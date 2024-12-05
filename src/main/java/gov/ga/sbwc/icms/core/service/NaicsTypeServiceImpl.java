package gov.ga.sbwc.icms.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ga.sbwc.icms.common.entity.core.NaicsType;
import gov.ga.sbwc.icms.core.repository.NaicsTypeRepository;

@Service
public class NaicsTypeServiceImpl {

	@Autowired
	private NaicsTypeRepository naicsTypeRepository;

	public NaicsType getNaicsTypeById(Long id) {
		return naicsTypeRepository.findById(id).orElse(null);
	}

	public NaicsType getNaicsTypeByCode(String code) {
		return naicsTypeRepository.findByCode(code);
	}

	public List<NaicsType> listAllNaicsTypes() {
		return naicsTypeRepository.listAllNaicsTypes();
	}

}
