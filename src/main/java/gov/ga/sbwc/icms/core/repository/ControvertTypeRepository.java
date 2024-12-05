package gov.ga.sbwc.icms.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.ga.sbwc.icms.common.entity.core.ControvertType;

@Repository
public interface ControvertTypeRepository extends CrudRepository<ControvertType, Long> {
	@Query("SELECT t FROM ControvertType t where recordStatus=1 order by t.description")
	List<ControvertType> listAllControvertTypes();

	ControvertType findByCode(String code);
}
