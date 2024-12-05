package gov.ga.sbwc.icms.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.ga.sbwc.icms.common.entity.core.TrailManagementCalendarIntHearing;

public interface TrlMgmtCalendarRepository extends JpaRepository<TrailManagementCalendarIntHearing, Long> {

	List<TrailManagementCalendarIntHearing> findByClaimNo(String claimNo);
	
	List<TrailManagementCalendarIntHearing> findByDivisionTypeId(Long divisionTypeId);
}