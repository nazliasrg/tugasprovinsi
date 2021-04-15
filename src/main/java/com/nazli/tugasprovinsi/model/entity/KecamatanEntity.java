package com.nazli.tugasprovinsi.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_kecamatan")
public class KecamatanEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, unique = true)
    private String kodeKecamatan;

    @Column(length = 50, unique = true, nullable = false)
    private String namaKecamatan;

    @Column(length = 11)
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "kodeKabupaten", referencedColumnName = "kodeKabupaten")
    private KabupatenEntity kabupaten;

    @ManyToOne
    @JoinColumn(name = "kodeProvinsi", referencedColumnName = "kodeProvinsi")
    private ProvinsiEntity provinsi;

    public KecamatanEntity(String kodeKecamatan, String namaKecamatan, Integer status, KabupatenEntity kabupaten, ProvinsiEntity provinsi) {
        this.kodeKecamatan = kodeKecamatan;
        this.namaKecamatan = namaKecamatan;
        this.status = status;
        this.kabupaten = kabupaten;
        this.provinsi = provinsi;
    }
}
