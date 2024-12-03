package com.icms.party.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public interface TrailManagementCalendar extends Serializable {

	public String getClaimNo();

	public void setClaimNo(String claimNo);
	
	public Long getScheduleId();

	public void setScheduleId(Long scheduleId);

	public String getClaimantFirstName();

	public void setClaimantFirstName(String claimantFirstName);

	public String getClaimantLastName();

	public void setClaimantLastName(String claimantLastName);

	public String getArea();

	public void setArea(String area);

	public Long getLocationTypeId();

	public void setLocationTypeId(Long locationTypeId);

	public String getSiteDesc();

	public void setSiteDesc(String siteDesc);

	public Long getSiteTypeId();

	public void setSiteTypeId(Long siteTypeId);

	public String getDivisionDesc();

	public void setDivisionDesc(String divisionDesc);

	public Long getDivisionTypeId();

	public void setDivisionTypeId(Long divisionTypeId);

	public Date getScheduledDate();

	public void setScheduledDate(Date scheduledDate);

	public Date getStartTime();

	public void setStartTime(Date startTime);

	public Date getEndTime();

	public void setEndTime(Date endTime);

	public String getScheduledStatus();

	public void setScheduledStatus(String scheduledStatus);

	public Long getPartyId();

	public void setPartyId(Long partyId);

	public Long getId();

	public void setId(Long id);

	public String getAljFirstName();

	public void setAljFirstName(String aljFirstName);

	public String getAljLastName();

	public void setAljLastName(String aljLastName);
	
	public String getAljMiddleName();

	public void setAljMiddleName(String aljMiddleName);

	public String getMediatorFirstName();

	public void setMediatorFirstName(String mediatorFirstName);

	public String getMediatorLastName();

	public void setMediatorLastName(String mediatorLastName);

	public Long getClaimId();

	public void setClaimId(Long claimId);

	//public String getSsnOrBtn();

	//public void setSsnOrBtn(String ssnOrBtn);

	public String getStaffAttorneyFirstName();

	public void setStaffAttorneyFirstName(String staffAttorneyFirstName);

	public String getStaffAttorneyLastName();

	public void setStaffAttorneyLastName(String staffAttorneyLastName);
	
	public String getRehabCoordinatorFirstName();

	public void setRehabCoordinatorFirstName(String rehabCoordinatorFirstName);

	public String getRehabCoordinatorLastName();

	public void setRehabCoordinatorLastName(String rehabCoordinatorLastName);
	
	public Date getDateOfInjury();

	public void setDateOfInjury(Date dateOfInjury);
	
	public String getCountyOfInjury();

	public void setCountyOfInjury(String countyOfInjury);
	
	public void setParties(List<Party> parties);
	
	public List<ClaimParty> getClaimParties() ;
	
public void setClaimParties(List<ClaimParty> claimParties);
	
	public List<Party> getParties() ; 
	
	public Long getResetNo() ;		

	public void setResetNo(Long resetNo) ;
	
}
