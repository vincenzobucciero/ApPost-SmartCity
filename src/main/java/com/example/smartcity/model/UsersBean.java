package com.example.smartcity.model;
import java.io.Serializable;

/**
 *
 *
 */
public class UsersBean implements Serializable {

    private String nome;
    private String cognome;
    private String email;
    private String password;

    /**
     *
     *
     */
    public UsersBean(){}

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}