package gov.ga.sbwc.icms.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import gov.ga.sbwc.icms.common.entity.core.UserProductivityReport;
import gov.ga.sbwc.icms.core.repository.UserProductivityReportRepository;

@Service
public class UserProductivityReportServiceImpl {
	
	@Autowired
	private UserProductivityReportRepository userProductivityReportRepository;

	public List<UserProductivityReport> getUserProductivityReport() {
		 Pageable pageable = PageRequest.of(0, 1000,Sort.by(Sort.Order.desc("userProductivityReportPK.activityDate"))); // 0 is the page number (first page), 500 is the page size
	        Page<UserProductivityReport> page = userProductivityReportRepository.findAll(pageable);
	        return page.getContent();
	}

}