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
          
    }
    
    public void updateThanhVien(int maTV, ThanhVien updatedThanhVien) {
    try {
        session.beginTransaction();
        ThanhVien existingThanhVien = session.get(ThanhVien.class, maTV);
        if (existingThanhVien != null) {
            existingThanhVien.setPassword(updatedThanhVien.getPassword());
            existingThanhVien.setHoTen(updatedThanhVien.getHoTen());
            existingThanhVien.setKhoa(updatedThanhVien.getKhoa());
            existingThanhVien.setNganh(updatedThanhVien.getNganh());
            existingThanhVien.setEmail(updatedThanhVien.getEmail());
            existingThanhVien.setSdt(updatedThanhVien.getSdt());
            session.update(existingThanhVien);
            session.getTransaction().commit();
        } else {
            System.out.println("Không tìm thấy thành viên với mã " + maTV);
        }
    } catch (Exception e) {
        if (session.getTransaction() != null) {
            session.getTransaction().rollback();
        }
        e.printStackTrace();
    } finally {
    }
}
    
    public void deleteThanhVien(int maTV) {
    try {
        session.beginTransaction();
        ThanhVien tv = session.get(ThanhVien.class, maTV);
        if (tv != null) {
            session.delete(tv);
        } else {
            // Xử lý trường hợp không tìm thấy đối tượng ThanhVien với mã maTV
            System.out.println("Không tìm thấy đối tượng ThanhVien với mã: " + maTV);
        }
        session.getTransaction().commit();
    } catch (Exception e) {
        if (session.getTransaction() != null && session.getTransaction().isActive()) {
            session.getTransaction().rollback();
        }
        e.printStackTrace();
    }
}
    
}
