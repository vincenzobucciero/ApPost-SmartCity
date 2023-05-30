package com.example.smartcity.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * La classe DatabaseConnection rappresenta una connessione al database MySQL usato dall'applicazione.
 * Utilizza il design pattern Singleton per garantire una sola istanza della connessione
 * nel corso dell'esecuzione dell'applicazione. La connessione viene creata nel costruttore
 * della classe, utilizzando il driver MySQL e le credenziali di accesso al database specificate.
 */
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;


    /**
     * Costruttore privato della classe che crea la connessione al database utilizzando
     * il driver MySQL e le credenziali di accesso specificate.
     * In caso di errori durante la creazione della connessione, viene sollevata un'eccezione SQLException.
     */
    private DatabaseConnection() throws SQLException {
        try {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            String url = "jdbc:mysql://127.0.0.1:3306/smartCity";
            this.connection = DriverManager.getConnection( url, "root", "password");
        } catch ( ClassNotFoundException ex ) {
            System.out.println( "Database Connection Creation Failed : " + ex.getMessage() );
        }
    }

    /**
     * Metodo pubblico che restituisce l'oggetto Connection della connessione al database.
     * @return l'oggetto Connection della connessione al database
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Metodo pubblico che restituisce l'unica istanza di DatabaseConnection, utilizzando il design pattern Singleton.
     * Se l'istanza non è stata ancora creata, viene creata.
     * In caso di errori durante la creazione della connessione, viene sollevata un'eccezione SQLException.
     *
     * @return l'unica istanza di DatabaseConnection
     */
    public static DatabaseConnection getInstance() throws SQLException {
        if ( instance == null ) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}