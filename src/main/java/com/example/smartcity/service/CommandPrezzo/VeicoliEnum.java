package com.example.smartcity.service.CommandPrezzo;

public enum VeicoliEnum {
    Auto(new PrezzoAFCommand(new Receiver()), new PostiACommand(new Receiver())),
    Furgone(new PrezzoAFCommand(new Receiver()), new PostiFCommand(new Receiver())),
    Moto(new PrezzoMCommand(new Receiver()), new PostiMCommand(new Receiver()));

    private final Command<Double> PREZZO;
    private final Command<Integer> POSTI;

    VeicoliEnum( Command<Double> prezzo, Command<Integer> posti) {
        this.PREZZO = prezzo;
        this.POSTI = posti;
    }

    public Command<Double> getPrezzoPosto() {
        return PREZZO;
    }

    public Command<Integer> getTotPosti() {
        return POSTI;
    }
}