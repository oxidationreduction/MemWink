package com.MemWink.Data.CardBag;

import javax.swing.*;
import java.io.Serializable;

public class UISetting implements Serializable {
    public boolean showBack = false;
    public int frontHorizenalAlignment = SwingConstants.CENTER;
    public int frontVerticalAlignment = SwingConstants.CENTER;
    public int frontFontSize = 50;

    public int backHorizenalAlignment = SwingConstants.CENTER;
    public int backVerticalAlignment = SwingConstants.CENTER;
    public int backFontSize = 50;
}
