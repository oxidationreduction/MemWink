/*
 * Created by JFormDesigner on Mon May 30 22:12:29 CST 2022
 */

package com.MemWink.UI.panel;

import java.awt.event.*;
import com.MemWink.Data.CardBag.CategorizedCard;
import com.MemWink.UI.UIManager;
import com.MemWink.util.MemWinkUtil;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.util.List;
import javax.swing.*;

/**
 * @author unknown
 */
public class StagenCount extends JPanel {
    @Override
    public void paint(Graphics g) {
        int fieldX = 0;
        int fieldY = 0;
        int fieldWeight = getSize().width;
        int fieldHeight = getSize().height;
        RoundRectangle2D rect = new RoundRectangle2D.Double(fieldX, fieldY, fieldWeight, fieldHeight, 20, 20);
        g.setClip(rect);
        super.paint(g);
    }

    private void beautifyUI() {
        label3.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        label4.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        label5.setText(null);
        updateUI();
    }
    public void setLabel5(String filename,int a,int b){
        this.label5.setIcon(MemWinkUtil.getScaledIcon(filename,a,b));
    }
    public StagenCount(String name, List<CategorizedCard> list) {
        this.list=list;
        initComponents();
        label3.setText(String.valueOf(list.size()) + " ");
        label4.setText(name);
        beautifyUI();
    }

    private void thisMouseClicked(MouseEvent e) {
            UIManager.showAllCards.showcard(list);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Sun Yihan
        panel1 = new JPanel();
        vSpacer3 = new JPanel(null);
        label5 = new JLabel();
        panel4 = new JPanel();
        label3 = new JLabel();
        hSpacer2 = new JPanel(null);
        panel2 = new JPanel();
        label4 = new JLabel();
        vSpacer2 = new JPanel(null);
        hSpacer1 = new JPanel(null);
        panel3 = new JPanel();
        vSpacer1 = new JPanel(null);

        //======== this ========
        setPreferredSize(new Dimension(74, 73));
        setMaximumSize(new Dimension(74, 73));
        setMinimumSize(new Dimension(74, 73));
        setBorder(null);
        setBackground(Color.lightGray);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                thisMouseClicked(e);
            }
        });
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .
        EmptyBorder ( 0, 0 ,0 , 0) ,  null , javax. swing .border . TitledBorder. CENTER ,javax . swing
        . border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,
        java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( )
        { @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )
        throw new RuntimeException( ) ;} } );
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBackground(Color.lightGray);
            panel1.setLayout(new BorderLayout());

            //---- vSpacer3 ----
            vSpacer3.setBackground(Color.lightGray);
            vSpacer3.setPreferredSize(new Dimension(10, 11));
            panel1.add(vSpacer3, BorderLayout.NORTH);

            //---- label5 ----
            label5.setText("text");
            label5.setIcon(null);
            panel1.add(label5, BorderLayout.WEST);

            //======== panel4 ========
            {
                panel4.setBackground(Color.lightGray);
                panel4.setLayout(new BorderLayout());

                //---- label3 ----
                label3.setText("number");
                label3.setHorizontalAlignment(SwingConstants.RIGHT);
                label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 8));
                label3.setBackground(Color.lightGray);
                panel4.add(label3, BorderLayout.CENTER);

                //---- hSpacer2 ----
                hSpacer2.setBackground(Color.lightGray);
                hSpacer2.setPreferredSize(new Dimension(11, 10));
                panel4.add(hSpacer2, BorderLayout.EAST);
            }
            panel1.add(panel4, BorderLayout.EAST);
        }
        add(panel1, BorderLayout.NORTH);

        //======== panel2 ========
        {
            panel2.setBackground(Color.lightGray);
            panel2.setLayout(new BorderLayout());

            //---- label4 ----
            label4.setText("\u9636\u6bb5\u5206\u7c7b");
            label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 8));
            label4.setBackground(Color.lightGray);
            panel2.add(label4, BorderLayout.CENTER);

            //---- vSpacer2 ----
            vSpacer2.setBackground(Color.lightGray);
            vSpacer2.setPreferredSize(new Dimension(10, 5));
            panel2.add(vSpacer2, BorderLayout.SOUTH);

            //---- hSpacer1 ----
            hSpacer1.setBackground(Color.lightGray);
            hSpacer1.setPreferredSize(new Dimension(8, 10));
            panel2.add(hSpacer1, BorderLayout.WEST);
        }
        add(panel2, BorderLayout.SOUTH);

        //======== panel3 ========
        {
            panel3.setBackground(Color.lightGray);
            panel3.setLayout(new BorderLayout());

            //---- vSpacer1 ----
            vSpacer1.setBackground(Color.lightGray);
            vSpacer1.setPreferredSize(new Dimension(10, 20));
            panel3.add(vSpacer1, BorderLayout.PAGE_END);
        }
        add(panel3, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    private List<CategorizedCard> list;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Sun Yihan
    private JPanel panel1;
    private JPanel vSpacer3;
    private JLabel label5;
    private JPanel panel4;
    private JLabel label3;
    private JPanel hSpacer2;
    private JPanel panel2;
    private JLabel label4;
    private JPanel vSpacer2;
    private JPanel hSpacer1;
    private JPanel panel3;
    private JPanel vSpacer1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
