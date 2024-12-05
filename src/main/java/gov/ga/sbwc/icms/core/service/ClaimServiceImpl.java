package gov.ga.sbwc.icms.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ga.sbwc.icms.common.entity.core.Claim;
import gov.ga.sbwc.icms.common.entity.core.Claimant;
import gov.ga.sbwc.icms.core.repository.ClaimRepository;
import gov.ga.sbwc.icms.core.repository.ClaimantRepository;

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
