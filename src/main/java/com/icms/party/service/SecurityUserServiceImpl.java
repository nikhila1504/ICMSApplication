package com.icms.party.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icms.party.entity.SecurityUser;
import com.icms.party.repository.SecurityUserRepository;

@Service
public class SecurityUserServiceImpl {

	@Autowired
	private SecurityUserRepository securityUserRepository;

	public SecurityUser getSecurityUserById(Long id) {
		return securityUserRepository.findById(id).orElse(null);
	}

}
