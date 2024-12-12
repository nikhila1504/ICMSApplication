package gov.ga.sbwc.icms.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ga.sbwc.icms.common.entity.core.ClaimParty;
import gov.ga.sbwc.icms.core.repository.ClaimPartyRepository;

@Service
public class ClaimPartyServiceImpl {

	@Autowired
	private ClaimPartyRepository claimPartyRepository;

	public ClaimParty getClaimPartyById(Long claimPartyId) {
		return claimPartyRepository.findByClaimPartyId(20750217L);
	}

	public List<ClaimParty> getClaimPartyByClaimId(Long id) {
		return claimPartyRepository.findByClaimIdOrderByPartyPartyTypeDisplayOrder(id);
	}
}
