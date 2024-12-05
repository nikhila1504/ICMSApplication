package gov.ga.sbwc.icms.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.ga.sbwc.icms.common.entity.core.Slot;

@Repository
public interface SlotRepository extends CrudRepository<Slot, Integer> {

	@Query("SELECT s FROM Slot s WHERE s.calendar.calendarId = :calendarId")
	List<Slot> findByCalendarId(@Param("calendarId") int calendarId);

}
