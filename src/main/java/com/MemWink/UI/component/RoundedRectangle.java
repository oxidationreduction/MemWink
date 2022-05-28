package com.MemWink.UI.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;

public class RoundedRectangle extends JPanel {
    private Paint p;
    private Color color;
    private double arc;
    public RoundedRectangle(int width, int height, double arc, Color color) {
        this.color = color;
        this.arc = arc;
        p = new GradientPaint(0, 0, color, getWidth(), getHeight(), color, true);
        setSize(width, height);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(p);

        g2d.setColor(color);
        Shape shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arc, arc);
        g2d.fill(shape);
    }

    public void setArc(double arc) {
        this.arc = arc;
    }

    public static void main(String[] args) {
        JFrame tmp = new JFrame();
        tmp.setSize(1000, 800);
        tmp.setLayout(null);
        RoundedRectangle tmpPanel = new RoundedRectangle(
                (int) Math.round(tmp.getWidth() * 0.6),
                (int) Math.round(tmp.getHeight() * 0.6),
                Math.round(tmp.getWidth() * 0.05),
                Color.ORANGE
        );
        tmpPanel.setLocation((int) Math.round(tmp.getWidth() * 0.2), (int) Math.round(tmp.getHeight() * 0.25));
        System.out.println(Math.round(tmp.getWidth() * 0.2) + " " + (int) Math.round(tmp.getHeight() * 0.25));
        tmp.add(tmpPanel);
        tmp.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                tmpPanel.setLocation((int) Math.round(tmp.getWidth() * 0.2), (int) Math.round(tmp.getHeight() * 0.25));
                tmpPanel.setSize((int) Math.round(tmp.getWidth() * 0.6), (int) Math.round(tmp.getHeight() * 0.6));
                tmpPanel.setArc(Math.round(tmp.getWidth() * 0.05));
                tmpPanel.updateUI();
                System.out.println(
                        tmp.getWidth() + " * " + tmp.getHeight() + ", "
                                + tmpPanel.getWidth() + " * " + tmpPanel.getHeight());
            }
        });
        tmp.setVisible(true);
    }
}
