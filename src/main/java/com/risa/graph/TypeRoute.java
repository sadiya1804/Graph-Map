package com.risa.graph;

public enum TypeRoute {
    AUTOROUTE("A"), NATIONALE("N"), DEPARTEMENTALE("D");

    private final String type;

    TypeRoute(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

}
