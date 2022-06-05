/*
 * Created by JFormDesigner on Sat May 28 15:39:11 CST 2022
 */

package com.MemWink.UI.panel;

import com.MemWink.Data.CardBag.Card;
import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.UI.UIManager;
import com.MemWink.UI.component.RoundButton;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * @author unknown
 */
public class CardBagPaneTop extends JPanel {
    private CardBag cardBag;
    private class ButtonListener implements ActionListener {
        private CardBag cardBag;

        private ButtonListener(CardBag cardBag) {
            this.cardBag = cardBag;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            UIManager.mainFrame.mainPanel.removeAll();
            UIManager.mainFrame.mainPanel.add(new ReviewManager(cardBag));
            UIManager.mainFrame.mainPanel.updateUI();
        }
    }

    @Override
    public void paint(Graphics g) {
        int fieldX = 0;
        int fieldY = 0;
        int fieldWeight = getSize().width;
        int fieldHeight = getSize().height;
        RoundRectangle2D rect = new RoundRectangle2D.Double(fieldX, fieldY, fieldWeight, fieldHeight, 20, 20);
        g.setClip(rect);
        super.paint(g);
    }


    public CardBagPaneTop(CardBag cardBag) {
        initComponents();
        this.cardBag = cardBag;
        this.setBackground(cardBag.getColor());
        this.TotalCardsNum.setText(Integer.toString(cardBag.getTotalCardsNum()));
        panel.setBackground(cardBag.getColor());
        if(cardBag.getReviewCardsNum()>0) {
            RoundButton button = new RoundButton();
            button.setText(Integer.toString(cardBag.getReviewCardsNum()));
            button.setBackground(Color.white);
            button.addActionListener(new ButtonListener(cardBag));
            panel.add(button);
        }
    }

    public CardBagPaneTop() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        TotalCardsNum = new JLabel();
        panel = new JPanel();

        //======== this ========

        //---- TotalCardsNum ----
        TotalCardsNum.setText("0");

        //======== panel ========
        {
            panel.setLayout(new GridLayout(1, 1));
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(177, Short.MAX_VALUE)
                    .addComponent(TotalCardsNum)
                    .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(panel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TotalCardsNum)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                    .addComponent(panel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                    .addGap(15, 15, 15))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JLabel TotalCardsNum;
    public JPanel panel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
