package com.MemWink.Data.CardBag;

import java.io.Serializable;

/**
 * 含分类的卡片
 * @author Liu Hongyu
 * @version 1.0
 */
public class CategorizedCard extends Card implements Serializable {
    /**
     * 卡片在卡包内的类别，默认为 {@code null} 代表"未分类"
     */
    private String category = null;

    /**
     * 构造器
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
     * {@code category} 的 setter 和 getter
     */
    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category;
    }
}
