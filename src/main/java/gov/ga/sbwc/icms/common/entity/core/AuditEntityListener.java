package gov.ga.sbwc.icms.common.entity.core;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.stereotype.Component;

@Component
public class AuditEntityListener {

	@PrePersist
	public void onCreate(Object object) {
		if (object instanceof BaseEntity) {
			BaseEntity entity = (BaseEntity) object;
			if (entity.getCreatedBy() == null) {
				entity.setCreatedBy(getCurrentUser());
			}
			entity.setCreatedDate(new Date());
		}
	}

	@PreUpdate
	public void onUpdate(Object object) {
		if (object instanceof BaseEntity) {
			BaseEntity entity = (BaseEntity) object;
			if (entity.getLastUpdatedBy() == null) {
				entity.setLastUpdatedBy(getCurrentUser());
			}
			entity.setLastUpdatedDate(new Date());

			if (entity.isInActive() && entity.getDeactiveDate() != null)
				return;

			if (entity.isInActive() || entity.isDeleted()) {
				entity.setDeactiveDate(new Date());
			} else {
				entity.setDeactiveDate(null);
			}

			if (entity.getCreatedBy() == null) {
				entity.setCreatedBy(getCurrentUser());
			}
			if (entity.getCreatedDate() == null) {
				entity.setCreatedDate(new Date());
			}
		}
	}

	public Long getCurrentUser() {
		return 1L;
	}

}
