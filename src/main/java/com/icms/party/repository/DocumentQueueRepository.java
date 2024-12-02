package com.icms.party.repository;

import org.springframework.stereotype.Repository;

import com.icms.party.dto.FormDTO;

@Repository
public interface DocumentQueueRepository {
	
	public void pushForm(FormDTO formDto);
	
}
