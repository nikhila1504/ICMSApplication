package com.icms.party.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icms.party.entity.DisabilityType;
import com.icms.party.repository.DisabilityTypeRepository;

@Service
public class DisabilityTypeServiceImpl {

	@Autowired
	private DisabilityTypeRepository disabilityTypeRepository;

	public DisabilityType getDisabilityTypeById(Long id) {
		return disabilityTypeRepository.findById(id).orElse(null);
	}

	public DisabilityType getDisabilityTypeByCode(String code) {
		return disabilityTypeRepository.findByCode(code);
	}

	public List<DisabilityType> listAllDisabilityTypes() {
		return disabilityTypeRepository.listAllDisabilityTypes();
	}

}
