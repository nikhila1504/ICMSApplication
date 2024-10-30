package com.icms.party.enums;

public enum RecordStatusEnum {

	
	ACTIVE (1),
	INACTIVE (2),
	DRAFT (3),
	DELETED (4),
	SUCCESS (5),
	FAIL (6),
	PARTIAL_SENT (7),
	DUPLICATE (8),
	PENDING_APPROVAL_TO_DESTROY(10),
	APPROVED_TO_DESTROY(11),
	DESTROYED(12),
	PROCESSED(13),
	COMPLETED(14),
	PENDING(15),
	PROCESSING(16),
	SUSPENDED(17),
	DIRECT_ROUTE(18);	
	
	private int code;
	
	RecordStatusEnum(int code) {
        this.code = code;
    }
    
    public int getCode() {
        return code;
    } 
	
}
