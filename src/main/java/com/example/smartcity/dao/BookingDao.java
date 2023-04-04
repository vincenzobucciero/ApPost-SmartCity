package com.example.smartcity.dao;

import com.example.smartcity.model.BookingBean;

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

    public void addBooking(BookingBean bookingBean) {
        try {
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement query = con.prepareStatement("INSERT INTO Prenotazione (data_prenotazione, orario_inizio, orario_fine, targaVeicolo, tipoVeicolo, email) " +
                    "VALUES(?, ?, ?, ?, ?, ?)");
            query.setString(1, bookingBean.getData_prenotazione());
            query.setString(2, bookingBean.getOrario_inizio());
            query.setString(3, bookingBean.getOrario_fine());
            query.setString(4, bookingBean.getTargaVeicolo());
            query.setString(5, bookingBean.getTipoVeicolo());
            query.setString(6, bookingBean.getEmail());
            query.execute();

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
    }




}