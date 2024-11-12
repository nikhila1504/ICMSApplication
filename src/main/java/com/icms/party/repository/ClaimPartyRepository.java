package com.icms.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.ClaimParty;

@Repository
public interface ClaimPartyRepository extends JpaRepository<ClaimParty, Long> {
	ClaimParty findByClaimPartyId(Long claimPartyId);

	List<ClaimParty> findByClaimId(Long claimId);
}
