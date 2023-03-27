package com.risa.graphicinterface;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.risa.functionality.generate.matrix.WkMatrix;
import com.risa.graph.Graph;
import com.risa.graphicinterface.graphstream.GraphSynced;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import org.graphstream.graph.implementations.MultiGraph;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final com.risa.graph.Graph graphSAE;
    private final GraphSynced graphUI;
    public MainWindow() {
        super();

        //Use flatlaf
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception e) {
            System.out.println("Erreur application de FlatLaf");
        }

        this.graphSAE = new Graph();
        graphUI = new GraphSynced(new MultiGraph("Graph"), graphSAE);
        graphUI.loadVisualFromSAEGraph(graphSAE);

        setTitle("Test");
        setSize(1300, 900);
        setMinimumSize(new Dimension(1300, 900));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(buildMainPanel());
        setVisible(true);
    }

    private JPanel buildMainPanel() {
        JPanel jPanel = new JPanel(new GridLayout(1, 1));
        JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        jSplitPane.setLeftComponent((Component) graphUI.getView());
        jSplitPane.setRightComponent(new ScreensManager(graphUI, graphSAE));

        jSplitPane.setDividerSize(1);
        jSplitPane.setResizeWeight(1);
        jSplitPane.setEnabled(false);

        jPanel.add(jSplitPane);
        return jPanel;
    }
}
