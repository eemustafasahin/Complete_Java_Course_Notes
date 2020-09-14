### Farklı enum'lar için equals metodu false değerini döndürür
```java
/*----------------------------------------------------------------------------------------------------------------------
	12.09.2020
	enum türünün equals metodu ile farklı türden enum class'lar kullanılabilir. Bu durum equals metodunun parametresinin
	türünün Object olmasından kaynaklanır. Bu işlemin nasıl yapılabildiği ve Object sınıfı ileride ele alınacaktır.
	Farklı enum'lar için equals metodu false değerini döndürür
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Color color = Color.BLUE;
		MartialStatus martialStatus = MartialStatus.DIVORCED;

		System.out.println(color.equals(martialStatus));
	}
}

enum Color {RED, GREEN, BLUE}
enum MartialStatus {MARRIED, SINGLE, DIVORCED}
```
### Aynı durum compareTo metodu için geçerli değildir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aynı durum compareTo metodu için geçerli değildir. Çünkü compareTo metodunun  parametresi aynı enum türündendir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Color color = Color.BLUE;
		MartialStatus martialStatus = MartialStatus.DIVORCED;

		System.out.println(color.compareTo(martialStatus)); //error
	}
}

enum Color {RED, GREEN, BLUE}
enum MartialStatus {MARRIED, SINGLE, DIVORCED}
```
### enum türleri switch deyimi ile de kullanılabilmektedir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	enum türleri switch deyimi ile de kullanılabilmektedir. Bu durumda case bölümlerine ilişkin sabitler şüphesiz
	ilgili enum türünden sabitler olmalıdır. Karşılaştırma işlemi == operatörü ile yapılır. case bölümlerine yazılan
	sabitlerde enum class ismi kullanımı geçersizdir. Sabit isimleri case bölümlerinde enum class'lar için doğrudan
	kullanılmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Input marital status:");
		String maritalStatusStr = kb.nextLine();
		MaritalStatus maritalStatus = MaritalStatus.valueOf(maritalStatusStr.toUpperCase());

		switch (maritalStatus) {
			case MARRIED:
				System.out.println("Evli");
				break;
			case SINGLE:
				System.out.println("Bekar");
				break;
			case DIVORCED:
				System.out.println("Boşanmış");
				break;
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}

enum MaritalStatus {MARRIED, SINGLE, DIVORCED}
```
### Aşağıdaki örnekte split metodu daha kolay kullanılır hale getirilmiştir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte split metodu daha kolay kullanılır hale getirilmiştir. İlgili metot StringUtil sınıfına da
	eklenmiştir.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		String str = "bugün hava  çok güzel. Bu güzel havada [evde] mi otururulur";

		String [] words = Util.split(str, " .][", StringSplitOptions.REMOVE_EMPTY_ENTRIES);

		for (String word : words)
			System.out.println(word);
	}
}

enum StringSplitOptions {NONE, REMOVE_EMPTY_ENTRIES}

class Util {
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
}
```
### Sınıflararası ilişkiler: (İçerme (composition), Birleşme (aggregation),Çağrışım (association),Kalıtım/Türetme (inheritance))
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıflararası ilişkiler: Sınıflararası ilişkiler aslında nesneler arasındaki ilişkisi temsil eder. Örneğin araba
	ile motoru arasında bir ilişki vardır. İnsan ile o kişiye ait olan kimliği arasında bir ilişki vardır. Örneklerde
	görüldüğü gibi aslında ilişkiler nesneler arasındadır. Ancak nesnelerin bu ilişkilerini belirtebilmek için
	sınıfların buna uygun yazılması gerekir.
	Nesne yönelimli programlama tekniği yapılacak bir projenin kodlama aşamasında önce sınıflar sonra da sınıflararası
	ilişkiler belirlenir ve kodlamaya geçilir. Sınıflar ve aralarındaki ilişkiler şüphesiz sınıfların/nesnelerin gerçek
	durumları düşünülerek belirlenir.

	Anahtar Notlar: Bir projenin müşteri ile görüşülmesinden müşteriye teslimine (deployment) geçe süreci çeşitli
	şemalarla anlatan UML (Unified Mpdeling Language) denilen bir araç bazı durumlarda kullanılmaktadır. Bu aracın
	en önemli şeması "sınıf şemaları (class diagrams)" dır. Bu şema tamamen kodlamaya yöneliktir. Sınıf şemalarının
	anlattığı özelliklerden biri de iki sınıf arasındaki ilişkidir.

	Anahtar Notlar: Bir kavram(lar) modellenirken o kavramın genel durumu düşünülür. İstisna niteliğinde olacak durumlar
	modelleme yapılırken göz önünde bulundurulmaz. Aksi taktirde hiç bir şey modellenemez. Örneğin arabayla motor arasındaki
	ilişki için şu kurallar söylenebilir:
		1. Araba nesnesine ait olan motor nesnesi başka bir araba tarafından kullanılamaz
		2. Araba nesnesine ait olan motor nesnesi ömrüne hemen hemen arabayla başlayacak ve araba ile ömrü son bulacak
	Burada örnmeğin ikinci koşul bazı durumlarda delinebilir. Ama bu ilişkinin genel durumunu değiştirmez.

	Bir sınıfın derlenebilmesi için başka bir sınıfın var olması gerektiği durumlara "bağımlılık (dependency)" denir

	İki sınıf arasında ya hiç bir ilişki yoktur ya da aşağıdakilerden birisi vardır:
	1. İçerme (composition) (has a): A ve B arasındaki "A has a B" ilişkisi için aşağıdaki koşulların ikisinin de
	sağlanması gerekir
		- A nesnesine ait B nesnesi ömrüne hemen hemen A nesnesi ile başlayacak ve hemen hemen A nesnesi ile ömrü sonlanacak
		- A nesnesine ait olan B nesnesi başka bir nesne tarafından kullanılamayacak
	Bu ilişkide A nesnesi B nesnesini istediği durumda (hemen her durumda) kullanabilmektedir. Buna bütünsel (whole)
	kullanım denir.

	2. Birleşme (aggregation) (holds a): A ve B arasındaki "A holds a B" ilişkisi composition kurallarının en az bir tanesinin
	gerçeklenmediği bütünsel kullanım ilişkisidir

	3. Çağrışım (association): A nesnesinin B nesnesini ihtiyacı olduğunda kullanması kullandıktan sonra saklamaması
	ilişkisidir. Yani bütünsel kullanım yoktur. Bu kullanıma parçalı (partial) kullanım da denir

	4. Kalıtım/Türetme (inheritance) (is a): Biyoloji'den programlamaya geçmiş bir kavramdır. Biyoloji'de kalıtım
	ebeveynin (parent) özelliklerinin çocuğuna (child) aktarılmasıdır.

	Anahtar Notlar: Bazı sınıflar implementasyonları gereği yukarıdaki ilişkilerin hiç birisine uygun olmayabilir. Ama
	ortada yine bir bağımlılık (dependency) söz konusudur. Bu da yine genel durumu bozmaz.
----------------------------------------------------------------------------------------------------------------------*/
```
### A ile B arasındaki composition ilişkisinin genel biçimi
```java
/*----------------------------------------------------------------------------------------------------------------------
	A ile B arasındaki composition ilişkisinin genel biçimi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		A x = new A(/*...*/);

		x.doWork1();
		x.doWork2();
	}
}

class A {
	private B m_b;
	//...

	public A(/*...*/)
	{
		//...
		m_b = new B(/*...*/);
	}

	public void doWork1()
	{
		//...
		m_b.doSomething();
	}

	public void doWork2()
	{
		//...
		m_b.doSomething();
	}
}


class B {
	//...
	public void doSomething()
	{
		//...
	}
}
```
### Car, Plane ve Engine sınıfları arasındaki ilişkiler
```java
/*----------------------------------------------------------------------------------------------------------------------
	Car, Plane ve Engine sınıfları arasındaki ilişkiler
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Car car = new Car(/*...*/);

		car.run();

		System.out.println("************************");

		Plane plane = new Plane(3/*...*/);

		plane.fly();
	}
}

class Plane {
	private Engine [] m_engines;

	private void startEngines()
	{
		for (Engine engine : m_engines)
			engine.startEngine();
	}

	private void accelerateEngines()
	{
		for (Engine engine : m_engines)
			engine.accelerateEngine();
	}

	private void slowEngines()
	{
		for (Engine engine : m_engines)
			engine.slowEngine();
	}

	private void stopEngines()
	{
		for (Engine engine : m_engines)
			engine.stopEngine();
	}

	public Plane(int n/*...*/)
	{
		//...
		m_engines = new Engine[n];
		for (int i = 0; i < n; ++i)
			m_engines[i] = new Engine(/*...*/);
	}

	public void fly()
	{
		startEngines();
		accelerateEngines();
		System.out.println("Plane fly");
		slowEngines();
		stopEngines();
	}
}

class Car {
	private Engine m_engine;

	public Car(/*...*/)
	{
		//...
		m_engine = new Engine(/*...*/);
	}

	public void brake()
	{
		m_engine.slowEngine();
	}

	public void run()
	{
		m_engine.startEngine();
		m_engine.accelerateEngine();

		System.out.println("Car run");
		//...
		brake();
		m_engine.stopEngine();
	}
}

class Engine {
	//...
	public void startEngine()
	{
		System.out.println("start engine");
	}

	public void accelerateEngine()
	{
		System.out.println("accelerate engine");
	}

	public void slowEngine()
	{
		System.out.println("slow engine");
	}

	public void stopEngine()
	{
		System.out.println("stop engine");
	}
	//...
}
```
### A ile B arasındaki aggregation ilişkisinin genel biçimi
```java
/*----------------------------------------------------------------------------------------------------------------------
	A ile B arasındaki aggregation ilişkisinin genel biçimi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		B x = new B(/*...*/);
		A y = new A(x/*....*/);

		y.doWork1();
		y.doWork2();

		B z = new B(/*...*/);

		y.setB(z);
		y.doWork1();
		y.doWork2();
	}
}

class A {
	private B m_b;

	public A(B b/*...*/)
	{
		//...
		setB(b);
	}

	public void setB(B b)
	{
		//...
		m_b = b;
	}

	public B getB()
	{
		return m_b;
	}

	public void doWork1()
	{
		//...
		m_b.doSomething();
	}

	public void doWork2()
	{
		//...
		m_b.doSomething();
	}
}

class B {
	//...
	public void doSomething()
	{
		//...
	}
}
```
### Command ile Connection sınıfları arasındaki aggregation ilişkisi
```java
/*----------------------------------------------------------------------------------------------------------------------
	Command ile Connection sınıfları arasındaki aggregation ilişkisi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		DatabaseApp.run();
	}
}

class DatabaseApp {
	private static final Connection CONNECTION = new Connection("postgresql:jdbc://192.168.2.123:5432/devicesappdb", "postgres", "csd1993");
	private static final String SELECT_COMMAND = "select * from devices";
	private static final String INSERT_COMMAND = "insert into devices (name, host, port) values (:name, :host, :port)";

	public static void run()
	{
		Command selectCommand = new Command(CONNECTION, SELECT_COMMAND);
		Command insertCommand = new Command(CONNECTION, INSERT_COMMAND);

		selectCommand.executeQuery();
		insertCommand.executeNonQuery();
	}
}

class Command {
	private Connection m_connection;
	private String m_commandText;

	public Command(Connection connection, String commandText)
	{
		//...
		m_connection = connection;
		m_commandText = commandText;
	}

	public void executeQuery()
	{
		System.out.println("executeQuery");
		m_connection.connect();
		//...
		System.out.printf("Command:%s%n", m_commandText);
	}

	public void executeNonQuery()
	{
		System.out.println("executeNonQuery");
		m_connection.connect();
		//...
		System.out.printf("Command:%s%n", m_commandText);
	}
}

class Connection {
	private String m_url;
	private String m_username;
	private String m_password;

	public Connection(String url, String username, String password)
	{
		//...
		m_url = url;
		m_username = username;
		m_password = password;
	}

	public String getUrl()
	{
		return m_url;
	}

	public String getUsername()
	{
		return m_username;
	}

	public String getPassword()
	{
		return m_password;
	}

	//...

	public void connect()
	{
		System.out.printf("URL:%s%n", m_url);
		System.out.printf("Username:%s%n", m_username);
		System.out.printf("Password:%s%n", m_password);
	}
}
```
### A ile B arasındaki association ilişkisinin genel biçimi
```java
/*----------------------------------------------------------------------------------------------------------------------
	A ile B arasındaki association ilişkisinin genel biçimi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		B x = new B(/*...*/);
		A y = new A(/*...*/);
		B z = new B(/*...*/);

		y.doWork(x);

		//...

		y.doWork(z);
	}
}

class A {
	//...
	public void doWork(B b)
	{
		//...
		b.doSomething();
	}
}

class B {
	public void doSomething()
	{
		//...
	}
}
```
### Taxi, Driver ve Client sınıfları arasındaki ilişkiler
```java
/*----------------------------------------------------------------------------------------------------------------------
	Taxi, Driver ve Client sınıfları arasındaki ilişkiler
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Driver driver = new Driver(/*...*/);
		Taxi taxi = new Taxi(driver/*...*/);
		Client client1 = new Client(/*...*/);

		taxi.take(client1);

		//....

		Client client2 = new Client(/*...*/);

		taxi.take(client2);
	}
}

class Taxi {
	private Driver m_driver;

	public Taxi(Driver driver/*...*/)
	{
		//...
		m_driver = driver;
	}

	//...

	public void take(Client client)
	{
		//...
	}
}

class Driver {
	//...
}

class Client {
	//...
}
```
### String sınıfı immutable olduğundan aşağıadaki ilişki ne aggregation ne de composition'dır.
```java
/*----------------------------------------------------------------------------------------------------------------------
	13.09.2020
	String sınıfı immutable olduğundan aşağıadaki ilişki ne aggregation ne de composition'dır. Ancak composition ilişkisine
	daha yakındır denebilir. Ancak gerçek olarak özel bir durumdur ve herhangi isim de verilemeyebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		String name = "Oğuz";
		int no = 1;

		Person person = new Person(no, name);

		System.out.println(person.getName());
		System.out.println(name);

		name = name.toUpperCase();

		System.out.println(person.getName());
		System.out.println(name);

	}
}

class Person {
	private int m_no;
	private String m_name;

	public Person(int no, String name)
	{
		//...
		m_no = no;
		m_name = name;
	}

	public int getNo()
	{
		return m_no;
	}


	public void setNo(int no)
	{
		//...
		m_no = no;
	}

	public String getName()
	{
		return m_name;
	}

	public void setName(String name)
	{
		//...
		m_name = name;
	}
}
```
## Türetme (inheritance)
```java
/*----------------------------------------------------------------------------------------------------------------------
   Türetme (inheritance) kavramı programlamada bir sınıfı genişletmek (extension) için kullanılır. Bu genişletme
   var olan özellikler üzerine ekleme olarak düşünülebilir. Bu ilişkide B sınıfı A sınıfından türetilmişse "B is A"
   cümlesi kullanılır.

   B sınıfı A sınıfından türetilmiş olsun. B sınıfına A sınıfının türemiş sınıfı (derived class) denir. A sınıfına ise
   B sınıfının taban sınıfı (base class) denir. Bu iki terim nesne yönelimli programlama paradigmasına yönelik
   genel terimlerdir. Java'da "base class" yerine "super class", "derived class" yerine ise "sub class" terimleri
   kullanılır.

   Anahtar Notlar: Nesne yönelimli programlamada "base class" yerine Biyoloji'den gelen terim olarak "parent class" da
   denilmektedir. Benzer şekilde "derived class" yerine yine Biyoloji'den gelen "child class" da denilmektedir. Bu terimler
   az kullanılsa da bazı kaynbaklarda görülmektedir.

   Bir dizi türetme söz konusu olabilir. Örneğin C sınıfı B sınıfından, B sınıfı da A sınıfından türetilmiş olabilir.
   Bu durumda C'nin taban sınıfı (super class) dendiğinden doğrudan taban sınıfı (direct super class) olan B anlaşılır.
   C nin dolaylı bir taban sınıfı (indirect super class) A dır. Örneğimizde "C'nin taban sınıfları B ve A'dır" cümlesi
   tamamen doğru değildir. Doğrusu "C nin taban sınıfı B'dir. Dolaylı taban sınıflarından biri A'dır" cümlesidir.

   Java' da bir sınıf birden fazla (doğrudan) taban sınıfa sahip olamaz. Yani Java' da çoklu türetme (multiple inheritance)
   yoktur. Java'da bir sınıf yalnızca tek bir sınıftan türetilir.

   Anahtar Not: Java' da çoklu türetmeyi gerektiği yerlerde kısmi olarak desteklemesini sağlayan "interface" denilen
   bir tür bulunmaktadır. Bu konu ileride ele alınacaktır. Çoklu türetmenin pratikte örneği yoktur. Varolan olan
   örnekler de interface ile yapılabilecek şekildedir

   Türetme kavramı aynı zamanda "bir sınıfın kodlarına dokunmadan o sınıfı genişletmek" anlamına gelir. Bu kavramında
   içinde bulunduğu prensibe nesne yönelimli programlama tekniğinde "Open Closed Principle" denir. Bu prensibin
   İngilizce olarak mottosu "Open for extension closed for modification" dır.
----------------------------------------------------------------------------------------------------------------------*/
```
### Java'da türetme extends anahtar sözcüğü ile aşağıdaki gibi yapılır
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java'da türetme extends anahtar sözcüğü ile aşağıdaki gibi yapılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

class D extends A {
	//...
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
### Taban sınıfın metotları türemiş sınıfa da aktarılır.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Taban sınıfın metotları türemiş sınıfa da aktarılır. Aşağıdaki örnekte foo ve bar metotları B sınıfında da vardır.
	Bu kavrama "davranışsal genişletme (behavioral extension)" de denir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		B x = new B();

		x.foo();
		x.bar();
		x.tar();
	}
}

class B extends A {
	public void tar()
	{
		System.out.println("B.tar");
	}
}

class A {
	public void foo()
	{
		System.out.println("A.foo");
	}

	public void bar()
	{
		System.out.println("A.bar");
	}
}
```
### Bir dizi türetme durumu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir dizi türetme durumu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		C x = new C();

		x.foo();
		x.bar();
		x.tar();
		x.zar();
	}
}

class C extends B {
	public void zar()
	{
		System.out.println("C.zar");
	}
}

class B extends A {
	public void tar()
	{
		System.out.println("B.tar");
	}
}

class A {
	public void foo()
	{
		System.out.println("A.foo");
	}

	public void bar()
	{
		System.out.println("A.bar");
	}
}
```
### Türemiş sınıf referansı ile taban sınıfın non-static bir veri elemanına erişilebilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Türemiş sınıf referansı ile taban sınıfın non-static bir veri elemanına erişilebilir. Yani taban sınıfın non-static
	veri elemanları da türemiş sınıfa aktarılmış olur. Türemiş sınıf nesnesi içerisinde taban sınıf kadarlık bir bölüm
	bulunmaktadır. Burada nesnesel bir kapsama söz konusudur. Buna göre, türemiş sınıf nesnesinin bellekte kapladığı
	alan "en az taban sınıf nesnesinin bellekte kapladığı alan + türemiş sınıfa eklenen non-static veri elemanlarının
	toplam uzunluğu kadardır"
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		B b = new B();

		b.x = 10;
		b.y = 20;

		System.out.printf("b.x=%d%n", b.x);
		System.out.printf("b.y=%d%n", b.y);
	}
}

class B extends A {
	public int y;
}

class A {
	public int x;
}
```
### Bir dizi türetme durumu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir dizi türetme durumu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		C c = new C();

		c.x = 10;
		c.y = 20;
		c.z = 34;

		System.out.printf("c.x=%d%n", c.x);
		System.out.printf("c.y=%d%n", c.y);
		System.out.printf("c.y=%d%n", c.y);
	}
}

class C extends B {
	public int z;
}

class B extends A {
	public int y;
}

class A {
	public int x;
}
```
### Türemiş sınıf nesnesinin yaratılması aşamasında ctor çağrısından önce taban sınıfın ctor'u çağrılır.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Türemiş sınıf nesnesinin yaratılması aşamasında ctor çağrısından önce taban sınıfın ctor'u çağrılır. Herhangi bir
	belirtme yapılmamışsa taban sınıfın default ctor'u çağrılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		B x = new B();

		System.out.println("////////////////////");

		B y = new B(12);
	}
}

class B extends A {
	public B()
	{
		System.out.println("B.B()");
	}

	public B(int val)
	{
		System.out.println("B.B(int)");
	}
}

class A {
	public A()
	{
		System.out.println("A.A()");
	}
}
```
### Aşağıdaki örnekte A'nın default ctor'u private olduğundan B sınıfının bildiriminde error oluşur
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte A'nın default ctor'u private olduğundan B sınıfının bildiriminde error oluşur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

class B extends A {
	public B() //error
	{
		System.out.println("B.B()");
	}

	public B(int val) //error
	{
		System.out.println("B.B(int)");
	}
}

class A {
	private A()
	{
		System.out.println("A.A()");
	}
}
```
### Aşağıdaki örnekte A'nın default ctor'u olmadığından B sınıfının bildiriminde error oluşur
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte A'nın default ctor'u olmadığından B sınıfının bildiriminde error oluşur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

class B extends A {
	public B() //error
	{
		System.out.println("B.B()");
	}

	public B(int val) //error
	{
		System.out.println("B.B(int)");
	}
}

class A {
	public A(int a)
	{
		System.out.println("A.A(int)");
	}
}
```
### Türemiş sınıfı yazan programcı super ctor sentaksı ile türemiş sınıfın istenilen ctor'unun çağrılmasını sağlayabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Türemiş sınıfı yazan programcı super ctor sentaksı ile türemiş sınıfın istenilen ctor'unun çağrılmasını
	sağlayabilir. super ctor sentaksında hangi ctor'un çağrılacağının belirlenmesi sürecei metot çağrıları iiçin
	kullanılan "overload resolution" kuralları ile aynıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		B x = new B();
		System.out.println("//////////////////");
		B y = new B(10);
	}
}

class B extends A {
	public B()
	{
		System.out.println("B.B()");
	}

	public B(int val)
	{
		super(val);
		System.out.println("B.B(int)");
	}
}

class A {
	public A()
	{
		System.out.println("A.A()");
	}

	public A(int a)
	{
		System.out.println("A.A(int)");
	}
}
```
### super ctor sentaksı ctor'un ilk deyimi olmalıdır
```java
/*----------------------------------------------------------------------------------------------------------------------
	super ctor sentaksı ctor'un ilk deyimi olmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		B x = new B();
		System.out.println("//////////////////");
		B y = new B(10);
	}
}

class B extends A {
	public B()
	{
		System.out.println("B.B()");
	}

	public B(int val)
	{
		System.out.println("B.B(int)");
		super(val); //error
	}
}

class A {
	public A()
	{
		System.out.println("A.A()");
	}

	public A(int a)
	{
		System.out.println("A.A(int)");
	}
}
```
### super ctor sentaksı adından da anlaşılacağı gibi yalnızca ctor'larda kullanılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	super ctor sentaksı adından da anlaşılacağı gibi yalnızca ctor'larda kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		B x = new B();
		System.out.println("//////////////////");
		B y = new B(10);
	}
}

class B extends A {
	public B()
	{
		System.out.println("B.B()");
	}

	public B(int val)
	{
		super(val);
		System.out.println("B.B(int)");
	}

	public void foo()
	{
		super(9); //error
	}
}

class A {
	public A()
	{
		System.out.println("A.A()");
	}

	public A(int a)
	{
		System.out.println("A.A(int)");
	}
}
```
### ** ile belirtilen super ctor sentaksı default ctor çağrısı demek olduğundan yazılması ya da yazılmamamsı aynı anlamdadır.
```java
/*----------------------------------------------------------------------------------------------------------------------
	** ile belirtilen super ctor sentaksı default ctor çağrısı demek olduğundan yazılması ya da yazılmamamsı aynı
	anlamdadır. Yani bir sınıfının ctor'unun başına super ctor sentaksı yazmamak derleyicinin super(); şeklindeki
	deyimi kendisinin yerleştirmesi demektir. Bu şekilde düşünülebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		B x = new B();
		System.out.println("//////////////////");
		B y = new B(10);
	}
}

class B extends A {
	public B()
	{
		super(); //**: Yazılması yazılmaması ile aynı anlamdadır
		System.out.println("B.B()");
	}

	public B(int val)
	{
		super(val);
		System.out.println("B.B(int)");
	}
}

class A {
	public A()
	{
		System.out.println("A.A()");
	}

	public A(int a)
	{
		System.out.println("A.A(int)");
	}
}
```
### Bir dizi türetme durumunda taban sınıfın ctor'unun çağrılması
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir dizi türetme durumunda taban sınıfın ctor'unun çağrılması
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		C x = new C(10);
	}
}

class C extends B {
	public C(int val)
	{
		super(val);
		System.out.println("C.C(int)");
	}
}

class B extends A {
	public B()
	{
		System.out.println("B.B()");
	}

	public B(int val)
	{
		super(val);
		System.out.println("B.B(int)");
	}
}

class A {
	public A()
	{
		System.out.println("A.A()");
	}

	public A(int a)
	{
		System.out.println("A.A(int)");
	}
}
```
### Bazı durumlarda bir sınıfın ctor'u içerisinde sınıfın başka bir ctor'unun çağrılması gerekebilir. Bu durumda this ctor sentaksı kullanılır
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bazı durumlarda bir sınıfın ctor'u içerisinde sınıfın başka bir ctor'unun çağrılması gerekebilir. Bu durumda
	this ctor sentaksı kullanılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		A x = new A();
		System.out.println("////////////");
		A y = new A(10);
		System.out.println("////////////");
		A z = new A(3.4);

	}
}

class A {
	public A()
	{
		System.out.println("A.A()");
	}

	public A(double a)
	{
		this();
		System.out.println("A.A(double)");
	}

	public A(int a)
	{
		this();
		System.out.println("A.A(int)");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bazı durumlarda bir sınıfın ctor'u içerisinde sınıfın başka bir ctor'unun çağrılması gerekebilir. Bu durumda
	this ctor sentaksı kullanılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		A x = new A();
		System.out.println("////////////");
		A y = new A(10);
		System.out.println("////////////");
		A z = new A(3.4);

	}
}

class A {
	public A()
	{
		System.out.println("A.A()");
	}

	public A(double a)
	{
		this();
		System.out.println("A.A(double)");
	}

	public A(int a)
	{
		this("ankara");
		System.out.println("A.A(int)");
	}

	public A(String s)
	{
		System.out.println("A.A(String)");
	}
}
```
### this ctor sentaksı da ctor'un ilk deyimi olmak zorundadır
```java
/*----------------------------------------------------------------------------------------------------------------------
	this ctor sentaksı da ctor'un ilk deyimi olmak zorundadır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		A x = new A();
		System.out.println("////////////");
		A y = new A(10);
		System.out.println("////////////");
		A z = new A(3.4);

	}
}

class A {
	public A()
	{
		System.out.println("A.A()");
	}

	public A(double a)
	{
		System.out.println("A.A(double)");
		this(); //error
	}

	public A(int a)
	{
		this("ankara");
		System.out.println("A.A(int)");
	}

	public A(String s)
	{
		System.out.println("A.A(String)");
	}
}
```
### this ve super ctor sentaksları aynı anda bulunamazlar.
```java
/*----------------------------------------------------------------------------------------------------------------------
	this ve super ctor sentaksları aynı anda bulunamazlar. Böyle bir durumla karşılaşan programcı yazdığı koda
	bakmalıdır. Çünkü iyi bir tasarımın programcıyı bu şekilde bir ihtiyaca sokmaması gerekir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{


	}
}

class B extends A {
	public B(String s)
	{
		System.out.println("B.B(String)");
	}

	public B(int val)
	{
		this("ankara");
		super(val);//error
	}
}

class A {
	public A()
	{
		System.out.println("A.A()");
	}

	public A(int a)
	{
		System.out.println("A.A(int)");
	}
}
```
### this ctor sentaksında döngüsel durum geçersizdir
```java
/*----------------------------------------------------------------------------------------------------------------------
	this ctor sentaksında döngüsel durum geçersizdir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{


	}
}



class A {
	public A() //error
	{
		this(0);
		System.out.println("A.A()");
	}

	public A(int a) //error
	{
		this();
		System.out.println("A.A(int)");
	}
}
```
### Aşağıdaki durum da döngüseldir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki durum da döngüseldir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{


	}
}


class A {
	public A()
	{
		System.out.println("A.A()");
	}

	public A(double a)
	{

		System.out.println("A.A(double)");
	}

	public A(int a)
	{
		this(a);
		System.out.println("A.A(int)");
	}
}
```
### Aşağıdaki örnekte tür dönüştürme operatörü kullanılarak double parametreli ctor'un çağrılması sağlanmıştır
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte tür dönüştürme operatörü kullanılarak double parametreli ctor'un çağrılması sağlanmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
	}
}

class A {
	public A()
	{
		System.out.println("A.A()");
	}

	public A(double a)
	{
		System.out.println("A.A(double)");
	}

	public A(int a)
	{
		this((double)a);
		System.out.println("A.A(int)");
	}
}
```
### Java'da bir sınıf herhangi bir sınıftan extends anahtar sözcüğü ile türetilmese bile java.lang paketi içerisinde bulunan Object isimli bir sınıftan türetilmiş olur. 
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java'da bir sınıf herhangi bir sınıftan extends anahtar sözcüğü ile türetilmese bile java.lang paketi içerisinde
	bulunan Object isimli bir sınıftan türetilmiş olur. Yani tüm sınıflar aslında doğrudan ya da dolaylı olarak
	Object sınıfından türetilmiştir. Başka bir deyişle Object sınıfı tüm sınıfların doğrudan ya da dolaylı olarak
	taban sınıfıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

class B extends A {

}

class A {

}
```
### Object sınıfı istenirse extends anahtar sözcüğü ile de bildirimde yazılabilir. 
```java
/*----------------------------------------------------------------------------------------------------------------------
	Object sınıfı istenirse extends anahtar sözcüğü ile de bildirimde yazılabilir. Şüphesiz bu sınıfın başka bir
	sınıftan türetilmemiş olması gerekir. Ancak Object sınıfı bu şekilde yazılmaz. Zaten Java programcısı bunu
	bilmektedir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

class B extends A {

}

class A extends Object {

}
/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/
```
