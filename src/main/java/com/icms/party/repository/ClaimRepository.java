package com.icms.party.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
	Claim findClaimByClaimNo(String claimNo);
}
