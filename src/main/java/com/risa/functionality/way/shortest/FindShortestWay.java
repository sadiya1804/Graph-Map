package com.risa.functionality.way.shortest;

import com.risa.functionality.generate.matrix.WkMatrix;

import java.util.ArrayList;

public class FindShortestWay {

    /**
     * Trouve le plus court chemin entre from et to.
     * @param matrix la Wk matrice calculée
     * @param from le noeud de départ
     * @param to le noeud d'arrivé
     * @return une liste ordonnée des noeuds par lesquels il faut passer
     */
    public ArrayList<String> findShortestWay(WkMatrix matrix, String from, String to) {
        ArrayList<String> way = new ArrayList<>();

        String position = from;
        way.add(position);
        while (! position.equals(to)) {
            position = matrix.getDistanceNode(to, position).getNode();
            way.add(position);
        }

        if (from.equals(to)) {
            way.clear();
        }

        return way;
    }

    public float distanceOfShortestWay(WkMatrix wkMatrix, String from, String to) {
        return wkMatrix.getDistanceNode(from, to).getDistance();
    }
}
