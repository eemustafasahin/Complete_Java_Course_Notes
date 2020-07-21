### Değişken isimleri rakam karakteri ile başlatılamaz 
```java
/*----------------------------------------------------------------------------------------------------------------------
	23.05.2020
	Değişken isimleri rakam karakteri ile başlatılamaz  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args)
	{
		int 1number; //error		
		
					
	}
}
```
### Değişken isimleri uygun karakterler ile başlatılıp istenildiği kadar rakam karakteri ile devam ettirilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Değişken isimleri uygun karakterler ile başlatılıp istenildiği kadar rakam karakteri ile devam ettirilebilir  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args)
	{
		int a123456 = 10; 
		
		System.out.println(a123456);					
	}
}
```
### Değişken isimlendirmede UNICODE alfabetik karakterler kullanılabilir. Yani isimler Türkçe karakter de içerebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Değişken isimlendirmede UNICODE alfabetik karakterler kullanılabilir. Yani isimler Türkçe karakter de içerebilir  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args)
	{
		int öğrencisayısı = 10; 
		
		System.out.println(öğrencisayısı);	
					
	}
}
```
### Değişken isimleri büyük küçük harf duyarlıdır (case sensitive)
```java
/*----------------------------------------------------------------------------------------------------------------------
	Değişken isimleri büyük küçük harf duyarlıdır (case sensitive)
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args)
	{
		int val, VAL, Val, VaL; 
		
	}
}
```
### Değişken isimlendirmede boşluk (whitespace) karakteri kullanılamaz
```java
/*----------------------------------------------------------------------------------------------------------------------
	Değişken isimlendirmede boşluk (whitespace) karakteri kullanılamaz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args)
	{
		int number of students; //error
		
	}
}
```
### Değişken isimlendirmede _ karakteri kullanılabilir. Hatta değişken _ ile de başlatılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Değişken isimlendirmede _ karakteri kullanılabilir. Hatta değişken _ ile de başlatılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args)
	{
		int _val = 10;
		int number_of_students = 20;
		
		System.out.println(_val);
		System.out.println(number_of_students);		
	}
}
```
### Java 9'dan itibaren alttire karakteri tek başına değişken ismi olarak kullanılamaz.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java 9'dan itibaren alttire karakteri tek başına değişken ismi olarak kullanılamaz.
	Java 8 ile birlikte alttire karakterinin tek başına değişken ismi olarak kullanımı "deprecated"
	olmuştur.	
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args)
	{
		int _ = 10; //error
		
		System.out.println(_);		
	}
}
```
### Java' da değişken isimlendirmede $ karakteri kullanılması durumu...
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java' da değişken isimlendirmede $ karakteri kullanılabilir. Hatta değişken ismi $ karakteri ile başlatılabilir.
	Hatta $ karakteri tek başına kullanılabilir. Ancak programcı açısından değişken isimlendirmede $ karakteri
	kullanılmaması tavsiye edilir. Çünkü derleyici ve bazı kod üreten araçlar isimlendirmede $ karakterini
	tercih edebilirler (çoğu zaman tercih ederler). İsim çakışması olmaması açısından $ karakteri değişken 
	isimlendirmede tercih edilmez
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args)
	{
		int amountOf$s = 100;
		int $123abc = 200;
		double $ = 345.56;

		
		System.out.println(amountOf$s);
		System.out.println($123abc);
		System.out.println($);		
	}
}
```
### Değişken isimleri doğrudan anahtar sözcüklerden oluşamaz. Ancak ...
```java
/*----------------------------------------------------------------------------------------------------------------------
	Değişken isimleri doğrudan anahtar sözcüklerden oluşamaz. Ancak bu konunun istisnası olarak Java'ya daha
	sonra eklenen anahtar sözcükler değişken isimlendirmede kullanılabilir. Bu tip anahtar sözcükler için derleyici
	kullanım yerine göre anahtar sözcük veya değişken ismi olduğuna karar verir.
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args)
	{
		int package; //error
		int var = 10;
		var a = 20;
	}
}
```
### Değişken isminin kolay telaffuz edilebilir, anlamlı ve yeterince uzunlukta olması tavsiye edilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Değişken isminin kolay telaffuz edilebilir, anlamlı ve yeterince uzunlukta olması tavsiye edilir
----------------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------------
	Klavyeden int türden değer okunması
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());
		
		int square = val * val;
		
		System.out.println(square);
	}
}
```
### Klavyeden int türden değer okunması
```java
/*----------------------------------------------------------------------------------------------------------------------
	Klavyeden int türden değer okunması
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Birinci sayıyı giriniz:");
		int a = Integer.parseInt(kb.nextLine());
		
		System.out.print("İkinci sayıyı giriniz:");
		int b = Integer.parseInt(kb.nextLine());
		
		int total = a + b;
		
		System.out.println(total);
	}
}
```
### Klavyeden double türden değer okunması
```java
/*----------------------------------------------------------------------------------------------------------------------
	Klavyeden double türden değer okunması
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Birinci sayıyı giriniz:");
		double a = Double.parseDouble(kb.nextLine());
		
		System.out.print("İkinci sayıyı giriniz:");
		double b = Double.parseDouble(kb.nextLine());
		
		double total = a + b;
		
		System.out.println(total);
	}
}
```
### Klavyeden long türden değer okunması
```java
/*----------------------------------------------------------------------------------------------------------------------
	Klavyeden long türden değer okunması
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.print("Birinci sayıyı giriniz:");
		long a = Long.parseLong(kb.nextLine());
		
		System.out.print("İkinci sayıyı giriniz:");
		long b = Long.parseLong(kb.nextLine());
		
		long total = a + b;
		
		System.out.println(total);
	}
}
```
### İfade (expression)
```java
/*----------------------------------------------------------------------------------------------------------------------
	İfade (expression): Sabitlerden, operatörlerden ve değişkenlerden oluşan herhangi bir kombinasyona ifade denir
	
	a = b + 10
----------------------------------------------------------------------------------------------------------------------*/
```
### return deyimi
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir metodun geri dönüş değeri return deyimi ile oluşturulur. return deyiminin genel biçimi:
	
	return [ifade];
	
	return deyiminin temel olarak ilk görevi metodu sonlandırmaktır. Metodun geri dönüş değeri varsa return' e
	ilişkinin ifadenin değeri çağıran metoda aktarılır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a;
		
		a = Sample.foo() * 2;
		
		System.out.println(a);
	}
}

class Sample {
	public static int foo()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());
		
		int square = val * val;
		
		return square;
	}
}
```
### return deyimi nasıl kullanılırsa kullanılsın metodu sonlandırır.
```java
/*----------------------------------------------------------------------------------------------------------------------
	return deyimi nasıl kullanılırsa kullanılsın metodu sonlandırır. Aşağıdaki örnekte return deyiminden sonrasına
	akış erişemeceğinden error oluşur
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a;
		
		a = Sample.foo() * 2;
		
		System.out.println(a);
	}
}

class Sample {
	public static int foo()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());
		
		int square = val * val;
		
		return square;
		
		System.out.println("Unreachable code"); //error
	}
}
```
### Akış return deyimine geldiğinde önce return deyimine ilşkin ifade hesaplanır. Sonuç döndürülür
```java
/*----------------------------------------------------------------------------------------------------------------------
	Akış return deyimine geldiğinde önce return deyimine ilşkin ifade hesaplanır. Sonuç döndürülür
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a;
		
		a = Sample.foo() * 2;
		
		System.out.println(a);
	}
}

class Sample {
	public static int foo()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());	 
		
		return val * val;	
	}
}
```
### Geri dönüş değeri olan metotlarda akışın her noktasında return deyimi ifade ile bulunmalıdır.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Geri dönüş değeri olan metotlarda akışın her noktasında return deyimi ifade ile bulunmalıdır. Aksi durumda
	error oluşur
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a;
		
		a = Sample.foo() * 2;
		
		System.out.println(a);
	}
}

class Sample {
	public static int foo() //error
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());	 
		
			
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Geri dönüş değeri olan metotlarda akışın her noktasında return deyimi ifade ile bulunmalıdır. Aksi durumda
	error oluşur
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a;
		
		a = Sample.foo() * 2;
		
		System.out.println(a);
	}
}

class Sample {
	public static int foo() //error
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());	
		
		if (val < 0)
			return 0;	
		
	}
}
```
### Geri dönüş değeri olan metotlarda return tek başına kullanılamaz
```java
/*----------------------------------------------------------------------------------------------------------------------
	Geri dönüş değeri olan metotlarda return tek başına kullanılamaz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a;
		
		a = Sample.foo() * 2;
		
		System.out.println(a);
	}
}

class Sample {
	public static int foo()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());	
		
		return; //error:	
	}
}
```
### Derleyici geri dönüş değeri aktarımı için geçici değişken yaratan kodu üretir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Derleyici geri dönüş değeri aktarımı için geçici değişken yaratan kodu üretir. Aşağıdaki kodun temsili 
	karşılığı:
	int temp = val * val;
	a = temp * 2;	
	
	Yani aslında geri dönüş değeri geçici değişkene yapılan bir atama işlemidir. Geçici değişkenin türü metodun
	geri dönüş değeri türü ile aynıdır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a;
		
		a = Sample.foo() * 2;
		
		System.out.println(a);
	}
}

class Sample {
	public static int foo()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());	
		
		return val * val;
	}
}
```
### Bir metodun geri dönüş değeri başka bir metodun geri dönüş değeri olarak return deyimi ile yazılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir metodun geri dönüş değeri başka bir metodun geri dönüş değeri olarak return deyimi ile yazılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = Mample.bar();
		
		System.out.println(a);
	}
}

class Sample {
	public static int foo()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());	
		
		return val * val;
	}
}

class Mample {
	public static int bar()
	{
		System.out.println("bar");		
		
		return Sample.foo();
	}
}
```
### Geri dönüş değeri olan metotlar geri dönüş değeri yokmuş gibi çağrılabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Geri dönüş değeri olan metotlar geri dönüş değeri yokmuş gibi çağrılabilir. Yani bir metodun geri dönüş 
	değerinin bir işleme sokulmasının zorunluluğu yoktur
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		Sample.foo();
	}
}

class Sample {
	public static int foo()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());
		
		int square = val * val;
		
		System.out.println(square);
		
		return square;
	}
}
```
### Geri dönüş değer olmayan metotlarda (void metot) return zorunlu değildir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Geri dönüş değer olmayan metotlarda (void metot) return zorunlu değildir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		Sample.foo();
	}
}

class Sample {
	public static void foo()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());	
		
		int square = val * val;
		
		System.out.println(square);
		
	}
}
```
### Geri dönüş değer olmayan metotlarda istenirse return tek başına metodu sonlandırmak için kullanılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Geri dönüş değer olmayan metotlarda istenirse return tek başına metodu sonlandırmak için kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		Sample.foo();
	}
}

class Sample {
	public static void foo()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());	
		
		if (val < 0)
			return;
		
		System.out.println(val * val);
	}
}
```
### Geri dönüş değer olmayan metotlar geri dönüş değeri varmış gibi çağrılamaz
```java
/*----------------------------------------------------------------------------------------------------------------------
	Geri dönüş değer olmayan metotlar geri dönüş değeri varmış gibi çağrılamaz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = Sample.foo(); //error
	}
}

class Sample {
	public static void foo()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());	
		
		if (val < 0)
			return;
		
		System.out.println(val * val);
	}
}
```
### Bir metodun bildiriminde parantez içerisinde bildirilen değişkenlere parametre değişkenleri denir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir metodun bildiriminde parantez içerisinde bildirilen değişkenlere parametre değişkenleri denir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		
	}
}

class Sample {
	public static void foo(int a, double b)
	{
		
	}
	
	public static void bar(int a)
	{
		
	}
}
```
### Parametre değişkenleri aynı türden olsa bile her değişken için tür bilgisi yazılmalıdır 
```java
/*----------------------------------------------------------------------------------------------------------------------
	Parametre değişkenleri aynı türden olsa bile her değişken için tür bilgisi yazılmalıdır 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		
	}
}

class Sample {
	public static void foo(int a, b) //error
	{
		
	}
}
```
### Parametre değişkenleri faaliyet alanı bakımından adeta metodun gövdesi (bloğu) başında bildirilen yerel değişkenler gibidir  
```java
/*----------------------------------------------------------------------------------------------------------------------
	Parametre değişkenleri faaliyet alanı bakımından adeta metodun gövdesi (bloğu) başında bildirilen yerel
	değişkenler gibidir  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		
	}
}

class Sample {
	public static void foo(int a, int b)
	{
		double a = 1.3; //error
		
		System.out.println(a);		
		System.out.println(b);
	}
}
```
### Metotlarda argüman nedir?
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir metodun parametrelerine değerler çağrılırken aktarılır. Metot çağrısında parametrelere aktarılan
	ifadelere "argüman" denir . Argümanlardan parametrelere aktarım da bir atama işlemidir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Birinci sayıyı giriniz:");
		int x = Integer.parseInt(kb.nextLine());
		
		System.out.print("İkinci sayıyı giriniz:");
		int y = Integer.parseInt(kb.nextLine());
		
		Sample.foo(x, y);		
	}
}

class Sample {
	public static void foo(int a, int b)
	{		
		System.out.println(a);		
		System.out.println(b);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir metodun parametrelerine değerler çağrılırken aktarılır. Metot çağrısında parametrelere aktarılan
	ifadelere "argüman" denir . Argümanlardan parametrelere aktarım da bir atama işlemidir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Birinci sayıyı giriniz:");
		int a = Integer.parseInt(kb.nextLine());
		
		System.out.print("İkinci sayıyı giriniz:");
		int b = Integer.parseInt(kb.nextLine());
		
		Sample.foo(a, b);		
	}
}

class Sample {
	public static void foo(int a, int b)
	{		
		System.out.println(a);		
		System.out.println(b);
	}
}
```
### Bir metot kaç parametreliyse o kadar sayıda argüman ile çağrılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir metot kaç parametreliyse o kadar sayıda argüman ile çağrılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Birinci sayıyı giriniz:");
		int x = Integer.parseInt(kb.nextLine());
		
		System.out.print("İkinci sayıyı giriniz:");
		int y = Integer.parseInt(kb.nextLine());
		
		Sample.foo(x); //error		
		Sample.foo(x, y, 10); //error
	}
}

class Sample {
	public static void foo(int a, int b)
	{		
		System.out.println(a);		
		System.out.println(b);
	}
}
```
### Metot çağrısında argümanlara ilişkin ifadeler önce hesaplanır. Elde edilen değerler ile metot çağrılır
```java
/*----------------------------------------------------------------------------------------------------------------------
	Metot çağrısında argümanlara ilişkin ifadeler önce hesaplanır. Elde edilen değerler ile metot çağrılır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Birinci sayıyı giriniz:");
		int x = Integer.parseInt(kb.nextLine());
		
		System.out.print("İkinci sayıyı giriniz:");
		int y = Integer.parseInt(kb.nextLine());
		
		Sample.foo(x * 2, y - 3);	
	}
}

class Sample {
	public static void foo(int a, int b)
	{		
		System.out.println(a);		
		System.out.println(b);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir metodun geri dönüş değeri ve parametresi olabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Birinci sayıyı giriniz:");
		int x = Integer.parseInt(kb.nextLine());
		
		int result = NumberUtil.square(x);
		
		System.out.println(result);
	}
}

class NumberUtil {
	public static int square(int val)
	{
		return val * val;
	}
}
```
### Bir metodun geri dönüş değeri başka bir metoda argüman olarak geçilebilir
```java

/*----------------------------------------------------------------------------------------------------------------------
	Bir metodun geri dönüş değeri başka bir metoda argüman olarak geçilebilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		CalculateTotalApp.run();
	}
}

class CalculateTotalApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.println("Birinci sayıyı giriniz:");
		int a = Integer.parseInt(kb.nextLine());
		
		System.out.println("İkinci sayıyı giriniz:");
		int b = Integer.parseInt(kb.nextLine());		
		
		Util.display(NumberUtil.add(a, b));
	}
}

class Util {
	public static void display(int val)
	{
		System.out.println(val);
	}
}

class NumberUtil {
	public static int add(int a, int b)
	{
		return a + b;
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir metodun geri dönüş değeri başka bir metoda argüman olarak geçilebilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		CalculateTotalApp.run();
	}
}

class CalculateTotalApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.printn("Birinci sayıyı giriniz:");
		int a = Integer.parseInt(kb.nextLine());
		
		System.out.println("İkinci sayıyı giriniz:");
		int b = Integer.parseInt(kb.nextLine());		
		
		System.out.println(NumberUtil.add(a, b));
	}
}


class NumberUtil {
	public static int add(int a, int b)
	{
		return a + b;
	}
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
	Bir metodun geri dönüş değeri başka bir metoda argüman olarak geçilebilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		CalculateTotalApp.run();
	}
}

class CalculateTotalApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.println("Birinci sayıyı giriniz:");
		int a = Integer.parseInt(kb.nextLine());
		
		System.out.println("İkinci sayıyı giriniz:");
		int b = Integer.parseInt(kb.nextLine());		
		
		System.out.println(NumberUtil.add(a + 2, b * 3));
	}
}


class NumberUtil {
	public static int add(int a, int b)
	{
		return a + b;
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte Add metodunu iki defa çağırmak yerine sonuç tekrar kullanılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		CalculateTotalApp.run();
	}
}

class CalculateTotalApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.println("Birinci sayıyı giriniz:");
		int a = Integer.parseInt(kb.nextLine());
		
		System.out.println("İkinci sayıyı giriniz:");
		int b = Integer.parseInt(kb.nextLine());		
		
		int sum = NumberUtil.add(a, b);
		
		System.out.println(sum);		
		System.out.println(sum);
	}
}


class NumberUtil {
	public static int add(int a, int b)
	{
		return a + b;
	}
}
```
### printf metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	24.05.2020
	System.out.printf metodunun ilk argümanı String atomu olmalıdır. printf metodu bu argüman dışında istenilen
	ve istenildiği kadar argüman alabilir. printf metodunun ilk argümanı olan String atomu içerisinde % karakteri
	ile birlikte anlamlı bazı karakterler kullanılabilir. Kullanılan bu karakterlere format belirleyici (format specifier)
	denir. Format karakterinin yüzde karakteri ile birlikte kullanımına yer tutucu (place holder) denir 
----------------------------------------------------------------------------------------------------------------------*/
```
### Tamsayı türlerinin (short, int, long, byte) decimal formatlanması için d format karakteri kullanılır
```java
/*----------------------------------------------------------------------------------------------------------------------
	Tamsayı türlerinin (short, int, long, byte) decimal formatlanması için d format karakteri kullanılır  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int degree = 25;
		
		System.out.printf("Bugün hava %d derece", degree);		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Tamsayı türlerinin (short, int, long, byte) decimal formatlanması için d format karakteri kullanılır  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int degree = 25;
		
		System.out.printf("Bugün hava %d derece", degree);		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Tamsayı türlerinin (short, int, long, byte) decimal formatlanması için d format karakteri kullanılır  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int degree = 25;
		int tomDegree = 28;
		
		System.out.printf("Bugün hava %d derece. Yarın %d derece olacak", degree, tomDegree);		
	}
}
```
### printf metodu ile x, X, h ve H format karakterleri kullanılarak tamsayı türleri hexadecimal olarak gösterilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	printf metodu ile x, X, h ve H format karakterleri kullanılarak tamsayı türleri hexadecimal olarak gösterilebilir
	printf metodu yazıyı bastıktan sonra imleci son karakterden sonraya çeker. Alt satırın başına indirmek için
	n format karakteri kullanılabilir  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int val = 10;
		
		System.out.printf("val=%d%n", val);		
		System.out.printf("val(oct)=%x%n", val);
		System.out.printf("val(oct)=%X%n", val);
		System.out.printf("val(hex)=%h%n", val);
		System.out.printf("val(hex)=%H%n", val);
	}
}
```
### printf metodu ile o format karakteri kullanılarak tamsayı türleri octal olarak gösterilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	printf metodu ile o format karakteri kullanılarak tamsayı türleri octal olarak gösterilebilir	  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int val = 10;
		
		System.out.printf("val=%d%n", val);		
		System.out.printf("val(oct)=%o%n", val);		
	}
}

```
### printf metodunda gerçek sayı türleri (double, float) için f format karakteri kullanılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
  	printf metodunda gerçek sayı türleri (double, float) için f format karakteri kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		double val = 2.34;
		
		System.out.printf("val=%f%n", val);			
	}
}
```
### printf metodu ile virgülden sonra kaç basamak gösterileceğinin belirlenmesi
```java
/*----------------------------------------------------------------------------------------------------------------------
  	printf metodu ile virgülden sonra kaç basamak gösterileceğinin belirlenmesi
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		double val = 2.345678;
		
		System.out.printf("val=%.4f%n", val);			
	}
}
```
### printf metodu ile hizalama yapılması
```java
/*----------------------------------------------------------------------------------------------------------------------
  	printf metodu ile hizalama yapılması
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int day = 10, mon = 9, year = 1976;
		
		System.out.printf("%02d/%02d/%04d%n", day, mon, year);
	}
}
```
### printf metodunda c format karakteri ile char türüne ilişkin karakter gösterilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
  	printf metodunda c format karakteri ile char türüne ilişkin karakter gösterilebilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		char ch = 67;
		
		System.out.printf("ch=%c%n", ch);
	}
}
```
### printf metodunda b format karakteri ile boolean türüne ilişkin değer gösterilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
  	printf metodunda b format karakteri ile boolean türüne ilişkin değer gösterilebilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		boolean b = true;
		
		System.out.printf("b=%b%n", b);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte Add metodunu iki defa çağırmak yerine sonuç tekrar kullanılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		CalculateTotalApp.run();
	}
}

class CalculateTotalApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Birinci sayıyı giriniz:");
		int a = Integer.parseInt(kb.nextLine());
		
		System.out.print("İkinci sayıyı giriniz:");
		int b = Integer.parseInt(kb.nextLine());		
		
		int sum = NumberUtil.add(a, b);
		
		System.out.printf("%d + %d = %d%n", a, b, sum);		
	}
}


class NumberUtil {
	public static int add(int a, int b)
	{
		return a + b;
	}
}
```
### System.out.format metodu printf ile tamamen aynı işi yapar
```java
/*----------------------------------------------------------------------------------------------------------------------
	System.out.format metodu printf ile tamamen aynı işi yapar
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		CalculateTotalApp.run();
	}
}

class CalculateTotalApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Birinci sayıyı giriniz:");
		int a = Integer.parseInt(kb.nextLine());
		
		System.out.print("İkinci sayıyı giriniz:");
		int b = Integer.parseInt(kb.nextLine());		
		
		int sum = NumberUtil.add(a, b);
		
		System.out.format("%d + %d = %d%n", a, b, sum);		
	}
}


class NumberUtil {
	public static int add(int a, int b)
	{
		return a + b;
	}
}
```
### printf ile % karakterini gösterebilmek için iki tane yanyana % karakteri kullanılmalıdır
```java
/*----------------------------------------------------------------------------------------------------------------------
	printf ile % karakterini gösterebilmek için iki tane yanyana % karakteri kullanılmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		int ratio = 10;
		
		System.out.printf("Faiz oranı:%%%d%n", ratio);
		
	}
}
```
### Math sınıfının abs metodu 
```java
/*----------------------------------------------------------------------------------------------------------------------
	Math sınıfının abs metodu 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		double val = Double.parseDouble(kb.nextLine());
		
		System.out.printf("|%f|=%f%n", val, Math.abs(val));					
	}
}
```
### Math sınıfının sqrt metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Math sınıfının sqrt metodu 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		double val = Double.parseDouble(kb.nextLine());
		
		System.out.printf("sqrt(%f)=%f%n", val, Math.sqrt(val));					
	}
}
```
### Gerçek sayılar içinde belirsizlik ve tanımsızlık Nan nedir ?
```java
/*----------------------------------------------------------------------------------------------------------------------
	Gerçek sayılar içerisinde belirsizliğe ve tanımsızlığa karşılık gelen değerler vardır. Örneğin 
	belirsizlik için genel olarak NaN değeri kullanılır 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		double a = -4, b = 0;
		
		System.out.println(a / b);
	}
}
```
### Math sınıfının pow metodu 
```java
/*----------------------------------------------------------------------------------------------------------------------
	Math sınıfının pow metodu 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Tabanı giriniz:");
		double a = Double.parseDouble(kb.nextLine());
		
		System.out.print("Üssü giriniz:");
		double b = Double.parseDouble(kb.nextLine());
		
		System.out.printf("pow(%f, %f)=%f%n", a, b, Math.pow(a, b));					
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Math sınıfının pow metodu 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Tabanı giriniz:");
		double a = Double.parseDouble(kb.nextLine());
		
		System.out.print("Üssü giriniz:");
		double b = Double.parseDouble(kb.nextLine());
		
		System.out.printf("pow(%f, %f)=%f%n", a, b, Math.pow(a, b));					
	}
}
```
### Math sınıfının PI ve E elemanları
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Math sınıfının PI ve E elemanları
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		System.out.printf("%.20f%n", Math.PI);					
		System.out.printf("%.20f%n", Math.E);
	}
}
```
### Sınıf Çalışması: Koordinat bilgilerine göre iki nokta arasındaki uzaklık bilgisini döndüren distance isimli metodu yazın.
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Sınıf Çalışması: Parametresi ile aldığı double türden x1, y1, x2, y2 koordinat bilgilerine göre
	 iki nokta arasındaki uzaklık bilgisini döndüren distance isimli metodu PointUtil isimli sınıf 
	 içerisinde yazınız. Klavyeden alınan değerlerle çağırarak test ediniz.
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		DistanceTest.run();
	}
}

class DistanceTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("x1 değerini giriniz:");
		double x1 = Double.parseDouble(kb.nextLine());
		System.out.print("y1 değerini giriniz:");
		double y1 = Double.parseDouble(kb.nextLine());
		
		System.out.print("x2 değerini giriniz:");
		double x2 = Double.parseDouble(kb.nextLine());
		System.out.print("y2 değerini giriniz:");
		double y2 = Double.parseDouble(kb.nextLine());
		
		double dist = PointUtil.distance(x1, y1, x2, y2);
		
		System.out.printf("Uzaklık:%f%n", dist);
	}
}

class PointUtil {
	public static double distance(double x1, double y1, double x2, double y2)
	{
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Sınıf Çalışması: Parametresi ile aldığı double türden x1, y1, x2, y2 koordinat bilgilerine göre
	 iki nokta arasındaki uzaklık bilgisini döndüren distance isimli metodu PointUtil isimli sınıf 
	 içerisinde yazınız. Klavyeden alınan değerlerle çağırarak test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		DistanceTest.run();
	}
}

class DistanceTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("x1 değerini giriniz:");
		double x1 = Double.parseDouble(kb.nextLine());
		System.out.print("y1 değerini giriniz:");
		double y1 = Double.parseDouble(kb.nextLine());
		
		System.out.print("x2 değerini giriniz:");
		double x2 = Double.parseDouble(kb.nextLine());
		System.out.print("y2 değerini giriniz:");
		double y2 = Double.parseDouble(kb.nextLine());
		
		double dist = PointUtil.distance(x1, y1, x2, y2);
		
		System.out.printf("Uzaklık:%f%n", dist);
	}
}

class PointUtil {
	public static double distance(double x1, double y1, double x2, double y2)	
	{
		double diffx = x1 - x2;
		double diffy = y1 - y2;
		
		return Math.sqrt(diffx * diffx + diffy * diffy);
	}
}
```
### Math sınıfının trigonometrik metotları radyan ölçü birimi ile çalışır
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Math sınıfının trigonometrik metotları radyan ölçü birimi ile çalışır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.printf("Bir sayı giriniz:");
		double val = Double.parseDouble(kb.nextLine());
		
		System.out.printf("sin(%f)=%f%n", val, Math.sin(val));
		
	}
}
```
### Math sınıfının toRadians metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Math sınıfının toRadians metodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.printf("Derece değerini giriniz:");
		double val = Double.parseDouble(kb.nextLine());
		
		System.out.printf("sin(%f)=%f%n", val, Math.sin(Math.toRadians(val)));		
	}
}
```
### Math sınıfının logaritma metotları
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Math sınıfının logaritma metotları
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.printf("Bir sayı giriniz:");
		double val = Double.parseDouble(kb.nextLine());
		
		System.out.printf("log(%f)=%f%n", val, Math.log(val));		
		System.out.printf("log10(%f)=%f%n", val, Math.log10(val));
		System.out.printf("log1p(%f)=%f%n", val, Math.log1p(val)); // Math.log(val + 1)
	}
}
```
### MathUtil sınıfının log metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	 MathUtil sınıfının log metodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.printf("Bir sayı giriniz:");
		double val = Double.parseDouble(kb.nextLine());
		
		System.out.printf("log(%f, %f)=%f%n", 2.0, val, MathUtil.log(2, val));		
		
	}
}

class MathUtil {
	public static double log(double a, double b)
	{
		return Math.log(b) / Math.log(a);
	}
}
```
### Math sınıfının min ve max metotları
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Math sınıfının min ve max metotları
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.printf("Birinci sayıyı giriniz:");
		int a = Integer.parseInt(kb.nextLine());

		System.out.printf("İkinci sayıyı giriniz:");
		int b = Integer.parseInt(kb.nextLine());
		
		System.out.printf("min(%d, %d)=%d%n", a, b, Math.min(a, b));
		System.out.printf("max(%d, %d)=%d%n", a, b, Math.max(a, b));		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Math sınıfının min ve max metotları
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.printf("Birinci sayıyı giriniz:");
		int a = Integer.parseInt(kb.nextLine());

		System.out.printf("İkinci sayıyı giriniz:");
		int b = Integer.parseInt(kb.nextLine());
		
		System.out.printf("Üçüncü sayıyı giriniz:");
		int c = Integer.parseInt(kb.nextLine());
		
		int min = Math.min(a, Math.min(b, c));
		int max = Math.max(a, Math.max(b, c));
		
		System.out.printf("min(%d, %d, %d)=%d%n", a, b, c, min);
		System.out.printf("max(%d, %d, %d)=%d%n", a, b, c, max);		
	}
}
```
### Math sınıfının yuvarlama yapan temel metotları
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Math sınıfının yuvarlama yapan temel metotları
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.printf("Bir sayı giriniz:");
		double a = Double.parseDouble(kb.nextLine());
		
		System.out.printf("round(%f)=%d%n", a, Math.round(a));
		System.out.printf("rint(%f)=%f%n", a, Math.rint(a));
		System.out.printf("floor(%f)=%f%n", a, Math.floor(a));
		System.out.printf("ceil(%f)=%f%n", a, Math.ceil(a));
			
	}
}
```
## Sabitler (literals)
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Sabitler (literals):
	 Program içerisinde doğrudan yazılan sayılara sabit denir. Sabitlerin de türleri vardır. Derleyici de  sabitin 
	 türüne	 göre işlem yapar.
	 
	 Sabitlerin türlerine ilişkin detaylar:
	 - Sayı nokta içermiyorsa ve sonuna bir ek almamışsa ve int türü sınırları içerisinde ise int türdendir. Sınırlar
	 dışında ise error oluşur
	 Örneğin: 10, 20, 2000000
	 
	 - Sayı nokta içermiyorsa ve sonuna L (küçük veya büyük) ekini almışsa long türdendir. Sayı long türü
	 sınırları dışındaysa error oluşur.
	 Örneğin: 10L, 4000000000L
	 
	 - Java' da byte ve short türlerinden sabit yoktur
	 
	 - Sayı nokta içeriyorsa ve hiç bir son ek almamışsa double türdendir. Sınırlar dışında kalıyorsa error oluşur
	 
	 Örneğin: 3.4, 456.123
	 
	 - Sayı nokta içersin ya da içermesin sonuna D (küçük veya büyük) ekini almışsa double türdendir.
	 Örneğin: 10d, 1.2d, 4.5D
	 
	 - Sayı nokta içersin ya da içermesin sonuna F (küçük veya büyük) ekini almışsa float türdendir
	 Örneğin: 3f, 2.3F 
	 
	 - boolean türden iki tane sabit vardır:true, false
	 
	 - char türden sabitler: Tek tırnak içerisinde yazılan uygun karakter(ler) tek tırnağı ile birlikte char türden
	 sabittir. Örneğin: 'z' sabiti z karakterinin tablodaki sıra numarasına karşılık gelir.
----------------------------------------------------------------------------------------------------------------------*/
```
### char türden sabitler
```java
/*----------------------------------------------------------------------------------------------------------------------
	 char türden sabitler	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		char ch = ':';
		
		System.out.println(ch);
	}
}
```
