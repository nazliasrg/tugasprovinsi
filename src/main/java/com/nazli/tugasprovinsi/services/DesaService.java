package com.nazli.tugasprovinsi.services;

import com.nazli.tugasprovinsi.model.dto.DesaDto;
import com.nazli.tugasprovinsi.model.entity.DesaEntity;

public interface DesaService {
    DesaEntity insertDesaEntity(String namaProvinsi, String namaKabupaten, String namaKecamatan, DesaDto desaDto);
    DesaEntity updateDesaEntity(String namaDesa, DesaDto desaDto);
}
