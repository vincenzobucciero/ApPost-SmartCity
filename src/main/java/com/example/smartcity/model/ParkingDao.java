package com.example.smartcity.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParkingDao {

    private static ParkingDao istanza;
    private final String url = "jdbc:mysql://localhost:3306/smartcity";

    Connection con;
    private ParkingDao(){}
    public static ParkingDao getIstanza(){
        if (istanza == null){
            istanza = new ParkingDao();
        }
        return istanza;
    }

    public List<ParkingBean> getParkings(){
        List<ParkingBean> list = new ArrayList<ParkingBean>();

        try{
             
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("SELECT nomeParcheggio, indirizzo, tariffaAF, tariffaM, postiAuto, postiFurgone, postiMoto  FROM Parcheggio ");
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
        } finally {
            try {
                if(con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public ParkingBean getParkingBean(String nomeParcheggio){
        ParkingBean parkingBean = new ParkingBean();
        try {
             
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Parcheggio WHERE nomeParcheggio = (?) ");
            stmt.setString(1, nomeParcheggio);
            ResultSet result = stmt.executeQuery();
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