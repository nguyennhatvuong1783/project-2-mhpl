package DAL;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "thongtinsd")
public class TTSD {
    @Id
    private int maTT;
    
    @Column(name = "MaTV")
    private int maTV; 
    
    @Column(name = "MaTB")
    private Integer maTB; 
    
    @Column
    private Date tgDatcho;
    
    @Column
    private Date tgVao;
    
    @Column
    private Date tgMuon;
    
    @Column
    private Date tgTra;

    public TTSD() {
    }

    public TTSD(int maTT, int maTV, Integer maTB, Date tgDatcho, Date tgVao, Date tgMuon, Date tgTra) {
        this.maTT = maTT;
        this.maTV = maTV;
        this.maTB = maTB;
        this.tgDatcho = tgDatcho;
        this.tgVao = tgVao;
        this.tgMuon = tgMuon;
        this.tgTra = tgTra;
    }

    public int getMaTT() {
        return maTT;
    }

    public void setMaTT(int maTT) {
        this.maTT = maTT;
    }

    public int getMaTV() {
        return maTV;
    }

    public void setMaTV(int maTV) {
        this.maTV = maTV;
    }

    public Integer getMaTB() {
        return maTB;
    }

    public void setMaTB(Integer maTB) {
        this.maTB = maTB;
    }

    public Date getTgDatcho() {
        return tgDatcho;
    }

    public void setTgDatcho(Date tgDatcho) {
        this.tgDatcho = tgDatcho;
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
}
