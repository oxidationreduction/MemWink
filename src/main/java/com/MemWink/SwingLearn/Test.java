package com.MemWink.SwingLearn;

import javax.swing.*;

public class Test {

    public static void main(String[] args) {
        new Test().init();
    }

    private void init(){
        MainFrame mainFrame = new MainFrame();
        ShowCardBags bagsPane = new ShowCardBags();
        mainFrame.mainPanel.add(bagsPane);

        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
