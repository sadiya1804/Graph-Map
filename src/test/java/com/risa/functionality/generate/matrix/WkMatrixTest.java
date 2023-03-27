package com.risa.functionality.generate.matrix;

import com.risa.graph.Graph;
import com.risa.graph.TypeLieu;
import com.risa.graph.TypeRoute;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WkMatrixTest {

    @Test
    void replaceDiagonalByZeros_shouldReturnOnlyZeros() {
        Graph graph = new Graph();
        graph.ajouterNoeud("Test1", TypeLieu.VILLE);
        graph.ajouterNoeud("Test2", TypeLieu.VILLE);

        WkMatrix wkMatrix = new WkMatrix(graph);

        for (String key : wkMatrix.getWkMatrix().keySet()) {
            assertThat(wkMatrix.getMatrixValue(key, key)).isEqualTo(0);
        }
    }

    @Test
    void convertFloatToDistanceNode_shouldConvertAllFloatToDistanceNode() {
        Graph graph = new Graph();
        graph.ajouterNoeud("Test1", TypeLieu.VILLE);
        graph.ajouterNoeud("Test2", TypeLieu.VILLE);

        WkMatrix wkMatrix = new WkMatrix(graph);

        for (String key : wkMatrix.getWkMatrix().keySet()) {
            for (String key2 : wkMatrix.getWkMatrix().keySet()) {
                assertThat(wkMatrix.getDistanceNode(key, key2)).isInstanceOf(DistanceNode.class);
            }
        }
    }

    @Test
    void calculateAllShortestWays_shouldReturn() {
        Graph graph = new Graph();
        graph.ajouterNoeud("Test1", TypeLieu.VILLE);
        graph.ajouterNoeud("Test2", TypeLieu.VILLE);
        graph.ajouterArete("Test1", TypeRoute.AUTOROUTE, 100, "Test2");
        graph.ajouterArete("Test2", TypeRoute.AUTOROUTE, 10, "Test1");

        WkMatrix wkMatrix = new WkMatrix(graph);
        HashMap<String, HashMap<String, DistanceNode>> matrix = wkMatrix.getWkMatrix();
        ArrayList<Float> checkListDistance = new ArrayList<>() {{
                add((float) 0);
                add((float) 100);
                add((float) 10);
                add((float) 0);
        }};
        ArrayList<String> checkListNodeNames = new ArrayList<>() {{
                add("Test1");
                add("Test1");
                add("Test2");
                add("Test2");
        }};

        int i = 0;
        for (String key : matrix.keySet()) {
            for (String key2 : matrix.get(key).keySet()) {
                DistanceNode distanceNode = matrix.get(key).get(key2);
                assertThat(distanceNode.getDistance()).isEqualTo(checkListDistance.get(i));
                assertThat(distanceNode.getNode()).isEqualTo(checkListNodeNames.get(i));
                i++;
            }
        }
    }
}
