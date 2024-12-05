package gov.ga.sbwc.icms.core.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.ga.sbwc.icms.common.entity.core.Document;
import gov.ga.sbwc.icms.common.entity.core.DocumentStatusType;
import gov.ga.sbwc.icms.common.entity.core.DocumentType;
import gov.ga.sbwc.icms.common.entity.core.SourceType;

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
