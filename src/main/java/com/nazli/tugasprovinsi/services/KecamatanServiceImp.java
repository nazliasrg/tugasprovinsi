package com.nazli.tugasprovinsi.services;

import com.nazli.tugasprovinsi.model.dto.KecamatanDto;
import com.nazli.tugasprovinsi.model.entity.KabupatenEntity;
import com.nazli.tugasprovinsi.model.entity.KecamatanEntity;
import com.nazli.tugasprovinsi.model.entity.ProvinsiEntity;
import com.nazli.tugasprovinsi.repository.KabupatenRepository;
import com.nazli.tugasprovinsi.repository.KecamatanRepository;
import com.nazli.tugasprovinsi.repository.ProvinsiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KecamatanServiceImp implements KecamatanService{
    @Autowired
    private KecamatanRepository kecamatanRepository;

    @Autowired
    private KabupatenRepository kabupatenRepository;

    @Autowired
    private ProvinsiRepository provinsiRepository;

    @Override
    public KecamatanEntity insertKecamatanEntity(String kodeProvinsi, String kodeKabupaten, KecamatanDto kecamatanDto) {
        KecamatanEntity kecamatanEntity = convertDtoToEntity(kodeProvinsi, kodeKabupaten, kecamatanDto);
        kecamatanRepository.save(kecamatanEntity);
        return kecamatanEntity;
    }

    @Override
    public KecamatanEntity updateKecamatanEntity(String namaKecamatan, KecamatanDto kecamatanDto) {
        KecamatanEntity kecamatanEntity = kecamatanRepository.findByNamaKecamatan(namaKecamatan);

        if(kecamatanDto.getNamaKecamatan() != null){
            kecamatanEntity.setNamaKecamatan(kecamatanDto.getNamaKecamatan());
        }
        if(kecamatanDto.getStatus() != null){
            kecamatanEntity.setStatus(kecamatanDto.getStatus());
        }
        if(kecamatanDto.getKodeKabupaten() != null){
            KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(kecamatanDto.getKodeKabupaten());
            kecamatanEntity.setKabupaten(kabupatenEntity);
        }
        if(kecamatanDto.getKodeProvinsi() != null){
            ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(kecamatanDto.getKodeProvinsi());
            kecamatanEntity.setProvinsi(provinsiEntity);
        }

        kecamatanRepository.save(kecamatanEntity);
        return kecamatanEntity;
    }

    private KecamatanEntity convertDtoToEntity(String kodeProvinsi, String kodeKabupaten, KecamatanDto kecamatanDto){
        KecamatanEntity kecamatanEntity = new KecamatanEntity();
        kecamatanEntity.setNamaKecamatan(kecamatanDto.getNamaKecamatan());
        kecamatanEntity.setStatus(1);
        kecamatanRepository.save(kecamatanEntity);

        kecamatanEntity.setKodeKecamatan("KE"+ kecamatanEntity.getId());

        KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(kodeKabupaten);
        kecamatanEntity.setKabupaten(kabupatenEntity);

        ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(kodeProvinsi);
        kecamatanEntity.setProvinsi(provinsiEntity);

        kecamatanRepository.save(kecamatanEntity);
        return kecamatanEntity;
    }
}
