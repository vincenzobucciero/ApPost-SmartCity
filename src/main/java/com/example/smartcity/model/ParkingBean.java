package com.example.smartcity.model;

import java.beans.JavaBean;
import java.io.Serializable;

@JavaBean

public class ParkingBean implements Serializable {

    private int idParcheggio;
    private String nomeParcheggio;
    private String indirizzo;
    private int numPosti;
    private double tariffa;

    public ParkingBean(){}

    public int getNumPosti() {
        return numPosti;
    }

    public void setNumPosti(int numPosti) {
        this.numPosti = numPosti;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getNomeParcheggio() {
        return nomeParcheggio;
    }

    public void setNomeParcheggio(String nomeParcheggio) {
        this.nomeParcheggio = nomeParcheggio;
    }

    public int getIdParcheggio() {
        return idParcheggio;
    }

    public void setIdParcheggio(int idParcheggio) {
        this.idParcheggio = idParcheggio;
    }

    public double getTariffa() {
        return tariffa;
    }

    public void setTariffa(double tariffa) {
        this.tariffa = tariffa;
    }
}