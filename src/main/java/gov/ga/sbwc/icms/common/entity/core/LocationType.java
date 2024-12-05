package gov.ga.sbwc.icms.common.entity.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import gov.ga.sbwc.icms.common.util.DataConversionUtil;

/**
 * The persistent class for the OFFICE_LOCATION database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "LOCATION_TYPE")
//@Immutable
@NamedQueries({
		@NamedQuery(name = "LocationType.findAll", query = "select ol from LocationType ol where ol.recordStatus = 1 order by ol.area asc"),
		@NamedQuery(name = "LocationType.findById", query = "select ol from LocationType ol  where ol.id = :locationId and ol.recordStatus= 1")

})
public class LocationType extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "LOCATION_TYPE_ID_GENERATOR", sequenceName = "LOCATION_TYPE_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOCATION_TYPE_ID_GENERATOR")
	@Column(name = "LOCATION_TYPE_ID", nullable = false, unique = true)
	private Long id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "ADDRESS1")
	private String address1;

	@Column(name = "ADDRESS2")
	private String address2;

	@Column(name = "AREA")
	private String area;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE")
	private String state = "GA";

	@Column(name = "ZIP")
	private String zip;

	@Column(name = "ZIP_EXT")
	private String zipExt;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "PHONE_EXT")
	private String phoneExt;

	@Column(name = "IS_HEAD_OFFICE")
	private Boolean headOffice = false;

	public LocationType() {
	}

	public Long getId() {
		return id;
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

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isHeadOffice() {
		return headOffice;
	}

	public void setHeadOffice(boolean headOffice) {
		this.headOffice = headOffice;
	}

	public String getPhone() {
		// return this.phone;
		// 2590
		return DataConversionUtil.formatPhone(phone, phoneExt);
	}

	public void setPhone(String phone) {
		// this.phone = phone;
		// 2590
		this.phoneExt = DataConversionUtil.parsePhoneExt(phone);
		this.phone = DataConversionUtil.parsePhone(phone);
	}

	public String getPhoneExt() {
		return this.phoneExt;
	}

	public void setPhoneExt(String phoneExt) {
		this.phoneExt = phoneExt;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getZipExt() {
		return this.zipExt;
	}

	public void setZipExt(String zipExt) {
		this.zipExt = zipExt;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof LocationType))
			return false;
		LocationType other = (LocationType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}