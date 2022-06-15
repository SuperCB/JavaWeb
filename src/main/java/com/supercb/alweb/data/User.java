package com.supercb.alweb.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class User {
    @Id
    private String id;
    /**
     *
     */
    @Column(length = 20)
    private String passwd;

}
