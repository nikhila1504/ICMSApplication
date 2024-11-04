package com.icms.party.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icms.party.entity.Claim;
import com.icms.party.entity.Claimant;
import com.icms.party.repository.ClaimRepository;
import com.icms.party.repository.ClaimantRepository;

@Service
public class ClaimServiceImpl {

	@Autowired
	private ClaimRepository claimRepository;

	@Autowired
	private ClaimantRepository claimantRepository;

	public Claim getClaimById(Long id) {
		return claimRepository.findById(id).orElse(null);
	}

	public Claim getClaimByClaimNo(String claimNo) {
		return claimRepository.findClaimByClaimNo(claimNo);
	}

	public List<Claim> getClaimByClaimantId(Long id) {
		Claimant claimant = claimantRepository.findById(id).orElse(null);
		return claimRepository.findClaimByClaimant(claimant);
	}
}
