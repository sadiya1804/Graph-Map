package com.risa.functionality.generate.matrix;

public class DistanceNode {
    private float distance;
    private String node;

    public DistanceNode(float distance, String node) {
        this.distance = distance;
        this.node = node;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "{" + distance + " " + node + "}";
    }
}
