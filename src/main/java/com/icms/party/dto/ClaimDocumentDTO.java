package com.icms.party.dto;

import java.io.Serializable;

import com.icms.party.entity.Claim;
import com.icms.party.entity.Document;

public class ClaimDocumentDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Claim claim;
	private Document document;

	public ClaimDocumentDTO() {
	}

	public ClaimDocumentDTO(Claim claim, Document document) {
		this.claim = claim;
		this.document = document;
	}

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

}
