package com.example.smartcity.model.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * La classe ModifyDao contiene metodi statici per la modifica delle informazioni relative
 * a un parcheggio presente nel database.
 */
public class ModifyDao {

    /**
     * Modifica la tariffa per i posti auto/furgone di un parcheggio nel database.
     *
     * @param nomeParcheggio nome del parcheggio da modificare
     * @param tariffa nuova tariffa per i posti auto/furgone
     * @throws SQLException errore generico
     */
    public static void modifyTariffaAF(String nomeParcheggio, double tariffa) {
        PreparedStatement stmt = null;
        try {
            stmt = DatabaseConnection.getInstance().getConnection().prepareStatement("UPDATE Parcheggio SET tariffaAF=(?) " +
                    "WHERE nomeParcheggio = (?)");
            stmt.setDouble(1, tariffa);
            stmt.setString(2, nomeParcheggio);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                if ( stmt != null ) {
                    stmt.close();
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }



    /**
     * Modifica la tariffa per i posti moto di un parcheggio nel database.
     *
     * @param nomeParcheggio nome del parcheggio da modificare
     * @param tariffa nuova tariffa per i posti moto
     * @throws SQLException errore generico
     */
    public static void modifyTariffaM(String nomeParcheggio, double tariffa) {
        PreparedStatement stmt = null;
        try {
            stmt = DatabaseConnection.getInstance().getConnection().prepareStatement("UPDATE Parcheggio SET tariffaM=(?) " +
                    "WHERE nomeParcheggio = (?)");
            stmt.setDouble(1, tariffa);
            stmt.setString(2, nomeParcheggio);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                if (stmt!=null)
                    stmt.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }


    /**
     * Modifica l'indirizzo di un parcheggio nel database.
     *
     * @param nomeParcheggio nome del parcheggio da modificare
     * @param indirizzo nuovo indirizzo del parcheggio
     * @throws SQLException errore generico
     */
    public static void modifyIndirizzo(String nomeParcheggio, String indirizzo) {
        PreparedStatement stmt = null;
        try {
            stmt = DatabaseConnection.getInstance().getConnection().prepareStatement("UPDATE Parcheggio SET indirizzo=(?) " +
                    "WHERE nomeParcheggio = (?)");
            stmt.setString(1, indirizzo);
            stmt.setString(2, nomeParcheggio);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                if (stmt!=null)
                    stmt.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }


    /**
     * Modifica il numero di posti auto di un parcheggio nel database.
     *
     * @param nomeParcheggio nome del parcheggio da modificare
     * @param numPostiAuto nuovo numero di posti auto del parcheggio
     * @throws SQLException errore generico
     */
    public static void modifyPostiAuto(String nomeParcheggio, int numPostiAuto) {
        PreparedStatement stmt = null;
        try {
            stmt = DatabaseConnection.getInstance().getConnection().prepareStatement("UPDATE Parcheggio SET postiAuto=(?) " +
                    "WHERE nomeParcheggio = (?)");
            stmt.setInt(1, numPostiAuto);
            stmt.setString(2, nomeParcheggio);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                if (stmt!=null)
                    stmt.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }


    /**
     * Modifica il numero di posti furgone di un parcheggio nel database.
     *
     * @param nomeParcheggio nome del parcheggio da modificare
     * @param numPostiFurgone nuovo numero di posti furgone del parcheggio
     * @throws SQLException errore generico
     */
    public static void modifyPostiFurgone(String nomeParcheggio, int numPostiFurgone){
        PreparedStatement stmt = null;
        try {
            stmt = DatabaseConnection.getInstance().getConnection().prepareStatement("UPDATE Parcheggio SET postiFurgone=(?) " +
                    "WHERE nomeParcheggio = (?)");
            stmt.setInt(1, numPostiFurgone);
            stmt.setString(2, nomeParcheggio);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                if (stmt!=null)
                    stmt.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }



    /**
     * Modifica il numero di posti moto di un parcheggio nel database.
     *
     * @param nomeParcheggio nome del parcheggio da modificare
     * @param numPostiMoto nuovo numero di posti moto del parcheggio
     * @throws SQLException errore generico
     */
    public static void modifyPostiMoto(String nomeParcheggio, int numPostiMoto) {
        PreparedStatement stmt = null;
        try {
            stmt = DatabaseConnection.getInstance().getConnection().prepareStatement("UPDATE Parcheggio SET postiMoto=(?) " +
                    "WHERE nomeParcheggio = (?)");
            stmt.setInt(1, numPostiMoto);
            stmt.setString(2, nomeParcheggio);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                if (stmt!=null)
                    stmt.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

}