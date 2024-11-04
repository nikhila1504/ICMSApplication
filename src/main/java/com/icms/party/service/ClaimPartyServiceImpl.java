package com.icms.party.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icms.party.entity.Claim;
import com.icms.party.entity.ClaimParty;
import com.icms.party.repository.ClaimPartyRepository;
import com.icms.party.repository.ClaimRepository;

@Service
public class ClaimPartyServiceImpl {

	@Autowired
	private ClaimPartyRepository claimPartyRepository;

	@Autowired
	private ClaimRepository claimRepository;

	public ClaimParty getClaimPartyById(Long id) {
		return claimPartyRepository.findById(id).orElse(null);
	}

	public List<ClaimParty> getClaimPartyByClaimId(Long claimId) {
//		Claim claim = claimRepository.findById(claimId).orElseThrow(() -> new RuntimeException("Claim not found"));
		return claimPartyRepository.findByClaimId(claimId);
	}

}
