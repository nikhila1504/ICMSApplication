package gov.ga.sbwc.icms.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.ga.sbwc.icms.common.entity.core.Claim;
import gov.ga.sbwc.icms.common.entity.core.Claimant;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
	Claim findClaimByClaimNo(String claimNo);

	List<Claim> findClaimByClaimant(Claimant claimant);
}
