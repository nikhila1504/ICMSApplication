package gov.ga.sbwc.icms.common.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TimeWithCurrentDateDeserializer extends JsonDeserializer<Date> {

	private static final SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");

	@Override
	public Date deserialize(JsonParser parser, DeserializationContext context) throws IOException {
		String timeString = parser.getText();
		try {
			// Parse the time string (e.g., "18:18")
			Date parsedTime = timeFormatter.parse(timeString);

			// Get the current date
			Calendar calendar = Calendar.getInstance();
			Calendar timeCalendar = Calendar.getInstance();
			timeCalendar.setTime(parsedTime);

			// Set the current date's year, month, and day
			calendar.set(Calendar.HOUR_OF_DAY, timeCalendar.get(Calendar.HOUR_OF_DAY));
			calendar.set(Calendar.MINUTE, timeCalendar.get(Calendar.MINUTE));
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);

			return calendar.getTime();
		} catch (ParseException e) {
			throw new IOException("Failed to parse time: " + timeString, e);
		}
	}
}