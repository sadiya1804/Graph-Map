package com.risa.graphicinterface.screensmanager.actions.zerodistance;

import com.risa.graph.TypeRoute;
import com.risa.graphicinterface.screensmanager.customcomponent.EdgesListModel;
import com.risa.graphicinterface.screensmanager.screens.ZeroDistanceScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ActionFilterEdge extends AbstractAction {
    private final ZeroDistanceScreen zeroDistanceScreen;
    private final TypeRoute typeRouteFilter;
    private final boolean noFilter;

    public ActionFilterEdge(ZeroDistanceScreen zeroDistanceScreen){
        this.zeroDistanceScreen = zeroDistanceScreen;
        typeRouteFilter = null;
        noFilter = true;
    }
    public ActionFilterEdge(ZeroDistanceScreen zeroDistanceScreen, TypeRoute typeRouteFilter){
        this.zeroDistanceScreen = zeroDistanceScreen;
        this.typeRouteFilter = typeRouteFilter;
        noFilter = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EdgesListModel edgesListModel = zeroDistanceScreen.getEdgeListModel();

        if (noFilter) {
            edgesListModel.emptyAll();
            edgesListModel.fill(zeroDistanceScreen.getScreensManager().getGraphSAE().getAretes());
        }
        if (!noFilter) {
            edgesListModel.filterBy(typeRouteFilter, zeroDistanceScreen.getScreensManager().getGraphSAE().getAretes());
        }

        Component button = ((Component) e.getSource());
        button.setEnabled(false);
        zeroDistanceScreen.getDisabledEdgeButton().setEnabled(true);
        zeroDistanceScreen.setDisabledEdgeButton(button);
    }
}
