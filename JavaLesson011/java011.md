### Derleyici özdeş String atomları (string literal) için aynı adresi verir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	 18.07.2020
	 Derleyici özdeş String atomları (string literal) için aynı adresi verir. Aşağıdaki örnekte "ankara" 
	 sabiti için hep aynı adres verilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{			
		String s1 = "ankara";
		String s2 = "ankara";		
		
		if (s1 == s2)
			System.out.println("Aynı yazı");
		else
			System.out.println("Farklı yazılar");
	}
}
```
### Sınıf çalışması: isPangramTR ve isPangramEN isimli metodlarını yazınız (1.1).
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Sınıf Çalışması: Parametresi ile aldığı bir yazının Türkçe pangram olup olmadığını test eden isPangramTR
	 ve İngilizce pangram olup olmadığını test eden isPangramEN isimli metotları yazınız ve test ediniz.
	 Pangram: İçerisinde özel isim bulunmayan anlamlı ve ilgili alfabenin tüm karakterlerini içeren cümlelere denir.
	 Örnekler:
	 İngilizce Pangram:
	 	The quick brown fox jumps over the lazy dog
	 Türkçe:
	 	Pijamalı hasta yağız şoföre çabucak güvendi
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{			
		PangramTest.run();		
	}
}

class PangramTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Bir yazı giriniz:");
			String text = kb.nextLine();
			
			if (text.equals("quit"))
				break;
			
			System.out.println(StringUtil.isPangramTR(text) ? "Pangram" : "Pangram değil");
			System.out.println(StringUtil.isPangramEN(text) ? "Pangram" : "Not a pangram");
		}	
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class StringUtil {
	public static boolean isPangramTR(String text)
	{
		return isPangram(text.toLowerCase(), "abcçdefgğhıijklmnoöprsştuüvyz");		
	}
	
	public static boolean isPangramEN(String text)
	{
		return isPangram(text.toLowerCase(), "abcdefghijklmnopqrstuwxvyz");		
	}
	
	public static boolean isPangram(String text, String alphabet)
	{
		int length = alphabet.length();
		
		for (int i = 0; i < length; ++i)
			if (text.indexOf(alphabet.charAt(i)) == -1)
				return false;
		
		return true;				
	}
}
```
### isPangramEN motedunun unicode-uyumlu yazılması (1.2)
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Yukarıdaki örnek için İngiliz alfabesindeki karakterler unicode tablosunda sıralı olduğundan isPangramEN
	 aşağıdaki gibi yazılzbilir. Ancak yukarıdaki yaklaşım daha geneldir	 	
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		PangramENTest.run();				
	}
}

class PangramENTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Input a text:");
			String text = kb.nextLine();
			
			if (text.equals("quit"))
				break;			
			
			System.out.println(StringUtil.isPangramEN(text) ? "Pangram" : "Not a pangram");
		}	
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class StringUtil {	
	public static boolean isPangramEN(String text)
	{
		for (char c = 'a'; c <= 'z'; ++c)
			if (text.indexOf(c) == -1)
				return false;
		
		return true;
	}
	
}
```
### Sınıf çalışması: isPalindrom isimli motodu yazınız (2).
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Sınıf Çalışması: Parametresi ile aldığı bir yazının palindrom olup olmadığını test eden isPalindrome
	 isimli metodu yazınız ve test ediniz
	 Palindrom: Yalnızca alfabetik karakterleri tersten de okunduğunda aynı olan yazılara denir. Yani alfabetik
	 dışı karakterler yok sayılır
	 
	 Örnek:
	 ey edip Adana'da pide ye -> eyedipadanadapideye
	 Anastas mum satsana -> anastasmumsatsana
	 Ali Papila -> alipapila
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		PalindromeTest.run();			
	}
}

class PalindromeTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Bir yazı giriniz:");
			String text = kb.nextLine();
			
			if (text.equals("quit"))
				break;
			
			System.out.println(StringUtil.isPalindrome(text) ? "Palindrom" : "Palindrom değil");
		}	
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class StringUtil {
	public static boolean isPalindrome(String s)
	{
		String str = getLetters(s);
		int left = 0;
		int right = str.length() - 1;	
		
		while (left < right) {
			char chLeft = Character.toLowerCase(str.charAt(left++));
			char chRight = Character.toLowerCase(str.charAt(right--));
			
			if (chLeft != chRight)
				return false;
		}
		
		return true;
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
}
```
### Sınıf çalışması: isPalindrom isimli motodu yazınız (3).
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Sınıf Çalışması: Parametresi ile aldığı bir yazının palindrom olup olmadığını test eden isPalindrome
	 isimli metodu yazınız ve test ediniz
	 Palindrom: Yalnızca alfabetik karakterleri tersten de okunduğunda aynı olan yazılara denir. Yani alfabetik
	 dışı karakterler yok sayılır
	 
	 Örnek:
	 ey edip Adana'da pide ye -> eyedipadanadapideye
	 Anastas mum satsana -> anastasmumsatsana
	 Ali Papila -> alipapila
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		PalindromeTest.run();			
	}
}

class PalindromeTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Bir yazı giriniz:");
			String text = kb.nextLine();
			
			if (text.equals("quit"))
				break;
			
			System.out.println(StringUtil.isPalindrome(text) ? "Palindrom" : "Palindrom değil");
		}	
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class StringUtil {
	public static boolean isPalindrome(String s)
	{
		String str = getLetters(s);
		int len = str.length();
		int halfLen = len / 2;
		
		for (int i = 0; i < halfLen; ++i) {
			char chLeft = Character.toLowerCase(str.charAt(i));
			char chRight = Character.toLowerCase(str.charAt(len - 1 - i));
			
			if (chLeft != chRight)
				return false;
		}	
			
		return true;
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
}
```
### Sınıf çalışması: isPalindrom isimli motodu yazınız(4).
```java
/*----------------------------------------------------------------------------------------------------------------------
	 19.07.2020
	 Sınıf Çalışması: Parametresi ile aldığı bir yazının palindrom olup olmadığını test eden isPalindrome
	 isimli metodu yazınız ve test ediniz
	 Palindrom: Yalnızca alfabetik karakterleri tersten de okunduğunda aynı olan yazılara denir. Yani alfabetik
	 dışı karakterler yok sayılır
	 
	 Örnek:
	 ey edip Adana'da pide ye -> eyedipadanadapideye
	 Anastas mum satsana -> anastasmumsatsana
	 Ali Papila -> alipapila
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		PalindromeTest.run();			
	}
}

class PalindromeTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Bir yazı giriniz:");
			String text = kb.nextLine();
			
			if (text.equals("quit"))
				break;
			
			System.out.println(StringUtil.isPalindrome(text) ? "Palindrom" : "Palindrom değil");
		}	
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class StringUtil {
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
}
```
### Sınıf çalışması: getLongestPalindrome metodunu yazınız.
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Sınıf Çalışması: Parametresi ile aldığı bir yazının içerisindeki en uzun palindromu döndüren 
	 getLongestPalindrome metodunu yazınız ve test ediniz.	 
	 
	 adaeyedipadanadapideyeadecealipapila
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		LongestPalindromeTest.run();			
	}
}

class LongestPalindromeTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Bir yazı giriniz:");
			String text = kb.nextLine();
			
			if (text.equals("quit"))
				break;
			
			System.out.println(StringUtil.getLongestPalindrome(text));
		}	
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class StringUtil {	
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
}
```
### Sınıf Çalışması: getRandomTextTR ve getRandomTextEN metodlarını yazınız.
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Sınıf Çalışması: Parametresi ile aldığı int türden n değeri için n tane rasgele belirlenmiş Türkçe 
	 karakterlerden oluşan bir yazı döndüren getRandomTextTR ile n tane rasgelebelirlenmiş İngilizce 
	 karakterlerden oluşan bir yazı döndüren getRandomTextEN metodunu yazınız ve test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		GetRandomTextTest.run();			
	}
}

class GetRandomTextTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		java.util.Random r = new java.util.Random();
		
		for (;;) {
			System.out.print("Bir sayı giriniz:");
			int n = Integer.parseInt(kb.nextLine());
			
			if (n <= 0)
				break;
			
			System.out.println(StringUtil.getRandomTextTR(r,n));
			System.out.println(StringUtil.getRandomTextEN(r,n));			
		}	
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class StringUtil {
	public static String getRandomTextTR(int n)
	{
		return getRandomTextTR(new java.util.Random(), n);		
	}
	
	public static String getRandomTextTR(java.util.Random r, int n)
	{
		return getRandomText(r, n, "abcçdefgğhıijklmnoöprsştuüvyz");
	}
	
	public static String getRandomTextEN(int n)
	{
		return getRandomTextEN(new java.util.Random(), n);		
	}
	
	public static String getRandomTextEN(java.util.Random r, int n)
	{
		return getRandomText(r, n, "abcdefghijklmnopqrstuwxvyz");
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
}
```
### Sarmalayan sınıfların parseXXX (parseint, parse double vs.) metodları ile yazılar sayıya çevrilebilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Sarmalayan sınıfların parseXXX metodları ile yazılar sayıya çevrilebilir. Bu metotlar parametresi 
	 ile aldıkları yazı ilgili türe ilişkin değere çevrilemiyor ise exception oluşur
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir yazı giriniz:");
		String s = kb.nextLine();		
		int val = Integer.parseInt(s);
		
		System.out.println(val * val);
	}
}
```
### Neden nextInt, nextLong, nextDouble metotları nextLine metodu ile aynı Scanner nesnesi üzerinde kullanılmamalıdır ?
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Scanner sınıfının çalışma sistematiği dolayısıyla nextInt, nextLong, nextDouble gibi metotlar nextLine
	 metodu ile aynı Scanner nesnesi üzerinde kullanılmamalıdır. Bu yüzden özellikle klevye işlemlerinde
	 nextLine metodu dışındakiler kullanılmamalıdır. Aşağıdaki çalıştırarak sorunu inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);						
		
		for (;;) {
			System.out.print("Numarayı giriniz:");
			int number = kb.nextInt();
			
			if (number <= 0)
				break;
			
			System.out.print("İsim giriniz");
			String name = kb.nextLine();
			
			System.out.printf("{number:%d, name:%s}%n", number, name);
		}
	}
}
```
### String sınıfının valueOf metodu.
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının valueOf metotları ile temel türlerin yazı karşılığı elde edilebilir   
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		int val = 10;		
		String str = String.valueOf(val);
		
		System.out.println(str);		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki işlem aşağıdaki biçimde de yapılabilir   
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		int val = 10;		
		String str = val + "";
		
		System.out.println(str);		
	}
}
```
### String sınıfının contains metodu.
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının contains metodu ile bir yazı içerisinde başka bir yazının varolup olmadığı test edilebilir   
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir yazı giriniz:");
		String s1 = kb.nextLine();
		
		System.out.print("Zararlı yazıyı giriniz:");
		String s2 = kb.nextLine();
		
		System.out.println(s1.contains(s2) ? "Yazı kabul edilemez" : "Yazı kabul edilebilir");		
	}
}

```
### Sınıf çalışması: isPangramTr ve isPangramEN metodlarını yazınız.
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Sınıf Çalışması: Parametresi ile aldığı bir yazının Türkçe pangram olup olmadığını test eden isPangramTR
	 ve İngilizce pangram olup olmadığını test eden isPangramEN isimli metotları yazınız ve test ediniz.
	 Pangram: İçerisinde özel isim bulunmayan anlamlı ve ilgili alfabenin tüm karakterlerini içeren cümlelere denir.
	 Örnekler:
	 İngilizce Pangram:
	 	The quick brown fox jumps over the lazy dog
	 Türkçe:
	 	Pijamalı hasta yağız şoföre çabucak güvendi
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{			
		PangramTest.run();		
	}
}

class PangramTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Bir yazı giriniz:");
			String text = kb.nextLine();
			
			if (text.equals("quit"))
				break;
			
			System.out.println(StringUtil.isPangramTR(text) ? "Pangram" : "Pangram değil");
			System.out.println(StringUtil.isPangramEN(text) ? "Pangram" : "Not a pangram");
		}	
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class StringUtil {
	public static boolean isPangramTR(String text)
	{
		return isPangram(text.toLowerCase(), "abcçdefgğhıijklmnoöprsştuüvyz");		
	}
	
	public static boolean isPangramEN(String text)
	{
		return isPangram(text.toLowerCase(), "abcdefghijklmnopqrstuwxvyz");		
	}
	
	public static boolean isPangram(String text, String alphabet)
	{
		int length = alphabet.length();
		
		for (int i = 0; i < length; ++i)
			if (!text.contains(alphabet.charAt(i) + ""))
				return false;
		
		return true;				
	}
}
```
### String sınıfının format metodu.
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının static format metodu formatlı bir yazı elde etmek için kullanılabilir. Bu metotta
	kullanılan format karakterleri printf metoduyla aynıdır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Birinci sayıyı giriniz:");
		int a = Integer.parseInt(kb.nextLine());
		
		System.out.print("İkinic sayıyı giriniz:");
		int b = Integer.parseInt(kb.nextLine());
		
		String str = String.format("%d + %d = %d", a, b, a + b);
		
		System.out.println(str);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Tüm öğrendiklerimize göre örneğin int türden bir değerin yazı karşılığı aşağıdaki gibi 3 şekilde
	elde edilebilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int val = 10;		
		String s1 = val + "";
		String s2 = String.valueOf(val);
		String s3 = String.format("%d", val);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Tüm öğrendiklerimize göre örneğin int türden bir değerin yazı karşılığı aşağıdaki gibi 3 şekilde
	elde edilebilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		Point p = new Point(100, 23);
		
		System.out.println(p.toString());
		
		p.offset(-30);
		
		String str = p.toString();
		
		//...
		
		System.out.println(str);
	}
}

class Point {
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
### Complex sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Complex sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Complex z = new Complex(3, 4);
		
		System.out.println(z.toString());		
	}
}

class Complex {
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
### String sınıfının replace metodu.
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının replace metodu ile yazı içerisinde bulunan başka yazılar değiştirilebilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		String str = "Bugün hava çok sıcak. Bu sıcak havada dışarıda dolaşılamıyor";
		
		str = str.replace("sıcak", "soğuk");
		
		System.out.println(str);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının replace metodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		String str = "ankara";
		
		str = str.replace('a', 'b');
		
		System.out.println(str);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının replace metodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		String str = "Bugün hava çok sıcak. Bu çok sıcak havada dışarıda dolaşılamıyor";
		
		str = str.replace(" çok", "");
		
		System.out.println(str);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının replace metodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		String str = "Bugün hava çok sıcak. Bu \tçok sıcak havada dışarıda dolaşılamıyor";
		
		str = str.replace(" ", "");
		str = str.replace("\t", "");
		
		System.out.println(str);
	}
}
```
### java 7 ile birlikte switch deyiminde String kullanımı.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java 7 ile birlikte switch deyiminde String de kullanılabilmektedir. Bu durumda case bölümlerinin
	String literal olması zorunludur. String sınıfı switch deyimi ile kullanıldığında karşılaştırma
	equals metodu ile yapılır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.printf("Şehir ismi giriniz:");
		String cityName = kb.nextLine();
		
		switch (cityName) {
		case "istanbul":
			System.out.println("Marmara Bölgesi");
			break;
		case "ankara":
			System.out.println("İç Anadolu Bölgesi");
			break;
		case "izmir":
			System.out.println("Ege Bölgesi");
			break;
		default:
			System.out.println("Sistemde kayıtlı olmayan şehir girdiniz");
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java 7 ile birlikte switch deyiminde String de kullanılabilmektedir. Bu durumda case bölümlerinin
	String literal olması zorunludur. String sınıfı switch deyimi ile kullanıldığında karşılaştırma
	equals metodu ile yapılır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.printf("Şehir ismi giriniz:");
		String cityName = kb.nextLine();
		
		switch (cityName.toLowerCase()) {
		case "istanbul":
			System.out.println("Marmara Bölgesi");
			break;
		case "ankara":
			System.out.println("İç Anadolu Bölgesi");
			break;
		case "izmir":
			System.out.println("Ege Bölgesi");
			break;
		default:
			System.out.println("Sistemde kayıtlı olmayan şehir girdiniz");
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
## Paketler
```java
/*----------------------------------------------------------------------------------------------------------------------
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
  		package <paket ismi>.<alt paket ismi>;

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

/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/
