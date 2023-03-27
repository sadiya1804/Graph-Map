package com.risa.functionality.load;

import com.risa.graph.Graph;
import com.risa.graph.TypeLieu;
import com.risa.graph.TypeRoute;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadGraphFromCSV {
    private final ArrayList<String> saveEdges =  new ArrayList<>();
    private final Graph graph;

    public LoadGraphFromCSV(Graph graph) {
        this.graph = graph;
    }

    public void load(File file) throws LoadFileExceptions {
        String lineRead;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while ((lineRead = bufferedReader.readLine()) != null) {
                parseLine(lineRead);
            }

            parseEdges();
        } catch (IOException e) {
            throw new LoadFileExceptions(1);
        }
    }

    private void parseLine(String line) throws LoadFileExceptions {
        String[] nodeAndEdges = line.split(";;");

        String mainNodeName = parseNode(nodeAndEdges[0]);

        saveEdges(nodeAndEdges[1], mainNodeName);
    }

    private String parseNode(String node) throws LoadFileExceptions {
        String[] nameAndTypeLieu = node.split("&");

        graph.ajouterNoeud(nameAndTypeLieu[0], valueOfTypeLieu(nameAndTypeLieu[1]));

        return nameAndTypeLieu[0];
    }

    private void saveEdges(String edges, String mainNodeName) {
        for (String edge : edges.split(";")) {
            saveEdges.add(mainNodeName + "///" + edge);
        }
    }

    private void parseEdges() throws LoadFileExceptions {
        for (String element : saveEdges) {
            String[] edges = element.split("///");
            String mainNodeName = edges[0];

            String[] destinations = edges[1].split(";");
            for (String destination : destinations) {
                String[] destinationAndEdges = destination.split(":");

                String destinationName = destinationAndEdges[0];

                addEdges(mainNodeName, destinationAndEdges[1], destinationName);
            }
        }
    }

    private void addEdges(String mainNodeName, String edges, String destination) throws LoadFileExceptions {
        for (String typeRouteAndDistance : edges.split(",")) {
            String[] edge = typeRouteAndDistance.split("&");

            graph.ajouterArete(mainNodeName, valueOfTypeRoute(edge[0]), Float.parseFloat(edge[1]), destination);
        }
    }

    private TypeLieu valueOfTypeLieu(String typeLieu) throws LoadFileExceptions {
        TypeLieu parsed = null;

        if (typeLieu.compareTo("V") == 0) {
            parsed = TypeLieu.VILLE;
        }
        if (typeLieu.compareTo("L") == 0) {
            parsed =  TypeLieu.CENTRE_LOISIR;
        }
        if (typeLieu.compareTo("R") == 0) {
            parsed = TypeLieu.RESTAURANT;
        }

        if (parsed == null) {
            throw new LoadFileExceptions(2);
        }

        return parsed;
    }

    private TypeRoute valueOfTypeRoute(String typeRoute) throws LoadFileExceptions {
        TypeRoute parsed = null;

        if (typeRoute.compareTo("D") == 0) {
            parsed = TypeRoute.DEPARTEMENTALE;
        }
        if (typeRoute.compareTo("A") == 0) {
            parsed = TypeRoute.AUTOROUTE;
        }
        if (typeRoute.compareTo("N") == 0) {
            parsed = TypeRoute.NATIONALE;
        }

        if (parsed == null) {
            throw new LoadFileExceptions(2);
        }

        return parsed;
    }
}
