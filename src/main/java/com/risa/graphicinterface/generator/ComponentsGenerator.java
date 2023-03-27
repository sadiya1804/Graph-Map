package com.risa.graphicinterface.generator;

import com.risa.graph.Arete;
import com.risa.graph.Noeud;
import com.risa.graphicinterface.screensmanager.customcomponent.EdgesListModel;
import com.risa.graphicinterface.screensmanager.customcomponent.NodesListModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import static java.awt.Component.CENTER_ALIGNMENT;
import static java.awt.Component.LEFT_ALIGNMENT;

public class ComponentsGenerator {

    /**
     * Créé un composant invisible prenant simplement une place déterminée en hauteur par maxHeigth.
     * @param maxHeigth Integer
     * @return Component
     */
    public static Component verticalGlue(int maxHeigth) {
        Component box = Box.createVerticalGlue();
        box.setMaximumSize(new Dimension(1, maxHeigth));
        box.setPreferredSize(new Dimension(1, maxHeigth));
        return box;
    }

    /**
     * Créé un JLabel avec un texte donné, automatiquement centré celon centered, en gras selon bold.
     * @param text texte
     * @param centered si le Composant doit être centré
     * @return JLabel
     */
    public static JLabel jLabel(String text, boolean centered) {
        JLabel label = new JLabel(text);

        if (centered) {
            label.setAlignmentX(CENTER_ALIGNMENT);
            label.setHorizontalAlignment(SwingConstants.CENTER);
        }

        return label;
    }

    /**
     * Créé un JLabel avec un texte donné, automatiquement centré celon centered, en gras selon bold.
     * @param text texte
     * @param centered si le Composant doit être centré
     * @param bold si le texte doit être en gras
     * @return JLabel
     */
    public static JLabel jLabel(String text, boolean centered, boolean bold) {
        JLabel label = jLabel(text, centered);

        if (bold) {
            label.setFont(new Font(
                    label.getFont().getFontName(),
                    Font.BOLD,
                    label.getFont().getSize()
            ));
        }

        return label;
    }

    /**
     * Créé un JLabel avec un texte donné, automatiquement centré celon centered, en gras selon bold, et souligné selon underlined.
     * @param text texte
     * @param centered si le Composant doit être centré
     * @param bold si le texte doit être en gras
     * @param underlined si le texte doit être souligné
     * @return JLabel
     */
    public static JLabel jLabel(String text, boolean centered, boolean bold, boolean underlined) {
        JLabel label = jLabel(text, centered, bold);

        if (underlined) {
            label.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
        }

        return label;
    }

    /**
     * Créé un JButton avec un texte donné, et automatiquement centré celon centered.
     * Et avec un ActionListener facultatif.
     * @param text texte
     * @param centered si le Composant doit être centré
     * @param abstractAction ActionListener ou null
     * @return JButton
     */
    public static JButton jButton(String text, boolean centered, ActionListener abstractAction) {
        JButton button = new JButton(text);

        if (centered) {
            button.setAlignmentX(CENTER_ALIGNMENT);
            button.setHorizontalAlignment(SwingConstants.CENTER);
        }

        if (abstractAction != null) {
            button.addActionListener(abstractAction);
        }

        return button;
    }

    /**
     * Créé une JComboBox centrée celon centered et permettant lui affecter un model.
     * @param centered si le Composant doit être centré
     * @param model le model ou null
     * @return JComboBox
     */
    public static JComboBox<Noeud> customNodesComboBox(boolean centered, NodesListModel model) {
        JComboBox<Noeud> comboBox = new JComboBox<>();
        comboBox.setMaximumSize(new Dimension(300, 24));

        if (centered) {
            comboBox.setAlignmentX(CENTER_ALIGNMENT);
        }

        if (model != null) {
            comboBox.setModel(model);
        }

        return comboBox;
    }

    /**
     *Créé une JComboBox centrée celon centered et permettant lui affecter un model.
     * @param centered si le Composant doit être centré
     * @param model le model ou null
     * @return JComboBox
     */
    public static JComboBox<Arete> customEdgesComboBox(boolean centered, EdgesListModel model) {
        JComboBox<Arete> comboBox = new JComboBox<>();
        comboBox.setMaximumSize(new Dimension(300, 24));

        if (centered) {
            comboBox.setAlignmentX(CENTER_ALIGNMENT);
        }

        if (model != null) {
            comboBox.setModel(model);
        }

        return comboBox;
    }

    /**
     * Créé un JTextArea centré en fonction de centered et ayant le word-wrapping activé.
     * @param text text
     * @return JTextArea
     */
    public static JTextArea jTextArea(String text, boolean centered) {
        JTextArea jTextArea = new JTextArea(text);

        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        jTextArea.setEditable(false);
        jTextArea.setMaximumSize(new Dimension(5000, 100));
        jTextArea.setPreferredSize(jTextArea.getMaximumSize());

        if (centered) {
            jTextArea.setAlignmentX(CENTER_ALIGNMENT);
        }

        return jTextArea;
    }
}
