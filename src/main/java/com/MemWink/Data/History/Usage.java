package com.MemWink.Data.History;

import java.io.Serializable;
import java.util.*;

/**
 * 全局记忆历史记录，记录的时每天的操作数量
 * <p>最多可以存储过去 31 天的数据</p>
 * <p>注意：只看操作数量，不看涉及到的卡的数量</p>
 * <p>如果 1 张卡在 1 天内被记忆2次，会被算成 2 次不同的记忆操作</p>
 * @author Liu Hongyu
 * @version 1.0
 * @since 2022-05-21
 */
public class Usage implements Serializable {
    /**
     * 上次操作时间，用于一天中首次使用时向 4 个数据列表中添加代表当天的新的数据元素，仅限内部使用
     */
    private Date lastUse = new Date();

    /**
     * 每天记忆操作总数
     */
    private List<Integer> reviewCardsNumHistory = new ArrayList<>();

    /**
     * 每天"已记住"操作的总数
     */
    private List<Integer> rememberedCardsNumHistory = new ArrayList<>();

    /**
     * 每天"没记住"操作的总数
     */
    private List<Integer> forgetCardsNumHistory = new ArrayList<>();

    /**
     * 每天的遗忘率
     */
    private List<Double> forgetRateHistory = new ArrayList<>();

    public Usage() {
        rememberedCardsNumHistory.add(0);
        reviewCardsNumHistory.add(0);
        forgetCardsNumHistory.add(0);
        forgetRateHistory.add(0.0);
    }

    /**
     * 用户做出"已记住"操作后，更新历史记录数据
     */
    public void addRememberedCardsNumHistory() {
        Date tmp = new Date();
        if (lastUse.getTime() < new Date(tmp.getYear(), tmp.getMonth(), tmp.getDay()).getTime()) {
            rememberedCardsNumHistory.add(1);
            forgetCardsNumHistory.add(0);
            reviewCardsNumHistory.add(1);
        } else {
            rememberedCardsNumHistory.set(
                    rememberedCardsNumHistory.size()-1,
                    rememberedCardsNumHistory.get(rememberedCardsNumHistory.size()-1) + 1
            );
            reviewCardsNumHistory.set(
                    reviewCardsNumHistory.size()-1,
                    reviewCardsNumHistory.get(reviewCardsNumHistory.size()-1) + 1
            );
        }
        if (rememberedCardsNumHistory.size() > 31) {
            rememberedCardsNumHistory.remove(0);
            reviewCardsNumHistory.remove(0);
        }
        updateForgetRateHistory();
        lastUse = new Date();
    }

    /**
     * 用户做出"没记住"操作后，更新历史记录数据
     */
    public void addForgetCardsNumHistory() {
        Date tmp = new Date();
        if (lastUse.getTime() < new Date(tmp.getYear(), tmp.getMonth(), tmp.getDay()).getTime()) {
            forgetCardsNumHistory.add(1);
            reviewCardsNumHistory.add(1);
            rememberedCardsNumHistory.add(0);
        } else {
            forgetCardsNumHistory.set(
                    forgetCardsNumHistory.size()-1,
                    forgetCardsNumHistory.get(forgetCardsNumHistory.size()-1) + 1
            );
            reviewCardsNumHistory.set(
                    reviewCardsNumHistory.size()-1,
                    reviewCardsNumHistory.get(reviewCardsNumHistory.size()-1) + 1
            );
        }
        if (forgetCardsNumHistory.size() > 31) {
            forgetCardsNumHistory.remove(0);
            reviewCardsNumHistory.remove(0);
        }
        updateForgetRateHistory();
        lastUse = new Date();
    }

    /**
     * 用户做出记忆操作后，更新遗忘率数据，仅限内部使用
     */
    private void updateForgetRateHistory() {
        if (reviewCardsNumHistory.get(reviewCardsNumHistory.size()-1) == 0) {
            forgetRateHistory.set(
                    forgetRateHistory.size()-1, 0.0
            );
        } else {
            forgetRateHistory.set(
                    forgetRateHistory.size()-1,
                    (double) forgetCardsNumHistory.get(forgetCardsNumHistory.size()-1)
                    / (double) reviewCardsNumHistory.get(reviewCardsNumHistory.size()-1)
            );
        }
    }

    /**
     * getter
     */
    public List<Integer> getReviewCardsNumHistory() {
        return reviewCardsNumHistory;
    }
    public List<Integer> getRememberedCardsNumHistory() {
        return rememberedCardsNumHistory;
    }
    public List<Integer> getForgetCardsNumHistory() {
        return forgetCardsNumHistory;
    }
    public List<Double> getForgetRateHistory() {
        return forgetRateHistory;
    }
}
