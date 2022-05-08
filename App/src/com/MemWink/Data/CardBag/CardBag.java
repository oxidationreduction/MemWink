package com.MemWink.Data.CardBag;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 卡包：存储卡片
 * <p>每天卡包提供给用户进行复习的卡片包括
 * <p>  1.新卡
 * <p>  2.旧卡中需要复习的卡片
 * <p>用户可以设置卡包每天抽出新卡的数量
 * <p>另外，用户可以自定义卡片的分类
 * @author Liu Hongyu
 * @version  1.0
 */
public class CardBag {
    /**
     * 卡包的名字
     */
    private String name;

    /**
     * 卡包的颜色
     */
    private Color color;

    /**
     * 每天记忆的新卡数量
     */
    private int dailyNewCardNum = 20;

    /**
     * 当天是否已经抽出新卡复习
     */
    private boolean dailyNewCardRemembered = false;

    /**
     * 卡片队列，按照添加顺序排序
     */
    private List<CategorizedCard> cards = new ArrayList<>();

    /**
     * 需要复习的卡片
     */
    private List<CategorizedCard> cardNeedReview = new ArrayList<>();

    /**
     * 用户自定义分类
     */
    private List<String> categories = new ArrayList<>();

    /**
     * 构造器
     */
    public CardBag(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    /**
     * 三参数构造器
     * @param dailyNewCardNum 每天记忆的新卡数量，要求不能小于 {@code 1}。
     */
    public CardBag(String name, Color color, int dailyNewCardNum) {
        this.name = name;
        this.color = color;
        if (dailyNewCardNum < 1) {
            throw new RuntimeException("Invalid daily new card number: " + dailyNewCardNum);
        } else {
            this.dailyNewCardNum = dailyNewCardNum;
        }
    }

    /**
     * getter
     */
    public Color getColor() {
        return color;
    }
    public int getDailyNewCardNum() {
        return dailyNewCardNum;
    }
    public List<CategorizedCard> getCards() {
        return cards;
    }
    public List<String> getCategories() {
        return categories;
    }
    public String getName() {
        return name;
    }

    /**
     * 向卡包内添加卡片
     * @param front 正面
     * @param back 反面
     * @param showFront 是否默认显示正面
     * @param memState 记忆阶段
     * @param starred 是否收藏
     * @param category 卡片类别
     */
    public void addCard(String front, String back, boolean showFront, int memState, boolean starred, String category) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        CategorizedCard tmp;
        if (Objects.equals(category, "") || categories.contains(category)) {
            tmp = new CategorizedCard(front, back, showFront, memState, starred, category);
        } else {
            throw new RuntimeException("Invalid Category: " + category);
        }
        cards.add(tmp);
    }

    /**
     * 更新卡包内的卡片
     * @param newCard 更新后的卡片
     */
    public void updateCard(CategorizedCard newCard) {
        int l = cards.size();
        for (int i = 0; i < l; i++) {
            if (newCard.getCreateTime() == cards.get(i).getCreateTime()) {
                cards.set(i, newCard);
                return;
            }
        }
    }

    /**
     * 在卡包内删除卡片
     * @param c 要删除的卡片
     */
    public void delCard(CategorizedCard c) {
        cards.remove(c);
        cardNeedReview.remove(c);
    }

    /**
     * 更新需要复习的卡片队列 {@code cardNeedReview}
     * <p>1.添加新出现的需要复习的卡
     * <p>2.移除当前不需要复习的卡
     */
    private void updateCardNeedReview() {
        if (dailyNewCardRemembered) {
            for (CategorizedCard i : cards) {
                if(i.getMemState() != MemStateConstants.newCard && i.needReview() && !cardNeedReview.contains(i)) {
                    cardNeedReview.add(i);
                }
            }
        } else {
            dailyNewCardRemembered = true;
            int newCardLeft = dailyNewCardNum;
            for (CategorizedCard i : cards) {
                if (i.getMemState() == MemStateConstants.newCard) {
                    if (newCardLeft > 0) {
                        cardNeedReview.add(i);
                        newCardLeft--;
                    }
                } else if (i.needReview()) {
                    cardNeedReview.add(i);
                }
            }
        }

        cardNeedReview.removeIf(i -> !i.needReview());
    }

    /**
     * 获取需要复习的卡片队列
     * <p>操作前更新需要复习的卡片队列 {@code cardNeedReview}。
     * @return 需要复习的卡片的队列
     */
    public List<CategorizedCard> getCardNeedReview() {
        updateCardNeedReview();
        return cardNeedReview;
    }

    /**
     * 返回卡包内总卡数
     * @return 卡包内卡的数量
     */
    public int getTotalCardsNum() {
        return cards.size();
    }

    /**
     * 返回卡包内当前需要记忆的卡的数量
     * <p>操作前更新需要复习的卡片队列 {@code cardNeedReview}。
     * @return 需要记忆/复习的卡片的数量
     */
    public int getReviewCardsNum() {
        updateCardNeedReview();
        return cardNeedReview.size();
    }
}
