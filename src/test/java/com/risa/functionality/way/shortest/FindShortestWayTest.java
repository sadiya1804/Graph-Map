package com.risa.functionality.way.shortest;

import com.risa.functionality.generate.matrix.WkMatrix;
import com.risa.graph.Graph;
import com.risa.graph.TypeLieu;
import com.risa.graph.TypeRoute;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FindShortestWayTest {

    @Test
    void findShortestWay_shouldReturnCorrectWay() {
        Graph graph = new Graph();
        graph.ajouterNoeud("Test1", TypeLieu.VILLE);
        graph.ajouterNoeud("Test2", TypeLieu.VILLE);
        graph.ajouterNoeud("Test3", TypeLieu.VILLE);
        // Create a big way from Test1 to Test2
        // Create the shortest way from Test1 to Test2 passing by Test3
        graph.ajouterArete("Test1", TypeRoute.AUTOROUTE, 100, "Test2");
        graph.ajouterArete("Test2", TypeRoute.AUTOROUTE, 100, "Test1");
        graph.ajouterArete("Test1", TypeRoute.AUTOROUTE, 10, "Test3");
        graph.ajouterArete("Test3", TypeRoute.AUTOROUTE, 10, "Test1");
        graph.ajouterArete("Test3", TypeRoute.AUTOROUTE, 10, "Test2");
        graph.ajouterArete("Test2", TypeRoute.AUTOROUTE, 10, "Test3");
        // Important to create edges from each side because it's a non-oriented graph.

        WkMatrix wkMatrix = new WkMatrix(graph);
        FindShortestWay findShortestWay = new FindShortestWay();

        ArrayList<String> answer = findShortestWay.findShortestWay(wkMatrix, "Test1", "Test2");
        ArrayList<String> correctWay = new ArrayList<>() {{
            add("Test1");
            add("Test3");
            add("Test2");
        }};

        assertThat(answer).isEqualTo(correctWay);
    }
}
