package com.risa.graphicinterface.screensmanager.screens;

import com.risa.functionality.compare.filter.NodeFilters;
import com.risa.graph.TypeLieu;
import com.risa.graphicinterface.generator.ComponentsGenerator;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.actions.comparisons.ActionCompareTwoCities;
import com.risa.graphicinterface.screensmanager.customcomponent.NodesListModel;

import javax.swing.*;

public class ComparisonsScreen extends JPanel {
    private final ScreensManager screensManager;
    private final NodesListModel citySelectorOne;
    private final NodesListModel citySelectorTwo;
    private final JLabel answerOppened;
    private final JLabel answerGastronomic;
    private final JLabel answerCultural;

    public ComparisonsScreen(ScreensManager screensManager) {
        this.screensManager = screensManager;
        citySelectorOne = new NodesListModel();
        citySelectorTwo = new NodesListModel();
        answerOppened = ComponentsGenerator.jLabel("", true);
        answerGastronomic = ComponentsGenerator.jLabel("", true);
        answerCultural = ComponentsGenerator.jLabel("", true);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        buildPanel();
    }

    private void buildPanel() {
        add(ComponentsGenerator.verticalGlue(50));

        NodeFilters filter = new NodeFilters();

        add(ComponentsGenerator.jLabel("Ville 1", true));
        add(ComponentsGenerator.customNodesComboBox(true, citySelectorOne));
        citySelectorOne.fill(
                filter.filterCustomized(screensManager.getGraphSAE().getNoeuds().values(), TypeLieu.VILLE)
        );
        add(ComponentsGenerator.jLabel("Ville 2", true));
        add(ComponentsGenerator.customNodesComboBox(true, citySelectorTwo));
        citySelectorTwo.fill(
                filter.filterCustomized(screensManager.getGraphSAE().getNoeuds().values(), TypeLieu.VILLE)
        );

        add(ComponentsGenerator.jButton("Comparer", true,
                new ActionCompareTwoCities(this))
        );

        add(ComponentsGenerator.verticalGlue(15));
        add(answerOppened);
        add(ComponentsGenerator.verticalGlue(5));
        add(answerGastronomic);
        add(ComponentsGenerator.verticalGlue(5));
        add(answerCultural);
    }

    public ScreensManager getScreensManager() {
        return screensManager;
    }

    public NodesListModel getCitySelectorOne() {
        return citySelectorOne;
    }

    public NodesListModel getCitySelectorTwo() {
        return citySelectorTwo;
    }

    public JLabel getAnswerOppened() {
        return answerOppened;
    }

    public JLabel getAnswerGastronomic() {
        return answerGastronomic;
    }

    public JLabel getAnswerCultural() {
        return answerCultural;
    }
}
