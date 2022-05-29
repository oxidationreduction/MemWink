package com.MemWink.Data.CardBag;

import java.io.Serializable;
import java.util.*;

/**
 * ��Ƭ����С���䵥Ԫ��
 * <p>
 * ÿ�ſ����������棬���������ʾ��Ϣ�����������Ҫ��������ݡ�
 * <p>
 * ��"���ʱ�"Ϊ��������������ķ��룬����������ĵ��ʡ��û�����ʱ���㿪��Ƭ��
 * ���ȿ������ķ��룬֮��������ķ�����뵥�ʣ��ٵ���������������
 * <p>
 *
 * @author Liu Hongyu
 * @version 1.0
 */
public class Card implements Serializable {
    /**
     * �����������
     */
    private String front = "";

    /**
     * �����������
     */
    private String back = "";

    /**
     * ��Ƭ����ʱ�䣬��Ƭ��Ψһ��ʶ�����ֻ��
     */
    private Date createTime = new Date();

    /**
     * �´μ���ʱ��
     * <p>
     * �������׶���"�Ѽ�ס"����һ��û������
     */
    private Date rememberTime;

    /**
     * �Ƿ�Ĭ����ʾ����
     */
    private boolean showFront = true;

    /**
     * ����׶�
     */
    private int memState = MemStateConstants.newCard;

    /**
     * �Ƿ���Ϊ�ղ�
     */
    private boolean starred = false;

    /**
     * ��ʼ����
     */
    public Card() {}
    public Card(String front, String back) {
        this.front = front;
        this.back = back;
        setRememberTime();
    }
    public Card(String front, String back, boolean showFront) {
        this.front = front;
        this.back = back;
        this.showFront = showFront;
        setRememberTime();
    }
    public Card(String front, String back, boolean showFront, int memState) {
        this.front = front;
        this.back = back;
        this.showFront = showFront;
        this.memState = memState;
        setRememberTime();
    }
    public Card(String front, String back, boolean showFront, int memState, boolean starred) {
        this.front = front;
        this.back = back;
        this.showFront = showFront;
        this.memState = memState;
        setRememberTime();
        this.starred = starred;
    }

    /**
     * setter
     * <p> {@code createTime} �� {@code rememberTime} ��ֱֹ������
     */
    public void setFront(String front) {
        this.front = front;
    }
    public void setBack(String back) {
        this.back = back;
    }
    public void setShowFront(boolean showFront) {
        this.showFront = showFront;
    }
    public void setStarred(boolean starred) {
        this.starred = starred;
    }

    /**
     * ���ÿ�Ƭ����׶�
     * <p>������������¿�Ƭ���´μ���ʱ�� {@code rememberTime}
     * @param memState ����׶�
     */
    public void setMemState(int memState) {
        this.memState = memState;
        setRememberTime();
    }

    /**
     * ���ݼ���׶����ÿ�Ƭ�ļ���ʱ��
     * <p>���ڴ�����Ƭ�����޸Ŀ�Ƭ����׶κ���á�
     */
    private void setRememberTime() {
        rememberTime = new Date();
        if (memState == MemStateConstants.newCard) {
            rememberTime = (Date) createTime.clone();
        } else if (memState == MemStateConstants.reinforce1) {
            rememberTime = new Date(new Date().getTime() + 60000);
        } else if (memState == MemStateConstants.reinforce2) {
            rememberTime = new Date(new Date().getTime() + 600000);
        } else if (memState == MemStateConstants.stage_one || memState == MemStateConstants.stage_two) {
            rememberTime.setTime(rememberTime.getTime() + 86400000);
            rememberTime = new Date(rememberTime.getYear(), rememberTime.getMonth(), rememberTime.getDate());
        } else if (memState == MemStateConstants.stage_three) {
            rememberTime.setTime(rememberTime.getTime() + 172800000);
            rememberTime = new Date(rememberTime.getYear(), rememberTime.getMonth(), rememberTime.getDate());
        } else if (memState == MemStateConstants.stage_four) {
            rememberTime.setTime(rememberTime.getTime() + 345600000);
            rememberTime = new Date(rememberTime.getYear(), rememberTime.getMonth(), rememberTime.getDate());
        } else if (memState == MemStateConstants.stage_five) {
            rememberTime.setTime(rememberTime.getTime() + 604800000);
            rememberTime = new Date(rememberTime.getYear(), rememberTime.getMonth(), rememberTime.getDate());
        }
    }

    /**
     * �жϿ�Ƭ�Ƿ���Ҫ��ϰ
     * @return boolean: true������Ҫ��ϰ
     */
    public boolean needReview() {
        return memState != MemStateConstants.finished && new Date().getTime() > rememberTime.getTime();
    }

    /**
     * getter
     */
    public Date getCreateTime() {
        return createTime;
    }
    public Date getRememberTime() {
        return rememberTime;
    }
    public String getFront() {
        return front;
    }
    public String getBack() {
        return back;
    }
    public int getMemState() {
        return memState;
    }
    public boolean isShowFront() {
        return showFront;
    }
    public boolean isStarred() {
        return starred;
    }
}
