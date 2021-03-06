package com.nazli.tugasprovinsi.services;

import com.nazli.tugasprovinsi.model.dto.DesaDto;
import com.nazli.tugasprovinsi.model.dto.StatusMessageDto;
import com.nazli.tugasprovinsi.model.entity.DesaEntity;
import com.nazli.tugasprovinsi.model.entity.KabupatenEntity;
import com.nazli.tugasprovinsi.model.entity.KecamatanEntity;
import com.nazli.tugasprovinsi.model.entity.ProvinsiEntity;
import com.nazli.tugasprovinsi.repository.DesaRepository;
import com.nazli.tugasprovinsi.repository.KabupatenRepository;
import com.nazli.tugasprovinsi.repository.KecamatanRepository;
import com.nazli.tugasprovinsi.repository.ProvinsiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DesaServiceImp implements DesaService{
    @Autowired
    private DesaRepository desaRepository;

    @Autowired
    private KecamatanRepository kecamatanRepository;

    @Autowired
    private KabupatenRepository kabupatenRepository;

    @Autowired
    private ProvinsiRepository provinsiRepository;

    @Override
    public ResponseEntity<?> insertDesaEntity(String kodeProvinsi, String kodeKabupaten, String kodeKecamatan, DesaDto desaDto) {
        StatusMessageDto<DesaEntity> result = new StatusMessageDto<>();

        DesaEntity desaEntity = convertDtoToEntity(kodeProvinsi, kodeKabupaten, kodeKecamatan, desaDto);
        desaRepository.save(desaEntity);

        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data Desa " + desaEntity.getNamaDesa() + " berhasil ditambah!");
        result.setData(desaEntity);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<?> updateDesaEntity(String namaDesa, DesaDto desaDto) {
        StatusMessageDto<DesaEntity> result = new StatusMessageDto<>();

        DesaEntity desaEntity = desaRepository.findByNamaDesa(namaDesa);

        if(desaDto.getNamaDesa() != null){
            desaEntity.setNamaDesa(desaDto.getNamaDesa());
        }
        if(desaDto.getStatus() != null){
            desaEntity.setStatus(desaDto.getStatus());
        }
        if(desaDto.getKodeKecamatan() != null){
            KecamatanEntity kecamatanEntity = kecamatanRepository.findByKodeKecamatan(desaDto.getKodeKecamatan());
            desaEntity.setKecamatan(kecamatanEntity);
        }
        if(desaDto.getKodeKabupaten() != null){
            KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(desaDto.getKodeKabupaten());
            desaEntity.setKabupaten(kabupatenEntity);
        }
        if(desaDto.getKodeProvinsi() != null){
            ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(desaDto.getKodeProvinsi());
            desaEntity.setProvinsi(provinsiEntity);
        }

        desaRepository.save(desaEntity);
        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data Desa " + desaEntity.getNamaDesa() + " berhasil diupdate!");
        result.setData(desaEntity);
        return ResponseEntity.ok(result);
    }

    private DesaEntity convertDtoToEntity(String kodeProvinsi, String kodeKabupaten, String kodeKecamatan, DesaDto desaDto){

        DesaEntity desaEntity = new DesaEntity();
        desaEntity.setNamaDesa(desaDto.getNamaDesa());
        desaEntity.setStatus(1);

        desaRepository.save(desaEntity);

        desaEntity.setKodeDesa("D" + desaEntity.getId());

        KecamatanEntity kecamatanEntity = kecamatanRepository.findByKodeKecamatan(kodeKecamatan);
        desaEntity.setKecamatan(kecamatanEntity);

        KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(kodeKabupaten);
        desaEntity.setKabupaten(kabupatenEntity);

        ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(kodeProvinsi);
        desaEntity.setProvinsi(provinsiEntity);

        desaRepository.save(desaEntity);
        return desaEntity;
    }

}
