/*
 * Created by JFormDesigner on Mon May 16 09:51:36 CST 2022
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
public class CardBagPane extends JPanel {
    public CardBagPane() {
        initComponents();
        menu.add(item);
        this.item.addActionListener(new itemListener(this));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ( e.getButton() == MouseEvent.BUTTON3 ){
                    menu.show(e.getComponent(),e.getX(),e.getY());
                }
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        button1 = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(140, 119));

        //---- label1 ----
        label1.setText("text");
        label1.setHorizontalAlignment(SwingConstants.RIGHT);

        //---- button1 ----
        button1.setText("text");
        button1.setHorizontalAlignment(SwingConstants.LEFT);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JLabel label1;
    public JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public JPopupMenu menu = new JPopupMenu();
    public JMenuItem item = new JMenuItem("删除");
    public CardBag cardBag;
    private class itemListener implements ActionListener{
        private CardBagPane panel;

        public itemListener(CardBagPane panel){
            this.panel = panel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JPanel parent = (JPanel) panel.getParent();
            DataManager.delCardBag(panel.cardBag.getName());
            parent.remove(panel);
            parent.updateUI();
        }
    }
}
