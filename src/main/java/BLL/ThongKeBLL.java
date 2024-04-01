package BLL;

import DAL.ThanhVien;
import DAL.ThongTinSD;
import DAL.XuLy;
import java.util.List;

/**
 *
 * @author Thanh Tran
 */
public interface ThongKeBLL {
    
    public List<ThongTinSD> getListByThanhVien_TGVao();
   
    public List<ThongTinSD> getListByThanhVien_Khoa();
    
    public List<ThongTinSD> getListByThanhVien_Nganh();
    
    public List<ThongTinSD> getListByThietBi_TGMuon();

    public List<ThongTinSD> getListByThietBi_Ten();
    
    public List<XuLy> getListByViPham_DaXuLy();
    
    public List<XuLy> getListByViPham_DangXuLy();
    
    public List<XuLy> getListByViPham_Tien();

}
