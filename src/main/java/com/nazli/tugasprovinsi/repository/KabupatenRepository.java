package com.nazli.tugasprovinsi.repository;

import com.nazli.tugasprovinsi.model.entity.KabupatenEntity;
import com.nazli.tugasprovinsi.model.entity.KecamatanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface KabupatenRepository extends JpaRepository<KabupatenEntity, Integer> {
    KabupatenEntity findByNamaKabupaten(String namaKabupaten);
    KabupatenEntity findByKodeKabupaten(String kodeKabupaten);
    List<KabupatenEntity> findByStatus(Integer status);

    @Query(value = "SELECT kode_kabupaten FROM tbl_kabupaten WHERE nama_kabupaten = ?", nativeQuery = true)
    KabupatenEntity getKodeKabupatenByNamaKabupaten(String namaKabupaten);

    @Query(value = "SELECT * FROM tbl_kabupaten WHERE kode_provinsi = ?", nativeQuery = true)
    List<KabupatenEntity> getKabupatenFromKodeProv(String kodeProvinsi);
}
