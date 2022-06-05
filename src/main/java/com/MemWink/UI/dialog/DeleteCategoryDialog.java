package com.MemWink.UI.dialog;

import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.Data.CardBag.CategorizedCard;
import com.MemWink.Data.DataManager;
import com.MemWink.UI.panel.CardContent;
import com.MemWink.util.constant.DataManagerStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class DeleteCategoryDialog extends JDialog {
    private CardBag cardBag;
    private JPanel panel;
    public DeleteCategoryDialog(CardBag cardBag, JPanel panel) {
        this.cardBag = cardBag;
        this.panel = panel;
        setup();
    }

    private void setup() {
        setSize(300, 425);
        setLayout(null);
        setLocation(
                (panel.getWidth() >> 1) - 150,
                (panel.getHeight() >> 1) - 200
        );

        // mainPanel
        {
            mainPanel = new JPanel();
            mainPanel.setSize(300, 420);
            mainPanel.setLocation(0, 0);
            mainPanel.setLayout(null);
            add(mainPanel);
        }

        // deleteLabel
        {
            deleteLabel = new JLabel("删除分类");
            deleteLabel.setFont(new Font("微软雅黑", Font.PLAIN, 24));
            deleteLabel.setSize(100, 30);
            deleteLabel.setLocation(5, 5);
            mainPanel.add(deleteLabel);
        }

        // scrollPane
        {
            scrollPane = new JScrollPane();
            scrollPane.setSize(280, 320);
            scrollPane.setLayout(null);
            scrollPane.setLocation(10, 40);

            // categoryList
            {
                int index = 0;
                for (String i : cardBag.getCategories()) {
                    JCheckBox item = new JCheckBox(i);
                    item.setSize(280, 25);
                    item.setFont(new Font("微软雅黑", Font.PLAIN, 20));
                    item.setLocation(0, index * 25);
                    scrollPane.add(item);
                    categoryItems.add(item);
                    index++;
                }
            }
            mainPanel.add(scrollPane);
        }

        // confirmButton
        {
            confirmButton = new JButton("删除");
            confirmButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
            confirmButton.setSize(80, 35);
            confirmButton.setLocation(210, 360);
            confirmButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (JCheckBox i : categoryItems) {
                        if (i.isSelected()) {
                            cardBag.delCategory(i.getText());
                            if (panel instanceof CardContent) {
                                ((CardContent) panel).categoryMenuUpdate();
                            }
                        }
                    }
                    DeleteCategoryDialog.this.dispose();
                }
            });
            // confirmButton.setEnabled(true);
            mainPanel.add(confirmButton);
        }

        add(mainPanel);
        setVisible(true);
    }

    private JLabel deleteLabel;
    private JScrollPane scrollPane;
    private JPanel mainPanel;
    private JButton confirmButton;
    private Set<JCheckBox> categoryItems = new HashSet<>();
}
