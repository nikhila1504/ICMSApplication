package gov.ga.sbwc.icms.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.ga.sbwc.icms.common.entity.core.UserProductivityReport;
import gov.ga.sbwc.icms.common.entity.core.UserProductivityReportPK;


public interface UserProductivityReportRepository  extends JpaRepository<UserProductivityReport, UserProductivityReportPK>{


}