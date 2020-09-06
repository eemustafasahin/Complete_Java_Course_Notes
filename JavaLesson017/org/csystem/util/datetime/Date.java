/*----------------------------------------------------------------------------------------------------------------------
	Date sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.Random;

public class Date {
    private static final String [] MONTHS_TR =
            {"", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};
    private static final String [] MONTHS_EN =
            {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    private int m_day;
    private int m_month;
    private int m_year;
    private int m_dayOfWeek;

    private static boolean isValidDate(int day, int month, int year)
    {
        if (day < 1 || day > 31 || month < 1 || month > 12)
            return false;

        int days = Month.values()[month - 1].getDaysByYear(year);

        return day <= days;
    }

    private static int getDayOfWeek(int day, int month, int year)
    {
        int dayOfYear;

        dayOfYear = getDayOfYear(day, month, year);

        if (year >= 1900) {
            for (int y = 1900; y < year; ++y)
                dayOfYear += Month.isLeapYear(y) ? 366 : 365;
        }
        else {
            for (int y = year + 1; y < 1900; ++y) //Algoritmasına bakılacak
                dayOfYear += Month.isLeapYear(y) ? 366 : 365;
        }


        return dayOfYear % 7;
    }

    private static int getDayOfYear(int day, int month, int year)
    {
        int dayOfYear = day;

        for (int m = month - 1; m >= 1; --m)
            dayOfYear += Month.values()[m - 1].getDaysByYear(year);

        return dayOfYear;
    }

    private static void doWorkForException(String errMsg)
    {
        System.out.println(errMsg);
        System.exit(-1); //exception işlemlerine kadar sabredin
    }

    private static void checkForDate(int day, int month, int year, String errMsg)
    {
        if (!isValidDate(day, month, year))
            doWorkForException(errMsg);
    }

    private void checkForDay(int val)
    {
        checkForDate(val, m_month, m_year, "Invalid day value");
    }

    private void checkForMonth(int val)
    {
        checkForDate(m_day, val, m_year, "Invalid month value");
    }

    private void checkForYear(int val)
    {
        checkForDate(m_day, m_month, val, "Invalid year value");
    }

    private void set(int day, int month, int year)
    {
        m_day = day;
        m_month = month;
        m_year = year;
        m_dayOfWeek = getDayOfWeek(m_day, m_month, m_year);
    }

    private String getDaySuffix()
    {
        String suffix;

        switch (m_day) {
            case 1:
            case 21:
            case 31:
                suffix = "st";
                break;
            case 2:
            case 22:
                suffix = "nd";
                break;
            case 3:
            case 23:
                suffix = "rd";
                break;
            default:
                suffix = "th";
        }

        return suffix;
    }

    public static Date randomDate()
    {
        return randomDate(new Random());
    }

    public static Date randomDate(Random r)
    {
        return randomDate(r, new Date().m_year);
    }

    public static Date randomDate(int year)
    {
        return randomDate(new Random(), year);
    }

    public static Date randomDate(Random r, int year)
    {
        return randomDate(r, year, year);
    }

    public static Date randomDate(int minYear, int maxYear) //[minYear, maxYear]
    {
        return randomDate(new Random(), minYear, maxYear);
    }

    public static Date randomDate(Random r, int minYear, int maxYear) //[minYear, maxYear]
    {
        int year = r.nextInt(maxYear - minYear + 1) + minYear;
        int month = r.nextInt(12) + 1;
        int day = r.nextInt(Month.values()[month - 1].getDaysByYear(year)) + 1;

        return new Date(day, month, year);
    }

    public Date() //Sistemden o anki tarih alınıyor. Buradaki yazılan kodu anlamanız gerekmiyor
    {
        Calendar now = Calendar.getInstance();

        m_day = now.get(Calendar.DAY_OF_MONTH);
        m_month = now.get(Calendar.MONTH) + 1;
        m_year = now.get(Calendar.YEAR);
    }

    public Date(int day, int month, int year)
    {
        checkForDate(day, month, year, "Invalid date values");
        set(day, month, year);
    }

    public Date(int day, Month month, int year)
    {
        checkForDate(day, month.ordinal() + 1, year, "Invalid date values");
        set(day, month.ordinal() + 1, year);
    }

    public int getDay()
    {
        return m_day;
    }

    public void setDay(int val)
    {
        if (val == m_day)
            return;

        checkForDay(val);
        set(val, m_month, m_year);
    }

    public int getMonthValue()
    {
        return m_month;
    }

    public void setMonthValue(int val)
    {
        if (val == m_month)
            return;

        checkForMonth(val);
        set(m_day, val, m_year);
    }

    public Month getMonth()
    {
        return Month.values()[m_month - 1];
    }

    public void setMonth(Month month)
    {
        setMonthValue(month.ordinal() + 1);
    }

    public int getYear()
    {
        return m_year;
    }

    public void setYear(int val)
    {
        if (val == m_year)
            return;

        checkForYear(val);
        set(m_day, m_month, val);
    }

    public DayOfWeek getDayOfWeek()
    {
        return DayOfWeek.values()[m_dayOfWeek];
    }

    public String getDayOfWeekTR()
    {
        return DayOfWeek.values()[m_dayOfWeek].NAME_TR;
    }

    public String getDayOfWeekEN()
    {
        return DayOfWeek.values()[m_dayOfWeek].NAME_EN;
    }

    public boolean isLeapYear()
    {
        return Month.isLeapYear(m_year);
    }

    public boolean isWeekday()
    {
        return !isWeekend();
    }

    public boolean isWeekend()
    {
        return m_dayOfWeek == 0 || m_dayOfWeek == 6;
    }

    public String toString(char delim)
    {
        return String.format("%02d%c%02d%c%04d", m_day, delim, m_month, delim, m_year);
    }

    public String toString()
    {
        return toString('/');
    }

    public String toStringTR()
    {
        return String.format("%d %s %d", m_day, MONTHS_TR[m_month], m_year);
    }

    public String toLongDateStringTR()
    {
        return String.format("%s %s", toStringTR(), getDayOfWeekTR());
    }

    public String toStringEN()
    {
        return String.format("%d%s %s %d", m_day, getDaySuffix(), MONTHS_EN[m_month], m_year);
    }

    public String toLongDateStringEN()
    {
        return String.format("%s %s", toStringEN(), getDayOfWeekEN());
    }
}
