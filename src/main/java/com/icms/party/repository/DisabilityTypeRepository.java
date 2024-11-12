package com.icms.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.DisabilityType;

@Repository
public interface DisabilityTypeRepository extends CrudRepository<DisabilityType, Long> {
	@Query("SELECT t FROM DisabilityType t where recordStatus=1 order by t.description")
	List<DisabilityType> listAllDisabilityTypes();

	DisabilityType findByCode(String code);
}
