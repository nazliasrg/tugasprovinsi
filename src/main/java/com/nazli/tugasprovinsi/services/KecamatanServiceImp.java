package com.nazli.tugasprovinsi.services;

import com.nazli.tugasprovinsi.model.dto.KecamatanDto;
import com.nazli.tugasprovinsi.model.dto.StatusMessageDto;
import com.nazli.tugasprovinsi.model.entity.KabupatenEntity;
import com.nazli.tugasprovinsi.model.entity.KecamatanEntity;
import com.nazli.tugasprovinsi.model.entity.ProvinsiEntity;
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
public class KecamatanServiceImp implements KecamatanService{
    @Autowired
    private KecamatanRepository kecamatanRepository;

    @Autowired
    private KabupatenRepository kabupatenRepository;

    @Autowired
    private ProvinsiRepository provinsiRepository;

    @Override
    public ResponseEntity<?> insertKecamatanEntity(String kodeProvinsi, String kodeKabupaten, KecamatanDto kecamatanDto) {
        StatusMessageDto<KecamatanEntity> result = new StatusMessageDto<>();
        KecamatanEntity kecamatanEntity = convertDtoToEntity(kodeProvinsi, kodeKabupaten, kecamatanDto);
        kecamatanRepository.save(kecamatanEntity);

        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data Kecamatan " + kecamatanEntity.getNamaKecamatan() + " berhasil ditambah!");
        result.setData(kecamatanEntity);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<?> updateKecamatanEntity(String namaKecamatan, KecamatanDto kecamatanDto) {
        StatusMessageDto<KecamatanEntity> result = new StatusMessageDto<>();
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

        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data Kecamatan " + kecamatanEntity.getNamaKecamatan() + " berhasil diupdate!");
        result.setData(kecamatanEntity);
        return ResponseEntity.ok(result);
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
