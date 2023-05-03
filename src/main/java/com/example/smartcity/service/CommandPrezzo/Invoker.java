package com.example.smartcity.service.CommandPrezzo;

import com.example.smartcity.model.Bean.BookingBean;
import com.example.smartcity.model.Bean.ParkingBean;


/**
 * La classe Invoker è una classe adibita all'invocazione un comando specifico 
 * associato a un'operazione selezionata dall'utente tramite l'enum VeicoliEnum.
 * Il metodo getTot restituisce il totale del prezzo per l'operazione richiesta, mentre il metodo getPosti
 * restituisce il numero di posti disponibili per l'operazione richiesta.
 */
public class Invoker {

    /**
     * Restituisce il totale del prezzo per l'operazione richiesta.
     *
     * @param operation l'operazione richiesta
     * @param parkingBean l'oggetto ParkingBean associato all'operazione
     * @param bookingBean l'oggetto BookingBean associato all'operazione
     * @return il totale del prezzo per l'operazione richiesta
     */
    public double getTot(VeicoliEnum operation, ParkingBean parkingBean, BookingBean bookingBean) {
        Command<Double> toExecute = operation.getPrezzoPosto();
        return toExecute.execute(parkingBean, bookingBean);
    }

    /**
     * Restituisce il numero di posti disponibili per l'operazione richiesta.
     *
     * @param operation l'operazione richiesta
     * @param parkingBean l'oggetto ParkingBean associato all'operazione
     * @param bookingBean l'oggetto BookingBean associato all'operazione
     * @return il numero di posti disponibili per l'operazione richiesta
     */
    public int getPosti(VeicoliEnum operation, ParkingBean parkingBean, BookingBean bookingBean){
        Command<Integer> toExecute = operation.getTotPosti();
        return toExecute.execute(parkingBean, bookingBean);

    }
}
