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
}
