package com.icms.party.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the CLAIM_STATUS_TYPE database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "CLAIM_STATUS_TYPE")
public class ClaimStatusType extends BaseEntity implements Type, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CLAIM_STATUS_TYPE_ID_GENERATOR", sequenceName = "CLAIM_STATUS_TYPE_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLAIM_STATUS_TYPE_ID_GENERATOR")
	@Column(name = "CLAIM_STATUS_TYPE_ID")
	private Long id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "EDI_CODE")
	private String ediCode;

	public ClaimStatusType() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code != null ? code.toUpperCase() : null;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEdiCode() {
		return ediCode;
	}

	public void setEdiCode(String ediCode) {
		this.ediCode = ediCode;
	}
}