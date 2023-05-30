package com.example.smartcity.service.Command;

/**
 * L'enumerazione VeicoliEnum rappresenta i diversi tipi di veicoli supportati dal sistema e associa a ciascuno
 * di essi due comandi: uno per calcolare il prezzo del posto e uno per ottenere il numero di posti disponibili.
 */
public enum VeicoliEnum {

    /**
     * Costante di tipo VeicoliEnum che rappresenta l'auto.
     */
    Auto(new PrezzoAFCommand(new Receiver()), new PostiACommand(new Receiver())),

    /**
     * Costante di tipo VeicoliEnum che rappresenta il furgone.
     */
    Furgone(new PrezzoAFCommand(new Receiver()), new PostiFCommand(new Receiver())),

    /**
     * Costante di tipo VeicoliEnum che rappresenta la moto.
     */
    Moto(new PrezzoMCommand(new Receiver()), new PostiMCommand(new Receiver()));


    /**
     * Costante di tipo Command<Double> che rappresenta il comando per calcolare il prezzo del posto.
     */
    private final Command<Double> PREZZO;

    /**
     * Costante di tipo Command<Integer> che rappresenta il comando per ottenere il numero di posti disponibili.
     */
    private final Command<Integer> POSTI;


    /**
     * Costruttore dell'enumerazione VeicoliEnum.
     *
     * @param prezzo il comando per calcolare il prezzo del posto
     * @param posti il comando per ottenere il numero di posti disponibili
     */
    VeicoliEnum( Command<Double> prezzo, Command<Integer> posti) {
        this.PREZZO = prezzo;
        this.POSTI = posti;
    }

    /**
     * Metodo che restituisce il comando per calcolare il prezzo del posto.
     *
     * @return il comando per calcolare il prezzo del posto
     */
    public Command<Double> getPrezzoPosto() {
        return PREZZO;
    }


    /**
     * Metodo che restituisce il comando per ottenere il numero di posti disponibili.
     *
     * @return il comando per ottenere il numero di posti disponibili
     */
    public Command<Integer> getTotPosti() {
        return POSTI;
    }
}