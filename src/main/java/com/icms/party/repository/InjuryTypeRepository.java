package com.icms.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.InjuryType;

@Repository
public interface InjuryTypeRepository extends CrudRepository<InjuryType, Long> {
	@Query("SELECT t FROM InjuryType t where recordStatus=1 order by t.description")
	List<InjuryType> listAllInjuryTypes();
	
	InjuryType findByCode(String code);
}
