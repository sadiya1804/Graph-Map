package com.risa.graphicinterface.screensmanager.actions.bonus;

import com.risa.graph.Noeud;
import com.risa.graphicinterface.generator.ComponentsGenerator;
import com.risa.graphicinterface.screensmanager.customcomponent.NodesListModel;
import com.risa.graphicinterface.screensmanager.screens.BonusScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static java.awt.Component.CENTER_ALIGNMENT;

public class ActionAddIntermediarySiteSelector extends AbstractAction {
    private final BonusScreen bonusScreen;

    public ActionAddIntermediarySiteSelector(BonusScreen bonusScreen) {
        this.bonusScreen = bonusScreen;
    }

    /**
     * Permet d'ajouter dynamiquement un sélecteur de noeuds à l'interface pour l'utilisateur.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        NodesListModel selector = new NodesListModel();
        JComboBox<Noeud> comboBox = ComponentsGenerator.customNodesComboBox(true, selector);

        selector.fill(bonusScreen.getScreensManager().getGraphSAE().getNoeuds().values());
        bonusScreen.add(comboBox);
        bonusScreen.getIntermediarySites().add(comboBox);

        bonusScreen.revalidate();
        bonusScreen.repaint();
    }
}
