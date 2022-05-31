package com.MemWink.UI.dialog;

import com.MemWink.Data.CardBag.CategorizedCard;
import com.MemWink.Data.CardBag.MemHistory;
import com.MemWink.util.constant.MemStateConstants;
import com.MemWink.util.MemWinkUtil;

import javax.swing.*;
import java.awt.*;

public class HistoryDialog extends JDialog {
    private CategorizedCard card;

    public HistoryDialog(CategorizedCard card) {
        this.card = card;
        setup();
    }

    public void setup() {
        JScrollPane historyPane;

        JPanel historyList = new JPanel();
        historyList.setLayout(new GridLayout(0, 1, 0, 10));
        JLabel historyItem = new JLabel();
        Font font = new Font("微软雅黑", Font.PLAIN, 15);
        ImageIcon tmpIcon = new ImageIcon("image/创建.png");
        Image tmpImage = tmpIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        tmpIcon = new ImageIcon(tmpImage);
        historyItem.setIcon(tmpIcon);
        historyItem.setText("创建于：" + MemWinkUtil.date2String(card.getCreateTime()));
        historyItem.setForeground(Color.BLACK);
        historyItem.setFont(font);
        historyItem.setSize(300, 30);
        historyList.add(historyItem);

        ImageIcon right = new ImageIcon("image/红叉.png");
        tmpImage = right.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        right = new ImageIcon(tmpImage);

        ImageIcon wrong = new ImageIcon("image/手动修改.png");
        tmpImage = wrong.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        wrong = new ImageIcon(tmpImage);
        ImageIcon manual = new ImageIcon("image/绿勾.png");
        tmpImage = manual.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        manual = new ImageIcon(tmpImage);

        int num = 1;
        for (MemHistory i : card.getMemHistories()) {
            historyItem = new JLabel();
            if (i.status == MemHistory.StatusNum.REMEMBERED) {
                historyItem.setIcon(right);
            } else if (i.status == MemHistory.StatusNum.FORGET) {
                historyItem.setIcon(wrong);
            } else {
                historyItem.setIcon(manual);
            }
            historyItem.setText("<html><body><font size=\"5\">第" + num + "次："
                    + MemStateConstants.getStageLabel(i.preState) + "→" + MemStateConstants.getStageLabel(i.afterState)
                    + "</font><br><font size=\"3\" color=\"gray\">" + MemWinkUtil.date2String(card.getCreateTime()) + "</font></body></html>");
            // historyItem.setFont(font);
            historyItem.setSize(280, 45);
            historyItem.setLocation(0, 45 * num);
            historyList.add(historyItem);
            num++;
        }

        historyList.setSize(280, 45 * num + 45);
        System.out.println(historyList.getSize());
        historyPane = new JScrollPane(historyList);
        add(historyPane);
        setVisible(true);
        setSize(280, Math.min(historyList.getHeight() + 80, 500));
        setLocation(170, 175);
        setResizable(false);
    }
}
