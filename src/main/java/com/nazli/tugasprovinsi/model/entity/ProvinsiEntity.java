package com.nazli.tugasprovinsi.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_provinsi")
public class ProvinsiEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, unique = true)
    private String kodeProvinsi;

    @Column(length = 50, nullable = false, unique = true)
    private String namaProvinsi;

    @Column(length = 11)
    private Integer status;

    public ProvinsiEntity(String kodeProvinsi, String namaProvinsi, Integer status) {
        this.kodeProvinsi = kodeProvinsi;
        this.namaProvinsi = namaProvinsi;
        this.status = status;
    }
}
