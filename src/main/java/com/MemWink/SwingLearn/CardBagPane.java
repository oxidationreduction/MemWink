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
        cardBagPaneTop = new CardBagPaneTop();
        this.add(cardBagPaneTop,BorderLayout.CENTER);
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

    private void thisMouseClicked(MouseEvent e) {
        ShowAllCards allCards = new ShowAllCards();
        MainFrame.getMainFrame().mainPanel.removeAll();
        MainFrame.getMainFrame().mainPanel.add(allCards);
        MainFrame.getMainFrame().mainPanel.updateUI();
        allCards.setVisible(true);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label2 = new JLabel();

        //======== this ========
        setPreferredSize(new Dimension(170, 130));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                thisMouseClicked(e);
            }
        });
        setLayout(new BorderLayout());

        //---- label2 ----
        label2.setText("text");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        add(label2, BorderLayout.SOUTH);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public CardBagPaneTop cardBagPaneTop;
    public JPopupMenu menu = new JPopupMenu();
    public JMenuItem item = new JMenuItem("删除");
    public CardBag cardBag;
    private class itemListener implements ActionListener {
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
