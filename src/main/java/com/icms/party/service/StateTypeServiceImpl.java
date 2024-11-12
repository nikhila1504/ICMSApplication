package com.icms.party.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icms.party.entity.StateType;
import com.icms.party.repository.StateTypeRepository;

@Service
public class StateTypeServiceImpl {

	@Autowired
	private StateTypeRepository stateTypeRepository;

	public StateType getStateTypeById(Long id) {
		return stateTypeRepository.findById(id).orElse(null);
	}

	public StateType getStateTypeByCode(String code) {
		return stateTypeRepository.findByCode(code);
	}

	public List<StateType> listAllStateTypes() {
		return stateTypeRepository.listAllStateTypes();
	}

}
