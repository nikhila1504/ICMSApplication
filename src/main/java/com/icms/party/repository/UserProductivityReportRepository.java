package com.icms.party.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icms.party.entity.UserProductivityReport;
import com.icms.party.entity.UserProductivityReportPK;


public interface UserProductivityReportRepository  extends JpaRepository<UserProductivityReport, UserProductivityReportPK>{


}