/*
 * Created by JFormDesigner on Mon May 16 09:51:36 CST 2022
 */

package com.MemWink.UI.panel;

import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.Data.DataManager;
import com.MemWink.UI.UIManager;
import com.MemWink.UI.dialog.AddPane;
import com.MemWink.UI.dialog.DeleteCardbag;
import com.MemWink.UI.dialog.ModifyDialog;
import com.MemWink.UI.frame.MainFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 卡包面板
 * <p>用于将其添加到卡包展示页面中再被绘制到主页面</p>
 * @author Feng Weilun
 */
public class CardBagPane extends JPanel {
    /**
     * 构造器
     * <p>每个卡包信息对应一个卡包</p>
     * <p>需从数据中心得到卡包数据来传入此面板以便于面板绘制</p>
     * @param cardBag 卡包面板对应的卡包数据
     */
    public CardBagPane(CardBag cardBag) {
        initComponents();
        this.cardBag = cardBag;
        this.cardBagPaneTop = new CardBagPaneTop(cardBag, this);
        this.add(cardBagPaneTop,BorderLayout.CENTER);
        menu.add(item1);
        this.item1.addActionListener(new item1Listener(this));
        menu.add(item2);
        this.item2.addActionListener(new item2Listener(this));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ( e.getButton() == MouseEvent.BUTTON3 ){
                    menu.show(e.getComponent(),e.getX(),e.getY());
                }
            }
        });
        beautifyUI();
    }

    private void beautifyUI() {
        // TODO: color
    }

    /**
     * 对点击卡包面板添加监听器
     * <p>若左键点击该面板会跳转至该卡包内部卡片页面</p>
     * @param e 鼠标事件
     */
    private void thisMouseClicked(MouseEvent e) {
        if ( e.getButton() == MouseEvent.BUTTON1 ){
            UIManager.cardBag = cardBag;
            ShowAllCards allCards = new ShowAllCards(cardBag,this);
            MainFrame.getMainFrame().mainPanel.removeAll();
            MainFrame.getMainFrame().mainPanel.add(allCards);
            MainFrame.getMainFrame().mainPanel.updateUI();
            allCards.setVisible(true);
            UIManager.showAllCards = allCards;
        }
    }

    /**
     * 初始化卡包面板
     * <p>在相应jfd文件中绘制好后由插件自动生成代码</p>
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label2 = new JLabel();

        //======== this ========
        setPreferredSize(new Dimension(170, 130));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                thisMouseClicked(e);
            }
        });
        setLayout(new BorderLayout());

        //---- label2 ----
        label2.setText("text");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        add(label2, BorderLayout.SOUTH);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    /**
     * 卡包页面由卡包UI和卡包名字组成
     * <p>此为卡包UI</p>
     * <p>信息与卡包对应</p>
     */
    public CardBagPaneTop cardBagPaneTop;
    /**
     * 弹窗页面
     */
    public JPopupMenu menu = new JPopupMenu();
    /**
     * 弹窗选项之卡包修改选项
     */
    public JMenuItem item1 = new JMenuItem("修改");
    /**
     * 弹窗选项之卡包删除选项
     */
    public JMenuItem item2 = new JMenuItem("删除");
    /**
     * 卡包对应的卡包数据
     */
    public CardBag cardBag;

    /**
     * 卡包页面内部类
     * <p>该内部类实现ActionListener接口</p>
     * <p>实现修改选项的监听器</p>
     * <p>该内部类仅在类内使用，故设计为private</p>
     */
    private class item1Listener implements ActionListener {
        /**
         * 调用该监听器的卡包页面
         * <p>储存该信息以便我们获取相关的卡包信息</p>
         */
         private CardBagPane panel;

        /**
         * 构造器
         * @param panel 调用该监听器的卡包页面
         */
         public item1Listener(CardBagPane panel){
             this.panel = panel;
         }

        /**
         * 重写actionPerformed方法，实现ActionListener接口
         * <p>当此按钮被按下时，调用卡包修改弹窗</p>
         * @param e 活动事件
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            ModifyDialog modifyDialog = new ModifyDialog(panel);
            modifyDialog.setVisible(true);
        }
    }

    /**
     * 卡包页面内部类
     * <p>该内部类实现ActionListener接口</p>
     * <p>实现删除选项的监听器</p>
     * <p>该内部类仅在类内使用，故设计为private</p>
     */
    private class item2Listener implements ActionListener {
        /**
         * 调用该监听器的卡包页面
         * <p>储存该信息以便我们获取相关的卡包信息</p>
         */
        private CardBagPane panel;
        /**
         * 构造器
         * @param panel 调用该监听器的卡包页面
         */
        public item2Listener(CardBagPane panel){
            this.panel = panel;
        }
        /**
         * 重写actionPerformed方法，实现ActionListener接口
         * <p>当此按钮被按下时，调用卡包删除弹窗</p>
         * @param e 活动事件
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteCardbag deleteCardbag = new DeleteCardbag(panel.cardBag);
            deleteCardbag.setVisible(true);
        }
    }
}
