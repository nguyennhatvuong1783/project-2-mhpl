/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Nguyen Nhat Vuong
 */
public class ThongTinSDDAL {
    Session session;

    public ThongTinSDDAL() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public static void main(String[] args) {
    }
    
    public List loadThongTinSD() {
        List<ThongTinSD> thongTinSD;
        session.beginTransaction();
        thongTinSD = session.createQuery("FROM ThongTinSD", ThongTinSD.class).list();
        session.getTransaction().commit();
        return thongTinSD;
    }
    
    public ThongTinSD getThongTinSD(int maTT) {
        ThongTinSD ttsd = session.get(ThongTinSD.class, maTT);
        return ttsd;
    }
    
    public void addThongTinSD(ThongTinSD ttsd) {
        session.save(ttsd);   
    }
    
    public void updateThongTinSD(ThongTinSD ttsd) {
        session.update(ttsd);
    }
    
    public void deleteThongTinSD(ThongTinSD ttsd) {
        session.delete(ttsd);
    }

}
