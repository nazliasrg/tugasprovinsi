package com.nazli.tugasprovinsi.services;

import com.nazli.tugasprovinsi.model.dto.DesaDto;
import com.nazli.tugasprovinsi.model.entity.DesaEntity;
import org.springframework.http.ResponseEntity;

public interface DesaService {
    ResponseEntity<?> insertDesaEntity(String namaProvinsi, String namaKabupaten, String namaKecamatan, DesaDto desaDto);
    ResponseEntity<?> updateDesaEntity(String namaDesa, DesaDto desaDto);
}
