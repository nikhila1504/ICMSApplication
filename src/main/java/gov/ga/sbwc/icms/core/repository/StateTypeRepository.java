package gov.ga.sbwc.icms.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.ga.sbwc.icms.common.entity.core.StateType;

@Repository
public interface StateTypeRepository extends CrudRepository<StateType, Long> {
	@Query("SELECT t FROM StateType t where recordStatus=1 order by t.description")
	List<StateType> listAllStateTypes();

	StateType findByCode(String code);
}
