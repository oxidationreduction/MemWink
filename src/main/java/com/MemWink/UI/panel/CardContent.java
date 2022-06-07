package com.MemWink.UI.panel;

import com.MemWink.Data.CardBag.*;
import com.MemWink.Data.DataManager;
import com.MemWink.UI.dialog.*;
import com.MemWink.util.constant.MemStateConstants;
import com.MemWink.util.MemWinkUtil;
import com.MemWink.util.constant.UIConstant;
import com.MemWink.UI.component.RoundedRectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Set;

public class CardContent extends JPanel implements KeyListener {
    protected CardBag cardBag;
    protected CategorizedCard card;

    public CardContent(CategorizedCard card) {
        this.card = card;
        this.cardBag = DataManager.provideCardBag(card.getCardBagName());
        this.setFocusable(true);
        this.addKeyListener(this);
        setupUI();
        if (!(this instanceof ReviewPanel)) {
            update();
        }
    }

    public void update() {
        setSize(new Dimension(UIConstant.mainPanelWidth, UIConstant.mainPanelHeight));
        setLocation(0, 0);
        leftPanel.setSize(110, UIConstant.mainPanelHeight - 100);
        middlePanel.setSize(
                new Dimension(
                        this.getWidth() - 210,
                        this.getHeight()
                )
        );

        frontPanel.setLocation(
                (int) Math.round(middlePanel.getWidth() * 0.02), 15
        );
        backPanel.setLocation(
                (int) Math.round(middlePanel.getWidth() * 0.53), 15
        );
        hidedBackPanel.setLocation(
                (int) Math.round(middlePanel.getWidth() * 0.53), 15
        );

        frontContentLabelsPanel.update();
        backContentLabelsPanel.update();
        if (isEditLayout || isReview) {
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
            if (isEditLayout)
                backButton.setText("保存布局");
        } else {
            frontPanel.setSize(
                    (int) Math.round(middlePanel.getWidth() * 0.45),
                    middlePanel.getHeight() - 30
            );
            backPanel.setSize(
                    (int) Math.round(middlePanel.getWidth() * 0.45),
                    middlePanel.getHeight() - 30
            );
            hidedBackPanel.setSize(
                    (int) Math.round(middlePanel.getWidth() * 0.45),
                    middlePanel.getHeight() - 30
            );
            backButton.setText("返回");
        }

        frontHorizenalLeft.setLocation(
                (frontPanel.getWidth() >> 1) - 50,
                middlePanel.getHeight() - 50
        );
        frontHorizenalCenter.setLocation(
                (frontPanel.getWidth() >> 1) - 8,
                middlePanel.getHeight() - 50
        );
        frontHorizenalRight.setLocation(
                (frontPanel.getWidth() >> 1) + 34,
                middlePanel.getHeight() - 50
        );
        backHorizenalLeft.setLocation(
                middlePanel.getWidth() - (backPanel.getWidth() >> 1) - 70,
                middlePanel.getHeight() - 50
        );
        backHorizenalCenter.setLocation(
                middlePanel.getWidth() - (backPanel.getWidth() >> 1) - 28,
                middlePanel.getHeight() - 50
        );
        backHorizenalRight.setLocation(
                middlePanel.getWidth() - (backPanel.getWidth() >> 1) + 14,
                middlePanel.getHeight() - 50
        );

        System.out.println(frontHorizenalLeft.getLocation());
        System.out.println(frontHorizenalRight.getLocation());

        rightPanel.setSize(110, UIConstant.mainPanelHeight - 100);
        rightPanel.setLocation(this.getWidth()-110, 0);

        backButton.setLocation(5, rightPanel.getHeight()-55);
        if (cardBag.getUiSetting().showBack) {
            showBack.setText("默认隐藏背面");
        } else {
            showBack.setText("直接显示背面");
        }
        frontContentLabelsPanel.updateParentSize(frontPanel.getSize());
        frontContentLabelsPanel.updateContent(card.getFrontList());
        backContentLabelsPanel.updateParentSize(backPanel.getSize());
        backContentLabelsPanel.updateContent(card.getBackList());
        super.updateUI();

        System.out.println("CardContent Updated.");
    }

    public void categoryMenuUpdate() {
        categoryButton.setText(card.getCategory());
        categoryMenu = new JPopupMenu();
        int menuHeight = 105;
        Set<String> categories = cardBag.getCategories();
        for (String i : categories) {
            JMenuItem item;
            if (i != null) {
                item = new JMenuItem(i);
            } else {
                continue;
            }

            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    card.updateCategory(item.getText());
                    categoryButton.setText(item.getText());
                }
            });
            item.setSize(100, 35);
            categoryMenu.add(item);
            menuHeight += 35;
        }

        // 未分类
        {
            JMenuItem item = new JMenuItem("未分类");
            item.setSize(110, 35);
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    card.updateCategory(null);
                    categoryButton.setText("未分类");
                }
            });
            categoryMenu.add(item);
        }

        // 添加新分类
        {
            JMenuItem item = new JMenuItem("新分类…");
            item.setSize(110, 35);
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("添加新分类，应打开添加分类面板");
                    new AddCategoryDialog(card, CardContent.this);
                }
            });
            categoryMenu.add(item);
        }

        // 删除分类
        {
            JMenuItem item = new JMenuItem("删除分类");
            item.setSize(110, 35);
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("删除分类，应打开删除分类面板");
                    new DeleteCategoryDialog(cardBag, CardContent.this);
                }
            });
            categoryMenu.add(item);
        }

        categoryMenu.setPopupSize(110, menuHeight);
        categoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                categoryMenu.show(categoryButton, 110, 5);
            }
        });
    }

    public void setupUI() {
        isShowBack = cardBag.getUiSetting().showBack && !isReview;
        setSize(new Dimension(
                UIConstant.mainPanelWidth - 95,
                UIConstant.mainPanelHeight - 180)
        );
        setLayout(null);

        // leftPanel
        {
            leftPanel = new JPanel();
            leftPanel.setSize(110, UIConstant.mainPanelHeight - 180);
            leftPanel.setFocusable(false);
            leftPanel.setLayout(null);

            // categoryButton
            {
                categoryButton = new JButton(card.getCategory());
                categoryButton.setSize(100, 45);
                categoryButton.setLocation(5, 5);
                categoryButton.setFocusable(false);

                categoryMenu = new JPopupMenu();
                int menuHeight = 105;
                Set<String> categories = cardBag.getCategories();
                for (String i : categories) {
                    JMenuItem item;
                    if (i != null) {
                        item = new JMenuItem(i);
                    } else {
                        continue;
                    }

                    item.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            card.updateCategory(item.getText());
                        }
                    });
                    item.setSize(100, 35);
                    categoryMenu.add(item);
                    menuHeight += 35;
                }

                // 未分类
                {
                    JMenuItem item = new JMenuItem("未分类");
                    item.setSize(110, 35);
                    item.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            card.updateCategory(null);
                        }
                    });
                    categoryMenu.add(item);
                }

                // 添加新分类
                {
                    JMenuItem item = new JMenuItem("新分类…");
                    item.setSize(110, 35);
                    item.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("添加新分类，应打开添加分类面板");
                            new AddCategoryDialog(card, CardContent.this);
                        }
                    });
                    categoryMenu.add(item);
                }

                // 删除分类
                {
                    JMenuItem item = new JMenuItem("删除分类");
                    item.setSize(110, 35);
                    item.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("删除分类，应打开删除分类面板");
                            new DeleteCategoryDialog(cardBag, CardContent.this);
                        }
                    });
                    categoryMenu.add(item);
                }

                categoryMenu.setPopupSize(110, menuHeight);
                categoryButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
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
                        stageMenu.show(stageButton, 110, 5);
                    }
                });
            }

            // historyButton
            {
                historyButton = new JButton("记忆历史");
                historyButton.setSize(100, 45);
                historyButton.setLocation(5, 115);
                historyButton.setFocusable(false);
                historyButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new HistoryDialog(card)
                                .setLocationRelativeTo(CardContent.this);
                    }
                });
            }

            // frontVerticalAlignmentButtons
            {
                {
                    frontVerticalTop = new JButton();
                    frontVerticalTop.setIcon(MemWinkUtil.getScaledIcon("设置", 30, 30));
                    frontVerticalTop.setSize(35, 35);
                    frontVerticalTop.setLocation(
                            (leftPanel.getWidth() >> 1) - 15,
                            (leftPanel.getHeight() >> 1) - 40
                    );

                    frontVerticalTop.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            UISetting tmp = cardBag.getUiSetting();
                            tmp.frontVerticalAlignment = BorderLayout.NORTH;
                            cardBag.updateUISetting(tmp);
                            frontContentLabelsPanel.updateVerticalAlignment(BorderLayout.NORTH);
                            update();
                        }
                    });
                    frontVerticalTop.setVisible(false);
                }

                {
                    frontVerticalCenter = new JButton();
                    frontVerticalCenter.setIcon(MemWinkUtil.getScaledIcon("设置", 30, 30));
                    frontVerticalCenter.setSize(35, 35);
                    frontVerticalCenter.setLocation(
                            (leftPanel.getWidth() >> 1) - 15,
                            (leftPanel.getHeight() >> 1)
                    );

                    frontVerticalCenter.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            UISetting tmp = cardBag.getUiSetting();
                            tmp.frontVerticalAlignment = BorderLayout.CENTER;
                            cardBag.updateUISetting(tmp);
                            frontContentLabelsPanel.updateVerticalAlignment(BorderLayout.CENTER);
                            update();
                        }
                    });
                    frontVerticalCenter.setVisible(false);
                }

                {
                    frontVerticalBottom = new JButton();
                    frontVerticalBottom.setIcon(MemWinkUtil.getScaledIcon("设置", 30, 30));
                    frontVerticalBottom.setSize(35, 35);
                    frontVerticalBottom.setLocation(
                            (leftPanel.getWidth() >> 1) - 15,
                            (leftPanel.getHeight() >> 1) + 40
                    );

                    frontVerticalBottom.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            UISetting tmp = cardBag.getUiSetting();
                            tmp.frontVerticalAlignment = BorderLayout.SOUTH;
                            cardBag.updateUISetting(tmp);
                            frontContentLabelsPanel.updateVerticalAlignment(BorderLayout.SOUTH);
                            update();
                        }
                    });
                    frontVerticalBottom.setVisible(false);
                }
            }

            // frontFontSizeButtons
            {
                {
                    frontFontSizeAddButton = new JButton();
                    frontFontSizeAddButton.setIcon(MemWinkUtil.getScaledIcon("设置", 30, 30));
                    frontFontSizeAddButton.setSize(35, 35);
                    frontFontSizeAddButton.setLocation(
                            (leftPanel.getWidth() >> 1) - 15,
                            (leftPanel.getHeight() >> 1) + 100
                    );

                    frontFontSizeAddButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            UISetting tmp = cardBag.getUiSetting();
                            tmp.frontFontSize += 5;
                            cardBag.updateUISetting(tmp);
                            frontContentLabelsPanel.updateFontSize(tmp.frontFontSize);
                            update();
                        }
                    });
                    frontFontSizeAddButton.setVisible(false);
                }

                {
                    frontFontSizeMinusButton = new JButton();
                    frontFontSizeMinusButton.setIcon(MemWinkUtil.getScaledIcon("设置", 30, 30));
                    frontFontSizeMinusButton.setSize(35, 35);
                    frontFontSizeMinusButton.setLocation(
                            (leftPanel.getWidth() >> 1) - 15,
                            (leftPanel.getHeight() >> 1) + 140
                    );

                    frontFontSizeMinusButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            UISetting tmp = cardBag.getUiSetting();
                            tmp.frontFontSize -= 5;
                            cardBag.updateUISetting(tmp);
                            frontContentLabelsPanel.updateFontSize(tmp.frontFontSize);
                            update();
                        }
                    });
                    frontFontSizeMinusButton.setVisible(false);
                }
            }

            leftPanel.add(categoryButton);
            leftPanel.add(stageButton);
            leftPanel.add(historyButton);
            leftPanel.add(frontVerticalTop);
            leftPanel.add(frontVerticalCenter);
            leftPanel.add(frontVerticalBottom);
            leftPanel.add(frontFontSizeAddButton);
            leftPanel.add(frontFontSizeMinusButton);

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
                frontPanel.setLayout(null);
                frontPanel.setLocation(
                        (int) Math.round(middlePanel.getWidth() * 0.2), 15
                );

                // frontContentLabelsPanel
                {
                    frontContentLabelsPanel = new CardContentLabelsPanel(
                            card.getFrontList(),
                            (int) Math.round(frontPanel.getWidth() * 0.9),
                            cardBag.getUiSetting().frontHorizenalAlignment,
                            cardBag.getUiSetting().frontVerticalAlignment,
                            frontPanel.getSize(),
                            cardBag.getUiSetting().frontFontSize
                    );
                    frontContentLabelsPanel.updateVerticalAlignment(cardBag.getUiSetting().frontVerticalAlignment);
                }
                frontPanel.add(frontContentLabelsPanel);
            }

            // frontHorizontalAlignmentButton
            {
                {
                    frontHorizenalLeft = new JButton();
                    frontHorizenalLeft.setIcon(MemWinkUtil.getScaledIcon("设置", 30, 30));
                    frontHorizenalLeft.setSize(35, 35);
                    frontHorizenalLeft.setLocation(
                            (frontPanel.getWidth() >> 1) - 50,
                            middlePanel.getHeight() - 50
                    );

                    frontHorizenalLeft.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            UISetting tmp = cardBag.getUiSetting();
                            tmp.frontHorizenalAlignment = SwingConstants.LEADING;
                            frontContentLabelsPanel.updateHorizonalAlignment(SwingConstants.LEADING);
                            cardBag.updateUISetting(tmp);
                            CardContent.this.update();
                        }
                    });
                    frontHorizenalLeft.setVisible(false);
                }

                {
                    frontHorizenalCenter = new JButton();
                    frontHorizenalCenter.setIcon(MemWinkUtil.getScaledIcon("设置", 30, 30));
                    frontHorizenalCenter.setSize(35, 35);
                    frontHorizenalCenter.setLocation(
                            (frontPanel.getWidth() >> 1) - 8,
                            middlePanel.getHeight() - 50
                    );

                    frontHorizenalCenter.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            UISetting tmp = cardBag.getUiSetting();
                            tmp.frontHorizenalAlignment = SwingConstants.CENTER;
                            cardBag.updateUISetting(tmp);
                            frontContentLabelsPanel.updateHorizonalAlignment(SwingConstants.CENTER);
                            CardContent.this.update();
                        }
                    });
                    frontHorizenalCenter.setVisible(false);
                }

                {
                    frontHorizenalRight = new JButton();
                    frontHorizenalRight.setIcon(MemWinkUtil.getScaledIcon("设置", 30, 30));
                    frontHorizenalRight.setSize(35, 35);
                    frontHorizenalRight.setLocation(
                            (frontPanel.getWidth() >> 1) + 34,
                            middlePanel.getHeight() - 50
                    );

                    frontHorizenalRight.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            UISetting tmp = cardBag.getUiSetting();
                            tmp.frontHorizenalAlignment = SwingConstants.RIGHT;
                            cardBag.updateUISetting(tmp);
                            frontContentLabelsPanel.updateHorizonalAlignment(SwingConstants.RIGHT);
                            CardContent.this.update();
                        }
                    });
                    frontHorizenalRight.setVisible(false);
                }
            }
            middlePanel.add(frontHorizenalLeft);
            middlePanel.add(frontHorizenalCenter);
            middlePanel.add(frontHorizenalRight);

            // backPanel
            {
                backPanel = new RoundedRectangle(
                        (int) Math.round(middlePanel.getWidth() * 0.45),
                        middlePanel.getHeight() - 30,
                        middlePanel.getHeight() * 0.05,
                        card.getCardBagColor()
                );
                backPanel.setFocusable(false);
                backPanel.setLayout(null);
                backPanel.setLocation(
                        (int) Math.round(middlePanel.getWidth() * 0.53), 15
                );

                // backContentLabelsPanel
                {
                    backContentLabelsPanel = new CardContentLabelsPanel(
                            card.getBackList(),
                            (int) Math.round(backPanel.getWidth() * 0.9),
                            cardBag.getUiSetting().backHorizenalAlignment,
                            cardBag.getUiSetting().backVerticalAlignment,
                            backPanel.getSize(),
                            cardBag.getUiSetting().backFontSize
                    );
                    backPanel.add(backContentLabelsPanel);
                }
                backPanel.setVisible(cardBag.getUiSetting().showBack);
            }
            // backHorizontalAlignmentButton
            {
                {
                    backHorizenalLeft = new JButton();
                    ImageIcon tmpIcon = new ImageIcon("image/设置.png");
                    Image tmpImage = tmpIcon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
                    tmpIcon = new ImageIcon(tmpImage);
                    backHorizenalLeft.setIcon(tmpIcon);
                    backHorizenalLeft.setSize(35, 35);
                    backHorizenalLeft.setLocation(
                            middlePanel.getWidth() - (backPanel.getWidth() >> 1) - 50,
                            middlePanel.getHeight() - 50
                    );

                    backHorizenalLeft.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            UISetting tmp = cardBag.getUiSetting();
                            tmp.backHorizenalAlignment = SwingConstants.LEADING;
                            cardBag.updateUISetting(tmp);
                            backContentLabelsPanel.updateHorizonalAlignment(SwingConstants.LEADING);
                            update();
                        }
                    });
                    backHorizenalLeft.setVisible(false);
                }

                {
                    backHorizenalCenter = new JButton();
                    ImageIcon tmpIcon = new ImageIcon("image/设置.png");
                    Image tmpImage = tmpIcon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
                    tmpIcon = new ImageIcon(tmpImage);
                    backHorizenalCenter.setIcon(tmpIcon);
                    backHorizenalCenter.setSize(35, 35);
                    backHorizenalCenter.setLocation(
                            middlePanel.getWidth() - (backPanel.getWidth() >> 1) - 8,
                            middlePanel.getHeight() - 50
                    );

                    backHorizenalCenter.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            UISetting tmp = cardBag.getUiSetting();
                            tmp.backHorizenalAlignment = SwingConstants.CENTER;
                            cardBag.updateUISetting(tmp);
                            backContentLabelsPanel.updateHorizonalAlignment(SwingConstants.CENTER);
                            update();
                        }
                    });
                    backHorizenalCenter.setVisible(false);
                }

                {
                    backHorizenalRight = new JButton();
                    ImageIcon tmpIcon = new ImageIcon("image/设置.png");
                    Image tmpImage = tmpIcon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
                    tmpIcon = new ImageIcon(tmpImage);
                    backHorizenalRight.setIcon(tmpIcon);
                    backHorizenalRight.setSize(35, 35);
                    backHorizenalRight.setLocation(
                            middlePanel.getWidth() - (backPanel.getWidth() >> 1) + 34,
                            middlePanel.getHeight() - 50
                    );

                    backHorizenalRight.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            UISetting tmp = cardBag.getUiSetting();
                            tmp.backHorizenalAlignment = SwingConstants.RIGHT;
                            cardBag.updateUISetting(tmp);
                            backContentLabelsPanel.updateHorizonalAlignment(SwingConstants.RIGHT);
                            update();
                        }
                    });
                    backHorizenalRight.setVisible(false);
                }
            }
            middlePanel.add(backHorizenalLeft);
            middlePanel.add(backHorizenalCenter);
            middlePanel.add(backHorizenalRight);

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
                        new Font("微软雅黑", Font.PLAIN, 60));
                hidedBackLabel.setVisible(true);
                hidedBackPanel.add(hidedBackLabel, BorderLayout.CENTER);
                hidedBackPanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        isShowBack = true;
                        hidedBackPanel.setVisible(false);
                        backPanel.setVisible(true);
                        update();
                        hidedBackPanel.setFocusable(false);
                        CardContent.this.requestFocus();
                    }
                });
                hidedBackPanel.setFocusable(false);
                hidedBackPanel.setVisible(!cardBag.getUiSetting().showBack);
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
            rightPanel.setSize(110, UIConstant.mainPanelHeight - 180);
            rightPanel.setLayout(null);
            rightPanel.setFocusable(false);

            // settingButton
            {
                settingButton = new JButton();
                settingButton.setIcon(MemWinkUtil.getScaledIcon("设置", 30, 30));
                settingButton.setSize(45, 45);
                settingButton.setLocation(60, 5);
                settingButton.setFocusable(false);

                // settingMenu: 调整布局、直接显示背面/隐藏背面、复制卡片、移动卡片、删除卡片
                {
                    settingMenu = new JPopupMenu();

                    // 调整布局
                    {
                        JMenuItem layoutSetting = new JMenuItem();
                        layoutSetting.setText("调整布局");
                        layoutSetting.setIcon(MemWinkUtil.getScaledIcon("手动修改", 30, 30));
                        layoutSetting.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                isEditLayout = true;
                                System.out.println("进入布局编辑状态" + isEditLayout);
                                hidedBackPanel.setVisible(false);
                                backPanel.setVisible(true);
                                updateUI();
                                frontHorizenalLeft.setVisible(true);
                                frontHorizenalCenter.setVisible(true);
                                frontHorizenalRight.setVisible(true);
                                frontVerticalTop.setVisible(true);
                                frontVerticalCenter.setVisible(true);
                                frontVerticalBottom.setVisible(true);
                                frontFontSizeAddButton.setVisible(true);
                                frontFontSizeMinusButton.setVisible(true);
                                backHorizenalLeft.setVisible(true);
                                backHorizenalCenter.setVisible(true);
                                backHorizenalRight.setVisible(true);
                                backVerticalTop.setVisible(true);
                                backVerticalCenter.setVisible(true);
                                backVerticalBottom.setVisible(true);
                                backFontSizeAddButton.setVisible(true);
                                backFontSizeMinusButton.setVisible(true);

                                update();
                            }
                        });
                        layoutSetting.setSize(150, 25);
                        settingMenu.add(layoutSetting);
                    }

                    // 直接显示背面/隐藏背面
                    {
                        showBack = new JMenuItem();

                        if (cardBag.getUiSetting().showBack) {
                            showBack.setText("默认隐藏背面");
                            showBack.setIcon(MemWinkUtil.getScaledIcon("手动修改", 30, 30));
                        } else {
                            showBack.setText("直接显示背面");
                            showBack.setIcon(MemWinkUtil.getScaledIcon("手动修改", 30, 30));
                        }


                        showBack.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("设置" + showBack.getText());
                                UISetting tmp = cardBag.getUiSetting();
                                tmp.showBack = !cardBag.getUiSetting().showBack;
                                cardBag.updateUISetting(tmp);
                                if (tmp.showBack) {
                                    hidedBackPanel.setVisible(false);
                                    backPanel.setVisible(true);
                                } else {
                                    hidedBackPanel.setVisible(!isEditLayout);
                                    backPanel.setVisible(isEditLayout);
                                }
                                updateUI();
                                update();
                            }
                        });
                        settingMenu.setSize(150, 25);
                        settingMenu.add(showBack);
                    }

                    // 复制卡片到…
                    {
                        JMenuItem duplicate = new JMenuItem();

                        duplicate.setText("复制卡片到…");
                        duplicate.setIcon(MemWinkUtil.getScaledIcon("手动修改", 30, 30));

                        duplicate.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.print(duplicate.getText());
                                try {
                                    new MoveCardDialog(card.cloneItem(), "复制")
                                            .setLocationRelativeTo(CardContent.this);
                                } catch (CloneNotSupportedException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        });
                        duplicate.setSize(150, 25);
                        settingMenu.add(duplicate);
                    }

                    // 移动卡片到…
                    {
                        JMenuItem move = new JMenuItem();

                        move.setText("移动卡片到…");
                        move.setIcon(MemWinkUtil.getScaledIcon("手动修改", 30, 30));

                        move.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.print(move.getText());
                                new MoveCardDialog(card, "移动")
                                        .setLocationRelativeTo(CardContent.this);
                            }
                        });
                        move.setSize(150, 25);
                        settingMenu.add(move);
                    }

                    // 删除卡片
                    {
                        JMenuItem delete = new JMenuItem();

                        delete.setText("删除卡片");
                        delete.setIcon(MemWinkUtil.getScaledIcon("手动修改", 30, 30));

                        delete.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                new DeleteConfirmDialog(card, CardContent.this)
                                        .setLocationRelativeTo(CardContent.this);
                            }
                        });

                        settingMenu.add(delete);
                    }

                    settingMenu.setPopupSize(150, 150);
                    settingButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("显示记忆阶段面板");
                            settingMenu.show(settingButton, -150, 5);
                        }
                    });
                }
            }

            // editButton
            {
                editButton = new JButton();
                editButton.setIcon(MemWinkUtil.getScaledIcon("修改", 30, 30));
                editButton.setSize(45, 45);
                editButton.setLocation(60, 60);
                editButton.setFocusable(false);
                editButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new EditCardDialog(card, CardContent.this);
                        update();
                    }
                });
            }

            // backVerticalAlignmentButtons
            {
                {
                    backVerticalTop = new JButton();
                    backVerticalTop.setIcon(MemWinkUtil.getScaledIcon("设置", 30, 30));
                    backVerticalTop.setSize(35, 35);
                    backVerticalTop.setLocation(
                            (rightPanel.getWidth() >> 1) + 15,
                            (rightPanel.getHeight() >> 1) - 40
                    );

                    backVerticalTop.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            UISetting tmp = cardBag.getUiSetting();
                            tmp.backVerticalAlignment = BorderLayout.NORTH;
                            cardBag.updateUISetting(tmp);
                            backContentLabelsPanel.updateVerticalAlignment(BorderLayout.NORTH);
                            update();
                        }
                    });
                    backVerticalTop.setVisible(false);
                }

                {
                    backVerticalCenter = new JButton();
                    backVerticalCenter.setIcon(MemWinkUtil.getScaledIcon("设置", 30, 30));;
                    backVerticalCenter.setSize(35, 35);
                    backVerticalCenter.setLocation(
                            (rightPanel.getWidth() >> 1) + 15,
                            (rightPanel.getHeight() >> 1)
                    );

                    backVerticalCenter.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            UISetting tmp = cardBag.getUiSetting();
                            tmp.backVerticalAlignment = BorderLayout.CENTER;
                            cardBag.updateUISetting(tmp);
                            backContentLabelsPanel.updateVerticalAlignment(BorderLayout.CENTER);
                            update();
                        }
                    });
                    backVerticalCenter.setVisible(false);
                }

                {
                    backVerticalBottom = new JButton();
                    backVerticalBottom.setIcon(MemWinkUtil.getScaledIcon("设置", 30, 30));;
                    backVerticalBottom.setSize(35, 35);
                    backVerticalBottom.setLocation(
                            (rightPanel.getWidth() >> 1) + 15,
                            (rightPanel.getHeight() >> 1) + 40
                    );

                    backVerticalBottom.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            UISetting tmp = cardBag.getUiSetting();
                            tmp.backVerticalAlignment = BorderLayout.SOUTH;
                            cardBag.updateUISetting(tmp);
                            backContentLabelsPanel.updateVerticalAlignment(BorderLayout.SOUTH);
                            update();
                        }
                    });
                    backVerticalBottom.setVisible(false);
                }
            }

            // backFontSizeButtons
            {
                {
                    backFontSizeAddButton = new JButton();
                    backFontSizeAddButton.setIcon(MemWinkUtil.getScaledIcon("设置", 30, 30));
                    backFontSizeAddButton.setSize(35, 35);
                    backFontSizeAddButton.setLocation(
                            (rightPanel.getWidth() >> 1) + 15,
                            (rightPanel.getHeight() >> 1) + 100
                    );

                    backFontSizeAddButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            UISetting tmp = cardBag.getUiSetting();
                            tmp.backFontSize += 5;
                            cardBag.updateUISetting(tmp);
                            backContentLabelsPanel.updateFontSize(tmp.backFontSize);
                            update();
                        }
                    });
                    backFontSizeAddButton.setVisible(false);
                }

                {
                    backFontSizeMinusButton = new JButton();
                    backFontSizeMinusButton.setIcon(MemWinkUtil.getScaledIcon("设置", 30, 30));
                    backFontSizeMinusButton.setSize(35, 35);
                    backFontSizeMinusButton.setLocation(
                            (rightPanel.getWidth() >> 1) + 15,
                            (rightPanel.getHeight() >> 1) + 140
                    );

                    backFontSizeMinusButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            UISetting tmp = cardBag.getUiSetting();
                            tmp.backFontSize -= 5;
                            cardBag.updateUISetting(tmp);
                            backContentLabelsPanel.updateFontSize(tmp.backFontSize);
                            update();
                        }
                    });
                    backFontSizeMinusButton.setVisible(false);
                }
            }

            // backButton
            {
                backButton = new JButton("返回");
                backButton.setSize(100, 45);
                backButton.setLocation(5, rightPanel.getHeight());
                backButton.setFocusable(false);
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (isEditLayout) {
                            System.out.println("退出布局编辑模式");
                            isEditLayout = false;
                            frontHorizenalLeft.setVisible(false);
                            frontHorizenalCenter.setVisible(false);
                            frontHorizenalRight.setVisible(false);
                            frontVerticalTop.setVisible(false);
                            frontVerticalCenter.setVisible(false);
                            frontVerticalBottom.setVisible(false);
                            frontFontSizeAddButton.setVisible(false);
                            frontFontSizeMinusButton.setVisible(false);
                            backHorizenalLeft.setVisible(false);
                            backHorizenalCenter.setVisible(false);
                            backHorizenalRight.setVisible(false);
                            backVerticalTop.setVisible(false);
                            backVerticalCenter.setVisible(false);
                            backVerticalBottom.setVisible(false);
                            backFontSizeAddButton.setVisible(false);
                            backFontSizeMinusButton.setVisible(false);

                            update();
                        } else {
                            System.out.println("返回");
                            CardContent.this.setVisible(false);
                        }
                    }
                });
            }

            rightPanel.add(settingButton);
            rightPanel.add(editButton);
            rightPanel.add(backButton);
            rightPanel.add(backVerticalTop);
            rightPanel.add(backVerticalCenter);
            rightPanel.add(backVerticalBottom);

            rightPanel.add(backFontSizeAddButton);
            rightPanel.add(backFontSizeMinusButton);


            rightPanel.setLocation(this.getWidth()-110, 0);
        }

        this.add(leftPanel);
        this.add(middlePanel);
        this.add(rightPanel);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        DataManager.init();
        DataManager.addCardBag("A", Color.gray, 20);
        DataManager.addCardBag("D", Color.gray, 20);
        DataManager.addCardBag("E", Color.gray, 20);
        DataManager.provideCardBag("A").addCard("Front\ncontent", "Back", true, MemStateConstants.newCard, false, null);
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(1280, 720);
        CardContent tmp = new CardContent(DataManager.provideCardBag("A").getCards().get(0));
        tmp.setLocation(50, 25);
        frame.add(tmp);
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                UIConstant.mainPanelWidth = frame.getWidth();
                UIConstant.mainPanelHeight = frame.getHeight();
                tmp.update();
            }
        });
        frame.setVisible(true);
    }

    public void updateReview(boolean review) {
        isReview = review;
        update();
    }

    CardContentLabelsPanel frontContentLabelsPanel;
    CardContentLabelsPanel backContentLabelsPanel;
    JButton frontFontSizeAddButton;
    JButton frontFontSizeMinusButton;
    JButton backFontSizeAddButton;
    JButton backFontSizeMinusButton;
     boolean isEditLayout = false;
    protected boolean isReview = false;
    protected boolean isShowBack;
    protected JPanel leftPanel;
    protected static JPanel middlePanel;
    protected JPanel rightPanel;
     JButton categoryButton;
     JButton stageButton;
     JButton historyButton;
    protected RoundedRectangle frontPanel;
     JButton frontHorizenalLeft;
     JButton frontHorizenalCenter;
     JButton frontHorizenalRight;
     JButton backHorizenalLeft;
     JButton backHorizenalCenter;
     JButton backHorizenalRight;
    protected RoundedRectangle backPanel;
    protected RoundedRectangle hidedBackPanel;
     JLabel hidedBackLabel = new JLabel("<html><body>点击此处<br>或按[↑]键<br>查看背面<body></html>", JLabel.CENTER);
     JButton settingButton;
     JButton editButton;
     JButton frontVerticalTop;
     JButton frontVerticalCenter;
     JButton frontVerticalBottom;
     JButton backVerticalTop;
     JButton backVerticalCenter;
     JButton backVerticalBottom;
     JPopupMenu settingMenu;
     JMenuItem showBack;
     JButton backButton;
     JPopupMenu categoryMenu;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            isShowBack = true;
            CardContent.this.hidedBackPanel.setVisible(false);
            CardContent.this.backPanel.setVisible(true);
            update();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
