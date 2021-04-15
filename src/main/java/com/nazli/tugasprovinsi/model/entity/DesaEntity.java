package com.nazli.tugasprovinsi.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_desa")
public class DesaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, unique = true)
    private String kodeDesa;

    @Column(length = 50, unique = true, nullable = false)
    private String namaDesa;

    @Column(length = 11)
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "kodeKecamatan", referencedColumnName = "kodeKecamatan")
    private KecamatanEntity kecamatan;

    @ManyToOne
    @JoinColumn(name = "kodeKabupaten", referencedColumnName = "kodeKabupaten")
    private KabupatenEntity kabupaten;

    @ManyToOne
    @JoinColumn(name = "kodeProvinsi", referencedColumnName = "kodeProvinsi")
    private ProvinsiEntity provinsi;

    public DesaEntity(String kodeDesa, String namaDesa, Integer status, KecamatanEntity kecamatan, KabupatenEntity kabupaten, ProvinsiEntity provinsi) {
        this.kodeDesa = kodeDesa;
        this.namaDesa = namaDesa;
        this.status = status;
        this.kecamatan = kecamatan;
        this.kabupaten = kabupaten;
        this.provinsi = provinsi;
    }
}
