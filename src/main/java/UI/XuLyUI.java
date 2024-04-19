/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import BLL.XuLyBLL;
import javax.swing.JPanel;

/**
 *
 * @author Nguyen Nhat Vuong
 */
public class XuLyUI extends JPanel{
    private XuLyBLL xuLyBLL;

    public XuLyUI() {
        xuLyBLL = new XuLyBLL();
        initComponents();
    }
    
    public void initComponents() {
    }

}
