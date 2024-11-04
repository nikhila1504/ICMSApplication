package com.icms.party.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.InjuryType;

@Repository
public interface InjuryTypeRepository extends CrudRepository<InjuryType, Long> {

	
	InjuryType findByCode(String code);
}
