package gov.ga.sbwc.icms.common.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import gov.ga.sbwc.icms.common.entity.core.BodyPartType;
import gov.ga.sbwc.icms.common.entity.core.ControvertType;
import gov.ga.sbwc.icms.common.entity.core.DisabilityType;
import gov.ga.sbwc.icms.common.entity.core.InjuryCauseType;
import gov.ga.sbwc.icms.common.entity.core.InjuryType;
import gov.ga.sbwc.icms.common.entity.core.NaicsType;
import gov.ga.sbwc.icms.common.entity.core.PartyType;
import gov.ga.sbwc.icms.common.entity.core.TreatmentType;
import gov.ga.sbwc.icms.common.enums.RadioButtonEnum;

public class Wc1FormBean implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private Long id;

	private InjuryType typeOfInjury;

	private BodyPartType disabilityBodyType;

	private BodyPartType affectedBodyType;

	private InjuryCauseType causeOfInjury;

	private NaicsType naicsType;

	private PartyType insurerType;

	private TreatmentType initialTreatmentGiven;

	private DisabilityType benefitsPayableFor;

	private ControvertType controvertType;

	private Double averageWeeklyWage = null;

	private Double compensationPaid = null;

	private Date dateBenefitsPayableFrom;

	private Date dateEmployerNotified;

	private Date dateFailedToWorkFullDay;

	private Date dateHired;

	private Date dateOfDeath;

	private Date dateOfDisability;

	private Date dateOfFirstPayment;

	private Date dateOfReport;

	private Date dateReturnedToWork;

	private Date dateSalaryPaid;

	private Date dateUntilBenefitsPaid;

	private String daysOff;

	private Integer daysWorkedPerWeek;

	private Double disabilityInWeeks;

	private Double disabilityPercentage;

	private RadioButtonEnum receivedFullPay;

	private Boolean sectionB = false;

	private Boolean sectionC = false;

	private Boolean sectionD = false;

	private String hospitalAddress1;

	private String hospitalAddress2;

	private String hospitalCity;

	/*
	 * @Size(max=100,
	 * message="Hospital Email should not be more than 100 characters")
	 * 
	 * @Column(name = "HOSPITAL_EMAIL") private String hospitalEmail;
	 */

	private String hospitalName;

	private String hospitalPhone;

	private String hospitalPhoneExt;

	private String hospitalState = "GA";

	private String hospitalZip;

	private String hospitalZipExt;

	private Boolean controverted;

	private RadioButtonEnum injuredInEmpPermises;

	private String jobClassificationCode;

	private Double penalityPaid = null;

	private String physicianAddress1;

	private String physicianAddress2;

	private String physicianCity;

	/*
	 * @Size(max=100,
	 * message="Physician Email should not be more than 100 characters")
	 * 
	 * @Column(name = "PHYSICIAN_EMAIL") private String physicianEmail;
	 */

	private String physicianName;

	private String physicianPhone;

	private String physicianPhoneExt;

	private String physicianState = "GA";

	private String physicianZip;

	private String physicianZipExt;

	private RadioButtonEnum previousMedicalOnly;

	private String reasonForBenefitsNotPaid;

	private String reportPreparedBy;

	private String reportPreparedPhone;

	private String reportPreparedPhoneExt;

	private Date timeOfInjury = null;

	private Double wagePerWeekAfterReturn = null;

	private Double wageRate = null;

	private Integer wageRateFrequency;

	private Double weeklyBenefit = null;

	private String othersBodyPartComment;

	private String insurerFileNo;

	private Boolean certified = false;

	private String otherInjuryCause;
	private Boolean dobNotAvailable = false;

	private boolean select = false;

	private RadioButtonEnum incomeBenefits;
	
	private List<BodyPartType> bodyPartAffected;

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

	public DisabilityType getBenefitsPayableFor() {
		return benefitsPayableFor;
	}

	public void setBenefitsPayableFor(DisabilityType benefitsPayableFor) {
		this.benefitsPayableFor = benefitsPayableFor;
	}

	public ControvertType getControvertType() {
		return controvertType;
	}

	public void setControvertType(ControvertType controvertType) {
		this.controvertType = controvertType;
	}

	public Double getAverageWeeklyWage() {
		return averageWeeklyWage;
	}

	public void setAverageWeeklyWage(Double averageWeeklyWage) {
		this.averageWeeklyWage = averageWeeklyWage;
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

	public Date getDateUntilBenefitsPaid() {
		return dateUntilBenefitsPaid;
	}

	public void setDateUntilBenefitsPaid(Date dateUntilBenefitsPaid) {
		this.dateUntilBenefitsPaid = dateUntilBenefitsPaid;
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
		this.hospitalPhone = hospitalPhone;
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

	public String getHospitalZipExt() {
		return hospitalZipExt;
	}

	public void setHospitalZipExt(String hospitalZipExt) {
		this.hospitalZipExt = hospitalZipExt;
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
		this.physicianPhone = physicianPhone;
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

	public String getPhysicianZipExt() {
		return physicianZipExt;
	}

	public void setPhysicianZipExt(String physicianZipExt) {
		this.physicianZipExt = physicianZipExt;
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
		return reportPreparedPhone;
	}

	public void setReportPreparedPhone(String reportPreparedPhone) {
		this.reportPreparedPhone = reportPreparedPhone;
	}

	public String getReportPreparedPhoneExt() {
		return reportPreparedPhoneExt;
	}

	public void setReportPreparedPhoneExt(String reportPreparedPhoneExt) {
		this.reportPreparedPhoneExt = reportPreparedPhoneExt;
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

	public String getOthersBodyPartComment() {
		return othersBodyPartComment;
	}

	public void setOthersBodyPartComment(String othersBodyPartComment) {
		this.othersBodyPartComment = othersBodyPartComment;
	}

	public String getInsurerFileNo() {
		return insurerFileNo;
	}

	public void setInsurerFileNo(String insurerFileNo) {
		this.insurerFileNo = insurerFileNo;
	}

	public Boolean getCertified() {
		return certified;
	}

	public void setCertified(Boolean certified) {
		this.certified = certified;
	}

	public String getOtherInjuryCause() {
		return otherInjuryCause;
	}

	public void setOtherInjuryCause(String otherInjuryCause) {
		this.otherInjuryCause = otherInjuryCause;
	}

	public Boolean getDobNotAvailable() {
		return dobNotAvailable;
	}

	public void setDobNotAvailable(Boolean dobNotAvailable) {
		this.dobNotAvailable = dobNotAvailable;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public RadioButtonEnum getIncomeBenefits() {
		return incomeBenefits;
	}

	public void setIncomeBenefits(RadioButtonEnum incomeBenefits) {
		this.incomeBenefits = incomeBenefits;
	}

	public List<BodyPartType> getBodyPartAffected() {
		return bodyPartAffected;
	}

	public void setBodyPartAffected(List<BodyPartType> bodyPartAffected) {
		this.bodyPartAffected = bodyPartAffected;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	

}
