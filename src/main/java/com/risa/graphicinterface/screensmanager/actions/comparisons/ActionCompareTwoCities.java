package com.risa.graphicinterface.screensmanager.actions.comparisons;

import com.risa.functionality.compare.SitesComparisons;
import com.risa.graph.Noeud;
import com.risa.graphicinterface.screensmanager.screens.ComparisonsScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ActionCompareTwoCities extends AbstractAction {
    private final ComparisonsScreen comparisonsScreen;

    public ActionCompareTwoCities(ComparisonsScreen comparisonsScreen) {
        this.comparisonsScreen = comparisonsScreen;
    }

    /**
     * Permet en fonction des deux villes choisies afficher si l'une est plus ouverte/gastronomique/culturelle que
     * l'autre dans trois JLabel.
     * Dans le cas ou tout les noeuds ne sont pas sélectionnés l'utilisateur est averti.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Noeud node1 = (Noeud) comparisonsScreen.getCitySelectorOne().getSelectedItem();
        Noeud node2 = (Noeud) comparisonsScreen.getCitySelectorTwo().getSelectedItem();
        boolean check = node1 != null && node2 != null;

        if (check) {
            SitesComparisons compare = new SitesComparisons(
                    comparisonsScreen.getScreensManager().getWkMatrix(),
                    comparisonsScreen.getScreensManager().getGraphSAE()
            );

            float resultOpened = compare.cityCompare(node1, node2);
            float resultGastronomic = compare.restaurantsCompare(node1, node2);
            float resultCultural = compare.centresLoisirCompare(node1, node2);

            comparisonsScreen.getAnswerOppened().setForeground(Color.WHITE);
            comparisonsScreen.getAnswerGastronomic().setForeground(Color.WHITE);
            comparisonsScreen.getAnswerCultural().setForeground(Color.WHITE);

            if (resultOpened == 1) {
                comparisonsScreen.getAnswerOppened().setText(node1.getNom() + " est plus ouvert que " + node2.getNom());
            } else if (resultOpened == 0) {
                comparisonsScreen.getAnswerOppened().setText(node1.getNom() + " est egalement ouvert avec " + node2.getNom());
            } else if (resultOpened == -1) {
                comparisonsScreen.getAnswerOppened().setText(node1.getNom() + " est moins ouvert que " + node2.getNom());
            } else if (resultOpened == Float.POSITIVE_INFINITY) {
                comparisonsScreen.getAnswerOppened().setText("Les deux sites selectionne sont a moins de deux distance.");
                comparisonsScreen.getAnswerOppened().setForeground(Color.ORANGE);
            }

            if (resultGastronomic == 1) {
                comparisonsScreen.getAnswerGastronomic().setText(node1.getNom() + " est plus gastronomique que " + node2.getNom());
            } else if (resultGastronomic == 0) {
                comparisonsScreen.getAnswerGastronomic().setText(node1.getNom() + " est egalement gastronomique avec " + node2.getNom());
            } else if (resultGastronomic == -1) {
                comparisonsScreen.getAnswerGastronomic().setText(node1.getNom() + " est moins gastronomique que " + node2.getNom());
            } else if (resultGastronomic == Float.POSITIVE_INFINITY) {
                comparisonsScreen.getAnswerGastronomic().setText("Les deux sites selectionne sont a moins de deux distance.");
                comparisonsScreen.getAnswerGastronomic().setForeground(Color.ORANGE);
            }

            if (resultCultural == 1) {
                comparisonsScreen.getAnswerCultural().setText(node1.getNom() + " est plus culturel que " + node2.getNom());
            } else if (resultCultural == 0) {
                comparisonsScreen.getAnswerCultural().setText(node1.getNom() + " est egalement culturel avec " + node2.getNom());
            } else if (resultCultural == -1) {
                comparisonsScreen.getAnswerCultural().setText(node1.getNom() + " est moins culturel que " + node2.getNom());
            } else if (resultCultural == Float.POSITIVE_INFINITY) {
                comparisonsScreen.getAnswerCultural().setText("Les deux sites selectionne sont a moins de deux distance.");
                comparisonsScreen.getAnswerCultural().setForeground(Color.ORANGE);
            }
        }
        if (! check) {
            JOptionPane.showMessageDialog(comparisonsScreen, "Veuillez selectionner deux villes.");
        }
    }
}
