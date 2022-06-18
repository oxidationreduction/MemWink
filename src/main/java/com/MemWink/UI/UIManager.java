package com.MemWink.UI;

import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.Data.CardBag.CategorizedCard;
import com.MemWink.Data.DataManager;
import com.MemWink.UI.frame.MainFrame;
import com.MemWink.UI.panel.*;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * 用户界面管理中心
 * <p>存储界面元素，管理界面更新</>
 * @author Liu Hongyu
 * @since 2022-05-18
 */
public class UIManager {
    /**
     * 外观主框架
     */
    public static MainFrame mainFrame;

    /**
     * 内部主面板
     */
    public static JPanel mainPanel;

    /**
     * 卡包列表
     */
    public static ShowCardBags showCardBags;

    /**
     * 卡片列表
     */
    public static ShowAllCards showAllCards;

    /**
     * 卡片详情
     */
    public static CardContent cardContent;

    /**
     * 复习界面
     */
    public static ReviewManager reviewManager;

    /**
     * 统计界面
     */
    public static ShowStatics showStatics;

    /**
     * 当前活跃卡包
     */
    public static CardBag cardBag = null;

    /**
     * 构造器
     */
    private UIManager() {
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
        updateThread.start();
    }

    /**
     * 用户界面初始化
     */
    public static void init() {
        new UIManager();
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
                    if (components[0] instanceof ShowCardBags) {
                        // System.out.println("ShowCardBags updated.");
                        mainFrame.mainPanel.removeAll();
                        mainFrame.mainPanel.add(showCardBags);
                    }
                    mainFrame.mainPanel.updateUI();
                    break;
                }
            }

            if (cardBag != null) {
                for (CategorizedCard i : cardBag.getCards()) {
                    // System.out.println(i.getFrontString() + " " + i.getMemState());
                }
            }
        }
    }
}
