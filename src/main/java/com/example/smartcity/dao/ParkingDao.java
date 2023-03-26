package com.example.smartcity.dao;

import com.example.smartcity.model.ParkingBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParkingDao {
    private static ParkingDao istanza;
    private final String url = "jdbc:mysql://localhost:3306/smartcity";

    Connection con;

    private ParkingDao() {
    }

    public static ParkingDao getIstanza() {
        if (istanza == null) {
            istanza = new ParkingDao();
        }
        return istanza;
    }

    public List<ParkingBean> getParkings(){
        List<ParkingBean> list = new ArrayList<ParkingBean>();

        try{
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("SELECT ID_parcheggio, nomeParcheggio, indirizzo, numPosti FROM Parcheggio ");
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                ParkingBean ParkingBean = new ParkingBean();
                ParkingBean.setIdParcheggio(resultSet.getInt(1));
                ParkingBean.setNomeParcheggio(resultSet.getString(2));
                ParkingBean.setIndirizzo(resultSet.getString(3));
                ParkingBean.setNumPosti(resultSet.getInt(4));
                list.add(ParkingBean);
            }
            return list;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public ParkingBean getparcheggioBean(int id){
        ParkingBean parkingBean = new ParkingBean();
        try {
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Parcheggio WHERE ID_parcheggio = (?) ");
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                parkingBean.setNomeParcheggio(result.getString("nomeParcheggio"));
                parkingBean.setIndirizzo(result.getString("indirizzo"));
                parkingBean.setTariffa(result.getDouble("tariffa"));
                parkingBean.setNumPosti(result.getInt("numPosti"));
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
        return parkingBean;
    }


}
