package gov.ga.sbwc.icms.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.ga.sbwc.icms.common.entity.core.InjuryType;

@Repository
public interface InjuryTypeRepository extends CrudRepository<InjuryType, Long> {
	@Query("SELECT t FROM InjuryType t where recordStatus=1 order by t.description")
	List<InjuryType> listAllInjuryTypes();
	
	InjuryType findByCode(String code);
}
