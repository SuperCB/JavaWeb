package com.supercb.alweb.data;

import lombok.Data;
import org.hibernate.query.criteria.internal.expression.function.LengthFunction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bman")
@Data
public class Bman {
	@Id
	private String id;
	@Column(length = 20)
	private String passwd;
	private String name;
}