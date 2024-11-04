package com.icms.party.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import org.hibernate.annotations.Immutable;

/**
 * The persistent class for the NAICS_TYPE database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "NAICS_TYPE")
public class NaicsType extends BaseEntity implements Type, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "NAICS_TYPE_ID_GENERATOR", sequenceName = "NAICS_TYPE_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NAICS_TYPE_ID_GENERATOR")
	@Column(name = "NAICS_TYPE_ID")
	private Long id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "VERSION")
	private int version;

	public NaicsType() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}