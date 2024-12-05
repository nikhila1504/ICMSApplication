package gov.ga.sbwc.icms.common.dto.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import gov.ga.sbwc.icms.common.entity.core.BodyPartType;
import gov.ga.sbwc.icms.common.entity.core.Claim;
import gov.ga.sbwc.icms.common.entity.core.Document;
import gov.ga.sbwc.icms.common.entity.core.Party;
import gov.ga.sbwc.icms.common.entity.core.Wc1Form;

public class Wc1FormDTO extends FormDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Wc1Form wc1Form;
	private List<BodyPartType> bodyPartTypes;
	private String bodyPartType;

	public Wc1FormDTO(Claim claim, Document document, Wc1Form wc1Form, Party employer, Party insurer, Party claimsOffice,
			List<BodyPartType> bodyPartTypes) {
		super(claim, document, employer, insurer, claimsOffice);
		this.wc1Form = wc1Form;
		this.bodyPartTypes = bodyPartTypes;
		if (bodyPartTypes != null) {
			this.bodyPartType = this.convertToDelimitedString(bodyPartTypes);
		}
	}

	public Wc1FormDTO(Claim claim, Document document, Wc1Form wc1Form, Party employer, Party insurer, Party claimsOffice) {
		super(claim, document, employer, insurer, claimsOffice);
		this.wc1Form = wc1Form;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getFormDTOList() {
		List list = new ArrayList();
		list.add(this);
		return list;
	}

	public Wc1Form getWc1Form() {
		return wc1Form;
	}

	public void setWc1Form(Wc1Form wc1Form) {
		this.wc1Form = wc1Form;
	}

	public List<BodyPartType> getBodyPartTypes() {
		return bodyPartTypes;
	}

	public void setBodyPartTypes(List<BodyPartType> bodyPartTypes) {
		this.bodyPartTypes = bodyPartTypes;
	}

	public String convertToDelimitedString(List<BodyPartType> bodyPartTypes) {
		StringBuffer ret = new StringBuffer("");
		int i = 0;
		for (BodyPartType bodyPartType : bodyPartTypes) {
			ret.append(bodyPartType.getDescription());
			if (i < bodyPartTypes.size() - 1) {
				ret.append(',');
			}
			i++;
		}
		return ret.toString();
	}

	public String getBodyPartType() {
		return bodyPartType;
	}

	public void setBodyPartType(String bodyPartType) {
		this.bodyPartType = bodyPartType;
	}
}
