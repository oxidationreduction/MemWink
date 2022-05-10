package com.MemWink;

import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.Data.CardBag.CategorizedCard;
import com.MemWink.Data.CardBag.MemStateConstants;
import com.MemWink.Data.DataManager;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        DataManager.init();
        DataManager.addCardBag("测试", Color.CYAN, 20);
        DataManager.provideCardBag("测试").addCard("正面", "背面", true, MemStateConstants.newCard, false, null);
        CardBag test = Objects.requireNonNull(DataManager.provideCardBag("测试"));
        List<CategorizedCard> cards = test.getCardNeedReview();
        System.out.println(new Date());
        for (CategorizedCard i : cards) {
            System.out.println(i.getFront() + ", Create at " + cards.get(0).getCreateTime().toString());
        }
        DataManager.delCardBag("测试");
    }
}
