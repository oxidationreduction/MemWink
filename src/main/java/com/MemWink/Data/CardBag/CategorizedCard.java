package com.MemWink.Data.CardBag;

import com.MemWink.Data.DataManager;

import java.io.Serializable;
import java.util.Objects;

/**
 * 含分类的卡片
 * @author Liu Hongyu
 * @version 1.0
 */
public class CategorizedCard extends Card implements Serializable, Cloneable {
    /**
     * 卡片在卡包内的类别，默认为 {@code null} 代表"未分类"
     */
    private String category = null;

    /**
     * 构造器
     */
    public CategorizedCard(String front, String back, boolean showFront, int memState, boolean starred, String category, String cardBagName) {
        super(front, back, showFront, memState, starred, cardBagName);
        this.category = category;
    }

    /**
     * {@code category} 的 setter 和 getter
     * <p> setter 仅限package内部使用，禁止外界直接访问。如果想要更改 {@code category}，请使用 updater </p>
     */
    protected void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category == null ? "未分类" : category;
    }

    /**
     * 类别 setter 的替代方法
     * @param category 卡片类别
     */
    public void updateCategory(String category) {
        setCategory(category);
        Objects.requireNonNull(DataManager.provideCardBag(getCardBagName())).updateCard(this);
    }

    /**
     * 克隆本张卡片，生成完全相同的新对象，包括创建时间也完全相同
     * @return 复制得到的卡片副本
     * @throws CloneNotSupportedException 不支持克隆，提示方法调用或 {@code CategorizedCard} 存在问题
     */
    public CategorizedCard cloneItem() throws CloneNotSupportedException {
        return (CategorizedCard) this.clone();
    }
}
