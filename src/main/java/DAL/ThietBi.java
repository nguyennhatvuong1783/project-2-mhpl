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
@Table(name = "thietbi")
public class ThietBi {
    @Id
    private int maTB;
    
    @Column
    private String tenTB;
    
    @Column
    private String moTaTB;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "thietBi")
    private List<ThongTinSD> thongTinSD;

    public ThietBi() {
    }

    public ThietBi(int maTB, String tenTB, String moTaTB) {
        this.maTB = maTB;
        this.tenTB = tenTB;
        this.moTaTB = moTaTB;
    }

    public int getMaTB() {
        return maTB;
    }

    public void setMaTB(int maTB) {
        this.maTB = maTB;
    }

    public String getTenTB() {
        return tenTB;
    }

    public void setTenTB(String tenTB) {
        this.tenTB = tenTB;
    }

    public String getMoTaTB() {
        return moTaTB;
    }

    public void setMoTaTB(String moTaTB) {
        this.moTaTB = moTaTB;
    }
    
    public List<ThongTinSD> getThongTinSD() {
        return thongTinSD;
    }
    
}
