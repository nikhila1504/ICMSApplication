package gov.ga.sbwc.icms.core.repository;

import org.springframework.stereotype.Repository;

import gov.ga.sbwc.icms.common.dto.form.FormDTO;

@Repository
public interface DocumentQueueRepository {
	
	public void pushForm(FormDTO formDto);
	
}
