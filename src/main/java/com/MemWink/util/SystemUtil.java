package com.MemWink.util;

import java.io.File;

/**
 * 获取系统配置信息
 *
 * @author Liu Hongyu
 * @since 2022/05/14.
 */
public class SystemUtil {
    private static final String OS_NAME = System.getProperty("os.name");
    private static final String OS_ARCH = System.getProperty("os.arch");
    private static final String VM_VENDOR = System.getProperty("java.vm.vendor");
    private static final String USER_HOME = System.getProperty("user.home");
    public static final String CONFIG_HOME = "usrData/";

    /**
     * log file dir
     */
    public final static String LOG_DIR = USER_HOME + File.separator + ".MooInfo" + File.separator + "logs" + File.separator;

    public static boolean isMacOs() {
        return OS_NAME.contains("Mac");
    }

    public static boolean isMacM1() {
        return OS_NAME.contains("Mac") && "aarch64".equals(OS_ARCH);
    }

    public static boolean isWindowsOs() {
        return OS_NAME.contains("Windows");
    }

    public static boolean isLinuxOs() {
        return OS_NAME.contains("Linux");
    }

    public static boolean isJBR() {
        return VM_VENDOR.contains("JetBrains");
    }
}