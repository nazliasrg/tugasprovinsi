package com.nazli.tugasprovinsi.services;

import com.nazli.tugasprovinsi.model.dto.KecamatanDto;
import com.nazli.tugasprovinsi.model.entity.KecamatanEntity;

public interface KecamatanService {
    KecamatanEntity insertKecamatanEntity(String kodeProvinsi, String kodeKabupaten, KecamatanDto kecamatanDto);
    KecamatanEntity updateKecamatanEntity(String namaKecamatan, KecamatanDto kecamatanDto);
}
