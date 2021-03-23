/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testict.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import javax.persistence.CascadeType;
//import org.hibernate.annotations.CascadeType;

/**
 *
 * @author PROSIA
 */
@Entity
@Data
@Table(name = "karyawan")
public class Karyawan implements Serializable {

    public enum JenisKelamin {
        L,
        P
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "karyawan_id", nullable = false)
    private Integer karyawanId;

    @Column(name = "nama", nullable = true, length = 125)
    private String nama;

    @Column(name = "jenis_kelamin", nullable = true)
    @Enumerated(EnumType.STRING)
    private Karyawan.JenisKelamin jenisKelamin;

    @Column(name = "tempat_lahir", nullable = true, length = 125)
    private String tempatLahir;

    @Column(name = "tanggal_lahir", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date tanggalLahir;

    @Column(name = "alamat_rumah", nullable = true, length = 125)
    private String alamatRumah;

    @Column(name = "nomor_handphone", nullable = true, length = 125)
    private String nomorHandphone;

    @JoinColumn(name = "perusahaan_id", referencedColumnName = "perusahaan_id", nullable = true)
    @ManyToOne
    private Perusahaan perusahaanId;
}
