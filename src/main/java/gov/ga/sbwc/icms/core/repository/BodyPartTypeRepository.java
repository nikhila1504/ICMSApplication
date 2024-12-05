package gov.ga.sbwc.icms.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.ga.sbwc.icms.common.entity.core.BodyPartType;

@Repository
public interface BodyPartTypeRepository extends CrudRepository<BodyPartType, Long> {
	@Query("SELECT t FROM BodyPartType t where t.recordStatus=1 and t.georgiaPI = false order by t.description")
	List<BodyPartType> listAllBodyPartTypes();

	BodyPartType findByCode(String code);
}
