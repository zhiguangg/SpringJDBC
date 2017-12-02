import java.util.Calendar;
import java.util.Date;

public final class Utils {

	public static Date getDateByYear(int year) {
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		return cal.getTime();
	}
}
