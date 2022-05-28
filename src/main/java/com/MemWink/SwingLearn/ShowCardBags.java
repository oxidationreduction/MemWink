/*
 * Created by JFormDesigner on Sun May 22 10:23:45 CST 2022
 */

package com.MemWink.SwingLearn;

import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.Data.DataManager;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class ShowCardBags extends JPanel {
    private static ShowCardBags showCardBags = new ShowCardBags();

    public static ShowCardBags getShowCardBags(){
        return showCardBags;
    }

    public ShowCardBags() {
        initComponents();
        for ( CardBag cardBag: DataManager.getCardBags()){
            CardBagPane cardBagPane = new CardBagPane();
            cardBagPane.cardBag = cardBag;
            cardBagPane.label2.setText(cardBag.getName());
            cardBagPane.cardBagPaneTop.setBackground(cardBag.getColor());
            this.panel1.add(cardBagPane);
        }
    }

    private void button1(ActionEvent e) {
        AddPane pane = new AddPane();
        pane.setVisible(true);
        JButton tmp = new JButton();
        tmp.setLocation(300, 200);
        add(tmp);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel4 = new JPanel();
        label1 = new JLabel();
        panel5 = new JPanel();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        panel1 = new JPanel();

        //======== this ========
        setPreferredSize(new Dimension(775, 559));
        setLayout(new BorderLayout());

        //======== panel4 ========
        {
            panel4.setLayout(new FlowLayout(FlowLayout.LEFT));

            //---- label1 ----
            label1.setText("\u5361\u5305");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 14f));
            panel4.add(label1);
        }
        add(panel4, BorderLayout.NORTH);

        //======== panel5 ========
        {
            panel5.setLayout(new FlowLayout(FlowLayout.RIGHT));

            //---- button1 ----
            button1.setText("+");
            button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 10f));
            button1.addActionListener(e -> button1(e));
            panel5.add(button1);
        }
        add(panel5, BorderLayout.SOUTH);

        //======== scrollPane1 ========
        {

            //======== panel1 ========
            {
                panel1.setPreferredSize(new Dimension(700, 460));
                panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
            }
            scrollPane1.setViewportView(panel1);
        }
        add(scrollPane1, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel4;
    private JLabel label1;
    private JPanel panel5;
    private JButton button1;
    private JScrollPane scrollPane1;
    public JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
