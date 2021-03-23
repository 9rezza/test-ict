/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testict.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author PROSIA
 */
//@Embeddable
@Entity
@Data
@Table(name = "mobil_karyawan")
public class MobilKaryawan implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "mobil_karyawan_id", nullable = false)
    private Integer mobilKaryawanId;
    
    @JoinColumn(name = "karyawan_id", referencedColumnName = "karyawan_id")
    @ManyToOne
    private Karyawan karyawanId;
    
    @JoinColumn(name = "mobil_id", referencedColumnName = "mobil_id")
    @ManyToOne
    private Mobil mobilId;
}
