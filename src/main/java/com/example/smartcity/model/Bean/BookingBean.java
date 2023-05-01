package com.example.smartcity.model.Bean;

import com.example.smartcity.service.CommandPrezzo.VeicoliEnum;

import java.io.Serializable;


/**
 * Questa classe rappresenta un oggetto di prenotazione di un parcheggio.
 * Contiene informazioni quali id, data e orario della prenotazione, tipo di veicolo, prezzo e metodo di pagamento.
 * La classe implementa l'interfaccia Serializable per permettere la serializzazione degli oggetti.
 */
public class BookingBean implements Serializable {

    /** L'ID della prenotazione */
    private String ID_prenotazione;

    /** La data della prenotazione*/
    private String data_prenotazione;

    /** L'orario d'inizio della prenotazione */
    private String orario_inizio;

    /** L'orario di fine della prenotazione */
    private String orario_fine;

    /** L'email dell'utente che ha effettuato la prenotazione */
    private String email;

    /** La targa del veicolo prenotato */
    private String targaVeicolo;

    /** Il tipo di veicolo prenotato */
    private VeicoliEnum tipoVeicolo;

    /** Il prezzo della prenotazione */
    private double prezzo;

    /** Metodo di pagamento della prenotazione */
    private String pagamento;

    /** Il nome del parcheggio prenotato */
    private String nomeParcheggio;


    /**
     * Restituisce l'ID della prenotazione.
     * @return l'ID della prenotazione
     */
    public String getID_prenotazione() {
        return ID_prenotazione;
    }


    /**
     * Imposta l'ID della prenotazione
     * @param ID_prenotazione l'ID della prenotazione
     */
    public void setID_prenotazione(String ID_prenotazione) {
        this.ID_prenotazione = ID_prenotazione;
    }


    /**
     * Restituisce la data della prenotazione.
     * @return la data della prenotazione
     */
    public String getData_prenotazione() {
        return data_prenotazione;
    }


    /**
     * Imposta la data della prenotazione
     * @param data_prenotazione la data della prenotazione
     */
    public void setData_prenotazione(String data_prenotazione) {
        this.data_prenotazione = data_prenotazione;
    }


    /**
     * Restituisce l'orario d'inizio della prenotazione.
     * @return l'orario d'inizio della prenotazione.
     */
    public String getOrario_inizio() {
        return orario_inizio;
    }


    /**
     * Imposta l'orario d'inizio della prenotazione.
     * @param orario_inizio l'orario d'inizio della prenotazione.
     */
    public void setOrario_inizio(String orario_inizio) {
        this.orario_inizio = orario_inizio;
    }


    /**
     * Restituisce l'orario di fine della prenotazione.
     * @return l'orario di fine della prenotazione.
     */
    public String getOrario_fine() {
        return orario_fine;
    }


    /**
     * Imposta l'orario di fine della prenotazione.
     * @param orario_fine l'orario di fine della prenotazione.
     */
    public void setOrario_fine(String orario_fine) {
        this.orario_fine = orario_fine;
    }


    /**
     * Restituisce la targa del veicolo di cui si vuole effettuare
     * la prenotazione al parcheggio
     * @return targa del veicolo
     */
    public String getTargaVeicolo() {
        return targaVeicolo;
    }


    /**
     * Imposta la targa del veicolo di cui si vuole effettuare
     * la prenotazione al parcheggio
     * @param targaVeicolo la targa del veicolo
     */
    public void setTargaVeicolo(String targaVeicolo) {
        this.targaVeicolo = targaVeicolo;
    }


    /**
     * Restituisce il tipo del veicolo di cui si vuole effettuare
     * la prenotazione al parcheggio
     * @return il tipo di veicolo
     */
    public VeicoliEnum getTipoVeicolo() {
        return tipoVeicolo;
    }


    /**
     * Imposta il tipo del veicolo di cui si vuole effettuare
     * la prenotazione al parcheggio
     * @param tipoVeicolo tipo di veicolo
     */
    public void setTipoVeicolo(VeicoliEnum tipoVeicolo) {
        this.tipoVeicolo = tipoVeicolo;
    }


    /**
     * Restituisce email dell'utente che effettua la prenotazione
     * @return email dell'utente
     */
    public String getEmail() {
        return email;
    }


    /**
     * Imposta l'email dell'utente che ha effettuato la prenotazione
     * @param email l'email dell'utente
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Restituisce il prezzo della prenotazione
     * @return il prezzo della prenotazione
     */
    public double getPrezzo() {
        return prezzo;
    }


    /**
     * Imposta il prezzo della prenotazione
     * @param prezzo  il prezzo della prenotazione
     */
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }


    /**
     * Restituisce il metodo di pagamento utilizzato per la prenotazione.
     * @return una stringa rappresentante il metodo di pagamento utilizzato per la prenotazione
     */
    public String getPagamento() {
        return pagamento;
    }


    /**
     * Imposta il metodo di pagamento utilizzato per la prenotazione.
     * @param pagamento una stringa rappresentante il metodo di pagamento utilizzato per la prenotazione
     */
    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }


    /**
     * Restituisce il nome del parcheggio presso il quale si vuole
     * effettuare la prenotazione.
     * @return il nome del parcheggio presso il quale si vuole
     * effettuare la prenotazione.
     */
    public String getNomeParcheggio() {
        return nomeParcheggio;
    }


    /**
     * Restituisce il nome del parcheggio presso il quale si vuole
     * effettuare la prenotazione.
     * @param nomeParcheggio  il nome del parcheggio presso il quale si vuole
     * effettuare la prenotazione.
     */
    public void setNomeParcheggio(String nomeParcheggio) {
        this.nomeParcheggio = nomeParcheggio;
    }
}