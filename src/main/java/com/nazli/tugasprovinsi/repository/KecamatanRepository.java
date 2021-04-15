package com.nazli.tugasprovinsi.repository;

import com.nazli.tugasprovinsi.model.entity.DesaEntity;
import com.nazli.tugasprovinsi.model.entity.KecamatanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KecamatanRepository extends JpaRepository<KecamatanEntity, Integer> {
    KecamatanEntity findByNamaKecamatan(String namaKecamatan);
    KecamatanEntity findByKodeKecamatan(String kodeKecamatan);

    @Query(value = "SELECT * FROM tbl_kecamatan WHERE kode_provinsi = ?", nativeQuery = true)
    List<KecamatanEntity> getKecamatanFromKodeProv(String kodeProvinsi);

    @Query(value = "SELECT * FROM tbl_kecamatan WHERE kode_kabupaten = ?", nativeQuery = true)
    List<KecamatanEntity> getKecamatanFromKodeKab(String kodeKabupaten);
}
