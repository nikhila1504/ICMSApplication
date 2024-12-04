package com.icms.party.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(schema = "ICMS", name = "VW_TRAIL_MGMT_CALENDAR_INT_HG")
public class TrailManagementCalendarIntHearing implements TrailManagementCalendar, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "CLAIM_ID")
	private Long claimId;
	

/*
	@Column(name = "SSN_OR_BTN")
	@ColumnTransformer(forColumn = "SSN_OR_BTN", read = "DECRYPT(SSN_OR_BTN)", write = "ENCRYPT(?)")
	private String ssnOrBtn;
*/
	@Column(name = "CLAIM_NO")
	private String claimNo;

	@Column(name = "CLAIMANT_FIRST_NAME")
	private String claimantFirstName;

	@Column(name = "CLAIMANT_LAST_NAME")
	private String claimantLastName;

	@Column(name = "AREA")
	private String area;

	@Column(name = "LOCATION_TYPE_ID")
	private Long locationTypeId;

	@Column(name = "SITE_DESC")
	private String siteDesc;

	@Column(name = "SITE_TYPE_ID")
	private Long siteTypeId;

	@Column(name = "DIVISION_DESC")
	private String divisionDesc;

	@Column(name = "DIVISION_TYPE_ID")
	private Long divisionTypeId;

	@Column(name = "SCHEDULED_DATE")
	private Date scheduledDate;
	
	@Column(name = "DATE_OF_INJURY")
	private Date dateOfInjury;

	@Column(name = "START_TIME")
	private Date startTime;

	@Column(name = "END_TIME")
	private Date endTime;

	@Column(name = "SCHEDULE_STATUS")
	private String scheduledStatus;

	@Column(name = "ALJ_FIRST_NAME")
	private String aljFirstName;

	@Column(name = "ALJ_LAST_NAME")
	private String aljLastName;
	

	@Column(name = "ALJ_MIDDLE_NAME")
	private String aljMiddleName;

	@Column(name = "MEDIATOR_FIRST_NAME")
	private String mediatorFirstName;

	@Column(name = "MEDIATOR_LAST_NAME")
	private String mediatorLastName;

	@Column(name = "STAFF_ATTORNEY_FIRST_NAME")
	private String staffAttorneyFirstName;

	@Column(name = "STAFF_ATTORNEY_LAST_NAME")
	private String staffAttorneyLastName;

	@Transient
	private Long partyId;
	
	@Column(name = "REHAB_COORDINATOR_FIRST_NAME")
	private String rehabCoordinatorFirstName;

	@Column(name = "REHAB_COORDINATOR_LAST_NAME")
	private String rehabCoordinatorLastName;

	@Column(name = "COUNTY_OF_INJURY")
	private String countyOfInjury;
	
	@Transient
	private List<Party>parties;
	
	@Transient
	private List<ClaimParty>claimParties;
	
	@Column(name = "RESET_NO")
	private Long resetNo;
	

	public TrailManagementCalendarIntHearing() {
	}

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getClaimantFirstName() {
		return claimantFirstName;
	}

	public void setClaimantFirstName(String claimantFirstName) {
		this.claimantFirstName = claimantFirstName;
	}

	public String getClaimantLastName() {
		return claimantLastName;
	}

	public void setClaimantLastName(String claimantLastName) {
		this.claimantLastName = claimantLastName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Long getLocationTypeId() {
		return locationTypeId;
	}

	public void setLocationTypeId(Long locationTypeId) {
		this.locationTypeId = locationTypeId;
	}

	public String getSiteDesc() {
		return siteDesc;
	}

	public void setSiteDesc(String siteDesc) {
		this.siteDesc = siteDesc;
	}

	public Long getSiteTypeId() {
		return siteTypeId;
	}

	public void setSiteTypeId(Long siteTypeId) {
		this.siteTypeId = siteTypeId;
	}

	public String getDivisionDesc() {
		return divisionDesc;
	}

	public void setDivisionDesc(String divisionDesc) {
		this.divisionDesc = divisionDesc;
	}

	public Long getDivisionTypeId() {
		return divisionTypeId;
	}

	public void setDivisionTypeId(Long divisionTypeId) {
		this.divisionTypeId = divisionTypeId;
	}

	public Date getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getScheduledStatus() {
		return scheduledStatus;
	}

	public void setScheduledStatus(String scheduledStatus) {
		this.scheduledStatus = scheduledStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAljFirstName() {
		return aljFirstName;
	}

	public void setAljFirstName(String aljFirstName) {
		this.aljFirstName = aljFirstName;
	}

	public String getAljLastName() {
		return aljLastName;
	}

	public void setAljLastName(String aljLastName) {
		this.aljLastName = aljLastName;
	}

	public String getMediatorFirstName() {
		return mediatorFirstName;
	}

	public void setMediatorFirstName(String mediatorFirstName) {
		this.mediatorFirstName = mediatorFirstName;
	}

	public String getMediatorLastName() {
		return mediatorLastName;
	}

	public void setMediatorLastName(String mediatorLastName) {
		this.mediatorLastName = mediatorLastName;
	}

	public Long getClaimId() {
		return claimId;
	}

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}

/*	public String getSsnOrBtn() {
		return ssnOrBtn;
	}

	public void setSsnOrBtn(String ssnOrBtn) {
		this.ssnOrBtn = ssnOrBtn;
	}
*/
	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public String getStaffAttorneyFirstName() {
		return staffAttorneyFirstName;
	}

	public void setStaffAttorneyFirstName(String staffAttorneyFirstName) {
		this.staffAttorneyFirstName = staffAttorneyFirstName;
	}

	public String getStaffAttorneyLastName() {
		return staffAttorneyLastName;
	}

	public void setStaffAttorneyLastName(String staffAttorneyLastName) {
		this.staffAttorneyLastName = staffAttorneyLastName;
	}

	public String getRehabCoordinatorFirstName() {
		return rehabCoordinatorFirstName;
	}

	public void setRehabCoordinatorFirstName(String rehabCoordinatorFirstName) {
		this.rehabCoordinatorFirstName = rehabCoordinatorFirstName;
	}

	public String getRehabCoordinatorLastName() {
		return rehabCoordinatorLastName;
	}

	public void setRehabCoordinatorLastName(String rehabCoordinatorLastName) {
		this.rehabCoordinatorLastName = rehabCoordinatorLastName;
	}

	public List<Party> getParties() {
		return parties;
	}

	public void setParties(List<Party> parties) {
		this.parties = parties;
	}

	public Date getDateOfInjury() {
		return dateOfInjury;
	}

	public void setDateOfInjury(Date dateOfInjury) {
		this.dateOfInjury = dateOfInjury;
	}

	public String getCountyOfInjury() {
		return countyOfInjury;
	}

	public void setCountyOfInjury(String countyOfInjury) {
		this.countyOfInjury = countyOfInjury;
	}

	public Long getResetNo() {
		return resetNo;
	}

	public void setResetNo(Long resetNo) {
		this.resetNo = resetNo;
	}

	@Override
	public Long getScheduleId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setScheduleId(Long scheduleId) {
		// TODO Auto-generated method stub
		
	}

	public String getAljMiddleName() {
		return aljMiddleName;
	}

	public void setAljMiddleName(String aljMiddleName) {
		this.aljMiddleName = aljMiddleName;
	}

	@Override
	public List<ClaimParty> getClaimParties() {
		
		return claimParties;
	}

	@Override
	public void setClaimParties(List<ClaimParty> claimParties) {
		this.claimParties = claimParties;
		
	}

	

}
