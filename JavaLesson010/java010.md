### Complex sınıfı ve test kodu
```java 
/*----------------------------------------------------------------------------------------------------------------------
	11.07.2020
	Complex sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Complex z = new Complex();
		
		z.display();		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Complex sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Complex z = new Complex(3, 4);
		
		z.display();		
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
	
	public void display()
	{
		System.out.printf("|%.2f + %.2f * i| = %f%n", re, im, getNorm());
	}
}
```
# Random sınıfının tohum değeri parametreli ctor elemanı
```java
/*----------------------------------------------------------------------------------------------------------------------
	Random sınıfının tohum değeri parametreli ctor elemanı
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Tohum değerini giriniz:");
		long seed = Long.parseLong(kb.nextLine());
		
		java.util.Random r = new java.util.Random(seed);
		
		for (int i = 0; i < 10; ++i)
			System.out.printf("%d ", r.nextInt(101));
		
		System.out.println();
	}
}
```
# Derleyici String atomu gördüğünde nasıl bir kod üretir ?
```java
/*----------------------------------------------------------------------------------------------------------------------
	Derleyici String atomu gördüğünde şöyle bir kod üretir: "Çalışma zamanı sırasında String türden bir nesne yarat
	bu karakteleri o nesneye aktar ve o nesnenin referansını ver"
	
	print ve println metotlarının String parametreli versiyonları (overload) aldıkları String referansına ilişkin
	yazıyı ekrana basarlar
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		String s;
		
		s = "ankara";
		
		System.out.println(s);
	}
}
```
# printf metodunda s format karakteri ile bir String referansına ilişkin yazı ekrana basılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	printf metodunda s format karakteri ile bir String referansına ilişkin yazı ekrana basılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		String s;
		
		s = "ankara";
		
		System.out.printf("Yazı:%s%n", s);
	}
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	printf metodunda s format karakteri ile bir String referansına ilişkin yazı ekrana basılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir yazı giriniz:");
		String s = kb.nextLine();
		
		System.out.printf("Girilen yazı:%s%n", s);		
	}
}
```
# immutable sınıf nedir ?
```java
/*----------------------------------------------------------------------------------------------------------------------
	immutable sınıf: Bir nesnenin bilgileri bir kez verilip bir daha değiştirilemiyor ise o nesneye ilişkin sınıfa 
	immutable sınıf denir
	
	String sınıfı immutable bir sınıftır. Yani bir String nesnesine ilişkin yazı üzerinde değişiklik yapılamaz.
	Yazı üzerinde değişiklik yapan metotlar (örneğin yazının tamamını büyük harfe çeviren metot) tamamı büyütülmüş
	harflerden oluşan yeni bir String nesnesinin referansını döndürür	
----------------------------------------------------------------------------------------------------------------------*/
```
# String sınıfının toUpperCase metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının toUpperCase metodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir yazı giriniz:");
		String s = kb.nextLine();		
		String upper = s.toUpperCase();
		
		System.out.println(s);
		System.out.println(upper);
	}
}
```
# String sınıfının toLowerCase metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının toLowerCase metodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir yazı giriniz:");
		String s = kb.nextLine();		
		String upper = s.toLowerCase();
		
		System.out.println(s);
		System.out.println(upper);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte mantıksal olarak değiştirilmiş yazı ile devam edilecek şekilde kod yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir yazı giriniz:");
		String s = kb.nextLine();		
		s = s.toLowerCase();
		
		System.out.println(s);		
	}
}
```
# String sınıfının length isimli metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının length isimli metodu ile yazının karakter sayısı elde edilebilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir yazı giriniz:");
		String s = kb.nextLine();		
		
		System.out.printf("Girilen Yazı:%s%n", s);		
		System.out.printf("Girilen Yazının Uzunluğu:%d%n", s.length());
	}
}
```
# String sınıfının charAt isimli metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının charAt isimli metodu ile herhangi bir indeksteki karakter elde edilebilir. Indeks numarası
	sıfırdan başlar
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir yazı giriniz:");
		String s = kb.nextLine();		
		
		int length = s.length();
		
		for (int i = 0; i < length; ++i)
			System.out.println(s.charAt(i));
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının charAt metoduna pozitif ya da negatif bakımdan sınırlar dışında değer verilemesi durumunda
	exception oluşur
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir yazı giriniz:");
		String s = kb.nextLine();		
		
		char ch = s.charAt(5);
		
		System.out.printf("ch=%c%n", ch);
	}
}
```
# Boş String nedir ?
```java
/*----------------------------------------------------------------------------------------------------------------------
	İki tane iki tırnağın bitişik olarak yazılması ile yaratılan String'e boş string (empty string) denir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		String s = ""; //boş string
		
		System.out.printf("Length:%d%n", s.length());
	}
}
```
# Aynı türden iki referansın == ve != operatörleri ile karşılaştırılması 
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aynı türden iki referansın == veya != operatörü ile karşılaştırılması adres karşılaştırmasıdır. Yani == operatörü
	iki referansı karşılaştırma durumunda iki referans da aynı nesneyi gösteriyorsa true değer üretilir. Benzer 
	şekilde !=	operatörü ile iki referansı karşılatırma durumunda iki referans farklı nesneleri gösteriyor ise
	true değer üretilir 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		Sample s = new Sample(10);
		Sample k = s; //new Sample(10);
		
		if (s == k)
			System.out.println("Aynı nesne");
		else
			System.out.println("Farklı nesneler");
	}
}


class Sample {
	public int x;
	
	public Sample(int a)
	{
		x = a;
	}
}
```
# Yazıların eşitkik karşılaştırması == ve != operatörleri ile yapılmaz
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yazıların eşitlik karşılaştırması == ve != operatörleri ile yapılamaz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Birinci yazıyı giriniz:");
		String s1 = kb.nextLine();		
		
		System.out.print("İkinci yazıyı giriniz:");
		String s2 = kb.nextLine();
		
		if (s1 == s2)
			System.out.println("Aynı yazı");
		else
			System.out.println("Farklı yazılar");
	}
}

```
# Yazıların eşitlik karşılaştırması equals metodu ile yapılabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yazıların eşitlik karşılaştırması equals metodu ile yapılabilir. equals metodu büyük küçük harf duyarlı 
	karşılaştırma yapar 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Birinci yazıyı giriniz:");
		String s1 = kb.nextLine();		
		
		System.out.print("İkinci yazıyı giriniz:");
		String s2 = kb.nextLine();
		
		if (s1.equals(s2))
			System.out.println("Aynı yazı");
		else
			System.out.println("Farklı yazılar");
	}
}

```
# String sınıfının equalsIgnoreCase isimli metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının equalsIgnoreCase isimli metodu büyük-küçük harf duyarsız eşitlik karşılaştırması yapar  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Birinci yazıyı giriniz:");
		String s1 = kb.nextLine();		
		
		System.out.print("İkinci yazıyı giriniz:");
		String s2 = kb.nextLine();
		
		if (s1.equalsIgnoreCase(s2))
			System.out.println("Aynı yazı");
		else
			System.out.println("Farklı yazılar");
	}
}
```
# String sınıfının indexOf metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının indexOf metodu  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		String str = "Bugün hava çok rüzgarlı, çok dikkat etmek gerekir";
		char ch = 'ç';
		
		int index = str.indexOf(ch);
		
		System.out.printf("Index:%d%n", index);		
	}
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının indexOf metodu  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		String str = "Bugün hava çok rüzgarlı, çok dikkat etmek gerekir";
		char ch = 'ğ';
		
		int index = str.indexOf(ch);
		
		System.out.printf("Index:%d%n", index);		
	}
}

```
# String sınıfının fromIndex parametreli indexOf metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının fromIndex parametreli indexOf metodu  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		String str = "Bugün hava çok rüzgarlı, çok dikkat etmek gerekir";
		char ch = 'ç';
		
		int index = str.indexOf(ch, 12);
		
		System.out.printf("Index:%d%n", index);		
	}
}
```

```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının indexOf metodu  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		String str = "Bugün hava çok rüzgarlı, çok dikkat etmek gerekir";
		String s = "çok";
		
		int index = str.indexOf(s);
		
		System.out.printf("Index:%d%n", index);		
	}
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının indexOf metodu  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		String str = "Bugün hava çok rüzgarlı, çok dikkat etmek gerekir";
		String s = "çok";
		
		int index = str.indexOf(s, 12);
		
		System.out.printf("Index:%d%n", index);		
	}
}
```
# String sınıfının lastIndexOf metodu
```java

/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının lastIndexOf metodu  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		String str = "Bugün hava çok rüzgarlı, çok dikkat etmek gerekir";
		String s = "çok";
		
		int index = str.lastIndexOf(s);
		
		System.out.printf("Index:%d%n", index);		
	}
}

```
# Sınıf Çalışması: (countString isimli metodun yazılması)
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı iki yazıdan birincisi içerisinde ikincisinden kaç tane olduğunu
	döndüren countString isimli metodu StringUtil sınıfı içerisinde yazınız ve test ediniz
	Örnek:
	aaa yazısı içerisinde aa dan 2 tane var  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		CountStringTest.run();
	}
}

class CountStringTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Birinci yazıyı giriniz:");
			String s1 = kb.nextLine();
			
			if (s1.equals("quit"))
				break;
			
			System.out.print("İkinci yazıyı giriniz:");
			String s2 = kb.nextLine();
			
			int count = StringUtil.countString(s1, s2);
			
			System.out.printf("Birinci yazı içerisinde ikinci yazıdan %d tane var%n", count);
		}		
	}
}

class StringUtil {
	public static int countString(String s1, String s2)
	{
		int count = 0;
		int index = 0;
		
		while ((index = s1.indexOf(s2, index)) != -1) {
			++count;
			++index;
		}
		
		return count;
	}
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı iki yazıdan birincisi içerisinde ikincisinden kaç tane olduğunu
	döndüren countString isimli metodu StringUtil sınıfı içerisinde yazınız ve test ediniz
	Örnek:
	aaa yazısı içerisinde aa dan 2 tane var  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		CountStringTest.run();
	}
}

class CountStringTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Birinci yazıyı giriniz:");
			String s1 = kb.nextLine();
			
			if (s1.equals("quit"))
				break;
			
			System.out.print("İkinci yazıyı giriniz:");
			String s2 = kb.nextLine();
			
			int count = StringUtil.countString(s1, s2);
			
			System.out.printf("Birinci yazı içerisinde ikinci yazıdan %d tane var%n", count);
		}		
	}
}

class StringUtil {
	public static int countString(String s1, String s2)
	{
		int count = 0;
		int index = -1;
		
		while ((index = s1.indexOf(s2, index + 1)) != -1)
			++count;			
		
		return count;
	}
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı iki yazıdan birincisi içerisinde ikincisinden kaç tane olduğunu
	döndüren countString isimli metodu StringUtil sınıfı içerisinde yazınız ve test ediniz
	Örnek:
	aaa yazısı içerisinde aa dan 2 tane var  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		CountStringTest.run();
	}
}

class CountStringTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Birinci yazıyı giriniz:");
			String s1 = kb.nextLine();
			
			if (s1.equals("quit"))
				break;
			
			System.out.print("İkinci yazıyı giriniz:");
			String s2 = kb.nextLine();
			
			int count = StringUtil.countString(s1, s2);
			
			System.out.printf("Birinci yazı içerisinde ikinci yazıdan %d tane var%n", count);
		}		
	}
}

class StringUtil {
	public static int countString(String s1, String s2)
	{
		int count = 0;
		
		for (int i = 0; (i = s1.indexOf(s2, i)) != -1; ++count, ++i)
			;
		
		return count;
	}
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı iki yazıdan birincisi içerisinde ikincisinden kaç tane olduğunu
	döndüren countString isimli metodu StringUtil sınıfı içerisinde yazınız ve test ediniz
	Örnek:
	aaa yazısı içerisinde aa dan 2 tane var  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		CountStringTest.run();
	}
}

class CountStringTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Birinci yazıyı giriniz:");
			String s1 = kb.nextLine();
			
			if (s1.equals("quit"))
				break;
			
			System.out.print("İkinci yazıyı giriniz:");
			String s2 = kb.nextLine();
			
			int count = StringUtil.countString(s1, s2);
			
			System.out.printf("Birinci yazı içerisinde ikinci yazıdan %d tane var%n", count);
		}		
	}
}

class StringUtil {
	public static int countString(String s1, String s2)
	{
		int count = 0;
		
		for (int i = -1; (i = s1.indexOf(s2, i + 1)) != -1; ++count)
			;
		
		return count;
	}
}

```
# Bir string içinde boş string arama testi 1 (kötü yöntem)
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir String'in boş string olup olmadığının anlaşılması (kötü yöntem)  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		EmptyStringTest.run();
	}
}

class EmptyStringTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Birinci yazıyı giriniz:");
			String s = kb.nextLine();
			
			if (s.equals("quit"))
				break;	
			
			System.out.println(s.length() == 0 ? "Boş String" : "Boş String değil");			
		}		
	}
}
```
# Bir string içinde boş string arama testi 2 (kötü yöntem)
```java

/*----------------------------------------------------------------------------------------------------------------------
	Bir String'in boş string olup olmadığının anlaşılması (kötü yöntem)  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		EmptyStringTest.run();
	}
}

class EmptyStringTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Birinci yazıyı giriniz:");
			String s = kb.nextLine();
			
			if (s.equals("quit"))
				break;	
			
			System.out.println(s.equals("") ? "Boş String" : "Boş String değil");			
		}		
	}
}
```
# Bir string içinde boş string arama testi 3 (iyi yöntem)
```java

/*----------------------------------------------------------------------------------------------------------------------
	Bir String'in boş string olup olmadığı isEmpty metodu ile anlaşılabilir (en iyi yöntem)
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		EmptyStringTest.run();
	}
}

class EmptyStringTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Birinci yazıyı giriniz:");
			String s = kb.nextLine();
			
			if (s.equals("quit"))
				break;	
			
			System.out.println(s.isEmpty() ? "Boş String" : "Boş String değil");			
		}		
	}
}
```
# String sınıfının trim metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının trim metodu baştaki sondaki boşlukları (whitespace) atar. Aradaki boşluklara dokunmaz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		EmptyStringTest.run();
	}
}

class EmptyStringTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Birinci yazıyı giriniz:");
			String s = kb.nextLine();
			
			if (s.equals("quit"))
				break;	
			
			System.out.printf("(%s)%n", s.trim());			
		}		
	}
}

```
# String sınıfının concat metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	12.07.2020
	String sınıfının concat metodu ile yazı birleştirmesi (concatanation) yapılabilir 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		String s1 = "ankara";
		String s2 = "istanbul";		
		String s;
		
		s = s1.concat(s2);
		
		System.out.println(s);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örneği ineleyiniz 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		String s1 = "ankara";
		String s2 = "istanbul";		
		String s;
		
		s = s1.concat("-").concat(s2);
		
		System.out.println(s);
	}
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örneği ineleyiniz 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		String s1 = "ankara";
		String s2 = "istanbul";		
		String s;
		
		s = s1.concat("-".concat(s2));
		
		System.out.println(s);
	}
}
```
# Yazı birleştirmesi + operatörü ile de yapılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yazı birleştirmesi + operatörü ile de yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		String s1 = "ankara";
		String s2 = "istanbul";		
		String s;
		
		s = s1 + "-" + s2;
		
		System.out.println(s);
	}
}
```
# + operatörünün operandlarından bir String türündense diğer operandının String karşlığı elde edilerek birleştirme işlemi yapılır
```java
/*----------------------------------------------------------------------------------------------------------------------
	+ operatörünün operandlarından bir String türündense diğer operandının String karşlığı elde edilerek
	birleştirme işlemi yapılır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		String message = "Derece:";
		double degree = 30.7;
		
		String fullMessage = message + degree;
		
		System.out.println(fullMessage);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte println metodu birleştirilmiş yazıyı ekrana basar
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		double degree = 30.7;	
		
		System.out.println("Derece:" + degree);
	}
}
```
# Sınıf Çalışması: reverse metodunu yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Paremetresi ile aldığı bir yazının tersini döndüren reverse isimli metodu StringUtil
	sınıfı içerisinde yazınız ve metodu test ediniz
	(İleride daha iyisi yazılacak)
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		ReverseTest.run();
	}
}

class ReverseTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Bir yazı giriniz:");
			String str = kb.nextLine();
			
			System.out.println(StringUtil.reverse(str));
			
			if (str.equals("quit"))
				break;
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class StringUtil {
	public static String reverse(String str)
	{
		String revStr = "";
		
		for (int i = str.length() - 1; i >= 0; --i)
			revStr += str.charAt(i);
		
		return revStr;		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Paremetresi ile aldığı bir yazının tersini döndüren reverse isimli metodu StringUtil
	sınıfı içerisinde yazınız ve metodu test ediniz
	(İleride daha iyisi yazılacak)
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		ReverseTest.run();
	}
}

class ReverseTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Bir yazı giriniz:");
			String str = kb.nextLine();
			
			System.out.println(StringUtil.reverse(str));
			
			if (str.equals("quit"))
				break;
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class StringUtil {
	public static String reverse(String str)
	{
		String revStr = "";
		
		for (int i = str.length() - 1; i >= 0; --i)
			revStr += str.charAt(i);
		
		return revStr;		
	}
}
```
# Sınıf Çalışması: Basit ATM kullanıcı ve parola test uygulamasını yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Klavyeden bir kullanıcı adı ve şifre isteyen basit ATM uygulamasının bir parçasını aşağıdaki
	açıklamalara göre yazınız:
	Açıklamalar:
	- Kullanıcı adı ve şifre 3 kez denenebilecektir
	- 3 kez deneme sırasında doğru giriş yapılırsa "Giriş Başarılı", 3 kez deneme de yanlış olursa 
	"Giriş Başarısız. Deneme hakkınız bitti" mesajı verilecektir.
	- Kullanıcı adı ve şifrenin doğruluğu program içerisinde belirlenen bir kullanıcı adı ve şifre ile yapılacacktır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		ATMApp.run();
	}
}

class ATMApp {
	public static void run()
	{
		ATM atm = new ATM(3);
		
		atm.run();
	}
}

class ATM {
	public int tryNum;
	public String username;
	public String password;
	public java.util.Scanner kb;
	//...
	
	public ATM(int number)
	{
		tryNum = number;
		username = "test";
		password = "1234";
		kb = new java.util.Scanner(System.in);
	}
	
	public void doWorkForSuccess()
	{
		System.out.println("Giriş başarılı");
	}
	
	public void doWorkForFail()
	{
		System.out.println("Giriş Başarısız. Deneme hakkınız bitti");		
	}
	
	public boolean isValid()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		int i;
		
		for (i = 0; i < tryNum; ++i) {
			System.out.print("Kullanıcı Adını giriniz:");
			String uname = kb.nextLine();
			System.out.print("Şifre giriniz:");
			String passwd = kb.nextLine();
			
			if (uname.equals(username) && passwd.equals(password))
				break;
		}		
		
		return tryNum != i;
	}
	
	public void run()
	{
		if (isValid())
			doWorkForSuccess();
		else
			doWorkForFail();
	}
}
```
# String sınıfının substring metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının substring metodu ile yazının içerisinden belli bir yazı alınabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		String s = "ankara";
		
		System.out.println(s.substring(2)); //kara
		System.out.println(s.substring(2, 5)); //[2, 5) -> kar
	}
}

```
# String sınıfının substring metoduna index numarası olarak yazının uzunluğu verildiğinde boş string döndürür
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının substring metoduna index numarası olarak yazının uzunluğu verildiğinde boş string döndürür
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		String s = "ankara";
		
		System.out.println(s.substring(s.length()).isEmpty() ? "Boş string" : "Boş string değil");		
	}
}
```
# Sınıf Çalışması: Quit girilene kadar aldığı yazıları - ile birleştiren programı yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Klavyeden quit girilene kadar alınan yazıların arasında - karakteri olacak şekilde 
	birleştirilmiş bir String oluşturan programı yazınız.
	Örnek: 
	ankara, istanbul, izmir girilirse
	ankara-istanbul-izmir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		ConcatWithHyphenApp.run();
	}
}

class ConcatWithHyphenApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.println("Yazıları girmeye başlayınız:");
		
		String str = "";
		
		for (;;) {
			String s = kb.nextLine();
			
			if (s.trim().isEmpty())
				continue;
			
			if (s.equals("quit"))
				break;
			
			str += s + "-";
		}
		
		str = str.isEmpty() ? "" : str.substring(0, str.length() - 1);
		
		System.out.println(str);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Klavyeden quit girilene kadar alınan yazıların arasında - karakteri olacak şekilde 
	birleştirilmiş bir String oluşturan programı yazınız.
	Örnek: 
	ankara, istanbul, izmir girilirse
	ankara-istanbul-izmir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		ConcatWithHyphenApp.run();
	}
}

class ConcatWithHyphenApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.println("Yazıları girmeye başlayınız:");
		
		String str = "";
		String s;
		
		while (!(s = kb.nextLine()).equals("quit")) {
			if (s.trim().isEmpty())
				continue;
			
			str += s + "-";
		}	
		
		
		str = str.isEmpty() ? "" : str.substring(0, str.length() - 1);
		
		System.out.println(str);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Klavyeden quit girilene kadar alınan yazıların arasında - karakteri olacak şekilde 
	birleştirilmiş bir String oluşturan programı yazınız.
	Örnek: 
	ankara, istanbul, izmir girilirse
	ankara-istanbul-izmir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		ConcatWithHyphenApp.run();
	}
}

class ConcatWithHyphenApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.println("Yazıları girmeye başlayınız:");
		
		String str = "";
		
		for (;;) {
			String s = kb.nextLine();	
			
			if (s.trim().isEmpty())
				continue;
			
			if (s.equals("quit"))
				break;
			
			if (!str.isEmpty())
				str += "-";
			
			str += s;
		}		
		
		System.out.println(str);
	}
}
```
# String sınıfının startsWith metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının startsWith metodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Web adresini giriniz");
		String address = kb.nextLine();
		
		if (!address.startsWith("http://"))
			address = "http://" + address;
		
		System.out.println(address);		
	}
}
```
# String sınıfının endsWith metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının endsWith metodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Email adresini giriniz");
		String email= kb.nextLine();
		
		if (!email.endsWith(".com"))
			email += ".com";
		
		System.out.println(email);		
	}
}

```
# Character sınıfının isXXX metotları
```java
/*----------------------------------------------------------------------------------------------------------------------
	Character sınıfının isXXX metotları
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		char ch = '\t';
		
		System.out.println(Character.isWhitespace(ch));
		System.out.println(Character.isLetter(ch));
		System.out.println(Character.isDigit(ch));
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Character sınıfının isXXX metotları
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		char ch = 'c';
		
		System.out.println(Character.isUpperCase(ch));		
		System.out.println(Character.isLowerCase(ch));
	}
}
```
# Character sınıfının toXXX metotları
```java
/*----------------------------------------------------------------------------------------------------------------------
	Character sınıfının toXXX metotları
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		char ch = 'c';
		
		System.out.println(Character.toUpperCase(ch));		
		System.out.println(Character.toLowerCase(ch));
	}
}

```
# Sınıf Çalışması: Aldığı yazının ilk karakterini büyük harf capitalize isimli metodu yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı bir yazının ilk harfi büyük geri kalanları küçük olacak
	şekilde bir yazı döndüren capitalize isimli metodu yazınız
	Örnek:
	Girilen yazı: bugün Hava ÇOK güzel -> Bugün hava çok güzel
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		CapitalizeTest.run();				
	}
}

class CapitalizeTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Bir yazı giriniz:");
			String s = kb.nextLine();
			
			System.out.println(StringUtil.capitalize(s));			
			
			if (s.equals("quit"))
				break;
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class StringUtil {
	public static String capitalize(String s)
	{
		if (s.isEmpty())
			return s;
		
		return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();			
	}
}

```
# Sınıf Çalışması: Aldığı yazının sağındaki boşlukları silen trimRight ve solundaki boşlukları silen trimLeft metotlarını ayrı ayrı yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı bir yazının başındaki boşluk karakterlerini atan trimLeft ile sonundaki
	boşluk karakterlerini atan trimRight isimli metotları yazınız
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		TrimLeftRightTest.run();				
	}
}

class TrimLeftRightTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Bir yazı giriniz:");
			String s = kb.nextLine();
			
			System.out.printf("(%s)%n", StringUtil.trimLeft(s));
			System.out.printf("(%s)%n", StringUtil.trimRight(s));
			
			if (s.equals("quit"))
				break;
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class StringUtil {
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
# Sınıf Çalışması: Aşağıda açıklanan metotları (padLeft ve padRight) yazınız ve test ediniz
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Aşağıda açıklanan metotları yazınız ve test ediniz
	
	public static String padLeft(String s, int length, char ch);
	public static String padLeft(String s, int length);
	public static String padRight(String s, int length, char ch);
	public static String padRight(String s, int length);
	
	Açıklamalar:
	- padLeft metodunun 3 parametreli versiyonu ikinci parametresi ile aldığı length uzunluğu
	yazıdan büyükse yazının soldan ch karakteri ile doldurulmuş olduğu yeni bir String referansı döndürecektir.
	Örneğin:
	padLeft("ankara", 10, 'x'); çağrısı
	
	xxxxankara
	yazısını döndürecektir
	
	- length yazıdan küçük veya eşitse aynı referans döndürülecektir
	
	- padLeft metodunun 2 parametreli versiyonu yazıyı soldan space karakteri ile dolduracaktır
	
	- padRight metotları sağdan dolduracak şekilde padLeft metotlarına benzer biçimde çalışacaktır	
----------------------------------------------------------------------------------------------------------------------*/
```
```java
package csd;

class App {	
	public static void main(String [] args) 
	{
		PadLeftRightTest.run();				
	}
}

class PadLeftRightTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Bir yazı giriniz:");
			String s = kb.nextLine();
			
			System.out.print("Uzunluk giriniz:");
			int length = Integer.parseInt(kb.nextLine());
			
			System.out.printf("(%s)%n", StringUtil.padLeft(s, length, 'x'));
			System.out.printf("(%s)%n", StringUtil.padLeft(s, length));
			System.out.printf("(%s)%n", StringUtil.padRight(s, length, 'x'));
			System.out.printf("(%s)%n", StringUtil.padRight(s, length));
			
			if (s.equals("quit"))
				break;
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class StringUtil {
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
	
	public static String repeat(int n, char ch)
	{
		String s = "";
		
		while (n-- > 0)
			s += ch;
		
		return s;
	}
}
```
# Homework-002-2. sorunun bir çözümü.
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Homework-002-2. sorunun bir çözümü.
	 İleride daha iyisi yazılacak
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		BallGameApp.run();				
	}
}

class BallGameApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		BallGame ballGame = new BallGame(); 
		
		for (;;) {
			System.out.print("Genişliği giriniz:");
			int width = Integer.parseInt(kb.nextLine());
			
			if (width == 0)
				break;
			
			System.out.print("Yüksekliği  giriniz:");
			int height = Integer.parseInt(kb.nextLine());			
			
			if (width < 0 || height <= 0)
				continue;
			
			ballGame.run(width, height);
			
			System.out.println(ballGame.result);			
		}
	}
}

class BallGame {
	public String result;
	
	public BallGame()
	{
		result = "";
	}
	
	public static boolean getFlag(int ballIndex, int width, boolean flag) 
	{
		if (ballIndex == 0)
			return true;
		
		if (ballIndex == width - 1)
			return false;
		
		return flag;		
	}
	
	public static int getBallIndex(int ballIndex, int width, boolean flag)
	{
		if (width == 1)
			return ballIndex;		
		
		if (flag)
			return ballIndex + 1;
		
		return ballIndex - 1;					
	}
	
	public void fillWithSpaces(int start, int end)
	{
		for (int i = start; i < end; ++i)
			result += ' ';		
	}
	
	public void playGame(int width, int height)
	{
		int ballIndex = 0;
		boolean flag = true;
		
		for (int i = 1; i <= height; ++i) {
			result += '|';
			fillWithSpaces(0, ballIndex);
			result += '*';
			fillWithSpaces(ballIndex + 1, width);			
			flag = getFlag(ballIndex, width, flag);						
			ballIndex = getBallIndex(ballIndex, width, flag);			
			result += "|\n";
		}		
	}
	
	public void run(int width, int height)
	{		
		result = "";
		playGame(width, height);
	}
}
```
# Aldığı yazının içindeki tüm boşlukları silen removeWhiteSpaces metodunu yazınız.
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Sınıf Çalışması: Paremetresi ile aldığı bir yazının tüm boşluk karakterlerinin atılmış olduğu bir
	 String referansı döndüren removeWhiteSpaces isimli metodu yazınız ve test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		RemoveWhitespacesTest.run();				
	}
}

class RemoveWhitespacesTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);	 
		
		for (;;) {
			System.out.print("Bir yazı giriniz:");
			String s = kb.nextLine();
			
			System.out.printf("(%s)%n", StringUtil.removeWhitespaces(s));
			
			if (s.equals("quit"))
				break;
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class StringUtil {
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
}
```
# String sınıfının compareTo metodu 
```java
/*----------------------------------------------------------------------------------------------------------------------
	 String sınıfının compareTo metodu 
	 s1.compareTo(s2); çağrısı için:
	 1. Geri dönüş değeri pozitif ise s2 s1'den önce gelir
	 2. Geri dönüş değeri negatif ise s1 s2'den önce gelir
	 3. Geri dönüş değeri sıfır ise s1 ile s2 aynı yazılardır
	 
	 Bu metot büyük-küçük harf duyarlı çalışır	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		String s1 = "Ankara";
		String s2 = "adana";
		
		int result = s1.compareTo(s2);
		
		System.out.println(result);						
	}
}
```
# String sınıfının compareToIgnoreCase metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	 String sınıfının compareToIgnoreCase metodu	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		String s1 = "Ankara";
		String s2 = "AnKaRa";
		
		int result = s1.compareToIgnoreCase(s2);
		
		System.out.println(result);						
	}
}

/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/
```
