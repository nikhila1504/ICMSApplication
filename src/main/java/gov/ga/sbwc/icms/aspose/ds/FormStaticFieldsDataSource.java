package gov.ga.sbwc.icms.aspose.ds;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import gov.ga.sbwc.icms.common.constants.FormConstants;
import gov.ga.sbwc.icms.common.dto.form.FormDTO;
import gov.ga.sbwc.icms.common.dto.form.Wc1FormDTO;
import gov.ga.sbwc.icms.common.entity.core.Address;
import gov.ga.sbwc.icms.common.entity.core.Claim;
import gov.ga.sbwc.icms.common.entity.core.Claimant;
import gov.ga.sbwc.icms.common.entity.core.Contact;
import gov.ga.sbwc.icms.common.entity.core.Document;
import gov.ga.sbwc.icms.common.entity.core.Party;
import gov.ga.sbwc.icms.common.entity.core.Wc1Form;
import gov.ga.sbwc.icms.common.enums.PartyTypeEnum;
import gov.ga.sbwc.icms.common.util.AsposeUtil;
import gov.ga.sbwc.icms.common.util.DataConversionUtil;

public class FormStaticFieldsDataSource {

	private FormDTO formDto;
	private Map<String, Object> map = new LinkedHashMap<String, Object>();

	public FormStaticFieldsDataSource(FormDTO formDto) {
		this.formDto = formDto;
	}

	public String[] getClaimFieldNames() {
		return new String[] { FormConstants.CLAIM_NO, FormConstants.DATE_OF_INJURY, FormConstants.COUNTY_OF_INJURY,
				FormConstants.CLAIMANT_FIRST_NAME, FormConstants.CLAIMANT_LAST_NAME,
				FormConstants.CLAIMANT_MIDDLE_INITIAL, FormConstants.DATE_OF_BIRTH, FormConstants.CLAIMANT_PHONE,
				FormConstants.CLAIMANT_EMAIL, FormConstants.CLAIMANT_ADDRESS, FormConstants.CLAIMANT_CITY,
				FormConstants.CLAIMANT_STATE, FormConstants.CLAIMANT_ZIP, FormConstants.CLAIMANT_GENDER };
	}

	public Object[] getClaimFieldValues() throws Exception {
		Claim claim = formDto.getClaim();
		Claimant claimant = claim.getClaimant();

		return new Object[] { getClaimNo(claim.getClaimNo()), claim.getDateOfInjury(),
				claim.getCountyOfInjury().getDescription(), claimant.getFirstName(), claimant.getLastName(),
				claimant.getMiddleIntial(),
				claimant.getDateOfBirth() != null ? new SimpleDateFormat("MM/dd/yyyy").format(claimant.getDateOfBirth())
						: null,
				getPhone(claimant), getEmail(claimant), getAddress(claimant), getCity(claimant), getState(claimant),
				getZip(claimant), claimant.getGender() };
	}

	public String[] getSubmitterFieldNames() {
		return new String[] { FormConstants.SUBMITTER_NAME, FormConstants.SUBMITTER_EMAIL,
				FormConstants.SUBMITTER_PHONE, FormConstants.SUBMITTER_SIGNATURE_DATE, FormConstants.SUBMITTER_ADDRESS1,
				FormConstants.SUBMITTER_ADDRESS2, FormConstants.SUBMITTER_CITY, FormConstants.SUBMITTER_STATE,
				FormConstants.SUBMITTER_ZIP, FormConstants.SUBMITTER_BAR_NO,
				FormConstants.SUBMITTER_SIGNATURE_INDICATOR };
	}

	public Object[] getSubmitterFieldValues() throws Exception {
		Document document = formDto.getDocument();

		return new Object[] { document.getSubmitterName(), document.getSubmitterEmail(), getSubmitterPhone(document),
				document.getSubmitterSignatureDate() != null
						? new SimpleDateFormat("MM/dd/yyyy").format(document.getSubmitterSignatureDate())
						: null,
				document.getSubmitterAddress1(), document.getSubmitterAddress2(), document.getSubmitterCity(),
				document.getSubmitterState(),
				getZipwithExtString(document.getSubmitterZip(), document.getSubmitterZipExt()),
				document.getSubmitterBarNo(), getYesOrNo(document.getSubmitterSigned()) };
	}

	private String getYesOrNo(Boolean value) {
		String yes_no = "N";
		if (value != null && value) {
			yes_no = "Y";
		}

		return yes_no;
	}

	private String getClaimNo(String claimNo) {
		if (StringUtils.isNotBlank(claimNo)) {
			return DataConversionUtil.formatClaimNo(claimNo);
		}

		return FormConstants.DEFAULT_STRING;

	}

	private String getAddress(Address address) {
		if (address != null) {
			StringBuilder strAddress = new StringBuilder();
			if (StringUtils.isNotBlank(address.getAddress1())) {
				strAddress.append(address.getAddress1());
				if (StringUtils.isNotBlank(address.getAddress2())) {
					strAddress.append(", " + address.getAddress2());
				}
			}

			return strAddress.toString();
		}

		return FormConstants.DEFAULT_STRING;
	}

	private String getZip(Address address) {
		if (address != null) {
			StringBuilder zip = new StringBuilder();
			if (StringUtils.isNotBlank(address.getZip())) {
				zip.append(address.getZip());
			}

			return zip.toString();
		}

		return FormConstants.DEFAULT_STRING;
	}

	private String getEmail(Contact contact) {
		if (contact != null) {
			if (StringUtils.isNotBlank(contact.getPrimaryEmail())) {
				return contact.getPrimaryEmail();
			}
			if (StringUtils.isNotBlank(contact.getSecondaryEmail())) {
				return contact.getSecondaryEmail();
			}
		}

		return FormConstants.DEFAULT_STRING;
	}

	private String getPhone(Contact contact) {
		if (contact != null) {
			return contact.getPrimaryPhone();
		}

		return FormConstants.DEFAULT_STRING;
	}

	private String getAddress(Claimant claimant) {
		if (claimant != null) {
			StringBuilder strAddress = new StringBuilder();
			if (StringUtils.isNotBlank(claimant.getAddress1())) {
				strAddress.append(claimant.getAddress1());
				if (StringUtils.isNotBlank(claimant.getAddress2())) {
					strAddress.append(", " + claimant.getAddress2());
				}
			}

			return strAddress.toString();
		}

		return FormConstants.DEFAULT_STRING;
	}

	private String getZip(Claimant claimant) {
		if (claimant != null) {
			StringBuilder zip = new StringBuilder();
			if (StringUtils.isNotBlank(claimant.getZip())) {
				zip.append(claimant.getZip());
			}

			return zip.toString();
		}

		return FormConstants.DEFAULT_STRING;
	}

	private String getPhone(Claimant claimant) {
		if (claimant != null) {
			return claimant.getPrimaryPhone();
		}

		return FormConstants.DEFAULT_STRING;
	}

	private String getEmail(Claimant claimant) {
		if (claimant != null) {
			if (StringUtils.isNotBlank(claimant.getPrimaryEmail())) {
				return claimant.getPrimaryEmail();
			}
			if (StringUtils.isNotBlank(claimant.getSecondaryEmail())) {
				return claimant.getSecondaryEmail();
			}
		}

		return FormConstants.DEFAULT_STRING;
	}

	public String getContactPerson(Contact contact) {
		if (contact != null)
			return contact.getPreferredContactName();

		return FormConstants.DEFAULT_STRING;
	}

	public String getContactTitle(Contact contact) {
		if (contact != null)
			return contact.getContactTitle();

		return FormConstants.DEFAULT_STRING;
	}

	public String getFax(Contact contact) {
		if (contact != null)
			return contact.getFax();

		return FormConstants.DEFAULT_STRING;
	}

	private String getSubmitterPhone(Document document) {
		if (document != null) {
			StringBuilder phone = new StringBuilder();
			if (StringUtils.isNotBlank(document.getSubmitterPhone())) {
				phone.append(document.getSubmitterPhone());
			}
			return phone.toString();
		}

		return FormConstants.DEFAULT_STRING;
	}

	// 2491
	public String[] getPartyFieldNames() {
		return new String[] {
				// 2667
				FormConstants.EMPLOYER_NAME, FormConstants.EMPLOYER_ADDRESS, FormConstants.EMPLOYER_CITY,
				FormConstants.EMPLOYER_STATE, FormConstants.EMPLOYER_ZIP, FormConstants.EMPLOYER_EMAIL,
				FormConstants.EMPLOYER_PHONE, FormConstants.EMPLOYER_FEIN,

				FormConstants.INSURER_NAME, FormConstants.INSURER_FEIN, FormConstants.INSURER_SBWC_ID,

				FormConstants.CLAIMS_OFFICE_NAME, FormConstants.CLAIMS_OFFICE_FEIN, FormConstants.CLAIMS_OFFICE_PHONE,
				FormConstants.CLAIMS_OFFICE_EMAIL, FormConstants.CLAIMS_OFFICE_ADDRESS,
				FormConstants.CLAIMS_OFFICE_CITY, FormConstants.CLAIMS_OFFICE_STATE, FormConstants.CLAIMS_OFFICE_ZIP,
				FormConstants.INSURER_PHONE_NO,

				FormConstants.CLAIMANT_ATTORNEY_NAME, FormConstants.CLAIMANT_ATTORNEY_ADDRESS,
				FormConstants.CLAIMANT_ATTORNEY_CITY, FormConstants.CLAIMANT_ATTORNEY_STATE,
				FormConstants.CLAIMANT_ATTORNEY_ZIP, FormConstants.CLAIMANT_ATTORNEY_BAR_NUMBER,
				FormConstants.CLAIMANT_ATTORNEY_EMAIL, FormConstants.CLAIMANT_ATTORNEY_PHONE,

				FormConstants.ATTORNEY_NAME, FormConstants.ATTORNEY_ADDRESS, FormConstants.ATTORNEY_CITY,
				FormConstants.ATTORNEY_STATE, FormConstants.ATTORNEY_ZIP, FormConstants.BAR_NUMBER,
				FormConstants.ATTORNEY_EMAIL, FormConstants.ATTORNEY_PHONE };
	}

	public Object[] getPartyFieldValues() throws Exception {
		Party employer = formDto.getEmployer();
		Party insurer = formDto.getInsurer();
		Party claimsOffice = formDto.getClaimsOffice();
		Party claimantAttorney = formDto.getEmployeeOrClaimantAttorney();
		Party employerAttorney = formDto.getEmployerOrInsurerAttorney();
		return new Object[] { getName(employer), getAddress(employer != null ? employer.getAddress() : null),
				getCity(employer != null ? employer.getAddress() : null),
				getState(employer != null ? employer.getAddress() : null),
				getZip(employer != null ? employer.getAddress() : null),
				getEmail(employer != null ? employer.getContact() : null),
				getPhone(employer != null ? employer.getContact() : null), getFEIN(employer),

				getName(insurer), getFEIN(insurer), insurer != null ? insurer.getSbwcNumber() : null,

				getName(claimsOffice), getFEIN(claimsOffice),
				getPhone(claimsOffice != null ? claimsOffice.getContact() : null),
				getEmail(claimsOffice != null ? claimsOffice.getContact() : null),
				getAddress(
						claimsOffice != null ? claimsOffice.getAddress()
								: (AsposeUtil.isDisplayInsurerAddressOnClaimsoffice(formDto.getDocument())
										&& insurer != null ? insurer.getAddress() : null)),
				getCity(claimsOffice != null ? claimsOffice.getAddress()
						: (AsposeUtil.isDisplayInsurerAddressOnClaimsoffice(formDto.getDocument()) && insurer != null
								? insurer.getAddress()
								: null)),
				getState(
						claimsOffice != null ? claimsOffice.getAddress()
								: (AsposeUtil.isDisplayInsurerAddressOnClaimsoffice(formDto.getDocument())
										&& insurer != null ? insurer.getAddress() : null)),
				getZip(claimsOffice != null ? claimsOffice.getAddress()
						: (AsposeUtil.isDisplayInsurerAddressOnClaimsoffice(formDto.getDocument()) && insurer != null
								? insurer.getAddress()
								: null)),
				getPhone(insurer != null ? insurer.getContact() : null),

				(claimantAttorney != null ? claimantAttorney.getPartyName() : null),
				getAddress(claimantAttorney != null ? claimantAttorney.getAddress() : null),
				getCity(claimantAttorney != null ? claimantAttorney.getAddress() : null),
				getState(claimantAttorney != null ? claimantAttorney.getAddress() : null),
				getZip(claimantAttorney != null ? claimantAttorney.getAddress() : null),
				(claimantAttorney != null ? claimantAttorney.getBarNumber() : null),
				getEmail(claimantAttorney != null ? claimantAttorney.getContact() : null),
				getPhone(claimantAttorney != null ? claimantAttorney.getContact() : null),

				(employerAttorney != null ? employerAttorney.getPartyName() : null),
				getAddress(employerAttorney != null ? employerAttorney.getAddress() : null),
				getCity(employerAttorney != null ? employerAttorney.getAddress() : null),
				getState(employerAttorney != null ? employerAttorney.getAddress() : null),
				getZip(employerAttorney != null ? employerAttorney.getAddress() : null),
				(employerAttorney != null ? employerAttorney.getBarNumber() : null),
				getEmail(employerAttorney != null ? employerAttorney.getContact() : null),
				getPhone(employerAttorney != null ? employerAttorney.getContact() : null) };
	}

	public String[] getWC1FormFieldNames() {
		return new String[] { FormConstants.NAICS_CODE, FormConstants.NATURE_OF_BUSINESS, FormConstants.INSURER_FILE_NO,
				FormConstants.DATE_HIRED, FormConstants.JOB_CLASSIFICATION_CODE, FormConstants.DAYS_WORKED_PER_WEEK,
				FormConstants.WAGE_RATE, FormConstants.WAGE_RATE_FREQUENCY, FormConstants.INSURER_TYPE,
				FormConstants.DAYS_OFF, FormConstants.TIME_OF_INJURY, FormConstants.TIME_OF_INJURY_AM_PM,
				FormConstants.DATE_EMPLOYER_NOTIFIED, FormConstants.DATE_FAILED_TO_WORK_FULL_DAY,
				FormConstants.EMPLOYEE_RECEIVE_FULL_PAY, FormConstants.INJURY_OCCUR_EMPLOYER_PREMISES,
				FormConstants.TYPE_OF_INJURY, FormConstants.BODY_PART_TYPE, FormConstants.CAUSE_OF_INJURY,
				FormConstants.TREATING_PHYSICIAN, FormConstants.INITIAL_TREATMENT_GIVEN, FormConstants.HOSPITAL,
				FormConstants.DATE_RETURNED_TO_WORK, FormConstants.WAGE_PER_WEEK_AFTER_RETURN,
				FormConstants.DATE_OF_DEATH, FormConstants.REPORT_PREPARED_BY, FormConstants.REPORT_PREPARED_BY_PHONE,
				FormConstants.DATE_OF_REPORT, FormConstants.SECTION_B, FormConstants.SECTION_C, FormConstants.SECTION_D,
				FormConstants.PREVIOUS_MEDICAL_ONLY, FormConstants.AVERAGE_WEEKLY_WAGE, FormConstants.WEEKLY_BENEFIT,
				FormConstants.DATE_OF_DISABILITY, FormConstants.DATE_OF_FIRST_PAYMENT, FormConstants.COMPENSATION_PAID,
				FormConstants.DATE_SALARY_PAID, FormConstants.PENALTY_PAID, FormConstants.DATE_BENEFITS_PAYABLE_FROM,
				FormConstants.TEMPORARY_TOTAL_DISABILITY, FormConstants.TEMPORARY_PARTIAL_DISABILITY,
				FormConstants.PERMANENT_PARTIAL_DISABILITY, FormConstants.DISABILITY_PERCENTAGE,
				FormConstants.DISABILITY_BODY_TYPE, FormConstants.DISABILITY_IN_WEEKS,
				FormConstants.DATE_UNTIL_BENEFITS_PAID, FormConstants.CONTROVERT_TYPE,
				FormConstants.REASON_FOR_BENEFITS_NOT_PAID, FormConstants.NO_DISABILITY_PAID };
	}

	public String[] getFormFieldNames() {
		Set<String> set = map.keySet();
		String[] fieldNames = set.toArray(new String[set.size()]);
		return fieldNames;

	}

	public Object[] getFormFieldValues() {
		List<Object> list = new ArrayList<Object>(map.values());
		return list.toArray();
	}

	public Object[] getWC1FormFieldValues() throws Exception {
		Wc1FormDTO wc1FormDto = (Wc1FormDTO) formDto;
		Wc1Form wc1Form = wc1FormDto.getWc1Form();
		try {
			return new Object[] {
					wc1Form.getNaicsType() != null ? wc1Form.getNaicsType().getCode() : FormConstants.DEFAULT_STRING,
					wc1Form.getNaicsType() != null ? wc1Form.getNaicsType().getDescription()
							: FormConstants.DEFAULT_STRING,
					wc1Form.getInsurerFileNo(), wc1Form.getDateHired(), wc1Form.getJobClassificationCode(),
					wc1Form.getDaysWorkedPerWeek(), wc1Form.getWageRate(), wc1Form.getWageRateFrequency(),
					getInsurerType(formDto.getInsurer()), //
					"2", null,
					FormConstants.DEFAULT_STRING,
					wc1Form.getDateEmployerNotified(), wc1Form.getDateFailedToWorkFullDay(),
					wc1Form.getReceivedFullPay().getCode(), wc1Form.getInjuredInEmpPermises(),
					wc1Form.getTypeOfInjury() != null ? wc1Form.getTypeOfInjury().getDescription()
							: FormConstants.DEFAULT_STRING,
					wc1FormDto.getBodyPartType(), getCauseOfInjury(wc1Form), getTreatingPhysician(wc1Form),
					getInitialTreatment(wc1Form), getHospital(wc1Form), wc1Form.getDateReturnedToWork(),
					wc1Form.getWagePerWeekAfterReturn(), wc1Form.getDateOfDeath(), wc1Form.getReportPreparedBy(),
					wc1Form.getReportPreparedPhone(), wc1Form.getDateOfReport(), getYesOrNo(wc1Form.getSectionB()),
					getYesOrNo(wc1Form.getSectionC()), getYesOrNo(wc1Form.getSectionD()),
					wc1Form.getPreviousMedicalOnly() != null ? wc1Form.getPreviousMedicalOnly().getCode()
							: FormConstants.DEFAULT_STRING,
					wc1Form.getAverageWeeklyWage(), wc1Form.getWeeklyBenefit(), wc1Form.getDateOfDisability(),
					wc1Form.getDateOfFirstPayment(), wc1Form.getCompensationPaid(), wc1Form.getDateSalaryPaid(),
					wc1Form.getPenalityPaid(), wc1Form.getDateBenefitsPayableFrom(), getBenefitsPayableFor(wc1Form),
					getBenefitsPayableFor(wc1Form), getBenefitsPayableFor(wc1Form), wc1Form.getDisabilityPercentage(),
					wc1Form.getDisabilityBodyType() != null ? wc1Form.getDisabilityBodyType().getDescription()
							: FormConstants.DEFAULT_STRING,
					wc1Form.getDisabilityInWeeks(), wc1Form.getDateUntilBenefitsPaid(),
					wc1Form.getControvertType() != null ? wc1Form
							.getControvertType().getDescription() : FormConstants.DEFAULT_STRING,
					wc1Form.getReasonForBenefitsNotPaid(),
					((wc1Form.getSectionD() && (wc1Form.getControverted() != null ? wc1Form.getControverted() : false))
							? "Y"
							: "N") };
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getName(Party party) {
		if (party != null && StringUtils.isNotBlank(party.getPartyName())) {
			return party.getPartyName();
		}
		return FormConstants.DEFAULT_STRING;
	}

	private String getCity(Address address) {
		if (address != null && StringUtils.isNotBlank(address.getCity())) {
			return address.getCity();
		}
		return FormConstants.DEFAULT_STRING;
	}

	private String getState(Address address) {
		if (address != null && StringUtils.isNotBlank(address.getState())) {
			return address.getState();
		}
		return FormConstants.DEFAULT_STRING;
	}

	private String getCity(Claimant claimant) {
		if (claimant != null && StringUtils.isNotBlank(claimant.getCity())) {
			return claimant.getCity();
		}
		return FormConstants.DEFAULT_STRING;
	}

	private String getState(Claimant claimant) {
		if (claimant != null && StringUtils.isNotBlank(claimant.getState())) {
			return claimant.getState();
		}
		return FormConstants.DEFAULT_STRING;
	}

	private String getFEIN(Party party) {
		if (party != null && StringUtils.isNotBlank(party.getFederalEin())) {
			if (party.getFederalEin().replace("-", "").length() == 9)
				return DataConversionUtil.formatEIN(party.getFederalEin());
			else
				return FormConstants.DEFAULT_STRING;
		}

		return FormConstants.DEFAULT_STRING;
	}

	private String getInsurerType(Party party) {
		String insurerType = "NA";
		if (party != null && party.getPartyType() != null) {
			if (PartyTypeEnum.INSURER.getCode().equals(party.getPartyType().getCode())) {
				insurerType = "I";
			} else if (PartyTypeEnum.EMPLOYER.getCode().equals(party.getPartyType().getCode())
					&& party.getSelfInsured()) {
				insurerType = "SI";
			} else if (PartyTypeEnum.GROUP_FUND.getCode().equals(party.getPartyType().getCode())) {
				insurerType = "G";
			}
		}
		return insurerType;
	}

	private String getBenefitsPayableFor(Wc1Form wc1Form) {
		if (wc1Form.getSectionB() && wc1Form.getBenefitsPayableFor() != null) {
			if (wc1Form.getBenefitsPayableFor().getId() == 2) {
				return "TD";
			} else if (wc1Form.getBenefitsPayableFor().getId() == 5) {
				return "TP";
			} else if (wc1Form.getBenefitsPayableFor().getId() == 3) {
				return "PP";
			}
		}
		return "N";
	}

	private String getTreatingPhysician(Wc1Form wc1Form) {
		StringBuilder address = new StringBuilder();
		if (StringUtils.isNotBlank(wc1Form.getPhysicianName())) {
			address.append(wc1Form.getPhysicianName());
		}
		if (StringUtils.isNotBlank(wc1Form.getPhysicianAddress1())) {
			address.append("\r" + wc1Form.getPhysicianAddress1());
			if (StringUtils.isNotBlank(wc1Form.getPhysicianAddress2())) {
				address.append("\r" + wc1Form.getPhysicianAddress2());
			}
		}

		if (StringUtils.isNotBlank(wc1Form.getPhysicianCity())) {
			address.append("\r" + wc1Form.getPhysicianCity());
			if (StringUtils.isNotBlank(wc1Form.getPhysicianState())) {
				address.append(", " + wc1Form.getPhysicianState());
			}
			if (StringUtils.isNotBlank(wc1Form.getPhysicianZip())) {
				address.append(" " + wc1Form.getPhysicianZip());
			}
		}

		return address.toString();
	}

	private String getHospital(Wc1Form wc1Form) {
		StringBuilder address = new StringBuilder();
		if (StringUtils.isNotBlank(wc1Form.getHospitalName())) {
			address.append(wc1Form.getHospitalName());
		}
		if (StringUtils.isNotBlank(wc1Form.getHospitalAddress1())) {
			address.append("\r" + wc1Form.getHospitalAddress1());
			if (StringUtils.isNotBlank(wc1Form.getHospitalAddress2())) {
				address.append("\r" + wc1Form.getHospitalAddress2());
			}
		}

		if (StringUtils.isNotBlank(wc1Form.getHospitalCity())) {
			address.append("\r" + wc1Form.getHospitalCity());
			if (StringUtils.isNotBlank(wc1Form.getHospitalState())) {
				address.append(", " + wc1Form.getHospitalState());
			}
			if (StringUtils.isNotBlank(wc1Form.getHospitalZip())) {
				address.append(" " + wc1Form.getHospitalZip());
			}
		}

		return address.toString();
	}

	private String getDaysOff(Wc1Form wc1Form) {
		if (StringUtils.isNotEmpty(wc1Form.getDaysOff())) {
			StringBuilder daysOff = new StringBuilder();
			if (wc1Form.getDaysOff().contains("1")) {
				daysOff.append("M, ");
			}
			if (wc1Form.getDaysOff().contains("2")) {
				daysOff.append("T, ");
			}
			if (wc1Form.getDaysOff().contains("3")) {
				daysOff.append("W, ");
			}
			if (wc1Form.getDaysOff().contains("4")) {
				daysOff.append("Th, ");
			}
			if (wc1Form.getDaysOff().contains("5")) {
				daysOff.append("F, ");
			}
			if (wc1Form.getDaysOff().contains("6")) {
				daysOff.append("Sa, ");
			}
			if (wc1Form.getDaysOff().contains("0")) {
				daysOff.append("Su, ");
			}
			if (wc1Form.getDaysOff().contains("7")) {// Added for EDI work week type code - V (Medical only claims)
				daysOff.append("VARIES, ");
			}
			return daysOff.toString().substring(0, daysOff.toString().length() - 2);
		}

		return FormConstants.DEFAULT_STRING;
	}

	private String getAmPmFromTime(Wc1Form wc1Form) {
		if (wc1Form.getTimeOfInjury() != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(wc1Form.getTimeOfInjury());
			if (cal.get(Calendar.AM_PM) == Calendar.PM) {
				return FormConstants.PM;
			} else {
				return FormConstants.AM;
			}
		}
		return FormConstants.DEFAULT_STRING;
	}

	private String getInitialTreatment(Wc1Form wc1Form) {
		if (wc1Form.getInitialTreatmentGiven() != null) {
			if (StringUtils.isNotEmpty(wc1Form.getInitialTreatmentGiven().getCode())) {
				return wc1Form.getInitialTreatmentGiven().getCode();
			} else {
				return FormConstants.DEFAULT_STRING;
			}
		} else {
			return FormConstants.DEFAULT_STRING;
		}
	}

	private String getCauseOfInjury(Wc1Form wc1Form) {
		StringBuilder causeOfInjury = new StringBuilder(wc1Form.getOtherInjuryCause());
		if (wc1Form.getCauseOfInjury() != null) {
			causeOfInjury.append(";" + wc1Form.getCauseOfInjury().getDescription());
		}

		return causeOfInjury.toString();
	}

	private String getZipwithExtString(String zip, String zipExt) {
		String zipWithExt = "";
		if (StringUtils.isNotBlank(zip)) {
			zipWithExt = zip;
			if (StringUtils.isNotBlank(zipExt)) {
				zipWithExt = zipWithExt + "-" + zipExt;
			}

		}

		return zipWithExt;
	}

}
