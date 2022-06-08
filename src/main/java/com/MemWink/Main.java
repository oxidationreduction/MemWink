package com.MemWink;

import com.MemWink.Data.DataManager;
import com.MemWink.UI.UIManager;
public class Main {
    public static void main(String[] args) {
        DataManager.init();
        UIManager.init();
    }
}
