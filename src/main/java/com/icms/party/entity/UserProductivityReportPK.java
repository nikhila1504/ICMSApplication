package com.icms.party.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserProductivityReportPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ACTIVITY_DATE")
	private Date activityDate;

	@Column(name="COUNT_NO")
	private Integer countNo;

	@Column(name="DIVISION_NAME")
	private String divisionName;

	@Column(name="FORM_NAME")
	private String formName;

	@Column(name="STAFF_NAME")
	private String staffName;
	
	public UserProductivityReportPK() {
	}

	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (!(other instanceof UserProductivityReportPK)) {
			return false;
		}
		UserProductivityReportPK object = (UserProductivityReportPK) other;

		return (this.activityDate.compareTo(object.activityDate) == 0 &&
				this.countNo == object.countNo &&
				this.divisionName.equals(object.divisionName) &&
				this.formName.equals(object.formName) &&
				this.staffName.equals(object.staffName));
	}
	
	public int hashCode() {
		return activityDate.hashCode() + countNo.hashCode() + divisionName.hashCode() + formName.hashCode() + staffName.hashCode();
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public Integer getCountNo() {
		return countNo;
	}

	public void setCountNo(Integer countNo) {
		this.countNo = countNo;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	
}
