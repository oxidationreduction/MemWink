package com.MemWink;

import com.MemWink.Data.CardBag.*;
import com.MemWink.Data.DataManager;
import com.MemWink.util.constant.UIConstant;
import com.MemWink.util.constant.MemStateConstants;

import javax.swing.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
//hello world！
public class Main {
    public static void main0(String[] args){
        DataManager.init();
        DataManager.addCardBag("TEST", UIConstant.blue, 20);
        CardBag test = Objects.requireNonNull(DataManager.provideCardBag("TEST"));

        test.addCard("正面", "背面", true, MemStateConstants.newCard, false, null);
/*
        CardBagPane pane = new CardBagPane();
        pane.setBackground(test.getColor());
        pane.label1.setText(test.getName());
        // pane.setBounds(20, 20, 1000, 700);
        pane.setVisible(true);
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(1440, 810);
        frame.add(pane);
        frame.setVisible(true);
*/
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(1440, 810);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        DataManager.init();
        DataManager.changeCardBagName("TEST", "测试");
        CardBag test = Objects.requireNonNull(DataManager.provideCardBag("测试"));
        // test.addCard("HELLO AGAIN", "MemCard DEBUG", true, MemStateConstants.newCard, false, null);
        /* test.getCardNeedReview().get(0).forget();
        System.out.println(test.getCardNeedReview().get(0));
         */

        System.out.println(test.getName());

        List<CategorizedCard> cards = test.getCardNeedReview();
        System.out.println(new Date());
        for (CategorizedCard i : cards) {
            i.remembered();
            System.out.println(i.getFrontString() + ", " + i.getMemState() + ", belongs to " + i.getCardBagName() + ", Create at " + i.getCreateTime().toString());

            for (MemHistory j : i.getMemHistories()) {
                System.out.println("\t" + j.status + ", " + j.preState + " -> " + j.afterState);
            }
            // i.updateFront("FRONT");
        }
        test.addCard("正面", "背面", true, MemStateConstants.newCard, false, null);
        System.out.println("Total remains: " + DataManager.getTodayRemainCardsNum());
        test.getCardNeedReview().get(0).forget();
        System.out.println("Total: " + DataManager.getTodayReviewCardsNum()
                + ", Remembered: " + DataManager.getTodayRememberedCardsNum()
                + ", Forget: " + DataManager.getTodayForgetCardsNum()
                + ", Forget Rate: " + DataManager.getTodayForgetRate()
        );
    }

    public static void main2(String[] args) {
        DataManager.init();
        DataManager.delCardBag("测试");
    }

    public static void main3(String[] args) {
        DataManager.init();
        DataManager.changeCardBagName("test", "TEST");
    }
}
