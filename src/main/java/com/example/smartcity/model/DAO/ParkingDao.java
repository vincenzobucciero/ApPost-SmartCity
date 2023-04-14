package com.example.smartcity.model.DAO;
import com.example.smartcity.model.Bean.ParkingBean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParkingDao {
    public static List<ParkingBean> getListParking() {
        PreparedStatement stmt = null;
        ResultSet result = null;
        List<ParkingBean> list = new ArrayList<ParkingBean>();
        try{
            stmt = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT *  FROM Parcheggio ");
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                ParkingBean parkingBean = new ParkingBean();
                parkingBean.setNomeParcheggio(resultSet.getString(1));
                parkingBean.setIndirizzo(resultSet.getString(2));
                parkingBean.setTariffaAF(resultSet.getDouble(3));
                parkingBean.setTariffaM(resultSet.getDouble(4));
                parkingBean.setPostiAuto(resultSet.getInt(5));
                parkingBean.setPostiFurgone(resultSet.getInt(6));
                parkingBean.setPostiMoto(resultSet.getInt(7));

                list.add(parkingBean);
            }
            return list;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
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


    public static ParkingBean getParkingBean(String nomeParcheggio){
        ParkingBean parkingBean = new ParkingBean();
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT * " +
                    "FROM Parcheggio " +
                    "WHERE nomeParcheggio = (?) ");
            stmt.setString(1, nomeParcheggio);
            result = stmt.executeQuery();
            if (result.next()) {
                parkingBean.setNomeParcheggio(result.getString("nomeParcheggio"));
                parkingBean.setIndirizzo(result.getString("indirizzo"));
                parkingBean.setTariffaAF(result.getDouble("tariffaAF"));
                parkingBean.setTariffaM(result.getDouble("tariffaM"));
                parkingBean.setPostiAuto(result.getInt("postiAuto"));
                parkingBean.setPostiFurgone(result.getInt("postiFurgone"));
                parkingBean.setPostiMoto(result.getInt("postiMoto"));
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
        return parkingBean;
    }

    public static double getStatisticheAccessi(String nome, String tipoVeicolo, String mese, String settimana) {
        double countStat = 0;
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT count(*)/7 numeroPrenotati " +
                    "FROM Prenotazione " +
                    "WHERE tipoVeicolo = (?) and " +
                    "      nomeParcheggio = (?) and " +
                    "      YEAR(data_prenotazione) = YEAR(CURDATE()) and " +
                    "      MONTH(data_prenotazione) = (?) and " +
                    "      WEEK(data_prenotazione) - WEEK(DATE_FORMAT(data_prenotazione,'%Y-%m-01')) + 1 = (?)" +
                    "GROUP BY tipoVeicolo");
            stmt.setString(1, tipoVeicolo);
            stmt.setString(2, nome);
            stmt.setString(3, mese);
            stmt.setString(4, settimana);
            result = stmt.executeQuery();
            if (result.next()) {
                countStat = result.getDouble("numeroPrenotati");
                System.out.println(" " + countStat);
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
        return countStat;
    }


    public static double getStatisticheOre(String nome, String tipoVeicolo, String mese, String settimana) {
        double countStat = 0;
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT SUM(TIME_TO_SEC(TIMEDIFF(orario_fine, orario_inizio))/3600) orePark  " +
                    "FROM Prenotazione " +
                    "WHERE tipoVeicolo = (?) and " +
                    "      nomeParcheggio = (?) and " +
                    "      YEAR(data_prenotazione) = YEAR(CURDATE()) and " +
                    "      MONTH(data_prenotazione) = (?) and " +
                    "      WEEK(data_prenotazione) - WEEK(DATE_FORMAT(data_prenotazione,'%Y-%m-01')) + 1 = (?)");
            stmt.setString(1, tipoVeicolo);
            stmt.setString(2, nome);
            stmt.setString(3, mese);
            stmt.setString(4, settimana);
            result = stmt.executeQuery();
            if (result.next()) {
                countStat = result.getDouble("orePark");
                System.out.println(" " + countStat);
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
        return countStat;
    }

}