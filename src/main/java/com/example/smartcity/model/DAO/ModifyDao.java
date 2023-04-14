package com.example.smartcity.model.DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModifyDao {
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