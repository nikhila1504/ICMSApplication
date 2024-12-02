package com.icms.party.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icms.party.constants.QueueConstants;
import com.icms.party.constants.TemplateConstants;
import com.icms.party.dto.FormDTO;
import com.icms.party.dto.MailDTO;
import com.icms.party.dto.MailMessageDTO;
import com.icms.party.dto.NotificationDTO;
import com.icms.party.entity.Claim;
import com.icms.party.entity.ClaimParty;
import com.icms.party.entity.Document;
import com.icms.party.entity.Party;
import com.icms.party.entity.SecurityUser;
import com.icms.party.entity.SourceType;
import com.icms.party.enums.ClaimTypeEnum;
import com.icms.party.enums.DocumentStatusTypeEnum;
import com.icms.party.enums.DocumentTypeEnum;
import com.icms.party.enums.EmailMessageEnum;
import com.icms.party.enums.PartyTypeEnum;
import com.icms.party.enums.RecordStatusEnum;
import com.icms.party.enums.SourceTypeEnum;
import com.icms.party.enums.TypeOfFormEnum;
import com.icms.party.repository.ClaimPartyRepository;
import com.icms.party.repository.DocumentRepository;
import com.icms.party.repository.SecurityUserRepository;
import com.icms.party.util.DataConversionUtil;

@Service
public class DocumentServiceImpl {

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private SecurityUserRepository securityUserRepository;

	@Autowired
	private DocumentQueueProducerImpl documentQueueProducerImpl;

	@Autowired
	private ClaimPartyRepository claimPartyRepository;
	
	public Document saveDocument(Document document) {
		return documentRepository.save(document);
	}

	public Document getDocumentById(Long id) {
		return documentRepository.findById(id).orElse(null);
	}

	public Document updateDocument(Document document) {
		return documentRepository.save(document);
	}

	public Document createNewDocument(Claim claim, String documentType, String sourceType, boolean isClaimCreator) {
		Document document = new Document();
		document.setRepositoryId(documentRepository.getNewRepositoryId().longValue());
		if (documentType != null) {
			document.setDocumentType(documentRepository.getDocumentTypeByCode(documentType));
		}

		document.setDocumentStatusType(
				documentRepository.getDocumentStatusTypeByCode(DocumentStatusTypeEnum.PENDING.getCode()));
		document.setRecordStatus(RecordStatusEnum.ACTIVE.getCode());
		document.setClaimCreator(isClaimCreator);

		if (sourceType == null) {
			sourceType = SourceTypeEnum.ONLINE.getCode();
		}
		SourceType sourceTypeObj = documentRepository.getSourceTypeByCode(sourceType);
		if (SourceTypeEnum.ONLINE.getCode().equals(sourceTypeObj.getCode())) {
			SecurityUser securityUser = securityUserRepository.findById(394L).orElse(null);
			if (securityUser != null) {
				Party party = securityUser.getParty();
				if (party != null) {
					document.setSubmitterBarNo(party.getBarNumber());
					document.setSubmitterName(buildSubmitterName(securityUser));
					document.setSubmitterAddress1(party.getAddress().getAddress1());
					document.setSubmitterAddress2(party.getAddress().getAddress2());
					document.setSubmitterCity(party.getAddress().getCity());
					document.setSubmitterState(party.getAddress().getState());
					if (party.getAddress().getZip() != null) {
						document.setSubmitterZip(DataConversionUtil.parseZip(party.getAddress().getZip()));
						document.setSubmitterZipExt(DataConversionUtil.parseZipExt(party.getAddress().getZip()));
					}

					document.setSubmitterEmail(party.getContact().getPrimaryEmail());
				}
			}
		}

		document.setSourceType(sourceTypeObj);
		document = saveDocument(document);
		return document;
	}

	private String buildSubmitterName(SecurityUser securityUser) {
		return securityUser.getFirstName() + " "
				+ ((StringUtils.isNotBlank(securityUser.getMiddleName()) ? securityUser.getMiddleName() + " " : ""))
				+ securityUser.getLastName();
	}

	public void createDocument(Claim claim, Document document, FormDTO formDto) {
		formDto.setDocument(this.updateDocumentStatusAndFileDate(document));

		formDto.setTypeOfForm(TypeOfFormEnum.CLAIM_FORM);
		formDto.setNotificationDto(prepareFilingNotification(claim, document));

		documentQueueProducerImpl.pushForm(formDto);
	}

	public Document updateDocumentStatusAndFileDate(Document document) {
		if (document.getDateFiled() == null) {
			if (document.getSubmitterSignatureDate() != null) {
				document.setDateFiled(document.getSubmitterSignatureDate());
			} else {
				document.setDateFiled(new Date());
			}
		}
		if (document.getDocumentType().getWorkflowName() == null
				|| (SourceTypeEnum.SCAN.getCode().equals(document.getSourceType().getCode())
						&& !document.getWorkflowRequired())) {
			document.setDocumentStatusType(
					documentRepository.getDocumentStatusTypeByCode(DocumentStatusTypeEnum.COMPLETED.getCode()));
			document.setAssignee(QueueConstants.IN_FILE);
		} else {
			document.setDocumentStatusType(
					documentRepository.getDocumentStatusTypeByCode(DocumentStatusTypeEnum.SUBMITTED.getCode()));
			document.setAssignee(QueueConstants.INITIATING_WORKFLOW);
		}
		document.setRecordStatus(RecordStatusEnum.ACTIVE.getCode());
		return updateDocument(document);
	}

	public NotificationDTO prepareFilingNotification(Claim claim, Document document) {
		NotificationDTO notificationDto = new NotificationDTO();
		notificationDto.setClaim(claim);
		notificationDto.setDocument(document);

		List<ClaimParty> claimParties = null;
		if (claim != null) {
			claimParties = claimPartyRepository.findByClaimId(claim.getId());
			if (ClaimTypeEnum.INJURY_CLAIM.getCode().equals(claim.getClaimType().getCode())) {
//				List<Claim> assoicatedClaims = claimService.findAssociatedClaims(document);
//				if (assoicatedClaims != null && assoicatedClaims.isEmpty()) {
//					for (Claim assocClaim : assoicatedClaims) {
//						claimParties.addAll(claimPartyRepository.findByClaimId(assocClaim.getId()));
//						claim = claimService.addAssociatedClaimNoAndInjuryDate(claim, assocClaim);
//					}
//				}
			}
		}
		if (claimParties != null && claimParties.isEmpty()) {
			List<Party> employers = new ArrayList<Party>();
			List<Party> insurers = new ArrayList<Party>();
			Party primaryRespondent = null;
			Party respondentAgent = null;
			List<Party> additionalRespondent = new ArrayList<Party>();
			for (ClaimParty cm : claimParties) {
				if (cm != null && cm.getParty() != null && cm.getParty().getPartyType() != null) {
					if (PartyTypeEnum.EMPLOYER.getCode().equals(cm.getParty().getPartyType().getCode())) {
						employers.add(cm.getParty());
					}

					if (PartyTypeEnum.INSURER.getCode().equals(cm.getParty().getPartyType().getCode())) {
						insurers.add(cm.getParty());
					}

					if (PartyTypeEnum.ADDITIONAL_RESPONDENT.getCode().equals(cm.getParty().getPartyType().getCode())) {
						additionalRespondent.add(cm.getParty());
					}

					if (PartyTypeEnum.PRIMARY_RESPONDENT.getCode().equals(cm.getParty().getPartyType().getCode())) {
						primaryRespondent = cm.getParty();
					}

					if (PartyTypeEnum.RESPONDENT_AGENT.getCode().equals(cm.getParty().getPartyType().getCode())) {
						respondentAgent = cm.getParty();
					}
				}
			}
			notificationDto.setEmployers(employers);
			notificationDto.setInsurers(insurers);
			notificationDto.setAdditionalRespondent(additionalRespondent);
			notificationDto.setPrimaryRespondent(primaryRespondent);
			notificationDto.setRespondentAgent(respondentAgent);
		}

		String templateName = TemplateConstants.DOCUMENT_FILING_NOTIFICATION;
		if (claim.getClaimType().getCode().equals(ClaimTypeEnum.INJURY_CLAIM.getCode())) {
			if (document.getClaimCreator() && !document.getResearch()) {
				templateName = TemplateConstants.CLAIM_CREATION_NOTIFICATION;
			}
		} else if (claim.getClaimType().getCode().equals(ClaimTypeEnum.ENFORCEMENT_CASE.getCode())) {
			if (document.getClaimCreator()) {
				templateName = TemplateConstants.CASE_CREATION_NOTIFICATON;
			} else {
				templateName = TemplateConstants.CASE_FILING_NOTIFICATON;
			}
		}

		notificationDto.setTemplateName(templateName);
		List<MailMessageDTO> mailMessageDtoList = new ArrayList<>();

		Set<MailDTO> mailDtoList = prepareNotificationMailDtoList(claim, document, claimParties);
		if (mailDtoList != null && mailDtoList.isEmpty()) {
			mailMessageDtoList.add(new MailMessageDTO(mailDtoList, EmailMessageEnum.DOCUMENT_FILING));
		}

		notificationDto.setMailMessageDtoList(mailMessageDtoList);
		return notificationDto;
	}

	public Set<MailDTO> prepareNotificationMailDtoList(Claim claim, Document document, List<ClaimParty> claimParties) {
		boolean includeSubmitter = false;
		if (DocumentTypeEnum.WC_1_EMPLOYERS_FIRST_REPORT_OF_INJURY.getCode()
				.equals(document.getDocumentType().getCode()) && document.getClaimCreator()
				&& (document.getSourceType() != null
						&& !SourceTypeEnum.SCAN.getCode().equals(document.getSourceType().getCode()))) {
			includeSubmitter = true;
		} else {
			// change the code
			if (document.getResearch()) {
				includeSubmitter = true;
			}
		}

		Set<MailDTO> emailDtoList = new HashSet<MailDTO>();
		if (!document.getResearch()) {
			List<Party> parties = new ArrayList<Party>();

			if (claimParties != null && claimParties.isEmpty()) {
				for (ClaimParty cm : claimParties) {
					if (cm != null && cm.getParty() != null && cm.getParty().getPartyType() != null) {
						if (!(PartyTypeEnum.CLAIMANT.getCode().equals(cm.getParty().getPartyType().getCode())
								|| PartyTypeEnum.EMPLOYER.getCode().equals(cm.getParty().getPartyType().getCode())
								|| PartyTypeEnum.REHAB_SUPPLIER.getCode()
										.equals(cm.getParty().getPartyType().getCode()))) {
							parties.add(cm.getParty());
						} else if (PartyTypeEnum.EMPLOYER.getCode().equals(cm.getParty().getPartyType().getCode())
								&& cm.getParty().getSelfInsured()) {
							parties.add(cm.getParty());
						}
					}
				}
			}

			if (parties != null && parties.isEmpty()) {
				for (Party party : parties) {
					if (party != null) {
						emailDtoList.add(new MailDTO(party, false));
					}
				}
			}

		}

		// added to include submitter email in send notification
		if (includeSubmitter && StringUtils.isNotBlank(document.getSubmitterEmail())) {
			emailDtoList.add(new MailDTO(document.getSubmitterEmail(), false));
		}

		return emailDtoList;
	}
}
