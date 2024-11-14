package com.icms.party.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnTransformer;

import com.icms.party.enums.UserStatusEnum;
import com.icms.party.util.DataConversionUtil;

/**
 * The persistent class for the SECURITY_USER database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "SECURITY_USER")
public class SecurityUser extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "USER_ID_GENERATOR", sequenceName = "SECURITY_USER_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_GENERATOR")
	@Column(name = "USER_ID", nullable = false, unique = true)
	protected Long id;

	@Size(max = 100, message = "User Name should not be more than 50 characters")
	@Column(name = "USER_NAME", nullable = false, unique = true)
	@ColumnTransformer(forColumn = "USER_NAME", write = "TRIM(LOWER(?))")
	protected String username;

	@Size(max = 100, message = "First Name should not be more than 100 characters")
	@Column(name = "FIRST_NAME")
	@ColumnTransformer(forColumn = "FIRST_NAME", write = "TRIM(UPPER(?))")
	protected String firstName;

	@Size(max = 100, message = "Last Name should not be more than 100 characters")
	@Column(name = "LAST_NAME")
	@ColumnTransformer(forColumn = "LAST_NAME", write = "TRIM(UPPER(?))")
	private String lastName;

	@Size(max = 100, message = "Middle Name should not be more than 100 characters")
	@Column(name = "MIDDLE_NAME")
	@ColumnTransformer(forColumn = "MIDDLE_NAME", write = "TRIM(UPPER(?))")
	private String middleName;

	@Column(name = "EMAIL", nullable = false, unique = true)
	@ColumnTransformer(forColumn = "EMAIL", write = "TRIM(LOWER(?))")
	private String email;

	@Column(name = "IS_EXTERNAL")
	private boolean external = true;

	@Column(name = "IS_SECONDARY")
	private boolean secondary = false;

	@Column(name = "LAST_LOGIN_TIME")
	private Date lastLoginTime = new Date();

	@Column(name = "LAST_FAILED_LOGIN_TIME")
	private Date lastFailedLoginTime = new Date();

	@Column(name = "FAILED_LOGIN_COUNT")
	private int failedLoginCount = 0;

	@Column(name = "LAST_HOST_ADDRESS")
	private String lastHostAddress;

	@Column(name = "EXPIRATION_TIME")
	private Date expirationTime = new Date();

	@Column(name = "LAST_PASSWORD_CHANGE_TIME")
	private Date lastPasswordChangeTime = new Date();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SECURITY_ROLE_TYPE_ID")
	private SecurityRoleType securityRole;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_STATUS_TYPE_ID")
	protected UserStatusType userStatus;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DIVISION_TYPE_ID")
	private DivisionType division;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "REJECTION_REASON_TYPE")
	private RejectionReasonType rejectionReasonType;

	@Column(name = "OTHER_REJECTION_COMMENTS")
	private String externalComments;

	@Column(name = "IS_AVAILABLE_FOR_WORK")
	protected Boolean availableForWork = true;

	@Column(name = "PHONE_NUMBER")
	private String phone;

	@Column(name = "PHONE_EXT")
	private String phoneExt;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LOCATION_TYPE_ID")
	private LocationType location;

	@Column(name = "SESSION_ID")
	private String sessionId;

	@SuppressWarnings("unused")
	@Transient
	private String fullName;

	@Transient
	private Party party;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username != null ? username.toLowerCase() : null;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = (email != null ? email.toLowerCase() : null);
	}

	public boolean isExternal() {
		return this.external;
	}

	public void setExternal(boolean external) {
		this.external = external;
	}

	public boolean isSecondary() {
		return this.secondary;
	}

	public void setSecondary(boolean secondary) {
		this.secondary = secondary;
	}

	public Date getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getLastFailedLoginTime() {
		return this.lastFailedLoginTime;
	}

	public void setLastFailedLoginTime(Date lastFailedLoginTime) {
		this.lastFailedLoginTime = lastFailedLoginTime;
	}

	public int getFailedLoginCount() {
		return failedLoginCount;
	}

	public void setFailedLoginCount(int failedLoginCount) {
		this.failedLoginCount = failedLoginCount;
	}

	public String getLastHostAddress() {
		return lastHostAddress;
	}

	public void setLastHostAddress(String lastHostAddress) {
		this.lastHostAddress = lastHostAddress;
	}

	public Date getExpirationTime() {
		return this.expirationTime;
	}

	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}

	public Date getLastPasswordChangeTime() {
		return this.lastPasswordChangeTime;
	}

	public void setLastPasswordChangeTime(Date lastPasswordChangeTime) {
		this.lastPasswordChangeTime = lastPasswordChangeTime;
	}

	public SecurityRoleType getSecurityRole() {
		return securityRole;
	}

	public void setSecurityRole(SecurityRoleType securityRole) {
		this.securityRole = securityRole;
	}

	public UserStatusType getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(UserStatusType userStatus) {
		this.userStatus = userStatus;
	}

	public boolean isExpired() {
		return getExpirationTime().before(new Date());
	}

	public boolean isLocked() {
		return (UserStatusEnum.LOCKED.getCode().equalsIgnoreCase(userStatus.getCode()));
	}

	public boolean isDisabled() {
		return (UserStatusEnum.INACTIVE.getCode().equalsIgnoreCase(userStatus.getCode()));
	}

	public boolean isEnabled() {
		return (UserStatusEnum.ACTIVE.getCode().equalsIgnoreCase(userStatus.getCode()));
	}

	public boolean isSuspended() {
		return (UserStatusEnum.SUSPENDED.getCode().equalsIgnoreCase(userStatus.getCode()));
	}

	public boolean isRejected() {
		return (UserStatusEnum.REJECTED.getCode().equalsIgnoreCase(userStatus.getCode()));
	}

	public boolean isPending() {
		return (UserStatusEnum.PENDING.getCode().equalsIgnoreCase(userStatus.getCode()));
	}

	public void incrementFailedLoginCount() {
		failedLoginCount++;
	}

	public DivisionType getDivision() {
		return division;
	}

	public void setDivision(DivisionType division) {
		this.division = division;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof SecurityUser))
			return false;
		SecurityUser other = (SecurityUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Boolean getAvailableForWork() {
		return availableForWork;
	}

	public void setAvailableForWork(Boolean availableForWork) {
		this.availableForWork = availableForWork;
	}

	public RejectionReasonType getRejectionReasonType() {
		return rejectionReasonType;
	}

	public void setRejectionReasonType(RejectionReasonType rejectionReasonType) {
		this.rejectionReasonType = rejectionReasonType;
	}

	public String getExternalComments() {
		return externalComments;
	}

	public void setExternalComments(String externalComments) {
		this.externalComments = externalComments;
	}

	public String getPhone() {
		return DataConversionUtil.formatPhone(phone);
	}

	public void setPhone(String phone) {
		this.phone = DataConversionUtil.parsePhone(phone);
	}

	public String getPhoneExt() {
		return phoneExt;
	}

	public void setPhoneExt(String phoneExt) {
		this.phoneExt = phoneExt;
	}

	public LocationType getLocation() {
		return location;
	}

	public void setLocation(LocationType location) {
		this.location = location;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}