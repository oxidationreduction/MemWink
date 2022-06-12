package com.MemWink.UI.panel;

import com.MemWink.util.MemWinkUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CardContentLabelsPanel extends JPanel {
    private List<String> content;
    private int horizonalAlignment;
    private int fontSize;
    private String verticalAlignment;
    private Dimension parentSize;
    private Color color;

    public CardContentLabelsPanel(
            List<String> content,
            int width,
            int horizonalAlignment,
            String verticalAlignment,
            Dimension parentSize,
            int fontSize,
            Color color) {
        this.content = content;
        setSize(width, (fontSize + 5) * content.size());
        this.horizonalAlignment = horizonalAlignment;
        this.parentSize = parentSize;
        this.color = color;
        updateVerticalAlignment(verticalAlignment);
        setup();
        updateFontSize(fontSize);
    }

    public void update() {
        removeAll();
        setup();
    }

    public void updateContent(List<String> content) {
        this.content = content;
        update();
    }

    public void updateHorizonalAlignment(int newAlignment) {
        this.horizonalAlignment = newAlignment;
        update();
    }

    public void updateFontSize(int fontSize) {
        this.fontSize = fontSize;
        font = new Font("微软雅黑", Font.PLAIN, fontSize);
        update();
    }

    private void setup() {
        setLayout(null);
        setBackground(null);
        setOpaque(false);
        setSize(getWidth(), (fontSize + 5) * content.size());
        int num = 0;
        for (String i : content) {
            JLabel tmp = new JLabel(i);
            {
                tmp.setFont(font);
                tmp.setForeground(
                        MemWinkUtil.isBrightColor(color) ? Color.BLACK : Color.WHITE);
                tmp.setHorizontalAlignment(horizonalAlignment);
                tmp.setSize(getWidth(), fontSize + 5);
                tmp.setLocation(0, num * tmp.getHeight());
            }
            add(tmp);
            num++;
        }
        super.updateUI();
    }

    public void updateVerticalAlignment(String verticalAlignment) {
        this.verticalAlignment = verticalAlignment;
        updateLocation();
    }

    public void updateParentSize(Dimension parentSize) {
        this.parentSize = parentSize;
        updateWidth((int) Math.round(parentSize.width * 0.9));
        updateLocation();
    }

    public void updateWidth(int width) {
        setSize(width, getHeight());
        update();
    }

    private void updateLocation() {
        if (Objects.equals(verticalAlignment, BorderLayout.NORTH)) {
            setLocation(20,20);
        } else if (Objects.equals(verticalAlignment, BorderLayout.CENTER)) {
            setLocation(20, (parentSize.height >> 1) - (this.getHeight() >> 1));
        } else {
            setLocation(20, parentSize.height - this.getHeight() - 20);
            System.out.println("New Location: " + getLocation());
        }

        update();
    }

    private List<JLabel> labels = new ArrayList<>();
    private Font font;
}
