/*
 * Created by JFormDesigner on Sun May 15 18:50:15 CST 2022
 */

package com.MemWink.SwingLearn;

import com.MemWink.UI.UIConstant;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        initComponents();
        // setPreferredSize(new Dimension(835, 625));
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
        mainPanel.add(showCardBags);
        mainPanel.updateUI();
    }

    private void button3(ActionEvent e) {
        mainPanel.removeAll();
        mainPanel.add(showStatics);
        mainPanel.updateUI();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - 刘洪宇
        menuBar1 = new JMenuBar();
        fileMenu = new JMenu();
        cardMenu = new JMenu();
        editMenu = new JMenu();
        helpMenu = new JMenu();
        barPanel = new JPanel();
        upperPanel = new JPanel();
        functionPanel = new JPanel();
        cardBagButton = new JButton();
        staticticButton = new JButton();
        lowerPanel = new JPanel();
        helpButton = new JButton();
        mainPanel = new JPanel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        setResizable(true);
        setBounds(new Rectangle(0, 0, 1280, 720));
        setMinimumSize(new Dimension(835, 625));

        //======== menuBar1 ========
        {

            //======== fileMenu ========
            {
                fileMenu.setText("\u6587\u4ef6");
            }
            menuBar1.add(fileMenu);

            //======== cardMenu ========
            {
                cardMenu.setText("\u5361\u7247");
            }
            menuBar1.add(cardMenu);

            //======== editMenu ========
            {
                editMenu.setText("\u7f16\u8f91");
            }
            menuBar1.add(editMenu);

            //======== helpMenu ========
            {
                helpMenu.setText("\u5e2e\u52a9");
            }
            menuBar1.add(helpMenu);
        }
        setJMenuBar(menuBar1);

        //======== barPanel ========
        {
            barPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
            border.EmptyBorder(0,0,0,0), "",javax.swing.border.TitledBorder.CENTER
            ,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font
            .BOLD,12),java.awt.Color.red),barPanel. getBorder()));barPanel. addPropertyChangeListener(
            new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r"
            .equals(e.getPropertyName()))throw new RuntimeException();}});
            barPanel.setLayout(new GridLayout(2, 1));

            //======== upperPanel ========
            {
                upperPanel.setLayout(new GridLayout(2, 1));

                //======== functionPanel ========
                {
                    functionPanel.setLayout(null);

                    //---- cardBagButton ----
                    cardBagButton.setText("卡包");
                    cardBagButton.setLocation(0, 0);
                    cardBagButton.setSize(65, 65);
                    cardBagButton.addActionListener(e -> button2(e));
                    functionPanel.add(cardBagButton);

                    //---- staticticButton ----
                    staticticButton.setText("统计");
                    staticticButton.setSize(65, 65);
                    staticticButton.setLocation(0, 70);
                    staticticButton.addActionListener(e -> button3(e));
                    functionPanel.add(staticticButton);
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
        setLocationRelativeTo(null);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                UIConstant.windowWidth = getWidth();
                UIConstant.windowHeight = getHeight();
                showCardBags.updateSize();
                showStatics.updateSize();

                System.out.println("W: " + UIConstant.windowWidth + ", H: " + UIConstant.windowHeight);
            }
        });
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - 刘洪宇
    public JMenuBar menuBar1;
    public JMenu fileMenu;
    public JMenu cardMenu;
    public JMenu editMenu;
    public JMenu helpMenu;
    public JPanel barPanel;
    public JPanel upperPanel;
    public JPanel functionPanel;
    public JButton cardBagButton;
    public JButton staticticButton;
    public JPanel lowerPanel;
    public JButton helpButton;
    public JPanel mainPanel;
    public ShowCardBags showCardBags = new ShowCardBags();
    public ShowStatics showStatics = new ShowStatics();
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
