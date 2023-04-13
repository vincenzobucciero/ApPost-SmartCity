package com.example.smartcity.service.Algoritmo;

import java.util.*;


/**
 * Classe A*
 * Implementazione dell'algoritmo A* (A Star).
 * E' un algoritmo di ricerca che individua un percorso da un dato nodo iniziale verso un dato nodo goal
 * (o che passi un test di goal dato). Utilizza una "stima euristica" che classifica ogni nodo
 * attraverso una stima della strada migliore che passa attraverso tale nodo.
 * Visita il nodo in base a tale stima euristica.
 * Nel nostro caso, l'algoritmo di ricerca è basato su matrice bidimensionale.
 * AStar è stato utilizzato per andare a ricercare il percorso più veloce che porta da una zona di partenza
 * al parcheggio piu vicino alla destinazione selezionata dall'utente in fase di prenotazione.
 */
public class AStar {

    //Costo Orizzontale e Verticale
    private static final int DEFAULT_HV_COST = 10;

    //Costo Diagionale
    private static final int DEFAULT_DIAGONAL_COST = 14;

    private int HVCosto;
    private int costoDiagonale;

    //Definisco la griglia rettangolare di nodi in cui viene effettuata la ricerca.
    private Nodo[][] searchArea;

    //(FIFO) Una PriorityQueue di nodi aperti/openset che vengono ancora valutati dalla ricerca
    private PriorityQueue<Nodo> openList;

    //Un Set di nodi che sono stati già valutati dalla ricerca e che non sarnno più prelevati
    //tipo di dato Insieme che non ammette duplicati e non definisce un ordinamento
    //per i suoi elementi.
    private Set<Nodo> closedSet;

    private Nodo nodoIniziale;

    private Nodo nodoFinale;


    /**
     * Metodo Costruttore AStar, inizializza tutti i parametri necessari
     *
     * @param rows numero di righe della matrice bidimensionale costruita
     * @param cols numero di colonne della matrice bidimensionale costruita
     * @param nodoIniziale nodo start da cui far partire la ricerca del percorso
     * @param nodoFinale nodo destinazione al quale deve arrivare la ricerca del percorso
     * @param HVCosto definizione del costo orizzontale e verticale
     * @param costoDiagonale definizione del costo diagonale
     */
    public AStar(int rows, int cols,  Nodo nodoIniziale, Nodo nodoFinale ,int HVCosto, int costoDiagonale) {
        this.HVCosto = HVCosto;
        this.costoDiagonale = costoDiagonale;
        setNodoIniziale(nodoIniziale);
        setNodoFinale(nodoFinale);
        this.searchArea = new Nodo[rows][cols];
        this.openList = new PriorityQueue<Nodo>(new Comparator<Nodo>() {

            /**
             * Metodo per confrontare due oggetti
             *
             * @param nodo0 primo oggetto per il confronto
             * @param nodo1 secondo oggetto per il confronto
             * @return un valore minore, uguale o maggiore di zero per indicare se il primo oggetto è minore, uguale o maggiore del secondo.
             */
            @Override
            public int compare(Nodo nodo0, Nodo nodo1) {
                return Integer.compare(nodo0.getF(),nodo1.getF());
            }
        });
        setNodi();
        this.closedSet = new HashSet<>();
    }


    /**
     * Metodo costruttore AStar, utilizza i valori predefiniti per i costi orizzontali/verticali e diagonali.
     *
     * @param rows numero di righe della matrice bidimensionale costruita
     * @param cols numero di colonne della matrice bidimensionale costruita
     * @param nodoIniziale nodo start da cui far partire la ricerca del percorso
     * @param nodoFinale nodo destinazione al quale deve arrivare la ricerca del percorso
     */
    public AStar(int rows, int cols, Nodo nodoIniziale, Nodo nodoFinale) {
        this(rows, cols, nodoIniziale, nodoFinale, DEFAULT_HV_COST, DEFAULT_DIAGONAL_COST);
    }


    /**
     * Metodo che crea e imposta la matrice di nodi searchArea.
     * Questa matrice rappresenta la griglia rettangolare di nodi in cui viene
     * effettuata la ricerca. All'interno del metodo viene creato un nodo per ogni elemento della
     * matrice searchArea e il cui valore è l'euristica calcolata in base
     * al nodo finale.
     */
    private void setNodi() {
        for (int i = 0; i < searchArea.length; i++){
            for (int j = 0; j < searchArea[0].length; j++){
                Nodo nodo = new Nodo(i,j);
                nodo.calcoloEuristica(getNodoFinale());
                this.searchArea[i][j] = nodo;
            }
        }

    }


    /**
     * Metodo che imposta i nodi bloccati nella griglia di ricerca. (Quindi gli ostacoli).
     * Questi sono i nodi attraverso i quali il percorso non può passare.
     *
     * @param blocksArray matrice di coordinate (row e col, che rappresentano i nodi bloccati nella griglia)
     */
    public void setBlocchi(int[][] blocksArray){
        for (int i = 0; i < blocksArray.length; i++){
            int row = blocksArray[i][0];
            int col = blocksArray[i][1];
            setBlock(row,col);
        }
    }


    /**
     * Metodo che imposta i parcheggi nella griglia di ricerca.
     *
     * @param blocksParking matrice di coordinate (row e col, che rappresentano i nodi parcheggio nella griglia)
     */
    public void setParking(int[][] blocksParking){
        for(int i = 0; i < blocksParking.length; i++){
            int row = blocksParking[i][0];
            int col = blocksParking[i][1];
            setPark(row, col);
        }
    }


    /**
     * Metodo che viene utilizzato dall'algoritmo A* per la ricerca del percorso.
     *
     * @return la lista dei nodi attraverso il quale il percorso deve passare per arrivare da un nodo
     * partenza a un nodo destinazione
     */
    public List<Nodo> ricercaPercorso() {

        //Aggiungo nodo iniziale all'openList
        openList.add(nodoIniziale);

        //Cicla fin quando la openList non è vuota
        while (!isEmpty(openList)) {

            //Viene estratto il nodo con la stima f più bassa tramite il metodo poll
            Nodo nodoCorrente = openList.poll();

            //Viene aggiunto alla closedList il nodo appena estratto
            closedSet.add(nodoCorrente);

            //Se il nodo estratto è quello finale allora viene restituito il percorso
            if (isFinalNode(nodoCorrente)) {
                return getPercorso(nodoCorrente);
            }  else {
                //Altrimenti, vengono aggiunti i nodi adiacenti al nodo estratto all'elenco aperto.
                addNodiAdiacente(nodoCorrente);
            }
        }
        return new ArrayList<Nodo>();
    }



    /**
     * Metodo che restituisce il percorso dal nodo finale al nodo iniziale.
     *
     * @param nodoCorrente nodo corrente che l'algoritmo sta visitando
     * @return percorso dal nodo finale al nodo iniziale
     */
    private List<Nodo> getPercorso(Nodo nodoCorrente){

        List<Nodo> percorso = new ArrayList<Nodo>();

        //Aggiungo il nodo corrente alla lista del percorso
        percorso.add(nodoCorrente);
        Nodo parent;

        //Ciclo fin quando il padre di un nodo corrente non è null
        while ((parent = nodoCorrente.getParent()) != null){

            //Aggiungo il padre al nodo corrente
            percorso.add(0,parent);

            //Imposto il padre appena aggiunto come nodo corrente
            nodoCorrente = parent;
        }
        return percorso;
    }


    /**
     * Metodo che viene chiamato per impostare le adiacenze del nodo corrente
     *
     * @param nodoCorrente nodo che si sta visitando
     */
    private void addNodiAdiacente(Nodo nodoCorrente){

        addAdjacentUpperRow(nodoCorrente);

        addAdjacentMiddleRow(nodoCorrente);

        addAdjacentLowerRow(nodoCorrente);
    }


    /**
     * Metodo che controlla che nodi presenti nella diagonale in alto a sx e dx (primi due if) e
     * il nodo in testa (ultimo check) della griglia abbiano una stima migliore rispetto al nodo corrente.
     *
     * @param nodoCorrente nodo che si sta visitando
     */
    private void addAdjacentUpperRow(Nodo nodoCorrente) {

        int row = nodoCorrente.getRow();
        int col = nodoCorrente.getCol();

        int upperRow = row - 1;

        if (upperRow >= 0) {

            if (col - 1 >= 0) {

                //checkNodo() controlla quale sia il costo migliore tra il nodo adiacente
                //(le cui coordinate sono passate in ingresso, con i costi lungo le diagonali o
                //le rette verticali e orizzontali) e il nodo corrente e decide se inserirlo nell'openSet.
                checkNodo(nodoCorrente, col - 1, upperRow, getCostoDiagonale());
            }
            if (col + 1 < getSearchArea()[0].length) {

                //checkNodo() controlla quale sia il costo migliore tra il nodo adiacente
                //(le cui coordinate sono passate in ingresso, con i costi lungo le diagonali o
                //le rette verticali e orizzontali) e il nodo corrente e decide se inserirlo nell'openSet.
                checkNodo(nodoCorrente, col + 1, upperRow, getCostoDiagonale());
            }

            checkNodo(nodoCorrente, col, upperRow, getHVCosto());
        }
    }


    /**
     * Metodo che controlla che nodi presenti alla sua destra e alla sua sinistra (primi due if) e
     * il nodo in testa (ultimo check) della griglia abbiano una stima migliore rispetto al nodo corrente.
     *
     * @param nodoCorrente nodo che si sta visitando
     */
    private void addAdjacentMiddleRow(Nodo nodoCorrente) {

        int row = nodoCorrente.getRow();
        int col = nodoCorrente.getCol();

        int middleRow = row;

        if (col - 1 >= 0) {
            checkNodo(nodoCorrente, col - 1, middleRow, getHVCosto());
        }
        if (col + 1 < getSearchArea()[0].length) {
            checkNodo(nodoCorrente, col + 1, middleRow, getHVCosto());
        }
    }



    /**
     * Metodo che Controlla che nodi presenti nella diagonale in basso a sx e dx (primi due if) e
     * il nodo immediatamente sotto della griglia, abbiano una stima migliore rispetto al nodo corrente.
     *
     * @param nodoCorrente nodo che si sta visitando
     */
    private void addAdjacentLowerRow(Nodo nodoCorrente) {

        int row = nodoCorrente.getRow();
        int col = nodoCorrente.getCol();

        int rigaLow = row + 1;

        if (rigaLow < getSearchArea().length){

            if (col - 1  >= 0){
                checkNodo(nodoCorrente, col - 1, rigaLow, getCostoDiagonale());
            }
            if (col + 1 < getSearchArea()[0].length) {
                checkNodo(nodoCorrente, col + 1, rigaLow, getCostoDiagonale());
            }

            checkNodo(nodoCorrente, col, rigaLow, getHVCosto());
        }
    }


    /*
        checkNodo():
         è una funzione che prende in input un nodo corrente e delle coordinate per calcolare un suo nodo adicante
         e controlla se questo soddisfa determinati criteri.
         1. se il nodo adiacente non è un blocco e il closedSet non contiene già questo nodo
         2. se il nodo adiacente non è stato ancora inserito nell'open list
          Allora setta il nodo e inseriscilo nell'openList

         Se questi controlli non sono verificati si controlla che il nodo adiacente abbia una stima migliore
         rispetto il nodo corrente. Se è vero Rimuovi e aggiungi il nodo modificato,
         in modo che PriorityQueue possa ordinare nuovamente il suo contenuto con il valore "finalCost"
         modificato del nodo modificato

         Questi controlli sono importanti perché consentono di evitare cicli e di assicurarsi che la distanza
         calcolata per il nodo sia sempre quella minima rispetto al nodo di partenza.
     */


    /**
     * Metodo che calcola un nodo adiacente di un nodo corrente
     * e controlla se questo soddisfa determinati criteri.
     *
     * @param nodoCorrente nodo che si sta visitando
     * @param col indice di colonna
     * @param row indice di riga
     * @param cost costo del nodo
     */
    private void checkNodo(Nodo nodoCorrente, int col, int row, int cost) {

        Nodo adjacentNode = getSearchArea()[row][col];

        /*
            I controlli che vengono effettuati sono importanti perché consentono di evitare cicli
            e di assicurarsi che la distanza calcolata per il nodo sia sempre quella minima rispetto al nodo di partenza.
        */

        //Se il nodo adiacente non è un blocco && il closedSet non contiene già questo nodo
        if (!adjacentNode.isBlock() && !getClosedSet().contains(adjacentNode)) {

            //Se il nodo adiacente non è stato ancora inserito nell'open list
            if (!getOpenList().contains(adjacentNode)) {

                //Setto il nodo
                adjacentNode.setNodoData(nodoCorrente, cost);

                //Lo Aggiungo alla openList
                getOpenList().add(adjacentNode);

            } else {

                boolean changed = adjacentNode.checkBetterPath(nodoCorrente, cost);

                //Altrimenti, si controlla che il nodo adiacente abbia una stima migliore
                //rispetto il nodo corrente
                if (changed) {

                    //Rimuovi e aggiungi il nodo modificato
                    getOpenList().remove(adjacentNode);
                    getOpenList().add(adjacentNode);
                }
            }
        }

    }


    /**
     * Metodo che setta un blocco nella matrice bidimensionale searchArea
     *
     * @param row indice di riga
     * @param col indice di colonna
     */
    private void setBlock(int row, int col) {
        this.searchArea[row][col].setBlock(true);
    }

    /**
     * Metodo che setta un parcheggio nella matrice bidimensionale searchArea
     *
     * @param row indice di riga
     * @param col indice di colonna
     */
    private void setPark(int row, int col) {
        this.searchArea[row][col].setPark(true);
    }

    /**
     * Metodo booleano che identica se il nodo corrente è il nodo di destinazione
     *
     * @param currentNode nodo che si sta visitando
     * @return true or false
     */
    private boolean isFinalNode(Nodo currentNode) {
        return currentNode.equals(nodoFinale);
    }

    /**
     * Metodo che controlla se la openList è vuota, quindi se restano ancora nodi da visitare
     *
     * @param openList lista dei nodi già visitati fino al momento corrente
     * @return true or false
     */
    private boolean isEmpty(PriorityQueue<Nodo> openList) {
        return openList.size() == 0;
    }


    /**
     * Metodo che restituisce il costo orizzontale/verticale di un nodo
     *
     * @return costo orizzontale/verticale di un nodo
     */
    public int getHVCosto() {
        return HVCosto;
    }

    /**
     * Metodo che setta il costo orizzontale/verticale di un nodo
     *
     * @param HVCosto costo orizzontale/verticale di un nodo
     */
    public void setHVCosto(int HVCosto) {
        this.HVCosto = HVCosto;
    }

    /**
     * Metodo che restituisce il costo diagonale di un nodo
     *
     * @return costo diagonale di un nodo
     */
    public int getCostoDiagonale() {
        return costoDiagonale;
    }

    /**
     * Metodo che setta il costo diagonale di un nodo
     *
     * @param costoDiagonale costo diagonale di un nodo
     */
    public void setCostoDiagonale(int costoDiagonale) {
        this.costoDiagonale = costoDiagonale;
    }

    /**
     * Metodo che restituisce la matrice bidimensionale di nodi nella quale andare a ricercare il percorso
     *
     * @return matrice bidimensionale
     */
    public Nodo[][] getSearchArea() {
        return searchArea;
    }

    /**
     * Metodo che setta la matrice bidimensionale nella quale andare a ricercare il percorso
     *
     * @param searchArea matrice bidimensionale di nodi
     */
    public void setSearchArea(Nodo[][] searchArea) {
        this.searchArea = searchArea;
    }

    /**
     * Metodo che restituisce la lista openList, cioè la lista dei nodi già visitati fino al momento corrente
     *
     * @return lista dei nodi già visitati fino al momento corrente
     */
    public PriorityQueue<Nodo> getOpenList() {
        return openList;
    }

    /**
     * Metodo che setta la lista openList, cioè la lista dei nodi già visitati fino al momento corrente
     *
     * @param openList lista dei nodi già visitati fino al momento corrente
     */
    public void setOpenList(PriorityQueue<Nodo> openList) {
        this.openList = openList;
    }

    /**
     * Metodo che restituisce la lista closedList, cioè la lista dei nodi già visitati fino a quel momento
     * e che per i quali non bisogna più passare
     *
     * @return closedList, lista dei nodi già visitati fino al momento corrente e che per i quali non bisogna più passare
     */
    public Set<Nodo> getClosedSet() {
        return closedSet;
    }

    /**
     * Metodo che setta la lista openList, cioè la lista dei nodi già visitati fino al momento corrente
     *
     * @param closedSet lista dei nodi già visitati fino al momento corrente
     */
    public void setClosedSet(Set<Nodo> closedSet) {
        this.closedSet = closedSet;
    }

    /**
     * Metodo che restituisce il nodo iniziale della matrice bidimensionale di nodi
     * @return nodo iniziale della matrice bidimensionale
     */
    public Nodo getNodoIniziale() {
        return nodoIniziale;
    }

    /**
     * Metodo che setta il nodo iniziale della matrice bidimensionale di nodi
     *
     * @param nodoIniziale nodo iniziale della matrice bidimensionale
     */
    public void setNodoIniziale(Nodo nodoIniziale) {
        this.nodoIniziale = nodoIniziale;
    }

    /**
     * Metodo che restituisce il nodo finale o destinazione della matrice bidimensionale di nodi
     * @return nodo finale o destinazione della matrice bidimensionale
     */
    public Nodo getNodoFinale() {
        return nodoFinale;
    }


    /**
     * Metodo che setta il nodo finale o destinazione della matrice bidimensionale di nodi
     * @param nodoFinale nodo finale o destinazione della matrice bidimensionale
     */
    public void setNodoFinale(Nodo nodoFinale) {
        this.nodoFinale = nodoFinale;
    }

}