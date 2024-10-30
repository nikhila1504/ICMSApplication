package com.icms.party.entity;

import java.io.Serializable;
import java.sql.Timestamp;

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
import javax.persistence.Transient;

/**
 * The persistent class for the DOCUMENT_TYPE database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "DOCUMENT_TYPE")
public class DocumentType extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "DOCUMENT_TYPE_ID_GENERATOR", sequenceName = "DOCUMENT_TYPE_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DOCUMENT_TYPE_ID_GENERATOR")
	@Column(name = "DOCUMENT_TYPE_ID")
	private Long id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DOCUMENT_CATEGORY_TYPE_ID")
	private DocumentCategoryType documentCategory;

	@Column(name = "IS_BOARD_FORM")
	private Boolean boardForm;

	@Column(name = "IS_INITIATING_CLAIM")
	private Boolean initiatingClaim;

	@Column(name = "WORKFLOW_NAME")
	private String workflowName;

	@Column(name = "FORM_NAME")
	private String formName;

	@Column(name = "IS_ROC_ELIGIBLE")
	private Boolean rocEligible = false;

	@Column(name = "IS_SCAN_FORM")
	private Boolean scanForm = false;

	@Column(name = "DISPLAY_ORDER")
	private Long displayOrder;

	@SuppressWarnings("unused")
	@Transient
	private String documentTypeDesc;

	public DocumentType() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDeactiveDate(Timestamp deactiveDate) {
		this.deactiveDate = deactiveDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public String getWorkflowName() {
		return this.workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public DocumentCategoryType getDocumentCategory() {
		return documentCategory;
	}

	public void setDocumentCategory(DocumentCategoryType documentCategory) {
		this.documentCategory = documentCategory;
	}

	public Boolean getBoardForm() {
		return boardForm;
	}

	public void setBoardForm(Boolean boardForm) {
		this.boardForm = boardForm;
	}

	public Boolean getInitiatingClaim() {
		return initiatingClaim;
	}

	public void setInitiatingClaim(Boolean initiatingClaim) {
		this.initiatingClaim = initiatingClaim;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumentTypeDesc() {
		if (this.description != null && this.description.length() > 30) {
			StringBuilder sb = new StringBuilder(this.description);
			int i = 0;
			while (i + 30 < sb.length() && (i = sb.lastIndexOf(" ", i + 30)) != -1) {
				sb.replace(i, i + 1, "<br>");
			}
			return sb.toString();
		} else {
			return this.description;
		}

	}

	public void setDocumentTypeDesc(String documentTypeDesc) {
		this.documentTypeDesc = documentTypeDesc;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public Boolean getRocEligible() {
		return rocEligible;
	}

	public void setRocEligible(Boolean rocEligible) {
		this.rocEligible = rocEligible;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DocumentType))
			return false;
		DocumentType other = (DocumentType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Boolean getScanForm() {
		return scanForm;
	}

	public void setScanForm(Boolean scanForm) {
		this.scanForm = scanForm;
	}

	public Long getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Long displayOrder) {
		this.displayOrder = displayOrder;
	}
}