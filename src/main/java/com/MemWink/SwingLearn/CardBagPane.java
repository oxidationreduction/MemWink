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
        CardBagPane pane = this;
        pane.item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel parent = (JPanel) pane.getParent();
                DataManager.delCardBag(pane.cardBag.getName());
                parent.remove(pane);
                parent.revalidate();
            }
        });
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
        setLayout(null);

        //---- label1 ----
        label1.setText("text");
        label1.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label1);
        label1.setBounds(65, 15, 75, 28);

        //---- button1 ----
        button1.setText("text");
        button1.setHorizontalAlignment(SwingConstants.LEFT);
        add(button1);
        button1.setBounds(6, 74, 88, 45);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JLabel label1;
    public JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public JPopupMenu menu = new JPopupMenu();
    public JMenuItem item = new JMenuItem("删除");
    public CardBag cardBag;
}
