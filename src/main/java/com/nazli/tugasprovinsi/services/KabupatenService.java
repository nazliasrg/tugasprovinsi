package com.nazli.tugasprovinsi.services;

import com.nazli.tugasprovinsi.model.dto.KabupatenDto;
import com.nazli.tugasprovinsi.model.entity.KabupatenEntity;

public interface KabupatenService {
    KabupatenEntity insertKabupatenEntity(String kodeProvinsi, KabupatenDto kabupatenDto);
    KabupatenEntity updateKabupatenEntity(String namaKabupaten, KabupatenDto kabupatenDto);
}
