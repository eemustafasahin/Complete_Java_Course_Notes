```java
/*----------------------------------------------------------------------------------------------------------------------
	16.05.2020
	Merhaba Dünya programı
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args)
	{
		System.out.println("Merhaba Dünya");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yorum satırları (comment lines)
----------------------------------------------------------------------------------------------------------------------*/

package csd;

class App {
	public static void main(String [] args)
	{
	//Burası derleyici tarafından görülmeyecek
		System.out.println("Merhaba Dünya"); //Merhaba dünya ekrana basıldı
/*

Burası da
derleyici tarafından görmezden gelinecek 

*/
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Atomlar(token):
	1. Anahtar sözcükler (keywords, reserved words)
	2. Değişkenler (variables, identifiers)
	3. Sabitler (literals, constants)
	4. Operatörler (operators)
	5. String'ler (strings)
	6. Ayraçlar (delimiters, punctuators)
----------------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------------
	Merhaba Dünya programının atomları:
	package			: anahtar sözcük (as)
	csd				: değişken (d)
	;				: ayraç (a)
	class			: as
	App				: d
	{}				: a
	public			: as
	static			: as
	void			: as
	main			: d
	()				: a
	String			: d
	[]				: a
	args			: d
	System			: d
	.				: operator (o)
	out				: d
	println			: d
	()				: o
	"Merhaba Dünya"	: string
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args)
	{
		System.out.println("Merhaba Dünya");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java' da atomlar arasında istenildiği kadar boşluk (whitespace) bırakılabilir	
----------------------------------------------------------------------------------------------------------------------*/
package csd;







class 



App 



{
	



public static void main(String [] args)
	{
							System.out













.println("Merhaba Dünya");
	}
}
```

```java
/*----------------------------------------------------------------------------------------------------------------------
	Anahtar sözcükler ve değişkenler dışında atomlar bitişik yazılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;class App{public static void main(String[]args){System.out.println("Merhaba Dünya");}}
/*----------------------------------------------------------------------------------------------------------------------
	Anahtar sözcükler ve değişkenler dışında atomlar bitişik yazılabilir
----------------------------------------------------------------------------------------------------------------------*/
packagecsd;class App{publicstatic void main(String[]args){System.out.println("Merhaba Dünya");}} //error

/*----------------------------------------------------------------------------------------------------------------------
	paket bildiriminin (declaration) genel biçimi:
	package <paket ismi>;
	package csd;
	sınıf bildiriminin genel biçimi:
	[erişim belirleyici] class <sınıf ismi> {
		//...
	}
	class Sample {
		//...
	}
	
	public class Mample {
		//...
	}
	
	Metot bildiriminin genel biçimi:
	[erişim belirleyici] [static] <geri dönüş değeri> <metot ismi>([parametreler])
	{
		//...
	}
	
	erişim belirleyiler: public, protected, no-modifier (hiç birşey yazmamak), private
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------	
	Metot bildirimi
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args) 
	{
		//...
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

class Mample {
	public static void tar()
	{
		System.out.println("tar");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Metot çağırmanın (call) genel biçimi:
	[paket ismi].[sınıf ismi].<metot ismi>([argümanlar]);
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args) 
	{
		csd.Sample.foo();
		csd.Sample.bar();
		csd.Mample.tar();
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

class Mample {
	public static void tar()
	{
		System.out.println("tar");
	}
}
```

```java
/*----------------------------------------------------------------------------------------------------------------------
	Metotların çagrılmasi
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args) 
	{
		csd.Sample.foo();
		csd.Sample.bar();		
	}
}

class Sample {
	public static void foo()
	{
		System.out.println("foo");
		csd.Mample.tar();
	}

	public static void bar()
	{
		System.out.println("bar");
	}
}

class Mample {
	public static void tar()
	{
		System.out.println("tar");
	}
}
```

```java
/*----------------------------------------------------------------------------------------------------------------------
	Çagiran metodun (caller) ait oldugu sinif ile çagrilan metodun (callee) ait oldugu sinif ayni pakette ise
	çagirma sirasinda paket ismi yazilmayabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args) 
	{
		Sample.foo();
		Sample.bar();		
	}
}

class Sample {
	public static void foo()
	{
		System.out.println("foo");
		Mample.tar();
	}

	public static void bar()
	{
		System.out.println("bar");
	}
}

class Mample {
	public static void tar()
	{
		System.out.println("tar");
	}
}
```

```java
/*----------------------------------------------------------------------------------------------------------------------
	Çagiran metot ile çagrilan metot ayni sinifta ise çagirma sirasinda sinif ismi yazilmayabilir.
	Süphesiz sinif ismi yazilmamasi paket ismini de yazmamaniz durumunda geçerlidir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args) 
	{
		Sample.foo();
		Sample.bar();		
	}
}

class Sample {
	public static void foo()
	{
		System.out.println("foo");
		bar();		
	}

	public static void bar()
	{
		System.out.println("bar");
	}
}

class Mample {
	public static void tar()
	{
		System.out.println("tar");
	}
}

```
