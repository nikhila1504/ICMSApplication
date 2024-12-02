package com.icms.party.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.icms.party.entity.Claim;
import com.icms.party.entity.Document;
import com.icms.party.entity.Party;
import com.icms.party.enums.TypeOfFormEnum;

public class FormDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	protected Claim claim;
	protected Party party;
	protected Document document;

	protected Party employer;
	protected Party insurer;
	protected Party claimsOffice;
	protected Party employeeOrClaimantAttorney;
	protected Party employerOrInsurerAttorney;
	protected Party other;
	protected Party attorney;
	protected Party supplier;
	protected Party proposedSupplier;

	protected List<Party> employers;
	protected List<Party> insurers;
	protected List<Party> claimsOffices;
	protected List<Party> employeeAttorneys;
	protected List<Party> claimsOfficeAttorneys;
	protected List<MultiplePartiesDTO> multipleParties;
	protected List<MultiplePartiesDTO> multipleOthers;

	protected Party complainant;
	protected Party complainantAttorney;
	protected Party primaryRespondent;
	protected Party respondentAgent;
	protected List<Party> otherRespondents;
	protected List<Party> respondentAttorneys;
	protected NotificationDTO notificationDto;
	protected DocumentFileDTO documentFileDto;
	protected TypeOfFormEnum typeOfForm;

	public FormDTO() {
	}

	public FormDTO(Claim claim, Document document) {
		this.claim = claim;
		this.document = document;
	}

	public FormDTO(Party insurer, Document document) {
		this.insurer = insurer;
		this.document = document;
	}

	public FormDTO(Claim claim, Document document, TypeOfFormEnum typeOfForm) {
		this.claim = claim;
		this.document = document;
		this.typeOfForm = typeOfForm;
	}

	public FormDTO(Claim claim, Document document, DocumentFileDTO documentFileDto, TypeOfFormEnum typeOfForm) {
		this.claim = claim;
		this.document = document;
		this.documentFileDto = documentFileDto;
		this.typeOfForm = typeOfForm;
	}

	public FormDTO(Party party, Document document, DocumentFileDTO documentFileDto, TypeOfFormEnum typeOfForm) {
		this.party = party;
		this.document = document;
		this.documentFileDto = documentFileDto;
		this.typeOfForm = typeOfForm;
	}

	public FormDTO(Document document, DocumentFileDTO documentFileDto, TypeOfFormEnum typeOfForm) {
		this.document = document;
		this.documentFileDto = documentFileDto;
		this.typeOfForm = typeOfForm;
	}

	public FormDTO(Claim claim, Document document, Party employer, Party insurer, Party claimsOffice) {
		this.claim = claim;
		this.employer = employer;
		this.insurer = insurer;
		this.claimsOffice = claimsOffice;
		this.document = document;
	}

	public FormDTO(Claim claim, Document document, Party employer, Party insurer, Party claimsOffice,
			Party employeeOrClaimantAttorney, Party employerOrInsurerAttorney) {
		this.claim = claim;
		this.employer = employer;
		this.insurer = insurer;
		this.claimsOffice = claimsOffice;
		this.document = document;
		this.employeeOrClaimantAttorney = employeeOrClaimantAttorney;
		this.employerOrInsurerAttorney = employerOrInsurerAttorney;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getFormDTOList() {
		List list = new ArrayList();
		list.add(this);
		return list;
	}

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Party getEmployer() {
		return employer;
	}

	public void setEmployer(Party employer) {
		this.employer = employer;
	}

	public Party getInsurer() {
		return insurer;
	}

	public void setInsurer(Party insurer) {
		this.insurer = insurer;
	}

	public Party getClaimsOffice() {
		return claimsOffice;
	}

	public void setClaimsOffice(Party claimsOffice) {
		this.claimsOffice = claimsOffice;
	}

	public Party getEmployeeOrClaimantAttorney() {
		return employeeOrClaimantAttorney;
	}

	public void setEmployeeOrClaimantAttorney(Party employeeOrClaimantAttorney) {
		this.employeeOrClaimantAttorney = employeeOrClaimantAttorney;
	}

	public Party getEmployerOrInsurerAttorney() {
		return employerOrInsurerAttorney;
	}

	public void setEmployerOrInsurerAttorney(Party employerOrInsurerAttorney) {
		this.employerOrInsurerAttorney = employerOrInsurerAttorney;
	}

	public List<Party> getEmployers() {
		return employers;
	}

	public void setEmployers(List<Party> employers) {
		this.employers = employers;
	}

	public List<Party> getInsurers() {
		return insurers;
	}

	public void setInsurers(List<Party> insurers) {
		this.insurers = insurers;
	}

	public List<MultiplePartiesDTO> getMultipleParties() {
		return multipleParties;
	}

	public void setMultipleParties(List<MultiplePartiesDTO> multipleParties) {
		this.multipleParties = multipleParties;
	}

	public List<MultiplePartiesDTO> getMultipleOthers() {
		return multipleOthers;
	}

	public void setMultipleOthers(List<MultiplePartiesDTO> multipleOthers) {
		this.multipleOthers = multipleOthers;
	}

	public List<Party> getEmployeeAttorneys() {
		return employeeAttorneys;
	}

	public void setEmployeeAttorneys(List<Party> employeeAttorneys) {
		this.employeeAttorneys = employeeAttorneys;
	}

	public List<Party> getClaimsOfficeAttorneys() {
		return claimsOfficeAttorneys;
	}

	public void setClaimsOfficeAttorneys(List<Party> claimsOfficeAttorneys) {
		this.claimsOfficeAttorneys = claimsOfficeAttorneys;
	}

	public Party getOther() {
		return other;
	}

	public void setOther(Party other) {
		this.other = other;
	}

	public Party getAttorney() {
		return attorney;
	}

	public void setAttorney(Party attorney) {
		this.attorney = attorney;
	}

	public List<Party> getClaimsOffices() {
		return claimsOffices;
	}

	public void setClaimsOffices(List<Party> claimsOffices) {
		this.claimsOffices = claimsOffices;
	}

	public Party getComplainant() {
		return complainant;
	}

	public void setComplainant(Party complainant) {
		this.complainant = complainant;
	}

	public Party getComplainantAttorney() {
		return complainantAttorney;
	}

	public void setComplainantAttorney(Party complainantAttorney) {
		this.complainantAttorney = complainantAttorney;
	}

	public Party getPrimaryRespondent() {
		return primaryRespondent;
	}

	public void setPrimaryRespondent(Party primaryRespondent) {
		this.primaryRespondent = primaryRespondent;
	}

	public Party getRespondentAgent() {
		return respondentAgent;
	}

	public void setRespondentAgent(Party respondentAgent) {
		this.respondentAgent = respondentAgent;
	}

	public List<Party> getOtherRespondents() {
		return otherRespondents;
	}

	public void setOtherRespondents(List<Party> otherRespondents) {
		this.otherRespondents = otherRespondents;
	}

	public List<Party> getRespondentAttorneys() {
		return respondentAttorneys;
	}

	public void setRespondentAttorneys(List<Party> respondentAttorneys) {
		this.respondentAttorneys = respondentAttorneys;
	}

	public Party getSupplier() {
		return supplier;
	}

	public void setSupplier(Party supplier) {
		this.supplier = supplier;
	}

	public Party getProposedSupplier() {
		return proposedSupplier;
	}

	public void setProposedSupplier(Party proposedSupplier) {
		this.proposedSupplier = proposedSupplier;
	}

	public NotificationDTO getNotificationDto() {
		return notificationDto;
	}

	public void setNotificationDto(NotificationDTO notificationDto) {
		this.notificationDto = notificationDto;
	}

	public DocumentFileDTO getDocumentFileDto() {
		return documentFileDto;
	}

	public void setDocumentFileDto(DocumentFileDTO documentFileDto) {
		this.documentFileDto = documentFileDto;
	}

	public TypeOfFormEnum getTypeOfForm() {
		return typeOfForm;
	}

	public void setTypeOfForm(TypeOfFormEnum typeOfForm) {
		this.typeOfForm = typeOfForm;
	}

}
