package gov.ga.sbwc.icms.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ga.sbwc.icms.common.entity.core.Claim;
import gov.ga.sbwc.icms.common.entity.core.ClaimDocument;
import gov.ga.sbwc.icms.common.entity.core.Document;
import gov.ga.sbwc.icms.core.repository.ClaimDocumentRepository;

@Service
public class ClaimDocumentServiceImpl {

	@Autowired
	private ClaimDocumentRepository claimDocumentRepository;

	public ClaimDocument getClaimDocumentById(Long id) {
		return claimDocumentRepository.findById(id).orElse(null);
	}

	public ClaimDocument createCaimDocument(Claim claim, Document document) {
		ClaimDocument claimDocument = new ClaimDocument();
		claimDocument.setClaim(claim);
		claimDocument.setDocument(document);
		return claimDocumentRepository.save(claimDocument);
	}
}
