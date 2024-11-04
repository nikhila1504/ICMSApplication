package com.icms.party.entity;

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
import javax.persistence.Transient;

/**
 * The persistent class for the CLAIM_PARTY database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "CLAIM_PARTY")
public class ClaimParty extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CLAIM_PARTY_ID_GENERATOR", sequenceName = "CLAIM_PARTY_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLAIM_PARTY_ID_GENERATOR")
	@Column(name = "CLAIM_PARTY_ID", nullable = false, unique = true)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "DOCUMENT_ID")
	private Document document;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PARTY_ID")
	private Party party;

	// bi-directional many-to-one association to Claim
	@ManyToOne
	@JoinColumn(name = "CLAIM_ID")
	private Claim claim;

	@ManyToOne
	@JoinColumn(name = "PARENT_PARTY_ID")
	private Party parentParty;

	@ManyToOne
	@JoinColumn(name = "GRAND_PARENT_PARTY_ID")
	private Party grandParentParty;

	@Column(name = "IS_FORMER")
	private Boolean former = false;

	@Column(name = "IS_ATTORNEY_FOR_EMPR_INSR")
	private Boolean attorneyForEmprInsr = false;

	@Column(name = "IS_PRINT")
	private Boolean print = false;

	@ManyToOne
	@JoinColumn(name = "PARTY_REPRESENT_AS")
	private PartyType partyRepresentAs;

	@Transient
	private boolean delete;

	@Transient
	private boolean select;

	@Transient
	private String contactMethod;

	@Transient
	private boolean enableSelectOption = false;

	@Transient
	private boolean employerAdded = false;

	@Transient
	private boolean insurerAdded = false;

	@Transient
	private boolean claimsOfficeAdded = false;

	@Transient
	private boolean attorneyAdded = false;

	public ClaimParty() {
	}

	public ClaimParty(Claim claim, Party party, Party parentParty) {
		this.claim = claim;
		this.party = party;
		this.parentParty = parentParty;
	}

	public ClaimParty(Claim claim, Document document, Party party) {
		this.claim = claim;
		this.document = document;
		this.party = party;
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

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
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

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public String getContactMethod() {
		return contactMethod;
	}

	public void setContactMethod(String contactMethod) {
		this.contactMethod = contactMethod;
	}

	public boolean isEnableSelectOption() {
		return enableSelectOption;
	}

	public void setEnableSelectOption(boolean enableSelectOption) {
		this.enableSelectOption = enableSelectOption;
	}

	public Boolean getFormer() {
		return former;
	}

	public void setFormer(Boolean former) {
		this.former = former;
	}

	public boolean isInsurerAdded() {
		return insurerAdded;
	}

	public void setInsurerAdded(boolean insurerAdded) {
		this.insurerAdded = insurerAdded;
	}

	public Boolean getPrint() {
		return print;
	}

	public void setPrint(Boolean print) {
		this.print = print;
	}

	public boolean isClaimsOfficeAdded() {
		return claimsOfficeAdded;
	}

	public void setClaimsOfficeAdded(boolean claimsOfficeAdded) {
		this.claimsOfficeAdded = claimsOfficeAdded;
	}

	public PartyType getPartyRepresentAs() {
		return partyRepresentAs;
	}

	public void setPartyRepresentAs(PartyType partyRepresentAs) {
		this.partyRepresentAs = partyRepresentAs;
	}

	public Boolean getAttorneyForEmprInsr() {
		return attorneyForEmprInsr;
	}

	public void setAttorneyForEmprInsr(Boolean attorneyForEmprInsr) {
		this.attorneyForEmprInsr = attorneyForEmprInsr;
	}

	@Override
	public int hashCode() {
		String str = (this.getClaim() != null ? this.getClaim().getClaimNo() : "") + this.getParty().getId()
				+ (this.getParentParty() != null ? this.getParentParty().getId() : "");
		return str.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == (obj != null ? obj.hashCode() : null);
	}

	public Party getGrandParentParty() {
		return grandParentParty;
	}

	public void setGrandParentParty(Party grandParentParty) {
		this.grandParentParty = grandParentParty;
	}

	public boolean isEmployerAdded() {
		return employerAdded;
	}

	public void setEmployerAdded(boolean employerAdded) {
		this.employerAdded = employerAdded;
	}

	public boolean isAttorneyAdded() {
		return attorneyAdded;
	}

	public void setAttorneyAdded(boolean attorneyAdded) {
		this.attorneyAdded = attorneyAdded;
	}

}