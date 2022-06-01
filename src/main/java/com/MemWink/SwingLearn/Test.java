package com.MemWink.SwingLearn;

import com.MemWink.Data.DataManager;
import com.MemWink.UI.frame.MainFrame;
import com.MemWink.UI.panel.MemoryCompletionPane;
import com.MemWink.UI.panel.ShowCardBags;

import javax.swing.*;

public class Test {

    public static void main(String[] args) {
        new Test().init();
    }

    private void init(){
        DataManager.init();
        MainFrame mainFrame = MainFrame.getMainFrame();

        mainFrame.mainPanel.add(ShowCardBags.getShowCardBags());
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
