package com.nazli.tugasprovinsi.services;

import com.nazli.tugasprovinsi.model.dto.KabupatenDto;
import com.nazli.tugasprovinsi.model.entity.KabupatenEntity;
import org.springframework.http.ResponseEntity;

public interface KabupatenService {
    ResponseEntity<?> insertKabupatenEntity(String kodeProvinsi, KabupatenDto kabupatenDto);
    ResponseEntity<?> updateKabupatenEntity(String namaKabupaten, KabupatenDto kabupatenDto);
}
