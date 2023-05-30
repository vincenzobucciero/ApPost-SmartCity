package com.example.smartcity.service.Algoritmo;

import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.model.DAO.ParkingDao;

import java.util.*;


/**
 * La classe Location è una classe che sfrutta la struttura dell'algoritmo A* per poter gestire
 * la disposizione dei parcheggi, quindi poterli inserire, associarli ai nodi ed ottenere informazioni.
 * La classe Location è stata anche utilizzata per settare partenze e destinazioni predefinite.
 */
public class Location {

    private List<Nodo> start = new ArrayList<>();   //lista dei nodi contenenti le partenze
    private List<Nodo> end = new ArrayList<>();     //lista dei nodi contenenti le destinazioni

    private List<Nodo> nodopark = new ArrayList<>();


    /**
     * Crea una nuova istanza della classe Location.
     */
    public Location(){
        setStart();
        setEnd();
    }


    /**
     * Imposta i nodi di partenza per il calcolo del percorso. In questo caso,
     * i nodi di partenza sono predefiniti nella classe e non dipendono da parametri
     * esterni. Ogni nodo di partenza viene creato come un oggetto di tipo Nodo,
     * che rappresenta un punto sulla mappa, e viene associato a un indirizzo.
     */
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


    /**
     * Imposta i nodi di arrivo per il calcolo del percorso. In questo caso,
     * i nodi di arrivo sono predefiniti nella classe e non dipendono da parametri
     * esterni. Ogni nodo di arrivo viene creato come un oggetto di tipo Nodo,
     * che rappresenta un punto sulla mappa, e viene associato a un indirizzo.
     */
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


    /**
     * Restituisce il nodo di partenza corrispondente all'indirizzo specificato.
     * Se non viene trovato alcun nodo con l'indirizzo specificato, restituisce null.
     *
     * @param indirizzo l'indirizzo del nodo di partenza desiderato
     * @return il nodo di partenza corrispondente all'indirizzo specificato, o null
     *         se non viene trovato alcun nodo con quell'indirizzo
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
     * Restituisce il nodo di destinazione corrispondente all'indirizzo specificato.
     * Se non viene trovato alcun nodo con l'indirizzo specificato, restituisce null.
     *
     * @param indirizzo l'indirizzo del Nodo da cercare
     * @return il Nodo corrispondente all'indirizzo specificato, se presente; altrimenti, restituisce null.
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
     * Questo metodo crea i nodi corrispondenti ai parcheggi presenti nel database e li aggiunge alla lista di nodi.
     * Inoltre, crea una matrice d'interi che rappresenta la posizione di ogni parcheggio nella griglia.
     * Infine, chiama il metodo setParkIndirizzo per associare a ogni nodo gli indirizzi dei parcheggi nel database.
     *
     * @return una matrice d'interi che rappresenta la posizione di ogni parcheggio nella griglia
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


    /**
     * Associa a ogni nodo dei parcheggi presenti nel database l'indirizzo corrispondente.
     * Il metodo preleva la lista dei parcheggi dal database, crea un array di stringhe contenente
     * gli indirizzi dei parcheggi e poi assegna a ogni nodo l'indirizzo corrispondente.
     */
    public void setParkIndirizzo(){    //dovrebbe essere privato
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
     * Restituisce l'oggetto ParkingBean contenente le informazioni relative al parcheggio
     * associato al nodo passato come parametro.
     *
     * @param nodo il nodo di cui si vuole conoscere l'indirizzo del parcheggio associato
     * @return l'oggetto ParkingBean contenente le informazioni relative al parcheggio associato al nodo,
     *         null se non viene trovato un parcheggio associato al nodo passato come parametro
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
     * Questo metodo è utilizzato per ottenere le informazioni sul parcheggio disponibile
     * associato a un determinato nodo. Viene effettuata una ricerca all'interno del database dei parcheggi
     * per trovare quello associato al nodo passato come parametro.
     *
     * @param nodoP il nodo parcheggio di cui si vuole conoscere il parcheggio disponibile associato
     * @return il bean contenente le informazioni sul parcheggio disponibile associato al nodo, o null se non è presente
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
     * Metodo che restituisce una lista di oggetti Nodo rappresentanti i punti di partenza.
     *
     * @return una lista di oggetti Nodo rappresentanti i punti di partenza.
     */
    public List<Nodo> getStart(){ return start;}


    /**
     * Metodo che restituisce una lista di oggetti Nodo rappresentanti i punti di destinazione.
     *
     * @return una lista di oggetti Nodo rappresentanti i punti di destinazione.
     */
    public List<Nodo> getEnd(){return end;}


    /**
     * Metodo che restituisce la lista dei nodi parcheggio dell'oggetto corrente.
     *
     * @return la lista dei nodi parcheggio.
     */
    public List<Nodo> getNodopark(){
        return nodopark;
    }


}
