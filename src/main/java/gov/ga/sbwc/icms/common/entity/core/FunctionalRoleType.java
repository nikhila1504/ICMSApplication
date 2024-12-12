package gov.ga.sbwc.icms.common.entity.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the "FUNCTIONAL_ROLE_TYPE" database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "FUNCTIONAL_ROLE_TYPE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FunctionalRoleType extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "FUNCTIONAL_ROLE_TYPE_ID_GENERATOR", sequenceName = "FUNCTIONAL_ROLE_TYPE_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FUNCTIONAL_ROLE_TYPE_ID_GENERATOR")
	@Column(name = "FUNCTIONAL_ROLE_TYPE_ID")
	private Long id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DIVISION_TYPE_ID")
	private DivisionType division;

	public FunctionalRoleType() {
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
		if (!(obj instanceof FunctionalRoleType))
			return false;
		FunctionalRoleType other = (FunctionalRoleType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public DivisionType getDivision() {
		return division;
	}

	public void setDivision(DivisionType division) {
		this.division = division;
	}

}