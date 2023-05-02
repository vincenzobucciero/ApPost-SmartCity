package com.example.smartcity.service.CommandPrezzo;

import com.example.smartcity.model.Bean.BookingBean;
import com.example.smartcity.model.Bean.ParkingBean;


/**
 * La classe PostiMCommand rappresenta un comando che implementa l'interfaccia Command.
 * Questa classe è utilizzata per ottenere il numero di posti disponibili per i veicoli di tipo moto in un parcheggio.
 */
public class PostiMCommand implements Command<Integer>{
    Receiver posti;

    /**
     * Costruttore della classe PostiMCommand
     *
     * @param posti oggetto della classe Receiver che rappresenta il destinatario del comando
     */
    public PostiMCommand(Receiver posti){
        this.posti = posti;
    }

    /**
     * Metodo che esegue il comando per ottenere il numero di posti disponibili per i veicoli di tipo moto in un parcheggio
     *
     * @param parkingBean oggetto della classe ParkingBean che rappresenta il parcheggio
     * @param bookingBean oggetto della classe BookingBean che rappresenta la prenotazione
     * @return il numero di posti disponibili per i veicoli di tipo moto in un parcheggio
     */
    @Override
    public Integer execute(ParkingBean parkingBean, BookingBean bookingBean) {
        return posti.getNumPostiM(parkingBean);
    }
}