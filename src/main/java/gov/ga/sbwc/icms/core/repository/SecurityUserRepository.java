package gov.ga.sbwc.icms.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.ga.sbwc.icms.common.entity.core.SecurityUser;

@Repository
public interface SecurityUserRepository extends JpaRepository<SecurityUser, Long> {

}
