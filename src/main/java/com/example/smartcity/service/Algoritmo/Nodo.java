package com.example.smartcity.service.Algoritmo;

/**
 * Classe che rappresenta un nodo utilizzato nell'algoritmo di pathfinding.
 * Ogni nodo contiene informazioni sulla sua posizione nella griglia, i suoi costi g, f e h,
 * se è un blocco (inaccessibile) o un parcheggio, il suo parent e l'indirizzo associato (solo per i parcheggi).
*/
public class Nodo {
    private int g, f, h , row, col;
    private boolean isBlock;
    private boolean isPark;
    private Nodo parent;

    private String indirizzo;


    /** Costruttore vuoto. */
    public Nodo(){};


    /**
     * Costruttore che inizializza la posizione del nodo nella griglia.
     *
     * @param row riga della posizione del nodo nella griglia
     * @param col colonna della posizione del nodo nella griglia
     */
    public Nodo(int row, int col) {
        super();
        this.row = row;
        this.col = col;
    }


    /**
     * Calcola l'euristica del nodo in base alla posizione del nodo finale specificato.
     * L'euristica viene calcolata come la distanza di Manhattan tra la posizione corrente del nodo e la posizione finale.
     * @param nodoFinale il nodo finale a cui calcolare l'euristica
     */
    public void calcoloEuristica(Nodo nodoFinale){
        this.h = Math.abs(nodoFinale.getRow() - getRow()) + Math.abs(nodoFinale.getCol() - getCol());
    }


    /**
     * Calcola il costo totale f del nodo come la somma del costo g e del costo h.
     */
    public void calcoloCostoFinale(){
        int costoFinale = getG() + getH();
        setF(costoFinale);
    }


    /**
     * Imposta i dati del nodo (costo g, genitore, costo totale f) in base al nodo corrente e al costo specificato.
     * Il costo g viene calcolato come la somma del costo g del nodo corrente e del costo specificato.
     * Il genitore del nodo viene impostato come il nodo corrente.
     * Infine, il metodo chiama il metodo calcoloCostoFinale per calcolare il costo totale f.
     *
     * @param currentNodo il nodo corrente
     * @param cost il costo del percorso dal nodo corrente al nodo successivo
     */
    public void setNodoData(Nodo currentNodo, int cost){
        int gCost = currentNodo.getG() + cost;
        setParent(currentNodo);
        setG(gCost);
        calcoloCostoFinale();
    }


    /**
     * Verifica se il percorso corrente per raggiungere il nodo ha un costo inferiore al percorso
     * precedente per raggiungere lo stesso nodo. Se il costo corrente è inferiore al costo precedente,
     * i dati del nodo vengono aggiornati con i valori del nodo corrente e del costo specificato.
     *
     * @param nodoCorrente il nodo corrente da verificare
     * @param cost il costo per raggiungere il nodo corrente
     * @return true se il percorso corrente ha un costo inferiore al precedente, false altrimenti
     */
    public boolean checkBetterPath(Nodo nodoCorrente, int cost){
        int gCost = nodoCorrente.getG() + cost;

        if (gCost < getG()){
            setNodoData(nodoCorrente, cost);
            return true;
        }
        return false;
    }



    /**
     * Verifica se questo nodo è uguale a un altro nodo passato come parametro.
     *
     * @param arg0 l'oggetto da confrontare con questo nodo.
     * @return true se i nodi hanno la stessa riga e colonna, false altrimenti.
     */
    @Override
    public boolean equals(Object arg0){
        Nodo other = (Nodo) arg0;
        return this.getRow() == other.getRow() && this.getCol() == other.getCol();

    }


    /**
     * Restituisce una stringa rappresentante l'oggetto Nodo, contenente informazioni riguardanti
     * la sua posizione nella griglia.
     *
     * @return una stringa rappresentante l'oggetto Nodo, contenente informazioni riguardanti
     * la sua posizione nella griglia.
     */
    @Override
    public String toString() {
        return "Nodo [row=" + row + ", col=" + col + "]";
    }



    /**
     * Imposta il costo g del nodo con il valore specificato.
     * Il costo g rappresenta il costo effettivo del percorso dalla posizione di partenza fino al nodo corrente.
     *
     * @param g il valore del costo g da impostare per il nodo corrente
     */
    public void setG(int g) {
        this.g = g;
    }


    /**
     * Restituisce il costo g del nodo con il valore specificato.
     * Il costo g rappresenta il costo effettivo del percorso dalla posizione di partenza fino al nodo corrente.
     *
     * @return  g il valore del costo g da impostare per il nodo corrente
     */
    public int getG() {
        return g;
    }


    /**
     * Questo metodo restituisce il valore del costo totale f del nodo.
     * Il costo totale f del nodo rappresenta la somma del costo g del nodo
     * e del valore dell'euristica h del nodo. Il costo g del nodo rappresenta
     * il costo del percorso dal nodo iniziale al nodo corrente, mentre l'euristica h
     * rappresenta una stima del costo per raggiungere il nodo finale partendo dal nodo corrente.
     *
     * @return il valore del costo totale f del nodo.
     */
    public int getF() {
        return f;
    }

    /**
     * Questo metodo imposta il valore del costo totale f del nodo.
     *
     * @param f il valore del costo totale f del nodo.
     */
    public void setF(int f) {
        this.f = f;
    }


    /**
     * Restituisce il valore dell'euristica del nodo.
     *
     * @return valore dell'euristica.
     */
    public int getH() {
        return h;
    }


    /**
     * Imposta il valore dell'euristica del nodo.
     * @param h valore dell'euristica.
     */
    public void setH(int h) {
        this.h = h;
    }


    /**
     * Restituisce la posizione della riga del nodo nella griglia.
     *
     * @return posizione della riga del nodo nella griglia.
     */
    public int getRow() {
        return row;
    }


    /**
     * Imposta la posizione della riga del nodo nella griglia.
     *
     * @param row posizione della riga del nodo nella griglia da impostare.
     */
    public void setRow(int row) {
        this.row = row;
    }


    /**
     * Restituisce la posizione della colonna del nodo nella griglia.
     *
     * @return posizione della colonna del nodo nella griglia.
     */
    public int getCol() {
        return col;
    }


    /**
     * Imposta la posizione della colonna del nodo nella griglia.
     *
     * @param col posizione della colonna del nodo nella griglia da impostare.
     */
    public void setCol(int col) {
        this.col = col;
    }


    /**
     * Restituisce lo stato del blocco del nodo.
     *
     * @return true se il nodo è un blocco, false altrimenti.
     */
    public boolean isBlock() {
        return isBlock;
    }


    /**
     * Restituisce lo stato del parcheggio del nodo.
     *
     * @return true se il nodo è un parcheggio, false altrimenti.
     */
    public boolean isPark() {
        return isPark;
    }


    /**
     * Imposta lo stato del blocco del nodo.
     *
     * @param block true se il nodo è un blocco, false altrimenti.
     */
    public void setBlock(boolean block) {
        isBlock = block;
    }


    /**
     * Imposta il valore del flag isPark del nodo.
     *
     * @param park true se il nodo rappresenta un parcheggio, false altrimenti
     */
    public void setPark(boolean park) {
        isPark = park;
    }


    /**
     * Questo metodo restituisce il nodo genitore del nodo corrente.
     *
     * @return il nodo genitore del nodo corrente.
     */
    public Nodo getParent() {
        return parent;
    }


    /**
     * Questo metodo imposta il nodo genitore del nodo corrente.
     *
     * @param parent  il nodo genitore del nodo corrente.
     */
    public void setParent(Nodo parent) {
        this.parent = parent;
    }


    /**
     * Restituisce l'indirizzo associato a questo nodo.
     *
     * @return l'indirizzo associato a questo nodo.
     */
    public String getIndirizzo() {
        return indirizzo;
    }


    /**
     * Imposta l'indirizzo associato a questo nodo.
     *
     * @param indirizzo l'indirizzo associato a questo nodo.
     */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }


}