package com.MemWink.UI.dialog;

import com.MemWink.Data.CardBag.CategorizedCard;
import com.MemWink.UI.panel.CardContent;
import com.MemWink.UI.panel.ShowAllCards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 卡片编辑器对话框
 * <p>用于新建或编辑卡片，修改卡片正/反面内容时使用</p>
 * @author Liu Hongyu
 * @since 2022-05-30
 */
public class EditCardDialog extends JDialog {
    /**
     * 被编辑的卡片
     */
    private CategorizedCard card;

    /**
     * 启动此对话框的面板
     */
    private JPanel panel;

    /**
     * 构造器
     */
    public EditCardDialog(CategorizedCard card, JPanel panel) {
        this.card = card;
        this.panel = panel;
        setup();
    }

    /**
     * 更新外观
     */
    private void update() {
        mainPanel.setSize(getWidth(), getHeight());
        frontTextArea.setSize(
                (getWidth() >> 1) - 5,
                getHeight() - 120
        );

        backLabel.setLocation(5 + (getWidth() >> 1), 5);
        backTextArea.setLocation(5 + (getWidth() >> 1), 40);
        backTextArea.setSize(
                (getWidth() >> 1) - 5,
                getHeight() - 120
        );
        confirm.setLocation(
                mainPanel.getWidth() - 105,
                mainPanel.getHeight() - 77
        );
    }

    /**
     * 初始化外观
     */
    private void setup() {
        setSize(640, 480);
        setMinimumSize(new Dimension(640, 480));
        setLocation(
                (panel.getWidth() >> 1) - (getWidth() >> 1),
                (panel.getHeight() >> 1) - (getHeight() >> 1)
        );
        setVisible(true);

        mainPanel = new JPanel();
        mainPanel.setSize(640, 480);
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
                frontTextArea.setSize(
                        (getWidth() >> 1) - 5,
                        getHeight() - 90
                );
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
                backTextArea.setSize((getWidth() >> 1) - 5, getHeight() - 90);
                backTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 25));
                backTextArea.setLineWrap(true);
            }
            mainPanel.add(backTextArea);
        }

        // 保存按钮
        {
            confirm = new JButton("保存");
            confirm.setFont(new Font("微软雅黑", Font.PLAIN, 18));
            confirm.setSize(100, 45);
            confirm.setLocation(
                    mainPanel.getWidth() - 105,
                    mainPanel.getHeight() - 48
            );
            confirm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    card.updateFront(frontTextArea.getText());
                    card.updateBack(backTextArea.getText());
                    dispose();
                    if (panel instanceof CardContent) {
                        ((CardContent) panel).update();
                    }
                    else if(panel instanceof ShowAllCards){
                        ((ShowAllCards) panel).cardBag1.addCard(card);
                        ((ShowAllCards) panel).showcard(((ShowAllCards) panel).cardBag1.getCards());
                    }
                    else {
                        throw new RuntimeException("EditCardDialog needs modify");
                    }

                    System.out.println("更改卡片内容，正面：" + card.getFrontString() + "， 背面：" + card.getBackString());
                }
            });
            confirm.setVisible(true);
        }
        mainPanel.add(confirm);
        add(mainPanel);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                update();
            }
        });
    }

    /**
     * 各种组件
     */
    private JPanel mainPanel;
    private JLabel frontLabel;
    private JTextArea frontTextArea;
    private JLabel backLabel;
    private JTextArea backTextArea;
    private JButton confirm;
}
