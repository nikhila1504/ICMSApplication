package gov.ga.sbwc.icms.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.ga.sbwc.icms.common.entity.core.Claimant;

@Repository
public interface ClaimantRepository extends JpaRepository<Claimant, Long> {

}
