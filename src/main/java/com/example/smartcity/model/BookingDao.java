package com.example.smartcity.model;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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
            PreparedStatement query = con.prepareStatement("INSERT INTO Prenotazione (Id_prenotazione, data_prenotazione, orario_inizio, orario_fine, targa_veicolo, tipoVeicolo, email, prezzo, pagamento) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            query.setString(1, bookingBean.getID_prenotazione());
            query.setString(2, bookingBean.getData_prenotazione());
            query.setString(3, bookingBean.getOrario_inizio());
            query.setString(4, bookingBean.getOrario_fine());
            query.setString(5, bookingBean.getTargaVeicolo());
            query.setString(6, bookingBean.getTipoVeicolo());
            query.setString(7, bookingBean.getEmail());
            query.setDouble(8, bookingBean.getPrezzo());
            query.setString(9, bookingBean.getPagamento());

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


    //ritorna tutte le prenotazioni fatte nel tempo da un certo utente
    public List<BookingBean> getBooking(String email){

        List<BookingBean> list = new ArrayList<BookingBean>();

        try {
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Prenotazione WHERE email = (?) ");
            stmt.setString(1, email);
            ResultSet result = stmt.executeQuery();
            list = new ArrayList<>();
            while (result.next()) {
                BookingBean bookingBean = new BookingBean();
                bookingBean.setID_prenotazione(result.getString("Id_prenotazione"));
                bookingBean.setData_prenotazione(result.getString("data_prenotazione"));
                bookingBean.setOrario_inizio(result.getString("orario_inizio"));
                bookingBean.setOrario_fine(result.getString("orario_fine"));
                bookingBean.setTargaVeicolo(result.getString("targaVeicolo"));
                bookingBean.setTipoVeicolo(result.getString("tipoVeicolo"));
                bookingBean.setEmail(result.getString("email"));
                bookingBean.setPrezzo(result.getDouble("prezzo"));
                bookingBean.setPagamento(result.getString("pagamento"));

                //System.out.println(bookingBean.getID_prenotazione() + " "+ bookingBean.getData_prenotazione());

                list.add(bookingBean);

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

        return list;
    }



    //ritorna una specifica prenotazione
    public BookingBean getBookingBean(int id){
        BookingBean bookingBean = new BookingBean();
        try {
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Prenotazione WHERE Id_prenotazione = (?) ");
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                bookingBean.setID_prenotazione(result.getString("Id_prenotazione"));
                bookingBean.setData_prenotazione(result.getString("data_prenotazione"));
                bookingBean.setOrario_inizio(result.getString("orario_inizio"));
                bookingBean.setOrario_fine(result.getString("orario_fine"));
                bookingBean.setTargaVeicolo(result.getString("targaVeicolo"));
                bookingBean.setTipoVeicolo(result.getString("tipoVeicolo"));
                bookingBean.setEmail(result.getString("email"));
                bookingBean.setPrezzo(result.getDouble("prezzo"));
                bookingBean.setPagamento(result.getString("pagamento"));
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
        return bookingBean;
    }
}
