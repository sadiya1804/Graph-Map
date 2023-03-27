package com.risa.functionality.generate.matrix;

import com.risa.graph.Graph;

import java.util.HashMap;

public class WkMatrix extends AdjacencyMatrix {
    private final HashMap<String, HashMap<String, DistanceNode>> wkMatrix;

    public WkMatrix(Graph graph) {
        super(graph);

        wkMatrix = new HashMap<>();

        replaceDiagonalByZeros();
        convertFloatToDistanceNode();
        calculateAllShortestWays();
    }

    public HashMap<String, HashMap<String, DistanceNode>> getWkMatrix() {
        return wkMatrix;
    }

    /**
     * Permet de récupérer une valeur de la matrice par le biais de deux entiers x et y.
     * @param x Integer
     * @param y Integer
     * @return Float
     */
    public Float getMatrixValue(int x, int y) {
        return wkMatrix.get(getKeys().get(x)).get(getKeys().get(y)).getDistance();
    }

    /**
     * Permet de récupérer une valeur de la matrice par le biais de deux noms de noeuds x et y.
     * @param x String
     * @param y String
     * @return Float
     */
    public Float getMatrixValue(String x, String y) {
        return wkMatrix.get(x).get(y).getDistance();
    }

    public DistanceNode getDistanceNode(int  x, int y) {
        return wkMatrix.get(getKeys().get(x)).get(getKeys().get(y));
    }

    public DistanceNode getDistanceNode(String x, String y) {
        return wkMatrix.get(x).get(y);
    }

    private void replaceDiagonalByZeros() {
        for (String nodeName : this.getMatrix().keySet()) {
            this.getMatrix().get(nodeName).put(nodeName, (float) 0);
        }
    }

    private void convertFloatToDistanceNode() {
        for (String nodeName : getMatrix().keySet()) {
            wkMatrix.put(nodeName, new HashMap<>());

            for (String nodeName2 : getMatrix().get(nodeName).keySet()) {
                wkMatrix.get(nodeName).put(nodeName2, new DistanceNode(
                        getMatrix().get(nodeName).get(nodeName2),
                        nodeName
                ));
            }
        }
    }

    private void calculateAllShortestWays() {
        for (int i = 0; i < wkMatrix.size(); i++) {
            calculateWkPlusOne(i);
        }
    }

    private void calculateWkPlusOne(int colomnRowNumber) {
        for (int row = 0; row < wkMatrix.size(); row++) {
            for (int column = 0; column < wkMatrix.size(); column++) {
                updateValueOfwkToCheck(colomnRowNumber, row, column);
            }
        }
    }

    private void updateValueOfwkToCheck(int colomnRowNumber, int row, int column) {
        Float wkColumn = getMatrixValue(row, colomnRowNumber);
        Float wkRow = getMatrixValue(colomnRowNumber, column);
        Float wkToCheck = getMatrixValue(row, column);
        DistanceNode wkToCheckDN = getDistanceNode(row, column);

        if (wkColumn + wkRow < wkToCheck) {
            wkToCheckDN.setDistance(wkColumn + wkRow);
            wkToCheckDN.setNode(
                    getDistanceNode(colomnRowNumber, column).getNode()
            );
        }
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder("[\n");
        for (HashMap<String, DistanceNode> line : wkMatrix.values()) {
            toString.append("\t[ ");
            for (DistanceNode value : line.values()) {
                toString.append(value.toString()).append(", ");
            }
            toString.append("],\n");
        }
        toString.append("]");

        return toString.toString();
    }
}
