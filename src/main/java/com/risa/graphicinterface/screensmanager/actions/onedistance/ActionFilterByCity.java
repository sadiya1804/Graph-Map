package com.risa.graphicinterface.screensmanager.actions.onedistance;

import com.risa.graph.Noeud;
import com.risa.graph.TypeLieu;
import com.risa.graphicinterface.screensmanager.screens.OneDistanceScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionFilterByCity extends AbstractAction {
    private final OneDistanceScreen oneDistanceScreen;

    public ActionFilterByCity(OneDistanceScreen oneDistanceScreen) {
        this.oneDistanceScreen = oneDistanceScreen;
    }

    /**
     * Permet de filtrer les noeuds étant des villes dans la liste des voisins du noeud.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (oneDistanceScreen.getNodesSelector().getSelectedItem() != null) {
            oneDistanceScreen.getDisplayNeighbours().filterBy(
                    TypeLieu.VILLE, ((Noeud) oneDistanceScreen.getNodesSelector().getSelectedItem()).getNeibours());
        }
    }
}
