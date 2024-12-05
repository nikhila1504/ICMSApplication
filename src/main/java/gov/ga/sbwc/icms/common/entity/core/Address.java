package gov.ga.sbwc.icms.common.entity.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnTransformer;

import gov.ga.sbwc.icms.common.util.DataConversionUtil;

/**
 * The persistent class for the ADDRESS database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "ADDRESS")
public class Address extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ADDRESS_ID_GENERATOR", sequenceName = "ADDRESS_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_ID_GENERATOR")
	@Column(name = "ADDRESS_ID")
	private Long id;

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

	public Address() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return DataConversionUtil.formatZip(this.zip, this.zipExt);
	}

	public void setZip(String zip) {
		this.zipExt = DataConversionUtil.parseZipExt(zip);
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

	@Override
	public String toString() {
		return address1 + ", " + (address2 == null ? "" : address2 + ",") + city + ", " + state + ", " + zip
				+ (zipExt == null ? "" : "-" + zipExt);
	}

}