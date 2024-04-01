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
@Entity()
@Table(name = "thongtinsd")
public class ThongTinSD {
    @Id
    private int maTT;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaTV", nullable = false)
    private ThanhVien thanhVienTTSD;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaTB", nullable = false)
    private ThietBi thietBi;
    
    @Column
    private Date tgVao;
    
    @Column
    private Date tgMuon;
    
    @Column
    private Date tgTra;
    
    //Bổ sung vài cái cho việc làm thống kê
    private int soluong;
    
    private String khoa;
    
    private String nganh;
    
    private String moTaTB;
   

    public ThongTinSD() {
    }

    public ThongTinSD(int maTT, ThanhVien thanhVien, ThietBi thietBi, Date tgVao, Date tgMuon, Date tgTra, int soluong, String khoa, String nganh, String moTaTB) {
        this.maTT = maTT;
        this.thanhVienTTSD = thanhVienTTSD;
        this.thietBi = thietBi;
        this.tgVao = tgVao;
        this.tgMuon = tgMuon;
        this.tgTra = tgTra;
        this.soluong = soluong;
        this.khoa = khoa;
        this.nganh = nganh;
        this.moTaTB = moTaTB;
    }

    public int getMaTT() {
        return maTT;
    }

    public void setMaTT(int maTT) {
        this.maTT = maTT;
    }

    public ThanhVien getMaTV() {
        return thanhVienTTSD;
    }

    public void setMaTV(ThanhVien thanhVienTTSD) {
        this.thanhVienTTSD = thanhVienTTSD;
    }

    public ThietBi getMaTB() {
        return thietBi;
    }

    public void setMaTB(ThietBi thietBi) {
        this.thietBi = thietBi;
    }

    public Date getTgVao() {
        return tgVao;
    }

    public void setTgVao(Date tgVao) {
        this.tgVao = tgVao;
    }

    public Date getTgMuon() {
        return tgMuon;
    }

    public void setTgMuon(Date tgMuon) {
        this.tgMuon = tgMuon;
    }

    public Date getTgTra() {
        return tgTra;
    }

    public void setTgTra(Date tgTra) {
        this.tgTra = tgTra;
    }

    public int getSoluong(){
        return soluong;
    }
    
    public void setSoluong(int soluong){
        this.soluong = soluong;
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
    
    public String getMoTaTB() {
        return moTaTB;
    }

    public void setMoTaTB(String moTaTB) {
        this.moTaTB = moTaTB;
    }
}

