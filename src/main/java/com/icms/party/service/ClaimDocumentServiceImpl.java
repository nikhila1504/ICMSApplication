package com.icms.party.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icms.party.entity.ClaimDocument;
import com.icms.party.repository.ClaimDocumentRepository;

@Service
public class ClaimDocumentServiceImpl {

	@Autowired
	private ClaimDocumentRepository claimDocumentRepository;

	public ClaimDocument getClaimDocumentById(Long id) {
		return claimDocumentRepository.findById(id).orElse(null);
	}

}
