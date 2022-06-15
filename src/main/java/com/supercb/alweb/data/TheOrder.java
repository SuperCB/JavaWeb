package com.supercb.alweb.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class TheOrder {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String userid;
    private String bmid;
    private Integer itemid;
    private String itemname;
    private Integer situation;
    private Double ensureprice;
    private Double price;
    private String question;
    private String date;
    private String companyname;
}
