/*
 * Created by JFormDesigner on Sun May 29 16:58:49 CST 2022
 */

package com.MemWink.UI.panel;

import java.awt.event.*;

import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.Data.CardBag.CategorizedCard;
import com.MemWink.UI.component.RoundPanel;
import com.MemWink.UI.UIManager;
import com.MemWink.util.MemWinkUtil;
import com.MemWink.util.constant.MemStateConstants;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.*;



/**
 * @author unknown
 */
public class CardPane extends RoundPanel {
    public CardPane(CategorizedCard card, Color color) {
        initComponents();
        this.setBackground(color);
        this.card = card;
        label1.setText(" " + card.getCategory());
        label2.setText(card.getFrontString());
        label3.setText(MemStateConstants.getStageLabel(card.getMemState()) + " ");
        beautifyUI();
    }

    public void beautifyUI() {
        label1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        label2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        label3.setFont(new Font("微软雅黑", Font.PLAIN, 12));

        if (!MemWinkUtil.isBrightColor(card.getCardBagColor())) {
            label1.setForeground(Color.WHITE);
            label2.setForeground(Color.WHITE);
            label3.setForeground(Color.WHITE);
        }
    }

    private void thisMouseClicked(MouseEvent e) {
        CardContent cardContent = new CardContent(card);
        UIManager.mainFrame.mainPanel.removeAll();
        UIManager.mainFrame.mainPanel.add(cardContent);
        ((CardContent) UIManager.mainFrame.mainPanel.getComponents()[0]).update();
        UIManager.mainFrame.mainPanel.updateUI();
    }

    /*private void thisMouseClicked(MouseEvent e) {
        CardContent cardContent = new CardContent(card);
        UIManager.mainFrame.mainPanel.removeAll();
        UIManager.mainFrame.mainPanel.add(cardContent);
        UIManager.mainFrame.mainPanel.updateUI();
    }*/


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();

        //======== this ========
        setForeground(new Color(238, 238, 238));
        setBackground(new Color(51, 51, 255));
        setMaximumSize(new Dimension(170, 164));
        setPreferredSize(new Dimension(170, 180));
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                thisMouseClicked(e);
            }
        });
        setLayout(new BorderLayout());

        //---- label1 ----
        label1.setText("\u5206\u7c7b");
        label1.setVerticalAlignment(SwingConstants.BOTTOM);
        add(label1, BorderLayout.NORTH);

        //---- label2 ----
        label2.setText("\u5361\u7247\u4fe1\u606f");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        add(label2, BorderLayout.CENTER);

        //---- label3 ----
        label3.setText("\u9636\u6bb5");
        label3.setHorizontalAlignment(SwingConstants.RIGHT);
        label3.setMaximumSize(new Dimension(170, 130));
        label3.setMinimumSize(new Dimension(170, 130));
        add(label3, BorderLayout.SOUTH);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    private CategorizedCard card;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
