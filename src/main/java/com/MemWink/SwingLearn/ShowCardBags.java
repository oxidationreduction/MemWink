/*
 * Created by JFormDesigner on Sun May 22 10:23:45 CST 2022
 */

package com.MemWink.SwingLearn;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class ShowCardBags extends JPanel {


    public ShowCardBags() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        AddPane pane = new AddPane();
        pane.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        panel1 = new JPanel();
        button1 = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(775, 559));

        //---- label1 ----
        label1.setText("\u5361\u5305");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 14f));

        //======== scrollPane1 ========
        {
            scrollPane1.setPreferredSize(new Dimension(750, 450));

            //======== panel1 ========
            {
                panel1.setPreferredSize(new Dimension(700, 400));
                panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
            }
            scrollPane1.setViewportView(panel1);
        }

        //---- button1 ----
        button1.setText("+");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getStyle() | Font.BOLD, button1.getFont().getSize() + 16f));
        button1.addActionListener(e -> button1(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(button1)
                        .addGroup(layout.createParallelGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JPanel panel1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
