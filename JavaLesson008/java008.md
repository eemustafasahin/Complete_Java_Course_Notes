```java
/*----------------------------------------------------------------------------------------------------------------------	
	27.06.2020
	Method overloading: Bir sınıfın içerisinde bulunan aynı isimli metotlar overload edilmiş olur 	 
----------------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------------	
	 Bir metodun erişim belirleyicisinin değiştirilmesinin overload işlemine etkisi yoktur 	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		
	}
}

class Sample {
	public static void foo(int val) //error
	{
		
	}
	
	private static void foo(int val) //error
	{
		
	}

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	 Bir metodun static olup olmamasının overload işlemine etkisi yoktur 	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		
	}
}

class Sample {
	public static void foo(int val) //error
	{
		
	}
	
	public void foo(int val) //error
	{
		
	}

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	 Bir metodun geri dönüş tür bilgisinin overload işlemine etkisi yoktur 	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		
	}
}

class Sample {
	public static int foo(int val) //error
	{
		
		return 0;		
	}
	
	public static void foo(int val) //error
	{
		
	}

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	 Bir metodun parametre değişkenlerinin isimlerinin overload işlemine etkisi yoktur
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		
	}
}

class Sample {
	public static int foo(int a) //error
	{
		
		return 0;		
	}
	
	public static void foo(int val) //error
	{
		
	}

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	 Bir metodun overload edilebilmesi için metodun parametrik tür bilgisinin ve dizilimlerinin (hepsine birden 
	 parametrik yapı denebilir) farklı olması gerekir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		
	}
}

class Sample {
	public static void foo(int a)
	{		
	}
	
	public static void foo(double a)
	{
		
	}
	
	public static void foo(double a, int b)
	{
		
	}
	
	public static void foo(int b, double a)
	{
		
	}

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	 Bir metodun imzası ismi ve parametrik yapı diziliminin tamamıdır.
	 Kural: Bir sınıf içerisinde aynı imzaya sahip birden fazla metot bildirimi geçersizdir
----------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------	
	 Bir metot çağrısında derleyicinin hangi metodu çağıracağına karar vermesi sürecine İngilizce olarak
	 "method overload resolution" veya yalnızca "overload resolution" denir.
	 
	 Metot çağrısında argümanlar ile parametrelerinin türlerinin birebir uyumlu olduğu bir metot varsa 
	 o metot çağrılır (best match, exact match)
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		int a = 10;
		long b = 34;
		
		Sample.foo(a, b); //#5 çağrılır (tam uyum)
	}
}

class Sample {
	public static void foo() //#1
	{		
		System.out.println("foo");
	}
	
	public static void foo(int a) //#2
	{		
		System.out.println("foo, int");		
	}
	
	public static void foo(int a, int b) //#3
	{
		System.out.println("foo, int, int");
	}
	
	public static void foo(double a, int b) //#4
	{
		System.out.println("foo, double, int");
	}
	
	public static void foo(int a, long b) //#5
	{
		System.out.println("foo, int, long");
	}
	
	public static void bar(int a) //#6
	{
		System.out.println("bar, int");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	 Tam uyum yoksa overload resolution aşağıdaki gibi gerçekleşir:
	 1. Aday Metotlar (candidate methods): Çağrılan metot ile aynı isimdeki tüm metotlardır
	 2. Uygun metotlar (applicable methods): Argüman sayısı parametre sayısı ile aynı olan ve argümanlardan
	 parametrelere otomatik tür dönüşümünün olduğu metotlardır
	 3. En uygun metot (the most applicable method): Uygun uygun metotlar arasında en kaliteli dönüşümü 
	 sunan metot belirlenir.
	 
	 En uygun metot öyle bir metottur ki argümanlardan parametrelere dönüşüm yarışa sokulduğunda daha iyi dönüşümü
	 veya daha kötü olmayan dönüşümü yapar.
	 
	 Dönüşüm kalitesi aşağıdaki gibi belirlenir:
	 1. T1 -> T2 ve T1 -> T3 otomatik dönüştürmelerinde T2 veya T3'den birisi T1 ile aynı ise aynı olan dönüşüm kalitelidir
	 int -> double
	 int -> int *
	 
	 2. T1 -> T2 ve T1 -> T3 otomatik dönüştürmelerinde T2 den T3 otomatik dönüşüm var T3 den T2 ye yoksa
	 T1->T2 daha kalitelidir.
	 
	 int -> long *
	 int -> float 
	 
	 ya da örneğin
	 
	 short -> int *
	 short -> double	 
	 
	 Bu aşamalardan herhangi bir tanesi gerçekleşemezse error oluşur.
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	 1. Aday metotlar: 1, 2, 3, 4, 5
	 2. Uygun metotlar: 3, 4, 5
	 3. En uygun metot: 3
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		int a = 10;
		short b = 34;
		
		Sample.foo(a, b); //#3 çağrılır
	}
}

class Sample {
	public static void foo() //#1
	{		
		System.out.println("foo");
	}
	
	public static void foo(int a) //#2
	{		
		System.out.println("foo, int");		
	}
	
	public static void foo(int a, int b) //#3
	{
		System.out.println("foo, int, int");
	}
	
	public static void foo(double a, int b) //#4
	{
		System.out.println("foo, double, int");
	}
	
	public static void foo(int a, long b) //#5
	{
		System.out.println("foo, int, long");
	}
	
	public static void bar(int a) //#6
	{
		System.out.println("bar, int");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	 1. Aday metotlar: 1, 2, 3, 4, 5
	 2. Uygun metotlar: 4
	 3. En uygun metot: 4
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		float a = 10;
		short b = 34;
		
		Sample.foo(a, b); //#4 çağrılır
	}
}

class Sample {
	public static void foo() //#1
	{		
		System.out.println("foo");
	}
	
	public static void foo(int a) //#2
	{		
		System.out.println("foo, int");		
	}
	
	public static void foo(int a, int b) //#3
	{
		System.out.println("foo, int, int");
	}
	
	public static void foo(double a, int b) //#4
	{
		System.out.println("foo, double, int");
	}
	
	public static void foo(int a, long b) //#5
	{
		System.out.println("foo, int, long");
	}
	
	public static void bar(int a) //#6
	{
		System.out.println("bar, int");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	 1. Aday metotlar: 1, 2, 3, 4, 5
	 2. Uygun metotlar: 4, 5
	 3. En uygun metot: 5
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		float a = 10;
		short b = 34;
		
		Sample.foo(a, b); //#5 çağrılır
	}
}

class Sample {
	public static void foo() //#1
	{		
		System.out.println("foo");
	}
	
	public static void foo(int a) //#2
	{		
		System.out.println("foo, int");		
	}
	
	public static void foo(int a, int b) //#3
	{
		System.out.println("foo, int, int");
	}
	
	public static void foo(double a, int b) //#4
	{
		System.out.println("foo, double, int");
	}
	
	public static void foo(double a, short b) //#5
	{
		System.out.println("foo, double, short");
	}
	
	public static void bar(int a) //#6
	{
		System.out.println("bar, int");
	}
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	 1. Aday metotlar: 1, 2, 3, 4, 5
	 2. Uygun metotlar: 3, 4, 5
	 3. En uygun metot: yok
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		int a = 10;
		int b = 34;
		
		Sample.foo(a, b); //error: ambiguity: iki anlamlılık
	}
}

class Sample {
	public static void foo() //#1
	{		
		System.out.println("foo");
	}
	
	public static void foo(int a) //#2
	{		
		System.out.println("foo, int");		
	}
	
	public static void foo(int a, long b) //#3
	{
		System.out.println("foo, int, long");
	}
	
	public static void foo(long a, int b) //#4
	{
		System.out.println("foo, long, int");
	}
	
	public static void foo(double a, float b) //#5
	{
		System.out.println("foo, double, float");
	}
	
	public static void bar(int a) //#6
	{
		System.out.println("bar, int");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	 1. Aday metotlar: 1, 2, 3, 4, 5
	 2. Uygun metotlar: yok	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		int a = 10;
		boolean b = true;
		
		Sample.foo(a, b); //error: uygun metot yok
	}
}

class Sample {
	public static void foo() //#1
	{		
		System.out.println("foo");
	}
	
	public static void foo(int a) //#2
	{		
		System.out.println("foo, int");		
	}
	
	public static void foo(int a, long b) //#3
	{
		System.out.println("foo, int, long");
	}
	
	public static void foo(long a, int b) //#4
	{
		System.out.println("foo, long, int");
	}
	
	public static void foo(double a, float b) //#5
	{
		System.out.println("foo, double, float");
	}
	
	public static void bar(int a) //#6
	{
		System.out.println("bar, int");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	 1. Aday metotlar: yok	 	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		int a = 10;
		int b = true;
		
		Sample.fo(a, b); //error: aday metot yok
	}
}

class Sample {
	public static void foo() //#1
	{		
		System.out.println("foo");
	}
	
	public static void foo(int a) //#2
	{		
		System.out.println("foo, int");		
	}
	
	public static void foo(int a, long b) //#3
	{
		System.out.println("foo, int, long");
	}
	
	public static void foo(long a, int b) //#4
	{
		System.out.println("foo, long, int");
	}
	
	public static void foo(double a, float b) //#5
	{
		System.out.println("foo, double, float");
	}
	
	public static void bar(int a) //#6
	{
		System.out.println("bar, int");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	Aşağıdaki örnekte Math sınıfının abs metotlarında short argüman ile kimin çağrılacağı simüle edilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		short a = 10;
		
		MyMath.abs(a);
	}
}

class MyMath {
	public static void abs(int val)
	{
		System.out.println("abs, int");
	}
	
	public static void abs(long val)
	{
		System.out.println("abs, long");
	}
	
	public static void abs(float val)
	{
		System.out.println("abs, float");
	}
	
	public static void abs(double val)
	{
		System.out.println("abs, double");
	}
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	Bilindiği bir değişkenin faaliyet alanı derleme zamanına ilişkin bir kavramdır. Bir değişkenin bellekte
	yaratılması ile yok edilmesi arasındaki zamana değişkenin ömrü (storage duration). Bu kavram şüphesiz çalışma
	zamanına ilişkin bir kavramdır. Mantıksal bir ayrı kavramlara olmasalar da, faaliyet alanı ile ömür aynı 
	şey değildir.
----------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------	
	Yerel değişkenler ve parametre değişkenleri stack alanında yaratılır. Yerel değişkenin ömrü akış bakımından
	bildirildiği yerde yaratılır bildirildiği blok sonunda yok edilir. Parametre değişkenleri ömrü akış bakımından 
	metot çağrısında yaratılır metot bittiğinde yok edilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		{
			int a; //Akış buradayken stack'te yaratıldı
			int b;
			
			//...
		} // b ve a yok edildi
		
		//...
		
		Sample.foo(10, 20);
		//..
		Sample.foo(20, 40);
	}
}


class Sample {
	public static void foo(int a, int b)
	{
		//...
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	28.06.2020
	Sınıfın içerindeki bildirimlere sınıfın elemanları (members) denir. Sınıfın bir elemanı eğer 
	bir alt programsa buna metot eğer bir değişken ise buna veri elemanı (member variable) denir
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	Sınıf içerisinde tüm metotların dışında herhangi bir yerde bildirilen değişkenlere sınıf veri 
	elemanı denir. Sınıf veri elemanları metotlarda olduğu gibi erişim belirleyiciye sahip olabilirler, 
	sınıf veri elemanı static veya non-static olarak bildirilebilirler
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
						
	}
}

class Sample {
	public int a;
	
	public static void foo()
	{
		
	}
	
	private static double b;
	double c;
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	Bir sınıfı içerisinde aynı isimde birden fazla veri elemanı bildirimi yapılamaz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
						
	}
}

class Sample {
	public int a; //error	
	static double a; //error 
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	Birden fazla veri elemanı aynı türdense, static veya non-static durumları aynı ise ve erişim
	belirleyicileri de aynı ise bildirimde virgül ile ayrılacak şekilde yazılabilirler
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
						
	}
}

class Sample {
	public int a, b, c;
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------	
	Sınıf bildirimi bir tür bildirimidir (user defined type)
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
						
	}
}

class Sample {
	 //...
}

class SerialPort {
	 //...
}

class Person {
	//...
}

class Car {
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	Sınıf bildirimi bir tür bildirimi olduğuna göre sınıf türünden de değişkenler bildirilebilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Sample s;
		Mample m;
	}
}

class Sample {
	//...
}

class Mample {
	//...
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------	
	Java' da türler kategori olarak iki gruba ayrılır: değer türleri (value types), referans türleri (reference types)
	T bir tür ismi olmak üzere T türden bir değişken içerisinde değerin kendisi tutuluyorsa T kategori olarak
	değer türlerine ilişkindir. Eğer T türünden değişkenin içerisinde bir adres bilgisi tutuluyorsa
	T bir referans türüne ilişkindir. 
	Tüm temel türler değer türleridir. Temel türler dışında kalan tüm türler (user defined type) referans
	türleridir
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	Sınıf türünden bir değişkene referans değişken ya da referans denir. 
	Anahtar Not: Java' da referans terimi adres yerine de kullanılabilir. Örneğin bir nesnenin adresi yerine
	bir nesnenin referansı da doğru bir cümledir. Ancak buradaki referans terimi değişken değil adresi temsil
	eder. Referans değişken (ya da kısaca referans) içerisinde adres (referans) tutabilen bir değişkendir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Sample s; //referans
		Mample m; //referans
	}
}

class Sample {
	//...
}

class Mample {
	//...
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------	
	Sınıf türünden bellekte ayrılan bölgelere nesne denir. Nesneler heap de yaratılır. Java' da stack'de nesne 
	yaratılamaz. Bir nesneyi yaratmak için new operatörü kullanılır. new operatörü operatör öncelik
	tablosunun birinci seviyesinde ve tek operandlı bir operatördür. Operatörün kullanımının genel biçimi:
	
		new <referans tür ismi>([argümanlar]);
		
	new operatörünün ürettiği değer heap de yaratılan nesnenin adresidir (referansıdır). Bu durumda new operatörünün
	değer uygun bir referansa atanabilir. Uygun referans new operatörü kullanılırken yazılan referans türden bir 
	değişkendir. Nesneler ilgili sınıf türünün bir örneği kabul edilir ve instance terimi kullanılır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Sample s; //referans
		
		s = new Sample();
	}
}

class Sample {
	//...
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	Sınıfın non-static veri elemanları her nesne için ayrıca yaratılır. Sınıfın non-static veri elamanlarına 
	sınıf dışından referans ve nokta operatörü ile erişilebilir. Her new işlemi yeni bir nesne yaratmak demektir.
	Aşağıdaki örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		Sample s, k;
		
		s = new Sample();
		
		s.x = 10;
		s.y = false;
		
		k = new Sample();
		
		k.x = 20;
		k.y = true;
		
		System.out.printf("s.x=%d%n", s.x);
		System.out.printf("s.y=%b%n", s.y);
		System.out.printf("k.x=%d%n", k.x);
		System.out.printf("k.y=%b%n", k.y);		
	}
}

class Sample {
	public int x;
	public boolean y;
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	Non-static veri elemanlarına nesnenin yaratılması aşamasında default değerler atanır. Default değerler
	mantıksal sıfır değerleridir. Örneğin int türü için sıfırken, boolean türü için false değeridir 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		Sample s, k;
		
		s = new Sample();		
		
		System.out.printf("s.x=%d%n", s.x);
		System.out.printf("s.y=%b%n", s.y);		
	}
}

class Sample {
	public int x;
	public boolean y;
	//...
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------	
	Aşağıdaki örnekte s değişkenine değer atanmadığı için error oluşur 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		Sample s;		
		
		
		System.out.printf("s.x=%d%n", s.x);
		System.out.printf("s.y=%b%n", s.y);		
	}
}

class Sample {
	public int x;
	public boolean y;
	//...
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------	
	 Bir nesnenin belekte kapladığın alan "en az non-static veri elemanının toplam uzunluğu kadardır"
	 Bu durumda aynı türden nesneler için aynı uzunlukta yer ayrılır. Farklı türden nesnelerin farklı veri 
	 elemanları olabileceğinden aynı uzunlukta yer ayrılması gerekmez. 
	 
	 Türü ne olursa olsun tüm referansların uzunlukları aynıdır. Bu da adreslenebilecek sayıları tutabilecek 
	 kadar uzunluktadır. Yani örneğin 64 bit bir işlemci de tüm referanslar 64 bit uzunluktadır.
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	 Aşağıdaki örnekte her s referansı nesneden kopartılıp yeni bir nesnenin adresi referansı atanmıştır 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		Sample s;		
		
		s = new Sample();
		
		s.x = 10;
		s.y = true;		
		
		s = new Sample();
		
		System.out.printf("s.x=%d%n", s.x);
		System.out.printf("s.y=%b%n", s.y);		
	}
}

class Sample {
	public int x;
	public boolean y;
	//...
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	 İki aynı türden referansın birbirine atanması iki referansın da aynı nesneyi göstermeleri demektir. Bu durumda
	 hangi referans ile nesneye erişildiğinin bir önemi yoktur.  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		Sample s, k;		
		
		s = new Sample();
		
		s.x = 10;
		s.y = true;		
		
		k = s;
		
		System.out.printf("s.x=%d%n", s.x);
		System.out.printf("s.y=%b%n", s.y);
				
		
		System.out.printf("k.x=%d%n", k.x);
		System.out.printf("k.y=%b%n", k.y);
		
		++k.x;
		
		k.y = false;
		
		System.out.println("////////////////////////");
		System.out.printf("s.x=%d%n", s.x);
		System.out.printf("s.y=%b%n", s.y);				
		
		System.out.printf("k.x=%d%n", k.x);
		System.out.printf("k.y=%b%n", k.y);
	}
}

class Sample {
	public int x;
	public boolean y;
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	 İki aynı türden referansın birbirine atanması iki referansın da aynı nesneyi göstermeleri demektir. Bu durumda
	 hangi referans ile nesneye erişildiğinin bir önemi yoktur.  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		Sample s, k;		
		
		s = new Sample();
		
		s.x = 10;
		s.y = true;		
		
		k = s;
		
		System.out.printf("s.x=%d%n", s.x);
		System.out.printf("s.y=%b%n", s.y);
				
		
		System.out.printf("k.x=%d%n", k.x);
		System.out.printf("k.y=%b%n", k.y);
		
		++k.x;
		
		k.y = false;
		
		System.out.println("////////////////////////");
		System.out.printf("s.x=%d%n", s.x);
		System.out.printf("s.y=%b%n", s.y);				
		
		System.out.printf("k.x=%d%n", k.x);
		System.out.printf("k.y=%b%n", k.y);
		
		k = new Sample();
		
		System.out.println("////////////////////////");
		System.out.printf("s.x=%d%n", s.x);
		System.out.printf("s.y=%b%n", s.y);				
		
		System.out.printf("k.x=%d%n", k.x);
		System.out.printf("k.y=%b%n", k.y);

	}
	
}

class Sample {
	public int x;
	public boolean y;
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	 Referans parametreli metotlar olabilir. Bu durumda metot içerisinde referans parametresine geçilen adrese
	 ilişkin nesneye erişilebilir  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		Date birthDate = new Date();
		
		birthDate.day = 10;
		birthDate.month = 9;
		birthDate.year = 1976;
		
		DateUtil.display(birthDate);		
	}
}

class DateUtil {
	public static void display(Date date)
	{
		System.out.printf("%02d/%02d/%04d%n", date.day, date.month, date.year);		
	}
}

class Date {
	public int day, month, year;
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	 Aşağıdaki örnekte argüman olan değişmez
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		int a = 10;
		Sample.foo(a);
		
		System.out.printf("a=%d%n", a);				
	}
}

class Sample {
	public static void foo(int a)
	{
		++a;		
	}
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------	
	 Referans parametreli metotlar aldıkları referansa ilişkin nesne üzerinde değişiklik yapabilirler  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		Date birthDate = new Date();
		
		birthDate.day = 10;
		birthDate.month = 9;
		birthDate.year = 1976;
		
		
		DateUtil.display(birthDate);
		DateUtil.changeDate(birthDate, 11, 7, 1983);
		DateUtil.display(birthDate);
	}
}

class DateUtil {
	public static void changeDate(Date date, int day, int month, int year)
	{
		//...
		date.day = day;
		date.month = month;
		date.year = year;		
	}
	
	public static void display(Date date)
	{
		System.out.printf("%02d/%02d/%04d%n", date.day, date.month, date.year);		
	}
}

class Date {
	public int day, month, year;
	//...
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	 Referans geri dönen metotlar ile bir nesnenin referansı metodun geri dönüş değerinden elde edilebilir  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		Date birthDate = DateUtil.createDate(10,9, 1976);		
		
		DateUtil.display(birthDate);
		DateUtil.changeDate(birthDate, 11, 7, 1983);
		DateUtil.display(birthDate);
	}
}

class DateUtil {
	public static Date createDate(int day, int month, int year)
	{
		//...		
		Date date = new Date();
		
		date.day = day;
		date.month = month;
		date.year = year;
		
		return date;
	}
	
	public static void changeDate(Date date, int day, int month, int year)
	{
		//...
		date.day = day;
		date.month = month;
		date.year = year;		
	}
	
	public static void display(Date date)
	{
		System.out.printf("%02d/%02d/%04d%n", date.day, date.month, date.year);		
	}
}

class Date {
	public int day, month, year;
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	 Sınıfın static bir veri elemanı bir tanedir. Bu elemanın kullanılabilmesi için nesne yaratılmış olması gerekmez.
	 Sınıfın static veri elemanına sınıf dışından sınıf ismi ve nokta operatörü ile erişilebilir  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		Sample.a = 10;
		Sample.b = true;
		
		System.out.printf("Sample.a=%d%n", Sample.a);
		System.out.printf("Sample.b=%b%n", Sample.b);		
	}
}

class Sample {
	public static int a;
	public static boolean b;
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	 Sınıfın static bir veri elemanı bir tanedir. Bu elemanın kullanılabilmesi için nesne yaratılmış olması gerekmez.
	 Sınıfın static veri elemanına sınıf dışından sınıf ismi ve nokta operatörü ile erişilebilir.  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		Sample.a = 10;
		Sample.b = true;
		
		System.out.printf("Sample.a=%d%n", Sample.a);
		System.out.printf("Sample.b=%b%n", Sample.b);		
	}
}

class Sample {
	public static int a;
	public static boolean b;
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Sınıfın static veri elemanlarının hepsi sınıfın bir elemanı ilk kez kez kullanıldığında yaratılır ve programın 
	 sonuna kadar yaşarlar
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		Sample.foo();	
	}
}

class Sample {
	public static int a;
	public static boolean b;
	
	public static void foo()
	{
		
	}
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Sınıfın static veri elemanlarına da default değerler atanır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		System.out.printf("Sample.a=%d%n", Sample.a);
		System.out.printf("Sample.b=%b%n", Sample.b);			
	}
}

class Sample {
	public static int a;
	public static boolean b;
	
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	 static veri elemanlarının bir kullanımı
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{				
		for (int i = 0; i < 10; ++i) {
			Alien alien = new Alien();
			//...			
		}
		
		for (int i = 0; i < 20; ++i) {
			Soldier soldier = new Soldier();
			
			//...			
		}
		
		System.out.printf("Number of Aliens:%d%n", Alien.count);
		System.out.printf("Number of Soldiers:%d%n", Soldier.count);
	}
}

class Alien {
	public static int count;
	public int color;
	public int numberOfArms;
	public int numberOfGuns;
	//...
	
	public Alien()
	{
		++count;
	}
}

class Soldier {
	public static int count;
	public int title;
	public int gunType;
	//...
	
	public Soldier()
	{
		++count;
	}
}


/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/
```


