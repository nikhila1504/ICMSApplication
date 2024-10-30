package com.icms.party.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icms.party.entity.Claim;
import com.icms.party.repository.ClaimRepository;

@Service
public class ClaimServiceImpl {

	@Autowired
	private ClaimRepository claimRepository;

	public Claim getClaimById(Long id) {
		return claimRepository.findById(id).orElse(null);
	}

	public Claim getClaimByClaimNo(String claimNo) {
		return claimRepository.findClaimByClaimNo(claimNo);
	}
	
}
