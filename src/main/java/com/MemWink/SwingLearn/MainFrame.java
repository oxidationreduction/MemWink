/*
 * Created by JFormDesigner on Sun May 15 18:50:15 CST 2022
 */

package com.MemWink.SwingLearn;

import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.Data.DataManager;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.intellij.uiDesigner.core.*;

/**
 * @author unknown
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        initComponents();
        setSize(835,625);
        int windowWidth = this.getWidth();                     //获得窗口宽

        int windowHeight = this.getHeight();                   //获得窗口高

        Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包

        Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸

        int screenWidth = screenSize.width;                     //获取屏幕的宽

        int screenHeight = screenSize.height;                   //获取屏幕的高

        this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
    }

    private void button2(ActionEvent e) {
        panel1.removeAll();
        panel1.add(ShowCardBags.getShowCardBags());
        panel1.updateUI();
    }

    private void button3(ActionEvent e) {
        panel1.removeAll();
        panel1.add(new ShowStatics());
        panel1.updateUI();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menu2 = new JMenu();
        menu3 = new JMenu();
        menu4 = new JMenu();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel5 = new JPanel();
        button2 = new JButton();
        button3 = new JButton();
        panel4 = new JPanel();
        button1 = new JButton();
        panel1 = new JPanel();

        //======== this ========
        setMaximizedBounds(new Rectangle(0, 0, 1920, 1080));
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u6587\u4ef6");
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u5361\u7247");
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("\u7f16\u8f91");
            }
            menuBar1.add(menu3);

            //======== menu4 ========
            {
                menu4.setText("\u5e2e\u52a9");
            }
            menuBar1.add(menu4);
        }
        setJMenuBar(menuBar1);

        //======== panel2 ========
        {
            panel2.setLayout(new GridLayout(2, 1));

            //======== panel3 ========
            {
                panel3.setLayout(new GridLayout(2, 1));

                //======== panel5 ========
                {
                    panel5.setLayout(new GridLayout(2, 1));

                    //---- button2 ----
                    button2.setText("text");
                    button2.addActionListener(e -> button2(e));
                    panel5.add(button2);

                    //---- button3 ----
                    button3.setText("text");
                    button3.addActionListener(e -> button3(e));
                    panel5.add(button3);
                }
                panel3.add(panel5);
            }
            panel2.add(panel3);

            //======== panel4 ========
            {
                panel4.setLayout(new BorderLayout());

                //---- button1 ----
                button1.setText("text");
                panel4.add(button1, BorderLayout.SOUTH);
            }
            panel2.add(panel4);
        }
        contentPane.add(panel2, BorderLayout.WEST);

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout(1, 1));
        }
        contentPane.add(panel1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JMenuBar menuBar1;
    public JMenu menu1;
    public JMenu menu2;
    public JMenu menu3;
    public JMenu menu4;
    public JPanel panel2;
    public JPanel panel3;
    public JPanel panel5;
    public JButton button2;
    public JButton button3;
    public JPanel panel4;
    public JButton button1;
    public JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
