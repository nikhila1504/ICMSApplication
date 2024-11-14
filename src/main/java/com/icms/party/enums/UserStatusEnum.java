package com.icms.party.enums;

public enum UserStatusEnum {

	PENDING("PENDIN"),
	ACTIVE("ACTIVE"),
	REJECTED("REJECT"),
	SUSPENDED("SUSPEN"),
	LOCKED("LOCKED"),
	INACTIVE("INACTI"),
	PROCESSING("PROCES"),;
    
	private String code;	    
	    
	UserStatusEnum(String code) {
        this.code = code;
    }
    
    public String getCode() {
        return code;
    }
    
    @Override
    public String toString() {
        return this.code;
    }
    
}
