package com.MemWink.util;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class MemWinkUtil {
    public static String date2String(Date date) {
        return (date.getYear() + 1900) + "年" + date.getMonth() + "月" + date.getDate() + "日"
                + " " + date.getHours() + ":" + date.getMinutes();
    }
    public static ImageIcon getScaledIcon(String fileName, int width, int height) {
        ImageIcon tmpIcon = new ImageIcon("image/" + fileName + ".png");
        Image tmpImage = tmpIcon.getImage().getScaledInstance(width, width, Image.SCALE_DEFAULT);
        return new ImageIcon(tmpImage);
    }
}
