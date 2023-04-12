package com.example.smartcity.service;

import com.example.smartcity.model.ModifyDao;
import com.example.smartcity.model.ParkingDao;

public class ModifyService {
    public static void modifyTariffaAF(String nomeParcheggio, double tariffa){ModifyDao.getIstanza().modifyTariffaAF(nomeParcheggio,tariffa);}
    public static void modifyTariffaM(String nomeParcheggio, double tariffa){ModifyDao.getIstanza().modifyTariffaM(nomeParcheggio,tariffa);}
    public static void modifyIndirizzo(String nomeParcheggio, String indirizzo){ModifyDao.getIstanza().modifyIndirizzo(nomeParcheggio, indirizzo);}
    public static void modifyPostiAuto(String nomeParcheggio, int numPosti){ModifyDao.getIstanza().modifyPostiAuto(nomeParcheggio, numPosti);}
    public static void modifyPostiFurgone(String nomeParcheggio, int numPosti){ModifyDao.getIstanza().modifyPostiFurgone(nomeParcheggio, numPosti);}
    public static void modifyPostiMoto(String nomeParcheggio, int numPosti){ModifyDao.getIstanza().modifyPostiMoto(nomeParcheggio, numPosti);}

}