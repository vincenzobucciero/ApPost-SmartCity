package com.example.smartcity.service.Algoritmo;

import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.model.DAO.ParkingDao;

import java.util.*;
public class Location {

    private List<Nodo> start = new ArrayList<>();   //lista dei nodi contenenti le partenze
    private List<Nodo> end = new ArrayList<>();     //lista dei nodi contenenti le destinazioni

    private List<Nodo> nodopark = new ArrayList<>();


    public Location(){
        setStart();
        setEnd();
    }

    void setStart(){
        Nodo nodo1 = new Nodo(2,1);
        nodo1.setIndirizzo("San Giorgio");

        Nodo nodo2 = new Nodo(1,1);
        nodo2.setIndirizzo("Portici");

        Nodo nodo3 = new Nodo(0,1);
        nodo3.setIndirizzo("Pomigliano");

        Nodo nodo4 = new Nodo(3,1);
        nodo4.setIndirizzo("Centro Direzionale");

        Nodo nodo5 = new Nodo(6,3);
        nodo5.setIndirizzo("Volla");

        this.start.add(nodo1);
        this.start.add(nodo2);
        this.start.add(nodo3);
        this.start.add(nodo4);
        this.start.add(nodo5);
    }

    public void setEnd() {
        Nodo nodo1 = new Nodo(2,5);
        nodo1.setIndirizzo("Napoli");

        Nodo nodo2 = new Nodo(3,6);
        nodo2.setIndirizzo("Caserta");

        Nodo nodo3 = new Nodo(5,5);
        nodo3.setIndirizzo("Casoria");

        Nodo nodo4 = new Nodo(6,7);
        nodo4.setIndirizzo("Vomero");

        Nodo nodo5 = new Nodo(6,7);
        nodo5.setIndirizzo("Centro Storico");

        this.end.add(nodo1);
        this.end.add(nodo2);
        this.end.add(nodo3);
        this.end.add(nodo4);
        this.end.add(nodo5);
    }

    //scorre la lista dei nodi partenze cerca quello contenente l'indirizzo dato in input e lo ritorna
    public Nodo chooseStart(String indirizzo){

        for (Nodo position : this.start) {
            if(indirizzo.equals(position.getIndirizzo())){
                return position;
            }
        }
        return null;
    }


    //scorre la lista dei nodi destinazione cerca quello contenente l'indirizzo dato in input e lo ritorna
    public Nodo chooseEnd(String indirizzo){

        for (Nodo position : this.end) {
            if(indirizzo.equals(position.getIndirizzo())){
                return position;
            }
        }
        return null;
    }

    /*
        Setto i nodi in cui si trovano i parcheggi con le rispettive coordinate
        questi nodi li inserisco in una lista di "nodi parcheggio "che mi servirà
        in questa classe per tener sempre traccia dei parcheggi nei nodi
        e li inserisco in un array 2D usando lo stesso criterio dei blocchi
     */
    public int[][] setParking(){

        Nodo park1 = new Nodo(0,2);
        Nodo park2 = new Nodo(0,3);
        Nodo park3 = new Nodo(1,4);
        Nodo park4 = new Nodo(3, 2);
        Nodo park5 = new Nodo(4, 4);
        Nodo park6 = new Nodo(6, 5); //p

        nodopark.add(park1);
        nodopark.add(park2);
        nodopark.add(park3);
        nodopark.add(park4);
        nodopark.add(park5);
        nodopark.add(park6);

        int[][] blocksParking = new int[][]{
                {park1.getRow(), park1.getCol()},
                {park2.getRow(), park2.getCol()},
                {park3.getRow(), park3.getCol()},
                {park4.getRow(), park4.getCol()},
                {park5.getRow(), park5.getCol()},
                {park6.getRow(), park6.getCol()}
        };

        this.setParkIndirizzo();        //è un metodo che uso per associare ad ogni nodo gli indirizzi
        // dei parcheggi presenti nel database
        return blocksParking;
    }

    /*
        Mi ricavo i parcheggi presenti nel database e li salvo in un'array di stringhe
        gli elemento dell'array conterrà quindi l'indirizzo di ciascun parcheggio del database
        per ogni nodo salvato nella lista dei "nodi parcheggio" associo quindi un indirizzo salvbato precedentemente
        nell'array
    */
    public void setParkIndirizzo(){    //dovrebbe essere privato
        int i = 0;
        int j = 0;

        List<ParkingBean> parkingBeanList = ParkingDao.getListParking();
        String IndirizziP[] = new String[parkingBeanList.size() + 1];

        for (ParkingBean parkingBean: parkingBeanList) {
            IndirizziP[i] = parkingBean.getIndirizzo();
            i++;
        }

        for (Nodo nodo: nodopark) {
            nodo.setIndirizzo(IndirizziP[j]);
            j++;
        }
    }


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


    public List<Nodo> getStart(){ return start;}

    public List<Nodo> getEnd(){return end;}

    public List<Nodo> getNodopark(){
        return nodopark;
    }


}