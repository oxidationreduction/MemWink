package com.MemWink.Data.CardBag;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

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
public class CardBag implements Serializable {
    /**
     * ����������
     */
    private String name;

    /**
     * ��������ɫ
     */
    private Color color;

    /**
     * ��������Ĵ���ʱ�䣬��ȷ������
     * <p>
     * ʹ��ʱ����Ϊ���ֲ�ͬ������Ψһ��ʶ����˴���ֻ��
     */
    private Date id;

    /**
     * ÿ�������¿�����
     * <p>Ҫ��ֵ��С�� {@code 1}
     * <p>ע�⣺����һ����޸��ڴ�����Ч
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
    private Set<String> categories = new HashSet<>();

    /**
     * ������
     */
    public CardBag(String name, Color color) {
        this.name = name;
        this.color = color;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        categories.add(null);
        this.id = new Date();
    }

    /**
     * ������������
     * @param dailyNewCardNum ÿ�������¿�������Ҫ����С�� {@code 1}��
     */
    public CardBag(String name, Color color, int dailyNewCardNum) {
        this.name = name;
        this.color = color;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (dailyNewCardNum < 1) {
            throw new RuntimeException("Invalid daily new card number: " + dailyNewCardNum);
        } else {
            this.dailyNewCardNum = dailyNewCardNum;
        }
    }

    /**
     * getter �� setter
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
    public Set<String> getCategories() {
        return categories;
    }
    public String getName() {
        return name;
    }
    public Date getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }

    /**
     * �򿨰�������µ�һ�ַ���
     * @param catName ������������
     * @return �Ƿ���ӳɹ�
     */
    public boolean addCategory(String catName) {
        if (categories.add(catName)) {
            saveCardBag(this);
            return true;
        } else {
            return false;
        }
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
        if (Objects.equals(category, null) || categories.contains(category)) {
            tmp = new CategorizedCard(front, back, showFront, memState, starred, category);
        } else {
            throw new RuntimeException("Invalid Category: " + category);
        }
        cards.add(tmp);
        saveCardBag(this);
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
        saveCardBag(this);
    }

    /**
     * �ڿ�����ɾ����Ƭ
     * @param c Ҫɾ���Ŀ�Ƭ
     */
    public void delCard(CategorizedCard c) {
        cards.remove(c);
        cardNeedReview.remove(c);
        saveCardBag(this);
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

    /**
     * ���濨������̬��������ֱ�ӵ���
     * @param cardBag Ҫ����Ŀ���
     * @return �Ƿ񱣴�ɹ�
     */
    public static boolean saveCardBag(CardBag cardBag) {
        String pathName = "App/dataBank/" + cardBag.getName();
        File file = new File(pathName);
        if (file.exists()) {
            file.delete();
        }
        try {
            ObjectOutputStream tool = new ObjectOutputStream(
                    new FileOutputStream(pathName));
            tool.writeObject(cardBag);
            tool.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * ���ļ���ȡ��������̬��������ֱ�ӵ���
     * @param bagName ��������
     * @return ��ȡ�Ŀ���
     * @throws RuntimeException I/O�����δ֪�����
     */
    public static CardBag openCardBag(String bagName) {
        try {
            ObjectInputStream tool = new ObjectInputStream(
                    new FileInputStream("App/dataBank/" + bagName));
            return (CardBag) tool.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
