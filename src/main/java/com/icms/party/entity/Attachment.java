package com.icms.party.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.icms.party.constants.FileExtensionConstants;
import com.icms.party.constants.MimeTypeConstants;

/**
 * The persistent class for the DOCUMENT_ATTACHMENT database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "ATTACHMENT")
@NamedQuery(name = "Attachment.findByDocument", query = "select da from Attachment da where da.document = :document and da.recordStatus = 1")
public class Attachment extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ATTACHMENT_ID_GENERATOR", sequenceName = "ATTACHMENT_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ATTACHMENT_ID_GENERATOR")
	@Column(name = "ATTACHMENT_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "DOCUMENT_ID")
	private Document document;

	@Column(name = "NAME")
	private String name;

	@Column(name = "REPOSITORY_DOC_ID")
	private Long repositoryId;

	@Transient
	private byte[] bytes;

	@Transient
	private String mimeType;

	@Transient
	private String extension;

	@Transient
	private long size = 0;

	public Attachment() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRepositoryId() {
		return repositoryId;
	}

	public void setRepositoryId(Long repositoryId) {
		this.repositoryId = repositoryId;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
		if (MimeTypeConstants.PDF_MIME_TYPE.equals(mimeType) || MimeTypeConstants.PDF2_MIME_TYPE.equals(mimeType)) {
			this.extension = FileExtensionConstants.PDF;
		} else if (MimeTypeConstants.DOCX_MIME_TYPE.equals(mimeType)) {
			this.extension = FileExtensionConstants.DOCX;
		} else if (MimeTypeConstants.DOC_MIME_TYPE.equals(mimeType)) {
			this.extension = FileExtensionConstants.DOC;
		}
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Attachment))
			return false;
		Attachment other = (Attachment) obj;
		if (getId() == null) {
			return false;
		}
		return getId().equals(other.getId());
	}

	@Override
	public int hashCode() {
		if (getId() != null) {
			return getId().hashCode();
		} else {
			return super.hashCode();
		}
	}

}