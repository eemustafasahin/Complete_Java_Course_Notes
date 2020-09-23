### Nitelikli ve niteliksiz genel isim arama kurallarına göre bir isim ilgili sınıfta bulunamazsa taban sınıflara da bakılır.
```java
/*----------------------------------------------------------------------------------------------------------------------
	19.09.2020
	Nitelikli ve niteliksiz genel isim arama kurallarına göre bir isim ilgili sınıfta bulunamazsa taban sınıflara da
	sırasıyla bulununcaya veya bulunamayıncaya kadar bakılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		B b = new B();

		b.bar(34);
		System.out.printf("b.x=%d%n", b.x);
	}
}

class B extends A {
	public void bar(int a)
	{
		foo();
		x = a;
	}
}

class A {
	public int x;
	public void foo()
	{
		System.out.println("A.foo");
	}
}
```
### sınıfın protected bölümü aynı paketteki diğer sınıflar için public'dir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Hatırlanacağı gibi sınıfın protected bölümü aynı paketteki diğer sınıflar için public'dir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

class B {
	public void bar()
	{
		A a = new A(/*...*/);

		a.x = 20;

		a.foo();
	}
}

class A {
	protected int x;
	protected A(/*...*/)
	{
		//...
	}

	protected void foo()
	{

	}
}
```
### sınıf içerisinde sınıfın her bölümüne erişilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Hatırlanacağı gibi sınıf içerisinde sınıfın her bölümüne erişilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

class A {
	private int m_x;
	protected void bar()
	{}

	void tar()
	{

	}

	public void foo()
	{
		A a = new A();

		a.m_x = 10;
		a.tar();
		a.bar();
	}
}
```
### protected bölüme türemiş sınıflar aşağıdaki gibi erişemez
```java
/*----------------------------------------------------------------------------------------------------------------------
	protected bölüme türemiş sınıflar aşağıdaki gibi erişemez
----------------------------------------------------------------------------------------------------------------------*/
package mest;

import test.A;

public class B extends A {
    public void bar()
    {
        A a = new A(/*...*/); //error

        a.x = 20; //error

        a.foo(); //error
    }
}

package test;

public class A {
    protected int x;
    protected A(/*...*/)
    {
        //...
    }

    protected void foo()
    {

    }
}
```
### Türemiş sınıf içerisinde kendisine ait olan taban sınıf bölümünün protected elemanlarına erişilebilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Türemiş sınıf içerisinde kendisine ait olan taban sınıf bölümünün protected elemanlarına erişilebilir. Yani türemiş
	sınıf nesnesinin taban sınıf nesnesine ilişkin protected bölüme erişim geçerlidir
----------------------------------------------------------------------------------------------------------------------*/

package mest;

import test.A;

public class B extends A {
    public B()
    {

    }

    public void bar()
    {
        x = 10;
        foo();
    }
}

package test;

public class A {
    protected int x;
    protected A(/*...*/)
    {
        //...
    }

    protected void foo()
    {

    }
}
```
### AnalyticalCircle sınıfı ve test kodu (1)
```java
/*----------------------------------------------------------------------------------------------------------------------
	AnalyticalCircle sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.geometry.AnalyticalCircle;

class App {
	public static void main(String [] args)
	{
		AnalyticalCircle analyticalCircle = new AnalyticalCircle(-3.4, 100, 45);

		System.out.printf("Yarıçap:%f%n", analyticalCircle.getRadius());
		System.out.printf("Çevre:%f%n", analyticalCircle.getCircumference());
		System.out.printf("Alan:%f%n", analyticalCircle.getArea());
		System.out.printf("{x:%d, y:%d}%n", analyticalCircle.getX(), analyticalCircle.getY());
	}
}
```
### AnalyticalCircle sınıfı ve test kodu (2)
```java
/*----------------------------------------------------------------------------------------------------------------------
	AnalyticalCircle sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.geometry.AnalyticalCircle;

class App {
	public static void main(String [] args)
	{
		AnalyticalCircle analyticalCircle = new AnalyticalCircle();

		System.out.printf("Yarıçap:%f%n", analyticalCircle.getRadius());
		System.out.printf("Çevre:%f%n", analyticalCircle.getCircumference());
		System.out.printf("Alan:%f%n", analyticalCircle.getArea());
		System.out.printf("{x:%d, y:%d}%n", analyticalCircle.getX(), analyticalCircle.getY());
	}
}
```
### AnalyticalCircle sınıfı ve test kodu (3)
```java
/*----------------------------------------------------------------------------------------------------------------------
	AnalyticalCircle sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.geometry.AnalyticalCircle;

class App {
	public static void main(String [] args)
	{
		AnalyticalCircle analyticalCircle = new AnalyticalCircle(100, 100);

		System.out.printf("Yarıçap:%f%n", analyticalCircle.getRadius());
		System.out.printf("Çevre:%f%n", analyticalCircle.getCircumference());
		System.out.printf("Alan:%f%n", analyticalCircle.getArea());
		System.out.printf("{x:%d, y:%d}%n", analyticalCircle.getX(), analyticalCircle.getY());
	}
}
```
### AnalyticalCircle sınıfı ve test kodu (4)
```java
/*----------------------------------------------------------------------------------------------------------------------
	AnalyticalCircle sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.geometry.AnalyticalCircle;

class App {
	public static void main(String [] args)
	{
		AnalyticalCircle analyticalCircle = new AnalyticalCircle(-9.78);

		System.out.printf("Yarıçap:%f%n", analyticalCircle.getRadius());
		System.out.printf("Çevre:%f%n", analyticalCircle.getCircumference());
		System.out.printf("Alan:%f%n", analyticalCircle.getArea());
		System.out.printf("{x:%d, y:%d}%n", analyticalCircle.getX(), analyticalCircle.getY());
	}
}
```
### AnalyticalCircle sınıfı ve test kodu (5)
```java
/*----------------------------------------------------------------------------------------------------------------------
	AnalyticalCircle sınıfı ve test kodu
	Aşağıdaki kodu double ve Point parametreli ctor'u aşağıdaki gibi yazarak test edip problemi inceleyiniz:
	public AnalyticalCircle(double radius, Point center) //Kötü tasarım
    {
        super(radius);
        m_center = center;
    }
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.geometry.AnalyticalCircle;
import org.csystem.math.geometry.Point;

class App {
	public static void main(String [] args)
	{
		Point p = new Point(100, 100);
		AnalyticalCircle analyticalCircle = new AnalyticalCircle(-3.4, p);

		System.out.printf("Yarıçap:%f%n", analyticalCircle.getRadius());
		System.out.printf("Çevre:%f%n", analyticalCircle.getCircumference());
		System.out.printf("Alan:%f%n", analyticalCircle.getArea());
		System.out.printf("{x:%d, y:%d}%n", analyticalCircle.getX(), analyticalCircle.getY());

		p.offset(-20);

		System.out.printf("Yarıçap:%f%n", analyticalCircle.getRadius());
		System.out.printf("Çevre:%f%n", analyticalCircle.getCircumference());
		System.out.printf("Alan:%f%n", analyticalCircle.getArea());
		System.out.printf("{x:%d, y:%d}%n", analyticalCircle.getX(), analyticalCircle.getY());
	}
}

```
### AnalyticalCircle sınıfı ve test kodu (6)
```java
/*----------------------------------------------------------------------------------------------------------------------
	AnalyticalCircle sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.geometry.AnalyticalCircle;
import org.csystem.math.geometry.Point;

class App {
	public static void main(String [] args)
	{
		Point p = new Point(100, 100);
		AnalyticalCircle analyticalCircle = new AnalyticalCircle(-3.4, p);

		System.out.printf("Yarıçap:%f%n", analyticalCircle.getRadius());
		System.out.printf("Çevre:%f%n", analyticalCircle.getCircumference());
		System.out.printf("Alan:%f%n", analyticalCircle.getArea());
		System.out.printf("{x:%d, y:%d}%n", analyticalCircle.getX(), analyticalCircle.getY());

		analyticalCircle.setCenter(-23, 78);

		System.out.printf("Yarıçap:%f%n", analyticalCircle.getRadius());
		System.out.printf("Çevre:%f%n", analyticalCircle.getCircumference());
		System.out.printf("Alan:%f%n", analyticalCircle.getArea());
		System.out.printf("{x:%d, y:%d}%n", analyticalCircle.getX(), analyticalCircle.getY());
	}
}
``` 
### AnalyticalCircle sınıfı ve test kodu (7)
```java
/*----------------------------------------------------------------------------------------------------------------------
	AnalyticalCircle sınıfı ve test kodu:
	Bir sınıfın içerisinde veri elemanı olarak tuttuğu referansa ilişkin bir metodun aynı isimde ve genel olarak
	aynı parametrik yapıda yazılan bir versiyonuna "delegate, pass-through, forwarding method" denir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.geometry.AnalyticalCircle;

class App {
	public static void main(String [] args)
	{
		AnalyticalCircle analyticalCircle = new AnalyticalCircle(-3.4, 100, 90);

		System.out.printf("Yarıçap:%f%n", analyticalCircle.getRadius());
		System.out.printf("Çevre:%f%n", analyticalCircle.getCircumference());
		System.out.printf("Alan:%f%n", analyticalCircle.getArea());
		System.out.printf("{x:%d, y:%d}%n", analyticalCircle.getX(), analyticalCircle.getY());

		analyticalCircle.offset(-10);

		System.out.printf("Yarıçap:%f%n", analyticalCircle.getRadius());
		System.out.printf("Çevre:%f%n", analyticalCircle.getCircumference());
		System.out.printf("Alan:%f%n", analyticalCircle.getArea());
		System.out.printf("{x:%d, y:%d}%n", analyticalCircle.getX(), analyticalCircle.getY());
	}
}
```
### AnalyticalCircle sınıfı ve test kodu (8)
```java
/*----------------------------------------------------------------------------------------------------------------------
	AnalyticalCircle sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.geometry.AnalyticalCircle;

class App {
	public static void main(String [] args)
	{
		AnalyticalCircle analyticalCircle1 = new AnalyticalCircle(-3.4, 100, 90);
		AnalyticalCircle analyticalCircle2 = new AnalyticalCircle(-3.4, 34, -90);

		System.out.printf("Radius distance:%f%n", analyticalCircle1.radiusDistance(analyticalCircle2));
	}
}
```
### Circle sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
	Circle sınıfı
	-- AnalyticalCircle is Circle, has a Point
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math.geometry;

public class AnalyticalCircle extends Circle {
    private final Point m_center;

    public AnalyticalCircle()
    {
        this(0);
    }

    public AnalyticalCircle(double radius)
    {
        this(radius, 0, 0);
    }

    public AnalyticalCircle(int x, int y)
    {
        this(0, x, y);
    }

    public AnalyticalCircle(Point center)
    {
        this(0, center);
    }

    public AnalyticalCircle(double radius, Point center)
    {
        this(radius, center.x, center.y);
    }

    public AnalyticalCircle(double radius, int x, int y) //primary (core) ctor
    {
        super(radius);
        m_center = new Point(x, y);
    }

    public int getX()
    {
        return m_center.x;
    }

    public void setCenter(Point center)
    {
        setCenter(center.x, center.y);
    }

    public void setCenter(int x, int y)
    {
        setX(x);
        setY(y);
    }

    public void setX(int x)
    {
        m_center.x = x;
    }

    public void setY(int y)
    {
        m_center.y = y;
    }

    public int getY()
    {
        return m_center.y;
    }

    public Point getCenter()
    {
        return new Point(m_center); // m_center doğrudan verilseydi. Composition delinmiş olurdu
    }

    public void offset(int dxy) //delegate method
    {
        offset(dxy, dxy);
    }

    public void offset(int dx, int dy) //delegate method
    {
        m_center.offset(dx, dy);
    }

    public double radiusDistance(AnalyticalCircle analyticalCircle)
    {
        return m_center.distance(analyticalCircle.m_center);
    }
}
```
### Point sınıfı 
```java
/*----------------------------------------------------------------------------------------------------------------------
	Point sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math.geometry;

import static java.lang.Math.sqrt;

public class Point {
	public int x;
	public int y;

	Point(Point point)
	{
		x = point.x;
		y = point.y;
	}

	public Point()
	{
	}

	public Point(int a)
	{
		x = a;
	}

	public Point(int a, int b)
	{
		x = a;
		y = b;
	}

	public double distance(Point p)
	{
		return distance(p.x, p.y);
	}

	public double distance(int a, int b)
	{
		return sqrt((x - a) * (x - a) + (y - b) * (y - b));
	}

	public void offset(int dxy)
	{
		offset(dxy, dxy);
	}

	public void offset(int dx, int dy)
	{
		x += dx;
		y += dy;
	}

	public String toString()
	{
		return String.format("{x: %d, y: %d}", x, y);
	}
}
```
### Time sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Time sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.datetime.Time;

class App {
	public static void main(String [] args)
	{
		Time time = new Time(15, 29);

		System.out.println(time.toShortTimeString());
		System.out.println(time.toLongTimeString());
		System.out.println(time.toString());
	}
}
```
### Time sınıfı
```java
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

    public Time(int hour, int minute)
    {
        this(hour, minute, 0);
    }

    public Time(int hour, int minute, int second)
    {
        this(hour, minute, second, 0);
    }

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
```
### Date sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Date sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.datetime.Date;
import org.csystem.util.datetime.Month;

class App {
	public static void main(String [] args)
	{
		Date date = new Date(19, Month.SEP, 2020);

		System.out.println(date.toStringTR());
		System.out.println(date.toStringEN());
		System.out.println(date.toLongDateStringTR());
		System.out.println(date.toLongDateStringEN());
	}
}
```
### Date sınıfı
```java
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
        this(day, month.ordinal() + 1, year);
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

```
### Aralarında türetme ilişkisi olmayan iki sınıf türünden referans birbirine tür dönüştürme operatörü kullanılarak bile atanamaz
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aralarında türetme ilişkisi olmayan iki sınıf türünden referans birbirine tür dönüştürme operatörü kullanılarak
	bile atanamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		A x = new A();
		B y;

		y = (B)x;
	}
}


class B {

}

class A {

}
```
### yukarıya doğru dönüşüm (upcasting)
```java
/*----------------------------------------------------------------------------------------------------------------------
	Türemiş sınıf türünden bir referans taban sınıf türünden bir referansa doğrudan (implicit) atanabilir. Buna
	yukarıya doğru dönüşüm (upcasting) denir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		B x = new B();
		A y;

		y = x; //upcasting
	}
}


class B extends A {

}

class A {

}
```
### Yukarıya doğru dönüşümde taban sınıf referansına türemiş sınıf referansına ilişkin nesnenin taban sınıf bölümünün adresi atanır.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıya doğru dönüşümde taban sınıf referansına türemiş sınıf referansına ilişkin nesnenin taban sınıf bölümünün
	adresi atanır.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		B x = new B();
		A y;

		x.a = 20;
		x.b = 30;

		y = x;

		System.out.printf("y.a=%d%n", y.a);
		System.out.printf("x.a=%d%n", x.a);
	}
}


class B extends A {
	public int b;
	//...
}

class A {
	public int a;
	//...
}
```
### Aşağıdaki örnekte doWork metodu yalnızca A sınıfına bağımlı (dependency) olarak yazılmıştır.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte doWork metodu yalnızca A sınıfına bağımlı (dependency) olarak yazılmıştır. Bu metot A sınıfından
	doğrudan ya da dolaylı olarak türetilen her sınıf için çağrılabilmektedir. Yani doWork metodu derleme zamanında
	yalnızca A ismini bilmek zorundadır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Sample s = new Sample();
		A x = new A();
		B y = new B();
		C z = new C();
		D t = new D();

		x.a = 10;
		y.a = 34;
		z.a = 12;
		t.a = 78;

		s.doWork(x);
		s.doWork(y);
		s.doWork(z);
		s.doWork(t);
	}
}

class Sample {
	public void doWork(A x)
	{
		System.out.printf("a=%d%n", x.a);
	}
}

class D extends A {
	//..
}

class C extends B {
	//..
}

class B extends A {
	public int b;
	//...
}

class A {
	public int a;
	//...
}
```
### CompanyApp uygulaması
```java
/*----------------------------------------------------------------------------------------------------------------------
	20.09.2020
	CompanyApp uygulaması (Detaylar gözardı edilmiştir)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.companyapp.CompanyApp;

class App {
	public static void main(String [] args)
	{
		CompanyApp.run();
	}
}

package org.csystem.app.samples.companyapp;

public class CompanyApp {
    private CompanyApp()
    { }

    public static void run()
    {
        Worker worker = new Worker("12345678124", "Ali", "mecidiyeköy", 6, 100);
        Manager manager = new Manager("98765432154", "Veli", "Şişli", 20000, "Pazarlama");
        SalesManager salesManager = new SalesManager("12678654322", "Selami", "Fulya", 30000, "Pazarlama", 10000);
        HumanResources humanResources = new HumanResources();

        humanResources.payInsurance(worker);
        humanResources.payInsurance(manager);
        humanResources.payInsurance(salesManager);
    }
}

package org.csystem.app.samples.companyapp;

public class HumanResources {
    public void payInsurance(Employee employee)
    {
        System.out.printf("CitizenId:%s%n", employee.getCitizenId());
        System.out.printf("Name:%s%n", employee.getName());
        //...
    }
    //...
}


package org.csystem.app.samples.companyapp;

public class Employee {
    private String m_citizenId;
    private String m_name;
    private String m_address;
    //...

    public Employee(String citizenId, String name, String address)
    {
        //...
        m_citizenId = citizenId;
        m_name = name;
        m_address = address;
    }

    public String getCitizenId()
    {
        return m_citizenId;
    }

    public void setCitizenId(String citizenId)
    {
        m_citizenId = citizenId;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public String getAddress()
    {
        return m_address;
    }

    public void setAddress(String address)
    {
        m_address = address;
    }
    //...
}

package org.csystem.app.samples.companyapp;

public class Worker extends Employee {
    private int m_hourPerDay;
    private double m_feePerHour;

    public Worker(String citizenId, String name, String address, int hourPerDay, double feePerHour)
    {
        super(citizenId, name, address);
        //...
        m_hourPerDay = hourPerDay;
        m_feePerHour = feePerHour;
    }

    public int getHourPerDay()
    {
        return m_hourPerDay;
    }

    public void setHourPerDay(int hourPerDay)
    {
        m_hourPerDay = hourPerDay;
    }

    public double getFeePerHour()
    {
        return m_feePerHour;
    }

    public void setFeePerHour(double feePerHour)
    {
        m_feePerHour = feePerHour;
    }
}


package org.csystem.app.samples.companyapp;

public class Manager extends Employee {
    private double m_salary;
    private String m_department;

    public Manager(String citizenId, String name, String address, double salary, String department)
    {
        super(citizenId, name, address);
        m_salary = salary;
        m_department = department;
    }

    public double getSalary()
    {
        return m_salary;
    }

    public void setSalary(double salary)
    {
        m_salary = salary;
    }

    public String getDepartment()
    {
        return m_department;
    }

    public void setDepartment(String department)
    {
        m_department = department;
    }
}


package org.csystem.app.samples.companyapp;

public class SalesManager extends Manager {
    private double m_extra;

    public SalesManager(String citizenId, String name, String address, double salary, String department, double extra)
    {
        super(citizenId, name, address, salary, department);
        m_extra = extra;
    }

    public double getExtra()
    {
        return m_extra;
    }

    public void setExtra(double extra)
    {
        m_extra = extra;
    }
}
```
### Static ve Dinamik referans türleri
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir referansın iki tane türü vardır: statik, dinamik
	- statik türü (static type): Bir referansın static türü o referansın bildirildiği türdür. "Referansın türü" dendiğinde
	static tür anlaşılır. Derleme zamanına ilişkin bir bilgidir ve değişmez

	- dinamik tür (dynamic type): Bir referansın dinamik türü o referansın gösterdiği nesnenin bellekte yaratıldığı
	türdür (gerçek türüdür). Çalışma zamnına ilişkin bir bilgidir ve değişebilir

	Anahtar Notlar: Bir referansın dinamik türü String olarak aşağıdaki şekilde elde edilebilir:
		<referans>.getClass().getName();
	Buna göre x bir referans ise x referansının dinamik türü ekrana şu şekilde yazdırılabilir:
		System.out.println(x.getClass().getName());
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		A x = new A(); //x'in static  türü A, dinamik türü A
		B y = new B(); //y'in static  türü B, dinamik türü B

		System.out.println(x.getClass().getName());
		System.out.println(y.getClass().getName());
		x = y; //x'in static  türü A, dinamik B

		System.out.println(x.getClass().getName());
		System.out.println(y.getClass().getName());
	}
}

class B extends A {

}

class A {

}
```
### Aşağıdaki örnekte x'in dinamik türünün değişimi gösterilmiştir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte x'in dinamik türünün değişimi gösterilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());

		A x;

		x = val > 0 ? new A() : new B();

		System.out.println(x.getClass().getName());
	}
}

class B extends A {

}

class A {

}
```
### Aşağıdaki örnekte x'in dinamik türünün değişimi gösterilmiştir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte x'in dinamik türünün değişimi gösterilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());

		A x;

		if (val > 0)
			x = new C();
		else if (val == 0)
			x = new B();
		else
			x = new A();

		System.out.println(x.getClass().getName());
	}
}

class C extends A {

}

class B extends A {

}

class A {

}
```
### Aşağıdaki örnekte z'nin dinamik türü C olmuştur
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte z'nin dinamik türü C olmuştur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		C x = new C();
		B y;
		A z;

		y = x;
		System.out.println(y.getClass().getName()); //org.csystem.app.C
		z = y;
		System.out.println(z.getClass().getName()); //org.csystem.app.C
	}
}

class C extends B {

}

class B extends A {

}

class A {

}
```
### ir dizi referansının dinamik türü JNI (Java Native Interface) tür ismi olarak yazdırılır. 
```java
/*----------------------------------------------------------------------------------------------------------------------
	Anahtar Notlar: Bir dizi referansının dinamik türü JNI (Java Native Interface) tür ismi olarak
	yazdırılır. Bu isim arakoddaki tür ismidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int [] a = new int[4];
		double [] b = new double[5];

		System.out.println(a.getClass().getName());
		System.out.println(b.getClass().getName());
	}
}
```
### Aşağıya doğru dönüşüm(downcasting), haklı ve haksız dönüşüm kavramları
```java
/*----------------------------------------------------------------------------------------------------------------------
	Taban sınıf türünden bir referans türemiş sınıf türünden bir referansa doğrudan atanamaz. Bu işlem
	tür dönüştürme operatörü ile (explicit) atanabilir. Burada tür dönüştürme derlemeden geçmek içindir.
	Çalışma zamanı sırasında kaynak referansın dinamik türünün tür dönüştürme operatörüne yazılan türü
	kapsayıp kapsamadığına bakılır. Kapsıyorsa haklı dönüşümdür. Kapsamıyorsa haksız dönüşümdür ve
	exception oluşur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());

		A x;
		B y;

		x = val > 0 ? new A() : new B();

		y = (B)x; //downcasting

		System.out.println("Tekrar yapıyor musunuz?");

		y.a = 10;
		y.b = 30;
	}
}


class B extends A {
	public int b;
}

class A {
	public int a;
}
```
### downcasting işlemi
```java
/*----------------------------------------------------------------------------------------------------------------------
	downcasting işlemi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());

		A x;
		B y;

		if (val > 0)
			x = new C();
		else if (val == 0)
			x = new B();
		else
			x = new A();

		System.out.println(x.getClass().getName());
		y = (B)x; //downcasting
		System.out.println(y.getClass().getName());
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class C extends B {
	//...
}

class B extends A {
	//...
}

class A {
	//...
}

```
### Object sınıfı her sınıfın doğrudan ya da dolaylı olarak taban sınıfı olduğundan her türden referans Object referansına atanabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Object sınıfı her sınıfın doğrudan ya da dolaylı olarak taban sınıfı olduğundan her türden referans
	Object referansına atanabilir. Aşağıdaki örnekte çeşitli türler için Object kullanarak upcasting
	yapılmış ve downcasting ile dinamik türlere ilişkin referanslara atama yapılmıştır. Şüphesiz downcasting
	işleminde dinamik tür bilinmeden yapılması durumu exception fırlatılmasına yol açabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.datetime.Date;

import java.util.Random;

class App {
	public static void main(String [] args)
	{
		Object os = "ankara";
		Object or = new Random();
		Object oia = new int[10];
		Object od = new Date();

		System.out.println(os.getClass().getName());
		System.out.println(or.getClass().getName());
		System.out.println(oia.getClass().getName());

		String s = (String)os;
		Random r = (Random)or;
		int [] a = (int[])oia;
		Date date = (Date)od;

		System.out.println(s.toUpperCase());
		System.out.println(r.nextInt());
		System.out.println(a[0]);
		System.out.println(date.toLongDateStringTR());
	}
}
```
### Aşağdaki örnekte Object dizisinin referanslarının dinamik türüne göre downcasting yapılmıştır.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağdaki örnekte Object dizisinin referanslarının dinamik türüne göre downcasting yapılmıştır.
	Ancak dinamik tür bilgisi (RTTI (Run Time Type Information) tür isminden elde edilmiştir. Programcının
	tür ismini yanlış yazma olasılığı vardır. Ayrıca yazı karşılaştırma işlemleri göreceli yavaştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.randomgenerator.RandomObjectArrayGeneratorApp;

class App {
	public static void main(String [] args)
	{
		RandomObjectArrayGeneratorApp.run();
	}
}

package org.csystem.app.samples.randomgenerator;

import org.csystem.util.ArrayUtil;
import org.csystem.util.IntValue;
import org.csystem.util.datetime.Date;
import org.csystem.util.datetime.Time;

public class RandomObjectArrayGeneratorApp {
    private RandomObjectArrayGeneratorApp()
    {}

    public static void run()
    {
        RandomObjectArrayGenerator randomObjectArrayGenerator = new RandomObjectArrayGenerator(5);

        randomObjectArrayGenerator.run();

        for (Object object : randomObjectArrayGenerator.getObjects()) {
            String typeName = object.getClass().getName();

            System.out.printf("Dinamik tür ismi:%s%n", typeName);

            if (typeName.equals("java.lang.String")) {
                String s = (String)object;

                System.out.printf("Yazı:%s%n", s);
                System.out.printf("Yazı:%s%n", s.toUpperCase());
            }
            else if (typeName.equals("org.csystem.util.IntValue")) {
                IntValue intValue = (IntValue)object;
                int val = intValue.getVal();

                System.out.printf("%d * %d = %d%n", val, val, val * val);
            }
            else if (typeName.equals("org.csystem.util.datetime.Date")) {
                Date date = (Date)object;

                System.out.println(date.toLongDateStringTR());
            }
            else if (typeName.equals("org.csystem.util.datetime.Time")) {
                Time time = (Time)object;

                System.out.println(time.toLongTimeString());
            }
            else if (typeName.equals("[I")) {
                int [] a = (int[])object;

                ArrayUtil.display(3, a);
            }
        }
    }
}

```
### Aşağdaki örnekte programcının tür ismini yanlış yazma olasılığı neredeyse kalmasa da hala yazı karşılaştırması yapılmaktadır
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağdaki örnekte programcının tür ismini yanlış yazma olasılığı neredeyse kalmasa da hala yazı karşılaştırması
	yapılmaktadır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.randomgenerator.RandomObjectArrayGeneratorApp;

class App {
	public static void main(String [] args)
	{
		RandomObjectArrayGeneratorApp.run();
	}
}

package org.csystem.app.samples.randomgenerator;

import org.csystem.util.ArrayUtil;
import org.csystem.util.IntValue;
import org.csystem.util.datetime.Date;
import org.csystem.util.datetime.Time;

public class RandomObjectArrayGeneratorApp {
    private RandomObjectArrayGeneratorApp()
    {}

    public static void run()
    {
        RandomObjectArrayGenerator randomObjectArrayGenerator = new RandomObjectArrayGenerator(5);

        randomObjectArrayGenerator.run();

        for (Object object : randomObjectArrayGenerator.getObjects()) {
            String typeName = object.getClass().getName();

            System.out.printf("Dinamik tür ismi:%s%n", typeName);

            if (typeName.equals(TypeInfo.STRING)) {
                String s = (String)object;

                System.out.printf("Yazı:%s%n", s);
                System.out.printf("Yazı:%s%n", s.toUpperCase());
            }
            else if (typeName.equals(TypeInfo.INT_VALUE)) {
                IntValue intValue = (IntValue)object;
                int val = intValue.getVal();

                System.out.printf("%d * %d = %d%n", val, val, val * val);
            }
            else if (typeName.equals(TypeInfo.DATE)) {
                Date date = (Date)object;

                System.out.println(date.toLongDateStringTR());
            }
            else if (typeName.equals(TypeInfo.TIME)) {
                Time time = (Time)object;

                System.out.println(time.toLongTimeString());
            }
            else if (typeName.equals(TypeInfo.INT_ARRAY)) {
                int [] a = (int[])object;

                ArrayUtil.display(3, a);
            }
        }
    }
}

package org.csystem.app.samples.randomgenerator;

public class TypeInfo {
    private TypeInfo()
    {}
    public static final String STRING = "java.lang.String";
    public static final String INT_VALUE = "org.csystem.util.IntValue";
    public static final String DATE = "org.csystem.util.datetime.Date";
    public static final String TIME = "org.csystem.util.datetime.Time";
    public static final String INT_ARRAY = "[I";
}
```
### instanceof operatörü iki operandlı (binary), araek (infix) bir operatördür.
```java
/*----------------------------------------------------------------------------------------------------------------------
	instanceof operatörü iki operandlı (binary), araek (infix) bir operatördür. instanceof operatörünün birinci
	operandı bir referans olmalıdır. İkinci operandı ise bir referans tür ismi olmalıdır. Bu operatörün ürettiği
	değer boolean türdendir. Operatör birinci operandına ilişkin referansın dinamik türü ikinci operandına ilişkin
	türü kapsıyorsa true, kapsamıyorsa false değerini üretir. Özellikle downcasting yapılacağı durumda tür kontrolü
	için kullanılır
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte instanceof operatörü kullanılarak hem okunabilirlik artırılmış, hem yazı içerisinde hata yapma
	olasılığı ortadan kaldırılmış hem de karşılaştırma işlemi daha etkin hale getirilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.randomgenerator.RandomObjectArrayGeneratorApp;

class App {
	public static void main(String [] args)
	{
		RandomObjectArrayGeneratorApp.run();
	}
}

package org.csystem.app.samples.randomgenerator;

import org.csystem.util.ArrayUtil;
import org.csystem.util.IntValue;
import org.csystem.util.datetime.Date;
import org.csystem.util.datetime.Time;

public class RandomObjectArrayGeneratorApp {
    private RandomObjectArrayGeneratorApp()
    {}

    public static void run()
    {
        RandomObjectArrayGenerator randomObjectArrayGenerator = new RandomObjectArrayGenerator(5);

        randomObjectArrayGenerator.run();

        for (Object object : randomObjectArrayGenerator.getObjects()) {
            System.out.printf("Dinamik tür ismi:%s%n", object.getClass().getName());

            if (object instanceof String) {
                String s = (String)object;

                System.out.printf("Yazı:%s%n", s);
                System.out.printf("Yazı:%s%n", s.toUpperCase());
            }
            else if (object instanceof IntValue) {
                IntValue intValue = (IntValue)object;
                int val = intValue.getVal();

                System.out.printf("%d * %d = %d%n", val, val, val * val);
            }
            else if (object instanceof Date) {
                Date date = (Date)object;

                System.out.println(date.toLongDateStringTR());
            }
            else if (object instanceof Time) {
                Time time = (Time)object;

                System.out.println(time.toLongTimeString());
            }
            else if (object instanceof int []) {
                int [] a = (int[])object;

                ArrayUtil.display(3, a);
            }
        }
    }
}

package org.csystem.app.samples.randomgenerator;

import org.csystem.util.ArrayUtil;
import org.csystem.util.IntValue;
import org.csystem.util.StringUtil;
import org.csystem.util.datetime.Date;
import org.csystem.util.datetime.Time;

import java.util.Random;

public class RandomObjectArrayGenerator {
    private final Random m_random;
    private final Object [] m_objects;

    private Object getRandomObject()
    {
        int val = m_random.nextInt(5);

        Object object;

        switch (val) {
            case 0:
                object = StringUtil.getRandomTextTR(m_random.nextInt(15) + 1);
                break;
            case 1:
                object = IntValue.of(m_random.nextInt(255) - 128);
                break;
            case 2:
                object = Date.randomDate(m_random);
                break;
            case 3:
                object = Time.randomTime(m_random);
                break;
            default:
                object = ArrayUtil.getRandomArray(m_random, 10, 0, 256);
        }

        return object;
    }

    public RandomObjectArrayGenerator(int n)
    {
        m_random = new Random();
        m_objects = new Object[n];
    }

    public Object [] getObjects()
    {
        return m_objects;
    }

    public void run()
    {
        for (int i = 0; i < m_objects.length; ++i)
            m_objects[i] = getRandomObject();
    }
}
```
### instanceof operatörü ikinci operandına ilişkin türü kapsayıp kapsamadığına bakar
```java
/*----------------------------------------------------------------------------------------------------------------------
	instanceof operatörü ikinci operandına ilişkin türü kapsayıp kapsamadığına bakar
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());

		A x = Sample.getAByValue(val);

		if (x instanceof B)
			((B)x).foo();
		else
			System.out.println("foo metodu çağrılamaz");
	}
}

class Sample {
	//...
	public static A getAByValue(int val)
	{
		A x;

		if (val > 0)
			x = new C();
		else if (val == 0)
			x = new B();
		else
			x = new A();

		return x;
	}
}

class C extends B {

}

class B extends A {
	public void foo()
	{
		System.out.println("B.foo");
	}
}

class A {

}

```
### Sarmalayan Sınıflar (wrapper classes)
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sarmalayan Sınıflar (wrapper classes): Java'da her temel (built-in) türe karşılık bir sınıf getirilmiştir. Bunun
	nedeni bu sınıfları tanıdıkça anlaşılacaktır. Bu sınıflar sarmalamanın dışında ilgili türe ilişkin yardımcı
	elemanları da barındırırlar. Örneğin Integer sınıfının parseInt metodu bir yazıdan (String) int türden bir değer
	elde etmek için kullanılır. Temel türlere ilişkin sarmalayan sınıflar aşağıdaki gibidir:

	Temel Tür				Sarmalayan Sınıf İsmi
	----------------------------------------------
	short						Short
	int							Integer
	long						Long
	byte						Byte
	double						Double
	float						Float
	char						Character
	boolean						Boolean

	Bu türlerden tamsayı ve gerçek sayı türlerine ilişkin sınıflara nümerik sarmalayan sınıf denebilir.
	Bu sınıflara ilişkin temel özellikler şunlardır:
	- Tamsayı ve gerçek sayı türlerine ilişkin sınıflar (Short, Integer, Long, Byte, Float, Double) Number isimli bir sınıftan
	türetilmiştir. Number sınıfı java.lang paketi içerisindedir. Number sınıfının metotları ileride ele alınacaktır.

	- Sarmalayan sınıflar immutable'dır.

	- Bu sınıflar temel türden değerin heap de tutulması için kullanılır. Bu kavrama kutulama (boxing) denir. Bu konu
	ileride ele alınacaktır.

	- Java 9 ile birlikte sarmalayan sınıfların ctor'ları depracated olmuştur. Java 5 den itibaren zaten kullanılmayan
	bu ctor'lar artık hiç kullanılmamalıdır. Bunun nedeni ileride ele alınacaktır
----------------------------------------------------------------------------------------------------------------------*/
```
### sarmalayan sınıfların MIN_VALUE ve MAX_VALUE isimli final static veri elemanları
```java
/*----------------------------------------------------------------------------------------------------------------------
	Tamsayı, gerçek sayı ve char türlerine ilişkin sarmalayan sınıfların MIN_VALUE ve MAX_VALUE isimli final static
	veri elemanları vardır. Bu elemanlar ilişkin oldukları temel türdendir. Double ve Float sınıflarının MIN_VALUE
	değerlerinin pozitif olduğuna dikkat ediniz. Bu durum IEEE 754 formatına ilişkindir. double ve float türleri
	için sınırlar aşağıdaki gibi -+ biçimindedir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		System.out.printf("short:[%d, %d]%n", Short.MIN_VALUE, Short.MAX_VALUE);
		System.out.printf("int:[%d, %d]%n", Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.printf("long:[%d, %d]%n", Long.MIN_VALUE, Long.MAX_VALUE);
		System.out.printf("byte:[%d, %d]%n", Byte.MIN_VALUE, Byte.MAX_VALUE);
		System.out.printf("char:[%d, %d]%n", (int)Character.MIN_VALUE, (int)Character.MAX_VALUE);
		System.out.printf("double:[-+%.325f, -+%f]%n", Double.MIN_VALUE, Double.MAX_VALUE);
		System.out.printf("float:[-+%.325f, -+%f]%n", Float.MIN_VALUE, Float.MAX_VALUE);
	}
}
```
### sarmalayan sınıfların SIZE isimli final ve static veri elemanları
```java
/*----------------------------------------------------------------------------------------------------------------------
	Boolean sınıfı haricindeki tüm sarmalayan sınıfların SIZE isimli final ve static veri elemanları ilgili
	temel türün bit cinsinden uzunluk bilgisini tutar. Bu eleman okunabilirliği artırmak için ilgili türün
	uzunluğu gerektiğinde kullanılabilir. Java' da temel türlerin uzunluğu sistemden sisteme değişmeyeceğinden
	doğrudan sayısal değerleri de kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		System.out.printf("sizeof(short)=%d bits%n", Short.SIZE);
		System.out.printf("sizeof(int)=%d bits%n", Integer.SIZE);
		System.out.printf("sizeof(long)=%d bits%n", Long.SIZE);
		System.out.printf("sizeof(byte)=%d bits%n", Byte.SIZE);
		System.out.printf("sizeof(char)=%d bits%n", Character.SIZE);
		System.out.printf("sizeof(double)=%d bits%n", Double.SIZE);
		System.out.printf("sizeof(float)=%d bits%n", Float.SIZE);
	}

}
```
### sarmalayan sınıfların BYTES isimli final ve static veri elemanları
```java
/*----------------------------------------------------------------------------------------------------------------------
	Boolean sınıfı haricindeki tüm sarmalayan sınıfların BYTES isimli final ve static veri elemanları ilgili
	temel türün byte cinsinden uzunluk bilgisini tutar. Bu eleman okunabilirliği artırmak için ilgili türün
	uzunluğu gerektiğinde kullanılabilir. Java' da temel türlerin uzunluğu sistemden sisteme değişmeyeceğinden
	doğrudan sayısal değerleri de kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		System.out.printf("sizeof(short)=%d Bytes%n", Short.BYTES);
		System.out.printf("sizeof(int)=%d Bytes%n", Integer.BYTES);
		System.out.printf("sizeof(long)=%d Bytes%n", Long.BYTES);
		System.out.printf("sizeof(byte)=%d Bytes%n", Byte.BYTES);
		System.out.printf("sizeof(char)=%d Bytes%n", Character.BYTES);
		System.out.printf("sizeof(double)=%d Bytes%n", Double.BYTES);
		System.out.printf("sizeof(float)=%d Bytes%n", Float.BYTES);
	}

}
```
### nümeric türlerin parseXXX metotları ile bir yazıdan ilgili türe ilişkin değer elde edilebilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bilindiği gibi nümeric türlerin parseXXX metotları ile bir yazıdan ilgili türe ilişkin değer elde edilebilir.
	Character sınıfı dışında tüm sarmalayan sınıfların parseXXX metotları vardır. Boolean sınıfı dışındaki tüm
	sarmalayan sınıfların pareXXX metotları yazıyı ilgili türe çeviremezse exception fırlatır. Boolean metodunun
	parseBoolean metodu çeviremedği bir yazı için false değerini döndürür. Yani kısaca parseBoolean metodu büyük-küçüğk
	harf duyarsız bir biçimde yazının true olması durumunda true değerini, diğer tüm yazılar için false değerini
	döndürür
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("true veya false giriniz:");
		boolean flag = Boolean.parseBoolean(kb.nextLine());

		System.out.printf("flag=%b%n", flag);
	}
}
```
### Integer sınıfının radix (sayı sistemi) parametreli parseInt metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Integer sınıfının radix (sayı sistemi) parametreli parseInt metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Sayı sistemini giriniz:");
		int radix = Integer.parseInt(kb.nextLine());

		System.out.printf("%d sayı sistemine uygun bir sayı giriniz:", radix);
		int val = Integer.parseInt(kb.nextLine(), radix);

		System.out.printf("val=%d%n", val);
	}
}
```
### Aşağıdaki örnekte substring ve parseInt metotları kullanılarak yazı içerisindeki not bilgisi elde edilmiştir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte substring ve parseInt metotları kullanılarak yazı içerisindeki not bilgisi elde edilmiştir.
	Format geçerlilik kontrolü yapılmamıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		String [] notesInfo = {
				"Oğuz Karan\0:78:\0Matematik\0vize",
				"Ali Serçe\0:100:\0Fizik\0final",
				"Güray Sönmez\0:79:\0Kimya\0vize"
		};

		int sum = 0;

		for (String noteInfo : notesInfo) {
			int firstNullCharacterIndex = noteInfo.indexOf('\0');

			//...
			int secondNullCharacterIndex = noteInfo.indexOf('\0', firstNullCharacterIndex + 2);
			//...

			String strNote = noteInfo.substring(firstNullCharacterIndex + 2, secondNullCharacterIndex - 1);

			int note = Integer.parseInt(strNote);

			System.out.printf("%d ", note);
			sum += note;
		}

		System.out.printf("%nOrtalama:%f%n", (double)sum / notesInfo.length);
	}
}

```
### Yuklarıdaki örnekte indeksler bulundak sonra sayıya çevirme işlemi Java 9 ile birlikte eklenen parseInt metodu ile çok daha kolay bir biçimde yapılabilir. 
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yuklarıdaki örnekte indeksler bulundak sonra sayıya çevirme işlemi Java 9 ile birlikte eklenen parseInt
	metodu ile çok daha kolay bir biçimde yapılabilir. Format geçerlilik kontrolü yapılmamıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		String [] notesInfo = {
				"Oğuz Karan\0:78:\0Matematik\0vize",
				"Ali Serçe\0:100:\0Fizik\0final",
				"Güray Sönmez\0:79:\0Kimya\0vize"
		};

		int sum = 0;

		for (String noteInfo : notesInfo) {
			int firstNullCharacterIndex = noteInfo.indexOf('\0');
			//...
			int secondNullCharacterIndex = noteInfo.indexOf('\0', firstNullCharacterIndex + 2);
			//...
			int note = Integer.parseInt(noteInfo, firstNullCharacterIndex + 2, secondNullCharacterIndex - 1, 10); //Since Java 9

			System.out.printf("%d ", note);
			sum += note;
		}

		System.out.printf("%nOrtalama:%f%n", (double)sum / notesInfo.length);
	}
}



/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/
```
