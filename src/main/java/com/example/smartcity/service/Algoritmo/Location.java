package com.example.smartcity.service.Algoritmo;

import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.model.DAO.ParkingDao;

import java.util.*;

/**
 * Classe Location
 * Utilizzata per istanziare oggetti all'interno della griglia come gli
 * oggetti Blocco attraverso i quali il percorso non può passare, gli oggetti
 * Parcheggio che sarebbero i nodi dove si trovano i parcheggi e le due liste start ed end
 * che contengono rispettivamente i nodi di partenza e di destinazione.
 */
public class Location {

    //lista dei nodi contenenti le partenze
    private List<Nodo> start = new ArrayList<>();

    //lista dei nodi contenenti le destinazioni
    private List<Nodo> end = new ArrayList<>();

    private List<Nodo> nodopark = new ArrayList<>();


    /**
     * Metodo costruttore che setta i nodi di partenza e i nodi di destinazione
     * all'interno della griglia di nodi
     */
    public Location(){
        setStart();
        setEnd();
    }


    /**
     * Metodo che inizializza i nodi di partenza
     */
    void setStart(){

        Nodo nodo1 = new Nodo(2,1);
        nodo1.setIndirizzo("San Giorgio");

        Nodo nodo2 = new Nodo(1,1);
        nodo2.setIndirizzo("Portici");

        Nodo nodo3 = new Nodo(0,1);
        nodo3.setIndirizzo("Pomigliano");

        //Aggiungo i nodi sopra definiti nella lista start
        this.start.add(nodo1);
        this.start.add(nodo2);
        this.start.add(nodo3);
    }


    /**
     * Metodo che inizializza i nodi di partenza
     */
    public void setEnd() {
        Nodo nodo1 = new Nodo(2,5);
        nodo1.setIndirizzo("Napoli");

        Nodo nodo2 = new Nodo(3,6);
        nodo2.setIndirizzo("Caserta");

        Nodo nodo3 = new Nodo(5,5);
        nodo3.setIndirizzo("Casoria");

        //Aggiungo i nodi sopra definiti nella lista end
        this.end.add(nodo1);
        this.end.add(nodo2);
        this.end.add(nodo3);
    }


    /**
     * Metodo che scorre la lista dei nodi appartenenti alla lista dei nodi start
     * e cerca quello contenente l'indirizzo dato in ingresso e lo restituisce
     *
     * @param indirizzo indirizzo del nodo
     * @return la posizione del nodo start
     */
    public Nodo chooseStart(String indirizzo){

        for (Nodo position : this.start) {
            if(indirizzo.equals(position.getIndirizzo())){
                return position;
            }
        }
        return null;
    }


    /**
     * Metodo che scorre la lista dei nodi appartenenti alla lista dei nodi end
     * e cerca quello contenente l'indirizzo dato in ingresso e lo restituisce
     *
     * @param indirizzo indirizzo del nodo
     * @return la posizione del nodo start
     */

    public Nodo chooseEnd(String indirizzo){

        for (Nodo position : this.end) {
            if(indirizzo.equals(position.getIndirizzo())){
                return position;
            }
        }
        return null;
    }


    /**
     * Metodo che setta i nodi in cui si trovano i parcheggi con le rispettive coordinate.
     * In questo modo si può tenere sempre traccia dei parcheggi nei nodi
     * e li inserisco in un array 2D usando lo stesso criterio dei blocchi
     *
     * @return matrice bidimensionale di parcheggi
     */
    public int[][] setParking(){

        //setto i parcheggi
        Nodo park1 = new Nodo(0,2);
        Nodo park2 = new Nodo(0,3);
        Nodo park3 = new Nodo(1,4);

        //Aggiungo parcheggi a una lista di nodi parcheggio
        nodopark.add(park1);
        nodopark.add(park2);
        nodopark.add(park3);

        //Matrice bidimensionale
        int[][] blocksParking = new int[][]{{park1.getRow(), park1.getCol()},
                {park2.getRow(), park2.getCol()},
                {park3.getRow(),park3.getCol()}};

        //Metodo che uso per associare a ogni nodo gli indirizzi dei parcheggi presenti nel database
        this.setParkIndirizzo();


        return blocksParking;
    }

    /*
        Mi ricavo i parcheggi presenti nel database e li salvo in un'array di stringhe
        gli elemento dell'array conterrà quindi l'indirizzo di ciascun parcheggio del database
        per ogni nodo salvato nella lista dei "nodi parcheggio" associo quindi un indirizzo salvbato precedentemente
        nell'array
    */

    /**
     * Metodo che ricava i parcheggi presenti nel database e li salva in un vettore di stringhe.
     */
    public void setParkIndirizzo(){

        int i = 0;
        int j = 0;

        List<ParkingBean> parkingBeanList = ParkingDao.getListParking();
        String[] IndirizziP = new String[parkingBeanList.size() + 1];

        for (ParkingBean parkingBean: parkingBeanList) {
            IndirizziP[i] = parkingBean.getIndirizzo();
            i++;
        }

        for (Nodo nodo: nodopark) {
            nodo.setIndirizzo(IndirizziP[j]);
            j++;
        }
    }


    /**
     * Metodo che ritorna i parcheggi associati al nodo trovato
     *
     * @param nodo nodo di tipo Nodo che è stato trovato
     * @return parcheggi associati al nodo appena trovato
     */
    public ParkingBean getNodoParkIndirizzo(Nodo nodo){

        //per ogni nodo appartenente alla lista dei nodi parcheggi che ho istanziato controllo se è un nodo del percorso trovato
        for (Nodo nodop:nodopark) {

            if(nodo.equals(nodop)) {

                //se la condizione è vera allora cerco i parcheggi associati a quel nodo
                return getParcheggiDisp(nodop);
            }
        }
        return null;
    }

    /**
     *
     * @param nodoP
     * @return
     */
    protected ParkingBean getParcheggiDisp(Nodo nodoP){
        List<ParkingBean> parkingBeanList = ParkingDao.getListParking();

        //per ogni parcheggio controllo che ci sia un nodo il cui indirizzo è uguale, in quel caso significa che ho trovato
        //un nodo parcheggio e lo metto in una lista
        for (ParkingBean parkingBean: parkingBeanList) {
            if(parkingBean.getIndirizzo().equals(nodoP.getIndirizzo())) {
                return parkingBean;
            }

        }
        return null;
    }

    /**
     * Metodo che restituisce lista dei nodi di partenza
     * @return lista dei nodi di partenza
     */
    public List<Nodo> getStart(){ return start;}

    /**
     * Metodo che restituisce lista dei nodi di destinazione
     * @return lista dei nodi di destinazione
     */
    public List<Nodo> getEnd(){return end;}

    /**
     * Metodo che restituisce lista dei nodi parcheggio
     * @return lista dei nodi parcheggio
     */
    public List<Nodo> getNodopark(){
        return nodopark;
    }


}