package com.MemWink.Data.CardBag;

import java.io.Serializable;
import java.util.Date;

/**
 * 卡片记忆历史记录
 * <p>记载了每一次修改卡片记忆阶段的操作的信息</p>
 *
 * @author Liu Hongyu
 * @version 1.0
 */
public class MemHistory implements Serializable {
    /**
     * 本次记忆操作的时间
     * <p>只读</p>
     */
    private Date date = new Date();

    /**
     * 记忆操作前，卡片的记忆阶段
     */
    public int preState;

    /**
     * 本次记忆操作的类型(记住/没记住/手动更改)
     */
    public int status;

    /**
     * 记忆操作后，卡片的记忆阶段
     */
    public int afterState;

    public MemHistory() {

    }

    /**
     * 构造器
     */
    public MemHistory(int preState, int status, int afterState) {
        this.preState = preState;
        this.status = status;
        this.afterState = afterState;
    }

    /**
     * Date getter
     * @return 操作进行的时间
     */
    public Date getDate() {
        return date;
    }

    /**
     * 用于记录与三种记忆操作类型一一对应的数值
     */
    public static class StatusNum implements Serializable {
        public static int REMEMBERED = 0;
        public static int FORGET = 1;
        public static int MANUAL_CHANGE = 2;
    }
}
