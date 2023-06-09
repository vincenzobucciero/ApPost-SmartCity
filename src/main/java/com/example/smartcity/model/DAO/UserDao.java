package com.example.smartcity.model.DAO;


import com.example.smartcity.model.Bean.UserBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Questa classe fornisce l'accesso ai dati degli utenti nel database.
 * Contiene metodi per controllare se una determinata email o una coppia email/password sono presenti nel database,
 * per ottenere un UserBean corrispondente a una determinata email, per aggiungere un nuovo utente al database
 * e per ottenere una lista di tutti gli utenti registrati nel database, a eccezione dell'utente amministratore.
 */
public class UserDao {

    /**
     * Controlla se un'email è presente nel database.
     *
     * @param email l'email da controllare
     * @return true se l'email è presente nel database, false altrimenti
     * @throws SQLException errore generico
     */
    public static boolean controllaEmail(String email){
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = DatabaseConnection.getInstance().getConnection().prepareStatement( "SELECT email " +
                    "FROM Utenti " +
                    "WHERE email = (?)");
            stmt.setString(1, email);
            result = stmt.executeQuery();
            return result.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if (stmt!=null)
                    stmt.close();

                if ( result != null ) {
                    result.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    /**
     * Controlla se una determinata coppia email/password è presente nel database.
     *
     * @param email l'email da controllare
     * @param password la password da controllare
     * @return true se la coppia email/password è presente nel database, false altrimenti
     * @throws SQLException errore generico
     */
    public static boolean controllaPassword(String email, String password){
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT email, password " +
                    "FROM Utenti " +
                    "WHERE email = (?) AND password = (?)");
            stmt.setString(1, email);
            stmt.setString(2, password);
            result = stmt.executeQuery();
            return result.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if (stmt!=null)
                    stmt.close();

                if ( result != null ) {
                    result.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Restituisce un UserBean corrispondente a una determinata email.
     *
     * @param email l'email dell'utente di cui si vuole ottenere il bean
     * @return il UserBean corrispondente all'email specificata, null se l'email non è presente nel database
     * @throws SQLException errore generico
     */
    public static UserBean getUserBean(String email){
        UserBean userBean = new UserBean();
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT * " +
                    "FROM Utenti " +
                    "WHERE email = (?) ");
            stmt.setString(1, email);
            result = stmt.executeQuery();
            if (result.next()) {
                userBean.setNome(result.getString("nome"));
                userBean.setCognome(result.getString("cognome"));
                userBean.setEmail(result.getString("email"));
                userBean.setPassword(result.getString("password"));
                userBean.setSesso(result.getString("sesso"));
                userBean.setTelefono(result.getString("telefono"));
                userBean.setDataNascita(result.getString("dataNascita"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if (stmt!=null)
                    stmt.close();

                if ( result != null ) {
                    result.close();
                }
            }
            catch (SQLException e) {

                e.printStackTrace();
            }
        }
        return userBean;
    }


    /**
     * Aggiunge una nuova registrazione utente al database, se non esiste già un utente con la stessa email.
     *
     * @param userBean l'oggetto UserBean contenente i dati dell'utente da registrare
     * @return true se la registrazione è stata aggiunta con successo, false se l'utente esiste già nel database
     * @throws SQLException errore generico
     */
    public static boolean addRegistrazione(UserBean userBean) {
        PreparedStatement stmt = null;
        PreparedStatement query = null;
        ResultSet result = null;
        try {
            stmt = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT email " +
                    "FROM Utenti " +
                    "WHERE email = (?) ");
            stmt.setString(1, userBean.getEmail());
            result = stmt.executeQuery();
            if (result.next()) {
                return false;
            } else {
                query = DatabaseConnection.getInstance().getConnection().prepareStatement("INSERT INTO Utenti (nome, cognome, email, password, sesso, telefono, dataNascita) " +
                        "VALUES(?, ?, ?, ?, ?, ?, ?)");
                query.setString(1, userBean.getNome());
                query.setString(2, userBean.getCognome());
                query.setString(3, userBean.getEmail());
                query.setString(4, userBean.getPassword());
                query.setString(5, userBean.getSesso());
                query.setString(6, userBean.getTelefono());
                query.setString(7, userBean.getDataNascita());
                query.execute();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if (stmt!=null)
                    stmt.close();

                if ( result != null ) {
                    result.close();
                }

                if ( query != null ){
                    query.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


}