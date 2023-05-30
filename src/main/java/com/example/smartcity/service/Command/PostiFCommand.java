package com.example.smartcity.service.Command;

import com.example.smartcity.model.Bean.BookingBean;
import com.example.smartcity.model.Bean.ParkingBean;

/**
 * La classe PostiFCommand rappresenta un comando che implementa l'interfaccia Command.
 * Questa classe è utilizzata per ottenere il numero di posti disponibili per i veicoli di tipo furgone in un parcheggio.
 */

public class PostiFCommand implements Command<Integer>{
    Receiver posti;

    /**
     * Costruttore della classe PostiFCommand
     *
     * @param posti oggetto della classe Receiver che rappresenta il destinatario del comando
     */
    public PostiFCommand(Receiver posti){
        this.posti = posti;
    }

    /**
     * Metodo che esegue il comando per ottenere il numero di posti disponibili per i veicoli di tipo furgone in un parcheggio
     *
     * @param parkingBean oggetto della classe ParkingBean che rappresenta il parcheggio
     * @param bookingBean oggetto della classe BookingBean che rappresenta la prenotazione
     * @return il numero di posti disponibili per i veicoli di tipo furgone in un parcheggio
     */
    @Override
    public Integer execute(ParkingBean parkingBean, BookingBean bookingBean) {
        return posti.getNumPostiF(parkingBean);
    }
}