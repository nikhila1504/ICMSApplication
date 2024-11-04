package com.icms.party.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnTransformer;

import com.icms.party.util.DataConversionUtil;

/**
 * The persistent class for the CONTACT database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "CONTACT")
public class Contact extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 2029258605461875419L;

	@Id
	@SequenceGenerator(name = "CONTACT_ID_GENERATOR", sequenceName = "CONTACT_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTACT_ID_GENERATOR")
	@NotNull
	@Column(name = "CONTACT_ID")
	private Long id;

	@Size(max = 30, message = "Contact Method should not be more than 30 characters")
	@Column(name = "PREFERRED_CONTACT_METHOD")
	private String preferredContactMethod;

	@Size(max = 100, message = "Contact Person should not be more than 100 characters")
	@Column(name = "PREFERRED_CONTACT_NAME")
	@ColumnTransformer(forColumn = "PREFERRED_CONTACT_NAME", write = "TRIM(UPPER(?))")
	private String preferredContactName;

	@Size(max = 100, message = "Primary Email should not be more than 100 characters")
	@Column(name = "PRIMARY_EMAIL")
	@ColumnTransformer(forColumn = "PRIMARY_EMAIL", write = "TRIM(LOWER(?))", read = "LOWER(PRIMARY_EMAIL)")
	private String primaryEmail;

	@Size(max = 100, message = "Secondary Email should not be more than 100 characters")
	@Column(name = "SECONDARY_EMAIL")
	@ColumnTransformer(forColumn = "SECONDARY_EMAIL", write = "TRIM(LOWER(?))", read = "LOWER(SECONDARY_EMAIL)")
	private String secondaryEmail;

	@Column(name = "PRIMARY_PHONE")
	private String primaryPhone;

	@Column(name = "PRIMARY_PHONE_EXT")
	private String primaryPhoneExt;

	@Column(name = "SECONDARY_PHONE")
	private String secondaryPhone;

	@Column(name = "SECONDARY_PHONE_EXT")
	private String secondaryPhoneExt;

	@Size(max = 100, message = "Contact Title should not be more than 100 characters")
	@Column(name = "CONTACT_TITLE")
	private String contactTitle;

	@Column(name = "CONTACT_PHONE")
	private String contactPhone;

	@Column(name = "CONTACT_PHONE_EXT")
	private String contactPhoneExt;

	@Column(name = "FAX")
	private String fax;

	public Contact() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return DataConversionUtil.formatPhone(primaryPhone, primaryPhoneExt);
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhoneExt = DataConversionUtil.parsePhoneExt(primaryPhone);
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
		return DataConversionUtil.formatPhone(secondaryPhone, secondaryPhoneExt);
	}

	public void setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhoneExt = DataConversionUtil.parsePhoneExt(secondaryPhone);
		this.secondaryPhone = DataConversionUtil.parsePhone(secondaryPhone);
	}

	public String getSecondaryPhoneExt() {
		return this.secondaryPhoneExt;
	}

	public void setSecondaryPhoneExt(String secondaryPhoneExt) {
		this.secondaryPhoneExt = secondaryPhoneExt;
	}

	public String getContactTitle() {
		return contactTitle;
	}

	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}

	public String getFax() {
		return DataConversionUtil.formatPhone(fax);
	}

	public void setFax(String fax) {
		this.fax = DataConversionUtil.parsePhone(fax);
	}

	public String getContactPhone() {
		return DataConversionUtil.formatPhone(contactPhone, contactPhoneExt);
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhoneExt = DataConversionUtil.parsePhoneExt(contactPhone);
		this.contactPhone = DataConversionUtil.parsePhone(contactPhone);
	}

	public String getContactPhoneExt() {
		return this.contactPhoneExt;
	}

	public void setContactPhoneExt(String contactPhoneExt) {
		this.contactPhoneExt = contactPhoneExt;
	}

}