/*----------------------------------------------------------------------------------------------------------------------
	Time sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.Random;

public class Time {
    private int m_hour;
    private int m_minute;
    private int m_second;
    private int m_millisecond;

    private static void doWorkForException(String msg)
    {
        System.out.println(msg);
        System.exit(-1); // exception işlemlerine kadar sabredin
    }

    private static boolean isValidForBounds(int val, int max) //[0, max]
    {
        return 0 <= val && val <= max;
    }

    private static boolean isValidForHour(int val)
    {
        return isValidForBounds(val, 23);
    }

    private static boolean isValidForMinute(int val)
    {
        return isValidForBounds(val, 59);
    }

    private static boolean isValidForSecond(int val)
    {
        return isValidForBounds(val, 59);
    }

    private static boolean isValidForMillisecond(int val)
    {
        return isValidForBounds(val, 999);
    }

    private static boolean isValidForTime(int hour, int minute, int second, int millisecond)
    {
        return isValidForHour(hour) && isValidForMinute(minute)
                && isValidForSecond(second) && isValidForMillisecond(millisecond);
    }

    private static void checkForHour(int val)
    {
        if (!isValidForHour(val))
            doWorkForException("Invalid hour value");
    }

    private static void checkForMinute(int val)
    {
        if (!isValidForMinute(val))
            doWorkForException("Invalid minute value");
    }

    private static void checkForSecond(int val)
    {
        if (!isValidForSecond(val))
            doWorkForException("Invalid second value");
    }

    private static void checkForMillisecond(int val)
    {
        if (!isValidForMillisecond(val))
            doWorkForException("Invalid millisecond value");
    }

    private static void checkForTime(int hour, int minute, int second, int millisecond)
    {
        if (!isValidForTime(hour, minute, second, millisecond))
            doWorkForException("Invalid time values");
    }

    public static Time randomTime()
    {
        return randomTime(new Random());
    }

    public static Time randomTime(Random r)
    {
        return new Time(r.nextInt(24), r.nextInt(60), r.nextInt(60), r.nextInt(1000));
    }

    public Time() //Sistemden o anki zaman alınıyor. Buradaki yazılan kodu anlamanız gerekmiyor
    {
        Calendar now = Calendar.getInstance();

        m_hour = now.get(Calendar.HOUR_OF_DAY);
        m_minute = now.get(Calendar.MINUTE);
        m_second = now.get(Calendar.SECOND);
        m_millisecond = now.get(Calendar.MILLISECOND);

    }

    //...

    public Time(int hour, int minute, int second, int millisecond)
    {
        checkForTime(hour, minute, second, millisecond);
        m_hour = hour;
        m_minute = minute;
        m_second = second;
        m_millisecond = millisecond;
    }

    public int getHour()
    {
        return m_hour;
    }

    public void setHour(int val)
    {
        if (val == m_hour)
            return;

        checkForHour(val);
        m_hour = val;
    }

    public int getMinute()
    {
        return m_minute;
    }

    public void setMinute(int val)
    {
        if (val == m_minute)
            return;

        checkForMinute(val);
        m_minute = val;
    }

    public int getSecond()
    {
        return m_second;
    }

    public void setSecond(int val)
    {
        if (val == m_second)
            return;

        checkForSecond(val);
        m_second = val;
    }

    public int getMillisecond()
    {
        return m_millisecond;
    }

    public void setMillisecond(int val)
    {
        if (val == m_millisecond)
            return;

        checkForMillisecond(val);
        m_millisecond = val;
    }

    public String toString()
    {
        return String.format("%s:%02d", toShortTimeString(), m_second);
    }

    public String toLongTimeString()
    {
        return String.format("%s.%03d", toString(), m_millisecond);
    }

    public String toShortTimeString()
    {
        return String.format("%02d:%02d", m_hour, m_minute);
    }
}
