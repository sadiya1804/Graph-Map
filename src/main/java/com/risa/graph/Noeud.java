package com.risa.graph;

import java.util.ArrayList;
import java.util.Collection;


public class Noeud {
    private final String nom;
    private final TypeLieu typeLieu;

    private final ArrayList<Arete> aretes;

    public Noeud(String nom, TypeLieu typeLieu) {
        this.nom = nom;
        this.typeLieu = typeLieu;
        aretes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public TypeLieu getTypeLieu() {
        return typeLieu;
    }

    public ArrayList<Arete> getAretes(){
        return aretes;
    }


    /**
     * Permet d'ajouter une arête au noeud
     * @param typeRoute la route
     * @param distance la distance
     * @param destination la destination differente de null
     * @return une confirmation d'ajout
     */
    public boolean ajouterArete(TypeRoute typeRoute, float distance, Noeud destination) {
        boolean success = false;

        if (destination != null) {
            success = aretes.add(new Arete(this, typeRoute, distance, destination));
        }

        return success;
    }

    /**
     * Permet de retourner les voisins de ce noeud.
     * @return liste de noeuds
     */
    public Collection<Noeud> getNeibours() {
        Collection<Noeud> neighbours = new ArrayList<>();

        for (Arete arete : aretes) {
            if (! neighbours.contains(arete.getDestination())) {
                neighbours.add(arete.getDestination());
            }
        }

        return neighbours;
    }

    @Override
    public String toString() {
        String toReturn = "";

        if (typeLieu != null) {
            toReturn += "[" + typeLieu + "] ";
        }

        toReturn += nom;
        return toReturn;
    }

    /**
     * Permet de retourner la représentation CSV d'un noeud.
     * @return "Nom&TypeLieu"
     */
    public String CSVToString() {
        return nom + "&" + typeLieu.toString();
    }
}
