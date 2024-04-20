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
public class ThanhVienDAL {
    Session session;

    public ThanhVienDAL() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public List loadThanhVien() {
        List<ThanhVien> thanhVien;
        session.beginTransaction();
        thanhVien = session.createQuery("FROM ThanhVien", ThanhVien.class).list();
        session.getTransaction().commit();
        return thanhVien;
    }
    
    public ThanhVien getThanhVien(int maTV) {
        ThanhVien tv = session.get(ThanhVien.class, maTV);
        return tv;
    }
    
    public void addThanhVien(ThanhVien tv) {
        session.beginTransaction();
        session.save(tv); 
        session.getTransaction().commit();
        session.close();   
    }
    
    public void updateThanhVien(ThanhVien tv) {
        session.update(tv);
    }
    
    public void deleteThanhVien(ThanhVien tv) {
        session.delete(tv);
    }
     
}
