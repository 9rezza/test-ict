

package com.example.testict.repository;

import com.example.testict.model.Mobil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilRepo extends JpaRepository<Mobil, Long> {
    public Mobil findTop1ByMobilId(Integer mobilId);
    public void deleteTop1ByMobilId(Integer mobilId);
}