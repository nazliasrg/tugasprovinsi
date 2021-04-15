package com.nazli.tugasprovinsi.services;

import com.nazli.tugasprovinsi.model.dto.ProvinsiDto;
import com.nazli.tugasprovinsi.model.entity.ProvinsiEntity;

public interface ProvinsiService {
    ProvinsiEntity insertProvinsiEntity(ProvinsiDto provinsiDto);
    ProvinsiEntity updateProvinsiEntity(Integer id, ProvinsiDto provinsiDto);
}
