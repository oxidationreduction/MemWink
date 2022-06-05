package com.MemWink.UI.dialog;

import com.MemWink.Data.CardBag.CategorizedCard;
import com.MemWink.Data.DataManager;
import com.MemWink.UI.panel.CardContent;
import com.MemWink.UI.panel.ReviewPanel;
import com.MemWink.util.constant.DataManagerStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AddCategoryDialog extends JDialog {
    private CategorizedCard card;
    private JPanel panel;
    public AddCategoryDialog(CategorizedCard card, JPanel panel) {
        this.card = card;
        this.panel = panel;
        setup();
    }

    private void setup() {
        setResizable(false);
        setSize(300, 150);
        setLocation(
                (panel.getWidth() >> 1) - (getWidth() >> 1),
                (panel.getHeight() >> 1) - (getHeight() >> 1)
        );
        setLayout(null);
        setVisible(true);

        // mainPanel
        {
            mainPanel = new JPanel();
            mainPanel.setSize(300, 200);
            mainPanel.setLocation(0, 0);
            mainPanel.setLayout(null);
        }

        // titleLabel
        {
            titleLabel = new JLabel("添加新分类(最多20字)");
            titleLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
            titleLabel.setLocation(5, 5);
            titleLabel.setSize(250, 30);
            mainPanel.add(titleLabel);
        }

        // insertArea
        {
            insertArea = new JTextArea();
            insertArea.setFont(new Font("微软雅黑", Font.PLAIN, 20));
            insertArea.setSize(250, 30);
            insertArea.setLocation(25, 40);
            mainPanel.add(insertArea);
        }

        // error
        {
            error.setVisible(false);
            error.setFont(new Font("微软雅黑", Font.PLAIN, 15));
            error.setForeground(Color.RED);
            error.setSize(180, 25);
            error.setLocation(10, 82);
            mainPanel.add(error);
        }

        // confirmButton
        {
            confirmButton = new JButton("确定");
            confirmButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
            confirmButton.setSize(80, 35);
            confirmButton.setLocation(205, 80);
            confirmButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (Objects.equals(insertArea.getText(), "未分类")) {
                        error.setVisible(true);
                        return;
                    }
                    int ans = DataManager.addCategory(card.getCardBagName(), insertArea.getText());
                    if (ans == DataManagerStatus.NORMAL) {
                        card.updateCategory(insertArea.getText());
                        if (panel instanceof CardContent) {
                            ((CardContent) panel).categoryMenuUpdate();
                        }
                        dispose();
                    } else if (ans == DataManagerStatus.DUPLICATE_CATEGORY) {
                        error.setVisible(true);
                    }
                }
            });
            // confirmButton.setEnabled(true);
            mainPanel.add(confirmButton);
        }

        add(mainPanel);
        setVisible(true);
    }

    private JPanel mainPanel;
    private JLabel titleLabel;
    private JTextArea insertArea;
    private JButton confirmButton;
    private JLabel error = new JLabel("分类名不可用，请修改");
}
