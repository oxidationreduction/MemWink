package com.MemWink.UI.panel;

import com.MemWink.Data.CardBag.CategorizedCard;
import com.MemWink.util.constant.MemStateConstants;
import com.MemWink.util.MemWinkUtil;
import com.MemWink.UI.component.RoundedRectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

/**
 * 复习页面
 * <p>用于复习时使用</p>
 * @author Liu Hongyu
 * @since 2022-05-31
 */
public class ReviewPanel extends CardContent implements ActionListener {
    /**
     * 倒计时面板
     */
    private RoundedRectangle timePanel;

    /**
     * 倒计时时间
     */
    private JLabel timeLabel;

    /**
     * 倒计时面板更新线程
     */
    protected Thread countdown;

    /**
     * 所属的复习管理器
     */
    private ReviewManager reviewManager;

    /**
     * 构造器
     * @param card 正在复习的卡片
     * @param remain 剩余的卡片数量
     * @param reviewManager 所属的复习管理器
     */
    public ReviewPanel(CategorizedCard card, int remain, ReviewManager reviewManager) {
        super(card);
        this.reviewManager = reviewManager;
        this.setFocusable(true);
        this.addKeyListener(this);
        this.remainLabel = new JLabel(remain + "");
        setup();
        update();
        countdown = new Thread() {
            @Override
            public void run() {
                updateTimeLabel();
            }
        };
        countdown.start();
    }

    /**
     * 更新倒计时面板
     */
    private void updateTimeLabel() {
        int time;
        if (card.getMemState() < 0 || card.getMemState() >= MemStateConstants.stage_four) {
            time = 4;
        } else if (card.getMemState() == MemStateConstants.stage_three) {
            time = 6;
        } else if (card.getMemState() == MemStateConstants.stage_two) {
            time = 8;
        } else if (card.getMemState() == MemStateConstants.stage_one) {
            time = 10;
        } else {
            return;
        }
        timeLabel.setText(time + "");
        while (time > -1) {
            try {
                Thread.sleep(999);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            timeLabel.setText(time + "");
            timePanel.updateUI();
            updateUI();
            time--;
        }
        showBackContent();
        updateUI();
    }

    /**
     * 初始化界面
     */
    private void setup() {
        isShowBack = false;
        isReview = true;

        // timePanel
        {
            timePanel = new RoundedRectangle(110, 60, 10, Color.WHITE);
            timePanel.setLocation(0, (frontPanel.getHeight() >> 2) - 30);
            timePanel.setLayout(null);
            // timeLabel
            {
                timeLabel = new JLabel();
                timeLabel.setForeground(Color.BLACK);
                timeLabel.setSize(80, 50);
                timeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 50));
                timeLabel.setLocation(0, 5);
                timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
                timeLabel.setVisible(card.getMemState() < 0 || card.getMemState() >= MemStateConstants.stage_two);
            }
            timePanel.add(timeLabel);

            // secondLabel
            {
                JLabel secondLabel = new JLabel("秒");
                secondLabel.setSize(20, 20);
                secondLabel.setLocation(80, 35);
                secondLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
                timePanel.add(secondLabel);
            }

            timePanel.setVisible(card.getMemState() != MemStateConstants.newCard);
        }
        leftPanel.add(timePanel);

        // rememberedButton
        {
            rememberedButton = new JButton("记住了");
            rememberedButton.setHorizontalTextPosition(SwingConstants.RIGHT);
            rememberedButton.setVerticalTextPosition(SwingConstants.CENTER);
            rememberedButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
            rememberedButton.setIcon(MemWinkUtil.getScaledIcon("绿勾", 20, 20));
            // rememberedButton.setBackground(Color.GREEN);
            // rememberedButton.setForeground(Color.WHITE);
            rememberedButton.setSize(100, 45);
            rememberedButton.setLocation(
                    frontPanel.getWidth() - 100, frontPanel.getHeight() + 5);
            rememberedButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Remember before: " + card.getFrontString() + " " + card.getMemState());
                    card.remembered();
                    reviewManager.remembered();
                    System.out.println("Remember after: " + card.getFrontString() + " " + card.getMemState());
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
            forgotButton.setIcon(MemWinkUtil.getScaledIcon("红叉", 20, 20));
            forgotButton.setIconTextGap(5);
            forgotButton.setSize(100, 45);
            forgotButton.setLocation(
                    backPanel.getX(), middlePanel.getHeight() - 50);
            forgotButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Forget before: " + card.getFrontString() + " " + card.getMemState());
                    card.forget();
                    reviewManager.forget();
                    System.out.println("Forget after: " + card.getFrontString() + " " + card.getMemState());
                }
            });
        }
        middlePanel.add(forgotButton);

        // remainLabel
        {
            remainLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
            remainLabel.setBackground(Color.BLUE);
            remainLabel.setSize(40, 30);
            remainLabel.setLocation((middlePanel.getWidth()) >> 1, 15);
        }
        middlePanel.add(remainLabel);
        // frontPanel.setSize(frontPanel.getWidth(), (int) Math.round(frontPanel.getHeight() * 0.9));
        // frontPanel.setSize(backPanel.getWidth(), (int) Math.round(backPanel.getHeight()));
        setVisible(true);
        update();
    }

    /**
     * 页面更新
     */
    @Override
    public void update() {
        super.update();
        forgotButton.setLocation(
                backPanel.getX(), middlePanel.getHeight() - 55);
        rememberedButton.setLocation(
                frontPanel.getX() + frontPanel.getWidth() - 100, middlePanel.getHeight() - 55);
        frontPanel.setSize(
                (int) Math.round(middlePanel.getWidth() * 0.45),
                middlePanel.getHeight() - 75
        );
        backPanel.setSize(
                (int) Math.round(middlePanel.getWidth() * 0.45),
                middlePanel.getHeight() - 75
        );
        hidedBackPanel.setSize(
                (int) Math.round(middlePanel.getWidth() * 0.45),
                middlePanel.getHeight() - 75
        );
        remainLabel.setLocation((middlePanel.getWidth() - remainLabel.getWidth()) >> 1, 15);
        // isShowBack = isTimeUp() || isShowBack;
        if (isShowBack) {
            // timePanel.setVisible(false);
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
        } else {
            // timeLabel.setText((endTime.getTime() - new Date().getTime()) / 1000 + "");
            // timePanel.setVisible(card.getMemState() < 0 || card.getMemState() > MemStateConstants.stage_one);
            categoryButton.setEnabled(false);
            stageButton.setEnabled(false);
            historyButton.setEnabled(false);
            settingButton.setEnabled(false);
            editButton.setEnabled(false);
            backButton.setEnabled(false);
        }
        System.out.println("ReviewPanel Updated.");
    }

    /* public boolean isTimeUp() {
        if (card.getMemState() >= 0 && card.getMemState() < MemStateConstants.stage_two) {
            return false;
        } else {
            return new Date().after(endTime);
        }
    }
    */

    /**
     * 获取应当在"记住了"按钮上显示的文字（下次复习时间）
     * @return 一个字符串，表示如果卡片本次记忆中被记住了，下一次应当记忆的时间
     */
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
    JLabel remainLabel;


    @Override
    public void actionPerformed(ActionEvent e) {
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
