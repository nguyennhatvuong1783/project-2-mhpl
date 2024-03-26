/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import BLL.ThietBiBLL;
import javax.swing.JPanel;

/**
 *
 * @author Nguyen Nhat Vuong
 */
public class ThongKeUI extends JPanel{
    private ThietBiBLL thietBiBLL;

    public ThongKeUI() {
        thietBiBLL = new ThietBiBLL();
        initComponents();
    }
    
    public void initComponents() {
    }
}
