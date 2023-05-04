package com.example.smartcity.service.Algoritmo;

import java.util.*;


/**
 * L’algoritmo A* è un algoritmo di ricerca su grafi o mappe che individua un
 * percorso da un dato nodo iniziale verso un dato nodo obiettivo, utilizzando una
 * stima euristica che classifica ogni nodo attraverso una stima del percorso migliore che passa 
 * attraverso tale nodo. L’algoritmo A* è un esempio di ricerca best-first.
 * L'algoritmo è stato utilizzato al fine di calcolare il percorso più breve dati due input, 
 * punto di partenza e punto di arrivo, e sono stati restituiti tutti i parcheggi in tale percorso, se presenti.
 */
public class AStar {

    private static int DEFAULT_HV_COST = 10; // Costo Orizzontale e Verticale
    private static int DEFAULT_DIAGONAL_COST = 14; //Costo Diagionale

    private int HVCosto;
    private int costoDiagonale;

    private Nodo[][] searchArea; //Rappresenta la griglia rettangolare di nodi in cui viene effettuata la ricerca.
    private PriorityQueue<Nodo> openList; //(FIFO) Una PriorityQueue di nodi aperti/openset che vengono ancora valutati dalla ricerca
    private Set<Nodo> closedSet; //Un Set di nodi che sono stati già valutati dalla ricerca e che non sarnno più prelevati
    //Set: tipo di dato Insieme che non ammette duplicati e non definisce un ordinamento per i suoi elementi.
    private Nodo nodoIniziale;
    private Nodo nodoFinale;
    
    
    /** 
     * Primo metodo costruttore per la classe A*.
     * Fornisce e imposta tutti i parametri necessari.
     *
     * @param rows numero di righe della matrice
     * @param cols numero di colonne della matrice
     * @param nodoIniziale nodo iniziale dal quale si ricerca il percorso
     * @param nodoFinale nodo destinazione al quale si deve arrivare
     * @param HVCosto costo orizzontale/verticale
     * @param costoDiagonale costo diagonale
     */
    public AStar(int rows, int cols,  Nodo nodoIniziale, Nodo nodoFinale, int HVCosto, int costoDiagonale) {
        this.HVCosto = HVCosto;
        this.costoDiagonale = costoDiagonale;
        setNodoIniziale(nodoIniziale);
        setNodoFinale(nodoFinale);
        this.searchArea = new Nodo[rows][cols];
        this.openList = new PriorityQueue<Nodo>(new Comparator<Nodo>() {
            @Override
            public int compare(Nodo nodo0, Nodo nodo1) {
                return Integer.compare(nodo0.getF(),nodo1.getF());
            }
        });
        setNodi();
        this.closedSet = new HashSet<>();
    }

    
    /** 
     * Secondo metodo costruttore per la classe A*.
     * Viene richiamato il primo costruttore e vengono utilizzati i valori predefiniti per i costi orizzontali/verticali e diagonali.
     *
     * @param rows numero di righe della matrice
     * @param cols numero di colonne della matrice
     * @param nodoIniziale nodo iniziale dal quale si ricerca il percorso
     * @param nodoFinale nodo destinazione al quale si deve arrivare
     */
    public AStar(int rows, int cols, Nodo nodoIniziale, Nodo nodoFinale) {
        this(rows, cols, nodoIniziale, nodoFinale, DEFAULT_HV_COST, DEFAULT_DIAGONAL_COST);
    }

    
    /** 
     * Metodo privato che viene utilizzato per creare e impostare una matrice di nodi searchArea.
     * Questa matrice rappresenta la griglia rettangolare di nodi in cui viene
     * effettuata la ricerca. All'interno del metodo viene creato un nodo per ogni elemento della
     * matrice searchArea e il cui valore è  l'euristica calcolata in base al nodo finale.
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
     * Metodo che viene utilizzato per impostare i nodi "blocchi" nella griglia di ricerca (quindi gli ostacoli).
     * Prende in input una matrice di coordinate (riga, colonna) che rappresentano i blocchi nella griglia. 
     */
    public void setBlocchi(int[][] blocksArray){
        for (int i = 0; i < blocksArray.length; i++){
            int row = blocksArray[i][0];
            int col = blocksArray[i][1];
            setBlock(row,col);
        }
    }


    
    /**
     * Metodo che viene utilizzato per impostare i nodi parcheggio nella griglia di ricerca.
     * Prende in input una matrice di coordinate (riga, colonna) che rappresentano i nodi parcheggio nella griglia.
     */
    public void setParking(int[][] blocksParking){
        for(int i = 0; i < blocksParking.length; i++){
            int row = blocksParking[i][0];
            int col = blocksParking[i][1];
            setPark(row, col);
        }
    }

    
    
    /** 
     * Metodo pubblico che viene utilizzato per eseguire l'algoritmo di ricerca del percorso A*.
     * Viene eseguito un ciclo finché openList non è vuoto. 
     * Durante il ciclo, viene estratto il nodo con il punteggio f (stima) più basso dall’openset
     * mediante il metodo poll e viene aggiunto all’elenco chiuso (closedSet).
     * Se il nodo estratto è il nodo finale, il percorso viene restituito chiamando il metodo getPath.
     * Altrimenti, vengono aggiunti i nodi adiacenti al nodo estratto all’elenco aperto.
     *
     * @see getPath
     * @return ArrayList<Nodo> la lista dei nodi che formano il percorso trovato dall'algoritmo 
     */ 
    public List<Nodo> ricercaPercorso() {
        openList.add(nodoIniziale);
        while (!isEmpty(openList)) {
            /*
                Il metodo poll() recupera il valore del primo elemento della coda rimuovendolo dalla coda stessa.
                Ad ogni invocazione rimuove il primo elemento della lista e se la lista è già vuota ritorna
                null ma non scatena nessuna eccezione
            */
            Nodo nodoCorrente = openList.poll();
            closedSet.add(nodoCorrente);
            if (isFinalNode(nodoCorrente)) {
                return getPercorso(nodoCorrente);
            }  else {
                addNodiAdiacente(nodoCorrente);
            }
        }
        return new ArrayList<Nodo>();
    }

    
    
    /**
     * Metodo privato che restituisce il percorso dal nodo finale al nodo iniziale.
     * Inizia aggiungendo il nodo corrente alla lista del percorso (che sarà dunque il nodo finale trovato)
     * e successivamente aggiungendo il padre (parent) del nodo corrente, e così via
     * fino a raggiungere il padre del nodo iniziale.
     *
     * @param nodoCorrente nodo corrente che si sta visitando
     * @return percorso una lista che rappresenta il percorso finale da un nodo finale al nodo iniziale
     */
    private List<Nodo> getPercorso(Nodo nodoCorrente){
        List<Nodo> percorso = new ArrayList<Nodo>();
        percorso.add(nodoCorrente);
        Nodo parent;
        while ((parent = nodoCorrente.getParent()) != null){
            percorso.add(0,parent);
            nodoCorrente = parent;
        }
        return percorso;
    }

    
    
    /**
     * Metodo privato che si occupa di calcolare le stime aggiornate grazie a tre metodi: 
     * addAdjacentUpperRow, addAdjacentMiddleRow, addAdjacentLowerRow
     *
     * @see addAdjacentUpperRow(Nodo nodoCorrente)
     * @see addAdjacentMiddleRow(Nodo nodoCorrente)
     * @see addAdjacentLowerRow(Nodo nodoCorrente)
     */
    private void addNodiAdiacente(Nodo nodoCorrente){
        addAdjacentUpperRow(nodoCorrente);
        addAdjacentMiddleRow(nodoCorrente);
        addAdjacentLowerRow(nodoCorrente);
    }


    
    /**
     * Metodo privato che controlla che i nodi presenti nella diagonale
     * in alto a sinistra e destra, e il nodo in testa alla griglia, rispetto al
     * nodo corrente, abbiano una stima migliore rispetto al nodo corrente.
     *
     * @param nodoCorrente nodo corrente che si sta visitando
     * @see checkNodo(Nodo nodoCorrente, int col, int row, int cost)
     */
    private void addAdjacentUpperRow(Nodo nodoCorrente) {
        int row = nodoCorrente.getRow();
        int col = nodoCorrente.getCol();
        int upperRow = row - 1;
        if (upperRow >= 0) {
            if (col - 1 >= 0) {
                checkNodo(nodoCorrente, col - 1, upperRow, getCostoDiagonale()); // Comment this if diagonal movements are not allowed
            }
            if (col + 1 < getSearchArea()[0].length) {
                checkNodo(nodoCorrente, col + 1, upperRow, getCostoDiagonale()); // Comment this if diagonal movements are not allowed
            }
            checkNodo(nodoCorrente, col, upperRow, getHVCosto());
        }
    }

    
    
    /**
     * Metodo che controlla che nodi presenti a sinistra e destra, rispetto al
     * nodo corrente, abbiano una stima migliore rispetto al nodo corrente.
     *
     * @param nodoCorrente nodo corrente che si sta visitando
     * @see checkNodo(Nodo nodoCorrente, int col, int row, int cost)
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
     * Metodo che Controlla che nodi presenti nella diagonale
     * in basso a sinistra e destra e il nodo immediatamente sotto, rispetto al
     * nodo corrente, abbiano una stima migliore rispetto al nodo corrente.
     *
     * @param nodoCorrente nodo corrente che si sta visitando
     * @see checkNodo(Nodo nodoCorrente, int col, int row, int cost)
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
                checkNodo(nodoCorrente, col + 1, rigaLow, getCostoDiagonale()); // Comment this line if diagonal movements are not allowed
            }
            checkNodo(nodoCorrente, col, rigaLow, getHVCosto());
        }
    }


    
    
    /**
     * Metodo che controlla quale sia il costo migliore tra il nodo
     * adiacente (le cui coordinate sono passate in input, con i costi lungo le
     * diagonali o le rette verticali e orizzontali) e il nodo corrente, e decide
     * se inserirlo nell’open set.
     *
     * @param nodoCorrente nodo corrente che si sta visitando
     * @param col indice di colonna
     * @param row indice di riga
     * @param cost costo del nodo corrente
     */

    private void checkNodo(Nodo nodoCorrente, int col, int row, int cost) {
        Nodo adjacentNode = getSearchArea()[row][col];
        if (!adjacentNode.isBlock() && !getClosedSet().contains(adjacentNode)) {
            if (!getOpenList().contains(adjacentNode)) {
                adjacentNode.setNodoData(nodoCorrente, cost);
                getOpenList().add(adjacentNode);
            } else {
                boolean changed = adjacentNode.checkBetterPath(nodoCorrente, cost);
                if (changed) {
                    getOpenList().remove(adjacentNode);
                    getOpenList().add(adjacentNode);
                }
            }
        }

    }



    //Metodi di Set& Get
    private void setBlock(int row, int col) {
        this.searchArea[row][col].setBlock(true);
    }

    private void setPark(int row, int col) {
        this.searchArea[row][col].setPark(true);
    }


    private boolean isFinalNode(Nodo currentNode) {
        return currentNode.equals(nodoFinale);
    }

    private boolean isEmpty(PriorityQueue<Nodo> openList) {
        return openList.size() == 0;
    }

    public int getHVCosto() {
        return HVCosto;
    }

    public void setHVCosto(int HVCosto) {
        this.HVCosto = HVCosto;
    }

    public int getCostoDiagonale() {
        return costoDiagonale;
    }

    public void setCostoDiagonale(int costoDiagonale) {
        this.costoDiagonale = costoDiagonale;
    }

    public Nodo[][] getSearchArea() {
        return searchArea;
    }

    public void setSearchArea(Nodo[][] searchArea) {
        this.searchArea = searchArea;
    }

    public PriorityQueue<Nodo> getOpenList() {
        return openList;
    }

    public void setOpenList(PriorityQueue<Nodo> openList) {
        this.openList = openList;
    }

    public Set<Nodo> getClosedSet() {
        return closedSet;
    }

    public void setClosedSet(Set<Nodo> closedSet) {
        this.closedSet = closedSet;
    }

    public Nodo getNodoIniziale() {
        return nodoIniziale;
    }

    public void setNodoIniziale(Nodo nodoIniziale) {
        this.nodoIniziale = nodoIniziale;
    }

    public Nodo getNodoFinale() {
        return nodoFinale;
    }

    public void setNodoFinale(Nodo nodoFinale) {
        this.nodoFinale = nodoFinale;
    }



}
