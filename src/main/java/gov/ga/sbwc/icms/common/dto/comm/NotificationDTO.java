/*
* Copyright (c) 2008 by State Board of Worker's Compensation. All rights reserved.
* 
* Date			Author			Description
* =====================================================================================
* 07/27/2018    SBWC            New File
*/

package gov.ga.sbwc.icms.common.dto.comm;

import java.io.Serializable;
import java.util.List;

import gov.ga.sbwc.icms.common.dto.mail.MailMessageDTO;
import gov.ga.sbwc.icms.common.entity.core.Claim;
import gov.ga.sbwc.icms.common.entity.core.Document;
import gov.ga.sbwc.icms.common.entity.core.Party;

public class NotificationDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Claim claim;
	private Document document;
	private List<Party> employers;
	private List<Party> insurers;
	private List<Party> additionalRespondent;
	private Party primaryRespondent;
	private Party respondentAgent;
	private List<Party> employerOrInsurerAttorneys;
	private String templateName;
	private Party party;
	private List<MailMessageDTO> mailMessageDtoList;
	private List<Claim> associatedClaimList;

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

	public List<Party> getAdditionalRespondent() {
		return additionalRespondent;
	}

	public void setAdditionalRespondent(List<Party> additionalRespondent) {
		this.additionalRespondent = additionalRespondent;
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

	public List<Party> getEmployerOrInsurerAttorneys() {
		return employerOrInsurerAttorneys;
	}

	public void setEmployerOrInsurerAttorneys(List<Party> employerOrInsurerAttorneys) {
		this.employerOrInsurerAttorneys = employerOrInsurerAttorneys;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/*
	 * public Set<MailDTO> getMailDtoList() { return mailDtoList; }
	 * 
	 * public void setMailDtoList(Set<MailDTO> mailDtoList) { this.mailDtoList =
	 * mailDtoList; }
	 */

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	/*
	 * public EmailMessageEnum getEmailMessage() { return emailMessage; }
	 * 
	 * public void setEmailMessage(EmailMessageEnum emailMessage) {
	 * this.emailMessage = emailMessage; }
	 */

	public List<Claim> getAssociatedClaimList() {
		return associatedClaimList;
	}

	public void setAssociatedClaimList(List<Claim> associatedClaimList) {
		this.associatedClaimList = associatedClaimList;
	}

	public List<MailMessageDTO> getMailMessageDtoList() {
		return mailMessageDtoList;
	}

	public void setMailMessageDtoList(List<MailMessageDTO> mailMessageDtoList) {
		this.mailMessageDtoList = mailMessageDtoList;
	}

}