/*
 * Created by JFormDesigner on Tue May 31 08:29:38 CST 2022
 */

package com.MemWink.UI.panel;

import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.Data.CardBag.CategorizedCard;
import com.MemWink.UI.UIManager;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class SortPane extends JPanel {
    @Override
    public void paint(Graphics g) {
        int fieldX = 0;
        int fieldY = 0;
        int fieldWeight = getSize().width;
        int fieldHeight = getSize().height;
        RoundRectangle2D rect = new RoundRectangle2D.Double(fieldX, fieldY, fieldWeight, fieldHeight, 20, 20);
        g.setClip(rect);
        super.paint(g);
    }
    public SortPane(String name, List<CategorizedCard> list) {
        this.list = list;
        initComponents();
        label1.setText(name);
        label2.setText(String.valueOf(list.size()));
    }

    private void thisMouseClicked(MouseEvent e) {
        UIManager.showAllCards.showcard(list);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        hSpacer1 = new JPanel(null);
        panel2 = new JPanel();
        label2 = new JLabel();
        hSpacer2 = new JPanel(null);

        //======== this ========
        setMaximumSize(new Dimension(10, 17));
        setMinimumSize(new Dimension(10, 17));
        setBorder(null);
        setPreferredSize(new Dimension(150, 21));
        setBackground(Color.lightGray);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                thisMouseClicked(e);
            }
        });
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBackground(Color.lightGray);
            panel1.setLayout(new BorderLayout());

            //---- label1 ----
            label1.setText("\u79cd\u7c7b");
            label1.setBackground(Color.lightGray);
            panel1.add(label1, BorderLayout.CENTER);

            //---- hSpacer1 ----
            hSpacer1.setBackground(Color.lightGray);
            hSpacer1.setPreferredSize(new Dimension(11, 10));
            panel1.add(hSpacer1, BorderLayout.WEST);
        }
        add(panel1, BorderLayout.WEST);

        //======== panel2 ========
        {
            panel2.setBackground(Color.lightGray);
            panel2.setLayout(new BorderLayout());

            //---- label2 ----
            label2.setText("number");
            label2.setBackground(Color.lightGray);
            panel2.add(label2, BorderLayout.CENTER);

            //---- hSpacer2 ----
            hSpacer2.setBackground(Color.lightGray);
            hSpacer2.setPreferredSize(new Dimension(11, 10));
            panel2.add(hSpacer2, BorderLayout.EAST);
        }
        add(panel2, BorderLayout.EAST);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    private List<CategorizedCard> list;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JPanel hSpacer1;
    private JPanel panel2;
    private JLabel label2;
    private JPanel hSpacer2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
