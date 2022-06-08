package com.MemWink.SwingLearn;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileSelector {
    public static void main(String[] args) {
        //第一步
        JFileChooser jfchooser = new JFileChooser();
//第二步
        FileNameExtensionFilter filter = new FileNameExtensionFilter("png","jpg");
        jfchooser.setFileFilter(filter);
//第三步
        int option = jfchooser.showOpenDialog(null);
        if( option == JFileChooser.APPROVE_OPTION) {       //说明选定了一个文件
            String address = jfchooser.getSelectedFile().getPath();//把文件地址取出给adress变量
			/*
		    buffimg = imageUtils.getImage(adress);
			imgarr = imageUtils.getImageArray(buffimg);
			imageUtils.drawImage(buffimg, gr);
            */
            System.out.println(address);
        }
    }
}
