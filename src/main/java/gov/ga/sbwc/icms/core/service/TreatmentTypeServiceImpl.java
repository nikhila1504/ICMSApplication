package gov.ga.sbwc.icms.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ga.sbwc.icms.common.entity.core.TreatmentType;
import gov.ga.sbwc.icms.core.repository.TreatmentTypeRepository;

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
