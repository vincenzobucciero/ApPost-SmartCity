package com.example.smartcity.service.Algoritmo;


import java.util.*;

public class AStar {

    private static int DEFAULT_HV_COST = 10; // Costo Orizzontale e Verticale
    private static int DEFAULT_DIAGONAL_COST = 14; //Costo Diagionale

    private int HVCosto;
    private int costoDiagonale;

    private Nodo[][] searchArea; //Rappresenta la griglia rettangolare di nodi in cui viene effettuata la ricerca.
    private PriorityQueue<Nodo> openList; //(FIFO) Una PriorityQueue di nodi aperti/openset che vengono ancora valutati dalla ricerca
    private Set<Nodo> closedSet; //Un Set di nodi che sono stati già valutati dalla ricerca e che non sarnno più prelevati
    //tipo di dato Insieme che non ammette duplicati e non definisce un ordinamento
    //per i suoi elementi.
    private Nodo nodoIniziale;
    private Nodo nodoFinale;

    //private Nodo nodoParcheggio;

    /*
        Il codice fornisce due costruttori per la classe AStar:
         1.Uno che accetta tutti i parametri necessari,
         2.Uno che utilizza i valori predefiniti per i costi orizzontali/verticali e diagonali.
    */

    //Primo Costruttore:
    public AStar(int rows, int cols,  Nodo nodoIniziale, Nodo nodoFinale ,int HVCosto, int costoDiagonale) {
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

    //Secondo Costruttore chiama il primo costruttore
    public AStar(int rows, int cols, Nodo nodoIniziale, Nodo nodoFinale) {
        this(rows, cols, nodoIniziale, nodoFinale, DEFAULT_HV_COST, DEFAULT_DIAGONAL_COST);
    }

    /*  SetNodi():
         Viene utilizzato per creare e impostare la matrice di nodi searchArea.
         Questa matrice rappresenta la griglia rettangolare di nodi in cui viene
         effettuata la ricerca.
         All'interno del metodo viene creato un nodo per ogni elemento della
         matrice searchArea e il cui valore è  l'euristica calcolata in base
         al nodo finale.
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

    /*  setBlocchi():
        Viene utilizzato per impostare i nodi bloccati nella griglia di ricerca. (Quindi gli ostacoli).
        Prende in input una matrice di coordinate (riga, colonna) che rappresentano i nodi bloccati
        nella griglia. In altre parole, questi sono i nodi attraverso i quali il percorso non può passare.
     */
    public void setBlocchi(int[][] blocksArray){
        for (int i = 0; i < blocksArray.length; i++){
            int row = blocksArray[i][0];
            int col = blocksArray[i][1];
            setBlock(row,col);
        }
    }


    public void setParking(int[][] blocksParking){
        for(int i = 0; i < blocksParking.length; i++){
            int row = blocksParking[i][0];
            int col = blocksParking[i][1];
            setPark(row, col);
        }
    }

    /*
        ricercaPercorso():
        Viene utilizzato per eseguire l'algoritmo di ricerca del percorso A*.
        Inizia con l'aggiunta del nodo iniziale all'openList.
        Successivamente, viene eseguito un ciclo finché openList non è vuoto.
        Durante il ciclo, viene estratto il nodo con il punteggio f(stima) più basso
        dall'opne set mediante il metoso poll e viene aggiunto all'elenco chiuso (closedSet).
        Se il nodo estratto è il nodo finale, il percorso viene restituito
        chiamando il metodo getPath.
        Altrimenti, vengono aggiunti i nodi adiacenti al nodo estratto all'elenco aperto.

        N.B Il metodo poll() recupera il valore del primo elemento della coda rimuovendolo dalla coda stessa.
        Ad ogni invocazione rimuove il primo elemento della lista e se la lista è già vuota ritorna
        null ma non scatena nessuna eccezione
     */
    public List<Nodo> ricercaPercorso() {
        openList.add(nodoIniziale);
        while (!isEmpty(openList)) {
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

    /*
        getPercorso():
        Restituisce il percorso dal nodo finale al nodo iniziale.
        Inizia aggiungendo il nodo corrente alla lista del percorso (che sarà duqneu il nodo finale trovato)
        e successivamente aggiungendo il padre (parent) del nodo corrente, e così via
        fino a raggiungere il padre del nodo iniziale.
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

    private void addNodiAdiacente(Nodo nodoCorrente){
        addAdjacentUpperRow(nodoCorrente);
        addAdjacentMiddleRow(nodoCorrente);
        addAdjacentLowerRow(nodoCorrente);
    }


    /*
        addAdjacentUpperRow():
        Controlla che nodi presenti nella diagonale in alto a sx e dx (primi due if) e il nodo in tesa (ultimo check)
        della griglia, rispetto al nodo corrente, abbiano una stima migliore rispetto al nodo corrente.
        Ll metodo check nodo controlla quale sia il costo migliore tra il nodo adiacente (le cui coordinate sono passate
        in input, con i costi lungo le diagonali o le rette verticali e orizzontali)
        e il nodo corrente e decide se inserirlo nell'open set.

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

    /*
        addAdjacentMiddleRow():
        Allo stesso modo ma controlla i nodi alla sua destra e sinistra
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



    /*
        addAdjacentLowerRow():
        ancora lo stesso criterio ma considera i nodi nella diagonale in basso a dx e sx e il nodo immediatamente sotto
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
         calcolata per il nodon sia sempre quella minima rispetto al nodo di partenza.
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


   /* public Nodo getNodoParcheggio() {
        return nodoParcheggio;
    }

    public void setNodoParcheggio(Nodo nodoParcheggio) {
        this.nodoParcheggio = nodoParcheggio;
    }*/
}