package com.nazli.tugasprovinsi.services;

import com.nazli.tugasprovinsi.model.dto.AllDto;
import org.springframework.http.ResponseEntity;

public interface AllService {
    ResponseEntity<?> addAllData(AllDto allDto);
}
