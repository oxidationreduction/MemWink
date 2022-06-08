/*
 * Created by JFormDesigner on Mon May 23 14:27:14 CST 2022
 */

package com.MemWink.UI.panel;

import com.MemWink.Data.DataManager;
import com.MemWink.UI.component.Graph;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * 数据展示主页面
 * <p>所有用户的相关数据会被展示到该页面上</p>
 * @author Feng Weilun
 */
public class ShowStatics extends JPanel {
    /**
     * 构造器
     * <p>因此面板不涉及用户动作监听故可被直接构造</p>
     * <p>每次构造时都会根据数据中心的最新数据来进行页面绘制</p>
     */
    public ShowStatics() {
        initComponents();
        beautifyUI();
        TodayRememberedCardsNum.setText(Integer.toString(DataManager.getTodayRememberedCardsNum()));
        TodayRemainCardsNum.setText(Integer.toString(DataManager.getTodayRemainCardsNum()));
        TodayForgetRate.setText(String.format("%.2f",DataManager.getTodayForgetRate()*100));
        TomorrowNum.setText(Integer.toString(DataManager.getTomorrowCardsNum()));
        int x1 = DataManager.getRememberedCardsNumHistory().get(DataManager.getRememberedCardsNumHistory().size()-1) -DataManager.getRememberedCardsNumHistory().get(DataManager.getRememberedCardsNumHistory().size()-2);
        if(x1<0) {
            Map1num.setText(Integer.toString(x1));
        }
        else {
            Map1num.setText("+"+ x1);
        }
        double x2 = DataManager.getForgetCardsNumHistory().get(DataManager.getForgetCardsNumHistory().size()-1) - DataManager.getForgetCardsNumHistory().get(DataManager.getForgetCardsNumHistory().size()-2);
        x2 = x2*100;
        if(x2<0) {
            Map2num.setText(String.format("%.2f",x2)+"%");
        }
        else {
            Map2num.setText("+"+String.format("%.2f",x2)+"%");
        }
        Map1.add(new Graph(0,300,300,DataManager.getRememberedCardsNumHistory()));
        Map2.add(new Graph(1,300,300,DataManager.getForgetCardsNumHistory()));
    }

    /**
     * 美化UI
     * @author Liu Hongyu
     * @since 2022-06-08
     */
    private void beautifyUI() {
        label1.setFont(new Font("微软雅黑", Font.PLAIN, 60));
        label8.setFont(new Font("微软雅黑", Font.PLAIN, 55));
        label11.setFont(new Font("微软雅黑", Font.PLAIN, 55));
        label14.setFont(new Font("微软雅黑", Font.PLAIN, 55));
        label17.setFont(new Font("微软雅黑", Font.PLAIN, 55));

        label25.setFont(new Font("微软雅黑", Font.PLAIN, 55));
        label26.setFont(new Font("微软雅黑", Font.PLAIN, 55));
        label27.setFont(new Font("微软雅黑", Font.PLAIN, 55));
        label28.setFont(new Font("微软雅黑", Font.PLAIN, 55));

        TodayRememberedCardsNum.setFont(new Font("微软雅黑", Font.PLAIN, 100));
        TodayRemainCardsNum.setFont(new Font("微软雅黑", Font.PLAIN, 100));
        TodayForgetRate.setFont(new Font("微软雅黑", Font.PLAIN, 100));
        TomorrowNum.setFont(new Font("微软雅黑", Font.PLAIN, 100));

        label19.setText("学习卡片数趋势");
        label22.setText("复习遗忘率趋势");
    }

    /**
     * 初始化数据页面
     * <p>在相应jfd文件中绘制好后由插件自动生成代码</p>
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Sun Yihan
        panel1 = new JPanel();
        label1 = new JLabel();
        vSpacer3 = new JPanel(null);
        panel10 = new JPanel();
        panel11 = new JPanel();
        vSpacer8 = new JPanel(null);
        vSpacer9 = new JPanel(null);
        panel38 = new JPanel();
        panel13 = new JPanel();
        panel18 = new JPanel();
        vSpacer6 = new JPanel(null);
        hSpacer3 = new JPanel(null);
        label25 = new JLabel();
        panel19 = new JPanel();
        vSpacer7 = new JPanel(null);
        vSpacer10 = new JPanel(null);
        panel20 = new JPanel();
        label8 = new JLabel();
        TodayRememberedCardsNum = new JLabel();
        panel14 = new JPanel();
        panel21 = new JPanel();
        vSpacer11 = new JPanel(null);
        hSpacer4 = new JPanel(null);
        label26 = new JLabel();
        panel22 = new JPanel();
        vSpacer12 = new JPanel(null);
        vSpacer13 = new JPanel(null);
        panel23 = new JPanel();
        label11 = new JLabel();
        TodayRemainCardsNum = new JLabel();
        panel15 = new JPanel();
        panel24 = new JPanel();
        vSpacer14 = new JPanel(null);
        hSpacer5 = new JPanel(null);
        label27 = new JLabel();
        panel25 = new JPanel();
        vSpacer15 = new JPanel(null);
        vSpacer16 = new JPanel(null);
        panel26 = new JPanel();
        label14 = new JLabel();
        TodayForgetRate = new JLabel();
        panel16 = new JPanel();
        panel27 = new JPanel();
        vSpacer17 = new JPanel(null);
        hSpacer6 = new JPanel(null);
        label28 = new JLabel();
        panel28 = new JPanel();
        vSpacer18 = new JPanel(null);
        vSpacer19 = new JPanel(null);
        panel29 = new JPanel();
        label17 = new JLabel();
        TomorrowNum = new JLabel();
        panel12 = new JPanel();
        panel30 = new JPanel();
        panel32 = new JPanel();
        panel33 = new JPanel();
        label19 = new JLabel();
        panel34 = new JPanel();
        label20 = new JLabel();
        Map1num = new JLabel();
        Map1 = new JPanel();
        panel31 = new JPanel();
        panel35 = new JPanel();
        panel36 = new JPanel();
        label22 = new JLabel();
        panel37 = new JPanel();
        label23 = new JLabel();
        Map2num = new JLabel();
        Map2 = new JPanel();
        hSpacer1 = new JPanel(null);
        hSpacer2 = new JPanel(null);

        //======== this ========
        setPreferredSize(new Dimension(775, 559));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
        ( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing. border
        . TitledBorder. BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
        propertyChange (java .beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

            //---- label1 ----
            label1.setText("\u7edf\u8ba1");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 14f));
            panel1.add(label1);
        }
        add(panel1, BorderLayout.NORTH);

        //---- vSpacer3 ----
        vSpacer3.setPreferredSize(new Dimension(10, 50));
        add(vSpacer3, BorderLayout.SOUTH);

        //======== panel10 ========
        {
            panel10.setLayout(new GridLayout(2, 1));

            //======== panel11 ========
            {
                panel11.setLayout(new BorderLayout());

                //---- vSpacer8 ----
                vSpacer8.setPreferredSize(new Dimension(10, 30));
                panel11.add(vSpacer8, BorderLayout.NORTH);

                //---- vSpacer9 ----
                vSpacer9.setPreferredSize(new Dimension(10, 50));
                panel11.add(vSpacer9, BorderLayout.SOUTH);

                //======== panel38 ========
                {
                    panel38.setLayout(new GridLayout(1, 4, 20, 0));

                    //======== panel13 ========
                    {
                        panel13.setBorder(new EtchedBorder(Color.lightGray, Color.gray));
                        panel13.setLayout(new BorderLayout());

                        //======== panel18 ========
                        {
                            panel18.setLayout(new BorderLayout());

                            //---- vSpacer6 ----
                            vSpacer6.setPreferredSize(new Dimension(10, 30));
                            panel18.add(vSpacer6, BorderLayout.SOUTH);

                            //---- hSpacer3 ----
                            hSpacer3.setPreferredSize(new Dimension(11, 10));
                            panel18.add(hSpacer3, BorderLayout.EAST);

                            //---- label25 ----
                            label25.setText("\u5f20");
                            label25.setVerticalAlignment(SwingConstants.BOTTOM);
                            label25.setFont(label25.getFont().deriveFont(label25.getFont().getSize() + 13f));
                            panel18.add(label25, BorderLayout.CENTER);
                        }
                        panel13.add(panel18, BorderLayout.EAST);

                        //======== panel19 ========
                        {
                            panel19.setLayout(new BorderLayout());
                            panel19.add(vSpacer7, BorderLayout.SOUTH);
                            panel19.add(vSpacer10, BorderLayout.NORTH);

                            //======== panel20 ========
                            {
                                panel20.setLayout(new GridLayout(2, 1));

                                //---- label8 ----
                                label8.setText("\u4eca\u65e5\u5df2\u5b66");
                                label8.setHorizontalAlignment(SwingConstants.CENTER);
                                label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 12f));
                                panel20.add(label8);

                                //---- TodayRememberedCardsNum ----
                                TodayRememberedCardsNum.setText("0");
                                TodayRememberedCardsNum.setHorizontalAlignment(SwingConstants.CENTER);
                                TodayRememberedCardsNum.setFont(TodayRememberedCardsNum.getFont().deriveFont(TodayRememberedCardsNum.getFont().getSize() + 20f));
                                panel20.add(TodayRememberedCardsNum);
                            }
                            panel19.add(panel20, BorderLayout.CENTER);
                        }
                        panel13.add(panel19, BorderLayout.CENTER);
                    }
                    panel38.add(panel13);

                    //======== panel14 ========
                    {
                        panel14.setBorder(new EtchedBorder(Color.lightGray, Color.gray));
                        panel14.setLayout(new BorderLayout());

                        //======== panel21 ========
                        {
                            panel21.setLayout(new BorderLayout());

                            //---- vSpacer11 ----
                            vSpacer11.setPreferredSize(new Dimension(10, 30));
                            panel21.add(vSpacer11, BorderLayout.SOUTH);

                            //---- hSpacer4 ----
                            hSpacer4.setPreferredSize(new Dimension(11, 10));
                            panel21.add(hSpacer4, BorderLayout.EAST);

                            //---- label26 ----
                            label26.setText("\u5f20");
                            label26.setVerticalAlignment(SwingConstants.BOTTOM);
                            label26.setFont(label26.getFont().deriveFont(label26.getFont().getSize() + 13f));
                            panel21.add(label26, BorderLayout.CENTER);
                        }
                        panel14.add(panel21, BorderLayout.EAST);

                        //======== panel22 ========
                        {
                            panel22.setLayout(new BorderLayout());
                            panel22.add(vSpacer12, BorderLayout.SOUTH);
                            panel22.add(vSpacer13, BorderLayout.NORTH);

                            //======== panel23 ========
                            {
                                panel23.setLayout(new GridLayout(2, 1));

                                //---- label11 ----
                                label11.setText("\u4eca\u65e5\u5f85\u5b66");
                                label11.setHorizontalAlignment(SwingConstants.CENTER);
                                label11.setFont(label11.getFont().deriveFont(label11.getFont().getSize() + 12f));
                                panel23.add(label11);

                                //---- TodayRemainCardsNum ----
                                TodayRemainCardsNum.setText("0");
                                TodayRemainCardsNum.setHorizontalAlignment(SwingConstants.CENTER);
                                TodayRemainCardsNum.setFont(TodayRemainCardsNum.getFont().deriveFont(TodayRemainCardsNum.getFont().getSize() + 20f));
                                panel23.add(TodayRemainCardsNum);
                            }
                            panel22.add(panel23, BorderLayout.CENTER);
                        }
                        panel14.add(panel22, BorderLayout.CENTER);
                    }
                    panel38.add(panel14);

                    //======== panel15 ========
                    {
                        panel15.setBorder(new EtchedBorder(Color.lightGray, Color.gray));
                        panel15.setLayout(new BorderLayout());

                        //======== panel24 ========
                        {
                            panel24.setLayout(new BorderLayout());

                            //---- vSpacer14 ----
                            vSpacer14.setPreferredSize(new Dimension(10, 30));
                            panel24.add(vSpacer14, BorderLayout.SOUTH);

                            //---- hSpacer5 ----
                            hSpacer5.setPreferredSize(new Dimension(11, 10));
                            panel24.add(hSpacer5, BorderLayout.EAST);

                            //---- label27 ----
                            label27.setText("%");
                            label27.setVerticalAlignment(SwingConstants.BOTTOM);
                            label27.setFont(label27.getFont().deriveFont(label27.getFont().getSize() + 13f));
                            panel24.add(label27, BorderLayout.CENTER);
                        }
                        panel15.add(panel24, BorderLayout.EAST);

                        //======== panel25 ========
                        {
                            panel25.setLayout(new BorderLayout());
                            panel25.add(vSpacer15, BorderLayout.SOUTH);
                            panel25.add(vSpacer16, BorderLayout.NORTH);

                            //======== panel26 ========
                            {
                                panel26.setLayout(new GridLayout(2, 1));

                                //---- label14 ----
                                label14.setText("\u590d\u4e60\u9057\u5fd8\u7387");
                                label14.setHorizontalAlignment(SwingConstants.CENTER);
                                label14.setFont(label14.getFont().deriveFont(label14.getFont().getSize() + 12f));
                                panel26.add(label14);

                                //---- TodayForgetRate ----
                                TodayForgetRate.setText("0");
                                TodayForgetRate.setHorizontalAlignment(SwingConstants.CENTER);
                                TodayForgetRate.setFont(TodayForgetRate.getFont().deriveFont(TodayForgetRate.getFont().getSize() + 20f));
                                panel26.add(TodayForgetRate);
                            }
                            panel25.add(panel26, BorderLayout.CENTER);
                        }
                        panel15.add(panel25, BorderLayout.CENTER);
                    }
                    panel38.add(panel15);

                    //======== panel16 ========
                    {
                        panel16.setBorder(new EtchedBorder(Color.lightGray, Color.gray));
                        panel16.setLayout(new BorderLayout());

                        //======== panel27 ========
                        {
                            panel27.setLayout(new BorderLayout());

                            //---- vSpacer17 ----
                            vSpacer17.setPreferredSize(new Dimension(10, 30));
                            panel27.add(vSpacer17, BorderLayout.SOUTH);

                            //---- hSpacer6 ----
                            hSpacer6.setPreferredSize(new Dimension(11, 10));
                            panel27.add(hSpacer6, BorderLayout.EAST);

                            //---- label28 ----
                            label28.setText("\u5f20");
                            label28.setVerticalAlignment(SwingConstants.BOTTOM);
                            label28.setFont(label28.getFont().deriveFont(label28.getFont().getSize() + 13f));
                            panel27.add(label28, BorderLayout.CENTER);
                        }
                        panel16.add(panel27, BorderLayout.EAST);

                        //======== panel28 ========
                        {
                            panel28.setLayout(new BorderLayout());
                            panel28.add(vSpacer18, BorderLayout.SOUTH);
                            panel28.add(vSpacer19, BorderLayout.NORTH);

                            //======== panel29 ========
                            {
                                panel29.setLayout(new GridLayout(2, 1));

                                //---- label17 ----
                                label17.setText("\u660e\u5929\u9884\u8ba1");
                                label17.setHorizontalAlignment(SwingConstants.CENTER);
                                label17.setFont(label17.getFont().deriveFont(label17.getFont().getSize() + 12f));
                                panel29.add(label17);

                                //---- TomorrowNum ----
                                TomorrowNum.setText("0");
                                TomorrowNum.setHorizontalAlignment(SwingConstants.CENTER);
                                TomorrowNum.setFont(TomorrowNum.getFont().deriveFont(TomorrowNum.getFont().getSize() + 20f));
                                panel29.add(TomorrowNum);
                            }
                            panel28.add(panel29, BorderLayout.CENTER);
                        }
                        panel16.add(panel28, BorderLayout.CENTER);
                    }
                    panel38.add(panel16);
                }
                panel11.add(panel38, BorderLayout.CENTER);
            }
            panel10.add(panel11);

            //======== panel12 ========
            {
                panel12.setLayout(new GridLayout(1, 2, 30, 0));

                //======== panel30 ========
                {
                    panel30.setBorder(new EtchedBorder(Color.lightGray, Color.gray));
                    panel30.setLayout(new BorderLayout());

                    //======== panel32 ========
                    {
                        panel32.setLayout(new GridLayout(1, 2));

                        //======== panel33 ========
                        {
                            panel33.setLayout(new FlowLayout(FlowLayout.LEFT));

                            //---- label19 ----
                            label19.setText("\u5b66\u4e60\u5361\u7247\u6570");
                            label19.setFont(label19.getFont().deriveFont(label19.getFont().getSize() + 10f));
                            panel33.add(label19);
                        }
                        panel32.add(panel33);

                        //======== panel34 ========
                        {
                            panel34.setLayout(new FlowLayout(FlowLayout.RIGHT));

                            //---- label20 ----
                            label20.setText("\u6bd4\u6628\u5929");
                            label20.setFont(label20.getFont().deriveFont(label20.getFont().getSize() + 5f));
                            label20.setVerticalAlignment(SwingConstants.BOTTOM);
                            panel34.add(label20);

                            //---- Map1num ----
                            Map1num.setText("+0");
                            Map1num.setFont(Map1num.getFont().deriveFont(Map1num.getFont().getSize() + 5f));
                            Map1num.setVerticalAlignment(SwingConstants.BOTTOM);
                            panel34.add(Map1num);
                        }
                        panel32.add(panel34);
                    }
                    panel30.add(panel32, BorderLayout.NORTH);

                    //======== Map1 ========
                    {
                        Map1.setLayout(new GridLayout(1, 1));
                    }
                    panel30.add(Map1, BorderLayout.CENTER);
                }
                panel12.add(panel30);

                //======== panel31 ========
                {
                    panel31.setBorder(new EtchedBorder(Color.lightGray, Color.gray));
                    panel31.setLayout(new BorderLayout());

                    //======== panel35 ========
                    {
                        panel35.setLayout(new GridLayout(1, 2));

                        //======== panel36 ========
                        {
                            panel36.setLayout(new FlowLayout(FlowLayout.LEFT));

                            //---- label22 ----
                            label22.setText("\u590d\u4e60\u9057\u5fd8\u7387");
                            label22.setFont(label22.getFont().deriveFont(label22.getFont().getSize() + 10f));
                            panel36.add(label22);
                        }
                        panel35.add(panel36);

                        //======== panel37 ========
                        {
                            panel37.setLayout(new FlowLayout(FlowLayout.RIGHT));

                            //---- label23 ----
                            label23.setText("\u6bd4\u6628\u5929");
                            label23.setFont(label23.getFont().deriveFont(label23.getFont().getSize() + 5f));
                            label23.setVerticalAlignment(SwingConstants.BOTTOM);
                            panel37.add(label23);

                            //---- Map2num ----
                            Map2num.setText("+0%");
                            Map2num.setFont(Map2num.getFont().deriveFont(Map2num.getFont().getSize() + 5f));
                            Map2num.setVerticalAlignment(SwingConstants.BOTTOM);
                            panel37.add(Map2num);
                        }
                        panel35.add(panel37);
                    }
                    panel31.add(panel35, BorderLayout.NORTH);

                    //======== Map2 ========
                    {
                        Map2.setLayout(new GridLayout(1, 1));
                    }
                    panel31.add(Map2, BorderLayout.CENTER);
                }
                panel12.add(panel31);
            }
            panel10.add(panel12);
        }
        add(panel10, BorderLayout.CENTER);

        //---- hSpacer1 ----
        hSpacer1.setPreferredSize(new Dimension(20, 10));
        add(hSpacer1, BorderLayout.WEST);

        //---- hSpacer2 ----
        hSpacer2.setPreferredSize(new Dimension(20, 10));
        add(hSpacer2, BorderLayout.EAST);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Sun Yihan
    private JPanel panel1;
    private JLabel label1;
    private JPanel vSpacer3;
    private JPanel panel10;
    private JPanel panel11;
    private JPanel vSpacer8;
    private JPanel vSpacer9;
    private JPanel panel38;
    private JPanel panel13;
    private JPanel panel18;
    private JPanel vSpacer6;
    private JPanel hSpacer3;
    private JLabel label25;
    private JPanel panel19;
    private JPanel vSpacer7;
    private JPanel vSpacer10;
    private JPanel panel20;
    private JLabel label8;
    private JLabel TodayRememberedCardsNum;
    private JPanel panel14;
    private JPanel panel21;
    private JPanel vSpacer11;
    private JPanel hSpacer4;
    private JLabel label26;
    private JPanel panel22;
    private JPanel vSpacer12;
    private JPanel vSpacer13;
    private JPanel panel23;
    private JLabel label11;
    private JLabel TodayRemainCardsNum;
    private JPanel panel15;
    private JPanel panel24;
    private JPanel vSpacer14;
    private JPanel hSpacer5;
    private JLabel label27;
    private JPanel panel25;
    private JPanel vSpacer15;
    private JPanel vSpacer16;
    private JPanel panel26;
    private JLabel label14;
    private JLabel TodayForgetRate;
    private JPanel panel16;
    private JPanel panel27;
    private JPanel vSpacer17;
    private JPanel hSpacer6;
    private JLabel label28;
    private JPanel panel28;
    private JPanel vSpacer18;
    private JPanel vSpacer19;
    private JPanel panel29;
    private JLabel label17;
    private JLabel TomorrowNum;
    private JPanel panel12;
    private JPanel panel30;
    private JPanel panel32;
    private JPanel panel33;
    private JLabel label19;
    private JPanel panel34;
    private JLabel label20;
    private JLabel Map1num;
    private JPanel Map1;
    private JPanel panel31;
    private JPanel panel35;
    private JPanel panel36;
    private JLabel label22;
    private JPanel panel37;
    private JLabel label23;
    private JLabel Map2num;
    private JPanel Map2;
    private JPanel hSpacer1;
    private JPanel hSpacer2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
