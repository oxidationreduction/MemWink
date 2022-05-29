package com.MemWink.Data;

import com.MemWink.Data.CardBag.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 * ��������
 * <p>�������п��������������I/O�����������ɴ˻�ȡ</p>
 * @author Liu Hongyu
 * @version 1.0
 */
public class DataManager {
    /**
     * ���п���
     */
    private static List<CardBag> cardBags = new ArrayList<>();

    /**
     * ���п���������
     * <p>��������������</p>
     */
    private static List<String> cardBagNames = new ArrayList<>();

    /**
     * ������
     * <p>���õ������ģʽ�����Ϊ {@code private} ����</p>
     * <p>��ʼ��ʱ�漰������I/O</p>
     */
    private DataManager() {
        try {
            FileInputStream fileInputStream = new FileInputStream("App/dataBank/card_bag_name.txt");
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
     * ��ʼ����������
     */
    public static void init() {
        new DataManager();
    }

    /**
     * ��ȡ���п���
     * @return �����б�
     */
    public static List<CardBag> getCardBags() {
        return cardBags;
    }

    /**
     * ����¿���
     * @param name ������
     * @param color ��ɫ
     * @param dailyNewCardNum ÿ���¿�����
     * @return ����״̬���μ� {@link DataManagerStatus}
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
     * ɾ������
     * @param name ������
     * @return ����״̬���μ� {@link DataManagerStatus}
     */
    public static int delCardBag(String name) {
        for (CardBag i : cardBags) {
            if (Objects.equals(i.getName(), name)) {
                cardBags.remove(i);
                new File("App/dataBank/" + name).delete();
                cardBagNames.remove(name);
                saveCardBagName();
                return DataManagerStatus.NORMAL;
            }
        }
        return DataManagerStatus.NO_SUCH_CARD_BAG;
    }

    /**
     * ����������
     * @param oldName ����
     * @param newName ����
     * @return ����״̬���μ� {@link DataManagerStatus}
     */
    public static int changeCardBagName(String oldName, String newName) {
        if (Objects.equals(newName, "")) {
            return DataManagerStatus.NO_SUCH_CARD_BAG;
        }
        for (CardBag i : cardBags) {
            if (Objects.equals(i.getName(), oldName)) {
                i.setName(newName);
                File oldFile = new File("App/dataBank/" + oldName);
                File newFile = new File("App/dataBank/" + newName);
                if (oldFile.exists()) {
                    if (!oldFile.renameTo(newFile)) {
                        throw new RuntimeException("Rename Failed.");
                    }
                }
                return DataManagerStatus.NORMAL;
            }
        }
        return DataManagerStatus.NO_SUCH_CARD_BAG;
    }

    /**
     * ��ȡָ���Ŀ���
     * @param name ������
     * @return ����Ŀ�����δ�ҵ�ʱ���� {@code null}
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
     * �洢����
     * @param cardBag Ҫ�洢�Ŀ���
     * @return ����״̬���μ� {@link DataManagerStatus}
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
     * ���濨�������б� {@code cardBagNames} ���ļ���
     * @return �Ƿ񱣴�ɹ�
     */
    public static boolean saveCardBagName() {
        try {
            File file = new File("App/dataBank/card_bag_name.txt");
            if (file.exists()) {
                file.delete();
            }
            ObjectOutputStream tool = new ObjectOutputStream(
                    new FileOutputStream("App/dataBank/card_bag_name.txt"));
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
