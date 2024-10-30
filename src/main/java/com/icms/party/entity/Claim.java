package com.icms.party.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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

import com.icms.party.util.DataConversionUtil;

/**
 * The persistent class for the CLAIM database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "CLAIM")
public class Claim extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CLAIM_ID_GENERATOR", sequenceName = "CLAIM_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLAIM_ID_GENERATOR")
	@Column(name = "CLAIM_ID")
	private Long id;

	@Column(name = "CLAIM_NO")
	private String claimNo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CLAIM_STATUS_TYPE_ID")
	private ClaimStatusType claimStatusType;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CLAIMANT_ID")
	private Claimant claimant;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COUNTY_OF_INJURY")
	private CountyType countyOfInjury;

	@Column(name = "DATE_CLAIM_STATUS_UPDATED")
	private Date dateClaimStatusUpdated;

	@Column(name = "DATE_OF_INJURY")
	private Date dateOfInjury;

	@Column(name = "IS_CATASTROPHIC_INJURY")
	private Boolean catastrophicInjury = false;

	@Column(name = "IS_FATAL")
	private Boolean fatal = false;

	@Column(name = "CLOSED_DATE")
	private Date closedDate;

	@Transient
	private boolean select = false;

	@Transient
	private Set<String> claimNoList;

	@Transient
	private Set<Date> dateOfInjuryList;

	@Column(name = "ENFORCEMENT_TRACKING_NO")
	private String enforcementTrackingNo;

	@ManyToOne
	@JoinColumn(name = "CLAIM_TYPE_ID")
	private ClaimType claimType;

	@Column(name = "REHAB_CLOSED_DATE")
	private Date rehabClosedDate;

	@Column(name = "CLAIM_CREATED_DATE")
	private Date claimCreatedDate;

	@Transient
	private String primaryRespondentName;

	@Transient
	private String sbwcAttorney;

	@Transient
	private String updatedBy;

	@Transient
	private Long associatedDocId;

	public Claim() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		if (claimNo != null) {
			this.claimNo = DataConversionUtil.parseClaimNo(claimNo);
			this.claimCreatedDate = new Date();
		}
	}

	public ClaimStatusType getClaimStatusType() {
		return claimStatusType;
	}

	public void setClaimStatusType(ClaimStatusType claimStatusType) {
		this.setDateClaimStatusUpdated(new Date());
		this.claimStatusType = claimStatusType;
	}

	public Claimant getClaimant() {
		return claimant;
	}

	public void setClaimant(Claimant claimant) {
		this.claimant = claimant;
	}

	public CountyType getCountyOfInjury() {
		return countyOfInjury;
	}

	public void setCountyOfInjury(CountyType countyOfInjury) {
		this.countyOfInjury = countyOfInjury;
	}

	public Date getDateClaimStatusUpdated() {
		return dateClaimStatusUpdated;
	}

	public void setDateClaimStatusUpdated(Date dateClaimStatusUpdated) {
		this.dateClaimStatusUpdated = dateClaimStatusUpdated;
	}

	public Date getDateOfInjury() {
		return dateOfInjury;
	}

	public void setDateOfInjury(Date dateOfInjury) {
		this.dateOfInjury = dateOfInjury;
	}

	public Boolean getCatastrophicInjury() {
		return catastrophicInjury;
	}

	public void setCatastrophicInjury(Boolean catastrophicInjury) {
		this.catastrophicInjury = catastrophicInjury;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public Boolean getFatal() {
		return fatal;
	}

	public void setFatal(Boolean fatal) {
		this.fatal = fatal;
	}

	public Set<String> getClaimNoList() {
		if (claimNoList == null) {
			claimNoList = new LinkedHashSet<String>();
			claimNoList.add(getClaimNo());
		}

		return claimNoList;
	}

	public void addAssociatedClaimNo(String associatedClaimNo) {
		if (claimNoList == null) {
			claimNoList = new LinkedHashSet<String>();
			claimNoList.add(claimNo);
		}
		claimNoList.add(associatedClaimNo);
	}

	public Set<Date> getDateOfInjuryList() {
		if (dateOfInjuryList == null) {
			dateOfInjuryList = new LinkedHashSet<Date>();
			dateOfInjuryList.add(getDateOfInjury());
		}
		return dateOfInjuryList;
	}

	public void addAssociatedDateOfInjury(Date associatedDateOfInjury) {
		if (dateOfInjuryList == null) {
			dateOfInjuryList = new LinkedHashSet<Date>();
			dateOfInjuryList.add(dateOfInjury);
		}
		dateOfInjuryList.add(associatedDateOfInjury);
	}

	public String getEnforcementTrackingNo() {
		return enforcementTrackingNo;
	}

	public void setEnforcementTrackingNo(String enforcementTrackingNo) {
		if (enforcementTrackingNo != null) {
			this.enforcementTrackingNo = DataConversionUtil.parseSSN(enforcementTrackingNo);
		}
	}

	public ClaimType getClaimType() {
		return claimType;
	}

	public void setClaimType(ClaimType claimType) {
		this.claimType = claimType;
	}

	public Date getRehabClosedDate() {
		return rehabClosedDate;
	}

	public void setRehabClosedDate(Date rehabClosedDate) {
		this.rehabClosedDate = rehabClosedDate;
	}

	public String getPrimaryRespondentName() {
		return primaryRespondentName;
	}

	public void setPrimaryRespondentName(String primaryRespondentName) {
		this.primaryRespondentName = primaryRespondentName;
	}

	public Date getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	public String getSbwcAttorney() {
		return sbwcAttorney;
	}

	public void setSbwcAttorney(String sbwcAttorney) {
		this.sbwcAttorney = sbwcAttorney;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Long getAssociatedDocId() {
		return associatedDocId;
	}

	public void setAssociatedDocId(Long associatedDocId) {
		this.associatedDocId = associatedDocId;
	}

	public Date getClaimCreatedDate() {
		return claimCreatedDate;
	}

	public void setClaimCreatedDate(Date claimCreatedDate) {
		this.claimCreatedDate = claimCreatedDate;
	}

	public void setClaimNoList(Set<String> claimNoList) {
		this.claimNoList = claimNoList;
	}

	public void setDateOfInjuryList(Set<Date> dateOfInjuryList) {
		this.dateOfInjuryList = dateOfInjuryList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Claim))
			return false;
		Claim other = (Claim) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}