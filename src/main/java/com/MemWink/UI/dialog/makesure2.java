/*
 * Created by JFormDesigner on Mon Jun 06 14:22:48 CST 2022
 */

package com.MemWink.UI.dialog;

import com.MemWink.Data.DataManager;
import com.MemWink.UI.UIManager;
import com.MemWink.UI.panel.ShowAllCards;
import com.MemWink.UI.panel.ShowCardBags;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author unknown
 */
public class makesure2 extends JDialog {
    public makesure2() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        DataManager.delCardBag(UIManager.showAllCards.gettable1().getText());
        UIManager.mainFrame.mainPanel.removeAll();
        UIManager.mainFrame.mainPanel.add(ShowCardBags.getShowCardBags());
        UIManager.mainFrame.mainPanel.updateUI();
        this.dispose();
    }

    private void button2(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        panel2 = new JPanel();
        button1 = new JButton();
        panel3 = new JPanel();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new BorderLayout());

            //---- label1 ----
            label1.setText("是否要删除卡包");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(label1, BorderLayout.CENTER);
        }
        contentPane.add(panel1, BorderLayout.NORTH);

        //======== panel2 ========
        {
            panel2.setLayout(new BorderLayout());

            //---- button1 ----
            button1.setText("\u662f");
            button1.addActionListener(e -> button1(e));
            panel2.add(button1, BorderLayout.CENTER);
        }
        contentPane.add(panel2, BorderLayout.WEST);

        //======== panel3 ========
        {
            panel3.setLayout(new BorderLayout());

            //---- button2 ----
            button2.setText("\u5426");
            button2.addActionListener(e -> button2(e));
            panel3.add(button2, BorderLayout.CENTER);
        }
        contentPane.add(panel3, BorderLayout.EAST);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JPanel panel2;
    private JButton button1;
    private JPanel panel3;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
