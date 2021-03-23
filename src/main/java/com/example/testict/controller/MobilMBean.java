package com.example.testict.controller;

import com.example.testict.exception.ResourceNotFoundException;
import com.example.testict.model.Mobil;
import com.example.testict.repository.MobilRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/mobil")
public class MobilMBean {

    @Autowired
    MobilRepo mobilRepo;

    @GetMapping()
    public List<Mobil> getAllMobil() {
        return mobilRepo.findAll();
    }

    @PostMapping()
    public Mobil saveMobil(@Valid @RequestBody Mobil mobil) {
        return mobilRepo.save(mobil);
    }

    @GetMapping("/{mobil_id}")
    public Mobil getMobilByMobilId(@PathVariable(value = "mobil_id") Integer mobilId) {
        return mobilRepo.findTop1ByMobilId(mobilId);
//                .orElseThrow(() -> new ResourceNotFoundException("Mobil", "mobilId", mobilId));
    }
    
    @Transactional
    @DeleteMapping("/{mobil_id}")
    public Boolean deleteMobilByMobilId(@PathVariable(value = "mobil_id") Integer mobilId) {
        mobilRepo.deleteTop1ByMobilId(mobilId);
        return true;
    }
}
