package com.example.smartcity.model;

import java.sql.*;

public class ModifyUserDao {

    private static ModifyUserDao istanza;
    private static final String url = "jdbc:mysql://localhost:3306/smartcity";
    private static Connection con;

    private ModifyUserDao() {
    }

    public static ModifyUserDao getIstanza() {
        if (istanza == null) {
            istanza = new ModifyUserDao();
        }
        return istanza;
    }

    public void modifyNome(String email, String nome) {
        try {
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("UPDATE Utenti SET nome=(?) WHERE email = (?)");
            stmt.setString(1, nome);
            stmt.setString(2, email);
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

    public void modifyCognome(String email, String cognome) {
        try {
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("UPDATE Utenti SET cognome=(?) WHERE email = (?)");
            stmt.setString(1, cognome);
            stmt.setString(2, email);
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

    public void modifyEmail(String email, String newEmail) {
        try {
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("UPDATE Utenti SET email=(?) WHERE email = (?)");
            stmt.setString(1, newEmail);
            stmt.setString(2, email);
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


    public void modifyPassword(String email, String password) {
        try {
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("UPDATE Utenti SET password=(?) WHERE email = (?)");
            stmt.setString(1, password);
            stmt.setString(2, email);
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