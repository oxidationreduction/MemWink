/*
 * Created by JFormDesigner on Mon Jun 06 16:37:22 CST 2022
 */

package com.MemWink.UI.dialog;

import java.awt.event.*;
import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.Data.DataManager;
import com.MemWink.UI.UIManager;
import com.MemWink.UI.panel.ShowCardBags;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * 删除卡包确认弹窗
 * <p>当卡包被右键并选中删除按钮时呼出该弹窗</p>
 * @author Feng Weilun
 */
public class DeleteCardbag extends JDialog {
    /**
     * 要删除的卡包信息
     */
    private CardBag cardBag;

    /**
     * 单参数构造器
     * @param cardBag 要删除的卡包信息
     */
    public DeleteCardbag(CardBag cardBag) {
        this.cardBag = cardBag;
        initComponents();
    }

    /**
     * 确认删除按钮监听器
     * <p>当此按钮被按下时删除该卡包信息并将其从屏幕上移除</p>
     * @param e 按钮按下事件
     */
    private void yes(ActionEvent e) {
        DataManager.delCardBag(cardBag.getName());
        UIManager.mainFrame.mainPanel.removeAll();
        UIManager.mainFrame.mainPanel.add(ShowCardBags.getShowCardBags());
        UIManager.mainFrame.mainPanel.updateUI();
        this.dispose();
    }

    /**
     * 取消删除按钮监听器
     * <p>当此按钮被按下时不进行删除操作</p>
     * @param e 按钮按下事件
     */
    private void no(ActionEvent e) {
        this.dispose();
    }

    /**
     * 初始化代码
     * <p>由相应的jfd文件绘制完成后，插件自动生成</p>
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        yes = new JButton();
        no = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u662f\u5426\u786e\u5b9a\u5220\u9664\u8be5\u5361\u5305\uff1f");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));

        //---- label2 ----
        label2.setText("\u8be5\u64cd\u4f5c\u65e0\u6cd5\u6062\u590d");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 10f));

        //---- yes ----
        yes.setText("\u662f");
        yes.setFont(yes.getFont().deriveFont(yes.getFont().getSize() + 5f));
        yes.addActionListener(e -> yes(e));

        //---- no ----
        no.setText("\u5426");
        no.setFont(no.getFont().deriveFont(no.getFont().getSize() + 5f));
        no.addActionListener(e -> no(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(92, Short.MAX_VALUE)
                    .addComponent(label1)
                    .addGap(90, 90, 90))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(121, 121, 121)
                    .addComponent(label2)
                    .addContainerGap(126, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(yes, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                    .addComponent(no, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                    .addGap(49, 49, 49))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(yes, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                        .addComponent(no, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
                    .addGap(53, 53, 53))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JButton yes;
    private JButton no;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
