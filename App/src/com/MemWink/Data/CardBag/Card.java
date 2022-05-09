package com.MemWink.Data.CardBag;

import java.io.Serializable;
import java.util.*;

/**
 * 卡片：最小记忆单元。
 * <p>
 * 每张卡有正反两面，正面记载提示信息，反面记载需要记忆的内容。
 * <p>
 * 以"单词本"为例：正面记载中文翻译，反面记载外文单词。用户记忆时，点开卡片后
 * 首先看到中文翻译，之后根据中文翻译回想单词，再点击翻面检查记忆结果。
 * <p>
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

    /**
     * 是否标记为收藏
     */
    private boolean starred = false;

    /**
     * 初始化器
     */
    public Card() {}
    public Card(String front, String back) {
        this.front = front;
        this.back = back;
        setRememberTime();
    }
    public Card(String front, String back, boolean showFront) {
        this.front = front;
        this.back = back;
        this.showFront = showFront;
        setRememberTime();
    }
    public Card(String front, String back, boolean showFront, int memState) {
        this.front = front;
        this.back = back;
        this.showFront = showFront;
        this.memState = memState;
        setRememberTime();
    }
    public Card(String front, String back, boolean showFront, int memState, boolean starred) {
        this.front = front;
        this.back = back;
        this.showFront = showFront;
        this.memState = memState;
        setRememberTime();
        this.starred = starred;
    }

    /**
     * setter
     * <p> {@code createTime} 和 {@code rememberTime} 禁止直接设置
     */
    public void setFront(String front) {
        this.front = front;
    }
    public void setBack(String back) {
        this.back = back;
    }
    public void setShowFront(boolean showFront) {
        this.showFront = showFront;
    }
    public void setStarred(boolean starred) {
        this.starred = starred;
    }

    /**
     * 设置卡片记忆阶段
     * <p>操作结束后更新卡片的下次记忆时间 {@code rememberTime}
     * @param memState 记忆阶段
     */
    public void setMemState(int memState) {
        this.memState = memState;
        setRememberTime();
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
            rememberTime = new Date(new Date().getTime() + 60000);
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
    public boolean isShowFront() {
        return showFront;
    }
    public boolean isStarred() {
        return starred;
    }
}
