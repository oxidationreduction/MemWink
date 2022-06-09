/*
 * Created by JFormDesigner on Mon Jun 06 21:01:23 CST 2022
 */

package com.MemWink.UI.dialog;

import com.MemWink.Data.DataManager;
import com.MemWink.UI.UIManager;
import com.MemWink.UI.panel.ShowCardBags;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * 添加帮助卡包确认弹窗
 * <p>当点击帮助按钮时该弹窗被呼出</p>
 * @author Feng Weilun
 */
public class HelpDialog extends JDialog {
    /**
     * 无参构造器
     */
    public HelpDialog() {
        initComponents();
    }

    /**
     * 取消按钮监听器
     * <p>此按钮被按下时取消添加帮助卡包</p>
     * @param e 按钮按下事件
     */
    private void no(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }

    /**
     * 确认按钮监听器
     * <p>此按钮被按下时添加帮助卡包，并将其显示到屏幕上</p>
     * @param e 按钮按下事件
     */
    private void yes(ActionEvent e) {
        // TODO add your code here
        DataManager.importExampleCardBag();
        UIManager.mainFrame.mainPanel.removeAll();
        UIManager.mainFrame.mainPanel.add(ShowCardBags.getShowCardBags());
        UIManager.mainFrame.mainPanel.updateUI();
        this.dispose();
    }

    /**
     * 初始化代码
     * <p>由相应的jfd文件绘制完成后，插件自动生成</p>
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        yes = new JButton();
        no = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u662f\u5426\u6dfb\u52a0\u5e2e\u52a9\u5361\u5305");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));

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
                    .addContainerGap(114, Short.MAX_VALUE)
                    .addComponent(label1)
                    .addGap(111, 111, 111))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addComponent(yes, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                    .addComponent(no, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                    .addGap(48, 48, 48))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(84, 84, 84)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(yes, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                        .addComponent(no, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                    .addGap(36, 36, 36))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JButton yes;
    private JButton no;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
