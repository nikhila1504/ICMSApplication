package com.icms.party.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.icms.party.entity.BodyPartType;
import com.icms.party.entity.Claim;
import com.icms.party.entity.ClaimParty;
import com.icms.party.entity.Claimant;
import com.icms.party.entity.InjuryCauseType;
import com.icms.party.entity.InjuryType;
import com.icms.party.entity.NaicsType;
import com.icms.party.entity.Wc1Form;
import com.icms.party.service.BodyPartTypeServiceImpl;
import com.icms.party.service.ClaimPartyServiceImpl;
import com.icms.party.service.ClaimServiceImpl;
import com.icms.party.service.ClaimantServiceImpl;
import com.icms.party.service.InjuryCauseTypeServiceImpl;
import com.icms.party.service.InjuryTypeServiceImpl;
import com.icms.party.service.NaicsTypeServiceImpl;
import com.icms.party.service.Wc1FormServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "WC1 Service", description = "WC1 Details", produces = "application/json")
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
	private NaicsTypeServiceImpl naicsTypeService;

	@Autowired
	private InjuryTypeServiceImpl injuryTypeService;

	@Autowired
	private InjuryCauseTypeServiceImpl injuryCauseTypeService;

	@Autowired
	private BodyPartTypeServiceImpl bodyPartTypeService;

	@Autowired
	private ClaimPartyServiceImpl claimPartyService;

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
//
//	@GetMapping("/claimParty/{claimId}")
//	@ApiOperation(value = "get ClaimParty by claimId")
//	@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
//	public List<ClaimParty> getClaimPartyByClaimId(@PathVariable(value = "claimId") Long claimId) {
//		return claimPartyService.getClaimPartyByClaimId(claimId);
//	}

	@GetMapping(value = "/claimPartyId/{claimId}")
	@ApiOperation(value = "get ClaimParty by id")
	@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
	public List<ClaimParty> getClaimPartyByClaimId(@PathVariable Long claimId) {
		return claimPartyService.getClaimPartyByClaimId(claimId);
	}

}
