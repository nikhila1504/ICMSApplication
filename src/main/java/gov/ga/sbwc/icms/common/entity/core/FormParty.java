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

/**
 * The persistent class for the FORM_PARTY database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "FORM_PARTY")
public class FormParty extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "FORM_PARTY_ID_GENERATOR", sequenceName = "FORM_PARTY_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FORM_PARTY_ID_GENERATOR")
	@Column(name = "FORM_PARTY_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DOCUMENT_ID")
	private Document document;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PARTY_ID")
	private Party party;

	@ManyToOne
	@JoinColumn(name = "PARENT_PARTY_ID")
	private Party parentParty;

	@ManyToOne
	@JoinColumn(name = "GRAND_PARENT_PARTY_ID")
	private Party grandParentParty;

	@Column(name = "IS_ATTORNEY_FOR_EMPR_INSR")
	private Boolean attorneyForEmprInsr = false;

	public FormParty() {
	}

	public FormParty(Document document, Party party) {
		this.document = document;
		this.party = party;
	}

	public FormParty(Document document, Party party, Party parentParty) {
		this.document = document;
		this.party = party;
		this.parentParty = parentParty;
	}

	public FormParty(Document document, Party party, Party parentParty, Boolean attorneyForEmprInsr) {
		this.document = document;
		this.party = party;
		this.parentParty = parentParty;
		this.attorneyForEmprInsr = attorneyForEmprInsr;
	}

	public FormParty(Document document, Party party, Party parentParty, Party grandParentParty) {
		this.document = document;
		this.party = party;
		this.parentParty = parentParty;
		this.grandParentParty = grandParentParty;
	}

	public FormParty(Document document, Party party, Party parentParty, Party grandParentParty,
			Boolean attorneyForEmprInsr) {
		this.document = document;
		this.party = party;
		this.parentParty = parentParty;
		this.grandParentParty = grandParentParty;
		this.attorneyForEmprInsr = attorneyForEmprInsr;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public Boolean getAttorneyForEmprInsr() {
		return attorneyForEmprInsr;
	}

	public void setAttorneyForEmprInsr(Boolean attorneyForEmprInsr) {
		this.attorneyForEmprInsr = attorneyForEmprInsr;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Party getParentParty() {
		return parentParty;
	}

	public void setParentParty(Party parentParty) {
		this.parentParty = parentParty;
	}

	public Party getGrandParentParty() {
		return grandParentParty;
	}

	public void setGrandParentParty(Party grandParentParty) {
		this.grandParentParty = grandParentParty;
	}
}