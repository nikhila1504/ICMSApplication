package gov.ga.sbwc.icms.common.entity.core;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import gov.ga.sbwc.icms.common.enums.RadioButtonEnum;
import gov.ga.sbwc.icms.common.util.DataConversionUtil;
import gov.ga.sbwc.icms.common.util.TimeWithCurrentDateDeserializer;

/**
 * The persistent class for the WC1_FORM database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "WC1_FORM")
public class Wc1Form extends BaseEntity implements Form, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DOCUMENT_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "INJURY_TYPE_ID")
	private InjuryType typeOfInjury;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DISA_BODY_PART_TYPE_ID")
	private BodyPartType disabilityBodyType;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AFFT_BODY_PART_TYPE_ID")
	private BodyPartType affectedBodyType;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "INJURY_CAUSE_TYPE_ID")
	private InjuryCauseType causeOfInjury;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "NAICS_TYPE_ID")
	private NaicsType naicsType;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "INSURER_TYPE_ID")
	private PartyType insurerType;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TREATMENT_TYPE_ID")
	private TreatmentType initialTreatmentGiven;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DISABILITY_TYPE_ID")
	private DisabilityType benefitsPayableFor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CONTROVERT_TYPE_ID")
	private ControvertType controvertType;

	@Column(name = "AVERAGE_WEEKLY_WAGE", columnDefinition = "NUMBER(38,2)")
	private Double averageWeeklyWage = null;

	@Column(name = "COMPENSATION_PAID", columnDefinition = "NUMBER(38,2)")
	private Double compensationPaid = null;

	@Column(name = "DATE_BENEFITS_PAYABLE_FROM")
	private Date dateBenefitsPayableFrom;

	@Column(name = "DATE_EMPLOYER_NOTIFIED")
	private Date dateEmployerNotified;

	@Column(name = "DATE_FAILED_TO_WORK_FULL_DAY")
	private Date dateFailedToWorkFullDay;

	@Column(name = "DATE_HIRED")
	private Date dateHired;

	@Column(name = "DATE_OF_DEATH")
	private Date dateOfDeath;

	@Column(name = "DATE_OF_DISABILITY")
	private Date dateOfDisability;

	@Column(name = "DATE_OF_FIRST_PAYMENT")
	private Date dateOfFirstPayment;

	@Column(name = "DATE_OF_REPORT")
	private Date dateOfReport;

	@Column(name = "DATE_RETURNED_TO_WORK")
	private Date dateReturnedToWork;

	@Column(name = "DATE_SALARY_PAID")
	private Date dateSalaryPaid;

	@Column(name = "DATE_UNTIL_BENEFITS_PAID")
	private Date dateUntilBenefitsPaid;

	@Column(name = "DAYS_OFF")
	private String daysOff;

	@Column(name = "DAYS_WORKED_PER_WEEK")
	private Integer daysWorkedPerWeek;

	@Column(name = "DISABILITY_IN_WEEKS", columnDefinition = "NUMBER(38,2)")
	private Double disabilityInWeeks;

	@Column(name = "DISBAILITY_PERCENTAGE", columnDefinition = "NUMBER(38,2)")
	private Double disabilityPercentage;

	@Column(name = "IS_RECEIVED_FULL_PAY")
	@Enumerated(EnumType.STRING)
	private RadioButtonEnum receivedFullPay;

	@Column(name = "IS_SEC_B")
	private Boolean sectionB = false;

	@Column(name = "IS_SEC_C")
	private Boolean sectionC = false;

	@Column(name = "IS_SEC_D")
	private Boolean sectionD = false;

	@Size(max = 100, message = "Hospital Address 1 should not be more than 100 characters")
	@Column(name = "HOSPITAL_ADDRESS1")
	private String hospitalAddress1;

	@Size(max = 100, message = "Hospital Address 2 should not be more than 30 characters")
	@Column(name = "HOSPITAL_ADDRESS2")
	private String hospitalAddress2;

	@Size(max = 100, message = "Hospital City should not be more than 100 characters")
	@Column(name = "HOSPITAL_CITY")
	private String hospitalCity;

	/*
	 * @Size(max=100,
	 * message="Hospital Email should not be more than 100 characters")
	 * 
	 * @Column(name = "HOSPITAL_EMAIL") private String hospitalEmail;
	 */

	@Size(max = 100, message = "Hospital Name should not be more than 100 characters")
	@Column(name = "HOSPITAL_NAME")
	private String hospitalName;

	@Size(max = 14, message = "Hospital Phone should not be more than 14 characters")
	@Column(name = "HOSPITAL_PHONE")
	private String hospitalPhone;

	@Size(max = 10, message = "Hospital Phone Extension should not be more than 10 characters")
	@Column(name = "HOSPITAL_PHONE_EXT")
	private String hospitalPhoneExt;

	@Size(max = 2, message = "Hospital State should not be more than 2 characters")
	@Column(name = "HOSPITAL_STATE")
	private String hospitalState = "GA";

	@Size(max = 5, message = "Hospital Zip should not be more than 5 characters")
	@Column(name = "HOSPITAL_ZIP")
	private String hospitalZip;

	@Size(max = 4, message = "Hospital Zip Extension should not be more than 4 characters")
	@Column(name = "HOSPITAL_ZIP_EXT")
	private String hospitalZipExt;

	@Column(name = "IS_CONTROVERTED")
	private Boolean controverted;

	@Column(name = "IS_INJURED_IN_EMP_PERMISES")
	@Enumerated(EnumType.STRING)
	private RadioButtonEnum injuredInEmpPermises;

	@Size(max = 20, message = "Job Classification Code should not be more than 20 characters")
	@Column(name = "JOB_CLASSIFICATION_CODE")
	private String jobClassificationCode;

	@Column(name = "PENALITY_PAID", columnDefinition = "NUMBER(38,2)")
	private Double penalityPaid = null;

	@Size(max = 100, message = "Physician Address 1 should not be more than 100 characters")
	@Column(name = "PHYSICIAN_ADDRESS1")
	private String physicianAddress1;

	@Size(max = 100, message = "Physician Address 2 should not be more than 100 characters")
	@Column(name = "PHYSICIAN_ADDRESS2")
	private String physicianAddress2;

	@Size(max = 100, message = "Physician City should not be more than 100 characters")
	@Column(name = "PHYSICIAN_CITY")
	private String physicianCity;

	/*
	 * @Size(max=100,
	 * message="Physician Email should not be more than 100 characters")
	 * 
	 * @Column(name = "PHYSICIAN_EMAIL") private String physicianEmail;
	 */

	@Size(max = 100, message = "Physician Name should not be more than 100 characters")
	@Column(name = "PHYSICIAN_NAME")
	private String physicianName;

	@Size(max = 14, message = "Physician Phone should not be more than 14 characters")
	@Column(name = "PHYSICIAN_PHONE")
	private String physicianPhone;

	@Size(max = 10, message = "Physician Phone Extension should not be more than 10 characters")
	@Column(name = "PHYSICIAN_PHONE_EXT")
	private String physicianPhoneExt;

	@Size(max = 2, message = "Physician State should not be more than 2 characters")
	@Column(name = "PHYSICIAN_STATE")
	private String physicianState = "GA";

	@Size(max = 5, message = "Physician Zip should not be more than 5 characters")
	@Column(name = "PHYSICIAN_ZIP")
	private String physicianZip;

	@Size(max = 4, message = "Physician Zip Extension should not be more than 4 characters")
	@Column(name = "PHYSICIAN_ZIP_EXT")
	private String physicianZipExt;

	@Column(name = "IS_PREVIOUS_MEDICAL_ONLY")
	@Enumerated(EnumType.STRING)
	private RadioButtonEnum previousMedicalOnly;

	@Size(max = 1000, message = "Reason for Benefits not paid should not be more than 1000 characters")
	@Column(name = "REASON_FOR_BENEFITS_NOT_PAID")
	private String reasonForBenefitsNotPaid;

	@Size(max = 100, message = "Report Prepared By should not be more than 100 characters")
	@Column(name = "REPORT_PREPARED_BY")
	private String reportPreparedBy;

	@Size(max = 14, message = "Telephone Number should not be more than 10 characters")
	@Column(name = "REPORT_PREPARED_PHONE")
	private String reportPreparedPhone;

	@Size(max = 10, message = "Telephone Number Extension should not be more than 10 characters")
	@Column(name = "REPORT_PREPARED_PHONE_EXT")
	private String reportPreparedPhoneExt;

	@Column(name = "TIME_OF_INJURY")
	@JsonDeserialize(using = TimeWithCurrentDateDeserializer.class)
	private Date timeOfInjury = null;

	@Column(name = "WAGE_PER_WEEK_AFTER_RETURN", columnDefinition = "NUMBER(38,2)")
	private Double wagePerWeekAfterReturn = null;

	@Column(name = "WAGE_RATE", columnDefinition = "NUMBER(38,2)")
	private Double wageRate = null;

	@Column(name = "WAGE_RATE_FREQUENCY")
	private Integer wageRateFrequency;

	@Column(name = "WEEKLY_BENEFIT", columnDefinition = "NUMBER(38,2)")
	private Double weeklyBenefit = null;

	@Size(max = 1000, message = "Others Body Part Comment should not be more than 1000 characters")
	@Column(name = "OTHERS_BODY_PART_COMMENT")
	private String othersBodyPartComment;

	@Size(max = 50, message = "Insurer File Number should not be more than 50 characters")
	@Column(name = "INSURER_FILE_NO")
	private String insurerFileNo;

	@Column(name = "IS_CERTIFIED")
	private Boolean certified = false;

	@Size(max = 500, message = "Other Injury Cause should not be more than 500 characters")
	@Column(name = "OTHER_INJURY_CAUSE")
	private String otherInjuryCause;
	@Column(name = "IS_DOB_NOT_AVAILABLE")
	private Boolean dobNotAvailable = false;

	@Transient
	private boolean select = false;

	@Column(name = "IS_INCOME_BENEFITS")
	@Enumerated(EnumType.STRING)
	private RadioButtonEnum incomeBenefits;

//	@ManyToOne
//	@JoinColumn(name = "EMPLOYER_ID")
//	private Party employer;

	public Wc1Form() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public InjuryType getTypeOfInjury() {
		return typeOfInjury;
	}

	public void setTypeOfInjury(InjuryType typeOfInjury) {
		this.typeOfInjury = typeOfInjury;
	}

	public BodyPartType getDisabilityBodyType() {
		return disabilityBodyType;
	}

	public void setDisabilityBodyType(BodyPartType disabilityBodyType) {
		this.disabilityBodyType = disabilityBodyType;
	}

	public BodyPartType getAffectedBodyType() {
		return affectedBodyType;
	}

	public void setAffectedBodyType(BodyPartType affectedBodyType) {
		this.affectedBodyType = affectedBodyType;
	}

	public InjuryCauseType getCauseOfInjury() {
		return causeOfInjury;
	}

	public void setCauseOfInjury(InjuryCauseType causeOfInjury) {
		this.causeOfInjury = causeOfInjury;
	}

	public NaicsType getNaicsType() {
		return naicsType;
	}

	public void setNaicsType(NaicsType naicsType) {
		this.naicsType = naicsType;
	}

	public PartyType getInsurerType() {
		return insurerType;
	}

	public void setInsurerType(PartyType insurerType) {
		this.insurerType = insurerType;
	}

	public TreatmentType getInitialTreatmentGiven() {
		return initialTreatmentGiven;
	}

	public void setInitialTreatmentGiven(TreatmentType initialTreatmentGiven) {
		this.initialTreatmentGiven = initialTreatmentGiven;
	}

	public Double getAverageWeeklyWage() {
		return averageWeeklyWage;
	}

	public void setAverageWeeklyWage(Double averageWeeklyWage) {
		this.averageWeeklyWage = averageWeeklyWage;
	}

	public DisabilityType getBenefitsPayableFor() {
		return benefitsPayableFor;
	}

	public void setBenefitsPayableFor(DisabilityType benefitsPayableFor) {
		this.benefitsPayableFor = benefitsPayableFor;
	}

	public Double getCompensationPaid() {
		return compensationPaid;
	}

	public void setCompensationPaid(Double compensationPaid) {
		this.compensationPaid = compensationPaid;
	}

	public Date getDateBenefitsPayableFrom() {
		return dateBenefitsPayableFrom;
	}

	public void setDateBenefitsPayableFrom(Date dateBenefitsPayableFrom) {
		this.dateBenefitsPayableFrom = dateBenefitsPayableFrom;
	}

	public Date getDateEmployerNotified() {
		return dateEmployerNotified;
	}

	public void setDateEmployerNotified(Date dateEmployerNotified) {
		this.dateEmployerNotified = dateEmployerNotified;
	}

	public Date getDateFailedToWorkFullDay() {
		return dateFailedToWorkFullDay;
	}

	public void setDateFailedToWorkFullDay(Date dateFailedToWorkFullDay) {
		this.dateFailedToWorkFullDay = dateFailedToWorkFullDay;
	}

	public Date getDateHired() {
		return dateHired;
	}

	public void setDateHired(Date dateHired) {
		this.dateHired = dateHired;
	}

	public Date getDateOfDeath() {
		return dateOfDeath;
	}

	public void setDateOfDeath(Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	public Date getDateOfDisability() {
		return dateOfDisability;
	}

	public void setDateOfDisability(Date dateOfDisability) {
		this.dateOfDisability = dateOfDisability;
	}

	public Date getDateOfFirstPayment() {
		return dateOfFirstPayment;
	}

	public void setDateOfFirstPayment(Date dateOfFirstPayment) {
		this.dateOfFirstPayment = dateOfFirstPayment;
	}

	public Date getDateOfReport() {
		return dateOfReport;
	}

	public void setDateOfReport(Date dateOfReport) {
		this.dateOfReport = dateOfReport;
	}

	public Date getDateReturnedToWork() {
		return dateReturnedToWork;
	}

	public void setDateReturnedToWork(Date dateReturnedToWork) {
		this.dateReturnedToWork = dateReturnedToWork;
	}

	public Date getDateSalaryPaid() {
		return dateSalaryPaid;
	}

	public void setDateSalaryPaid(Date dateSalaryPaid) {
		this.dateSalaryPaid = dateSalaryPaid;
	}

	public String getDaysOff() {
		return daysOff;
	}

	public void setDaysOff(String daysOff) {
		this.daysOff = daysOff;
	}

	public Integer getDaysWorkedPerWeek() {
		return daysWorkedPerWeek;
	}

	public void setDaysWorkedPerWeek(Integer daysWorkedPerWeek) {
		this.daysWorkedPerWeek = daysWorkedPerWeek;
	}

	public Double getDisabilityInWeeks() {
		return disabilityInWeeks;
	}

	public void setDisabilityInWeeks(Double disabilityInWeeks) {
		this.disabilityInWeeks = disabilityInWeeks;
	}

	public Double getDisabilityPercentage() {
		return disabilityPercentage;
	}

	public void setDisabilityPercentage(Double disabilityPercentage) {
		this.disabilityPercentage = disabilityPercentage;
	}

	public String getHospitalAddress1() {
		return hospitalAddress1;
	}

	public void setHospitalAddress1(String hospitalAddress1) {
		this.hospitalAddress1 = hospitalAddress1;
	}

	public String getHospitalAddress2() {
		return hospitalAddress2;
	}

	public void setHospitalAddress2(String hospitalAddress2) {
		this.hospitalAddress2 = hospitalAddress2;
	}

	public String getHospitalCity() {
		return hospitalCity;
	}

	public void setHospitalCity(String hospitalCity) {
		this.hospitalCity = hospitalCity;
	}

	/*
	 * public String getHospitalEmail() { return hospitalEmail; }
	 * 
	 * public void setHospitalEmail(String hospitalEmail) { this.hospitalEmail =
	 * hospitalEmail; }
	 */

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalPhone() {
		return hospitalPhone;
	}

	public void setHospitalPhone(String hospitalPhone) {
		this.hospitalPhone = DataConversionUtil.parsePhone(hospitalPhone);
	}

	public String getHospitalPhoneExt() {
		return hospitalPhoneExt;
	}

	public void setHospitalPhoneExt(String hospitalPhoneExt) {
		this.hospitalPhoneExt = hospitalPhoneExt;
	}

	public String getHospitalState() {
		return hospitalState;
	}

	public void setHospitalState(String hospitalState) {
		this.hospitalState = hospitalState;
	}

	public String getHospitalZip() {
		return hospitalZip;
	}

	public void setHospitalZip(String hospitalZip) {
		this.hospitalZip = hospitalZip;
	}

	public Boolean getControverted() {
		return controverted;
	}

	public void setControverted(Boolean controverted) {
		this.controverted = controverted;
	}

	public RadioButtonEnum getInjuredInEmpPermises() {
		return injuredInEmpPermises;
	}

	public void setInjuredInEmpPermises(RadioButtonEnum injuredInEmpPermises) {
		this.injuredInEmpPermises = injuredInEmpPermises;
	}

	public String getJobClassificationCode() {
		return jobClassificationCode;
	}

	public void setJobClassificationCode(String jobClassificationCode) {
		this.jobClassificationCode = jobClassificationCode;
	}

	public Double getPenalityPaid() {
		return penalityPaid;
	}

	public void setPenalityPaid(Double penalityPaid) {
		this.penalityPaid = penalityPaid;
	}

	public String getPhysicianAddress1() {
		return physicianAddress1;
	}

	public void setPhysicianAddress1(String physicianAddress1) {
		this.physicianAddress1 = physicianAddress1;
	}

	public String getPhysicianAddress2() {
		return physicianAddress2;
	}

	public void setPhysicianAddress2(String physicianAddress2) {
		this.physicianAddress2 = physicianAddress2;
	}

	public String getPhysicianCity() {
		return physicianCity;
	}

	public void setPhysicianCity(String physicianCity) {
		this.physicianCity = physicianCity;
	}

	/*
	 * public String getPhysicianEmail() { return physicianEmail; }
	 * 
	 * public void setPhysicianEmail(String physicianEmail) { this.physicianEmail =
	 * physicianEmail; }
	 */

	public String getPhysicianName() {
		return physicianName;
	}

	public void setPhysicianName(String physicianName) {
		this.physicianName = physicianName;
	}

	public String getPhysicianPhone() {
		return physicianPhone;
	}

	public void setPhysicianPhone(String physicianPhone) {
		this.physicianPhone = DataConversionUtil.parsePhone(physicianPhone);
	}

	public String getPhysicianPhoneExt() {
		return physicianPhoneExt;
	}

	public void setPhysicianPhoneExt(String physicianPhoneExt) {
		this.physicianPhoneExt = physicianPhoneExt;
	}

	public String getPhysicianState() {
		return physicianState;
	}

	public void setPhysicianState(String physicianState) {
		this.physicianState = physicianState;
	}

	public String getPhysicianZip() {
		return physicianZip;
	}

	public void setPhysicianZip(String physicianZip) {
		this.physicianZip = physicianZip;
	}

	public RadioButtonEnum getPreviousMedicalOnly() {
		return previousMedicalOnly;
	}

	public void setPreviousMedicalOnly(RadioButtonEnum previousMedicalOnly) {
		this.previousMedicalOnly = previousMedicalOnly;
	}

	public String getReasonForBenefitsNotPaid() {
		return reasonForBenefitsNotPaid;
	}

	public void setReasonForBenefitsNotPaid(String reasonForBenefitsNotPaid) {
		this.reasonForBenefitsNotPaid = reasonForBenefitsNotPaid;
	}

	public String getReportPreparedBy() {
		return reportPreparedBy;
	}

	public void setReportPreparedBy(String reportPreparedBy) {
		this.reportPreparedBy = reportPreparedBy;
	}

	public String getReportPreparedPhone() {
		return DataConversionUtil.formatPhone(reportPreparedPhone);
	}

	public void setReportPreparedPhone(String reportPreparedPhone) {
		this.reportPreparedPhone = DataConversionUtil.parsePhone(reportPreparedPhone);
	}

	public Date getTimeOfInjury() {
		return timeOfInjury;
	}

	public void setTimeOfInjury(Date timeOfInjury) {
		this.timeOfInjury = timeOfInjury;
	}

	public Double getWagePerWeekAfterReturn() {
		return wagePerWeekAfterReturn;
	}

	public void setWagePerWeekAfterReturn(Double wagePerWeekAfterReturn) {
		this.wagePerWeekAfterReturn = wagePerWeekAfterReturn;
	}

	public Double getWageRate() {
		return wageRate;
	}

	public void setWageRate(Double wageRate) {
		this.wageRate = wageRate;
	}

	public Integer getWageRateFrequency() {
		return wageRateFrequency;
	}

	public void setWageRateFrequency(Integer wageRateFrequency) {
		this.wageRateFrequency = wageRateFrequency;
	}

	public Double getWeeklyBenefit() {
		return weeklyBenefit;
	}

	public void setWeeklyBenefit(Double weeklyBenefit) {
		this.weeklyBenefit = weeklyBenefit;
	}

	public Date getDateUntilBenefitsPaid() {
		return dateUntilBenefitsPaid;
	}

	public void setDateUntilBenefitsPaid(Date dateUntilBenefitsPaid) {
		this.dateUntilBenefitsPaid = dateUntilBenefitsPaid;
	}

	public ControvertType getControvertType() {
		return controvertType;
	}

	public void setControvertType(ControvertType controvertType) {
		this.controvertType = controvertType;
	}

	public String getOthersBodyPartComment() {
		return othersBodyPartComment;
	}

	public void setOthersBodyPartComment(String othersBodyPartComment) {
		this.othersBodyPartComment = othersBodyPartComment;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public Boolean getCertified() {
		return certified;
	}

	public void setCertified(Boolean certified) {
		this.certified = certified;
	}

	public RadioButtonEnum getReceivedFullPay() {
		return receivedFullPay;
	}

	public void setReceivedFullPay(RadioButtonEnum receivedFullPay) {
		this.receivedFullPay = receivedFullPay;
	}

	public Boolean getSectionB() {
		return sectionB;
	}

	public void setSectionB(Boolean sectionB) {
		this.sectionB = sectionB;
	}

	public Boolean getSectionC() {
		return sectionC;
	}

	public void setSectionC(Boolean sectionC) {
		this.sectionC = sectionC;
	}

	public Boolean getSectionD() {
		return sectionD;
	}

	public void setSectionD(Boolean sectionD) {
		this.sectionD = sectionD;
	}

	public String getInsurerFileNo() {
		return insurerFileNo;
	}

	public void setInsurerFileNo(String insurerFileNo) {
		this.insurerFileNo = insurerFileNo;
	}

	public RadioButtonEnum getIncomeBenefits() {
		return incomeBenefits;
	}

	public void setIncomeBenefits(RadioButtonEnum incomeBenefits) {
		this.incomeBenefits = incomeBenefits;
	}

//	public Party getEmployer() {
//		return employer;
//	}
//
//	public void setEmployer(Party employer) {
//		this.employer = employer;
//	}

	public String getHospitalZipExt() {
		return hospitalZipExt;
	}

	public void setHospitalZipExt(String hospitalZipExt) {
		this.hospitalZipExt = hospitalZipExt;
	}

	public String getPhysicianZipExt() {
		return physicianZipExt;
	}

	public void setPhysicianZipExt(String physicianZipExt) {
		this.physicianZipExt = physicianZipExt;
	}

	public String getOtherInjuryCause() {
		return otherInjuryCause;
	}

	public void setOtherInjuryCause(String otherInjuryCause) {
		this.otherInjuryCause = otherInjuryCause;
	}

	public String getReportPreparedPhoneExt() {
		return reportPreparedPhoneExt;
	}

	public void setReportPreparedPhoneExt(String reportPreparedPhoneExt) {
		this.reportPreparedPhoneExt = reportPreparedPhoneExt;
	}

	public Boolean getDobNotAvailable() {
		return dobNotAvailable;
	}

	public void setDobNotAvailable(Boolean dobNotAvailable) {
		this.dobNotAvailable = dobNotAvailable;
	}
}