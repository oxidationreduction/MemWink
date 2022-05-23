/*
 * Created by JFormDesigner on Mon May 16 20:00:47 CST 2022
 */

package com.MemWink.SwingLearn;

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
        String name = textField1.getText();
        label.setText(name);
    }

    private void textField2CaretUpdate(CaretEvent e) {

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        textField1 = new JTextField();
        example = new JPanel();
        label1 = new JLabel();
        label = new JLabel();
        colorPane = new JPanel();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        save = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setModal(true);
        setTitle("\u5361\u5305\u8bbe\u7f6e");
        var contentPane = getContentPane();

        //---- textField1 ----
        textField1.addCaretListener(e -> textField1CaretUpdate(e));

        //======== example ========
        {
            example.setBackground(Color.blue);
            example.setBorder(new LineBorder(Color.blue, 20, true));

            //---- label1 ----
            label1.setText("0");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));

            GroupLayout exampleLayout = new GroupLayout(example);
            example.setLayout(exampleLayout);
            exampleLayout.setHorizontalGroup(
                exampleLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, exampleLayout.createSequentialGroup()
                        .addGap(0, 114, Short.MAX_VALUE)
                        .addComponent(label1))
            );
            exampleLayout.setVerticalGroup(
                exampleLayout.createParallelGroup()
                    .addGroup(exampleLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1)
                        .addContainerGap(50, Short.MAX_VALUE))
            );
        }

        //---- label ----
        label.setText("example");

        //======== colorPane ========
        {
            colorPane.setLayout(new GridLayout(1, 6, 5, 0));
        }

        //---- label2 ----
        label2.setText("\u8bf7\u8f93\u5165\u5361\u5305\u7684\u540d\u5b57\uff1a");
        label2.setHorizontalAlignment(SwingConstants.RIGHT);
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 8f));

        //---- textField2 ----
        textField2.addCaretListener(e -> textField2CaretUpdate(e));

        //---- label3 ----
        label3.setText("\u8bf7\u8f93\u5165\u6bcf\u65e5\u590d\u4e60\u5361\u7247\u6570\u91cf\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 8f));

        //---- save ----
        save.setText("\u786e\u5b9a");
        save.setFont(save.getFont().deriveFont(save.getFont().getSize() + 8f));
        save.setBackground(Color.black);
        save.setForeground(Color.lightGray);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label2)
                                .addComponent(label3))
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(label))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                        .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(202, 202, 202)
                            .addComponent(example, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(52, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(119, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(colorPane, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)
                            .addGap(78, 78, 78))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(save)
                            .addGap(37, 37, 37))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(example, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                    .addComponent(colorPane, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(save)
                    .addGap(22, 22, 22))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTextField textField1;
    private JPanel example;
    private JLabel label1;
    private JLabel label;
    private JPanel colorPane;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JLabel save;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private Color addColor = Color.blue;
    private LinkedList<colorButton> buttons = new LinkedList<>();
    private JPopupMenu menu = new JPopupMenu();
    private JMenuItem item = new JMenuItem("请输入合法的参数");

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
                example.setBackground(button.color);
                example.setBorder(BorderFactory.createLineBorder(example.getBackground(),30,true));
                addColor = button.color;
            }
        }
    }
}
