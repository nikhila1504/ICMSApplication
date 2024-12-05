package gov.ga.sbwc.icms.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.ga.sbwc.icms.common.entity.core.Role;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findRoleByName(String name);
}