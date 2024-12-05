package gov.ga.sbwc.icms.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ga.sbwc.icms.common.entity.core.Party_Dummy;
import gov.ga.sbwc.icms.core.service.PartyServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Party Service", description = "Party Details",produces ="application/json")
@CrossOrigin
@RequestMapping("/party")
public class PartyController {
	
	@Autowired
	private PartyServiceImpl partyService;
	
	private static final String PARTY_DETAIL_SERVICE = "party-Details";
	
 
	@GetMapping("/getAllParties")
	@ApiOperation(value = "get all parties")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Party_Dummy> listparties() {
		return partyService.getAllParties();
	}
	
	public List<Object> orderFallback(Throwable t){
		List<Object> parties = new ArrayList<>();
		parties.add("party-Detail service unavailable!");
        return parties;

    }

	
	@PostMapping("/saveParty")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@ApiOperation(value = "save party details")
	public Party_Dummy saveparty(@RequestBody Party_Dummy party) {
		return partyService.saveParty(party);
	}
	
	@PutMapping("/updateParty/{id}")
	@ApiOperation(value = "update party details")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Party_Dummy updateparty(@RequestBody Party_Dummy party) {
		// save updated party object
		return partyService.updateParty(party);
	}
	
	// handler method to handle delete party request
	
	@DeleteMapping("/deleteParty/{id}")
	@ApiOperation(value = "delete party")
	@PreAuthorize("hasRole('ADMIN')")
	public void deletepartyById(@PathVariable int id) {
		 partyService.deletePartyById(id);
	}
	
	@GetMapping(value = "/{partyId}")
	@ApiOperation(value = "get party by id")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Party_Dummy getpartyById(@PathVariable int partyId) {
		return partyService.getPartyById(partyId);
	}
	
	
}
