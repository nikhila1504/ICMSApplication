package com.icms.party.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.ClaimDocument;

@Repository
public interface ClaimDocumentRepository extends CrudRepository<ClaimDocument, Long> {

}
