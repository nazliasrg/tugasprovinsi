package com.nazli.tugasprovinsi.services;

import com.nazli.tugasprovinsi.model.dto.KabupatenDto;
import com.nazli.tugasprovinsi.model.entity.KabupatenEntity;
import com.nazli.tugasprovinsi.model.entity.ProvinsiEntity;
import com.nazli.tugasprovinsi.repository.KabupatenRepository;
import com.nazli.tugasprovinsi.repository.ProvinsiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KabupatenServiceImp implements KabupatenService{

    @Autowired
    private KabupatenRepository kabupatenRepository;

    @Autowired
    private ProvinsiRepository provinsiRepository;

    @Override
    public KabupatenEntity insertKabupatenEntity(String kodeProvinsi, KabupatenDto kabupatenDto) {
        if(kabupatenDto.getNamaKabupaten() != null){
            KabupatenEntity kabupatenEntity = convertDtoToEntity(kodeProvinsi, kabupatenDto);
            kabupatenRepository.save(kabupatenEntity);
            return kabupatenEntity;
        }
        return null;
    }

    @Override
    public KabupatenEntity updateKabupatenEntity(String namaKabupaten, KabupatenDto kabupatenDto) {
        KabupatenEntity kabupatenEntity = kabupatenRepository.findByNamaKabupaten(namaKabupaten);

        if(kabupatenDto.getNamaKabupaten() != null){
            kabupatenEntity.setNamaKabupaten(kabupatenDto.getNamaKabupaten());
        }
        if(kabupatenDto.getStatus() != null){
            kabupatenEntity.setStatus(kabupatenDto.getStatus());
        }
        if(kabupatenDto.getKodeProvinsi() != null){
            ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(kabupatenDto.getKodeProvinsi());
            kabupatenEntity.setProvinsi(provinsiEntity);
        }

        kabupatenRepository.save(kabupatenEntity);
        return kabupatenEntity;
    }

    private KabupatenEntity convertDtoToEntity(String kodeProvinsi, KabupatenDto kabupatenDto){
        KabupatenEntity kabupatenEntity = new KabupatenEntity();
        kabupatenEntity.setNamaKabupaten(kabupatenDto.getNamaKabupaten());
        kabupatenEntity.setStatus(1);
        kabupatenRepository.save(kabupatenEntity);

        kabupatenEntity.setKodeKabupaten("KA" + kabupatenEntity.getId());

        ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(kodeProvinsi);
        kabupatenEntity.setProvinsi(provinsiEntity);

        return kabupatenEntity;
    }
}
