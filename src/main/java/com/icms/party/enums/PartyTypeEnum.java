package com.icms.party.enums;

public enum PartyTypeEnum {
	INSURER("INSURERC"),
	CLAIMS_OFFICE("CLAIMSOF"),
	ATTORNEY("ATTORNEY"),
	EMPLOYER("EMPLOYER"),
	GROUP_FUND("GROUPFUN"),
	GROUP_FUND_MEMBER("GROUPFUM"),
	OTHER("OTHERCDE"),
	CLAIMANT("CLAIMANT"),
	REHAB_SUPPLIER("REHABILI"),
	VENDOR("VENDORCD"),
	RESPONDENT("RSPNDAGN"),
	PRIMARY_RESPONDENT("PRIRSPND"),
	ADDITIONAL_RESPONDENT("ADDRSPND"),
	COMPLAINANT("COMPLNNT"),
	COMPLAINANT_ATTORNEY("SBWCENFO"),
	RESPONDENT_ATTORNEY("RSPNDATT"),
	RESPONDENT_AGENT("RSPNDAGN"),
	REGISTERED_AGENT("RSPNDAGN");
	/*GROUP_FUND("GROUPFUN");
	GROUP_FUND("GROUPFUN");*/
			
	private String code;	
	
	private PartyTypeEnum(String code) {
        this.code = code;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
