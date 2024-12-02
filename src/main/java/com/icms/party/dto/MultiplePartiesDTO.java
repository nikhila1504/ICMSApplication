package com.icms.party.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import com.icms.party.entity.Party;

public class MultiplePartiesDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Party employer;
	private Party insurer;
	private Party claimsOffice;
	private Party other1;
	private Party other2;
	private Set<Party> employerAttorneys;

	@PostConstruct
	public void init() {
		employer = null;
		insurer = null;
		claimsOffice = null;
		other1 = null;
		other2 = null;
		employerAttorneys = null;
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

	public Party getOther1() {
		return other1;
	}

	public void setOther1(Party other1) {
		this.other1 = other1;
	}

	public Party getOther2() {
		return other2;
	}

	public void setOther2(Party other2) {
		this.other2 = other2;
	}

	public List<Party> getEmployerAttorneys() {
		if (employerAttorneys != null)
			return new ArrayList<Party>(employerAttorneys);
		else
			return null;
	}

	public void setEmployerAttorneys(List<Party> employerAttorneys) {
		if (this.employerAttorneys == null)
			this.employerAttorneys = new HashSet<Party>();
		this.employerAttorneys.addAll(employerAttorneys);
	}

}
