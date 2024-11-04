package com.icms.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.InjuryCauseType;

@Repository
public interface InjuryCauseTypeRepository extends CrudRepository<InjuryCauseType, Long> {
	
	@Query("SELECT t FROM InjuryCauseType t where recordStatus=1 order by t.description")
	List<InjuryCauseType> listAllInjuryCauseTypes();

	InjuryCauseType findByCode(String code);
}
