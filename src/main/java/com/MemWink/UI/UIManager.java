package com.MemWink.UI;

import com.MemWink.UI.panel.CardBagsPanel;

import javax.swing.*;

public class UIManager {
    public UIManager() {
        JFrame frame = new JFrame();
        frame.setSize(1440, 810);
        frame.add(new CardBagsPanel());
        frame.setVisible(true);
    }
}
