package com.MemWink.Data.CardBag;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class UISetting implements Serializable {
    public boolean showBack = false;
    public int frontHorizenalAlignment = SwingConstants.CENTER;
    public String frontVerticalAlignment = BorderLayout.CENTER;
    public int frontFontSize = 50;

    public int backHorizenalAlignment = SwingConstants.CENTER;
    public String backVerticalAlignment = BorderLayout.CENTER;
    public int backFontSize = 50;
}
