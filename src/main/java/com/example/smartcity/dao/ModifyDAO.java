package com.example.smartcity.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModifyDAO {

    private static ModifyDAO istanza;
    private static final String url = "jdbc:mysql://localhost:3306/smartcity";
    private static Connection con;

    private ModifyDAO() {
    }

    public static ModifyDAO getIstanza() {
        if (istanza == null) {
            istanza = new ModifyDAO();
        }
        return istanza;
    }

    public void modifyTariffa(int id, double tariffa) {
        try {
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("UPDATE Parcheggio SET tariffa=(?) WHERE ID_parcheggio = (?)");
            stmt.setDouble(1, tariffa);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                if (con!=null)
                    con.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void modifyNome(int id, String nome) {
        try {
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("UPDATE Parcheggio SET nomeParcheggio=(?) WHERE ID_parcheggio = (?)");
            stmt.setString(1, nome);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                if (con!=null)
                    con.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void modifyIndirizzo(int id, String indirizzo) {
        try {
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("UPDATE Parcheggio SET indirizzo=(?) WHERE ID_parcheggio = (?)");
            stmt.setString(1, indirizzo);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                if (con!=null)
                    con.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void modifyNumPosti(int id, int numPosti) {
        try {
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("UPDATE Parcheggio SET numPosti=(?) WHERE ID_parcheggio = (?)");
            stmt.setDouble(1, numPosti);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                if (con!=null)
                    con.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

}