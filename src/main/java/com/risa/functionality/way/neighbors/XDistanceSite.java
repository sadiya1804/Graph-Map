package com.risa.functionality.way.neighbors;

import com.risa.graph.Arete;
import com.risa.graph.Graph;
import com.risa.graph.Noeud;

import java.util.HashSet;
import java.util.Set;

public class XDistanceSite {
    /**
     * Trouve tout les sites à une distance de 1 saut du noeud donné soit les voisins.
     * Utiliser un Set permet d'ajouter des valeurs sans les dupliquer.
     * @param node le noeud étudié
     * @return un set contenant les valeurs uniques des voisins
     */
    public Set<String> oneDistanceSite(Noeud node) {
        Set<String> sites = new HashSet<>();

        for (Arete arete : node.getAretes()) {
            sites.add(arete.getDestination().getNom());
        }

        return sites;
    }


    /**
     * Trouve tout les sites à une distance de 2 saut du noeud donné soit les voisins des voisins.
     * Utiliser un Set permet d'ajouter des valeurs sans les dupliquer.
     * @param node le noeud étudié
     * @return un set contenant les valeurs uniques des voisins des voisins
     */
    public Set<String> twoDistanceSite(Noeud node) {
        Set<String> sites = new HashSet<>();
        for (Arete arete : node.getAretes()) {
            sites.addAll(
                    oneDistanceSite(arete.getDestination())
            );
        }

        sites.remove(node.getNom());

        return sites;
    }


    /**
     * Trouve tout les sites à une distance de 1 saut du noeud donné soit les voisins.
     * Utiliser un Set permet d'ajouter des valeurs sans les dupliquer.
     * @param node le noeud étudié
     * @return un set contenant les valeurs uniques des voisins
     */
    public Set<String> nDistanceSite(Graph graph, Noeud node, int n) {
        if (n <= 0) {
            return new HashSet<>();
        }
        if (n == 1) {
            return oneDistanceSite(node);
        }

        return recursiveNDistanceSite(oneDistanceSite(node), graph, n - 1);
    }

    /**
     * Permet de trouver les sites à n distance du noeud donné.
     * Utiliser un Set permet d'ajouter des valeurs sans les dupliquer.
     * @param sites liste de nom de noeuds
     * @param graph graphe
     * @param n Integer
     * @return liste de nom de noeuds
     */
    private Set<String> recursiveNDistanceSite(Set<String> sites, Graph graph, int n) {
        if (n == 0) {
            return sites;
        }
        if (n > 0) {
            Set<String> newSites = new HashSet<>();

            for (String site : sites) {
                for (Arete arete : graph.getNoeud(site).getAretes()) {
                    newSites.add(arete.getDestination().getNom());
                }
            }

            return recursiveNDistanceSite(newSites, graph, n - 1);
        }

        return null; // Never reached
    }
}
