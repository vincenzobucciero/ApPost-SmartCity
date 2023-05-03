package com.example.smartcity.service.CommandPrezzo;

import com.example.smartcity.model.Bean.BookingBean;
import com.example.smartcity.model.Bean.ParkingBean;

/**
 * Classe interfaccia in cui è presente il metodo per eseguire la richiesta.
 * La casse è stata realizzata utilizzando dei template affinché le classi concrete, che implementano tale interfaccia, 
 * possano far ritornare da execute un tipo diverso in base alle necessità.
 */
public interface Command <T>{

    /**
     * Metodo che esegue il comando sulla prenotazione di un parcheggio.
     *
     * @param parkingBean il parcheggio su cui eseguire il comando.
     * @param bookingBean la prenotazione su cui eseguire il comando.
     * @return il risultato dell'esecuzione del comando.
     */
    T execute(ParkingBean parkingBean, BookingBean bookingBean);
}
