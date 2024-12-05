package gov.ga.sbwc.icms.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import gov.ga.sbwc.icms.common.entity.core.Party_Dummy;
import gov.ga.sbwc.icms.core.repository.PartyRepository;

@Service
public class PartyServiceImpl {

	@Autowired
	private PartyRepository partyRepository;

	@Autowired
	private RestTemplate restTemplate;

	public List<Party_Dummy> getAllParties() {
		// TODO Auto-generated method stub
		List<Party_Dummy> Partys = (List<Party_Dummy>) partyRepository.findAll();
//		ResponseEntity<List<PartyDetail>> responseEntity = restTemplate.exchange(
//				"http://localhost:8080/getAllPartyDetails", HttpMethod.GET, null,
//				new ParameterizedTypeReference<List<PartyDetail>>() {
//				});
//		List<PartyDetail> studetail = responseEntity.getBody();
//		Partys.stream().forEach(stu -> {
//			ArrayList<PartyDetail> list = new ArrayList<>();
//			studetail.stream().forEach(std -> {
//				if (stu.getId() == std.getId()) {
//					list.add(std);
//				}
//			});
//			//stu.setPartyDetail(list);
//		});
		return Partys;
	}

	public Party_Dummy saveParty(Party_Dummy party) {
		Party_Dummy stu = partyRepository.save(party);
		return stu;
	}

	public Party_Dummy getPartyById(int id) {
//		Party service = partyRepository.findById(id).orElse(null);
//
//		String res = "http://localhost:8080/savePartyDetail";
//
//		ResponseEntity<PartyDetail> response = restTemplate
//				.getForEntity("http://localhost:8080/getPartyDetail/" + "/" + id, PartyDetail.class);
//
//		PartyDetail st = response.getBody();
//		List<PartyDetail> Party = new ArrayList();
//		Party.add(st);
		//service.setPartyDetail(Party);
		// return partyRepository.findById(id).orElse(null);
		return partyRepository.findById(id).orElse(null);
	}

	public Party_Dummy updateParty(Party_Dummy party) {
		return partyRepository.save(party);
	}

	public void deletePartyById(int id) {
		partyRepository.deleteById(id);
	}

}
