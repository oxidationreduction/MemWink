/*
 * Created by JFormDesigner on Mon May 16 20:11:50 CST 2022
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
public class AddMemCard extends JDialog {
    public AddMemCard(Window owner) {
        super(owner);
        initComponents();
        this.panel1.add(new ColorButton(Color.green));
        this.panel1.add(new ColorButton(Color.pink));
        this.panel1.add(new ColorButton(Color.orange));
        this.panel1.add(new ColorButton(Color.CYAN));
        this.panel1.add(new ColorButton(Color.red));
        this.panel1.add(new ColorButton(Color.magenta));
        this.panel1.add(new ColorButton(Color.blue));
    }

    private void label3MouseClicked(MouseEvent e) {
        String name = textField1.getText();
        if ( !name.equals("") && colorSelect ) {
            DataManager.addCardBag(name,color,10);
            this.dispose();
            MainFrame mainFrame = (MainFrame) this.getOwner();
            CardBagPane pane = new CardBagPane();
            CardBag cardBag = DataManager.provideCardBag(name);
            pane.cardBag = cardBag;
            pane.setBackground(cardBag.getColor());
            pane.label1.setText(cardBag.getName());
            mainFrame.mainPanel.add(pane);
            mainFrame.revalidate();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label4 = new JLabel();
        panel1 = new JPanel();
        label3 = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setModal(true);
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u53d6\u6d88");

        //---- label2 ----
        label2.setText("\u65b0\u5efa\u8bb0\u5fc6\u95ea\u5361\u5305");

        //---- textField1 ----
        textField1.setToolTipText("\u5361\u5305\u540d\u79f0");

        //---- label4 ----
        label4.setText("\u5361\u5305\u5e95\u8272");

        //======== mainPanel ========
        {
            panel1.setLayout(new GridLayout(1, 7, 10, 0));
        }

        //---- label3 ----
        label3.setText("\u4fdd\u5b58");
        label3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label3MouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                    .addGap(170, 170, 170)
                    .addComponent(label2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addGap(21, 21, 21))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label4)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(273, Short.MAX_VALUE)
                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
                    .addGap(35, 35, 35))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(46, 46, 46)
                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                    .addGap(63, 63, 63)
                    .addComponent(label4)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addGap(7, 7, 7))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label4;
    private JPanel panel1;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private Color color;
    private boolean colorSelect;
    class ColorButton extends JButton{
        public ColorButton(Color button_color) {
            this.setBorder(BorderFactory.createLineBorder(button_color));
            this.setBackground(button_color);
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    colorSelect = !colorSelect;
                    if ( colorSelect ){
                        color = getBackground();
                        setBorder(BorderFactory.createLineBorder(Color.black));
                    }
                    else {
                        setBorder(BorderFactory.createLineBorder(button_color));
                    }
                }

            });
        }
    }
}
