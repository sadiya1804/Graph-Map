package com.risa.graphicinterface.screensmanager.actions.twodistance;

import com.risa.functionality.way.neighbors.XDistanceSite;
import com.risa.graph.Noeud;
import com.risa.graphicinterface.screensmanager.screens.TwoDistanceScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ActionTwoDistanceNodes extends AbstractAction {
    private final TwoDistanceScreen twoDistanceScreen;

    public ActionTwoDistanceNodes(TwoDistanceScreen twoDistanceScreen) {
        this.twoDistanceScreen = twoDistanceScreen;
    }

    /**
     * Permet d'afficher si les deux sites sélectionnés sont exactement à deux distance ou non.
     * Dans le cas ou tout les noeuds ne sont pas sélectionnés l'utilisateur est averti.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Noeud nodeOne = (Noeud) twoDistanceScreen.getSelectorOne().getSelectedItem();
        Noeud nodeTwo = (Noeud) twoDistanceScreen.getSelectorTwo().getSelectedItem();

        if (nodeOne != null && nodeTwo != null) {
            XDistanceSite twoDistance = new XDistanceSite();
            if (twoDistance.twoDistanceSite(nodeOne).contains(nodeTwo.getNom())) {
                twoDistanceScreen.getAnswer().setText(
                        "Les deux sites selectionne sont a deux distance."
                );
                twoDistanceScreen.getAnswer().setForeground(Color.GREEN);
            }
            else {
                twoDistanceScreen.getAnswer().setText(
                        "Les deux sites selectionne ne sont pas a deux distance."
                );
                twoDistanceScreen.getAnswer().setForeground(Color.ORANGE);
            }
        }
        if (nodeOne == null || nodeTwo == null) {
            JOptionPane.showMessageDialog(twoDistanceScreen, "Veuillez selectionner deux noeuds !");
        }
    }
}
