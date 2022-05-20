package com.MemWink.UI.panel;

import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.Data.DataManager;
import com.MemWink.UI.UIConstant;
import com.MemWink.UI.component.CardbagLookup;

import javax.swing.*;
import java.awt.*;

public class CardBagsPanel extends JPanel {
    private JScrollPane scrollPane = new JScrollPane();

    private JPanel basePanel = new JPanel();

    private JPanel cardBagsGridPanel = new JPanel(new GridLayout(0, 6));

    private JLabel cardBagLabel = new JLabel("卡包");

    public CardBagsPanel() {
        setupUI();

    }

    private void setupUI() {
        cardBagLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 80));
        cardBagLabel.setHorizontalAlignment(SwingConstants.LEFT);
        cardBagLabel.setBounds(0, 0, 1440, 90);
        cardBagLabel.setForeground(Color.WHITE);
        for (CardBag i : DataManager.getCardBags()) {
            cardBagsGridPanel.add(new CardbagLookup(i));
        }
        cardBagsGridPanel.setBounds(0, 90,1440, 720);
        cardBagsGridPanel.setBackground(UIConstant.background);
        cardBagsGridPanel.setVisible(true);

        basePanel.setLayout(null);
        basePanel.setBounds(0, 0, 1440, 810);
        basePanel.add(cardBagLabel);
        basePanel.add(cardBagsGridPanel);

        basePanel.setVisible(true);
        basePanel.setBackground(UIConstant.background);
        scrollPane.add(basePanel);
        scrollPane.setVisible(true);
        scrollPane.setBackground(UIConstant.background);
        this.setLayout(null);
        this.setSize(1440, 810);
        this.add(basePanel);
        this.setVisible(true);
    }
}
