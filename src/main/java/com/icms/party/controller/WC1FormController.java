package com.icms.party.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icms.party.entity.Claim;
import com.icms.party.entity.User;
import com.icms.party.entity.Wc1Form;
import com.icms.party.service.ClaimServiceImpl;
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

	public Claim loadClaimByClaimNo(String claimNo) throws UsernameNotFoundException {
		claimNo = "2024000100";
		Claim claim = claimService.getClaimByClaimNo(claimNo);
        if(claim == null){
            throw new UsernameNotFoundException("Invalid Claim No.");
        }
        else {
        	System.out.println("claim..."+claim.getId());
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
	@ApiOperation(value = "get Claim by id")
	@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
	public Claim getClaimById(@PathVariable Long id) {
		return claimService.getClaimById(id);
	}
	

	@GetMapping(value = "/claim/{claimNo}")
	@ApiOperation(value = "get Claim by claimNo")
	@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
	public Claim getClaimByClaimNo(@PathVariable String claimNo) {
		Claim claim = claimService.getClaimByClaimNo(claimNo);
		System.out.println("claim..."+claim.getId());
		return claim;
	}
}
