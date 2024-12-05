package gov.ga.sbwc.icms.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ga.sbwc.icms.common.entity.core.Claimant;
import gov.ga.sbwc.icms.core.repository.ClaimantRepository;

@Service
public class ClaimantServiceImpl {

	@Autowired
	private ClaimantRepository claimantRepository;

	public Claimant getClaimantById(Long id) {
		return claimantRepository.findById(id).orElse(null);
	}

}
