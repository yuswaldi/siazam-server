package com.c77.almakmur.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table (name = "t_pembayaran_zakat_detail")
public class PembayaranZakatDetail {
    
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "id_pembayaran_zakat_header")
    private PembayaranZakatHeader pembayaranZakatHeader;
    
    @ManyToOne
    @JoinColumn(name = "id_jenis_zakat")
    private JenisZakat jenisZakat;
    
    @ManyToOne
    @JoinColumn(name = "id_satuan_zakat")
    private SatuanZakat satuanZakat;
    
    @Column(name = "keterangan")
    private String keterangan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PembayaranZakatHeader getPembayaranZakatHeader() {
        return pembayaranZakatHeader;
    }

    public void setPembayaranZakatHeader(PembayaranZakatHeader pembayaranZakatHeader) {
        this.pembayaranZakatHeader = pembayaranZakatHeader;
    }

    public JenisZakat getJenisZakat() {
        return jenisZakat;
    }

    public void setJenisZakat(JenisZakat jenisZakat) {
        this.jenisZakat = jenisZakat;
    }

    public SatuanZakat getSatuanZakat() {
        return satuanZakat;
    }

    public void setSatuanZakat(SatuanZakat satuanZakat) {
        this.satuanZakat = satuanZakat;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
}    
            
            