package com.icms.party.enums;

public enum RadioButtonEnum {

	Y("Y"),
	N("N"),
	NA("NA"),
	HOME("H"),
	WORK("W");
    
	private String code;	    
	    
	private RadioButtonEnum(String code) {
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
