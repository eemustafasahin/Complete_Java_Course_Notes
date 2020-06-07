```java
/*----------------------------------------------------------------------------------------------------------------------	 
	 Tek tırnak içerisinde özel durumlar dışında birden fazla karakter yazılamaz. Özel durumlar da aslında 
	 tek bir karaktere karaktere karşılık gelen sabitin yazılmasıdır	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		char ch = 'abcd'; //error
		
		System.out.println(ch);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Ters bölüden sonra özel karakterler dışında yazılamaz	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		char ch = '\k'; //error
		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Ters bölü karakteri tek tırnak içersine iki tane olarak yazılmalıdır	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		char ch = '\\';
		
		System.out.println(ch);		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Tek tırnak karakter sabiti tek tırnak içerisinde ters bölü ile yazılmalıdır	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		char ch = '\'';
		
		System.out.println(ch);		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	 İki tırnak karakter sabiti tek tırnak içerisinde iki türlü kullanılabilir	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		char ch1 = '\"';
		char ch2 = '"';
		
		System.out.println(ch1);
		System.out.println(ch2);
	}
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
	 İki tırnak içerisinde (String atomunda) ter bölü yazılması gereken karakterler anlamlıdır. Aşağıdaki örnekye
	 tab ve line feed karakterleri ile işlem yaopılmış olur	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		System.out.println("C:\test\names.txt");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Yukarıdaki işlem aşağıdaki gibi yazılabilir	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		System.out.println("C:\\test\\names.txt");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	 Aşağıdaki durumda ters bölüden sonra özel karakter kullanılmadığından error oluşur	 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		System.out.println("C:\mest\people.txt"); //error
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	İki tırnak karakteri iki tırnak içerisinde ters bölü ile kullanılmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		System.out.println("\"ankara\"");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	İki tırnak karakteri iki tırnak içerisinde ters bölü ile kullanılmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		System.out.println("\"ankara");	
	}
}
```
```java


/*----------------------------------------------------------------------------------------------------------------------
	Tek tırnak karakteri iki tırnak içerisinde iki şekilde kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		System.out.println("'ankara\'");
		
	}
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
	Tek tırnak karakteri iki tırnak içerisinde iki şekilde kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		System.out.println("'ankara");	
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Ters bölü ve u ile bir karakterin sıra numarası hexadecimal olarak tek tırnak içerisinde yazıldığında
	o karakter ilişkin sabit yazılmış olur 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		char ch = '\u0175';
		
		System.out.println(ch);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Ters bölü u ile değişken isimlerine ilişkin karakterler de belirlenebilir 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int \u0175abc = 1;
		
		System.out.println(\u0175abc);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Ters bölü u ile değişken isimlerine ilişkin karakterler de belirlenebilir 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int \u0061 = 1;
		
		System.out.println(a);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Ters bölü u iki tırnak içerisinde de anlamlıdır 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		System.out.println("Merhaba \u0175");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir tamsayı önüne bir ek almadan yazıldığında decimal yazılmış olur 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 67; //decimal sabit
		
		System.out.println(a);									
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Tamsayı sabitinin önünen sıfır ve x (büyük veya küçük) yazıldığında bu ekten sonra gelen basamaklar hexadimal
	basamaklar olarak yazılabilir 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 0x43;
		
		System.out.println(a);									
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Tamsayı sabitinin önünen sıfır ve x (büyük veya küçük) yazıldığında bu ekten sonra gelen basamaklar hexadimal
	basamaklar olarak yazılabilir 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 0xA; //hexadecimal
		
		System.out.println(a);									
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Tamsayı sabitinin önünen sıfır  yazıldığında bu ekten sonra gelen basamaklar octal basamaklar olarak yazılabilir 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 012; //octal
		
		System.out.println(a);									
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java 7 ile birlikte sabitin başına sıfır ve b (büyük veya küçük) yazıldığından ikilik sistemde basamaklar
	yazılabilir  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 0b1010; //binary
		
		System.out.println(a);									
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Gerçek sayı sabit sabitlerinin üstel gösterilişi  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		double a = 1.23E23;
		
		System.out.printf("%f%n", a);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Gerçek sayı sabit sabitlerinin üstel gösterilişi  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		double a = 123E+23;
		
		System.out.printf("%f%n", a);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Gerçek sayı sabit sabitlerinin üstel gösterilişi  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		double a = 123E-23;
		
		System.out.printf("%.30f%n", a);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Gerçek sayı sabit sabitlerinin üstel gösterilişi  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		double a = 123e-23;
		
		System.out.printf("%.30f%n", a);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Gerçek sayı sabit sabitlerinin üstel gösterilişi  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		double avogadro = 6.02E23;
		
		System.out.printf("%f%n", avogadro);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java 7 ile birlikte bir sabit içerisinde alttire karakteri kullanılabilmektedir 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 0x1F_C0;
		
		System.out.printf("a=%d%n", a);
		System.out.printf("a=0x%X%n", a);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Alttire karakteri kullanılabildiği yerde istenildiği kadar yazılabilir  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 1________________________________________0;
		
		System.out.printf("a=%d%n", a);		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Alttire karakteri kullanılabildiği yerde istenildiği kadar yazılabilir  
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		long a = 0x00_00_10_01__A0_00_00_00L;
		
		System.out.printf("a=%d%n", a);		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Alttire karakteri karakter sabitleri içerisinde geçersizdir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		char ch = '\u01_75'; //error
		
		System.out.println(ch);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Alttire karakteri sabitin başında ya da sonunda geçersizdir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = _34;//error
		int b = 45_;//error
		
		//...
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Alttire karakteri sayı nokta içeriyosa noktadan önce ya da sonra geçersizdir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		double a = 3_.14; //error
		double b = 3._14; //error
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Alttire karakteri sabit sonundaki eklerden önce ya da sonra kullanılamaz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		long a = 10L_; //error
		long b = 10_L; //error
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Alttire karakteri sabitin önündeki eklerden önce sonra veya arasında geçersizdir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		long a = 0x_10; //error
		long b = 0_x10; //error
		long b = _0_x10; //error
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Octal sabitler için önek ile sabitin ilk basamağı arasında alttire karakteri geçerlidir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 0_12;
	}
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
	Octal sabitin önekinden önce alttire yine geçersizdir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = _012; //error
	}
}
```
```java


/*----------------------------------------------------------------------------------------------------------------------
	Gerçek sayı sabitlerinin tamsayı kısmının değeri sıfırsa noktadan önce sıfır yazılmayabilir. Aynı durum
	noktadan sonraki kısmı sıfır ise, sıfır yazılmayabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		double a = .1; //0.1
		double b = 1.; //1.0
		
		System.out.println(a);
		System.out.println(b);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Operatörler 3(üç) biçimde sınıflandırılabilir:
	1. İşlevlerine göre sınıflandırma:
		- Aritimetik Operatörler
		- Karşılaştırma operatörleri
		- Mantıksal Operatörler
		- Bitsel Operatörler
		- Özel amaçlı operatörler
	2. Operand sayılarına göre sınıflandırma
		- Tek operandlı (unary)
		- İki operandlı (binary)
		- Üç operandlı (ternary)
	3. Operatörün konumuna göre sınıflandırma:
		- önek operatörler (prefix)
		- araek operatörler (infix)
		- sonek operatörler (postfix)
		
	Operatörün kısıtı (constraint)
	Operatörün ürettiği değer (product value):
	Operatörün yan etkisi (side effect)
	Operatörün önceliği (precedence):
		a = b + c * d;
		i1: c * d
		i2: b + i1
		i3: a = i2
		
		
		a = (b + c) * d;
		i1: b + c
		i2: c * i1
		i3: a = i2
		
		a = b + c - d //soldan sağa
		i1: b + c	
		i2: i1 - d
		i3: a = i2	
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aritmetik 4 işlem ve mod operatörü (bölme hariç)
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
		
		System.out.printf("%d + %d = %d%n", a, b, a + b);
		System.out.printf("%d - %d = %d%n", a, b, a - b);
		System.out.printf("%d * %d = %d%n", a, b, a * b);
		System.out.printf("%d %% %d = %d%n", a, b, a % b);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bölme işleminde operandlar tamsayı türündense sonuç tamsayı türünden çıkar. Sonucun noktadan sonraki
	kısmı atılır
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
		
		System.out.printf("%d / %d = %d%n", a, b, a / b);		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Mod operatörünün birinci operandı negatif ise sonuç hep negatif çıkar. Pozitif ise hep pozitif çıkar	
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
		
		System.out.printf("%d %% %d = %d%n", a, b, a % b);		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Mod operatörü Java' da gerçek sayılar için de kullanılabilir	
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Birinci sayıyı giriniz:");
		double a = Double.parseDouble(kb.nextLine());
		
		System.out.print("İkinci sayıyı giriniz:");
		double b = Double.parseDouble(kb.nextLine());
		
		System.out.printf("%f %% %f = %f%n", a, b, a % b);		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden 3 basamaklı bir sayının basamakları toplamını döngü
	kullanmadan döndüren getDigitsSum metodunu yazınız. Metot sayının basamak sayısı kontrolünü yapmayacaktır	
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int a = Integer.parseInt(kb.nextLine());
		
		System.out.printf("%d sayısının basamakları toplamı:%d%n", a, NumberUtil.getDigitsSum(a));		
	}
}

class NumberUtil {
	public static int getDigitsSum(int val)
	{
		int a, b, c;
		
		a = val / 100;
		b = val / 10 % 10; //val % 100 / 10
		c = val % 10;
		
		return Math.abs(a + b + c);				
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	İşaret - operatörü	
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int a = Integer.parseInt(kb.nextLine());		
		int b = -a;
		
		System.out.printf("a=%d%n", a);	
		System.out.printf("b=%d%n", b);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	İşaret + operatörü	
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int a = Integer.parseInt(kb.nextLine());		
		int b = +a;
		
		System.out.printf("a=%d%n", a);	
		System.out.printf("b=%d%n", b);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örneği inceleyiniz	
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a;
		
		a = - - - - - - - - - 2; 
		
		System.out.println(a);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örneği inceleyiniz	
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a, b = 10, c = 3;
		
		a = b - - - - - - - - - - c; 
		
		System.out.println(a);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	31.05.2020
	++ operatörü iki şekilde operatörü postfix ve prefix olarak kullanılabilir. Bu operatör nasıl kullanılırsa 
	kullanılsın operandının değerini bir artırır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 10;
		
		++a; // a = a + 1;
		
		System.out.println(a);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	++ operatörü iki şekilde operatörü postfix ve prefix olarak kullanılabilir. Bu operatör nasıl kullanılırsa 
	kullanılsın operandının değerini bir artırır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 10;
		
		a++; // a = a + 1;
		
		System.out.println(a);
	}
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
	++ operatörünün prefix kullanımında ürettiği değer (işleme giren değer) artırılmış değerdir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 10;		
		int b;
		
		b = ++a;
		
		System.out.printf("a=%d%n", a); //a=11
		System.out.printf("b=%d%n", b); //b=11
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	++ operatörünün postfix kullanımında ürettiği değer (işleme giren değer) artırılMAmış değerdir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 10;		
		int b;
		
		b = a++;
		
		System.out.printf("a=%d%n", a); //a=11
		System.out.printf("b=%d%n", b); //b=10
	}
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------	
	-- operatörü iki şekilde operatörü postfix ve prefix olarak kullanılabilir. Bu operatör nasıl kullanılırsa 
	kullanılsın operandının değerini bir azaltır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 10;
		
		--a; // a = a - 1;
		
		System.out.println(a);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	-- operatörü iki şekilde operatörü postfix ve prefix olarak kullanılabilir. Bu operatör nasıl kullanılırsa 
	kullanılsın operandının değerini bir azaltır
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 10;
		
		a--; // a = a - 1;
		
		System.out.println(a);
	}
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
	-- operatörünün prefix kullanımında ürettiği değer (işleme giren değer) azaltılmış değerdir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 10;		
		int b;
		
		b = --a;
		
		System.out.printf("a=%d%n", a); //a=9
		System.out.printf("b=%d%n", b); //b=9
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	-- operatörünün postfix kullanımında ürettiği değer (işleme giren değer) azaltılMAmış değerdir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 10;		
		int b;
		
		b = a--;
		
		System.out.printf("a=%d%n", a); //a=9
		System.out.printf("b=%d%n", b); //b=10
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	++ ve -- operatörlerinin kullanımı
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 10;		
		int b;
		
		b = --a + ++a;
		
		System.out.printf("a=%d%n", a); //a=10
		System.out.printf("b=%d%n", b); //b=19
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	++ ve -- operatörlerinin kullanımı
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 10;		
		int b;
		
		b = a-- + ++a;
		
		System.out.printf("a=%d%n", a); //a=10
		System.out.printf("b=%d%n", b); //b=20
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	++ ve -- operatörlerinin kullanımı
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 10;		
		int b;
		
		b = a-- + ++a - --a;
		
		System.out.printf("a=%d%n", a); //a=9
		System.out.printf("b=%d%n", b); //b=11
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Derleyici yukarıdan aşağıya ve soldan sağa olmak üzere anlamlı en uzun ifadeyi alacak şekilde atomlarına ayırma
	işlemini yapar
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 10;		
		int b = 9;
		int c;
		
		c = a+++b; //a++ + b
		
		System.out.printf("a=%d%n", a); //a=11
		System.out.printf("b=%d%n", b); //b=9
		System.out.printf("c=%d%n", c); //c=19
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Karşılaştırma operatörleri karşılaştırmanın sonucuna göre boolean türden değer üretir
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
		
		boolean result;
		
		result = a > b;
		
		System.out.printf("%d > %d -> %b%n", a, b, result);
		
		result = a <= b;
		
		System.out.printf("%d <= %d -> %b%n", a, b, result);
		
		result = a < b;
		
		System.out.printf("%d < %d -> %b%n", a, b, result);
		
		result = a >= b;
		
		System.out.printf("%d >= %d -> %b%n", a, b, result);
		
		result = a == b;
		
		System.out.printf("%d == %d -> %b%n", a, b, result);
		
		result = a != b;
		
		System.out.printf("%d != %d -> %b%n", a, b, result);		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Mantıksal VE (AND) operatörü 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		boolean result;
		
		result = Sample.foo() && Sample.bar();
		
		System.out.printf("result:%b%n", result);				
	}
}

class Sample {
	public static boolean foo()
	{
		System.out.println("foo");
		
		return true;
	}
	
	public static boolean bar()
	{
		System.out.println("bar");
		
		return false;
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Mantıksal VEYA (OR) operatörü 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		boolean result;
		
		result = Sample.bar() || Sample.foo();
		
		System.out.printf("result:%b%n", result);				
	}
}

class Sample {
	public static boolean foo()
	{
		System.out.println("foo");
		
		return true;
	}
	
	public static boolean bar()
	{
		System.out.println("bar");
		
		return false;
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Mantıksal operatörlerin kısa devre (short circuit) davranışı
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		boolean result;
		
		result = Sample.foo() || Sample.bar();
		
		System.out.printf("result:%b%n", result);				
	}
}

class Sample {
	public static boolean foo()
	{
		System.out.println("foo");
		
		return true;
	}
	
	public static boolean bar()
	{
		System.out.println("bar");
		
		return false;
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Mantıksal operatörlerin kısa devre (short circuit) davranışı
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		boolean result;
		
		result = Sample.bar() && Sample.foo();
		
		System.out.printf("result:%b%n", result);				
	}
}

class Sample {
	public static boolean foo()
	{
		System.out.println("foo");
		
		return true;
	}
	
	public static boolean bar()
	{
		System.out.println("bar");
		
		return false;
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Mantıksal operatörler doğru sonuca yani matematiksel olarak yapılacak olursa elde edilecek sonuca en kısa yoldan
	ulaşabilmek için (kısa devre davranışını kullanarak) en soldaki ifadeyi önce yaparlar. Aşağıdaki örnekte
	&& operatörü || operatöründen öncelikli de olsa önce || işlemi yapılır. Ancak && operatörünün önceliği ile 
	elde edilecek sonuç değişmez
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		boolean result;
		
		result = Sample.foo() || Sample.bar() && Sample.tar();		
		
		System.out.printf("result:%b%n", result);				
	}
}

class Sample {
	public static boolean foo()
	{
		System.out.println("foo");
		
		return true;
	}
	
	public static boolean bar()
	{
		System.out.println("bar");
		
		return false;
	}
	
	public static boolean tar()
	{
		System.out.println("tar");
		
		return false;
	}	
	
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Mantıksal operatörler doğru sonuca yani matematiksel olarak yapılacak olursa elde edilecek sonuca en kısa yoldan
	ulaşabilmek için (kısa devre davranışını kullanarak) en soldaki ifadeyi önce yaparlar
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		boolean result;
		
		result = Sample.foo() && Sample.bar() || Sample.tar();		
		
		System.out.printf("result:%b%n", result);				
	}
}

class Sample {
	public static boolean foo()
	{
		System.out.println("foo");
		
		return false;
	}
	
	public static boolean bar()
	{
		System.out.println("bar");
		
		return false;
	}
	
	public static boolean tar()
	{
		System.out.println("tar");
		
		return false;
	}
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
	Bitsel AND (&)ve bitsel OR (|) operatörleri tamsayılar ile çalışırlar. Ancak boolean türü ile işlem yapıldığında
	kısa devre davranışı olmayan AND ve OR operatörleri olarak düşünülebilirler 
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		boolean result;
		
		result = Sample.foo() | Sample.bar() & Sample.tar();		
		
		System.out.printf("result:%b%n", result);				
	}
}

class Sample {
	public static boolean foo()
	{
		System.out.println("foo");
		
		return true;
	}
	
	public static boolean bar()
	{
		System.out.println("bar");
		
		return false;
	}
	
	public static boolean tar()
	{
		System.out.println("tar");
		
		return false;
	}	
	
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bitsel AND (&)ve bitsel OR (|) operatörleri
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 10; //1010
		int b = 11;//1011
		int c;
		
		c = a & b;
		
		System.out.printf("c=%d%n", c);
		
		c = a | b;
		
		System.out.printf("c=%d%n", c);		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 10;
		
		a = a++;
		
		System.out.printf("a=%d%n", a);		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Mantıksal değil operatörünün flag değişkenlerde kullanımı
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		boolean flag = false;
		
		flag = !flag;
		
		System.out.println(flag);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Atama operatörü sağdan sola önceliklidir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a, b, c;
		
		a = b = c = 10;
		
		System.out.printf("a=%d%n", a);
		System.out.printf("b=%d%n", b);
		System.out.printf("c=%d%n", c);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte atama operatörünün birinci operandının değişken olması gerektiğinden error oluşur
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 1, b = 34, c = 34;
		
		(a = b) = c; //error
		
		System.out.printf("a=%d%n", a);
		System.out.printf("b=%d%n", b);
		System.out.printf("c=%d%n", c);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte hata oluşmaz. Parantez gereksizdir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 1, b = 34, c = 34;
		
		a = (b = c); 
		
		System.out.printf("a=%d%n", a);
		System.out.printf("b=%d%n", b);
		System.out.printf("c=%d%n", c);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	İşlemli atama operatörlerinin genel biçimi:
	
		<ifade1> <op>= <ifade2>
	<ifade1> = <ifade1> op <ifade2>
	
	a += b -> a = a + b;
	a /= b -> a = a / b	
	a %= b -> a = a % b
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 1, b = 34;
		
		a += b; // a = a + b
		
		System.out.printf("a=%d%n", a);
		System.out.printf("b=%d%n", b);
		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	İşlemli atama operatörleri ifadeleri daha basit yazmak için tercih edilebilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 1, b = 3, c = 2;
		
		a *= b + c; //a = a * (b + c);
		
		System.out.printf("a=%d%n", a);		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Metot çağırma operatörü
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 10, b = 20;
		int c;
		
		c = Operation.add(a, b) * 2;
		
		System.out.printf("c=%d%n", c);
		
	}
}

class Operation {
	public static int add(int a, int b)
	{
		return a + b;
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java' da etkisiz ifadeler genel olarak error oluşturur
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 10;
		
		a + 2; //etkisiz ifade:
		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Deyim (statement): Bir programın çalıştırılan parçalarına deyim denir. Bir program deyimlerin çalıştırılmasıyla
	çalışır
	Java' da deyimler:
	1. Basit deyimler (simple statements)
	2. Bileşik deyimler (compound statements)
	3. Bildirim deyimleri (declaration statements)
	4. Kontrol deyimleri (control statements)
	5. Boş deyim (null statement)
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Basit deyim
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 10, b;
		
		b = a + 1; //basit deyim
		
	}
}

```
```java

/*----------------------------------------------------------------------------------------------------------------------
	Bileşik deyim
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a = 10, b;
		
		{ //bileşik deyim
			++a;
			b = a;
			//...
			
			{
				//...
			}
		}
		
	}
}

```
```java

/*----------------------------------------------------------------------------------------------------------------------
	Bildirim deyimleri
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a; //bildirim deyimi	
		
	}
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Boş deyim
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		int a;;
		
		; //boş deyim
		
		;
		
		;;;;;;
		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	if deyiminin genel biçimi:
	if (<boolean türden ifade>)
		<deyim>
	[
	else
		<deyim>
	]
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());
		
		if (val % 2 == 0)
			System.out.println("Çift");
		else
			System.out.println("Tek");
		
		System.out.println("Tekrar yapıyor musunuz?");		
	}
}
```
```java


/*----------------------------------------------------------------------------------------------------------------------
	else kısmı olmayan if deyimleri yazılabilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());
		
		if (val % 2 == 0)
			val /= 2;
		
		System.out.printf("val=%d%n", val);		
		
		System.out.println("Tekrar yapıyor musunuz?");		
	}
}
```
```java


/*----------------------------------------------------------------------------------------------------------------------
	if deyiminin parantezi sonuna noktalı virgül konması ve oluşabilecek hatalı durum
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());
		
		if (val % 2 == 0);		
			val /= 2;
		
		System.out.printf("val=%d%n", val);		
		
		System.out.println("Tekrar yapıyor musunuz?");		
	}
}

```
```java

/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte else'in ait olduğu bir if deyimi olmadığından error oluşur
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());
		
		if (val % 2 == 0);
			val /= 2;			
		else //error
			val *= 2;
		
		System.out.printf("val=%d%n", val);		
		
		System.out.println("Tekrar yapıyor musunuz?");		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte else kısmı içteki if deyimine ait olur (dangling else)
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());
		
		if (val > 0)
			if (val % 2 == 0)
				System.out.println("Pozitif çift");
		else
			System.out.println("Pozitif değil");
		
		System.out.println("Tekrar yapıyor musunuz?");		
	}
}
```
```java


/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki örnekte dangling else durumu aşağıdaki gibi bileşik deyim koyarak düzeltilebilir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());
		
		if (val > 0) {
			if (val % 2 == 0)
				System.out.println("Pozitif çift");
		}
		else
			System.out.println("Pozitif değil");
		
		System.out.println("Tekrar yapıyor musunuz?");		
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki durumda bileşik deyim kullanmaya gerek yoktur. Çünkü if deyimi else kısmı ile birlikte tek bir deyimdir
----------------------------------------------------------------------------------------------------------------------*/
package csd;

class App {	
	public static void main(String [] args) 
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int val = Integer.parseInt(kb.nextLine());
		
		if (val > 0)
			if (val % 2 == 0)
				System.out.println("Pozitif çift");
			else
				System.out.println("Pozitif tek");
		else
			System.out.println("Pozitif değil");
		
		System.out.println("Tekrar yapıyor musunuz?");		
	}
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/
```

