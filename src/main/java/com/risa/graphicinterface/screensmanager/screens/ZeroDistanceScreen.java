package com.risa.graphicinterface.screensmanager.screens;

import com.risa.functionality.compare.filter.EdgeFilters;
import com.risa.functionality.compare.filter.NodeFilters;
import com.risa.graph.*;
import com.risa.graphicinterface.generator.ComponentsGenerator;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.actions.zerodistance.*;
import com.risa.graphicinterface.screensmanager.customcomponent.EdgesListModel;
import com.risa.graphicinterface.screensmanager.customcomponent.NodesListModel;

import javax.swing.*;
import java.awt.*;

public class ZeroDistanceScreen extends JPanel {

    private final ScreensManager screensManager;
    private final EdgesListModel edgeListModel;
    private final NodesListModel nodesListModel;
    private Component disabledNodeButton;
    private Component disabledEdgeButton;


    public ZeroDistanceScreen(ScreensManager screensManager) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.screensManager = screensManager;

        edgeListModel = new EdgesListModel();
        nodesListModel = new NodesListModel();

        disabledNodeButton = null;
        disabledEdgeButton = null;

        buildPanel();
    }


    private void buildPanel() {
        add(ComponentsGenerator.verticalGlue(8));
        add(buildTopSubPanel());
        add(ComponentsGenerator.verticalGlue(14));
        add(buildCenterSubPanel());
        add(ComponentsGenerator.verticalGlue(14));
        add(buildBottomSubPanel());
    }

    private JPanel buildTopSubPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 9, 4));
        panel.setPreferredSize(new Dimension(10000, 176));
        panel.setMaximumSize(panel.getPreferredSize());


        panel.add(ComponentsGenerator.jLabel("Noeuds", true, true));
        panel.add(ComponentsGenerator.jLabel("Aretes", true, true));


        disabledNodeButton = ComponentsGenerator.jButton("Afficher tout les noeuds", false,
                new ActionFilterNodes(this)
        );
        disabledNodeButton.setEnabled(false);
        disabledEdgeButton = ComponentsGenerator.jButton("Afficher toutes les aretes", false,
                new ActionFilterEdge(this )
        );
        disabledEdgeButton.setEnabled(false);
        panel.add(disabledNodeButton);
        panel.add(disabledEdgeButton);

        panel.add(ComponentsGenerator.jButton("Villes",false,
                new ActionFilterNodes(this, TypeLieu.VILLE)
        ));
        panel.add(ComponentsGenerator.jButton("Autoroutes ", false,
                new ActionFilterEdge(this, TypeRoute.AUTOROUTE)
        ));
        panel.add(ComponentsGenerator.jButton("Restaurants", false,
                new ActionFilterNodes(this, TypeLieu.RESTAURANT)
        ));
        panel.add(ComponentsGenerator.jButton("Departementales", false,
                new ActionFilterEdge(this, TypeRoute.DEPARTEMENTALE)
        ));
        panel.add(ComponentsGenerator.jButton("Centres de loisir", false,
                new ActionFilterNodes(this, TypeLieu.CENTRE_LOISIR)
        ));
        panel.add(ComponentsGenerator.jButton("Nationales", false,
                new ActionFilterEdge(this, TypeRoute.NATIONALE)
        ));


        return panel;
    }

    private JPanel buildCenterSubPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2, 9, 2));

        JList<Noeud> listeNoeud = new JList<>(nodesListModel);
        nodesListModel.fill(screensManager.getGraphSAE().getNoeuds().values());
        JList<Arete> listeArete = new JList<>(edgeListModel);
        edgeListModel.fill(screensManager.getGraphSAE().getAretes());

        panel.add(new JScrollPane(
                listeNoeud,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        ));
        panel.add(new JScrollPane(
                listeArete,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        ));

        return panel;
    }

    private JPanel buildBottomSubPanel() {
        JPanel panel = new JPanel(new GridLayout(4,2));
        panel.setPreferredSize(new Dimension(10000, 110));
        panel.setMaximumSize(panel.getPreferredSize());

        Graph graphSAE = screensManager.getGraphSAE();
        NodeFilters nodeFilters = new NodeFilters();
        EdgeFilters edgeFilters = new EdgeFilters();

        int nbVilles = nodeFilters.filterCustomized(this.getScreensManager().getGraphSAE().getNoeuds().values(), TypeLieu.VILLE).size();
        int nbRestaurants = nodeFilters.filterCustomized(this.getScreensManager().getGraphSAE().getNoeuds().values(), TypeLieu.RESTAURANT).size();
        int nbCentresDeLoisir = nodeFilters.filterCustomized(this.getScreensManager().getGraphSAE().getNoeuds().values(), TypeLieu.CENTRE_LOISIR).size();

        int nbAutoroutes = edgeFilters.filterCustomized(this.getScreensManager().getGraphSAE().getAretes(), TypeRoute.AUTOROUTE).size()/2;
        int nbNationales = edgeFilters.filterCustomized(this.getScreensManager().getGraphSAE().getAretes(), TypeRoute.NATIONALE).size()/2;
        int nbDepartementales = edgeFilters.filterCustomized(this.getScreensManager().getGraphSAE().getAretes() , TypeRoute.DEPARTEMENTALE).size()/2;

        panel.add(ComponentsGenerator.jLabel("Nombre de noeuds : " + graphSAE.getNoeuds().size() + " noeuds.", true, true));
        panel.add(ComponentsGenerator.jLabel("Nombre d'aretes : " + graphSAE.getAretes().size()/2  + " aretes", true, true));
        panel.add(ComponentsGenerator.jLabel("Nombre de villes : " + nbVilles, true, true));
        panel.add(ComponentsGenerator.jLabel("Nombre d'autoroutes : "  + nbAutoroutes, true, true));
        panel.add(ComponentsGenerator.jLabel("Nombre de restaurants : " + nbRestaurants, true, true));
        panel.add(ComponentsGenerator.jLabel("Nombre de departements : " + nbDepartementales, true, true));
        panel.add(ComponentsGenerator.jLabel("Nombre de centres de loisir : " + nbCentresDeLoisir, true, true));
        panel.add(ComponentsGenerator.jLabel("Nombre de Nationales : " + nbNationales, true, true));

        return panel;
    }

    public NodesListModel getNodesListModel() {
        return nodesListModel;
    }

    public EdgesListModel getEdgeListModel(){
        return edgeListModel;
    }

    public ScreensManager getScreensManager() {
        return screensManager;
    }

    public Component getDisabledNodeButton() {
        return disabledNodeButton;
    }

    public void setDisabledNodeButton(Component disabledNodeButton) {
        this.disabledNodeButton = disabledNodeButton;
    }

    public Component getDisabledEdgeButton() {
        return disabledEdgeButton;
    }

    public void setDisabledEdgeButton(Component disabledEdgeButton) {
        this.disabledEdgeButton = disabledEdgeButton;
    }
}