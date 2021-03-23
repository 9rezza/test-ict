package com.example.testict.controller;

import com.example.testict.exception.ResourceNotFoundException;
import com.example.testict.model.Karyawan;
import com.example.testict.model.Mobil;
import com.example.testict.model.MobilKaryawan;
import com.example.testict.model.Perusahaan;
import com.example.testict.repository.KaryawanRepo;
import com.example.testict.repository.MobilKaryawanRepo;
import com.example.testict.repository.MobilRepo;
import com.example.testict.repository.PerusahaanRepo;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.ui.Model;

@RestController
@RequestMapping("/api/karyawan")
public class KaryawanMBean {

    @Autowired
    KaryawanRepo karyawanRepo;

    @Autowired
    MobilRepo mobilRepo;

    @Autowired
    MobilKaryawanRepo mobilKaryawanRepo;

    @Autowired
    PerusahaanRepo perusahaanRepo;

    @GetMapping()
    public List<Karyawan> getAllKaryawan() {
        List<Karyawan> listKaryawan = karyawanRepo.findAll();
        return listKaryawan;
    }

    @GetMapping("/mobil/{karyawan_id}")
    public List<MobilKaryawan> getAllMobilKaryawan(@PathVariable(value = "karyawan_id") Integer karyawanId) {
        Karyawan karyawan = karyawanRepo.findTop1ByKaryawanId(karyawanId);
        List<MobilKaryawan> listMobilKaryawan = mobilKaryawanRepo.findAllByKaryawanId(karyawan);
        return listMobilKaryawan;
    }

    @PostMapping()
    public Karyawan saveKaryawan(@Valid @RequestBody Karyawan karyawan) {
        Perusahaan perusahaan = perusahaanRepo.findTop1ByPerusahaanId(karyawan.getPerusahaanId().getPerusahaanId());
        karyawan.setPerusahaanId(perusahaan);
        return karyawanRepo.save(karyawan);
    }

    @Transactional
    @PostMapping("/mobil")
    public List<MobilKaryawan> saveMobilKaryawan(@Valid @RequestBody List<MobilKaryawan> listMobilKaryawan) {
        if (listMobilKaryawan.size() > 0) {
            Karyawan karyawan = karyawanRepo.findTop1ByKaryawanId(listMobilKaryawan.get(0).getKaryawanId().getKaryawanId());
            mobilKaryawanRepo.deleteByKaryawanId(karyawan);
            for (MobilKaryawan mobilKaryawan : listMobilKaryawan) {
                Mobil mobil = mobilRepo.findTop1ByMobilId(mobilKaryawan.getMobilId().getMobilId());
                mobilKaryawan.setMobilId(mobil);
                mobilKaryawan.setKaryawanId(karyawan);
            }
            return mobilKaryawanRepo.saveAll(listMobilKaryawan);
        } else {
            return null;
        }
    }

    @GetMapping("/{karyawan_id}")
    public Karyawan getKaryawanByKaryawanId(@PathVariable(value = "karyawan_id") Integer karyawanId) {
        Karyawan karyawan = karyawanRepo.findTop1ByKaryawanId(karyawanId);
        return karyawan;
    }

    @Transactional
    @DeleteMapping("/{karyawan_id}")
    public Boolean deleteKaryawan(@PathVariable(value = "karyawan_id") Integer karyawanId) {
        Karyawan karyawan = karyawanRepo.findTop1ByKaryawanId(karyawanId);
        mobilKaryawanRepo.deleteByKaryawanId(karyawan);
        karyawanRepo.deleteTop1ByKaryawanId(karyawanId);
        return true;
    }

    @GetMapping("/p_dan_l")
    public List<Object> getAllKaryawanGroupByJenisKelamin() {
        List<Object> listObject = karyawanRepo.findKaryawanGroupByJenisKelamin();
        return listObject;
    }

    @GetMapping("/jumlah_mobil_karyawan")
    public List<Object> getAllMobilKaryawanGroupByMobilId() {
        List<Object> listObject = karyawanRepo.findMobilKaryawanGroupByKaryawanId();
        return listObject;
    }

    @GetMapping("/jumlah_asset_karyawan")
    public List<Object> getAssetKaryawanGroupByMobilId() {
        List<Object> listObject = karyawanRepo.findAssetGroupByKaryawanId();
        return listObject;
    }

    @GetMapping("/jumlah_karyawan_perusahaan")
    public List<Object> getKaryawanGroupByPerusahaanId() {
        List<Object> listObject = karyawanRepo.findKaryawanGroupByPerusahaanId();
        return listObject;
    }

    @GetMapping("/mobil_populer")
    public List<Object> getMobilKaryawanGroupByMobilId() {
        List<Object> listObject = karyawanRepo.findMobilKaryawanGroupByMobilId();
        return listObject;
    }
}
