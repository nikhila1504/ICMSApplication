package gov.ga.sbwc.icms.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ga.sbwc.icms.common.entity.core.InjuryType;
import gov.ga.sbwc.icms.core.repository.InjuryTypeRepository;

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
