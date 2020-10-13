```java
/*----------------------------------------------------------------------------------------------------------------------
	10.10.2020
	Parser uygulaması
	(İleride eklentiler yapılacak ve bazı kodlar daha iyi hale getirilecektir)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.parserapp.ParserTest;

class App {
	public static void main(String [] args)
	{
		ParserTest.run();
	}
}

package org.csystem.app.samples.parserapp;

import java.util.Scanner;

public final class ParserTest {
    private ParserTest()
    {
    }

    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Parser parser = new Parser();

        for (;;) {
            System.out.print("Bir yazı giriniz:");
            String str = kb.nextLine();

            if (str.equals("quit"))
                break;

            StringSource stringSource = new StringSource(str);
            CharArraySource charArraySource = new CharArraySource(str + str);

            parser.setSource(stringSource);

            parser.doParse();

            parser.setSource(charArraySource);

            parser.doParse();
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}

package org.csystem.app.samples.parserapp;

public class Source {
    public int getChar()
    {
        return -1;
    }
}

package org.csystem.app.samples.parserapp;

public class Parser {
    private Source m_source;

    public Parser()
    {
    }

    public Parser(Source source)
    {
        this.setSource(source);
    }

    public Source getSource()
    {
        return m_source;
    }

    public void setSource(Source source)
    {
        //...
        m_source = source;
    }

    public void doParse()
    {
        if (m_source == null)
            return;

        int count = 0;
        int ch;

        while ((ch = m_source.getChar()) != -1)
            if (Character.isWhitespace((int)ch))
                ++count;

        System.out.printf("Count:%d%n", count);
    }
}

package org.csystem.app.samples.parserapp;

import java.util.Arrays;

public class CharArraySource extends Source {
    private final char [] m_chars;
    private int m_index;

    public CharArraySource(char [] chars)
    {
        m_chars = Arrays.copyOf(chars, chars.length);
    }

    public CharArraySource(String str)
    {
        m_chars = str.toCharArray();
    }

    public int getChar()
    {
        return m_index == m_chars.length ? -1 : m_chars[m_index++];
    }
}


package org.csystem.app.samples.parserapp;

public class StringSource extends Source {
    private final String m_str;
    private int m_index;

    public StringSource(String str)
    {
        m_str = str;
    }

    public int getChar()
    {
        return m_str.length() == m_index ? -1 : m_str.charAt(m_index++);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Object sınıfının toString metodu nesneye yönelik tekil (unique) bir bilgiyi yazı olarak döndürür
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample s = new Sample();
        Sample k = new Sample();

        System.out.println(s.toString());
        System.out.println(k.toString());
    }
}

class Sample {

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Object sınıfının toString metodu sanal bir metottur. Bir nesnenin yazısal karşılığının olması durumunda o sınıf
    için toString override edilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Object s = new Sample();
		Object k = new Sample();

		System.out.println(s.toString());
		System.out.println(k.toString());
	}
}

class Sample {
	public String toString()
	{
		return "Sample";
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    print ve println metotlarının Object parametreli overload'ları ekrana basacakları yazı için toString metodunu
    çağırır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Object s = new Sample();
		Object k = new Sample();

		System.out.println(s);
		System.out.println(k);
	}
}

class Sample {
	public String toString()
	{
		return "Sample";
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    print ve println metotlarının Object parametreli overload'ları ekrana basacakları yazı için toString metodunu
    çağırır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.Rational;

class App {
	public static void main(String [] args)
	{
		Rational r = new Rational(3, 4);

		System.out.println(r);
	}
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    printf metodu (dolayısıyla String sınıfının format metodu) s format karakterine karşılık gelen yazı için
    toString metodunu çağırır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.Rational;

class App {
    public static void main(String [] args)
    {
        Rational r = new Rational(3, 4);

        System.out.printf("Kesir:%s%n", r);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte yazıya dönüştürme öncesinde auto-boxing yapılır, sonra toString metodu çağrılır. Şüphesiz derleyici
    buna ilişkin kodu yazar
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int val = 10;
		String str = "Değer:" + val; // "Değer:" + Integer.valueOf(val).toString();

		System.out.println(str);
	}
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte r referansı için toString çağrılarak yazı elde edilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.Rational;

class App {
    public static void main(String [] args)
    {
        Rational r = new Rational(3, 4);
        String str = "Kesir:" + r; //"Kesir:" + r.toString();

        System.out.println(str);
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    printf (dolayısıyla String.format) metodu için s format karakteri temel türler için de kullanılabilir. Bu durumda
    yine toString metodu çağrılacaktır. Şüphesiz temel bir tür printf metoduna verildiğinde Object ataması
    dolayısyla atama sırasında yine otomatik kutulama yapılacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int a = 10;
		double b = 20;

		System.out.printf("a=%s, b=%s%n", a, b);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.datetime.Date;

class App {
	public static void main(String [] args)
	{
		Sample.display(10);
		Sample.display("ankara");
		Sample.display(new Date());
	}
}

class Sample {
	public static void display(Object o)
	{
		String s = o.toString();

		System.out.println(s);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Hatırlanacağı gibi ArrayList sınıfının toString metodu içerisinde tuttuğu elemanları [] içerisinde listeler.
    ArrayList sınıfı elemanlara ilişkin Object referansları için toString metodunu çağırır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.ArrayList;

class App {
	public static void main(String [] args)
	{
		ArrayList list = new ArrayList();

		for (int i = 0; i < 10; ++i)
			list.add(i * 10);

		System.out.println(list);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Hatırlanacağı gibi ArrayList sınıfının toString metodu içerisinde tuttuğu elemanları [] içeriisnde listeler.
    ArrayList sınıfı elemanlara ilişkin Object referansları için toString metodunu çağırır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.geometry.Point;

import java.util.ArrayList;

class App {
	public static void main(String [] args)
	{
		ArrayList list = new ArrayList();

		list.add(new Point(100, 100));
		list.add(new Point(-100, 10));
		list.add(new Point());

		System.out.println(list);
	}
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
    Hatırlanacağı gibi ArrayList sınıfının toString metodu içerisinde tuttuğu elemanları [] içeriisnde listeler.
    ArrayList sınıfı elemanlara ilişkin Object referansları için toString metodunu çağırır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.datetime.Date;

import java.util.ArrayList;

class App {
	public static void main(String [] args)
	{
		ArrayList list = new ArrayList();

		list.add(new Date());
		list.add(Date.randomDate());
		list.add(new Date(10, 10, 2020));

		System.out.println(list);
	}
}

```
```java

/*----------------------------------------------------------------------------------------------------------------------
    CSDArrayList sınıfının toString metodu
    (İleride daha iyisi yazılacaktır)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.collection.CSDArrayList;
import org.csystem.util.datetime.Date;

class App {
	public static void main(String [] args)
	{
		CSDArrayList list = new CSDArrayList();

		list.add(new Date());
		list.add(Date.randomDate());
		list.add(new Date(10, 10, 2020));

		System.out.println(list);
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

    public String toString()
    {
        String str = "";

        for (int i = 0; i < m_index; ++i)
            str += m_elems[i] + ", ";

        if (!str.isEmpty())
            str = str.substring(0, str.length() - ", ".length());

        return "[" + str + "]";
    }
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
    Bazı durumlarda bir sınıf bir kavramı soyut olarak temsil ediyor olabilir. Bu durumda sınıfın tek başına
    anlamı yoktur. Yani nesne yönelimli programlama bakış açısıyla o sınıf türünden nesnenin anlamı yoktur. Ancak
    o sınıftan türeyen sınıfların nesne olarak anlamı vardır. Bu tarz sınıflara soyut (abstract) sınıflar denir.
    Soyut olmayan sınıflara da somut (concrete) sınıflar denir. Bu tip durumlarda sınıfın soyut (abstract) bildirilmesi
    daha uygundur.Örneğin CompanyApp uygulamasında Employee sınıfı tek başına anlamlı değildir ancak soyut olarak
    "çalışan kavramını" temsil eder. Employee sınıfından türetilen sınıflar nesne olarak anlamlıdır. Yani Employee
    sınıfından türemil olan sınıflar somut (concrete) sınıflardır.
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Soyut bir sınıf abstract anahtar sözcüğü ile bildirilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {

    }
}

abstract class Sample {
    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir sınıfın abstract metotları olabilir. abstract metotlar gövdesi olmayan metotlardır. Bu metotlara gövde yazımı
    error oluşturur. abstract metotlar abstract anahtar sözcüğü ile bildirilir. Bu metotlar sanaldır. Dolayısıyla
    override edilebilir. En az bir tane abstract metodu olan bir sınıf abstract olarak bildirilmelidir.
    Aksi durumda error oluşur. Dikkat edilirse abstract bir sınıfın abstract bir metodu olmak zorunda değildir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {

    }
}

abstract class A {
    public abstract void foo() //error
    {
    }

}

class Mample { //error
    public abstract void bar();
}

abstract class Sample {
    public abstract void foo();
    public abstract void tar();

    public void bar()
    {}
}

abstract class Test {
    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    abstract sınıf türünden bir nesne new operatörü ile yaratılamaz. new işlemi sınıf içerisinde de yapılamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Sample s = new Sample(); //error
	}
}

abstract class Sample {
	public abstract void foo();
	public abstract void tar();

	public void bar()
	{
		Sample s = new Sample(); //error
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    abstract sınıfların da non-static veri elemanları olabilir. abstract sınıfların abstract olmayan metotları da
    olabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {

    }
}

abstract class Sample {
    private int m_x;
    public abstract void foo();
    public abstract void tar();

    public void bar()
    {

    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    abstract bir sınıftan türetilmiş olan bir sınıf taban sınıfının en az bir tane abstract metodunu override etmezse
    türemiş sınıf da abstract olarak bildirilmek zorundadır. Sınıf içerisinde hiç abstract metot kalmadıysa bu durumda
    sınıf concrete olabilir. Şüphesiz aşağıdaki örnekte E sınıfının A'nın tüm metotlarını override etmiş olmasına
    rağmen conrete olma zorunluluğu yoktur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

abstract class E extends A {
	public void foo()
	{
		//...
	}

	public void bar()
	{
		//...
	}
}

class C extends A {
	public void foo()
	{
		//...
	}
	public void bar()
	{
		//...
	}
}

abstract class D extends A {
	public void foo()
	{
		//...
	}
}

class B extends A { //error
	public void foo()
	{
		//...
	}
}

abstract class A {
	public abstract void foo();
	public abstract void bar();
	//...
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki durumda C sınıfında artık hiç abstract metot kalmadığından concrete olabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {

    }
}

class C extends B {
    public void bar()
    {
        //...
    }
}

abstract class B extends A {
    public void foo()
    {
        //...
    }
}

abstract class A {
    public abstract void foo();
    public abstract void bar();
    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    abstract sınıf referanslarının taban sınıf referansı olarak kullanımı anlamlıdır. Bu durumda polymoprhism' de
    abstract sınıflarla yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		A x = new C();

		x.foo();
		x.bar();
	}
}

class C extends B {
	public void bar()
	{
		System.out.println("C.bar");
	}
}

abstract class B extends A {
	public void foo()
	{
		System.out.println("B.foo");
	}
}

abstract class A {
	public abstract void foo();
	public abstract void bar();
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    abstract sınıflarda ctor olabilir. abstract sınıfların ctor'larının public yapılması anlamsızdır. public yerine
    protected yapılması okunabilirlik açısından daha uygundur. private ve no-modifier erişimcilerin ctor açısından
    anlamı olabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		B b = new B(10, 20);

		//..
	}
}

class B extends A {
	private int m_y;

	public B(int x, int y)
	{
		super(x);
		m_y = y;
	}

	public void foo()
	{

	}
}

abstract class A {
	private int m_x;

	private A()
	{
		//...
	}

	protected A(int x)
	{
		this();
		m_x = x;
	}

	public int getX()
	{
		return m_x;
	}

	public void setX(int x)
	{
		m_x = x;
	}

	public abstract void foo();
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    CompanyApp örneğindeki Employee sınıfının calculatePayment metodunun abstract yapılması daha uygundur. Ayrıca
    ctor'u da protected yapılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.samples.companyapp;

public abstract class Employee {
    private String m_citizenId;
    private String m_name;
    private String m_address;
    //...

    protected Employee(String citizenId, String name, String address)
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

    public abstract double calculatePayment();
    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Parser uygulamasında da Source sınıfının artık abstract sınıf olması ve getChar metodunun da abstract olarak
    bildirilmesi uygundur. İleride bu sınıf daha iyi tasarlanacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.samples.parserapp;

public abstract class Source {
    public abstract int getChar();
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    abstract sınıflar final olarak bildirilemez
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

abstract final class A { //error

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Şüphesiz bir sınıf başka bir sınıftan türetilip abstract olmıyacaksa final bildirilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}


final class B extends A {
	//...
}

abstract class A {
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    override işleminde erişim belirleyici erişim anlamında yükseltilebilir ancak düşürülemez. Bu durumda public bir
    sanal metot public olarak override edilmek zorundadır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

class B extends A {
	protected void foo() //error
	{

	}
}

abstract class A {
	public abstract void foo();
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    override işleminde erişim belirleyici erişim anlamnında yükseltilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {

    }
}

class B extends A {
    public void foo()
    {

    }
}

abstract class A {
    protected abstract void foo();
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    override işleminde erişim belirleyici erişim anlamnında yükseltilebilir. Ancak bu durumda aşağıdaki gibi
    sınıfların da paket anlamında uygun yerlerinde olması gerekir. Erişim belirleyicilerinin anlamlarını hatırlayınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import test.B;

class App {
	public static void main(String [] args)
	{
		A x = new B();

		x.foo();
	}
}

package test;

import org.csystem.app.A;

public class B extends A {
    public void foo()
    {
        System.out.println("B.foo");
    }
}

package test;

import org.csystem.app.A;

public class B extends A {
    public void foo()
    {
        System.out.println("B.foo");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    final olarak bildirilmiş bir metot sanal değildir. Override edilemez
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {

    }
}

class B extends A {
    public void foo() //error
    {

    }
}

class A {
    public final void foo()
    {

    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    final olarak bildirilmiş bir metot sanal değildir. Override edilemez. Aşağıdaki örnekte B sınıfı foo metodunu
    override etmiştir. B foo'nun sanallığını kaldırdığında C sınıfında foo override edilemez
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

class C extends B {
	public void foo() //error
	{}
}

class B extends A {
	public final void foo()
	{
	}
}

abstract class A {
	public abstract void foo();

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Java' da static bir metot türemiş sınıfta aynı geri dönüş değeri ve aynı imza ile ve erişim belirleyiciyi
    düşürmemek şartıyla yazılabilir. Bu durumda metot hangi sınıf ismi ile çağrılıyorsa o sınıfın metodu çağrılır.
    Bu durum her ne kadar override işlemini andırsa da "override" dendiğinde non-static bir metot anlaşılır. static
    metotlar için bu işleme bazı kaynaklar "static override" derler. Ancak unutulmamalıdır ki "override" non-static
    metotlar ve polymorphism için anlamlıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		A.foo();
		B.foo();
	}
}

class B extends A {
	public static void foo()
	{
		System.out.println("B.foo");
	}
}

class A {
	public static void foo()
	{
		System.out.println("A.foo");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte B sınıfının foo metodu içerisinde A sınıfının foo metodu çağrılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		A.foo();
		B.foo();
	}
}

class B extends A {
	public static void foo()
	{
		System.out.println("B.foo");
		A.foo();
	}
}

class A {
	public static void foo()
	{
		System.out.println("A.foo");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte x A türünden olduğundan ve foo' da static olduğundan A'nın foo metodu çağrılır.
    static bir metodun referans ile çağrılmasının sınıf ismi ile çağrılmasından farkı olmadığını hatırlayınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		A x = new B();

		x.foo();
	}
}

class B extends A {
	public static void foo()
	{
		System.out.println("B.foo");
	}
}

class A {
	public static void foo()
	{
		System.out.println("A.foo");
	}
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	11.10.2020
	Homework-015'in bir çözümü
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.games.shufflecardsapp.ShuffleCardApp;

class App {
	public static void main(String [] args)
	{
		ShuffleCardApp.run();
	}
}

package org.csystem.app.samples.games.shufflecardsapp;

import org.csystem.app.samples.games.cardgames.Card;

public final class ShuffleCardApp {
    private ShuffleCardApp()
    {
    }

    public static void run()
    {
        Card[] deck;

        deck = Card.getShuffledDeck();

        for (Card c : deck)
            System.out.println(c);
    }
}


package org.csystem.app.samples.games.cardgames;

import java.util.Random;

public class Card
{
    private static final Card [] DECK = getNewDeck();
    private CardValue m_value;
    private CardType m_type;

    private static void swap(Card [] deck, int i, int k)
    {
        Card temp = deck[i];

        deck[i] = deck[k];
        deck[k] = temp;
    }

    private static void shuffle(Card [] deck, int n)
    {
        Random r = new Random();

        for (int i = 0; i < n; ++i) {
            int first = r.nextInt(52);
            int second = r.nextInt(52);

            swap(deck, first, second);
        }
    }

    private static void doWorkForException(String message)
    {
        System.out.println(message);
        System.exit(-1); //exception konusuna kadar sabredin
    }

    private static Card[] getNewDeck()
    {
        Card [] deck = new Card[52];
        int i = 0;

        for (CardType cardType : CardType.values())
            for (CardValue cardValue : CardValue.values())
                deck[i++] = new Card(cardValue, cardType);

        return deck;
    }

    private void setCard(String name)
    {
        String [] cardInfo = name.split("[-]");

        if (cardInfo.length != 2)
            doWorkForException("Geçersiz kart ismi");

        CardType cardType = CardType.getCardTypeByString(cardInfo[0]);
        CardValue cardValue = CardValue.getCardValueByString(cardInfo[1]);

        if (cardValue == null | cardType == null)
            doWorkForException("Geçersiz kart");

        m_type = cardType;
        m_value = cardValue;
    }

    public Card(CardValue cardValue, CardType cardType)
    {
        m_value = cardValue;
        m_type = cardType;
    }

    public Card(String name)
    {
        this.setName(name);
    }

    public String getName()
    {
        return String.format("%s-%s", m_type.getTypeStr(), m_value.getValueStr());
    }

    public void setName(String name)
    {
        this.setCard(name);
    }

    public String toString()
    {
        return getName();
    }

    public static Card[] getShuffledDeck()
    {
        shuffle(DECK, 100);

        return DECK;
    }
}
package org.csystem.app.samples.games.cardgames;

public enum CardValue {
    TWO("İki"), THREE("Üç"), FOUR("Dört"), FIVE("Beş"), SIX("Altı"), SEVEN("Yedi"), EIGHT("Sekiz"), NINE("Dokuz"),
    TEN("On"), KNAVE("Vale"), QUEEN("Kız"), KING("Papaz"), ACE("As");

    private final String m_valueStr;

    CardValue(String typeStr)
    {
        m_valueStr = typeStr;
    }

    public String getValueStr()
    {
        return m_valueStr;
    }

    public static CardValue getCardValueByString(String valueStr)
    {
        CardValue resultValue = null;

        for (CardValue cardValue : values())
            if (cardValue.m_valueStr.equals(valueStr)) {
                resultValue = cardValue;
                break;
            }

        return resultValue;
    }
}
package org.csystem.app.samples.games.cardgames;

public enum CardType {
    SPADE("Maça"), CLUB("Sinek"), DIAMOND("Karo"), HEART("Kupa");
    private final String m_typeStr;

    CardType(String typeStr)
    {
        m_typeStr = typeStr;
    }

    public String getTypeStr()
    {
        return m_typeStr;
    }

    public static CardType getCardTypeByString(String typeStr)
    {
        CardType resultType = null;

        for (CardType cardType : values())
            if (cardType.m_typeStr.equals(typeStr)) {
                resultType = cardType;
                break;
            }

        return resultType;
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte bir oyun sistemine ilişkin demo bir şablon hazırlanmıştır. Bu sisteme oyun olarak
	dahil olabilmek için AbstractGame isimli şablon (template) sınıftan türetme yapmak ve ilgili metotları
	override etmek gerekmektedir. Konunun daha fazla detayları vardır. Burada demo biçiminde ele alınmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.games.template.GamerRunnerApp;

class App {
	public static void main(String [] args)
	{
		GamerRunnerApp gamerRunnerApp = new GamerRunnerApp();

		gamerRunnerApp.run();
	}
}

package org.csystem.app.samples.games.template;

import org.csystem.app.samples.games.angrybirdsgame.AngryBirdsGame;
import org.csystem.app.samples.games.cargameapp.CarRaceGame;
import org.csystem.app.samples.games.randomcardgame.RandomCardGame;
import org.csystem.app.samples.games.shuffledeckgame.ShuffleDeckGame;
import org.csystem.app.samples.games.zombiegame.ZombieGame;

public class GamerRunnerApp {
    private final GameController m_gameController;

    private void initGames()
    {
        m_gameController.add(new CarRaceGame());
        m_gameController.add(new ZombieGame());
        m_gameController.add(new AngryBirdsGame());
        m_gameController.add(new ShuffleDeckGame());
        m_gameController.add(new RandomCardGame());
    }

    public GamerRunnerApp()
    {
        m_gameController = new GameController();
        this.initGames();
    }

    public void run()
    {
        m_gameController.run();
    }
}

package org.csystem.app.samples.games.template;

import java.util.ArrayList;
import java.util.Scanner;

public class GameController {
    private final ArrayList m_games = new ArrayList();
    //...
    private AbstractGame getGameByOption(int option)
    {
        return (AbstractGame)m_games.get(option);
    }

    public void displayMenu()
    {
        int size = m_games.size();

        System.out.println("Oyunlar:");
        for (int i = 0; i < size; ++i)
            System.out.printf("%d.%s%n", i + 1, ((AbstractGame) m_games.get(i)).getName());

        System.out.printf("%d.Çıkış%n", size + 1);
        System.out.print("Oyun numarasını giriniz:");
    }

    public void run()
    {
        Scanner kb = new Scanner(System.in);

        int sizep1 = m_games.size() + 1;

        for (;;) {
            this.displayMenu();
            int option = Integer.parseInt(kb.nextLine());

            if (option < 0 || option > sizep1) {
                System.out.println("Geçersiz seçenek");
                continue;
            }
            if (option == sizep1)
                break;

            AbstractGame abstractGame = getGameByOption(option - 1);

            abstractGame.run();
            System.out.println("/////////////////////");
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }

    public void add(AbstractGame abstractGame)
    {
        //...
        m_games.add(abstractGame);
    }
}


package org.csystem.app.samples.games.template;

public abstract class AbstractGame {
    private String m_name;
    //...

    public AbstractGame(String name)
    {
        m_name = name;
    }


    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public abstract void start();
    public abstract void play();
    public abstract void pause();
    //...
    public abstract void end();

    //...
    public final void run()
    {
        this.start();
        this.play();
        //...
        this.pause();
        //...
        this.end();
    }
}

package org.csystem.app.samples.games.shuffledeckgame;

import org.csystem.app.samples.games.cardgames.Card;
import org.csystem.app.samples.games.template.AbstractGame;

public class ShuffleDeckGame extends AbstractGame {
    private Card[] m_deck;

    public ShuffleDeckGame()
    {
        super("Shuffle Deck");
    }

    public void start()
    {
        m_deck = Card.getShuffledDeck();
    }
    public void play()
    {
        for (Card card : m_deck)
            System.out.println(card);
    }

    public void pause()
    {
        System.out.println("Shuffle Deck pause");
    }
    //...
    public void end()
    {
        System.out.println("Shuffle Deck end");
    }
}

package org.csystem.app.samples.games.cardgames;

import java.util.Random;

public class Card
{
    private static final Card [] DECK = getNewDeck();
    private CardValue m_value;
    private CardType m_type;

    private static void swap(Card [] deck, int i, int k)
    {
        Card temp = deck[i];

        deck[i] = deck[k];
        deck[k] = temp;
    }

    private static void shuffle(Card [] deck, int n)
    {
        Random r = new Random();

        for (int i = 0; i < n; ++i) {
            int first = r.nextInt(52);
            int second = r.nextInt(52);

            swap(deck, first, second);
        }
    }

    private static void doWorkForException(String message)
    {
        System.out.println(message);
        System.exit(-1); //exception konusuna kadar sabredin
    }

    private static Card[] getNewDeck()
    {
        Card [] deck = new Card[52];
        int i = 0;

        for (CardType cardType : CardType.values())
            for (CardValue cardValue : CardValue.values())
                deck[i++] = new Card(cardValue, cardType);

        return deck;
    }

    private void setCard(String name)
    {
        String [] cardInfo = name.split("[-]");

        if (cardInfo.length != 2)
            doWorkForException("Geçersiz kart ismi");

        CardType cardType = CardType.getCardTypeByString(cardInfo[0]);
        CardValue cardValue = CardValue.getCardValueByString(cardInfo[1]);

        if (cardValue == null | cardType == null)
            doWorkForException("Geçersiz kart");

        m_type = cardType;
        m_value = cardValue;
    }

    public Card(CardValue cardValue, CardType cardType)
    {
        m_value = cardValue;
        m_type = cardType;
    }

    public Card(String name)
    {
        this.setName(name);
    }

    public String getName()
    {
        return String.format("%s-%s", m_type.getTypeStr(), m_value.getValueStr());
    }

    public void setName(String name)
    {
        this.setCard(name);
    }

    public String toString()
    {
        return getName();
    }

    public static Card[] getShuffledDeck()
    {
        shuffle(DECK, 100);

        return DECK;
    }
}

package org.csystem.app.samples.games.cardgames;

public enum CardType {
    SPADE("Maça"), CLUB("Sinek"), DIAMOND("Karo"), HEART("Kupa");
    private final String m_typeStr;

    CardType(String typeStr)
    {
        m_typeStr = typeStr;
    }

    public String getTypeStr()
    {
        return m_typeStr;
    }

    public static CardType getCardTypeByString(String typeStr)
    {
        CardType resultType = null;

        for (CardType cardType : values())
            if (cardType.m_typeStr.equals(typeStr)) {
                resultType = cardType;
                break;
            }

        return resultType;
    }
}

package org.csystem.app.samples.games.cardgames;

public enum CardValue {
    TWO("İki"), THREE("Üç"), FOUR("Dört"), FIVE("Beş"), SIX("Altı"), SEVEN("Yedi"), EIGHT("Sekiz"), NINE("Dokuz"),
    TEN("On"), KNAVE("Vale"), QUEEN("Kız"), KING("Papaz"), ACE("As");

    private final String m_valueStr;

    CardValue(String typeStr)
    {
        m_valueStr = typeStr;
    }

    public String getValueStr()
    {
        return m_valueStr;
    }

    public static CardValue getCardValueByString(String valueStr)
    {
        CardValue resultValue = null;

        for (CardValue cardValue : values())
            if (cardValue.m_valueStr.equals(valueStr)) {
                resultValue = cardValue;
                break;
            }

        return resultValue;
    }
}

package org.csystem.app.samples.games.angrybirdsgame;

import org.csystem.app.samples.games.template.AbstractGame;

public class AngryBirdsGame extends AbstractGame {
    //...

    public AngryBirdsGame()
    {
        super("Angry Birds");
    }

    public void start()
    {
        System.out.println("Angry Birds start");
    }
    public void play()
    {
        System.out.println("Angry Birds play");
    }

    public void pause()
    {
        System.out.println("Angry Birds pause");
    }
    //...
    public void end()
    {
        System.out.println("Angry Birds end");
    }
}
package org.csystem.app.samples.games.cargameapp;

import org.csystem.app.samples.games.template.AbstractGame;

public class CarRaceGame extends AbstractGame {
    //...

    public CarRaceGame()
    {
        super("Car Racing");
    }

    public void start()
    {
        System.out.println("CarRaceGame start");
    }
    public void play()
    {
        System.out.println("CarRaceGame play");
    }

    public void pause()
    {
        System.out.println("CarRaceGame pause");
    }
    //...
    public void end()
    {
        System.out.println("CarRaceGame end");
    }
}


package org.csystem.app.samples.games.zombiegame;

import org.csystem.app.samples.games.template.AbstractGame;

public class ZombieGame extends AbstractGame {
    //...

    public ZombieGame()
    {
        super("Escape from zombies");
    }

    public void start()
    {
        System.out.println("ZombieGame start");
    }

    public void play()
    {
        System.out.println("ZombieGame play");
    }

    public void pause()
    {
        System.out.println("ZombieGame pause");
    }
    //...
    public void end()
    {
        System.out.println("ZombieGame end");
    }
}

package org.csystem.app.samples.games.randomcardgame;

import org.csystem.app.samples.games.cardgames.Card;
import org.csystem.app.samples.games.template.AbstractGame;

import java.util.Scanner;

public class RandomCardGame extends AbstractGame {
    private Scanner m_scanner;
    private int m_count;
    private int m_score;

    private void playGame(Card card)
    {
        Card [] deck = Card.getShuffledDeck();
        // Seçilen kartın index numarası bulunup sonuç belirlenebilir. enum'ların eşitlik karşılaştırmasını göstermek
        //için aşağıdaki gibi yazdık

        boolean turnFlag = true;

        for (Card c : deck) {
            if (c.getValue() == card.getValue() && c.getType() == card.getType()) {
                if (turnFlag) {
                    ++m_score;
                    System.out.println("Sen kazandın");
                }
                else
                    System.out.println("ben kazandım");

                break;
            }

            turnFlag = !turnFlag;
        }
    }

    public RandomCardGame()
    {
        super("Random Card Generator");
    }

    public void start()
    {
        m_scanner = new Scanner(System.in);
        System.out.print("Kaç kez oynamak istersiniz:");
        m_count = Integer.parseInt(m_scanner.nextLine());
    }

    public void play()
    {
        for (int i = 0; i < m_count; ++i) {
            System.out.print("Lütfen bir kart seçiniz");
            String name = m_scanner.nextLine();
            //...
            Card card = new Card(name);

            playGame(card);
        }

        System.out.printf("Sen:%d, Ben:%d%n", m_score, m_count - m_score);
    }

    public void pause()
    {
        System.out.println("RandomCardGame pause");
    }
    //...
    public void end()
    {
        System.out.println("RandomCardGame end");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Exception İşlemleri:
    Exception programlamada genel olarak çalışma zamanında oluşan hatalara denir. Ancak bazen bir exeception hata
    durumuna ilişkin olmayabilir. Exception oluştuğunda programın nasıl devam edeceğinin belirlenmesine
    "exception handling" denir. Örneğin, bir yön bulma uygulamasında uygulamanın GPS sensöründen bilgi alamaması
    durumu bir exception durumudur. Bu durumda program bunu kullanıcıya belirterek uygulamanın devam etmesini
    sağlayabilir.

    Java' da exception işlemleri için aşağıdaki anahtar sözcükler kullanılır:
    try, catch, throw, finally, throws

    Bir exception throw anahtar sözcüğü ile fırlatılabilir. throw anahtar sözcüğünün genel biçimi şöyledir:

    throw <referans>;

    throw anahtar sözcüğü bir referans alır. throw anahtar sözcüğünün aldığı referansın Throwable sınıfından doğrudan
    ya da dolaylı olarak türemiş bir sınıf türünden olması gerekir.

    Bir exception fırlatıldığında akış exception'ın fırlatıldığı metottan çıkar.

    Bir exception yakalanamaz ise bu durumda exception ın fırlatıldığı akış (thread) sonlanır.

    Akış exception bakımından ele alınacaksa (handling) try bloğu içerisinde yazılmalıdır. try bloğu
    catch bloğu veya blokları veya tek başına finally bloğu veya catch blokları ve finally bloğu
    ile devam edebilir. try bloğu tek başına olamaz. try bloğu tüm diğer blokları ile birlikte tek bir deyimdir.
    try bloğu ile birlikte bulunan diğer bloklar arasında herhangi bir deyim yazılamaz.

    catch bloğunun parantezi içerisinde yazılan parametreye catch parametresi denir. catch parametresine
    ilişkin türün bir exception sınıfı yani Throwable'dan doğrudan ya da dolaylı olarak türetilmiş
    bir sınıf türünden olması gerekir.

    Exception oluşursa (fırlatılırsa) akış try bloğundan bir daha geri dönmemek üzere (non-resumptive) catch bloklarına
    sıçrar. catch blokları yukarıdan aşağıya switch deyimi gibi teker teker kontrol edilir. Uygun catch bloğu bulunursa
    o catch bloğu çalıştırılır. Uygun catch bloğu fırlatılan exception nesnesinin adresinin (referansının) ilgili catch
    parametresine doğrudan atanabildiği ilk catch bloğudur. Exception yakalanırsa yakalanan catch bloğuna ilişkin kodlar
    çalıştırılır. Kodlar bitince tüm diğer catch blokları atlanarak akış devam eder. Eğer exception hiç yakalanamazsa akış
    çöker. Yani bir catch bloğu çalıştırılırsa diğer catch blokları çalıştırılmaz. try bloğu exception oluşmadan sonlanırsa
    tüm catch blokları atlanarak akış devam eder.
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
     Aşağıdaki örnekte MyException sınıfı doğrudan ya da dolaylı olarak Throwable sınıfından türetilmediği için
     throw' a referans olarak verilemez
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {

    }
}

class MathUtil {
    public static double myLog(double val)
    {
        if (val <= 0) {
            MyException ex = new MyException();

            throw ex; //error
        }

        //...
    }

}

class MyException {

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir exception fırlatılması
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
    public static void main(String [] args)
    {
        Scanner kb = new Scanner(System.in);

        System.out.print("Bir sayı giriniz:");
        double val = Double.parseDouble(kb.nextLine());

        System.out.printf("log(%f)=%f%n", val, MathUtil.myLog(val));
    }
}

class MathUtil {
    public static double myLog(double val)
    {
        if (val <= 0) {
            MyException ex = new MyException();

            throw ex;
        }

        return Math.log(val);
    }
}


class MyException extends RuntimeException {
    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    throw ile o an nesne yaratılarak fırlatılmasına ilişkin ifade çok sık kullanılmaktadır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
    public static void main(String [] args)
    {
        Scanner kb = new Scanner(System.in);

        System.out.print("Bir sayı giriniz:");
        double val = Double.parseDouble(kb.nextLine());

        System.out.printf("log(%f)=%f%n", val, MathUtil.myLog(val));
    }
}

class MathUtil {
    public static double myLog(double val)
    {
        if (val <= 0)
            throw new MyException();

        return Math.log(val);
    }
}


class MyException extends RuntimeException {
    //...
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    try-catch blokları: Örnekte parseDouble metodunun fırlattığı exception'ın yakalanamadığına dolayısıyla bu exception
    fırlatıldığında akışın sonlandığına dikkat ediniz. Kodu çeşitli sayılarla test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);

		System.out.print("Bir sayı giriniz:");
		double val = Double.parseDouble(kb.nextLine());

		try {
			double result = MathUtil.myLog(val);

			System.out.printf("log(%f)=%f%n", val, result);
		}
		catch (MyException ex) {
			System.out.println("My Excepion yakalandı");
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class MathUtil {
	public static double myLog(double val)
	{
		if (val <= 0)
			throw new MyException();

		return Math.log(val);
	}
}

class MyException extends RuntimeException {
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    try-catch blokları: Örnekte parseDouble metodunun fırlattığı exception'ın yakalanamadığına dolayısıyla bu exception
    fırlatıldığında akışın sonlandığına dikkat ediniz. Kodu çeşitli sayılarla test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);

		System.out.print("Bir sayı giriniz:");
		double val = Double.parseDouble(kb.nextLine());

		try {
			double result = MathUtil.myLog(val);

			System.out.printf("log(%f)=%f%n", val, result);
		}
		catch (MyException ex) {
			System.out.println("My Exception yakalandı");
		}
		catch (YourException ex) {
			System.out.println("Your Excepion yakalandı");
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class MathUtil {
	public static double myLog(double val)
	{
		if (val < 0)
			throw new MyException();

		if (val == 0)
			throw new YourException();

		return Math.log(val);
	}
}


class MyException extends RuntimeException {
	//...
}

class YourException extends RuntimeException {
	//...
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
    Taban sınıf parametreli catch bloğu o sınıftan türemiş olan sınıflara ilişkin exception nesnelerini yakalayabilir.
    Bu işlem aslında bir upcasting işlemidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		double val = Double.parseDouble(kb.nextLine());

		try {
			double result = MathUtil.myLog(val);

			System.out.printf("log(%f)=%f%n", val, result);
		}
		catch (MyException ex) {
			System.out.println("My Excepion yakalandı");
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class MathUtil {
	public static double myLog(double val)
	{
		if (val < 0)
			throw new MyException();

		if (val == 0)
			throw new YourException();

		return Math.log(val);
	}
}


class MyException extends RuntimeException {
	//...
}

class YourException extends MyException {
	//...
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Türemiş sınıf exception parametreli catch bloğu taban sınıf parametreli catch bloğundan sonra yazılamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);

		System.out.print("Bir sayı giriniz:");
		double val = Double.parseDouble(kb.nextLine());

		try {
			double result = MathUtil.myLog(val);

			System.out.printf("log(%f)=%f%n", val, result);
		}
		catch (MyException ex) {
			System.out.println("My Exception yakalandı");
		}
		catch (YourException ex) { //error
			System.out.println("Your Exception yakalandı");
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class MathUtil {
	public static double myLog(double val)
	{
		if (val < 0)
			throw new MyException();

		if (val == 0)
			throw new YourException();

		return Math.log(val);
	}
}


class MyException extends RuntimeException {
	//...
}

class YourException extends MyException {
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Türemiş sınıf exception parametreli catch bloğu taban sınıf parametreli catch bloğundan önce yazılmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
    public static void main(String [] args)
    {
        Scanner kb = new Scanner(System.in);

        System.out.print("Bir sayı giriniz:");
        double val = Double.parseDouble(kb.nextLine());

        try {
            double result = MathUtil.myLog(val);

            System.out.printf("log(%f)=%f%n", val, result);
        }
        catch (YourException ex) {
            System.out.println("Your Exception yakalandı");
        }
        catch (MyException ex) {
            System.out.println("My Exception yakalandı");
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}

class MathUtil {
    public static double myLog(double val)
    {
        if (val < 0)
            throw new MyException();

        if (val == 0)
            throw new YourException();


        return Math.log(val);
    }
}


class MyException extends RuntimeException {
    //...
}

class YourException extends MyException {
    //...
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir kod paraçasının try bloğu içerisine alınması o kod parçasının fırlattığı exception'ın yakalanacağı
    anlamına gelmez. Fırlatma işleminden sonra uygun catch bloğunun bulunması gerekir. Aksi durumda akış sonlanır.
    Bu durumda aslında akış hemen sonlanmaz. Detaylar ileride ele alınacaktır. Aşağıdaki örnekte parseDouble metodunun
    fırlattığı exception nesnesini yakalayabilecek bir catch bloğu bulunamadığından akış sonlanır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		try {
			Scanner kb = new Scanner(System.in);

			System.out.print("Bir sayı giriniz:");
			double val = Double.parseDouble(kb.nextLine());
			double result = MathUtil.myLog(val);

			System.out.printf("log(%f)=%f%n", val, result);
		}
		catch (YourException ex) {
			System.out.println("Your Exception yakalandı");
		}
		catch (MyException ex) {
			System.out.println("My Exception yakalandı");
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class MathUtil {
	public static double myLog(double val)
	{
		if (val < 0)
			throw new MyException();

		if (val == 0)
			throw new YourException();

		return Math.log(val);
	}
}


class MyException extends RuntimeException {
	//...
}

class YourException extends MyException {
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Throwable parametreli catch bloğu tüm fırlatılan exception nesnelerini yakalayabilir. Şüphesiz Throwable parametreli
    catch bloğunun tüm catch bloklarından sonra yazılması gerekir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		try {
			Scanner kb = new Scanner(System.in);

			System.out.print("Bir sayı giriniz:");
			double val = Double.parseDouble(kb.nextLine());
			double result = MathUtil.myLog(val);

			System.out.printf("log(%f)=%f%n", val, result);
		}
		catch (YourException ex) {
			System.out.println("Your Exception yakalandı");
		}
		catch (MyException ex) {
			System.out.println("My Exception yakalandı");
		}
		catch (Throwable ex) {
			System.out.println("Exception yakalandı");
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class MathUtil {
	public static double myLog(double val)
	{
		if (val < 0)
			throw new MyException();

		if (val == 0)
			throw new YourException();


		return Math.log(val);
	}
}


class MyException extends RuntimeException {
	//...
}

class YourException extends MyException {
	//...
}

```
```java

/*----------------------------------------------------------------------------------------------------------------------
    Bir try bloğu içerisinde bir exception yakalanamaz ise o try bloğunu kapsayan try bloğunun catch bloklarına
    bakılır. Bu işlem uygun catch bloğu bulununcaya veya bulunamayıncaya kadar devam eder. Bulunursa uygun catch bloğu
    çalıştırılır bulunamazsa akış sonlanır. Eğer bir exception try bloğu içerisinde yakalanmışsa kapsayan try bloklarının
    catch bloklarına bakılmaz. Aşağıdaki örneği çeşitli girdiler ile test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		try {
			Sample.foo();
			System.out.println("main:try sonu");
		}
		catch (YourException ex) {
			System.out.println("main:Your Exception yakalandı");
		}
		catch (MyException ex) {
			System.out.println("main:My Exception yakalandı");
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class Sample {
	public static void foo()
	{
		try {
			Scanner kb = new Scanner(System.in);

			System.out.print("Bir sayı giriniz:");
			double val = Double.parseDouble(kb.nextLine());
			double result = MathUtil.myLog(val);

			System.out.printf("log(%f)=%f%n", val, result);
		}
		catch (MyException ex) {
			System.out.println("foo:My Exception yakalandı");
		}

		System.out.println("foo sonu");
	}
}

class MathUtil {
	public static double myLog(double val)
	{
		if (val < 0)
			throw new MyException();

		if (val == 0)
			throw new YourException();

		return Math.log(val);
	}
}


class MyException extends RuntimeException {
	//...
}

class YourException extends RuntimeException {
	//...
}

/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/
```
