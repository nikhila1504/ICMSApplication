package com.icms.party.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the CLAIM_TYPE database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "CLAIM_TYPE")
@NamedQueries({
		@NamedQuery(name = "ClaimType.findAll", query = "select ct from ClaimType ct where ct.recordStatus = 1 order by ct.description asc"),
		@NamedQuery(name = "ClaimType.findByCode", query = "select ct from ClaimType ct where ct.code = :code") })
public class ClaimType extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CLAIM_TYPE_ID_GENERATOR", sequenceName = "CLAIM_TYPE_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLAIM_TYPE_ID_GENERATOR")
	@Column(name = "CLAIM_TYPE_ID")
	private Long id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "DESCRIPTION")
	private String description;

	public ClaimType() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ClaimType))
			return false;
		ClaimType other = (ClaimType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return (id != null) ? (this.getClass().hashCode() + id.hashCode()) : super.hashCode();
	}

	@Override
	public String toString() {
		return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	}

}