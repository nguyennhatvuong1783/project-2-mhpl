/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
        session.beginTransaction();
        ThietBi tb = session.get(ThietBi.class, maTB);
        return tb;
    }
    
    public void addThietBi(ThietBi tb) {
        session.beginTransaction();
        session.save(tb); 
        session.getTransaction().commit();
        session.close();
        
    }
    
    public void updateThietBi(ThietBi tb) {
        session.beginTransaction();
        session.update(tb);
        session.getTransaction().commit();
        session.close();
    }
    
    public void deleteThietBi(ThietBi tb) {
        session.delete(tb);
        session.getTransaction().commit();
        
    }
    
    public int getlastMaTB(){
        List<ThietBi> thietbi = loadThietBi();
        int id = thietbi.get(thietbi.size()-1).getMaTB()+1;
        return id; 
    }
    
    public List searchThietBi(String tenTB) {
         session.beginTransaction();
        List<ThietBi> thietBi;
        if(tenTB == null){
            tenTB = "%";
        }else{
            tenTB = "%"+tenTB+"%";
        }
        Query query = session.createQuery("FROM ThietBi WHERE TenTB LIKE : tenTB",ThietBi.class);
        query.setParameter("tenTB", tenTB);
        thietBi = query.list();
        session.getTransaction().commit();
        return thietBi;
    }
}
