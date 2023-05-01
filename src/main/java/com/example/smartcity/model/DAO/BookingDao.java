package com.example.smartcity.model.DAO;

import com.example.smartcity.model.Bean.BookingBean;
import com.example.smartcity.service.CommandPrezzo.VeicoliEnum;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;

public class BookingDao {
    public static void addBooking(BookingBean bookingBean) {
        PreparedStatement query = null;
        try {
            query = DatabaseConnection.getInstance().getConnection().prepareStatement("INSERT INTO Prenotazione (Id_prenotazione, data_prenotazione, orario_inizio, orario_fine, targaVeicolo, tipoVeicolo, email, prezzo, pagamento, nomeParcheggio) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            query.setString(1, bookingBean.getID_prenotazione());
            query.setString( 2, bookingBean.getData_prenotazione() );
            query.setString(3, bookingBean.getOrario_inizio());
            query.setString(4, bookingBean.getOrario_fine());
            query.setString(5, bookingBean.getTargaVeicolo());
            query.setString(6, String.valueOf(bookingBean.getTipoVeicolo()));
            query.setString(7, bookingBean.getEmail());
            query.setDouble(8, bookingBean.getPrezzo());
            query.setString(9, bookingBean.getPagamento());
            query.setString(10, bookingBean.getNomeParcheggio());

            query.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if (query!=null)
                    query.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    //ritorna tutte le prenotazioni fatte nel tempo da un certo utente
    public static List<BookingBean> getBooking(String email){
        PreparedStatement stmt = null;
        ResultSet result = null;
        List<BookingBean> list = new ArrayList<BookingBean>();
        try {
            stmt = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT * " +
                    "FROM Prenotazione " +
                    "WHERE email = (?) ");
            stmt.setString(1, email);
            result = stmt.executeQuery();
            list = new ArrayList<>();
            while (result.next()) {
                BookingBean bookingBean = new BookingBean();
                bookingBean.setID_prenotazione(result.getString("Id_prenotazione"));
                bookingBean.setData_prenotazione(result.getString("data_prenotazione"));
                bookingBean.setOrario_inizio(result.getString("orario_inizio"));
                bookingBean.setOrario_fine(result.getString("orario_fine"));
                bookingBean.setTargaVeicolo(result.getString("targaVeicolo"));
                bookingBean.setTipoVeicolo(VeicoliEnum.valueOf(result.getString("tipoVeicolo")));
                bookingBean.setEmail(result.getString("email"));
                bookingBean.setPrezzo(result.getDouble("prezzo"));
                bookingBean.setPagamento(result.getString("pagamento"));
                bookingBean.setNomeParcheggio(result.getString("nomeParcheggio"));

                list.add(bookingBean);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if (stmt!=null)
                    stmt.close();

                if ( result != null ) {
                    result.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }


    public static void deleteBooking(String idPrenotazione){
        PreparedStatement stmt = null;
        try {
            stmt = DatabaseConnection.getInstance().getConnection().prepareStatement("DELETE FROM Prenotazione " +
                    "WHERE Id_prenotazione = (?)");
            stmt.setString(1,idPrenotazione);
            stmt.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if (stmt!=null)
                    stmt.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static double getTotPrice(double price, BookingBean bookingBean){
        String oraInizio = bookingBean.getOrario_inizio();
        String oraFine = bookingBean.getOrario_fine();

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");

        Date inizio;
        Date fine;
        double tot;
        try {
            inizio = formatter.parse(oraInizio);
            fine = formatter.parse(oraFine);

            Calendar inizioDate = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"), Locale.ITALY);
            Calendar fineDate = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"), Locale.ITALY);
            inizioDate.setTime(inizio);
            fineDate.setTime(fine);

            double ore = fineDate.get(HOUR_OF_DAY) - inizioDate.get(HOUR_OF_DAY);
            double minuti = (double)(fineDate.get(MINUTE) - inizioDate.get(MINUTE))/60;


            if(minuti > 0){
                tot = price*ore + price;
            }
            else if (ore > 5){
                tot = 20.00;
            }
            else{
                tot = price*ore;
            }

            System.out.println("totale: " + tot);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        return tot;
    }


    public static List<BookingBean> getListBooking(){
        PreparedStatement stmt = null;
        ResultSet result = null;
        List<BookingBean> list = new ArrayList<BookingBean>();
        try {
            stmt = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Prenotazione ");
            result = stmt.executeQuery();
            list = new ArrayList<>();
            while (result.next()) {
                BookingBean bookingBean = new BookingBean();
                bookingBean.setID_prenotazione(result.getString(1));
                bookingBean.setData_prenotazione(result.getString(2));
                bookingBean.setOrario_inizio(result.getString(3));
                bookingBean.setOrario_fine(result.getString(4));
                bookingBean.setEmail(result.getString(5));
                bookingBean.setTargaVeicolo(result.getString(6));
                bookingBean.setTipoVeicolo(VeicoliEnum.valueOf(result.getString(7)));
                bookingBean.setPrezzo(result.getDouble(8));
                bookingBean.setPagamento(result.getString(9));
                bookingBean.setNomeParcheggio(result.getString(10));

                list.add(bookingBean);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if (stmt!=null)
                    stmt.close();

                if ( result != null ) {
                    result.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}