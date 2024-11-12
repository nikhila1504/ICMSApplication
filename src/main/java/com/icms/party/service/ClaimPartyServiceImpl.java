package com.icms.party.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icms.party.entity.ClaimParty;
import com.icms.party.repository.ClaimPartyRepository;

@Service
public class ClaimPartyServiceImpl {

	@Autowired
	private ClaimPartyRepository claimPartyRepository;

	public ClaimParty getClaimPartyById(Long claimPartyId) {
		return claimPartyRepository.findByClaimPartyId(20750217L);
	}

	public List<ClaimParty> getClaimPartyByClaimId(Long id) {
		return claimPartyRepository.findByClaimId(id);
	}
}
