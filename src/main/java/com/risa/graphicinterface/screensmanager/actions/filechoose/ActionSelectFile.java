package com.risa.graphicinterface.screensmanager.actions.filechoose;

import com.risa.functionality.generate.matrix.WkMatrix;
import com.risa.functionality.load.LoadFileExceptions;
import com.risa.functionality.load.LoadGraphFromCSV;
import com.risa.graph.Graph;
import com.risa.graph.TypeLieu;
import com.risa.graph.TypeRoute;
import com.risa.graphicinterface.screensmanager.ScreensManager;
import com.risa.graphicinterface.screensmanager.screens.FileChooseScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class ActionSelectFile extends AbstractAction {
    private final ScreensManager screensManager;
    private final FileChooseScreen fileChooseScreen;

    public ActionSelectFile(FileChooseScreen fileChooseScreen) {
        this.fileChooseScreen = fileChooseScreen;
        screensManager = fileChooseScreen.getScreensManager();
    }

    /**
     * Donne a l'utilisateur la possibilité de choisir un fichier CSV pour faire charger le graphe.
     * Dans le cas ou le fichier n'est pas bon l'utilisateur est averti.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        File file = fileChooseScreen.getFileChooser().getSelectedFile();
        boolean fileSuccesfullyLoaded = false;

        if (file != null) {
            LoadGraphFromCSV load = new LoadGraphFromCSV(screensManager.getGraphSAE());

            try {
                load.load(file);
                fileSuccesfullyLoaded = true;
            } catch (LoadFileExceptions loadFileExceptions) {
                JOptionPane.showMessageDialog(screensManager, "Le fichier selectionne doit comporter des erreurs de syntaxe.");
            }

        }

        if (fileSuccesfullyLoaded) {
            screensManager.getGraphUI().loadVisualFromSAEGraph(screensManager.getGraphSAE());
            screensManager.setWkMatrix(new WkMatrix(screensManager.getGraphSAE()));

            fileChooseScreen.getLoadState().setForeground(Color.BLUE);
            fileChooseScreen.getLoadState().setText("charge");

            fileChooseScreen.getValidation().setEnabled(false);

            screensManager.initialize();
        }

        if (file == null) {
            fileChooseScreen.getLoadState().setForeground(Color.RED);
            fileChooseScreen.getLoadState().setText("erreur lors du chargement");
            JOptionPane.showMessageDialog(fileChooseScreen, "Merci de selectionner un fichier !");
        }

    }
}
