package gov.ga.sbwc.icms.common.entity.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The persistent class for the CLAIM_DOCUMENT database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "CLAIM_DOCUMENT")
public class ClaimDocument extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CLAIM_DOCUMENT_ID_GENERATOR", sequenceName = "CLAIM_DOCUMENT_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLAIM_DOCUMENT_ID_GENERATOR")
	@Column(name = "CLAIM_DOCUMENT_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DOCUMENT_ID")
	private Document document;

	// bi-directional many-to-one association to ClaimDetail
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CLAIM_ID")
	private Claim claim;

	@Column(name = "IS_CLAIM_ASSOCIATED")
	private Boolean claimAssociated = false;

	@Transient
	private boolean select;

	public ClaimDocument() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	public Boolean getClaimAssociated() {
		return claimAssociated;
	}

	public void setClaimAssociated(Boolean claimAssociated) {
		this.claimAssociated = claimAssociated;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}
}