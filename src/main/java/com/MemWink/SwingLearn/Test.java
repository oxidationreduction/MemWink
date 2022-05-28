package com.MemWink.SwingLearn;

import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.Data.DataManager;
import com.MemWink.UI.component.CardbagLookup;

import javax.swing.*;
import java.awt.*;

public class Test {

    public static void main(String[] args) {
        new Test().init();
    }

    private void init(){
        DataManager.init();
        MainFrame mainFrame = new MainFrame();
        mainFrame.mainPanel.add(ShowCardBags.getShowCardBags());

        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
