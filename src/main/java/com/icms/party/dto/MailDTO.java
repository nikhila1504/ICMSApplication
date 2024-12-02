package com.icms.party.dto;

import java.io.Serializable;

import com.icms.party.entity.Claimant;
import com.icms.party.entity.Party;

public class MailDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String recipient;
	private boolean usmail = false;
	private Party party;
	private Claimant claimant;

	public MailDTO(String recipient, boolean usmail) {
		super();
		this.recipient = recipient;
		this.usmail = usmail;
	}

	public MailDTO(Party party, boolean usmail) {
		super();
		this.usmail = usmail;
		this.party = party;
	}

	public MailDTO(Claimant claimant, boolean usmail) {
		super();
		this.usmail = usmail;
		this.claimant = claimant;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public Claimant getClaimant() {
		return claimant;
	}

	public void setClaimant(Claimant claimant) {
		this.claimant = claimant;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public boolean isUsmail() {
		return usmail;
	}

	public void setUsmail(boolean usmail) {
		this.usmail = usmail;
	}
}
