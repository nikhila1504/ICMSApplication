package gov.ga.sbwc.icms.common.dto.mail;

import java.io.Serializable;
import java.util.Set;

import gov.ga.sbwc.icms.common.enums.EmailMessageEnum;

public class MailMessageDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Set<MailDTO> mailDtoList;
	private EmailMessageEnum emailMessage;

	public MailMessageDTO(EmailMessageEnum emailMessage) {
		super();
		this.emailMessage = emailMessage;
	}

	public MailMessageDTO(Set<MailDTO> mailDtoList, EmailMessageEnum emailMessage) {
		super();
		this.mailDtoList = mailDtoList;
		this.emailMessage = emailMessage;
	}

	public Set<MailDTO> getMailDtoList() {
		return mailDtoList;
	}

	public EmailMessageEnum getEmailMessage() {
		return emailMessage;
	}

	public void setMailDtoList(Set<MailDTO> mailDtoList) {
		this.mailDtoList = mailDtoList;
	}

	public void setEmailMessage(EmailMessageEnum emailMessage) {
		this.emailMessage = emailMessage;
	}

}
