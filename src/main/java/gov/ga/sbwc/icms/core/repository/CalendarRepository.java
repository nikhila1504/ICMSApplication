package gov.ga.sbwc.icms.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.ga.sbwc.icms.common.entity.core.Calendar;

@Repository
public interface CalendarRepository extends CrudRepository<Calendar,Integer>{

}