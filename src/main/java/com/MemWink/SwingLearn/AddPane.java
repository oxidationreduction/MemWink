/*
 * Created by JFormDesigner on Mon May 16 20:00:47 CST 2022
 */

package com.MemWink.SwingLearn;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class AddPane extends JDialog {
    public AddPane(Window owner) {
        super(owner);
        initComponents();
    }

    private void panel1MouseClicked(MouseEvent e) {
        AddMemCard addMemCard = new AddMemCard(this.getOwner());
        addMemCard.setVisible(true);
        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        panel2 = new JPanel();
        label3 = new JLabel();
        label4 = new JLabel();
        panel3 = new JPanel();
        label5 = new JLabel();
        label6 = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setModal(true);
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(3, 1));

        //======== panel1 ========
        {
            panel1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    panel1MouseClicked(e);
                }
            });

            //---- label1 ----
            label1.setText("text");

            //---- label2 ----
            label2.setText("\u8bb0\u5fc6\u95ea\u5361");
            label2.setHorizontalAlignment(SwingConstants.LEFT);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(38, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                        .addContainerGap(21, Short.MAX_VALUE))
            );
        }
        contentPane.add(panel1);

        //======== panel2 ========
        {

            //---- label3 ----
            label3.setText("text");

            //---- label4 ----
            label4.setText("\u65f6\u95f4\u95ea\u5361");

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(38, Short.MAX_VALUE))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(label3, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                            .addComponent(label4, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                        .addContainerGap(21, Short.MAX_VALUE))
            );
        }
        contentPane.add(panel2);

        //======== panel3 ========
        {

            //---- label5 ----
            label5.setText("text");

            //---- label6 ----
            label6.setText("\u5361\u5305\u5206\u7ec4");

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(38, Short.MAX_VALUE))
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(label5, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                            .addComponent(label6, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                        .addContainerGap(21, Short.MAX_VALUE))
            );
        }
        contentPane.add(panel3);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JPanel panel2;
    private JLabel label3;
    private JLabel label4;
    private JPanel panel3;
    private JLabel label5;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
