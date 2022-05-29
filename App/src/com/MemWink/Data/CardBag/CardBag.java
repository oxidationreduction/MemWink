package com.MemWink.Data.CardBag;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * �������洢��Ƭ
 * <p>ÿ�쿨���ṩ���û����и�ϰ�Ŀ�Ƭ����
 * <p>  1.�¿�
 * <p>  2.�ɿ�����Ҫ��ϰ�Ŀ�Ƭ
 * <p>�û��������ÿ���ÿ�����¿�������
 * <p>���⣬�û������Զ��忨Ƭ�ķ���
 * @author Liu Hongyu
 * @version  1.0
 */
public class CardBag {
    /**
     * ����������
     */
    private String name;

    /**
     * ��������ɫ
     */
    private Color color;

    /**
     * ÿ�������¿�����
     */
    private int dailyNewCardNum = 20;

    /**
     * �����Ƿ��Ѿ�����¿���ϰ
     */
    private boolean dailyNewCardRemembered = false;

    /**
     * ��Ƭ���У��������˳������
     */
    private List<CategorizedCard> cards = new ArrayList<>();

    /**
     * ��Ҫ��ϰ�Ŀ�Ƭ
     */
    private List<CategorizedCard> cardNeedReview = new ArrayList<>();

    /**
     * �û��Զ������
     */
    private List<String> categories = new ArrayList<>();

    /**
     * ������
     */
    public CardBag(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    /**
     * ������������
     * @param dailyNewCardNum ÿ�������¿�������Ҫ����С�� {@code 1}��
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
     * �򿨰�����ӿ�Ƭ
     * @param front ����
     * @param back ����
     * @param showFront �Ƿ�Ĭ����ʾ����
     * @param memState ����׶�
     * @param starred �Ƿ��ղ�
     * @param category ��Ƭ���
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
     * ���¿����ڵĿ�Ƭ
     * @param newCard ���º�Ŀ�Ƭ
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
     * �ڿ�����ɾ����Ƭ
     * @param c Ҫɾ���Ŀ�Ƭ
     */
    public void delCard(CategorizedCard c) {
        cards.remove(c);
        cardNeedReview.remove(c);
    }

    /**
     * ������Ҫ��ϰ�Ŀ�Ƭ���� {@code cardNeedReview}
     * <p>1.����³��ֵ���Ҫ��ϰ�Ŀ�
     * <p>2.�Ƴ���ǰ����Ҫ��ϰ�Ŀ�
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
     * ��ȡ��Ҫ��ϰ�Ŀ�Ƭ����
     * <p>����ǰ������Ҫ��ϰ�Ŀ�Ƭ���� {@code cardNeedReview}��
     * @return ��Ҫ��ϰ�Ŀ�Ƭ�Ķ���
     */
    public List<CategorizedCard> getCardNeedReview() {
        updateCardNeedReview();
        return cardNeedReview;
    }

    /**
     * ���ؿ������ܿ���
     * @return �����ڿ�������
     */
    public int getTotalCardsNum() {
        return cards.size();
    }

    /**
     * ���ؿ����ڵ�ǰ��Ҫ����Ŀ�������
     * <p>����ǰ������Ҫ��ϰ�Ŀ�Ƭ���� {@code cardNeedReview}��
     * @return ��Ҫ����/��ϰ�Ŀ�Ƭ������
     */
    public int getReviewCardsNum() {
        updateCardNeedReview();
        return cardNeedReview.size();
    }
}
