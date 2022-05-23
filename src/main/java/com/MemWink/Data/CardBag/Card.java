package com.MemWink.Data.CardBag;

import com.MemWink.Data.DataManager;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Stack;

/**
 * 卡片：最小记忆单元。
 * <p>
 * 每张卡有正反两面，正面记载提示信息，反面记载需要记忆的内容。
 * <p>
 * 以"单词本"为例：正面记载中文翻译，反面记载外文单词。用户记忆时，点开卡片后
 * 首先看到中文翻译，之后根据中文翻译回想单词，再点击翻面检查记忆结果。
 * <p>
 * 卡片不能脱离卡包存在，每张卡片只属于一个卡包
 *
 * @author Liu Hongyu
 * @version 1.0
 */
public class Card implements Serializable {
    /**
     * 卡正面的内容
     */
    private String front = "";

    /**
     * 卡背面的内容
     */
    private String back = "";

    /**
     * 卡片创建时间，卡片的唯一标识，因此只读
     */
    private Date createTime = new Date();

    /**
     * 卡片所属的卡包的名字
     */
    private String cardBagName;

    /**
     * 下次记忆时间
     * <p>
     * 如果记忆阶段是"已记住"，这一项没有意义
     */
    private Date rememberTime;

    /**
     * 是否默认显示正面
     */
    private boolean showFront = true;

    /**
     * 记忆阶段
     */
    private int memState = MemStateConstants.newCard;

    private Stack<MemHistory> memHistories = new Stack<>();

    /**
     * 是否标记为收藏
     */
    private boolean starred = false;

    /**
     * 初始化器
     */
    public Card(String front, String back, boolean showFront, int memState, boolean starred, String cardBagName) {
        this.front = front;
        this.back = back;
        this.showFront = showFront;
        this.memState = memState;
        setRememberTime();
        this.starred = starred;
        this.cardBagName = cardBagName;
    }

    /**
     * setter
     * <p> 仅限软件包内部访问，禁止直接设置 </p>
     * <p> {@code createTime} 和 {@code rememberTime} 禁止直接设置
     */
    protected void setFront(String front) {
        this.front = front;
    }
    protected void setBack(String back) {
        this.back = back;
    }
    protected void setShowFront(boolean showFront) {
        this.showFront = showFront;
    }
    protected void setStarred(boolean starred) {
        this.starred = starred;
    }
    protected void setCardBagName(String cardBagName) {
        this.cardBagName = cardBagName;
    }

    /**
     * updater
     * <p> setter 的替代品，用于支持外部直接访问 </p>
     * <p> 在给出的 setter 中，cardBagName 的 setter 没有替代品，不可以被外界直接更改。</p>
     */
    public void updateFront(String front) {
        setFront(front);
        Objects.requireNonNull(DataManager.provideCardBag(cardBagName)).updateCard((CategorizedCard) this);
    }
    public void updateBack(String back) {
        setBack(back);
        Objects.requireNonNull(DataManager.provideCardBag(cardBagName)).updateCard((CategorizedCard) this);
    }

    public void updateShowFront(boolean showFront) {
        setShowFront(showFront);
        Objects.requireNonNull(DataManager.provideCardBag(cardBagName)).updateCard((CategorizedCard) this);
    }

    public void updateStarred(boolean starred) {
        setStarred(starred);
        Objects.requireNonNull(DataManager.provideCardBag(cardBagName)).updateCard((CategorizedCard) this);
    }

    /**
     * 设置卡片记忆阶段
     * <p>操作结束后更新卡片的下次记忆时间 {@code rememberTime}
     * <p>仅限内部使用，如想手动更改记忆阶段，另见 {@code public void changeMemState()}</p>
     * @param memState 记忆阶段
     */
    private void setMemState(int memState) {
        if (memState < -2 || memState > 6) {
            throw new RuntimeException("Invalid memState.");
        }
        this.memState = memState;
        setRememberTime();
    }

    /**
     * 复习时，卡片被记住
     * <p>此方法会根据卡片的记忆历史，自动修改卡片的记忆阶段 {@code memState}
     * 和下次记忆时间 {@code rememberTime}，并添加一条记忆历史，更新全局记忆历史记录 ({@code usage})</p>
     *
     * @throws RuntimeException 不应该被复习的卡片被复习了，
     * 提示 {@code CardBag.updateCardNeedReview} 存在问题
     */
    public void remembered() {
        // "已记住"的卡片不应该被复习
        if (memState == MemStateConstants.finished) {
            throw new RuntimeException("A card that shouldn't be reviewed is being reviewed. Check CardBag.updateCardNeedReview");
        }

        // 获取上次记住这张卡片时卡片的记忆阶段，"强化记忆阶段"除外
        int lastState = -1;
        Stack<MemHistory> tmpStack = new Stack<>();
        while (!memHistories.isEmpty()) {
            MemHistory tmp = memHistories.pop();
            tmpStack.push(tmp);
            if (tmp.status == MemHistory.StatusNum.REMEMBERED && tmp.afterState > 0) {
                lastState = tmp.afterState;
                break;
            }
        }
        if (lastState == -1) {
            if (!tmpStack.isEmpty()) {
                lastState = tmpStack.peek().preState;
            } else {
                lastState = memState;
            }
        }
        while (!tmpStack.isEmpty()) {
            memHistories.push(tmpStack.pop());
        }

        // 根据用户确认本次记住之前卡片的记忆阶段，和刚刚获取的上次记住这张卡片时卡片的记忆阶段进行判断，
        // 确定现在卡片在本次被记住后应当变为的记忆阶段、下次记忆时间，添加一条记忆历史记录
        if (memState == MemStateConstants.reinforce1) {
            setMemState(MemStateConstants.reinforce2);
            memHistories.add(
                    new MemHistory(MemStateConstants.reinforce1, MemHistory.StatusNum.REMEMBERED, MemStateConstants.reinforce2));
        } else if (memState == MemStateConstants.reinforce2) {
            if (lastState == MemStateConstants.newCard) {
                setMemState(MemStateConstants.stage_one);
                memHistories.add(
                        new MemHistory(MemStateConstants.reinforce2, MemHistory.StatusNum.REMEMBERED, MemStateConstants.stage_one));
            } else {
                if (lastState < 0 || lastState == MemStateConstants.finished) {
                    throw new RuntimeException("A card that shouldn't be reviewed is being reviewed. Check CardBag.updateCardNeedReview");
                }
                memHistories.add(
                        new MemHistory(MemStateConstants.reinforce2, MemHistory.StatusNum.REMEMBERED, lastState));
                setMemState(lastState);
            }
        } else if (memState != MemStateConstants.finished) {
            if (memState == MemStateConstants.newCard) {
                DataManager.rememberNewCard(cardBagName);
            }
            memHistories.add(new MemHistory(memState, MemHistory.StatusNum.REMEMBERED, memState + 1));
            setMemState(memState + 1);
        }

        // 完成状态更新后进行数据更新和文件存储
        Objects.requireNonNull(DataManager.provideCardBag(cardBagName)).updateCard((CategorizedCard) this);
        DataManager.addRememberedCardsNumHistory();
    }

    /**
     * 复习时，卡片没有被记住
     * <p>此方法会根据卡片的记忆历史，自动修改卡片的记忆阶段 {@code memState}
     * 和下次记忆时间 {@code rememberTime}，并添加一条记忆历史，更新全局记忆历史记录 ({@code usage})</p>
     *
     * @throws RuntimeException 不应该被复习的卡片被复习了，
     * 提示 {@code CardBag.updateCardNeedReview} 存在问题
     */
    public void forget() {
        if (memState == MemStateConstants.finished) {
            throw new RuntimeException("A card that shouldn't be reviewed is being reviewed. Check CardBag.updateCardNeedReview");
        }

        if (memState == MemStateConstants.newCard) {
            DataManager.rememberNewCard(cardBagName);
        }

        memHistories.add(
                new MemHistory(memState, MemHistory.StatusNum.FORGET, MemStateConstants.reinforce1));
        setMemState(MemStateConstants.reinforce1);

        // 数据更新和文件存储
        DataManager.saveCardBag(DataManager.provideCardBag(cardBagName));
        DataManager.addForgetCardsNumHistory();
    }

    /**
     * 用户手动修改卡片记忆阶段
     * <p>此方法会修改卡片的记忆阶段 {@code memState}
     * 和下次记忆时间 {@code rememberTime}，并添加一条记忆历史</p>
     * @param newMemState 用户要修改的目标记忆阶段
     */
    public void changeMemState(int newMemState) {
        memHistories.add(
                new MemHistory(memState, MemHistory.StatusNum.MANUAL_CHANGE, newMemState));
        setMemState(newMemState);

        // 数据更新和文件存储
        DataManager.saveCardBag(DataManager.provideCardBag(cardBagName));
    }

    /**
     * 根据记忆阶段设置卡片的记忆时间
     * <p>仅在创建卡片，或修改卡片记忆阶段后调用。
     */
    private void setRememberTime() {
        rememberTime = new Date();
        if (memState == MemStateConstants.newCard) {
            rememberTime = (Date) createTime.clone();
        } else if (memState == MemStateConstants.reinforce1) {
            rememberTime = new Date(new Date().getTime() + 6000);
        } else if (memState == MemStateConstants.reinforce2) {
            rememberTime = new Date(new Date().getTime() + 600000);
        } else if (memState == MemStateConstants.stage_one || memState == MemStateConstants.stage_two) {
            rememberTime.setTime(rememberTime.getTime() + 86400000);
            rememberTime = new Date(rememberTime.getYear(), rememberTime.getMonth(), rememberTime.getDate());
        } else if (memState == MemStateConstants.stage_three) {
            rememberTime.setTime(rememberTime.getTime() + 172800000);
            rememberTime = new Date(rememberTime.getYear(), rememberTime.getMonth(), rememberTime.getDate());
        } else if (memState == MemStateConstants.stage_four) {
            rememberTime.setTime(rememberTime.getTime() + 345600000);
            rememberTime = new Date(rememberTime.getYear(), rememberTime.getMonth(), rememberTime.getDate());
        } else if (memState == MemStateConstants.stage_five) {
            rememberTime.setTime(rememberTime.getTime() + 604800000);
            rememberTime = new Date(rememberTime.getYear(), rememberTime.getMonth(), rememberTime.getDate());
        }
    }

    /**
     * 判断卡片是否需要复习
     * @return boolean: true代表需要复习
     */
    public boolean needReview() {
        return memState != MemStateConstants.finished && new Date().getTime() > rememberTime.getTime();
    }

    /**
     * getter
     */
    public Date getCreateTime() {
        return createTime;
    }
    public Date getRememberTime() {
        return rememberTime;
    }
    public String getFront() {
        return front;
    }
    public String getBack() {
        return back;
    }
    public int getMemState() {
        return memState;
    }
    public String getCardBagName() {
        return cardBagName;
    }
    public Stack<MemHistory> getMemHistories() {
        return memHistories;
    }
    public boolean isShowFront() {
        return showFront;
    }
    public boolean isStarred() {
        return starred;
    }
}
