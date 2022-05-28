/*
 * Created by JFormDesigner on Mon May 23 14:27:14 CST 2022
 */

package com.MemWink.SwingLearn;

import com.MemWink.UI.UIConstant;

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
        // Generated using JFormDesigner Evaluation license - 刘洪宇
        staticLabel = new JLabel();
        upperPanel = new JPanel();
        alreadyStudyPanel = new JPanel();
        label2 = new JLabel();
        label6 = new JLabel();
        alreadyStudy = new JLabel();
        waitStudyPanel = new JPanel();
        label0 = new JLabel();
        label7 = new JLabel();
        waitStudy = new JLabel();
        forgetPerPanel = new JPanel();
        label4 = new JLabel();
        forgetPer = new JLabel();
        label1 = new JLabel();
        nextStudyPanel = new JPanel();
        label5 = new JLabel();
        label8 = new JLabel();
        nextStudy = new JLabel();
        lowerPanel = new JPanel();
        studyNumGraphPanel = new JPanel();
        label9 = new JLabel();
        label11 = new JLabel();
        foegerRateGraphPanel = new JPanel();
        label10 = new JLabel();
        label12 = new JLabel();

        //======== this ========
        setPreferredSize(new Dimension(1150, 600));
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
        border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder.CENTER
        ,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font
        .BOLD,12),java.awt.Color.red), getBorder())); addPropertyChangeListener(
        new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r"
        .equals(e.getPropertyName()))throw new RuntimeException();}});

        //---- staticLabel ----
        staticLabel.setText("\u7edf\u8ba1");
        staticLabel.setFont(staticLabel.getFont().deriveFont(staticLabel.getFont().getSize() + 39f));

        //======== upperPanel ========
        {
            upperPanel.setLayout(new GridLayout(1, 4, 30, 0));

            //======== alreadyStudyPanel ========
            {
                alreadyStudyPanel.setBorder(new EtchedBorder(Color.lightGray, Color.gray));

                //---- label2 ----
                label2.setText("\u4eca\u5929\u5df2\u5b66");
                label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));

                //---- label6 ----
                label6.setText("\u5f20");
                label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 5f));

                //---- alreadyStudy ----
                alreadyStudy.setText("0");
                alreadyStudy.setFont(alreadyStudy.getFont().deriveFont(alreadyStudy.getFont().getSize() + 25f));

                GroupLayout alreadyStudyPanelLayout = new GroupLayout(alreadyStudyPanel);
                alreadyStudyPanel.setLayout(alreadyStudyPanelLayout);
                alreadyStudyPanelLayout.setHorizontalGroup(
                    alreadyStudyPanelLayout.createParallelGroup()
                        .addGroup(alreadyStudyPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(alreadyStudyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label2)
                                .addComponent(alreadyStudy))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                            .addComponent(label6)
                            .addContainerGap())
                );
                alreadyStudyPanelLayout.setVerticalGroup(
                    alreadyStudyPanelLayout.createParallelGroup()
                        .addGroup(alreadyStudyPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label2)
                            .addGap(18, 18, 18)
                            .addGroup(alreadyStudyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(alreadyStudy)
                                .addComponent(label6))
                            .addContainerGap(13, Short.MAX_VALUE))
                );
            }
            upperPanel.add(alreadyStudyPanel);

            //======== waitStudyPanel ========
            {
                waitStudyPanel.setBorder(new EtchedBorder(Color.lightGray, Color.gray));

                //---- label0 ----
                label0.setText("\u4eca\u5929\u5f85\u5b66");
                label0.setFont(label0.getFont().deriveFont(label0.getFont().getSize() + 5f));

                //---- label7 ----
                label7.setText("\u5f20");
                label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 5f));

                //---- waitStudy ----
                waitStudy.setText("0");
                waitStudy.setFont(waitStudy.getFont().deriveFont(waitStudy.getFont().getSize() + 25f));

                GroupLayout waitStudyPanelLayout = new GroupLayout(waitStudyPanel);
                waitStudyPanel.setLayout(waitStudyPanelLayout);
                waitStudyPanelLayout.setHorizontalGroup(
                    waitStudyPanelLayout.createParallelGroup()
                        .addGroup(waitStudyPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(waitStudyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(waitStudy)
                                .addComponent(label0))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                            .addComponent(label7)
                            .addContainerGap())
                );
                waitStudyPanelLayout.setVerticalGroup(
                    waitStudyPanelLayout.createParallelGroup()
                        .addGroup(waitStudyPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label0)
                            .addGap(18, 18, 18)
                            .addGroup(waitStudyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(waitStudy)
                                .addComponent(label7))
                            .addContainerGap(13, Short.MAX_VALUE))
                );
            }
            upperPanel.add(waitStudyPanel);

            //======== forgetPerPanel ========
            {
                forgetPerPanel.setBorder(new EtchedBorder(Color.lightGray, Color.gray));

                //---- label4 ----
                label4.setText("\u590d\u4e60\u9057\u5fd8\u7387");
                label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 5f));

                //---- forgetPer ----
                forgetPer.setText("%");
                forgetPer.setFont(forgetPer.getFont().deriveFont(forgetPer.getFont().getSize() + 25f));

                //---- label1 ----
                label1.setText("0");
                label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 25f));
                label1.setHorizontalTextPosition(SwingConstants.RIGHT);

                GroupLayout forgetPerPanelLayout = new GroupLayout(forgetPerPanel);
                forgetPerPanel.setLayout(forgetPerPanelLayout);
                forgetPerPanelLayout.setHorizontalGroup(
                    forgetPerPanelLayout.createParallelGroup()
                        .addGroup(forgetPerPanelLayout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addGroup(forgetPerPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label4)
                                .addGroup(forgetPerPanelLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(forgetPer)))
                            .addContainerGap(33, Short.MAX_VALUE))
                );
                forgetPerPanelLayout.setVerticalGroup(
                    forgetPerPanelLayout.createParallelGroup()
                        .addGroup(forgetPerPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label4)
                            .addGap(18, 18, 18)
                            .addGroup(forgetPerPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(forgetPer)
                                .addComponent(label1))
                            .addContainerGap(13, Short.MAX_VALUE))
                );
            }
            upperPanel.add(forgetPerPanel);

            //======== nextStudyPanel ========
            {
                nextStudyPanel.setBorder(new EtchedBorder(Color.lightGray, Color.gray));

                //---- label5 ----
                label5.setText("\u660e\u5929\u9884\u8ba1");
                label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 5f));

                //---- label8 ----
                label8.setText("\u5f20");
                label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 5f));

                //---- nextStudy ----
                nextStudy.setText("0");
                nextStudy.setFont(nextStudy.getFont().deriveFont(nextStudy.getFont().getSize() + 25f));

                GroupLayout nextStudyPanelLayout = new GroupLayout(nextStudyPanel);
                nextStudyPanel.setLayout(nextStudyPanelLayout);
                nextStudyPanelLayout.setHorizontalGroup(
                    nextStudyPanelLayout.createParallelGroup()
                        .addGroup(nextStudyPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(nextStudyPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(nextStudy)
                                .addComponent(label5))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                            .addComponent(label8)
                            .addContainerGap())
                );
                nextStudyPanelLayout.setVerticalGroup(
                    nextStudyPanelLayout.createParallelGroup()
                        .addGroup(nextStudyPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label5)
                            .addGap(18, 18, 18)
                            .addGroup(nextStudyPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(nextStudy)
                                .addComponent(label8))
                            .addContainerGap(13, Short.MAX_VALUE))
                );
            }
            upperPanel.add(nextStudyPanel);
        }

        //======== lowerPanel ========
        {
            lowerPanel.setLayout(new GridLayout(1, 2, 30, 0));

            //======== studyNumGraphPanel ========
            {
                studyNumGraphPanel.setBorder(new EtchedBorder(Color.lightGray, Color.gray));

                //---- label9 ----
                label9.setText("\u5b66\u4e60\u5361\u7247\u6570");
                label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 5f));

                //---- label11 ----
                label11.setText("\u6bd4\u6628\u5929");
                label11.setFont(label11.getFont().deriveFont(label11.getFont().getSize() + 5f));

                GroupLayout studyNumGraphPanelLayout = new GroupLayout(studyNumGraphPanel);
                studyNumGraphPanel.setLayout(studyNumGraphPanelLayout);
                studyNumGraphPanelLayout.setHorizontalGroup(
                    studyNumGraphPanelLayout.createParallelGroup()
                        .addGroup(studyNumGraphPanelLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(label9)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                            .addComponent(label11)
                            .addGap(68, 68, 68))
                );
                studyNumGraphPanelLayout.setVerticalGroup(
                    studyNumGraphPanelLayout.createParallelGroup()
                        .addGroup(studyNumGraphPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(studyNumGraphPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label9)
                                .addComponent(label11))
                            .addContainerGap(226, Short.MAX_VALUE))
                );
            }
            lowerPanel.add(studyNumGraphPanel);

            //======== foegerRateGraphPanel ========
            {
                foegerRateGraphPanel.setBorder(new EtchedBorder(Color.lightGray, Color.gray));

                //---- label10 ----
                label10.setText("\u590d\u4e60\u9057\u5fd8\u7387");
                label10.setFont(label10.getFont().deriveFont(label10.getFont().getSize() + 5f));

                //---- label12 ----
                label12.setText("\u6bd4\u6628\u5929");
                label12.setFont(label12.getFont().deriveFont(label12.getFont().getSize() + 5f));

                GroupLayout foegerRateGraphPanelLayout = new GroupLayout(foegerRateGraphPanel);
                foegerRateGraphPanel.setLayout(foegerRateGraphPanelLayout);
                foegerRateGraphPanelLayout.setHorizontalGroup(
                    foegerRateGraphPanelLayout.createParallelGroup()
                        .addGroup(foegerRateGraphPanelLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(label10)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                            .addComponent(label12)
                            .addGap(75, 75, 75))
                );
                foegerRateGraphPanelLayout.setVerticalGroup(
                    foegerRateGraphPanelLayout.createParallelGroup()
                        .addGroup(foegerRateGraphPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(foegerRateGraphPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label10)
                                .addComponent(label12))
                            .addContainerGap(226, Short.MAX_VALUE))
                );
            }
            lowerPanel.add(foegerRateGraphPanel);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 26, Short.MAX_VALUE)
                            .addComponent(upperPanel, GroupLayout.PREFERRED_SIZE, 713, GroupLayout.PREFERRED_SIZE))
                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(staticLabel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(0, 20, Short.MAX_VALUE)
                                    .addComponent(lowerPanel, GroupLayout.PREFERRED_SIZE, 713, GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(staticLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)
                    .addComponent(upperPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(55, 55, 55)
                    .addComponent(lowerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap(21, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void updateSize() {
        setSize(UIConstant.windowWidth - 130, UIConstant.windowHeight - 220);
        System.out.println("staticPanel: " + getWidth() + " * " + getHeight());
        updateUI();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - 刘洪宇
    private JLabel staticLabel;
    private JPanel upperPanel;
    private JPanel alreadyStudyPanel;
    private JLabel label2;
    private JLabel label6;
    private JLabel alreadyStudy;
    private JPanel waitStudyPanel;
    private JLabel label0;
    private JLabel label7;
    private JLabel waitStudy;
    private JPanel forgetPerPanel;
    private JLabel label4;
    private JLabel forgetPer;
    private JLabel label1;
    private JPanel nextStudyPanel;
    private JLabel label5;
    private JLabel label8;
    private JLabel nextStudy;
    private JPanel lowerPanel;
    private JPanel studyNumGraphPanel;
    private JLabel label9;
    private JLabel label11;
    private JPanel foegerRateGraphPanel;
    private JLabel label10;
    private JLabel label12;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
