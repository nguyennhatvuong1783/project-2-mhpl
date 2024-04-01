package DAL;
/**
 *
 * @author Tran Duc Thanh
 * MSSV 3121410451
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

    @Override
    public List<ThongTinSD> getListByThanhVien_TGVao() {
        List<ThongTinSD> list = new ArrayList<>();
        try {
            String hql = "SELECT t.tgVao, COUNT(*) FROM ThongTinSD t GROUP BY t.tgVao";
                Query<Object[]> query = session.createQuery(hql, Object[].class);
                List<Object[]> results = query.getResultList();
                for (Object[] result : results) {
                    ThongTinSD ttsd = new ThongTinSD();
                    ttsd.setTgVao((Date) result[0]); 
                    ttsd.setSoluong(((Number) result[1]).intValue());
                    list.add(ttsd);
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    @Override
    public List<ThongTinSD> getListByThanhVien_Khoa() {
        List<ThongTinSD> list = new ArrayList<>();
        try {
            String hql = "SELECT tv.khoa, COUNT(*) FROM ThongTinSD t LEFT JOIN t.thanhVienTTSD tv GROUP BY tv.khoa";
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            List<Object[]> results = query.getResultList();
            for (Object[] result : results) {
                ThongTinSD ttsd = new ThongTinSD();
                ttsd.setKhoa((String) result[0]); 
                ttsd.setSoluong(((Number) result[1]).intValue());
                list.add(ttsd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    
    @Override
    public List<ThongTinSD> getListByThanhVien_Nganh() {
        List<ThongTinSD> list = new ArrayList<>();
        try {
            String hql = "SELECT tv.nganh, COUNT(*) FROM ThongTinSD t LEFT JOIN t.thanhVienTTSD tv GROUP BY tv.nganh";
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            List<Object[]> results = query.getResultList();
            for (Object[] result : results) {
                ThongTinSD ttsd = new ThongTinSD();
                ttsd.setNganh((String) result[0]); 
                ttsd.setSoluong(((Number) result[1]).intValue());
                list.add(ttsd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ThongTinSD> getListByThietBi_TGMuon() {
        List<ThongTinSD> list = new ArrayList<>();
        try {
            String hql = "SELECT tb.tgMuon, COUNT(*) FROM ThongTinSD tb GROUP BY tb.tgMuon";
                Query<Object[]> query = session.createQuery(hql, Object[].class);
                List<Object[]> results = query.getResultList();
                for (Object[] result : results) {
                    ThongTinSD ttsd = new ThongTinSD();
                    ttsd.setTgMuon((Date) result[0]); 
                    ttsd.setSoluong(((Number) result[1]).intValue());
                    list.add(ttsd);
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ThongTinSD> getListByThietBi_Ten() {
        List<ThongTinSD> list = new ArrayList<>();
        try {
            String hql = "SELECT tb.moTaTB, COUNT(*) FROM ThongTinSD t LEFT JOIN t.thietBi tb GROUP BY tb.moTaTB";
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            List<Object[]> results = query.getResultList();
            for (Object[] result : results) {
                ThongTinSD ttsd = new ThongTinSD();
                ttsd.setMoTaTB((String) result[0]); 
                ttsd.setSoluong(((Number) result[1]).intValue());
                list.add(ttsd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<XuLy> getListByViPham_DaXyLy() {
        List<XuLy> list = new ArrayList<>();
        try {
            String hql = "SELECT xl.hinhThucXL, COUNT(*) FROM XuLy xl WHERE xl.trangThaiXL = 1 GROUP BY xl.hinhThucXL";
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            List<Object[]> results = query.getResultList();
            for (Object[] result : results) {
                XuLy ttsd = new XuLy();
                ttsd.setHinhThucXL((String) result[0]); 
                ttsd.setSoluong(((Number) result[1]).intValue());
                list.add(ttsd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<XuLy> getListByViPham_DangXyLy() {
        List<XuLy> list = new ArrayList<>();
        try {
            String hql = "SELECT xl.hinhThucXL, COUNT(*) FROM XuLy xl WHERE xl.trangThaiXL = 0 GROUP BY xl.hinhThucXL";
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            List<Object[]> results = query.getResultList();
            for (Object[] result : results) {
                XuLy ttsd = new XuLy();
                ttsd.setHinhThucXL((String) result[0]); 
                ttsd.setSoluong(((Number) result[1]).intValue());
                list.add(ttsd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<XuLy> getListByViPham_Tien() {
        List<XuLy> list = new ArrayList<>();
        try {
            String hql = "SELECT xl.hinhThucXL, SUM(xl.soTien) FROM XuLy xl WHERE xl.trangThaiXL = 1 GROUP BY xl.hinhThucXL";
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            List<Object[]> results = query.getResultList();
            for (Object[] result : results) {
                XuLy ttsd = new XuLy();
                ttsd.setHinhThucXL((String) result[0]); 
                ttsd.setSoTien((long) result[1]);
                list.add(ttsd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
