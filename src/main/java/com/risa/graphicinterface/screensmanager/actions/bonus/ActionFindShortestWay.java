package com.risa.graphicinterface.screensmanager.actions.bonus;

import com.risa.functionality.way.shortest.FindShortestWay;
import com.risa.graph.Noeud;
import com.risa.graphicinterface.screensmanager.screens.BonusScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ActionFindShortestWay extends AbstractAction {
    private final BonusScreen bonusScreen;

    public ActionFindShortestWay(BonusScreen bonusScreen) {
        this.bonusScreen = bonusScreen;
    }

    /**
     * Permet de vérifier si l'utilisateur a bien sélectionner des noeuds pour ensuite récupérer les noeuds et afficher
     * le plus court chemin entre eux dans un JLabel.
     * Dans le cas ou tout les noeuds ne sont pas sélectionnés l'utilisateur est averti.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Noeud node1 = (Noeud) bonusScreen.getSelectorOne().getSelectedItem();
        Noeud node2 = (Noeud) bonusScreen.getSelectorTwo().getSelectedItem();

        if (node1 != null && node2 != null) {
            JTextArea answerShortestWay = bonusScreen.getAnswerShortestWay();

            FindShortestWay shortestWay = new FindShortestWay();
            ArrayList<String> way = shortestWay.findShortestWay(
                    bonusScreen.getScreensManager().getWkMatrix(),
                    node1.getNom(), node2.getNom()
            );
            float distanceShortestWay = shortestWay.distanceOfShortestWay(
                    bonusScreen.getScreensManager().getWkMatrix(),
                    node1.getNom(),
                    node2.getNom()
            );

            if (way.size() == 0) {
                answerShortestWay.setText("Il n'existe pas de plus court chemin entre les deux sites choisis.");
                answerShortestWay.setForeground(Color.ORANGE);
            }
            if (way.size() > 0) {
                answerShortestWay.setText(
                        way.toString().replace("[", "<").replace("]", ">")
                        + "\n\nDistance a parcourir : " + distanceShortestWay + "km.");
                answerShortestWay.setForeground(Color.GREEN);

                bonusScreen.getScreensManager().getGraphUI().asyncColorizeGivenWay(way);
            }
        }
        if (node1 == null || node2 == null) {
            JOptionPane.showMessageDialog(bonusScreen, "Veuillez selectionner deux sites quelconques !");
        }
    }
}
