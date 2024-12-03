package com.icms.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icms.party.entity.TrailManagementCalendarIntHearing;

public interface TrlMgmtCalendarRepository extends JpaRepository<TrailManagementCalendarIntHearing, Long> {

	List<TrailManagementCalendarIntHearing> findByClaimNo(String claimNo);
}