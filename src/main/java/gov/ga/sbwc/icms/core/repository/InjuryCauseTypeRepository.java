package gov.ga.sbwc.icms.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.ga.sbwc.icms.common.entity.core.InjuryCauseType;

@Repository
public interface InjuryCauseTypeRepository extends CrudRepository<InjuryCauseType, Long> {
	
	@Query("SELECT t FROM InjuryCauseType t where recordStatus=1 order by t.description")
	List<InjuryCauseType> listAllInjuryCauseTypes();

	InjuryCauseType findByCode(String code);
}
