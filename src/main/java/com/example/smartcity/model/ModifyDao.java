package com.example.smartcity.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModifyDao {

    private static ModifyDao istanza;
    private static final String url = "jdbc:mysql://127.0.0.1:3306/SmartCity";
    private static Connection con;

    private ModifyDao() {
    }

    public static ModifyDao getIstanza() {
        if (istanza == null) {
            istanza = new ModifyDao();
        }
        return istanza;
    }

    public void modifyTariffaAF(int id, double tariffa) {
        try {
            con = DriverManager.getConnection(url, "camilla", "camilla");
            PreparedStatement stmt = con.prepareStatement("UPDATE Parcheggio SET tariffaAF=(?) WHERE ID_parcheggio = (?)");
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

    public void modifyTariffaM(int id, double tariffa) {
        try {
            con = DriverManager.getConnection(url, "camilla", "camilla");
            PreparedStatement stmt = con.prepareStatement("UPDATE Parcheggio SET tariffaM=(?) WHERE ID_parcheggio = (?)");
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
            con = DriverManager.getConnection(url, "camilla", "camilla");
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
            con = DriverManager.getConnection(url, "camilla", "camilla");
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

    public void modifyPostiAuto(int id, int numPostiAuto) {
        try {
            con = DriverManager.getConnection(url, "camilla", "camilla");
            PreparedStatement stmt = con.prepareStatement("UPDATE Parcheggio SET postiAuto=(?) WHERE ID_parcheggio = (?)");
            stmt.setInt(1, numPostiAuto);
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


    public void modifyPostiFurgone(int id, int numPostiFurgone) {
        try {
            con = DriverManager.getConnection(url, "camilla", "camilla");
            PreparedStatement stmt = con.prepareStatement("UPDATE Parcheggio SET postiFurgone=(?) WHERE ID_parcheggio = (?)");
            stmt.setInt(1, numPostiFurgone);
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



    public void modifyPostiMoto(int id, int numPostiMoto) {
        try {
            con = DriverManager.getConnection(url, "camilla", "camilla");
            PreparedStatement stmt = con.prepareStatement("UPDATE Parcheggio SET postiMoto=(?) WHERE ID_parcheggio = (?)");
            stmt.setInt(1, numPostiMoto);
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