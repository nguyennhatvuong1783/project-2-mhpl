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
public class ThietBiDAL {
    Session session;

    public ThietBiDAL() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
  
    public List loadThietBi() {
        List<ThietBi> thietBi;
        session.beginTransaction();
        thietBi = session.createQuery("FROM ThietBi", ThietBi.class).list();
        session.getTransaction().commit();
        return thietBi;
    }
    
    public ThietBi getThietBi(int maTB) {
        ThietBi tb = session.get(ThietBi.class, maTB);
        return tb;
    }
    
    public void addThietBi(ThietBi tb) {
        session.save(tb);   
    }
    
    public void updateThietBi(ThietBi tb) {
        session.update(tb);
    }
    
    public void deleteThietBi(ThietBi tb) {
        session.delete(tb);
    }
}
