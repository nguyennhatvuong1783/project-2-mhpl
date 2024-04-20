/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Nguyen Nhat Vuong
 */
public class MainUI {
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    
    public static JFrame f;
    private JPanel pnlLeftMenu, pnlContent, pnlMenu;
    public JButton btnThanhVien, btnThietBi, btnXuLy, btnThongKe, btnLogOut,btnThongTin;
    private int flag[] = new int[5];
    private CardLayout cardLayout = new CardLayout();

    public MainUI() {
        init();
    }
    
    public void init() {
        f = new JFrame("App quản lý thành viên");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setSize(new Dimension(1024, 600));
        int x = (d.width - f.getSize().width) / 2;
        int y = (d.height - f.getSize().height) / 2 - 25;
        f.setLocation(x, y);

        pnlLeftMenu = LeftMenu();
        pnlContent = new JPanel();
        pnlContent.setLayout(cardLayout);
        pnlContent.add(new JPanel(), "null");
        f.add(pnlLeftMenu, BorderLayout.WEST);
        f.add(pnlContent, BorderLayout.CENTER);

        f.setVisible(true);
    }
    
    private JPanel LeftMenu() {
        JPanel pnlLeftMenu = new JPanel(new BorderLayout());
        pnlLeftMenu.setBackground(new Color(62,78,94));

        JLabel lblLogo = new JLabel("ADMIN", JLabel.CENTER);
        lblLogo.setForeground(new Color(255,255,255));
        lblLogo.setFont(new Font(null, Font.BOLD, 30));
        lblLogo.setPreferredSize(new Dimension(245, 170));

        pnlMenu = new JPanel(new GridLayout(6, 1));
        pnlMenu.setBackground(new Color(62,78,94));

        btnThanhVien = new JButton("Thành viên");
        btnThanhVien.setForeground(new Color(255,255,255));
        btnThanhVien.setFont(new Font(null, Font.BOLD, 15));
        btnThanhVien.setBackground(new Color(62,78,94));
        btnThanhVien.setBorder(new EmptyBorder(0,0,0,0));
        btnThanhVien.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnThanhVien.setOpaque(true);
        btnThanhVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag[0] == 0) {
                    JPanel pnl = new ThanhVienUI();
                    pnlContent.add(pnl, "0");
                    cardLayout.show(pnlContent, "0");
                } else {
                    cardLayout.show(pnlContent, "0");
                }
                switchView(0);
            }
        });
        
        btnThongTin = new JButton("Thông tin sử dụng");
        btnThongTin.setForeground(new Color(255,255,255));
        btnThongTin.setFont(new Font(null, Font.BOLD, 15));
        btnThongTin.setBackground(new Color(62,78,94));
        btnThongTin.setBorder(new EmptyBorder(0,0,0,0));
        btnThongTin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnThongTin.setOpaque(true);
        btnThongTin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag[2] == 0) {
                    JPanel pnl = new ThongTinSuDungUI();
                    pnlContent.add(pnl, "2");
                    cardLayout.show(pnlContent, "2");
                } else {
                    cardLayout.show(pnlContent, "2");
                }
                switchView(2);
            }
        });
        
        btnThietBi = new JButton("Thiết bị");
        btnThietBi.setForeground(new Color(255,255,255));
        btnThietBi.setFont(new Font(null, Font.BOLD, 15));
        btnThietBi.setBackground(new Color(62,78,94));
        btnThietBi.setBorder(new EmptyBorder(0,0,0,0));
        btnThietBi.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnThietBi.setOpaque(true);
        btnThietBi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag[1] == 0) {
                    JPanel pnl = new ThietBiUI();
                    pnlContent.add(pnl, "1");
                    cardLayout.show(pnlContent, "1");
                } else {
                    cardLayout.show(pnlContent, "1");
                }
                switchView(1);
            }
        });

        btnXuLy = new JButton("Xử lý vi phạm");
        btnXuLy.setForeground(new Color(255,255,255));
        btnXuLy.setFont(new Font(null, Font.BOLD, 15));
        btnXuLy.setBackground(new Color(62,78,94));
        btnXuLy.setBorder(new EmptyBorder(0,0,0,0));
        btnXuLy.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnXuLy.setOpaque(true);
        btnXuLy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag[3] == 0) {
                    JPanel pnl = new XuLyUI();
                    pnlContent.add(pnl, "3");
                    cardLayout.show(pnlContent, "3");
                } else {
                    cardLayout.show(pnlContent, "3");
                }
                switchView(3);
            }
        });

        btnThongKe = new JButton("Thống kê");
        btnThongKe.setForeground(new Color(255,255,255));
        btnThongKe.setFont(new Font(null, Font.BOLD, 15));
        btnThongKe.setBackground(new Color(62,78,94));
        btnThongKe.setBorder(new EmptyBorder(0,0,0,0));
        btnThongKe.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnThongKe.setOpaque(true);
        btnThongKe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag[4] == 0) {
                    JPanel pnl = new ThongKeUI();
                    pnlContent.add(pnl, "4");
                    cardLayout.show(pnlContent, "4");
                } else {
                    cardLayout.show(pnlContent, "4");
                }
                switchView(4);
            }
        });
        
        btnLogOut = new JButton("Đăng xuất");
        btnLogOut.setForeground(new Color(255,255,255));
        btnLogOut.setFont(new Font(null, Font.BOLD, 15));
        btnLogOut.setBackground(new Color(62,78,94));
        btnLogOut.setBorder(new EmptyBorder(0,0,0,0));
        btnLogOut.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogOut.setOpaque(true);
        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        pnlMenu.add(btnThanhVien);
        pnlMenu.add(btnThietBi);
        pnlMenu.add(btnThongTin);
        pnlMenu.add(btnXuLy);
        pnlMenu.add(btnThongKe);
        pnlMenu.add(btnLogOut);


        pnlLeftMenu.add(lblLogo, BorderLayout.NORTH);
        pnlLeftMenu.add(pnlMenu, BorderLayout.CENTER);

        return pnlLeftMenu;
    }
    
    public void switchView(int i) {
        JButton[] btnList = {this.btnThanhVien, this.btnThietBi,this.btnThongTin, this.btnXuLy, this.btnThongKe};
        for(int j = 0; j < 5; j++) {
            if(flag[j] == 2) {
                flag[j] = 1;
                btnList[j].setBackground(new Color(62, 78, 94));
                break;
            }
        }        

        flag[i] = 2;
        btnList[i].setBackground(new Color(184, 207, 229));
    }
}
