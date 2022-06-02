package com.MemWink.UI;

import com.MemWink.UI.frame.MainFrame;
import com.MemWink.UI.panel.ShowCardBags;

import javax.swing.*;

public class UIManager {
    public static MainFrame mainFrame;

    private UIManager() {

    }
    public static void init() {
        mainFrame = MainFrame.getMainFrame();

        mainFrame.mainPanel.add(ShowCardBags.getShowCardBags());
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
