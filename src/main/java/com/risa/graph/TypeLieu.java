package com.risa.graph;

public enum TypeLieu {
    VILLE("V"), RESTAURANT("R"), CENTRE_LOISIR("C");

    private final String type;

    TypeLieu(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
