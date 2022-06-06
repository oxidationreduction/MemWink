package com.MemWink.UI.panel;

import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.Data.CardBag.CategorizedCard;
import com.MemWink.util.constant.MemStateConstants;
import com.MemWink.Data.DataManager;
import com.MemWink.util.constant.UIConstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ReviewManager extends JPanel {
    private int rememberedNum = 0;
    private int forgotNum = 0;
    private CardBag cardBag;
    private List<CategorizedCard> cards;

    public ReviewManager(CardBag cardBag) {
        this.cardBag = cardBag;
        rememberedNum = 0;
        forgotNum = 0;
        cards = null;
        setup();
    }

    private void setup() {
        cards = cardBag.getCardNeedReview();
        setLayout(null);

        removeAll();
        int remain = cards.size();
        if (remain == 0) {
            System.out.println("No cards");
        } else {
            reviewPanel = new ReviewPanel(cards.get(0), remain, this);
            reviewPanel.setLocation(0, 0);
            add(reviewPanel);
            reviewPanel.requestFocus();
            updateUI();
        }

        setVisible(true);
    }

    public void remembered() {
        rememberedNum++;
        setup();
    }
    public void forget() {
        forgotNum++;
        setup();
    }

    public void update() {
        setup();
        reviewPanel.update();
        setSize(new Dimension(
                UIConstant.windowWidth - 95,
                UIConstant.windowHeight - 100)
        );
    }

    public ReviewPanel reviewPanel;

    public static void main(String[] args) {
        DataManager.init();
        DataManager.addCardBag("C", Color.gray, 20);
        for (int i = 0; i < 3; i++)
            DataManager.provideCardBag("C").addCard("Front\ncontent", "Back", true, MemStateConstants.newCard, false, null);
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(1280, 720);
        ReviewManager tmp = new ReviewManager(DataManager.provideCardBag("C"));
        tmp.setLocation(50, 25);
        frame.add(tmp);

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                UIConstant.windowWidth = frame.getWidth();
                UIConstant.windowHeight = frame.getHeight();
                tmp.update();
            }
        });
        frame.setVisible(true);
    }
}

