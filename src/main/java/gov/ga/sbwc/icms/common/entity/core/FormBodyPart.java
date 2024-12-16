package gov.ga.sbwc.icms.common.entity.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the FORM_BODY_PART database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "FORM_BODY_PART")
public class FormBodyPart extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "FORM_BODY_PART_ID_GENERATOR", sequenceName = "FORM_BODY_PART_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FORM_BODY_PART_ID_GENERATOR")
	@Column(name="FORM_BODY_PART_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BODY_PART_TYPE_ID")
	private BodyPartType bodyPartType;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DOCUMENT_ID")
	private Document document;
	

    public FormBodyPart() {
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public BodyPartType getBodyPartType() {
		return bodyPartType;
	}


	public void setBodyPartType(BodyPartType bodyPartType) {
		this.bodyPartType = bodyPartType;
	}


	public Document getDocument() {
		return document;
	}


	public void setDocument(Document document) {
		this.document = document;
	}



}