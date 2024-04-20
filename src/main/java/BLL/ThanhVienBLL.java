/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.HibernateUtil;
import DAL.ThanhVien;
import DAL.ThanhVienDAL;
import java.util.List;
import org.hibernate.Session;
public class ThanhVienBLL {
      private ThanhVienDAL thanhvienDAL;
      Session session;
    public ThanhVienBLL() {
        thanhvienDAL = new ThanhVienDAL();
         session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public List loadThanhVien() {
        List list;
        list = thanhvienDAL.loadThanhVien();
        
        return list;
    }
    public Object[][] convertList(List<ThanhVien> list) {
        int rows = list.size();
        int cols = 7;
        Object[][] obj = new Object[rows][cols];
        for(int i = 0; i < rows; i++) {
            obj[i][0] = list.get(i).getMaTV();
            obj[i][1] = list.get(i).getHoTen();
            obj[i][2] = list.get(i).getPassword();
            obj[i][3] = list.get(i).getEmail();
            obj[i][4] = list.get(i).getSdt();
            obj[i][5] = list.get(i).getKhoa();
            obj[i][6] = list.get(i).getNganh();
        }
        return obj;
    }
    
    public void createUser(ThanhVien tv) {
        thanhvienDAL.addThanhVien(tv);
    }
    
    public ThanhVien getUser(int matv) {
        ThanhVien tv = thanhvienDAL.getThanhVien(matv);
        return tv;
    }
    public void updateThanhVien(int maTV, ThanhVien updatedThanhVien) {
        thanhvienDAL.updateThanhVien(maTV, updatedThanhVien);
    }
    public boolean deleteThanhVien(int maTV) {
    try {
        thanhvienDAL.deleteThanhVien(maTV);
        return true; // Trả về true nếu xóa thành công
    } catch (Exception e) {
        e.printStackTrace();
        return false; // Trả về false nếu xóa không thành công
    }
}

}