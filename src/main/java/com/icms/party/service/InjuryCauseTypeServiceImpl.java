package com.icms.party.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icms.party.entity.InjuryCauseType;
import com.icms.party.repository.InjuryCauseTypeRepository;

@Service
public class InjuryCauseTypeServiceImpl {

	@Autowired
	private InjuryCauseTypeRepository injuryCauseTypeRepository;

	public InjuryCauseType getInjuryCauseTypeById(Long id) {
		return injuryCauseTypeRepository.findById(id).orElse(null);
	}

	public InjuryCauseType getInjuryCauseTypeByCode(String code) {
		return injuryCauseTypeRepository.findByCode(code);
	}

	public List<InjuryCauseType> listAllInjuryCauseTypes() {
		return injuryCauseTypeRepository.listAllInjuryCauseTypes();
	}

}
