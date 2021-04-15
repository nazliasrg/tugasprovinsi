package com.nazli.tugasprovinsi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KecamatanDto {
    private String kodeKecamatan;
    private String namaKecamatan;
    private Integer status;
    private String kodeKabupaten;
    private String kodeProvinsi;

}