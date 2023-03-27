package com.risa.functionality.generate.matrix;

import com.risa.graph.Arete;
import com.risa.graph.Graph;
import com.risa.graph.Noeud;

import java.util.ArrayList;
import java.util.HashMap;

public class AdjacencyMatrix {
    private final HashMap<String, HashMap<String, Float>> matrix;
    private final ArrayList<String> keys;

    public AdjacencyMatrix(Graph graph) {
        matrix = new HashMap<>();
        keys = new ArrayList<>(graph.getNoeuds().keySet());

        genAdjacencyMatrixFromGraph(graph);
    }

    public HashMap<String, HashMap<String, Float>> getMatrix() {
        return matrix;
    }

    public ArrayList<String> getKeys() {
        return keys;
    }

    /**
     * Get a value of the matrix by Integers values.
     * @param x Integer
     * @param y Integer
     * @return the value associated to matrix[x][y].
     */
    public Float getMatrixValue(int x, int y) {
        return matrix.get(keys.get(x)).get(keys.get(y));
    }

    /**
     * Get a value of the matrix by String names.
     * @param x String
     * @param y String
     * @return the value associated to matrix[x][y].
     */
    public Float getMatrixValue(String x, String y) {
        return matrix.get(x).get(y);
    }

    private void genAdjacencyMatrixFromGraph(Graph graph) {
        // Initialize empty Hashmap matrix
        for (String nodeName : keys) {
            matrix.put(nodeName, new HashMap<String, Float>());
            for (String nodeName2 : keys) {
                matrix.get(nodeName).put(nodeName2, Float.POSITIVE_INFINITY);
            }
        }

        for (Noeud noeud : graph.getNoeuds().values()) {
            for (Arete arete : noeud.getAretes()) {
                matrix.get(noeud.getNom()).put(arete.getDestination().getNom(), arete.getDistance());
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder("[\n");
        for (HashMap<String, Float> line : matrix.values()) {
            toString.append("\t[ ");
            for (Float value : line.values()) {
                toString.append(value).append(", ");
            }
            toString.append("],\n");
        }
        toString.append("]");

        return toString.toString();
    }
}
