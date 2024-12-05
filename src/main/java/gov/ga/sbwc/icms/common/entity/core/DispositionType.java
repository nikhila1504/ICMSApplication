package gov.ga.sbwc.icms.common.entity.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import org.hibernate.annotations.Immutable;

/**
 * The persistent class for the DISPOSITION_TYPE database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "DISPOSITION_TYPE")
public class DispositionType extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "DISPOSITION_TYPE_ID_GENERATOR", sequenceName = "DISPOSITION_TYPE_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DISPOSITION_TYPE_ID_GENERATOR")
	@Column(name = "DISPOSITION_TYPE_ID")
	private Long id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToOne
	@JoinColumn(name = "DISPOSITION_CATEGORY_TYPE_ID")
	private DispositionCategoryType dispositionCategoryType;

	public DispositionType() {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DispositionCategoryType getDispositionCategoryType() {
		return dispositionCategoryType;
	}

	public void setDispositionCategoryType(DispositionCategoryType dispositionCategoryType) {
		this.dispositionCategoryType = dispositionCategoryType;
	}

}