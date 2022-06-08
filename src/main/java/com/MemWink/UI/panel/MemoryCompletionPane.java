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

    /**
     * 三参数构造器
     * @param remember 本轮"记住了"的卡片数
     * @param forget 本轮"没记住"的卡片数
     * @param tomorrow 明天应该记忆的卡片数
     *
     * @author Liu Hongyu
     * @since 2022-06-06
     */
    public MemoryCompletionPane(int remember, int forget, int tomorrow) {
        initComponents();
        setup(remember, forget, tomorrow);
        beautifyUI();
    }

    /**
     * 用于根据数据显示信息，初始化页面
     * @author Liu Hongyu
     * @since 2022-06-08
     */
    private void setup(int remember, int forget, int tomorrow) {
        label3.setText((remember + forget) + "");
        label9.setText(remember + "");
        label12.setText(forget + "");
        label15.setText(String.format("%.2f", (double) forget / (double) (remember + forget) * 100.0) + "%");
        label6.setText(tomorrow + "");
    }

    /**
     * 美化UI
     * @author Liu Hongyu
     * @since 2022-06-08
     */
    private void beautifyUI() {
        label1.setFont(new Font("微软雅黑", Font.PLAIN, 100));
        label3.setFont(new Font("微软雅黑", Font.PLAIN, 100));
        label9.setFont(new Font("微软雅黑", Font.PLAIN, 100));
        label12.setFont(new Font("微软雅黑", Font.PLAIN, 100));
        label15.setFont(new Font("微软雅黑", Font.PLAIN, 100));
        label6.setFont(new Font("微软雅黑", Font.PLAIN, 100));

        label2.setFont(new Font("微软雅黑", Font.PLAIN, 60));
        label8.setFont(new Font("微软雅黑", Font.PLAIN, 60));
        label11.setFont(new Font("微软雅黑", Font.PLAIN, 60));
        label14.setFont(new Font("微软雅黑", Font.PLAIN, 60));
        label5.setFont(new Font("微软雅黑", Font.PLAIN, 60));
        label4.setFont(new Font("微软雅黑", Font.PLAIN, 60));
        label10.setFont(new Font("微软雅黑", Font.PLAIN, 60));
        label13.setFont(new Font("微软雅黑", Font.PLAIN, 60));
        label7.setFont(new Font("微软雅黑", Font.PLAIN, 60));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        vSpacer1 = new JPanel(null);
        label1 = new JLabel();
        vSpacer21 = new JPanel(null);
        panel2 = new JPanel();
        vSpacer2 = new JPanel(null);
        button1 = new JButton();
        hSpacer1 = new JPanel(null);
        hSpacer2 = new JPanel(null);
        vSpacer22 = new JPanel(null);
        panel3 = new JPanel();
        panel4 = new JPanel();
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
        panel13 = new JPanel();
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
        panel17 = new JPanel();
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
        panel6 = new JPanel();
        panel21 = new JPanel();
        panel22 = new JPanel();
        label14 = new JLabel();
        hSpacer18 = new JPanel(null);
        vSpacer19 = new JPanel(null);
        label15 = new JLabel();
        hSpacer19 = new JPanel(null);
        vSpacer20 = new JPanel(null);
        hSpacer20 = new JPanel(null);
        panel7 = new JPanel();
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
            button1.setBackground(new Color(0, 204, 51));
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
                panel4.setBorder(null);
                panel4.setBackground(Color.lightGray);
                panel4.setLayout(new BorderLayout());

                //======== panel8 ========
                {
                    panel8.setBackground(Color.lightGray);
                    panel8.setLayout(new BorderLayout());

                    //---- label2 ----
                    label2.setText("\u672c\u6b21\u5b66\u4e60");
                    panel8.add(label2, BorderLayout.CENTER);

                    //---- hSpacer5 ----
                    hSpacer5.setPreferredSize(new Dimension(15, 10));
                    hSpacer5.setBackground(Color.lightGray);
                    panel8.add(hSpacer5, BorderLayout.WEST);

                    //---- vSpacer3 ----
                    vSpacer3.setBackground(Color.lightGray);
                    vSpacer3.setPreferredSize(new Dimension(10, 15));
                    panel8.add(vSpacer3, BorderLayout.NORTH);
                }
                panel4.add(panel8, BorderLayout.NORTH);

                //---- label3 ----
                label3.setText("number");
                label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
                label3.setBackground(Color.lightGray);
                panel4.add(label3, BorderLayout.CENTER);

                //---- hSpacer6 ----
                hSpacer6.setBackground(Color.lightGray);
                panel4.add(hSpacer6, BorderLayout.WEST);

                //---- vSpacer4 ----
                vSpacer4.setMinimumSize(new Dimension(12, 60));
                vSpacer4.setBackground(Color.lightGray);
                panel4.add(vSpacer4, BorderLayout.SOUTH);

                //======== panel9 ========
                {
                    panel9.setBackground(Color.lightGray);
                    panel9.setLayout(new BorderLayout());

                    //---- label4 ----
                    label4.setText("\u5f20");
                    label4.setBackground(Color.lightGray);
                    panel9.add(label4, BorderLayout.CENTER);

                    //---- hSpacer7 ----
                    hSpacer7.setBackground(Color.lightGray);
                    hSpacer7.setPreferredSize(new Dimension(20, 10));
                    panel9.add(hSpacer7, BorderLayout.EAST);

                    //---- vSpacer5 ----
                    vSpacer5.setBackground(Color.lightGray);
                    panel9.add(vSpacer5, BorderLayout.SOUTH);

                    //---- vSpacer6 ----
                    vSpacer6.setBackground(Color.lightGray);
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
                    panel13.setBorder(null);
                    panel13.setBackground(Color.lightGray);
                    panel13.setLayout(new BorderLayout());

                    //======== panel14 ========
                    {
                        panel14.setBackground(Color.lightGray);
                        panel14.setLayout(new BorderLayout());

                        //======== panel15 ========
                        {
                            panel15.setBackground(Color.lightGray);
                            panel15.setLayout(new BorderLayout());

                            //---- label8 ----
                            label8.setText("\u8bb0\u4f4f");
                            panel15.add(label8, BorderLayout.CENTER);

                            //---- hSpacer11 ----
                            hSpacer11.setPreferredSize(new Dimension(15, 10));
                            hSpacer11.setBackground(Color.lightGray);
                            panel15.add(hSpacer11, BorderLayout.WEST);

                            //---- vSpacer11 ----
                            vSpacer11.setPreferredSize(new Dimension(10, 15));
                            vSpacer11.setBackground(Color.lightGray);
                            panel15.add(vSpacer11, BorderLayout.NORTH);
                        }
                        panel14.add(panel15, BorderLayout.NORTH);

                        //---- label9 ----
                        label9.setText("number");
                        label9.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
                        label9.setBackground(Color.lightGray);
                        panel14.add(label9, BorderLayout.CENTER);

                        //---- hSpacer12 ----
                        hSpacer12.setBackground(Color.lightGray);
                        panel14.add(hSpacer12, BorderLayout.WEST);

                        //---- vSpacer12 ----
                        vSpacer12.setBackground(Color.lightGray);
                        panel14.add(vSpacer12, BorderLayout.SOUTH);

                        //======== panel16 ========
                        {
                            panel16.setBackground(Color.lightGray);
                            panel16.setLayout(new BorderLayout());

                            //---- label10 ----
                            label10.setText("\u5f20");
                            label10.setBackground(Color.lightGray);
                            panel16.add(label10, BorderLayout.CENTER);

                            //---- hSpacer13 ----
                            hSpacer13.setBackground(Color.lightGray);
                            panel16.add(hSpacer13, BorderLayout.EAST);

                            //---- vSpacer13 ----
                            vSpacer13.setBackground(Color.lightGray);
                            panel16.add(vSpacer13, BorderLayout.SOUTH);

                            //---- vSpacer14 ----
                            vSpacer14.setBackground(Color.lightGray);
                            panel16.add(vSpacer14, BorderLayout.NORTH);
                        }
                        panel14.add(panel16, BorderLayout.EAST);
                    }
                    panel13.add(panel14, BorderLayout.CENTER);
                }
                panel5.add(panel13, BorderLayout.WEST);

                //======== panel17 ========
                {
                    panel17.setBorder(null);
                    panel17.setBackground(Color.lightGray);
                    panel17.setLayout(new BorderLayout());

                    //======== panel18 ========
                    {
                        panel18.setBackground(Color.lightGray);
                        panel18.setLayout(new BorderLayout());

                        //======== panel19 ========
                        {
                            panel19.setBackground(Color.lightGray);
                            panel19.setLayout(new BorderLayout());

                            //---- label11 ----
                            label11.setText("\u5fd8\u8bb0");
                            label11.setBackground(Color.lightGray);
                            panel19.add(label11, BorderLayout.CENTER);

                            //---- hSpacer14 ----
                            hSpacer14.setBackground(Color.lightGray);
                            hSpacer14.setPreferredSize(new Dimension(15, 10));
                            panel19.add(hSpacer14, BorderLayout.WEST);

                            //---- vSpacer15 ----
                            vSpacer15.setBackground(Color.lightGray);
                            vSpacer15.setPreferredSize(new Dimension(10, 15));
                            panel19.add(vSpacer15, BorderLayout.NORTH);
                        }
                        panel18.add(panel19, BorderLayout.NORTH);

                        //---- label12 ----
                        label12.setText("number");
                        label12.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
                        label12.setBackground(Color.lightGray);
                        panel18.add(label12, BorderLayout.CENTER);

                        //---- hSpacer15 ----
                        hSpacer15.setBackground(Color.lightGray);
                        panel18.add(hSpacer15, BorderLayout.WEST);

                        //---- vSpacer16 ----
                        vSpacer16.setBackground(Color.lightGray);
                        panel18.add(vSpacer16, BorderLayout.SOUTH);

                        //======== panel20 ========
                        {
                            panel20.setBackground(Color.lightGray);
                            panel20.setLayout(new BorderLayout());

                            //---- label13 ----
                            label13.setText("\u5f20");
                            label13.setBackground(Color.lightGray);
                            panel20.add(label13, BorderLayout.CENTER);

                            //---- hSpacer16 ----
                            hSpacer16.setBackground(Color.lightGray);
                            panel20.add(hSpacer16, BorderLayout.EAST);

                            //---- vSpacer17 ----
                            vSpacer17.setBackground(Color.lightGray);
                            panel20.add(vSpacer17, BorderLayout.SOUTH);

                            //---- vSpacer18 ----
                            vSpacer18.setBackground(Color.lightGray);
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
                panel6.setBorder(null);
                panel6.setBackground(Color.lightGray);
                panel6.setLayout(new BorderLayout());

                //======== panel21 ========
                {
                    panel21.setBackground(Color.lightGray);
                    panel21.setLayout(new BorderLayout());

                    //======== panel22 ========
                    {
                        panel22.setBackground(Color.lightGray);
                        panel22.setLayout(new BorderLayout());

                        //---- label14 ----
                        label14.setText("\u9057\u5fd8\u7387");
                        label14.setBackground(Color.lightGray);
                        panel22.add(label14, BorderLayout.CENTER);

                        //---- hSpacer18 ----
                        hSpacer18.setBackground(Color.lightGray);
                        hSpacer18.setPreferredSize(new Dimension(15, 10));
                        panel22.add(hSpacer18, BorderLayout.WEST);

                        //---- vSpacer19 ----
                        vSpacer19.setBackground(Color.lightGray);
                        vSpacer19.setPreferredSize(new Dimension(10, 15));
                        panel22.add(vSpacer19, BorderLayout.NORTH);
                    }
                    panel21.add(panel22, BorderLayout.NORTH);

                    //---- label15 ----
                    label15.setText("number");
                    label15.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
                    label15.setBackground(Color.lightGray);
                    panel21.add(label15, BorderLayout.CENTER);

                    //---- hSpacer19 ----
                    hSpacer19.setBackground(Color.lightGray);
                    panel21.add(hSpacer19, BorderLayout.WEST);

                    //---- vSpacer20 ----
                    vSpacer20.setBackground(Color.lightGray);
                    panel21.add(vSpacer20, BorderLayout.SOUTH);
                }
                panel6.add(panel21, BorderLayout.CENTER);

                //---- hSpacer20 ----
                hSpacer20.setBackground(Color.lightGray);
                panel6.add(hSpacer20, BorderLayout.EAST);
            }
            panel3.add(panel6);

            //======== panel7 ========
            {
                panel7.setBorder(null);
                panel7.setBackground(Color.lightGray);
                panel7.setLayout(new BorderLayout());

                //======== panel10 ========
                {
                    panel10.setBackground(Color.lightGray);
                    panel10.setLayout(new BorderLayout());

                    //======== panel11 ========
                    {
                        panel11.setBackground(Color.lightGray);
                        panel11.setLayout(new BorderLayout());

                        //---- label5 ----
                        label5.setText("\u4eca\u5929\u8fd8\u5269");
                        label5.setBackground(Color.lightGray);
                        panel11.add(label5, BorderLayout.CENTER);

                        //---- hSpacer8 ----
                        hSpacer8.setBackground(Color.lightGray);
                        hSpacer8.setPreferredSize(new Dimension(15, 10));
                        panel11.add(hSpacer8, BorderLayout.WEST);

                        //---- vSpacer7 ----
                        vSpacer7.setBackground(Color.lightGray);
                        vSpacer7.setPreferredSize(new Dimension(10, 15));
                        panel11.add(vSpacer7, BorderLayout.NORTH);
                    }
                    panel10.add(panel11, BorderLayout.NORTH);

                    //---- label6 ----
                    label6.setText("number");
                    label6.setBackground(Color.lightGray);
                    panel10.add(label6, BorderLayout.CENTER);

                    //---- hSpacer9 ----
                    hSpacer9.setBackground(Color.lightGray);
                    panel10.add(hSpacer9, BorderLayout.WEST);

                    //---- vSpacer8 ----
                    vSpacer8.setBackground(Color.lightGray);
                    panel10.add(vSpacer8, BorderLayout.SOUTH);

                    //======== panel12 ========
                    {
                        panel12.setBackground(Color.lightGray);
                        panel12.setLayout(new BorderLayout());

                        //---- label7 ----
                        label7.setText("\u5f20");
                        label7.setBackground(Color.lightGray);
                        panel12.add(label7, BorderLayout.CENTER);

                        //---- hSpacer10 ----
                        hSpacer10.setBackground(Color.lightGray);
                        panel12.add(hSpacer10, BorderLayout.EAST);

                        //---- vSpacer9 ----
                        vSpacer9.setBackground(Color.lightGray);
                        panel12.add(vSpacer9, BorderLayout.SOUTH);

                        //---- vSpacer10 ----
                        vSpacer10.setBackground(Color.lightGray);
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

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new MemoryCompletionPane(1, 1, 1));
        frame.setVisible(true);
    }
}
