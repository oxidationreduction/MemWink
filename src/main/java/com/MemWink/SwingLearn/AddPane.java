/*
 * Created by JFormDesigner on Mon May 16 20:00:47 CST 2022
 */

package com.MemWink.SwingLearn;

import com.MemWink.Data.DataManager;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.LineBorder;
import javax.swing.event.*;

/**
 * @author unknown
 */
public class AddPane extends JDialog {
    public AddPane() {
        initComponents();
        top = new CardBagPaneTop();
        top.setBackground(Color.blue);
        example.add(top,BorderLayout.CENTER);
        colorButton button = new colorButton(Color.blue);
        button.selected = true;
        button.setBorder(BorderFactory.createLineBorder(Color.black));
        buttons.add(button);
        buttons.add(new colorButton(Color.black));
        buttons.add(new colorButton(Color.orange));
        buttons.add(new colorButton(Color.gray));
        buttons.add(new colorButton(Color.yellow));
        buttons.add(new colorButton(Color.green));

        for ( colorButton temp: buttons){
            colorPane.add(temp);
        }
        addColor = Color.blue;


    }

    private void textField1CaretUpdate(CaretEvent e) {
        label.setText(textField1.getText());
        if ( textField2.getText().matches("\\d+") && Integer.parseInt(textField2.getText()) > 0 && !label.getText().equals("") ){
            save.setForeground(Color.black);
        }
        else {
            save.setForeground(Color.lightGray);
        }
    }

    private void textField2CaretUpdate(CaretEvent e) {
        if ( textField2.getText().matches("\\d+") && Integer.parseInt(textField2.getText()) > 0 && !label.getText().equals("") ){
            save.setForeground(Color.black);
        }
        else {
            save.setForeground(Color.lightGray);
        }
    }

    private void saveMouseClicked(MouseEvent e) {
        if ( save.getForeground() == Color.black ){
            if ( DataManager.addCardBag(textField1.getText(),addColor,Integer.parseInt(textField2.getText())) == 0 ){
                ShowCardBags showCardBags = ShowCardBags.getShowCardBags();
                CardBagPane cardBagPane = new CardBagPane();
                cardBagPane.cardBag = DataManager.provideCardBag(textField1.getText());
                cardBagPane.label2.setText(textField1.getText());
                cardBagPane.cardBagPaneTop.setBackground(addColor);
                showCardBags.panel1.add(cardBagPane);
                showCardBags.updateUI();
                this.dispose();
            }
            else {
                save.setBorder(BorderFactory.createLineBorder(Color.red));
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        colorPane = new JPanel();
        save = new JLabel();
        example = new JPanel();
        label = new JLabel();
        panel2 = new JPanel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        textField2 = new JTextField();

        //======== this ========
        setBackground(Color.white);
        setModal(true);
        setTitle("\u5361\u5305\u8bbe\u7f6e");
        var contentPane = getContentPane();

        //======== colorPane ========
        {
            colorPane.setLayout(new GridLayout(1, 6, 5, 0));
        }

        //---- save ----
        save.setText("\u786e\u5b9a");
        save.setFont(save.getFont().deriveFont(save.getFont().getSize() + 8f));
        save.setBackground(Color.black);
        save.setForeground(Color.lightGray);
        save.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                saveMouseClicked(e);
            }
        });

        //======== example ========
        {
            example.setBorder(BorderFactory.createEmptyBorder());
            example.setLayout(new BorderLayout());

            //---- label ----
            label.setText("example");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            example.add(label, BorderLayout.SOUTH);
        }

        //======== panel2 ========
        {
            panel2.setLayout(new GridLayout(2, 2, 0, 5));

            //---- label2 ----
            label2.setText("\u8bf7\u8f93\u5165\u5361\u5305\u7684\u540d\u5b57\uff1a");
            label2.setHorizontalAlignment(SwingConstants.RIGHT);
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 8f));
            panel2.add(label2);

            //---- textField1 ----
            textField1.addCaretListener(e -> textField1CaretUpdate(e));
            panel2.add(textField1);

            //---- label3 ----
            label3.setText("\u8bf7\u8f93\u5165\u6bcf\u65e5\u590d\u4e60\u5361\u7247\u6570\u91cf\uff1a");
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 8f));
            label3.setHorizontalAlignment(SwingConstants.RIGHT);
            panel2.add(label3);

            //---- textField2 ----
            textField2.addCaretListener(e -> textField2CaretUpdate(e));
            panel2.add(textField2);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(117, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(save)
                            .addGap(37, 37, 37))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(colorPane, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)
                            .addGap(80, 80, 80))))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 524, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(168, 168, 168)
                            .addComponent(example, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(22, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(example, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(colorPane, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                    .addComponent(save)
                    .addGap(22, 22, 22))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel colorPane;
    private JLabel save;
    private JPanel example;
    private JLabel label;
    private JPanel panel2;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private CardBagPaneTop top;
    private Color addColor = Color.blue;
    private LinkedList<colorButton> buttons = new LinkedList<>();

    private class colorButton extends JButton{
        private Color color;
        private boolean selected = false;

        public colorButton(Color color) {
            this.color = color;
            this.setBackground(color);
            this.setBorder(BorderFactory.createLineBorder(this.color));
            this.addActionListener(new ButtonListener(this));
        }
    }

    private class ButtonListener implements ActionListener{
        private colorButton button;

        public ButtonListener(colorButton button) {
            this.button = button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if ( !button.selected ){
                colorButton temp = new colorButton(Color.black);
                for ( colorButton colorButton: buttons){
                    if ( colorButton.selected){
                        temp = colorButton;
                    }
                }
                temp.selected = false;
                temp.setBorder(BorderFactory.createLineBorder(temp.color));
                button.selected = true;
                button.setBorder(BorderFactory.createLineBorder(Color.black));
                top.setBackground(button.color);
                addColor = button.color;
            }
        }
    }
}
