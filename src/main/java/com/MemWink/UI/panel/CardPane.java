/*
 * Created by JFormDesigner on Sun May 29 16:58:49 CST 2022
 */

package com.MemWink.UI.panel;

import com.MemWink.Data.CardBag.CategorizedCard;
import com.MemWink.UI.component.RoundPanel;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.*;



/**
 * @author unknown
 */
public class CardPane extends RoundPanel {
    public CardPane(CategorizedCard card) {
        initComponents();
        label1.setText(card.getCategory());
        label2.setText(card.getFrontString());
        int stageflag = card.getMemState();
        switch (stageflag){
            case -2:
                label3.setText("首次强化记忆");
                break;
            case -1:
                label3.setText("二次强化记忆");
                break;
            case 0:
                label3.setText("新卡");
                break;
            case 1:
                label3.setText("阶段一");
                break;
            case 2:
                label3.setText("阶段二");
                break;
            case 3:
                label3.setText("阶段三");
                break;
            case 4:
                label3.setText("阶段四");
                break;
            case 5:
                label3.setText("阶段五");
                break;
            case 6:
                label3.setText("已记住");
                break;
        }
    }


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

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
