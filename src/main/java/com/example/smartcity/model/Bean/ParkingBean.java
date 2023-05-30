package com.example.smartcity.model.Bean;

import java.io.Serializable;

/**
 * Questa classe rappresenta un oggetto di tipo Parcheggio.
 * Un parcheggio è definito da un nome, un indirizzo, il numero di posti disponibili per auto, furgoni e moto,
 * e le tariffe orarie per auto e moto.
 * La classe implementa l'interfaccia Serializable per permettere la serializzazione degli oggetti.
 */
public class ParkingBean implements Serializable {

    /** Nome del parcheggio */
    private String nomeParcheggio;

    /** Indirizzo del parcheggio */
    private String indirizzo;

    /** Numero di posto auto nel parcheggio */
    private int postiAuto;

    /** Numero di posto furgone nel parcheggio */
    private int postiFurgone;

    /** Numero di posto moto nel parcheggio */
    private int postiMoto;

    /** Tariffa per il tipo di veicolo auto/furgone */
    private double tariffaAF;

    /** Tariffa per il tipo di veicolo moto */
    private double tariffaM;

    /**
     * Costruttore vuoto della classe ParkingBean.
     */
    public ParkingBean(){}

    /**
     * Restituisce il numero di posti disponibili per auto.
     * @return Il numero di posti disponibili per auto.
     */
    public int getPostiAuto() {
        return postiAuto;
    }

    /**
     * Imposta il numero di posti disponibili per auto.
     * @param postiAuto  Il numero di posti disponibili per auto.
     */
    public void setPostiAuto(int postiAuto) {
        this.postiAuto = postiAuto;
    }

    /**
     * Restituisce l'indirizzo del parcheggio.
     * @return L'indirizzo del parcheggio.
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * Imposta l'indirizzo del parcheggio.
     * @param indirizzo L'indirizzo del parcheggio.
     */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    /**
     * Restituisce il nome del parcheggio.
     * @return Il nome del parcheggio.
     */
    public String getNomeParcheggio() {
        return nomeParcheggio;
    }

    /**
     * Imposta il nome del parcheggio.
     * @param nomeParcheggio Il nome del parcheggio.
     */
    public void setNomeParcheggio(String nomeParcheggio) {
        this.nomeParcheggio = nomeParcheggio;
    }

    /**
     * Imposta il prezzo della tariffa per tipo auto/furgone
     * @param tariffaAF il prezzo della tariffa per tipo auto/furgone
     */
    public void setTariffaAF(double tariffaAF) {
        this.tariffaAF = tariffaAF;
    }

    /**
     * Restituisce il prezzo della tariffa per tipo auto/furgone
     * @return il prezzo della tariffa per tipo auto/furgone
     */
    public double getTariffaAF() {
        return tariffaAF;
    }

    /**
     * Restituisce il prezzo della tariffa per tipo moto
     * @return il prezzo della tariffa per tipo moto
     */
    public double getTariffaM() {
        return tariffaM;
    }

    /**
     * Imposta il prezzo della tariffa per tipo moto
     * @param tariffaM  il prezzo della tariffa per tipo moto
     */
    public void setTariffaM(double tariffaM) {
        this.tariffaM = tariffaM;
    }

    /**
     * Restituisce il numero di posti disponibili per furgone.
     * @return Il numero di posti disponibili per furgone.
     */
    public int getPostiFurgone() {
        return postiFurgone;
    }

    /**
     * Imposta il numero di posti disponibili per furgone.
     * @param postiFurgone Il numero di posti disponibili per furgone.
     */
    public void setPostiFurgone(int postiFurgone) {
        this.postiFurgone = postiFurgone;
    }

    /**
     * Restituisce il numero di posti disponibili per moto.
     * @return Il numero di posti disponibili per moto.
     */
    public int getPostiMoto() {
        return postiMoto;
    }

    /**
     * Imposta il numero di posti disponibili per moto.
     * @param postiMoto Il numero di posti disponibili per moto.
     */
    public void setPostiMoto(int postiMoto) {
        this.postiMoto = postiMoto;
    }

}