/*
 * Created by JFormDesigner on Sat May 28 16:54:13 CST 2022
 */

package com.MemWink.UI.panel;

import com.MemWink.Data.CardBag.CardBag;
import com.MemWink.Data.CardBag.CategorizedCard;
import com.MemWink.Data.DataManager;
import com.MemWink.UI.UIManager;
import com.MemWink.UI.dialog.*;
import com.MemWink.util.MemWinkUtil;
import com.MemWink.util.constant.MemStateConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.DimensionUIResource;

import static com.MemWink.UI.UIManager.cardBag;


/**
 * @author unknown
 */
public class ShowAllCards extends JPanel {
    public ShowAllCards(CardBag cardBag,CardBagPane cardBagPane) {
        cardBag1=cardBag;
        this.cardBagPane=cardBagPane;
        UIManager.showAllCards=this;
        UIManager.cardBag =cardBag1;
        initComponents();
        init2();

        panel5.setVisible(true);
        label1.setText(cardBag1.getName());

        //右上角阶段分类
        StagenCount stagenCount1 = new StagenCount("全部",cardBag1.getCards());
        StagenCount stagenCount2 = new StagenCount("新卡",cardBag1.getNewCards());
        StagenCount stagenCount3 = new StagenCount("记忆中",cardBag1.getCardsLearning());
        StagenCount stagenCount4 = new StagenCount("已记住",cardBag1.getCardFinished());
        stagenCount1.setLabel5("全部",30,30);
        stagenCount2.setLabel5("新卡",30,30);
        stagenCount3.setLabel5("学习中",30,30);
        stagenCount4.setLabel5("已完成",30,30);
        this.panel6.add(stagenCount1);
        this.panel6.add(stagenCount2);
        this.panel6.add(stagenCount3);
        this.panel6.add(stagenCount4);
        //右下角自我分类
        for(String name:cardBag1.getCategories()){
            SortPane sortPane;
            if (name == null || name.equals("")) {
                sortPane = new SortPane("未分类", cardBag1.getCardsByCategory("未分类"));
            } else {
                sortPane = new SortPane(name, cardBag1.getCardsByCategory(name));
            }
            panel8.add(sortPane);
        }
        //待复习button
        if(cardBag1.getReviewCardsNum()>0){
            button3.setVisible(true);
            button3.setText("待复习："+String.valueOf(cardBag1.getReviewCardsNum()));
            button3.addActionListener(e -> button3(e));
        }
        //初始化卡片panel1
        this.showcard(cardBag1.getCards());
        panel1.setPreferredSize(new Dimension(20,getrightheight(UIManager.mainFrame.mainPanel.getSize(),cardBag1.getCards().size())));

        beautifyUI();
        UIManager.showAllCards = this;
    }

    private void beautifyUI() {
        // TODO: Make panel wider.
        label1.setFont(new Font("微软雅黑", Font.PLAIN, 45));
        label3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        button1.setSize(button1.getHeight(), button1.getHeight());
    }

    //panel1高度求解
    public int getrightheight(Dimension dimension , int cardnum){
        Double width = dimension.getWidth()-60;
        Double height = dimension.getHeight();
        //a为每行的卡片数
        double a =Math.floor(width/175);
        //b为总卡片数
        double b =cardnum;
        //c为理论卡片行数
        double c =Math.ceil(b/a) + 1;

        int rightheight =(int) c*185;

        return rightheight;
    }

    //更新卡片页面，需要list数据
    public void showcard(List<CategorizedCard> list){
        this.panel1.removeAll();
        for(CategorizedCard card:list){
            this.panel1.add(new CardPane(card,cardBag1.getColor()));
        }
        panel1.setPreferredSize(new Dimension(20,getrightheight(UIManager.mainFrame.mainPanel.getSize(),cardBag1.getCards().size())+1));
        this.panel1.updateUI();
    }

    public JLabel gettable1(){
        return label1;
    }
    //新建卡片事件
    private void menuItem1(ActionEvent e) {
        CategorizedCard newcard = new CategorizedCard("请输入","请输入",true, MemStateConstants.newCard,true,null, cardBag.getName());
        EditCardDialog editCardDialog = new EditCardDialog(newcard,this);
        editCardDialog.setVisible(true);
        editCardDialog.setBounds(400,180,100,100);
    }

    private void button1(ActionEvent e) {
        popupMenu1.show(button1,-95,0);
    }

    private void button2(ActionEvent e) {
        popupMenu2.show(button2,-75,0);
    }

    public void init2(){
        button1.setIcon(MemWinkUtil.getScaledIcon("设置",30,30));
    }

    private void button3(ActionEvent e) {
        ReviewManager reviewManager = new ReviewManager(cardBag);
        UIManager.mainFrame.mainPanel.removeAll();;
        UIManager.mainFrame.mainPanel.add(reviewManager);
        UIManager.mainFrame.mainPanel.updateUI();
    }

    private void menuItem4(ActionEvent e) {
        cardBag.updateSortLogic(0);
        this.showcard(cardBag.getCards());
    }

    private void menuItem8(ActionEvent e) {
        cardBag.updateSortLogic(1);
        this.showcard(cardBag.getCards());
    }

    private void menuItem9(ActionEvent e) {
        cardBag.updateSortLogic(2);
        this.showcard(cardBag.getCards());
    }
    //删除卡包
    private void menuItem7(ActionEvent e) {
        /*
        DataManager.delCardBag(label1.getText());
        UIManager.mainFrame.mainPanel.removeAll();
        UIManager.mainFrame.mainPanel.add(ShowCardBags.getShowCardBags());
        UIManager.mainFrame.mainPanel.updateUI();
        */
        makesure2 makesure2 = new makesure2();
        makesure2.setVisible(true);
        makesure2.setBounds(700,300,100,80);
    }
    //清除卡包内容
    private void menuItem6(ActionEvent e) {
        /*
        UIManager.cardBag.removeAllCards();
        this.showcard(UIManager.cardBag.getCards());
         */
        makesure1 makesure1 = new makesure1(this);
        makesure1.setVisible(true);
        makesure1.setBounds(700,300,100,80);
    }

    private void menuItem3(ActionEvent e) {
        ModifyDialog modifyDialog = new ModifyDialog(cardBagPane);
        modifyDialog.setVisible(true);
    }

    private void menuItem2(ActionEvent e) {
        /*
        FileChoose fileChoose = new FileChoose(cardBag1);
        fileChoose.setVisible(true);
        fileChoose.setBounds(400,200,600,400);

         */
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("csv","csv");
        chooser.setFileFilter(filter);
        int flag = chooser.showOpenDialog(null);
        if(flag == JFileChooser.APPROVE_OPTION){
            String address = chooser.getSelectedFile().getPath();
            File file = new File(address);
            cardBag1.importCSV(file);
            UIManager.mainFrame.mainPanel.removeAll();
            UIManager.mainFrame.mainPanel.add(new ShowAllCards(cardBag1, cardBagPane));
            UIManager.mainFrame.mainPanel.updateUI();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        popupMenu1 = new JPopupMenu();
        menuItem3 = new JMenuItem();
        menu1 = new JMenu();
        menuItem4 = new JMenuItem();
        menuItem8 = new JMenuItem();
        menuItem9 = new JMenuItem();
        menuItem6 = new JMenuItem();
        menuItem7 = new JMenuItem();
        popupMenu2 = new JPopupMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        panel3 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();
        label3 = new JLabel();
        scrollPane2 = new JScrollPane();
        panel8 = new JPanel();
        panel4 = new JPanel();
        label1 = new JLabel();
        button1 = new JButton();
        panel5 = new JPanel();
        button2 = new JButton();
        button3 = new JButton();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        panel1 = new JPanel();

        //======== popupMenu1 ========
        {

            //---- menuItem3 ----
            menuItem3.setText("\u5361\u5305\u8bbe\u7f6e");
            menuItem3.addActionListener(e -> menuItem3(e));
            popupMenu1.add(menuItem3);

            //======== menu1 ========
            {
                menu1.setText("\u6392\u5e8f\u65b9\u5f0f");

                //---- menuItem4 ----
                menuItem4.setText("\u521b\u5efa\u65f6\u95f4");
                menuItem4.addActionListener(e -> menuItem4(e));
                menu1.add(menuItem4);

                //---- menuItem8 ----
                menuItem8.setText("\u6b63\u9762\u5185\u5bb9");
                menuItem8.addActionListener(e -> menuItem8(e));
                menu1.add(menuItem8);

                //---- menuItem9 ----
                menuItem9.setText("\u8bb0\u5fc6\u9636\u6bb5");
                menuItem9.addActionListener(e -> menuItem9(e));
                menu1.add(menuItem9);
            }
            popupMenu1.add(menu1);

            //---- menuItem6 ----
            menuItem6.setText("\u6e05\u9664\u5361\u5305\u5185\u5bb9");
            menuItem6.addActionListener(e -> menuItem6(e));
            popupMenu1.add(menuItem6);

            //---- menuItem7 ----
            menuItem7.setText("\u5220\u9664\u5361\u5305");
            menuItem7.addActionListener(e -> menuItem7(e));
            popupMenu1.add(menuItem7);
        }

        //======== popupMenu2 ========
        {

            //---- menuItem1 ----
            menuItem1.setText("\u65b0\u5efa\u5361\u7247");
            menuItem1.addActionListener(e -> menuItem1(e));
            popupMenu2.add(menuItem1);

            //---- menuItem2 ----
            menuItem2.setText("\u5bfc\u5165csv");
            menuItem2.addActionListener(e -> menuItem2(e));
            popupMenu2.add(menuItem2);
        }

        //======== this ========
        setLayout(new BorderLayout());

        //======== panel3 ========
        {
            panel3.setLayout(new BorderLayout());

            //======== panel6 ========
            {
                panel6.setLayout(new GridLayout(2, 2, 18, 18));
            }
            panel3.add(panel6, BorderLayout.PAGE_START);

            //======== panel7 ========
            {
                panel7.setLayout(new BorderLayout());

                //---- label3 ----
                label3.setText("\u5206\u7c7b");
                label3.setHorizontalTextPosition(SwingConstants.RIGHT);
                label3.setHorizontalAlignment(SwingConstants.RIGHT);
                panel7.add(label3, BorderLayout.PAGE_START);

                //======== scrollPane2 ========
                {

                    //======== panel8 ========
                    {
                        panel8.setPreferredSize(new Dimension(40, 10));
                        panel8.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
                    }
                    scrollPane2.setViewportView(panel8);
                }
                panel7.add(scrollPane2, BorderLayout.CENTER);
            }
            panel3.add(panel7, BorderLayout.CENTER);
        }
        add(panel3, BorderLayout.LINE_END);

        //======== panel4 ========
        {
            panel4.setLayout(new BorderLayout());

            //---- label1 ----
            label1.setText("\u5361\u5305\u540d");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 14f));
            panel4.add(label1, BorderLayout.WEST);

            //---- button1 ----
            button1.setPreferredSize(new Dimension(45, 45));
            button1.addActionListener(e -> button1(e));
            panel4.add(button1, BorderLayout.EAST);
        }
        add(panel4, BorderLayout.PAGE_START);

        //======== panel5 ========
        {
            panel5.setLayout(new BorderLayout());

            //---- button2 ----
            button2.setText("+");
            button2.setPreferredSize(new Dimension(45, 45));
            button2.addActionListener(e -> button2(e));
            panel5.add(button2, BorderLayout.EAST);

            //---- button3 ----
            button3.setText("text");
            button3.setVisible(false);
            button3.addActionListener(e -> button3(e));
            panel5.add(button3, BorderLayout.CENTER);
        }
        add(panel5, BorderLayout.PAGE_END);

        //======== panel2 ========
        {
            panel2.setLayout(new BorderLayout());

            //======== scrollPane1 ========
            {
                scrollPane1.setPreferredSize(new Dimension(20, 120));

                //======== panel1 ========
                {
                    panel1.setBorder(null);
                    panel1.setMaximumSize(new Dimension(16, 16));
                    panel1.setPreferredSize(new Dimension(20, 100));
                    panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
                }
                scrollPane1.setViewportView(panel1);
            }
            panel2.add(scrollPane1, BorderLayout.CENTER);
        }
        add(panel2, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    public CardBagPane cardBagPane;
    public CardBag cardBag1;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPopupMenu popupMenu1;
    private JMenuItem menuItem3;
    private JMenu menu1;
    private JMenuItem menuItem4;
    private JMenuItem menuItem8;
    private JMenuItem menuItem9;
    private JMenuItem menuItem6;
    private JMenuItem menuItem7;
    private JPopupMenu popupMenu2;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JPanel panel3;
    private JPanel panel6;
    private JPanel panel7;
    private JLabel label3;
    private JScrollPane scrollPane2;
    private JPanel panel8;
    private JPanel panel4;
    private JLabel label1;
    private JButton button1;
    private JPanel panel5;
    private JButton button2;
    private JButton button3;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    public JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
