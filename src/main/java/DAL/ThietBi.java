/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author Nguyen Nhat Vuong
 */
@Entity
@Table (name = "thietbi")
public class ThietBi implements Serializable{
    @Id
    private int MaTB;
    
    @Column
    private String TenTB;
    
    @Column
    private String MoTaTB;

    public ThietBi() {
    }

    public ThietBi(int MaTB, String TenTB, String MoTaTB) {
        this.MaTB = MaTB;
        this.TenTB = TenTB;
        this.MoTaTB = MoTaTB;
    }
    
    

    public int getMaTB() {
        return MaTB;
    }

    public void setMaTB(int MaTB) {
        this.MaTB = MaTB;
    }

    public String getTenTB() {
        return TenTB;
    }

    public void setTenTB(String tenTB) {
        this.TenTB = tenTB;
    }

    public String getMoTaTB() {
        return MoTaTB;
    }

    public void setMoTaTB(String MoTaTB) {
        this.MoTaTB = MoTaTB;
    }
    
    
    
    
            
    
    
}
