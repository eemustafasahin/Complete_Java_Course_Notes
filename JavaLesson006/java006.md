### Sınıf Çalışması: Parametresi ile aldığı int türden bir n değeri için n-inci asal sayıyı döndüren getPrime isimli metodu yazınız.
```java
/*----------------------------------------------------------------------------------------------------------------------
	13.06.2020
	Sınıf Çalışması: Parametresi ile aldığı int türden bir n değeri için n-inci asal sayıyı döndüren 
	getPrime isimli metodu yazınız:
	Açıklamalar:
	- isPrime metodununu kullanınız
	- Metot n'nin pozitif olmayan değerleri için -1 sayısını döndürecektir
	- Metodu klavyeden alınan değerlerle çağırarak test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		GetPrimeTest.run();			
	}
}

class GetPrimeTest {
	public static void run()
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.printf("Kaçıncı asal sayıyı istiyorsun?");
			int n = Integer.parseInt(kb.nextLine());
			
			if (n <= 0)
				return;
			
			int val = NumberUtil.getPrime(n);
			
			System.out.printf("%d. asal sayı:%d%n", n, val);
		}
	}
}

class NumberUtil {
	public static int getPrime(int n)
	{
		if (n <= 0)
			return -1;
		
		int count = 0;
		int val = 2;
		
		for (;;) {
			if (isPrime(val))
				++count;
			
			if (count == n)
				return val;
			
			++val;
		}
	}
	
	public static boolean isPrime(int val)
	{
		if (val <= 1)
			return false;
		
		if (val % 2 == 0)
			return val == 2;
		
		if (val % 3 == 0)
			return val == 3;
		
		if (val % 5 == 0)
			return val == 5;
		
		if (val % 7 == 0)
			return val == 7;		
		
		for (int i = 11; i * i <= val; i += 2)			
			if (val % i == 0)
				return false;		
		
		return true;			 
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden bir n değeri için n-inci asal sayıyı döndüren 
	getPrime isimli metodu yazınız:
	Açıklamalar:
	- isPrime metodununu kullanınız
	- Metot n'nin pozitif olmayan değerleri için -1 sayısını döndürecektir
	- Metodu klavyeden alınan değerlerle çağırarak test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		GetPrimeTest.run();			
	}
}

class GetPrimeTest {
	public static void run()
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.printf("Kaçıncı asal sayıyı istiyorsun?");
			int n = Integer.parseInt(kb.nextLine());
			
			if (n <= 0)
				return;
			
			int val = NumberUtil.getPrime(n);
			
			System.out.printf("%d. asal sayı:%d%n", n, val);
		}
	}
}

class NumberUtil {
	public static int getPrime(int n)
	{
		if (n <= 0)
			return -1;
		
		int count = 0;
		int val = 2;
		
		for (int i = 2; count < n; ++i)
			if (isPrime(i)) {
				++count;
				val = i;
			}		
		
		return val;
	}
	
	public static boolean isPrime(int val)
	{
		if (val <= 1)
			return false;
		
		if (val % 2 == 0)
			return val == 2;
		
		if (val % 3 == 0)
			return val == 3;
		
		if (val % 5 == 0)
			return val == 5;
		
		if (val % 7 == 0)
			return val == 7;		
		
		for (int i = 11; i * i <= val; i += 2)			
			if (val % i == 0)
				return false;		
		
		return true;			 
	}
}
```
### Sınıf Çalışması: Parametresi ile aldığı n sayısı için n-inci fibonacci sayısını döndüren getFibonacci isimli metodu yazınız.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı n sayısı için n-inci fibonacci sayısını döndüren getFibonacci
	isimli metodu yazınız:
	Açıklamalar:
		- Fibonacci sayıları:
			0 1 1 2 3 5 8 13 21 ...
		- Metot 1 den küçük n değerleri için -1 değerini döndürecektir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		GetFibonnaciTest.run();			
	}
}

class GetFibonnaciTest {
	public static void run()
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.printf("Kaçıncı Fibonacci sayısını istiyorsun?");
			int n = Integer.parseInt(kb.nextLine());
			
			if (n <= 0)
				return;
			
			int val = NumberUtil.getFibonacciNumber(n);
			
			System.out.printf("%d. fibonacci sayısı:%d%n", n, val);
		}
	}
}

class NumberUtil {
	public static int getFibonacciNumber(int n)
	{
		if (n <= 0)
			return -1;
		
		if (n <= 2)
			return n - 1;
		
		int prev1 = 1, prev2 = 0, val = 0;
		
		for (int i = 2; i < n; ++i) {
			val = prev1 + prev2;
			prev2 = prev1;
			prev1 = val;
		}
		
		return val;		
	}
}
```
### Sınıf Çalışması: Parametresi ile aldığı sayıdan büyük ilk Fibonacci sayısını döndüren getNextFibonacciNumber isimli metodu yazınız ve test ediniz
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı sayıdan büyük ilk Fibonacci sayısını döndüren getNextFibonacciNumber
	isimli metodu yazınız ve test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		GetNextFibonacciNextTest.run();
	}
}

class GetNextFibonacciNextTest {
	public static void run()
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.printf("Bir sayı giriniz?");
			int n = Integer.parseInt(kb.nextLine());
			
			if (n <= -999)
				return;
			
			int val = NumberUtil.getNextFibonacciNumber(n);
			
			System.out.printf("%d. sayısından sonraki ilk fibonacci sayısı:%d%n", n, val);
		}
	}
}

class NumberUtil {
	public static int getNextFibonacciNumber(int val)
	{
		if (val < 0)
			return 0;
		
		int prev1 = 1, prev2 = 0, result;
		
		for (;;) {
			result = prev1 + prev2;
			
			if (result > val)
				return result;
			
			prev2 = prev1;
			prev1 = result;
		}
	}
}
```
### İçiçe döngüler
```java
/*----------------------------------------------------------------------------------------------------------------------
	İçiçe döngüler
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		for (int i = 0; i < 3; ++i)
			for (int k = 3; k >= 0; --k)
				System.out.printf("(%d, %d)%n", i, k);		
			
	}
}

```
### Programcı bazen tek bir döngü yazsada döngü içerisinde çağrılan metotlar içerisinde de döngü kullanılmışsa içiçe döngü yazılmış olur
```java
/*----------------------------------------------------------------------------------------------------------------------
	Programcı bazen tek bir döngü yazsada döngü içerisinde çağrılan metotlar içerisinde de döngü kullanılmışsa
	içiçe döngü yazılmış olur
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		for (int i = 0; i < 3; ++i)
			Sample.foo(i);			
	}
}


class Sample {
	public static void foo(int i)
	{
		for (int k = 3; k >= 0; --k)
			System.out.printf("(%d, %d)%n", i, k);		
	}
}
```
### 3 basamanklı Armstrong sayılarının içiçe döngü ile bulunuşu
```java
/*----------------------------------------------------------------------------------------------------------------------
	3 basamanklı Armstrong sayılarının içiçe döngü ile bulunuşu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		for (int a = 1; a <= 9; ++a)
			for (int b = 0; b <= 9; ++b)
				for (int c = 0; c <= 9; ++c)
					if (a * a * a + b * b * b + c * c * c == 100 * a + 10 * b + c)
						System.out.printf("%d%d%d%n", a, b, c);
	}
}
```
### break deyiminin genel biçimi.
```java
/*----------------------------------------------------------------------------------------------------------------------
	break deyiminin genel biçimi:
	break [etiket ismi];
	break deyimi dendiğindde ilk akla etiketsiz kullanım gelir. Etiketli kullanıma "labeled break" denir.
	break deyimi ilgili döngüyü sonlandırmak için kullanılır
----------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------
	break deyiminin etiketsiz kullanımı. Aşağıdaki örnekte klavyeden sıfır girilene kadar alınan sayıların
	toplamı bulunmaktadır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		System.out.println("Sayıları girmeye başlayınız:");
		
		int sum = 0;
		
		for (;;) {
			int val = Integer.parseInt(kb.nextLine());
			
			if (val == 0)
				break;
			
			sum += val;
		}
		
		System.out.printf("Toplam:%d%n", sum);
	}
}
```
### Aşağıdaki örnekte içteki döngüde bir koşul gerçekleştiğinde dıştaki döngü sonlandırılmıştır
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte içteki döngüde bir koşul gerçekleştiğinde dıştaki döngü sonlandırılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		boolean flag = false;
		
		for (int i = 0; i < 10; ++i) {			
			for (int k = 6; k >= 1; --k) {
				System.out.printf("(%d, %d)%n", i, k);
				if ((i + k) % 11 == 0) {
					flag = true;
					break;
				}
			}			
			
			if (flag)
				break;
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

```
### Etiketli break deyimi ile yukarıdaki örnek daha okunabilir olarak değiştirilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Etiketli break deyimi ile yukarıdaki örnek daha okunabilir olarak değiştirilebilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		EXIT_LOOP:
		for (int i = 0; i < 10; ++i) {			
			for (int k = 6; k >= 1; --k) {
				System.out.printf("(%d, %d)%n", i, k);
				if ((i + k) % 11 == 0) 
					break EXIT_LOOP;
			}			
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
### Etiketli break deyiminin kullanımı
```java
/*----------------------------------------------------------------------------------------------------------------------
	Etiketli break deyiminin kullanımı
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		EXIT_LOOP:
		for (int i = 0; i < 10; ++i) {
			EXIT_INNER_LOOP:
			for (int j = 10; j < 100; ++j) {
				for (int k = 6; k >= 1; --k) {
					System.out.printf("(%d, %d, %d)%n", i, j, k);
					if ((i + j + k) % 8 == 0) 
						break EXIT_INNER_LOOP;
					
					if ((i + j + k) % 11 == 0) 
						break EXIT_LOOP;
				}			
			}
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
### continue deyimi döngüyü değil döngünün adımını sonlandırır
```java
/*----------------------------------------------------------------------------------------------------------------------
	continue deyimi döngüyü değil döngünün adımını sonlandırır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		for (int i = 0; i < 100; ++i) {
			if (i % 2 == 0)
				continue;
			
			System.out.printf("%d ", i);
		}		
		
		System.out.println();
	}
}
```
### Menülerle işlem yapılabilen basit bir iskelet program
```java
/*----------------------------------------------------------------------------------------------------------------------
	14.06.2020
	Menülerle işlem yapılabilen basit bir iskelet program
	(İleride daha iyisi yazılacaktır)
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		MenuApp.run();		
	}
}

class MenuApp {
	public static void run()
	{
		Menu.run();
	}
}

class Menu {
	public static void displayMenu()
	{
		System.out.println("1.Ekle");
		System.out.println("2.Güncelle");
		System.out.println("3.Sil");
		System.out.println("4.Listele");
		System.out.println("5.Çıkış");
		System.out.print("Seçenek:");
	}
	
	public static void doWorkForInsert() 
	{
		System.out.println("*****************");
		System.out.println("Ekle seçildi");
		System.out.println("*****************");
	}
	
	public static void doWorkForUpdate() 
	{
		System.out.println("*****************");
		System.out.println("Güncelle seçildi");
		System.out.println("*****************");
	}
	
	public static void doWorkForDelete() 
	{
		System.out.println("*****************");
		System.out.println("Sil seçildi");
		System.out.println("*****************");
	}
	
	public static void doWorkForList() 
	{
		System.out.println("*****************");
		System.out.println("Listele seçildi");
		System.out.println("*****************");
	}
	
	public static void doWork(int option)
	{
		if (option == 1)
			doWorkForInsert();
		else if (option == 2)
			doWorkForUpdate();
		else if (option == 3)
			doWorkForDelete();
		else 
			doWorkForList();		
	}
	
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			displayMenu();
			
			int option = Integer.parseInt(kb.nextLine());
			
			if (option < 1 || option > 5) {
				System.out.println("Geçersiz seçenek");
				continue;
			}
			
			if (option == 5)
				break;
			
			doWork(option);
		}				
		
		System.out.println("Tekrar yapınız!!");
	}
}
```
### switch deyiminin genel biçimi
```java
/*----------------------------------------------------------------------------------------------------------------------
	switch deyiminin genel biçimi:
	switch (<ifade>) {
	case <sabit ifadesi>:
		<deyim>
	case <sabit ifadesi>:
		<deyim>
	[
	default:
		<deyim>
	]	
	}
	
	switch deyiminin parantez içerisindeki ifadesi temel türler için tamsayı türlerinden biri veya char olabilir.
	Bunlar dışında bu ifade String veya enum türlerinden de olabilir. Bu türler ileride ele alınacaktır.
	case bölümlerine ilişkin ifadelerin sabit ifadesi olması gerekir.
	switch deyiminde default kısmı olmak zorunda değildir
----------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki switch deyiminin if deyimi karşılığı:
	if (plate == 34)
		System.out.println("İstanbul");
	else if (plate == 6)
		System.out.println("Ankara");
	else if (plate == 35)
		System.out.println("İzmir");
	else
		System.out.println("Geçersiz plaka değeri");	
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Plaka numarasını giriniz:");
		int plate = Integer.parseInt(kb.nextLine());
		
		switch (plate) {
		case 34:
			System.out.println("İstanbul");
			break;
		case 6:
			System.out.println("Ankara");
			break;
		case 35:
			System.out.println("İzmir");
			break;
		default:
			System.out.println("Geçersiz plaka değeri");
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
### switch deyiminde default bölüm olmak zorunda değildir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	switch deyiminde default bölüm olmak zorunda değildir.
	Aşağıdaki switch deyiminin if deyimi karşılığı:
	if (plate == 34)
		System.out.println("İstanbul");
	else if (plate == 6)
		System.out.println("Ankara");
	else if (plate == 35)
		System.out.println("İzmir");		
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Plaka numarasını giriniz:");
		int plate = Integer.parseInt(kb.nextLine());
		
		switch (plate) {
		case 34:
			System.out.println("İstanbul");
			break;
		case 6:
			System.out.println("Ankara");
			break;
		case 35:
			System.out.println("İzmir");
			break;		
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
### switch deyiminde default bölümününm yerinin önemi yoktur. Şüphesiz sona konması daha uygundur
```java
/*----------------------------------------------------------------------------------------------------------------------
	switch deyiminde default bölümününm yerinin önemi yoktur. Şüphesiz sona konması daha uygundur	
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Plaka numarasını giriniz:");
		int plate = Integer.parseInt(kb.nextLine());
		
		switch (plate) {
		default:
			System.out.println("Geçersiz plaka değeri");
			break;
		case 34:
			System.out.println("İstanbul");
			break;
		case 6:
			System.out.println("Ankara");
			break;
		case 35:
			System.out.println("İzmir");
			break;		
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
### switch deyiminde bir case bölümüne ilişkin ifadenin sabit ifadesi olması gerekir
```java
/*----------------------------------------------------------------------------------------------------------------------
	switch deyiminde bir case bölümüne ilişkin ifadenin sabit ifadesi olması gerekir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Plaka numarasını giriniz:");
		int plate = Integer.parseInt(kb.nextLine());
		
		int a = 34;
		
		switch (plate) {			
		case a: //error
			System.out.println("İstanbul");
			break;
		case 6:
			System.out.println("Ankara");
			break;
		case 35:
			System.out.println("İzmir");
			break;		
		default:
			System.out.println("Geçersiz plaka değeri");
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
### switch deyiminde birden fazla aynı değere sahip case bölümü geçersizdir
```java
/*----------------------------------------------------------------------------------------------------------------------
	switch deyiminde birden fazla aynı değere sahip case bölümü geçersizdir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Plaka numarasını giriniz:");
		int plate = Integer.parseInt(kb.nextLine());		
		
		switch (plate) {			
		case 34:
			System.out.println("İstanbul");
			break;
		case 6: //error
			System.out.println("Ankara");
			break;
		case 6: //error
			System.out.println("Ankara");
			break;
		case 35:
			System.out.println("İzmir");
			break;		
		default:
			System.out.println("Geçersiz plaka değeri");
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
### switch deyiminde birden fazla aynı değere sahip case bölümü geçersizdir (2)
```java
/*----------------------------------------------------------------------------------------------------------------------
	switch deyiminde birden fazla aynı değere sahip case bölümü geçersizdir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Plaka numarasını giriniz:");
		int plate = Integer.parseInt(kb.nextLine());		
		
		switch (plate) {			
		case 34:
			System.out.println("İstanbul");
			break;
		case 6: //error
			System.out.println("Ankara");
			break;
		case 3 + 3: //error
			System.out.println("Ankara");
			break;
		case 35:
			System.out.println("İzmir");
			break;		
		default:
			System.out.println("Geçersiz plaka değeri");
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
### switch deyiminde temel türler için tamsayı türleri ve char türü dışında hiç bir tür kullanılamaz.
```java
/*----------------------------------------------------------------------------------------------------------------------
	switch deyiminde temel türler için tamsayı türleri ve char türü dışında hiç bir tür kullanılamaz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Plaka numarasını giriniz:");
		double plate = Double.parseDouble(kb.nextLine());		
		
		switch (plate) {	 //error		
		case 3.4:
			System.out.println("İstanbul");
			break;
		case 6: 
			System.out.println("Ankara");
			break;
			
		case 35:
			System.out.println("İzmir");
			break;		
		default:
			System.out.println("Geçersiz plaka değeri");
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
### switch deyiminde aşağı düşme (fall through) özelliği vardır.
```java
/*----------------------------------------------------------------------------------------------------------------------
	switch deyiminde aşağı düşme (fall through) özelliği vardır. Bir case bölümü veya default yakalandığında
	aşağı doğru engelleyen herhangi bir deyim yoksa yukarıdan aşağıya tüm bölümler yapılır. break deyimi
	switch deyimini sonlandırmakta kullanılır. Şüphesiz başka deyimler de aşağı düşmeyi engelleyebilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Plaka numarasını giriniz:");
		int plate = Integer.parseInt(kb.nextLine());		
		
		switch (plate) {		
		case 34:
			System.out.println("İstanbul");
		case 6: 
			System.out.println("Ankara");						
		case 35:
			System.out.println("İzmir");		
			break;
		default:
			System.out.println("Geçersiz plaka değeri");
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte 34 için ve 6 için Ankara yazısı ekrana basılmak istendiğinde aşağı düşme özelliğinden 
	yararlanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Plaka numarasını giriniz:");
		int plate = Integer.parseInt(kb.nextLine());		
		
		switch (plate) {		
		case 34:
			System.out.println("İstanbul");			
		case 6:		
			System.out.println("Ankara");
			break;		
		default:
			System.out.println("Geçersiz plaka değeri");
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki 34 ve 6 değerleri için case bölümlerine ilişkin kodun daha kısa yapılış yöntemi yoktur
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Plaka numarasını giriniz:");
		int plate = Integer.parseInt(kb.nextLine());		
		
		switch (plate) {		
		case 34:						
		case 6:		
			System.out.println("Büyük şehir");
			break;		
		case 67:
			System.out.println("Zonguldak");
			break;
		default:
			System.out.println("Geçersiz plaka değeri");
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
### switch deyimi char türü için de kullanılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	switch deyimi char türü için de kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		char option = 'e';
		
		switch (option) {
		case 'e':
		case 'E':
			System.out.println("Ekle");
			break;
		case 's':
		case 'S':
			System.out.println("Sil");
			break;
		default:
			System.out.println("Geçersiz seçenek");
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
### Menülerle işlem yapılabilen basit bir iskelet program
```java
/*----------------------------------------------------------------------------------------------------------------------
	Menülerle işlem yapılabilen basit bir iskelet program
	(İleride daha iyisi yazılacaktır)
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		MenuApp.run();		
	}
}

class MenuApp {
	public static void run()
	{
		Menu.run();
	}
}

class Menu {
	public static void displayMenu()
	{
		System.out.println("1.Ekle");
		System.out.println("2.Güncelle");
		System.out.println("3.Sil");
		System.out.println("4.Listele");
		System.out.println("5.Çıkış");
		System.out.print("Seçenek:");
	}
	
	public static void doWorkForInsert() 
	{
		System.out.println("*****************");
		System.out.println("Ekle seçildi");
		System.out.println("*****************");
	}
	
	public static void doWorkForUpdate() 
	{
		System.out.println("*****************");
		System.out.println("Güncelle seçildi");
		System.out.println("*****************");
	}
	
	public static void doWorkForDelete() 
	{
		System.out.println("*****************");
		System.out.println("Sil seçildi");
		System.out.println("*****************");
	}
	
	public static void doWorkForList() 
	{
		System.out.println("*****************");
		System.out.println("Listele seçildi");
		System.out.println("*****************");
	}
	
	
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		EXIT_MENU:
		for (;;) {
			displayMenu();
			
			int option = Integer.parseInt(kb.nextLine());
			
			switch (option) {
			case 1:
				doWorkForInsert();
				break;
			case 2:
				doWorkForUpdate();
				break;
			case 3:
				doWorkForDelete();
				break;
			case 4:
				doWorkForList();
				break;
			case 5:				
				break EXIT_MENU;
			default:
				System.out.println("Geçersiz seçenek");
			}
		}				
		
		System.out.println("Tekrar yapınız!!");
	}
}
```
### Menülerle işlem yapılabilen basit bir iskelet program
```java
/*----------------------------------------------------------------------------------------------------------------------
	Menülerle işlem yapılabilen basit bir iskelet program
	(İleride daha iyisi yazılacaktır)
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		MenuApp.run();		
	}
}

class MenuApp {
	public static void run()
	{
		Menu.run();
	}
}

class Menu {
	public static void displayMenu()
	{
		System.out.println("1.Ekle");
		System.out.println("2.Güncelle");
		System.out.println("3.Sil");
		System.out.println("4.Listele");
		System.out.println("5.Çıkış");
		System.out.print("Seçenek:");
	}
	
	public static void doWorkForInsert() 
	{
		System.out.println("*****************");
		System.out.println("Ekle seçildi");
		System.out.println("*****************");
	}
	
	public static void doWorkForUpdate() 
	{
		System.out.println("*****************");
		System.out.println("Güncelle seçildi");
		System.out.println("*****************");
	}
	
	public static void doWorkForDelete() 
	{
		System.out.println("*****************");
		System.out.println("Sil seçildi");
		System.out.println("*****************");
	}
	
	public static void doWorkForList() 
	{
		System.out.println("*****************");
		System.out.println("Listele seçildi");
		System.out.println("*****************");
	}
	
	public static boolean isQuit(int option)
	{
		boolean status = false;
		
		switch (option) {
		case 1:
			doWorkForInsert();
			break;
		case 2:
			doWorkForUpdate();
			break;
		case 3:
			doWorkForDelete();
			break;
		case 4:
			doWorkForList();
			break;
		case 5:	
			status = true;
			break;
		default:
			System.out.println("Geçersiz seçenek");
		}		
		
		return status;
	}
	
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);		
		
		for (;;) {
			displayMenu();
			
			int option = Integer.parseInt(kb.nextLine());

			if (isQuit(option))
				break;		
		}				
		
		System.out.println("Tekrar yapınız!!");
	}
}
```
### Sınıf çalışması: Parametresi ile aldığı int türden bir yıl değerine göre yılın artık yıl olup olmadığını test eden isLeapYear isimli metodu yazınız ve test ediniz
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf çalışması: Parametresi ile aldığı int türden bir yıl değerine göre yılın artık yıl olup olmadığını
	test eden isLeapYear isimli metodu yazınız ve test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{							
		IsLeapYearTest.run();
	}
}

class IsLeapYearTest {
	public static void run()
	{
		for (int year = 1999; year <= 2105; ++year)
			if (DateUtil.isLeapYear(year))
				System.out.printf("%d ", year);
		
		System.out.println();
	}	
}

class DateUtil {
	public static boolean isLeapYear(int year)
	{
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
}
```
### Sınıf çalışması: Parametresi ile aldığı int türden gün, ay ve yıl bilgilerine ilişkin tarihin geçerli bir tarih olup olmadığını test eden isValidDate isimli metodu yazınız ve test ediniz
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf çalışması: Parametresi ile aldığı int türden gün, ay ve yıl bilgilerine ilişkin tarihin geçerli bir
	tarih olup olmadığını test eden isValidDate isimli metodu yazınız ve test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{							
		IsValidDateTest.run();
	}
}

class IsValidDateTest {
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
			
			if (DateUtil.isValidDate(day, month, year))
				System.out.printf("%02d/%02d/%04d tarihi geçerlidir%n", day, month, year);
			else
				System.out.println("Geçersiz tarih");	
			
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}	
}

class DateUtil {
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
### Sınıf çalışması: Parametresi ile aldığı int türden gün, ay ve yıl bilgilerine ilişkin tarihin yılın kaçıncı günü olduğunu döndüren getDayOfYear isimli metodu yazınız ve test ediniz.
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



/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/
```
