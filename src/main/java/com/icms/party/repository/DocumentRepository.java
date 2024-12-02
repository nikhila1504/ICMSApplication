package com.icms.party.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.Document;
import com.icms.party.entity.DocumentStatusType;
import com.icms.party.entity.DocumentType;
import com.icms.party.entity.SourceType;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Long> {
	@Query(value = "SELECT DOCUMENT_REPOSITORY_DOC_ID_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	public Long getNewRepositoryId();

	@Query("select dt from DocumentType dt where dt.code = :code")
	public DocumentType getDocumentTypeByCode(String code);

	@Query("select dt from DocumentStatusType dt where dt.code = :code")
	public DocumentStatusType getDocumentStatusTypeByCode(String code);

	@Query("select dt from SourceType dt where dt.code = :code")
	public SourceType getSourceTypeByCode(String code);
}
