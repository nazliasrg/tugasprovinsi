package com.nazli.tugasprovinsi.controller;

import com.nazli.tugasprovinsi.model.dto.KabupatenDto;
import com.nazli.tugasprovinsi.model.entity.KabupatenEntity;
import com.nazli.tugasprovinsi.model.entity.KecamatanEntity;
import com.nazli.tugasprovinsi.repository.KabupatenRepository;
import com.nazli.tugasprovinsi.services.KabupatenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class KabupatenController {
    @Autowired
    private KabupatenService kabupatenService;

    @Autowired
    private KabupatenRepository kabupatenRepository;

//  get all data kabupaten
    @GetMapping("/kabupaten-all")
    public ResponseEntity<?> getAll(){
        List<KabupatenEntity> kabupatenEntityList = kabupatenRepository.findAll();
        return ResponseEntity.ok(kabupatenEntityList);
    }

//  get by id data kabupaten
    @GetMapping("/kabupaten/{id}")
    public ResponseEntity<?> getKabupaten(@PathVariable Integer id){
        KabupatenEntity kabupatenEntity = kabupatenRepository.findById(id).get();
        return ResponseEntity.ok(kabupatenEntity);
    }

//  get by kode data kabupaten
    @GetMapping("/get/kabupaten/{kodeKabupaten}")
    public ResponseEntity<?> getKabupatenByKode(@PathVariable String kodeKabupaten){
        KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(kodeKabupaten);
        return ResponseEntity.ok(kabupatenEntity);
    }

//  get data kabupaten by kodeProvinsi
    @GetMapping("/getkodeprov/kabupaten/{kodeProvinsi}")
    public ResponseEntity<?> getKabupatenByKodeProvinsi(@PathVariable String kodeProvinsi){
        List<KabupatenEntity> kabupatenEntityList = kabupatenRepository.getKabupatenFromKodeProv(kodeProvinsi);
        return ResponseEntity.ok(kabupatenEntityList);
    }

//  insert data kabupaten
    @PostMapping("/insert/kabupaten/{kodeProvinsi}")
    public ResponseEntity<?> insertKabupatenEntity(@PathVariable String kodeProvinsi, @RequestBody KabupatenDto kabupatenDto){
        KabupatenEntity kabupatenEntity = kabupatenService.insertKabupatenEntity(kodeProvinsi, kabupatenDto);
        return ResponseEntity.ok(kabupatenEntity);
    }

//  update data kabupaten
    @PutMapping("/update/kabupaten/{namaKabupaten}")
    public ResponseEntity<?> updateKabupatenEntity(@PathVariable String namaKabupaten, @RequestBody KabupatenDto kabupatenDto){
        KabupatenEntity kabupatenEntity = kabupatenService.updateKabupatenEntity(namaKabupaten, kabupatenDto);
        return ResponseEntity.ok(kabupatenEntity);
    }

//  delete data kabupaten
    @DeleteMapping("/delete/kabupaten/{namaKabupaten}")
    public ResponseEntity<?> deleteKabupatenEntity(@PathVariable String namaKabupaten){
        KabupatenEntity kabupatenEntity = kabupatenRepository.findByNamaKabupaten(namaKabupaten);
        kabupatenEntity.setStatus(0);
        kabupatenRepository.save(kabupatenEntity);
        return ResponseEntity.ok(kabupatenEntity);
    }

}
