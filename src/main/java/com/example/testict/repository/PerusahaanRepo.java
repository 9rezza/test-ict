

package com.example.testict.repository;

import com.example.testict.model.Perusahaan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerusahaanRepo extends JpaRepository<Perusahaan, Long> {
    public Perusahaan findTop1ByPerusahaanId(Integer perusahaanId);
    public void deleteTop1ByPerusahaanId(Integer perusahaanId);
}