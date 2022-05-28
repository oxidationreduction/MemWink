/*
 * Created by JFormDesigner on Sun May 22 10:23:45 CST 2022
 */

package com.MemWink.SwingLearn;

import com.MemWink.UI.UIConstant;

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

    private void addButton(ActionEvent e) {
        AddPane pane = new AddPane();
        pane.setVisible(true);
        JButton tmp = new JButton();
        tmp.setLocation(300, 200);
        add(tmp);
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - 刘洪宇
        cardBagLabel = new JLabel();
        cardBagScrollPane = new JScrollPane();
        cardBagInnerPanel = new JPanel();
        addButton = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(775, 559));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
        EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing
        . border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ),
        java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( )
        { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () ))
        throw new RuntimeException( ); }} );

        //---- cardBagLabel ----
        cardBagLabel.setText("\u5361\u5305");
        cardBagLabel.setFont(cardBagLabel.getFont().deriveFont(cardBagLabel.getFont().getSize() + 39f));

        //======== cardBagScrollPane ========
        {
            cardBagScrollPane.setPreferredSize(new Dimension(750, 450));

            //======== cardBagInnerPanel ========
            {
                cardBagInnerPanel.setPreferredSize(new Dimension(700, 400));
                cardBagInnerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            }
            cardBagScrollPane.setViewportView(cardBagInnerPanel);
        }

        //---- addButton ----
        addButton.setText("+");
        addButton.setFont(addButton.getFont().deriveFont(addButton.getFont().getStyle() | Font.BOLD, addButton.getFont().getSize() + 16f));
        addButton.addActionListener(e -> button1(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(addButton)
                        .addGroup(layout.createParallelGroup()
                            .addComponent(cardBagLabel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                            .addComponent(cardBagScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cardBagLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cardBagScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addButton)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void updateSize() {
        cardBagInnerPanel.setSize(UIConstant.windowWidth - 130, UIConstant.windowHeight - 220);
        // System.out.println("cardBagInnerPanel: " + cardBagInnerPanel.getWidth() + " * " + cardBagInnerPanel.getHeight());
        cardBagInnerPanel.updateUI();

        cardBagScrollPane.setSize(UIConstant.windowWidth - 95, UIConstant.windowHeight - 180);
        // System.out.println("cardBagScrollPane: " + cardBagScrollPane.getWidth() + " * " + cardBagScrollPane.getHeight());
        cardBagScrollPane.updateUI();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - 刘洪宇
    private JLabel cardBagLabel;
    private JScrollPane cardBagScrollPane;
    private JPanel cardBagInnerPanel;
    private JButton addButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
