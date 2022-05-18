package com.MemWink.SwingLearn;

import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.Data.DataManager;

import javax.swing.*;
import java.awt.*;

public class Test {

    public static void main(String[] args) {
        new Test().init();
    }

    private void init(){
        DataManager.init();
        MainFrame mainFrame = new MainFrame();
        for (CardBag cardBag:DataManager.getCardBags()) {
            CardBagPane pane = new CardBagPane();
            pane.setBackground(cardBag.getColor());
            pane.label1.setText(cardBag.getName());
            mainFrame.panel1.add(pane);
        }
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
