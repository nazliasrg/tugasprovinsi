package com.nazli.tugasprovinsi.services;

import com.nazli.tugasprovinsi.model.dto.KecamatanDto;
import com.nazli.tugasprovinsi.model.entity.KecamatanEntity;
import org.springframework.http.ResponseEntity;

public interface KecamatanService {
    ResponseEntity<?> insertKecamatanEntity(String kodeProvinsi, String kodeKabupaten, KecamatanDto kecamatanDto);
    ResponseEntity<?> updateKecamatanEntity(String namaKecamatan, KecamatanDto kecamatanDto);
}
