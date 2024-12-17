package gov.ga.sbwc.icms.core.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.ga.sbwc.icms.common.entity.core.Claim;
import gov.ga.sbwc.icms.common.entity.core.Claimant;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
	Claim findClaimByClaimNo(String claimNo);

	List<Claim> findClaimByClaimant(Claimant claimant);

	@Query("SELECT cm FROM Claim cm LEFT JOIN FETCH cm.claimant cl WHERE cl.firstName = :firstName "
			+ "AND cl.lastName = :lastName AND cl.dateOfBirth = :dob AND cl.dateOfBirth IS NOT NULL "
			+ "AND cm.dateOfInjury BETWEEN :startDate AND :endDate "
			+ "AND cm.recordStatus = 1 AND cl.recordStatus = 1")
	List<Claim> findMatchingClaims(@Param("firstName") String firstName, @Param("lastName") String lastName,
			@Param("dob") Date dateOfBirth, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

	@Query("SELECT cm FROM Claim cm JOIN cm.claimant cl "
			+ "WHERE ((cl.lastName = :lastName AND cl.firstName = :firstName) "
			+ "   OR (cl.lastName = :firstName AND cl.firstName = :lastName)) "
			+ "AND cm.dateOfInjury BETWEEN :startDate AND :endDate "
			+ "AND cm.recordStatus = 1 AND cl.recordStatus = 1")
	List<Claim> findMatchingClaims(@Param("firstName") String firstName, @Param("lastName") String lastName,
			@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	@Query("select cm from Claim cm join cm.claimant cl where cl.dateOfBirth = :dob and cm.dateOfInjury = :dateOfInjury and cm.recordStatus = 1 and cl.recordStatus = 1")
	List<Claim> findExactMatchClaims(@Param("dob") Date dateOfBirth, @Param("dateOfInjury") Date dateOfInjury);
}
