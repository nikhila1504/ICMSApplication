package com.icms.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.Slot;

@Repository
public interface SlotRepository extends CrudRepository<Slot, Integer> {

	@Query("SELECT s FROM Slot s WHERE s.calendar.calendarId = :calendarId")
	List<Slot> findByCalendarId(@Param("calendarId") int calendarId);

}
