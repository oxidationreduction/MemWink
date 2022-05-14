package com.MemWink.Data.CardBag;

import com.MemWink.Data.DataManager;

import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.*;

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
public class CardBag implements Serializable {
    /**
     * 卡包的名字
     */
    private String name;

    /**
     * 卡包的颜色
     */
    private Color color;

    /**
     * 卡包对象的创建时间，精确到毫秒
     * <p>
     * 使用时间作为区分不同卡包的唯一标识，因此此项只读
     */
    private Date id;

    /**
     * 每天记忆的新卡数量
     * <p>要求值不小于 {@code 1}
     * <p>注意：对这一项的修改在次日生效
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
    private Set<String> categories = new HashSet<>();

    /**
     * 构造器
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
     * 三参数构造器
     * @param dailyNewCardNum 每天记忆的新卡数量，要求不能小于 {@code 1}。
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
        this.id = new Date();
    }

    /**
     * getter 和 setter
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

    /**
     * 卡包名的 setter，禁止直接调用
     * @param name 卡包名
     */
    protected void setName(String name) {
        this.name = name;
        for (CategorizedCard i : cards) {
            i.setCardBagName(name);
        }
    }

    /**
     * 卡包名 setter 的替代品，外界可访问
     * @param name 卡包名
     */
    public void updateName(String name) {
        setName(name);
    }

    /**
     * 向卡包内添加新的一种分类
     * @param catName 分类种类名称
     * @return 是否添加成功
     */
    public boolean addCategory(String catName) {
        if (categories.add(catName)) {
            return saveCardBag(this);
        } else {
            return false;
        }
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
    public boolean addCard(String front, String back, boolean showFront, int memState, boolean starred, String category) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        CategorizedCard tmp;
        if (Objects.equals(category, null) || categories.contains(category)) {
            tmp = new CategorizedCard(front, back, showFront, memState, starred, category, this.name);
        } else {
            throw new RuntimeException("Invalid Category: " + category);
        }
        cards.add(tmp);
        return saveCardBag(this);
    }

    /**
     * 更新卡包内的卡片
     * @param newCard 更新后的卡片
     */
    public boolean updateCard(CategorizedCard newCard) {
        int l = cards.size();
        for (int i = 0; i < l; i++) {
            if (newCard.getCreateTime() == cards.get(i).getCreateTime()) {
                cards.set(i, newCard);
                return saveCardBag(this);
            }
        }
        return false;
    }

    /**
     * 在卡包内删除卡片
     * @param c 要删除的卡片
     */
    public boolean delCard(CategorizedCard c) {
        cards.remove(c);
        cardNeedReview.remove(c);
        return saveCardBag(this);
    }

    /**
     * 更新需要复习的卡片队列 {@code cardNeedReview}
     * <p>1.添加新出现的需要复习的卡
     * <p>2.移除当前不需要复习的卡
     */
    private void updateCardNeedReview() {
        cardNeedReview = new ArrayList<>();
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

    /**
     * 保存卡包，静态方法，可直接调用
     * @param cardBag 要保存的卡包
     * @return 是否保存成功
     */
    public static boolean saveCardBag(CardBag cardBag) {
        String pathName = DataManager.savePath + cardBag.getName();
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
     * 从文件读取卡包，静态方法，可直接调用
     * @param bagName 卡包名称
     * @return 读取的卡包
     * @throws RuntimeException I/O错误或未知类错误
     */
    public static CardBag openCardBag(String bagName) {
        try {
            ObjectInputStream tool = new ObjectInputStream(
                    new FileInputStream(DataManager.savePath + bagName));
            return (CardBag) tool.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
