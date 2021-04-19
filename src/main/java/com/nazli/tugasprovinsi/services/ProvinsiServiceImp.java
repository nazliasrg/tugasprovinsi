package com.nazli.tugasprovinsi.services;

import com.nazli.tugasprovinsi.model.dto.ProvinsiDto;
import com.nazli.tugasprovinsi.model.dto.StatusMessageDto;
import com.nazli.tugasprovinsi.model.entity.ProvinsiEntity;
import com.nazli.tugasprovinsi.repository.ProvinsiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProvinsiServiceImp implements ProvinsiService{
    @Autowired
    private ProvinsiRepository provinsiRepository;

    @Override
    public ResponseEntity<?> insertProvinsiEntity(ProvinsiDto provinsiDto) {
        StatusMessageDto<ProvinsiEntity> result = new StatusMessageDto<>();
        if(provinsiDto.getNamaProvinsi() != null){
            ProvinsiEntity provinsiEntity = convertDtoToEntity(provinsiDto);
            provinsiRepository.save(provinsiEntity);

            result.setStatus(HttpStatus.OK.value());
            result.setMessage("Data Provinsi " + provinsiEntity.getNamaProvinsi() + " berhasil ditambah!");
            result.setData(provinsiEntity);
            return ResponseEntity.ok(result);
        }
        return null;
    }

    @Override
    public ResponseEntity<?> updateProvinsiEntity(Integer id, ProvinsiDto provinsiDto) {
        StatusMessageDto<ProvinsiEntity> result = new StatusMessageDto<>();

        ProvinsiEntity provinsiEntity =provinsiRepository.findById(id).get();
        if(provinsiDto.getNamaProvinsi() != null){
            provinsiEntity.setNamaProvinsi(provinsiDto.getNamaProvinsi());
        }
        if(provinsiDto.getStatus() != null){
            provinsiEntity.setStatus(provinsiDto.getStatus());
        }

        provinsiRepository.save(provinsiEntity);

        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data Provinsi " + provinsiEntity.getNamaProvinsi() + " berhasil diupdate!");
        result.setData(provinsiEntity);
        return ResponseEntity.ok(result);
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
