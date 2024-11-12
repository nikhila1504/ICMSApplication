package com.icms.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.StateType;

@Repository
public interface StateTypeRepository extends CrudRepository<StateType, Long> {
	@Query("SELECT t FROM StateType t where recordStatus=1 order by t.description")
	List<StateType> listAllStateTypes();

	StateType findByCode(String code);
}
