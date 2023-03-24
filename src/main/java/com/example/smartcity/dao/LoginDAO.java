
package com.example.smartcity.dao;


import com.example.smartcity.model.AccessoLogin;
import com.example.smartcity.model.UsersBean;
import com.example.smartcity.service.AuthService;
import com.example.smartcity.handler.Handler;
import com.example.smartcity.handler.MailHandler;
import com.example.smartcity.handler.PasswordHandler;
import com.example.smartcity.handler.RoleHandler;


import java.sql.*;

public class LoginDAO {
    private static LoginDAO istanza;
    private static final String url = "jdbc:mysql://localhost:3306/smartcity";
    private static Connection con;
    private LoginDAO(){

    }

    public static LoginDAO getIstanza(){
        if (istanza == null){
            istanza = new LoginDAO();
        }
        return istanza;
    }


    public static boolean controllaDB(String email, String password){
        try {
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("SELECT email, password FROM Utenti WHERE email = (?) AND password = (?)");
            stmt.setString(1, email);
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

    public static boolean controllaLogin(String email){
        try {
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("SELECT email  FROM Utenti WHERE email = (?)");
            stmt.setString(1, email);
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

    /*

    public AccessoLogin logIn(String email, String password){
        LoginDAO users = LoginDAO.getIstanza();
        Handler handler = new MailHandler(users);
        handler.setNextHandler(new PasswordHandler(users)).setNextHandler(new RoleHandler());


        AuthService authService = new AuthService(handler);
        return authService.logIn(email, password);
    }

    */


    public UsersBean getUserBean(String email) {
        UsersBean usersBean = new UsersBean();
        try {
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Utenti WHERE email = (?)");
            stmt.setString(1, email);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                usersBean.setNome(result.getString("nome"));
                usersBean.setCognome(result.getString("cognome"));
                usersBean.setEmail(result.getString("email"));
                usersBean.setPassword(result.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usersBean;
    }



    //Registrazione
    public boolean addUtente(UsersBean usersBean) {
        try {
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("SELECT email FROM Utenti WHERE (?)");
            stmt.setString(1, usersBean.getEmail());
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return false;
            } else {
                PreparedStatement query = con.prepareStatement("INSERT INTO Utenti (nome, cognome, email, password) VALUES(?, ?, ?, ?)");
                query.setString(1, usersBean.getNome());
                query.setString(2, usersBean.getCognome());
                query.setString(3, usersBean.getEmail());
                query.setString(4, usersBean.getPassword());
                query.execute();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;

    }
}