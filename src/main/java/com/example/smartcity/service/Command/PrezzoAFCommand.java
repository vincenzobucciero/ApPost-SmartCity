package com.example.smartcity.service.Command;

import com.example.smartcity.model.Bean.BookingBean;
import com.example.smartcity.model.Bean.ParkingBean;

/**
 * La classe PrezzoAFCommand implementa l'interfaccia Command<Double> e rappresenta un comando per ottenere il prezzo
 * di un parcheggio con un veicolo di tipo auto/furgone. Il prezzo è calcolato utilizzando un oggetto Receiver prezzo
 * che esegue la logica di calcolo del prezzo in base al tipo di veicolo.
 */
public class PrezzoAFCommand implements Command<Double>{

    /**
     * Il riferimento al Receiver che contiene la logica di business per calcolare il prezzo di un posto per
     * un veicolo di tipo auto/furgone.
     */
    Receiver prezzo;

    /**
     * Costruisce un nuovo oggetto PrezzoAFCommand con il riferimento al Receiver.
     *
     * @param prezzo il riferimento al Receiver.
     */
    public PrezzoAFCommand(Receiver prezzo){ this.prezzo = prezzo; }

    /**
     * Calcola il prezzo totale di un posto auto per un veicolo di tipo auto/furgone.
     *
     * @param parkingBean l'oggetto ParkingBean che contiene le informazioni sul parcheggio.
     * @param bookingBean l'oggetto BookingBean che contiene le informazioni sulla prenotazione.
     * @return il prezzo totale calcolato dal Receiver per il veicolo di tipo auto/furgone.
     */
    @Override
    public Double execute(ParkingBean parkingBean, BookingBean bookingBean) {
        return prezzo.getPrezzoAF(parkingBean, bookingBean);
    }
}
