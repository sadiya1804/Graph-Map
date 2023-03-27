package com.risa.functionality.compare.filter;

import com.risa.graph.Graph;
import com.risa.graph.Noeud;
import com.risa.graph.TypeLieu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class NodeFilters {

    /**
     * Permet de filtrer des nom de noeuds passé en paramètre selon un type de lieu.
     * @param sites liste de nom de noeuds
     * @param filter filtre
     * @return la liste filtrée
     */
    public Set<String> filterCustomized(Set<String> sites, Graph graph, TypeLieu filter) {
        Set<String> filteredSites = new HashSet<>();
        for (String site : sites) {
            if (graph.getNoeud(site).getTypeLieu() == filter) {
                filteredSites.add(site);
            }
        }
        return filteredSites;
    }

    /**
     * Permet de filtrer des noeuds passé en paramètre selon un type de lieu.
     * @param nodes liste de noeuds
     * @param filter filtre
     * @return liste filtrée
     */
    public ArrayList<Noeud> filterCustomized(Collection<Noeud> nodes, TypeLieu filter) {
        ArrayList<Noeud> filteredNodes = new ArrayList<>();
        for (Noeud node : nodes) {
            if (node.getTypeLieu() == filter) {
                filteredNodes.add(node);
            }
        }
        return filteredNodes;
    }
}
