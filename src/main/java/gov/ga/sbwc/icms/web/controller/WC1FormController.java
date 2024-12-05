package gov.ga.sbwc.icms.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ga.sbwc.icms.common.dto.doc.DocumentFileDTO;
import gov.ga.sbwc.icms.common.dto.form.FormDTO;
import gov.ga.sbwc.icms.common.dto.form.Wc1FormDTO;
import gov.ga.sbwc.icms.common.entity.core.BodyPartType;
import gov.ga.sbwc.icms.common.entity.core.Claim;
import gov.ga.sbwc.icms.common.entity.core.ClaimParty;
import gov.ga.sbwc.icms.common.entity.core.Claimant;
import gov.ga.sbwc.icms.common.entity.core.ControvertType;
import gov.ga.sbwc.icms.common.entity.core.DisabilityType;
import gov.ga.sbwc.icms.common.entity.core.Document;
import gov.ga.sbwc.icms.common.entity.core.InjuryCauseType;
import gov.ga.sbwc.icms.common.entity.core.InjuryType;
import gov.ga.sbwc.icms.common.entity.core.NaicsType;
import gov.ga.sbwc.icms.common.entity.core.StateType;
import gov.ga.sbwc.icms.common.entity.core.TreatmentType;
import gov.ga.sbwc.icms.common.entity.core.UserProductivityReport;
import gov.ga.sbwc.icms.common.entity.core.Wc1Form;
import gov.ga.sbwc.icms.common.enums.DocumentTypeEnum;
import gov.ga.sbwc.icms.common.enums.SourceTypeEnum;
import gov.ga.sbwc.icms.core.service.AsposeServiceImpl;
import gov.ga.sbwc.icms.core.service.BodyPartTypeServiceImpl;
import gov.ga.sbwc.icms.core.service.ClaimDocumentServiceImpl;
import gov.ga.sbwc.icms.core.service.ClaimPartyServiceImpl;
import gov.ga.sbwc.icms.core.service.ClaimServiceImpl;
import gov.ga.sbwc.icms.core.service.ClaimantServiceImpl;
import gov.ga.sbwc.icms.core.service.ControvertTypeServiceImpl;
import gov.ga.sbwc.icms.core.service.DisabilityTypeServiceImpl;
import gov.ga.sbwc.icms.core.service.DocumentServiceImpl;
import gov.ga.sbwc.icms.core.service.InjuryCauseTypeServiceImpl;
import gov.ga.sbwc.icms.core.service.InjuryTypeServiceImpl;
import gov.ga.sbwc.icms.core.service.NaicsTypeServiceImpl;
import gov.ga.sbwc.icms.core.service.StateTypeServiceImpl;
import gov.ga.sbwc.icms.core.service.TreatmentTypeServiceImpl;
import gov.ga.sbwc.icms.core.service.UserProductivityReportServiceImpl;
import gov.ga.sbwc.icms.core.service.Wc1FormServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "WC1 Service", produces = "application/json")
@CrossOrigin
@RequestMapping("/wc1")
public class WC1FormController {

	@Autowired
	private Wc1FormServiceImpl wc1FormService;

	@Autowired
	private ClaimServiceImpl claimService;

	@Autowired
	private ClaimantServiceImpl claimantService;

	@Autowired
	private DocumentServiceImpl documentService;

	@Autowired
	private ClaimDocumentServiceImpl claimDocumentService;

	@Autowired
	private StateTypeServiceImpl stateTypeService;

	@Autowired
	private NaicsTypeServiceImpl naicsTypeService;

	@Autowired
	private InjuryTypeServiceImpl injuryTypeService;

	@Autowired
	private InjuryCauseTypeServiceImpl injuryCauseTypeService;

	@Autowired
	private BodyPartTypeServiceImpl bodyPartTypeService;

	@Autowired
	private ClaimPartyServiceImpl claimPartyService;

	@Autowired
	private ControvertTypeServiceImpl controvertTypeServiceImpl;

	@Autowired
	private TreatmentTypeServiceImpl treatmentTypeServiceImpl;

	@Autowired
	private DisabilityTypeServiceImpl disabilityTypeServiceImpl;

	@Autowired
	private UserProductivityReportServiceImpl userProductivityReportServiceImpl;

	@Autowired
	private AsposeServiceImpl asposeService;

	public Claim loadClaimByClaimNo(String claimNo) throws UsernameNotFoundException {
		claimNo = "2024000100";
		Claim claim = claimService.getClaimByClaimNo(claimNo);
		if (claim == null) {
			throw new UsernameNotFoundException("Invalid Claim No.");
		} else {
			System.out.println("claim..." + claim.getId());
		}
		return claim;
	}

	public List<Object> orderFallback(Throwable t) {
		List<Object> parties = new ArrayList<>();
		parties.add("Wc1Form-Detail service unavailable!");
		return parties;

	}

	@PostMapping("/saveWc1Form")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@ApiOperation(value = "save WC1Form details")
	public Wc1Form saveWc1Form(@RequestBody Wc1Form wc1Form) {
		return wc1FormService.saveWc1Form(wc1Form);
	}

	@PutMapping("/updateWc1Form/{id}")
	@ApiOperation(value = "update Wc1Form details")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Wc1Form updateWc1Form(@RequestBody Wc1Form wc1Form) {
		// save updated party object
		return wc1FormService.updateWc1Form(wc1Form);
	}

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "get WC1Form by id")
	@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
	public Wc1Form getWC1FormById(@PathVariable Long id) {
		return wc1FormService.getWc1FormById(id);
	}

	@GetMapping(value = "/claimId/{id}")
	@ApiOperation(value = "get Claim by id")
	@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
	public Claim getClaimById(@PathVariable Long id) {
		return claimService.getClaimById(id);
	}

	@GetMapping(value = "/claimantId/{id}")
	@ApiOperation(value = "get Claim by id")
	@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
	public Claimant getClaimantById(@PathVariable Long id) {
		return claimantService.getClaimantById(id);
	}

	@GetMapping(value = "/claim/{claimNo}")
	@ApiOperation(value = "get Claim by claimNo")
	@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
	public Claim getClaimByClaimNo(@PathVariable String claimNo) {
		Claim claim = claimService.getClaimByClaimNo(claimNo);
		System.out.println("claim..." + claim.getId());
		return claim;
	}

	@GetMapping(value = "/claimant/{claimantId}")
	@ApiOperation(value = "get Claim by claimNo")
	@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
	public List<Claim> getClaimByClaimantId(@PathVariable Long claimantId) {
		return claimService.getClaimByClaimantId(claimantId);
	}

	@GetMapping("/getAllStateTypes")
	@ApiOperation(value = "get all State Types")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<StateType> listAllStateTypes() {
		return stateTypeService.listAllStateTypes();
	}

	@GetMapping("/getAllNaicsTypes")
	@ApiOperation(value = "get all Naics Types")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<NaicsType> listAllNaicsTypes() {
		return naicsTypeService.listAllNaicsTypes();
	}

	@GetMapping("/getAllInjuryTypes")
	@ApiOperation(value = "get all Injury Types")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<InjuryType> listAllInjuryTypes() {
		return injuryTypeService.listAllInjuryTypes();
	}

	@GetMapping("/getAllInjuryCauseTypes")
	@ApiOperation(value = "get all InjuryCause Types")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<InjuryCauseType> listAllInjuryCauseTypes() {
		return injuryCauseTypeService.listAllInjuryCauseTypes();
	}

	@GetMapping("/getAllBodyPartTypes")
	@ApiOperation(value = "get all BodyPart Types")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<BodyPartType> listAllBodyPartTypes() {
		return bodyPartTypeService.listAllBodyPartTypes();
	}

	@GetMapping("/getAllControvertTypes")
	@ApiOperation(value = "get all Controvert Types")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<ControvertType> listAllControvertTypes() {
		return controvertTypeServiceImpl.listAllControvertTypes();
	}

	@GetMapping("/getAllTreatmentTypes")
	@ApiOperation(value = "get all Treatment Types")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<TreatmentType> listAllTreatmentTypes() {
		return treatmentTypeServiceImpl.listAllTreatmentTypes();
	}

	@GetMapping("/getAllDisabilityTypes")
	@ApiOperation(value = "get all Disability Types")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<DisabilityType> listAllDisabilityTypes() {
		return disabilityTypeServiceImpl.listAllDisabilityTypes();
	}

	@GetMapping("/claimParty/{claimId}")
	@ApiOperation(value = "get ClaimParty by claimId")
	@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
	public List<ClaimParty> getClaimPartyByClaimId(@PathVariable(value = "claimId") Long claimId) {
		return claimPartyService.getClaimPartyByClaimId(claimId);
	}

//	@GetMapping(value = "/claimPartyId/{claimId}")
//	@ApiOperation(value = "get ClaimParty by id")
//	@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
//	public List<ClaimParty> getClaimPartyByClaimId(@PathVariable Long claimId) {
//		return claimPartyService.getClaimPartyByClaimId(claimId);
//	}

	@GetMapping(value = "/claimPartyById/{claimPartyId}")
	@ApiOperation(value = "get ClaimParty by id")
	@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
	public ClaimParty getClaimPartyByById(@PathVariable Long claimPartyId) {
		return claimPartyService.getClaimPartyById(claimPartyId);
	}

	@GetMapping(value = "/userProductiveReport")
	@ApiOperation(value = "get user ProductiveReport")
	@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
	public List<UserProductivityReport> getUserProductiveReport() {
		return userProductivityReportServiceImpl.getUserProductivityReport();
	}

	@PostMapping(value = "/submitWc1Form")
	@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
	public ResponseEntity<byte[]> submitWc1Form(@RequestBody Wc1Form wc1Form) {
		String documentType = DocumentTypeEnum.WC_1_EMPLOYERS_FIRST_REPORT_OF_INJURY.getCode();
		String sourceType = SourceTypeEnum.ONLINE.getCode();
//		Document document = documentService.createNewDocument(claim, documentType, sourceType, false);
//		wc1Form.setId(document.getId());
//		wc1Form = wc1FormService.saveWc1Form(wc1Form);
		Claim claim = getClaimById(1665067L);
//		claimDocumentService.createCaimDocument(claim, document);

//		List<ClaimParty> claimPartyList = getClaimPartyByClaimId(1665067L);
		Document document = documentService.getDocumentById(9368654L);
//		ClaimDocumentDTO claimDocumentDto = new ClaimDocumentDTO(claim, document);
		FormDTO formDto = new Wc1FormDTO(claim, document, wc1Form, null, null, null, null);
		try {
			DocumentFileDTO documentFileDTO = asposeService.createForm(claim, document, formDto);
			System.out.println("documentFileDTO...."+documentFileDTO.getBytes());
			byte[] fileBytes = documentFileDTO.getBytes();
//	         HttpHeaders headers = new HttpHeaders();
//	        headers.setContentType(MediaType.APPLICATION_PDF); 
//	        headers.setContentDisposition(ContentDisposition.inline().filename("Wc1.pdf").build()); 
//	        return new ResponseEntity<>(fileBytes, headers, HttpStatus.OK);
			HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/pdf");
            headers.add("Content-Disposition", "inline;");
            return ResponseEntity.ok().headers(headers).body(fileBytes);
//			asposeService.convertDocumentToPdf(documentFileDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("After catch....");
		return null;
	}
}
