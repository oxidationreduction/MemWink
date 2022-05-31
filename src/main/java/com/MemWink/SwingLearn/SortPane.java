/*
 * Created by JFormDesigner on Tue May 31 08:29:38 CST 2022
 */

package com.MemWink.SwingLearn;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class SortPane extends JPanel {
    public SortPane() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();

        //======== this ========
        setMaximumSize(new Dimension(10, 17));
        setMinimumSize(new Dimension(10, 17));
        setPreferredSize(new Dimension(10, 17));
        setBorder(new EtchedBorder());
        setLayout(new BorderLayout());

        //---- label1 ----
        label1.setText("\u79cd\u7c7b");
        add(label1, BorderLayout.WEST);

        //---- label2 ----
        label2.setText("number");
        add(label2, BorderLayout.EAST);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
