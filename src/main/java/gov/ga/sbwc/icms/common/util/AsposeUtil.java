package gov.ga.sbwc.icms.common.util;

import gov.ga.sbwc.icms.common.dto.form.FormDTO;
import gov.ga.sbwc.icms.common.entity.core.Document;

public class AsposeUtil {

	public static boolean isDisplayInsurerAddressOnClaimsoffice(Document document) {
		if (document == null) {
			return true;
		}

		return true;
	}

	public static boolean isDisplayInsurerAddressOnClaimsoffice(FormDTO formDto) {
		if (formDto == null)
			return true;

		return isDisplayInsurerAddressOnClaimsoffice(formDto.getDocument());
	}
}
