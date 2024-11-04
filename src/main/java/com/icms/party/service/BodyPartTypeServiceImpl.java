package com.icms.party.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icms.party.entity.BodyPartType;
import com.icms.party.repository.BodyPartTypeRepository;

@Service
public class BodyPartTypeServiceImpl {

	@Autowired
	private BodyPartTypeRepository bodyPartTypeRepository;

	public BodyPartType getBodyPartTypeById(Long id) {
		return bodyPartTypeRepository.findById(id).orElse(null);
	}

	public BodyPartType getBodyPartTypeByCode(String code) {
		return bodyPartTypeRepository.findByCode(code);
	}

	public List<BodyPartType> listAllBodyPartTypes() {
		return bodyPartTypeRepository.listAllBodyPartTypes();
	}

}
