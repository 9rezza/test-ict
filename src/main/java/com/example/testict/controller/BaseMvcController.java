package com.example.testict.controller;

import com.example.testict.repository.KaryawanRepo;
import com.example.testict.repository.MobilRepo;
import com.example.testict.repository.PerusahaanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class BaseMvcController {
    
    @Autowired
    KaryawanRepo karyawanRepo;
    
    @Autowired
    MobilRepo mobilRepo;
    
    @Autowired
    PerusahaanRepo perusahaanRepo;
    
    //    dashboard
    @GetMapping("dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("karyawan")
    public String karyawan(Model model) {
        model.addAttribute("mobil", mobilRepo.findAll());
        model.addAttribute("karyawan", karyawanRepo.findAll());
        return "karyawan";
    }

    @GetMapping("mobil")
    public String mobil(Model model) {
        model.addAttribute("mobil", mobilRepo.findAll());
        return "mobil";
    }

    @GetMapping("perusahaan")
    public String perusahaan(Model model) {
        model.addAttribute("perusahaan", perusahaanRepo.findAll());
        return "perusahaan";
    }


}
