package BLL;
/**
 *
 * @author Tran Duc Thanh
 * MSSV 3121410451
 */
import DAL.ThongTinSD;
import DAL.XuLy;
import java.util.List;

public interface ThongKeBLL {
    
    public List<ThongTinSD> getListByThanhVien_TGVao();
   
    public List<ThongTinSD> getListByThanhVien_Khoa();
    
    public List<ThongTinSD> getListByThanhVien_Nganh();
    
    public List<ThongTinSD> getListByThietBi_TGMuon();

    public List<ThongTinSD> getListByThietBi_TenTB();
    
    public List<XuLy> getListByViPham_DaXuLy();
    
    public List<XuLy> getListByViPham_DangXuLy();
    
    public List<XuLy> getListByViPham_Tien();

}
