package com.risa.functionality.compare.filter;

import com.risa.graph.*;

import java.util.ArrayList;
import java.util.Collection;

public class EdgeFilters {

    /**
     * Permet de trouver l'arête la plus courte entre un noeud source et de destination.
     * @param source source
     * @param destination destination
     * @param graph graphe
     * @return arête
     */
    public Arete filterEdgesMatchingAndShortest(Noeud source, Noeud destination, Graph graph) {
        Arete result = null;

        for (Arete arete : graph.getAretes()) {
            if (arete.getSource().getNom().equals(source.getNom()) && arete.getDestination().getNom().equals(destination.getNom())) {
                if (result == null) {
                    result = arete;
                }
                if (result.getDistance() > arete.getDistance()) {
                    result = arete;
                }
            }
        }

        return result;
    }

    /**
     * Permet de trouver les arêtes entre un noeud source et de destination.
     * @param source source
     * @param destination destination
     * @param graph graphe
     * @return liste d'arêtes
     */
    public ArrayList<Arete> filterEdgesMatching(String source, String destination, Graph graph) {
        ArrayList<Arete> result = new ArrayList<>();

        for (Arete arete : graph.getAretes()) {
            if (arete.getSource().getNom().equals(source) && arete.getDestination().getNom().equals(destination)) {
                result.add(arete);
            }
        }

        return result;
    }

    /**
     * Permet de filtrer des arêtes passé en paramètres selon un type de route.
     * @param egdes liste d'arêtes
     * @param filter filtre
     * @return la liste filtrée
     */
    public ArrayList<Arete> filterCustomized(Collection<Arete> egdes, TypeRoute filter) {
        ArrayList<Arete> filteredEdges = new ArrayList<>();
        for (Arete edge : egdes) {
            if (edge.getTypeRoute() == filter) {
                filteredEdges.add(edge);
            }
        }
        return filteredEdges;
    }
}
