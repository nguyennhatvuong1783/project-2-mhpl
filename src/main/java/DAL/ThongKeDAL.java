package DAL;
/**
 *
 * @author Thanh Tran
 */
import java.util.List;

public interface ThongKeDAL {
    
    public List<ThongTinSD> getListByThanhVien_TGVao();
    
    public List<ThongTinSD> getListByThanhVien_Khoa();
    
    public List<ThongTinSD> getListByThanhVien_Nganh();

    public List<ThongTinSD> getListByThietBi_TGMuon();
    
    public List<ThongTinSD> getListByThietBi_Ten();
    
    public List<XuLy> getListByViPham_DaXyLy();
    
    public List<XuLy> getListByViPham_DangXyLy();
    
    public List<XuLy> getListByViPham_Tien();
    
}
