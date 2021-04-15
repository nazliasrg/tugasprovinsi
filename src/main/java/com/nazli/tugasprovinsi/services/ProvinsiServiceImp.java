package com.nazli.tugasprovinsi.services;

import com.nazli.tugasprovinsi.model.dto.ProvinsiDto;
import com.nazli.tugasprovinsi.model.entity.ProvinsiEntity;
import com.nazli.tugasprovinsi.repository.ProvinsiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProvinsiServiceImp implements ProvinsiService{
    @Autowired
    private ProvinsiRepository provinsiRepository;

    @Override
    public ProvinsiEntity insertProvinsiEntity(ProvinsiDto provinsiDto) {
        if(provinsiDto.getNamaProvinsi() != null){
            ProvinsiEntity provinsiEntity = convertDtoToEntity(provinsiDto);
            provinsiRepository.save(provinsiEntity);
            return provinsiEntity;
        }
        return null;
    }

    @Override
    public ProvinsiEntity updateProvinsiEntity(Integer id, ProvinsiDto provinsiDto) {
        ProvinsiEntity provinsiEntity =provinsiRepository.findById(id).get();
        if(provinsiDto.getNamaProvinsi() != null){
            provinsiEntity.setNamaProvinsi(provinsiDto.getNamaProvinsi());
        }
        if(provinsiDto.getStatus() != null){
            provinsiEntity.setStatus(provinsiDto.getStatus());
        }

        provinsiRepository.save(provinsiEntity);
        return provinsiEntity;
    }

    private ProvinsiEntity convertDtoToEntity(ProvinsiDto provinsiDto){
        ProvinsiEntity provinsiEntity = new ProvinsiEntity();

        provinsiEntity.setNamaProvinsi(provinsiDto.getNamaProvinsi());
        provinsiEntity.setStatus(1);
        provinsiRepository.save(provinsiEntity);

        provinsiEntity.setKodeProvinsi("P" + provinsiEntity.getId());

        return provinsiEntity;
    }
}
