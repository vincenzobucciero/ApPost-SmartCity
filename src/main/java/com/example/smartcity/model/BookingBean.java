package com.example.smartcity.model;

import java.io.Serializable;


public class BookingBean implements Serializable {
    private int ID_prenotazione;
    private String data_prenotazione;
    private String orario_inizio;
    private String orario_fine;
    private String email;
    private String targaVeicolo;
    private String tipoVeicolo;
    private double prezzo;

    public int getID_prenotazione() {
        return ID_prenotazione;
    }

    public void setID_prenotazione(int ID_prenotazione) {
        this.ID_prenotazione = ID_prenotazione;
    }

    public String getData_prenotazione() {
        return data_prenotazione;
    }

    public void setData_prenotazione(String data_prenotazione) {
        this.data_prenotazione = data_prenotazione;
    }

    public String getOrario_inizio() {
        return orario_inizio;
    }

    public void setOrario_inizio(String orario_inizio) {
        this.orario_inizio = orario_inizio;
    }

    public String getOrario_fine() {
        return orario_fine;
    }

    public void setOrario_fine(String orario_fine) {
        this.orario_fine = orario_fine;
    }


    public String getTargaVeicolo() {
        return targaVeicolo;
    }

    public void setTargaVeicolo(String targaVeicolo) {
        this.targaVeicolo = targaVeicolo;
    }

    public String getTipoVeicolo() {
        return tipoVeicolo;
    }

    public void setTipoVeicolo(String tipoVeicolo) {
        this.tipoVeicolo = tipoVeicolo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}