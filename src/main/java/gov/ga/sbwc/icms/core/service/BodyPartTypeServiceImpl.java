package gov.ga.sbwc.icms.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ga.sbwc.icms.common.entity.core.BodyPartType;
import gov.ga.sbwc.icms.core.repository.BodyPartTypeRepository;

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
