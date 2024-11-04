package com.icms.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.Claim;
import com.icms.party.entity.ClaimParty;
import com.icms.party.entity.Claimant;

@Repository
public interface ClaimPartyRepository extends JpaRepository<ClaimParty, Long> {
	@Query("SELECT t FROM ClaimParty t where recordStatus=1 and t.claim.claimNo=:claimNo")
	List<ClaimParty> findClaimPartyByClaimNo(String claimNo);

	@Query("SELECT cp from ClaimParty as cp where cp.claim.id = :claimId")
	List<ClaimParty> findByClaimId(Long claimId);
	
	
	List<ClaimParty> findClaimPartyByClaim(Claim claim);
	
}
