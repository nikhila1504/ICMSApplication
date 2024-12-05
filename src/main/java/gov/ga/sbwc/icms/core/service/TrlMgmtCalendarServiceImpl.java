package gov.ga.sbwc.icms.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import gov.ga.sbwc.icms.common.entity.core.TrailManagementCalendarIntHearing;
import gov.ga.sbwc.icms.core.repository.TrlMgmtCalendarRepository;

@Service
public class TrlMgmtCalendarServiceImpl {

	@Autowired
	private TrlMgmtCalendarRepository trlMgmtCalendarRepository;

	public List<TrailManagementCalendarIntHearing> getTrlMgmtCalendarList() {
//		return trlMgmtCalendarRepository.findByClaimNo("2024013943");
//		return trlMgmtCalendarRepository.findByDivisionTypeId(2L);
		Pageable pageable = PageRequest.of(0, 500, Sort.by(Sort.Order.desc("id"))); // 0 is the page number (first
																					// page), 500 is the page size
		Page<TrailManagementCalendarIntHearing> page = trlMgmtCalendarRepository.findAll(pageable);
		return page.getContent();
	}

}