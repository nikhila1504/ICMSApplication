package com.icms.party.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.Wc1Form;

@Repository
public interface Wc1FormRepository extends CrudRepository<Wc1Form, Long> {

}
