package com.example.smartcity.service.CommandPrezzo;

import com.example.smartcity.model.Bean.BookingBean;
import com.example.smartcity.model.Bean.ParkingBean;


/**
 * Questa interfaccia rappresenta un comando generico da eseguire sulla prenotazione di un parcheggio.
 *
 * @param <T> il tipo di valore di ritorno dell'esecuzione del comando.
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