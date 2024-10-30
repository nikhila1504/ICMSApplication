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

//import org.hibernate.annotations.Immutable;

/**
 * The persistent class for the CONTROVERT_TYPE database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "CONTROVERT_TYPE")
//@Immutable
@NamedQueries({ 
	@NamedQuery(name = "ControvertType.findAll", query = "select ct from ControvertType ct where ct.recordStatus = 1 order by ct.description asc")

})
public class ControvertType extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CONTROVERT_TYPE_ID_GENERATOR", sequenceName = "CONTROVERT_TYPE_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTROVERT_TYPE_ID_GENERATOR")
	@Column(name = "CONTROVERT_TYPE_ID")
	private Long id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "DESCRIPTION")
	private String description;

	public ControvertType() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getControvertTypeId() {
		return this.id;
	}

	public void setControvertTypeId(long controvertTypeId) {
		this.id = controvertTypeId;
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
}