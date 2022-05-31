package com.MemWink.UI.panel;

import com.MemWink.Data.CardBag.CategorizedCard;
import com.MemWink.util.constant.MemStateConstants;
import com.MemWink.util.MemWinkUtil;
import com.MemWink.UI.component.RoundedRectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class ReviewPanel extends CardContent implements ActionListener {
    private Timer timer = new Timer(2000, this);
    private Date endTime = new Date();
    private ReviewManager reviewManager;
    public ReviewPanel(CategorizedCard card, ReviewManager reviewManager) {
        super(card);
        this.reviewManager = reviewManager;
        this.setFocusable(true);
        this.addKeyListener(this);
        setup();
    }
    private void setup() {
        isShowBack = false;
        isReview = true;
        // timePanel
        {
            timePanel = new RoundedRectangle(110, 60, 10, Color.WHITE);
            timePanel.setLocation(0, (frontPanel.getHeight() >> 2) - 30);
            // timeLabel
            {
                timeLabel = new JLabel((endTime.getTime() - new Date().getTime()) / 1000 + "");
                timeLabel.setForeground(Color.BLACK);
                timeLabel.setSize(90, 50);
                timeLabel.setLocation(0, 5);
                timeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                timeLabel.setVisible(card.getMemState() < 0 || card.getMemState() >= MemStateConstants.stage_two);
            }
            timePanel.add(timeLabel);

            // secondLabel
            {
                JLabel secondLabel = new JLabel("秒");
                secondLabel.setSize(20, 20);
                secondLabel.setLocation(90, 40);
                secondLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
                timePanel.add(secondLabel);
            }

            timePanel.setVisible(card.getMemState() < 0 || card.getMemState() > MemStateConstants.stage_one);
        }
        leftPanel.add(timePanel);

        // rememberedButton
        {
            rememberedButton = new JButton("记住了");
            rememberedButton.setHorizontalTextPosition(SwingConstants.RIGHT);
            rememberedButton.setVerticalTextPosition(SwingConstants.CENTER);
            rememberedButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
            rememberedButton.setIcon(MemWinkUtil.getScaledIcon("绿勾", 12, 12));
            // rememberedButton.setBackground(Color.GREEN);
            // rememberedButton.setForeground(Color.WHITE);
            rememberedButton.setSize(100, 45);
            rememberedButton.setLocation(
                    frontPanel.getWidth() - 100, frontPanel.getHeight() + 5);
            rememberedButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    card.remembered();
                    reviewManager.remembered();
                }
            });
        }
        middlePanel.add(rememberedButton);

        // forgotButton
        {
            forgotButton= new JButton("没记住");
            forgotButton.setVerticalTextPosition(SwingConstants.CENTER);
            forgotButton.setHorizontalTextPosition(SwingConstants.RIGHT);
            forgotButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
            forgotButton.setIcon(MemWinkUtil.getScaledIcon("红叉", 6, 6));
            forgotButton.setIconTextGap(5);
            forgotButton.setSize(100, 45);
            forgotButton.setLocation(
                    backPanel.getX(), middlePanel.getHeight() - 50);
            forgotButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    card.forget();
                    reviewManager.forget();
                }
            });
        }
        middlePanel.add(forgotButton);
        // frontPanel.setSize(frontPanel.getWidth(), (int) Math.round(frontPanel.getHeight() * 0.9));
        // frontPanel.setSize(backPanel.getWidth(), (int) Math.round(backPanel.getHeight()));
        setVisible(true);
        update();
    }

    @Override
    public void update() {
        super.update();
        forgotButton.setLocation(
                backPanel.getX(), rightPanel.getHeight() - 55);
        rememberedButton.setLocation(
                frontPanel.getX() + frontPanel.getWidth() - 100, rightPanel.getHeight() - 55);
        isShowBack = isTimeUp() || isShowBack;
        if (isShowBack) {
            timePanel.setVisible(false);
            hidedBackPanel.setVisible(false);
            backPanel.setVisible(true);
            rememberedButton.setText(getRememberedButtonText());
            forgotButton.setText("+1分钟");
            categoryButton.setEnabled(true);
            stageButton.setEnabled(true);
            historyButton.setEnabled(true);
            settingButton.setEnabled(true);
            editButton.setEnabled(true);
            backButton.setEnabled(true);
            timer.stop();
        } else {
            timeLabel.setText((endTime.getTime() - new Date().getTime()) / 1000 + "");
            timePanel.setVisible(card.getMemState() < 0 || card.getMemState() > MemStateConstants.stage_one);
            categoryButton.setEnabled(false);
            stageButton.setEnabled(false);
            historyButton.setEnabled(false);
            settingButton.setEnabled(false);
            editButton.setEnabled(false);
            backButton.setEnabled(false);
        }
    }

    public boolean isTimeUp() {
        if (card.getMemState() >= 0 && card.getMemState() < MemStateConstants.stage_two) {
            return false;
        } else {
            return new Date().after(endTime);
        }
    }
    public String getRememberedButtonText() {
        String tmp;
        try {
            CategorizedCard tmpCard = card.cloneItem();
            tmpCard.remembered();
            tmp = MemStateConstants.getRememberTimeLabel(tmpCard.getMemState());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        if (card.getMemState() != MemStateConstants.stage_five) {
            return "+" + tmp.split("后记忆")[0];
        } else {
            return "已记住";
        }
    }

    JButton rememberedButton;
    JButton forgotButton;
    JPanel timePanel;
    JLabel timeLabel;


    @Override
    public void actionPerformed(ActionEvent e) {
        // update();
        if (card.getMemState() == MemStateConstants.stage_two) {
            endTime.setTime(new Date().getTime() + 20000);
        } else if (card.getMemState() == MemStateConstants.stage_three) {
            endTime.setTime(new Date().getTime() + 15000);
        } else if (card.getMemState() < 0 || card.getMemState() == MemStateConstants.stage_four) {
            endTime.setTime(new Date().getTime() + 10000);
        } else if (card.getMemState() == MemStateConstants.stage_five) {
            endTime.setTime(new Date().getTime() + 5000);
        }
        timer.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            isShowBack = true;
        } else if (code == KeyEvent.VK_LEFT) {
            card.remembered();
            reviewManager.remembered();
        } else if (code == KeyEvent.VK_RIGHT) {
            card.forget();
            reviewManager.forget();
        }
        update();
    }
}
