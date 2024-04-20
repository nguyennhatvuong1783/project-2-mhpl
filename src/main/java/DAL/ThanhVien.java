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
    private String password;
    
    @Column
    private String hoTen;
    
    @Column
    private String khoa;
    
    @Column
    private String nganh;
    
    @Column
    private String email;
    
    @Column
    private String sdt; // Thay đổi kiểu dữ liệu thành String
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "thanhVienTTSD")
    private List<ThongTinSD> thongTinSD;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "thanhVienXL")
    private List<XuLy> xuLy;

    public ThanhVien() {
    }

    public ThanhVien(int maTV, String password, String hoTen, String khoa, String nganh, String email, String sdt) { // Thay đổi kiểu dữ liệu của tham số sdt
        this.maTV = maTV;
        this.password = password;
        this.hoTen = hoTen;
        this.khoa = khoa;
        this.nganh = nganh;
        this.email = email;
        this.sdt = sdt;
    }

    public int getMaTV() {
        return maTV;
    }

    public void setMaTV(int maTV) {
        this.maTV = maTV;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() { // Thay đổi kiểu dữ liệu của getter
        return sdt;
    }

    public void setSdt(String sdt) { // Thay đổi kiểu dữ liệu của setter
        this.sdt = sdt;
    }
    
    public List<ThongTinSD> getThongTinSD() {
        return thongTinSD;
    }
    
    public List<XuLy> getXuLy() {
        return xuLy;
    }
}

