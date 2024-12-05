package gov.ga.sbwc.icms.common.dto.doc;

import java.io.Serializable;
import java.util.Map;

import gov.ga.sbwc.icms.common.constants.FileExtensionConstants;
import gov.ga.sbwc.icms.common.constants.MimeTypeConstants;

public class DocumentFileDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String mimeType;
	private long size;
	private byte[] bytes;
	private String extension;
	private Map<String, Object> properties;
	private String folderName;
	private boolean notification = true;

	public DocumentFileDTO() {
	}

	public DocumentFileDTO(String name, String mimeType, long size, byte[] bytes) {
		super();
		this.name = name;
		this.mimeType = mimeType;
		this.size = size;
		this.bytes = bytes;
		if (MimeTypeConstants.PDF_MIME_TYPE.equals(mimeType) || MimeTypeConstants.PDF2_MIME_TYPE.equals(mimeType)) {
			this.extension = FileExtensionConstants.PDF;
		} else if (MimeTypeConstants.DOCX_MIME_TYPE.equals(mimeType)) {
			this.extension = FileExtensionConstants.DOCX;
		} else if (MimeTypeConstants.DOC_MIME_TYPE.equals(mimeType)) {
			this.extension = FileExtensionConstants.DOC;
		}
	}

	public DocumentFileDTO(String name, String mimeType, long size, byte[] bytes, boolean notification) {
		super();
		this.name = name;
		this.mimeType = mimeType;
		this.size = size;
		this.bytes = bytes;
		if (MimeTypeConstants.PDF_MIME_TYPE.equals(mimeType) || MimeTypeConstants.PDF2_MIME_TYPE.equals(mimeType)) {
			this.extension = FileExtensionConstants.PDF;
		} else if (MimeTypeConstants.DOCX_MIME_TYPE.equals(mimeType)) {
			this.extension = FileExtensionConstants.DOCX;
		} else if (MimeTypeConstants.DOC_MIME_TYPE.equals(mimeType)) {
			this.extension = FileExtensionConstants.DOC;
		}
		this.notification = notification;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public boolean isNotification() {
		return notification;
	}

	public void setNotification(boolean notification) {
		this.notification = notification;
	}

}
