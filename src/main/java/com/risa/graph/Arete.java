package com.risa.graph;

public class Arete {
    private final TypeRoute typeRoute;
    private final float distance;
    private final Noeud source;
    private final Noeud destination;

    public Arete(Noeud source, TypeRoute typeRoute, float distance, Noeud destination) {
        this.source = source;
        this.typeRoute = typeRoute;
        this.distance = distance;
        this.destination = destination;
    }

    public TypeRoute getTypeRoute() {
        return typeRoute;
    }

    public float getDistance() {
        return distance;
    }

    public Noeud getDestination() {
        return destination;
    }

    public Noeud getSource() {
        return source;
    }

    /**
     * Permet de créer un identifiant unique pour deux arêtes reliant les mêmes noeuds. Partant du principe qu'il
     * n'existe pas deux arêtes ayant une même source et destination avec le même type de route et même distance.
     * @return identifiant
     */
    public String getUniqueIdentifier() {
        String identifier = "";

        int comparison = source.getNom().compareTo(destination.getNom());
        if (comparison == 0) {
            identifier = null;
        }
        if (comparison > 0) {
            identifier += String.valueOf(destination.hashCode());
            identifier += String.valueOf(source.hashCode());
        }
        if (comparison < 0) {
            identifier += String.valueOf(source.hashCode());
            identifier += String.valueOf(destination.hashCode());
        }

        identifier += typeRoute;
        identifier += distance;

        return identifier;
    }

    @Override
    public String toString() {
        return source.getNom() + " -> " + destination.getNom();
    }

    /**
     * Permet de retourner la représentation CSV d'une arête.
     * @return "TypeRoute&Distance"
     */
    public String CSVToString() {
        return typeRoute.toString() + "&" + distance;
    }
}
