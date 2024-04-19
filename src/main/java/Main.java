
import DAL.ThietBi;
import java.util.List;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nguyen Nhat Vuong
 */
public class Main {
    private static SessionFactory factory;
    public static void main(String[] args) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            System.err.println("Failed to create sessionFactory object." + e);
            throw new ExceptionInInitializerError(e);
        }
        Main m = new Main();
        m.listThietBi();
        //m.addThietBi();
        //m.deleteThietBi();
        m.updateThietBi();
    }
    
    public void listThietBi(){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List thietBi = session.createQuery("FROM ThietBi").list();
            for(Iterator iterator = thietBi.iterator(); iterator.hasNext();){
                ThietBi tb = (ThietBi) iterator.next();
                System.out.println(" MaTB: " + tb.getMaTB());
                System.out.println(" TenTB: " + tb.getTenTB());
                System.out.println(" MoTaTB: " + tb.getMoTaTB());
            }
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx!=null) tx.rollback();
        } finally {
            session.close();
        }
    }
    
    public void addThietBi(){
         Session session = factory.openSession();
         Transaction tx = null;
        try {
            tx = session.beginTransaction();
            ThietBi tb = new ThietBi(1000004, "test", "tttttttt");
            session.save(tb);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx!=null) tx.rollback();
        } finally {
            session.close();
        }
    }
    
    public void deleteThietBi(){
         Session session = factory.openSession();
         Transaction tx = null;
        try {
            tx = session.beginTransaction();
            ThietBi tb = session.get(ThietBi.class, 1000004);
            if(tb!=null){
                 session.delete(tb);
            }
           
           tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx!=null) tx.rollback();
        } finally {
            session.close();
        }
    }
        
     public void updateThietBi(){
         Session session = factory.openSession();
         Transaction tx = null;
        try {
            tx = session.beginTransaction();
            ThietBi tb = session.get(ThietBi.class, 1000004);
            if(tb!=null){
                 tb.setTenTB("test1");
                 session.update(tb);
            }
           
           tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx!=null) tx.rollback();
        } finally {
            session.close();
        }
    }
        
        
}
