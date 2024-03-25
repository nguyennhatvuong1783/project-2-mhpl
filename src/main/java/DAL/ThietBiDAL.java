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
    
    public static void main(String[] args) {
    }
    
    public List readDepartment() {
        List<ThietBi> thietBi;
        session.beginTransaction();
        thietBi = session.createQuery("FROM Department", ThietBi.class).list();
        session.getTransaction().commit();
        return thietBi;
    }
    
    public ThietBi getCategory(int maTB) {
        ThietBi d = session.get(ThietBi.class, maTB);
        return d;
    }
    
    public void createDepartment(ThietBi tb) {
        session.save(tb);   
    }
    
    public void updateDepartment(ThietBi tb) {
        session.update(tb);
    }
    
    public void deleteDepartment(ThietBi tb) {
        session.delete(tb);
    }
}
