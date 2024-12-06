package gov.ga.sbwc.icms.core.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Service;

import com.aspose.words.MailMergeCleanupOptions;
import com.aspose.words.SaveFormat;

import gov.ga.sbwc.icms.aspose.ds.FormStaticFieldsDataSource;
import gov.ga.sbwc.icms.common.constants.FileExtensionConstants;
import gov.ga.sbwc.icms.common.constants.MimeTypeConstants;
import gov.ga.sbwc.icms.common.dto.doc.DocumentFileDTO;
import gov.ga.sbwc.icms.common.dto.form.FormDTO;
import gov.ga.sbwc.icms.common.entity.core.Claim;
import gov.ga.sbwc.icms.common.entity.core.Document;
import gov.ga.sbwc.icms.common.entity.core.DocumentType;
import gov.ga.sbwc.icms.common.enums.DocumentTypeEnum;

@Service
public class AsposeServiceImpl {

	public DocumentFileDTO createForm(Claim claim, Document document, FormDTO formDto) throws Exception {
		long startTime;
		long endTime;
		ByteArrayOutputStream outStream = null;
		// try {
		DocumentType documentType = formDto.getDocument().getDocumentType();

		startTime = System.currentTimeMillis();
		// Load the document.
		com.aspose.words.Document asposeDoc = new com.aspose.words.Document("C:\\WC-1.doc");

		FormStaticFieldsDataSource staticFields = new FormStaticFieldsDataSource(formDto);
		asposeDoc.getMailMerge().execute(staticFields.getClaimFieldNames(), staticFields.getClaimFieldValues());
		asposeDoc.getMailMerge().execute(staticFields.getSubmitterFieldNames(), staticFields.getSubmitterFieldValues());

		if (DocumentTypeEnum.WC_1_EMPLOYERS_FIRST_REPORT_OF_INJURY.getCode().equals(documentType.getCode())) {
			asposeDoc.getMailMerge().execute(staticFields.getPartyFieldNames(), staticFields.getPartyFieldValues());
			asposeDoc.getMailMerge().setCleanupOptions(MailMergeCleanupOptions.REMOVE_UNUSED_REGIONS
					| MailMergeCleanupOptions.REMOVE_CONTAINING_FIELDS | MailMergeCleanupOptions.REMOVE_UNUSED_FIELDS
					| MailMergeCleanupOptions.REMOVE_EMPTY_PARAGRAPHS);
			asposeDoc.getMailMerge().execute(staticFields.getWC1FormFieldNames(), staticFields.getWC1FormFieldValues());
		}

		// Create a new memory stream.
		outStream = new ByteArrayOutputStream();

		// Save the document to stream.
		asposeDoc.save(outStream,com.aspose.words.SaveFormat.PDF);
//		asposeDoc.save("C:\\Users\\gonea\\Documents\\Wc1.pdf");
		byte[] bytes = outStream.toByteArray();
//		OutputStream out = new FileOutputStream(new File("c:\\Wc1.pdf"));
//		int read = 0;
//		while ((read = bytes) != -1) {
//			out.write(bytes, 0, read);
//		}
		outStream.close();
		endTime = System.currentTimeMillis();
//		log.debug("Create Document time in seconds: " + ((endTime - startTime) / 1000));

		return new DocumentFileDTO(String.valueOf(formDto.getDocument().getRepositoryId()),
				MimeTypeConstants.PDF_MIME_TYPE, bytes.length, bytes);
	}

	public DocumentFileDTO convertDocumentToPdf(DocumentFileDTO documentFileDto) {
		ByteArrayOutputStream outStream = null;
		try {

			// Load the document.
			com.aspose.words.Document asposeDoc = new com.aspose.words.Document(
					new ByteArrayInputStream(documentFileDto.getBytes()));

			outStream = new ByteArrayOutputStream();
			// Save the document to stream.
			asposeDoc.save(outStream, SaveFormat.PDF);

			documentFileDto.setMimeType(MimeTypeConstants.PDF_MIME_TYPE);
			documentFileDto.setBytes(outStream.toByteArray());
			documentFileDto.setSize(outStream.toByteArray().length);
			documentFileDto.setExtension(FileExtensionConstants.PDF);

			return documentFileDto;
		} catch (Exception e) {
		} finally {
			try {
				if (outStream != null) {
					outStream.close();
				}
			} catch (IOException e) {
			}
		}

		return null;
	}

//	private static void storeSingleFile(byte[] bytes) throws IOException {
//		OutputStream out = null;
//		try {
//			out = new FileOutputStream(new File("c:\\Wc1.pdf"));
//			int read = 0;
//			final byte[] bytes = new byte[1024];
//
//			while ((read = filecontent.read(bytes)) != -1) {
//				out.write(bytes, 0, read);
//			}
//		} catch (FileNotFoundException fne) {
//
//		} catch (IOException e) {
//		} finally {
//			if (out != null) {
//				out.close();
//			}
//		}
//	}
}
