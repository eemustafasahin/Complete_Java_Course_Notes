### Sınıfın non-static bir elemanına sınıf dışından sınıf ismi ile erişilemez. Çünkü non-static veri elemanı her nesne için ayrıca yaratılır. Nesne bilinmeden elemana erişilemez
```java
/*----------------------------------------------------------------------------------------------------------------------
	 04.07.2020
	 Sınıfın non-static bir elemanına sınıf dışından sınıf ismi ile erişilemez. Çünkü non-static veri elemanı
	 her nesne için ayrıca yaratılır. Nesne bilinmeden elemana erişilemez
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{			
		Sample.x = 10; //error		
	}
}

class Sample {
	public int x;
}
```
###  Sınıfın static bir elemanına sınıf dışından referans ile de erişilebilir. Sınıf ismi ile erişmekten bir farkı yoktur. Bu şekilde kodlar okunabilirlik açısından yazılmamalıdır
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Sınıfın static bir elemanına sınıf dışından referans ile de erişilebilir. Sınıf ismi ile erişmekten
	 bir farkı yoktur. Bu şekilde kodlar okunabilirlik açısından yazılmamalıdır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{			
		Sample s = new Sample();
		
		s.x = 10;
		
		System.out.printf("Sample.x:%d%n", Sample.x);				
	}
}

class Sample {
	public static int x;
	//...
}
```
### Sınıfın non-static bir metodu sınıf dışından referans ve nokta operatörü ile çağrılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Sınıfın non-static bir metodu sınıf dışından referans ve nokta operatörü ile çağrılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Sample s = new Sample();
		
		s.foo();						
	}
}

class Sample {
	public void foo()
	{
		
	}
}
```
### Sınıfın non-static bir metodu sınıf dışından sınıf ismi ve noka operatörü ile çağrılamaz
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Sınıfın non-static bir metodu sınıf dışından sınıf ismi ve noka operatörü ile çağrılamaz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		Sample.foo(); //error						
	}
}

class Sample {
	public void foo()
	{
		
	}
}
```
### Sınıfın static bir metodu sınıf isme ve nokta operatörü ile çağrılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Sınıfın static bir metodu sınıf isme ve nokta operatörü ile çağrılabilir
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
		
	}
}
```
### Sınıfın static bir metodu referans ve nokta operatörü ile de çağrılabilir. static veri elemanlarında olduğu gibi herhangi bir etkisi yoktur. Bu şekilde çağrı okunabilirlik açısından yapılmamalıdır
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Sınıfın static bir metodu referans ve nokta operatörü ile de çağrılabilir. static veri elemanlarında olduğu
	 gibi herhangi bir etkisi yoktur. Bu şekilde çağrı okunabilirlik açısından yapılmamalıdır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Sample s = new Sample();
		
		s.foo();						
	}
}

class Sample {
	public static void foo()
	{
		
	}
}
```
### Sınıfın non-static bir metodu içerisinde aynı sınıfın non-static bir veri elemanına doğrudan erişilebilir. Doğrudan erişilen veri elemanı metodu çağıran referansın gösterdiği nesnenin veri elemanıdır
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıfın non-static bir metodu içerisinde aynı sınıfın non-static bir veri elemanına doğrudan erişilebilir.
	Doğrudan erişilen veri elemanı metodu çağıran referansın gösterdiği nesnenin veri elemanıdır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Sample s = new Sample();
		Sample k = new Sample();
		
		s.foo(10);
		k.foo(20);
		
		System.out.printf("s.x=%d%n", s.x);
		System.out.printf("k.x=%d%n", k.x);					
	}
}

class Sample {
	public int x;
	
	public void foo(int a)
	{
		x = a;
	}
}
```
### Sınıfın non-static bir metodu içerisinde aynı sınıfın non-static metodu doğrudan çağrılabilir. Doğrudan çağrılan metot, çağıran metodu çağıran referans ile çağrılmış olur
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıfın non-static bir metodu içerisinde aynı sınıfın non-static metodu doğrudan çağrılabilir.
	Doğrudan çağrılan metot, çağıran metodu çağıran referans ile çağrılmış olur
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Sample s = new Sample();
		Sample k = new Sample();
		
		s.foo(10);
		k.foo(20);
		
		System.out.printf("s.x=%d%n", s.x);
		System.out.printf("k.x=%d%n", k.x);					
	}
}

class Sample {
	public int x;
	
	public void foo(int a)
	{
		bar(a);
	}
	
	public void bar(int a)
	{
		x = a;
	}
}
```
### Yukarıdaki iki maddenin özeti olarak, sınıfın non-static bir metodu içerisinde sınıfın non-static elemanlarına doğrudan erişilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki iki maddenin özeti olarak, sınıfın non-static bir metodu içerisinde sınıfın non-static elemanlarına
	doğrudan erişilebilir	
----------------------------------------------------------------------------------------------------------------------*/
```
### Sınıfın non-static bir metodu içerisinde sınıfın static bir veri elemanına doğrudan erişilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıfın non-static bir metodu içerisinde sınıfın static bir veri elemanına doğrudan erişilebilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Sample s = new Sample();		
		
		s.foo(10);
		
		System.out.printf("Sample.x=%d%n", Sample.x);
							
	}
}

class Sample {
	public static int x;
	
	public void foo(int a)
	{
		x = a;
	}	
	
}
```
### Sınıfın non-static bir metodu içerisinde sınıfın static bir metodu doğrudan çağrılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıfın non-static bir metodu içerisinde sınıfın static bir metodu doğrudan çağrılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Sample s = new Sample();		
		
		s.foo(10);
		
		System.out.printf("Sample.x=%d%n", Sample.x);
							
	}
}

class Sample {
	public static int x;
	
	public static void bar(int a)
	{
		x = a;
	}
	
	public void foo(int a)
	{
		bar(a);
	}	
}
```
### Yukarıdaki iki maddenin özeti olarak, sınıfın non-static bir metodu içerisinde sınıfın static elemanlarına doğrudan erişilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki iki maddenin özeti olarak, sınıfın non-static bir metodu içerisinde sınıfın static elemanlarına
	doğrudan erişilebilir	
----------------------------------------------------------------------------------------------------------------------*/
```
### Yukarıdaki dört maddenin özeti olarak, sınıfın non-static bir metodu içerisinde sınıfın tüm elemanlarına (non-static veya static) doğrudan erişilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki dört maddenin özeti olarak, sınıfın non-static bir metodu içerisinde sınıfın tüm elemanlarına
	(non-static veya static) doğrudan erişilebilir	
----------------------------------------------------------------------------------------------------------------------*/
```
### Sınıfın static bir metodu içerisinde sınıfın non-static bir veri elemanına doğrudan erişilemez. Çünkü static metotların referans ile çağrılmasının bir anlamı olmadığı non-static veri elemanının kime ait olduğu bilinemez. Dolayısıyla error oluşur
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıfın static bir metodu içerisinde sınıfın non-static bir veri elemanına doğrudan erişilemez.
	Çünkü static metotların referans ile çağrılmasının bir anlamı olmadığı non-static veri elemanının kime
	ait olduğu bilinemez. Dolayısıyla error oluşur
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		
							
	}
}

class Sample {
	public int x;	
	
	
	public static void foo(int a)
	{
		x = a; //error
	}	
}
```
### Sınıfın static bir metodu içerisinde sınıfın non-static bir metodu doğrudan çağrılamaz. Çünkü çağrılmaya çalışılan non-static metot bir non-veri elemanına erişiyor  olabilir. Bu durumda veri elemanının hangi nesneye olduğu bilinemez. Dolayısıyla error oluşur.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıfın static bir metodu içerisinde sınıfın non-static bir metodu doğrudan çağrılamaz.
	Çünkü çağrılmaya çalışılan non-static metot bir non-veri elemanına erişiyor olabilir. Bu durumda veri elemanının
	hangi nesneye olduğu bilinemez. Dolayısıyla error oluşur.
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		
							
	}
}

class Sample {
	public int x;
	
	public void bar(int a)
	{
		x = a;
	}
	
	public static void foo(int a)
	{
		bar(a); //error
	}	
}
```
### Yukarıdaki iki maddenin özeti olarak, sınıfın static bir metodu içerisinde sınıfın non-static elemanlarına doğrudan erişilemez
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki iki maddenin özeti olarak, sınıfın static bir metodu içerisinde sınıfın non-static elemanlarına
	doğrudan erişilemez	
----------------------------------------------------------------------------------------------------------------------*/
```
### Sınıfın static bir metodu içerisinde sınıfın static bir elemanına doğrudan erişilebilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıfın static bir metodu içerisinde sınıfın static bir elemanına doğrudan erişilebilir	
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Sample.foo(10);
		
		System.out.printf("Sample.x=%d%n", Sample.x);							
	}
}

class Sample {
	public static int x;	
	
	public static void foo(int a)
	{
		x = a;
	}	
}
```
### Sınıfın static bir metodu içerisinde sınıfın static bir metodu doğrudan çağrılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıfın static bir metodu içerisinde sınıfın static bir metodu doğrudan çağrılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Sample.foo(10);
		
		System.out.printf("Sample.x=%d%n", Sample.x);							
	}
}

class Sample {
	public static int x;	
	
	public static void bar(int a)
	{
		x = a;
	}
	
	public static void foo(int a)
	{
		bar(a);
	}	
}
```
### Yukarıdaki iki maddenin özeti olarak, sınıfın static bir metodu içerisinde sınıfın static elemanlarına doğrudan erişilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki iki maddenin özeti olarak, sınıfın static bir metodu içerisinde sınıfın static elemanlarına
	doğrudan erişilebilir
----------------------------------------------------------------------------------------------------------------------*/
```
### Yukarıdaki dört maddenin özeti olarak, sınıfın static bir metodu içerisinde sınıfın yalnızca static elemanlarına doğrudan erişilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki dört maddenin özeti olarak, sınıfın static bir metodu içerisinde sınıfın yalnızca static elemanlarına
	doğrudan erişilebilir
----------------------------------------------------------------------------------------------------------------------*/
```
### Yukarıdaki sekiz maddenin özeti olarak, sınıfın non-static bir metodu içerisinde sınıfın her elemanına doğrudan erişilebilirken, static bir metodu içerisinde yalnızca static elemanlarına doğrudan erişilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki sekiz maddenin özeti olarak, sınıfın non-static bir metodu içerisinde sınıfın her elemanına doğrudan
	erişilebilirken, static bir metodu içerisinde yalnızca static elemanlarına doğrudan erişilebilir
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte doğrudan erişim yapılmamıştır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Sample s = Sample.foo(10);
		
		System.out.printf("s.x=%d%n", s.a);									
	}
}

class Sample {
	public int a;
	
	public static Sample foo(int a)
	{
		Sample x = new Sample();
		
		x.a = a;		
		
		return x;		
	}
}
```
### Point sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Point sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Point p1 = new Point();
		Point p2 = new Point();
		
		p1.x = 20;
		p1.y = -123;	
		
		p2.x = 120;
		p2.y = 23;
		
		p1.display();
		p2.display();
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Point sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Point p = new Point();		
		
		p.x = 20;
		p.y = -123;
		
		p.display();		
		p.offset(20, 10);		
		p.display();
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Point sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Point p = new Point();		
		
		p.x = 20;
		p.y = -123;
		
		p.display();
		p.offset(20);		
		p.display();
	}
}
```
### Point sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
	Point sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Point p1 = new Point();		
		Point p2 = new Point();
		
		p1.x = 50;
		p1.y = 50;
		
		p2.x = 100;
		p2.y = 100;

		p1.display();
		p2.display();
		
		
		double dist = p1.distance(p2);
		System.out.printf("Distance:%f%n", dist);
		
		int x = 100, y = 100;
		
		dist = p1.distance(x, y);
		
		System.out.printf("Distance:%f%n", dist);		
	}
}

class Point {
	public int x;
	public int y;
	
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
	
	public void display()
	{
		System.out.printf("{x = %d, y = %d}%n", x, y);		
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
		Complex z = new Complex();
		
		z.re = 3.4;
		z.im = 4.6;		
		z.display();
		z.offset(-0.12);		
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
		Complex z1 = new Complex();
		Complex z2 = new Complex();
		
		z1.re = 3.4;
		z1.im = 4.6;		
		z2.re = 7;
		z2.im = 9;
		
		Complex z;
		
		z = z1.add(z2);
		
		z.display();
		
		z = z1.add(3.1);
		
		z.display();
		
		z = Complex.add(3.1, z1);
		
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
		Complex z1 = new Complex();
		Complex z2 = new Complex();
		
		z1.re = 3.4;
		z1.im = 4.6;		
		z2.re = 7;
		z2.im = 9;
		
		Complex z;
		
		z = z1.subtract(z2);
		
		z.display();
		
		z = z1.subtract(3.1);
		
		z.display();
		
		z = Complex.subtract(3.1, z1);
		
		z.display();
	}
}
```
### Complex sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
	Complex sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Complex z = new Complex();
		
		z.re = 3.4;
		z.im = 4.6;		
		
		Complex conjugate = z.getConjugate();
		
		z.display();
		conjugate.display();		
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
### Random sınıfının nextInt metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Random sınıfının nextInt metodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Random r = new java.util.Random();

		for (int i = 0; i < 10; ++i)
			System.out.println(r.nextInt());		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Random sınıfının nextInt metodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Random r = new java.util.Random();

		for (int i = 0; i < 10; ++i)
			System.out.printf("%d ", r.nextInt(100)); //[0, 100)
		
		System.out.println();
	}
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
	Random sınıfı ile [min, max) arasında değer üretilmesi
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Random r = new java.util.Random();
		
		int min = 10;
		int max = 21;

		for (int i = 0; i < 10; ++i)
			System.out.printf("%d ", r.nextInt(max - min) + min); //[min, max)
		
		System.out.println();
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Random sınıfı ile [min, max) arasında değer üretilmesi
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Random r = new java.util.Random();
		
		int min = 10;
		int max = 21;

		for (int i = 0; i < 10; ++i)
			System.out.printf("%d ", RandomUtil.nextInt(r, min, max)); //[min, max)
		
		System.out.println();
	}
}

class RandomUtil {
	public static int nextInt(java.util.Random r, int min, int max)
	{
		return r.nextInt(max - min) + min;
	}
}
```
### Random sınıfı nextDouble metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	05.07.2020
	Random sınıfı nextDouble metodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Random r = new java.util.Random();	
		
		for (int i = 0; i < 10; ++i)
			System.out.println(r.nextDouble());  //[0, 1)	
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Random sınıfı nextDouble metodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Random r = new java.util.Random();	
		
		double min = 3.456;
		double max = 7.898;
		
		for (int i = 0; i < 10; ++i)
			System.out.println(RandomUtil.nextDouble(r, min, max));	
		
	}
}


class RandomUtil {
	public static double nextDouble(java.util.Random r, double min, double max)
	{
		return r.nextDouble() * (max - min) + min;
	}
	
	public static int nextInt(java.util.Random r, int min, int max)
	{
		return r.nextInt(max - min) + min;
	}
}

```
### Random sınıfının nextLong metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Random sınıfının nextLong metodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Random r = new java.util.Random();		
		
		for (int i = 0; i < 10; ++i)
			System.out.println(r.nextLong());	
		
	}
}

```
### Random sınıfının nextBoolean metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Random sınıfının nextBoolean metodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Random r = new java.util.Random();		
		
		for (int i = 0; i < 10; ++i)
			System.out.println(r.nextBoolean());	
		
	}
}
```
### Sınıf Çalışması: Paranın yazı gelme olasılığının yaklaşık olarak 0.5 olduğunu bulan basit bir simulasyon programını yazınız 
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Paranın yazı gelme olasılığının yaklaşık olarak 0.5 olduğunu bulan basit bir simulasyon 
	programını yazınız 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		CoinSimulationApp.run();		
	}
}

class CoinSimulationApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Parayı kaç kez atmak istiyorsunuz?");
		int n = Integer.parseInt(kb.nextLine());
		
		CoinSimulation coinSimulation = new CoinSimulation();
		
		coinSimulation.run(n);
		
		System.out.printf("p=%.10f%n", coinSimulation.p);
		
	}
}

class CoinSimulation {
	public double p;
	
	public void run(int n)
	{
		java.util.Random r = new java.util.Random();
		
		int sumOfTails = 0;
		
		for (int i = 0; i < n; ++i)
			sumOfTails += r.nextInt(2);
		
		p = (double) sumOfTails / n;
	}
}
```
### Sınıf Çalışması: Paranın yazı gelme olasılığının yaklaşık olarak 0.5 olduğunu bulan basit bir simulasyon programını yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Paranın yazı gelme olasılığının yaklaşık olarak 0.5 olduğunu bulan basit bir simulasyon 
	programını yazınız 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		CoinSimulationApp.run();		
	}
}

class CoinSimulationApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Parayı kaç kez atmak istiyorsunuz?");
		int n = Integer.parseInt(kb.nextLine());
		
		CoinSimulation coinSimulation = new CoinSimulation();
		
		coinSimulation.run(n);
		
		System.out.printf("p=%.10f%n", coinSimulation.p);		
	}
}

class CoinSimulation {
	public double p;
	
	public void run(int n)
	{
		java.util.Random r = new java.util.Random();
		
		int sumOfTails = 0;
		
		for (int i = 0; i < n; ++i)
			if (r.nextBoolean())
				++sumOfTails;
		
		p = (double) sumOfTails / n;
	}
}

```
### Sınıf Çalışması: İki zar atıldığında zarların çift gelmesi (ikisi de aynı) olasılığını yaklaşık hesaplayan basit simülasyon programını yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: İki zar atıldığında zarların çift gelmesi (ikisi de aynı) olasılığını yaklaşık hesaplayan
	basit simülasyon programını yazınız
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		SameDiceSimulationApp.run();		
	}
}

class SameDiceSimulationApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Zarları kaç kez atmak istiyorsunuz?");
		int n = Integer.parseInt(kb.nextLine());
		
		SameDiceSimulation sameDiceSimulation = new SameDiceSimulation ();
		
		sameDiceSimulation.run(n);
		
		System.out.printf("p=%.10f%n", sameDiceSimulation.p);		
	}
}

class SameDiceSimulation {
	public double p;
	
	public static boolean areSame(java.util.Random r)
	{
		return r.nextInt(6) + 1 == r.nextInt(6) + 1;		
	}
	
	public void run(int n)
	{
		java.util.Random r = new java.util.Random();
		
		int sumOfSames = 0;
		
		for (int i = 0; i < n; ++i)
			if (areSame(r))
				++sumOfSames;
		
		p = (double) sumOfSames / n;
	}
}
```
### Tohum değeri setSeed isimli metot ile değiştirilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Tohum değeri setSeed isimli metot ile değiştirilebilir	
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Random r = new java.util.Random();
		
		r.setSeed(200);
		
		for (int i = 0; i < 10; ++i)
			System.out.printf("%d ", r.nextInt(101));
		
		System.out.println();
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Aşağıdaki örnekte üretilen ilk 10 sayı zamana bağlı tohum değeri alınarak, ikinci 10 sayı da klavyeden girilen tohum
	 değerine göre üretilmektedir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		java.util.Random r = new java.util.Random();
		
		System.out.print("Tohum değerini giriniz:");
		long seed = Long.parseLong(kb.nextLine());				
		
		for (int i = 0; i < 10; ++i)
			System.out.printf("%02d ", r.nextInt(100));
		
		System.out.println();
		
		r.setSeed(seed);
		
		for (int i = 0; i < 10; ++i)
			System.out.printf("%02d ", r.nextInt(100));
		
		System.out.println();		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Math sınıfının random metodu [0, 1) aralığında double türden rasgele üretilmiş bir sayı döndürür. Bu metot
	 içsel olarak hep aynı Random nesnesini kullanır. Bu nesne her yaratıldığında yani ilk çağrıldığında tohum değeri
	 zaman bağlı olarak alınıp yaratılır. Aşağıdaki kodun eşdeğeri:
	 
	 java.util.Random r = new java.util.Random();
	 
	 for (int i = 0; i < 10; ++i)
			System.out.println(r.nextDouble());
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{			
		for (int i = 0; i < 10; ++i)
			System.out.println(Math.random());
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Aşağıda kullanılması gerekmese de [min, max) aralığında int türden bir sayı farklı bir yöntemle üretilmiştir.
	 Şüphesiz nextInt metodunun parametreli overload'unu kullanmak daha iyidir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Random r = new java.util.Random();
		int min = 10;
		int max = 21;
		
		for (int i = 0; i < 10; ++i) {
			int val = Math.abs(r.nextInt()) % (max - min) + min;
			
			System.out.println(val);
		}
	}
}
```
### Homework-002-2. sorunun bir çözümü.
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Homework-002-2. sorunun bir çözümü.
	 Not: Ödevin verildiği tarihteki bilgilere göre çözülmüştür. İleride daha iyisi yazılacaktır
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
		
		for (;;) {
			System.out.print("Genişliği giriniz:");
			int width = Integer.parseInt(kb.nextLine());
			
			if (width == 0)
				break;
			
			System.out.print("Yüksekliği  giriniz:");
			int height = Integer.parseInt(kb.nextLine());			
			
			if (width < 0 || height <= 0)
				continue;
			
			BallGame.run(width, height);
		}
	}
}

class BallGame {
	public static void fillWithSpaces(int start, int end)
	{
		for (int i = start; i < end; ++i)
			System.out.print(' ');		
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

	
	public static void playGame(int width, int height)
	{
		int ballIndex = 0;
		boolean flag = true;
		
		for (int i = 1; i <= height; ++i) {
			System.out.print('|');
			fillWithSpaces(0, ballIndex);
			System.out.print('*');
			fillWithSpaces(ballIndex + 1, width);			
			flag = getFlag(ballIndex, width, flag);						
			ballIndex = getBallIndex(ballIndex, width, flag);			
			System.out.println('|');
		}		
	}
	
	public static void run(int width, int height)
	{		
		playGame(width, height);
	}
}
```
### Java'da nesnenin yaratılma aşamaları:
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Java'da nesnenin yaratılma aşamaları:
	 1. Bellekte yer ayrılır
	 2. non-static veri elemanlarına default değerler atanır
	 3. constructor (ctor) çağrılır
	 Bu üç aşamanın sonunda new operatörünün ürettiği değer yani referans elde edilir	  
----------------------------------------------------------------------------------------------------------------------*/
```
### constructor (ctro) özellikleri
```java
/*----------------------------------------------------------------------------------------------------------------------
	ctor aşağıdaki özelliklere sahip bir metottur:
	- Sınıfı yazan programcı sınıfa hiç bir ctor yazmasa bile sınıfın parametresiz ctor'u (default ctor) 
	derleyici içi boş ve public olarak yazılır
	
	- Sınıfı yazan programcı sınıfa en az bir tane bile ctor yazsa default ctor derleyici yazılmaz. Programccının
	ctor default ctor değilse default ctor sınıfta bulunmaz
	
	- Sınıfın ctor'u sınıf ismi ile aynı olan ve geri dönüş değeri kavramı olmayan bir metottur. Geri dönüş bilgisi
	hiç birşey yazılmaz. void da yazılmaz. void yazıldığında error oluşmaz. Ancak bu ctor anlamına gelmez.
	Yapılamamalıdır
	
	- ctor overload edilebilir
	
	- ctor non-static bir metottur
	
	- ctor new operatörü ile nesne yaratılması aşamasında çağrılır. Hangi ctor'un çağrılacağı derleme zamanında
	overload resolution kuralları ile aynı şekilde belirlenir
	
	- ctor'dan veri elemanlarına default değer atanmış olur
	
	- ctor içerisinde return deyimi tek başına olmak üzere istenirse ctor'u sonlandırmak için kullanılabilir
	
	- Programcı ctor çağıramaz. Programcı new operatörü ile ilgili ctor'un ÇAĞRILACAĞI kodu yazar
----------------------------------------------------------------------------------------------------------------------*/
```
### ctor'un çağrılması
```java
/*----------------------------------------------------------------------------------------------------------------------
	ctor'un çağrılması
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Sample s1 = new Sample();
		Sample s2 = new Sample(10);
		Sample s3 = new Sample(10, 3.4);
		Sample s4 = new Sample(10, 10L);
		
		//...
	}
}

class Sample {
	public Sample()
	{
		System.out.println("Sample.Sample()");
	}
	
	public Sample(int a)
	{
		System.out.println("Sample.Sample(int)");
	}
	
	public Sample(int a, double b)
	{
		System.out.println("Sample.Sample(int, double)");
	}
}
```
### ctor non-static bir metottur. Aşağıdaki örnekte doğrudan erişilen x bu ctor ile yaratılan nesnenin x'i olur.
```java
/*----------------------------------------------------------------------------------------------------------------------
	ctor non-static bir metottur. Aşağıdaki örnekte doğrudan erişilen x bu ctor ile yaratılan nesnenin x'i olur
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Sample s = new Sample(10);
		
		System.out.println(s.x);
	}
}

class Sample {
	public int x;	
	
	public Sample(int a)
	{
		x = a;
		System.out.println("Sample.Sample(int)");
	}	
}
```
### ctor öncesinde default değerler atanmış olur
```java
/*----------------------------------------------------------------------------------------------------------------------
	ctor öncesinde default değerler atanmış olur
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Sample s = new Sample(10);
		
		System.out.println(s.x);
		System.out.println(s.y);
	}
}

class Sample {
	public int x;
	public boolean y;	
	
	public Sample(int a)
	{
		System.out.printf("x=%d%n", x);
		System.out.printf("y=%b%n", y);
	}	
}
```
### ctor içerisinde return kullanımı
```java
/*----------------------------------------------------------------------------------------------------------------------
	ctor içerisinde return kullanımı
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Sample s = new Sample(-10);
		
		System.out.println(s.x);
		
	}
}

class Sample {
	public int x;		
	
	public Sample(int a)
	{
		if (a > 0)
			return;
		
		x = -a;
	}	
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	ctor içerisinde veri elemanlarına değer atanması çok sık yapılır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Sample s = new Sample(-10, true);
		
		System.out.println(s.x);
		System.out.println(s.y);
		
		Sample k = new Sample(-34);
		
		System.out.println(k.x);
		System.out.println(k.y);		
	}
}

class Sample {
	public int x;
	public boolean y;
	
	public Sample(int a)
	{
		x = a;		 
	}
	
	public Sample(int a, boolean b)
	{
		x = Math.abs(a);
		y = b;		
	}	
}
```
### Point sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Point sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		Point p1 = new Point();
		
		p1.display();
		
		Point p2 = new Point(100, 34);
		
		p2.display();
		
		Point p3 = new Point(100);
		
		p3.display();
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
	
	public void display()
	{
		System.out.printf("{x = %d, y = %d}%n", x, y);		
	}
}



/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/
```
