/*
 * Created by JFormDesigner on Wed Jun 01 10:17:43 CST 2022
 */

package com.MemWink.UI.panel;

import com.MemWink.UI.component.RoundButton;
import com.MemWink.UI.component.RoundPanel;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.*;

/**
 * @author unknown
 */
public class MemoryCompletionPane extends JPanel {

    public MemoryCompletionPane() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        vSpacer1 = new JPanel(null);
        label1 = new JLabel();
        vSpacer21 = new JPanel(null);
        panel2 = new JPanel();
        vSpacer2 = new JPanel(null);
        button1 = new RoundButton();
        hSpacer1 = new JPanel(null);
        hSpacer2 = new JPanel(null);
        vSpacer22 = new JPanel(null);
        panel3 = new JPanel();
        panel4 = new RoundPanel();
        panel8 = new JPanel();
        label2 = new JLabel();
        hSpacer5 = new JPanel(null);
        vSpacer3 = new JPanel(null);
        label3 = new JLabel();
        hSpacer6 = new JPanel(null);
        vSpacer4 = new JPanel(null);
        panel9 = new JPanel();
        label4 = new JLabel();
        hSpacer7 = new JPanel(null);
        vSpacer5 = new JPanel(null);
        vSpacer6 = new JPanel(null);
        panel5 = new JPanel();
        panel13 = new RoundPanel();
        panel14 = new JPanel();
        panel15 = new JPanel();
        label8 = new JLabel();
        hSpacer11 = new JPanel(null);
        vSpacer11 = new JPanel(null);
        label9 = new JLabel();
        hSpacer12 = new JPanel(null);
        vSpacer12 = new JPanel(null);
        panel16 = new JPanel();
        label10 = new JLabel();
        hSpacer13 = new JPanel(null);
        vSpacer13 = new JPanel(null);
        vSpacer14 = new JPanel(null);
        panel17 = new RoundPanel();
        panel18 = new JPanel();
        panel19 = new JPanel();
        label11 = new JLabel();
        hSpacer14 = new JPanel(null);
        vSpacer15 = new JPanel(null);
        label12 = new JLabel();
        hSpacer15 = new JPanel(null);
        vSpacer16 = new JPanel(null);
        panel20 = new JPanel();
        label13 = new JLabel();
        hSpacer16 = new JPanel(null);
        vSpacer17 = new JPanel(null);
        vSpacer18 = new JPanel(null);
        hSpacer17 = new JPanel(null);
        panel6 = new RoundPanel();
        panel21 = new JPanel();
        panel22 = new JPanel();
        label14 = new JLabel();
        hSpacer18 = new JPanel(null);
        vSpacer19 = new JPanel(null);
        label15 = new JLabel();
        hSpacer19 = new JPanel(null);
        vSpacer20 = new JPanel(null);
        hSpacer20 = new JPanel(null);
        panel7 = new RoundPanel();
        panel10 = new JPanel();
        panel11 = new JPanel();
        label5 = new JLabel();
        hSpacer8 = new JPanel(null);
        vSpacer7 = new JPanel(null);
        label6 = new JLabel();
        hSpacer9 = new JPanel(null);
        vSpacer8 = new JPanel(null);
        panel12 = new JPanel();
        label7 = new JLabel();
        hSpacer10 = new JPanel(null);
        vSpacer9 = new JPanel(null);
        vSpacer10 = new JPanel(null);
        hSpacer3 = new JPanel(null);
        hSpacer4 = new JPanel(null);
        hSpacer21 = new JPanel(null);

        //======== this ========
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new BorderLayout());

            //---- vSpacer1 ----
            vSpacer1.setPreferredSize(new Dimension(10, 50));
            vSpacer1.setMinimumSize(new Dimension(12, 80));
            panel1.add(vSpacer1, BorderLayout.NORTH);

            //---- label1 ----
            label1.setText("\u8bb0\u5fc6\u5b8c\u6210");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
            panel1.add(label1, BorderLayout.CENTER);

            //---- vSpacer21 ----
            vSpacer21.setPreferredSize(new Dimension(10, 30));
            panel1.add(vSpacer21, BorderLayout.SOUTH);
        }
        add(panel1, BorderLayout.NORTH);

        //======== panel2 ========
        {
            panel2.setBackground(UIManager.getColor("Button.background"));
            panel2.setLayout(new BorderLayout());

            //---- vSpacer2 ----
            vSpacer2.setPreferredSize(new Dimension(10, 60));
            panel2.add(vSpacer2, BorderLayout.SOUTH);

            //---- button1 ----
            button1.setText("\u786e\u8ba4");
            button1.setBackground(new Color(102, 255, 102));
            button1.setForeground(new Color(238, 238, 238));
            panel2.add(button1, BorderLayout.CENTER);

            //---- hSpacer1 ----
            hSpacer1.setPreferredSize(new Dimension(300, 10));
            panel2.add(hSpacer1, BorderLayout.EAST);

            //---- hSpacer2 ----
            hSpacer2.setPreferredSize(new Dimension(300, 10));
            panel2.add(hSpacer2, BorderLayout.WEST);

            //---- vSpacer22 ----
            vSpacer22.setPreferredSize(new Dimension(10, 60));
            panel2.add(vSpacer22, BorderLayout.NORTH);
        }
        add(panel2, BorderLayout.SOUTH);

        //======== panel3 ========
        {
            panel3.setLayout(new GridLayout(2, 2, 30, 20));

            //======== panel4 ========
            {
                panel4.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                panel4.setLayout(new BorderLayout());

                //======== panel8 ========
                {
                    panel8.setLayout(new BorderLayout());

                    //---- label2 ----
                    label2.setText("\u672c\u6b21\u5b66\u4e60");
                    panel8.add(label2, BorderLayout.CENTER);
                    panel8.add(hSpacer5, BorderLayout.WEST);
                    panel8.add(vSpacer3, BorderLayout.NORTH);
                }
                panel4.add(panel8, BorderLayout.NORTH);

                //---- label3 ----
                label3.setText("number");
                label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
                panel4.add(label3, BorderLayout.CENTER);
                panel4.add(hSpacer6, BorderLayout.WEST);

                //---- vSpacer4 ----
                vSpacer4.setMinimumSize(new Dimension(12, 60));
                panel4.add(vSpacer4, BorderLayout.SOUTH);

                //======== panel9 ========
                {
                    panel9.setLayout(new BorderLayout());

                    //---- label4 ----
                    label4.setText("\u5f20");
                    panel9.add(label4, BorderLayout.CENTER);
                    panel9.add(hSpacer7, BorderLayout.EAST);
                    panel9.add(vSpacer5, BorderLayout.SOUTH);
                    panel9.add(vSpacer6, BorderLayout.NORTH);
                }
                panel4.add(panel9, BorderLayout.EAST);
            }
            panel3.add(panel4);

            //======== panel5 ========
            {
                panel5.setBorder(null);
                panel5.setLayout(new BorderLayout(20, 10));

                //======== panel13 ========
                {
                    panel13.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    panel13.setLayout(new BorderLayout());

                    //======== panel14 ========
                    {
                        panel14.setLayout(new BorderLayout());

                        //======== panel15 ========
                        {
                            panel15.setLayout(new BorderLayout());

                            //---- label8 ----
                            label8.setText("\u8bb0\u4f4f");
                            panel15.add(label8, BorderLayout.CENTER);
                            panel15.add(hSpacer11, BorderLayout.WEST);
                            panel15.add(vSpacer11, BorderLayout.NORTH);
                        }
                        panel14.add(panel15, BorderLayout.NORTH);

                        //---- label9 ----
                        label9.setText("number");
                        label9.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
                        panel14.add(label9, BorderLayout.CENTER);
                        panel14.add(hSpacer12, BorderLayout.WEST);
                        panel14.add(vSpacer12, BorderLayout.SOUTH);

                        //======== panel16 ========
                        {
                            panel16.setLayout(new BorderLayout());

                            //---- label10 ----
                            label10.setText("\u5f20");
                            panel16.add(label10, BorderLayout.CENTER);
                            panel16.add(hSpacer13, BorderLayout.EAST);
                            panel16.add(vSpacer13, BorderLayout.SOUTH);
                            panel16.add(vSpacer14, BorderLayout.NORTH);
                        }
                        panel14.add(panel16, BorderLayout.EAST);
                    }
                    panel13.add(panel14, BorderLayout.CENTER);
                }
                panel5.add(panel13, BorderLayout.WEST);

                //======== panel17 ========
                {
                    panel17.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    panel17.setLayout(new BorderLayout());

                    //======== panel18 ========
                    {
                        panel18.setLayout(new BorderLayout());

                        //======== panel19 ========
                        {
                            panel19.setLayout(new BorderLayout());

                            //---- label11 ----
                            label11.setText("\u5fd8\u8bb0");
                            panel19.add(label11, BorderLayout.CENTER);
                            panel19.add(hSpacer14, BorderLayout.WEST);
                            panel19.add(vSpacer15, BorderLayout.NORTH);
                        }
                        panel18.add(panel19, BorderLayout.NORTH);

                        //---- label12 ----
                        label12.setText("number");
                        label12.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
                        panel18.add(label12, BorderLayout.CENTER);
                        panel18.add(hSpacer15, BorderLayout.WEST);
                        panel18.add(vSpacer16, BorderLayout.SOUTH);

                        //======== panel20 ========
                        {
                            panel20.setLayout(new BorderLayout());

                            //---- label13 ----
                            label13.setText("\u5f20");
                            panel20.add(label13, BorderLayout.CENTER);
                            panel20.add(hSpacer16, BorderLayout.EAST);
                            panel20.add(vSpacer17, BorderLayout.SOUTH);
                            panel20.add(vSpacer18, BorderLayout.NORTH);
                        }
                        panel18.add(panel20, BorderLayout.EAST);
                    }
                    panel17.add(panel18, BorderLayout.CENTER);
                }
                panel5.add(panel17, BorderLayout.EAST);
                panel5.add(hSpacer17, BorderLayout.CENTER);
            }
            panel3.add(panel5);

            //======== panel6 ========
            {
                panel6.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                panel6.setLayout(new BorderLayout());

                //======== panel21 ========
                {
                    panel21.setLayout(new BorderLayout());

                    //======== panel22 ========
                    {
                        panel22.setLayout(new BorderLayout());

                        //---- label14 ----
                        label14.setText("\u9057\u5fd8\u7387");
                        panel22.add(label14, BorderLayout.CENTER);
                        panel22.add(hSpacer18, BorderLayout.WEST);
                        panel22.add(vSpacer19, BorderLayout.NORTH);
                    }
                    panel21.add(panel22, BorderLayout.NORTH);

                    //---- label15 ----
                    label15.setText("number");
                    label15.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
                    panel21.add(label15, BorderLayout.CENTER);
                    panel21.add(hSpacer19, BorderLayout.WEST);
                    panel21.add(vSpacer20, BorderLayout.SOUTH);
                }
                panel6.add(panel21, BorderLayout.CENTER);
                panel6.add(hSpacer20, BorderLayout.EAST);
            }
            panel3.add(panel6);

            //======== panel7 ========
            {
                panel7.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                panel7.setLayout(new BorderLayout());

                //======== panel10 ========
                {
                    panel10.setLayout(new BorderLayout());

                    //======== panel11 ========
                    {
                        panel11.setLayout(new BorderLayout());

                        //---- label5 ----
                        label5.setText("\u4eca\u5929\u8fd8\u5269");
                        panel11.add(label5, BorderLayout.CENTER);
                        panel11.add(hSpacer8, BorderLayout.WEST);
                        panel11.add(vSpacer7, BorderLayout.NORTH);
                    }
                    panel10.add(panel11, BorderLayout.NORTH);

                    //---- label6 ----
                    label6.setText("number");
                    panel10.add(label6, BorderLayout.CENTER);
                    panel10.add(hSpacer9, BorderLayout.WEST);
                    panel10.add(vSpacer8, BorderLayout.SOUTH);

                    //======== panel12 ========
                    {
                        panel12.setLayout(new BorderLayout());

                        //---- label7 ----
                        label7.setText("\u5f20");
                        panel12.add(label7, BorderLayout.CENTER);
                        panel12.add(hSpacer10, BorderLayout.EAST);
                        panel12.add(vSpacer9, BorderLayout.SOUTH);
                        panel12.add(vSpacer10, BorderLayout.NORTH);
                    }
                    panel10.add(panel12, BorderLayout.EAST);
                }
                panel7.add(panel10, BorderLayout.CENTER);
            }
            panel3.add(panel7);
        }
        add(panel3, BorderLayout.CENTER);

        //---- hSpacer3 ----
        hSpacer3.setPreferredSize(new Dimension(200, 10));
        add(hSpacer3, BorderLayout.WEST);

        //---- hSpacer4 ----
        hSpacer4.setPreferredSize(new Dimension(200, 10));
        add(hSpacer4, BorderLayout.EAST);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JPanel vSpacer1;
    private JLabel label1;
    private JPanel vSpacer21;
    private JPanel panel2;
    private JPanel vSpacer2;
    private JButton button1;
    private JPanel hSpacer1;
    private JPanel hSpacer2;
    private JPanel vSpacer22;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel8;
    private JLabel label2;
    private JPanel hSpacer5;
    private JPanel vSpacer3;
    private JLabel label3;
    private JPanel hSpacer6;
    private JPanel vSpacer4;
    private JPanel panel9;
    private JLabel label4;
    private JPanel hSpacer7;
    private JPanel vSpacer5;
    private JPanel vSpacer6;
    private JPanel panel5;
    private JPanel panel13;
    private JPanel panel14;
    private JPanel panel15;
    private JLabel label8;
    private JPanel hSpacer11;
    private JPanel vSpacer11;
    private JLabel label9;
    private JPanel hSpacer12;
    private JPanel vSpacer12;
    private JPanel panel16;
    private JLabel label10;
    private JPanel hSpacer13;
    private JPanel vSpacer13;
    private JPanel vSpacer14;
    private JPanel panel17;
    private JPanel panel18;
    private JPanel panel19;
    private JLabel label11;
    private JPanel hSpacer14;
    private JPanel vSpacer15;
    private JLabel label12;
    private JPanel hSpacer15;
    private JPanel vSpacer16;
    private JPanel panel20;
    private JLabel label13;
    private JPanel hSpacer16;
    private JPanel vSpacer17;
    private JPanel vSpacer18;
    private JPanel hSpacer17;
    private JPanel panel6;
    private JPanel panel21;
    private JPanel panel22;
    private JLabel label14;
    private JPanel hSpacer18;
    private JPanel vSpacer19;
    private JLabel label15;
    private JPanel hSpacer19;
    private JPanel vSpacer20;
    private JPanel hSpacer20;
    private JPanel panel7;
    private JPanel panel10;
    private JPanel panel11;
    private JLabel label5;
    private JPanel hSpacer8;
    private JPanel vSpacer7;
    private JLabel label6;
    private JPanel hSpacer9;
    private JPanel vSpacer8;
    private JPanel panel12;
    private JLabel label7;
    private JPanel hSpacer10;
    private JPanel vSpacer9;
    private JPanel vSpacer10;
    private JPanel hSpacer3;
    private JPanel hSpacer4;
    private JPanel hSpacer21;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
