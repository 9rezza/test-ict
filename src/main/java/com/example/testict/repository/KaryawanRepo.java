package com.example.testict.repository;

import com.example.testict.model.Karyawan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanRepo extends JpaRepository<Karyawan, Long> {

    public Karyawan findTop1ByKaryawanId(Integer karyawanId);

    public void deleteTop1ByKaryawanId(Integer karyawanId);

    @Query(value = "SELECT "
            + "         jenis_kelamin, count(karyawan_id) as jumlah"
            + "     FROM karyawan "
            + "     Group By jenis_kelamin", nativeQuery = true)
    public List<Object> findKaryawanGroupByJenisKelamin();

    @Query(value = "SELECT "
            + "         c.nama, count(a.mobil_karyawan_id) as jumlah"
            + "     FROM mobil_karyawan a"
            + "     JOIN mobil b on a.mobil_id = b.mobil_id"
            + "     JOIN karyawan c on a.karyawan_id = c.karyawan_id"
            + "     Group By c.nama, c.karyawan_id", nativeQuery = true)
    public List<Object> findMobilKaryawanGroupByKaryawanId();

    @Query(value = "SELECT "
            + "         c.nama, sum(b.harga) as jumlah"
            + "     FROM mobil_karyawan a"
            + "     JOIN mobil b on a.mobil_id = b.mobil_id"
            + "     JOIN karyawan c on a.karyawan_id = c.karyawan_id"
            + "     Group By c.nama, c.karyawan_id", nativeQuery = true)
    public List<Object> findAssetGroupByKaryawanId();

    @Query(value = "SELECT "
            + "         b.nama, count(a.karyawan_id) as jumlah"
            + "     FROM karyawan a"
            + "     JOIN perusahaan b on a.perusahaan_id = b.perusahaan_id"
            + "     Group By b.nama, b.perusahaan_id", nativeQuery = true)
    public List<Object> findKaryawanGroupByPerusahaanId();

    @Query(value = "SELECT "
            + "         b.nama, count(a.mobil_karyawan_id) as jumlah"
            + "     FROM mobil_karyawan a"
            + "     JOIN mobil b on a.mobil_id = b.mobil_id"
            + "     Group BY b.nama, b.mobil_id"
            + "     ORDER BY count(a.mobil_karyawan_id) DESC"
            + "     LIMIT 5", nativeQuery = true)
    public List<Object> findMobilKaryawanGroupByMobilId();
}
