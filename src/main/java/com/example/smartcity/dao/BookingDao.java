package com.example.smartcity.dao;

import com.example.smartcity.model.UsersBean;

import java.sql.*;

public class BookingDao {
    private static BookingDao istanza;
    private static final String url = "jdbc:mysql://localhost:3306/smartcity";
    private static Connection con;

    private BookingDao() {

    }

    public static BookingDao getIstanza() {
        if (istanza == null) {
            istanza = new BookingDao();
        }
        return istanza;
    }

    public boolean addBooking(UsersBean usersBean) {
        try {
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("SELECT email FROM Utenti WHERE email = (?) ");
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