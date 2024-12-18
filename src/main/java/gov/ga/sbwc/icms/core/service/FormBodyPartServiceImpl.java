package gov.ga.sbwc.icms.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ga.sbwc.icms.common.entity.core.BodyPartType;
import gov.ga.sbwc.icms.common.entity.core.Document;
import gov.ga.sbwc.icms.common.entity.core.FormBodyPart;
import gov.ga.sbwc.icms.core.repository.FormBodyPartRepository;

@Service
public class FormBodyPartServiceImpl {
	
	@Autowired
	private FormBodyPartRepository formBodyPartRepository;
	
	public void saveFormBodyParties(Document document,List<BodyPartType> affectedBodyParts)
	{
		if(affectedBodyParts != null)
		{
			for(BodyPartType bodyPartType:affectedBodyParts)
			{
				FormBodyPart formBodyPart = new FormBodyPart();
				formBodyPart.setBodyPartType(bodyPartType);
				formBodyPart.setDocument(document);
				formBodyPartRepository.save(formBodyPart);
			}
		}
	}

}
