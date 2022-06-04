/*
 * Created by JFormDesigner on Sat May 28 15:39:11 CST 2022
 */

package com.MemWink.UI.panel;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * @author unknown
 */
public class CardBagPaneTop extends JPanel {
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


    public CardBagPaneTop() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        TotalCardsNum = new JLabel();
        DailyNewCardNum = new JLabel();

        //======== this ========

        //---- TotalCardsNum ----
        TotalCardsNum.setText("0");

        //---- DailyNewCardNum ----
        DailyNewCardNum.setText("0");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(177, Short.MAX_VALUE)
                    .addComponent(TotalCardsNum)
                    .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DailyNewCardNum)
                    .addContainerGap(177, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TotalCardsNum)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                    .addComponent(DailyNewCardNum)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JLabel TotalCardsNum;
    public JLabel DailyNewCardNum;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
