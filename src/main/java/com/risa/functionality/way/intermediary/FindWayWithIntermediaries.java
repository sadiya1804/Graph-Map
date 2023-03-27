package com.risa.functionality.way.intermediary;

import com.risa.functionality.generate.matrix.WkMatrix;
import com.risa.functionality.way.shortest.FindShortestWay;

import java.util.ArrayList;
import java.util.function.Predicate;

public class FindWayWithIntermediaries {

    /**
     * Permet de trouver un chemin, allant de from à to et prenant en compte des noeuds intermediaires par lesquels le
     * chemin devra passer. Si aucun intermediaire n'est donné, ce sera simplement le plus court chemin qui sera donné.
     * Aussi, l'odre des intermédiaires n'est pas forcément respecté.
     * @param matrix la Wk matrice calculée
     * @param from le noeud de départ
     * @param to le noeud d'arrivé
     * @param intermediaries un ou plusieurs intermédiaires
     * @return une liste des noeuds par lesquels il faut passer, dans l'ordre
     */
    public ArrayList<String> findWayWithIntermediaries(WkMatrix matrix, String from, String to, ArrayList<String> intermediaries) {
        ArrayList<String> way = new ArrayList<>();
        FindShortestWay findShortestWay = new FindShortestWay();

        intermediaries.removeIf(Predicate.isEqual(to));
        intermediaries.removeIf(Predicate.isEqual(from));

        String position = from;
        boolean intermediaryAlreadyReached = false;
        for (int i = 0; i < intermediaries.size(); ++i) {
            intermediaryAlreadyReached = way.contains(intermediaries.get(i));
            if (! intermediaryAlreadyReached) {
                way.addAll(findShortestWay.findShortestWay(matrix, position, intermediaries.get(i)));
                position = way.remove(way.size() - 1);
            }
        }
        way.addAll(findShortestWay.findShortestWay(matrix, position, to));

        return way;
    }
}
