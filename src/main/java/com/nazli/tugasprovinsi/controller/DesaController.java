package com.nazli.tugasprovinsi.controller;

import com.nazli.tugasprovinsi.model.dto.DesaDto;
import com.nazli.tugasprovinsi.model.entity.DesaEntity;
import com.nazli.tugasprovinsi.repository.DesaRepository;
import com.nazli.tugasprovinsi.services.DesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DesaController {
    @Autowired
    private DesaRepository desaRepository;

    @Autowired
    private DesaService desaService;

//  get all data desa
    @GetMapping("/desa-all")
    public ResponseEntity<?> getAll(){
        List<DesaEntity> desaEntityList = desaRepository.findAll();
        return ResponseEntity.ok(desaEntityList);
    }

//  get by id data desa
    @GetMapping("/desa/{id}")
    public ResponseEntity<?> getDesa(@PathVariable Integer id){
        DesaEntity desaEntity = desaRepository.findById(id).get();
        return ResponseEntity.ok(desaEntity);
    }

//  get by kode data desa
    @GetMapping("/get/desa/{kodeDesa}")
    public ResponseEntity<?> getDesaByKode(@PathVariable String kodeDesa){
        DesaEntity desaEntity = desaRepository.findByKodeDesa(kodeDesa);
        return ResponseEntity.ok(desaEntity);
    }

//  get data desa by kodeKecamatan
    @GetMapping("/getkodekec/desa/{kodeKecamatan}")
    public ResponseEntity<?> getDesaByKodeKecamatan(@PathVariable String kodeKecamatan){
        List<DesaEntity> desaEntityList = desaRepository.getDesaFromKodeKec(kodeKecamatan);
        return ResponseEntity.ok(desaEntityList);
    }

//  get data desa by kodeKabupaten
    @GetMapping("/getkodekab/desa/{kodeKabupaten}")
    public ResponseEntity<?> getDesaByKodeKabupaten(@PathVariable String kodeKabupaten){
        List<DesaEntity> desaEntityList = desaRepository.getDesaFromKodeKab(kodeKabupaten);
        return ResponseEntity.ok(desaEntityList);
    }

//  get data desa by kodeProvinsi
    @GetMapping("/getkodeprov/desa/{kodeProvinsi}")
    public ResponseEntity<?> getDesaByKodeProvinsi(@PathVariable String kodeProvinsi){
        List<DesaEntity> desaEntityList = desaRepository.getDesaFromKodeProv(kodeProvinsi);
        return ResponseEntity.ok(desaEntityList);
    }

//  insert data desa
    @PostMapping("/insert/desa/{kodeProvinsi}/{kodeKabupaten}/{kodeKecamatan}")
    public ResponseEntity<?> insertDesaEntity(@PathVariable String kodeProvinsi, @PathVariable String kodeKabupaten, @PathVariable String kodeKecamatan, @RequestBody DesaDto desaDto){
        DesaEntity desaEntity = desaService.insertDesaEntity(kodeProvinsi, kodeKabupaten, kodeKecamatan, desaDto);
        return ResponseEntity.ok(desaEntity);
    }

//  update data desa
    @PutMapping("/update/desa/{namaDesa}")
    public ResponseEntity<?> updateKecamatanEntity(@PathVariable String namaDesa, @RequestBody DesaDto desaDto){
        DesaEntity desaEntity = desaService.updateDesaEntity(namaDesa, desaDto);
        return ResponseEntity.ok(desaEntity);
    }

//  delete data kecamatan
    @DeleteMapping("/delete/desa/{namaDesa}")
    public ResponseEntity<?> deleteDesaEntity(@PathVariable String namaDesa){
        DesaEntity desaEntity = desaRepository.findByNamaDesa(namaDesa);
        desaEntity.setStatus(0);
        desaRepository.save(desaEntity);
        return ResponseEntity.ok(desaEntity);
    }

}
