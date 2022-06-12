package com.MemWink.util;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 工具类
 * @author Liu Hongyu
 * @since 2022-05-29
 */
public class MemWinkUtil {
    /**
     * 将日期转换为中文字符串
     * @param date 要转换的日期
     * @return 日期转换为"yyyy年mm月dd日"后的字符串
     */
    public static String date2String(Date date) {
        return (date.getYear() + 1900) + "年" + date.getMonth() + "月" + date.getDate() + "日"
                + " " + date.getHours() + ":" + date.getMinutes();
    }

    /**
     * 将图片转换并生成指定大小的图标
     * @param fileName 图片名（去除扩展名）
     * @param width 目标图标宽度
     * @param height 目标图标高度
     * @return 生成的图标
     */
    public static ImageIcon getScaledIcon(String fileName, int width, int height) {
        ImageIcon tmpIcon = new ImageIcon("image/" + fileName + ".png");
        Image tmpImage = tmpIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        return new ImageIcon(tmpImage);
    }

    /**
     * 判断一种颜色是否为亮色
     * @param color 要判断的颜色
     * @return true-是亮色；false-是暗色
     */
    public static boolean isBrightColor(Color color) {
        return color.equals(Color.orange) || color.equals(Color.yellow) || color.equals(Color.green);
    }
}
