package com.example.smartcity.service.Algoritmo;

import com.example.smartcity.model.ParkingBean;
import com.example.smartcity.model.ParkingDao;

import java.util.*;
public class Location {

    private List<Nodo> start = new ArrayList<>();
    private List<Nodo> end = new ArrayList<>();

    private List<Nodo> nodopark = new ArrayList<>();


    //private int[][]blocksParking;

    public Location(){
        setStart();
        setEnd();
        //setParking();
    }

    void setStart(){
        Nodo nodo1 = new Nodo(2,1);
        nodo1.setIndirizzo("San Giorgio");

        Nodo nodo2 = new Nodo(1,1);
        nodo2.setIndirizzo("Portici");

        Nodo nodo3 = new Nodo(0,1);
        nodo3.setIndirizzo("Pomigliano");

        this.start.add(nodo1);
        this.start.add(nodo2);
        this.start.add(nodo3);
    }

    public void setEnd() {
        Nodo nodo1 = new Nodo(2,5);
        nodo1.setIndirizzo("Napoli");

        Nodo nodo2 = new Nodo(3,6);
        nodo2.setIndirizzo("Caserta");

        Nodo nodo3 = new Nodo(5,5);
        nodo3.setIndirizzo("Casoria");

        this.end.add(nodo1);
        this.end.add(nodo2);
        this.end.add(nodo3);
    }

    public int[][] setParking(){
        //int[][] blocksParking = new int[][]{{0,2}, {0,3}, {1,4}};
        //List<ParkingBean> parking = ParkingDao.getIstanza().;

        Nodo park1 = new Nodo(0,2);
        Nodo park2 = new Nodo(0,3);
        Nodo park3 = new Nodo(1,4);

        nodopark.add(park1);
        nodopark.add(park2);
        nodopark.add(park3);


        int[][] blocksParking = new int[][]{{park1.getRow(), park1.getCol()},
                {park2.getRow(), park2.getCol()},
                {park3.getRow(),park3.getCol()}};

        this.setParkIndirizzo();
        return blocksParking;
    }

    public void setParkIndirizzo(){
        int i = 1;
        ParkingDao parkingDao = ParkingDao.getIstanza();

        for (Nodo nodo: nodopark) {
            nodo.setIndirizzo(parkingDao.getParkingBean(i).getIndirizzo());
            i++;
        }
    }


    public Nodo chooseStart(String indirizzo){

        for (Nodo position : this.start) {
            if(indirizzo.equals(position.getIndirizzo())){
                return position;
            }
        }
        return null;
    }

    public Nodo chooseEnd(String indirizzo){

        for (Nodo position : this.end) {
            if(indirizzo.equals(position.getIndirizzo())){
                return position;
            }
        }
        return null;
    }

    public List<Nodo> getStart(){ return start;}

    public List<Nodo> getEnd(){return end;}
    public List<Nodo> getNodopark(){
        return nodopark;
    }


    public ParkingBean getNodoParkIndirizzo(Nodo nodo){
        //List<ParkingBean> listaParcheggi = new ArrayList<>();

        //per ogni nodo appartenente alla lista dei nodi parcheggi che ho istanziato controllo se è un nodo del percorso trovato
        for (Nodo nodop:nodopark) {
            if(nodo.equals(nodop)) {
                //se la condizione è vera allora cerco i parcheggi associati a quel nodo
                //listaParcheggi = getParcheggiDisp(nodop);
                return getParcheggiDisp(nodop);
                // System.out.println("Parcheggio trovato alle coordinte " + nodop.getRow() + " " + nodop.getCol() + " indirizzo " + nodop.getIndirizzo());
            }
        }
        return null;
    }

    public ParkingBean getParcheggiDisp(Nodo nodoP){
        System.out.println(nodoP.getIndirizzo());
        List<ParkingBean> parkingBeanList = ParkingDao.getIstanza().getParkings();
        List<ParkingBean> parkDisp = new ArrayList<>();

        //per ogni parcheggio controllo che ci sia un nodo il cui indirizzo è uguale, in quel caso significa che ho trovato
        //un nodo parcheggio e lo metto in una lista
        for (ParkingBean parkingBean: parkingBeanList) {
            if(parkingBean.getIndirizzo().equals(nodoP.getIndirizzo())) {
                //parkDisp.add(parkingBean);
                System.out.println("Parcheggio disponibile: "+ parkingBean.getIndirizzo());
                return parkingBean;
            }

        }
        return null;
    }


}