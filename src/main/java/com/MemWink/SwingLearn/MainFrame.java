/*
 * Created by JFormDesigner on Sun May 15 18:50:15 CST 2022
 */

package com.MemWink.SwingLearn;

import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.Data.DataManager;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * @author unknown
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        AddPane addPane = new AddPane(this);
        addPane.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - 刘洪宇
        panel2 = new JPanel();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        scrollPane1 = new JScrollPane();
        panel1 = new JPanel();
        panel3 = new JPanel();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== panel2 ========
        {
            panel2.setBorder (new CompoundBorder( new TitledBorder (new
                    EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", TitledBorder. CENTER, TitledBorder. BOTTOM, new Font ("Dia\u006cog" , Font .BOLD ,12 ),
            Color. red) ,panel2. getBorder( )) ); panel2. addPropertyChangeListener (new PropertyChangeListener( )
            {  public void propertyChange (PropertyChangeEvent e) {if ("b\u006frde\u0072" .equals (e .getPropertyName () ))
            throw new RuntimeException( ); }} );

            //---- button2 ----
            button2.setText("text");

            //---- button3 ----
            button3.setText("text");

            //---- button4 ----
            button4.setText("text");

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .add(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(panel2Layout.createParallelGroup()
                            .add(button3)
                            .add(button4)
                            .add(button2))
                        .addContainerGap(21, Short.MAX_VALUE))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .add(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(button2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .add(button3, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .add(button4, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        //======== scrollPane1 ========
        {
            scrollPane1.setPreferredSize(new Dimension(461, 351));
            scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            //======== panel1 ========
            {
                panel1.setMaximumSize(new Dimension(290, 32767));
                panel1.setPreferredSize(new Dimension(461, 351));
                panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
            }
            scrollPane1.setViewportView(panel1);
        }

        //======== panel3 ========
        {

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .add(0, 0, Short.MAX_VALUE)
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .add(0, 17, Short.MAX_VALUE)
            );
        }

        //---- button1 ----
        button1.setText("text");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button1(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .add(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(contentPaneLayout.createParallelGroup()
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(204, 204, 204)
                            .add(button1))
                        .add(scrollPane1, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .add(scrollPane1, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(contentPaneLayout.createParallelGroup()
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .add(13, 13, 13))
                        .add(GroupLayout.TRAILING, contentPaneLayout.createSequentialGroup()
                            .add(button1)
                            .addContainerGap())))
                .add(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - 刘洪宇
    public JPanel panel2;
    public JButton button2;
    public JButton button3;
    public JButton button4;
    public JScrollPane scrollPane1;
    public JPanel panel1;
    public JPanel panel3;
    public JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
