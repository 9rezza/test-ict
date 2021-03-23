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
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import com.google.gson.Gson;

/**
 *
 * @author PROSIA
 */
@Entity
@Data
@Table(name = "mobil")
public class Mobil implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "mobil_id", nullable = false)
    private Integer mobilId;
    
    @Column(name = "nama", nullable = true, length = 125)
    private String nama;
    
    @Column(name = "merk", nullable = true, length = 125)
    private String merk;
    
    @Column(name = "harga", nullable = true)
    private Integer harga;
}
