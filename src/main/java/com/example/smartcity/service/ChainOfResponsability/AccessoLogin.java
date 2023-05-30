package com.example.smartcity.service.ChainOfResponsability;

/**
 * Questa classe rappresenta un'enumerazione che descrive i possibili
 * esiti di un tentativo di accesso al sistema di login.
 */
public enum AccessoLogin {
    /** L'utente specificato non esiste nel sistema di login. */
    UTENTE_INESISTENTE,

    /** La password specificata non è corretta. */
    PASSWORD_ERRATA,

    /** L'accesso è stato effettuato con successo da un utente con privilegi di amministratore. */
    SUCCESSO_ADMIN,

    /** L'accesso è stato effettuato con successo da un utente non amministratore. */
    SUCCESSO,

    /** Si è verificato un errore durante il tentativo di accesso al sistema di login. */
    ERRORE
}