package com.nazli.tugasprovinsi.repository;

import com.nazli.tugasprovinsi.model.entity.ProvinsiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinsiRepository extends JpaRepository<ProvinsiEntity, Integer> {
    ProvinsiEntity findByNamaProvinsi(String namaProvinsi);
    ProvinsiEntity findByKodeProvinsi(String kodeProvinsi);

    @Query(value = "SELECT kode_provinsi FROM tbl_provinsi WHERE nama_provinsi = ?", nativeQuery = true)
    ProvinsiEntity getKodeProvinsi(String namaProvinsi);
}
