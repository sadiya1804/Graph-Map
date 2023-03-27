package com.risa.graphicinterface.screensmanager.screens;

import com.risa.graph.Noeud;
import com.risa.graphicinterface.generator.ComponentsGenerator;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.actions.onedistance.*;
import com.risa.graphicinterface.screensmanager.customcomponent.EdgesListModel;
import com.risa.graphicinterface.screensmanager.customcomponent.NodesListModel;

import javax.swing.*;
import java.awt.*;

public class OneDistanceScreen extends JPanel {
    private final ScreensManager screensManager;
    private final NodesListModel nodesSelector;
    private final NodesListModel displayNeighbours;
    private final EdgesListModel edgesSelector;
    private final  JLabel startNode;
    private final JLabel arrivalNode;
    private final  JLabel edgeDistance;
    private final JLabel edgeType;

    public OneDistanceScreen(ScreensManager screensManager) {
        this.screensManager = screensManager;
        displayNeighbours = new NodesListModel();
        nodesSelector = new NodesListModel();
        edgesSelector = new EdgesListModel();

        startNode = ComponentsGenerator.jLabel("", true, true);
        arrivalNode = ComponentsGenerator.jLabel("", true, true);
        edgeDistance = ComponentsGenerator.jLabel("", true, true);
        edgeType = ComponentsGenerator.jLabel("", true, true);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        buildScreen();
    }

    private void buildScreen() {
        add(ComponentsGenerator.verticalGlue(50));

        add(ComponentsGenerator.jLabel("Selectonnez un noeud pour aficher ses voisins : ", true, true));

        add(ComponentsGenerator.verticalGlue(20));

        add(ComponentsGenerator.customNodesComboBox(true, nodesSelector));
        nodesSelector.fill(screensManager.getGraphSAE().getNoeuds().values());

        add(ComponentsGenerator.verticalGlue(5));

        add(ComponentsGenerator.jButton("Analyser", true, new ActionDisplayNodeInformations(this)));

        add(ComponentsGenerator.verticalGlue(15));
        add(ComponentsGenerator.jLabel("Filtrer par type de voisins (re-analyser pour reinitialiser) :", true, true));

        JPanel jPanel = new JPanel();
        jPanel.setMaximumSize(new Dimension(10000, 100));
        jPanel.add(ComponentsGenerator.jButton("Villes", false, new ActionFilterByCity(this)));
        jPanel.add(ComponentsGenerator.jButton("Restaurants", false, new ActionFilterByRestaurant(this)));
        jPanel.add(ComponentsGenerator.jButton("Centres de loisir", false, new ActionFilterByLeisureCenter(this)));
        add(jPanel);

        add(ComponentsGenerator.verticalGlue(20));

        JList<Noeud> jList = new JList<>(displayNeighbours);
        jList.setAlignmentX(CENTER_ALIGNMENT);
        jList.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        add(jList);

        add(ComponentsGenerator.verticalGlue(100));

        add(ComponentsGenerator.jLabel("Selectionnez une arete pour voir les noeuds qu'il relie :", true, true));

        add(ComponentsGenerator.verticalGlue(20));

        add(ComponentsGenerator.customEdgesComboBox(true, edgesSelector));
        edgesSelector.fill(screensManager.getGraphSAE().getAretes());

        add(ComponentsGenerator.verticalGlue(5));

        add(ComponentsGenerator.jButton("Analyser", true, new ActionDisplayEdgeInformations(this)));

        add(ComponentsGenerator.verticalGlue(20));

        JPanel edgesInfo = new JPanel();
        edgesInfo.setLayout(new BoxLayout(edgesInfo, BoxLayout.Y_AXIS));
        edgesInfo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        edgesInfo.setMaximumSize(new Dimension(250, 200));

        edgesInfo.add(ComponentsGenerator.jLabel("Noeud de depart :", true));
        edgesInfo.add(ComponentsGenerator.verticalGlue(5));
        edgesInfo.add(startNode);
        edgesInfo.add(ComponentsGenerator.verticalGlue(10));
        edgesInfo.add(ComponentsGenerator.jLabel("Noeud d'arrivee :", true));
        edgesInfo.add(ComponentsGenerator.verticalGlue(5));
        edgesInfo.add(arrivalNode);
        edgesInfo.add(ComponentsGenerator.verticalGlue(10));
        edgesInfo.add(ComponentsGenerator.jLabel("Longueur :", true));
        edgesInfo.add(ComponentsGenerator.verticalGlue(5));
        edgesInfo.add(edgeDistance);
        edgesInfo.add(ComponentsGenerator.verticalGlue(10));
        edgesInfo.add(ComponentsGenerator.jLabel("Type de route :", true));
        edgesInfo.add(ComponentsGenerator.verticalGlue(5));
        edgesInfo.add(edgeType);

        add(edgesInfo);

        // Fill empty remaining space
        add(Box.createVerticalGlue());
    }

    public ScreensManager getScreensManager() {
        return screensManager;
    }

    public NodesListModel getDisplayNeighbours() {
        return displayNeighbours;
    }

    public NodesListModel getNodesSelector() {
        return nodesSelector;
    }

    public EdgesListModel getEdgesSelector() {
        return edgesSelector;
    }

    public JLabel getStartNode() {
        return startNode;
    }

    public JLabel getArrivalNode() {
        return arrivalNode;
    }

    public JLabel getEdgeDistance() {
        return edgeDistance;
    }

    public JLabel getEdgeType() {
        return edgeType;
    }
}
