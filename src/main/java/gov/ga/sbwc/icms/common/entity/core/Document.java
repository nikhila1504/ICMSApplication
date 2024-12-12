package gov.ga.sbwc.icms.common.entity.core;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnTransformer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import gov.ga.sbwc.icms.common.enums.RecordStatusEnum;
import gov.ga.sbwc.icms.common.util.DataConversionUtil;

/**
 * The persistent class for the DOCUMENT database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "DOCUMENT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Document extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "DOCUMENT_ID_GENERATOR", sequenceName = "DOCUMENT_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DOCUMENT_ID_GENERATOR")
	@Column(name = "DOCUMENT_ID")
	private Long id;

	@Column(name = "DATE_FILED")
	private Date dateFiled;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DOCUMENT_TYPE_ID")
	private DocumentType documentType;

	@Column(name = "REPOSITORY_DOC_ID")
	private Long repositoryId;

	@Size(max = 20, message = "Matching Claim No should not be more than 20 characters")
	@Column(name = "MATCHING_CLAIM_NO")
	private String matchingClaimNo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SOURCE_TYPE_ID")
	private SourceType sourceType;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DOCUMENT_STATUS_TYPE_ID")
	private DocumentStatusType documentStatusType;

	@Size(max = 200, message = "Assignee should not be more than 200 characters")
	@Column(name = "ASSIGNEE")
	private String assignee;

	@Column(name = "SCAN_DATE")
	private Date dateScanned;

	@Column(name = "IS_CLAIM_CREATOR")
	private Boolean claimCreator = false;

	@Column(name = "IS_RESEARCH")
	private Boolean research = false;

	@Size(max = 20, message = "Submitter Bar No should not be more than 20 characters")
	@Column(name = "SUBMITTER_BAR_NO")
	private String submitterBarNo;

	@Size(max = 100, message = "Submitter Name should not be more than 100 characters")
	@Column(name = "SUBMITTER_NAME")
	@ColumnTransformer(forColumn = "SUBMITTER_NAME", write = "TRIM(UPPER(?))")
	private String submitterName;

	@Size(max = 100, message = "Submitter Address 1 should not be more than 100 characters")
	@Column(name = "SUBMITTER_ADDRESS1")
	private String submitterAddress1;

	@Size(max = 100, message = "Submitter Address 2 should not be more than 100 characters")
	@Column(name = "SUBMITTER_ADDRESS2")
	private String submitterAddress2;

	@Size(max = 100, message = "Submitter City should not be more than 100 characters")
	@Column(name = "SUBMITTER_CITY")
	private String submitterCity;

	@Size(max = 2, message = "Submitter State should not be more than 2 characters")
	@Column(name = "SUBMITTER_STATE")
	private String submitterState = "GA";

	@Column(name = "SUBMITTER_ZIP")
	private String submitterZip;

	@Column(name = "SUBMITTER_ZIP_EXT")
	private String submitterZipExt;

	@Column(name = "SUBMITTER_PHONE")
	private String submitterPhone;

	@Column(name = "SUBMITTER_PHONE_EXT")
	private String submitterPhoneExt;

	@Size(max = 100, message = "Submitter Email should not be more than 100 characters")
	@Column(name = "SUBMITTER_EMAIL")
	private String submitterEmail;

	@Column(name = "IS_SUBMITTER_SIGNED")
	private Boolean submitterSigned = false;

	@Transient
	private String submitterSignature;

	@Column(name = "SUBMITTER_SIGNATURE_DATE")
	private Date submitterSignatureDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TAB_TYPE_ID")
	private TabType tabType;

	@Column(name = "IS_ROC")
	private Boolean roc = false;

	@Column(name = "IS_WORKFLOW_REQUIRED")
	private Boolean workflowRequired = true;

	@Column(name = "DISPOSITION_DATE")
	private Date dispositionDate;

	@ManyToOne
	@JoinColumn(name = "DISPOSITION_TYPE_ID")
	private DispositionType dispositionType;

	@Column(name = "IS_SAVE")
	private Boolean save = false;

	@Column(name = "SCAN_BATCH_ID")
	private Long scanBatchId;

	@Column(name = "IS_SCAN_ERROR")
	private Boolean isScanError = false;

	/* Fix #2726 */
	@Column(name = "PARENT_ID", nullable = true)
	private Long parentId;

	/* Fix #2726 */
	/* Fix #1195 */
	@Column(name = "COMPLETED_DATE")
	private Date completedDate;
	/* Fix #1195 */

	@Column(name = "QUEUE_ENTRY_DATE")
	private Date queueEntryDate;

	@Column(name = "QUEUE_EXIT_DATE")
	private Date queueExitDate;

	@Column(name = "RESEARCH_ENTRY_DATE")
	private Date researchEntryDate;

	@Column(name = "RESEARCH_EXIT_DATE")
	private Date researchExitDate;

	@ManyToOne
	@JoinColumn(name = "FUNCTIONAL_ROLE_TYPE_ID")
	private FunctionalRoleType functionalRoleType;

	@ManyToOne
	@JoinColumn(name = "TASK_ACTION_TYPE_ID")
	private TaskActionType taskActionType;

	@Size(max = 4000, message = "Comments should not be more than 4000 characters")
	@Column(name = "COMMENTS")
	private String comments;

	@Column(name = "WORKFLOW_ID", columnDefinition = "nvarchar2")
	private String workflowId;

	@Column(name = "SUSPENDED_DATE")
	private Date suspendedDate;

	@Version
	@Column(name = "VERSION")
	private int version;

	@Transient
	private String insurerFileNo;

	@Transient
	private String taskId;

	@Transient
	private String owner;

	@Transient
	private boolean openSchedule = false;

	public Document() {
	}

	public Date getDateFiled() {
		return dateFiled;
	}

	public void setDateFiled(Date dateFiled) {
		this.dateFiled = dateFiled;
	}

	public Long getRepositoryId() {
		return repositoryId;
	}

	public void setRepositoryId(Long repositoryId) {
		this.repositoryId = repositoryId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public String getMatchingClaimNo() {
		return matchingClaimNo;
	}

	public void setMatchingClaimNo(String matchingClaimNo) {
		this.matchingClaimNo = matchingClaimNo;
	}

	public Date getDateScanned() {
		return dateScanned;
	}

	public SourceType getSourceType() {
		return sourceType;
	}

	public void setSourceType(SourceType sourceType) {
		this.sourceType = sourceType;
	}

	public void setDateScanned(Date dateScanned) {
		this.dateScanned = dateScanned;
	}

	public Boolean getClaimCreator() {
		return claimCreator;
	}

	public void setClaimCreator(Boolean claimCreator) {
		this.claimCreator = claimCreator;
	}

	public Boolean getResearch() {
		return research;
	}

	public void setResearch(Boolean research) {
		this.research = research;
		if (research != null) {
			if (research) {
				this.researchEntryDate = new Date();
			} else if (this.researchEntryDate != null) {
				this.researchExitDate = new Date();
			}
		}
	}

	public DocumentStatusType getDocumentStatusType() {
		return documentStatusType;
	}

	public void setDocumentStatusType(DocumentStatusType documentStatusType) {
		this.documentStatusType = documentStatusType;
	}

	public String getSubmitterName() {
		return submitterName;
	}

	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
	}

	public String getSubmitterAddress1() {
		return submitterAddress1;
	}

	public void setSubmitterAddress1(String submitterAddress1) {
		this.submitterAddress1 = submitterAddress1;
	}

	public String getSubmitterAddress2() {
		return submitterAddress2;
	}

	public void setSubmitterAddress2(String submitterAddress2) {
		this.submitterAddress2 = submitterAddress2;
	}

	public String getSubmitterCity() {
		return submitterCity;
	}

	public void setSubmitterCity(String submitterCity) {
		this.submitterCity = submitterCity;
	}

	public String getSubmitterState() {
		return submitterState;
	}

	public void setSubmitterState(String submitterState) {
		this.submitterState = submitterState;
	}

	public String getSubmitterZip() {
		return submitterZip;
	}

	public void setSubmitterZip(String submitterZip) {
		this.submitterZip = submitterZip;
	}

	public String getSubmitterZipExt() {
		return submitterZipExt;
	}

	public void setSubmitterZipExt(String submitterZipExt) {
		this.submitterZipExt = submitterZipExt;
	}

	public String getSubmitterPhone() {
		return DataConversionUtil.formatPhone(submitterPhone);
	}

	public void setSubmitterPhone(String submitterPhone) {
		this.submitterPhone = DataConversionUtil.parsePhone(submitterPhone);
	}

	public String getSubmitterPhoneExt() {
		return submitterPhoneExt;
	}

	public void setSubmitterPhoneExt(String submitterPhoneExt) {
		this.submitterPhoneExt = submitterPhoneExt;
	}

	public String getSubmitterEmail() {
		return submitterEmail;
	}

	public void setSubmitterEmail(String submitterEmail) {
		this.submitterEmail = submitterEmail;
	}

	public Boolean getSubmitterSigned() {
		return submitterSigned;
	}

	public void setSubmitterSigned(Boolean submitterSigned) {
		this.submitterSigned = submitterSigned;
	}

	/* Fix #2705 */
	public Date getSubmitterSignatureDate() {
		submitterSignatureDate = (recordStatus == RecordStatusEnum.DRAFT.getCode() ? new Date()
				: submitterSignatureDate);
		return submitterSignatureDate;
	}

	public void setSubmitterSignatureDate(Date submitterSignatureDate) {
		this.submitterSignatureDate = submitterSignatureDate;
	}

	/* Fix #2705 */

	public String getSubmitterBarNo() {
		return submitterBarNo;
	}

	public void setSubmitterBarNo(String submitterBarNo) {
		this.submitterBarNo = submitterBarNo;
	}

	public TabType getTabType() {
		return tabType;
	}

	public void setTabType(TabType tabType) {
		this.tabType = tabType;
	}

	public Boolean getRoc() {
		return roc;
	}

	public void setRoc(Boolean roc) {
		this.roc = roc;
	}

	public Date getDispositionDate() {
		return dispositionDate;
	}

	public void setDispositionDate(Date dispositionDate) {
		this.dispositionDate = dispositionDate;
	}

	public DispositionType getDispositionType() {
		return dispositionType;
	}

	public void setDispositionType(DispositionType dispositionType) {
		this.dispositionType = dispositionType;
	}

	public Boolean getSave() {
		return save;
	}

	public void setSave(Boolean save) {
		this.save = save;
	}

	public Boolean getWorkflowRequired() {
		return workflowRequired;
	}

	public void setWorkflowRequired(Boolean workflowRequired) {
		this.workflowRequired = workflowRequired;
	}

	public Boolean getIsScanError() {
		return isScanError;
	}

	public void setIsScanError(Boolean isScanError) {
		this.isScanError = isScanError;
	}

	public Long getScanBatchId() {
		return scanBatchId;
	}

	public void setScanBatchId(Long scanBatchId) {
		this.scanBatchId = scanBatchId;
	}

	/* Fix #2726 */
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/* Fix #2726 */
	/* Fix #1195 */
	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}
	/* Fix #1195 */

	public Date getQueueEntryDate() {
		return queueEntryDate;
	}

	public void setQueueEntryDate(Date queueEntryDate) {
		this.queueEntryDate = queueEntryDate;
	}

	public Date getQueueExitDate() {
		return queueExitDate;
	}

	public void setQueueExitDate(Date queueExitDate) {
		this.queueExitDate = queueExitDate;
	}

	public Date getResearchEntryDate() {
		return researchEntryDate;
	}

	public void setResearchEntryDate(Date researchEntryDate) {
		this.researchEntryDate = researchEntryDate;
	}

	public Date getResearchExitDate() {
		return researchExitDate;
	}

	public void setResearchExitDate(Date researchExitDate) {
		this.researchExitDate = researchExitDate;
	}

	public FunctionalRoleType getFunctionalRoleType() {
		return functionalRoleType;
	}

	public void setFunctionalRoleType(FunctionalRoleType functionalRoleType) {
		this.functionalRoleType = functionalRoleType;
	}

	public TaskActionType getTaskActionType() {
		return taskActionType;
	}

	public void setTaskActionType(TaskActionType taskActionType) {
		this.taskActionType = taskActionType;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getSubmitterSignature() {
		return submitterSignature;
	}

	public void setSubmitterSignature(String submitterSignature) {
		this.submitterSignature = submitterSignature;
	}

	public String getInsurerFileNo() {
		return insurerFileNo;
	}

	public void setInsurerFileNo(String insurerFileNo) {
		this.insurerFileNo = insurerFileNo;
	}

	public boolean isOpenSchedule() {
		return openSchedule;
	}

	public void setOpenSchedule(boolean openSchedule) {
		this.openSchedule = openSchedule;
	}

	public String getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getSuspendedDate() {
		return suspendedDate;
	}

	public void setSuspendedDate(Date suspendedDate) {
		this.suspendedDate = suspendedDate;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

}