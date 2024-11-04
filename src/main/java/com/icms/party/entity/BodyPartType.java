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
 * The persistent class for the BODY_PART_TYPE database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "BODY_PART_TYPE")
public class BodyPartType extends BaseEntity implements Type, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "BODY_PART_TYPE_ID_GENERATOR", sequenceName = "BODY_PART_TYPE_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BODY_PART_TYPE_ID_GENERATOR")
	@Column(name = "BODY_PART_TYPE_ID")
	private Long id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "MAXIMUM_WEEKS")
	private Integer maximumWeeks;

	@Column(name = "IS_PERMANENT_IMPAIRMENT")
	private Boolean permanentImpairment;

	@Column(name = "IS_GEORGIA_PI")
	private Boolean georgiaPI;

	@Column(name = "DISPLAY_ORDER")
	private Integer displayOrder;

	public BodyPartType() {
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
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMaximumWeeks() {
		return maximumWeeks;
	}

	public void setMaximumWeeks(Integer maximumWeeks) {
		this.maximumWeeks = maximumWeeks;
	}

	public Boolean getPermanentImpairment() {
		return permanentImpairment;
	}

	public void setPermanentImpairment(Boolean permanentImpairment) {
		this.permanentImpairment = permanentImpairment;
	}

	public Boolean getGeorgiaPI() {
		return georgiaPI;
	}

	public void setGeorgiaPI(Boolean georgiaPI) {
		this.georgiaPI = georgiaPI;
	}

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BodyPartType))
			return false;
		BodyPartType other = (BodyPartType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
}