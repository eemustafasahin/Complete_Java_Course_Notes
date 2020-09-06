### Rational sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	05.09.2020
	Rational sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.Rational;

class App {
	public static void main(String [] args)
	{
		Rational r = new Rational(-3, -4);

		System.out.println(r.toString());
	}
}
```
### Rational sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Rational sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.Rational;

class App {
	public static void main(String [] args)
	{
		Rational r = new Rational(3, -4);

		System.out.println(r.toString());
	}
}
```
### Rational sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Rational sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.Rational;

class App {
	public static void main(String [] args)
	{
		Rational r = new Rational(3, 0);

		System.out.println(r.toString());
	}
}
```
### Rational sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Rational sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.Rational;

class App {
	public static void main(String [] args)
	{
		Rational r = new Rational(0, 0);

		System.out.println(r.toString());
	}
}
```
### Rational sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Rational sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.Rational;

class App {
	public static void main(String [] args)
	{
		Rational r = new Rational(6, -14);

		System.out.println(r.toString());

		r.setNumerator(0);

		System.out.println(r.toString());

		r.setNumerator(23);

		System.out.println(r.toString());
	}
}
```
### Rational sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Rational sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.Rational;

class App {
	public static void main(String [] args)
	{
		Rational r = new Rational(6, -14);

		System.out.println(r.toString());

		r.setNumerator(0);

		System.out.println(r.toString());

		r.setDenominator(23);

		System.out.println(r.toString());
	}
}
```
### Rational sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Rational sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.Rational;

class App {
	public static void main(String [] args)
	{
		Rational r1 = new Rational(3, 4);
		Rational r2 = new Rational(-8, 7);
		Rational r;

		r = r1.add(r2);

		System.out.println(r.toString());

		r = r1.add(3);

		System.out.println(r.toString());

		r = Rational.add(3, r1);

		System.out.println(r.toString());
	}
}
```
### Rational sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Rational sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.Rational;

class App {
	public static void main(String [] args)
	{
		Rational r1 = new Rational(3, 4);
		Rational r2 = new Rational(-8, 7);
		Rational r;

		r = r1.subtract(r2);

		System.out.println(r.toString());

		r = r1.subtract(3);

		System.out.println(r.toString());

		r = Rational.subtract(3, r1);

		System.out.println(r.toString());
	}
}
```
### Rational sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Rational sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.Rational;

class App {
	public static void main(String [] args)
	{
		Rational r1 = new Rational(3, 4);
		Rational r2 = new Rational(-8, 7);
		Rational r;

		r = r1.multiply(r2);

		System.out.println(r.toString());

		r = r1.multiply(3);

		System.out.println(r.toString());

		r = Rational.multiply(3, r1);

		System.out.println(r.toString());
	}
}
```
### Rational sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Rational sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.Rational;

class App {
	public static void main(String [] args)
	{
		Rational r1 = new Rational(3, 4);
		Rational r2 = new Rational(-8, 7);
		Rational r;

		r = r1.divide(r2);

		System.out.println(r.toString());

		r = r1.divide(3);

		System.out.println(r.toString());

		r = Rational.divide(3, r1);

		System.out.println(r.toString());
	}
}
```
### Rational sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Rational sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.Rational;

class App {
	public static void main(String [] args)
	{
		Rational r1 = new Rational();
		Rational r2 = new Rational();
		Rational r;

		r = r2.divide(r1);

		System.out.println(r.toString());
	}
}
```
### Rational sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Rational sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.Rational;

class App {
	public static void main(String [] args)
	{
		Rational r = new Rational(3, 4);

		System.out.println(r.toString());

		r.increment();
		System.out.println(r.toString());
	}
}
```
### Rational sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Rational sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.Rational;

class App {
	public static void main(String [] args)
	{
		Rational r = new Rational(3, 4);

		System.out.println(r.toString());

		r.decrement();
		System.out.println(r.toString());
	}
}
```
### Rational sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
	Rational sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math;

public class Rational {
    private int m_a;
    private int m_b;

    private static Rational add(int a1, int b1, int a2, int b2)
    {
        return new Rational(a1 * b2 + a2 * b1, b1 * b2);
    }

    private static Rational subtract(int a1, int b1, int a2, int b2)
    {
        return add(a1, b1, -a2, b2);
    }

    private static Rational multiply(int a1, int b1, int a2, int b2)
    {
        return new Rational(a1 * a2, b1 * b2);
    }

    private static Rational divide(int a1, int b1, int a2, int b2)
    {
        return multiply(a1, b1, b2, a2);
    }

    private static void check(int a, int b)
    {
        if (b == 0) {
            if (a == 0)
                System.out.println("Belirsiz");
            else
                System.out.println("Tanımsız");

            System.exit(-1); //Exception işlemlerine kadar sabredin
        }
    }

    private void simplify()
    {
        int min = Math.min(Math.abs(m_a), m_b);

        for (int i = min; i >= 2; --i)
            if (m_a % i == 0 && m_b % i == 0) {
                m_a /= i;
                m_b /= i;
                break;
            }
    }

    private void configureSign()
    {
        if (m_b < 0) {
            m_a = -m_a;
            m_b = -m_b;
        }
    }

    private void set(int a, int b)
    {
        if (a == 0) {
            m_a = 0;
            m_b = 1;
            return;
        }
        m_a = a;
        m_b = b;
        configureSign();
        simplify();
    }

    public Rational()
    {
        m_b = 1;
    }

    public Rational(int a)
    {
        m_a = a;
        m_b = 1;
    }

    public Rational(int a, int b)
    {
        check(a, b);
        set(a, b);
    }

    public int getNumerator()
    {
        return m_a;
    }

    public void setNumerator(int val)
    {
        if (val == m_a)
            return;

        set(val, m_b);
    }

    public void setDenominator(int val)
    {
        if (val == m_b)
            return;

        check(m_a, val);
        set(m_a, val);
    }

    public int getDenominator()
    {
        return m_b;
    }

    public double getRealValue()
    {
        return  (double) m_a / m_b;
    }

    //add
    public Rational add(Rational r)
    {
        return add(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational add(int val)
    {
        return add(m_a, m_b, val, 1);
    }

    public static Rational add(int val, Rational r)
    {
        return add(val, 1, r.m_a, r.m_b);
    }

    //subtract
    public Rational subtract(Rational r)
    {
        return subtract(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational subtract(int val)
    {
        return subtract(m_a, m_b, val, 1);
    }

    public static Rational subtract(int val, Rational r)
    {
        return subtract(val, 1, r.m_a, r.m_b);
    }

    //multiply
    public Rational multiply(Rational r)
    {
        return multiply(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational multiply(int val)
    {
        return multiply(m_a, m_b, val, 1);
    }

    public static Rational multiply(int val, Rational r)
    {
        return multiply(val, 1, r.m_a, r.m_b);
    }

    //divide
    public Rational divide(Rational r)
    {
        return divide(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational divide(int val)
    {
        return divide(m_a, m_b, val, 1);
    }

    public static Rational divide(int val, Rational r)
    {
        return divide(val, 1, r.m_a, r.m_b);
    }

    //increment
    public void increment(int val)
    {
        m_a += m_b * val;
    }

    public void increment()
    {
        increment(1);
    }

    //decrement
    public void decrement(int val)
    {
        increment(-val);
    }

    public void decrement()
    {
        decrement(1);
    }

    public String toString()
    {
        return String.format("%d / %d = %f", m_a, m_b, getRealValue());
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

class App {
	public static void main(String [] args)
	{
		Date d = new Date(29, 2, 2019);

		System.out.println(d.getDayOfWeekTR());
		System.out.println(d.getDayOfWeekEN());
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

class App {
	public static void main(String [] args)
	{
		Date d = new Date(5, 9, 2020);

		System.out.println(d.getDayOfWeekTR());
		System.out.println(d.getDayOfWeekEN());

		d.setDay(31);

		System.out.println(d.getDayOfWeekTR());
		System.out.println(d.getDayOfWeekEN());
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

class App {
	public static void main(String [] args)
	{
		Date d = new Date(5, 9, 2020);

		System.out.println(d.isLeapYear() ? "Artık yıl" : "Artık yıl değil");

		d.setYear(2019);

		System.out.println(d.isLeapYear() ? "Artık yıl" : "Artık yıl değil");
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

class App {
	public static void main(String [] args)
	{
		Date d = new Date(5, 9, 2020);

		System.out.println(d.toString('.'));

		d.setYear(2019);

		System.out.println(d.toString('-'));
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

class App {
	public static void main(String [] args)
	{
		Date d = new Date(5, 9, 2020);

		System.out.println(d.toStringTR());
		System.out.println(d.toLongDateStringTR());

		d.setDay(10);

		System.out.println(d.toStringTR());
		System.out.println(d.toLongDateStringTR());

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

class App {
	public static void main(String [] args)
	{
		Date d = new Date(5, 9, 2020);

		System.out.println(d.toStringEN());
		System.out.println(d.toLongDateStringEN());

		d.setDay(12);

		System.out.println(d.toStringEN());
		System.out.println(d.toLongDateStringEN());

		d.setDay(21);

		System.out.println(d.toStringEN());
		System.out.println(d.toLongDateStringEN());

		d.setDay(22);

		System.out.println(d.toStringEN());
		System.out.println(d.toLongDateStringEN());
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

import java.util.Random;

class App {
	public static void main(String [] args)
	{
		Random r = new Random();

		for (int i = 0; i < 10; ++i) {
			Date date = Date.randomDate(r, 1900, 2100);

			System.out.println(date.toLongDateStringTR());
			System.out.println(date.toLongDateStringEN());

			System.out.println("///////////////////");
		}
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

class App {
	public static void main(String [] args)
	{
		Date today = new Date();

		System.out.println(today.toLongDateStringEN());
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

import java.util.Random;

class App {
	public static void main(String [] args)
	{
		Random r = new Random();

		for (int i = 0; i < 10; ++i) {
			Date date = Date.randomDate(r, 2020);

			System.out.println(date.toLongDateStringTR());
			System.out.println(date.toLongDateStringEN());

			System.out.println("///////////////////");
		}
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

import java.util.Random;

class App {
	public static void main(String [] args)
	{
		Random r = new Random();

		for (int i = 0; i < 10; ++i) {
			Date date = Date.randomDate(r);

			System.out.println(date.toLongDateStringTR());
			System.out.println(date.toLongDateStringEN());

			System.out.println("///////////////////");
		}
	}
}
```
### Student parserApp ve Date sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf çalışması: Klavyeden aşağıdaki formatta girilen bilgiyi ayrıştırarak ekrana yazdıran programı yazınız.
	Not: Geçerlilik kontrolü yapılmayacaktır.

	<isim>:<gg/aa/yyyy>:<ders adı>:<vize>:<final>
	Oğuz karan:10/09/1976:Matematik:90:100

	Bu formatta kişinin vize final notlarına vize * %40 + final * %60 formulüne göre geçme notunu hesaplayan ve doğum
	tarihinin hangi güne geldiğini yazdıran programı yazınız
	**** Örnekte Date sınıfı kullanılmıştır ****
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.studentinfoparserapp.StudentInfoParserApp;

class App {
	public static void main(String [] args)
	{
		StudentInfoParserApp.run();
	}
}

package org.csystem.app.samples.studentinfoparserapp;

import java.util.Scanner;

public class StudentInfoParserApp {
    private StudentInfoParserApp()
    {}

    public static void run()
    {
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print("Formatlı yazıyı giriniz:");
            String str = kb.nextLine();

            if (str.equals("quit"))
                break;

            StudentInfoParser studentInfoParser = new StudentInfoParser(str);

            System.out.println(studentInfoParser.getStudentInfo().toString());
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}

package org.csystem.app.samples.studentinfoparserapp;

import org.csystem.util.datetime.Date;

public class StudentInfo {
    private String m_name;
    private Date m_birthDate;
    private String m_lectureName;
    private int m_midtermGrade;
    private int m_finalGrade;

    public StudentInfo(String name, int day, int mon, int year, String lectureName, int midtermGrade, int finalGrade)
    {
        //...
        m_name = name;
        m_birthDate = new Date(day, mon, year);
        m_lectureName = lectureName;
        m_midtermGrade = midtermGrade;
        m_finalGrade = finalGrade;
    }

    public StudentInfo(String name, String birthDateStr, String lectureName, int midtermGrade, int finalGrade)
    {
        //...
        m_name = name;
        m_lectureName = lectureName;
        m_midtermGrade = midtermGrade;
        m_finalGrade = finalGrade;
        setBirthDate(birthDateStr);
    }

    public double getGrade()
    {
        return m_midtermGrade * 0.4 + m_finalGrade * 0.6;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public void setLectureName(String lectureName)
    {
        m_lectureName = lectureName;
    }

    public void setMidtermGrade(int midtermGrade)
    {
        m_midtermGrade = midtermGrade;
    }

    public void setFinalGrade(int finalGrade)
    {
        m_finalGrade = finalGrade;
    }

    public void setBirthDate(String birthDateStr)
    {
        String [] birthDateInfo = birthDateStr.split("[/]");

        m_birthDate = new Date(Integer.parseInt(birthDateInfo[0]), Integer.parseInt(birthDateInfo[1]), Integer.parseInt(birthDateInfo[2]));
    }

    public String toString()
    {
        double grade = getGrade();

        return String.format("{name:'%s', birthDate:'%s', lectureName:%s, midTermGrade:%d, finalGrade: %d, grade:%f, status:'%s'}",
                m_name, m_birthDate.toLongDateStringTR(), m_lectureName, m_midtermGrade, m_finalGrade, grade,  grade >= 50 ? "Geçti" : "Kaldı");
    }
}

package org.csystem.app.samples.studentinfoparserapp;

public class StudentInfoParser {
    private StudentInfo m_studentInfo;

    public StudentInfoParser(String str)
    {
        String [] studentInfoStr = str.split("[:]+");
        //...

        m_studentInfo = new StudentInfo(studentInfoStr[0], studentInfoStr[1], studentInfoStr[2], Integer.parseInt(studentInfoStr[3]), Integer.parseInt(studentInfoStr[4]));
    }

    public StudentInfo getStudentInfo()
    {
        return m_studentInfo;
    }
}
```
### Date sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	06-09-2020
	Date sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.datetime.Date;

class App {
	public static void main(String [] args)
	{
		Date date = new Date(1, 1, 100);

		System.out.println(date.toLongDateStringTR());
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
    private static final int [] DAYS_OF_MONTHS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String [] DAYS_OF_WEEK_TR =
            {"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};
    private static final String [] DAYS_OF_WEEK_EN=
            {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    private static final String [] MONTHS_TR =
            {"", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};
    private static final String [] MONTHS_EN =
            {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    private int m_day;
    private int m_month;
    private int m_year;
    private int m_dayOfWeek;

    private static boolean isLeapYear(int year)
    {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    private static boolean isValidDate(int day, int month, int year)
    {
        if (day < 1 || day > 31 || month < 1 || month > 12)
            return false;

        int days = month == 2 && isLeapYear(year) ? 29 : DAYS_OF_MONTHS[month];

        return day <= days;
    }

    private static int getDayOfWeek(int day, int month, int year)
    {
        int dayOfYear;

        dayOfYear = getDayOfYear(day, month, year);

        if (year >= 1900) {
            for (int y = 1900; y < year; ++y)
                dayOfYear += isLeapYear(y) ? 366 : 365;
        }
        else {
            for (int y = year + 1; y < 1900; ++y) //Algoritmasına bakılacak
                dayOfYear += isLeapYear(y) ? 366 : 365;
        }


        return dayOfYear % 7;
    }

    private static int getDayOfYear(int day, int month, int year)
    {
        int dayOfYear = day;

        for (int m = month - 1; m >= 1; --m)
            dayOfYear += DAYS_OF_MONTHS[m];

        if (month > 2 && isLeapYear(year))
            ++dayOfYear;

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
        int day = r.nextInt(month == 2 && isLeapYear(year) ? 29 : DAYS_OF_MONTHS[month]) + 1;

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

    public int getDayOfWeek()
    {
        return m_dayOfWeek;
    }

    public String getDayOfWeekTR()
    {
        return DAYS_OF_WEEK_TR[m_dayOfWeek];
    }

    public String getDayOfWeekEN()
    {
        return DAYS_OF_WEEK_EN[m_dayOfWeek];
    }

    public boolean isLeapYear()
    {
        return isLeapYear(m_year);
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
### Enum türü neden gereklidir (1)?
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte move metodunun parametresi int türünden olduğundan parametre değişken ismi ne olduğu ile ilgili
	bilgi verse de ona geçibilecek argümanlar anlaşılamamaktadır. Ayrıca çağırna sırasında geçilen argümanlar da
	ne anlama geldikleri hakkında bilgi vermemektedir. Yani okunabilirlik zayıftır. Şüphesiz move metodu doğru olsa
	çağırma sırasında geçersiz değerler geçilebilir bu da kod yazanın hata yapma olasılığının fazla olduğunu gösterir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		SampleGame sampleGame = new SampleGame();

		sampleGame.run();
	}
}

class SampleGame {
	public void run()
	{
		GameObject gameObject = new GameObject();

		//...
		gameObject.move(1); //top
		gameObject.move(3); //bottom
		gameObject.move(2); //left
		gameObject.move(0); //right
		gameObject.move(3); //bottom
	}
}

class GameObject {
	public void move(int direction)
	{
		//...
	}
}
```
### Enum türü neden gereklidir (2)?
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte move metodunun parametresi yine birşey anlatmamaktadır. Argümanlar okunabilirlik açısından
	düzeltilmiştir. Ancak argümanı hem yanlış yazma olasılığı hem de String karşılaştırmasının göreceli yavaş olması
	bu tekniğin de iyi olmadığını göstermektedir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		SampleGame sampleGame = new SampleGame();

		sampleGame.run();
	}
}

class SampleGame {
	public void run()
	{
		GameObject gameObject = new GameObject();

		//...
		gameObject.move("top");
		gameObject.move("bottom");
		gameObject.move("left");
		gameObject.move("right");
		gameObject.move("botom");
	}
}

class GameObject {
	public void move(String direction)
	{
		//...
	}
}
```
### Enum türü neden gereklidir (3)?
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki örnek aşağıdaki gibi bir tasarımla hata yapma olasılığının düşürüldüğü bir biçime getirilebilir.
	Ancak hala göreceli yavaşlık giderilmemiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		SampleGame sampleGame = new SampleGame();

		sampleGame.run();
	}
}

class SampleGame {
	public static final String LEFT = "left";
	public static final String RIGHT = "right";
	public static final String TOP = "top";
	public static final String BOTTOM = "bottom";

	public void run()
	{
		GameObject gameObject = new GameObject();

		//...
		gameObject.move(TOP);
		gameObject.move(BOTTOM);
		gameObject.move(LEFT);
		gameObject.move(RIGHT);
		gameObject.move(BOTTOM);
	}
}

class GameObject {
	public void move(String direction)
	{
		//...
	}
}
```
### Enum türü neden gereklidir (4)?
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıda metodun parametresi int yapılmış değerler de final elemanlar olarak belirlenmiştir. Ancak hala parametre
	değişkeni birşey anlatmamakta üstelik int türden olduğu için ilgisiz değerler de geçilebilmektedir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		SampleGame sampleGame = new SampleGame();

		sampleGame.run();
	}
}

class SampleGame {
	public static final int LEFT = 2;
	public static final int RIGHT = 0;
	public static final int TOP = 1;
	public static final int BOTTOM = 3;

	public void run()
	{
		GameObject gameObject = new GameObject();

		//...
		gameObject.move(TOP);
		gameObject.move(BOTTOM);
		gameObject.move(LEFT);
		gameObject.move(RIGHT);
		gameObject.move(BOTTOM);
	}
}

class GameObject {
	public void move(int direction)
	{
		//...
	}
}
```
### Enum türü neden gereklidir (5)?
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki problemler aşağıdaki gibi bir tasarımla çözülebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		SampleGame sampleGame = new SampleGame();

		sampleGame.run();
	}
}

class Direction {
	private Direction()
	{}

	public static final Direction LEFT = new Direction();
	public static final Direction RIGHT = new Direction();
	public static final Direction TOP = new Direction();
	public static final Direction BOTTOM = new Direction();
}

class SampleGame {

	public void run()
	{
		GameObject gameObject = new GameObject();

		//...
		gameObject.move(Direction.TOP);
		gameObject.move(Direction.BOTTOM);
		gameObject.move(Direction.LEFT);
		gameObject.move(Direction.RIGHT);
		gameObject.move(Direction.BOTTOM);
	}
}

class GameObject {
	public void move(Direction direction)
	{
		//...
	}
}
```
### Direction sınıfının geliştirilmesi
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte Direction sınıfı geliştirilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Direction direction = Direction.TOP;

		System.out.println(direction.ordinal());

		int ordinal = 3;

		direction = Direction.values()[ordinal];

		//...
	}
}

class Direction {
	private static final Direction [] DIRECTIONS = {new Direction(0), new Direction(1), new Direction(2), new Direction(3)};
	private final int m_ordinal;
	private Direction(int ordinal)
	{
		m_ordinal = ordinal;
	}

	public static final Direction RIGHT = DIRECTIONS[0];
	public static final Direction TOP = DIRECTIONS[1];
	public static final Direction LEFT = DIRECTIONS[2];
	public static final Direction BOTTOM = DIRECTIONS[3];

	public static Direction [] values()
	{
		return DIRECTIONS;
	}

	public int ordinal()
	{
		return m_ordinal;
	}
}
```
### enum anahtar sözcüğü ile bir enum türü (enum class) bildirilebilir. 
```java
/*----------------------------------------------------------------------------------------------------------------------
	enum anahtar sözcüğü ile bir enum türü (enum class) bildirilebilir. enum türü içerisinde ilk noktalı virgülden önce
	(noktalı virgül zorunlu olmadıkça konmaz) bildirilen isimlere enum sabitleri denir. Bu isimler ilgili enum türünden
	public static ve final olarak bildirilmiş referanslardır. Bu referanslar herbiri ilgili enum türünden yaratılmış olan
	bir nesnenin adresini tutarlar. enum sabitlerinin public static veya final veya tür bilgisi yazılması geçersizdir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

enum Color {
	RED, GREEN, BLUE
}

enum DayOfWeek {
	SUN, MON, TUE, WED, THU, FRI, SAT
}
```
### enum türünün ordinal isimli non-static metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	enum türünün ordinal isimli non-static metodu referansa ilişkin nesneyi tutan enum sabitinin sıra numarasını
	döndürür. Ordinal numarası sıfırdan başlar.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Color c = Color.RED;

		System.out.println(c.ordinal());

		DayOfWeek dayOfWeek = DayOfWeek.SAT;

		System.out.println(dayOfWeek.ordinal());
	}
}

enum Color {
	RED, GREEN, BLUE
}

enum DayOfWeek {
	SUN, MON, TUE, WED, THU, FRI, SAT
}
```
### enum türünün toString metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	enum türünün toString metodu ilgili sabitin yazı karşılığını döndürür
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

		DayOfWeek dayOfWeek = DayOfWeek.WED;

		System.out.println(dayOfWeek.toString());
	}
}


enum DayOfWeek {
	SUN, MON, TUE, WED, THU, FRI, SAT
}
```
### enum türünün static valueOf static metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	enum türünün static valueOf static metodu ile enum sabitinin yazı karşılından referansı elde edilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		DayOfWeek dayOfWeek = DayOfWeek.valueOf("WED");

		System.out.println(dayOfWeek.toString());
	}
}


enum DayOfWeek {
	SUN, MON, TUE, WED, THU, FRI, SAT
}
```
### enum türünün values isimli metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	enum türünün values isimli metodu enum sabitlerine ilişkin diziyi döndürür
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		for (DayOfWeek dayOfWeek : DayOfWeek.values())
			System.out.println(dayOfWeek.toString());
	}
}


enum DayOfWeek {
	SUN, MON, TUE, WED, THU, FRI, SAT
}
```
### enum türünden nesne new operatörü ile hiç bir yerde (enum içinde bile) yaratılamaz!
```java
/*----------------------------------------------------------------------------------------------------------------------
	enum türünden nesne new operatörü ile hiç bir yerde (enum içinde bile) yaratılamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		DayOfWeek dayOfWeek = new DayOfWeek(); //error
	}
}


enum DayOfWeek {
	SUN, MON, TUE, WED, THU, FRI, SAT
}
```
### enun türüne sabitler dışında metot, veri elemanı ve ctor gibi elemanlar da eklenebilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	enun türüne sabitler dışında metot, veri elemanı ve ctor gibi elemanlar da eklenebilir. Bunun için son sabit
	bildiriminden sonra noktalı virgül konmalı ve elemanlar bildirilmelidir. Eğer enum class'ın hiç bir sabiti
	olmayacaksa (ki bu durum pratikte anlamsızdır) eklenecek diğer elemanlardan önce yine noktalı virgül konmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

enum Sample {
	;
	private int m_x;
	public void foo()
	{

	}
}

enum Color {
	RED, GREEN, BLUE;
	private int m_x;
	public void foo()
	{

	}
}
```
### Aşağıdaki enum türünde içi boş ()'ler geçerlidir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki enum türünde içi boş ()'ler geçerlidir. Yani hiç parantez konmaması ile içi boş () konması aynı
	anlamdadır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

enum Color {
	RED(), GREEN(), BLUE();
}
```
### enum türünde içi boş ()'lerin anlamı
```java
/*----------------------------------------------------------------------------------------------------------------------
	enum türlerinde parantez koymamak veya içi boş () koymak default ctor çağrılarak enum sabitlerine ilişkin
	nesnelerin yaratılması demektir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

enum Color {
	RED, GREEN, BLUE;
}
```
### enum türlerine ctor yazılabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	enum türlerine ctor yazılabilir. Ancak bu ctor ya private bildirilmelidir ya da hiç bir erişim belirleyici
	yazılmamalıdır. Erişim belirleyici yazılmaması enum sınıflarının ctor'ları için private anlamındadır. Bu durum
	yalnızca ctoriçin geçerlidir. Veri elemanları ve metotlar için sınıflar ile aynıdır. enum sınıfının ctor'u
	public veya protected bildirilemez. enum sınıfı türünden bir nesne enum sınıfı içerisinde de yaratılamaz. Yani ctor
	elemanı private olmanın da ötesindedir.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

enum Color {
	RED, GREEN, BLUE;
	private Color()
	{

	}
	public void foo()
	{
		Color c = new Color(); //error
	}
}
```
### enum türü ve ctor çağrılması
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte RED, GREEN, BLUE referanslarına ilişkin nesneler yaratılırken default ctor'un çağrıldığına
	dikkat ediniz.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Color.foo();
		System.out.println("////////////");
		Color.foo();

	}
}

enum Color {
	RED, GREEN, BLUE;
	Color()
	{
		System.out.println("Color.Color");
	}

	public static void foo()
	{

	}
}
```
### enum sınıfına eklenen ctor elemanı ve her bir sabite iliştirilen bilgi!
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte Color enum sınıfına eklenen ctor elemanı ile her bir sabite ilişkin nesneye bilgi iliştirilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Color color = Color.BLUE;

		System.out.printf("(%d, %d, %d)", color.getR(), color.getG(), color.getB());
	}
}

enum Color {
	RED(255, 0, 0), GREEN(0, 255, 0), BLUE(0, 0, 255);
	private final int m_r, m_b, m_g;

	Color(int r, int g, int b)
	{
		m_r = r;
		m_g = g;
		m_b = b;
	}

	public int getR()
	{
		return m_r;
	}

	public int getG()
	{
		return m_g;
	}

	public int getB()
	{
		return m_b;
	}
}
```
### enum sınıfına eklenen ctor elemanı ve her bir sabite iliştirilen bilgi!
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte Color enum sınıfına eklenen ctor elemanı ile her bir sabite ilişkin nesneye bilgi iliştirilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Color color = Color.BLUE;

		System.out.printf("(%d, %d, %d)", color.r, color.g, color.b);
	}
}

enum Color {
	RED(255, 0, 0), GREEN(0, 255, 0), BLUE(0, 0, 255);
	public final int r, b, g;

	Color(int x, int y, int z)
	{
		r = x;
		g = y;
		b = z;
	}
}
```
### enum sınıfına eklenen ctor elemanı ve her bir sabite iliştirilen bilgi!
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte Color enum sınıfına eklenen ctor elemanı ile her bir sabite ilişkin nesneye bilgi iliştirilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Color color = Color.B;

		System.out.printf("(%d, %d, %d)", color.r, color.g, color.b);
	}
}

enum Color {
	RED(255, 0, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
	R(RED), G(GREEN), B(BLUE);
	public final int r, b, g;

	Color(int x, int y, int z)
	{
		r = x;
		g = y;
		b = z;
	}

	Color(Color c)
	{
		r = c.r;
		g = c.g;
		b = c.b;
	}
}
```
### enum class ile Singleton sınıf bildirimi.
```java
/*----------------------------------------------------------------------------------------------------------------------
	enum class ile Singleton sınıf bildirimi. Lazy implemenatation gerekmedikçe veya başka bir gerekçe yoksa singleton
	için bu implementasyon en iyisidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Singleton s = Singleton.INSTANCE;
		Singleton k = Singleton.INSTANCE;

		System.out.println(s == k);
	}
}

enum Singleton {
	INSTANCE;
	private int m_a;

	public int getA()
	{
		return m_a;
	}

	public void setA(int a)
	{
		//...
		m_a = a;
	}
}
```
### enum türlerinde eşitlik karşılaştırması
```java
/*----------------------------------------------------------------------------------------------------------------------
	enum türlerinde eşitlik karşılaştırması yani aynı enum sabitine ilşkin referansın tutulup tutulmadığı == veya !=
	operatörleri ile test edilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Direction direction1 = Direction.LEFT;
		Direction direction2 = Direction.LEFT;

		System.out.println(direction1 == direction2);
		System.out.println(direction1 != direction2);
	}
}

enum Direction {
	RIGHT, TOP, LEFT, BOTTOM
}
```
### enum türlerinde eşitlik karşılaştırması equals isimli metot ile yapılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	enum türlerinde eşitlik karşılaştırması equals isimli metot ile yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Direction direction1 = Direction.LEFT;
		Direction direction2 = Direction.LEFT;

		System.out.println(direction1.equals(direction2));
	}
}

enum Direction {
	RIGHT, TOP, LEFT, BOTTOM
}
```
### enum türlerinin compareTo metodu:
```java
/*----------------------------------------------------------------------------------------------------------------------
	enum türlerinin compareTo metodu:
		a.compareTo(b);
	çağrısı için
		a.ordinal() - b.ordinal()
	sonucunu döndürür
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		DayOfWeek dayOfWeek1 = DayOfWeek.MON;
		DayOfWeek dayOfWeek2 = DayOfWeek.WED;

		System.out.println(dayOfWeek1.compareTo(dayOfWeek2));

		if (dayOfWeek1.compareTo(dayOfWeek2) > 0)
			System.out.println("dayofWeek1, dayOfWeek2 den sonra geliyor");
		else
			System.out.println("dayofWeek2, dayOfWeek1 den sonra geliyor");
	}
}

enum DayOfWeek {
	SUN, MON, TUE, WED, THU, FRI, SAT
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
		Date d = new Date(8, Month.SEP, 2020);

		System.out.println(d.getDayOfWeek().toString());

		System.out.println(d.toLongDateStringTR());
		System.out.println(d.toLongDateStringEN());

		d.setMonth(Month.AUG);

		System.out.println(d.getDayOfWeek().toString());

		System.out.println(d.toLongDateStringTR());
		System.out.println(d.toLongDateStringEN());
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

import java.util.Random;

class App {
	public static void main(String [] args)
	{
		Random r = new Random();

		for (int i = 0; i < 10; ++i) {
			Date date = Date.randomDate(r, 2020);

			System.out.println(date.toLongDateStringTR());
			System.out.println(date.toLongDateStringEN());

			if (date.isWeekend())
				System.out.println("Bugün kurs var. Tekrar yaptınız mı?");
			else
				System.out.println("Kurs günü yaklaşıyor. Tekrar yapınız!!!");
		}
	}
}
```
### Homework-015 için bir ipucu. Detaylar gözrmezden gelindi
```java
/*----------------------------------------------------------------------------------------------------------------------
	Homework-015 için bir ipucu. Detaylar gözrmezden gelindi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Card [] deck;

		deck = Card.getShuffledDeck();

		for (Card card : deck)
			System.out.printf("%s-%s%n", card.getType(), card.getValue());
	}
}

class Card
{
	private CardValue m_value;
	private CardType m_type;
	//...

	public Card(CardValue v, CardType t)
	{
		m_value = v;
		m_type = t;
	}

	public CardValue getValue()
	{
		return m_value;
	}

	public CardType getType()
	{
		return m_type;
	}
	//....
	public static Card[] getShuffledDeck()
	{
		Card[] deck = new Card[52];

		int index = 0;

		for (CardType cardType : CardType.values())
			for (CardValue cardValue : CardValue.values())
				deck[index++] = new Card(cardValue, cardType);

		//...

		return deck;
	}

	//…
}


enum CardType
{
	SPADE, CLUB, DIAMOND, HEART
}

enum CardValue
{
	TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, KNAVE, QUEEN, KING, ACE
}

/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/
```
