package com.MemWink.UI.dialog;

import com.MemWink.Data.CardBag.CategorizedCard;
import com.MemWink.UI.panel.CardContent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditCardDialog extends JDialog {
    private CategorizedCard card;
    private JPanel panel;
    public EditCardDialog(CategorizedCard card, JPanel panel) {
        this.card = card;
        this.panel = panel;
        setup();
    }


    private void setup() {
        setSize(640, 450);
        setMinimumSize(new Dimension(640, 450));
        setLocation(
                (panel.getWidth() >> 1) - (getWidth() >> 1),
                (panel.getHeight() >> 1) - (getHeight() >> 1)
        );
        setVisible(true);

        mainPanel = new JPanel();
        mainPanel.setSize(640, 450);
        mainPanel.setLocation(0, 0);
        mainPanel.setLayout(null);

        // 正面
        {
            {
                frontLabel = new JLabel("正面");
                frontLabel.setFont(new Font("微软雅黑", Font.PLAIN, 25));
                frontLabel.setLocation(5, 5);
                frontLabel.setSize(100, 30);
            }
            mainPanel.add(frontLabel);

            {
                frontTextArea = new JTextArea(card.getFrontString());
                frontTextArea.setLocation(5, 40);
                frontTextArea.setSize((getWidth() >> 1) - 5, getHeight() - 80);
                frontTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 25));
                frontTextArea.setLineWrap(true);
                frontTextArea.setWrapStyleWord(true);
            }
            mainPanel.add(frontTextArea);
        }

        // 反面
        {
            {
                backLabel = new JLabel("反面");
                backLabel.setFont(new Font("微软雅黑", Font.PLAIN, 25));
                backLabel.setLocation(5 + (getWidth() >> 1), 5);
                backLabel.setSize(100, 30);
            }
            mainPanel.add(backLabel);

            {
                backTextArea = new JTextArea(card.getBackString());
                backTextArea.setLocation(5 + (getWidth() >> 1), 40);
                backTextArea.setSize((getWidth() >> 1) - 5, getHeight() - 80);
                backTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 25));
            }
            mainPanel.add(backTextArea);
        }

        // 确认按钮
        {
            confirm = new JButton("保存");
            confirm.setFont(new Font("微软雅黑", Font.PLAIN, 18));
            confirm.setSize(100, 50);
            confirm.setLocation(mainPanel.getWidth() - 105, mainPanel.getHeight() - 55);
            confirm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    card.updateFront(frontTextArea.getText());
                    card.updateBack(backTextArea.getText());
                    dispose();
                    if (panel instanceof CardContent) {
                        ((CardContent) panel).update();
                    } else {
                        throw new RuntimeException("EditCardDialog needs modify");
                    }

                    System.out.println("更改卡片内容，正面：" + card.getFrontString() + "， 背面：" + card.getBackString());
                }
            });
            confirm.setVisible(true);
        }
        mainPanel.add(confirm);

        add(mainPanel);
    }

    private JPanel mainPanel;
    private JLabel frontLabel;
    private JTextArea frontTextArea;
    private JLabel backLabel;
    private JTextArea backTextArea;
    private JButton confirm;
}
