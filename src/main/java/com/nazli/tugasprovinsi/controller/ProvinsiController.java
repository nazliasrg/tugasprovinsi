package com.nazli.tugasprovinsi.controller;

import com.nazli.tugasprovinsi.model.dto.AllDto;
import com.nazli.tugasprovinsi.model.dto.ProvinsiDto;
import com.nazli.tugasprovinsi.model.dto.StatusMessageDto;
import com.nazli.tugasprovinsi.model.entity.ProvinsiEntity;
import com.nazli.tugasprovinsi.repository.ProvinsiRepository;
import com.nazli.tugasprovinsi.services.AllService;
import com.nazli.tugasprovinsi.services.ProvinsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ProvinsiController {
    @Autowired
    private ProvinsiRepository provinsiRepository;

    @Autowired
    private ProvinsiService provinsiService;

    @Autowired
    private AllService allService;

//  get all data provinsi
    @GetMapping("/provinsi-all")
    public ResponseEntity<?> getAll(){
        List<ProvinsiEntity> provinsiEntityList = provinsiRepository.findAll();
        return ResponseEntity.ok(provinsiEntityList);
    }

//  get by id data provinsi
    @GetMapping("/provinsi/{id}")
    public ResponseEntity<?> getProvinsi(@PathVariable Integer id){
        ProvinsiEntity provinsiEntity = provinsiRepository.findById(id).get();
        return ResponseEntity.ok(provinsiEntity);
    }

//  get by kode data provinsi
    @GetMapping("/get/provinsi/{kodeProvinsi}")
    public ResponseEntity<?> getProvinsiByKode(@PathVariable String kodeProvinsi){
        ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(kodeProvinsi);
        return ResponseEntity.ok(provinsiEntity);
    }

//  insert data provinsi
    @PostMapping("/insert/provinsi")
    public ResponseEntity<?> insertProvinsiEntity(@RequestBody ProvinsiDto provinsiDto){

        StatusMessageDto<ProvinsiEntity> result = new StatusMessageDto<>();
        try{
            return provinsiService.insertProvinsiEntity(provinsiDto);
        }catch (Exception e){
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

//  update data provinsi
    @PutMapping("/update/provinsi/{id}")
    public ResponseEntity<?> updateProvinsiEntity(@PathVariable Integer id, @RequestBody ProvinsiDto provinsiDto){
        StatusMessageDto<ProvinsiEntity> result = new StatusMessageDto<>();
        try{
            return provinsiService.updateProvinsiEntity(id, provinsiDto);
        }catch (Exception e){
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

//  delete data provinsi
    @DeleteMapping("/delete/provinsi/{namaProvinsi}")
    public ResponseEntity<?> deleteProvinsiEntity(@PathVariable String namaProvinsi){
        StatusMessageDto<ProvinsiEntity> result = new StatusMessageDto<>();
        ProvinsiEntity provinsiEntity = provinsiRepository.findByNamaProvinsi(namaProvinsi);
        provinsiEntity.setStatus(0);
        provinsiRepository.save(provinsiEntity);

        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data Provinsi " + provinsiEntity.getNamaProvinsi() + " berhasil dihapus!");
        result.setData(provinsiEntity);
        return ResponseEntity.ok(result);
    }

//  insert all data
    @PostMapping("/insert/all-data")
    public ResponseEntity<?> insertAllData(@RequestBody AllDto allDto){
        StatusMessageDto<ProvinsiEntity> result = new StatusMessageDto<>();
        try{
            return allService.addAllData(allDto);
        }catch (Exception e){
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }
}
