package com.MemWink.UI;

import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.Data.CardBag.CategorizedCard;
import com.MemWink.Data.DataManager;
import com.MemWink.UI.frame.MainFrame;
import com.MemWink.UI.panel.*;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

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

        Thread updateThread = new Thread() {
            @Override
            public void run() {
                try {
                    update();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        // updateThread.start();
    }

    /**
     * 页面更新线程需要执行的语句
     * @throws InterruptedException 线程异常
     */
    public static void update() throws InterruptedException {
        while (true) {
            Thread.sleep(5000);

            for (CardBag i : DataManager.getCardBags()) {
                if (i.getReviewCardsNum() > 0) {
                    Component[] components = mainFrame.mainPanel.getComponents();
                    ShowCardBags.getShowCardBags();
                    // TODO：ShowAllCards构造器中应当有一个CardBag参数
                    // showAllCards = new ShowAllCards();
                    if (components[0] instanceof ShowCardBags) {
                        System.out.println("ShowCardBags updated.");
                        mainFrame.mainPanel.removeAll();
                        mainFrame.mainPanel.add(showCardBags);
                    } else if (components[0] instanceof ShowAllCards) {
                        System.out.println("ShowAllCards updated.");
                        mainFrame.mainPanel.removeAll();
                        mainFrame.mainPanel.add(showAllCards);
                    }
                    mainFrame.mainPanel.updateUI();
                    break;
                }
            }

            if (cardBag != null) {
                for (CategorizedCard i : cardBag.getCards()) {
                    System.out.println(i.getFrontString() + " " + i.getMemState());
                }
            }
        }
    }
}
