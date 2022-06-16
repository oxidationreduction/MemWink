package com.MemWink.UI.panel;

import com.MemWink.util.MemWinkUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 卡片详情页用于显示卡片内容的面板
 * <p>手动实现了排版功能</p>
 * @author Liu Hongyu
 * @since 2022-05-30
 */
public class CardContentLabelsPanel extends JPanel {
    /**
     * 记载卡片内容的字符串列表
     */
    private List<String> content;

    /**
     * 水平对齐配置
     */
    private int horizonalAlignment;

    /**
     * 垂直对齐配置
     */
    private String verticalAlignment;

    /**
     * 文字大小
     */
    private int fontSize;

    /**
     * 父面板(代表卡片的圆角矩形面板)大小
     */
    private Dimension parentSize;

    /**
     * 颜色
     */
    private Color color;

    /**
     * 构造器
     * @param content 卡片内容列表
     * @param width 宽度
     * @param horizonalAlignment 水平对齐配置
     * @param verticalAlignment 垂直对齐配置
     * @param parentSize 父面板大小
     * @param fontSize 文字大小
     * @param color 颜色
     */
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

    /**
     * 页面更新
     */
    public void update() {
        removeAll();
        setup();
    }

    /**
     * 卡片内容更新
     * @param content 新内容
     */
    public void updateContent(List<String> content) {
        this.content = content;
        update();
    }

    /**
     * 水平对齐配置更新
     * @param newAlignment 新的水平对齐配置
     */
    public void updateHorizonalAlignment(int newAlignment) {
        this.horizonalAlignment = newAlignment;
        update();
    }

    /**
     * 文字大小更新
     * @param fontSize 新的文字大小
     */
    public void updateFontSize(int fontSize) {
        this.fontSize = fontSize;
        font = new Font("微软雅黑", Font.PLAIN, fontSize);
        update();
    }

    /**
     * 页面初始化
     */
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

    /**
     * 垂直对齐配置更新
     * @param verticalAlignment 新的水平对齐配置
     */
    public void updateVerticalAlignment(String verticalAlignment) {
        this.verticalAlignment = verticalAlignment;
        updateLocation();
    }

    /**
     * 更新父面板大小
     * @param parentSize 父面板大小
     */
    public void updateParentSize(Dimension parentSize) {
        this.parentSize = parentSize;
        updateWidth((int) Math.round(parentSize.width * 0.9));
        updateLocation();
    }

    /**
     * 更新宽度
     * @param width 新宽度
     */
    public void updateWidth(int width) {
        setSize(width, getHeight());
        update();
    }

    /**
     * 更新面板位置
     */
    private void updateLocation() {
        if (Objects.equals(verticalAlignment, BorderLayout.NORTH)) {
            setLocation(20,20);
        } else if (Objects.equals(verticalAlignment, BorderLayout.CENTER)) {
            setLocation(20, (parentSize.height >> 1) - (this.getHeight() >> 1));
        } else {
            setLocation(20, parentSize.height - this.getHeight() - 20);
            // System.out.println("New Location: " + getLocation());
        }

        update();
    }

    /**
     * 字体配置
     */
    private Font font;
}
