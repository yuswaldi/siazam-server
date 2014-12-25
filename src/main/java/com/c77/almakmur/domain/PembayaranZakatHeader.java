package com.c77.almakmur.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

@Entity 
@Table(name = "t_pembayaran_zakat_header")
public class PembayaranZakatHeader implements Serializable {
    
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    
    @Column(name = "no_kwitansi", nullable = false, unique = true)
    private String noKwitansi;
    
    @Column(name = "tanggal_kwitansi", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggal;
    
    @Column(name = "nama_penyetor", nullable = false)
    private String namaPenyetor;
    
    @Column(name = "alamat_penyetor", nullable = false)
    private String alamatPenyetor;
    
    @OneToMany(mappedBy = "pembayaranZakatHeader", cascade = CascadeType.ALL, orphanRemoval = true)
//    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
//    private List<PembayaranZakatDetail> details = new ArrayList<PembayaranZakatDetail>();
    @OrderBy(value = "jenisZakat")
    private Set<PembayaranZakatDetail> zakatDetailSet = new TreeSet<PembayaranZakatDetail>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoKwitansi() {
        return noKwitansi;
    }

    public void setNoKwitansi(String noKwitansi) {
        this.noKwitansi = noKwitansi;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getNamaPenyetor() {
        return namaPenyetor;
    }

    public void setNamaPenyetor(String namaPenyetor) {
        this.namaPenyetor = namaPenyetor;
    }

    public String getAlamatPenyetor() {
        return alamatPenyetor;
    }

    public void setAlamatPenyetor(String alamatPenyetor) {
        this.alamatPenyetor = alamatPenyetor;
    }

    public Set<PembayaranZakatDetail> getZakatDetailSet() {
        return zakatDetailSet;
    }

    public void setZakatDetailSet(Set<PembayaranZakatDetail> zakatDetailSet) {
        this.zakatDetailSet = zakatDetailSet;
    }

}
