package BLL;

import DAL.ThietBi;
import DAL.ThietBiDAL;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nguyen Nhat Vuong
 */
public class ThietBiBLL {
    private ThietBiDAL thietBiDAL;
    
    public ThietBiBLL() {
        thietBiDAL = new ThietBiDAL();
    }
    
    public List loadThietBi() {
        List list;
        list = thietBiDAL.loadThietBi();
        
        return list;
    }

    public Object[][] convertList(List<ThietBi> list) {
        int rows = list.size();
        int cols = 3;
        Object[][] obj = new Object[rows][cols];
        for(int i = 0; i < rows; i++) {
            obj[i][0] = list.get(i).getMaTB();
            obj[i][1] = list.get(i).getTenTB();
            obj[i][2] = list.get(i).getMoTaTB();
        }
        return obj;
    }
    
    public void createCategory(ThietBi tb) {
        thietBiDAL.addThietBi(tb);
    }
    
    public ThietBi getCategory(int maTB) {
        ThietBi tb = thietBiDAL.getThietBi(maTB);
        return tb;
    }

}
