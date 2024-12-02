package com.icms.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.ConfigType;

@Repository
public interface ConfigTypeRepository extends CrudRepository<ConfigType, Long> {
	@Query("select cfg from ConfigType cfg order by cfg.key asc")
	List<ConfigType> listAllConfigTypes();

	ConfigType findByKey(String key);
}
