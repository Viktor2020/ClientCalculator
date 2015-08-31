package statistic;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by on 13.01.2015.
 * @author Viktor
 */
public class GregorianCalendarToString {
    public static String convert(GregorianCalendar calendar) {
        return  calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.MONTH)+1 + " " + calendar.get(Calendar.YEAR) +  "";
    }
}
