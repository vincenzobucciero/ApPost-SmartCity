package com.example.smartcity.service;

import com.example.smartcity.dao.ModifyDAO;

public class ModifyService {
    public static void modifyTariffa(int id, double tariffa){
        ModifyDAO.getIstanza().modifyTariffa(id,tariffa);
    }

    public static void modifyNome(int id, String nome){ ModifyDAO.getIstanza().modifyNome(id, nome);}

    public static void modifyIndirizzo(int id, String indirizzo){ModifyDAO.getIstanza().modifyIndirizzo(id, indirizzo);}

    public static void modifyNumPosti(int id, int numPosti){ModifyDAO.getIstanza().modifyNumPosti(id, numPosti);}
}
