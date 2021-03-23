package com.example.testict.controller;

import com.example.testict.exception.ResourceNotFoundException;
import com.example.testict.model.Perusahaan;
import com.example.testict.repository.PerusahaanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/perusahaan")
public class PerusahaanMBean {

    @Autowired
    PerusahaanRepo perusahaanRepo;

    @GetMapping()
    public List<Perusahaan> getAllPerusahaan() {
        return perusahaanRepo.findAll();
    }

    @PostMapping()
    public Perusahaan savePerusahaan(@Valid @RequestBody Perusahaan perusahaan) {
        return perusahaanRepo.save(perusahaan);
    }

    @GetMapping("/{perusahaan_id}")
    public Perusahaan getPerusahaanByPerusahaanId(@PathVariable(value = "perusahaan_id") Integer perusahaanId) {
        return perusahaanRepo.findTop1ByPerusahaanId(perusahaanId);
//                .orElseThrow(() -> new ResourceNotFoundException("Perusahaan", "perusahaan_id", perusahaanId));
    }
    
    @Transactional
    @DeleteMapping("/{perusahaan_id}")
    public Boolean deletePerusahaanByPerusahaanId(@PathVariable(value = "perusahaan_id") Integer perusahaanId) {
        perusahaanRepo.deleteTop1ByPerusahaanId(perusahaanId);
        return true;
    }
}
