package com.risa.graphicinterface.screensmanager.actions.zerodistance;

import com.risa.graph.TypeLieu;
import com.risa.graphicinterface.screensmanager.customcomponent.NodesListModel;
import com.risa.graphicinterface.screensmanager.screens.ZeroDistanceScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ActionFilterNodes extends AbstractAction {
    private final ZeroDistanceScreen zeroDistanceScreen;
    private final TypeLieu typeLieuFilter;
    private final boolean noFilter;

    public ActionFilterNodes(ZeroDistanceScreen zeroDistanceScreen){
        this.zeroDistanceScreen = zeroDistanceScreen;
        typeLieuFilter = null;
        noFilter = true;
    }
    public ActionFilterNodes(ZeroDistanceScreen zeroDistanceScreen, TypeLieu typeLieuFilter){
        this.zeroDistanceScreen = zeroDistanceScreen;
        this.typeLieuFilter = typeLieuFilter;
        noFilter = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        NodesListModel nodesListModel = zeroDistanceScreen.getNodesListModel();

        if (noFilter) {
            nodesListModel.emptyAll();
            nodesListModel.fill(zeroDistanceScreen.getScreensManager().getGraphSAE().getNoeuds().values());
        }
        if (!noFilter) {
            nodesListModel.filterBy(typeLieuFilter, zeroDistanceScreen.getScreensManager().getGraphSAE().getNoeuds().values());
        }

        Component button = ((Component) e.getSource());
        button.setEnabled(false);
        zeroDistanceScreen.getDisabledNodeButton().setEnabled(true);
        zeroDistanceScreen.setDisabledNodeButton(button);
    }
}
