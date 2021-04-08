package javaa.mykong;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {

	private static final String DATE_FORMAT = "dd-MMM-yyyy HH:mm:ss";
	private static final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	private static final DateTimeFormatter dateFormat8 = DateTimeFormatter.ofPattern(DATE_FORMAT);

	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		Date date = new Date("07-OCT-1986");
		LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		System.out.println("localDateTime : " + dateFormat8.format(localDateTime));
		localDateTime = localDateTime.plusYears(1).plusMonths(1).plusDays(1);
		localDateTime = localDateTime.plusHours(1).plusMinutes(2).minusMinutes(1).plusSeconds(1);
		date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		System.out.println("\nOutput : " + dateFormat.format(date));

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 7);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.YEAR, 1986);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		System.out.println(dateFormat.format(cal.getTime()));
	}

}
