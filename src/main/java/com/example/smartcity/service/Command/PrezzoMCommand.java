package com.example.smartcity.service.Command;

import com.example.smartcity.model.Bean.BookingBean;
import com.example.smartcity.model.Bean.ParkingBean;

/**
 * La classe PrezzoMCommand implementa l'interfaccia Command<Double> e rappresenta un comando per ottenere il prezzo
 * di un parcheggio con un veicolo di tipo moto. Il prezzo è calcolato utilizzando un oggetto Receiver prezzo
 * che esegue la logica di calcolo del prezzo in base al tipo di veicolo.
 */
public class PrezzoMCommand implements Command<Double>{

    /**
     * Il riferimento al Receiver che contiene la logica di business per calcolare il prezzo di un posto per
     * un veicolo di tipo moto.
     */
    Receiver prezzo;

    /**
     * Costruttore della classe PrezzoMCommand.
     *
     * @param prezzo oggetto Receiver che esegue la logica di calcolo del prezzo in base al tipo di veicolo.
     */
    public PrezzoMCommand(Receiver prezzo){ this.prezzo = prezzo; }


    /**
     * Implementazione del metodo execute dell'interfaccia Command.
     *
     * @param parkingBean il parcheggio di cui si vuole calcolare il prezzo.
     * @param bookingBean la prenotazione di cui si vuole calcolare il prezzo.
     * @return il prezzo di un'ora di sosta con un veicolo di tipo moto.
     */
    @Override
    public Double execute(ParkingBean parkingBean, BookingBean bookingBean) {
        return prezzo.getPrezzoM(parkingBean, bookingBean);
    }
}