package com.MemWink.Data;

import com.MemWink.Data.CardBag.Card;
import com.MemWink.Data.CardBag.*;
import com.MemWink.Data.CardBag.MemStateConstants;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DataManager {
    public static void main(String[] args) {
        CardBag testBag = new CardBag("test bag", Color.CYAN, 1);
        testBag.addCard("1 Front", "1 Back", true, MemStateConstants.newCard, false, "");
        testBag.addCard("2 Front", "2 Back", true, MemStateConstants.newCard, false, "");
        testBag.addCard("3 Front", "3 Back", true, MemStateConstants.reinforce1, false, "");
        testBag.addCard("4 Front", "4 Back", true, MemStateConstants.stage_one, false, "");

        Timer timer = new Timer();
        final int[] time = {0};
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                List<CategorizedCard> cards = testBag.getCardNeedReview();
                int time = 0;
                while (time < 7) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.print(new Date().toString() + "-> 1 : ");
                    for (CategorizedCard i : cards) {
                        System.out.print(i.getFront() + ", ");
                    }
                    System.out.println();
                    time++;
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                cards = testBag.getCardNeedReview();
                CategorizedCard newCard = cards.get(0);
                newCard.setMemState(MemStateConstants.reinforce1);
                testBag.updateCard(newCard);

                time = 0;
                while (time < 10) {
                    cards = testBag.getCardNeedReview();
                    System.out.print(new Date().toString() + "-> 2 : ");
                    for (CategorizedCard i : cards) {
                        System.out.print(i.getFront() + ", ");
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println();
                    time++;
                }
                Thread.currentThread().stop();
            }
        }, 0);
    }
}
