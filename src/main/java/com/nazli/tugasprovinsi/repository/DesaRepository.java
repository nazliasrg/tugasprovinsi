package com.nazli.tugasprovinsi.repository;

import com.nazli.tugasprovinsi.model.entity.DesaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesaRepository extends JpaRepository<DesaEntity, Integer> {
    DesaEntity findByNamaDesa(String namaDesa);
    DesaEntity findByKodeDesa(String kodeDesa);
    List<DesaEntity> findByStatus(Integer status);

    @Query(value = "SELECT * FROM tbl_desa WHERE kode_provinsi = ?", nativeQuery = true)
    List<DesaEntity> getDesaFromKodeProv(String kodeProvinsi);

    @Query(value = "SELECT * FROM tbl_desa WHERE kode_kabupaten = ?", nativeQuery = true)
    List<DesaEntity> getDesaFromKodeKab(String kodeKabupaten);

    @Query(value = "SELECT * FROM tbl_desa WHERE kode_kecamatan = ?", nativeQuery = true)
    List<DesaEntity> getDesaFromKodeKec(String kodeKecamatan);
}
