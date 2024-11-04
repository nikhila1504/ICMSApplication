package com.icms.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icms.party.entity.Claim;
import com.icms.party.entity.ClaimParty;

public interface ClaimPartyRepository extends JpaRepository<ClaimParty, Long> {
	List<ClaimParty> findByClaimId(Long claimId);

}
