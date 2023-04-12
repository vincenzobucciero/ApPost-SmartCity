package com.example.smartcity.model;

import java.sql.*;

public class ModifyDao {

    private static ModifyDao istanza;
    private final String url = "jdbc:mysql://localhost:3306/smartcity";

    Connection con;
    private ModifyDao(){}
    public static ModifyDao getIstanza(){
        if (istanza == null){
            istanza = new ModifyDao();
        }
        return istanza;
    }

    public void modifyTariffaAF(String nomeParcheggio, double tariffa) {
        try {
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("UPDATE Parcheggio SET tariffaAF=(?) WHERE nomeParcheggio = (?)");
            stmt.setDouble(1, tariffa);
            stmt.setString(2, nomeParcheggio);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }  finally {
            try{
                if (con!=null)
                    con.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void modifyTariffaM(String nomeParcheggio, double tariffa) {
        try {
            
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("UPDATE Parcheggio SET tariffaM=(?) WHERE nomeParcheggio = (?)");
            stmt.setDouble(1, tariffa);
            stmt.setString(2, nomeParcheggio);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }  finally {
            try{
                if (con!=null)
                    con.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    /*public void modifyNome(int id, String nome) {
        try {
            
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("UPDATE Parcheggio SET nomeParcheggio=(?) WHERE ID_parcheggio = (?)");
            stmt.setString(1, nome);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }  finally {
            try{
                if (con!=null)
                    con.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }*/

    public void modifyIndirizzo(String nomeParcheggio, String indirizzo) {
        try {
            
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("UPDATE Parcheggio SET indirizzo=(?) WHERE nomeParcheggio = (?)");
            stmt.setString(1, indirizzo);
            stmt.setString(2, nomeParcheggio);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }  finally {
            try{
                if (con!=null)
                    con.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void modifyPostiAuto(String nomeParcheggio, int numPostiAuto) {
        try {
            
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("UPDATE Parcheggio SET postiAuto=(?) WHERE nomeParcheggio = (?)");
            stmt.setInt(1, numPostiAuto);
            stmt.setString(2, nomeParcheggio);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }  finally {
            try{
                if (con!=null)
                    con.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }



    public void modifyPostiFurgone(String nomeParcheggio, int numPostiFurgone) {
        try {
            
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("UPDATE Parcheggio SET postiFurgone=(?) WHERE nomeParcheggio = (?)");
            stmt.setInt(1, numPostiFurgone);
            stmt.setString(2, nomeParcheggio);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }  finally {
            try{
                if (con!=null)
                    con.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }



    public void modifyPostiMoto(String nomeParcheggio, int numPostiMoto) {
        try {
            
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("UPDATE Parcheggio SET postiMoto=(?) WHERE nomeParcheggio = (?)");
            stmt.setInt(1, numPostiMoto);
            stmt.setString(2, nomeParcheggio);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }  finally {
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