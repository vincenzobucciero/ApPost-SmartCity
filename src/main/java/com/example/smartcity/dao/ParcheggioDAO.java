package com.example.smartcity.dao;

import com.example.smartcity.model.ParcheggioBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParcheggioDAO {
    private static ParcheggioDAO istanza;
    private final String url = "jdbc:mysql://localhost:3306/smartcity";

    Connection con;

    private ParcheggioDAO() {
    }

    public static ParcheggioDAO getIstanza() {
        if (istanza == null) {
            istanza = new ParcheggioDAO();
        }
        return istanza;
    }

    public List<ParcheggioBean> getParkings(){
        List<ParcheggioBean> list = new ArrayList<ParcheggioBean>();

        try{
            con = DriverManager.getConnection(url, "vincenzo", "vincenzo");
            PreparedStatement stmt = con.prepareStatement("SELECT ID_parcheggio, nomeParcheggio, indirizzo, numPosti FROM Parcheggio ");
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                ParcheggioBean ParcheggioBean = new ParcheggioBean();
                ParcheggioBean.setIdParcheggio(resultSet.getInt(1));
                ParcheggioBean.setNomeParcheggio(resultSet.getString(2));
                ParcheggioBean.setIndirizzo(resultSet.getString(3));
                ParcheggioBean.setNumPosti(resultSet.getInt(4));
                list.add(ParcheggioBean);
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
}
