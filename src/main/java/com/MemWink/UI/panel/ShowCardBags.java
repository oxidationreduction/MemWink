/*
 * Created by JFormDesigner on Sun May 22 10:23:45 CST 2022
 */

package com.MemWink.UI.panel;

import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.Data.DataManager;
import com.MemWink.UI.UIManager;
import com.MemWink.UI.dialog.AddPane;
import com.MemWink.util.constant.MemStateConstants;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class ShowCardBags extends JPanel {

    public static ShowCardBags getShowCardBags(){
        UIManager.showCardBags = new ShowCardBags();
        return UIManager.showCardBags;
    }

    private ShowCardBags() {
        initComponents();
        for ( CardBag cardBag: DataManager.getCardBags()){
            CardBagPane cardBagPane = new CardBagPane(cardBag);
            cardBagPane.label2.setText(cardBag.getName());
            this.panel1.add(cardBagPane);
        }
        int x = DataManager.getCardBags().size()/4 +(DataManager.getCardBags().size()%4 != 0 ? 1:0);
        if(x<4) {
            panel1.setPreferredSize(new Dimension(700,400));
        }
        else if(x==4) {
            panel1.setPreferredSize(new Dimension(700,600));
        }
        else {
            panel1.setPreferredSize(new Dimension(700,600+140*(x-4)));
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
        panel6 = new JPanel();
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

        //======== panel6 ========
        {
            panel6.setLayout(new BorderLayout());

            //======== scrollPane1 ========
            {

                //======== panel1 ========
                {
                    panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));
                }
                scrollPane1.setViewportView(panel1);
            }
            panel6.add(scrollPane1, BorderLayout.CENTER);
        }
        add(panel6, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel4;
    private JLabel label1;
    private JPanel panel5;
    private JButton button1;
    public JPanel panel6;
    public JScrollPane scrollPane1;
    public JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
