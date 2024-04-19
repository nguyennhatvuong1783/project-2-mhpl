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
public class XuLyDAL {
    Session session;

    public XuLyDAL() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
  
    
    public List loadXuLy() {
        List<XuLy> xuLy;
        session.beginTransaction();
        xuLy = session.createQuery("FROM XuLy", XuLy.class).list();
        session.getTransaction().commit();
        return xuLy;
    }
    
    public XuLy getXuLy(int maXL) {
        XuLy xl = session.get(XuLy.class, maXL);
        return xl;
    }
    
    public void addXuLy(XuLy xl) {
        session.save(xl);   
    }
    
    public void updateXuLy(XuLy xl) {
        session.update(xl);
    }
    
    public void deleteXuLy(XuLy xl) {
        session.delete(xl);
    }
    
}
