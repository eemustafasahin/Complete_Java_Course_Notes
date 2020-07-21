### Sınıf çalışması: getDayOfYear isimli metodu yazınız ve test ediniz.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf çalışması: Parametresi ile aldığı int türden gün, ay ve yıl bilgilerine ilişkin tarihin yılın kaçıncı
	günü olduğunu döndüren getDayOfYear isimli metodu yazınız ve test ediniz. Metot geçersiz bir tarih için
	-1 değerini döndürecektir	
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{							
		GetDayOfYearTest.run();
	}
}

class GetDayOfYearTest {
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
			
			int dayOfYear = DateUtil.getDayOfYear(day, month, year);
			
			if (dayOfYear != -1)
				System.out.printf("%02d/%02d/%04d tarihi yılın %d. günüdür%n", day, month, year, dayOfYear);
			else
				System.out.println("Geçersiz tarih");			
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}	
}

class DateUtil {
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
			dayOfYear += 28;
			if (isLeapYear(year))
				++dayOfYear;
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
			days = 28;
			if (isLeapYear(year))
				++days;
		}
		
		return day <= days;
	}
	
	public static boolean isLeapYear(int year)
	{
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
}
```
### Sınıf çalışması: getDayOfWeek metodunu yazınız.
```java
/*----------------------------------------------------------------------------------------------------------------------
	20.06.2020
	Sınıf çalışması: Parametresi ile aldığı int türden gün, ay ve yıl bilgilerine ilişkin tarihin aşağıdaki 
	açıklamalara göre haftanın hangi gününe geldiğini döndüren getDayOfWeek metodunu yazınız.
	Açıklamalar: 
		- Metot geçersiz bir tarih için -1 değerini döndürecektir.
		- Haftanın günü 1.1.1900 ile verilen tarih arasındaki gün sayısının 7 değerine modu alınarak bulunabilir
		- 7 değerine mod alındıktan sonra sıfır Pazar, 1 pazartesi, .., 6 cumartesi günü için
		elde edilecek değerdir
		- 1.1.1900' den önceki tarihler geçersiz kabul edilecektir 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{							
		GetDayOfWeekTest.run();
	}
}

class GetDayOfWeekTest {
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

class DateUtil {
	public static int getDayOfWeek(int day, int month, int year)
	{
		int dayOfYear;
		
		dayOfYear = getDayOfYear(day, month, year);
		
		if (dayOfYear == -1 || year < 1900)
			return -1;
		
		for (int y = 1900; y < year; ++y) {
			dayOfYear += 365;
			if (isLeapYear(y))
				++dayOfYear;
		}
		
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
			dayOfYear += 28;
			if (isLeapYear(year))
				++dayOfYear;
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
			days = 28;
			if (isLeapYear(year))
				++days;
		}
		
		return day <= days;
	}
	
	public static boolean isLeapYear(int year)
	{
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
}
```
## Tür Dönüşümümlerine genel bakış
```java
/*----------------------------------------------------------------------------------------------------------------------
	T1 ve T2 tür ismi olmak üzere T1 türünden T2 türüne yapılan doğrudan atama işlemine T1 türünden T2 türüne
	doğrudan dönüştürme (implicit conversion). Bu atama örneğin:
	T1 a;
	T2 b;
	
	b = a;
	
	şeklinde belirtilebilir. Aşağıdaki anlatılan kurallar aksi belirtilmediği sürece tüm atama durumları için 
	geçerlidir. 
	
	Yukarıdaki atamada T1 türüne kaynak tür (source type), T2 türüne hedef tür (target type). Java'da bir bir türün
	başka bir türe atanıp atanamayacağına derleme zamanında bakılır. Kaynak türe ilişkin değere yani çalışma zamanında
	atanmayacağına bakılmaz. Zaten çoğu zaman da bakılamaz.
	
	Java' da genel olarak bilgi kaybına yol açmayacak dönüşümler doğrudan geçerlidir.
	
	Anahtar Not: Java Language Specification dökümanında uzunluk olarak küçük türden uzunluk olarak büyük türe
	dönüşüme genişletme dönüşümü (widening conversion), büyük türden küçük türe yapılan dönüşüme ise
	daraltma dönüşümü (narrowing conversion) terimleri kullanılmaktadır
----------------------------------------------------------------------------------------------------------------------*/
```
### Aşağıdaki örnekte long türünün içerisindeki değere bakılmaksızın atama geçersiz olduğundan error oluşur  
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte long türünün içerisindeki değere bakılmaksızın atama geçersiz olduğundan error oluşur  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{							
		long a = 10;
		int b;
		
		b = a; //error
	}
}
```
### Küçük tamsayı türünden büyük tamsayı türüne doğrudan atama yapılabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Küçük tamsayı türünden büyük tamsayı türüne doğrudan atama yapılabilir.
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		byte a = 10;
		int b;
		
		b = a; 
		
		System.out.printf("a=%d%n", a);
		System.out.printf("b=%d%n", b);
		
	}
}
```
### Küçük tamsayı türünden büyük tamsayı türüne yapılan atamalarda tamsayı türüne ilişkin değer pozitif veya sıfır ise nasıl besleme yapılır ?
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Küçük tamsayı türünden büyük tamsayı türüne yapılan atamalarda küçük tamsayı türüne ilişkin değer 
	 pozitif veya sıfır ise sayının eklenen yüksek anlamlı bit'leri sıfır ile beslenir.
	 Eğer sayı negatif ise sayının işaretinin değişmemesi yüksek anlamlı bitler 1(bir) ile beslenir	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		short a = Short.parseShort(kb.nextLine());
		int b;
		
		b = a;
		
		System.out.printf("a=%d%n", a);
		System.out.printf("a=0x%X%n", a);
		System.out.printf("b=%d%n", b);
		System.out.printf("b=0x%X%n", b);				
	}
}
```
### Hiç bir türden char türüne doğrudan atama yapılamaz
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Hiç bir türden char türüne doğrudan atama yapılamaz	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		int val = 67;
		char ch = val; //error
	}
}
```
### Yukarıdaki kuralın istisnası olarak "char türü sınırları içerisinde kalan int türden bir sabit" char türüne doğrudan atanabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Yukarıdaki kuralın istisnası olarak "char türü sınırları içerisinde kalan int türden bir sabit" char türüne
	 doğrudan atanabilir	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		int val = 67;
		char c1 = 67;
		char c2 = 70000; //error
		char c3 = 67L; //error
		char c4 = val; //error 
		
	}
}
```
### char türünden short türüne doğrudan atama geçersizdir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	 char türünden short türüne doğrudan atama geçersizdir	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		char a = 40000;		
		short b;
		
		b = a; //error		 
		
	}
}
```
### char türünden kendisinden uzunluk olarak büyük türlere doğrudan atama geçerlidir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	 char türünden kendisinden uzunluk olarak büyük türlere doğrudan atama geçerlidir 	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		char a = 'C';		
		int b;
		
		b = a;		
		
		System.out.printf("b=%d%n", b);		
	}
}
```
### char türünden kendisinden uzunluk olarak büyük türlere doğrudan atama geçerlidir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	 char türünden kendisinden uzunluk olarak büyük türlere doğrudan atama geçerlidir.	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		char a = 'C';		
		double b;
		
		b = a;		
		
		System.out.printf("b=%f%n", b);		
	}
}
```
### short türünden char türüne doğrudan atama geçersizdir 
```java
/*----------------------------------------------------------------------------------------------------------------------
	 short türünden char türüne doğrudan atama geçersizdir 	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		short a = 10;
		char c;
		
		c = a; //error
	}
}
```
### Bilindiği gibi Java'da byte ve short türden sabit yoktur. Ancak "sınırlar içerisinde kalan int türden bir sabit" byte/short türüne atanabilir 
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Bilindiği gibi Java'da byte ve short türden sabit yoktur. Ancak "sınırlar içerisinde kalan int türden bir sabit"
	 byte/short türüne atanabilir 	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		short x = 10;
		byte y = 30;
		
		
		x = 40000; //error
		x = 40L; //error
		
		int val = 10;
		
		x = val; //error		
	}
}
```
### Bütün tamsayı türlerinden gerçek sayı türlerine doğrudan atama geçerlidir
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Bütün tamsayı türlerinden gerçek sayı türlerine doğrudan atama geçerlidir 	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		long a = 10;
		float b;
		
		b = a;
	}
}
```
### Gerçek sayılardan tamsayı türlerine atama geçersizdir 
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Gerçek sayılardan tamsayı türlerine atama geçersizdir 	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		float a = 10;
		long b;
		
		b = a; //error
	}
}
```
### float türünden double türüne doğrudan atama geçerlidir
```java
/*----------------------------------------------------------------------------------------------------------------------
	 float türünden double türüne doğrudan atama geçerlidir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		float a = 10;
		double b;
		
		b = a;
	}
}
```
### double türünden float türüne doğrudan atama geçersizdir 
```java
/*----------------------------------------------------------------------------------------------------------------------
	 double türünden float türüne doğrudan atama geçersizdir 	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		double a = 10;
		float b;
		
		b = a; //error
	}
}
```
### boolean türünden herhangi bir türe doğrudan atama geçersizdir 
```java
/*----------------------------------------------------------------------------------------------------------------------
	 boolean türünden herhangi bir türe doğrudan atama geçersizdir 	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		boolean flag = true;
		int a;
		
		a = flag; //error
	}
}
```
### Herhangi bir türden boolean türüne doğrudan atama geçersizdir 
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Herhangi bir türden boolean türüne doğrudan atama geçersizdir 	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		int a = 0;
		boolean b;
		
		b = a; //error
	}
}
```
## Temel türler için doğrudan dönüşüm tablosu:
```java
/*----------------------------------------------------------------------------------------------------------------------
	Temel türler için doğrudan dönüşüm tablosu:
	byte 	-> short, int, long, float, double
	short 	-> int, long, float, double
	int 	-> long, float, double
	long 	-> float, double
	float 	-> double
	char 	-> int, long, float, double	
----------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------
	 short, byte ve char türlerine "sınırlar içerisinde kalması koşuluyla int türden sabit atanması" detayları 	 
----------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------
	 short, byte ve char türlerine "sınırlar içerisinde kalması koşuluyla int türden sabit atanması" kuralları
	 metodun geri dönüş değerinin geçici değişkene atanması işleminde de geçerlidir	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		
	}
}

class Sample {
	public static short foo()
	{
		//...
		
		return 10;		
	}
	
	public static byte bar()
	{
		//...
		return 123;
	}
	
	public static char tar()
	{
		//...
		return 67;
	}
}
```
### short, byte ve char türlerine "sınırlar içerisinde kalması koşuluyla int türden sabit atanması" kuralları metot çağrısında argümanlardan parametrelere yapılan atama işleminde geçersizdir
```java
/*----------------------------------------------------------------------------------------------------------------------
	 short, byte ve char türlerine "sınırlar içerisinde kalması koşuluyla int türden sabit atanması" kuralları
	 metot çağrısında argümanlardan parametrelere yapılan atama işleminde geçersizdir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		Sample.foo(10); //error
		Sample.bar(20); //error
		Sample.tar(67); //error		
	}
}

class Sample {
	public static void foo(short a)
	{
		//...		
	}
	
	public static void bar(byte b)
	{
		//...		
	}
	
	public static void tar(char c)
	{
		//...	
	}
}
```
### Aşağıdaki örnekte float türüne atamalar yapılmıştır. Çıktıları inceleyiniz
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Aşağıdaki örnekte float türüne atamalar yapılmıştır. Çıktıları inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		float a = 10;
		float b = 3.4F;
		double c = 3.4;
		
		System.out.printf("a=%.30f%n", a);
		System.out.printf("b=%.30f%n", b);
		System.out.printf("c=%.30f%n", c);				
	}
}
```
### Aşağıdaki örnekte klavyden float değer alındığında yuvarlama hatası oluşabilir
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Aşağıdaki örnekte klavyden float değer alındığında yuvarlama hatası oluşabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		float a = Float.parseFloat(kb.nextLine());
		
		System.out.printf("a=%.30f%n", a);						
	}
}
```
### Yukarıda söylenen sabite ilişkin detaylar sabit ifadeleri için de geçerlidir. Zaten sabit ifadelerinin sonucu da sabittir
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Yukarıda söylenen sabite ilişkin detaylar sabit ifadeleri için de geçerlidir. Zaten sabit ifadelerinin 
	 sonucu da sabittir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		byte a = 123 + 5; //error: 						
	}
}
```
### İki operandlı bir operatör için derleyici önce operandların türlerine bakar. Operandlar farklı türdense önce ortak türe dönüştürür sonra işlemi yapar.
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 İki operandlı bir operatör için derleyici önce operandların türlerine bakar. Operandlar farklı türdense 
	 önce ortak türe dönüştürür sonra işlemi yapar. Bu dönüştürmeye işlem öncesi otomatik tür dönüştürmesi denir
	 Bu kuralın özeti "Genel olarak küçük türe ilişkin değer büyük türe dönüştürülür. Sonuç büyük türden elde edilir"  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		int a;
		long b;
		
		a = 10;
		b = 30L;
		
		long c = a + b;
		
		System.out.printf("c=%d%n", c);				
	}
}
```
### İşlem öncesinde her iki operand da byte, short ve char türlerindense (yani uzunluk olarak int türünden küçükse) her iki operand da int türüne yükseltilir (integer promotion), sonuç int türden çıkar 
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 İşlem öncesinde her iki operand da byte, short ve char türlerindense (yani uzunluk olarak int türünden küçükse)
	 her iki operand da int türüne yükseltilir (integer promotion), sonuç int türden çıkar   
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		short a, b;		
		short c;
		
		a = 10;
		b = 20;
		
		c = a + b; //error
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 İşlem öncesinde her iki operand da byte, short ve char türlerindense (yani uzunluk olarak int türünden küçükse)
	 her iki operand da int türüne yükseltilir (integer promotion), sonuç int türden çıkar   
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		byte a, b;		
		short c;
		
		a = 10;
		b = 20;
		
		c = a + b; //error
	}
}
```
### Gerçek sayı türleri ve tamsayı türleri işleme sokulduğunda dönüştürme gerçek sayı türüne doğrudur ve sonuç dönüştürülen gerçek sayı türünden çıkar. 
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Gerçek sayı türleri ve tamsayı türleri işleme sokulduğunda dönüştürme gerçek sayı türüne doğrudur ve sonuç
	 dönüştürülen gerçek sayı türünden çıkar.    
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		float a;
		long b;
		
		a = 3.4F;
		b = 3;
		
		float c;
		
		c = a + b; 
	}
}
```
### Bölme işleminde her iki operand da tamsayı türlerine ilişkinse sonuç tamsayı türünden çıkar. Bölme işlemi yapılır. Elde edilen değerin noktadan sonraki kısmı atılır  
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Bölme işleminde her iki operand da tamsayı türlerine ilişkinse sonuç tamsayı türünden çıkar. Bölme işlemi yapılır.
	 Elde edilen değerin noktadan sonraki kısmı atılır    
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		int a = 10;
		int b = 3;		
		double c;
		
		c = a / b;
		
		System.out.printf("c=%.30f%n", c);
		
	}
}
```
### Küçük tamsayı türü ile büyük tamsayı türü işleme sokulduğunda dönüşüm büyük tamsayı türüne doğrudur. Sonuçta büyük tamsayı türünden çıkar
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Küçük tamsayı türü ile büyük tamsayı türü işleme sokulduğunda dönüşüm büyük tamsayı türüne doğrudur. 
	 Sonuçta büyük tamsayı türünden çıkar    
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		int a = 10;
		long b = 3;		
		long c;
		
		c = a + b;
		
		System.out.printf("c=%d%n", c);		
	}
}
```
### boolean türü hiçbir tür ile işleme sokulamaz   
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 boolean türü hiçbir tür ile işleme sokulamaz    
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		boolean a = false;
		int b = 3;		
		int c;
		
		c = a + b; //error
		
		System.out.printf("c=%d%n", c);		
	}
}
```
### char türü diğer türlerle işleme sokulabilir  
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 char türü diğer türlerle işleme sokulabilir    
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		char a = 'C';
		float b = 3;		
		float c;
		
		c = a + b;				
		
		System.out.printf("c=%f%n", c);		
	}
}
```
### İşlem öncesi otomatik tür dönüşümü geçici değişken yaratılarak yapılır. Örnekte derleyici aşağıdakine benzer bir kod üretir: 
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 İşlem öncesi otomatik tür dönüşümü geçici değişken yaratılarak yapılır. Örnekte derleyici aşağıdakine benzer 
	 bir kod üretir: 
	 long temp = a;	 
	 long c = temp + b;
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		int a = 10;
		long b = 20;		
		long c = a + b; //**
		//...
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 İşlem öncesi otomatik tür dönüşümü geçici değişken yaratılarak yapılır. Örnekte derleyici aşağıdakine benzer 
	 bir kod üretir: 
	 int temp1 = a;	 
	 int temp2 = b;
	 int c = temp1 + temp2;
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		short a = 10;
		char b = 'Z';		
		int c = a + b;
		
		//...				
	}
}
```
## Tür dönüştürme operatörünün genel biçimi:
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Tür dönüştürme operatörünün genel biçimi:
	 (<tür ismi>) <operand>
	 
	 Tür dönüştürme operatörü ile yapılan dönüşümlere "explicit conversion" denir. Genel olarak implicit olmayan
	 dönüşümler explicit olarak yapılır. Tür dönüştürme operatörünün kullanılma zorunluğu genel olarak bize  
	 "ortada bir problem olabilir. Derleyici bunu doğrudan yapmamızı istemiyor. Benim derleyiciye durumun farkındayım
	 demem gerekiyor" algısı yaratmalıdır. 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		int a = 10;
		int b = 3;
		
		double c = (double)a / b;
		
		System.out.printf("c=%f%n", c);
	}
}
```
### implicit olarak yapılabilen dönüşümler explicit olarak da yapılabilir. Ancak bunun kullanımı anlamsızdır
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 implicit olarak yapılabilen dönüşümler explicit olarak da yapılabilir. Ancak bunun kullanımı anlamsızdır 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		int a = 10;
		long b = (long)a;
		
		System.out.printf("b=%d%n", b);
	}
}
```
### Aşağdaki explicit dönüşüme ilişkin maddeler else-if biçiminde değerlendirilmelidir
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Aşağdaki explicit dönüşüme ilişkin maddeler else-if biçiminde değerlendirilmelidir 
----------------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------------	 
	 Dönüştürme sırasında kaynak türün içerisindeki değer hedef türün sınırları içeriisnde kalıyor ise bilgi kaybı
	 oluşmaz 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		long a;
		int b;
		
		a = 234;
		b = (int)a;
		
		System.out.printf("b=%d%n", b);			
	}
}
```
### Büyük tamsayı türünden küçük tamsayı türüne yapılan explicit dönüşümde sayının yüksek anlamlı byte değerleri atılır. Elde edilen değer hedef tamsayı türüne atanır
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Büyük tamsayı türünden küçük tamsayı türüne yapılan explicit dönüşümde sayının yüksek anlamlı byte değerleri
	 atılır. Elde edilen değer hedef tamsayı türüne atanır 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		long a;
		int b;
		
		a = 100_000_000_000L;
		b = (int)a;
		
		System.out.printf("a=%d%n", a);
		System.out.printf("a=0x%X%n", a);
		System.out.printf("b=%d%n", b);
		System.out.printf("b=0x%X%n", b);			
	}
}
```

```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Büyük tamsayı türünden küçük tamsayı türüne yapılan explicit dönüşümde sayının yüksek anlamlı byte değerleri
	 atılır. Elde edilen değer hedef tamsayı türüne atanır 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in); 
		long a;
		int b;
		
		System.out.print("Bir sayı giriniz:");
		a = Long.parseLong(kb.nextLine());
		b = (int)a;
		
		System.out.printf("a=%d%n", a);
		System.out.printf("a=0x%X%n", a);
		System.out.printf("b=%d%n", b);
		System.out.printf("b=0x%X%n", b);			
	}
}
```
### short türünden char türüne yapılan explicit dönüşümde sayının bit kalıbı değişmez. Bitlerin yorumlanışı değişir 
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 short türünden char türüne yapılan explicit dönüşümde sayının bit kalıbı değişmez.
	 Bitlerin yorumlanışı değişir 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in); 
		short a;
		char b;
		
		System.out.print("Bir sayı giriniz:");
		a = Short.parseShort(kb.nextLine());
		b = (char)a;
		
		System.out.printf("a=0x%X%n", a);
		System.out.printf("(int)b=%d%n", (int)b);
		System.out.printf("b=%c%n", b);					
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 char türünden short türüne yapılan explicit dönüşümde sayının bit kalıbı değişmez.
	 Bitlerin yorumlanışı değişir. 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		char a = '\uFFAC';
		short b;
		
		b = (short)a;		
		
		System.out.printf("(int)a=%d%n", (int)a);
		System.out.printf("b=%d%n", b);					
	}
}
```
### byte türünden char türüne yapılan explicit dönüşüm iki aşamada geçekleşir. Birinci aşamada değer int türüne dönüştürülür. İkinci aşamada yüksek anlamlı byte değerleri atılarak char türüne dönüştürülür 
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 21.06.2020
	 byte türünden char türüne yapılan explicit dönüşüm iki aşamada geçekleşir. Birinci aşamada değer int türüne
	 dönüştürülür. İkinci aşamada yüksek anlamlı byte değerleri atılarak char türüne dönüştürülür 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		byte a;
		char b;
		
		a = 99;
		b = (char)a;
		
		System.out.printf("int:a=0x%X%n", (int)a);
		System.out.printf("b=%c%n", b);
		System.out.printf("int:b=%X%n", (int)b);
	}
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 byte türünden char türüne yapılan explicit dönüşüm iki aşamada geçekleşir. Birinci aşamada değer int türüne
	 dönüştürülür. İkinci aşamada yüksek anlamlı byte değerleri atılarak char türüne dönüştürülür 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		byte a;
		char b;
		
		a = -99;
		b = (char)a;
		
		System.out.printf("int:a=0x%X%n", (int)a);
		System.out.printf("b=%c%n", b);
		System.out.printf("int:b=%X%n", (int)b);
	}
}
```
###  double türünden  float türüne yapılan explicit dönüüşmde bilgi kaybı olabilir. Bu durumda IEEE754 standardına göre yuvarlama kuralları kullanılarak float türünde gösterilebilecek en yakın değer elde edilir
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 double türünden  float türüne yapılan explicit dönüüşmde bilgi kaybı olabilir. Bu durumda IEEE754 standardına
	 göre yuvarlama kuralları kullanılarak float türünde gösterilebilecek en yakın değer elde edilir 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		double a;
		float b;
		
		a = 3.567;		
		b = (float)a;
		
		System.out.printf("a=%.30f%n", a);
		System.out.printf("b=%.30f%n", b);
	}
}
```
### Tür dönüştürme operatörü ile de boolean türünden hiç bir türe ve hiç bir türden boolean türüne dönüşüm yapılamaz
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Tür dönüştürme operatörü ile de boolean türünden hiç bir türe ve hiç bir türden boolean türüne dönüşüm 
	 yapılamaz	  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		boolean a = true;
		int b = (int)a; //error
		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Tür dönüştürme operatörü ile de boolean türünden hiç bir türe ve hiç bir türden boolean türüne dönüşüm 
	 yapılamaz	  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		int a = 1;
		boolean b = (boolean)a; //error
		
	}
}
```
## Gerçek sayı türünden tamsayı türüne explicit dönüşüm şu aşamalarla gerçekleşir:
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Gerçek sayı türünden tamsayı türüne explicit dönüşüm şu aşamalarla gerçekleşir:
	 - Sayının noktadan sonraki kısmı atılır
	 	- Elde edilen değer hedef türün sınırları içerisinde ise doğrudan hedef türe atanır
	 	- Elde edilen değer hedef türün sınırları içerisinde değilse:
	 		- Hedef tür byte, short, int ve char türlerinden biriyse elde edilen değer int türüne dönüştürülür
	 			- Elde edilen değer int türü sınırları içerisindeyse int türüne dönüşüm kuralları uygulanır. Elde edilen
	 			tamsayılar arasındaki tür dönüştürme kurallarına göre hedef türe dönüştürülür	 		
	 			- Elde edilen değer int türü sınırları içerisinde değilse değerin pozitif ya da negatif olmasına göre 
	 			int türünün en büyük veya en küçük değeri alınır ve hedef türe dönüştürülür	 			
	 		- Hedef tür long türü ise elde edilen değer long türüne dönüştürülür	 			
	 			- Elde edilen değer long türü sınırları içerisinde değilse değerin pozitif ya da negatif durumuna göre
	 			long türünün en büyük veya en küçük değeri alınır ve atanır 
----------------------------------------------------------------------------------------------------------------------*/

package csd;

class App {	
	public static void main(String [] args) 
	{	
		double a;
		int b;
		
		a = 123.4567;
		
		b = (int)a;
		
		System.out.println(b);		
		
	}
}

package csd;

class App {	
	public static void main(String [] args) 
	{	
		double a;
		byte b;
		
		a = 1230.4567;
		
		b = (byte)a;
		
		System.out.printf("1230=0x%X%n", 1230);
		System.out.printf("b=%d%n", b);		
		System.out.printf("b=0x%X%n", b);		
	}
}


package csd;

class App {	
	public static void main(String [] args) 
	{	
		double a;
		byte b;
		
		a = 5_000_000_000.4567;
		
		b = (byte)a;
		
		System.out.printf("%d%n", (byte)5_000_000_000L);
		System.out.printf("%d%n", (byte)2147483647);
		System.out.printf("b=%d%n", b);				
	}
}

package csd;

class App {	
	public static void main(String [] args) 
	{	
		double a;
		int b;
		
		a = 5_000_000_000.4567;
		
		b = (int)a;
		
		System.out.printf("%d%n", (int)5_000_000_000L);		
		System.out.printf("b=%d%n", b);				
	}
}

package csd;

class App {	
	public static void main(String [] args) 
	{	
		double a;
		int b;
		
		a = -5_000_000_000.4567;
		
		b = (int)a;
		
		System.out.printf("%d%n", (int)-5_000_000_000L);		
		System.out.printf("b=%d%n", b);				
	}
}
```
### Bazen tür dönüştürme operatörü kullanılmazsa bilgi kaybı oluşabilir
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	Bazen tür dönüştürme operatörü kullanılmazsa bilgi kaybı oluşabilir  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.println("Sayıları girmeye başlayınız:");
		
		int sum = 0;
		int count = 0;
		
		for (;;) {
			int val = Integer.parseInt(kb.nextLine());
			
			if (val == 0)
				break;
			
			sum += val;
			++count;			
		}		
		
		double average = (double)sum / count;
		
		System.out.printf("Ortalama:%f%n", average);		
		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	Bazen tür dönüştürme operatörü kullanılmazsa bilgi kaybı oluşabilir  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.println("Birinci sayıyı giriniz:");
		int a = Integer.parseInt(kb.nextLine());
		
		System.out.println("İkinci sayıyı giriniz:");
		int b = Integer.parseInt(kb.nextLine());
		
		long c = (long)a + b;
		
		System.out.printf("c=%d%n", c);		
	}
}
```
### Aşağıdaki örnekte double türden sabit kullanıldığından doğru işlem yapılmıştır.
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	Aşağıdaki örnekte double türden sabit kullanıldığından doğru işlem yapılmıştır.  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		int sum = 0;
		for (int i = 0; i < 5; ++i) {
			System.out.printf("%d. sayıyı giriniz:", i + 1);
			int val = Integer.parseInt(kb.nextLine());
			
			sum += val;					
		}
		
		double average = sum / 5.;
		
		System.out.printf("Ortalama:%f%n", average);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	Aşağıdaki örnekte double türden sabit kullanıldığından doğru işlem yapılmıştır  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		int sum = 0;
		for (int i = 0; i < 5; ++i) {
			System.out.printf("%d. sayıyı giriniz:", i + 1);
			int val = Integer.parseInt(kb.nextLine());
			
			sum += val;					
		}
		
		double average = sum / 5D;
		
		System.out.printf("Ortalama:%f%n", average);
	}
}
```
### İşlemli atama operatörlerinin çalışma biçimi:
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 İşlemli atama operatörlerinin çalışma biçimi:
	 T1 a;
	 T2 b;
	 
	 a op= b -> a = (T1)(a op b)
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		int a = 10;
		int n = 2;
		
		a += Math.pow(10, n); //a = (int)(a + Math.pow(10, n));
		//...
	}
}
```
### Bir sayının log10 kullanarak basamak sayısının bulunması
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Bir sayının log10 kullanarak basamak sayısının bulunması
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());
		
		int count = 1;
		
		if (val != 0)
			count = (int)Math.log10(Math.abs(val)) + 1;
		
		System.out.printf("%d sayısının basamak sayısı:%d", val, count);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Bir sayının log10 kullanarak basamak sayısının bulunması
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());	
		
		System.out.printf("%d sayısının basamak sayısı:%d", val, NumberUtil.getDigitsCount(val));
	}
}

class NumberUtil {
	public static int getDigitsCount(long val)
	{
		if (val == 0)
			return 1;
		
		return (int)Math.log10(Math.abs(val)) + 1;
	}
}
```
### Homework-005-1. sorunun bir çözümü
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Homework-005-1. sorunun bir çözümü
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		System.out.println(NumberUtil.getE());
	}
}

class NumberUtil {
	public static double getE()
	{
		double e = 2;
		
		for (int i = 2; i <= 20; ++i)
			e += 1. / factorial(i);
		
		return e;
	}
	
	public static long factorial(int n)
	{
		if (n < 0)
			return -1;
		
		long result = 1;
		
		for (int i = 2; i <= n; ++i)
			result *= i;
		
		return result;
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Homework-005-1. sorunun bir çözümü
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		System.out.println(NumberUtil.getE());
	}
}

class NumberUtil {
	public static double getE()
	{
		double e = 2;
		
		for (int i = 2; i <= 20; ++i)
			e += 1D / factorial(i);
		
		return e;
	}
	
	public static long factorial(int n)
	{
		if (n < 0)
			return -1;
		
		long result = 1;
		
		for (int i = 2; i <= n; ++i)
			result *= i;
		
		return result;
	}
}
```

```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Homework-005-1. sorunun bir çözümü
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		System.out.println(NumberUtil.getE());
	}
}

class NumberUtil {
	public static double getE()
	{
		double e = 2;
		
		for (int i = 2; i <= 20; ++i)
			e += 1 / (double) factorial(i);
		
		return e;
	}
	
	public static long factorial(int n)
	{
		if (n < 0)
			return -1;
		
		long result = 1;
		
		for (int i = 2; i <= n; ++i)
			result *= i;
		
		return result;
	}
}
```
### Koşul operatörünün genel biçimi
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Koşul operatörünün genel biçimi:
	 
	 <operand1> ? <operand2> : <operand3>
	 
	 operand1: boolean türden ifade
	 Aşağıdaki koşul operatörünün if deyimi karşılığı:
	 if (a > b)
	 	max = a;
	 else
	 	max = b;	 	
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
		
		int max = a > b ? a : b;
		
		System.out.printf("max(%d, %d)=%d%n", a, b, max);			
	}
}
```
### Aşağıdaki örnekte b + 200 ifadesi koşul operatörünün 3. operandıdır
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Aşağıdaki örnekte b + 200 ifadesi koşul operatörünün 3. operandıdır
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
		
		int result = a > b ? a : b + 200;
		
		System.out.println(result);
			
	}
}
```
### Aşağıdaki örnekte 200 sayısı koşul operatörünün ürettiği değer eklenmiştir
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Aşağıdaki örnekte 200 sayısı koşul operatörünün ürettiği değer eklenmiştir
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
		
		int result = (a > b ? a : b) + 200;
		
		System.out.println(result);
			
	}
}
```
### Koşul operatörünün ürettiği değer bir işleme sokulabilir
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Koşul operatörünün ürettiği değer bir işleme sokulabilir
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
		
		int n = 10;
		
		int result = n - (a > b ? a : b) + 200;
		
		System.out.println(result);
			
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Koşul operatörünün ürettiği değer bir değişkene atanabilir
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
		
		int min = a < b ? a : b;
		
		System.out.printf("min(%d, %d)=%d%n", a, b, min);
			
	}
}
```
### Koşul operatörü return deyimine ilişkin ifadede kullanılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Koşul operatörü return deyimine ilişkin ifadede kullanılabilir
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
		
		System.out.printf("min(%d, %d)=%d%n", a, b, NumberUtil.min(a, b));			
	}
}

class NumberUtil {
	public static int min(int a, int b)
	{
		return a < b ? a : b;
	}
}
```
### Koşul operatörü bir metoda argüman olarak verilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Koşul operatörü bir metoda argüman olarak verilebilir
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
		
		System.out.printf("min(%d, %d)=%d%n", a, b, a < b ? a : b);			
	}
}
```
### Bir sayının log10 kullanarak basamak sayısının bulunması
```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Bir sayının log10 kullanarak basamak sayısının bulunması
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());	
		
		System.out.printf("%d sayısının basamak sayısı:%d", val, NumberUtil.getDigitsCount(val));
	}
}

class NumberUtil {
	public static int getDigitsCount(long val)
	{	
		return val == 0 ? 1 : (int)Math.log10(Math.abs(val)) + 1;
	}
}
```
### Sınıf Çalışması: getDayOfWeek metodunu yazınız.
```java
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
package csd;

class App {	
	public static void main(String [] args) 
	{							
		GetDayOfWeekTest.run();
	}
}

class GetDayOfWeekTest {
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

class DateUtil {
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
### Koşul operatörünün opandlarında ilişkin ifade void bir ifade olamaz
```java
/*----------------------------------------------------------------------------------------------------------------------	
	Koşul operatörünün opandlarında ilişkin ifade void bir ifade olamaz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());
		
		val % 2 == 0 ? foo() : bar(); //error
	}
}


class Sample {
	public static void foo()
	{
		System.out.println("foo");
	}
	
	public static void bar()
	{
		System.out.println("bar");
	}
}
```
### Koşul operatörünün bir kullanımı
```java
/*----------------------------------------------------------------------------------------------------------------------	
	Koşul operatörünün bir kullanımı
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());
		
		System.out.println(val % 2 == 0 ? "Çift" : "Tek");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	Koşul operatörünün bir kullanımı
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
		System.out.print("Üçüncü sayıyı giriniz:");
		int c = Integer.parseInt(kb.nextLine());
		
		int max = a > b ? a > c ? a : c : b > c ? b : c;
		
		System.out.printf("max(%d, %d, %d) = %d%n", a, b, c, max);
	}
}
```
### Aşağıdaki örnekte koşul operatörünün daha okunabilir olması için gerekmese de parantez konmalıdır
```java
/*----------------------------------------------------------------------------------------------------------------------	
	Aşağıdaki örnekte koşul operatörünün daha okunabilir olması için gerekmese de parantez konmalıdır 
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
		System.out.print("Üçüncü sayıyı giriniz:");
		int c = Integer.parseInt(kb.nextLine());
		
		int max = (a > b) ? (a > c ? a : c) : (b > c ? b : c);
		
		System.out.printf("max(%d, %d, %d) = %d%n", a, b, c, max);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	Aşağıdaki örnekte koşul operatörünün daha okunabilir olması için gerekmese de parantez konmalıdır 
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
		System.out.print("Üçüncü sayıyı giriniz:");
		int c = Integer.parseInt(kb.nextLine());		
		
		System.out.printf("max(%d, %d, %d) = %d%n", a, b, c, NumberUtil.max(a, b, c));
	}
}

class NumberUtil {
	public static int max(int a, int b, int c)
	{
		return (a > b) ? (a > c ? a : c) : (b > c ? b : c);
	}
}
```
### Aşağıdaki foo metotları ayrı sınıflarda olduklarından herhangi bir problem oluşmaz. Bu işlem method overloading değildir.
```java
/*----------------------------------------------------------------------------------------------------------------------	
	Aşağıdaki foo metotları ayrı sınıflarda olduklarından herhangi bir problem oluşmaz. Bu işlem method overloading
	değildir	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Sample.foo();
		Mample.foo();
	}
}

class Mample {
	public static void foo()
	{
		System.out.println("Mample.foo");
	}
}

class Sample {
	public static void foo()
	{
		System.out.println("Sample.foo");
	}
}


/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/
```
