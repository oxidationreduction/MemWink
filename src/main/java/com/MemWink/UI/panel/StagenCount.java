/*
 * Created by JFormDesigner on Mon May 30 22:12:29 CST 2022
 */

package com.MemWink.UI.panel;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class StagenCount extends JPanel {
    public StagenCount() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label3 = new JLabel();
        panel2 = new JPanel();
        label4 = new JLabel();
        panel3 = new JPanel();
        label5 = new JLabel();
        vSpacer1 = new JPanel(null);

        //======== this ========
        setPreferredSize(new Dimension(74, 73));
        setMaximumSize(new Dimension(74, 73));
        setMinimumSize(new Dimension(74, 73));
        setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new BorderLayout());

            //---- label3 ----
            label3.setText("number");
            label3.setHorizontalAlignment(SwingConstants.RIGHT);
            label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 8));
            panel1.add(label3, BorderLayout.CENTER);
        }
        add(panel1, BorderLayout.NORTH);

        //======== panel2 ========
        {
            panel2.setLayout(new BorderLayout());

            //---- label4 ----
            label4.setText("\u9636\u6bb5\u5206\u7c7b");
            label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 8));
            panel2.add(label4, BorderLayout.CENTER);
        }
        add(panel2, BorderLayout.SOUTH);

        //======== panel3 ========
        {
            panel3.setLayout(new BorderLayout());

            //---- label5 ----
            label5.setText("\u84dd\u70b9");
            label5.setHorizontalAlignment(SwingConstants.LEFT);
            label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 8));
            panel3.add(label5, BorderLayout.CENTER);

            //---- vSpacer1 ----
            vSpacer1.setPreferredSize(new Dimension(10, 180));
            panel3.add(vSpacer1, BorderLayout.PAGE_END);
        }
        add(panel3, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label3;
    private JPanel panel2;
    private JLabel label4;
    private JPanel panel3;
    private JLabel label5;
    private JPanel vSpacer1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
