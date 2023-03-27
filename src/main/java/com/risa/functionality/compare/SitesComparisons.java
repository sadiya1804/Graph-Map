package com.risa.functionality.compare;


import com.risa.functionality.compare.filter.NodeFilters;
import com.risa.functionality.generate.matrix.WkMatrix;
import com.risa.functionality.way.neighbors.XDistanceSite;
import com.risa.functionality.way.shortest.FindShortestWay;
import com.risa.graph.Graph;
import com.risa.graph.Noeud;
import com.risa.graph.TypeLieu;

public class SitesComparisons {
    WkMatrix wkMatrix;
    Graph graph;

    public SitesComparisons(WkMatrix wkMatrix, Graph graph) {
        this.wkMatrix = wkMatrix;
        this.graph = graph;
    }

    /**
     * Si la ville A a plus de villes voisines 2-distance que la ville B alors la ville A est plus ouverte que
     * la ville B, à l’inverse la ville A est plus fermée que la ville B.
     * @param node1 le site 1
     * @param node2 le site 2
     * @return Si les deux sites sont à moins de 2-distance -> +∞ | site1 > site2 -> 1 | site1 < site2 -> -1
     * | site1 == site2 -> 0
     */
    public float cityCompare(Noeud node1, Noeud node2) {
        return compareNodes(node1, node2, TypeLieu.VILLE);
    }

    /**
     * Si la ville A a plus de restaurants voisins 2-distance que la ville B alors le restaurant A est
     * plus gastronomique que la ville, à l’inverse la ville A est moins gastronomique que la ville B.
     * @param node1 le site 1
     * @param node2 le site 2
     * @return Si les deux sites sont à moins de 2-distance -> +∞ | site1 > site2 -> 1 | site1 < site2 -> -1
     * | site1 == site2 -> 0
     */
    public float restaurantsCompare(Noeud node1, Noeud node2) {
        return compareNodes(node1, node2, TypeLieu.RESTAURANT);
    }

    /**
     * Si la ville A a plus de centres de loirirs voisins 2-distance que la ville B alors la ville A est
     * plus culturel que la ville, à l’inverse la ville A est moins culturel que la ville B.
     * @param node1 le site 1
     * @param node2 le site 2
     * @return Si les deux sites sont à moins de 2-distance -> +∞ | site1 > site2 -> 1 | site1 < site2 -> -1
     * | site1 == site2 -> 0
     */
    public float centresLoisirCompare(Noeud node1, Noeud node2) {
        return compareNodes(node1, node2, TypeLieu.CENTRE_LOISIR);
    }



    private float compareNodes(Noeud node1, Noeud node2, TypeLieu filter) {
        float result = Float.POSITIVE_INFINITY;
        FindShortestWay findShortestWay = new FindShortestWay();

        if (! (findShortestWay.findShortestWay(wkMatrix, node1.getNom(), node2.getNom()).size() < 2)) {
            XDistanceSite twoDistanceSite = new XDistanceSite();
            NodeFilters citiesFilters = new NodeFilters();
            int twoDistanceSite1 = citiesFilters.filterCustomized(
                    twoDistanceSite.twoDistanceSite(node1), graph, filter
            ).size();
            int twoDistanceSite2 = citiesFilters.filterCustomized(
                    twoDistanceSite.twoDistanceSite(node2), graph, filter
            ).size();



            if (twoDistanceSite1 == twoDistanceSite2) {
                result = 0;
            }
            if (twoDistanceSite1 < twoDistanceSite2) {
                result = -1;
            }
            if (twoDistanceSite1 > twoDistanceSite2) {
                result = 1;
            }
        }

        return result;
    }
}
