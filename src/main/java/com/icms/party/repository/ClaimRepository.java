package com.icms.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.Claim;
import com.icms.party.entity.Claimant;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
	Claim findClaimByClaimNo(String claimNo);

	List<Claim> findClaimByClaimant(Claimant claimant);
}
