package com.example.smartcity.service;

import com.example.smartcity.dao.ParcheggioDAO;
import com.example.smartcity.model.ParcheggioBean;

import java.util.List;

public class ParcheggioService {
    public static List<ParcheggioBean> getAllParkings() {
        ParcheggioDAO parcheggioDAO = ParcheggioDAO.getIstanza();

        return ParcheggioDAO.getIstanza().getParkings();
    }

        public static void modifyTariffa(int id, double tariffa){
            ParcheggioDAO.getIstanza().modifyTariffa(id,tariffa);
        }
}

