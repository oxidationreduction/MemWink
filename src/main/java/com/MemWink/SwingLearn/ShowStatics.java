/*
 * Created by JFormDesigner on Mon May 23 14:27:14 CST 2022
 */

package com.MemWink.SwingLearn;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class ShowStatics extends JPanel {
    public ShowStatics() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        panel1 = new JPanel();
        panel4 = new JPanel();
        label2 = new JLabel();
        label6 = new JLabel();
        alreadyStudy = new JLabel();
        panel5 = new JPanel();
        label3 = new JLabel();
        label7 = new JLabel();
        waitStudy = new JLabel();
        panel6 = new JPanel();
        label4 = new JLabel();
        forgetPer = new JLabel();
        panel7 = new JPanel();
        label5 = new JLabel();
        label8 = new JLabel();
        nextStudy = new JLabel();
        panel8 = new JPanel();
        panel9 = new JPanel();
        label9 = new JLabel();
        label11 = new JLabel();
        panel10 = new JPanel();
        label10 = new JLabel();
        label12 = new JLabel();

        //======== this ========
        setPreferredSize(new Dimension(775, 559));

        //---- label1 ----
        label1.setText("\u7edf\u8ba1");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 14f));

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout(1, 4, 30, 0));

            //======== panel4 ========
            {
                panel4.setBorder(new EtchedBorder(Color.lightGray, Color.gray));

                //---- label2 ----
                label2.setText("\u4eca\u5929\u5df2\u5b66");
                label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));

                //---- label6 ----
                label6.setText("\u5f20");
                label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 5f));

                //---- alreadyStudy ----
                alreadyStudy.setText("0");
                alreadyStudy.setFont(alreadyStudy.getFont().deriveFont(alreadyStudy.getFont().getSize() + 25f));

                GroupLayout panel4Layout = new GroupLayout(panel4);
                panel4.setLayout(panel4Layout);
                panel4Layout.setHorizontalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(panel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label2)
                                .addComponent(alreadyStudy))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                            .addComponent(label6)
                            .addContainerGap())
                );
                panel4Layout.setVerticalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(panel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label2)
                            .addGap(18, 18, 18)
                            .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(alreadyStudy)
                                .addComponent(label6))
                            .addContainerGap(17, Short.MAX_VALUE))
                );
            }
            panel1.add(panel4);

            //======== panel5 ========
            {
                panel5.setBorder(new EtchedBorder(Color.lightGray, Color.gray));

                //---- label3 ----
                label3.setText("\u4eca\u5929\u5f85\u5b66");
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));

                //---- label7 ----
                label7.setText("\u5f20");
                label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 5f));

                //---- waitStudy ----
                waitStudy.setText("0");
                waitStudy.setFont(waitStudy.getFont().deriveFont(waitStudy.getFont().getSize() + 25f));

                GroupLayout panel5Layout = new GroupLayout(panel5);
                panel5.setLayout(panel5Layout);
                panel5Layout.setHorizontalGroup(
                    panel5Layout.createParallelGroup()
                        .addGroup(panel5Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(waitStudy)
                                .addComponent(label3))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                            .addComponent(label7)
                            .addContainerGap())
                );
                panel5Layout.setVerticalGroup(
                    panel5Layout.createParallelGroup()
                        .addGroup(panel5Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label3)
                            .addGap(18, 18, 18)
                            .addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(waitStudy)
                                .addComponent(label7))
                            .addContainerGap(17, Short.MAX_VALUE))
                );
            }
            panel1.add(panel5);

            //======== panel6 ========
            {
                panel6.setBorder(new EtchedBorder(Color.lightGray, Color.gray));

                //---- label4 ----
                label4.setText("\u590d\u4e60\u9057\u5fd8\u7387");
                label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 5f));

                //---- forgetPer ----
                forgetPer.setText("0%");
                forgetPer.setFont(forgetPer.getFont().deriveFont(forgetPer.getFont().getSize() + 25f));

                GroupLayout panel6Layout = new GroupLayout(panel6);
                panel6.setLayout(panel6Layout);
                panel6Layout.setHorizontalGroup(
                    panel6Layout.createParallelGroup()
                        .addGroup(panel6Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(forgetPer)
                                .addComponent(label4))
                            .addContainerGap(61, Short.MAX_VALUE))
                );
                panel6Layout.setVerticalGroup(
                    panel6Layout.createParallelGroup()
                        .addGroup(panel6Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label4)
                            .addGap(18, 18, 18)
                            .addComponent(forgetPer)
                            .addContainerGap(17, Short.MAX_VALUE))
                );
            }
            panel1.add(panel6);

            //======== panel7 ========
            {
                panel7.setBorder(new EtchedBorder(Color.lightGray, Color.gray));

                //---- label5 ----
                label5.setText("\u660e\u5929\u9884\u8ba1");
                label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 5f));

                //---- label8 ----
                label8.setText("\u5f20");
                label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 5f));

                //---- nextStudy ----
                nextStudy.setText("0");
                nextStudy.setFont(nextStudy.getFont().deriveFont(nextStudy.getFont().getSize() + 25f));

                GroupLayout panel7Layout = new GroupLayout(panel7);
                panel7.setLayout(panel7Layout);
                panel7Layout.setHorizontalGroup(
                    panel7Layout.createParallelGroup()
                        .addGroup(panel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(nextStudy)
                                .addComponent(label5))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                            .addComponent(label8)
                            .addContainerGap())
                );
                panel7Layout.setVerticalGroup(
                    panel7Layout.createParallelGroup()
                        .addGroup(panel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label5)
                            .addGap(18, 18, 18)
                            .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(nextStudy)
                                .addComponent(label8))
                            .addContainerGap(17, Short.MAX_VALUE))
                );
            }
            panel1.add(panel7);
        }

        //======== panel8 ========
        {
            panel8.setLayout(new GridLayout(1, 2, 30, 0));

            //======== panel9 ========
            {
                panel9.setBorder(new EtchedBorder(Color.lightGray, Color.gray));

                //---- label9 ----
                label9.setText("\u5b66\u4e60\u5361\u7247\u6570");
                label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 5f));

                //---- label11 ----
                label11.setText("\u6bd4\u6628\u5929");
                label11.setFont(label11.getFont().deriveFont(label11.getFont().getSize() + 5f));

                GroupLayout panel9Layout = new GroupLayout(panel9);
                panel9.setLayout(panel9Layout);
                panel9Layout.setHorizontalGroup(
                    panel9Layout.createParallelGroup()
                        .addGroup(panel9Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(label9)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                            .addComponent(label11)
                            .addGap(68, 68, 68))
                );
                panel9Layout.setVerticalGroup(
                    panel9Layout.createParallelGroup()
                        .addGroup(panel9Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label9)
                                .addComponent(label11))
                            .addContainerGap(229, Short.MAX_VALUE))
                );
            }
            panel8.add(panel9);

            //======== panel10 ========
            {
                panel10.setBorder(new EtchedBorder(Color.lightGray, Color.gray));

                //---- label10 ----
                label10.setText("\u590d\u4e60\u9057\u5fd8\u7387");
                label10.setFont(label10.getFont().deriveFont(label10.getFont().getSize() + 5f));

                //---- label12 ----
                label12.setText("\u6bd4\u6628\u5929");
                label12.setFont(label12.getFont().deriveFont(label12.getFont().getSize() + 5f));

                GroupLayout panel10Layout = new GroupLayout(panel10);
                panel10.setLayout(panel10Layout);
                panel10Layout.setHorizontalGroup(
                    panel10Layout.createParallelGroup()
                        .addGroup(panel10Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(label10)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                            .addComponent(label12)
                            .addGap(75, 75, 75))
                );
                panel10Layout.setVerticalGroup(
                    panel10Layout.createParallelGroup()
                        .addGroup(panel10Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label10)
                                .addComponent(label12))
                            .addContainerGap(229, Short.MAX_VALUE))
                );
            }
            panel8.add(panel10);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                                .addComponent(panel8, GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE))))
                    .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addGap(47, 47, 47)
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                    .addGap(53, 53, 53)
                    .addComponent(panel8, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(48, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JPanel panel1;
    private JPanel panel4;
    private JLabel label2;
    private JLabel label6;
    private JLabel alreadyStudy;
    private JPanel panel5;
    private JLabel label3;
    private JLabel label7;
    private JLabel waitStudy;
    private JPanel panel6;
    private JLabel label4;
    private JLabel forgetPer;
    private JPanel panel7;
    private JLabel label5;
    private JLabel label8;
    private JLabel nextStudy;
    private JPanel panel8;
    private JPanel panel9;
    private JLabel label9;
    private JLabel label11;
    private JPanel panel10;
    private JLabel label10;
    private JLabel label12;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
