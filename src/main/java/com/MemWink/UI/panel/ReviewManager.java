package com.MemWink.UI.panel;

import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.Data.CardBag.CategorizedCard;
import com.MemWink.UI.UIManager;
import com.MemWink.util.constant.MemStateConstants;
import com.MemWink.Data.DataManager;
import com.MemWink.util.constant.UIConstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

/**
 * 复习管理器
 * <p>用于统合复习页面和复习结束时的总结页面</p>
 *
 * @since 2022-05-30
 * @author Liu Hongyu
 */
public class ReviewManager extends JPanel {
    /**
     * 本轮"记住了"的卡片数
     */
    private int rememberedNum = 0;

    /**
     * 本轮"没记住"的卡片数
     */
    private int forgotNum = 0;

    /**
     * 被复习的卡包
     */
    private CardBag cardBag;

    /**
     * 要复习的卡片队列
     */
    private List<CategorizedCard> cards;

    /**
     * 构造器
     */
    public ReviewManager(CardBag cardBag) {
        this.cardBag = cardBag;
        UIManager.cardBag = cardBag;
        rememberedNum = 0;
        forgotNum = 0;
        cards = null;
        setup();
    }

    /**
     * 初始化外观，也可用于外观更新
     */
    private void setup() {
        cards = cardBag.getCardNeedReview();
        setLayout(new BorderLayout());

        removeAll();
        int remain = cards.size();
        if (remain == 0) {
            // System.out.println("No cards");
            memoryCompletionPane = new MemoryCompletionPane(rememberedNum, forgotNum, cardBag.getTodayRemainNum(), cardBag.getColor());
            add(memoryCompletionPane);
            updateUI();
        } else {
            reviewPanel = new ReviewPanel(cards.get(0), remain, this);
            reviewPanel.setLocation(0, 0);
            add(reviewPanel);
            reviewPanel.requestFocus();
            updateUI();
        }

        setVisible(true);
    }

    /**
     * 选择"记住了"之后，对页面进行更新操作
     */
    public void remembered() {
        rememberedNum++;
        update();
    }

    /**
     * 选择"没记住"之后，对页面进行更新操作
     */
    public void forget() {
        forgotNum++;
        update();
    }

    /**
     * 更新页面
     */
    public void update() {
        setup();
        reviewPanel.update();
        setSize(new Dimension(
                UIConstant.mainPanelWidth - 95,
                UIConstant.mainPanelHeight - 100)
        );
    }

    /**
     * 复习面板
     */
    public ReviewPanel reviewPanel;

    /**
     * 复习结束后的总结面板
     */
    public MemoryCompletionPane memoryCompletionPane;

    public static void main(String[] args) {
        DataManager.init();
        DataManager.addCardBag("C", Color.gray, 20);
        for (int i = 0; i < 3; i++)
            DataManager.provideCardBag("C").addCard("Front\ncontent", "Back", true, MemStateConstants.newCard, false, null);
        JFrame frame = new JFrame();
        frame.setSize(1280, 720);

        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(1280, 720));
        frame.setLayout(new BorderLayout());
        frame.add(mainPanel, BorderLayout.CENTER);

        ReviewManager tmp = new ReviewManager(DataManager.provideCardBag("C"));
        tmp.setLocation(50, 25);
        frame.add(tmp);

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                UIConstant.mainPanelWidth = frame.getWidth();
                UIConstant.mainPanelHeight = frame.getHeight();
                tmp.update();
            }
        });
        frame.setVisible(true);
    }
}

