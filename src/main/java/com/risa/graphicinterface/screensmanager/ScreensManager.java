package com.risa.graphicinterface.screensmanager;

import com.risa.functionality.generate.matrix.WkMatrix;
import com.risa.graph.Graph;
import com.risa.graphicinterface.graphstream.GraphSynced;
import com.risa.graphicinterface.screensmanager.screens.*;

import javax.swing.*;
import java.awt.*;

public class ScreensManager extends JSplitPane {
    private final GraphSynced graphUI;
    private final com.risa.graph.Graph graphSAE;
    private WkMatrix wkMatrix;

    private final ScreensButtonMenu screensButtonMenu;
    private final JPanel screensContainer;
    private final CardLayout cardLayout;

    public ScreensManager(GraphSynced graphUI, com.risa.graph.Graph graphSAE) {
        super(JSplitPane.VERTICAL_SPLIT);

        this.graphUI = graphUI;
        this.graphSAE = graphSAE;
        this.wkMatrix = null;
        this.screensButtonMenu = new ScreensButtonMenu();
        cardLayout = new CardLayout();
        screensContainer = new JPanel();
        screensContainer.setLayout(cardLayout);

        setEnabled(false);
        setDividerSize(0);

        buildPane();
    }

    private void buildPane() {
        setTopComponent(screensButtonMenu);
        setBottomComponent(screensContainer);

        screensContainer.add(new FileChooseScreen(this), "1");

        for (String id : screensButtonMenu.getScreenButtons().keySet()) {
            screensButtonMenu.getScreenButtons().get(id).addActionListener(event -> {
                cardLayout.show(screensContainer, id);
                screensButtonMenu.disableOtherButton(id);
            });
        }
    }

    /**
     * Permet d'activer l'interface après qu'un graphe ai été chargé.
     */
    public void initialize() {
        screensContainer.add(new ZeroDistanceScreen(this), "2");
        screensContainer.add(new OneDistanceScreen(this), "3");
        screensContainer.add(new TwoDistanceScreen(this), "4");
        screensContainer.add(new ComparisonsScreen(this), "5");
        screensContainer.add(new BonusScreen(this), "6");
        screensContainer.add(new ToolsAndHelp(this), "7");

        screensButtonMenu.enableAllExceptDisabled();

    }

    public GraphSynced getGraphUI() {
        return graphUI;
    }

    public Graph getGraphSAE() {
        return graphSAE;
    }

    public WkMatrix getWkMatrix() {
        return wkMatrix;
    }

    public void setWkMatrix(WkMatrix wkMatrix) {
        this.wkMatrix = wkMatrix;
    }
}
