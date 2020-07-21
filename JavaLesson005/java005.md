### if deyiminin koşul parantezinde boolean türden ifadeler için == veya != operatörleri kullanılması
```java
/*----------------------------------------------------------------------------------------------------------------------
	06.06.2020
	if deyiminin koşul parantezinde boolean türden ifadeler için == veya != operatörleri kullanılması
	iyi bir teknik değildir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());	
		
		Util.displayStatus(val % 2 == 0);
		
		System.out.println("Tekrar yapıyor musunuz?");		
	}
}

class Util {
	public static void displayStatus(boolean flag)
	{
		if (flag) // if (flag == true) 
			System.out.println("Çift");
		else
			System.out.println("Tek");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	if deyiminin koşul parantezinde boolean türden ifadeler için == veya != operatörleri kullanılması
	iyi bir teknik değildir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());	
		
		Util.displayStatus(val % 2 == 0);
		
		System.out.println("Tekrar yapıyor musunuz?");		
	}
}

class Util {
	public static void displayStatus(boolean flag)
	{
		if (!flag) // if (flag != true) 
			System.out.println("Tek");
		else
			System.out.println("Çift");
	}
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki isEven metodunda else kullanımına gerek yoktur. Çünkü return deyimi metodu sonlandırır. Dolayısıyla
	akış return deyimine geldiğinden deyimin aşağına inemez
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());	
		
		Util.displayStatus(NumberUtil.isEven(val));
		
		System.out.println("Tekrar yapıyor musunuz?");		
	}
}

class NumberUtil {
	public static boolean isEven(int val)
	{
		if (val % 2 == 0)
			return true;
		
		return false;
	}
}

class Util {
	public static void displayStatus(boolean flag)
	{
		if (!flag) 
			System.out.println("Tek");
		else
			System.out.println("Çift");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	isEven metodu aşağıdaki gibi daha profesyonel yazılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());	
		
		Util.displayStatus(NumberUtil.isEven(val));
		
		System.out.println("Tekrar yapıyor musunuz?");		
	}
}

class NumberUtil {
	public static boolean isEven(int val)
	{
		return val % 2 == 0;
	}
}

class Util {
	public static void displayStatus(boolean flag)
	{
		if (!flag) 
			System.out.println("Tek");
		else
			System.out.println("Çift");
	}
}
```
### isEven metodu kullanarak isOdd metodu aşağıdaki gibi yazılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	isEven metodu kullanarak isOdd metodu aşağıdaki gibi yazılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());	
		
		Util.displayStatus(!NumberUtil.isOdd(val));
		
		System.out.println("Tekrar yapıyor musunuz?");		
	}
}

class NumberUtil {
	public static boolean isEven(int val)
	{
		return val % 2 == 0;
	}
	
	public static boolean isOdd(int val)
	{
		return !isEven(val);
	}
}

class Util {
	public static void displayStatus(boolean flag)
	{
		if (flag) 
			System.out.println("Çift");
		else
			System.out.println("Tek");
	}
}
```
### boolean türden bir metot çağrısının if deyiminde kullanımı
```java
/*----------------------------------------------------------------------------------------------------------------------
	boolean türden bir metot çağrısının if deyiminde kullanımı
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());	
		
		if (NumberUtil.isEven(val)) // if (NumberUtil.isEven(val) == true)
			System.out.println("Çift");
		else
			System.out.println("Tek");
		
		System.out.println("Tekrar yapıyor musunuz?");		
	}
}

class NumberUtil {
	public static boolean isEven(int val)
	{
		return val % 2 == 0;
	}	
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	boolean türden bir metot çağrısının if deyiminde kullanımı
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());	
		
		if (!NumberUtil.isEven(val)) // if (NumberUtil.isEven(val) == false)			
			System.out.println("Tek");
		else
			System.out.println("Çift");
		
		System.out.println("Tekrar yapıyor musunuz?");		
	}
}

class NumberUtil {
	public static boolean isEven(int val)
	{
		return val % 2 == 0;
	}	
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte bir tane if deyimi vardır. Bu if deyiminin else kısmında başka if deyimi yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());	
		
		if (val > 0) 
			System.out.println("Pozitif");
		else 
			if (val == 0)
				System.out.println("Sıfır");
			else
				System.out.println("Negatif");
		
		System.out.println("Tekrar yapıyor musunuz?");		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki if deyimi aşağıdaki gibi daha okunabilir olarak yazılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());	
		
		if (val > 0) 
			System.out.println("Pozitif");		
		else if (val == 0)			
			System.out.println("Sıfır");
		else
			System.out.println("Negatif");
		
		System.out.println("Tekrar yapıyor musunuz?");		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki if deyimi aşağıdaki gibi daha okunabilir olarak yazılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());	
		
		if (val > 0) 
			System.out.println("Pozitif");		
		else if (val == 0)			
			System.out.println("Sıfır");
		else
			System.out.println("Negatif");
		
		System.out.println("Tekrar yapıyor musunuz?");		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki koşullar ayrık olduğundan else-if kullanılması daha uygundur
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());	
		
		if (val > 0) 
			System.out.println("Pozitif");		
		if (val == 0)
			System.out.println("Sıfır");
		if (val < 0)
			System.out.println("Negatif");
		
		System.out.println("Tekrar yapıyor musunuz?");		
	}
}
```
### Sınıf Çalışması: Katsayıları klavyeden girilen ikinci dereceden bir denklemin köklerini bulup ekrana basan programı yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Katsayıları klavyeden girilen ikinci dereceden bir denklemin köklerini bulup ekrana 
	basan programı yazınız
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		EquationSolverApp.run();	
	}
}

class EquationSolverApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("a?");
		double a = Double.parseDouble(kb.nextLine());
		System.out.print("b?");
		double b = Double.parseDouble(kb.nextLine());
		System.out.print("c?");		
		double c = Double.parseDouble(kb.nextLine());
		
		EquationSolver.findRoots(a, b, c);
	}
}

class EquationSolver {	
	public static void findRoots(double a, double b, double c)
	{
		double delta = b * b - 4 * a * c;
		
		if (delta > 0) {
			double sqrtDelta = Math.sqrt(delta);
			double divider = 2 * a;			
			double x1 = (-b + sqrtDelta) / divider;
			double x2 = (-b - sqrtDelta) / divider;
			
			System.out.printf("x1=%f, x2=%f%n", x1, x2);			
		}
		else if (delta == 0) {
			double x = -b / (2 * a);
			
			System.out.printf("x1=x2=%f%n", x);
		}
		else 
			System.out.println("Gerçek kök yok");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Katsayıları klavyeden girilen ikinci dereceden bir denklemin köklerini bulup ekrana 
	basan programı yazınız
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		EquationSolverApp.run();	
	}
}

class EquationSolverApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("a?");
		double a = Double.parseDouble(kb.nextLine());
		System.out.print("b?");
		double b = Double.parseDouble(kb.nextLine());
		System.out.print("c?");		
		double c = Double.parseDouble(kb.nextLine());
		
		EquationSolver.findRoots(a, b, c);
	}
}

class EquationSolver {	
	public static void findRoots(double a, double b, double c)
	{
		double delta = b * b - 4 * a * c;
		
		if (delta >= 0) {
			double sqrtDelta = Math.sqrt(delta);
			double divider = 2 * a;			
			double x1 = (-b + sqrtDelta) / divider;
			double x2 = (-b - sqrtDelta) / divider;
			
			System.out.printf("x1=%f, x2=%f%n", x1, x2);			
		}		
		else 
			System.out.println("Gerçek kök yok");
	}
}
```
### Döngü deyimleri
```java
/*----------------------------------------------------------------------------------------------------------------------
	Döngü deyimleri:
	1. while döngü deyimleri
		- Kontrolün başta yapıldığı while döngü deyimi (while döngüsü)
		- Kontrolün sonda yapıldığı while döngü deyimi (do-while döngüsü)
	2. for döngü deyimi
	3. for-each döngü deyimi
----------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------
	Kontrolün başta yapıldığı while döngü deyimi (while döngüsü):
	
	while (<koşul ifadesi>)
		<deyim>
		
	koşul ifadesinin boolean türden olması gerekir. 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int n = Integer.parseInt(kb.nextLine());
		
		int i = 0;
		
		while (i < n) {
			System.out.printf("i=%d%n", i);
			++i;
		}
		
		System.out.printf("Döngü sonrası-i:%d%n", i);
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	while döngüsünde yanlışlıkla noktalı virgül konması durumu 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int n = Integer.parseInt(kb.nextLine());
		
		int i = 0;
		
		while (i < n); {
			System.out.printf("i=%d%n", i);
			++i;
		}
		
		System.out.printf("Döngü sonrası-i:%d%n", i);
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
### while döngüsünde n-kez dönen döngü kalıbı (dizi uyumlu)
```java
/*----------------------------------------------------------------------------------------------------------------------
	while döngüsünde n-kez dönen döngü kalıbı (dizi uyumlu) 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int n = Integer.parseInt(kb.nextLine());
		
		int i = 0;
		
		while (i < n) {
			System.out.printf("i=%d%n", i);
			++i;
		}
		
		System.out.printf("Döngü sonrası-i:%d%n", i);
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
### while döngüsünde n-kez dönen döngü kalıbı
```java
/*----------------------------------------------------------------------------------------------------------------------
	while döngüsünde n-kez dönen döngü kalıbı
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int n = Integer.parseInt(kb.nextLine());
		
		int i = 1;
		
		while (i <= n) {
			System.out.printf("i=%d%n", i);
			++i;
		}
		
		System.out.printf("Döngü sonrası-i:%d%n", i);
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	while döngüsünde n-kez dönen döngü kalıbı (dizi uyumlu)
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int n = Integer.parseInt(kb.nextLine());
		
		int i = n - 1;
		
		while (i >= 0) {
			System.out.printf("i=%d%n", i);
			--i;
		}
		
		System.out.printf("Döngü sonrası-i:%d%n", i);
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	while döngüsünde n-kez dönen döngü kalıbı:
	
	n = 4 -> (döngünün içinde basılacak değerler) 3 -> 2 -> 1 -> 0 ->  (döngü bitiminde n nin değeri) -1
	count: + + + + -> 4
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int n = Integer.parseInt(kb.nextLine());
		
		while (n-- > 0)
			System.out.printf("n=%d%n", n);
		
		System.out.printf("Döngü sonrası-n:%d%n", n);
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
### while döngüsünün parantezi içerisinde okunabilirliği etkilemedeği sürece aşağıdaki gibi bir kod yazılabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	while döngüsünün parantezi içerisinde bir değişkene değer atanıp atanan değerin kontrolüne ilişkin
	algoritmalar olabilmektedir. Okunabilirliği etkilemedeği sürece aşağıdaki gibi bir kod yazılabilir.
	Aşağıdaki örnekte klavyeden sıfır girilene kadar alınan değerlerin toplamı bulunmuştur
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Sayıları girmeye başlayınız:");
		
		int sum = 0;		
		int val;
		
		while ((val = Integer.parseInt(kb.nextLine())) != 0)
			sum += val;
		
		System.out.printf("Toplam:%d%n", sum);		
	}
}
```
### Sınıf Çalışması: Klavyeden sıfır girilene kadar alınan sayıların pozitif ve negatif olanlarının ayrı ayrı toplamlarını bulan programı yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Klavyeden sıfır girilene kadar alınan sayıların pozitif ve negatif olanlarının ayrı ayrı
	toplamlarını bulan programı yazınız
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		FindPosNegSumApp.run();
	}
}

class FindPosNegSumApp {
	public static void displayResult(int posSum, int negSum)
	{
		if (posSum > 0)
			System.out.printf("Pozitif sayıların toplamı:%d%n", posSum);
		else
			System.out.println("Hiç pozitif sayı girmediniz");
		
		if (negSum < 0)
			System.out.printf("Negatif sayıların toplamı:%d%n", negSum);
		else
			System.out.println("Hiç negatif sayı girmediniz");
	}
	
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.println("Sayıları girmeye başlayınız:");
		
		int posSum = 0, negSum = 0;
		
		int val;
		
		while ((val = Integer.parseInt(kb.nextLine())) != 0)
			if (val > 0)
				posSum += val;
			else
				negSum += val;
		
		displayResult(posSum, negSum);				
	}
}
```
### Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının basamak sayısını döndüren getDigitsCount isimli metodu yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının basamak sayısını döndüren getDigitsCount isimli
	metodu NumberUtil isimli bir sınıfın içerisinde yazınız ve klavyeden alınan değerlerle çağırarak test ediniz
	
	123 -> 12 -> 1 -> 0 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		GetDigitsCountTest.run();		
	}
}

class GetDigitsCountTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);	
		
		System.out.print("Bir sayı giriniz:");
		
		int val;
		
		while ((val = Integer.parseInt(kb.nextLine())) != 0) {
			int count = NumberUtil.getDigitsCount(val);
			
			System.out.printf("%d sayısının basamak sayısı:%d%n", val, count);			
			System.out.print("Bir sayı giriniz:");
		}
		
		System.out.printf("0 sayısının basamak sayısı:%d%n", NumberUtil.getDigitsCount(0));
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class NumberUtil {
	public static int getDigitsCount(int val)
	{
		if (val == 0)
			return 1;
		
		int count = 0;
		
		while (val != 0) {
			++count;
			val /= 10;
		}				
		
		return count;
	}
}
```
### Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının basamakları toplamını döndüren getDigitsSum isimli metodu yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının basamakları toplamını döndüren getDigitsSum isimli
	metodu yazınız ve klavyeden girilen değerlerle çağırarak test ediniz.
	Metot negatif sayılar için pozitif basamak toplamını döndürecektir 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		GetDigitsSumTest.run();		
	}
}

class GetDigitsSumTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);	
		
		System.out.print("Bir sayı giriniz:");
		
		int val;
		
		while ((val = Integer.parseInt(kb.nextLine())) != 0) {
			int count = NumberUtil.getDigitsSum(val);
			
			System.out.printf("%d sayısının basamakları toplamı:%d%n", val, count);			
			System.out.print("Bir sayı giriniz:");
		}
		
		System.out.printf("0 sayısının basamakları toplamı:%d%n", NumberUtil.getDigitsSum(0));
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class NumberUtil {
	public static int getDigitsSum(int val)
	{
		int sum = 0;
		
		while (val != 0) {
			sum += val % 10;
			val /= 10;
		}
		
		return Math.abs(sum);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının basamakları toplamını döndüren getDigitsSum isimli
	metodu yazınız ve klavyeden girilen değerlerle çağırarak test ediniz.
	Metot negatif sayılar için pozitif basamak toplamını döndürecektir 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		GetDigitsSumTest.run();		
	}
}

class GetDigitsSumTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);	
		
		System.out.print("Bir sayı giriniz:");
		
		int val;
		
		while ((val = Integer.parseInt(kb.nextLine())) != 0) {
			int count = NumberUtil.getDigitsSum(val);
			
			System.out.printf("%d sayısının basamakları toplamı:%d%n", val, count);			
			System.out.print("Bir sayı giriniz:");
		}
		
		System.out.printf("0 sayısının basamakları toplamı:%d%n", NumberUtil.getDigitsSum(0));
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class NumberUtil {
	public static int getDigitsSum(int val)
	{
		val = Math.abs(val);
		int sum = 0;
		
		while (val != 0) {
			sum += val % 10;
			val /= 10;
		}
		
		return sum;
	}
}
```
### Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının tersini döndüren getReverse isimli metodu
	yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
	07.06.2020
	Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının tersini döndüren getReverse isimli metodu
	yazınız ve test ediniz. Örneğin -123 sayısı için metot -321 sayısını döndürecektir
	123 -> 3 -> 3 * 10 + 2 = 32 -> 32 * 10 + 1 = 321
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		GetReverseTest.run();		
	}
}

class GetReverseTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);	
		
		System.out.print("Bir sayı giriniz:");
		
		int val;
		
		while ((val = Integer.parseInt(kb.nextLine())) != 0) {
			int reverse = NumberUtil.getReverse(val);
			
			System.out.printf("%d sayısının tersi:%d%n", val, reverse);			
			System.out.print("Bir sayı giriniz:");
		}		
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class NumberUtil {
	public static int getReverse(int val)
	{
		int reverse = 0;
		
		while (val != 0) {
			reverse = reverse * 10 + val % 10;
			val /= 10;
		}
		
		return reverse;
	}
}
```
### Kontrolün sonda yapıldığı while döngü deyimi (do-while döngüsü):
```java
/*----------------------------------------------------------------------------------------------------------------------
	Kontrolün sonda yapıldığı while döngü deyimi (do-while döngüsü):
	
	do 
		<deyim>
	while (<boolean türden ifade>);
	
	Bu döngü deyiminde akış döngüye geldiğinde kontrol yapılmaz. İlk adımdan sonra kontrol yapılmaya başlanır.
	Yani bu döngü deyiminin en az bir kez çalıştırılacağı garanti altındadır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int n = Integer.parseInt(kb.nextLine());
		
		int i = 0;
		
		do {
			System.out.printf("i=%d%n", i);
			++i;
		} while (i < n);
		
		System.out.printf("Döngü sonrası:i=%d%n", i);		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının basamak sayısını döndüren getDigitsCount isimli
	metodu NumberUtil isimli bir sınıfın içerisinde yazınız ve klavyeden alınan değerlerle çağırarak test ediniz
	
	123 -> 12 -> 1 -> 0 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		GetDigitsCountTest.run();		
	}
}

class GetDigitsCountTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);	
		
		System.out.print("Bir sayı giriniz:");
		
		int val;
		
		while ((val = Integer.parseInt(kb.nextLine())) != 0) {
			int count = NumberUtil.getDigitsCount(val);
			
			System.out.printf("%d sayısının basamak sayısı:%d%n", val, count);			
			System.out.print("Bir sayı giriniz:");
		}
		
		System.out.printf("0 sayısının basamak sayısı:%d%n", NumberUtil.getDigitsCount(0));
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}

class NumberUtil {
	public static int getDigitsCount(int val)
	{		
		int count = 0;
		
		do {
			++count;
			val /= 10;
		} while (val != 0);					
		
		return count;
	}
}
```
### do-while döngüsü içerisinde bildirilen bir değişken while parantezinde faaliyet alanı kuralları gereği kullanılamaz 
```java
/*----------------------------------------------------------------------------------------------------------------------
	do-while döngüsü içerisinde bildirilen bir değişken while parantezinde faaliyet alanı kuralları gereği
	kullanılamaz  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		do {
			System.out.print("Bir sayı giriniz:");
			int val = Integer.parseInt(kb.nextLine());
			
			System.out.printf("%d%n", val * val);
		} while (val != 0); //error		
		
		System.out.println();		
	}
}
```
### Yukarıdaki örnek aşağıdaki gibi çözülebilir  
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki örnek aşağıdaki gibi çözülebilir  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		int val;
		
		do {
			System.out.print("Bir sayı giriniz:");
			val = Integer.parseInt(kb.nextLine());
			
			System.out.printf("%d%n", val * val);
		} while (val != 0);		
	}
}
```
### Sonsuz döngü:  Döngünün koşulundan dolayı sonlanmadığı döngülere denir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sonsuz döngü:  Döngünün koşulundan dolayı sonlanmadığı döngülere denir. Bu durumda hiç sonlanmayan döngüler de
	sonsuz döngülerdir. Tersine sonsuz döngüler de sonlanabilir. while döngü deyimi ile sonsuz döngü aşağıdaki 
	biçimde oluşturulabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		while (true) {
			//...
		}				
	}
}
```
### Sonsuz döngünün sonlandırılması
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte sonsuz döngü oluşturulmuş, döngü içerisinde bir koşul gerçekleştiğinde return deyimi
	kullanıldığından döngü de sonlanmıştır
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
		
		while (true) {
			System.out.print("Bir sayı giriniz:");
			int val = Integer.parseInt(kb.nextLine());
			
			if (val == 0)
				return;
			
			System.out.println(val * val);
		}
	}
}
```
### for döngü deyimi
```java
/*----------------------------------------------------------------------------------------------------------------------
	for döngü deyimi:
	for ([1.kısım]; [2.kısım]; [3.kısım])
		<deyim>
		
	1.kısım: Akış for döngü deyimine geldiğinde ilk kez ve bir kez yapılacak kısımdır
	
	2.kısım: for döngü deyimin koşul ifadesidir. Yani buradaki ifadenin boolean türden olması gerekir. Bu ifade
	doğru olduğu sürece döngü yinelenir. Akış for döngü deyimine ilk kez geldiğinde birinci kısım yapıldıktan 
	sonra koşul kontrolü yapılır
	
	3.kısım: Döngünün bir adımı tamamlandığında bir sonraki adıma geçmek için yapacağı kontrolden hemen önce
	yapılacak kısımdır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int i;
		
		for (i = 0; i < 5; ++i)
			System.out.printf("i=%d%n", i);
		
		System.out.printf("Döngü sonrası-i=%d%n", i);
	}
}
```
### for döngü deyiminin 1.kısmında değişken bildirimi yapılabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	for döngü deyiminin 1.kısmında değişken bildirimi yapılabilir. Burada bildirilen değişlen yalnızca for döngüsü
	boyunca görülebilirdir.
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		for (int i = 0; i < 5; i++)
			System.out.printf("i=%d%n", i);
		
		System.out.printf("Döngü sonrası-i=%d%n", i); //error
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki durum yerel değişkenlerin faaliyet alanı kuralları gereği error oluşturur
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		int i;
		
		for (int i = 0; i < 5; i++) //error
			System.out.printf("i=%d%n", i);	
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki durum yerel değişkenlerin faaliyet alanı kuralları gereği geçerlidir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		for (int i = 0; i < 5; i++) 
			System.out.printf("Birinci döngü:i=%d%n", i);		
		
		//...
		
		for (int i = 0; i < 5; i++) 
			System.out.printf("İkinci döngü:i=%d%n", i);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	for döngü deyimi sonunda yanlışlıkla noktalı virgül konması durumu
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		for (int i = 0; i < 5; i++);
			System.out.println("Merhaba");	
		
	}
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
	for döngü deyimi sonunda yanlışlıkla noktalı virgül konması durumu. Aşağıdaki durumda error oluştuğuna
	dikkat ediniz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		for (int i = 0; i < 5; i++);
			System.out.printf("i=%d%n", i); //error		
	}
}
```
### for döngü deyimi ile n-kez dönen döngü kalıbı (dizi uyumlu)
```java
/*----------------------------------------------------------------------------------------------------------------------
	for döngü deyimi ile n-kez dönen döngü kalıbı (dizi uyumlu)
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int n = Integer.parseInt(kb.nextLine());
		
		for (int i = 0; i < n; ++i)
			System.out.println("Merhaba");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	for döngü deyimi ile n-kez dönen döngü kalıbı (dizi uyumlu)
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int n = Integer.parseInt(kb.nextLine());
		
		for (int i = n - 1; i >= 0; --i)
			System.out.printf("i=%d%n", i);
	}
}
```
### for döngü deyimi ile n-kez dönen döngü kalıbı
```java
/*----------------------------------------------------------------------------------------------------------------------
	for döngü deyimi ile n-kez dönen döngü kalıbı
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int n = Integer.parseInt(kb.nextLine());
		
		for (int i = 1; i <= n; ++i)
			System.out.printf("i=%d%n", i);
	}
}
```
### for döngü deyiminin birinci ve üçüncü kısmında virgül ayracı ifade ayırmak için kullanılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	for döngü deyiminin birinci ve üçüncü kısmında virgül ayracı ifade ayırmak için kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		for (int i = 1, k = 10; i <= 5 && k >= 0; ++i, --k)
			System.out.printf("(%d, %d)%n", i, k);
	}
}
```
### for döngü deyiminin birinci ve üçüncü kısmında virgül ayracı ifade ayırmak için kullanılabilir (2)
```java
/*----------------------------------------------------------------------------------------------------------------------
	for döngü deyiminin birinci ve üçüncü kısmında virgül ayracı ifade ayırmak için kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		int i = 0;
		
		for (System.out.println("1.kısım"); i <= 5; System.out.println("Üçüncü kısım"), ++i)
			System.out.println("Döngü deyimi");
	}
}
```
## for döngü deyiminin birinci kısmında değişken bildirimi varsa virgülle ayırarak bildirim dışında bir ifade yazılamaz.
```java
/*----------------------------------------------------------------------------------------------------------------------
	for döngü deyiminin birinci kısmında değişken bildirimi varsa virgülle ayırarak bildirim dışında bir 
	ifade yazılamaz. Bildirilen tüm değişkenlerin aynı türden olması gerekir 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		for (int i = 0, double k = 4; i <= 5; System.out.println("Üçüncü kısım"), ++i) //error
			System.out.println("Döngü deyimi");
	}
}
```
### for döngü deyiminin ilginç bir kullanımı 
```java
/*----------------------------------------------------------------------------------------------------------------------
	for döngü deyiminin ilginç bir kullanımı 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		int sum = 0;
		int val;
		
		for (System.out.println("Sayıları girmeye başlayınız:"), System.out.println("Sayı?"); 
				(val = Integer.parseInt(kb.nextLine())) != 0; sum += val, System.out.println("Sayı?"))
			;	
		
		System.out.printf("Toplam:%d%n", sum);		
	}
}
```
### for döngü deyiminin ilginç bir kullanımı (2)
```java
/*----------------------------------------------------------------------------------------------------------------------
	for döngü deyiminin ilginç bir kullanımı 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		int sum = 0;
		int val;
		
		for (System.out.println("Sayıları girmeye başlayınız:"), System.out.println("Sayı?"); 
				(val = Integer.parseInt(kb.nextLine())) != 0; sum += val, System.out.println("Sayı?"))
			;	
		
		System.out.printf("Toplam:%d%n", sum);		
	}
}
```
### for döngü deyiminin 3.kısmının boş bırakılması durumu 
```java
/*----------------------------------------------------------------------------------------------------------------------
	for döngü deyiminin 3.kısmının boş bırakılması durumu 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		for (int i = 0; i < 5; ) {
			System.out.printf("%d ", i);
			++i;
		}
		
		System.out.println();
	}
}
```
### for döngü deyiminin 1.ve 3.kısmının boş bırakılması while döngü deyimine benzetilebilir 
```java
/*----------------------------------------------------------------------------------------------------------------------
	for döngü deyiminin 1.ve 3.kısmının boş bırakılması while döngü deyimine benzetilebilir 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		int i = 0;
		
		for (; i < 5; ) { //while (i < 5)
			System.out.printf("%d ", i);
			++i;
		}
		
		System.out.println();
	}
}
```
### for döngü deyiminin 2.kısmının boş bırakılması sonsuz döngü oluşturmak demektir
```java
/*----------------------------------------------------------------------------------------------------------------------
	for döngü deyiminin 2.kısmının boş bırakılması sonsuz döngü oluşturmak demektir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		for (int i = 0; ; ++i) {
			System.out.printf("%d%n", i);			
		}
	
	}
}
```
### for döngü deyimi ile sonsuz döngü kalıbı
```java
/*----------------------------------------------------------------------------------------------------------------------
	for döngü deyimi ile sonsuz döngü kalıbı
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		for (;;) { //sonsuz döngü kalıbı
			//...
		}	
	}
}
```
### Sınıf Çalışması: Parametresi ile aldığı int türden a ve b değerleri için a'nın b-inci kuvvetini döndüren pow isimli metodu yazınız.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden a ve b değerleri için a'nın b-inci kuvvetini döndüren
	pow isimli metodu yazınız.
	Açıklamalar:
	- Math sınıfının pow metodu kullanılmayacaktır
	- Metot b nin negatif değerleri için 1 değerini döndürecektir
	- Metot NumberUtil sınıfı içerisinde yazılacaktır	
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		PowTest.run();	
	}
}

class PowTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Tabanı giriniz:");
			int a = Integer.parseInt(kb.nextLine());		
			
			System.out.print("Üssü giriniz:");
			int b = Integer.parseInt(kb.nextLine());
			
			System.out.printf("pow(%d, %d)=%d%n", a, b, NumberUtil.pow(a, b));
			
			if (a == 0)
				return;
		}
	}
}

class NumberUtil {
	public static int pow(int a, int b)
	{
		if (b <= 0)
			return 1;
		
		int result = 1;
		
		for (int i = 0; i < b; ++i)
			result *= a;
		
		return result;
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden a ve b değerleri için a'nın b-inci kuvvetini döndüren
	pow isimli metodu yazınız.
	Açıklamalar:
	- Math sınıfının pow metodu kullanılmayacaktır
	- Metot b nin negatif değerleri için 1 değerini döndürecektir
	- Metot NumberUtil sınıfı içerisinde yazılacaktır	
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		PowTest.run();	
	}
}

class PowTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Tabanı giriniz:");
			int a = Integer.parseInt(kb.nextLine());		
			
			System.out.print("Üssü giriniz:");
			int b = Integer.parseInt(kb.nextLine());
			
			System.out.printf("pow(%d, %d)=%d%n", a, b, NumberUtil.pow(a, b));
			
			if (a == 0)
				return;
		}
	}
}

class NumberUtil {
	public static int pow(int a, int b)
	{
		if (b <= 0)
			return 1;
		
		int result = 1;
		
		while (b-- > 0)
			result *= a;
		
		return result;
	}
}
```
### Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının Armstrong sayısı olup olmadığını test eden isArmstrong metodunu yazınız ve test ediniz.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının Armstrong sayısı olup olmadığını test eden
	isArmstrong metodunu yazınız ve test ediniz.
	Açıklamalar:
	- Bir sayının her basamağının basamak sayıncı kuvvetleri toplamı sayının kendisine eşitse bu sayıya Armstrong 
	sayısı denir	
	153 -> 1 + 125 + 27 = 153
	- Sayı negatif ise false döndürebilirsiniz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		IsArmstrongTest.run();	
	}
}

class IsArmstrongTest {
	public static void run()
	{
		for (int n = -100; n <= 9999999; ++n)
			if (NumberUtil.isArmstrong(n))
				System.out.println(n);			
	}
}

class NumberUtil {
	public static boolean isArmstrong(int val)
	{
		if (val < 0)
			return false;
		
		return getDigitsPowSum(val) == val;	
	}
	
	public static int getDigitsPowSum(int val)
	{
		int count = getDigitsCount(val);
		
		int sum = 0;
		
		while (val != 0) {
			sum += pow(val % 10, count);
			val /= 10;
		}
		
		return sum;
	}
	
	public static int getDigitsCount(int val)
	{
		int count = 0;
		
		do {
			++count;
			val /= 10;
			
		} while (val != 0);
			
		return count;
	}
	
	public static int pow(int a, int b)
	{
		if (b <= 0)
			return 1;
		
		int result = 1;
		
		while (b-- > 0)
			result *= a;
		
		return result;
	}
}
```
### Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının faktoriyelini döndüren factorial isimli metodu yazınız ve test ediniz.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının faktoriyelini döndüren factorial isimli 
	metodu yazınız ve test ediniz.
	Açıklamalar: 
	- Metot negatif sayılar için -1 değerini döndürecektir
	- Faktoriyel tanımı:
		0!= 1
		1!=1
		2!=1*2
		...
		n!=1 * 2 * ...* (n - 1) * n
	- Sınır taşması gözardı edilecektir	
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{		
		FactorialTest.run();	
	}
}

class FactorialTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int n = Integer.parseInt(kb.nextLine());
		
		for (int i = 0; i <= n; ++i)
			System.out.printf("%d!=%d%n", i, NumberUtil.factorial(i));		
	}
}

class NumberUtil {
	public static int factorial(int n)
	{
		if (n < 0)
			return -1;
		
		int result = 1;
		
		for (int i = 2; i <= n; ++i)
			result *= i;
		
		return result;
	}
}
```
### Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının asal olup olmadığını test eden isPrime metodunu yazınız ve test ediniz
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının asal olup olmadığını test eden isPrime
	metodunu yazınız ve test ediniz
	(Yavaş versiyon)
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		IsPrimeTest.run();			
	}
}

class IsPrimeTest {
	public static void run()
	{
		for (int i = 0; i <= 100; ++i)
			if (NumberUtil.isPrime(i))
				System.out.printf("%d ", i);
		
		System.out.println();
		
		if (NumberUtil.isPrime(1_000_003))
			System.out.println("Asal");
		else
			System.out.println("Asal değil");
	}
}

class NumberUtil {
	public static boolean isPrime(int val)
	{
		if (val <= 1)
			return false;
		
		int halfVal = val / 2;
		
		for (int i = 2; i <= halfVal; ++i)
			if (val % i == 0)
				return false;
		
		return true;
	}
}
```
### Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının asal olup olmadığını test eden isPrime metodunu yazınız ve test ediniz
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının asal olup olmadığını test eden isPrime
	metodunu yazınız ve test ediniz.
	
	Teorem: Bir sayı karekökünden küçük olan asal sayıların hiç birine bölünemiyorsa asaldır
	(Çok daha hızlı versiyon)
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		IsPrimeTest.run();			
	}
}

class IsPrimeTest {
	public static void run()
	{
		for (int i = 0; i <= 100; ++i)
			if (NumberUtil.isPrime(i))
				System.out.printf("%d ", i);
		
		System.out.println();
		
		if (NumberUtil.isPrime(1_000_003))
			System.out.println("Asal");
		else
			System.out.println("Asal değil");
	}
}

class NumberUtil {
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
### Yukarıda yazılan isPrime metotlarının performanslarını gösteren basit bir test
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıda yazılan isPrime metotlarının performanslarını gösteren basit bir test
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{	
		IsPrimeTest.run();			
	}
}

class IsPrimeTest {
	public static void run()
	{		
		if (NumberUtil.isPrimeSlow(1_000_003))
			System.out.println("Asal");
		else
			System.out.println("Asal değil");
		
		if (NumberUtil.isPrime(1_000_003))
			System.out.println("Asal");
		else
			System.out.println("Asal değil");
	}
}

class NumberUtil {
	public static boolean isPrimeSlow(int val)
	{
		if (val <= 1)
			return false;
		
		int halfVal = val / 2;		
		int count = 0;
		
		for (int i = 2; i <= halfVal; ++i) {
			++count;
			if (val % i == 0)
				return false;
		}
		
		System.out.printf("isPrimeSlow:Count:%d%n", count);
		return true;
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
		
		int count = 0;
		
		for (int i = 11; i * i <= val; i += 2) {
			++count;
			if (val % i == 0)
				return false;
		}
		
		System.out.printf("isPrime:Count:%d%n", count);
		
		return true;			 
	}
}




/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/
```
