package com.risa.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GraphTest {
    Graph graph;

    @BeforeEach
    void setUp() {
        graph = new Graph();
    }

    @Test
    void ajouterNoeudTest() {
        graph.ajouterNoeud("nom", TypeLieu.RESTAURANT);

        int result = graph.getNoeuds().size();

        assertThat(result).isEqualTo(1);
    }

    @Test
    void ajouterAreteWithStringNodes() {
        graph.ajouterNoeud("source", TypeLieu.RESTAURANT);
        graph.ajouterNoeud("destination", TypeLieu.CENTRE_LOISIR);
        graph.ajouterArete("source", TypeRoute.AUTOROUTE, 5, "destination");

        int result = graph.getNoeud("source").getAretes().size();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void ajouterAreteWithNoeudNodes() {
        graph.ajouterNoeud("source", TypeLieu.RESTAURANT);
        graph.ajouterNoeud("destination", TypeLieu.RESTAURANT);

        graph.ajouterArete(graph.getNoeud("source"), TypeRoute.AUTOROUTE, 5, graph.getNoeud("destination"));

        int result = graph.getNoeud("source").getAretes().size();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void toStringLien() {
        graph.ajouterNoeud("Test", TypeLieu.RESTAURANT);
        graph.ajouterNoeud("Destination1", TypeLieu.CENTRE_LOISIR);
        graph.ajouterNoeud("Destination2", TypeLieu.VILLE);
        graph.ajouterArete("Test", TypeRoute.AUTOROUTE, (float) 20.26, "Destination1");
        graph.ajouterArete("Test", TypeRoute.DEPARTEMENTALE, (float) -661.3, "Destination1");
        graph.ajouterArete("Test", TypeRoute.NATIONALE, (float) 99, "Destination2");

        String result = graph.toString();
        assertThat(result).isEqualTo(
                "Test&R;;Destination2:N&99.0;Destination1:A&20.26,D&-661.3\nDestination2&V;;\nDestination1&C;;"
        );
    }
}
