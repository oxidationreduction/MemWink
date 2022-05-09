package com.MemWink.Data.CardBag;

import java.io.Serializable;

/**
 * ������Ŀ�Ƭ
 * @author Liu Hongyu
 * @version 1.0
 */
public class CategorizedCard extends Card implements Serializable {
    /**
     * ��Ƭ�ڿ����ڵ����Ĭ��Ϊ {@code null} ����"δ����"
     */
    private String category = null;

    /**
     * ������
     */
    public CategorizedCard() {
        super();
    }
    public CategorizedCard(String front, String back) {
        super(front, back);
    }
    public CategorizedCard(String front, String back, boolean showFront) {
        super(front, back, showFront);
    }
    public CategorizedCard(String front, String back, boolean showFront, int memState) {
        super(front, back, showFront, memState);
    }
    public CategorizedCard(String front, String back, boolean showFront, int memState, boolean starred) {
        super(front, back, showFront, memState, starred);
    }
    public CategorizedCard(String front, String back, boolean showFront, int memState, boolean starred, String category) {
        super(front, back, showFront, memState, starred);
        this.category = category;
    }

    /**
     * {@code category} �� setter �� getter
     */
    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category;
    }
}
