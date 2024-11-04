package com.icms.party.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icms.party.entity.Claimant;
import com.icms.party.repository.ClaimantRepository;

@Service
public class ClaimantServiceImpl {

	@Autowired
	private ClaimantRepository claimantRepository;

	public Claimant getClaimantById(Long id) {
		return claimantRepository.findById(id).orElse(null);
	}

}
