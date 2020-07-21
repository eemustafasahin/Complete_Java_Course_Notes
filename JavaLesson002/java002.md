### Tür nedir ?
```java
/*----------------------------------------------------------------------------------------------------------------------
	17.05.2020
	Tür (type): Bir değişken için bellekte kaç byte yer ayrılacağını ve içerisindeki değerin hangi formatta
	tutulacağını belirten kavrama denir.
	
	Temel Türler (built-in type, predefined type)
	
	Tür ismi				Uzunluğu (byte)
	short						2
   *int							4
	long						8
	byte						1
	
	float						4
   *double						8
	
	char						2
	boolean						?
----------------------------------------------------------------------------------------------------------------------*/
```
### Java'da Değişken bildiriminin genel biçimi:
```java
/*----------------------------------------------------------------------------------------------------------------------
	Değişken bildiriminin genel biçimi:
	<tür> <değişken ismi>;
	int a;
	double b;
	boolean c;
----------------------------------------------------------------------------------------------------------------------*/
```
### Java'da değişken bildirimi 3(üç) şekilde yapılabilir:
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java'da değişken bildirimi 3(üç) şekilde yapılabilir:
	1. Yerel değişkenler (local variables)
	2. Parametre değişkenleri (parameter variables)
	3. Sınıf veri elemanları (member variables, fields)
	
	Değişkenler için temel kavramlar:
	İsmi: Bir kurallara bağlı olarak yazılan karakterler topluluğu
	Türü: Değişkenin bellekte ne kadar yer kapladığı ve içerisindeki değerin hangi formatta tutulduğu	
	Faaliyet alanı (scope): Bir değişken isminin derleyici tarafından görülebildiği kod aralığına denir
	Ömür (storage duration): Bir değişkenin bellekte kalma süresi
	
	Temel Kavramlar:
	Blok (block): Bir metot içerisinde { küme parantezi ile } parantezi arasında kalan kod bölümü. Metodun
	gövdesi de bir bloktur  
	İlk değer verme (initialization): Bir değişkene bildirim noktasında atanan değer ilkdeğer verme denir 
----------------------------------------------------------------------------------------------------------------------*/
```
### Bir metot içerisinde istenildiği kadar içiçe veya ayrık bloklar olabilir. 
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir metot içerisinde istenildiği kadar içiçe veya ayrık bloklar olabilir. 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args)
	{
		{
			//...
			
			{
				//...
			}
			
			{
				//...
			}
		}
		
		
		{
			//...
			{
				{
					
				}
			}
		}
						
	}
}

class Sample {
	public static void foo()
	{
		{
			//...
			
			{
				//...
			}
			
			{
				//,...
			}
		}
		
		
		{
			//...
			{
				{
					
				}
			}
		}
	}
}
```
### Bir blok içerisinde herhangi bir yerde bildirilen değişkenlere yerel değişkenler denir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir blok içerisinde herhangi bir yerde bildirilen değişkenlere yerel değişkenler denir 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args)
	{
		
						
	}
}

class Sample {
	public static void foo()
	{
		
		{
			//...
			int a;
			
			{
				//...
				double b;
			}
			
			{
				//,...
				
				float c;
			}
		}
		
		boolean d;
		
		{
			//...
			{
				{
					
				}
			}
		}
	}
}
```
### Aynı türden yerel değişkenler aralarına virgül konarak bildirilebilirler 
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aynı türden yerel değişkenler aralarına virgül konarak bildirilebilirler 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args)
	{
		
						
	}
}

class Sample {
	public static void foo()
	{
		int a, b, c, d;
		float e;
	}
}
```
##  Yerel değişkenlere ilk değer verilmesi
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Yerel değişkenlere ilk değer verilmesi
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args)
	{
								
	}
}

class Sample {
	public static void foo()
	{
		int a = 10, b = 20, c;
		double d = 3.4;
		
		
		c = 23;
	}
}
```
### Yerel bir değişkenin faaliyet alanı bildirildiği yerden bildirildiği bloğun sonuna kadardır
```java

/*----------------------------------------------------------------------------------------------------------------------
	 Yerel bir değişkenin faaliyet alanı bildirildiği yerden bildirildiği bloğun sonuna kadardır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args)
	{
								
	}
}

class Sample {
	public static void foo()
	{
		int b;
		
		{
			int a;
			
			a = 45;
		}
		
		a = 20; //error
		
		b = 45;
	}
	
	public static void bar()
	{
		b = 30; //error
	}
}
```
### Aynı faaliyet alanı içerisinde aynı isimde yerel değişken bildirimi geçersizdir
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Aynı faaliyet alanı içerisinde aynı isimde yerel değişken bildirimi geçersizdir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args)
	{
								
	}
}

class Sample {
	public static void foo()
	{
		int a;
		double a; //error
	}
	
	public static void bar()
	{
		int a;
		
		{
			
			double a; //error
			
		}
	}
}
```
### Farklı faaliyet alanları içerisinde aynı isimde yerel değişken bildirimi yapılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Farklı faaliyet alanları içerisinde aynı isimde yerel değişken bildirimi yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args)
	{
								
	}
}

class Sample {
	public static void foo()
	{
		int x;
		
		{
			int a;
			//...
		}
		
		{
			int a;
			//...
		}
	}
	
	public static void bar()
	{
		int x;
		
		{
			int a;
		}
		
		int a;
	}
}
```
### Farklı faaliyet alanları içerisinde aynı isimde yerel değişken bildirimi yapılabilir
```java

/*----------------------------------------------------------------------------------------------------------------------
	 Farklı faaliyet alanları içerisinde aynı isimde yerel değişken bildirimi yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args)
	{
										
	}
}

class Sample {
	public static void foo()
	{
		int x;
		
		{
			int a;
			//...
		}
		
		{
			int a;
			//...
		}
	}
	
	public static void bar()
	{
		int x;
		
		{
			int a;
		}
		
		int a;
	}
}
```
### print ve println metotları değişkenlerin içerisindeki değerleri ekrana basabilirler
```java
/*----------------------------------------------------------------------------------------------------------------------
	 print ve println metotları değişkenlerin içerisindeki değerleri ekrana basabilirler
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args)
	{
		int a = 10;
		boolean b = true;
		char c = 67;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
```
### İçerisine değer atanmamış hiç bir değişken kullanılamaz yani içerisinde değer varmış gibi işlem yapılamaz
```java
/*----------------------------------------------------------------------------------------------------------------------
	 İçerisine değer atanmamış hiç bir değişken kullanılamaz yani içerisinde değer varmış gibi işlem yapılamaz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args)
	{
		int a;		
		int x = a * 2; //error
		
		System.out.println(a); //error	
	}
}
```
### Yerel değişkenlere değer atanması programcının sorumluluğundadır
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Yerel değişkenlere değer atanması programcının sorumluluğundadır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {
	public static void main(String [] args)
	{	
		int a;
		
		a = 10;
		int x = a * 2;
		
		System.out.println(a);		
		System.out.println(x);
	}
}
```
