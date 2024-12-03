package com.icms.party.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icms.party.entity.TrailManagementCalendarIntHearing;
import com.icms.party.repository.TrlMgmtCalendarRepository;

@Service
public class TrlMgmtCalendarServiceImpl {

	@Autowired
	private TrlMgmtCalendarRepository trlMgmtCalendarRepository;

	public List<TrailManagementCalendarIntHearing> getTrlMgmtCalendarList() {
		return trlMgmtCalendarRepository.findByClaimNo("2022095587");
	}

}