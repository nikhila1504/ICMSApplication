package gov.ga.sbwc.icms.common.entity.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;


/**
 * The persistent class for the RPT_USER_PRODUCTIVITY_REPORT database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "RPT_USER_PRODUCTIVITY_REPORT")
@Immutable
public class UserProductivityReport implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private UserProductivityReportPK userProductivityReportPK;
	
	@Column(name="FUNCTIONAL_ROLE")
	private String functionalRole;
	
	@Column(name="DISPLAY_ORDER")
	private Integer displayOrder;

	public UserProductivityReport() {
	}

	public UserProductivityReportPK getUserProductivityReportPK() {
		return userProductivityReportPK;
	}

	public void setUserProductivityReportPK(
			UserProductivityReportPK userProductivityReportPK) {
		this.userProductivityReportPK = userProductivityReportPK;
	}

	public String getFunctionalRole() {
		return functionalRole;
	}

	public void setFunctionalRole(String functionalRole) {
		this.functionalRole = functionalRole;
	}

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}


}