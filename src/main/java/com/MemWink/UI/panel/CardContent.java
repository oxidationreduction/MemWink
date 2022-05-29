package com.MemWink.UI.panel;

import com.MemWink.Data.CardBag.CategorizedCard;
import com.MemWink.Data.CardBag.MemStateConstants;
import com.MemWink.Data.DataManager;
import com.MemWink.UI.UIConstant;
import com.MemWink.UI.component.RoundedRectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CardContent extends JPanel {
    private JPanel leftPanel;
    private static JPanel middlePanel;
    private JPanel rightPanel;
    private JButton categoryButton;
    private JButton stageButton;
    private JButton historyButton;

    private RoundedRectangle frontPanel;
    private JLabel frontContentLabel;
    private int frontHorizenalAlignment = SwingConstants.CENTER;
    private int frontVerticalAlignment = SwingConstants.CENTER;
    private int frontFontSize = 50;
    private JLabel backContentLabel;
    private int backHorizenalAlignment = SwingConstants.CENTER;
    private int backVerticalAlignment = SwingConstants.CENTER;
    private int backFontSize = 50;
    private RoundedRectangle backPanel;

    private RoundedRectangle hidedBackPanel;
    private JLabel hidedBackLabel = new JLabel("<html><body>点击此处<br>或按[↑]键<br>查看背面<body></html>", JLabel.CENTER);

    private JButton settingButton;
    private JButton editButton;
    private JButton backButton;

    private CategorizedCard card;

    public CardContent(CategorizedCard card) {
        this.card = card;
        setupUI();
    }
    public void setCard(CategorizedCard card) {
        this.card = card;
        updateUI();
    }

    public void update() {
        setSize(new Dimension(UIConstant.windowWidth - 95, UIConstant.windowHeight - 100));
        leftPanel.setSize(110, UIConstant.windowHeight - 100);
        middlePanel.setSize(
                new Dimension(
                        this.getWidth() - 210,
                        this.getHeight()
                )
        );
        frontPanel.setSize(
                (int) Math.round(middlePanel.getWidth() * 0.45),
                middlePanel.getHeight() - 30
        );
        frontPanel.setLocation(
                (int) Math.round(middlePanel.getWidth() * 0.02), 15
        );
        backPanel.setSize(
                (int) Math.round(middlePanel.getWidth() * 0.45),
                middlePanel.getHeight() - 30
        );
        backPanel.setLocation(
                (int) Math.round(middlePanel.getWidth() * 0.53), 15
        );
        hidedBackPanel.setSize(
                (int) Math.round(middlePanel.getWidth() * 0.45),
                middlePanel.getHeight() - 30
        );
        hidedBackPanel.setLocation(
                (int) Math.round(middlePanel.getWidth() * 0.53), 15
        );
        rightPanel.setSize(110, UIConstant.windowHeight - 100);
        rightPanel.setLocation(this.getWidth()-110, 0);

        backButton.setLocation(5, rightPanel.getHeight()-55);
    }

    public void setupUI() {
        setSize(new Dimension(
                UIConstant.windowWidth - 95,
                UIConstant.windowHeight - 180)
        );
        setLayout(null);

        // leftPanel
        {
            leftPanel = new JPanel();
            leftPanel.setSize(110, UIConstant.windowHeight - 180);
            leftPanel.setFocusable(false);
            leftPanel.setLayout(null);

            // categoryButton
            {
                categoryButton = new JButton(card.getCategory());
                categoryButton.setSize(100, 45);
                categoryButton.setLocation(5, 5);
                categoryButton.setFocusable(false);

                JPopupMenu categoryMenu = new JPopupMenu();
                int menuHeight = 35;
                for (String i : new String[]{"A", "B", "C"}) {
                    JMenuItem item = new JMenuItem(i);
                    item.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("更新卡片分类为：" + item.getText());
                            card.updateCategory(item.getText());
                        }
                    });
                    item.setSize(100, 35);
                    categoryMenu.add(item);
                    menuHeight += 35;
                }
                JMenuItem item = new JMenuItem("新分类…");
                item.setSize(110, 35);
                item.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("添加新分类，应打开添加分类面板");
                    }
                });
                categoryMenu.add(item);
                categoryMenu.setPopupSize(110, menuHeight);
                categoryButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("显示卡片分类面板");
                        categoryMenu.show(categoryButton, 110, 5);
                    }
                });
            }

            // stageButton
            {
                stageButton = new JButton(
                        MemStateConstants.getStageLabel(card.getMemState()));
                stageButton.setSize(100, 45);
                stageButton.setLocation(5, 60);
                stageButton.setFocusable(false);

                JPopupMenu stageMenu = new JPopupMenu();
                int height = 0;
                for (Integer i : MemStateConstants.values) {
                    if (i == MemStateConstants.reinforce2)
                        continue;
                    JMenuItem tmp = new JMenuItem(
                            MemStateConstants.getStageLabel(i));
                    JLabel timeLabel = new JLabel(
                            MemStateConstants.getRememberTimeLabel(i));
                    timeLabel.setFont(
                            new Font("微软雅黑", Font.PLAIN, 15));
                    timeLabel.setForeground(Color.GRAY);
                    timeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                    timeLabel.setBounds(50, 0, 155, 35);
                    tmp.add(timeLabel);
                    tmp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.print("改变卡片记忆阶段至：" + tmp.getText());

                            System.out.println("，值为：" + MemStateConstants.getStageVal(tmp.getText()));
                            card.changeMemState(MemStateConstants.getStageVal(tmp.getText()));
                            stageButton.setText(tmp.getText());
                        }
                    });
                    stageMenu.add(tmp);
                    tmp.setLayout(null);
                    tmp.setSize(220, 35);
                    height += 35;
                }
                stageMenu.setPopupSize(220, height);
                stageButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("显示记忆阶段面板");
                        stageMenu.show(stageButton, 110, 55);
                    }
                });
            }

            // historyButton
            {
                historyButton = new JButton("记忆历史");
                historyButton.setSize(100, 45);
                historyButton.setLocation(5, 115);
                historyButton.setFocusable(false);
            }

            leftPanel.add(categoryButton);
            leftPanel.add(stageButton);
            leftPanel.add(historyButton);
            leftPanel.setLocation(0, 0);
            leftPanel.setVisible(true);
        }

        // middlePanel
        {
            middlePanel = new JPanel();
            middlePanel.setLayout(null);
            middlePanel.setSize(
                this.getWidth() - 240,
                this.getHeight()
            );
            middlePanel.setFocusable(false);

            // frontPanel
            {
                frontPanel = new RoundedRectangle(
                        (int) Math.round(middlePanel.getWidth() * 0.45),
                        middlePanel.getHeight() - 30,
                        middlePanel.getHeight() * 0.05,
                        card.getCardBagColor()
                );
                frontPanel.setFocusable(false);
                frontPanel.setLayout(new BorderLayout());
                frontPanel.setLocation(
                        (int) Math.round(middlePanel.getWidth() * 0.02), 15
                );
                frontContentLabel = new JLabel(card.getFront());
                frontContentLabel.setSize(
                        (int) Math.round(frontPanel.getWidth() * 0.9),
                        (int) Math.round(frontPanel.getHeight() * 0.9)
                );
                frontContentLabel.setHorizontalAlignment(frontHorizenalAlignment);
                frontContentLabel.setFont(
                        new Font("Microsoft Sans Serif", Font.PLAIN, frontFontSize));
                frontContentLabel.setForeground(Color.WHITE);
                frontPanel.add(frontContentLabel, frontVerticalAlignment);
                frontPanel.setVisible(true);
                System.out.println("Front: " + frontPanel.getWidth() + " * " + frontPanel.getHeight());
            }

            // backPanel
            {
                backPanel = new RoundedRectangle(
                        (int) Math.round(middlePanel.getWidth() * 0.45),
                        middlePanel.getHeight() - 30,
                        middlePanel.getHeight() * 0.05,
                        card.getCardBagColor()
                );
                backPanel.setLayout(new BorderLayout());
                backPanel.setLocation(
                        (int) Math.round(middlePanel.getWidth() * 0.53), 15
                );
                backContentLabel = new JLabel(card.getBack());
                backContentLabel.setSize(
                        (int) Math.round(frontPanel.getWidth() * 0.9),
                        (int) Math.round(frontPanel.getHeight() * 0.9)
                );
                backContentLabel.setForeground(Color.WHITE);
                backContentLabel.setHorizontalAlignment(backHorizenalAlignment);
                backContentLabel.setFont(
                        new Font("Microsoft Sans Serif", Font.PLAIN, backFontSize));
                backPanel.add(backContentLabel, backVerticalAlignment);
                backPanel.setVisible(false);
                backPanel.setFocusable(false);
            }

            // hidedBackPanel
            {
                hidedBackPanel = new RoundedRectangle(
                        (int) Math.round(middlePanel.getWidth() * 0.45),
                        middlePanel.getHeight() - 30,
                        middlePanel.getHeight() * 0.05,
                        Color.WHITE
                );

                hidedBackPanel.setLayout(new BorderLayout());
                hidedBackPanel.setLocation(
                        (int) Math.round(middlePanel.getWidth() * 0.53), 15
                );
                hidedBackLabel.setSize(
                        (int) Math.round(frontPanel.getWidth() * 0.9),
                        (int) Math.round(frontPanel.getHeight() * 0.9)
                );
                hidedBackLabel.setForeground(Color.GRAY);
                hidedBackLabel.setHorizontalAlignment(SwingConstants.CENTER);
                hidedBackLabel.setVerticalAlignment(SwingConstants.CENTER);
                hidedBackLabel.setFont(
                        new Font("Microsoft Sans Serif", Font.PLAIN, 60));
                hidedBackLabel.setVisible(true);
                hidedBackPanel.add(hidedBackLabel, BorderLayout.CENTER);
                hidedBackPanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        hidedBackPanel.setVisible(false);
                        backPanel.setVisible(true);
                        repaint();
                        System.out.println("mouseClicked");
                        hidedBackPanel.setFocusable(false);
                        CardContent.this.requestFocus();
                    }
                });
                hidedBackPanel.setFocusable(false);
                hidedBackPanel.setVisible(true);
            }

            middlePanel.add(frontPanel);
            middlePanel.add(backPanel);
            middlePanel.add(hidedBackPanel);
            middlePanel.setLocation(100, 0);
            middlePanel.setVisible(true);
        }

        // rightPanel
        {
            rightPanel = new JPanel();
            rightPanel.setSize(110, UIConstant.windowHeight - 180);
            rightPanel.setLayout(null);
            rightPanel.setFocusable(false);

            // settingButton
            {
                settingButton = new JButton();
                ImageIcon tmpIcon = new ImageIcon("image/设置.png");
                Image tmpImage = tmpIcon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
                tmpIcon = new ImageIcon(tmpImage);
                settingButton.setIcon(tmpIcon);
                settingButton.setSize(45, 45);
                settingButton.setLocation(60, 5);
                settingButton.setFocusable(false);
            }

            // editButton
            {
                ImageIcon tmpIcon = new ImageIcon("image/修改.png");
                Image tmpImage = tmpIcon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
                tmpIcon = new ImageIcon(tmpImage);
                editButton = new JButton();
                editButton.setIcon(tmpIcon);
                editButton.setSize(45, 45);
                editButton.setLocation(60, 60);
                editButton.setFocusable(false);
            }

            // backButton
            {
                backButton = new JButton("返回");
                backButton.setSize(100, 45);
                backButton.setLocation(5, rightPanel.getHeight()-50);
                backButton.setFocusable(false);
            }

            rightPanel.add(settingButton);
            rightPanel.add(editButton);
            rightPanel.add(backButton);
            rightPanel.setLocation(this.getWidth()-110, 0);
        }

        this.add(leftPanel);
        this.add(middlePanel);
        this.add(rightPanel);
        this.setVisible(true);
        System.out.println("Line 281: " + middlePanel.getWidth() + " * " + middlePanel.getHeight());
    }

    public KeyAdapter getKeyAdapter() {
        return new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    CardContent.this.hidedBackPanel.setVisible(false);
                    CardContent.this.backPanel.setVisible(true);
                    System.out.println("Show back.");
                    CardContent.this.updateUI();
                }
            }
        };
    }

    public static void main(String[] args) {
        DataManager.init();
        DataManager.addCardBag("A", Color.gray, 20);
        DataManager.provideCardBag("A").addCard("Front", "Back", true, MemStateConstants.newCard, false, null);
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(1280, 720);
        CardContent tmp = new CardContent(
                DataManager
                        .provideCardBag("A")
                        .getCards()
                        .get(0));
        tmp.setLocation(50, 25);
        frame.add(tmp);
        System.out.println(UIConstant.windowWidth + " * " + UIConstant.windowHeight + ", "
                + tmp.getWidth() + " * " + tmp.getHeight());

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                UIConstant.windowWidth = frame.getWidth();
                UIConstant.windowHeight = frame.getHeight();
                tmp.update();

                System.out.println(
                        UIConstant.windowWidth + " * " + UIConstant.windowHeight + ", "
                        + tmp.getWidth() + " * " + tmp.getHeight() + ", "
                        + middlePanel.getWidth() + " * " + middlePanel.getHeight());
            }
        });
        frame.addKeyListener(tmp.getKeyAdapter());
        tmp.requestFocus();
        frame.setVisible(true);
    }
}
