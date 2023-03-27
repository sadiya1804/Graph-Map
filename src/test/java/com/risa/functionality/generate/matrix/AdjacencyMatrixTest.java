package com.risa.functionality.generate.matrix;

import com.risa.graph.Graph;
import com.risa.graph.TypeLieu;
import com.risa.graph.TypeRoute;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class AdjacencyMatrixTest {
    @Test
    void adjacencyMatrix_instanciation_shouldBeNotNull() {
        Graph graph = new Graph();

        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(graph);

        assertThat(adjacencyMatrix.getMatrix()).isNotNull();
    }

    @Test
    void genAdjacencyMatrix_basicGen_shouldHaveTwoEntriesInHashMap() {
        Graph graph = new Graph();
        graph.ajouterNoeud("Test1", TypeLieu.VILLE);
        graph.ajouterNoeud("Test2", TypeLieu.VILLE);

        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(graph);

        assertThat(adjacencyMatrix.getMatrix().keySet().size()).isEqualTo(2);
    }

    @Test
    void genAdjacencyMatrix_genWithValues_ShouldReturn5ForEdgeBetweenTest1AndTest2() {
        Graph graph = new Graph();
        graph.ajouterNoeud("Test1", TypeLieu.VILLE);
        graph.ajouterNoeud("Test2", TypeLieu.VILLE);

        graph.ajouterArete("Test1", TypeRoute.AUTOROUTE, 5, "Test2");

        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(graph);

        assertThat(adjacencyMatrix.getMatrix().get("Test1").get("Test2")).isEqualTo(5);
    }
}
