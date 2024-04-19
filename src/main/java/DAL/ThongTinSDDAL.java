/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Nguyen Nhat Vuong
 */
public class ThongTinSDDAL {
    Session session;

    public ThongTinSDDAL() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
 
    
    public List loadThongTinSD() {
        List<ThongTinSD> thongTinSD;
        session.beginTransaction();
        thongTinSD = session.createQuery("FROM ThongTinSD", ThongTinSD.class).list();
        session.getTransaction().commit();
        return thongTinSD;
    }
    
    public ThongTinSD getThongTinSD(int MaTT) {
        ThongTinSD ttsd = session.get(ThongTinSD.class, MaTT);
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
public TTSD getTTSDByMaTV(int maTV) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        TTSD thongTinSD = null;
        
        try {
            transaction = session.beginTransaction();
            String hql = "FROM TTSD WHERE maTV = :maTV";
            Query query = session.createQuery(hql);
            query.setParameter("maTV", maTV);
            thongTinSD = (TTSD) query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return thongTinSD;
    }
}
