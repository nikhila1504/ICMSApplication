package com.icms.party.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icms.party.entity.Claim;
import com.icms.party.entity.ClaimDocument;
import com.icms.party.entity.Wc1Form;
import com.icms.party.repository.ClaimDocumentRepository;
import com.icms.party.repository.ClaimRepository;
import com.icms.party.repository.Wc1FormRepository;

@Service
public class Wc1FormServiceImpl {

	@Autowired
	private Wc1FormRepository wc1FormRepository;

	@Autowired
	private ClaimRepository claimRepository;

	@Autowired
	private ClaimDocumentRepository claimDocumentRepository;

	public Wc1Form saveWc1Form(Wc1Form wc1Form) {
		return wc1FormRepository.save(wc1Form);
	}

	public Wc1Form getWc1FormById(Long id) {
		return wc1FormRepository.findById(id).orElse(null);
	}

	public Wc1Form updateWc1Form(Wc1Form wc1Form) {
		return wc1FormRepository.save(wc1Form);
	}

	public void deleteWc1FormById(Long id) {
		wc1FormRepository.deleteById(id);
	}

	public Claim getClaimById(Long id) {
		return claimRepository.findById(id).orElse(null);
	}

	public Claim updateClaim(Claim claim) {
		return claimRepository.save(claim);
	}

	public ClaimDocument updateClaimDocument(ClaimDocument claimDocument) {
		return claimDocumentRepository.save(claimDocument);
	}
}
