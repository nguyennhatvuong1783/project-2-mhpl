/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;
import DAL.HibernateUtil;
import DAL.TTSD;
import DAL.ThongTinSDDAL;
import DAL.ThongTinSD;
import java.util.List;
import org.hibernate.Session;
public class ThongTinSDBLL {
    private ThongTinSDDAL thongtinsdDAL;
    private TTSD ttsd;
    public ThongTinSDBLL(){
    thongtinsdDAL= new ThongTinSDDAL();
    ttsd=new TTSD();
    }
    public List loadThongTin(){
        List list;
        list = thongtinsdDAL.loadThongTinSD();
        
        return list;
    }
    public ThongTinSD getUser(int MaTT) {
        ThongTinSD tt=thongtinsdDAL.getThongTinSD(MaTT);
        return tt;
    }
     public TTSD getTTSDByMaTV(int maTV) {
        return thongtinsdDAL.getTTSDByMaTV(maTV);
    }
     public Object[][] convertList(List<TTSD> list) {
        int rows = list.size();
        int cols = 7;
        Object[][] obj = new Object[rows][cols];
        for(int i = 0; i < rows; i++) {
            obj[i][0] = list.get(i).getMaTT();
            obj[i][1] = list.get(i).getMaTV();
            obj[i][2] = list.get(i).getMaTB();
            obj[i][3] = list.get(i).getTgDatcho();
            obj[i][4] = list.get(i).getTgVao();
            obj[i][5] = list.get(i).getTgMuon();
            obj[i][6] = list.get(i).getTgTra();
        }
        return obj;
    }
     public List loadTTSD(){
        List list;
        list = thongtinsdDAL.loadTTSD();
        return list;
    }
}
