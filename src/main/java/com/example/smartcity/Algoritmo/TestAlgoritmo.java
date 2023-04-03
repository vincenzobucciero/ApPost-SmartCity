package com.example.smartcity.Algoritmo;

import com.example.smartcity.model.ParkingBean;

import java.util.List;

public class TestAlgoritmo {
    public static void main(String[] args) {
        Location start = new Location();


        //qua è quello che deve comparire all'utente
        Nodo initialNode = start.chooseStart("San Giorgio");
        Nodo finalNode = start.chooseEnd("Napoli");

        int rows = 6;
        int cols = 7;

        AStar aStar = new AStar(rows, cols, initialNode, finalNode);
        int[][] blocksArray = new int[][]{{1, 3}, {2, 3}, {3, 3}};
        //int[][] blocksParking = new int[][]{{0,2}, {0,3}, {1,4}};

        aStar.setBlocchi(blocksArray);
        aStar.setParking(start.setParking());

        List<Nodo> nodo = start.getNodopark();
        for (Nodo nodoPark: nodo) {
            aStar.setNodoParcheggio(nodoPark);
        }

        List<Nodo> path = aStar.ricercaPercorso();

        List<ParkingBean> parcheggioDisp;
        for (Nodo node : path) {
            System.out.println(node);                               //per ogni nodo appartentente al percorso trovato da a*
            if(node.isPark()){                                      //controllo se è un nodo parcheggio
                parcheggioDisp = start.getNodoParkIndirizzo(node);  //se è vero allora cerco i parcheggi disponibili lungo il percorso
                for (ParkingBean parking: parcheggioDisp) {         //e li stampo (n.b questo passo va nella jsp)
                    System.out.println(parking.getNomeParcheggio());
                    System.out.println(parking.getIndirizzo());
                    System.out.println(parking.getNumPosti());

                }
            }
        }




        //Search Area
        //      0   1   2   3   4   5   6
        // 0    -   -   P   P   -   -   -
        // 1    -   -   -   B   P   -   -
        // 2    -   I   -   B   -   F   -
        // 3    -   -   -   B   -   -   -
        // 4    -   -   -   -   -   -   -
        // 5    -   -   -   -   -   -   -

        //Expected output with diagonals
        //Node [row=2, col=1]
        //Node [row=1, col=2]
        //Node [row=0, col=3]
        //Node [row=1, col=4]
        //Node [row=2, col=5]

        //Search Path with diagonals
        //      0   1   2   3   4   5   6
        // 0    -   -   -   *   -   -   -
        // 1    -   -   *   B   *   -   -
        // 2    -   I*  -   B   -  *F   -
        // 3    -   -   -   B   -   -   -
        // 4    -   -   -   -   -   -   -
        // 5    -   -   -   -   -   -   -

        //Expected output without diagonals
        //Node [row=2, col=1]
        //Node [row=2, col=2]
        //Node [row=1, col=2]
        //Node [row=0, col=2]
        //Node [row=0, col=3]
        //Node [row=0, col=4]
        //Node [row=1, col=4]
        //Node [row=2, col=4]
        //Node [row=2, col=5]

        //Search Path without diagonals
        //      0   1   2   3   4   5   6
        // 0    -   -   *   *   *   -   -
        // 1    -   -   *   B   *   -   -
        // 2    -   I*  *   B   *  *F   -
        // 3    -   -   -   B   -   -   -
        // 4    -   -   -   -   -   -   -
        // 5    -   -   -   -   -   -   -
    }
}