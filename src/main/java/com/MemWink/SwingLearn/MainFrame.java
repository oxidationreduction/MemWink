/*
 * Created by JFormDesigner on Sun May 15 18:50:15 CST 2022
 */

package com.MemWink.SwingLearn;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        initComponents();
        setSize(new Dimension(835, 625));
        int windowWidth = this.getWidth();                     //获得窗口宽

        int windowHeight = this.getHeight();                   //获得窗口高

        Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包

        Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸

        int screenWidth = screenSize.width;                     //获取屏幕的宽

        int screenHeight = screenSize.height;                   //获取屏幕的高

        this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
    }

    private void button2(ActionEvent e) {
        mainPanel.removeAll();
        mainPanel.add(ShowCardBags.getShowCardBags());
        mainPanel.updateUI();
    }

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


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        fileMenu = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();
        cardMenu = new JMenu();
        menuItem4 = new JMenuItem();
        menuItem5 = new JMenuItem();
        editMenu = new JMenu();
        menuItem6 = new JMenuItem();
        menuItem7 = new JMenuItem();
        menuItem8 = new JMenuItem();
        helpMenu = new JMenu();
        menuItem9 = new JMenuItem();
        menuItem10 = new JMenuItem();
        barPanel = new JPanel();
        upperPanel = new JPanel();
        functionPanel = new JPanel();
        cardBagButton = new JButton();
        staticticButton = new JButton();
        lowerPanel = new JPanel();
        helpButton = new JButton();
        mainPanel = new JPanel();

        //======== this ========
        setMaximizedBounds(new Rectangle(0, 0, 1920, 1080));
        setMinimumSize(new Dimension(835, 625));
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //======== fileMenu ========
            {
                fileMenu.setText("\u6587\u4ef6");

                //---- menuItem1 ----
                menuItem1.setText("\u65b0\u5efa\u5361\u5305");
                menuItem1.addActionListener(e -> menuItem1(e));
                fileMenu.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("\u5bfc\u5165\u5361\u5305");
                fileMenu.add(menuItem2);

                //---- menuItem3 ----
                menuItem3.setText("\u5220\u9664\u5361\u5305");
                fileMenu.add(menuItem3);
            }
            menuBar1.add(fileMenu);

            //======== cardMenu ========
            {
                cardMenu.setText("\u5361\u7247");

                //---- menuItem4 ----
                menuItem4.setText("\u65b0\u5efa\u5361\u7247");
                cardMenu.add(menuItem4);

                //---- menuItem5 ----
                menuItem5.setText("\u5220\u9664\u5361\u7247");
                cardMenu.add(menuItem5);
            }
            menuBar1.add(cardMenu);

            //======== editMenu ========
            {
                editMenu.setText("\u7f16\u8f91");

                //---- menuItem6 ----
                menuItem6.setText("\u4fee\u6539\u8bb0\u5fc6\u9636\u6bb5");
                editMenu.add(menuItem6);

                //---- menuItem7 ----
                menuItem7.setText("\u4fee\u6539\u5206\u7c7b");
                editMenu.add(menuItem7);

                //---- menuItem8 ----
                menuItem8.setText("\u8fdb\u5165\u7f16\u8f91\u9875\u9762");
                editMenu.add(menuItem8);
            }
            menuBar1.add(editMenu);

            //======== helpMenu ========
            {
                helpMenu.setText("\u5e2e\u52a9");

                //---- menuItem9 ----
                menuItem9.setText("\u5bfc\u5165\u793a\u4f8b\u5361\u5305");
                helpMenu.add(menuItem9);

                //---- menuItem10 ----
                menuItem10.setText("\u5173\u4e8e");
                helpMenu.add(menuItem10);
            }
            menuBar1.add(helpMenu);
        }
        setJMenuBar(menuBar1);

        //======== barPanel ========
        {
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

                    //---- staticticButton ----
                    staticticButton.setText("\u7edf\u8ba1");
                    staticticButton.addActionListener(e -> button3(e));
                    functionPanel.add(staticticButton);
                    staticticButton.setBounds(0, 70, 65, 65);

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
                helpButton.setText("text");
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
    public JMenuBar menuBar1;
    public JMenu fileMenu;
    public JMenuItem menuItem1;
    public JMenuItem menuItem2;
    public JMenuItem menuItem3;
    public JMenu cardMenu;
    public JMenuItem menuItem4;
    public JMenuItem menuItem5;
    public JMenu editMenu;
    public JMenuItem menuItem6;
    public JMenuItem menuItem7;
    public JMenuItem menuItem8;
    public JMenu helpMenu;
    public JMenuItem menuItem9;
    public JMenuItem menuItem10;
    public JPanel barPanel;
    public JPanel upperPanel;
    public JPanel functionPanel;
    public JButton cardBagButton;
    public JButton staticticButton;
    public JPanel lowerPanel;
    public JButton helpButton;
    public static JPanel mainPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
