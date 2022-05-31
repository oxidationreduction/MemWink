package com.MemWink.Data.CardBag;

import java.io.Serializable;

/**
 * 记忆阶段：用于表示卡片的记忆阶段。
 * @author Liu Hongyu
 * @version 1.0
 */
public class MemStateConstants implements Serializable {
    public static int[] values = {-2, -1, 0, 1, 2, 3, 4, 5, 6};
    /**
     * 首次强化记忆，1分钟后重新记忆。
     */
    public static int reinforce1 = -2;

    /**
     * 二次强化记忆，10分钟后重新记忆。
     */
    public static int reinforce2 = -1;

    /**
     * 新卡
     */
    public static int newCard = 0;

    /**
     * 阶段一，已记忆1天，1天后重新记忆。
     */
    public static int stage_one = 1;

    /**
     * 阶段二，已记忆2天，1天后重新记忆。
     */
    public static int stage_two = 2;

    /**
     * 阶段三，已记忆3天，2天后重新记忆。
     */
    public static int stage_three = 3;

    /**
     * 阶段四，已记忆5天，4天后重新记忆。
     */
    public static int stage_four = 4;

    /**
     * 阶段五，已记忆9天，7天后重新记忆。
     */
    public static int stage_five = 5;

    /**
     * 已记住。
     */
    public static int finished = 6;

    public static String getStageLabel(int stage) {
        switch (stage) {
            case -2, -1 -> {
                return "强化记忆";
            }
            case 0 -> {
                return "新卡";
            }
            case 1 -> {
                return "阶段一";
            }
            case 2 -> {
                return "阶段二";
            }
            case 3 -> {
                return "阶段三";
            }
            case 4 -> {
                return "阶段四";
            }
            case 5 -> {
                return "阶段五";
            }
            case 6 -> {
                return "已记住";
            }
            default -> throw new IllegalStateException("Unexpected value: " + stage);
        }
    }
    public static int getStageVal(String stage) {
        switch (stage) {
            case "强化记忆" -> {
                return reinforce1;
            }
            case "新卡" -> {
                return 0;
            }
            case "阶段一" -> {
                return 1;
            }
            case "阶段二" -> {
                return 2;
            }
            case "阶段三" -> {
                return 3;
            }
            case "阶段四" -> {
                return 4;
            }
            case "阶段五" -> {
                return 5;
            }
            case "已记住" -> {
                return 6;
            }
            default -> throw new IllegalStateException("Unexpected value: " + stage);
        }
    }
    public static String getRememberTimeLabel(int stage) {
        switch (stage) {
            case -2 -> {
                return "1分钟后记忆";
            }
            case -1 -> {
                return "10分钟后记忆";
            }
            case 0 -> {
                return "择机抽取";
            }
            case 1, 2 -> {
                return "1天后记忆";
            }
            case 3 -> {
                return "2天后记忆";
            }
            case 4 -> {
                return "4天后记忆";
            }
            case 5 -> {
                return "7天后记忆";
            }
            case 6 -> {
                return "不再记忆";
            }
            default -> throw new IllegalStateException("Unexpected value: " + stage);
        }
    }
}
