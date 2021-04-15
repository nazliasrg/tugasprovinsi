package com.nazli.tugasprovinsi.services;

import com.nazli.tugasprovinsi.model.dto.AllDto;
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
public class AllServiceImp implements AllService{
    @Autowired
    private ProvinsiRepository provinsiRepository;

    @Autowired
    private KabupatenRepository kabupatenRepository;

    @Autowired
    private KecamatanRepository kecamatanRepository;

    @Autowired
    private DesaRepository desaRepository;

    @Override
    public ResponseEntity<?> addAllData(AllDto allDto) {
        StatusMessageDto<ProvinsiEntity> result = new StatusMessageDto<>();

        ProvinsiEntity provinsiEntity = new ProvinsiEntity();
        KabupatenEntity kabupatenEntity = new KabupatenEntity();
        KecamatanEntity kecamatanEntity = new KecamatanEntity();
        DesaEntity desaEntity = new DesaEntity();

        provinsiEntity.setNamaProvinsi(allDto.getNamaProvinsi());
        provinsiEntity.setStatus(1);
        provinsiRepository.save(provinsiEntity);
        provinsiEntity.setKodeProvinsi("P" + provinsiEntity.getId());
        provinsiRepository.save(provinsiEntity);

        kabupatenEntity.setNamaKabupaten(allDto.getNamaKabupaten());
        kabupatenEntity.setStatus(1);
        kabupatenRepository.save(kabupatenEntity);
        kabupatenEntity.setKodeKabupaten("KA" + kabupatenEntity.getId());
        kabupatenEntity.setProvinsi(provinsiRepository.findByKodeProvinsi(provinsiEntity.getKodeProvinsi()));
        kabupatenRepository.save(kabupatenEntity);

        kecamatanEntity.setNamaKecamatan(allDto.getNamaKecamatan());
        kecamatanEntity.setStatus(1);
        kecamatanRepository.save(kecamatanEntity);
        kecamatanEntity.setKodeKecamatan("KE" + kecamatanEntity.getId());
        kecamatanEntity.setKabupaten(kabupatenRepository.findByKodeKabupaten(kabupatenEntity.getKodeKabupaten()));
        kecamatanEntity.setProvinsi(provinsiRepository.findByKodeProvinsi(provinsiEntity.getKodeProvinsi()));
        kecamatanRepository.save(kecamatanEntity);

        desaEntity.setNamaDesa(allDto.getNamaDesa());
        desaEntity.setStatus(1);
        desaRepository.save(desaEntity);
        desaEntity.setKodeDesa("D" + desaEntity.getId());
        desaEntity.setKecamatan(kecamatanRepository.findByKodeKecamatan(kecamatanEntity.getKodeKecamatan()));
        desaEntity.setKabupaten(kabupatenRepository.findByKodeKabupaten(kabupatenEntity.getKodeKabupaten()));
        desaEntity.setProvinsi(provinsiRepository.findByKodeProvinsi(provinsiEntity.getKodeProvinsi()));
        desaRepository.save(desaEntity);

        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data berhasil tersimpan");
        result.setData(provinsiEntity);

        return ResponseEntity.ok(result);
    }
}
