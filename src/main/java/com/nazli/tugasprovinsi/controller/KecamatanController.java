package com.nazli.tugasprovinsi.controller;

import com.nazli.tugasprovinsi.model.dto.KecamatanDto;
import com.nazli.tugasprovinsi.model.dto.StatusMessageDto;
import com.nazli.tugasprovinsi.model.entity.DesaEntity;
import com.nazli.tugasprovinsi.model.entity.KecamatanEntity;
import com.nazli.tugasprovinsi.model.entity.ProvinsiEntity;
import com.nazli.tugasprovinsi.repository.KecamatanRepository;
import com.nazli.tugasprovinsi.services.KecamatanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class KecamatanController {
    @Autowired
    private KecamatanRepository kecamatanRepository;

    @Autowired
    private KecamatanService kecamatanService;

//  get all data kecamatan
    @GetMapping("/kecamatan-all")
    public ResponseEntity<?> getAll(){
        List<KecamatanEntity> kecamatanEntityList = kecamatanRepository.findAll();
        return ResponseEntity.ok(kecamatanEntityList);
    }

//  get by id data kecamatan
    @GetMapping("/kecamatan/{id}")
    public ResponseEntity<?> getKecamatan(@PathVariable Integer id){
        KecamatanEntity kecamatanEntity = kecamatanRepository.findById(id).get();
        return ResponseEntity.ok(kecamatanEntity);
    }

//  get by kode data kecamatan
    @GetMapping("/get/kecamatan/{kodeKecamatan}")
    public ResponseEntity<?> getKecamatanByKode(@PathVariable String kodeKecamatan){
        KecamatanEntity kecamatanEntity = kecamatanRepository.findByKodeKecamatan(kodeKecamatan);
        return ResponseEntity.ok(kecamatanEntity);
    }

//  get data kecamatan by kodeKabupaten
    @GetMapping("/getkodekab/kecamatan/{kodeKabupaten}")
    public ResponseEntity<?> getKecamatanByKodeKabupaten(@PathVariable String kodeKabupaten){
        List<KecamatanEntity> kecamatanEntityList = kecamatanRepository.getKecamatanFromKodeKab(kodeKabupaten);
        return ResponseEntity.ok(kecamatanEntityList);
    }

//  get data kecamatan by kodeProvinsi
    @GetMapping("/getkodeprov/kecamatan/{kodeProvinsi}")
    public ResponseEntity<?> getKecamatanByKodeProvinsi(@PathVariable String kodeProvinsi){
        List<KecamatanEntity> kecamatanEntityList = kecamatanRepository.getKecamatanFromKodeProv(kodeProvinsi);
        return ResponseEntity.ok(kecamatanEntityList);
    }

//  insert data kecamatan
    @PostMapping("/insert/kecamatan/{kodeProvinsi}/{kodeKabupaten}")
    public ResponseEntity<?> insertKecamatanEntity(@PathVariable String kodeProvinsi, @PathVariable String kodeKabupaten, @RequestBody KecamatanDto kecamatanDto){
        StatusMessageDto<KecamatanEntity> result = new StatusMessageDto<>();
        try{
            return kecamatanService.insertKecamatanEntity(kodeProvinsi, kodeKabupaten, kecamatanDto);
        }catch (Exception e){
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

//  update data kecamatan
    @PutMapping("/update/kecamatan/{namaKecamatan}")
    public ResponseEntity<?> updateKecamatanEntity(@PathVariable String namaKecamatan, @RequestBody KecamatanDto kecamatanDto){
        StatusMessageDto<KecamatanEntity> result = new StatusMessageDto<>();
        try{
            return kecamatanService.updateKecamatanEntity(namaKecamatan, kecamatanDto);
        }catch (Exception e){
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

//  delete data kecamatan
    @DeleteMapping("/delete/kecamatan/{namaKecamatan}")
    public ResponseEntity<?> deleteKecamatanEntity(@PathVariable String namaKecamatan){
        StatusMessageDto<KecamatanEntity> result = new StatusMessageDto<>();
        KecamatanEntity kecamatanEntity = kecamatanRepository.findByNamaKecamatan(namaKecamatan);
        kecamatanEntity.setStatus(0);
        kecamatanRepository.save(kecamatanEntity);

        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data Kecamatan " + kecamatanEntity.getNamaKecamatan() + " berhasil dihapus!");
        result.setData(kecamatanEntity);
        return ResponseEntity.ok(result);
    }

}
