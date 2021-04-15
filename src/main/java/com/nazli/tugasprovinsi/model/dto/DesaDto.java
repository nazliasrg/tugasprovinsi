package com.nazli.tugasprovinsi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesaDto {
    private String kodeDesa;
    private String namaDesa;
    private Integer status;
    private String kodeProvinsi;
    private String kodeKabupaten;
    private String kodeKecamatan;
}
