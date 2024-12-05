package gov.ga.sbwc.icms.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ga.sbwc.icms.common.entity.core.StateType;
import gov.ga.sbwc.icms.core.repository.StateTypeRepository;

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
