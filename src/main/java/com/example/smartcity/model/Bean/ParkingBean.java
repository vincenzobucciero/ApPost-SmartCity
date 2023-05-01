package com.example.smartcity.model.Bean;

import java.io.Serializable;

public class ParkingBean implements Serializable {
    private String nomeParcheggio;
    private String indirizzo;
    private int postiAuto;
    private int postiFurgone;
    private int postiMoto;
    private double tariffaAF;
    private double tariffaM;

    public ParkingBean(){}

    public int getPostiAuto() {
        return postiAuto;
    }

    public void setPostiAuto(int postiAuto) {
        this.postiAuto = postiAuto;
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


    public void setTariffaAF(double tariffaAF) {
        this.tariffaAF = tariffaAF;
    }
    public double getTariffaM() {
        return tariffaM;
    }

    public void setTariffaM(double tariffaM) {
        this.tariffaM = tariffaM;
    }
    public double getTariffaAF() {
        return tariffaAF;
    }

    public int getPostiFurgone() {
        return postiFurgone;
    }

    public void setPostiFurgone(int postiFurgone) {
        this.postiFurgone = postiFurgone;
    }

    public int getPostiMoto() {
        return postiMoto;
    }

    public void setPostiMoto(int postiMoto) {
        this.postiMoto = postiMoto;
    }

}