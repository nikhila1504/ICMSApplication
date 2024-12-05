package gov.ga.sbwc.icms.common.entity.core;

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
 * The persistent class for the TREATMENT_TYPE database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "TREATMENT_TYPE")
//@Immutable
@NamedQueries({
	@NamedQuery(name = "TreatmentType.findAll", query = "select tt from TreatmentType tt where tt.recordStatus = 1 order by tt.description asc"),
	@NamedQuery(name = "TreatmentType.findByCode", query = "select tt from TreatmentType tt where tt.code =:code ")
})
public class TreatmentType extends BaseEntity implements Type, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "TREATMENT_TYPE_ID_GENERATOR", sequenceName = "TREATMENT_TYPE_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TREATMENT_TYPE_ID_GENERATOR")
	@Column(name = "TREATMENT_TYPE_ID")
	private Long id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "DESCRIPTION")
	private String description;

	public TreatmentType() {
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

}