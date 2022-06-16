/*
 * Created by JFormDesigner on Sun May 15 18:50:15 CST 2022
 */

package com.MemWink.UI.frame;

import com.MemWink.UI.UIManager;
import com.MemWink.UI.dialog.AddPane;
import com.MemWink.UI.dialog.HelpDialog;
import com.MemWink.UI.panel.*;
import com.MemWink.util.MemWinkUtil;
import com.MemWink.util.constant.UIConstant;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

/**
 * 程序主页面
 * @author Feng Weilun
 */
public class MainFrame extends JFrame {
    /**
     * 静态类属性
     * <p>单例模式，仅存在一个该类实例对象</p>
     */
    private static MainFrame mainFrame = new MainFrame();

    /**
     * 单例模式方法
     * <p>用于获得唯一的主页面</p>
     * @return 主页面
     */
    public static MainFrame getMainFrame() {
        return mainFrame;
    }

    /**
     * 无参数构造器
     * <p>单例模式构造器，故设计为private</p>
     */
    private MainFrame() {
        initComponents();
        beautifyUI();
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        int windowWidth = this.getWidth();                     //获得窗口宽

        int windowHeight = this.getHeight();                   //获得窗口高

        Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包

        Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸

        int screenWidth = screenSize.width;                     //获取屏幕的宽

        int screenHeight = screenSize.height;                   //获取屏幕的高

        this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示

        UIConstant.mainPanelWidth = mainPanel.getWidth();
        UIConstant.mainPanelHeight = mainPanel.getHeight();

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                UIConstant.mainPanelWidth = mainPanel.getWidth();
                UIConstant.mainPanelHeight = mainPanel.getHeight();
                // System.out.println(UIConstant.mainPanelWidth + " * " + UIConstant.mainPanelHeight);
                if (mainPanel.getComponents().length == 0) {
                    return;
                }
                if (mainPanel.getComponents()[0] instanceof CardContent) {
                    ((CardContent) mainPanel.getComponents()[0]).update();
                }  else if (mainPanel.getComponents()[0] instanceof ReviewManager) {
                    ((ReviewManager) mainPanel.getComponents()[0]).update();
                }  else {
                    // System.out.println(mainPanel.getComponents()[0].getClass());
                }
            }
        });
    }

    /**
     * 美化UI
     * @author Liu Hongyu
     * @since 2022-06-08
     */
    public void beautifyUI() {
        upperPanel.setBackground(new Color(37, 174, 96));
        functionPanel.setBackground(new Color(37, 174, 96));
        lowerPanel.setBackground(new Color(37, 174, 96));

        cardBagButton.setText(null);
        cardBagButton.setSize(upperPanel.getWidth(), upperPanel.getWidth());
        cardBagButton.setIcon(new ImageIcon("image/CardBag.png"));

        statisticButton.setSize(cardBagButton.getSize());
        statisticButton.setText(null);
        statisticButton.setLocation(statisticButton.getX(), statisticButton.getY() + 5);
        statisticButton.setIcon(MemWinkUtil.getScaledIcon("Statistic",
                (int) Math.round(0.85 * statisticButton.getWidth()),
                (int) Math.round(0.85 * statisticButton.getHeight())));
    }

    /**
     * 卡包按钮监听器
     * <p>按下该按钮会刷新卡包页面并将其显示在屏幕中</p>
     * @param e 按钮按下事件
     */
    private void button2(ActionEvent e) {
        UIManager.cardBag = null;
        mainPanel.removeAll();
        mainPanel.add(ShowCardBags.getShowCardBags());
        mainPanel.updateUI();
    }

    /**
     * 统计按钮监听器
     * <p>按下该按钮会刷新统计页面并将其显示在屏幕中</p>
     * @param e 按钮按下事件
     */
    private void button3(ActionEvent e) {
        mainPanel.removeAll();
        mainPanel.add(new ShowStatics());
        mainPanel.updateUI();
    }

    private void menuItem1(ActionEvent e) {
        AddPane pane = new AddPane();
        pane.setVisible(true);
        JButton tmp = new JButton();
        tmp.setLocation(300, 200);
        add(tmp);
    }

    /**
     * 帮助按钮监听器
     * <p>按下该按钮会呼出帮助卡包添加确认弹窗</p>
     * @param e 按钮按下事件
     */
    private void help(ActionEvent e) {
        // TODO add your code here
        HelpDialog helpDialog = new HelpDialog();
        helpDialog.setVisible(true);
    }

    /**
     * 初始化代码
     * <p>由相应的jfd文件绘制完成后，插件自动生成</p>
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Sun Yihan
        barPanel = new JPanel();
        upperPanel = new JPanel();
        functionPanel = new JPanel();
        cardBagButton = new JButton();
        statisticButton = new JButton();
        lowerPanel = new JPanel();
        helpButton = new JButton();
        mainPanel = new JPanel();

        //======== this ========
        setMaximizedBounds(new Rectangle(0, 0, 1920, 1080));
        setMinimumSize(new Dimension(835, 625));
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== barPanel ========
        {
            barPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
            javax.swing.border.EmptyBorder(0,0,0,0), null,javax
            .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
            .awt.Font("D\u0069alog",java.awt.Font.BOLD,12),java.awt
            .Color.red),barPanel. getBorder()));barPanel. addPropertyChangeListener(new java.beans.
            PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".
            equals(e.getPropertyName()))throw new RuntimeException();}});
            barPanel.setLayout(new GridLayout(2, 1));

            //======== upperPanel ========
            {
                upperPanel.setLayout(new GridLayout(2, 1));

                //======== functionPanel ========
                {
                    functionPanel.setLayout(null);

                    //---- cardBagButton ----
                    cardBagButton.setText("\u5361\u5305");
                    cardBagButton.addActionListener(e -> button2(e));
                    functionPanel.add(cardBagButton);
                    cardBagButton.setBounds(0, 0, 65, 65);

                    //---- statisticButton ----
                    statisticButton.setText("\u7edf\u8ba1");
                    statisticButton.addActionListener(e -> button3(e));
                    functionPanel.add(statisticButton);
                    statisticButton.setBounds(0, 70, 65, 65);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < functionPanel.getComponentCount(); i++) {
                            Rectangle bounds = functionPanel.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = functionPanel.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        functionPanel.setMinimumSize(preferredSize);
                        functionPanel.setPreferredSize(preferredSize);
                    }
                }
                upperPanel.add(functionPanel);
            }
            barPanel.add(upperPanel);

            //======== lowerPanel ========
            {
                lowerPanel.setLayout(new BorderLayout());

                //---- helpButton ----
                helpButton.setText("\u5e2e\u52a9");
                helpButton.addActionListener(e -> help(e));
                lowerPanel.add(helpButton, BorderLayout.SOUTH);
            }
            barPanel.add(lowerPanel);
        }
        contentPane.add(barPanel, BorderLayout.WEST);

        //======== mainPanel ========
        {
            mainPanel.setLayout(new GridLayout(1, 1));
        }
        contentPane.add(mainPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Sun Yihan
    public JPanel barPanel;
    public JPanel upperPanel;
    public JPanel functionPanel;
    public JButton cardBagButton;
    public JButton statisticButton;
    public JPanel lowerPanel;
    public JButton helpButton;
    public JPanel mainPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
