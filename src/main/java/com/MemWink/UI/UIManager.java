package com.MemWink.UI;

import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.UI.frame.MainFrame;
import com.MemWink.UI.panel.*;

import javax.swing.*;

public class UIManager {
    public static MainFrame mainFrame;

    public static JPanel mainPanel;

    public static ShowCardBags showCardBags;

    public static ShowAllCards showAllCards;

    public static CardContent cardContent;

    public static ReviewManager reviewManager;

    public static ShowStatics showStatics;

    public static CardBag cardBag = null;

    private UIManager() {

    }
    public static void init() {
        mainFrame = MainFrame.getMainFrame();

        mainFrame.mainPanel.add(ShowCardBags.getShowCardBags());
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void update() {
        // showAllCards = new ShowAllCards(cardBag);
    }
}
