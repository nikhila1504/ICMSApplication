package com.icms.party.enums;

public enum ClaimTypeEnum {

	INJURY_CLAIM("INJURYKG"),
	ENFORCEMENT_CASE("WC24RERT");
    
	private String code;	    
	    
	private ClaimTypeEnum(String code) {
        this.code = code;
    }
    
    public String getCode() {
        return code;
    }
    
    @Override
    public String toString() {
        return String.valueOf(code);
    }
}
