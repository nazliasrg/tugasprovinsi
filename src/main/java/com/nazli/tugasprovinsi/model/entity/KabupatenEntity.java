package com.nazli.tugasprovinsi.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_kabupaten")
public class KabupatenEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, unique = true)
    private String kodeKabupaten;

    @Column(length = 50, unique = true, nullable = false)
    private String namaKabupaten;

    @Column(length = 11)
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "kodeProvinsi", referencedColumnName = "kodeProvinsi")
    private ProvinsiEntity provinsi;

    public KabupatenEntity(String kodeKabupaten, String namaKabupaten, Integer status, ProvinsiEntity provinsi) {
        this.kodeKabupaten = kodeKabupaten;
        this.namaKabupaten = namaKabupaten;
        this.status = status;
        this.provinsi = provinsi;
    }
}
