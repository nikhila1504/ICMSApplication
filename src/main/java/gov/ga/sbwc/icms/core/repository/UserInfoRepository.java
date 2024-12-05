package gov.ga.sbwc.icms.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.ga.sbwc.icms.common.entity.core.User;

@Repository
public interface UserInfoRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
