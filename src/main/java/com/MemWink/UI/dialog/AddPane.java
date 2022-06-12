/*
 * Created by JFormDesigner on Mon May 16 20:00:47 CST 2022
 */

package com.MemWink.UI.dialog;

import com.MemWink.Data.DataManager;
import com.MemWink.UI.UIManager;
import com.MemWink.UI.panel.CardBagPaneTop;
import com.MemWink.UI.panel.ShowCardBags;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.*;

/**
 * 修改卡包弹窗
 * <p>用于在展示卡包页面点击添加按钮呼出</p>
 * @author Feng Weilun
 */
public class AddPane extends JDialog {
    /**
     * 构造器
     * <p>初始化一个修改卡包的弹窗</p>
     */
    public AddPane() {
        initComponents();
        initButtons();
        addColor = Color.blue;
    }

    /**
     * 初始化弹窗内的颜色按钮
     * <p>默认是蓝色按钮被选中</p>
     */
    private void initButtons() {
        top = new CardBagPaneTop();
        top.setBackground(Color.blue);
        top.panel.setBackground(Color.blue);
        example.add(top,BorderLayout.CENTER);
        colorButton button = new colorButton(Color.blue);
        button.selected = true;
        button.setBorder(BorderFactory.createLineBorder(Color.black));
        buttons.add(button);
        buttons.add(new colorButton(Color.black));
        buttons.add(new colorButton(Color.orange));
        buttons.add(new colorButton(Color.gray));
        buttons.add(new colorButton(Color.yellow));
        buttons.add(new colorButton(Color.green));

        for ( colorButton temp: buttons){
            colorPane.add(temp);
        }
    }

    /**
     * 为卡包名输入框添加监听器
     * <p>可随着输入文本的不同随时调整上方显示的卡包样式</p>
     * <p>方便用户观察卡包的样式</p>
     * <p>当此输入框和名字输入框的输入均合法才可保存新卡包</p>
     * @param e 文本框事件
     */
    private void textField1CaretUpdate(CaretEvent e) {
        label.setText(textField1.getText());
        if ( textField2.getText().matches("\\d+") && Integer.parseInt(textField2.getText()) > 0 && !label.getText().equals("") ){
            save.setForeground(Color.black);
        }
        else {
            save.setForeground(Color.lightGray);
        }
    }

    /**
     * 为卡片数量输入框添加监听器
     * <p>用到正则表达式来检查是否是合法的数字</p>
     * <p>当此输入框和名字输入框的输入均合法才可保存新卡包</p>
     * @param e 文本框事件
     */
    private void textField2CaretUpdate(CaretEvent e) {
        if ( textField2.getText().matches("\\d+") && Integer.parseInt(textField2.getText()) > 0 && !label.getText().equals("") ){
            save.setForeground(Color.black);
        }
        else {
            save.setForeground(Color.lightGray);
        }
    }

    /**
     * 为确定保存按钮添加监听器
     * <p>当参数均合法时保存相应的卡包并将其显示在屏幕上</p>
     * <p>无法保存时即为卡包名已保存过，将名字标红以提示用户</p>
     * @param e 鼠标事件
     */
    private void saveMouseClicked(MouseEvent e) {
        if ( save.getForeground() == Color.black ){
            if ( DataManager.addCardBag(textField1.getText(),addColor,Integer.parseInt(textField2.getText())) == 0 ){
                UIManager.mainFrame.mainPanel.removeAll();
                UIManager.mainFrame.mainPanel.add(ShowCardBags.getShowCardBags());
                UIManager.mainFrame.mainPanel.updateUI();
                UIManager.mainFrame.getContentPane();
                this.dispose();
            }
            else {
                label2.setForeground(Color.red);
            }
        }
    }

    /**
     * 初始化代码
     * <p>由相应的jfd文件绘制完成后，插件自动生成</p>
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Sun Yihan
        colorPane = new JPanel();
        save = new JLabel();
        example = new JPanel();
        label = new JLabel();
        panel2 = new JPanel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        textField2 = new JTextField();

        //======== this ========
        setBackground(Color.white);
        setModal(true);
        setTitle("\u5361\u5305\u8bbe\u7f6e");
        var contentPane = getContentPane();

        //======== colorPane ========
        {
            colorPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(
            0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder
            .BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.
            red),colorPane. getBorder()));colorPane. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.
            beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}});
            colorPane.setLayout(new GridLayout(1, 6, 5, 0));
        }

        //---- save ----
        save.setText("\u786e\u5b9a");
        save.setFont(save.getFont().deriveFont(save.getFont().getSize() + 8f));
        save.setBackground(Color.black);
        save.setForeground(Color.lightGray);
        save.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                saveMouseClicked(e);
            }
        });

        //======== example ========
        {
            example.setBorder(BorderFactory.createEmptyBorder());
            example.setLayout(new BorderLayout());

            //---- label ----
            label.setText("example");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            example.add(label, BorderLayout.SOUTH);
        }

        //======== panel2 ========
        {
            panel2.setLayout(new GridLayout(2, 2, 0, 5));

            //---- label2 ----
            label2.setText("\u8bf7\u8f93\u5165\u5361\u5305\u7684\u540d\u5b57\uff1a");
            label2.setHorizontalAlignment(SwingConstants.RIGHT);
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 8f));
            panel2.add(label2);

            //---- textField1 ----
            textField1.addCaretListener(e -> textField1CaretUpdate(e));
            panel2.add(textField1);

            //---- label3 ----
            label3.setText("\u8bf7\u8f93\u5165\u6bcf\u65e5\u590d\u4e60\u5361\u7247\u6570\u91cf\uff1a");
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 8f));
            label3.setHorizontalAlignment(SwingConstants.RIGHT);
            panel2.add(label3);

            //---- textField2 ----
            textField2.addCaretListener(e -> textField2CaretUpdate(e));
            panel2.add(textField2);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(117, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(save)
                            .addGap(37, 37, 37))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(colorPane, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)
                            .addGap(80, 80, 80))))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 524, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(168, 168, 168)
                            .addComponent(example, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(22, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(example, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(colorPane, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                    .addComponent(save)
                    .addGap(22, 22, 22))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Sun Yihan
    private JPanel colorPane;
    private JLabel save;
    private JPanel example;
    private JLabel label;
    private JPanel panel2;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    /**
     * 用于在此弹窗中展示的卡包样式
     */
    private CardBagPaneTop top;
    /**
     * 此时被选中的颜色
     * <p>默认为蓝色</p>
     */
    private Color addColor = Color.blue;
    /**
     * 储存颜色按钮的线性表
     * <p>默认有6个不同的颜色</p>
     */
    private LinkedList<colorButton> buttons = new LinkedList<>();

    /**
     * 私有类
     * <p>专属于此弹窗的颜色按钮</p>
     */
    private class colorButton extends JButton {
        /**
         * 该按钮的颜色
         */
        private Color color;
        /**
         * 该按钮目前是否被选中
         * <p>同一时间仅有一个按钮被选中</p>
         */
        private boolean selected = false;

        /**
         * 单参数构造器
         * <p>根据参数的颜色构造一个按钮</p>
         * @param color 该按钮的颜色
         */
        public colorButton(Color color) {
            this.color = color;
            this.setBackground(color);
            this.setBorder(BorderFactory.createLineBorder(this.color));
            this.addActionListener(new AddPane.ButtonListener(this));
        }
    }

    /**
     * 私有类
     * <p>实现了ActionListener接口</p>
     * <p>与私有的颜色按钮类相配套的按钮监听器</p>
     */
    private class ButtonListener implements ActionListener{
        /**
         * 该监听器监听的按钮
         */
        private colorButton button;

        /**
         * 单参数构造器
         * @param button 该监听器监听的按钮
         */
        public ButtonListener(colorButton button) {
            this.button = button;
        }

        /**
         * 重写ActionListener接口的actionPerformed方法
         * <p>设置专属的按钮行为</p>
         * <p>卡包颜色会随着不同按钮的按下而改变</p>
         * <p>同一时间仅有一个按钮会被选中</p>
         * @param e 按钮按下行为
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if ( !button.selected ){
                colorButton temp = new colorButton(Color.black);
                for ( colorButton colorButton: buttons){
                    if ( colorButton.selected){
                        temp = colorButton;
                    }
                }
                temp.selected = false;
                temp.setBorder(BorderFactory.createLineBorder(temp.color));
                button.selected = true;
                button.setBorder(BorderFactory.createLineBorder(Color.black));
                top.setBackground(button.color);
                top.panel.setBackground(button.color);
                addColor = button.color;
            }
        }
    }
}
