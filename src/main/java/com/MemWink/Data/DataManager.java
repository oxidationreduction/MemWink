package com.MemWink.Data;

import com.MemWink.Data.CardBag.*;

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

    public static String savePath = "usrData/";

    /**
     * 构造器
     * <p>采用单例设计模式，因此为 {@code private} 类型</p>
     * <p>初始化时涉及到磁盘I/O</p>
     */
    private DataManager() {
        try {
            FileInputStream fileInputStream = new FileInputStream(DataManager.savePath + "card_bag_name.txt");
            ObjectInputStream tool = new ObjectInputStream(fileInputStream);
            cardBagNames = (List<String>) tool.readObject();
            for (String i : cardBagNames) {
                cardBags.add(CardBag.openCardBag(i));
            }
        } catch (IOException | ClassNotFoundException e) {
            saveCardBagName();
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
                new File( DataManager.savePath+ "" + name).delete();
                cardBagNames.remove(name);
                saveCardBagName();
                return DataManagerStatus.NORMAL;
            }
        }
        return DataManagerStatus.NO_SUCH_CARD_BAG;
    }

    /**
     * 重命名卡包
     * @param oldName 旧名
     * @param newName 新名
     * @return 操作状态，参见 {@link DataManagerStatus}
     */
    public static int changeCardBagName(String oldName, String newName) {
        if (Objects.equals(newName, "")) {
            return DataManagerStatus.NO_SUCH_CARD_BAG;
        }
        for (CardBag i : cardBags) {
            if (Objects.equals(i.getName(), oldName)) {
                i.updateName(newName);
                File oldFile = new File( DataManager.savePath+ "" + oldName);
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
            File file = new File(DataManager.savePath + "card_bag_name.txt");
            if (file.exists()) {
                file.delete();
            }
            ObjectOutputStream tool = new ObjectOutputStream(
                    new FileOutputStream(DataManager.savePath + "card_bag_name.txt"));
            tool.writeObject(cardBagNames);
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
