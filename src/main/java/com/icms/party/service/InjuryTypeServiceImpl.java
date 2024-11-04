package com.icms.party.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icms.party.entity.InjuryType;
import com.icms.party.repository.InjuryTypeRepository;

@Service
public class InjuryTypeServiceImpl {

	@Autowired
	private InjuryTypeRepository injuryTypeRepository;

	public InjuryType getInjuryTypeById(Long id) {
		return injuryTypeRepository.findById(id).orElse(null);
	}

	public InjuryType getInjuryTypeByCode(String code) {
		return injuryTypeRepository.findByCode(code);
	}

	public List<InjuryType> listAllInjuryTypes() {
		return injuryTypeRepository.listAllInjuryTypes();
	}

}
