package me.kamili.rachid.weather.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtils {

    public static boolean isDay(long ts) {
        Date d = new Date(ts);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
        return timeOfDay < 20 && timeOfDay >= 6;
    }

    public static Date shiftTimeZone(long ts, TimeZone sourceTimeZone, TimeZone targetTimeZone) {
        Calendar sourceCalendar = Calendar.getInstance();
        sourceCalendar.setTime(new Date(ts));
        sourceCalendar.setTimeZone(sourceTimeZone);

        Calendar targetCalendar = Calendar.getInstance();
        for (int field : new int[]{Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH,
                Calendar.HOUR, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND}) {
            targetCalendar.set(field, sourceCalendar.get(field));
        }
        targetCalendar.setTimeZone(targetTimeZone);

        return targetCalendar.getTime();
    }

}
