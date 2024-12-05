package gov.ga.sbwc.icms.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ga.sbwc.icms.common.entity.core.Role;
import gov.ga.sbwc.icms.core.repository.RoleRepository;

@Service(value = "roleService")
public class RoleServiceImpl {
	
	@Autowired
	private RoleRepository roleRepo;

	public Role findByName(String name) {
		Role role = roleRepo.findRoleByName(name);
		return role;
	}
}
