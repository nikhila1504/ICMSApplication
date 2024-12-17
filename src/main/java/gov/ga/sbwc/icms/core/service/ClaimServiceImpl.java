package gov.ga.sbwc.icms.core.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
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

	public List<Claim> findMatchingClaims(String firstName, String lastName, Date dateOfBirth, Date dateOfInjury) {
		Date startDate = DateUtils.addDays(dateOfInjury, -30);
		Date endDate = DateUtils.addDays(dateOfInjury, 30);
		if (dateOfBirth != null) {
			return claimRepository.findMatchingClaims(firstName, lastName, dateOfBirth, startDate, endDate);
		} else
			return claimRepository.findMatchingClaims(firstName, lastName, startDate, endDate);
	}

	public List<Claim> findExactMatchClaims(Date dateOfBirth, Date dateOfInjury) {
		return claimRepository.findExactMatchClaims(dateOfBirth, dateOfInjury);
	}
}
