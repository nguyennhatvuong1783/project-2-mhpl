/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import BLL.ThanhVienBLL;
import javax.swing.JPanel;

/**
 *
 * @author Nguyen Nhat Vuong
 */
public class ThanhVienUI extends JPanel{
    private ThanhVienBLL thanhVienBLL;

    public ThanhVienUI() {
        thanhVienBLL = new ThanhVienBLL();
        initComponents();
    }
    
    public void initComponents() {
    }
}
