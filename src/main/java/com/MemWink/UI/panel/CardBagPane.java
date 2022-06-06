/*
 * Created by JFormDesigner on Mon May 16 09:51:36 CST 2022
 */

package com.MemWink.UI.panel;

import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.Data.DataManager;
import com.MemWink.UI.UIManager;
import com.MemWink.UI.dialog.AddPane;
import com.MemWink.UI.dialog.DeleteCardbag;
import com.MemWink.UI.dialog.ModifyDialog;
import com.MemWink.UI.frame.MainFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class CardBagPane extends JPanel {
    public CardBagPane(CardBag cardBag) {
        initComponents();
        this.cardBag = cardBag;
        this.cardBagPaneTop = new CardBagPaneTop(cardBag);
        this.add(cardBagPaneTop,BorderLayout.CENTER);
        menu.add(item1);
        this.item1.addActionListener(new item1Listener(this));
        menu.add(item2);
        this.item2.addActionListener(new item2Listener(this));
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
        if ( e.getButton() == MouseEvent.BUTTON1 ){
            UIManager.cardBag = cardBag;
            ShowAllCards allCards = new ShowAllCards(cardBag);
            MainFrame.getMainFrame().mainPanel.removeAll();
            MainFrame.getMainFrame().mainPanel.add(allCards);
            MainFrame.getMainFrame().mainPanel.updateUI();
            allCards.setVisible(true);
            UIManager.showAllCards = allCards;
        }
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
    public JMenuItem item1 = new JMenuItem("修改");
    public JMenuItem item2 = new JMenuItem("删除");
    public CardBag cardBag;
    private class item1Listener implements ActionListener {
         private CardBagPane panel;

         public item1Listener(CardBagPane panel){
             this.panel = panel;
         }

        @Override
        public void actionPerformed(ActionEvent e) {
            ModifyDialog modifyDialog = new ModifyDialog(panel);
            modifyDialog.setVisible(true);

            // AddPane addPane = new AddPane(cardBag.getName(), cardBag.getDailyNewCardNum(), cardBag.getColor());
            // addPane.setVisible(true);
        }
    }
    private class item2Listener implements ActionListener {
        private CardBagPane panel;

        public item2Listener(CardBagPane panel){
            this.panel = panel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteCardbag deleteCardbag = new DeleteCardbag(panel.cardBag);
            deleteCardbag.setVisible(true);
        }
    }
}
