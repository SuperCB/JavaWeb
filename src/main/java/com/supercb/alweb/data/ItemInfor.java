package com.supercb.alweb.data;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
@Data
public class ItemInfor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String name;

    private Double price;

    private String location;

    private String companyname;

    private Integer messagecount;
    private String bmid;
    private String description;
}
