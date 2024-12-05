package gov.ga.sbwc.icms.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.ga.sbwc.icms.common.entity.core.ConfigType;

@Repository
public interface ConfigTypeRepository extends CrudRepository<ConfigType, Long> {
	@Query("select cfg from ConfigType cfg order by cfg.key asc")
	List<ConfigType> listAllConfigTypes();

	ConfigType findByKey(String key);
}
