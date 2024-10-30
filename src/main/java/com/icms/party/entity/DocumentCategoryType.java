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
 * The persistent class for the FORM_CATEGORY_TYPE database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "DOCUMENT_CATEGORY_TYPE")
public class DocumentCategoryType extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "DOCUMENT_CATEGORY_TYPE_ID_GENERATOR", sequenceName = "DOCUMENT_CATEGORY_TYPE_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DOCUMENT_CATEGORY_TYPE_ID_GENERATOR")
	@Column(name = "DOCUMENT_CATEGORY_TYPE_ID")
	private Long id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "DESCRIPTION")
	private String description;

	public DocumentCategoryType() {
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DocumentCategoryType))
			return false;
		DocumentCategoryType other = (DocumentCategoryType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}