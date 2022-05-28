package com.MemWink.UI.component;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;

/**
 * 折线图
 *
 * @author Liu Hongyu
 * @version 1.0
 * @since 2022-05-26
 */
public class Graph extends JPanel {
    private List<Double> data;
    private int type;

    /**
     * 构造器
     * @param type 折线图类型，参见 {@link GraphType}
     * @param width 图表宽度
     * @param height 图表高度
     * @param data 数据列表
     */
    public Graph(int type, int width, int height, List data) {
        super();
        setSize(width, height);
        this.data = new ArrayList<>();
        for (Object datum : data) {
            this.data.add(Double.parseDouble(datum + ""));
        }

        this.type = type;
        if (type < 0 || type > 2) {
            throw new RuntimeException("Invalid GraphType: " + type);
        }
        setVisible(true);
    }

    @Override
    public void paint(Graphics g0) {
        Graphics2D g = (Graphics2D) g0;
        g.setColor(Color.darkGray);
        g.setStroke(new BasicStroke(3));
        g.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
        double maxVal = getMaxVal();

        int n = data.size();
        int interval_x = (getWidth() - 50) / (n-1);
        int available_height = getHeight() - 40;
        for (int i = 0; i < n-1; i++) {
            int x1 = 20 + interval_x * i, y1 = getHeight() - (int) (data.get(i) / maxVal * available_height) -20;
            int x2 = 20 + interval_x * (i+1), y2 = getHeight() - (int) (data.get(i+1) / maxVal * available_height) -20;
            if (i > 0)
                g.drawOval(x1-1, y1-1, 2, 2);

            g.drawLine(x1, y1, x2, y2);
        }
        g.setColor(Color.GRAY);
        g.setStroke(new BasicStroke(1));
        g.drawLine(20, getHeight() - 20, getWidth()-30, getHeight() - 20);

        g.drawString(getTopLabel(), getWidth() - 50, 20);
        g.drawString("0", getWidth() - 25, getHeight()-15);
        g.drawString((n-1) + "天前", 20, getHeight()-5);
        g.drawString("今天", getWidth()-60, getHeight()-5);
    }

    private Double getMaxVal() {
        Double maxVal = Collections.max(data);
        if (type == GraphType.FORGET_RATE) {
            maxVal = maxVal < 0.5 ? 0.5 : maxVal;
        } else if (type == GraphType.REMEMBER_TIME) {
            maxVal = maxVal < 10 ? 10.0 : maxVal;
        }
        return maxVal;
    }

    private String getTopLabel() {
        if (type == GraphType.REMEMBER_TIME) {
            DecimalFormat format = new DecimalFormat("#####");
            return getMaxVal() == 10 ? "10" : format.format(getMaxVal());
        } else if (type == GraphType.FORGET_RATE) {
            DecimalFormat format = new DecimalFormat("###");
            return getMaxVal() == 0.5 ? "50%" : format.format(getMaxVal()*100) + "%";
        }
        return "";
    }
}

class Test {
    public static void main(String[] args) {
        int[] tmp = {12, 20, 18, 33, 45, 34};
        List<Double> data = new ArrayList<>();
        for (int i : tmp) {
            data.add((double) i / 100);
        }
        JFrame p = new JFrame();
        p.setSize(1280, 720);
        Graph g = new Graph(GraphType.FORGET_RATE, 700, 360, data);
        g.setLocation(100, 100);
        p.setVisible(true);
        // p.add(g);
        JPanel tmp1 = new JPanel();
        tmp1.setSize(70, 70);
        tmp1.setBackground(Color.black);
        p.add(tmp1);
    }
}