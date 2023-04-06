package com.example.smartcity.service;

import com.example.smartcity.model.ModifyDao;
import com.example.smartcity.model.ParkingDao;

public class ModifyService {
    public static void modifyTariffaAF(int id, double tariffa){
        ModifyDao.getIstanza().modifyTariffaAF(id,tariffa);
    }
    public static void modifyTariffaM(int id, double tariffa){
        ModifyDao.getIstanza().modifyTariffaM(id,tariffa);
    }

    public static void modifyNome(int id, String nome){ ModifyDao.getIstanza().modifyNome(id, nome);}

    public static void modifyIndirizzo(int id, String indirizzo){ModifyDao.getIstanza().modifyIndirizzo(id, indirizzo);}

    public static void modifyPostiAuto(int id, int numPosti){ModifyDao.getIstanza().modifyPostiAuto(id, numPosti);}

    public static void modifyPostiFurgone(int id, int numPosti){ModifyDao.getIstanza().modifyPostiFurgone(id, numPosti);}
    public static void modifyPostiMoto(int id, int numPosti){ModifyDao.getIstanza().modifyPostiMoto(id, numPosti);}



}