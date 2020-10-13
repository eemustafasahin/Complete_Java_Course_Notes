```java
/*----------------------------------------------------------------------------------------------------------------------
    CSDArrayList sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.collection.CSDArrayList;
import org.csystem.util.StringUtil;

import java.util.Random;

class App {
	public static void main(String [] args)
	{
		CSDArrayList passwords = new CSDArrayList();
		Random r = new Random();

		System.out.printf("Size:%d%n", passwords.size());
		System.out.printf("Capacity:%d%n", passwords.capacity());

		for (int i = 0; i < 15; ++i)
			passwords.add(StringUtil.getRandomTextTR(r, 10));

		System.out.printf("Size:%d%n", passwords.size());
		System.out.printf("Capacity:%d%n", passwords.capacity());

		int size = passwords.size();

		for (int i = 0; i < size; ++i) {
			String pasword = (String)passwords.get(i);

			System.out.println(pasword);
		}
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    CSDArrayList sınıfı ve test kodu.
    clear metodunda tutulan referansların nesnelerinden kopartıldığına dikkat ediniz. Aksi durumda bellek sızıntısı
    (memory leak) oluşabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.collection.CSDArrayList;
import org.csystem.util.StringUtil;

import java.util.Random;

class App {
	public static void main(String [] args)
	{
		CSDArrayList passwords = new CSDArrayList();
		Random r = new Random();

		System.out.printf("Size:%d%n", passwords.size());
		System.out.printf("Capacity:%d%n", passwords.capacity());

		for (int i = 0; i < 15; ++i)
			passwords.add(StringUtil.getRandomTextTR(r, 10));

		System.out.printf("Size:%d%n", passwords.size());
		System.out.printf("Capacity:%d%n", passwords.capacity());

		passwords.clear();

		System.out.printf("Size:%d%n", passwords.size());
		System.out.printf("Capacity:%d%n", passwords.capacity());
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    CSDArrayList sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.collection.CSDArrayList;

class App {
	public static void main(String [] args)
	{
		CSDArrayList list = new CSDArrayList();

		for (int i = 0; i < 15; ++i)
			list.add(i * 10);


		int size = list.size();

		for (int i = 0; i < size; ++i) {
			int val = (int)list.get(i);

			System.out.printf("%d ", val);
		}

		System.out.println();

		int oldValue = (int)list.set(3, 67);

		for (int i = 0; i < size; ++i) {
			int val = (int)list.get(i);

			System.out.printf("%d ", val);
		}

		System.out.printf("%nOld Value:%d%n", oldValue);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    CSDArrayList sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.collection.CSDArrayList;

class App {
	public static void main(String [] args)
	{
		CSDArrayList list = new CSDArrayList();

		for (int i = 0; i < 15; ++i)
			list.add(i * 10);

		System.out.printf("Size:%d%n", list.size());
		System.out.printf("Capacity:%d%n", list.capacity());

		list.trimToSize();

		System.out.printf("Size:%d%n", list.size());
		System.out.printf("Capacity:%d%n", list.capacity());

	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    CSDArrayList sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.collection.CSDArrayList;

class App {
	public static void main(String [] args)
	{
		CSDArrayList list = new CSDArrayList();

		System.out.printf("Size:%d%n", list.size());
		System.out.printf("Capacity:%d%n", list.capacity());

		list.trimToSize();

		System.out.printf("Size:%d%n", list.size());
		System.out.printf("Capacity:%d%n", list.capacity());

		list.add(20);

		System.out.printf("Size:%d%n", list.size());
		System.out.printf("Capacity:%d%n", list.capacity());

		list.add(30);

		System.out.printf("Size:%d%n", list.size());
		System.out.printf("Capacity:%d%n", list.capacity());
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
  	CSDArrayList sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.collection.CSDArrayList;

import java.util.Scanner;

class App {
	public static void main(String[] args)
	{
		DeviceApp app = new DeviceApp(2);

		app.run();
	}
}

class DeviceApp {
	private final CSDArrayList m_devices;

	public DeviceApp(int n)
	{
		m_devices = new CSDArrayList(n);
	}
	public void run()
	{
		Scanner kb = new Scanner(System.in);

		for (;;) {
			System.out.print("İsim giriniz:");
			String name = kb.nextLine();

			if (name.equals("quit"))
				break;

			System.out.print("Host giriniz:");
			String host = kb.nextLine();

			System.out.print("Port giriniz:");
			int port = Integer.parseInt(kb.nextLine());

			m_devices.add(new Device(name, host, port));

			System.out.printf("Capacity:%d%n", m_devices.capacity());
			System.out.printf("Size:%d%n", m_devices.size());
		}
		System.out.println("Final:");
		System.out.printf("Capacity:%d%n", m_devices.capacity());
		System.out.printf("Size:%d%n", m_devices.size());
		//...
	}
}


class Device {
	private String m_name;
	private String m_host;
	private int m_port;

	public Device(String name, String host, int port)
	{
		m_name = name;
		m_host = host;
		m_port = port;
	}

	public String getName()
	{
		return m_name;
	}

	public void setName(String name)
	{
		m_name = name;
	}

	public String getHost()
	{
		return m_host;
	}

	public void setHost(String host)
	{
		m_host = host;
	}

	public int getPort()
	{
		return m_port;
	}

	public void setPort(int port)
	{
		m_port = port;
	}

	public String toString()
	{
		return String.format("[%s]%s:%d", m_name, m_host, m_port);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    CSDArrayList sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.collection;

public class CSDArrayList {
    private static final int DEFAULT_CAPACITY = 10;
    private Object [] m_elems;
    private int m_index;

    private static void doWorkForIllegalArgumentException(String message)
    {
        System.out.println(message);
        System.exit(-1); //exception işlemleri konusuna kadar sabredin
    }

    private static void doWorkForIndexOutOfBoundsException(String message)
    {
        System.out.println(message);
        System.exit(-1); //exception işlemleri konusuna kadar sabredin
    }

    private void checkForIndex(int index)
    {
        if (index < 0 || index >= m_index)
            doWorkForIndexOutOfBoundsException("IndexOutOfBounds");
    }

    private void checkCapacityValue(int capacity)
    {
        if (capacity < 0)
            doWorkForIllegalArgumentException("Capacity can no be negative");
    }

    private void changeCapacity(int capacity)
    {
        Object [] temp = new Object[capacity];

        for (int i = 0; i < m_index; ++i)
            temp[i] = m_elems[i];

        m_elems = temp;
    }

    public CSDArrayList()
    {
        m_elems = new Object[DEFAULT_CAPACITY];
    }

    public CSDArrayList(int capacity)
    {
        checkCapacityValue(capacity);

        m_elems = new Object[capacity];
    }

    public boolean add(Object elem)
    {
        if (m_index == m_elems.length)
            changeCapacity(m_elems.length == 0 ? 1 : m_elems.length * 2);

        m_elems[m_index++] = elem;

        return true;
    }

    public void add(int index, Object elem)
    {
        if (m_index == m_elems.length)
            changeCapacity(m_elems.length == 0 ? 1 : m_elems.length * 2);

        //TODO:
    }

    public int capacity()
    {
        return m_elems.length;
    }

    public void clear()
    {
        for (int i = 0; i < m_index; ++i)
            m_elems[i] = null;

        m_index = 0;
    }

    public void ensureCapacity(int minCapacity)
    {
        if (minCapacity <= m_elems.length)
            return;

        changeCapacity(Math.max(minCapacity, m_elems.length * 2));
    }

    public Object get(int index)
    {
        checkForIndex(index);

        return m_elems[index];
    }

    public Object remove(int index)
    {
        //TODO: bellek sızıntına dikkat!!!
        Object oldElem = m_elems[index];

        //...

        return oldElem;
    }

    public Object set(int index, Object elem)
    {
        checkForIndex(index);
        Object oldElem = m_elems[index];

        m_elems[index] = elem;

        return oldElem;
    }

    public int size()
    {
        return m_index;
    }

    public void trimToSize()
    {
        changeCapacity(m_index);
    }

    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    04.10.2020
    Bir sınıfın içerisinde tüm metotların dışında herhangi bir yerde static anahtar sözcüğü ile tanımlanan bloklara
    sınıfın static blokları (static initializers) denir. Sınıfın herhangi bir elamanı ilk kez kullanıldığında tüm static
    bloklar yukarıdan aşağıya doğru sırayla bir kez olmak üzere çalıştırılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Sample.foo();
		System.out.println("////////////////////");
		Sample.foo();
	}
}

class Sample {
	static {
		System.out.println("static initializer1");
	}
	//...

	static {
		System.out.println("static initializer2");
	}

	static {
		System.out.println("static initializer3");
	}

	public static void foo()
	{
		System.out.println("foo");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir sınıfın içerisinde tüm metotların dışında herhangi bir yerde static anahtar sözcüğü ile tanımlanan bloklara
    sınıfın static blokları (static initializers) denir. Sınıfın herhangi bir elamanı ilk kez kullanıldığında tüm static
    bloklar yukarıdan aşağıya doğru sırayla bir kez olmak üzere çalıştırılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Sample s;

		System.out.println("////////////////////////////////");
		s = new Sample();
	}
}

class Sample {
	static {
		System.out.println("static initializer1");
	}
	//...

	static {
		System.out.println("static initializer2");
	}

	static {
		System.out.println("static initializer3");
	}

	public Sample()
	{
		System.out.println("Sample.Sample()");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    static bloklar static metotlar gibidir yani bu bloklarda sınıfın yalnızca static elemanlarına doğrudan erişilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Sample.foo();
		Sample.foo();
	}
}

class Sample {
	private static int ms_val;
	static {
		ms_val = 10;
		System.out.println("static initializer1");
		foo();
		bar();//error
	}


	public static void foo()
	{
		//..
	}

	public void bar()
	{
		//..
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıfın final static veri elemanlarına static bloklarda değer atanabilir. Şüphesiz burada değer atanabilmesi
    için bildirim noktasında atanmamış olması gerekir. Zaten static initilizer'ın en çok kullanıldığı durum da
    finale ve static veri elemanlara değer verilmesidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		System.out.println(Sample.PI);
	}
}

class Sample {
	public static final double PI;

	static {
		PI = 3.14;
	}

	//...

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    static bloğun bir kullanımı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Random;
import java.util.Scanner;

class App {
    public static void main(String [] args)
    {
        System.out.println(Sample.VAL);
        System.out.println("************************");
        System.out.println(Sample.VAL);
    }
}

class Sample {
    public static final int VAL;

    static {
        Random r = new Random();

        Scanner kb = new Scanner(System.in);
        System.out.print("min?");
        int min = Integer.parseInt(kb.nextLine());

        System.out.print("max?");
        int max = Integer.parseInt(kb.nextLine());

        VAL = r.nextInt(max - min) + min;
    }
    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte static blok kullanılarak kod daha basit bir biçimde yazılmıştır. static blok kullanmadan
    nasıl yaparsınız? Düşünün
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Random;
import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		System.out.println(Sample.VAL);
		System.out.println(Sample.VAL2);
		System.out.println("****************");
		System.out.println(Sample.VAL);
		System.out.println(Sample.VAL2);
	}
}

class Sample {
	static {
		Random r = new Random();

		Scanner kb = new Scanner(System.in);
		System.out.print("min?");
		int min = Integer.parseInt(kb.nextLine());

		System.out.print("max?");
		int max = Integer.parseInt(kb.nextLine());

		VAL =  r.nextInt(max - min) + min;
		VAL2 =  r.nextInt(max - min) + min;
	}


	public static final int VAL;
	public static final int VAL2;
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir sınıf içerisindeki tüm static blokların kendi faaliyet alanları vardır. Yani aslında bunlar ayrı metotlar
    gibi düşünülebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		System.out.println(Sample.VAL1);
		System.out.println(Sample.VAL2);
	}
}

class Sample {
	public static final int VAL1;
	public static final int VAL2;

	static {
		System.out.println("static initializer1");
		int a = 10;

		VAL1 = a * 2;
	}

	static {
		System.out.println("static initializer2");
		int a = 20;

		VAL2 = a * 3;
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Date sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.Random;

public class Date {
    private static final String [] MONTHS_TR;
    private static final String [] MONTHS_EN;

    private int m_day;
    private int m_month;
    private int m_year;
    private int m_dayOfWeek;

    static {
        MONTHS_TR = new String[]{"", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz",
                "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};
        MONTHS_EN = new String[]{"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
                "Aug", "Sep", "Oct", "Nov", "Dec"};
    }

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
```java
/*----------------------------------------------------------------------------------------------------------------------
	NumberUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import static java.lang.Math.*;

public final class NumberUtil {
	private static final String [] ONES_TR;
	private static final String [] TENS_TR;

	static {
		ONES_TR = new String[]{"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
		TENS_TR = new String[]{"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};
	}

	private static int[] getDigits(long val, int n)
	{
		long value = Math.abs(val);
		int count = value == 0 ? 1 : (int)Math.log10(value) / n + 1;
		int [] digits = new int[count];
		int powerOfTen = (int)Math.pow(10, n);

		for (int i = count - 1; i >= 0; digits[i] = (int)(value % powerOfTen), value /= powerOfTen, --i)
			;

		return digits;
	}

	private static String numberToText3DigitsTR(int val)
	{
		if(val == 0)
			return "sıfır";

		String text = val < 0 ? "eksi" : "";
		int value = Math.abs(val);
		int a = value / 100;
		int b = value / 10 % 10;
		int c = value % 10;

		if (a != 0) {
			if (a != 1)
				text += ONES_TR[a];
			text += "yüz";
		}

		if (b != 0)
			text += TENS_TR[b];

		if (c != 0)
			text += ONES_TR[c];

		return text;
	}

	private NumberUtil()
	{
	}

	public static int factorial(int n)
	{
		if (n < 0)
			return -1;

		int result = 1;

		for (int i = 2; i <= n; ++i)
			result *= i;

		return result;
	}

	public static int[] getDigits(int val)
	{
		return getDigits((long)val);
	}

	public static int[] getDigits(long val)
	{
		return getDigits(val, 1);
	}

	public static int[] getDigitsInTwos(long val)
	{
		return getDigits(val, 2);
	}

	public static int[] getDigitsInThrees(long val)
	{
		return getDigits(val, 3);
	}

	public static int getDigitsCount(long val)
	{
		return val == 0 ? 1 : (int)log10(abs(val)) + 1;
	}

	public static int getDigitsPowSum(int val)
	{
		int count = getDigitsCount(val);

		int sum = 0;

		while (val != 0) {
			sum += pow(val % 10, count);
			val /= 10;
		}

		return sum;
	}

	public static int getDigitsSum(int val)
	{
		val = abs(val);
		int sum = 0;

		while (val != 0) {
			sum += val % 10;
			val /= 10;
		}

		return sum;
	}

	public static int getFibonacciNumber(int n)
	{
		if (n <= 0)
			return -1;

		if (n <= 2)
			return n - 1;

		int prev1 = 1, prev2 = 0, val = 0;

		for (int i = 2; i < n; ++i) {
			val = prev1 + prev2;
			prev2 = prev1;
			prev1 = val;
		}

		return val;
	}

	public static int getNextFibonacciNumber(int val)
	{
		if (val < 0)
			return 0;

		int prev1 = 1, prev2 = 0, result;

		for (;;) {
			result = prev1 + prev2;

			if (result > val)
				return result;

			prev2 = prev1;
			prev1 = result;
		}
	}

	public static int getPrime(int n)
	{
		if (n <= 0)
			return -1;

		int count = 0;
		int val = 2;

		for (int i = 2; count < n; ++i)
			if (isPrime(i)) {
				++count;
				val = i;
			}

		return val;
	}

	public static int getReverse(int val)
	{
		int reverse = 0;

		while (val != 0) {
			reverse = reverse * 10 + val % 10;
			val /= 10;
		}

		return reverse;
	}

	public static boolean isArmstrong(int val)
	{
		if (val < 0)
			return false;

		return getDigitsPowSum(val) == val;
	}

	public static boolean isEven(int val)
	{
		return val % 2 == 0;
	}


	public static boolean isOdd(int val)
	{
		return !isEven(val);
	}

	public static boolean isPrime(int val)
	{
		if (val <= 1)
			return false;

		if (val % 2 == 0)
			return val == 2;

		if (val % 3 == 0)
			return val == 3;

		if (val % 5 == 0)
			return val == 5;

		if (val % 7 == 0)
			return val == 7;

		int sqrtVal = (int)sqrt(val);

		for (int i = 11; i <= sqrtVal; i += 2)
			if (val % i == 0)
				return false;

		return true;
	}

	public static boolean isNotPrime(int val)
	{
		return !isPrime(val);
	}

	public static int max(int a, int b, int c)
	{
		return Math.max(Math.max(a, b), c);
	}

	public static int min(int a, int b, int c)
	{
		return Math.min(Math.min(a, b), c);
	}


	public static String numberToTextTR(long val)
	{
		String text;

		//TODO: Homework-012-3. soru
		text = numberToText3DigitsTR((int)val);

		return text;
	}

	public static int pow(int a, int b)
	{
		if (b <= 0)
			return 1;

		int result = 1;

		while (b-- > 0)
			result *= a;

		return result;
	}
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
	StringUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Random;

import static java.lang.Character.*;

public final class StringUtil {
	private static final String ALPHABET_TR;
	private static final String ALPHABET_EN;

	static {
		ALPHABET_TR = "abcçdefgğhıijklmnoöprsştuüvyz";
		ALPHABET_EN = "abcdefghijklmnopqrstuwxvyz";
	}

	private StringUtil()
	{
	}

    public static String capitalize(String s)
    {
		if (s.isEmpty())
			return s;

		return toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

    public static int countString(String s1, String s2)
    {
		int count = 0;

		for (int i = -1; (i = s1.indexOf(s2, i + 1)) != -1; ++count)
			;

		return count;
    }

    public static String getLetters(String s)
    {
		String str = "";
		int length = s.length();

		for (int i = 0; i < length; ++i) {
		    char ch = s.charAt(i);

		    if (isLetter(ch))
		    	str += ch;
		}

		return str;
    }

    public static String getLongestPalindrome(String s)
    {
		String text = "";

		int endIndex = s.length();

		while (endIndex != 0) {
		    int beginIndex = 0;

		    while (beginIndex != endIndex) {
				String str = s.substring(beginIndex++, endIndex);

				if (str.length() > 1 && StringUtil.isPalindrome(str) && str.length() > text.length())
				    text = str;
		    }

		    --endIndex;
		}

		return text;
    }

    public static String getRandomText(Random r, int n, String mainText)
    {
		char [] c = new char[n];

		for (int i = 0; i < n; ++i) {
		    char ch = mainText.charAt(r.nextInt(mainText.length()));

		    if (r.nextBoolean())
				ch = toUpperCase(ch);

		    c[i] = ch;
		}

		return String.valueOf(c);
    }

    public static String getRandomTextEN(int n)
    {
    	return getRandomTextEN(new Random(), n);
    }

    public static String getRandomTextEN(Random r, int n)
    {
    	return getRandomText(r, n, ALPHABET_EN);
    }

    public static String getRandomTextTR(int n)
    {
    	return getRandomTextTR(new Random(), n);
    }

    public static String getRandomTextTR(Random r, int n)
    {
    	return getRandomText(r, n, ALPHABET_TR);
    }

    public static boolean isPalindrome(String s)
	{
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			char chLeft = toLowerCase(s.charAt(left));

			if (!isLetter(chLeft)) {
				++left;
				continue;
			}

			char chRight = toLowerCase(s.charAt(right));

			if (!isLetter(chRight)) {
				--right;
				continue;
			}

			if (chLeft != chRight)
				return false;

			++left;
			--right;
		}

		return true;
	}

    public static boolean isPangram(String text, String alphabet)
    {
		int length = alphabet.length();

		for (int i = 0; i < length; ++i)
		    if (!text.contains(alphabet.charAt(i) + ""))
		    	return false;

		return true;
    }

    public static boolean isPangramEN(String text)
    {
    	return isPangram(text.toLowerCase(), ALPHABET_EN);
    }

    public static boolean isPangramTR(String text)
    {
    	return isPangram(text.toLowerCase(), ALPHABET_TR);
    }

    public static String padLeft(String s, int length)
    {
    	return padLeft(s, length, ' ');
    }

    public static String padLeft(String s, int length, char ch)
    {
		length -= s.length();

		if (length <= 0)
		    return s;

		return repeat(length, ch) + s;
    }

    public static String padRight(String s, int length)
    {
    	return padRight(s, length, ' ');
    }

    public static String padRight(String s, int length, char ch)
    {
		length -= s.length();

		if (length <= 0)
		    return s;

		return s + repeat(length, ch);
    }

    public static String removeWhitespaces(String s)
    {
		int length = s.length();
		String str = "";

		for (int i = 0; i < length; ++i) {
		    char ch = s.charAt(i);

		    if (!isWhitespace(ch))
				str += ch;
		}

		return str;
    }

    public static String repeat(int n, char ch)
    {
		char [] c = new char[n];

		while (n-- > 0)
		    c[n] = ch;

		return String.valueOf(c);
    }

    public static String reverse(String str)
    {
		char [] c = str.toCharArray();

		ArrayUtil.reverse(c);

		return String.valueOf(c);
    }

	public static String [] split(String str, String delimiters)
	{
		return split(str, delimiters, StringSplitOptions.NONE);
	}

    public static String [] split(String str, String delimiters, StringSplitOptions stringSplitOptions) // Bazı az kulanılan detaylar gözmezden gelindi
	{
		String pattern = "[";
		int length = delimiters.length();

		for (int i = 0; i < length; ++i) {
			char delim = delimiters.charAt(i);

			pattern += delim == '[' || delim == ']' ? "\\" + delim : delim;
		}

		pattern += stringSplitOptions == StringSplitOptions.REMOVE_EMPTY_ENTRIES ? "]+" : "]";

		return  str.split(pattern);
	}

    public static String trimLeft(String s)
    {
		int i;
		int len = s.length();

		for (i = 0; i < len && isWhitespace(s.charAt(i)); ++i)
		    ;

		return s.substring(i);
    }

    public static String trimRight(String s)
    {
		int i;

		for (i = s.length() - 1; i >= 0 && isWhitespace(s.charAt(i)); --i)
		    ;

		return s.substring(0, i + 1);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir sınıfın non-static blokları (non-static initializer) olabilir. Bu bloklar ctor'ların başında çalıştırılır.
    Yani adeta bu bloklar her ctor'un başına gizlice eklenir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Sample s = new Sample();
		System.out.println("*****************");
		Sample k = new Sample();

		//...
	}
}

class Sample {
	{
		System.out.println("non-static initializer1");
	}


	{
		System.out.println("non-static initializer2");
	}
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir sınıfın non-static blokları (non-static initializer) olabilir. Bu bloklar ctor'ların başında çalıştırılır.
    Yani adeta bu bloklar her ctor'un başına gizlice eklenir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample s = new Sample();
        System.out.println("*****************");
        Sample k = new Sample(10);

        //...
    }
}

class Sample {
    {
        System.out.println("non-static initializer1");
    }


    {
        System.out.println("non-static initializer2");
    }

    public Sample()
    {
        System.out.println("Sample.Sample()");
    }

    public Sample(int a)
    {
        System.out.println("Sample.Sample(int)");
    }
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
    Bir sınıfın ctor'u içerisinde o sınıfın başka bir ctor'unun çağrılması kodu yazılmışsa (this ctor) bu durumda
    çağıran için non-static initializer kodu yerleştirilmez. Çünkü zaten çağrılan ctor' da ya olacaktır ya da
    o da başka bir ctor'u çağırsa da sonuçta çalıştırılacak bir non-static blok mutlaka olacaktır. Yani bir non-static
    initializer nesne başına bir kez çağrılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Sample s1 = new Sample();
		System.out.println("**********************");
		Sample s2 = new Sample(10);
		System.out.println("**********************");
		Sample s3 = new Sample(3.4);

		//...
	}
}

class Sample {
	{
		System.out.println("non-static initializer");
	}

	public Sample(double a)
	{
		System.out.println("Sample.Sample(double)");
	}

	public Sample()
	{
		this(Math.PI);
		System.out.println("Sample.Sample()");
	}

	public Sample(int a)
	{
		this();
		System.out.println("Sample.Sample(int)");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    super ctor sentaksı kullanıldığında non-static blokların çalıştırılma sırası
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		B x = new B();
		System.out.println("*****************");
		B y = new B(20);

	}
}

class A {
	{
		System.out.println("non-static initializer of A");
	}

	public A()
	{
		System.out.println("A.A()");
	}

	public A(int a)
	{
		System.out.println("A.A(int)");
	}
}

class B extends A {
	{
		System.out.println("non-static initializer of B");
	}

	public B()
	{
		System.out.println("B.B()");
	}

	public B(int a)
	{
		super(a);
		System.out.println("B.B(int)");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    non-static bloklar non-static metotlar gibidir. Yani non-static elemanlara doğrudan erişilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		A x = new A();
	}
}

class A {
	{
		System.out.println("non-static initializer of A");
		bar();
	}

	public void bar()
	{
		System.out.println("bar");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıfın non-static final veri elemanlarına non-static blok içerisinde değer atanabilir. Şüphesiz daha önce
    değerin atanmamış olması gerekir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Random;
import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Sample s = new Sample();

		System.out.printf("s.val=%d%n", s.val);

		Sample k = new Sample();

		System.out.printf("k.val=%d%n", k.val);
	}
}

class Sample {
	private static final Random RAND = new Random();
	private static final Scanner KB = new Scanner(System.in);
	public final int val;

	{
		System.out.print("min?");
		int min = Integer.parseInt(KB.nextLine());

		System.out.print("max?");
		int max = Integer.parseInt(KB.nextLine());

		val = RAND.nextInt(max - min) + min;
	}
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki örnek aşağıdaki gibi de yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Random;
import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Sample s = new Sample();

		System.out.printf("s.val=%d%n", s.val);

		Sample k = new Sample();

		System.out.printf("k.val=%d%n", k.val);
	}
}

class Sample {
	private static final Random RAND;
	private static final Scanner KB;
	public final int val;

	static {
		RAND = new Random();
		KB = new Scanner(System.in);
	}

	{
		System.out.print("min?");
		int min = Integer.parseInt(KB.nextLine());

		System.out.print("max?");
		int max = Integer.parseInt(KB.nextLine());

		val = RAND.nextInt(max - min) + min;
	}
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağkdaki sınıfta public bölümde hiç static eleman olmadığından müşteri kodlar nesne yaratmadan bu sınıfı
    kullanamazlar. İlk nesne yaratılırken sınıfın static bloğu çalıştırılacağından diğer nesneler aynı MIN ve MAX
    değerlerini kullanacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Random;
import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Sample s = new Sample();

		System.out.printf("s.val=%d%n", s.val);

		Sample k = new Sample();

		System.out.printf("k.val=%d%n", k.val);
	}
}

class Sample {
	private static final Random RAND;
	private static final Scanner KB;
	private static final int MIN;
	private static final int MAX;
	public final int val;

	static {
		RAND = new Random();
		KB = new Scanner(System.in);
		System.out.print("min?");
		MIN = Integer.parseInt(KB.nextLine());

		System.out.print("max?");
		MAX = Integer.parseInt(KB.nextLine());
	}

	{
		val = RAND.nextInt(MAX - MIN) + MIN;
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Türemiş sınıfı içerisinde taban sınıfta bulunan non-static bir veri elemanı ile aynı isimde veri elemanı bildirilebilir.
    Bu durumda türemiş sınıf içerisindeki veri elemanı taban sınıf veri elemanı ismini maskeler (shadowing, masking).
    Aşağıdaki örnekte b referansı ile B içerisinde bildirilen x veri elemanına, a referansı ile a'nın gösterdiği
    B nesnesinin (dinamik türünün) A bölümündeki x veri elemanına erişilir. Artık B türü üzerinden A sınıfının  x veri
    elemanına erişilemez. Bu anlatılanlar sınıf dışından erişimler için geçerlidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		B b = new B();

		b.x = 10;

		System.out.printf("b.x=%d%n", b.x);

		A a = b;

		System.out.printf("a.x=%d%n", a.x);
	}
}


class B extends A {
	public int x;
	//...
}

class A {
	public int x;
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	super referansı ile taban sınıfın bir elemanına erişilebilir. Aşağıdaki örnekte setValues metodu ile hem taban
	hem de türemiş sınıfta aynı isimde bulunan veri elemanlarına atama yapılmıştır. super referansı ile taban sınıfın
	bir metodu da çağrılabilir. Bu konunun detayları ileri ele alınacaktır. Örnekte super.x erişiminde super
	referansının kaldırırarak sonucu inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		B b = new B();

		b.setValues(10, 20);

		System.out.printf("b.x=%d%n", b.x);

		A a = b;

		System.out.printf("a.x=%d%n", a.x);
	}
}


class B extends A {
	public int x;

	public void setValues(int a, int b)
	{
		x = a; //this.x = a;
		super.x = b;
		super.foo();
	}
	//...
}

class A {
	public int x;
	public void foo()
	{

	}
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Türemiş sınıf içerisinde taban sınıfta bulunan static bir veri elemanı ile aynı isimde bir veri elemanı bildirilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		B.setValues(10, 20);
		System.out.printf("B.x=%d%n", B.x);
		System.out.printf("A.x=%d%n", A.x);
	}
}


class B extends A {
	public static int x;

	public static void setValues(int a, int b)
	{
		x = a;
		A.x = b;
	}
	//...
}

class A {
	public static int x;

	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Çok biçimlilik (polymorphism): Biyolojiden programlamaya aktarılmıştır. Biyolojide çok biçimlilik:
	"Farklı doku ya da organların evrim süreci içerisinde temel işlevleri aynı kalması koşuluyla, bu işlevi yerine
	getirme biçiminin değişmesidir"
	şeklinde tanımlanabilir. Örneğin duyma eylemi (davranışı) birbirlerinde türetilmiş canlılar arasında farklılık
	gösterebilir. Fakat görev "duymaktır"

	Nesne yönelimli programlama tekniğinde aşağıda anlatılan çpk biçimliliğe "çalışma zamanı çk biçimliliği (runtime polymorphism")"
	denir. Aslında çok biçimlilik çalışma zamanı ve derleme zamanı çok biçimliliği olarak iki gruba ayrılabilir.
	Biyoloji'den programlamaya aktarılan çok biçimlilik çalışma zamanı çok biçimliliğidir. Çoğu zaman çalışma zamanın
	çok biçimliliği yerine doğprudan "çok biçimlilik" denir.

	Çalışma zamanı çok biçimliliği için çok fazla tanım ya da açıklama yapılabilse de aşağıdaki 3(üç) tanım ile bu kavram
	anlatılabilir:
	1. Biyolojik tanım: Taban sınıfın bir fonksiyonunun türemiş sınıfta yeniden gerçekleştirilmesidir

	2. Yazılım mühendisliği tanım: Türden bapımsız kod yazmaktır. Yani bir kavramın çok sayıda türevi olsa da türevlerden
	bağımsız olarak sadece o kavram üzerinde kod yazmaktır.

	3. Aşağı seviyeli tanım: Önceden yazılmış kodların sonradan yazılmış kodları çağırabilmesidir.

	Java'da çok biçimlilik sanal metotlar (virtual method) kullanılarak gerçekleştirilir. Java' da non-static olan
	ve final olmayan her metot sanaldır. İleride bunun dışında da sanal olan metotlar antalıcaktır.

	Sanal bir metodun türemiş sınıfta geri dönüş değeri ve imzası aynı olacak şekilde yazılmasına "override" denir.
	override işleminde erişim belirleyicinin durumu ileride ele alınacaktır. Yani örneğin
	"public bir metodu override	edebilir miyim?" sorusunın detayları ayrıca cevaplanacaktır. Ancak public bir metot
	public olarak override edilmelidir
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	non-static bir metot çağrısında metot sanal ise derleyici "çalışma zamanında referansın dinamik türüne bak, dinamik
	türe ilişkin sınıfta metot override edilmişse onu çağır" kodunu üretir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		B x = new B();
		A y;

		y = x;

		y.foo();
	}
}

class B extends A {
	public void foo() //override
	{
		System.out.println("B.foo");
	}
}

class A {
	public void foo()
	{
		System.out.println("A.foo");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	non-static bir metot çağrısında metot sanal ise derleyici "çalışma zamanında referansın dinamik türüne bak, dinamik
	türe ilişkin sınıfta metot override edilmişse onu çağır" kodunu üretir.
	Aşağıdaki örnekte main metodunun içindeki müşteri kodu A sınıfından türetilenlerden bağımsız olarak yazılmıştır.
	Yani türden bağımsız yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Factory factory = new Factory();
		Scanner kb = new Scanner(System.in);

		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());

		A x;

		x = factory.getInstance(val);

		x.foo(23);
	}
}


class Factory {
	//...
	public A getInstance(int val)
	{
		return val % 2 == 0 ? new B() : new A();
	}
}

class B extends A {
	public void foo(int val) //override
	{
		System.out.println("B.foo");
	}
}

class A {
	public void foo(int val)
	{
		System.out.println("A.foo");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki örneğe C sınıfı eklenmesine rağmen main içerisinde kodlar bundan etkilenmemiştir (türden bağımsızlık)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Factory factory = new Factory();
		Scanner kb = new Scanner(System.in);

		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());

		A x;

		x = factory.getInstance(val);

		x.foo(23);
	}
}


class Factory {
	//...
	public A getInstance(int val)
	{
		A x;

		if (val > 0)
			x = new B();
		else if (val == 0)
			x = new C();
		else
			x = new A();

		return x;
	}
}

class C extends A {
	public void foo(int val) //override
	{
		System.out.println("C.foo");
	}
}

class B extends A {
	public void foo(int val) //override
	{
		System.out.println("B.foo");
	}
}

class A {
	public void foo(int val)
	{
		System.out.println("A.foo");
	}
}

/*----------------------------------------------------------------------------------------------------------------------
	Sanal metot dinamik türe ilişkin sınıfta override edilmemişse sırasıyla taban sınıflar bakılır. İlk bulunan
	metot çağrılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Factory factory = new Factory();
		Scanner kb = new Scanner(System.in);

		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());

		A x;

		x = factory.getInstance(val);

		x.foo(23);
	}
}


class Factory {
	//...
	public A getInstance(int val)
	{
		A x;

		if (val > 0)
			x = new B();
		else if (val == 0)
			x = new C();
		else
			x = new A();

		return x;
	}
}

class C extends B {

}

class B extends A {
	public void foo(int val) //override
	{
		System.out.println("B.foo");
	}
}

class A {
	public void foo(int val)
	{
		System.out.println("A.foo");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sanal metot dinamik türe ilişkin sınıfta override edilmemişse sırasıyla taban sınıflar bakılır. İlk bulunan
	metot çağrılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Factory factory = new Factory();
		Scanner kb = new Scanner(System.in);

		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());

		A x;

		x = factory.getInstance(val);

		x.foo(23);
	}
}


class Factory {
	//...
	public A getInstance(int val)
	{
		A x;

		if (val > 0)
			x = new B();
		else if (val == 0)
			x = new C();
		else
			x = new A();

		return x;
	}
}

class C extends B {

}

class B extends A {

}

class A {
	public void foo(int val)
	{
		System.out.println("A.foo");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sanal metot dinamik türe ilişkin sınıfta override edilmemişse sırasıyla taban sınıflar bakılır. İlk bulunan
	metot çağrılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Factory factory = new Factory();
		Scanner kb = new Scanner(System.in);

		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());

		A x;

		x = factory.getInstance(val);

		x.foo(23);
	}
}


class Factory {
	//...
	public A getInstance(int val)
	{
		A x;

		if (val > 0)
			x = new B();
		else if (val == 0)
			x = new C();
		else
			x = new A();

		return x;
	}
}

class C extends B {
	public void foo(int val)
	{
		System.out.println("C.foo");
	}
}

class B extends A {

}

class A {
	public void foo(int val)
	{
		System.out.println("A.foo");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bazen override edilen metot içerisinde taban sınıfının ilgili metodu da çağrılmak istenebilir. Bu durumda
	super referansı kullanılmalıdır. Bu işleme "augmatation" da denir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Factory factory = new Factory();
		Scanner kb = new Scanner(System.in);

		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());

		A x;

		x = factory.getInstance(val);

		x.foo(23);
	}
}


class Factory {
	//...
	public A getInstance(int val)
	{
		A x;

		if (val > 0)
			x = new B();
		else if (val == 0)
			x = new C();
		else
			x = new A();

		return x;
	}
}

class C extends B {
	public void foo(int val)
	{
		System.out.println("C.foo");
		super.foo(val); //augmetation
	}
}

class B extends A {
	public void foo(int val)
	{
		System.out.println("B.foo");
		super.foo(val); //augmetation
	}
}

class A {
	public void foo(int val)
	{
		System.out.println("A.foo");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki örneğe D sınıfı eklenmesine rağmen yine müşteri kodları etkilenmemiştir. Ayrıca taban sınıfın
	ilgili metodunu çağırma kuralına D için de bu senaryoda uyulduğundan D için de program doğru çalışmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Factory factory = new Factory();
		Scanner kb = new Scanner(System.in);

		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());

		A x;

		x = factory.getInstance(val);

		x.foo(23);
	}
}


class Factory {
	//...
	public A getInstance(int val)
	{
		A x;

		if (val > 0)
			x = new B();
		else if (val == 0)
			x = new C();
		else
			x = new D();

		return x;
	}
}

class D extends C {
	public void foo(int a)
	{
		System.out.println("D.foo");
		super.foo(a);
	}
}

class C extends B {
	public void foo(int val)
	{
		System.out.println("C.foo");
		super.foo(val); //augmetation
	}
}

class B extends A {
	public void foo(int val)
	{
		System.out.println("B.foo");
		super.foo(val); //augmetation
	}
}

class A {
	public void foo(int val)
	{
		System.out.println("A.foo");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	CompanyApp örneği
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
        ProjectWorker projectWorker = new ProjectWorker("12345678964", "Halis", "Şişli", 6, 100, 1000);
        HumanResources humanResources = new HumanResources();

        humanResources.payInsurance(worker);
        humanResources.payInsurance(manager);
        humanResources.payInsurance(salesManager);
        humanResources.payInsurance(projectWorker);
    }
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

    public double calculatePayment()
    {
        return 0;
    }
    //...
}

package org.csystem.app.samples.companyapp;

public class HumanResources {
    public void payInsurance(Employee employee)
    {
        System.out.printf("CitizenId:%s%n", employee.getCitizenId());
        System.out.printf("Name:%s%n", employee.getName());

        System.out.printf("Payment:%f%n", employee.calculatePayment());
    }
    //...
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

    public double calculatePayment()
    {
        return m_salary * 1.5;
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

    public double calculatePayment()
    {
        return super.calculatePayment() + m_extra;
    }
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

    public double calculatePayment()
    {
        return m_feePerHour * m_hourPerDay * 30;
    }
}


package org.csystem.app.samples.companyapp;

public class ProjectWorker extends Worker {
    private double m_extra;

    public ProjectWorker(String citizenId, String name, String address, int hourPerDay, double feePerHour, double extra)
    {
        super(citizenId, name, address, hourPerDay, feePerHour);
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

    public double calculatePayment()
    {
        return super.calculatePayment() + m_extra * 30;
    }
}

/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/
```
