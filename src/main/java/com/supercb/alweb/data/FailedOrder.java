package com.supercb.alweb.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class FailedOrder {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String userid;
    private String bmanid;
    private String itemname;
    private Integer itemid;
    private String date;
    private Integer timelong;
}
