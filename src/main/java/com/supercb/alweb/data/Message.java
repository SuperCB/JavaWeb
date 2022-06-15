package com.supercb.alweb.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Message {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private Integer itemid;
    private Integer identity;
    private String content;
    private String speakerId;
    private String date;
}
