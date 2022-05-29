package com.MemWink.Data;

import java.util.Date;

public class Util {
    public static String date2String(Date date) {
        return (date.getYear() + 1900) + "年" + date.getMonth() + "月" + date.getDate() + "日"
                + " " + date.getHours() + ":" + date.getMinutes();
    }
}
