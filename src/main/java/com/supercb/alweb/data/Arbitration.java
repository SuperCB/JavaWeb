package com.supercb.alweb.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Arbitration {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    private String userid;
    private String bmid;
    private Integer itemid;
    private Integer orderid;
    private String itemname;
    private String question;
    private String result;
}
