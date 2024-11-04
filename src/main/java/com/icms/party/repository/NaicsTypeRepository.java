package com.icms.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.NaicsType;

@Repository
public interface NaicsTypeRepository extends CrudRepository<NaicsType, Long> {
	@Query("SELECT t FROM NaicsType t where recordStatus=1 order by t.description")
	List<NaicsType> listAllNaicsTypes();

	NaicsType findByCode(String code);
}
