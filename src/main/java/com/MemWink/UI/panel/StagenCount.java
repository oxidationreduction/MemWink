/*
 * Created by JFormDesigner on Mon May 30 22:12:29 CST 2022
 */

package com.MemWink.UI.panel;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class StagenCount extends JPanel {
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
    public StagenCount() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label3 = new JLabel();
        hSpacer2 = new JPanel(null);
        vSpacer3 = new JPanel(null);
        panel2 = new JPanel();
        label4 = new JLabel();
        vSpacer2 = new JPanel(null);
        hSpacer1 = new JPanel(null);
        panel3 = new JPanel();
        label5 = new JLabel();
        vSpacer1 = new JPanel(null);

        //======== this ========
        setPreferredSize(new Dimension(74, 73));
        setMaximumSize(new Dimension(74, 73));
        setMinimumSize(new Dimension(74, 73));
        setBorder(null);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBackground(Color.lightGray);
            panel1.setLayout(new BorderLayout());

            //---- label3 ----
            label3.setText("number");
            label3.setHorizontalAlignment(SwingConstants.RIGHT);
            label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 8));
            label3.setBackground(Color.lightGray);
            panel1.add(label3, BorderLayout.CENTER);

            //---- hSpacer2 ----
            hSpacer2.setBackground(Color.lightGray);
            hSpacer2.setPreferredSize(new Dimension(13, 10));
            panel1.add(hSpacer2, BorderLayout.EAST);

            //---- vSpacer3 ----
            vSpacer3.setBackground(Color.lightGray);
            vSpacer3.setPreferredSize(new Dimension(10, 11));
            panel1.add(vSpacer3, BorderLayout.NORTH);
        }
        add(panel1, BorderLayout.NORTH);

        //======== panel2 ========
        {
            panel2.setBackground(Color.lightGray);
            panel2.setLayout(new BorderLayout());

            //---- label4 ----
            label4.setText("\u9636\u6bb5\u5206\u7c7b");
            label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 8));
            label4.setBackground(Color.lightGray);
            panel2.add(label4, BorderLayout.CENTER);

            //---- vSpacer2 ----
            vSpacer2.setBackground(Color.lightGray);
            vSpacer2.setPreferredSize(new Dimension(10, 11));
            panel2.add(vSpacer2, BorderLayout.SOUTH);

            //---- hSpacer1 ----
            hSpacer1.setBackground(Color.lightGray);
            hSpacer1.setPreferredSize(new Dimension(13, 10));
            panel2.add(hSpacer1, BorderLayout.WEST);
        }
        add(panel2, BorderLayout.SOUTH);

        //======== panel3 ========
        {
            panel3.setBackground(Color.lightGray);
            panel3.setLayout(new BorderLayout());

            //---- label5 ----
            label5.setText("\u84dd\u70b9");
            label5.setHorizontalAlignment(SwingConstants.LEFT);
            label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 8));
            label5.setBackground(Color.lightGray);
            panel3.add(label5, BorderLayout.CENTER);

            //---- vSpacer1 ----
            vSpacer1.setPreferredSize(new Dimension(10, 180));
            vSpacer1.setBackground(Color.lightGray);
            panel3.add(vSpacer1, BorderLayout.PAGE_END);
        }
        add(panel3, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label3;
    private JPanel hSpacer2;
    private JPanel vSpacer3;
    private JPanel panel2;
    private JLabel label4;
    private JPanel vSpacer2;
    private JPanel hSpacer1;
    private JPanel panel3;
    private JLabel label5;
    private JPanel vSpacer1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
