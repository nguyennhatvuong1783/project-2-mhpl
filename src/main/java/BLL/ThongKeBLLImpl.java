package BLL;
/**
 *
 * @author Tran Duc Thanh
 * MSSV 3121410451
 */
import DAL.ThanhVien;
import DAL.ThongKeDAL;
import DAL.ThongTinSD;
import DAL.XuLy;
import java.util.List;

/**
 *
 * @author Thanh Tran
 */
public class ThongKeBLLImpl implements ThongKeBLL {
    private ThongKeDAL tkDAL;

    public ThongKeBLLImpl(ThongKeDAL tkDAL) {
        this.tkDAL = tkDAL;
    }

    @Override
    public List<ThongTinSD> getListByThanhVien_TGVao() {
        return tkDAL.getListByThanhVien_TGVao();
    }

    @Override
    public List<ThongTinSD> getListByThanhVien_Khoa() {
        return tkDAL.getListByThanhVien_Khoa();
    }
    
    @Override
    public List<ThongTinSD> getListByThanhVien_Nganh() {
        return tkDAL.getListByThanhVien_Nganh();
    }

    @Override
    public List<ThongTinSD> getListByThietBi_TGMuon() {
        return tkDAL.getListByThietBi_TGMuon();
    }

    @Override
    public List<ThongTinSD> getListByThietBi_Ten() {
        return tkDAL.getListByThietBi_Ten();
    }

    @Override
    public List<XuLy> getListByViPham_DaXuLy() {
        return tkDAL.getListByViPham_DaXyLy();
    }

    @Override
    public List<XuLy> getListByViPham_DangXuLy() {
        return tkDAL.getListByViPham_DangXyLy();
    }

    @Override
    public List<XuLy> getListByViPham_Tien() {
        return tkDAL.getListByViPham_Tien();
    }
}
