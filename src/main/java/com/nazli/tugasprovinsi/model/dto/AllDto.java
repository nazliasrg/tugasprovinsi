package com.nazli.tugasprovinsi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllDto {
    private String kodeProvinsi;
    private String namaProvinsi;
    private String kodeKabupaten;
    private String namaKabupaten;
    private String kodeKecamatan;
    private String namaKecamatan;
    private String kodeDesa;
    private String namaDesa;
    private Integer status;
}
