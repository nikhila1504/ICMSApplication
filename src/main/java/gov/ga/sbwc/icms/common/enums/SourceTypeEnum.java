package gov.ga.sbwc.icms.common.enums;

public enum SourceTypeEnum {

	SCAN("SCANCDEC"),
	FAX("FAXCDECD"),
	MIGRATED("MIGRATED"),
	INTERNAL("INTERNAL"),
	ONLINE("ONLINESU"),
	EDI("EDICDECD");
    
	private String code;	    
	    
	SourceTypeEnum(String code) {
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
