package com.example.smartcity.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class BookingBean implements Serializable {
    private String ID_prenotazione;
    private String data_prenotazione;
    private String orario_inizio;
    private String orario_fine;
    private String email;
    private String targaVeicolo;
    private String tipoVeicolo;
    private double prezzo;
    private String pagamento;
    private String nomeParcheggio;

    public String getID_prenotazione() {
        return ID_prenotazione;
    }

    public void setID_prenotazione(String ID_prenotazione) {
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

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public String getNomeParcheggio() {
        return nomeParcheggio;
    }

    public void setNomeParcheggio(String nomeParcheggio) {
        this.nomeParcheggio = nomeParcheggio;
    }
}