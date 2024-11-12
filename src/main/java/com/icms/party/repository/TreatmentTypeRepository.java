package com.icms.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.TreatmentType;

@Repository
public interface TreatmentTypeRepository extends CrudRepository<TreatmentType, Long> {
	@Query("SELECT t FROM TreatmentType t where recordStatus=1 order by t.description")
	List<TreatmentType> listAllTreatmentTypes();

	TreatmentType findByCode(String code);
}
