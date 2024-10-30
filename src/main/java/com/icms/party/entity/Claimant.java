package com.icms.party.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnTransformer;

import com.icms.party.util.DataConversionUtil;

/**
 * The persistent class for the CLAIMANT database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "CLAIMANT")
public class Claimant extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CLAIMANT_ID_GENERATOR", sequenceName = "CLAIMANT_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLAIMANT_ID_GENERATOR")
	@Column(name = "CLAIMANT_ID")
	private Long id;

	@Column(name = "CLAIMANT_NO")
	private Long claimantNo;

	@Column(name = "DATE_OF_BIRTH")
	private Date dateOfBirth;

	@Size(max = 100, message = "Claimant First Name should not be more than 100 characters")
	@Column(name = "FIRST_NAME")
	@ColumnTransformer(forColumn = "FIRST_NAME", write = "TRIM(UPPER(?))")
	private String firstName;

	@Size(max = 1, message = "Claimant Gender should not be more than 1 character")
	@Column(name = "GENDER")
	private String gender;

	@Size(max = 100, message = "Claimant Last Name should not be more than 100 characters")
	@Column(name = "LAST_NAME")
	@ColumnTransformer(forColumn = "LAST_NAME", write = "TRIM(UPPER(?))")
	private String lastName;

	@Size(max = 1, message = "Claimant Middle Initial should not be more than 1 character")
	@Column(name = "MIDDLE_INTIAL")
	@ColumnTransformer(forColumn = "MIDDLE_INTIAL", write = "TRIM(UPPER(?))")
	private String middleIntial;

	@Size(max = 100, message = "Address1 should not be more than 100 characters")
	@Column(name = "ADDRESS1")
	@ColumnTransformer(forColumn = "ADDRESS1", write = "TRIM(UPPER(?))")
	private String address1;

	@Size(max = 100, message = "Address2 Name should not be more than 100 characters")
	@Column(name = "ADDRESS2")
	@ColumnTransformer(forColumn = "ADDRESS2", write = "TRIM(UPPER(?))")
	private String address2;

	@Size(max = 100, message = "City should not be more than 100 characters")
	@ColumnTransformer(forColumn = "CITY", write = "TRIM(UPPER(?))")
	@Column(name = "CITY")
	private String city;

	@Size(max = 2, message = "State should not be more than 2 characters")
	@Column(name = "STATE")
	private String state = "GA";

	@Column(name = "ZIP")
	private String zip;

	@Column(name = "ZIP_EXT")
	private String zipExt;

	@Column(name = "IS_OUT_OF_COUNTRY")
	private Boolean international = false;

	@Size(max = 30, message = "Contact Method should not be more than 30 characters")
	@Column(name = "PREFERRED_CONTACT_METHOD")
	private String preferredContactMethod;

	@Size(max = 100, message = "Contact Person should not be more than 100 characters")
	@Column(name = "PREFERRED_CONTACT_NAME")
	private String preferredContactName;

	@Size(max = 100, message = "Primary Email should not be more than 100 characters")
	@Column(name = "PRIMARY_EMAIL")
	private String primaryEmail;

	@Size(max = 100, message = "Secondary Email should not be more than 100 characters")
	@Column(name = "SECONDARY_EMAIL")
	private String secondaryEmail;

	@Column(name = "PRIMARY_PHONE")
	private String primaryPhone;

	@Column(name = "PRIMARY_PHONE_EXT")
	private String primaryPhoneExt;

	@Column(name = "SECONDARY_PHONE")
	private String secondaryPhone;

	@Column(name = "SECONDARY_PHONE_EXT")
	private String secondaryPhoneExt;

	@Transient
	private Boolean exactMatch = false;

	@Transient
	private Boolean select = false;

	@Transient
	private String fullName;

	public Claimant() {
	}

	public Claimant(String firstName, String lastName, Date dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClaimantNo() {
		return claimantNo;
	}

	public void setClaimantNo(Long claimantNo) {
		this.claimantNo = claimantNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleIntial() {
		return middleIntial;
	}

	public void setMiddleIntial(String middleIntial) {
		this.middleIntial = middleIntial;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Boolean getSelect() {
		return select;
	}

	public void setSelect(Boolean select) {
		this.select = select;
	}

	public Boolean getExactMatch() {
		return exactMatch;
	}

	public void setExactMatch(Boolean exactMatch) {
		this.exactMatch = exactMatch;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return DataConversionUtil.formatZip(this.zip);
	}

	public void setZip(String zip) {
		this.zip = DataConversionUtil.parseZip(zip);
	}

	public String getZipExt() {
		return this.zipExt;
	}

	public void setZipExt(String zipExt) {
		this.zipExt = zipExt;
	}

	public Boolean getInternational() {
		return international;
	}

	public void setInternational(Boolean international) {
		this.international = international;
	}

	public String getPreferredContactMethod() {
		return this.preferredContactMethod;
	}

	public void setPreferredContactMethod(String preferredContactMethod) {
		this.preferredContactMethod = preferredContactMethod;
	}

	public String getPreferredContactName() {
		return this.preferredContactName != null ? this.preferredContactName.toUpperCase() : null;
	}

	public void setPreferredContactName(String preferredContactName) {
		this.preferredContactName = preferredContactName;
	}

	public String getPrimaryEmail() {
		return this.primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public String getPrimaryPhone() {
		return DataConversionUtil.formatPhone(this.primaryPhone);
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = DataConversionUtil.parsePhone(primaryPhone);
	}

	public String getPrimaryPhoneExt() {
		return this.primaryPhoneExt;
	}

	public void setPrimaryPhoneExt(String primaryPhoneExt) {
		this.primaryPhoneExt = primaryPhoneExt;
	}

	public String getSecondaryEmail() {
		return this.secondaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	public String getSecondaryPhone() {
		return DataConversionUtil.formatPhone(this.secondaryPhone);
	}

	public void setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = DataConversionUtil.parsePhone(secondaryPhone);
	}

	public String getSecondaryPhoneExt() {
		return this.secondaryPhoneExt;
	}

	public void setSecondaryPhoneExt(String secondaryPhoneExt) {
		this.secondaryPhoneExt = secondaryPhoneExt;
	}
}