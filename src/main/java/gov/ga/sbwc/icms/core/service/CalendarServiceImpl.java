package gov.ga.sbwc.icms.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ga.sbwc.icms.common.entity.core.Calendar;
import gov.ga.sbwc.icms.core.repository.CalendarRepository;

@Service
public class CalendarServiceImpl {
	
	@Autowired
	private CalendarRepository calendarRepository;
	
	public List<Calendar> getAllCalendarList() {
		return (List<Calendar>) calendarRepository.findAll();
	
	}
	
	public Calendar saveCalendar(Calendar calendar) {
		return calendarRepository.save(calendar);
	}
	
	public Calendar getCalendarById(int id) {
		return calendarRepository.findById(id).orElse(null);
	}
	
	public Calendar updateCalendar(Calendar calendar) {
		return calendarRepository.save(calendar);
	}

	public void deleteCalendarById(int id) {
		calendarRepository.deleteById(id);
	}


}
