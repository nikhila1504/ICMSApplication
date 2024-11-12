package com.icms.party.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icms.party.entity.TreatmentType;
import com.icms.party.repository.TreatmentTypeRepository;

@Service
public class TreatmentTypeServiceImpl {

	@Autowired
	private TreatmentTypeRepository treatmentTypeRepository;

	public TreatmentType getTreatmentTypeById(Long id) {
		return treatmentTypeRepository.findById(id).orElse(null);
	}

	public TreatmentType getTreatmentTypeByCode(String code) {
		return treatmentTypeRepository.findByCode(code);
	}

	public List<TreatmentType> listAllTreatmentTypes() {
		return treatmentTypeRepository.listAllTreatmentTypes();
	}

}
