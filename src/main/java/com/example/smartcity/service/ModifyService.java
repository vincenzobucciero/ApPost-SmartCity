package com.example.smartcity.service;

import com.example.smartcity.dao.ModifyDao;

public class ModifyService {
    public static void modifyTariffa(int id, double tariffa){
        ModifyDao.getIstanza().modifyTariffa(id,tariffa);
    }

    public static void modifyNome(int id, String nome){ ModifyDao.getIstanza().modifyNome(id, nome);}

    public static void modifyIndirizzo(int id, String indirizzo){
        ModifyDao.getIstanza().modifyIndirizzo(id, indirizzo);}

    public static void modifyNumPosti(int id, int numPosti){
        ModifyDao.getIstanza().modifyNumPosti(id, numPosti);}
}
