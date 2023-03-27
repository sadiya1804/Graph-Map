package com.risa.graphicinterface.screensmanager;

import javax.swing.*;
import java.util.HashMap;

public class ScreensButtonMenu extends JMenuBar {
    private final HashMap<String, JButton> screenButtons;
    private String disabledButton;

    public ScreensButtonMenu() {
        screenButtons = new HashMap<>() {
            {
                put("1", new JButton("Accueil"));
                put("2", new JButton("0-distance"));
                put("3", new JButton("1-distance"));
                put("4", new JButton("2-distance"));
                put("5", new JButton("Comparaisons"));
                put("6", new JButton("Bonus"));
                put("7", new JButton("Outils et Aide"));
            }
        };

        for (JButton jButton : screenButtons.values()) {
            add(jButton);
        }

        disabledButton = "1";
        disableButton("1");

        disableAll();
    }

    public HashMap<String, JButton> getScreenButtons() {
        return screenButtons;
    }

    /**
     * Permet de désactiver tout les boutons du menu.
     */
    public void disableAll() {
        for (JButton jButton : screenButtons.values()) {
            jButton.setEnabled(false);
        }
    }

    /**
     * Active tout les boutons sauf celui désactivé.
     */
    public void enableAllExceptDisabled() {
        for (JButton jButton : screenButtons.values()) {
            jButton.setEnabled(true);
        }
        disableButton(disabledButton);
    }

    /**
     * Désactive le bouton dont l'ID est donné.
     * @param id button à désactiver
     */
    private void disableButton(String id) {
        screenButtons.get(id).setEnabled(false);
        disabledButton = id;
    }

    /**
     * Désactive un bouton passé en paramètres et réactive l'ancien bouton désactivé.
     * @param id button à désactiver
     */
    public void disableOtherButton(String id) {
        if (! disabledButton.equals(id)) {
            enableButton(disabledButton);
            disableButton(id);
        }
    }

    /**
     * Active le bouton dont l'ID est donné.
     * @param id bouton à activer
     */
    public void enableButton(String id) {
        screenButtons.get(id).setEnabled(true);
    }
}
