
package com.example.smartcity.model;


import com.example.smartcity.service.AuthService;
import com.example.smartcity.handler.Handler;
import com.example.smartcity.handler.MailHandler;
import com.example.smartcity.handler.PasswordHandler;
import com.example.smartcity.handler.RoleHandler;

import java.sql.*;

public class DB {
    private static DB istanza;
    private final String url = "jdbc:mysql://localhost:3306/smartcity";
    Connection con;
    private DB(){}
    public static DB getIstanza(){
        if (istanza == null){
            istanza = new DB();
        }
        return istanza;
    }


    public boolean controllaDB(String username, String password){
        try {
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("SELECT email, password FROM Utenti WHERE email = (?) AND password = (?)");
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet result = stmt.executeQuery();
            return result.next();
        }
        catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if (con!=null)
                    con.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean controllaLogin(String username){
        try {
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("SELECT email  FROM Utenti WHERE email = (?)");
            stmt.setString(1, username);
            ResultSet result = stmt.executeQuery();
            return result.next();
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
        return false;
    }

    public AccessoLogin logIn(String mail, String password){
        DB users = DB.getIstanza();
        Handler handler = new MailHandler(users);
        handler.setNextHandler(new PasswordHandler(users)).setNextHandler(new RoleHandler());


        AuthService authService = new AuthService(handler);
        return authService.logIn(mail,password);
    }


    //Registrazione
    public boolean addUtente(String nome, String cognome, String email, String password)
    {
        try {
            con = DriverManager.getConnection(url,"vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("SELECT email FROM Utenti WHERE (?)");
            stmt.setString(1,email);
            ResultSet result = stmt.executeQuery();
            if (result.next()){
                return false;
            }else {
                PreparedStatement query = con.prepareStatement("INSERT INTO Utenti (nome, cognome, email,password) VALUES(?, ?, ?, ?)");
                query.setString(1,nome);
                query.setString(2,cognome);
                query.setString(3, email);
                query.setString(4, password);
                query.execute();
                return true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                if (con!=null)
                    con.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        return false;

    }
}