package com.MemWink.UI.component;

import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.util.constant.UIConstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

public class CardbagLookup extends JPanel {
    private CardBag cardBag;

    private String name;

    private int reviewNum;

    private int totalNum;

    private Color color;

    private JPanel base;

    private JButton reviewButton;

    private JPanel rectangleBack;
    private JLabel totalNumLabel;

    private MouseListener pressCardGrid = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // System.out.println("Open cards grid.");
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };

    public CardbagLookup(CardBag cardBag) {
        this.cardBag = cardBag;
        init();
        setComponent();
    }
    public void init() {
        this.name = cardBag.getName();
        this.totalNum = cardBag.getTotalCardsNum();
        this.reviewNum = cardBag.getReviewCardsNum();
        this.color = cardBag.getColor();
        this.reviewButton = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("记忆(" + reviewNum + ") in " + name);
            }
        });
        this.reviewButton.setLabel("记忆(" + reviewNum + ")");
        this.setLayout(null);
        this.setSize(240, 160);
    }

    public void setComponent() {
        base = getBase();
        JLabel totalCards = new JLabel(totalNum + " ", SwingConstants.RIGHT);
        totalCards.setFont(new Font("微软雅黑", Font.BOLD, 35));
        totalCards.setVerticalAlignment(SwingConstants.BOTTOM);
        totalCards.setHorizontalAlignment(SwingConstants.RIGHT);
        totalCards.setForeground(Color.white);
        totalCards.setBounds(0, 10, 200, 35);
        base.add(totalCards);

        if (reviewNum > 0) {
            reviewButton.setBounds(5, 75, 80, 40);
            base.add(reviewButton);
        }

        JButton cardBagButton = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println(name);
            }
        });

        base.addMouseListener(pressCardGrid);
        this.add(base);

        JLabel nameLabel = new JLabel(name);
        nameLabel.addMouseListener(pressCardGrid);
        nameLabel.setBounds(20, 133, 200, 30);
        nameLabel.setFont(new Font("微软雅黑", Font.BOLD, 25));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(nameLabel);
        this.setBackground(UIConstant.background);
        this.setVisible(true);
    }

    public JPanel getBase() {
        Paint p = new GradientPaint(0.0f, 0.0f, color,
                getWidth(), getHeight(), color, true);
        JPanel panel = new JPanel(){
            private static final long serialVersionUID = 1L;

            public void paintComponent(Graphics g){
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(p);

                // 设置画笔颜色为蓝色
                g2d.setColor(color);
                Shape shape = null;
                shape = new RoundRectangle2D.Double(0, 0, 200, 120, 20D, 20D);
                g2d.fill(shape);
            }
        };
        panel.setLayout(null);
        panel.setBounds(20, 10, 200, 120);
        panel.setVisible(true);
        return panel;
    }
}