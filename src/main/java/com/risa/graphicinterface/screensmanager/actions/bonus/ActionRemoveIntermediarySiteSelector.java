package com.risa.graphicinterface.screensmanager.actions.bonus;

import com.risa.graphicinterface.screensmanager.screens.BonusScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionRemoveIntermediarySiteSelector extends AbstractAction {
    private final BonusScreen bonusScreen;

    public ActionRemoveIntermediarySiteSelector(BonusScreen bonusScreen) {
        this.bonusScreen = bonusScreen;
    }

    /**
     * Permet de supprimer dynamiquement un sélecteur de noeuds à l'interface pour l'utilisateur.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (bonusScreen.getIntermediarySites().size() > 0) {
            bonusScreen.remove(
                    bonusScreen.getIntermediarySites().get(bonusScreen.getIntermediarySites().size() - 1)
            );
            bonusScreen.getIntermediarySites().remove(bonusScreen.getIntermediarySites().size() - 1);

            bonusScreen.revalidate();
            bonusScreen.repaint();
        }
    }
}
