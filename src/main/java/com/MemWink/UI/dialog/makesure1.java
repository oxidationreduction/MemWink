/*
 * Created by JFormDesigner on Mon Jun 06 14:22:48 CST 2022
 */

package com.MemWink.UI.dialog;

import com.MemWink.UI.panel.ShowAllCards;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class makesure1 extends JDialog {
    public makesure1(ShowAllCards showAllCards) {
        initComponents();
        this.showAllCards = showAllCards;
    }

    private void button1(ActionEvent e) {
        showAllCards.cardBag1.removeAllCards();
        showAllCards.showcard(showAllCards.cardBag1.getCards());
        this.dispose();
    }

    private void button2(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Sun Yihan
        panel1 = new JPanel();
        label1 = new JLabel();
        panel2 = new JPanel();
        button1 = new JButton();
        panel3 = new JPanel();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
            border.EmptyBorder(0,0,0,0), null,javax.swing.border.TitledBorder.CENTER
            ,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font
            .BOLD,12),java.awt.Color.red),panel1. getBorder()));panel1. addPropertyChangeListener(
            new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order"
            .equals(e.getPropertyName()))throw new RuntimeException();}});
            panel1.setLayout(new BorderLayout());

            //---- label1 ----
            label1.setText("\u662f\u5426\u8981\u6e05\u9664\u5361\u5305\u5185\u5bb9");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(label1, BorderLayout.CENTER);
        }

        //======== panel2 ========
        {
            panel2.setLayout(new BorderLayout());

            //---- button1 ----
            button1.setText("\u662f");
            button1.addActionListener(e -> button1(e));
            panel2.add(button1, BorderLayout.CENTER);
        }

        //======== panel3 ========
        {
            panel3.setLayout(new BorderLayout());

            //---- button2 ----
            button2.setText("\u5426");
            button2.addActionListener(e -> button2(e));
            panel3.add(button2, BorderLayout.CENTER);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(200, 200, 200)
                    .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
                        .addComponent(panel3, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    private ShowAllCards showAllCards;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Sun Yihan
    private JPanel panel1;
    private JLabel label1;
    private JPanel panel2;
    private JButton button1;
    private JPanel panel3;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
