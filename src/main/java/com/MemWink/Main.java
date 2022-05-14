package com.MemWink;

import cn.hutool.setting.Setting;
import com.MemWink.Data.CardBag.*;
import com.MemWink.Data.DataManager;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args){
        DataManager.init();
        DataManager.addCardBag("TEST", Color.CYAN, 20);
        CardBag test = Objects.requireNonNull(DataManager.provideCardBag("TEST"));
        test.addCard("正面", "背面", true, MemStateConstants.newCard, false, null);



        DataManager.changeCardBagName("TEST", "测试");

        List<CategorizedCard> cards = test.getCardNeedReview();
        System.out.println(new Date());
        for (CategorizedCard i : cards) {
            System.out.println(i.getFront() + ", belongs to " + i.getCardBagName() + ", Create at " + cards.get(0).getCreateTime().toString());
            i.updateFront("FRONT");
        }
    }

    public static void main1(String[] args) {
        DataManager.init();
        CardBag test = Objects.requireNonNull(DataManager.provideCardBag("测试"));
        // test.addCard("HELLO AGAIN", "MemCard DEBUG", true, MemStateConstants.newCard, false, null);
        /* test.getCardNeedReview().get(0).forget();
        System.out.println(test.getCardNeedReview().get(0));
         */

        System.out.println(test.getName());

        List<CategorizedCard> cards = test.getCards();// test.getCardNeedReview();
        System.out.println(new Date());
        for (CategorizedCard i : cards) {
            i.remembered();
            System.out.println(i.getFront() + ", " + i.getMemState() + ", belongs to " + i.getCardBagName() + ", Create at " + i.getCreateTime().toString());

            for (MemHistory j : i.getMemHistories()) {
                System.out.println("\t" + j.status + ", " + j.preState + " -> " + j.afterState);
            }
            // i.updateFront("FRONT");
        }
    }

    public static void main2(String[] args) {
        DataManager.init();
        DataManager.delCardBag("测试");
    }
}
