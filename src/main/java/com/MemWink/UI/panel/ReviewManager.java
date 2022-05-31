package com.MemWink.UI.panel;

import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.Data.CardBag.CategorizedCard;
import com.MemWink.Data.CardBag.MemStateConstants;
import com.MemWink.Data.DataManager;
import com.MemWink.UI.UIConstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
        System.out.println(cardBag.getCardNeedReview().size());;
        setup();
    }

    private void setup() {
        cards = cardBag.getCardNeedReview();
        setLayout(null);

        removeAll();
        if (cards.size() == 0) {
            System.out.println("Card size == 0");
        } else {
            System.out.println("size != 0");
            reviewPanel = new ReviewPanel(cards.get(0), this);
            reviewPanel.setLocation(0, 0);
            add(reviewPanel);
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
        reviewPanel.update();
        setSize(new Dimension(
                UIConstant.windowWidth - 95,
                UIConstant.windowHeight - 180)
        );
    }

    public ReviewPanel reviewPanel;

    public static void main(String[] args) {
        DataManager.init();
        DataManager.addCardBag("A", Color.gray, 20);
        DataManager.provideCardBag("A").addCard("Front\ncontent", "Back", true, MemStateConstants.newCard, false, null);
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(1280, 720);
        ReviewManager tmp = new ReviewManager(DataManager.provideCardBag("A"));
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
        frame.addKeyListener(tmp.reviewPanel.getKeyAdapter());
        tmp.requestFocus();
        frame.setVisible(true);
    }
}
