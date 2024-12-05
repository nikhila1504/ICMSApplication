package gov.ga.sbwc.icms.common.entity.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import org.hibernate.annotations.Immutable;

/**
 * The persistent class for the "SECURITY_ROLE_TYPE" database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "SECURITY_ROLE_TYPE")
public class SecurityRoleType extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SECURITY_ROLE_ID_GENERATOR", sequenceName = "SECURITY_ROLE_TYPE_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SECURITY_ROLE_ID_GENERATOR")
	@Column(name = "SECURITY_ROLE_TYPE_ID")
	private Long id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "IS_EXTERNAL")
	private Boolean external;

	public SecurityRoleType() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isExternal() {
		return this.external;
	}

	public void setExternal(boolean external) {
		this.external = external;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SecurityRoleType))
			return false;
		SecurityRoleType other = (SecurityRoleType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}