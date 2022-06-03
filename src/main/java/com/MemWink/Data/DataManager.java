package com.MemWink.Data;

import com.MemWink.Data.CardBag.*;
import com.MemWink.Data.History.Usage;
import com.MemWink.util.constant.DataManagerStatus;
import com.MemWink.util.constant.SystemUtil;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 数据中心
 * <p>管理所有卡包，并负责磁盘I/O，所有数据由此获取</p>
 * @author Liu Hongyu
 * @version 1.0
 */
public class DataManager {
    /**
     * 所有卡包
     */
    private static List<CardBag> cardBags = new ArrayList<>();

    /**
     * 所有卡包的名字
     * <p>卡包不允许重名</p>
     */
    private static List<String> cardBagNames = new ArrayList<>();

    /**
     * 记忆历史记录
     */
    private static Usage usage = new Usage();

    /**
     * 卡包文件夹路径
     */
    public static String cardBagSavePath = SystemUtil.CONFIG_HOME + "cardbags/";

    /**
     * 历史记录文件夹路径
     */
    public static String historySavePath = SystemUtil.CONFIG_HOME + "history/history";

    /**
     * 构造器
     * <p>采用单例设计模式，因此为 {@code private} 类型</p>
     * <p>初始化时涉及到磁盘I/O</p>
     */
    private DataManager() {
        // 读取卡包名列表，再按名字读取卡包
        try {
            FileInputStream fileInputStream = new FileInputStream(cardBagSavePath + "card_bag_name.txt");
            ObjectInputStream tool = new ObjectInputStream(fileInputStream);
            cardBagNames = (List<String>) tool.readObject();
            for (String i : cardBagNames) {
                cardBags.add(CardBag.openCardBag(i));
            }
        } catch (IOException | ClassNotFoundException e) {
            saveCardBagName();
        }

        // 读取记忆历史记录
        try {
            FileInputStream fileInputStream = new FileInputStream(historySavePath);
            ObjectInputStream tool = new ObjectInputStream(fileInputStream);
            usage = (Usage) tool.readObject();
        } catch (IOException | ClassNotFoundException e) {
            saveUsage();
        }
    }

    /**
     * 初始化数据中心
     */
    public static void init() {
        new DataManager();
    }

    /**
     * 获取所有卡包
     * @return 卡包列表
     */
    public static List<CardBag> getCardBags() {
        return cardBags;
    }

    /**
     * 添加新卡包
     * @param name 卡包名
     * @param color 颜色
     * @param dailyNewCardNum 每日新卡数量
     * @return 操作状态，参见 {@link DataManagerStatus}
     */
    public static int addCardBag(String name, Color color, int dailyNewCardNum) {
        if (dailyNewCardNum < 1) {
            return DataManagerStatus.DAILY_NEW_CARD_NUM_ERR;
        }
        for (CardBag i : cardBags) {
            if (Objects.equals(i.getName(), name)) {
                return DataManagerStatus.DUPLICATE_CARD_BAG_NAME;
            }
        }
        CardBag newCardBag = new CardBag(name, color, dailyNewCardNum);
        cardBags.add(newCardBag);
        cardBagNames.add(name);
        if (CardBag.saveCardBag(newCardBag)) {
            saveCardBagName();
        } else {
            throw new RuntimeException("Card Bag Save Failed.");
        }

        return DataManagerStatus.NORMAL;
    }

    /**
     * 删除卡包
     * @param name 卡包名
     * @return 操作状态，参见 {@link DataManagerStatus}
     */
    public static int delCardBag(String name) {
        for (CardBag i : cardBags) {
            if (Objects.equals(i.getName(), name)) {
                cardBags.remove(i);
                new File( DataManager.cardBagSavePath + "" + name).delete();
                cardBagNames.remove(name);
                saveCardBagName();
                return DataManagerStatus.NORMAL;
            }
        }
        return DataManagerStatus.NO_SUCH_CARD_BAG;
    }

    /**
     * 用于Card与CardBag建立连接，使进行记忆操作后更新已经当日已经复习的新卡的数量，禁止调用
     * @param cardBagName 卡包名
     */
    public static void rememberNewCard(String cardBagName) {
        for (CardBag i : cardBags) {
            if (Objects.equals(i.getName(), cardBagName)) {
                i.rememberNewCard();
                return;
            }
        }
        throw new RuntimeException("Invalid card bag name: " + cardBagName);
    }

    /**
     * 重命名卡包
     * @param oldName 旧名
     * @param newName 新名
     * @return 操作状态，参见 {@link DataManagerStatus}
     */
    public static int changeCardBagName(String oldName, String newName) {
        if (Objects.equals(newName, "")) {
            return DataManagerStatus.EMPTY_NAME;
        }
        for (CardBag i : cardBags) {
            if (Objects.equals(i.getName(), oldName)) {
                i.updateName(newName);
                File oldFile = new File( DataManager.cardBagSavePath + "" + oldName);
                if (oldFile.delete()) {
                    saveCardBag(i);
                } else {
                    throw new RuntimeException("Invalid card bag name: " + oldName);
                }

                cardBagNames.set(cardBagNames.indexOf(oldName), newName);
                saveCardBagName();

                return DataManagerStatus.NORMAL;
            }
        }
        return DataManagerStatus.NO_SUCH_CARD_BAG;
    }

    /**
     * 更新卡包的颜色
     * @param name 卡包名
     * @param color 新颜色
     */
    public static void updateColor(String name, Color color) {
        Objects.requireNonNull(DataManager.provideCardBag(name)).updateColor(color);
    }

    public static void updateName(String oldName, String newName) {
        Objects.requireNonNull(DataManager.provideCardBag(oldName)).updateName(newName);
    }

    public static void updateDailyNewCardNum(String name, int num) {
        Objects.requireNonNull(DataManager.provideCardBag(name)).updateDailyNewCardNum(num);
    }
    /**
     * 获取指定的卡包
     * @param name 卡包名
     * @return 所需的卡包，未找到时返回 {@code null}
     */
    public static CardBag provideCardBag(String name) {
        for (CardBag i : cardBags) {
            if (Objects.equals(i.getName(), name)) {
                return i;
            }
        }
        return null;
    }

    /**
     * 获取今天进行的记忆操作数量
     * @return 本日记忆操作数量
     */
    public static int getTodayReviewCardsNum() {
        List<Integer> tmp = usage.getReviewCardsNumHistory();
        return  tmp.get(tmp.size()-1);
    }

    /**
     * 获取今天"已记住"操作的数量
     * @return "已记住"操作数量
     */
    public static int getTodayRememberedCardsNum() {
        List<Integer> tmp = usage.getRememberedCardsNumHistory();
        return  tmp.get(tmp.size()-1);
    }
    /**
     * 获取今天"没记住"操作的数量
     * @return "没记住"操作数量
     */
    public static int getTodayForgetCardsNum() {
        List<Integer> tmp = usage.getForgetCardsNumHistory();
        return  tmp.get(tmp.size()-1);
    }
    /**
     * 获取今天的遗忘率
     * @return 本日遗忘率
     */
    public static double getTodayForgetRate() {
        List<Double> tmp = usage.getForgetRateHistory();
        return tmp.get(tmp.size()-1);
    }
    /**
     * 获取今天还需记忆的卡片的数量
     * @return 本日剩余卡片数量
     */
    public static int getTodayRemainCardsNum() {
        int ans = 0;
        for (CardBag i : cardBags) {
            ans += i.getReviewCardsNum();
        }
        return ans;
    }

    /**
     * 和全局记忆历史记录 ({@code usage}) 中的数据列表有关的 getter
     * <p>主要在实现折线图时使用</p>
     */
    public static List<Integer> getReviewCardsNumHistory() {
        return usage.getReviewCardsNumHistory();
    }
    public static List<Integer> getRememberedCardsNumHistory() {
        return usage.getRememberedCardsNumHistory();
    }
    public static List<Integer> getForgetCardsNumHistory() {
        return usage.getForgetCardsNumHistory();
    }

    /**
     * 用户操作"已记住"后，更新并存储历史数据
     */
    public static void addRememberedCardsNumHistory() {
        usage.addRememberedCardsNumHistory();
        saveUsage();
    }

    /**
     * 用户操作"没记住"后，更新并存储历史数据
     */
    public static void addForgetCardsNumHistory() {
        usage.addForgetCardsNumHistory();
        saveUsage();
    }

    /**
     * 存储卡包
     * @param cardBag 要存储的卡包
     * @return 操作状态，参见 {@link DataManagerStatus}
     */
    public static int saveCardBag(CardBag cardBag) {
        int cardBagNum = cardBags.size();
        for (int i = 0; i < cardBagNum; i++) {
            if (Objects.equals(cardBags.get(i).getId(), cardBag.getId())) {
                cardBags.set(i, cardBag);
                CardBag.saveCardBag(cardBag);
                return DataManagerStatus.NORMAL;
            }
        }
        return DataManagerStatus.NO_SUCH_CARD_BAG;
    }

    /**
     * 保存卡包名称列表 {@code cardBagNames} 到文件。
     * @return 是否保存成功
     */
    public static boolean saveCardBagName() {
        try {
            File file = new File(DataManager.cardBagSavePath + "card_bag_name.txt");
            if (file.exists()) {
                file.delete();
            }
            ObjectOutputStream tool = new ObjectOutputStream(
                    new FileOutputStream(DataManager.cardBagSavePath + "card_bag_name.txt"));
            tool.writeObject(cardBagNames);
            tool.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * 存储全局记忆历史记录 ({@code usage})
     * @return 是否保存成功
     */
    public static boolean saveUsage() {
        try {
            File file = new File(historySavePath);
            if (file.exists()) {
                file.delete();
            }
            ObjectOutputStream tool = new ObjectOutputStream(
                    new FileOutputStream(historySavePath)
            );
            tool.writeObject(usage);
            tool.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * getter
     */
    public static List<String> getCardBagNames() {
        return cardBagNames;
    }
}
