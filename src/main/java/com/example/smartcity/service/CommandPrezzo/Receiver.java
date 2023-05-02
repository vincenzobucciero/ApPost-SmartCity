package com.example.smartcity.service.CommandPrezzo;

import com.example.smartcity.model.Bean.BookingBean;
import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.model.DAO.BookingDao;


/**
 * La classe Receiver si occupa di eseguire le operazioni richieste dai comandi del pattern Command.
 */
public class Receiver {

    /**
     * Restituisce il prezzo totale di una prenotazione per un posto auto/furgone.
     *
     * @param parkingBean oggetto ParkingBean che rappresenta il parcheggio.
     * @param bookingBean oggetto BookingBean che rappresenta la prenotazione.
     * @return il prezzo totale della prenotazione.
     */
    public double getPrezzoAF(ParkingBean parkingBean, BookingBean bookingBean){
        return BookingDao.getTotPrice(parkingBean.getTariffaAF(), bookingBean);
    }


    /**
     * Restituisce il prezzo totale di una prenotazione per un posto moto.
     *
     * @param parkingBean oggetto ParkingBean che rappresenta il parcheggio.
     * @param bookingBean oggetto BookingBean che rappresenta la prenotazione.
     * @return il prezzo totale della prenotazione.
     */
    public double getPrezzoM(ParkingBean parkingBean, BookingBean bookingBean) {
        return BookingDao.getTotPrice(parkingBean.getTariffaM(), bookingBean);
    }


    /**
     * Restituisce il numero di posti auto disponibili nel parcheggio.
     *
     * @param parkingBean oggetto ParkingBean che rappresenta il parcheggio.
     * @return il numero di posti auto disponibili nel parcheggio.
     */
    public int getNumPostiA(ParkingBean parkingBean) {
        return parkingBean.getPostiAuto();
    }

    /**
     * Restituisce il numero di posti furgone disponibili nel parcheggio.
     *
     * @param parkingBean oggetto ParkingBean che rappresenta il parcheggio.
     * @return il numero di posti furgone disponibili nel parcheggio.
     */
    public int getNumPostiF(ParkingBean parkingBean) {
        return parkingBean.getPostiFurgone();
    }

    /**
     * Restituisce il numero di posti moto disponibili nel parcheggio.
     *
     * @param parkingBean oggetto ParkingBean che rappresenta il parcheggio.
     * @return il numero di posti moto disponibili nel parcheggio.
     */
    public int getNumPostiM(ParkingBean parkingBean) {
        return parkingBean.getPostiMoto();
    }
}