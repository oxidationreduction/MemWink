package com.MemWink.Data;

/**
 * 用于汇总 {@code DataManager} 的状态返回值
 * @author Liu Hongyu
 * @version 1.0
 */
public class DataManagerStatus {
    public static int NORMAL = 0;
    public static int DAILY_NEW_CARD_NUM_ERR = 1;
    public static int DUPLICATE_CARD_BAG_NAME = 2;
    public static int NO_SUCH_CARD_BAG = 3;
    public static int EMPTY_NAME = 4;
}
