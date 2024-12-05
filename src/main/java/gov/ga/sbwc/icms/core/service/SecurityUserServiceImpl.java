package gov.ga.sbwc.icms.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ga.sbwc.icms.common.entity.core.SecurityUser;
import gov.ga.sbwc.icms.core.repository.SecurityUserRepository;

@Service
public class SecurityUserServiceImpl {

	@Autowired
	private SecurityUserRepository securityUserRepository;

	public SecurityUser getSecurityUserById(Long id) {
		return securityUserRepository.findById(id).orElse(null);
	}

}
