package com.risa.graphicinterface.screensmanager.screens;

import com.risa.graphicinterface.generator.ComponentsGenerator;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.actions.twodistance.ActionTwoDistanceNodes;
import com.risa.graphicinterface.screensmanager.customcomponent.NodesListModel;

import javax.swing.*;

public class TwoDistanceScreen extends JPanel {
    private final ScreensManager screensManager;
    private final NodesListModel selectorOne;
    private final NodesListModel selectorTwo;
    private final JLabel answer;

    public TwoDistanceScreen(ScreensManager screensManager) {
        this.screensManager = screensManager;
        selectorOne = new NodesListModel();
        selectorTwo = new NodesListModel();
        answer = ComponentsGenerator.jLabel("", true);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        buildPanel();
    }

    private void buildPanel() {
        add(ComponentsGenerator.verticalGlue(50));

        add(ComponentsGenerator.jLabel("Selectionner deux sites pour savoir si ils sont exactement a deux distance.", true, true));

        add(ComponentsGenerator.verticalGlue(20));

        add(ComponentsGenerator.jLabel("Site 1", true));
        add(ComponentsGenerator.customNodesComboBox(true, selectorOne));
        selectorOne.fill(screensManager.getGraphSAE().getNoeuds().values());
        add(ComponentsGenerator.jLabel("Site 2", true));
        add(ComponentsGenerator.customNodesComboBox(true, selectorTwo));
        selectorTwo.fill(screensManager.getGraphSAE().getNoeuds().values());

        add(ComponentsGenerator.verticalGlue(5));

        add(ComponentsGenerator.jButton("Analyser", true, new ActionTwoDistanceNodes(this)));

        add(ComponentsGenerator.verticalGlue(15));

        answer.setAlignmentX(CENTER_ALIGNMENT);
        add(answer);
    }

    public NodesListModel getSelectorOne() {
        return selectorOne;
    }

    public NodesListModel getSelectorTwo() {
        return selectorTwo;
    }

    public JLabel getAnswer() {
        return answer;
    }
}
