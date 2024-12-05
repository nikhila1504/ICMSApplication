package gov.ga.sbwc.icms.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ga.sbwc.icms.common.entity.core.ControvertType;
import gov.ga.sbwc.icms.core.repository.ControvertTypeRepository;

@Service
public class ControvertTypeServiceImpl {

	@Autowired
	private ControvertTypeRepository controvertTypeRepository;

	public ControvertType getControvertTypeById(Long id) {
		return controvertTypeRepository.findById(id).orElse(null);
	}

	public ControvertType getControvertTypeByCode(String code) {
		return controvertTypeRepository.findByCode(code);
	}

	public List<ControvertType> listAllControvertTypes() {
		return controvertTypeRepository.listAllControvertTypes();
	}

}
