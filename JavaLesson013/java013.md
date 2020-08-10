### Bir metodun parametresi bir dizi referansı olabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	08.08.2020
	Bir metodun parametresi bir dizi referansı olabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

class App {
	public static void main(String [] args)
	{
		int [] a = {1, 2, 3, 4, 5};

		ArrayUtil.display(a);
	}
}
```
### Bir metodun geri dönüş değerine ilişkin tür bir dizi türü olabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir metodun geri dönüş değerine ilişkin tür bir dizi türü olabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Random;

class App {
	public static void main(String [] args)
	{
		Random r = new Random();
		int [] a = ArrayUtil.getRandomArray(r, 10, 0, 101);

		ArrayUtil.display(a);
	}
}
```
### ArrayUtil sınıfının swap metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	ArrayUtil sınıfının swap metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

class App {
	public static void main(String [] args)
	{
		int [] a = {1, 2, 3, 4, 5};

		ArrayUtil.swap(a, 1, 3);

		ArrayUtil.display(a);
	}
}
```
### ArrayUtil sınıfının fillRandomArray metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	ArrayUtil sınıfının fillRandomArray metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Random;

class App {
	public static void main(String [] args)
	{
		Random r = new Random();
		int [] a = new int[10];

		ArrayUtil.fillRandomArray(r, a, 0, 101);
		ArrayUtil.display(a);
	}
}
```
### Sınıf Çalışması: Parametresi ile aldığı int türden bir diziyi tersyüz eden reverse isimli metodu yazınız ve tes ediniz. İşlemi ikinci bir dizi kullanmadan yapınız.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden bir diziyi tersyüz eden reverse isimli metodu
	yazınız ve tes ediniz. İşlemi ikinci bir dizi kullanmadan yapınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

class App {
	public static void main(String [] args)
	{
		int [] a = {1, 2, 3, 4, 5, 6};

		ArrayUtil.reverse(a);
		ArrayUtil.display(a);
	}
}
```
### Sınıf Çalışması: Parametresi ile aldığı int türden bir diziyi tersyüz eden reverse isimli metodu yazınız ve tes ediniz. İşlemi ikinci bir dizi kullanmadan yapınız.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden bir diziyi tersyüz eden reverse isimli metodu
	yazınız ve tes ediniz. İşlemi ikinci bir dizi kullanmadan yapınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

class App {
	public static void main(String [] args)
	{
		int [] a = {1, 2, 3, 4, 5};

		Util.reverse(a);
		ArrayUtil.display(a);
	}
}

class Util {
	public static void reverse(int [] a)
	{
		int left = 0;
		int right = a.length - 1;

		while (left < right)
			swap(a, left++, right--);
	}

	public static void swap(int [] a, int i, int k)
	{
		int temp;

		temp = a[i];
		a[i] = a[k];
		a[k] = temp;
	}
}
```
### Java'da length bilgisi sıfır olan dizi yaratılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java'da length bilgisi sıfır olan dizi yaratılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int [] a = new int[0];
		int [] b = {};

		System.out.printf("Length:%d%n", a.length);
		System.out.printf("Length:%d%n", b.length);
	}
}
```
### Sıfır elemanlı aşağıdaki gibi kontrol amaçlı kullanılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sıfır elemanlı aşağıdaki gibi kontrol amaçlı kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Dizinin eleman sayısını giriniz:");
		int n = Integer.parseInt(kb.nextLine());

		System.out.print("En küçük değeri giriniz:");
		int min = Integer.parseInt(kb.nextLine());

		System.out.print("En büyük değeri giriniz:");
		int max = Integer.parseInt(kb.nextLine());

		Random r = new Random();

		int [] a = Util.getRandomArray(r, n, min, max);

		if (a.length != 0)
			ArrayUtil.display(a);
		else
			System.out.println("Geçersiz değerler");
	}
}

class Util {
	public static int[] getRandomArray(Random r, int n, int min, int max)
	{
		if (n <= 0 || min > max)
			return new int[0];

		int [] a = new int[n];

		for (int i = 0; i < a.length; ++i)
			a[i] = r.nextInt(max - min) + min;

		return a;
	}
}
```
### Sayısal loto kuponu üreten basit bir program
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sayısal loto kuponu üreten basit bir program
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.lottary.LottaryApp;

class App {
	public static void main(String [] args)
	{
		LottaryApp.run();
	}
}

package org.csystem.app.samples.lottary;

import org.csystem.util.ArrayUtil;

import java.util.Scanner;

public class LottaryApp {
    public static void run()
    {
        Lottary lottary = new Lottary();
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print("Kaç kupon oynamak istersiniz?");
            int n = Integer.parseInt(kb.nextLine());

            if (n <= 0)
                break;

            for (int i = 0; i < n; ++i)
                ArrayUtil.display(2, lottary.getNumbers());

            System.out.println("///////////////////");
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}


package org.csystem.app.samples.lottary;

import java.util.Arrays;
import java.util.Random;

public class Lottary {
    public Random random;

    public Lottary()
    {
        random = new Random();
    }

    public int [] getNumbers()
    {
        int [] a = new int[6];

        for (int i = 0; i < 6; ++i) {
            boolean repeat;

            do {
                repeat = false;
                a[i] = random.nextInt(49) + 1;
                for (int k = 0; k < i; ++k)
                    if (a[k] == a[i]) {
                        repeat = true;
                        break;
                    }
            } while (repeat);
        }

        Arrays.sort(a); //Diziyi küçükten büyüğe sıralar

        return a;
    }
}
```
### Sayısal loto kuponu üreten basit bir program (Daha iyi versiyon)
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sayısal loto kuponu üreten basit bir program
	(Daha iyi versiyon)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.lottary.LottaryApp;

class App {
	public static void main(String [] args)
	{
		LottaryApp.run();
	}
}

package org.csystem.app.samples.lottary;

import org.csystem.util.ArrayUtil;

import java.util.Scanner;

public class LottaryApp {
    public static void run()
    {
        Lottary lottary = new Lottary();
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print("Kaç kupon oynamak istersiniz?");
            int n = Integer.parseInt(kb.nextLine());

            if (n <= 0)
                break;

            for (int i = 0; i < n; ++i)
                ArrayUtil.display(2, lottary.getNumbers());

            System.out.println("///////////////////");
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}

package org.csystem.app.samples.lottary;

import java.util.Random;

public class Lottary {
    public Random random;

    public boolean [] getFlags()
    {
        boolean [] flags = new boolean[50];
        int val;

        for (int i = 0; i < 6; ++i) {
            for (;;) {
                val = random.nextInt(49) + 1;
                if (!flags[val])
                    break;
            }
            flags[val] = true;
        }

        return flags;
    }

    public int [] getNumbers(boolean [] flags)
    {
        int [] a = new int[6];

        int index = 0;

        for (int i = 1; i < 50; ++i)
            if (flags[i])
                a[index++] = i;

        return a;
    }

    public Lottary()
    {
        random = new Random();
    }

    public int [] getNumbers()
    {
        return getNumbers(getFlags());
    }
}
```
### ArrayUtil sınıfının max ve min metotları
```java
/*----------------------------------------------------------------------------------------------------------------------
	ArrayUtil sınıfının max ve min metotları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

class App {
	public static void main(String [] args)
	{
		int [] a = ArrayUtil.getRandomArray(10, 0, 256);

		ArrayUtil.display(3, a);

		System.out.printf("En küçük eleman:%d%n", ArrayUtil.min(a));
		System.out.printf("En büyük eleman:%d%n", ArrayUtil.max(a));
	}
}
```
### Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının basamklarından oluşan diziyi döndüren getDigits isimli metodu yazınız.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının basamklarından
	oluşan diziyi döndüren getDigits isimli metodu NumberUtil sınıfı içerisinde yazınız.
	Metot negatif sayılar için pozitif düşünerek diziyi döndürecektir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;
import org.csystem.util.NumberUtil;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		GetDigitsTest.run();
	}
}

class GetDigitsTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);

		for (;;) {
			System.out.print("Bir sayı giriniz:");
			int val = Integer.parseInt(kb.nextLine());
			int [] digits = NumberUtil.getDigits(val);

			ArrayUtil.display(digits);

			if (val == 0)
				break;
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
### Sınıf Çalışması: Parametresi ile aldığı int türden bir dizinin elemanları toplamını döndüren sum isimli metodu ArrayUtil sınıfı içerisinde yazınız.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden bir dizinin elemanları toplamını döndüren
	sum isimli metodu ArrayUtil sınıfı içerisinde yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

class App {
	public static void main(String [] args)
	{
		int [] a = ArrayUtil.getRandomArray(10, 0, 101);

		ArrayUtil.display(2, a);

		System.out.printf("Toplam:%d%n", ArrayUtil.sum(a));
	}
}
```
### ArrayUtil sınıfının getHistogramData metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	ArrayUtil sınıfının getHistogramData metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

class App {
	public static void main(String [] args)
	{
		int [] a = ArrayUtil.getRandomArray(20, 0, 11);//[0, 11)

		ArrayUtil.display(a);
		ArrayUtil.display(ArrayUtil.getHistogramData(a, 10)); //[0, 10]
	}
}
```
### String sınıfının char türden dizi paametreli ctor'u ile char türden diziden bir String elde edilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının char türden dizi paametreli ctor'u ile char türden diziden bir String
	elde edilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		char [] c = {'a','n', 'k', 'a', 'r', 'a'};
		String s = new String(c);

		System.out.println(s);
	}
}
```
### String sınıfının char türden dizi paametreli valueOf ile char türden diziden bir String elde edilebilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının char türden dizi paametreli valueOf ile char türden diziden bir String
	elde edilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		char [] c = {'a','n', 'k', 'a', 'r', 'a'};
		String s = String.valueOf(c);

		System.out.println(s);
	}
}
```
### String sınıfının toCharArray metodu ile bit String'in karakterlerinden oluşan char türden bir dizi elde edilebilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfının toCharArray metodu ile bit String'in karakterlerinden oluşan
	char türden bir dizi elde edilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		String s = "ankara";
		char [] c = s.toCharArray();

		for (int i = 0; i < c.length; ++i)
			System.out.println(c[i]);
	}
}
```
### StringUtil sınıfının reverse metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	StringUtil sınıfının reverse metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.StringUtil;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Bir yazı giriniz:");
		String str = kb.nextLine();

		System.out.println(StringUtil.reverse(str));
	}
}
```
## Dizilerin sıraya dizilmesi (sorting):
```java
/*----------------------------------------------------------------------------------------------------------------------
	09.08.2020
	Dizilerin sıraya dizilmesi (sorting):
	Dizilerin sıraya dizlmesine yönelik çok algoritma vardır. Sıraya dizme işleminde küçük büyüğe (ascending) sıralama
	doğal sıralama (natural sort order) olarak tanımlanır. Biz burada kabarcık sıralama (bubble sort) ve
	seçerek sıralama (selection sort) algoritmalarını kodlayacağız
----------------------------------------------------------------------------------------------------------------------*/
### Kabarcık sıralama algoritması
/*----------------------------------------------------------------------------------------------------------------------
	Kabarcık sıralama algoritmasında dizinin yanyana iki elemanı karşıklaştırılır duruma göre yer değiştirilir.
	Bu işlem bir kez yapılmaz. Her yinelemede en büyük eleman daraltılmış dizinin sonuna gider. Böylece her yinelemede
	eskisinde bir geriye kadar gitmek yeterli olur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

class App {
	public static void main(String [] args)
	{
		int [] a = {-3, 4, -8, 9, -2, 7, 10, 11};

		ArrayUtil.bubbleSort(a, true);
		ArrayUtil.display(a);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Kabarcık sıralama algoritması
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

class App {
	public static void main(String [] args)
	{
		int [] a = {-3, 4, -8, 9, -2, 7, 10, 11};

		ArrayUtil.bubbleSort(a);
		ArrayUtil.display(a);
	}
}
```
### Seçerek sıralama algoritması
```java
/*----------------------------------------------------------------------------------------------------------------------
	Seçerek sıralama yönteminde dizinin en küçük elemanı bulunur, ilk elemanla yer değiştirilir. Dizi bir daraltılır,
	aynı şey daraltılmış dizi için de yapılır. Böyle ilerlenir.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

class App {
	public static void main(String [] args)
	{
		int [] a = {-3, 4, -8, 9, -2, 7, 10, 11};

		ArrayUtil.selectionSort(a);
		ArrayUtil.display(a);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Seçerek sıralama yöntemi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

class App {
	public static void main(String [] args)
	{
		int [] a = {-3, 4, -8, 9, -2, 7, 10, 11};

		ArrayUtil.selectionSort(a, true);
		ArrayUtil.display(a);
	}
}
```
### ArrayUtil sınıfının partition metodu (partition algoritması kullanılmıştır)
```java
/*----------------------------------------------------------------------------------------------------------------------
	ArrayUtil sınıfının partition metodu (partition algoritması kullanılmıştır)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

class App {
	public static void main(String [] args)
	{
		int [] a = {1, 2, 3, 4, 5};
		int partitionPoint = ArrayUtil.partition(a , 8);

		ArrayUtil.display(a);
		System.out.printf("Partition Point:%d%n",partitionPoint);

	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	ArrayUtil sınıfının partition metodu (partition algoritması kullanılmıştır)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

class App {
	public static void main(String [] args)
	{
		int [] a = {1, 2, 3, 4, 5};
		int partitionPoint = ArrayUtil.partition(a , -1);

		ArrayUtil.display(a);
		System.out.printf("Partition Point:%d%n",partitionPoint);

	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	ArrayUtil sınıfının partition metodu (partition algoritması kullanılmıştır)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Random;

class App {
	public static void main(String [] args)
	{
		Random r = new Random();
		int [] a = ArrayUtil.getRandomArray(r, 10, 0, 101);
		int threshold = r.nextInt(101);
		ArrayUtil.display(a);
		System.out.printf("Threshold:%d%n", threshold);
		int partitionPoint = ArrayUtil.partition(a , threshold);

		ArrayUtil.display(a);
		System.out.printf("Partition Point:%d%n",partitionPoint);
	}
}
```
### ArrayUtil sınıfının drawHistogram metodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	ArrayUtil sınıfının drawHistogram metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		DrawHistogramTest.run();
	}
}

class DrawHistogramTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		Random r = new Random();

		for (;;) {
			System.out.print("Dizinin eleman sayısını giriniz:");
			int count = Integer.parseInt(kb.nextLine());

			if (count <= 0)
				break;

			int n = 10;

			int [] a = ArrayUtil.getRandomArray(r, count, 0, n + 1);
			int [] hist = ArrayUtil.getHistogramData(a, n);

			System.out.print("Dizi:");
			ArrayUtil.display(a);
			System.out.print("Histogram verileri:");
			ArrayUtil.display(hist);
			ArrayUtil.drawHistogram(hist, 15, 'X');
			System.out.println("\n\n");
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}
```
## Referans dizileri
```java
/*----------------------------------------------------------------------------------------------------------------------
	Referans dizilerinde dizinin yaratılması dizinin elemanları olan referansların gösterdikleri nesnelerin de
	yaratılması anlamına gelmez. Bu durumdda programcının referans dizisinin elemanlları olan referanslara da
	uygun nesnelerin adreslerini vermesi gerekir. Aşağıdaki örnekte referans dizi yaratılmıştır ancak referansların
	gösterdiği nesneler olmadığı için erişmeye çalışmak exception oluşturur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Sample [] samples;

		samples = new Sample[5];

		for (int i = 0; i < 5; ++i)
			samples[i].x = i;

		for (int i = 0; i < 5; ++i)
			System.out.println(samples[i].x);
	}
}

class Sample {
	public int x;
	public Sample(int a)
	{
		x = a;
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki problemin bir çözümü aşağıdaki gibi olabilir. Şüphesiz çözüm senaryoya da bağlıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Sample [] samples;

		samples = new Sample[5];

		for (int i = 0; i < 5; ++i)
			samples[i] = new Sample(i);

		for (int i = 0; i < 5; ++i)
			System.out.println(samples[i].x);
	}
}

class Sample {
	public int x;
	public Sample(int a)
	{
		x = a;
	}
}
```
### Referans dizierine ilkdeğer verilmesi
```java
/*----------------------------------------------------------------------------------------------------------------------
	Referans dizierine ilkdeğer verilmesi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Sample s = new Sample(10);
		Sample k = new Sample(30);
		Sample [] samples = {new Sample(1), s, new Sample(67), s, k, new Sample(90)};

		for (int i = 0; i < samples.length; ++i)
			System.out.printf("%d ", samples[i].x);

		System.out.println();
	}
}

class Sample {
	public int x;
	public Sample(int a)
	{
		x = a;
	}
}
```
### String dizileri
```java
/*----------------------------------------------------------------------------------------------------------------------
	String dizileri
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		String [] cities = {"ankara", "istanbul", "izmir", "zonguldak", "bolu"};

		for (int i = 0; i < cities.length; ++i)
			System.out.println(cities[i]);
	}
}
```
### Sınıf çalışması: getDayOfWeek metodunu aşağıdaki kurallara göre yazınız.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf çalışması: Parametresi ile aldığı int türden gün, ay ve yıl bilgilerine ilişkin tarihin aşağıdaki
	açıklamalara göre haftanın hangi gününe geldiğini döndüren getDayOfWeek metodunu yazınız.
	Açıklamalar:
		- Metot geçersiz bir tarih için -1 değerini döndürecektir.
		- Haftanın günü 1.1.1900 ile verilen tarih arasındaki gün sayısının 7 değerine modu alınarak bulunabilir
		- 7 değerine mod alındıktan sonra sıfır Pazar, 1 pazartesi, .., 6 cumartesi günü için
		elde edilecek değerdir
		- 1.1.1900' den önceki tarihler geçersiz kabul edilecektir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.dateapp.DateUtilApp;

class App {
	public static void main(String [] args)
	{
		DateUtilApp.run();
	}
}

package org.csystem.app.samples.dateapp;

public class DateUtilApp {
	public static String [] daysOfWeek = {"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};
	public static String [] monthsTR = {"", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran",
			"Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};

	public static String [] monthsEN = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

	public static void displayTR(int day, int month, int year)
	{
		int dayOfWeek = DateUtil.getDayOfWeek(day, month, year);

		if (dayOfWeek == -1) {
			System.out.println("Geçersiz tarih");
			return;
		}

		System.out.printf("%02d %s %04d %s%n", day, monthsTR[month], year, daysOfWeek[dayOfWeek]);

		if (dayOfWeek == 0 || dayOfWeek == 6)
			System.out.println("Bugün kurs var. Tekrar yaptınız mı?");
		else
			System.out.println("Kurs günü yaklaşıyor. Tekrar yapınız!!!!");
	}

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

			displayTR(day, month, year);
		}
	}
}

package org.csystem.app.samples.dateapp;

public class DateUtil {
	public static int [] daysOfMonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public static int getDayOfWeek(int day, int month, int year)
	{
		int dayOfYear;

		dayOfYear = getDayOfYear(day, month, year);

		if (dayOfYear == -1 || year < 1900)
			return -1;

		for (int y = 1900; y < year; ++y)
			dayOfYear += isLeapYear(y) ? 366 : 365;

		return dayOfYear % 7;
	}

	public static int getDayOfYear(int day, int month, int year)
	{
		if (!isValidDate(day, month, year))
			return -1;

		int dayOfYear = day;

		for (int m = month - 1; m >= 1; --m)
			dayOfYear += daysOfMonths[m];

		if (month > 2 && isLeapYear(year))
			++dayOfYear;

		return dayOfYear;
	}

	public static boolean isValidDate(int day, int month, int year)
	{
		if (day < 1 || day > 31 || month < 1 || month > 12)
			return false;

		int days = month == 2 && isLeapYear(year) ? 29 : daysOfMonths[month];

		return day <= days;
	}

	public static boolean isLeapYear(int year)
	{
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
}
```
### Sınıf çalışması: Klavyden int türden bir n sayısı isteyiniz. n elemanlı bir String dizisi yaratınız. 
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf çalışması: Klavyden int türden bir n sayısı isteyiniz. n elemanlı bir String dizisi yaratınız.
	Bu dizinin her bir elemanını rasgele uzunlukta rasgele üretilmiş yazılarla doldurunuz. Bu işlemden sonra
	dizinin elemanlarını aralarında - (tire) karakteri olacak şekilde birleştirip yeni bir String elde eden
	programı yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;
import org.csystem.util.StringUtil;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		JoinWithDelimiterApp.run();
	}
}

class JoinWithDelimiterApp {
	public static void run()
	{
		Random r = new Random();
		Scanner kb = new Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int n = Integer.parseInt(kb.nextLine());

		String [] strings = new String[n];

		for (int i = 0; i < n; ++i)
			strings[i] = StringUtil.getRandomTextTR(r, r.nextInt(10) + 10);

		ArrayUtil.display(strings);

		String str = ArrayUtil.join(strings, '-');

		System.out.println(str);
	}
}
```
### Sınıf çalışması: Parametresi ile aldığı en fazla üç basamaklı bir sayının Türkçe olarak okunuşunu döndüren numberToText3DigitsTR metodunu yazınız ve test ediniz.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf çalışması: Parametresi ile aldığı en fazla üç basamaklı bir sayının Türkçe olarak okunuşunu döndüren
	numberToText3DigitsTR metodunu yazınız ve test ediniz. Metot 3 basamaktan daha büyü sayılar için kontrol
	yapmayacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.NumberUtil;

import java.util.Random;
import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		NumberToText3DigitsTest.run();
	}
}

class NumberToText3DigitsTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		Random r = new Random();

		for (;;) {
			System.out.print("Bir sayı giriniz:");
			int n = Integer.parseInt(kb.nextLine());

			if (n <= 0)
				break;

			for (int i = 0; i < n; ++i) {
				int val = r.nextInt(1000 + 999) - 999;
				System.out.printf("%d:%s%n", val, NumberUtil.numberToText3DigitsTR(val));
			}
			System.out.println("*********************************");
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}

/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/


/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/


/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/
```
```java

