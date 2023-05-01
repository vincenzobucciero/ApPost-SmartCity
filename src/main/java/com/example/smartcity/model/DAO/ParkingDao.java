package com.example.smartcity.model.DAO;
import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.service.CommandPrezzo.VeicoliEnum;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * La classe ParkingDao gestisce l'accesso ai dati dei parcheggi del sistema,
 * recuperandoli dal database.
 */
public class ParkingDao {


    /**
     * Metodo che restituisce la lista di tutti i parcheggi presenti nel sistema.
     * @return lista di tutti i parcheggi presenti nel sistema
     */
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


    /**
     * Metodo che restituisce un oggetto ParkingBean relativo al parcheggio con il nome specificato.
     * @param nomeParcheggio nome del parcheggio di cui si vuole ottenere le informazioni
     * @return oggetto ParkingBean relativo al parcheggio con il nome specificato
     */
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



    /**
     * Restituisce il numero di prenotazioni effettuate per un determinato parcheggio,
     * di un certo tipo di veicolo, in una determinata settimana di un certo mese dell'anno corrente.
     * Il risultato è dato dalla media del numero di prenotazioni effettuate in ciascuno dei sette giorni della settimana specificata.
     * @param nome il nome del parcheggio di cui si vogliono ottenere le statistiche di accesso
     * @param tipoVeicolo il tipo di veicolo per cui si vogliono ottenere le statistiche di accesso
     * @param mese il mese per cui si vogliono ottenere le statistiche di accesso
     * @param settimana il numero della settimana per cui si vogliono ottenere le statistiche di accesso
     * @return la media del numero di prenotazioni effettuate per il tipo di veicolo specificato nel parcheggio specificato
     * durante la settimana e il mese specificati
     * @throws SQLException se si verifica un errore durante l'accesso al database
     */
    public static double getStatisticheAccessi(String nome, VeicoliEnum tipoVeicolo, int mese, int settimana) {
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
            stmt.setString(1, String.valueOf(tipoVeicolo));
            stmt.setString(2, nome);
            stmt.setInt(3, mese);
            stmt.setInt(4, settimana);
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



    /**
     * Questo metodo restituisce il numero di ore totali di parcheggio per un determinato parcheggio,
     * veicolo, mese e settimana.
     * @param nome Il nome del parcheggio per il quale si vuole ottenere la statistica delle ore di parcheggio.
     * @param tipoVeicolo Il tipo di veicolo (auto o moto) per il quale si vuole ottenere la statistica delle ore di parcheggio.
     * @param mese Il numero del mese per il quale si vuole ottenere la statistica delle ore di parcheggio.
     * @param settimana Il numero della settimana nell'anno per la quale si vuole ottenere la statistica delle ore di parcheggio.
     * @return Il numero di ore totali di parcheggio per il parcheggio, il veicolo, il mese e la settimana specificati.
     */
    public static double getStatisticheOre(String nome, VeicoliEnum tipoVeicolo, int mese, int settimana) {
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
            stmt.setString(1, String.valueOf(tipoVeicolo));
            stmt.setString(2, nome);
            stmt.setInt(3, mese);
            stmt.setInt(4, settimana);
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