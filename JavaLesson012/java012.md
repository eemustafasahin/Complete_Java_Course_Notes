```java
/*----------------------------------------------------------------------------------------------------------------------
	25.07.2020
	Aşağıdaki maddelerde aksi belirtilmediği sürece "sınıf" kavramı aslında "tür" kavramı olarak
	kullanılacaktır. Burada "tür" temel türler dışında kalan programcının belirlediği türlerdir (user defined types).
	Yani tüm referans türleri için geçerli olacaktır.
	
	Paketler:

	- javac her sınıf için ayrı bir .class uzantılı dosya (byte code) üretir. Bu işlem
	sınıflar aynı java dosyasında olsa bile yapılır.

  	- Bir .class dosyasının ait olduğu pakete ilişkin bir dizinde (directory) bulunması gerekir.
	Aslında java dosyaları için böyle bir zorunluluk yoktur. Ancak bir çok IDE bunu kendi içinde 
	zorunlu tutar.

  	- Bir sınıf herhangi bir pakette olabilir. Bir proje içerisinde kullanılan sınıfların aynı pakette
  	olma zorunluluğu yoktur

  	- Bir paket içerisinde bildirilen bir sınıfın farklı bir paketten kullanılabilmesi için
  	public olarak bildirilmesi gerekir. public olarak bildirilmeyen bir sınıf ancak
  	aynı paketteki diğer sınıflar tarafından kullanılabilir (friendly, internal)

  	- Farklı paketlerdeki sınıflar için byte kodların da uygun yerde olması gerekir. Uygulamanın çalışmaya
  	başlatıldığı dizin tüm paketlerin olması gereken dizindir. Ancak bu durumun istisnaları olabilir

  	- Uygulamada kullanılan sınıflar içerisinde bir tane main metodu olmak zorunda değildir.
  	Ancak şüphesiz java programına verilen byte koda ilişkin sınıfta (bu kesinlike sınıf olmalı)
  	mutlaka uygun main metodunun olması gerekir. main metodunun aşağıdaki yapıya sahip olması gerekir.
  		public static void main(String [] args)
  	java programına verilen main metoduna giriş noktası (entry point) denilmektedir

  	- public olarak bildirilen bir sınıfın kendi ismiyle aynı isimde bir .java uzantılı dosyada olması
  	zorunludur.

  	- Bir .java uzantılı dosyanın içerisinde yalnızca dosya ismi ile aynı olan sınıf public olarak
  	bildirilebilir.

  	- Bir .java dosyası içerisinde public sınıf olmak zorunda değildir. public sınıf olacaksa dosya ismi
  	ile aynı isimde olan sınıf ancak public olabilir.

	- Bir .java dosyası içerisinde public olmayan istenildiği kadar sınıf yazılabilir. Bu sınıflar aynı pakette 
	bildirilmiş olur.
	
  	- Bir java dosyası içerisinde dosya ismi ile aynı isimde sınıf olmak zorunda değildir  	

  	- Bir paket içerisinde aynı isimde birden fazla sınıf bildirimi yapılamaz. Aynı java dosyası veya farklı 
  	java dosyası içerisinde olmak bu durumu değiştirmez
  	
  	- Farklı paketler içerisinde aynı isimde sınıflar olabilir

  	- Bir java dosyası içerisindeki sınıflar o java dosyasının başında bildirilen paket içerisinde
  	 olurlar.

  	- Bir java dosyasında farklı paket bildirimleri yapılamaz

  	- Hiç bir paket bildirimi olmayan java dosyalarında bildirilen sınıflar isimsiz paket (unnamed package) 
  	denilen bir paket içerisinde kabul edilir. Ancak projelerde isimsiz paket içerisinde sınıf bildirimi 
  	yapılmamalıdır.

  	 - Bir sınıfa onun bulunduğu paket dışında başka bir paketin içerisinde, paket ismi ve nokta operatörü
	ile erişilebilir

  	- Bir paket içerisinde alt paketler olabilir. Alt paketler
  		package <paket ismi>.<alt paket ismi>.<al paket isimi>...;

  	  biçiminde bildirilir. Alt paketlerde bulunan sınıfların .class dosyaları (byte code) paket
  	  hiyararşisine uygun alt dizinlerde bulunmalıdır.

  	- Paketler içiçe bile olsa farklı paketlerdir. Yani örneğin org.csystem.util paketi içerisinde
  	ArrayUtil sınıfı varsa org.csystem paketi içerisinde de ArrayUtil sınıfı olabilir.
  	Bu isimler kesinlikle çakışmaz

  	- Paket isimleri genelde firmaya ilişkin tekil bir bilgi olan domain isimleri ile
	belirlenir. Örneğin CSD firmasının paketleri ve sınıfları domain adresi "csystem.org"
	olduğundan "org.csystem" paketi altında yazılabilir. Bu şekilde yaklaşıma uyulmalıdır.

	- java nın standart tüm paketleri ve sınıfları java isimli bir paket altında toplanmıştır

	- java.lang isimli paket altında bulunan tüm sınıflar her yerden görülebilirdir. Yani
	buradaki isimleri paket ismi ile kombine etmeye gerek yoktur (import bildirimi olmadan da kullanılabilir)
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	java.lang paketi altındaki tüm sınıflar heryerden görülebilirdir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {	
	public static void main(String [] args) 
	{	
		String s = "ankara"; //java.lang.String s = "ankara";
		System.out.println("Merhaba"); //java.lang.System.out.println("Merhaba");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Point sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math.geometry;

public class Point {
	public int x;
	public int y;
	
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
		return Math.sqrt((x - a) * (x - a) + (y - b) * (y - b));								
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
```java
/*----------------------------------------------------------------------------------------------------------------------
	Complex sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math;

public class Complex {
	public static Complex add(double re1, double im1, double re2, double im2) //İleride gizlenecek
	{
		Complex z = new Complex();
		
		z.re = re1 + re2;
		z.im = im1 + im2;
		
		return z;
	}
	
	public static Complex subtract(double re1, double im1, double re2, double im2) //İleride gizlenecek
	{
		return add(re1, im1, -re2, -im2);
	}
	
	public double re;
	public double im;
	
	public Complex()
	{
		
	}
	
	public Complex(int a)
	{
		re = a;
	}
	
	public Complex(int a, int b)
	{
		re = a;
		im = b;
	}
	
	public Complex getConjugate()
	{
		Complex z = new Complex();
		
		z.re = re;
		z.im = -im;
		
		return z;
	}
	
	public double getNorm()
	{
		return Math.sqrt(re * re + im * im);
	}
	
	//add
	public static Complex add(double a, Complex z)
	{
		return add(a, 0, z.re, z.im);				
	}
	
	public Complex add(Complex z)
	{
		return add(re, im, z.re, z.im);
	}
	
	public Complex add(double a)
	{
		return add(re, im, a, 0);		
	}
	
	//subtract
	public static Complex subtract(double a, Complex z)
	{
		return subtract(a, 0, z.re, z.im);				
	}
	
	public Complex subtract(Complex z)
	{
		return subtract(re, im, z.re, z.im);
	}
	
	public Complex subtract(double a)
	{
		return subtract(re, im, a, 0);		
	}
	
	public void offset(double dxy)
	{
		offset(dxy, dxy);
	}	
	
	public void offset(double dx, double dy)
	{
		re += dx;
		im += dy;
	}
	
	public String toString()
	{
		return String.format("|%.2f + %.2f * i| = %f", re, im, getNorm());
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	PointF sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math.geometry;

public class PointF {
	public float x;
	public float y;
	
	public PointF()
	{		
	}
	
	public PointF(float a)
	{
		x = a;
	}
	
	public PointF(float a, float b)
	{
		x = a;
		y = b;
	}
	
	public double distance(Point p)
	{
		return distance(p.x, p.y);				
	}
	
	public double distance(float a, float b)
	{
		return Math.sqrt((x - a) * (x - a) + (y - b) * (y - b));								
	}
	
	public void offset(float dxy)
	{
		offset(dxy, dxy);
	}
	
	public void offset(float dx, float dy)
	{
		x += dx;
		y += dy;
	}
	
	public String toString()
	{
		return String.format("{x: %f, y: %f}", x, y);
	}	
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	DateApp uygulaması
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {	
	public static void main(String [] args) 
	{	
		org.csystem.app.samples.dateapp.DateUtilApp.run();		
	}
}
/*----------------------------------------------------------------------------------------------------------------------	
	Sınıf çalışması: Parametresi ile aldığı int türden gün, ay ve yıl bilgilerine ilişkin tarihin aşağıdaki 
	açıklamalara göre haftanın hangi gününe geldiğini döndüren getDayOfWeek metodunu yazınız.
	Açıklamalar: 
		- Metot geçersiz bir tarih için -1 değerini döndürecektir.
		- Haftanın günü 1.1.1900 ile verilen tarih arasındaki gün sayısının 7 değerine modu alınarak bulunabilir
		- 7 değerine mod alındıktan sonra sıfır Pazar, 1 pazartesi, .., 6 cumartesi günü için
		elde edilecek değerdir
		- 1.1.1900' den önceki tarihler geçersiz kabul edilecektir 
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.samples.dateapp;

public class DateUtilApp {
	public static void displayTR(int day, int month, int year)
	{
		int dayOfWeek = DateUtil.getDayOfWeek(day, month, year);
		
		if (dayOfWeek == -1) {
			System.out.println("Geçersiz tarih");
			return;
		}
		
		switch (dayOfWeek) {
		case 0:
			System.out.printf("%02d/%02d/%04d Pazar%n", day, month, year);
			break;
		case 1:
			System.out.printf("%02d/%02d/%04d Pazartesi%n", day, month, year);
			break;
		case 2:
			System.out.printf("%02d/%02d/%04d Salı%n", day, month, year);
			break;
		case 3:
			System.out.printf("%02d/%02d/%04d Çarşamba%n", day, month, year);
			break;
		case 4:
			System.out.printf("%02d/%02d/%04d Perşembe%n", day, month, year);
			break;
		case 5:
			System.out.printf("%02d/%02d/%04d Cuma%n", day, month, year);
			break;
		case 6:
			System.out.printf("%02d/%02d/%04d Cumartesi%n", day, month, year);
			break;			
		}
		
		if (dayOfWeek == 0 || dayOfWeek == 6)
			System.out.println("Bugün kurs var. Tekrar yaptınız mı?");
		else
			System.out.println("Kurs günü yaklaşıyor. Tekrar yapınız!!!!");		
		
	}
	
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Gün bilgisini giriniz:");
			int day = Integer.parseInt(kb.nextLine());
			
			if (day == 0)
				break;
			
			System.out.print("Ay bilgisini giriniz:");
			int month = Integer.parseInt(kb.nextLine());
			
			System.out.print("Yıl bilgisini giriniz:");
			int year = Integer.parseInt(kb.nextLine());
			
			displayTR(day, month, year);		
		}	
		
	}
}


package org.csystem.app.samples.dateapp;

public class DateUtil {
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
		
		switch (month - 1) {
		case 11:
			dayOfYear += 30;
		case 10:
			dayOfYear += 31;
		case 9:
			dayOfYear += 30;
		case 8:
			dayOfYear += 31;
		case 7:
			dayOfYear += 31;
		case 6:
			dayOfYear += 30;
		case 5:
			dayOfYear += 31;
		case 4:
			dayOfYear += 30;
		case 3:
			dayOfYear += 31;
		case 2:
			dayOfYear += isLeapYear(year) ? 29 : 28;			
		case 1:
			dayOfYear += 31;
		}
		
		return dayOfYear;
	}
	
	public static boolean isValidDate(int day, int month, int year)
	{
		if (day < 1 || day > 31 || month < 1 || month > 12)
			return false;
		
		int days = 31;
		
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 2:
			days = isLeapYear(year) ? 29 : 28;			
		}
		
		return day <= days;
	}
	
	public static boolean isLeapYear(int year)
	{
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	StringUtil sınıfı  
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

public class StringUtil {
  
    public static String capitalize(String s)
    {
		if (s.isEmpty())
			return s;
			
		return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();			
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
	
		    if (Character.isLetter(ch))
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

    public static String getRandomText(java.util.Random r, int n, String alphabet) 
    {
		String str = "";
	
		for (int i = 0; i < n; ++i) {
		    char ch = alphabet.charAt(r.nextInt(alphabet.length()));
	
		    if (r.nextBoolean())
			ch = Character.toUpperCase(ch);
	
		    str += ch;
		}
	
		return str;
    }    

    public static String getRandomTextEN(int n) 
    {
    	return getRandomTextEN(new java.util.Random(), n);
    }

    public static String getRandomTextEN(java.util.Random r, int n) 
    {
    	return getRandomText(r, n, "abcdefghijklmnopqrstuwxvyz");
    }

    public static String getRandomTextTR(int n) 
    {
    	return getRandomTextTR(new java.util.Random(), n);
    }

    public static String getRandomTextTR(java.util.Random r, int n) 
    {
    	return getRandomText(r, n, "abcçdefgğhıijklmnoöprsştuüvyz");
    }   
  
    public static boolean isPalindrome(String s)
	{
		int left = 0;
		int right = s.length() - 1;
		
		while (left < right) {
			char chLeft = Character.toLowerCase(s.charAt(left));
			
			if (!Character.isLetter(chLeft)) {
				++left;
				continue;
			}
			
			char chRight = Character.toLowerCase(s.charAt(right));
			
			if (!Character.isLetter(chRight)) {
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
    	return isPangram(text.toLowerCase(), "abcdefghijklmnopqrstuwxvyz");
    }

    public static boolean isPangramTR(String text) 
    {
    	return isPangram(text.toLowerCase(), "abcçdefgğhıijklmnoöprsştuüvyz");
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
	
		    if (!Character.isWhitespace(ch))
			str += ch;
		}
	
		return str;
    }

    public static String repeat(int n, char ch) 
    {
		String s = "";
	
		while (n-- > 0)
		    s += ch;
	
		return s;
    }

    public static String reverse(String str) 
    {
		String revStr = "";
	
		for (int i = str.length() - 1; i >= 0; --i)
		    revStr += str.charAt(i);
	
		return revStr;
    }

    public static String trimLeft(String s) 
    {
		int i;
		int len = s.length();
	
		for (i = 0; i < len && Character.isWhitespace(s.charAt(i)); ++i)
		    ;
	
		return s.substring(i);
    }

    public static String trimRight(String s) 
    {
		int i;
	
		for (i = s.length() - 1; i >= 0 && Character.isWhitespace(s.charAt(i)); --i)
		    ;
	
		return s.substring(0, i + 1);
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	NumberUtil sınıfı  
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

public class NumberUtil {	
	public static int factorial(int n)
	{
		if (n < 0)
			return -1;
		
		int result = 1;
		
		for (int i = 2; i <= n; ++i)
			result *= i;
		
		return result;
	}
	
	public static int getDigitsCount(long val)
	{	
		return val == 0 ? 1 : (int)Math.log10(Math.abs(val)) + 1;
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
		val = Math.abs(val);
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
		
		int sqrtVal = (int) Math.sqrt(val);
		
		for (int i = 11; i <= sqrtVal; i += 2)
			if (val % i == 0)
				return false;
		
		return true;			 
	}
		
	public static int max(int a, int b, int c)
	{
		return Math.max(Math.max(a, b), c);
	}	

	public static int min(int a, int b, int c)
	{
		return Math.min(Math.min(a, b), c);
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
	İsim arama (name lookup): Derleyici kullanılan bir ismi gördüğünde o ismi önce arar. Eğer bulursa doğru
	kullanılıp kullanılmadığına bakar. Derleyici isim aramayı belirli kurallara göre yapar. Burada anlatılacak
	kuralların dışında başka detaylar da vardır. Bunlar daha sonra ele alınacaktır. Yani buradaki kuralları genel 
	kurallar olarak düşünmelisiniz. İstisnaları zaten ayrı kurallardır  
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Derleyici bildirim sırasındaki isimleri aramaz. Zaten bu bildirimdir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {	
	public static void main(String [] args) 
	{	
		int a; // a aranmaz
						
	}
}

class Sample { // Sample aranmaz
	public int a; //a aranmaz
	
	public void foo() //foo aranmaz
	{
		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir isim programlamada iki türlü kullanılabilir: nitelikli (qualified), niteliksiz (unqualified)
	
	Bir isim doğrudan veya nokta operatörünü solunda kalmışsa (yani solunda nokta operatörü yoksa)
	niteliksiz kullanılmış olur ve niteliksiz isim arama (unqualified name lookup) kurallarına göre aranır.
	
	Bir isim nokta operatörünün sağında kullanılmışsa nitelikli kullanılmış olur ve nitelikli isim arama 
	(qualified name lookup) kurallarına göre aranır.
	
	Özetle:
	Bir isim nokta operatörünün sağında kalıyorsa nitelikli, kalmıyorsa niteliksiz aranır
	
	Anahtar Notlar: Yukarıdaki tamımlardaki nitelikli veya niteliksiz olumlu ve olumsuz bir etki anlamında 
	düşünülmemelidir
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Nitelikli ve niteliksiz kullanım
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {	
	public static void main(String [] args) 
	{	
		int a; // a aranmaz	
		
		a = 10; // a niteliksiz aranır
		
		Sample s; // Sample niteliksiz aranır, s aranmaz
		
		s = new Sample(); //s niteliksiz, Sample niteliksiz aranır
		
		s.foo(); // s niteliksiz, foo nitelikli aranır
		s.a = 24; // s nitelikisiz, a nitelikli aranır
	}
}

class Sample { // Sample aranmaz
	public int a; //a aranmaz
	
	public void foo() //foo aranmaz
	{
		//..				
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Derleyici bir ismi bulduktan sonra doğru kullanılıp kullanılmadığına bakar. Aşağıdaki örnekte derleyici
	a ismini bulmuştur ancak kullanım hatasından dolayı error oluşur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {	
	public static void main(String [] args) 
	{	
		int a;
		
		a = 2.3; //error
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte isim bulunamadığından dolayı error oluşur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {	
	public static void main(String [] args) 
	{	
		int a;
		
		x = 2.3; //error
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Niteliksiz isim arama kuralları (else if biçiminde değerlendiriniz)
	1. Bir isim metot içerisinde kullanılmışsa, kullanıldığı yerden yukarıya doğru metot içerisinde aranır. Burada
	isim için parametre değişkenlerine de bakılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {	
	public static void main(String [] args) 
	{	
		int a;
		
		a = 34;
	}
}

class Sample {
	public void foo(int x) 
	{
		int a;
		
		a = x;
		//...
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Niteliksiz isim arama kuralları (else if biçiminde değerlendiriniz)
	2. İsim metot içerisinde bulunamazsa metodun ait olduğu sınıfın tamamında ancak tüm metotların dışında aranır. 
	Burada sınıf içerisinde bulunamazsa taban sınıflara (super class) da bakılır. Taban sınıf konusu işleride
	ele alınacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {	
	public static void main(String [] args) 
	{	
		Sample s = new Sample();
		
		s.foo(67);
		
		System.out.println(s.a);		
	}
}

class Sample {	
	public void foo(int b)
	{
		a = b;
	}
	
	public int a;
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki iki kurala göre bir sınıfın veri elemanı ile aynı isimde olan metot parametre değişkenleri
	veya yerel değişkenler olabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {	
	public static void main(String [] args) 
	{	
		Sample s = new Sample();
		
		s.foo(67);
		
		System.out.println(s.a);	
		
	}
}

class Sample {
	public int a;
	
	public void foo(int b)
	{
		int a; //shadowing
		
		a = b;
	}
	
	
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki iki kurala göre bir sınıfın veri elemanı ile aynı isimde olan metot parametre değişkenleri
	veya yerel değişkenler olabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {	
	public static void main(String [] args) 
	{	
		Sample s = new Sample();
		
		s.foo(67);
		
		System.out.println(s.a);	
		
	}
}

class Sample {
	public int a;
	
	public void foo(int a)
	{		
		a = a;
	}	
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Niteliksiz isim arama kuralları (else if biçiminde değerlendiriniz)
	3. Sınıfın ait olduğu paket içerisinde aranır. Burada alt paketlere veya üst paketlere bakılmaz, 
	sadece ait olduğu pakete bakılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {	
	public static void main(String [] args) 
	{	
		Sample s = new Sample(); //error
		
		s.foo(67);
		
		System.out.println(s.a);		
	}
}

package org.csystem;

public class Sample {
	public void foo(int b)
	{
		a = b;
	}
	
	public int a;
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Niteliksiz isim arama kuralları (else if biçiminde değerlendiriniz)
	3. Sınıfın ait olduğu paket içerisinde aranır. Burada alt paketlere veya üst paketlere bakılmaz, 
	sadece ait olduğu pakete bakılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {	
	public static void main(String [] args) 
	{	
		Sample s = new Sample(); //error
		
		s.foo(67);
		
		System.out.println(s.a);		
	}
}


package org.csystem.app.test;

public class Sample {
	public void foo(int b)
	{
		a = b;
	}
	
	public int a;
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki kurala göre isimsiz paket altında bulunan bir sınıfa bir paket içerisinden erişilemez.
	Sadece bu sebepten dolayı bile isimsiz paket altına bir sınıf konmamalıdır
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Niteliksiz isim arama kuralları (else if biçiminde değerlendiriniz)
	4. Yıldızlı import bildirimi (import on demand declaration) varsa o pakatlere de bakılır. Bu konu ileride
	ele alınacaktır
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki arama işleminde sonuna kadar hiçbir yerde bulamazsa error oluşur	
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Nitelikli isim arama kuralları (else if biçiminde değerlendiriniz)
	1. Aranacak ismin solunda sınıf ismi varsa isim ilgili sınıf içerisinde aranır. Bulunamazsa taban sınıflara da
	bakılır 	
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {	
	public static void main(String [] args) 
	{	
		Sample.foo();
		Sample.x = 10;
	}
}


class Sample {
	public static int x;
	
	public static void foo()
	{
		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Nitelikli isim arama kuralları (else if biçiminde değerlendiriniz)
	2. Aranacak ismin solunda referans ismi varsa isim referansa ilişkin sınıfın içerisinde aranır. Bulunamazsa taban 
	sınıflara da bakılır 	
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {	
	public static void main(String [] args) 
	{	
		Sample s = new Sample();
		
		s.foo();
		s.x = 10;
	}
}


class Sample {
	public int x;
	
	public void foo()
	{
		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Nitelikli isim arama kuralları (else if biçiminde değerlendiriniz)
	3. Aranacak ismin solunda bir paket ismi varsa bu durumda isim paket içerisinde aranır. Alt ya da üst paketlere
	bakılmaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {	
	public static void main(String [] args) 
	{	
		test.Sample s;		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Alt paket isimleri niteliksiz aramaya dahil değildir. Yani aşağıdaki örnekte test isimli 
	paket org.csystem.app paketi içerisinde paket ismi olduğu için dikkate alınmaz. Bir paket 
	isminin niteliksiz aranması için global düzeyde olması gerekir. Yani üst paketinin
	olmaması gerekir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {	
	public static void main(String [] args) 
	{	
		test.Sample s; //error
	}
}


package org.csystem.app.test;

public class Sample {

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	import bildirimi genel olarak bir tür ismi için niteliklendirmeyi azaltmak, dolayısıyla daha 
	kolay ve açık (clean) kod yazımı için vardır. 
	import bildirimleri bir kütüphaneyi "import etmek" anlamına gelmez.
	
	import bildirimi iki şekilde kullanılabilir:
	1. Yıldızlı import bildirimi (import on demand declaration)
	2. Yıldızsız import bildirimi (import single type declaration) 
	
	import bildirimleri paket bildiriminden sonra diğer bildirimlerden önce yazılmalıdır. import bildirimleri
	nasıl kullanılırsa kullanılsın yazılma sırasının önemi yoktur.
	
	import bildirimleri niteliksiz kullanım için geçerlidir. Nitelikli kullanımda import bildirimlerinin etkisi olmaz
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yıldızlı import bildiriminin (import on demand declaration): 
	import <paket ismi>.[paket ismi.paketismi listesi].*;
	
	Yıldızlı import bildirimi niteliksiz bir isim paket içerisinde de bulunamazsa arama için bakılacak paketi temsil 
	eder. Yani adeta bir paketin başka paket içerisine isim arama anlamında enjekte edilmesidir. Her zmaan
	olduğu gibi yıldızlı import bildirimi ile yazılan paketlerde bulunamama durumunda alt ya da üst paketlere
	bakılmaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.*;
import org.csystem.math.*;
import org.csystem.math.geometry.*;

class App {	
	public static void main(String [] args) 
	{	
		Random r;
		Complex z;
		Point p;
		//...
		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yıldızlı import bildiriminin (import on demand declaration): 
	import <paket ismi>.[paket ismi.paketismi listesi].*;
	
	Yıldızlı import bildirimi niteliksiz bir isim paket içerisinde de bulunamazsa arama için bakılacak paketi temsil 
	eder. Yani adeta bir paketin başka paket içerisine isim arama anlamında enjekte edilmesidir. Her zmaan
	olduğu gibi yıldızlı import bildirimi ile yazılan paketlerde bulunamama durumunda alt ya da üst paketlere
	bakılmaz
	
	Daha açık olarak yıldızlı import bildirimi derleyiciye "eğer niteliksi bir ismi pakette de bulamazsan bu paketlere de bak"
	anlamına gelir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.*;
import org.csystem.math.*;
import org.csystem.math.geometry.*;

class App {	
	public static void main(String [] args) 
	{	
		Random r;
		Complex z;
		Point p;
		//...
		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yıldızlı import bildirimlerine paketlerin hepsine bakılır. Birden fazla paket içerisinde bulunursa
	yine error oluşur (ambiguity)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import test.*;
import mest.*;

class App {	
	public static void main(String [] args) 
	{	
		Mample m;
		Sample s; //error: ambiguity
		
		//...		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki problemin bir çözümü
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import test.*;
import mest.*;

class App {	
	public static void main(String [] args) 
	{	
		Mample m;
		test.Sample s;
		mest.Sample s1;
		
		//...		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte yıldızlı import deyimi ile nitelikdirme azaltılmıştır. Daha okunabilir bir kod yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.*;
import org.csystem.math.geometry.*;

class App {	
	public static void main(String [] args) 
	{	
		Scanner kb = new Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int count = Integer.parseInt(kb.nextLine());
		
		Random r = new Random();
		
		for (int i = 0; i < count; ++i) {
			Point p = new Point(r.nextInt(100), r.nextInt(100));
			
			System.out.println(p.toString());
		}
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yıldızsız import bildiriminin (import single type declaration) genel biçimi:
	import <paket ismi>.[alt paketler].<sınıf ismi>; 
	
	Not: Burada sınıf ismi bir user defined type anlamındadır.
	
	Bu bildirim sınıf isminin doğrudan kullanılacağını belirtir. Bu bildirimin yazılabildiği durumda bu isim için klasik isim
	arama yapılmaz. Yani niteliksiz isim arama kuralları bu isim için uygulanmaz. Programc münkün olduğunca bu import
	deyimini tercih etmelidir. Zaten bir çok IDE de programcıyı bu şekilde yönlendirir
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte 
		import java.util.Scanner
	bildirimi bu dosyada Scannner ismi doğrudan kullanıldığında java.util.Scanner olarak anlaşılsın demektir  
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Random;
import java.util.Scanner;
import org.csystem.math.geometry.Point;

class App {	
	public static void main(String [] args) 
	{	
		Scanner kb = new Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int count = Integer.parseInt(kb.nextLine());
		
		Random r = new Random();
		
		for (int i = 0; i < count; ++i) {
			Point p = new Point(r.nextInt(100), r.nextInt(100));
			
			System.out.println(p.toString());
		}
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	26.07.2020
	Aşağıdaki durumda Sample isminin niteliksiz kullanımına ilişkin birden fazla yıldızsız import bildirimi
	yapılmaya çalışıldığından error oluşur. Burada Sample isminin doğrudan kullanılması gerekmez. Hata import
	bildiriminde oluşur  
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import test.Sample;
import mest.Sample; //error:

class App {	
	public static void main(String [] args) 
	{	
		Sample s = new Sample();
		
		s.foo();        		
	}
}


package test;

public class Sample {
	public void foo()
	{
		System.out.println("test.Sample.foo");
	}
}	

package mest;

public class Sample {
	public void foo()
	{
		System.out.println("mest.Sample.foo");
	}
}	
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	  Aşağıdaki örnekte yıldızsız import direktifi dolayısıyla test.Sample sınıfının foo metodu çağrılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import test.Sample;

class App {	
	public static void main(String [] args) 
	{	
		Sample s = new Sample();
		
		s.foo();
	}
}

package test;

public class Sample {
	public void foo()
	{
		System.out.println("test.Sample.foo");
	}
}

package org.csystem.app;

public class Sample {
	public void foo()
	{
		System.out.println("org.csystem.app.Sample.foo");
	}
}	
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Aşağıdaki örnekte import bildirimine ilişkin java dosyasında Sample sınıfı zaten olduğundan yani bu java
	 dosyasında Sample ismi adeta rezerve edilmiş olduğunda aşağıdaki gibi yıldızsız import bildirimi geçersizdir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import test.Sample; //error

class App {	
	public static void main(String [] args) 
	{	
		Sample s = new Sample();
		
		s.foo();
	}
}


class Sample {
	public void foo()
	{
		System.out.println("org.csystem.app.Sample.foo");
	}
}	

package test;

public class Sample {
	public void foo()
	{
		System.out.println("test.Sample.foo");
	}
}	
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	StringUtil sınıfı  
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Random;

public class StringUtil {  
    public static String capitalize(String s)
    {
		if (s.isEmpty())
			return s;
			
		return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();			
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
	
		    if (Character.isLetter(ch))
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

    public static String getRandomText(Random r, int n, String alphabet) 
    {
		String str = "";
	
		for (int i = 0; i < n; ++i) {
		    char ch = alphabet.charAt(r.nextInt(alphabet.length()));
	
		    if (r.nextBoolean())
			ch = Character.toUpperCase(ch);
	
		    str += ch;
		}
	
		return str;
    }    

    public static String getRandomTextEN(int n) 
    {
    	return getRandomTextEN(new Random(), n);
    }

    public static String getRandomTextEN(Random r, int n) 
    {
    	return getRandomText(r, n, "abcdefghijklmnopqrstuwxvyz");
    }

    public static String getRandomTextTR(int n) 
    {
    	return getRandomTextTR(new Random(), n);
    }

    public static String getRandomTextTR(Random r, int n) 
    {
    	return getRandomText(r, n, "abcçdefgğhıijklmnoöprsştuüvyz");
    }   
  
    public static boolean isPalindrome(String s)
	{
		int left = 0;
		int right = s.length() - 1;
		
		while (left < right) {
			char chLeft = Character.toLowerCase(s.charAt(left));
			
			if (!Character.isLetter(chLeft)) {
				++left;
				continue;
			}
			
			char chRight = Character.toLowerCase(s.charAt(right));
			
			if (!Character.isLetter(chRight)) {
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
    	return isPangram(text.toLowerCase(), "abcdefghijklmnopqrstuwxvyz");
    }

    public static boolean isPangramTR(String text) 
    {
    	return isPangram(text.toLowerCase(), "abcçdefgğhıijklmnoöprsştuüvyz");
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
	
		    if (!Character.isWhitespace(ch))
			str += ch;
		}
	
		return str;
    }

    public static String repeat(int n, char ch) 
    {
		String s = "";
	
		while (n-- > 0)
		    s += ch;
	
		return s;
    }

    public static String reverse(String str) 
    {
		String revStr = "";
	
		for (int i = str.length() - 1; i >= 0; --i)
		    revStr += str.charAt(i);
	
		return revStr;
    }

    public static String trimLeft(String s) 
    {
		int i;
		int len = s.length();
	
		for (i = 0; i < len && Character.isWhitespace(s.charAt(i)); ++i)
		    ;
	
		return s.substring(i);
    }

    public static String trimRight(String s) 
    {
		int i;
	
		for (i = s.length() - 1; i >= 0 && Character.isWhitespace(s.charAt(i)); --i)
		    ;
	
		return s.substring(0, i + 1);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Aşağıdaki örnekte Pointe'lerden bir tanesi yıldızsız ise diğeri nitelikli kullanılmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.geometry.Point;
import test.*;

class App {	
	public static void main(String [] args) 
	{	
		Point p1 = new Point();
		test.Point p2 = new test.Point();
		
		//...
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Aşağıdaki örnekte import bildirimleri ile nitaliklendirme azaltılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Random;
import java.util.Scanner;
import org.csystem.util.NumberUtil;

class App {	
	public static void main(String [] args) 
	{	
		Scanner kb = new Scanner(System.in);
		System.out.print("Bir sayı giriniz");
		int n = Integer.parseInt(kb.nextLine());	
		
		Random r = new Random();
		
		for (int i = 0; i < n; ++i) {			
			int val = r.nextInt(100);			
			
			System.out.printf("%d sayısı %s%n", val, NumberUtil.isPrime(val) ? "asaldır" : "asal değildir");			
		}
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Java 5 ile birlikte import static bildirimleri eklenmiştir. import static bildirimlerinin de iki
	 biçimi vardır:
	 1. Yıldızlı import static bildirimi (import static on demand declaration)
	 2. Yıldızsız import static bildirimi (import static single type declaration)
	 
	 import static bildirimlerinde okunabilirliği etkileyen durumlar olabilir. Buna dikkat edilmelidir.
	 import static bildirimleri import bildirimleri ile aynı yerde yazılır. Herhangi bir şekilde sıranın
	 önemi olmaz
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yıldızlı import static bildiriminin genel biçimi:
	import static <paket ismi>.[alpaket listesi].<tür ismi>.*;
	
	Bu bildirim ile bildirimin yapıldığı java dosyasında bildirime ilişkin tüm static elemanlar doğurdan 
	kullanılabilir duruma gelir.	
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import static java.lang.Math.*;
import static org.csystem.util.NumberUtil.*;
import java.util.Random;

class App {	
	public static void main(String [] args) 
	{	
		Random r = new Random();
		
		for (int i = 0; i < 10; ++i) {
			int val = r.nextInt(100);
			
			if (isPrime(val))
				System.out.printf("%f * %d = %f%n", PI, val, PI * val);
		}
		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	NumberUtil sınıfı  
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import static java.lang.Math.*;

public class NumberUtil {	
	public static int factorial(int n)
	{
		if (n < 0)
			return -1;
		
		int result = 1;
		
		for (int i = 2; i <= n; ++i)
			result *= i;
		
		return result;
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
		
	public static int max(int a, int b, int c)
	{
		return Math.max(Math.max(a, b), c);
	}	

	public static int min(int a, int b, int c)
	{
		return Math.min(Math.min(a, b), c);
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

public class StringUtil {  
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

    public static String getRandomText(Random r, int n, String alphabet) 
    {
		String str = "";
	
		for (int i = 0; i < n; ++i) {
		    char ch = alphabet.charAt(r.nextInt(alphabet.length()));
	
		    if (r.nextBoolean())
			ch = toUpperCase(ch);
	
		    str += ch;
		}
	
		return str;
    }    

    public static String getRandomTextEN(int n) 
    {
    	return getRandomTextEN(new Random(), n);
    }

    public static String getRandomTextEN(Random r, int n) 
    {
    	return getRandomText(r, n, "abcdefghijklmnopqrstuwxvyz");
    }

    public static String getRandomTextTR(int n) 
    {
    	return getRandomTextTR(new Random(), n);
    }

    public static String getRandomTextTR(Random r, int n) 
    {
    	return getRandomText(r, n, "abcçdefgğhıijklmnoöprsştuüvyz");
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
    	return isPangram(text.toLowerCase(), "abcdefghijklmnopqrstuwxvyz");
    }

    public static boolean isPangramTR(String text) 
    {
    	return isPangram(text.toLowerCase(), "abcçdefgğhıijklmnoöprsştuüvyz");
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
		String s = "";
	
		while (n-- > 0)
		    s += ch;
	
		return s;
    }

    public static String reverse(String str) 
    {
		String revStr = "";
	
		for (int i = str.length() - 1; i >= 0; --i)
		    revStr += str.charAt(i);
	
		return revStr;
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
	Point sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math.geometry;

import static java.lang.Math.*;

public class Point {
	public int x;
	public int y;
	
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
```java
/*----------------------------------------------------------------------------------------------------------------------
	PointF sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math.geometry;

import static java.lang.Math.*;

public class PointF {
	public float x;
	public float y;
	
	public PointF()
	{		
	}
	
	public PointF(float a)
	{
		x = a;
	}
	
	public PointF(float a, float b)
	{
		x = a;
		y = b;
	}
	
	public double distance(Point p)
	{
		return distance(p.x, p.y);				
	}
	
	public double distance(float a, float b)
	{
		return sqrt((x - a) * (x - a) + (y - b) * (y - b));								
	}
	
	public void offset(float dxy)
	{
		offset(dxy, dxy);
	}
	
	public void offset(float dx, float dy)
	{
		x += dx;
		y += dy;
	}
	
	public String toString()
	{
		return String.format("{x: %f, y: %f}", x, y);
	}	
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yıldızsız import static bildiriminin genel biçimi:
	import static <paket ismi>.[alt paket listesi].<tür ismi>.<static eleman ismi>;
	Bu bildirim ile belirtilen static eleman ilgili java dosyasında doğrudan kullanılabilir		
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import static java.lang.Math.PI;
import static org.csystem.util.NumberUtil.isPrime;
import java.util.Random;

class App {	
	public static void main(String [] args) 
	{	
		Random r = new Random();
		
		for (int i = 0; i < 10; ++i) {
			int val = r.nextInt(100);
			
			if (isPrime(val))
				System.out.printf("%f * %d = %f%n", PI, val, PI * val);
		}
		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	NumberUtil sınıfı  
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import static java.lang.Math.abs;
import static java.lang.Math.log10;
import static java.lang.Math.sqrt;

public class NumberUtil {	
	public static int factorial(int n)
	{
		if (n < 0)
			return -1;
		
		int result = 1;
		
		for (int i = 2; i <= n; ++i)
			result *= i;
		
		return result;
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
		
	public static int max(int a, int b, int c)
	{
		return Math.max(Math.max(a, b), c);
	}	

	public static int min(int a, int b, int c)
	{
		return Math.min(Math.min(a, b), c);
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

import static java.lang.Character.isLetter;
import static java.lang.Character.isWhitespace;
import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;

import java.util.Random;

public class StringUtil {  
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

    public static String getRandomText(Random r, int n, String alphabet) 
    {
		String str = "";
	
		for (int i = 0; i < n; ++i) {
		    char ch = alphabet.charAt(r.nextInt(alphabet.length()));
	
		    if (r.nextBoolean())
			ch = toUpperCase(ch);
	
		    str += ch;
		}
	
		return str;
    }    

    public static String getRandomTextEN(int n) 
    {
    	return getRandomTextEN(new Random(), n);
    }

    public static String getRandomTextEN(Random r, int n) 
    {
    	return getRandomText(r, n, "abcdefghijklmnopqrstuwxvyz");
    }

    public static String getRandomTextTR(int n) 
    {
    	return getRandomTextTR(new Random(), n);
    }

    public static String getRandomTextTR(Random r, int n) 
    {
    	return getRandomText(r, n, "abcçdefgğhıijklmnoöprsştuüvyz");
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
    	return isPangram(text.toLowerCase(), "abcdefghijklmnopqrstuwxvyz");
    }

    public static boolean isPangramTR(String text) 
    {
    	return isPangram(text.toLowerCase(), "abcçdefgğhıijklmnoöprsştuüvyz");
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
		String s = "";
	
		while (n-- > 0)
		    s += ch;
	
		return s;
    }

    public static String reverse(String str) 
    {
		String revStr = "";
	
		for (int i = str.length() - 1; i >= 0; --i)
		    revStr += str.charAt(i);
	
		return revStr;
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
	Point sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math.geometry;

import static java.lang.Math.sqrt;

public class Point {
	public int x;
	public int y;
	
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
```java
/*----------------------------------------------------------------------------------------------------------------------
	PointF sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math.geometry;

import static java.lang.Math.sqrt;

public class PointF {
	public float x;
	public float y;
	
	public PointF()
	{		
	}
	
	public PointF(float a)
	{
		x = a;
	}
	
	public PointF(float a, float b)
	{
		x = a;
		y = b;
	}
	
	public double distance(Point p)
	{
		return distance(p.x, p.y);				
	}
	
	public double distance(float a, float b)
	{
		return sqrt((x - a) * (x - a) + (y - b) * (y - b));								
	}
	
	public void offset(float dxy)
	{
		offset(dxy, dxy);
	}
	
	public void offset(float dx, float dy)
	{
		x += dx;
		y += dy;
	}
	
	public String toString()
	{
		return String.format("{x: %f, y: %f}", x, y);
	}	
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Veri yapısı: Verileri belirli bir algoritmaya göre tutan ve istenilğidinde bu verilere erişilebilen
	yapılara denir.

	Diziler (Arrays):
	Elemanları aynı türden olan ve elemanların bellekte peşpeşe olarak tutulduğu veri yapısıdır. Java' diziler
	sınıfsal olarak temsil edilir. Yani dizi türü aslında bir referans türüdür ve diziiler heap de yaratılır.
	Şüphesiz dizi referansları stack'de yaratılabilir
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Dizi refansı referansı bildirimi Java' da iki şekilde yapılabilir:
	T bir tür olmak üzere

	T [] a; //*
	T a[];

	Biz *'daki bildirim biçimini kullanacağız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int [] a; // dizi referansı bildirimi
		int b[]; //dizi referansı bildirimi
		//...
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	[]'in referans bildiriminde bulunduğu yare göre farkları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int [] a, b, c;
		int d[], e, f;

		e = 10;
		d = 30; //error
		b = 45; //error
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Dizi yaratmak için de new operatörü kullanılır. Dizi yaramanın genel biçimi:
		new <tür>[<dizinin int türden eleman sayısı>];
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int [] a;

		a = new int[5];

		//...

	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Dizi yaratılırken verilen eleman sayısı sabit ifadesi olmak zorunda değildir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Bir sayı giriniz");
		int n = Integer.parseInt(kb.nextLine());
		int [] a;

		a = new int[n];

		//...

	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	length veri elemanına atama yapılamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int n = Integer.parseInt(kb.nextLine());
		int [] a;

		a = new int[n];

		System.out.printf("Length:%d%n", a.length);

		a.length = 20; //error

	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Dizinin elamlarına [] operatörü ile erişilebilir. Bu operatör iki operandlıdır ürettiği değer dizinin elemanı
	türünden bir değişkendir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int n = Integer.parseInt(kb.nextLine());
		int [] a;

		a = new int[n];

		for (int i = 0; i < a.length; ++i)
			a[i] = i + 1;

		for (int i = 0; i < a.length; ++i)
			System.out.printf("%d ", a[i]);

		System.out.println();
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	[] operatörüne negatif pozitif bakımından sınırlar dışında bir değer verildiğinde exception oluşur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int n = Integer.parseInt(kb.nextLine());
		int [] a;

		a = new int[n];

		for (int i = 0; i < a.length; ++i)
			a[i] = i + 1;

		System.out.println(a[5]);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir dizi ilk yaratıldığında tüm elemanlarına default değerler atanır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int n = Integer.parseInt(kb.nextLine());
		int [] a;
		boolean [] flags;

		a = new int[n];
		flags = new boolean[n];

		for (int i = 0; i < a.length; ++i)
			System.out.printf("%d ", a[i]);

		System.out.println();

		for (int i = 0; i < flags.length; ++i)
			System.out.printf("%b ", flags[i]);

		System.out.println();
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Dizilere ilkdeğer verilmesi (initialization) küme parantezi ile yapılabilir. Burada new operatörünün [] içerisi
	boş bırakılmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int [] a;

		a = new int[] {1, 2, 3, 4, 5};

		for (int i = 0; i < a.length; ++i)
			System.out.printf("%d ", a[i]);

		System.out.println();
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Diziye ilkdeğer verilirken aynı zamanda bir referansa da ilkdeğer veriliyorsa new operatörü kullanılması
	gerekmez
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int [] a = {1, 2, 3, 4, 5};

		for (int i = 0; i < a.length; ++i)
			System.out.printf("%d ", a[i]);

		System.out.println();
	}
}
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnek error oluşturur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int [] a;

		a = {1, 2, 3, 4, 5}; //error

		for (int i = 0; i < a.length; ++i)
			System.out.printf("%d ", a[i]);

		System.out.println();
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Diziye ilkdeğer verilmesi sırasında küme parantezi içerisinde yazılan son elemandan sonra konan bir tane
	virgül geçerlidir. Bu dizinin eleman sayısını değiştirmez
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int [] a = {1, 2, 3, 4, 5,};

		System.out.printf("Length:%d%n", a.length);

		for (int i = 0; i < a.length; ++i)
			System.out.printf("%d ", a[i]);

		System.out.println();
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Diziye ilkdeğer olarak verilen elemanlar sabit ifadesi olmak zorunda değildir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int x = Integer.parseInt(kb.nextLine());
		int [] a = {x, x + 1, x + 2, x + 3};

		for (int i = 0; i < a.length; ++i)
			System.out.printf("%d ", a[i]);

		System.out.println();
	}
}



/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/
```
```java
