package com.icms.party.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnTransformer;

import com.icms.party.util.DataConversionUtil;

/**
 * The persistent class for the PARTY database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "PARTY")
public class Party extends BaseEntity implements Serializable, Comparable<Party> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PARTY_ID_GENERATOR", sequenceName = "PARTY_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARTY_ID_GENERATOR")
	@Column(name = "PARTY_ID")
	private Long id;

	@Column(name = "BAR_NUMBER", unique = true)
	private String barNumber;

	@Column(name = "PARTY_NAME")
	@ColumnTransformer(forColumn = "PARTY_NAME", write = "TRIM(UPPER(?))")
	private String partyName;

	@Column(name = "DOING_BUSINESS_AS")
	@ColumnTransformer(forColumn = "DOING_BUSINESS_AS", write = "TRIM(UPPER(?))")
	private String doingBusinessAs;

	@Column(name = "FEDERAL_EIN", unique = true)
	private String federalEin;

	@Column(name = "SBWC_NUMBER", unique = true)
	private String sbwcNumber;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CONTACT_ID")
	private Contact contact;

	@ManyToOne
	@JoinColumn(name = "RELATION_TYPE")
	private RelationType relationType;

	@ManyToOne
	@JoinColumn(name = "REHAB_TYPE_ID")
	private RehabType rehabType;

	@ManyToOne
	@JoinColumn(name = "PARTY_TYPE_ID")
	private PartyType partyType;

	@JoinTable(name = "INSURER_CLAIMS_OFFICE", joinColumns = {
			@JoinColumn(name = "INSURER_ID", referencedColumnName = "PARTY_ID", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "CLAIMS_OFFICE_ID", referencedColumnName = "PARTY_ID", nullable = false) })
	@ManyToMany
	private Collection<Party> claimOfficeCollection;

	@ManyToMany(mappedBy = "claimOfficeCollection")
	private Collection<Party> insuranceCollection;

	@Column(name = "IS_SELF_INSURED")
	private Boolean selfInsured = false;

	@Column(name = "IS_SELF_EMPLOYED")
	private Boolean selfEmployed = false;

	@Column(name = "IS_SELF_ADMINISTERED")
	private Boolean selfAdministered = false;

	@Column(name = "IS_GROUP_FUND_MEMBER")
	private Boolean groupFundMember = false;

	@Column(name = "CCM_EXPIRATION_DATE")
	private Date ccmExpirationDate;

	@Column(name = "CDMS_EXPIRATION_DATE")
	private Date cdmsExpirationDate;

	@Column(name = "CLOSE_DATE")
	private Date closeDate;

	@Column(name = "COHN_EXPIRATION_DATE")
	private Date cohnExpirationDate;

	@Column(name = "COHNS_EXPIRATION_DATE")
	private Date cohnsExpirationDate;

	@Column(name = "CRC_EXPIRATION_DATE")
	private Date crcExpirationDate;

	@Column(name = "CRRN_EXPIRATION_DATE")
	private Date crrnExpirationDate;

	@Column(name = "CWAVES_EXPIRATION_DATE")
	private Date cwavesExpirationDate;

	@Column(name = "LPC_EXPIRATION_DATE")
	private Date lpcExpirationDate;

	@Column(name = "EXPIRATION_DATE")
	private Date expirationDate;

	@Column(name = "EFFECTIVE_DATE")
	private Date effectiveDate;

	@Column(name = "ASSESSED_CLOSE_DATE")
	private Date assessedCloseDate;

	@Column(name = "IS_EDI_TRADING_PARTNER")
	private Boolean isTradingPartner = false;

	@Column(name = "IS_INTERNAL_USE")
	private Boolean internalUseNumber = false;

	// defect 2640
	@Column(name = "LAW_FIRM_NAME")
	@ColumnTransformer(forColumn = "LAW_FIRM_NAME", write = "UPPER(?)")
	private String lawFirmName;

	@Transient
	private String documentType;

	@Transient
	private boolean select;

	@Transient
	private String contactMethod;

	@Transient
	private boolean enableSelectOption = false;

	@Transient
	private String fein;

	@Transient
	private Boolean former = false;

	@Transient
	private Boolean attorneyForEmprInsr = false;

	@Transient
	private Boolean formerAttorney = false;

	@Column(name = "FRANCHISE_STORE_NO")
	private String franchiseStoreNo;

	@Column(name = "TYPE_OF_BUSINESS")
	private String typeOfBusiness;

	@Column(name = "IS_DBA")
	private Boolean isDba = false;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "BOARD_CORR_ADDRESS_ID")
	private Address boardCorrespondenceAddress;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "BOARD_CORR_CONTACT_ID")
	private Contact boardCorrespondenceContact;

	public Party() {
		address = new Address();
		contact = new Contact();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBarNumber() {
		return this.barNumber;
	}

	public void setBarNumber(String barNumber) {
		this.barNumber = barNumber;
	}

	public String getDoingBusinessAs() {
		return this.doingBusinessAs;
	}

	public void setDoingBusinessAs(String doingBusinessAs) {
		this.doingBusinessAs = doingBusinessAs;
	}

	public String getFederalEin() {
		return this.federalEin;
	}

	public void setFederalEin(String federalEin) {
		if (federalEin != null) {
			this.federalEin = DataConversionUtil.parseEIN(federalEin);
		}

	}

	public String getSbwcNumber() {
		return this.sbwcNumber;
	}

	public void setSbwcNumber(String sbwcNumber) {
		this.sbwcNumber = sbwcNumber;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public PartyType getPartyType() {
		return partyType;
	}

	public void setPartyType(PartyType partyType) {
		this.partyType = partyType;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public Collection<Party> getInsuranceCollection() {
		return insuranceCollection;
	}

	public void setInsuranceCollection(Collection<Party> insuranceCollection) {
		this.insuranceCollection = insuranceCollection;
	}

	public Collection<Party> getClaimOfficeCollection() {
		return claimOfficeCollection;
	}

	public void setClaimOfficeCollection(Collection<Party> claimOfficeCollection) {
		this.claimOfficeCollection = claimOfficeCollection;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public RelationType getRelationType() {
		return relationType;
	}

	public void setRelationType(RelationType relationType) {
		this.relationType = relationType;
	}

	public Boolean getSelfInsured() {
		return selfInsured;
	}

	public void setSelfInsured(Boolean selfInsured) {
		this.selfInsured = selfInsured;
	}

	public Boolean getSelfAdministered() {
		return selfAdministered;
	}

	public void setSelfAdministered(Boolean selfAdministered) {
		this.selfAdministered = selfAdministered;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Party))
			return false;
		Party other = (Party) obj;

		if (id == null) {
			if (other.id != null)
				return false;
			else if (this.getPartyName() == null || other.getPartyName() == null)
				return false;
			else if (this.getPartyName().equals(other.getPartyName()))
				return true;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public boolean isEnableSelectOption() {
		return enableSelectOption;
	}

	public void setEnableSelectOption(boolean enableSelectOption) {
		this.enableSelectOption = enableSelectOption;
	}

	public String getContactMethod() {
		return contactMethod;
	}

	public void setContactMethod(String contactMethod) {
		this.contactMethod = contactMethod;
	}

	public Boolean getGroupFundMember() {
		return groupFundMember;
	}

	public void setGroupFundMember(Boolean groupFundMember) {
		this.groupFundMember = groupFundMember;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getAssessedCloseDate() {
		return assessedCloseDate;
	}

	public void setAssessedCloseDate(Date assessedCloseDate) {
		this.assessedCloseDate = assessedCloseDate;
	}

	public RehabType getRehabType() {
		return rehabType;
	}

	public void setRehabType(RehabType rehabType) {
		this.rehabType = rehabType;
	}

	public Date getCcmExpirationDate() {
		return ccmExpirationDate;
	}

	public void setCcmExpirationDate(Date ccmExpirationDate) {
		this.ccmExpirationDate = ccmExpirationDate;
	}

	public Date getCdmsExpirationDate() {
		return cdmsExpirationDate;
	}

	public void setCdmsExpirationDate(Date cdmsExpirationDate) {
		this.cdmsExpirationDate = cdmsExpirationDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
		this.deactiveDate = closeDate;
	}

	public Date getDeactiveDate() {
		return deactiveDate;
	}

	public void setDeactiveDate(Date deactiveDate) {
		this.closeDate = deactiveDate;
		this.deactiveDate = deactiveDate;
	}

	public Date getCohnExpirationDate() {
		return cohnExpirationDate;
	}

	public void setCohnExpirationDate(Date cohnExpirationDate) {
		this.cohnExpirationDate = cohnExpirationDate;
	}

	public Date getCohnsExpirationDate() {
		return cohnsExpirationDate;
	}

	public void setCohnsExpirationDate(Date cohnsExpirationDate) {
		this.cohnsExpirationDate = cohnsExpirationDate;
	}

	public Date getCrcExpirationDate() {
		return crcExpirationDate;
	}

	public void setCrcExpirationDate(Date crcExpirationDate) {
		this.crcExpirationDate = crcExpirationDate;
	}

	public Date getCrrnExpirationDate() {
		return crrnExpirationDate;
	}

	public void setCrrnExpirationDate(Date crrnExpirationDate) {
		this.crrnExpirationDate = crrnExpirationDate;
	}

	public Date getCwavesExpirationDate() {
		return cwavesExpirationDate;
	}

	public void setCwavesExpirationDate(Date cwavesExpirationDate) {
		this.cwavesExpirationDate = cwavesExpirationDate;
	}

	public Date getLpcExpirationDate() {
		return lpcExpirationDate;
	}

	public void setLpcExpirationDate(Date lpcExpirationDate) {
		this.lpcExpirationDate = lpcExpirationDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Boolean getSelfEmployed() {
		return selfEmployed;
	}

	public void setSelfEmployed(Boolean selfEmployed) {
		this.selfEmployed = selfEmployed;
	}

	public Boolean getIsTradingPartner() {
		return isTradingPartner;
	}

	public void setIsTradingPartner(Boolean isTradingPartner) {
		this.isTradingPartner = isTradingPartner;
	}

	public String getFein() {
		return fein;
	}

	public void setFein(String fein) {
		this.fein = fein;
	}

	@Override
	public int compareTo(Party otherParty) {
		long relationshipId1 = this.getRelationType() == null ? 0 : this.getRelationType().getId();
		long relationshipId2 = otherParty.getRelationType() == null ? 0
				: (otherParty.getRelationType().getId() == null ? 0 : otherParty.getRelationType().getId());

		return (int) (relationshipId1 - relationshipId2);
	}

	public Boolean getInternalUseNumber() {
		return internalUseNumber;
	}

	public void setInternalUseNumber(Boolean internalUseNumber) {
		this.internalUseNumber = internalUseNumber;
	}

	public Boolean getFormer() {
		return former;
	}

	public void setFormer(Boolean former) {
		this.former = former;
	}

	public String getLawFirmName() {
		return lawFirmName;
	}

	public void setLawFirmName(String lawFirmName) {
		this.lawFirmName = lawFirmName;
	}

	public Boolean getAttorneyForEmprInsr() {
		return attorneyForEmprInsr;
	}

	public void setAttorneyForEmprInsr(Boolean attorneyForEmprInsr) {
		this.attorneyForEmprInsr = attorneyForEmprInsr;
	}

	public String getFranchiseStoreNo() {
		return franchiseStoreNo;
	}

	public void setFranchiseStoreNo(String franchiseStoreNo) {
		this.franchiseStoreNo = franchiseStoreNo;
	}

	public String getTypeOfBusiness() {
		return typeOfBusiness;
	}

	public void setTypeOfBusiness(String typeOfBusiness) {
		this.typeOfBusiness = typeOfBusiness;
	}

	public Boolean getIsDba() {
		return isDba;
	}

	public void setIsDba(Boolean isDba) {
		this.isDba = isDba;
	}

	public Address getBoardCorrespondenceAddress() {
		return boardCorrespondenceAddress;
	}

	public void setBoardCorrespondenceAddress(Address boardCorrespondenceAddress) {
		this.boardCorrespondenceAddress = boardCorrespondenceAddress;
	}

	public Contact getBoardCorrespondenceContact() {
		return boardCorrespondenceContact;
	}

	public void setBoardCorrespondenceContact(Contact boardCorrespondenceContact) {
		this.boardCorrespondenceContact = boardCorrespondenceContact;
	}

	public Boolean getFormerAttorney() {
		return formerAttorney;
	}

	public void setFormerAttorney(Boolean formerAttorney) {
		this.formerAttorney = formerAttorney;
	}
}