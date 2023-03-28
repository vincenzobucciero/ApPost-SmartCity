package com.example.smartcity.model;

import java.beans.JavaBean;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@JavaBean

public class BookingBean implements Serializable {
    private int ID_prenotazione;
    private LocalDate data_prenotazione;
    private LocalTime orario_inizio;
    private LocalTime orario_fine;
    private int ID_utente;
    private String targaVeicolo;
    private String tipoVeicolo;

    public int getID_prenotazione() {
        return ID_prenotazione;
    }

    public void setID_prenotazione(int ID_prenotazione) {
        this.ID_prenotazione = ID_prenotazione;
    }

    public LocalDate getData_prenotazione() {
        return data_prenotazione;
    }

    public void setData_prenotazione(LocalDate data_prenotazione) {
        this.data_prenotazione = data_prenotazione;
    }

    public LocalTime getOrario_inizio() {
        return orario_inizio;
    }

    public void setOrario_inizio(LocalTime orario_inizio) {
        this.orario_inizio = orario_inizio;
    }

    public LocalTime getOrario_fine() {
        return orario_fine;
    }

    public void setOrario_fine(LocalTime orario_fine) {
        this.orario_fine = orario_fine;
    }

    public int getID_utente() {
        return ID_utente;
    }

    public void setID_utente(int ID_utente) {
        this.ID_utente = ID_utente;
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
}