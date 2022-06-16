package com.MemWink.UI.dialog;

import com.MemWink.Data.CardBag.CategorizedCard;
import com.MemWink.Data.DataManager;
import com.MemWink.util.constant.UIConstant;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MoveCardDialog extends JDialog {
    private CategorizedCard card;
    private String operation;
    public MoveCardDialog(CategorizedCard card, String operation) {
        // System.out.print("卡片归属移动对话框 ");
        this.card = card;
        this.operation = operation;
        setup();
        // System.out.println("UI设置结束");
    }

    private void setup() {
        JPanel mainPanel = new JPanel();
        JScrollPane cardBagPane = new JScrollPane();

        List<String> tmp = DataManager.getCardBagNames();
        tmp.remove(card.getCardBagName());
        JList<String> cardBagList = new JList<>(tmp.toArray(new String[0]));

        cardBagList.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        cardBagList.setSize(250, tmp.size() * 30);
        cardBagPane.setViewportView(cardBagList);
        cardBagPane.setSize(250, 265);
        cardBagPane.setLocation(0, 40);

        mainPanel.setLayout(null);
        JLabel moveToLabel = new JLabel("将卡片" + operation + "到");
        moveToLabel.setLocation(5, 2);
        moveToLabel.setSize(200, 35);
        moveToLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));

        JButton confirmButton = new JButton("确认");
        confirmButton.setSize(80, 40);
        confirmButton.setLocation(165, 305);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!cardBagList.getValueIsAdjusting()) {
                    String name = cardBagList.getSelectedValue();
                    if (name != null) {
                        card.moveToCardBag(name);
                        MoveCardDialog.this.dispose();
                        // System.out.println("卡片归属改为：" + name);
                    } else {
                        JLabel warningLabel = new JLabel("请选择卡包");
                        warningLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
                        warningLabel.setForeground(Color.RED);
                        warningLabel.setLocation(5, 310);
                        warningLabel.setSize(120, 25);
                        mainPanel.add(warningLabel);
                        MoveCardDialog.this.repaint();
                        // System.out.println("显示警示标签");
                    }
                }
            }
        });

        mainPanel.add(moveToLabel);
        mainPanel.add(cardBagPane);
        mainPanel.add(confirmButton);
        mainPanel.setVisible(true);
        mainPanel.setSize(250, 375);

        add(mainPanel);
        setSize(250, 375);
        setLocation(
                (UIConstant.mainPanelWidth >> 1) - 125,
                (UIConstant.mainPanelHeight >> 1) - 150
        );
        setVisible(true);
        setResizable(false);
    }
}
