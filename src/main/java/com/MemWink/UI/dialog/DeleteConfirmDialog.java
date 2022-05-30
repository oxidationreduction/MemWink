package com.MemWink.UI.dialog;

import com.MemWink.Data.CardBag.CategorizedCard;
import com.MemWink.Data.DataManager;
import com.MemWink.UI.panel.CardContent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class DeleteConfirmDialog extends JDialog {
    private CategorizedCard card;
    private CardContent panel;
    public DeleteConfirmDialog(CategorizedCard card, CardContent panel) {
        this.card = card;
        this.panel = panel;
        setup();
    }
    public void setup() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        JLabel warningLabel = new JLabel("操作无法恢复");
        warningLabel.setFont(new Font("微软雅黑", Font.PLAIN, 35));
        ImageIcon tmpIcon = new ImageIcon("image/手动修改.png");
        Image tmpImage = tmpIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        tmpIcon = new ImageIcon(tmpImage);
        warningLabel.setIcon(tmpIcon);
        warningLabel.setHorizontalAlignment(SwingConstants.CENTER);
        warningLabel.setSize(350, 100);
        warningLabel.setLocation(0, 0);

        JButton abort = new JButton("取消");
        abort.setLocation(5, 120);
        abort.setSize(120, 45);
        abort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteConfirmDialog.this.dispose();
                System.out.println("取消删除");
            }
        });

        JButton confirm = new JButton("仍然删除");
        confirm.setLocation(225, 120);
        confirm.setSize(120, 45);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Objects.requireNonNull(DataManager.provideCardBag(card.getCardBagName())).delCard(card);
                DeleteConfirmDialog.this.dispose();
                panel.setVisible(false);
                System.out.println("仍然删除");
            }
        });

        mainPanel.add(warningLabel);
        mainPanel.add(abort);
        mainPanel.add(confirm);
        mainPanel.setSize(350, 200);

        add(mainPanel);
        setSize(350, 200);
        setVisible(true);
        setResizable(false);
    }
}
