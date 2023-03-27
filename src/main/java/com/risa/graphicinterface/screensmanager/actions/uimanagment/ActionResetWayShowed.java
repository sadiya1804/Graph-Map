package com.risa.graphicinterface.screensmanager.actions.uimanagment;

import com.risa.graphicinterface.screensmanager.screens.ToolsAndHelp;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionResetWayShowed extends AbstractAction {
    private final ToolsAndHelp toolsAndHelp;

    public ActionResetWayShowed(ToolsAndHelp toolsAndHelp) {
        this.toolsAndHelp = toolsAndHelp;
    }

    /**
     * Permet à l'utilisateur de décolorer les noeuds.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        toolsAndHelp.getScreensManager().getGraphUI().asyncUncolorizeAll();
    }
}
