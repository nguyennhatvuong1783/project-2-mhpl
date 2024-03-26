/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Nguyen Nhat Vuong
 */
@Data
@Entity
@Table(name = "thanhvien")
public class ThanhVien {
    @Id
    private int maTV;
    
    @Column
    private String hoTen;
    
    @Column
    private String khoa;
    
    @Column
    private String nganh;
    
    @Column
    private int sdt;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "thanhVienTTSD")
    private List<ThongTinSD> thongTinSD;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "thanhVienXL")
    private List<XuLy> xuLy;

    public ThanhVien() {
    }

    public ThanhVien(int maTV, String hoTen, String khoa, String nganh, int sdt) {
        this.maTV = maTV;
        this.hoTen = hoTen;
        this.khoa = khoa;
        this.nganh = nganh;
        this.sdt = sdt;
    }

    public int getMaTV() {
        return maTV;
    }

    public void setMaTV(int maTV) {
        this.maTV = maTV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }
    
    public List<ThongTinSD> getThongTinSD() {
        return thongTinSD;
    }
    
    public List<XuLy> getXuLy() {
        return xuLy;
    }
    
}
