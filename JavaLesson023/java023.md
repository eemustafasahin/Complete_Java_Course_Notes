### "rethrow" işlemi
```java
/*----------------------------------------------------------------------------------------------------------------------
    17.10.2020
    Aşağıdaki örnekte foo metodu MyException fırlatıldığında onu yakalamış ve aynı nesneyi yeniden fırlatmıştır.
    Bu işleme "rethow" denir.

    Aşağıdaki örnekte foo metodu müşteri kodları açısından MyException fırlatmış olur. Bu foo için oluşturulacak
    dökümanda yazılır. foo metodunu yazan açısından ise Myexception hem ilgili try bloğunda işlenmiş hem de aynı exception
    nesnesi müşteri koda fırlatılmış olur
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
		catch (Throwable ex) {
			System.out.println("main:Throwable yakalandı");
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
			throw ex; //rethrow
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
```
### finally bloğu try bloğundan nasıl çıkılırsa çıkılsın çalıştırılacak bloktur.
```java
/*----------------------------------------------------------------------------------------------------------------------
    finally bloğu try bloğundan nasıl çıkılırsa çıkılsın çalıştırılacak bloktur. finally bloğu try bloğunda catch
    blokları ile birlikte olacaksa tüm catch bloklarının sonunda olmalıdır
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
		finally {
			System.out.println("main:finally");
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
		finally {
			System.out.println("foo:finally");
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
```
### finally bloğu try bloğundan nasıl çıkılırsa çıkılsın çalıştırılacak bloktur. (2)
```java
/*----------------------------------------------------------------------------------------------------------------------
    finally bloğu try bloğundan nasıl çıkılırsa çıkılsın çalıştırılacak bloktur. finally bloğu try bloğunda catch
    blokları ile birlikte olacaksa tüm catch bloklarının sonunda olmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		try {
			double result = Sample.foo();

			System.out.printf("result:%f%n", result);
		}
		catch (YourException ex) {
			System.out.println("main:Your Exception yakalandı");
		}
		catch (MyException ex) {
			System.out.println("main:My Exception yakalandı");
		}
		finally {
			System.out.println("main:finally");
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class Sample {
	public static double foo()
	{
		try {
			Scanner kb = new Scanner(System.in);

			System.out.print("Bir sayı giriniz:");
			double val = Double.parseDouble(kb.nextLine());
			double result = MathUtil.myLog(val);

			return result;
		}
		catch (MyException ex) {
			System.out.println("foo:My Exception yakalandı");
			throw ex;
		}
		finally {
			System.out.println("foo:finally");
		}
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
### try-finally yani catch bloksuz bir try bloğu ile exception nesnesi yakalanmadan kod yazılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    try-finally yani catch bloksuz bir try bloğu ile exception nesnesi yakalanmadan ve aynı zamanda exception
    oluşsa da oluşmasa da yapılacak bir işleme yönelik kod yazılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		try {
			double result = Sample.foo();

			System.out.printf("result:%f%n", result);

		}
		catch (YourException ex) {
			System.out.println("main:Your Exception yakalandı");
		}
		catch (MyException ex) {
			System.out.println("main:My Exception yakalandı");
		}
		catch (NumberFormatException ex) {
			System.out.println("main:NumberFormatException yakalandı");
		}
		finally {
			System.out.println("main:finally");
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class Sample {
	public static double foo()
	{
		try {
			Scanner kb = new Scanner(System.in);

			System.out.print("Bir sayı giriniz:");
			double val = Double.parseDouble(kb.nextLine());
			double result = MathUtil.myLog(val);
			//...
			return result;
		}
		finally {
			System.out.println("foo:finally");
		}
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
### Aşağıdaki örnekte return edilmeden önce try yazısı ekleneceğinden çıktı exceptiontryfinally biçiminde olur.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte return edilmeden önce try yazısı ekleneceğinden çıktı exceptiontryfinally biçiminde olur.
    Aşağıdaki örnete durumun anlaşılması için MutableString sınıfı yazılmıştır. Sınıf daha iyi yazılabilir. Burada
    bu durum gözardı edilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		System.out.println(Sample.foo("exception")); //exceptiontryfinally
	}
}


class Sample {
	public static MutableString foo(String str)
	{
		MutableString mutableString = new MutableString(str);

		try {
			return mutableString.append("try");
		}
		finally {
			mutableString.append("finally");
		}
	}
}

class MutableString {
	private String m_str;

	public MutableString(String str)
	{
		this.setStr(str);
	}

	public void setStr(String str)
	{
		//...
		m_str = str;
	}

	public MutableString append(String str)
	{
		m_str += str;

		return this;
	}

	//...

	public String toString()
	{
		return m_str;
	}
}
```
### Aşağıdaki örneği inceleyiniz (finally örneği)
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		System.out.println(Sample.foo("exception")); //exceptiontry
	}
}


class Sample {
	public static String foo(String str)
	{
		MutableString mutableString = new MutableString(str);

		try {
			return mutableString.append("try").toString();
		}
		finally {
			mutableString.append("finally");
			System.out.printf("In foo:%s%n", mutableString);
		}
	}
}

class MutableString {
	private String m_str;

	public MutableString(String str)
	{
		this.setStr(str);
	}

	public void setStr(String str)
	{
		//...
		m_str = str;
	}

	public MutableString append(String str)
	{
		m_str += str;

		return this;
	}

	//...

	public String toString()
	{
		return m_str;
	}
}
```
### Aşağıdaki örneği inceleyiniz (finally örneği (2))
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		System.out.println(Sample.foo("exception")); //exceptiontry
	}
}


class Sample {
	public static String foo(String str)
	{
		try {
			str += "try";

			return str;
		}
		finally {
			str += "finally";
			System.out.printf("In foo:%s%n", str);
		}
	}
}
```
### Exception sınıfları içerisinde tutulan elemanlar ile bilgi taşınabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Exception sınıfları içerisinde tutulan elemanlar ile bilgi taşınabilir
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
		catch (MyException ex) {
			System.out.printf("Exception message:%s%n", ex.getMessage());
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class MathUtil {
	public static double myLog(double val)
	{
		if (val < 0)
			throw new MyException("val can not be negative");

		if (val == 0)
			throw new MyException("val can not be zero");


		return Math.log(val);
	}
}


class MyException extends RuntimeException {
	private final String m_message;

	public MyException(String message)
	{
		m_message = message;
	}

	public String getMessage() {return m_message;}
}
```
### Throwable sınıfı içerisinde exception işlemlerine yönelik veri elemanları
```java
/*----------------------------------------------------------------------------------------------------------------------
    Throwable sınıfı içerisinde exception işlemlerine yönelik bir takım veri elemanları bulunmaktadır. Bunlardan en temel
    olanı mesaja karşılık gelen elemandır. Throwable sınıfından türetilmiş olan sınıflar yani exception sınıfları genel
    olarak String parametreli ctor elemanını yazarlar böylelikle hiyararşik olarak mesaj elemanı Throwable sınıfına
    aktarılmış olur. İsterse programcı başka bilgileri de yazdığı exception sınıfına ekleyebilir. Throwable sınıfının
    getMessage metodu ile mesaj bilgisi elde edilebilir
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
		catch (MyException ex) {
			System.out.printf("Exception message:%s, Error Status:%s%n", ex.getMessage(), ex.getErrorStatus());

			if (ex.getErrorStatus() == MyExceptionStatus.NEGATIVE)
				System.out.println("Negatif değer kabul edilemez");
			else
				System.out.println("Sıfır değeri kabul edilemez");
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class MathUtil {
	public static double myLog(double val)
	{
		if (val < 0)
			throw new MyException("val can not be negative", MyExceptionStatus.NEGATIVE);

		if (val == 0)
			throw new MyException("val can not be zero", MyExceptionStatus.ZERO);


		return Math.log(val);
	}
}

enum MyExceptionStatus {ZERO, NEGATIVE}

class MyException extends RuntimeException {
	private final MyExceptionStatus m_errorStatus;

	public MyException(String message, MyExceptionStatus errorStatus)
	{
		super(message);
		m_errorStatus = errorStatus;
	}

	public MyExceptionStatus getErrorStatus()
	{
		return m_errorStatus;
	}
}
```
### getMessage metodu override edilebilir. 
```java
/*----------------------------------------------------------------------------------------------------------------------
    getMessage metodu override edilebilir. Böylelikle programcı kendi exception sınıfına özel getMessage yazabilir.
    Aşağıdaki örnekte çok biçimli olarak MyException sınıfının getMessage metodu çağrılır
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
		catch (Throwable ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class MathUtil {
	public static double myLog(double val)
	{
		if (val < 0)
			throw new MyException("val can not be negative", MyExceptionStatus.NEGATIVE);

		if (val == 0)
			throw new MyException("val can not be zero", MyExceptionStatus.ZERO);


		return Math.log(val);
	}
}

enum MyExceptionStatus {ZERO, NEGATIVE}

class MyException extends RuntimeException {
	private final MyExceptionStatus m_errorStatus;

	public MyException(String message, MyExceptionStatus errorStatus)
	{
		super(message);
		m_errorStatus = errorStatus;
	}

	public MyExceptionStatus getErrorStatus()
	{
		return m_errorStatus;
	}

	public String getMessage()
	{
		return String.format("Message:%s, Error Status:%s", super.getMessage(), m_errorStatus);
	}
}
```
### Throwable sınıfının parametresiz printStackTrace metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    Throwable sınıfının parametresiz printStackTrace metodu exception fırlatılması noktalarını bir stack biçiminde
    gösteren detaylı mesajı ekrana basar. Bu metotta basılan yazı akış exception yakalanmadığından dolayı sonlandığında da
    basılan yazı ile neredeyse aynıdır
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
		catch (Throwable ex) {
			ex.printStackTrace();
		}
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class MathUtil {
	public static double myLog(double val)
	{
		if (val < 0)
			throw new MyException("val can not be negative", ErrorStatus.NEGATIVE);

		if (val == 0)
			throw new MyException("val can not be zero", ErrorStatus.ZERO);


		return Math.log(val);
	}
}

enum ErrorStatus {ZERO, NEGATIVE}

class MyException extends RuntimeException {
	private final ErrorStatus m_errorStatus;
	public MyException(String message, ErrorStatus errorStatus)
	{
		super(message);
		m_errorStatus = errorStatus;
	}

	public ErrorStatus getErrorStatus()
	{
		return m_errorStatus;
	}

	public String getMessage()
	{
		return String.format("Message:%s, Error Status:%s", super.getMessage(), m_errorStatus);
	}
}
```
### Throwable sınıfı içerisinde Throwable türünden bir referans tutulur. **
```java
/*----------------------------------------------------------------------------------------------------------------------
    Throwable sınıfı içerisinde Throwable türünden bir referans tutulur. Bu referans bir exception sınıfı içerisinde
    başka bir exception referansının tutulabilmesine olanak sağlar. getCause metodu ile içsel olarak tutulan referans
    elde edilebilir. Ayrıca Throwable sınıfının Throwble parametresi de alan ctor elemanı ile bu bilgi nesneye verilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		try {
			System.out.println(Sample.foo());
		}
		catch (WrapperException ex) {
			System.out.println(ex.getMessage());
			Throwable cause = ex.getCause();

			if (cause instanceof NumberFormatException)
				System.out.printf("Cause Message:%s%n", cause.getMessage());
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class Sample {
	public static double foo()
	{
		try {
			Scanner kb = new Scanner(System.in);

			System.out.print("Bir sayı giriniz:");
			double val = Double.parseDouble(kb.nextLine());
			double result = MathUtil.myLog(val);

			return result;
		}
		catch (Throwable ex) {
			//...
			throw new WrapperException("foo exception", ex);
		}
	}
}

class MathUtil {
	public static double myLog(double val)
	{
		if (val < 0)
			throw new WrapperException("val < 0", new MyException("val can not be negative", ErrorStatus.NEGATIVE));

		if (val == 0)
			throw new WrapperException("val can not be zero");

		return Math.log(val);
	}
}

class WrapperException extends RuntimeException {
	public WrapperException(String message)
	{
		super(message);
	}

	public WrapperException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public String getMessage()
	{
		Throwable cause =  getCause();

		return String.format("Message:%s%s",
				super.getMessage(), cause != null ? ", Cause Message:" + cause.getMessage() : "");
	}
}

enum ErrorStatus {ZERO, NEGATIVE}

class MyException extends RuntimeException {
	private final ErrorStatus m_errorStatus;
	public MyException(String message, ErrorStatus errorStatus)
	{
		super(message);
		m_errorStatus = errorStatus;
	}

	public ErrorStatus getErrorStatus()
	{
		return m_errorStatus;
	}

	public String getMessage()
	{
		return String.format("Message:%s, Error Status:%s", super.getMessage(), m_errorStatus);
	}
}

```
###  Console sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
    Console sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
	public static void main(String [] args)
	{
		int a = Console.readInt("Birinci sayıyı giriniz:", "Hatalı giriş yaptınız:");
		int b = Console.readInt("İkinci  sayıyı giriniz:", "Hatalı giriş yaptınız:");

		System.out.printf("%d + %d = %d%n", a, b, a + b);
	}
}
```
### Console sınıfı ve test kodu (2)
```java
/*----------------------------------------------------------------------------------------------------------------------
    Console sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
	public static void main(String [] args)
	{
		double a = Console.readDouble("Birinci sayıyı giriniz:", "Hatalı giriş yaptınız:");
		double b = Console.readDouble("İkinci  sayıyı giriniz:", "Hatalı giriş yaptınız:");

		System.out.printf("%f + %f = %f%n", a, b, a + b);
	}
}

```
### Console sınıfı ve test kodu (3)
```java
/*----------------------------------------------------------------------------------------------------------------------
    Console sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
	public static void main(String [] args)
	{
		int a = Console.readIntLine("Birinci sayıyı giriniz:", "Hatalı giriş yaptınız:");
		int b = Console.readIntLine("İkinci  sayıyı giriniz:", "Hatalı giriş yaptınız:");

		System.out.printf("%d + %d = %d%n", a, b, a + b);
	}
}

```
###  Console sınıfı ve test kodu (4)
```java
/*----------------------------------------------------------------------------------------------------------------------
    Console sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
	public static void main(String [] args)
	{
		int a = Console.readInt("Birinci sayıyı giriniz:");
		int b = Console.readInt("İkinci  sayıyı giriniz:");

		System.out.printf("%d + %d = %d%n", a, b, a + b);
	}
}
```
###  Console sınıfı ve test kodu (5)
```java
/*----------------------------------------------------------------------------------------------------------------------
    Console sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
	public static void main(String [] args)
	{
		int a = Console.readInt("Birinci sayıyı giriniz:");
		int b = Console.readInt("İkinci  sayıyı giriniz:");

		Console.writeLine("%d + %d = %d", a, b, a + b);
		Console.writeLine("Tekrar yapıyor musunuz?");
	}
}
```
###  Console sınıfı 
```java
/*----------------------------------------------------------------------------------------------------------------------
	Console sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Scanner;

public final class Console {
    private static final Scanner KB;

    static {
        KB = new Scanner(System.in);
    }

    private Console()
    {
    }

    public static int readIntLine(String message)
    {
        return readInt(message + "\n");
    }

    public static int readIntLine(String message, String errorMessage)
    {
        return readInt(message + "\n", errorMessage + "\n");
    }

    public static int readInt()
    {
        return readInt("");
    }

    public static int readInt(String message)
    {
        return readInt(message, "");
    }

    public static int readInt(String message, String errorMessage)
    {
        for (;;) {
            try {
                System.out.print(message);

                return Integer.parseInt(KB.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print(errorMessage);
            }
        }
    }

    public static double readDoubleLine(String message)
    {
        return readDouble(message + "\n");
    }

    public static double readDoubleLine(String message, String errorMessage)
    {
        return readDouble(message + "\n", errorMessage + "\n");
    }

    public static double readDouble()
    {
        return readDouble("");
    }

    public static double readDouble(String message)
    {
        return readDouble(message, "");
    }

    public static double readDouble(String message, String errorMessage)
    {
        for (;;) {
            try {
                System.out.print(message);

                return Double.parseDouble(KB.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print(errorMessage);
            }
        }
    }

    //...
    public static void writeLine(String format, Object...objects)
    {
        System.out.printf(format + "\n", objects);
    }
    //...
}
```
### Java'da exception sınıfları kategori olarak iki gruba ayrılır: checked, unchecked
```java
/*----------------------------------------------------------------------------------------------------------------------
    Java'da exception sınıfları kategori olarak iki gruba ayrılır: checked, unchecked
    unchecked exception sınıfları: Bir exception sınıfının türetme hiyararşisi içerisinde Error veya RuntimeException sınıfı
    varsa unchecked exception sınıfıdır.

    checked exception sınıfları: unchecked olmayan exception sınıflarıdır

    Anahtar Notlar: Bir exception sınıfının unchecked veya checked olmasının çalışma zamanı açısından bir önemi yoktur.
    Yani tüm exception sınıfları için exception mekanizmasının çalışma zamanı sırasında aynıdır. Bir exception
    sınıfının checked olması derleme zamanında bir takım özellikleri (detayları) beraberinde getirir.

    Anahtar Notlar: Exception sınıflarının yazımında geleneksel olarak Throwable sınıfından doğrudan türetme yapılmaz

    Anahtar Notlar: Türetme kavramı dolayısıyla bir exception sınıfından türetilen bir başka exception sınıfı
    kategori olarak taban sınıfı ile aynıdır. Yani taban sınıfı checked ise kendisi de checked bir exception
    sınıfı olur
----------------------------------------------------------------------------------------------------------------------*/
```
### Checked ve unchecked exception sınıfları
```java
/*----------------------------------------------------------------------------------------------------------------------
    Checked ve unchecked exception sınıfları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

class MyException extends Throwable { //checked

}

class YourException extends Error { //unchecked

}

class OurException extends Exception { //checked

}

class TheirException extends RuntimeException { //unchecked

}

class HisException extends TheirException { //unchecked

}

class HerException extends OurException { //checked

}
```
### checked bir exception throw edilen metodun içerisinde eğer exception ele alınmayacaksa (handle) throws bildirimi yapılmalıdır.
```java
/*----------------------------------------------------------------------------------------------------------------------
    checked bir exception throw edilen metodun içerisinde eğer exception ele alınmayacaksa (handle) throws bildirimi
    yapılmalıdır. Aksi durumda error oluşur. Aşağıdaki kodu inceleyiniz
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
		catch (MyException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class MathUtil {
	public static double myLog(double val) throws MyException
	{
		if (val < 0)
			throw new MyException("val can not be negative");

		if (val == 0)
			throw new MyException("val can not be zero");

		return Math.log(val);
	}
}

class MyException extends Exception {
	public MyException(String message)
	{
		super(message);
	}
}
```
### checked bir exception throw edilen metodun içerisinde eğer exception ele alınmayacaksa (handle) throws bildirimi yapılmalıdır (2)
```java
/*----------------------------------------------------------------------------------------------------------------------
    checked bir exception throw edilen metodun içerisinde eğer exception ele alınmayacaksa throws bildirimi
    yapılmalıdır. Aksi durumda error oluşur
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
        catch (MyException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Tekrar yapıyor musunuz?");
    }
}

class MathUtil {
    public static double myLog(double val)
    {
        if (val < 0)
            throw new MyException("val can not be negative"); //error

        if (val == 0)
            throw new MyException("val can not be zero"); //error

        return Math.log(val);
    }
}

class MyException extends Exception {
    public MyException(String message)
    {
        super(message);
    }
}

```
### Birden fazla checked exception fırlatılması durumunda exception sınıfları arasında doğrudan ya da dolaylı olarak türetme ilişkisi yoksa hepsi birden throws listesine yazılmalıdır.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Birden fazla checked exception fırlatılması durumunda exception sınıfları arasında doğrudan ya da dolaylı olarak
    türetme ilişkisi yoksa hepsi birden throws listesine yazılmalıdır.
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
		catch (Throwable ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class MathUtil {
	public static double myLog(double val) throws MyException, YourException
	{
		if (val < 0)
			throw new MyException("val can not be negative");

		if (val == 0)
			throw new YourException("val can not be zero");

		return Math.log(val);
	}
}

class MyException extends Exception {
	public MyException(String message)
	{
		super(message);
	}
}

class YourException extends Exception {
	public YourException(String message)
	{
		super(message);
	}
}
```
### checked exception fırlatma ihtimali olan bir akışın throws bildirimi yapılmayacaksa try bloğu içerisinde olması ve fırlatma ihtimali olan checked exception'ları yakalayabilecek catch bloklarının varolması zorunludur
```java
/*----------------------------------------------------------------------------------------------------------------------
    checked exception fırlatma ihtimali olan bir akışın throws bildirimi yapılmayacaksa try bloğu içerisinde
    olması ve fırlatma ihtimali olan checked exception'ları yakalayabilecek catch bloklarının varolması zorunludur
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
			double result = MathUtil.myLog(val); //error

			System.out.printf("log(%f)=%f%n", val, result);
		}
		catch (MyException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class MathUtil {
	public static double myLog(double val) throws MyException, YourException
	{
		if (val < 0)
			throw new MyException("val can not be negative");

		if (val == 0)
			throw new YourException("val can not be zero");

		return Math.log(val);
	}
}

class MyException extends Exception {
	public MyException(String message)
	{
		super(message);
	}
}

class YourException extends Exception {
	public YourException(String message)
	{
		super(message);
	}
}
```
### checked exception sınıfı türünden parametreli bir catch bloğunun ait olduğu try bloğunda o checked exception türüne ilişkin nesneyi fırlatabilecek bir akış bulunmalıdır
```java
/*----------------------------------------------------------------------------------------------------------------------
    checked exception sınıfı türünden parametreli bir catch bloğunun ait olduğu try bloğunda o checked exception
    türüne ilişkin nesneyi fırlatabilecek bir akış bulunmalıdır
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
			double result = Math.log(val);

			System.out.printf("log(%f)=%f%n", val, result);
		}
		catch (MyException ex) { //error
			System.out.println(ex.getMessage());
		}
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class MyException extends Exception {
	public MyException(String message)
	{
		super(message);
	}
}
```
### Yukarıdaki kural Exception ve Throwable sınıfları için geçerli değildir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki kural Exception ve Throwable sınıfları için geçerli değildir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		try {
			//...
		}
		catch (Exception ex) {
			//...
		}
		catch (Throwable ex) {
			//...
		}
	}
}
```
### Bir metodun fırlatabileceği checked exception sınıfları arasında türetme ilişkisi varsa throws listesine istenirse yalnızca taban sınıf yazılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir metodun fırlatabileceği checked exception sınıfları arasında türetme ilişkisi varsa throws listesine
    istenirse yalnızca taban sınıf yazılabilir
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
			double result = Math.log(val);

			System.out.printf("log(%f)=%f%n", val, result);
		}
		catch (Throwable ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class MathUtil {
	public static double myLog(double val) throws MyException
	{
		if (val < 0)
			throw new MyException("val can not be negative");

		if (val == 0)
			throw new YourException("val can not be zero");


		return Math.log(val);
	}
}

class MyException extends Exception {
	public MyException(String message)
	{
		super(message);
	}
}

class YourException extends MyException {
	public YourException(String message)
	{
		super(message);
	}
}
```
### throws bildirimi olan bir metodun override edilmesi durumunda override edilen metotta throws listesinde olan exception sınıfları kaldırılabilir. Yani örneğin, hiç throws listesi de yazılmayabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
    throws bildirimi olan bir metodun override edilmesi durumunda override edilen metotta throws listesinde
    olan exception sınıfları kaldırılabilir. Yani örneğin, hiç throws listesi de yazılmayabilir. throws listesi
    override edilen metotta olacaksa throws listesindeki sınıflar ya taban sınıfın metoduyla aynı olan veya ondan türemiş
    sınıflar türünden olmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

class E extends A {
	public void foo() throws TheirException //error
	{
		//...
	}
}

class D extends A {
	public void foo() throws OurException
	{

	}
}

class C extends A {
	public void foo() throws MyException
	{
		//...
	}
}

class B extends A {
	public void foo()
	{
		//...
	}
}

abstract class A {
	//...
	public abstract void foo() throws MyException, YourException;
}

class MyException extends Exception {

}

class OurException extends MyException {

}

class YourException extends Exception {

}

class TheirException extends Exception {

}
```
### Yukarıdaki problemden dolayı programcı aşağıdaki gibi kodda yöntemini değiştirmelidir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki problemden dolayı programcı aşağıdaki gibi kodda yöntemini değiştirmelidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

class Sample {
	public static void bar() throws YourException
	{
		//...
	}
}
class B extends A {
	public void foo() throws YourException //error
	{
		Sample.bar();
	}
}

abstract class A {
	public abstract void foo() throws MyException;
}


class MyException extends Exception {

}
class YourException extends Exception {

}
```
### Yukarıdaki problem aşağıdaki gibi çözülebilir. Aşağıdaki kodda unchecked exception içerisine checked bir exceptiom referansı (cause) verilmiştir.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki problem aşağıdaki gibi çözülebilir. Aşağıdaki kodda unchecked exception içerisine checked bir exceptiom
    referansı (cause) verilmiştir. Bu durumda yukarıdaki hata oluşmaz. Bu çözüm override ettiğimiz metoda ilişkin
    sınıfı bizim tasarlamadığımız durumlarda daha çok karşımıza çıkar
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

class Sample {
	public static void bar() throws YourException
	{
		//...
	}
}

class B extends A {
	public void foo()
	{
		try {
			Sample.bar();
		}
		catch (YourException ex) {
			throw new WrapperException("wrapper", ex);
		}
	}
}

class WrapperException extends RuntimeException {
	public WrapperException(String message)
	{
		super(message);
	}
	public WrapperException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public String getMessage()
	{
		Throwable cause =  getCause();
		return String.format("Message:%s%s",
				super.getMessage(), cause != null ? ", Cause Message:" + cause.getMessage() : "");
	}
}

abstract class A {
	public abstract void foo() throws MyException;
}

class MyException extends Exception {

}

class YourException extends Exception {

}
```
### Yukarıdaki problem abstract metodun çok genel bir kullanımı olabilecekse aşağıdaki gibi abstract metodun bildirimine throws Exception eklenerek çözülebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki problem abstract metodun çok genel bir kullanımı olabilecekse aşağıdaki gibi abstract metodun
    bildirimine throws Exception eklenerek çözülebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

class Sample {
	public static void bar() throws YourException
	{
		//...
	}
}

class B extends A {
	public void foo() throws YourException
	{
		Sample.bar();
	}
}

abstract class A {
	public abstract void foo() throws Exception;
}

class MyException extends Exception {

}

class YourException extends Exception {

}
```
### NumberFormatException sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
    NumberFormatException sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
    public static void main(String [] args)
    {
        Scanner kb = new Scanner(System.in);

        try {
            System.out.print("Bir sayı giriniz:");
            int val = Integer.parseInt(kb.nextLine());

            System.out.println(val * val);
        }
        catch (NumberFormatException ex) {
            System.out.printf("Message:%s%n", ex.getMessage());
            System.out.println("Geçersiz formatta sayı girdiniz");
        }
    }
}
```
### ClassCastException sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
    ClassCastException sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A x = new A();

        B y = (B)x;

        System.out.println("Tekrar yapıyor musunuz?");
    }
}

class A {

}

class B extends A {

}
```
### ClassCastException sınıfı aşağıdaki gibi try-catch ile kullanılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    ClassCastException sınıfı aşağıdaki gibi try-catch ile kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
	public static void main(String [] args)
	{
		try {
			int val = Console.readInt("Bir sayı giriniz:");
			A x = val > 0 ? new B() : new A();
			B y = (B) x;

			System.out.println("Tekrar yapıyor musunuz?");
		}
		catch (ClassCastException ex) {
			System.out.println("Haksız dönüşüm");
		}
	}
}

class A {

}

class B extends A {

}
```
### Yukarıdaki örnek instanceof operatörü ile de yapılabilir. Bu şekilde kullanım daha çok tercih edilmelidir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki örnek instanceof operatörü ile de yapılabilir. Bu şekilde kullanım daha çok tercih edilmelidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
	public static void main(String [] args)
	{
		int val = Console.readInt("Bir sayı giriniz:");
		A x = val > 0 ? new B() : new A();

		if (x instanceof B) {
			B y = (B) x;
			//...
			System.out.println("Tekrar yapıyor musunuz?");
		}
		else
			System.out.println("Haksız dönüşüm");
	}
}

class A {

}

class B extends A {

}
```
### NullPointerException sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
    NullPointerException sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample s = null;

        s.foo();
    }
}

class Sample {
    public void foo()
    {
        //...
    }
}
```
### Aşağıdaki örnekte getRandomArray metodunun döndürdüğü referansın null olması durumunda NullPointerException nesnesi fırlatılır.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte getRandomArray metodunun döndürdüğü referansın null olması durumunda NullPointerException
    nesnesi fırlatılır. NullPointerException nesnesinin try-catch bloğu ile işlenmesi genel olarak tercih edilmez.
    Akışın bu exception fırlatılması noktasına gelmesi engellenir. Hatta gerekirse başka bir exception fırlatılabilir.
    Örnekte ** ile belirtilen kodu kaldırarak test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Random;
import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		Random r = new Random();

		for (int i = 0; i < 5; ++i) {
			System.out.print("Eleman sayısını giriniz:");
			int n = Integer.parseInt(kb.nextLine());

			System.out.print("Minimum değeri giriniz:");
			int min = Integer.parseInt(kb.nextLine());

			System.out.print("Maximun değeri giriniz:");
			int max = Integer.parseInt(kb.nextLine());

			int [] a = Util.getRandomArray(r, n, min, max);

			if (a == null) continue; //**

			for (int val : a)
				System.out.printf("%d ", val);

			System.out.println("\n//////////////");
		}
	}
}

class Util {
	//...
	public static int [] getRandomArray(Random r, int n, int min, int max)
	{
		if (r == null || n <= 0|| min >= max)
			return null;

		int [] a = new int[n];

		for (int i = 0; i < n; ++i)
			a[i] = r.nextInt(max - min) + min;

		return a;
	}
}

class Sample {
	public void foo()
	{
		//...
	}
}
```
### IllegalArgumentException sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
    IllegalArgumentException sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Random;
import java.util.Scanner;

class App {
    public static void main(String [] args)
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("min?");
        int min = Integer.parseInt(kb.nextLine());

        System.out.print("max?");
        int max = Integer.parseInt(kb.nextLine());

        try {
            Random r = new Random();

            for (int i = 0; i < 10; ++i)
                System.out.printf("%d ", RandomUtil.nextInt(r, min, max));

            System.out.println();
        }
        catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class RandomUtil {
    public static int nextInt(Random r, int min, int max)
    {
        if (r == null)
            throw new IllegalArgumentException("r can not be null value");

        if (min >= max)
            throw new IllegalArgumentException(String.format("min must be less than max:min=%d, max=%d", min, max));

        return r.nextInt(max - min) + min;
    }
}
```
### IndexOutOfBoundsException sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
    IndexOutOfBoundsException sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("n?");
		int n = Integer.parseInt(kb.nextLine());

		System.out.print("start?");
		int start = Integer.parseInt(kb.nextLine());

		System.out.print("end?");
		int end = Integer.parseInt(kb.nextLine());

		int [] a = ArrayUtil.getRandomArray(n, 0, 100);

		ArrayUtil.display(2, a);
		ArrayUtil.display(2, Util.getSubArray(a, start, end));
	}
}

class Util {
	public static int [] getSubArray(int []a, int start, int end) //[start, end)
	{
		if (a == null)
			throw new IllegalArgumentException("a can not be null");

		if (start < 0 || end < 0 || start >= end || start >= a.length || end > a.length)
			throw new IndexOutOfBoundsException(String.format("Invalid bounds:start=%d, end=%d", start, end));

		int [] res = new int[end - start];

		for (int i = start; i < end; ++i)
			res[i - start] = a[i];

		return res;
	}
}
```
### ArrayIndexOutOfBoundsException sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
    ArrayIndexOutOfBoundsException sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("n?");
		int n = Integer.parseInt(kb.nextLine());

		System.out.print("start?");
		int start = Integer.parseInt(kb.nextLine());

		System.out.print("end?");
		int end = Integer.parseInt(kb.nextLine());

		int [] a = ArrayUtil.getRandomArray(n, 0, 100);

		ArrayUtil.display(2, a);
		ArrayUtil.display(2, Util.getSubArray(a, start, end));
	}
}

class Util {
	public static int [] getSubArray(int []a, int start, int end) //[start, end)
	{
		if (a == null)
			throw new IllegalArgumentException("a can not be null");

		if (start < 0 || end < 0 || start >= end || start >= a.length || end > a.length)
			throw new ArrayIndexOutOfBoundsException(String.format("Invalid bounds:start=%d, end=%d", start, end));

		int [] res = new int[end - start];

		for (int i = start; i < end; ++i)
			res[i - start] = a[i];

		return res;
	}
}
```
### UnsupportedOperationException sınıfı.
```java
/*----------------------------------------------------------------------------------------------------------------------
    UnsupportedOperationException sınıfı. Bu sınıf aşağıdaki gibi desteklenmeyen metotların boş bırakılması ya da
    geri dönüş değeri varsa anlamsız return deyimi yazmak yerine tercih edilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		A x = new B();

		x.foo();
		//x.bar();
	}
}

class B extends A {
	public void foo()
	{
		//...
	}

	public int bar()
	{
		throw new UnsupportedOperationException("bar not supported in B");
	}
}

abstract class A {
	//...
	public abstract void foo();
	public abstract int bar();
}
```
### Java 7 ile birlikte birden fazla exception için ortak bir iş yapılacaksa | atomu kullanılarak catch bloğu yazılabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
    18.10.2020
    Java 7 ile birlikte birden fazla exception için ortak bir iş yapılacaksa | atomu kullanılarak catch bloğu
    yazılabilir. Bu catch bloğu içerisinde iki sınıfın da ancak ortak elemanları kullanılablir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		try {
			double result = Sample.foo();

			System.out.printf("result:%f%n", result);
		}
		catch (MyException | YourException ex) { //Since Java 7
			System.out.println("ortak iş");
			System.out.println(ex.getMessage());
		}
		catch (NumberFormatException ex) {
			System.out.println("main:NumberFormatException yakalandı");
		}
		finally {
			System.out.println("main:finally");
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class Sample {
	public static double foo()
	{
		try {
			Scanner kb = new Scanner(System.in);

			System.out.print("Bir sayı giriniz:");
			double val = Double.parseDouble(kb.nextLine());
			double result = MathUtil.myLog(val);

			return result;
		}
		finally {
			System.out.println("foo:finally");
		}
	}
}

class MathUtil {
	public static double myLog(double val)
	{
		if (val < 0)
			throw new MyException("val can not be negative");

		if (val == 0)
			throw new YourException("val can not be zero");


		return Math.log(val);
	}
}


class MyException extends RuntimeException {
	public MyException(String msg)
	{
		super(msg);
	}
}

class YourException extends RuntimeException {
	public YourException(String msg)
	{
		super(msg);
	}
}

```
###  Yukarıdaki işlem istenildiği kadar exception sınıfı ile yapılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki işlem istenildiği kadar exception sınıfı ile yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		try {
			double result = Sample.foo();

			System.out.printf("result:%f%n", result);
		}
		catch (MyException | YourException | NumberFormatException ex) { //Since Java 7
			System.out.println("ortak iş");
			System.out.println(ex.getMessage());
		}
		catch (Throwable ex) {
			System.out.printf("Throwable:%s%n", ex.getMessage());
		}
		finally {
			System.out.println("main:finally");
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class Sample {
	public static double foo()
	{
		try {
			Scanner kb = new Scanner(System.in);

			System.out.print("Bir sayı giriniz:");
			double val = Double.parseDouble(kb.nextLine());
			double result = MathUtil.myLog(val);

			return result;
		}
		finally {
			System.out.println("foo:finally");
		}
	}
}

class MathUtil {
	public static double myLog(double val)
	{
		if (val < 0)
			throw new MyException("val can not be negative");

		if (val == 0)
			throw new YourException("val can not be zero");


		return Math.log(val);
	}
}


class MyException extends RuntimeException {
	public MyException(String msg)
	{
		super(msg);
	}
}

class YourException extends RuntimeException {
	public YourException(String msg)
	{
		super(msg);
	}
}

```
### Birden fazla exception'ın | atomu yakalanması durumunda exception sınıfları arasında türetme ilişkisi olmaması gerekir.
```java
/*----------------------------------------------------------------------------------------------------------------------
    Birden fazla exception'ın | atomu yakalanması durumunda exception sınıfları arasında türetme ilişkisi
    olmaması gerekir. Olması durumunda türemiş exception sınıfı taban sınıfı ile birlikte kullanılamaz. Zaten
    türemiş sınıf exception nesnesi taban sınıf parametreli catch bloğu ile yakalanabilir. Java bu durumda gereksiz
    kod yazımını engellemek için error oluşturur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		try {
			double result = Sample.foo();

			System.out.printf("result:%f%n", result);
		}
		catch (MyException | YourException | NumberFormatException ex) { //error
			System.out.println("ortak iş");
			System.out.println(ex.getMessage());
		}
		catch (Throwable ex) {
			//...
		}
		finally {
			System.out.println("main:finally");
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class Sample {
	public static double foo()
	{
		try {
			Scanner kb = new Scanner(System.in);

			System.out.print("Bir sayı giriniz:");
			double val = Double.parseDouble(kb.nextLine());
			double result = MathUtil.myLog(val);

			return result;
		}
		finally {
			System.out.println("foo:finally");
		}
	}
}

class MathUtil {
	public static double myLog(double val)
	{
		if (val < 0)
			throw new MyException("val can not be negative");

		if (val == 0)
			throw new YourException("val can not be zero");


		return Math.log(val);
	}
}


class MyException extends RuntimeException {
	public MyException(String msg)
	{
		super(msg);
	}
}

class YourException extends MyException {
	public YourException(String msg)
	{
		super(msg);
	}
}
```
### CSDArrayList sınıfı
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
        throw new IllegalArgumentException(message);
    }

    private static void doWorkForIndexOutOfBoundsException(String message)
    {
        throw new IndexOutOfBoundsException(message);
    }

    private void checkForIndex(int index)
    {
        if (index < 0 || index >= m_index)
            doWorkForIndexOutOfBoundsException("Index out of bounds");
    }

    private void checkCapacityValue(int capacity)
    {
        if (capacity < 0)
            doWorkForIllegalArgumentException("Capacity can not be negative");
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
### Rational sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Rational sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.test.RationalTest;

class App {
	public static void main(String[] args)
	{
		RationalTest.run();
	}
}


package org.csystem.app.test;

import org.csystem.math.Rational;
import org.csystem.math.RationalException;

import java.util.Scanner;

public final class RationalTest {
    private RationalTest()
    {
    }

    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Rational rational = new Rational();

        for (int i = 0; i  < 5; ++i) {
            try {
                System.out.print("Pay değerini giriniz:");
                int a = Integer.parseInt(kb.nextLine());

                System.out.print("Payda değerini giriniz:");
                int b = Integer.parseInt(kb.nextLine());

                rational.setNumerator(a);
                rational.setDenominator(b);

                System.out.printf("Kesir:%s%n", rational);
            }
            catch (RationalException ex) {
                System.out.println(ex.getMessage());
            }
        }
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
                throw new RationalException("Indefinite", RationalExceptionStatus.INDEFINITE);

            throw new RationalException("Undefined", RationalExceptionStatus.UNDEFINED);
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
### RationalException sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
	RationalException sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math;

public class RationalException extends RuntimeException {
    private final RationalExceptionStatus m_rationalExceptionStatus;

    public RationalException(String s, RationalExceptionStatus rationalExceptionStatus)
    {
        super(s);
        m_rationalExceptionStatus = rationalExceptionStatus;
    }

    public RationalExceptionStatus getRationalExceptionStatus()
    {
        return m_rationalExceptionStatus;
    }

    public String getMessage()
    {
        return String.format("Mesage:%s, Exception Status:%s", super.getMessage(), m_rationalExceptionStatus);
    }
}
```
### RationalExceptionStatus enum sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
	RationalExceptionStatus enum sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math;

public enum  RationalExceptionStatus {UNDEFINED, INDEFINITE}

```
### DateTime sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	DateTime sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.test.DateTimeTest;

class App {
	public static void main(String[] args)
	{
		DateTimeTest.run();
	}
}


package org.csystem.app.test;

import org.csystem.util.datetime.DateTime;
import org.csystem.util.datetime.DateTimeException;

import java.util.Scanner;

public final class DateTimeTest {
    private DateTimeTest()
    {
    }

    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        DateTime dateTime = new DateTime();

        for (int i = 0; i  < 5; ++i) {
            try {
                System.out.print("Gün bilgisini giriniz:");
                int day = Integer.parseInt(kb.nextLine());

                System.out.print("Saat bilgisini giriniz:");
                int hour = Integer.parseInt(kb.nextLine());

                dateTime.setDay(day);
                dateTime.setHour(hour);

                System.out.println(dateTime.toLongDateStringTR());
                System.out.println(dateTime.toLongTimeString());
                System.out.println(dateTime.toString());
            }
            catch (DateTimeException ex) {
                System.out.println(ex.getMessage());
            }
        }
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
        throw new DateTimeException(errMsg);
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
### Time sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
	Time sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.Random;

public class Time {
    private int m_hour;
    private int m_minute;
    private int m_second;
    private int m_millisecond;

    private static void doWorkForException(String errMsg)
    {
        throw new DateTimeException(errMsg);
    }

    private static boolean isValidForBounds(int val, int max) //[0, max]
    {
        return 0 <= val && val <= max;
    }

    private static boolean isValidForHour(int val)
    {
        return isValidForBounds(val, 23);
    }

    private static boolean isValidForMinute(int val)
    {
        return isValidForBounds(val, 59);
    }

    private static boolean isValidForSecond(int val)
    {
        return isValidForBounds(val, 59);
    }

    private static boolean isValidForMillisecond(int val)
    {
        return isValidForBounds(val, 999);
    }

    private static boolean isValidForTime(int hour, int minute, int second, int millisecond)
    {
        return isValidForHour(hour) && isValidForMinute(minute)
                && isValidForSecond(second) && isValidForMillisecond(millisecond);
    }

    private static void checkForHour(int val)
    {
        if (!isValidForHour(val))
            doWorkForException("Invalid hour value");
    }

    private static void checkForMinute(int val)
    {
        if (!isValidForMinute(val))
            doWorkForException("Invalid minute value");
    }

    private static void checkForSecond(int val)
    {
        if (!isValidForSecond(val))
            doWorkForException("Invalid second value");
    }

    private static void checkForMillisecond(int val)
    {
        if (!isValidForMillisecond(val))
            doWorkForException("Invalid millisecond value");
    }

    private static void checkForTime(int hour, int minute, int second, int millisecond)
    {
        if (!isValidForTime(hour, minute, second, millisecond))
            doWorkForException("Invalid time values");
    }

    public static Time randomTime()
    {
        return randomTime(new Random());
    }

    public static Time randomTime(Random r)
    {
        return new Time(r.nextInt(24), r.nextInt(60), r.nextInt(60), r.nextInt(1000));
    }

    public Time() //Sistemden o anki zaman alınıyor. Buradaki yazılan kodu anlamanız gerekmiyor
    {
        Calendar now = Calendar.getInstance();

        m_hour = now.get(Calendar.HOUR_OF_DAY);
        m_minute = now.get(Calendar.MINUTE);
        m_second = now.get(Calendar.SECOND);
        m_millisecond = now.get(Calendar.MILLISECOND);
    }

    public Time(int hour, int minute)
    {
        this(hour, minute, 0);
    }

    public Time(int hour, int minute, int second)
    {
        this(hour, minute, second, 0);
    }

    public Time(int hour, int minute, int second, int millisecond)
    {
        checkForTime(hour, minute, second, millisecond);
        m_hour = hour;
        m_minute = minute;
        m_second = second;
        m_millisecond = millisecond;
    }

    public int getHour()
    {
        return m_hour;
    }

    public void setHour(int val)
    {
        if (val == m_hour)
            return;

        checkForHour(val);
        m_hour = val;
    }

    public int getMinute()
    {
        return m_minute;
    }

    public void setMinute(int val)
    {
        if (val == m_minute)
            return;

        checkForMinute(val);
        m_minute = val;
    }

    public int getSecond()
    {
        return m_second;
    }

    public void setSecond(int val)
    {
        if (val == m_second)
            return;

        checkForSecond(val);
        m_second = val;
    }

    public int getMillisecond()
    {
        return m_millisecond;
    }

    public void setMillisecond(int val)
    {
        if (val == m_millisecond)
            return;

        checkForMillisecond(val);
        m_millisecond = val;
    }

    public String toString()
    {
        return String.format("%s:%02d", toShortTimeString(), m_second);
    }

    public String toLongTimeString()
    {
        return String.format("%s.%03d", toString(), m_millisecond);
    }

    public String toShortTimeString()
    {
        return String.format("%02d:%02d", m_hour, m_minute);
    }
}

```
### DateTime sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
	DateTime sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.datetime;

import java.util.Random;

public class DateTime {
    private final Date m_date;
    private final Time m_time;

    private DateTime(Date date, Time time)
    {
        m_date = date;
        m_time = time;
    }

    //TODO: randomTime metotları
    public static DateTime randomDateTime(Random r, int minYear, int maxYear)
    {
        return new DateTime(Date.randomDate(r, minYear, maxYear), Time.randomTime(r));
    }


    public DateTime() // Örnek için yapıldı. Detaylandırılmadı
    {
        m_date = new Date();
        m_time = new Time();
    }

    public DateTime(int day, int monthValue, int year)
    {
        this(day, monthValue, year, 0, 0);
    }

    public DateTime(int day, Month month, int year)
    {
        this(day, month.ordinal() + 1, year);
    }

    public DateTime(int day, int monthValue, int year, int hour, int minute)
    {
        this(day, monthValue, year, hour, minute, 0);
    }

    public DateTime(int day, Month month, int year, int hour, int minute)
    {
        this(day, month.ordinal() + 1, year, hour, minute);
    }

    public DateTime(int day, int monthValue, int year, int hour, int minute, int second)
    {
        this(day, monthValue, year, hour, minute, second, 0);
    }

    public DateTime(int day, Month month, int year, int hour, int minute, int second)
    {
        this(day, month.ordinal() + 1, year, hour, minute, second);
    }

    public DateTime(int day, Month month, int year, int hour, int minute, int second, int millisecond)
    {
        this(day, month.ordinal() + 1, year, hour, minute, second, millisecond);
    }

    public DateTime(int day, int monthValue, int year, int hour, int minute, int second, int millisecond)
    {
        m_date = new Date(day, monthValue, year);
        m_time = new Time(hour, minute, second, millisecond);
    }

    public int getDay()
    {
        return m_date.getDay();
    }

    public void setDay(int val)
    {
        m_date.setDay(val);
    }

    public int getMonthValue()
    {
        return m_date.getMonthValue();
    }

    public void setMonthValue(int val)
    {
        m_date.setMonthValue(val);
    }

    public Month getMonth()
    {
        return m_date.getMonth();
    }

    public void setMonth(Month month)
    {
        m_date.setMonth(month);
    }

    public int getYear()
    {
        return m_date.getYear();
    }

    public void setYear(int val)
    {
        m_date.setYear(val);
    }

    public DayOfWeek getDayOfWeek()
    {
        return m_date.getDayOfWeek();
    }

    public String getDayOfWeekTR()
    {
        return m_date.getDayOfWeekTR();
    }

    public String getDayOfWeekEN()
    {
        return m_date.getDayOfWeekEN();
    }

    public boolean isLeapYear()
    {
        return m_date.isLeapYear();
    }

    public boolean isWeekday()
    {
        return m_date.isWeekday();
    }

    public boolean isWeekend()
    {
        return m_date.isWeekend();
    }

    public int getHour()
    {
        return m_time.getHour();
    }

    public void setHour(int val)
    {
        m_time.setHour(val);
    }

    public int getMinute()
    {
        return m_time.getMinute();
    }

    public void setMinute(int val)
    {
        m_time.setMinute(val);
    }

    public int getSecond()
    {
        return m_time.getSecond();
    }

    public void setSecond(int val)
    {
        m_time.setSecond(val);
    }

    public int getMillisecond()
    {
        return m_time.getMillisecond();
    }

    public void setMillisecond(int val)
    {
        m_time.setMillisecond(val);
    }

    public String toLongDateStringTR()
    {
        return m_date.toLongDateStringTR();
    }

    public String toLongDateStringEN()
    {
        return m_date.toLongDateStringEN();
    }

    public String toLongTimeString()
    {
        return m_time.toLongTimeString();
    }

    public String toShortTimeString()
    {
        return m_time.toShortTimeString();
    }

    //TODO: toStringXXX metotları
    public String toString(char delim)
    {
        return String.format("%s %s", m_date.toString(delim), m_time);
    }

    public String toString()
    {
        return toString('/');
    }
}

package org.csystem.util.datetime;

public enum Month {
    JAN(31), FEB(28), MAR(31), APR(30), MAY(31), JUN(30),
    JUL(31), AUG(31), SEP(30), OCT(31), NOV(30), DEC(31);

    private final int m_days;

    Month(int days)
    {
        m_days = days;
    }

    static boolean isLeapYear(int year)
    {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    int getDaysByYear(int year)
    {
        return ordinal() == 1 && isLeapYear(year) ? 29 : m_days;
    }
}

package org.csystem.util.datetime;

public enum DayOfWeek {
    SUN("Pazar", "Sun"), MON("Pazartesi", "Mon"), TUE("Salı", "Tue"), WED("Çarşamba", "Wed"),
    THU("Perşembe", "Thu"), FRI("Cuma", "Fri"), SAT("Cumartesi", "Sat");

    DayOfWeek(String nameTR, String nameEN)
    {
        NAME_TR = nameTR;
        NAME_EN = nameEN;
    }

    final String NAME_TR, NAME_EN;
}
```
### DateTimeException sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
	DateTimeException sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.datetime;

public class DateTimeException extends RuntimeException {
    public DateTimeException()
    {
    }

    public DateTimeException(String message)
    {
        super(message);
    }
}
```
### ArrayUtil sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
	ArrayUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.ArrayList;
import java.util.Random;

public final class ArrayUtil {
    private static void bubbleSortAscending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k + 1] < a[k])
                    swap(a, k, k + 1);
    }

    private static void bubbleSortDescending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k + 1] > a[k])
                    swap(a, k, k + 1);
    }

    private static void selectionSortAscending(int [] a)
    {
        int min, minIndex;

        for (int i = 0; i < a.length - 1; ++i) {
            min = a[i];
            minIndex = i;

            for (int k = i + 1; k < a.length; ++k) {
                if (a[k] < min) {
                    min = a[k];
                    minIndex = k;
                }
            }
            a[minIndex] = a[i];
            a[i] = min;
        }
    }

    private static void selectionSortDescending(int [] a)
    {
        int max, maxIndex;

        for (int i = 0; i < a.length - 1; ++i) {
            max = a[i];
            maxIndex = i;

            for (int k = i + 1; k < a.length; ++k) {
                if (a[k] > max) {
                    max = a[k];
                    maxIndex = k;
                }
            }
            a[maxIndex] = a[i];
            a[i] = max;
        }
    }

    private ArrayUtil()
    {
    }

    public static int [][] addMatrices(int [][] a, int [][] b)
    {
        if (isNotMatrix(a) || isNotMatrix(b) || a.length != b.length || a[0].length != b[0].length)
            throw new IllegalArgumentException("Invalid matrices for add operation");

        int [][] total = new int[a.length][a[0].length];

        for (int i = 0; i < total.length; ++i)
            for (int j = 0; j < total[i].length; ++j)
                total[i][j] = a[i][j] + b[i][j];

        return total;
    }


    public static void bubbleSort(int [] a, boolean descending)
    {
        if (descending)
            bubbleSortDescending(a);
        else
            bubbleSortAscending(a);
    }

    public static void bubbleSort(int [] a)
    {
        bubbleSort(a, false);
    }

    public static void display(int [] a)
    {
        display(1, a);
    }

    public static void display(int k, int [] a)
    {
        display(k, a.length, a);
    }

    public static void display(int k, int count, int [] a)
    {
        String fmt = String.format("%%0%dd ", k); //"%02d " -> k = 2

        for (int i = 0; i < count; ++i)
            System.out.printf(fmt, a[i]);

        System.out.println();
    }

    public static void display(String [] strings)
    {
        for (String string : strings)
            System.out.println(string);
    }

    public static void display(int [][] a)
    {
        display(1, a);
    }

    public static void display(int k, int [][] a)
    {
        for (int [] array : a)
            display(k, array);
    }

    public static void drawHistogram(int [] data, int n, char ch)
    {
        int maxVal = max(data);

        for (int val : data) {
            int count  = (int)Math.floor(val * n / (double)maxVal);

            while (count-- > 0)
                System.out.print(ch);

            System.out.println();
        }
    }

    public static int [] enlarge(int [] a, int newLength)
    {
        if (newLength <= a.length)
            return a;

        int [] newArray = new int[newLength];

        for (int i = 0; i < a.length; ++i)
            newArray[i] = a[i];

        return newArray;
    }

    public static void fillRandomArray(int [] a, int min, int max)
    {
        fillRandomArray(new Random(), a, min, max);
    }

    public static void fillRandomArray(Random r, int [] a, int min, int max)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] = r.nextInt(max - min) + min;
    }

    public static int[] getHistogramData(int [] a, int n) //[0, n]
    {
        int [] histData = new int[n + 1];

        for (int val : a)
            ++histData[val];

        return histData;
    }

    public static int [] getRandomArray(int n, int min, int max) //[min, max)
    {
        return getRandomArray(new Random(), n, min, max);
    }

    public static int [] getRandomArray(Random r, int n, int min, int max) //[min, max)
    {
        int [] a = new int[n];

        fillRandomArray(r, a, min, max);

        return a;
    }

    public static int[][] getRandomMatrix(int m, int n, int min, int max) //[min, max)
    {
        return getRandomMatrix(new Random(), m, n, min, max);
    }

    public static int[][] getRandomMatrix(Random r, int m, int n, int min, int max) //[min, max)
    {
        int [][] a = new int[m][];

        for (int i = 0; i < m; ++i)
            a[i] = getRandomArray(r, n, min, max);

        return a;
    }

    public static int [][] getRandomSquareMatrix(int n, int min, int max)
    {
        return getRandomSquareMatrix(new Random(), n, min, max);
    }

    public static int [][] getRandomSquareMatrix(Random r, int n, int min, int max)
    {
        return getRandomMatrix(r, n, n, min, max);
    }

    public static boolean isMatrix(int [][] a)
    {
        int count = a[0].length;

        for (int i = 1; i < a.length; ++i)
            if (a[i].length != count)
                return false;

        return true;
    }

    public static boolean isNotMatrix(int [][]a)
    {
        return !isMatrix(a);
    }

    public static boolean isSquareMatrix(int [][] a)
    {
        return isMatrix(a) && a[0].length == a.length;
    }

    public static boolean isNotSquareMatrix(int [][] a)
    {
        return !isSquareMatrix(a);
    }


    public static String join(ArrayList list, char delimiter)
    {
        return join(list, delimiter + "");
    }

    public static String join(ArrayList list, String delimiter)
    {
        String str = "";

        for (Object s : list)
            str += s + delimiter;

        return str.substring(0, str.length() - delimiter.length());
    }

    public static String join(String [] strings, char delimiter)
    {
        return join(strings, delimiter + "");
    }

    public static String join(String [] strings, String delimiter)
    {
        String str = "";

        for (String s : strings)
            str += s + delimiter;

        return str.substring(0, str.length() - delimiter.length());
    }

    public static int max(int [] a)
    {
        int maxVal = a[0];

        for (int i = 1; i < a.length; ++i)
            if (a[i] > maxVal)
                maxVal = a[i];

        return maxVal;
    }

    public static int min(int [] a)
    {
        int minVal = a[0];

        for (int i = 1; i < a.length; ++i)
            if (a[i] < minVal)
                minVal = a[i];

        return minVal;
    }

    public static int partition(int [] a, int threshold)
    {
        int partitionIndex = 0;

        while (partitionIndex != a.length && a[partitionIndex] < threshold)
            ++partitionIndex;

        if (partitionIndex == a.length)
            return partitionIndex;

        for (int i = partitionIndex + 1; i < a.length; ++i)
            if (a[i] < threshold)
                swap(a, i, partitionIndex++);

        return partitionIndex;
    }

    public static void reverse(int [] a)
    {
        int halfLen = a.length / 2;

        for (int i = 0; i < halfLen; ++i)
            swap(a, i, a.length - 1 - i);
    }

    public static void reverse(char [] a)
    {
        int halfLen = a.length / 2;

        for (int i = 0; i < halfLen; ++i)
            swap(a, i, a.length - 1 - i);
    }

    public static void selectionSort(int [] a)
    {
        selectionSort(a, false);
    }

    public static void selectionSort(int [] a, boolean descending)
    {
        if (descending)
            selectionSortDescending(a);
        else
            selectionSortAscending(a);
    }

    public static int sum(int [] a)
    {
        int total = 0;

        for (int val : a)
            total += val;

        return total;
    }

    public static int sum(int [][] a)
    {
        int total = 0;

        for (int i = 0; i < a.length; ++i)
            for (int k = 0; k < a[i].length; ++k)
                total += a[i][k];

        return total;
    }

    public static int sumDiagonal(int [][] a)
    {
        int total = 0;

        for (int i = 0; i < a.length; ++i)
            total += a[i][i];

        return total;
    }

    public static void swap(int [] a, int i, int k)
    {
        int temp;

        temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }

    public static void swap(char [] a, int i, int k)
    {
        char temp;

        temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }

    public static int [][] transpose(int [][] a)
    {
        int [][] t = new int[a[0].length][a.length];

        for (int i = 0; i < t.length; ++i)
            for (int j = 0; j < t[i].length; ++j)
                t[i][j] = a[j][i];

        return t;
    }
}
```
### Exam Simulation uygulması kalvyeden girişler için Consoel sınıf kullanılmıştır
```java
/*----------------------------------------------------------------------------------------------------------------------
	Exam Simulation uygulması kalvyeden girişler için Consoel sınıf kullanılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.examsimulationapp.ExamSimulationApp;

class App {
	public static void main(String[] args)
	{
		ExamSimulationApp.run();
	}
}


package org.csystem.app.samples.examsimulationapp;

public final class ExamSimulationApp {
    private ExamSimulationApp()
    {
    }

    public static void run()
    {
        ExamSimulation examSimulation = new ExamSimulation("Matematik");

        examSimulation.run();
        examSimulation.displayGrades();
        examSimulation.displayStatus();
    }
}

package org.csystem.app.samples.examsimulationapp;

import org.csystem.util.ArrayUtil;
import org.csystem.util.Console;

import java.util.Random;

public final class ExamSimulation {
    private final String m_lectureName;
    private int [][] m_grades;
    private double [] m_averages;
    private double m_average;

    private void findAverages()
    {
        int totalNumberOfStudents = 0;
        int totalGrades = 0;

        for (int i = 0; i < m_grades.length; ++i) {
            int total = ArrayUtil.sum(m_grades[i]);

            m_averages[i] = (double)total / m_grades[i].length;
            totalGrades += total;
            totalNumberOfStudents += m_grades[i].length;
        }

        m_average = (double)totalGrades / totalNumberOfStudents;
    }

    private void fillGrades()
    {
        Random r = new Random();
        m_grades = new int[Console.readInt("Şube sayısını giriniz:")][];
        m_averages = new double[m_grades.length];

        for (int i = 0; i < m_grades.length; ++i) {
            int count = Console.readInt(String.format("%d. şube öğrenci sayısını giriniz:", i + 1));

            m_grades[i] = ArrayUtil.getRandomArray(r, count, 0, 101);
        }
    }

    public ExamSimulation(String name)
    {
        m_lectureName = name;
    }

    public String getLectureName()
    {
        return m_lectureName;
    }

    public int getGrade(int i, int k)
    {
        return m_grades[i][k];
    }

    public double getAverage(int i)
    {
        return m_averages[i];
    }

    public int getNumberOfClasses()
    {
        return m_averages.length;
    }

    public int getNumberOfStudents(int i)
    {
        return m_grades[i].length;
    }

    public double getAverage()
    {
        return m_average;
    }

    public void run()
    {
        fillGrades();
        findAverages();
    }

    public void displayGrades()
    {
        System.out.printf("%s dersi sınav notları:%n", m_lectureName);
        System.out.println("*************************************************************");
        for (int i = 0; i < m_grades.length; ++i) {
            System.out.printf("%d. şube notları:", i + 1);
            ArrayUtil.display(3, m_grades[i]);
        }
        System.out.println("*************************************************************");
    }

    public void displayStatus()
    {
        displayGrades();

        System.out.printf("%s dersi için ortalamalar%n", m_lectureName);
        System.out.println("*************************************************************");
        for (int i = 0; i < m_averages.length; ++i)
            System.out.printf("%d.şube not ortalaması:%f%n", i + 1, m_averages[i]);

        System.out.printf("Okul ortalaması:%f%n", m_average);
        System.out.println("*************************************************************");
    }
}
```
### Card sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
	Card sınıfı
----------------------------------------------------------------------------------------------------------------------*/
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
        throw new IllegalArgumentException(message);
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

    public CardValue getValue()
    {
        return m_value;
    }

    public void setValue(CardValue value)
    {
        m_value = value;
    }

    public CardType getType()
    {
        return m_type;
    }

    public void setType(CardType type)
    {
        m_type = type;
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
```
## Arayüzler (Interfaces)
```java
/*----------------------------------------------------------------------------------------------------------------------
  Arayüzler (Interfaces):
	Bilindiği gibi Java'da sınıf ve enum bildirimi bir tür bildirimidir (user defined types). Java' da interface
	anahtar sözcüğü ile arayüz (interface) bildirimi yapılabilmektedir. Arayüz bildirimi de bir tür bildirimidir.

	Arayüzler daha çok abstract sınıflara benzese de şüphesiz farklı özelliklere de sahiptir
----------------------------------------------------------------------------------------------------------------------*/
```
### interface ismini diğer tür bildirimlerinden ayırt etmek için biz kendi interface'lerimizin ismini "I" ile başlatacağız. Java'daki standart arayüz isimlerinde bu kurala uyulmamıştır
```java
/*----------------------------------------------------------------------------------------------------------------------
	interface ismini diğer tür bildirimlerinden ayırt etmek için biz kendi interface'lerimizin
	ismini "I" ile başlatacağız. Java'daki standart arayüz isimlerinde bu kurala uyulmamıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

interface IX {
    //...
}

interface ISample {
    //...
}
```
### interface içerisinde veri elemanı bildirimi yapılabilir. (public static ve final)
```java
/*----------------------------------------------------------------------------------------------------------------------
	interface içerisinde veri elemanı bildirimi yapılabilir. Bu veri elemanları yazılsa da yazılmasa da
	public static ve final olarak bildirilmiş olur. Biz bildirimlerde bu anahtar sözcükleri yazmayacağız.
	Interface içerisinde final olmayan veya public dışında erişim belirleyiciye sahip veya static olmayan
	veri elemanı bildirimi yapılamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        System.out.println(IX.PI);
        IX.PI = 2.34; //error
    }
}

interface IX {
    double PI = 3.14;
}

interface IY {
    private int x; //error
}
```
### interface içerisinde gövdesiz metotlar olabilir. (public ve abstract)
```java
/*----------------------------------------------------------------------------------------------------------------------
	interface içerisinde gövdesiz metotlar olabilir. Bu metotlar yazılsa da yazılmasa da public ve abstract olur.
	Yine biz public ve abstract yazmayacağız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

interface IX {
    void foo();
    int bar(double val);
}
```
### Hiç bir abstract metodu olmayan arayüzlere işaretleme arayüzleri (marker interfaces) denir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Hiç bir abstract metodu olmayan arayüzlere işaretleme arayüzleri (marker interfaces) denir.
	Genel olarak işaretleme arayüzlerinin içerisi boş bırakılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

interface IMarker { //marker interface

}

interface IX { //marker interface
    String name = "IX";
}
```
### Java 8 ile birlikte interface içerisinde gövdeli (abstract olmayan) non-static metotlar yazılabilir. (default anahtar sözcüğü ile)
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java 8 ile birlikte interface içerisinde gövdeli (abstract olmayan) non-static metotlar yazılabilir. Bu metotlar
	default anahtar sözcüğü ile bildirilmelidir. Yazılsa da yazılmasa da default metotlar public'dir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

interface IX {
    default void foo() //Since Java 8
    {
        //...
    }
}

```
### Java 8 ile birlikte bir arayüz içerisinde static metotlar olabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java 8 ile birlikte bir arayüz içerisinde static metotlar olabilir. Şüphesiz static metotlar gövdeli olmalıdır.
	Bu metotlar da yazılsa da yazılmasa da public dir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        IX.foo();
    }
}

interface IX {
    static void foo() //Since Java 8
    {
        System.out.println("foo");
    }
}
```
### fonksiyonel arayüzler (functional interfaces) içerisinde bir ve yalnız bir tane abstract metodu olan arayüzlere denir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java 8 ile birlikte belli koşullar altında arayüzler kullanım anlamında genişletilmiştir. Buna göre içerisinde
	bir ve yalnız bir tane abstract metodu olan arayüzlere fonksiyonel arayüzler (functional interfaces) denir.
	Fonksiyonel arayüzler ile Java'da fonksiyonel programlama daha kolay ve gelişmiş biçimde yapılabilmektedir.
	Aşağıdaki kodda fonksiyonel programlama tekniğine ilişkin bir örnek verilmiştir. Konunun detayı uygulama
	kursunda ele alınacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        IIntBinaryOperation intBinaryOperator = (a, b) -> a + b; //Integer::sum

        StringConverterUtil.display(String::length, "ankara");
        System.out.println(intBinaryOperator.applyAsInt(10, 20));
    }
}

class StringConverterUtil {
    public static void display(IStringToIntConverter stringToIntConverter, String str)
    {
        System.out.println(stringToIntConverter.convert(str));
    }
}

interface IIntBinaryOperation {
    int applyAsInt(int a, int b);
}

interface IStringToIntConverter {
    int convert(String str);
}
```
### Java 9 ile birlikte arayüzler içerisinde private metotlar yazılabilir. 
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java 9 ile birlikte arayüzler içerisinde private metotlar yazılabilir. Şüphesiz bu metotların gövdesi olmalıdır.
	private metotlar için default anahtar sözcüğü kullanılmaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

interface IX {
    private void foo() //Since Java 9
    {
        //...
    }

    default void bar()
    {
        foo();
    }
}

```
### interface içerisinde bulunabilen private metotlar static olarak da bildirilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	interface içerisinde bulunabilen private metotlar static olarak da bildirilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

interface IX {
	private static void foo() //Since Java 9
	{
		//...
	}
}
```
### interface içerisinde olabilecek elemanlar
```java
/*----------------------------------------------------------------------------------------------------------------------
	interface içerisinde olabilecek elemanlar
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

interface IX {
    int NUM = 10;

    private void foo() //Since Java 9
    {

    }

    private static void bar() //Since Java 9
    {

    }

    default void tar() //Since Java 8
    {

    }

    static void func() // Since Java 8
    {

    }

    void zar();
    void car();
}
```
### interface türünden nesne yaratılmaz ve yaratılamaz. interface nesne özelliği olmayan bir tür bildirimidir
```java
/*----------------------------------------------------------------------------------------------------------------------
	interface türünden nesne yaratılmaz ve yaratılamaz. interface nesne özelliği olmayan bir tür bildirimidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        IX ix = new IX(); //error

        //...
    }
}

interface IX {
    //...
}
```
### interface bildiriminde abstract anahtar sözcüğü yazılabilir ancak yazmayacağız
```java
/*----------------------------------------------------------------------------------------------------------------------
	interface bildiriminde abstract anahtar sözcüğü yazılabilir ancak yazmayacağız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class A implements IX {
    //...
}

abstract interface IX {
    //...
}
```
### Bir sınıf bir arayüzü implements anahtar sözcüğü ile destekler (implementation)
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir sınıf bir arayüzü implements anahtar sözcüğü ile destekler (implementation)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class A implements IX {
    //...
}

interface IX {
    //...
}

```
### Bir sınıf birden fazla arayüzü destekleyebilir. 
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir sınıf birden fazla arayüzü destekleyebilir. Bu durumda hangi arayüzün listede önce olduğunun hiç bir önemi yoktur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class A implements IX, IY, IZ {

}

interface IX {
    //...
}

interface IY {
    //...
}

interface IZ {
    //...
}

```
### Bir sınıf başka bir sınıftan türetilip istediği kadar arayüzü destekleyebilir. Bu durumda taban sınıf listenin başında olmalıdır
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir sınıf başka bir sınıftan türetilip istediği kadar arayüzü destekleyebilir. Bu durumda taban sınıf
	listenin başında olmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class B extends A implements IX, IY, IZ {
    //..
}


class A {

}

interface IX {
    //...
}

interface IY {
    //...
}

interface IZ {
    //...
}
```
### Bir sınıf bir arayüzü destekliyorsa o arayüzün tüm abstract metotlarını override etmelidir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir sınıf bir arayüzü destekliyorsa o arayüzün tüm abstract metotlarını override etmelidir. Eğer birini bile override
	etmezse sınıf bildiriminde abstract yazılmalıdır. Yani sınıf abstract olmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

abstract class B implements IX {
    public void foo()
    {
        //...
    }
}

class A implements IX {
    public void foo()
    {
        //...
    }

    public void bar()
    {
        //...
    }
}

interface IX {
    void foo();
    void bar();
}
```
### Arayüz referansları taban sınıf referansı gibi kullanılabilir. Böylelikle çok biçimlilik arayüzler ile de yapılabilmektedir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Arayüz referansları taban sınıf referansı gibi kullanılabilir. Böylelikle çok biçimlilik arayüzler ile de
	yapılabilmektedir. Yani arayüzler çoklu türetmeyi (multiple inheritance) kısmi olarak kullanabilme olanağı sağlar
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Mample m = new Mample();
        Sample s = new Sample();
        Test t = new Test();

        m.doWorkForIX(s);
        m.doWorkForIY(s);
        m.doWorkForIX(t);
    }
}

class Mample {
    public void doWorkForIX(IX ix)
    {
        ix.foo();
    }

    public void doWorkForIY(IY iy)
    {
        iy.bar();
    }
}

class Test implements IX {
    public void foo()
    {
        System.out.println("Test.foo");
    }
}

class Sample implements IX, IY {
    public void foo()
    {
        System.out.println("Sample.foo");
    }

    public void bar()
    {
        System.out.println("Sample.bar");
    }
}

interface IX {
    void foo();
}

interface IY {
    void bar();
}
```
### Arayüz referansları taban sınıf referansı gibi kullanılabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Arayüz referansları taban sınıf referansı gibi kullanılabilir. Böylelikle çok biçimlilik arayüzler ile de
	yapılabilmektedir. Yani arayüzler çoklu türetmeyi kısmi olarak kullanabilme olanağı sağlar. Aşağıdaki örnekte
	Test sınıfı IY arayüzünü desteklemediğinde ** ile belirtilen çağrıda error oluşur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample s = new Sample();
        Mample m = new Mample();
        Test t = new Test();

        m.doWorkForIX(s);
        m.doWorkForIY(s);
        m.doWorkForIX(t);
        m.doWorkForIY(t); //** error
    }
}

class Mample {
    public void doWorkForIX(IX ix)
    {
        ix.foo();
    }

    public void doWorkForIY(IY iy)
    {
        iy.bar();
    }
}

class Test implements IX {
    public void foo()
    {
        System.out.println("Test.foo");
    }

}

class Sample implements IX, IY {
    public void foo()
    {
        System.out.println("Sample.foo");
    }

    public void bar()
    {
        System.out.println("Sample.bar");
    }
}

interface IX {
    void foo();
}

interface IY {
    void bar();
}
```
### Birden fazla arayüz içerisinde aynı imzaya ve geri dönüş değerine sahip bir sanal metot varsa ve bir sınıf bu iki arayüzü de destekliyorsa bir tane metot ikisi için de override edilmiş olur
```java
/*----------------------------------------------------------------------------------------------------------------------
	Birden fazla arayüz içerisinde aynı imzaya ve geri dönüş değerine sahip bir sanal metot varsa ve bir sınıf
	bu iki arayüzü de destekliyorsa bir tane metot ikisi için de override edilmiş olur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample s = new Sample();
        Mample m = new Mample();

        s.foo();
        m.doWorkForIX(s);
        m.doWorkForIY(s);
    }
}

class Mample {
    public void doWorkForIX(IX ix)
    {
        ix.foo();
    }

    public void doWorkForIY(IY iy)
    {
        iy.foo();
    }
}

class Sample implements IX, IY {
    public void foo()
    {
        System.out.println("Sample.foo");
    }

    public void bar()
    {
        System.out.println("Sample.bar");
    }
}

interface IX {
    void foo();
}

interface IY {
    void foo();
    void bar();
}
```
### Bir sınıf bir arayüzü destekliyorsa o sınıftan türetilmiş bir sınıf da aynı arayüzü destekler.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir sınıf bir arayüzü destekliyorsa o sınıftan türetilmiş bir sınıf da aynı arayüzü destekler. Bu durum
	türemiş sınıf arayüz listesinde belirtilmek zorunda değildir. İstenirse belirtilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        B b = new B();

        IX ix = b;

        ix.foo();
    }
}

class C extends A implements IX {

}

class B extends A {

}

class A implements IX {
    public void foo()
    {
        System.out.println("A.foo");
    }
}

interface IX {
    void foo();
}
```
### Aşağıdaki örnekte B sınıfı IX arayüzünün foo metodunu override etmiştir. Şüphesiz B açısından bu metot taban sınıfının metodudur
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte B sınıfı IX arayüzünün foo metodunu override etmiştir. Şüphesiz B açısından bu metot taban sınıfının
	metodudur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        B b = new B();

        IX ix = b;

        ix.foo();
    }
}

class B extends A {
    public void foo()
    {
        System.out.println("B.foo");
    }
}

class A implements IX {
    public void foo()
    {
        System.out.println("A.foo");
    }
}

interface IX {
    void foo();
}
```
### Aşağıdaki örnekte foo metodu A sınıfında final yapılmıştır
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte foo metodu A sınıfında final yapılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        B b = new B();

        IX ix = b;

        ix.foo();
    }
}

class B extends A {
    public void foo() //error
    {

    }
}

class A implements IX {
    public final void foo()
    {
        System.out.println("A.foo");
    }
}

interface IX {
    void foo();
}
```
### Bir arayüz başka bir arayüzden türetilebilir. Burada extends anahtar sözcüğü kullanılır.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir arayüz başka bir arayüzden türetilebilir. Burada extends anahtar sözcüğü kullanılır. Bu durumda türemiş arayüzü
	destekleyen bir sınıf taban arayüzü de desteklemiş olur yani somut sınıf olabilmek için tüm abstract metotları
	override etmesi gerekir. Aşağıdaki örnekte A sınıfı hem IY yi hem de IX'i desteklemiş olur. Arayüz listesinde sadece
	IY yazılması yeterlidir. İstenirse IX de yazılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A a = new A();

        IY iy = a;
        IX ix = a;

        ix = iy; //upcasting

        System.out.println(ix.getClass().getName());
    }
}

class B implements IY, IX {
    public void foo()
    {

    }

    public void bar()
    {

    }
}

class A implements IY {
    public void foo()
    {

    }

    public void bar()
    {

    }
}

interface IY extends IX {
    void bar();
}

interface IX {
    void foo();
}

```
### Arayüzler arasında çoklu türetme (multiple inheritance) yapılabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Arayüzler arasında çoklu türetme (multiple inheritance) yapılabilir. Aşağıdaki örnekte IZ yi destekleyen bir sınıf
	listeye yazılsa da yazılmasa da IX ve IY yi de destekler
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A a = new A();

        IZ iz = a;
        IY iy = a;
        IX ix = a;
        //...

        ix = iz; //upcasting
        iy = iz; //upcasting
    }
}

class A implements IZ {
    public void foo()
    {

    }

    public void bar()
    {

    }

    public void tar()
    {

    }
}

interface IZ extends IX, IY {
    void tar();
}

interface IY  {
    void foo();
}

interface IX {
    void bar();
}
```
### default metotlar sanaldır. default metotlar da override edilebilir. 
```java
/*----------------------------------------------------------------------------------------------------------------------
	default metotlar sanaldır. default metotlar da override edilebilir. Bu durumda çok biçimli olarak override edilen
	çağrılır. default metotlar override edilmek zorunda değildir. Aşağıdaki örnekte B sınıfı foo default metodunu
	override etmemiştir, somut sınıf olarak bildirilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A a = new A();
        IX ix = a;

        ix.foo();

        ix = new B();

        ix.foo();
    }
}

class B implements IX {

}

class A implements IX {
    public void foo()
    {
        System.out.println("A.foo");
    }
}

interface IX {
    default void foo()
    {
        System.out.println("IX.foo");
    }
}
```
### super referansı taban sınıfı temsil ettiğinden aşağıdaki örnekte taban sınıf da Object olduğundan error oluşur
```java
/*----------------------------------------------------------------------------------------------------------------------
	super referansı taban sınıfı temsil ettiğinden aşağıdaki örnekte taban sınıf da Object olduğundan error oluşur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A a = new A();
        IX ix = a;

        ix.foo();
    }
}

class A implements IX {
    public void foo()
    {
        System.out.println("A.foo");
        super.foo(); //error: Burada super referansı Object türündendir
    }
}

interface IX {
    default void foo()
    {
        System.out.println("IX.foo");
    }
}

```
### Aşağıdaki örnek geçerlidir. super.foo() çağrısında B sınfının foo metodu çağrılır
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnek geçerlidir. super.foo() çağrısında B sınfının foo metodu çağrılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A a = new A();
        IX ix = a;

        ix.foo();
    }
}

class B {
    public void foo()
    {
        System.out.println("B.foo");
    }
}

class A extends B implements IX {
    public void foo()
    {
        System.out.println("A.foo");
        super.foo(); //Burada super referansı B türündendir
    }
}

interface IX {
    default void foo()
    {
        System.out.println("IX.foo");
    }
}
```
### Aşağıdaki örnek geçerlidir. B den kalıtımla alınan foo metodu A'nın foo metodu olarak ix referansı ile çağrılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnek geçerlidir. B den kalıtımla alınan foo metodu A'nın foo metodu olarak ix referansı ile çağrılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A a = new A();
        IX ix = a;

        ix.foo();
    }
}

class B {
    public void foo()
    {
        System.out.println("B.foo");
    }
}

class A extends B implements IX {

}

interface IX {
    void foo();
}
```
### Aşağıdaki örnekte A'da override edilen foo aynı zamanda IX türden referans ile de dinamik olarak çağrılabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte A'da override edilen foo aynı zamanda IX türden referans ile de dinamik olarak çağrılabilir.
	C sınıfı için foo metodu public olarak override edilmelidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A a = new A();
        IX ix = a;

        ix.foo();
    }
}

class C extends B implements IX { //error: Geçerli olsaydı IX için foo metodunun erişim belirleyicisi düşürülmüş oludu

}

class B {
    protected void foo()
    {
        System.out.println("B.foo");
    }
}

class A extends B implements IX {
    public void foo()
    {
        System.out.println("A.foo");
    }
}


interface IX {
    void foo();
}

```
### Yukarıdaki örnekte sınıfı abstract yaparak da error engellenemez. 
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki örnekte sınıfı abstract yaparak da error engellenemez. Buradaki hata IX'in foo metodunun protected olarak
	bırakılmasıdır. Bu da error oluşturur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A a = new A();
        IX ix = a;

        ix.foo();
    }
}

abstract class C extends B implements IX {
    //...
}

class B {
    protected void foo()
    {
        System.out.println("B.foo");
    }
}

class A extends B implements IX {
    public void foo()
    {
        System.out.println("A.foo");
    }
}


interface IX {
    void foo();
}
```
### Aşağıdaki durum geçersizdir. Çünkü bir sınıf içerisinde aynı imzaya sahip birden fazla metot bildirimi yapılamaz
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki durum geçersizdir. Çünkü bir sınıf içerisinde aynı imzaya sahip birden fazla metot bildirimi yapılamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class A implements IX, IY {
    public void foo() //error
    {

    }

    public int foo() //error
    {
        return 10;
    }
}

interface IX {
    void foo();
}

interface IY {
    int foo();
}
```
### "covariant return type"
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir sınıfın sanal bir metodu referansa geri dönen bir metot ise, bu metot türemiş sınıfta override edilirken
	geri dönüş değeri olan referansa ilişkin sınıftan türetilmiş bir sınıf geri dönüş değeri olarak yazılabilir.
	Buna İnglizce olarak "covariant return type" denir. Bu kullanım yararlı olsa da Java'da pek tercih edilmez.
	Burada geri dönüş değeri bir interface ise override edilirken geri dönüş değeri bilgisi yerine o interface'i
	implemente eden bir sınıf yazılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class B extends A {
    public Y foo()
    {
        Y y = new Y();

        //...
        return y;
    }
}

class Y extends X {

}

abstract class A {
    public abstract X foo();
}



class X {

}
```
### Sanal bir metodun geri dönüş değeri Object türündense override edililirken geri dönüş bilgisi yerine istenilen bir referans türü yazılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sanal bir metodun geri dönüş değeri Object türündense override edililirken geri dönüş bilgisi yerine istenilen bir
	referans türü yazılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Random;

class D implements IFactory {
    public Sample create()
    {
        return new Sample();
    }
}

class Sample {

}


class E implements IFactory {
    public int [] create()
    {
        return ArrayUtil.getRandomArray(10, 10, 100);
    }
}

class C implements IFactory {
    public Random create()
    {
        return new Random();
    }
}

class B implements IFactory {
    public String create()
    {
        return "ankara";
    }
}

interface IFactory {
    Object create();
}
```
### Aşağıdaki durum covariant return type kuralları dolayısıyla geçerlidir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki durum covariant return type kuralları dolayısıyla geçerlidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class A implements IX, IY {
    public String foo()
    {
        return "ankara";
    }
}

interface IX {
    String foo();
}

interface IY {
    Object foo();
}
```
## (Abstract) sınıflar ile arayüzler arasındaki farklar:
```java
/*----------------------------------------------------------------------------------------------------------------------
    (Abstract) sınıflar ile arayüzler arasındaki farklar: (Maddelerin sırasının önemi yoktur)
    - Arayüzler interface anahtar sözcüğü ile abstract sınıflar ise class anahtar sözcüğü ile bildirilir

    - Arayüzler non-static veri elemanlarına sahip olamaz, abstract sınıflar olabilir

    - Arayüzler nesne özelliği göstermediğinden ctor'ları olamaz, abstract sınıfların olabilir

    - Arayüzlerin abstract metotları public ve abstract yazılmasa da bu şekilde kabul edilir. abstract
    sınıflarda bunlar yazılmalıdır

    - Arayüzlere Java 8 ile birlikte eklenen gövdeli non-static metotlar default anahtar sözcüğü ile yazılmalıdır.
    abstract sınıflarda doğrudan erişim belirleyici ile yazılmalıdır.

    - Arayüzlerin veri elemanları yazılsa da yazılmasa da public, static ve final olur. abstract sınıflarda
    bunlar belirtilmelidir

    - Bir sınıf bir arayüzü implements anahtar sözcüğü ile destekler (implementation), abstract sınıftan
    ise extends anahtar sözcüğü ile türetilebilir. Burada arayüzler için türetme teriminin kullanılmadığına
    dikkat ediniz

    - Bir sınıf istediği kadar arayüzü destekleyebilir, ancak tek bir sınıftan türetilebilir

    - Arayüzler arasında çoklu türetme yapılabilir. Ancak sınıflar arasında çoklu türetme geçersizdir

    - Arayüzler türünden nesne hiç bir şekilde yaratılmaz, abstract sınıf türünden nesne türemiş
    sınıf nesnesi içerisinde otomatik olarak yaratılır.
----------------------------------------------------------------------------------------------------------------------*/
```
### Bir tür ne zaman interface ne zaman abstract sınıf yapılmalıdır? Programcı buna nasıl karar verecektir?
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir tür ne zaman interface ne zaman abstract sınıf yapılmalıdır? Programcı buna nasıl karar verecektir?
	Bu durumda yeni başlayanlar için bu sorunun cevabı şöyle özetlenebilir:
	"Önce interface düşünülmeli, interface özellikleri yazacağınız türü karşılamıyorsa (abstract) sınıf tercih edilmelidir"

	interface yapılabildiği yerde abstract sınıf yerine interface yapılması, bu interface'i destekleyen sınıfın başka bir
	sınıftan da türetilmesi olanağı sağlar
----------------------------------------------------------------------------------------------------------------------*/
```
### Parser uygulaması: ISource interface yapılmıştır
```java
/*----------------------------------------------------------------------------------------------------------------------
	Parser uygulaması: ISource interface yapılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.parserapp.ParserTest;

class App {
    public static void main(String[] args)
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

            StringISource stringSource = new StringISource(str);
            CharArrayISource charArraySource = new CharArrayISource(str + str);

            parser.setSource(stringSource);

            parser.doParse();

            parser.setSource(charArraySource);

            parser.doParse();
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}

package org.csystem.app.samples.parserapp;

public class Parser {
    private ISource m_source;

    public Parser()
    {
    }

    public Parser(ISource source)
    {
        this.setSource(source);
    }

    public ISource getSource()
    {
        return m_source;
    }

    public void setSource(ISource source)
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

public class CharArrayISource implements ISource {
    private final char [] m_chars;
    private int m_index;

    public CharArrayISource(char [] chars)
    {
        m_chars = Arrays.copyOf(chars, chars.length);
    }

    public CharArrayISource(String str)
    {
        m_chars = str.toCharArray();
    }

    public int getChar()
    {
        return m_index == m_chars.length ? -1 : m_chars[m_index++];
    }
}

package org.csystem.app.samples.parserapp;

public class StringISource implements ISource {
    private final String m_str;
    private int m_index;

    public StringISource(String str)
    {
        m_str = str;
    }

    public int getChar()
    {
        return m_str.length() == m_index ? -1 : m_str.charAt(m_index++);
    }
}
/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/


/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/
```
