/*
 * Created by JFormDesigner on Mon Jun 06 16:43:50 CST 2022
 */

package com.MemWink.UI.dialog;

import com.MemWink.Data.CardBag.CardBag;

import java.awt.*;
import java.io.File;
import java.util.Locale;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author unknown
 */
public class FileChoose extends JDialog {
    public FileChoose(CardBag cardBag) {
        initComponents();
        this.cardBag = cardBag;
        JFileChooser jFileChooser = new JFileChooser();
        this.add(jFileChooser,BorderLayout.CENTER);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("csv","csv");
        jFileChooser.setFileFilter(filter);
        int flag = jFileChooser.showOpenDialog(null);
        if(flag == JFileChooser.APPROVE_OPTION){
            String address = jFileChooser.getSelectedFile().getPath();
            File file = new File(address);
            cardBag.importCSV(file);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    private CardBag cardBag;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
