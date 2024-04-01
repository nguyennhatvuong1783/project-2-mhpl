/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Nguyen Nhat Vuong
 */
@Data
@Entity
@Table(name = "xuly")
public class XuLy {
    @Id
    private int maXL;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaTV", nullable = false)
    private ThanhVien thanhVienXL;
    
    @Column
    private String hinhThucXL;
    
    @Column
    private long soTien;
    
    @Column
    private Date ngayXL;
    
    @Column
    private boolean trangThaiXL;
    
    private int soluong;

    public XuLy() {
    }

    public XuLy(int maXL, ThanhVien thanhVienXL, String hinhThucXL, long soTien, Date ngayXL, boolean trangThaiXL, int soluong) {
        this.maXL = maXL;
        this.thanhVienXL = thanhVienXL;
        this.hinhThucXL = hinhThucXL;
        this.soTien = soTien;
        this.ngayXL = ngayXL;
        this.trangThaiXL = trangThaiXL;
        this.soluong = soluong;
    }

    public int getMaXL() {
        return maXL;
    }

    public void setMaXL(int maXL) {
        this.maXL = maXL;
    }

    public ThanhVien getMaTV() {
        return thanhVienXL;
    }

    public void setMaTV(ThanhVien thanhVienXL) {
        this.thanhVienXL = thanhVienXL;
    }

    public String getHinhThucXL() {
        return hinhThucXL;
    }

    public void setHinhThucXL(String hinhThucXL) {
        this.hinhThucXL = hinhThucXL;
    }

    public long getSoTien() {
        return soTien;
    }

    public void setSoTien(long soTien) {
        this.soTien = soTien;
    }

    public Date getNgayXL() {
        return ngayXL;
    }

    public void setNgayXL(Date ngayXL) {
        this.ngayXL = ngayXL;
    }

    public boolean isTrangThaiXL() {
        return trangThaiXL;
    }

    public void setTrangThaiXL(boolean trangThaiXL) {
        this.trangThaiXL = trangThaiXL;
    }

    public int getSoluong(){
        return soluong;
    }
    
    public void setSoluong(int soluong){
        this.soluong = soluong;
    }
}
