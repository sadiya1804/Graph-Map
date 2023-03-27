package com.risa.graphicinterface.screensmanager.screens;

import com.risa.graph.Noeud;
import com.risa.graphicinterface.generator.ComponentsGenerator;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.actions.bonus.ActionAddIntermediarySiteSelector;
import com.risa.graphicinterface.screensmanager.actions.bonus.ActionFindShortestWay;
import com.risa.graphicinterface.screensmanager.actions.bonus.ActionFindWayWithIntermediaries;
import com.risa.graphicinterface.screensmanager.actions.bonus.ActionRemoveIntermediarySiteSelector;
import com.risa.graphicinterface.screensmanager.customcomponent.NodesListModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BonusScreen extends JPanel {
    private final ScreensManager screensManager;
    private final NodesListModel selectorOne;
    private final NodesListModel selectorTwo;
    private final JTextArea answerShortestWay;
    private final ArrayList<JComboBox<Noeud>> intermediarySites;
    private final JTextArea answerWayWithIntermediaries;

    public BonusScreen(ScreensManager screensManager) {
        this.screensManager = screensManager;
        selectorOne = new NodesListModel();
        selectorTwo = new NodesListModel();
        answerShortestWay = ComponentsGenerator.jTextArea("", true);
        intermediarySites = new ArrayList<>();
        answerWayWithIntermediaries = ComponentsGenerator.jTextArea("", true);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        buildPanel();
    }

    private void buildPanel() {
        add(ComponentsGenerator.verticalGlue(50));

        add(ComponentsGenerator.jLabel("Site quelconque 1", true));
        add(ComponentsGenerator.customNodesComboBox(true, selectorOne));
        selectorOne.fill(screensManager.getGraphSAE().getNoeuds().values());
        add(ComponentsGenerator.jLabel("Site quelconque 2", true));
        add(ComponentsGenerator.customNodesComboBox(true, selectorTwo));
        selectorTwo.fill(screensManager.getGraphSAE().getNoeuds().values());

        add(ComponentsGenerator.verticalGlue(5));

        add(ComponentsGenerator.jButton("Chercher le plus court chemin", true,
                new ActionFindShortestWay(this))
        );

        add(ComponentsGenerator.verticalGlue(5));
        add(answerShortestWay);
        add(ComponentsGenerator.verticalGlue(25));
        add(ComponentsGenerator.jLabel(
                "Trouver un chemin entre les deux sites choisis avec des sites intermediaires par lesquels passer :",
                true)
        );
        add(ComponentsGenerator.verticalGlue(5));
        add(buildSubPanel());
        add(ComponentsGenerator.jButton("Chercher un chemin passant par la selection", true,
                new ActionFindWayWithIntermediaries(this))
        );

        add(ComponentsGenerator.verticalGlue(5));

        add(answerWayWithIntermediaries);

        add(ComponentsGenerator.verticalGlue(5));
    }

    private JPanel buildSubPanel() {
        JPanel panel = new JPanel(new FlowLayout());

        panel.add(ComponentsGenerator.jLabel("Ajouter ou supprimer un site intermediaire : ", true));
        panel.add(ComponentsGenerator.jButton("    +    ", true, new ActionAddIntermediarySiteSelector(this)));
        panel.add(ComponentsGenerator.jButton("    -    ", true, new ActionRemoveIntermediarySiteSelector(this)));

        panel.setPreferredSize(new Dimension(10000, 50));
        panel.setMaximumSize(panel.getPreferredSize());

        return panel;
    }

    public ScreensManager getScreensManager() {
        return screensManager;
    }

    public NodesListModel getSelectorOne() {
        return selectorOne;
    }

    public NodesListModel getSelectorTwo() {
        return selectorTwo;
    }

    public JTextArea getAnswerShortestWay() {
        return answerShortestWay;
    }

    public ArrayList<JComboBox<Noeud>> getIntermediarySites() {
        return intermediarySites;
    }

    public JTextArea getAnswerWayWithIntermediaries() {
        return answerWayWithIntermediaries;
    }
}
