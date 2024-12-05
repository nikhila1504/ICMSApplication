package gov.ga.sbwc.icms.common.entity.core;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import gov.ga.sbwc.icms.common.enums.RecordStatusEnum;

@MappedSuperclass
@EntityListeners(AuditEntityListener.class)
@DynamicInsert
@DynamicUpdate
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "CREATED_BY", nullable = false)
	protected Long createdBy;

	@NotNull
	@Column(name = "CREATED_DATE", nullable = false, insertable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdDate;

	@Column(name = "LAST_UPDATED_BY", nullable = true)
	protected Long lastUpdatedBy;

	@Column(name = "LAST_UPDATED_DATE", nullable = true, insertable = false, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastUpdatedDate;

	@Column(name = "DEACTIVE_DATE", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date deactiveDate;

	@NotNull
	@Column(name = "RECORD_STATUS", nullable = false)
	protected int recordStatus = 1;

	@Transient
	protected boolean checked;

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Date getDeactiveDate() {
		return deactiveDate;
	}

	public void setDeactiveDate(Date deactiveDate) {
		this.deactiveDate = deactiveDate;
	}

	public int getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(int recordStatus) {
		this.recordStatus = recordStatus;
	}

	public boolean isChecked() {
		return recordStatus == RecordStatusEnum.INACTIVE.getCode();
	}

	public void setChecked(boolean checked) {
		recordStatus = checked ? RecordStatusEnum.INACTIVE.getCode() : RecordStatusEnum.ACTIVE.getCode();
	}

	public boolean isActive() {
		return recordStatus == RecordStatusEnum.ACTIVE.getCode();
	}

	public boolean isInActive() {
		return recordStatus == RecordStatusEnum.INACTIVE.getCode();
	}

	public boolean isDraft() {
		return recordStatus == RecordStatusEnum.DRAFT.getCode();
	}

	public boolean isDuplicate() {
		return recordStatus == RecordStatusEnum.DUPLICATE.getCode();
	}

	public boolean isDeleted() {
		return recordStatus == RecordStatusEnum.DELETED.getCode();
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (!(obj instanceof BaseEntity))
//			return false;
//		BaseEntity other = (BaseEntity) obj;
//		if (getId() == null) {
//			return false;
//		}
//		return getId().equals(other.getId());
//	}
//
//	@Override
//	public int hashCode() {
//		if (getId() != null) {
//			return getId().hashCode();
//		} else {
//			return super.hashCode();
//		}
//	}
//
//	@Override
//	public String toString() {
//		return this.getClass().getName() + " [id=" + getId() + "]";
//	}

}