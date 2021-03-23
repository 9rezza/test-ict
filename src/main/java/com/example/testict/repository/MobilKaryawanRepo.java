

package com.example.testict.repository;

import com.example.testict.model.Karyawan;
import com.example.testict.model.MobilKaryawan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilKaryawanRepo extends JpaRepository<MobilKaryawan, Long> {
    public MobilKaryawan findTop1ByMobilKaryawanId(Integer mobilKaryawanId);
    public List<MobilKaryawan> findAllByKaryawanId(Karyawan karyawanId);
    public void deleteByKaryawanId(Karyawan karyawanId);
}