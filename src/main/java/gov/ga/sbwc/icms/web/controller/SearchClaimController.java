package gov.ga.sbwc.icms.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.ga.sbwc.icms.common.entity.core.Claim;
import gov.ga.sbwc.icms.core.service.ClaimServiceImpl;
import io.swagger.annotations.Api;

@RestController
@Api(value = "Search Claim Service", produces = "application/json")
@CrossOrigin
@RequestMapping("/searchClaim")
public class SearchClaimController {

	@Autowired
	private ClaimServiceImpl claimService;

	@GetMapping("/findClaim")
	public ResponseEntity<List<Claim>> findMatchingClaims(@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfInjury) {

		Set<Claim> claims = new HashSet<Claim>();
		claims.addAll(claimService.findMatchingClaims(firstName, lastName, dateOfBirth, dateOfInjury));
		claims.addAll(claimService.findMatchingClaims(lastName, firstName, dateOfBirth, dateOfInjury));
		claims.addAll(claimService.findMatchingClaims(firstName, lastName,null, dateOfInjury));
		claims.addAll(claimService.findExactMatchClaims(dateOfBirth, dateOfInjury));
		return ResponseEntity.ok(new ArrayList<Claim>(claims));
	}
}
