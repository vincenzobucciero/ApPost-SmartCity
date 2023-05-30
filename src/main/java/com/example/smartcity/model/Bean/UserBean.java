package com.example.smartcity.model.Bean;
import java.io.Serializable;

public class UserBean implements Serializable {

    /** Il nome dell'utente. */
    private String nome;

    /** Il cognome dell'utente. */
    private String cognome;

    /** L'email dell'utente. */
    private String email;

    /** La password dell'utente. */
    private String password;

    /** Il numero di telefono dell'utente */
    private String telefono;

    /** Il sesso dell'utente */
    private String sesso;

    /** Data di nascita dell'utente */
    private String dataNascita;

    /**
     * Crea un nuovo oggetto UserBean con valori di default per tutti i suoi campi.
     */
    public UserBean(){}

    /**
     * Restituisce il nome dell'utente.
     * @return Il nome dell'utente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome dell'utente.
     * @param nome il nome dell'utente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il cognome dell'utente.
     * @return Il cognome dell'utente.
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Imposta il cognome dell'utente.
     * @param cognome Il cognome dell'utente.
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Restituisce l'email dell'utente.
     * @return l'email dell'utente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Imposta l'email dell'utente.
     * @param email l'email dell'utente.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Restituisce la password dell'utente.
     * @return la password dell'utente.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Imposta la password dell'utente.
     * @param password la password dell'utente.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Restituisce il numero di telefono dell'utente.
     * @return il telefono dell'utente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Imposta il numero di telefono dell'utente.
     * @param telefono la password dell'utente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Restituisce il sesso dell'utente.
     * @return il sesso dell'utente.
     */
    public String getSesso() {
        return sesso;
    }

    /**
     * Imposta il sesso dell'utente.
     * @param sesso la password dell'utente.
     */
    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    /**
     * Restituisce la data di nascita dell'utente.
     * @return la data di nascita dell'utente.
     */
    public String getDataNascita() {
        return dataNascita;
    }

    /**
     * Imposta la data di nascita dell'utente.
     * @param dataNascita la password dell'utente.
     */
    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }
}