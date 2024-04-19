package DAL;
/**
 *
 * @author Thanh Tran
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class ThongKeDALImpl implements ThongKeDAL {
    private Session session;

    public ThongKeDALImpl(Session session) {
        this.session = session;
    }

    //==========================================================================
    
    @Override
    public List<ThongTinSD> getListByThanhVien_TGVao() {
        List<ThongTinSD> list = new ArrayList<>();
        try {
            String hql = "SELECT t.tgVao, COUNT(*) "
                    + "FROM ThongTinSD t "
                    + "GROUP BY t.tgVao";
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            List<Object[]> results = query.getResultList();
            for (Object[] result : results) {
                ThongTinSD ttsd = new ThongTinSD();
                Date tgVao = (Date) result[0];
                if (tgVao != null) {
                    ttsd.setTgVao(tgVao); 
                    ttsd.setSoluong(((Number) result[1]).intValue());
                    list.add(ttsd);
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    
    //==========================================================================
    
    @Override
    public List<ThongTinSD> getListByThanhVien_Khoa() {
        List<ThongTinSD> list = new ArrayList<>();
        try {
            String hql = "SELECT tv.khoa, COUNT(*) "
                    + "FROM ThongTinSD t LEFT JOIN t.thanhVienTTSD tv "
                    + "GROUP BY tv.khoa";
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            List<Object[]> results = query.getResultList();
            for (Object[] result : results) {
                ThongTinSD ttsd = new ThongTinSD();
                if(result[0] != null && result[1] != null)
                {
                    ttsd.setKhoa((String) result[0]); 
                    ttsd.setSoluong(((Number) result[1]).intValue());
                    list.add(ttsd);
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    //==========================================================================
    
    
    @Override
    public List<ThongTinSD> getListByThanhVien_Nganh() {
        List<ThongTinSD> list = new ArrayList<>();
        try {
            String hql = "SELECT tv.nganh, COUNT(*) "
                    + "FROM ThongTinSD t LEFT JOIN t.thanhVienTTSD tv "
                    + "GROUP BY tv.nganh";
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            List<Object[]> results = query.getResultList();
            for (Object[] result : results) {
                ThongTinSD ttsd = new ThongTinSD();
                if(result[0] != null && result[1] != null)
                {
                    ttsd.setNganh((String) result[0]); 
                    ttsd.setSoluong(((Number) result[1]).intValue());
                    list.add(ttsd);
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //==========================================================================
    
    @Override
    public List<ThongTinSD> getListByThietBi_TGMuon() {
        List<ThongTinSD> list = new ArrayList<>();
        try {
            String hql = "SELECT tb.tgMuon, COUNT(*) "
                    + "FROM ThongTinSD tb "
                    + "GROUP BY tb.tgMuon";
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            List<Object[]> results = query.getResultList();
            for (Object[] result : results) {
                ThongTinSD ttsd = new ThongTinSD();
                Date tgMuon = (Date) result[0];
                if (tgMuon != null) {
                    ttsd.setTgMuon(tgMuon); 
                    ttsd.setSoluong(((Number) result[1]).intValue());
                    list.add(ttsd);
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //==========================================================================
    
    @Override
    public List<ThongTinSD> getListByThietBi_TenTB() {
        List<ThongTinSD> list = new ArrayList<>();
        try {
            String hql = "SELECT tb.tenTB, COUNT(*) "
                        + "FROM ThongTinSD t LEFT JOIN t.thietBi tb "
                        + "WHERE tb.tenTB IS NOT NULL "
                        + "GROUP BY tb.tenTB";

            Query<Object[]> query = session.createQuery(hql, Object[].class);
            List<Object[]> results = query.getResultList();
            for (Object[] result : results) {
                ThongTinSD ttsd = new ThongTinSD();
                if(result[0] != null && result[1] != null)
                {
                    ttsd.setTenTB((String) result[0]); 
                    ttsd.setSoluong(((Number) result[1]).intValue());
                    list.add(ttsd);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //==========================================================================
    
    @Override
    public List<XuLy> getListByViPham_DaXyLy() {
        List<XuLy> list = new ArrayList<>();
        try {
            String hql = "SELECT xl.hinhThucXL, COUNT(*) "
                    + "FROM XuLy xl WHERE xl.trangThaiXL = 1 "
                    + "GROUP BY xl.hinhThucXL";
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            List<Object[]> results = query.getResultList();
            for (Object[] result : results) {
                XuLy ttsd = new XuLy();
                if (result[1] != null && result[0] != null) 
                {
                    ttsd.setHinhThucXL((String) result[0]); 
                    ttsd.setSoluong(((Number) result[1]).intValue());
                    list.add(ttsd);
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //==========================================================================
    
    @Override
    public List<XuLy> getListByViPham_DangXyLy() {
        List<XuLy> list = new ArrayList<>();
        try {
            String hql = "SELECT xl.hinhThucXL, COUNT(*) "
                    + "FROM XuLy xl WHERE xl.trangThaiXL = 0 "
                    + "GROUP BY xl.hinhThucXL";
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            List<Object[]> results = query.getResultList();
            for (Object[] result : results) {
                XuLy ttsd = new XuLy();
                if (result[1] != null && result[0] != null) 
                {
                    ttsd.setHinhThucXL((String) result[0]); 
                    ttsd.setSoluong(((Number) result[1]).intValue());
                    list.add(ttsd);
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //==========================================================================
    
    @Override
    public List<XuLy> getListByViPham_Tien() {
        List<XuLy> list = new ArrayList<>();
        try {
            String hql = "SELECT xl.hinhThucXL, SUM(xl.soTien) "
                    + "FROM XuLy xl WHERE xl.trangThaiXL = 1 "
                    + "AND xl.soTien IS NOT NULL "
                    + "GROUP BY xl.hinhThucXL";
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            List<Object[]> results = query.getResultList();
            for (Object[] result : results) {
                XuLy xuLy = new XuLy();            
                if (result[1] != null && result[0] != null) 
                {
                    xuLy.setSoTien(((Number) result[1]).longValue());
                    xuLy.setHinhThucXL((String) result[0]); 
                    list.add(xuLy);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


}
