package com.nazli.tugasprovinsi.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProvinsiDto {
    private String kodeProvinsi;
    private String namaProvinsi;
    private Integer status;
}