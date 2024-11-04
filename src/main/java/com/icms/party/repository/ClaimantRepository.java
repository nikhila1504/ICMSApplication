package com.icms.party.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.Claimant;

@Repository
public interface ClaimantRepository extends JpaRepository<Claimant, Long> {

}
