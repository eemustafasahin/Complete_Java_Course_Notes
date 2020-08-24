package org.csystem.app.samples.dateapp;

public class DateUtil {
	public static int [] daysOfMonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public static int getDayOfWeek(int day, int month, int year)
	{
		int dayOfYear;
		
		dayOfYear = getDayOfYear(day, month, year);
		
		if (dayOfYear == -1 || year < 1900)
			return -1;
		
		for (int y = 1900; y < year; ++y)
			dayOfYear += isLeapYear(y) ? 366 : 365;		
		
		return dayOfYear % 7;
	}
	
	public static int getDayOfYear(int day, int month, int year)
	{
		if (!isValidDate(day, month, year))
			return -1;

		int dayOfYear = day;

		for (int m = month - 1; m >= 1; --m)
			dayOfYear += daysOfMonths[m];
		
		if (month > 2 && isLeapYear(year))
			++dayOfYear;

		return dayOfYear;
	}
	
	public static boolean isValidDate(int day, int month, int year)
	{
		if (day < 1 || day > 31 || month < 1 || month > 12)
			return false;

		int days = month == 2 && isLeapYear(year) ? 29 : daysOfMonths[month];
		
		return day <= days;
	}
	
	public static boolean isLeapYear(int year)
	{
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
}
