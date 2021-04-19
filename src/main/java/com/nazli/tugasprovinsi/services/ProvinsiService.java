package com.nazli.tugasprovinsi.services;

import com.nazli.tugasprovinsi.model.dto.ProvinsiDto;
import com.nazli.tugasprovinsi.model.entity.ProvinsiEntity;
import org.springframework.http.ResponseEntity;

public interface ProvinsiService {
    ResponseEntity<?> insertProvinsiEntity(ProvinsiDto provinsiDto);
    ResponseEntity<?> updateProvinsiEntity(Integer id, ProvinsiDto provinsiDto);
}
