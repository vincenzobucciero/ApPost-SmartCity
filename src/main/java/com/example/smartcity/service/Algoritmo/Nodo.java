package com.example.smartcity.service.Algoritmo;

/**
 * Classe Nodo
 * Utilizzata per definire e istanziare un singolo nodo all'interno
 * della matrice bidimensionale al fine di andare a trovare il percorso migliore
 * tramite l'utilizzo dell'algoritmo A*.
 */
public class Nodo {
    private int g, f, h , row, col;
    private boolean isBlock;
    private boolean isPark;
    private Nodo parent;

    private String indirizzo;

    /**
     * Metodo costruttore
     */
    public Nodo(){};

    /**
     * Metodo costruttore che definisce e inizializza tutti i parametri necessari
     *
     * @param row indice di riga
     * @param col indice di colonna
     */
    public Nodo(int row, int col) {
        super();
        this.row = row;
        this.col = col;
    }


    /**
     * Metodo che calcola l'euristica del nodo in base alla posizione del nodo finale specificato
     *
     * @param nodoFinale nodo finale da raggiungere
     */
    public void calcoloEuristica(Nodo nodoFinale){

        //Distanza di Manhattan - Utilizzata per calcolare l'euristica
        this.h = Math.abs(nodoFinale.getRow() - getRow()) + Math.abs(nodoFinale.getCol() - getCol());
    }


    /**
     * Metodo che calcola il costo finale del percorso utile a raggiungere
     * un nodo destinazione dato un nodo di partenza
     */
    public void calcoloCostoFinale(){
        int costoFinale = getG() + getH();
        setF(costoFinale);
    }


    /**
     * Metodo che imposta i dati del nodo (costo g, genitore, costo totale f)
     * in base al nodo corrente e al costo specificati.
     *
     * @param currentNodo nodo corrente
     * @param cost costo specificato
     */
    public void setNodoData(Nodo currentNodo, int cost){

        //Il costo g viene calcolato come la somma del costo g del nodo corrente e del costo specificato.
        int gCost = currentNodo.getG() + cost;

        //Setta il genitore del nodo corrente
        setParent(currentNodo);

        //Setta il costo g del nodo
        setG(gCost);

        //Calcolo costo finale
        calcoloCostoFinale();
    }


    /**
     * Metodo che verifica se il percorso corrente per raggiungere il nodo ha un costo inferiore
     * al percorso precedente per raggiungere lo stesso nodo.
     *
     * @param nodoCorrente nodo corrente
     * @param cost costo specificato
     * @return true or false
     */
    public boolean checkBetterPath(Nodo nodoCorrente, int cost){

        int gCost = nodoCorrente.getG() + cost;

        if (gCost < getG()){

            //Se si verifica la condizione, imposta i dati del nodo con i valori del nodo corrente e del costo specificato.
            setNodoData(nodoCorrente, cost);
            return true;
        }
        return false;
    }

    /**
     * Metodo che confronta l’oggetto su cui viene richiamato con l’oggetto passato
     * come parametro e restituisce un valore booleano.
     *
     * @param arg0 oggetto che deve essere confrontato
     * @return true or false
     */
    @Override
    public boolean equals(Object arg0){
        Nodo other = (Nodo) arg0;
        return this.getRow() == other.getRow() && this.getCol() == other.getCol();

    }

    /**
     * Metodo che converte un oggetto in stringa
     *
     * @return stringa in output
     */
    @Override
    public String toString() {
        return "Nodo [row=" + row + ", col=" + col + "]";
    }

    /**
     * Metodo che setta la funzione g(n)
     *
     * @param g costo necessario per raggiungere il nodo n dal nodo scelto come partenza
     */
    public void setG(int g) {
        this.g = g;
    }

    /**
     * Metodo che restituisce costo necessario per raggiungere il nodo n dal nodo scelto come partenza
     *
     * @return costo necessario per raggiungere il nodo n dal nodo scelto come partenza
     */
    public int getG() {
        return g;
    }

    /**
     * Metodo che restituisce una stima del costo associato al percorso che congiunge il nodo
     * di partenza e il nodo di destinazione passando per il nodo n
     *
     * @return stima del costo associato al percorso che congiunge il nodo di partenza e il nodo di destinazione passando per il nodo n
     */
    public int getF() {
        return f;
    }

    /**
     * Metodo che setta una stima del costo associato al percorso che congiunge il nodo
     * di partenza e il nodo di destinazione passando per il nodo n
     *
     * @param f stima del costo associato al percorso che congiunge il nodo di partenza e il nodo di destinazione passando per il nodo n
     */
    public void setF(int f) {
        this.f = f;
    }

    /**
     * Metodo che ritorna la funzione euristica h(n), funzione che fornisce una "stima ottimistica"
     * della distanza che separa il nodo n dall'arrivo
     *
     * @return stima ottimistica
     */
    public int getH() {
        return h;
    }

    /**
     * Metodo che setta la funzione euristica h(n), funzione che fornisce una "stima ottimistica"
     * della distanza che separa il nodo n dall'arrivo
     *
     * @param h stima ottimistica
     */
    public void setH(int h) {
        this.h = h;
    }

    /**
     * Metodo che ritorna l 'indice di riga
     *
     * @return indice di riga
     */
    public int getRow() {
        return row;
    }

    /**
     * Metodo che setta l'indice di riga
     *
     * @param row indice di riga
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Metodo che ritorna l 'indice di colonna
     *
     * @return indice di colonna
     */
    public int getCol() {
        return col;
    }

    /**
     * Metodo che setta l 'indice di colonna
     *
     * @param col indice di colonna
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * Metodo che restituisce se il nodo considerato è un blocco nella griglia o meno
     *
     * @return true or false
     */
    public boolean isBlock() {
        return isBlock;
    }

    /**
     * Metodo che restituisce se il nodo considerato è un parcheggio nella griglia o meno
     *
     * @return true or false
     */
    public boolean isPark() {
        return isPark;
    }

    /**
     * Metodo che setta blocchi nella griglia
     *
     * @param block blocco nella griglia
     */
    public void setBlock(boolean block) {
        isBlock = block;
    }

    /**
     * Metodo che setta un parcheggio
     *
     * @param park parcheggio nella griglia
     */
    public void setPark(boolean park) {
        isPark = park;
    }


    /**
     * Metodo che ritorna il padre del nodo che si sta considerando
     *
     * @return padre del nodo che si sta considerando
     */
    public Nodo getParent() {
        return parent;
    }

    /**
     * Metodo che setta il padre del nodo che si sta considerando
     *
     * @param parent padre del nodo che si sta considerando
     */
    public void setParent(Nodo parent) {
        this.parent = parent;
    }


    /**
     * Metodo che ritorna l'indirizzo
     *
     * @return indirizzo
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * Metodo che setta l'indirizzo
     *
     * @param indirizzo indirizzo del nodo
     */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }


}