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
 * 卡包UI面板
 * <p>将此面板添加到卡包面板上配套使用</p>
 * @author Feng Weilun
 */
public class CardBagPaneTop extends JPanel {
    /**
     * 属于该卡包UI的卡包信息
     */
    private CardBag cardBag;

    /**
     * 附属的卡包面板
     */
    private CardBagPane pane;

    /**
     * 卡包UI页面内部类
     * <p>该内部类实现ActionListener接口</p>
     * <p>实现记忆卡片选项的监听器</p>
     * <p>该内部类仅在类内使用，故设计为private</p>
     */
    private class ButtonListener implements ActionListener {
        /**
         * 属于卡包UI的卡包信息
         */
        private CardBag cardBag;

        /**
         * 构造器
         * @param cardBag 属于卡包UI的卡包信息
         */
        private ButtonListener(CardBag cardBag) {
            this.cardBag = cardBag;
        }

        /**
         * 重写actionPerformed方法，实现ActionListener接口
         * <p>当此按钮被按下时，更新卡片列表页面并调用卡片复习页面</p>
         * @param e 活动事件
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            UIManager.mainFrame.mainPanel.removeAll();
            UIManager.showAllCards = new ShowAllCards(cardBag, pane);
            UIManager.mainFrame.mainPanel.add(new ReviewManager(cardBag));
            UIManager.mainFrame.mainPanel.updateUI();
        }
    }

    /**
     * 重写方法paint
     * <p>将此卡包UI面板绘制成圆角，美化UI</p>
     * @param g 画笔
     */
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

    /**
     * 构造器
     * <p>该构造器在展示卡包页面时调用</p>
     * <p>根据卡包信息来绘制相应的卡包UI</p>
     * <p>根据卡包内部卡片的复习情况来决定是否出现复习卡片的按钮</p>
     * @param cardBag 属于卡包UI的卡包信息
     */
    public CardBagPaneTop(CardBag cardBag, CardBagPane pane) {
        initComponents();
        this.cardBag = cardBag;
        this.pane = pane;
        this.setBackground(cardBag.getColor());
        this.TotalCardsNum.setText(Integer.toString(cardBag.getTotalCardsNum()));
        panel.setBackground(cardBag.getColor());
        if(cardBag.getReviewCardsNum()>0) {
            RoundButton button = new RoundButton();
            button.setFont(new Font("微软雅黑", Font.PLAIN, 9));
            button.setText("待复习:" + cardBag.getReviewCardsNum());
            button.setBackground(Color.white);
            button.addActionListener(new ButtonListener(cardBag));
            panel.add(button);
        }
    }

    /**
     * 构造器
     * <p>此构造器仅在修改卡包页面调用</p>
     * <p>无需考虑卡包内部卡片信息</p>
     */
    public CardBagPaneTop() {
        initComponents();
    }

    /**
     * 初始化卡包UI
     * <p>由相应的jfd文件绘制完成后自动生成代码</p>
     */
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
                    .addContainerGap()
                    .addComponent(panel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TotalCardsNum)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                    .addComponent(panel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                    .addGap(14, 14, 14))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JLabel TotalCardsNum;
    public JPanel panel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
