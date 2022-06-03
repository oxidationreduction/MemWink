/*
 * Created by JFormDesigner on Sat May 28 16:54:13 CST 2022
 */

package com.MemWink.UI.panel;

import com.MemWink.UI.dialog.AddPane;
import com.MemWink.util.MemWinkUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;


/**
 * @author unknown
 */
public class ShowAllCards extends JPanel {
    public ShowAllCards() {
        initComponents();
        StagenCount stagenCount1 = new StagenCount();
        StagenCount stagenCount2 = new StagenCount();
        StagenCount stagenCount3 = new StagenCount();
        StagenCount stagenCount4 = new StagenCount();
        this.panel6.add(stagenCount1);
        this.panel6.add(stagenCount2);
        this.panel6.add(stagenCount3);
        this.panel6.add(stagenCount4);
        SortPane sortPane1 = new SortPane();
        SortPane sortPane2 = new SortPane();
        SortPane sortPane3 = new SortPane();
        SortPane sortPane4 = new SortPane();
        SortPane sortPane5 = new SortPane();
        this.panel8.add(sortPane1);
        this.panel8.add(sortPane2);
        this.panel8.add(sortPane3);
        this.panel8.add(sortPane4);
        this.panel8.add(sortPane5);
    }
    //添加菜单的两个监听


    private void menuItem1(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setVisible(true);
        jDialog.setBounds(500,250,300,300);
        Container container = jDialog.getContentPane();
        container.setLayout(null);
        Button button = new Button("123");
        button.setVisible(true);
        button.setBounds(0,0,100,100);
        container.add(button);
    }

    private void button1(ActionEvent e) {
        popupMenu1.show(button1,-95,0);
        button1.setIcon(MemWinkUtil.getScaledIcon("设置",30,30));
        button1.setBackground(Color.lightGray);
    }

    private void button2(ActionEvent e) {
        popupMenu2.show(button2,-75,0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - 刘洪宇
        popupMenu1 = new JPopupMenu();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menuItem6 = new JMenuItem();
        menuItem7 = new JMenuItem();
        popupMenu2 = new JPopupMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        scrollPane1 = new JScrollPane();
        panel1 = new JPanel();
        panel3 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();
        label3 = new JLabel();
        scrollPane2 = new JScrollPane();
        panel8 = new JPanel();
        panel4 = new JPanel();
        label1 = new JLabel();
        button1 = new JButton();
        panel5 = new JPanel();
        label2 = new JLabel();
        button2 = new JButton();

        //======== popupMenu1 ========
        {

            //---- menuItem3 ----
            menuItem3.setText("\u5361\u5305\u8bbe\u7f6e");
            popupMenu1.add(menuItem3);

            //---- menuItem4 ----
            menuItem4.setText("\u6392\u5e8f\u65b9\u5f0f");
            popupMenu1.add(menuItem4);

            //---- menuItem5 ----
            menuItem5.setText("\u9ed8\u8ba4\u663e\u793a\u5361\u7247");
            popupMenu1.add(menuItem5);

            //---- menuItem6 ----
            menuItem6.setText("\u6e05\u9664\u5361\u5305\u5185\u5bb9");
            popupMenu1.add(menuItem6);

            //---- menuItem7 ----
            menuItem7.setText("\u5220\u9664\u5361\u5305");
            popupMenu1.add(menuItem7);
        }

        //======== popupMenu2 ========
        {

            //---- menuItem1 ----
            menuItem1.setText("\u65b0\u5efa\u5361\u7247");
            menuItem1.addActionListener(e -> menuItem1(e));
            popupMenu2.add(menuItem1);

            //---- menuItem2 ----
            menuItem2.setText("\u5bfc\u5165csv");
            popupMenu2.add(menuItem2);
        }

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border
        .EmptyBorder(0,0,0,0), "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e",javax.swing.border.TitledBorder.CENTER,javax
        .swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069al\u006fg",java.awt.Font.BOLD,
        12),java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans
        .PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062or\u0064er".equals(e.
        getPropertyName()))throw new RuntimeException();}});
        setLayout(new BorderLayout());

        //======== scrollPane1 ========
        {

            //======== panel1 ========
            {
                panel1.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
            }
            scrollPane1.setViewportView(panel1);
        }
        add(scrollPane1, BorderLayout.CENTER);

        //======== panel3 ========
        {
            panel3.setLayout(new BorderLayout());

            //======== panel6 ========
            {
                panel6.setLayout(new GridLayout(2, 2, 18, 18));
            }
            panel3.add(panel6, BorderLayout.PAGE_START);

            //======== panel7 ========
            {
                panel7.setLayout(new BorderLayout());

                //---- label3 ----
                label3.setText("\u5206\u7c7b");
                label3.setHorizontalTextPosition(SwingConstants.RIGHT);
                label3.setHorizontalAlignment(SwingConstants.RIGHT);
                panel7.add(label3, BorderLayout.PAGE_START);

                //======== scrollPane2 ========
                {

                    //======== panel8 ========
                    {
                        panel8.setPreferredSize(new Dimension(40, 10));
                        panel8.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
                    }
                    scrollPane2.setViewportView(panel8);
                }
                panel7.add(scrollPane2, BorderLayout.CENTER);
            }
            panel3.add(panel7, BorderLayout.CENTER);
        }
        add(panel3, BorderLayout.LINE_END);

        //======== panel4 ========
        {
            panel4.setLayout(new BorderLayout());

            //---- label1 ----
            label1.setText("\u5361\u5305\u540d");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 14f));
            panel4.add(label1, BorderLayout.WEST);

            //---- button1 ----
            button1.setPreferredSize(new Dimension(45, 45));
            button1.addActionListener(e -> button1(e));
            panel4.add(button1, BorderLayout.EAST);
        }
        add(panel4, BorderLayout.PAGE_START);

        //======== panel5 ========
        {
            panel5.setLayout(new BorderLayout());

            //---- label2 ----
            label2.setText("\u5f85\u590d\u4e60\uff1a");
            label2.setHorizontalAlignment(SwingConstants.RIGHT);
            label2.setBorder(new EtchedBorder());
            panel5.add(label2, BorderLayout.CENTER);

            //---- button2 ----
            button2.setText("+");
            button2.setPreferredSize(new Dimension(45, 45));
            button2.addActionListener(e -> button2(e));
            panel5.add(button2, BorderLayout.EAST);
        }
        add(panel5, BorderLayout.PAGE_END);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - 刘洪宇
    private JPopupMenu popupMenu1;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JMenuItem menuItem5;
    private JMenuItem menuItem6;
    private JMenuItem menuItem7;
    private JPopupMenu popupMenu2;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JScrollPane scrollPane1;
    private JPanel panel1;
    private JPanel panel3;
    private JPanel panel6;
    private JPanel panel7;
    private JLabel label3;
    private JScrollPane scrollPane2;
    private JPanel panel8;
    private JPanel panel4;
    private JLabel label1;
    private JButton button1;
    private JPanel panel5;
    private JLabel label2;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
