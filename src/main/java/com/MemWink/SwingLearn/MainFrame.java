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
        setMaximizedBounds(new Rectangle(0, 0, 1920, 1080));
        setMinimumSize(new Dimension(835, 625));
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

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
            barPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
            ( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing. border
            . TitledBorder. BOTTOM, new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,barPanel. getBorder( )) ); barPanel. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
            propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
