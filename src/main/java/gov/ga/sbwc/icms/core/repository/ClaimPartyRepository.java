package gov.ga.sbwc.icms.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.ga.sbwc.icms.common.entity.core.ClaimParty;

@Repository
public interface ClaimPartyRepository extends JpaRepository<ClaimParty, Long> {
	ClaimParty findByClaimPartyId(Long claimPartyId);

	List<ClaimParty> findByClaimId(Long claimId);
	
	List<ClaimParty> findByClaimIdOrderByPartyPartyTypeDisplayOrder(Long claimId);
}
