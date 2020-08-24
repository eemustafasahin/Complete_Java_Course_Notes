```java
/*----------------------------------------------------------------------------------------------------------------------
	22.08.2020
	for-each döngü deyiminin genel biçimi:
	for (<tür> <değişken> : <dolaşaılabilir (iterable) bir türe ilişkin referans>)
		<deyim>

	Burada dolaşılabilir kavramı uygulama kursunda ele alınacaktır. Diziler dolaşılabilir türler olduğundan
	for-each döngü deyimi ile kullanılabilir. İleride diziler dışında dolaşılabilir bir sınıflar göreceğiz

	for-each döngü deyimi kodu kolaylaştırır. Bu durumlarda hep for-each kullanılmalı. Kodu kolaylaştırmadığı
	durumlarda klasik for döngüsü tercih edilmelidir.

	for-each döngü deyimi kodun okunabilirliğini de artırır. Yani kodu okuyan kişi for-each döngü deyimi
	gördüğünde dizinin tüm elemanlarıyla sırasıyla bir işlem yapılıyor olduğunu anlar. Okunabilirlik tersten de düşünülebilir.
	Yani kodu okuyan kişi bir örneğin bir dizi için klasik for döngüsü görürse, "for-each ile yazılmadığına göre
	dizinin baştan sona tamamı dolaşılsa bile örneğin index gerekiyor olabilir" anlayabilir.
----------------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------------
	for-each döngü deyiminin dizi ile kullanımında döngü değişkenine döngünün her adımında o anki elemanın değeri
	atanır. Bu işlem dizinin başından sonuna kadar tekrarlanır. Aşağıdaki for-each deyiminin temsili karşılığı şu
	şekildedir:

    {
        int val;

        for (int i = 0; i < a.length; ++i) {
            val = a[i];

            System.out.printf("%d ", val);
        }
    }
```
```java
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int [] a = {1, 2, 3, 4, 5};

		for (int val : a)
			System.out.printf("%d ", val);

		System.out.println();
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	for-each döngü deyiminde döngü değişkenine atama işlemi dorğudan yapılır. Aşağıdaki örnekte int türünden short
	türüne otomatik tür dönüşümü olmadığından error oluşur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int [] a = {1, 2, 3, 4, 5};

		for (short val : a) //error
			System.out.printf("%d ", val);

		System.out.println();
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	for-each döngü deyiminde döngü değişkenine atama işlemi dorğudan yapılır. Aşağıdaki örnekte error oluşmaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int [] a = {1, 2, 3, 4, 5};

		for (double val : a)
			System.out.printf("%f%n", val);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	for-each döngü deyiminde döngü değişkenini alanı döngü boyunca görülebilirdir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int [] a = {1, 2, 3, 4, 5};

		for (double val : a)
			System.out.printf("%f%n", val);

		System.out.println(val); //error
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	for-each döngü deyiminde : den sonraki kısım bir kez yapılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		for (int val : Sample.getArray())
			System.out.printf("%d ", val);

		System.out.println();
	}
}

class Sample {
	public static int[] getArray()
	{
		System.out.println("getArray");

		return new int[] {1, 2, 3, 4, 5};
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	for-each döngü deyiminde döngü değişkenine atama yapılabilir. Bu çok işe yarar bir işlem değildir. Şüphesiz
	döngü değikenini değiştirmez diz elemanını değiştirmez
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int [] a = {1, 2, 3, 4};

		for (int val : a)
			val *= 2;

		for (int val : a)
			System.out.printf("%d ", val);

		System.out.println();
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	String sınıfı for-each döngü deyimi ile kullanılamamaktadır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		String s = "ankara";

		for (char c : s) //error
			System.out.println(c);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki işlem toCharArray metodu ile yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		String s = "ankara";

		for (char c : s.toCharArray())
			System.out.println(c);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	for-each döngü deyimi ile dizi dizilerinin dolaşılması
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int [][] a = {{1, 2}, {3, 4}, {5, 6}};

		for (int [] array : a) {
			for (int val : array)
				System.out.printf("%d ", val);

			System.out.println();
		}
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	for-each döngü deyimi kullanımı kolaylaştırdığı her yerde kullanılmalıdır. Ancak örneğin döngü içerisinde indeks
	gerekirse for-each döngü deyimi index değerini vermediğinden indeksin ayrıca tanımlanması yerine klasik
	for döngü deyimi tercih edilebilir. Aşağıdaki örnekte for-each döngü deyimi index ayrıca ayrıca tanımlanarak
	kullanılmıştır. Örnekte for-each döngü deyiminin döngü değişkeninin kullanılmadığına dikkat ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int [] a = new int[5];

		int i = 0;

		for (int val : a) // Bunun yerine klasik for döngüsü kullanılması daha iyidir
			a[i++] = i * 10;

		for (int val : a)
			System.out.printf("%d ", val);

		System.out.println();
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	ArrayUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Random;

public class ArrayUtil {
    public static void bubbleSortAscending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k + 1] < a[k])
                    swap(a, k, k + 1);
    }

    public static void bubbleSortDescending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k + 1] > a[k])
                    swap(a, k, k + 1);
    }

    public static void selectionSortAscending(int [] a)
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

    public static void selectionSortDescending(int [] a)
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

    public static int [][] addMatrices(int [][] a, int [][] b)
    {
        if (isNotMatrix(a) || isNotMatrix(b) || a.length != b.length || a[0].length != b[0].length) {
            System.out.println("Invalid matrices for add operation");
            System.exit(-1); //exception işlemlerine kadar sabredin
        }

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
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıfın elemanlarının erişim belirleyicileri:
	Sınıf elemanlarının (veri elemanları, metotlar, ctor'lar vb.) erişim belirleyicileri 4 tanedir:
	public, protected, no-modifier, private
	Erişim belirleyici anlamında sınıf dört bölüme ayrılmış gibi düşünülmelidir. Yani örneğin sınıfın public bir elemanı
	sınıfın içerisinde nerede bildirilirse bildirilsin public bölüme eklenmiş olur. Erişim belirleyiciler sınıf dışından
	erişim için anlamlıdır. Sınıfın dışı başka bir sınıfın içi demektir. Sınıfın içinde erişim belirleyici anlamında bir
	kısıt yoktur. Yani sınıfın içerisinde her bölüme erişilebilir.

	Anahtar Notlar: Sınıfın no-modifier elemanı (hiçbir erişim belirleyici yazılmaması) Java' da erişim anlamında
	diğerlerinden farklıdır. Bazı dillerde olduğu gibi no-modifier diğerlerinden biri anlamına gelmez (default).
	Bu durumun bir tek enum türünde ctor için istisnası
	vardır. İleride ele alınacaktır.

	Sınıfın protected ve no-modifier bölümlerinin anlamları sınıfların aynı pakette veya farklı pakette olmasına göre
	değişmektedir.

	Sınıfın private ve public bölümlerinin anlamları aynı pakette veya farklı pakette değişmemektedir
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıfın public bölüme sınıf dışından erişilebilir
----------------------------------------------------------------------------------------------------------------------*/

class A {
	public int a;

	public A()
	{}

	public void foo()
	{}
}

class B {
	public void bar()
	{
		A x = new A();

		x.a = 20;
		x.foo();
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıfın public bölüme sınıf dışından erişilebilir
----------------------------------------------------------------------------------------------------------------------*/

package test;

public class A {
    public int a;

    public A()
    {}

    public void foo()
    {}
}

package mest;

import test.A;

public class B {
    public void bar()
    {
        A x = new A();

        x.a = 20;
        x.foo();
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıfın private bölüme sınıf dışından erişilemez
----------------------------------------------------------------------------------------------------------------------*/

class A {
	private int a;

	private A()
	{}

	private void foo()
	{}
}

class B {
	public void bar()
	{
		A x = new A(); //error

		x.a = 20; //error
		x.foo(); //error
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıfın private bölüme sınıf dışından erişilemez
----------------------------------------------------------------------------------------------------------------------*/

package test;

public class A {
    private int a;

    private A()
    {}

    private void foo()
    {}
}

package mest;

import test.A;

public class B {
    public void bar()
    {
        A x = new A(); //error

        x.a = 20; //error
        x.foo(); //error
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıfın no-modifier bölümü aynı paketteki diğer sınıflar için public anlamındadır (friendly, internal)
----------------------------------------------------------------------------------------------------------------------*/
class A {
	int a;

	A()
	{}

	void foo()
	{}
}

class B {
	public void bar()
	{
		A x = new A();

		x.a = 20;
		x.foo();
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıfın no-modifier bölümü farklı paketteki diğer sınıflar için private anlamındadır
----------------------------------------------------------------------------------------------------------------------*/
package test;

public class A {
    int a;

    A()
    {}

    void foo()
    {}
}

package mest;

import test.A;

public class B {
    public void bar()
    {
        A x = new A(); //error

        x.a = 20; //error
        x.foo(); //error
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıfın protected bölümü aynı paketteki diğer sınıflar için public anlamındadır (friendly, internal)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		//...
	}
}

class A {
	protected int a;

	protected A()
	{}

	protected void foo()
	{}
}

class B {
	public void bar()
	{
		A x = new A();

		x.a = 20;
		x.foo();
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıfın protected bölümü farklı paketteki diğer sınıflar için türetme (inheritance) söz konusu değilse private
	anlamdadır. Türetme ve protected bölümün anlamı ileride ele alınacaktır
----------------------------------------------------------------------------------------------------------------------*/
package test;

public class A {
    protected int a;

    protected A()
    {}

    protected void foo()
    {}
}

package mest;

import test.A;

public class B {
    public void bar()
    {
        A x = new A(); //error

        x.a = 20; //error
        x.foo(); //error
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Erişim Belirleyici          Kendisi         Aynı Paketteki sınıflar     Farklı paketteki sınıflar       Türemiş sınıflar
    public                         T                       T                           T                            T
    protected                      T                       T                           F                            T
    no-modifier                    T                       T                           F                            F
    private                        T                       F                           F                            F
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıfın özellikle veri elemanlarının gizlenmesine (yani diğer sınıflardan erişilememesine) nesne yönelimli
	programlama tekniğinde kapsülleme (encapsulation) denir. Bu kavramın geneline veri/bilgi gizleme (data/information hiding)
	denir. Burada temel amaç dışarıyı yani sınıf dışını ilgilendirmeyecek verilerin/bilgilerin dışarıya verilmemesidir.
	Bu kavram gerçek hayattan nesne yönelimli programlamaya aktarılmıştır. Örneğin araba kullanan bir kişi vites değişim
	sırasında teknik olarak vites değişiminin nasıl gerçekleştiğini bilmek zorunda değildir. Bilse bile araba kullanırken
	bunun anlamı yoktur.

	Bu anlamda sınıfı yazan ve sınıfı kullanan bakış açısı farklıdır. Genel olarak sınıfı kullanan kişiye sınıfn müşterisi
	(client), sınıfı yazan kişiye ise hizmet veren (server) denir.
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Anahtar Notlar: Programlamada isimlendirme için bazı teknikler kullanılmaktadır. Bu teknikler dışında da isimlendirme
    yapılabilir. Bunlar çok kullanılan tekniklerdir:
    1. Unix stili (snake case): Bu isimlendirmede karakterlerin tamamı küçük harfle yazılır ve birden fala kelimeden oluşan
    isimlerde kelimeler arasına alttire karakteri yerleştirilir. Bu isimlendirme Java'da pek tercih edilmez. Örneğin:
        number_of_invoices, serial_port

    2. Camel case (lower camel case): Bu isimlendirmede kelimeler bitişik yazılır. İlk kelimenin baş harfi küçük, diğer
    kelimelerin baş harfleri büyük olarak yazılır. Geri kalan tüm karakterler de küçük harfle yazılır. Bu isimlendirme
    Java'da genel olarak yerel değişkenlerde, parametre değişkenlerinde ve metot isimlerinde tercih edilir. Örneğin:
        parseInt, nextBoolean, isPrime

    3. Pascal case (upper camel case): Bu isimlendirmede kelimeler bitişik yazılır. Tüm kelimelerin baş haffleri
    büyük harf geri kalan karakterler küçük harfle yazılır. Bu isimlerndirme Java' da genelde sınıf ve benzeri
    türlerde kullanılır. Örneğin:
        Random, String, LottaryApp

    İsimlendirmede bunlardan biri ya da birden fazlası kullanılmak zorunda değildir. Örneğin Java' da genel olarak
    paket isimlerinin tamamı küçük harfle ve bitişik olarak yazılır. Örneğin:
        org.csystem.util, java.lang, java.io, java.util
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Nesne yönelimli programlamada sınıfın özellike gizlene (genel olarak private) veri elemanlarının isimlendirilmesine
    yönelik bazı teknikler kullanılmaktadır. Örneğin bazı programcılar private veri elemanları isimlendirmesinde
    (lower) camel case kullanılabilir. Ya da örneğin, private veri elemanları "m_", "d_", "_", "m" gbi önekler alabilir.
    Biz sınıfın private veri elemanları için "m_" önekini kullanacağız. Eğer sınıfın private veri elemanı aynı
    zamanda static "ms_" önekini kullanacağız.
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir veri elemanı gizlendiğinde sınıfın müşteri kodlarının bu elemana değer ataması veya bu elemanın değerini
    elde etmesi için public metotlar yazılabilir. Veri elenaanlarına erişip değerine elde etmek için yazılan metotlara
    "get metotları (getters)" denir. Veri elemanına erişip değerini değiştirmeye yarayan metotlara ise "set metotları (setters)"
    denir. Sınıfın bu şekildeki metotlarına "accessors" denir. Tersine get ve set metotlarının veri elemanlarına erişmesi
    gerekmez. Bu durumda metotlar mantıksal olarak yazılır. Bu durum ileride ele alınacaktır.

    Sınıfın set metotlarının isimleri "set" ile başlatılır. get metotları ise "get" ile başlatılır. İstisna olarak
    sınfın get metodu boolean türden bir değere karşılık geliyor ise genel olarak ismi "is" ile başlatılır.
    Sınıfı yazan programcı bu isimlendirmeye aksi bir durum olmadıkça dikkat etmelidir. Birtakım işlem yapan ve uygulamada
    kullanılan ortamlar (framework) veya kütüphaneler (libraries) programcı tarafından yazılmış olan sınıflar için bu şekilde
    isimlendirilen metotları ararlar ve çağırırlar.
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki Date sınıfında veriler gizlenmiş ve get, set metotları yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Date date = new Date(10, 9, 1976);

		System.out.printf("%02d/%02d/%04d%n", date.getDay(), date.getMonth(), date.getYear());

		date.setDay(11);
		date.setMonth(7);
		date.setYear(1983);

		System.out.printf("%02d/%02d/%04d%n", date.getDay(), date.getMonth(), date.getYear());
	}
}

class Date {
	private int m_day, m_mon, m_year;

	public Date(int day, int mon, int year)
	{
		//...
		m_day = day;
		m_mon = mon;
		m_year = year;
	}

	public int getDay()
	{
		return m_day;
	}

	public void setDay(int val)
	{
		//...
		m_day = val;
	}

	public int getMonth()
	{
		return m_mon;
	}

	public void setMonth(int val)
	{
		//...
		m_mon = val;
	}

	public int getYear()
	{
		return m_year;
	}

	public void setYear(int val)
	{
		//...
		m_year = val;
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki Device sınıfında m_isActive veri elemanı için get metodunun ismi "is" ile başlatılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Device device = new Device("test", "192.156.2.123", 50500, true);

		System.out.printf("%s://%s:%d %s", device.getName(), device.getHost(), device.getPort(), device.isActive() ? "Çalışıyor" : "Çalışmıyor");
	}
}

class Device {
	private String m_name;
	private String m_host;
	private int m_port;
	private boolean m_isActive;

	public Device(String name, String host, int port, boolean isActive)
	{
		//...
		m_name = name;
		m_host = host;
		m_port = port;
		m_isActive = isActive;
	}

	public String getName()
	{
		return m_name;
	}

	public String getHost()
	{
		return m_host;
	}

	public int getPort()
	{
		return m_port;
	}

	public boolean isActive()
	{
		return m_isActive;
	}

	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki durumlardan en az biri varsa veri elemanı gizlenmelidir:
    - Sınıfın geliştirilmesinde versiyon değiştikçe (ilerledikçe) bir veri elemanın isminin hatta türünün değişmesine
    çok sık ratlanır. Bu durumda eski kodların bu değişimden etkilenmemesi için veri elemanı gizlenmelidir.

    - Bir veri elemanının sınır değerleri olabilir. Bu değerlerin kontrol edilip değiştirilebilmesi için veri elemanı
    gizlenmelidir

    - Bir veri elemanı değiştiğinde başka bir veri elemanının değerinin değişen elemana göre hesaplanması gerekebilir.
    Bu durumda veri elemanları gizlenmelidir

    - Bir veri elemanı değiştiğinde yeni değere göre bir işlem yapılması gerekiyor olabilir. Örneğin veri elemanı
    bir uzak veri tabanı yönetyim sistemine ilişkin yer (adres) bilgisi (url) tutuyor olsun. Bu bilgi değiştikçe eski
    adresten bağlantı kesilip yeni adresteki veritabanı yönetim sistemine bağlanılması gerekiyor olabilir. Bu durumda
    ilgili veri elemanı gizlenmelidir

    - Bazen bir veri elemanının gizlenmesi gerekmese de diğer veri elemanları da gizlendiğinden bütünlük açısından
    gizlenebilir

    Bu durumlar dışında (%3 ile %5 arası rastlanır) sınıfın veri elemanı puıblic yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağdaki örnekte Date sınıfının içsel algoritması değişmesine rağmen müşteri kodları bundan etkilenmemiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Date date = new Date(10, 9, 1976);

		System.out.printf("%02d/%02d/%04d%n", date.getDay(), date.getMonth(), date.getYear());

		date.setDay(11);
		date.setMonth(7);
		date.setYear(1983);

		System.out.printf("%02d/%02d/%04d%n", date.getDay(), date.getMonth(), date.getYear());
	}
}

class Date {
	private String m_date;

	public Date(int day, int mon, int year)
	{
		//...
		m_date = String.format("%02d/%02d/%04d", day, mon, year);
	}

	public int getDay()
	{
		return Integer.parseInt(m_date.substring(0, 2));
	}

	public void setDay(int val)
	{
		//...
		m_date = String.format("%02d/%02d/%04d", val, getMonth(), getYear());
	}

	public int getMonth()
	{
		return Integer.parseInt(m_date.substring(3, 5));
	}

	public void setMonth(int val)
	{
		//...
		m_date = String.format("%02d/%02d/%04d", getDay(), val, getYear());
		//...
	}

	public int getYear()
	{
		return Integer.parseInt(m_date.substring(6));
	}

	public void setYear(int val)
	{
		//...
		m_date = String.format("%02d/%02d/%04d", getDay(), getMonth(), val);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    23.08.2020
	Circle sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.geometry.Circle;

class App {
	public static void main(String [] args)
	{
		Circle c = new Circle();

		System.out.printf("Yarıçap:%f%n", c.getRadius());
		System.out.printf("Alan:%f%n", c.getArea());
		System.out.printf("Çevre:%f%n", c.getCircumference());
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Circle sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.geometry.Circle;

class App {
	public static void main(String [] args)
	{
		Circle c = new Circle(-2.3);

		System.out.printf("Yarıçap:%f%n", c.getRadius());
		System.out.printf("Alan:%f%n", c.getArea());
		System.out.printf("Çevre:%f%n", c.getCircumference());

		c.setRadius(-9);

		System.out.println("///////////////////////");
		System.out.printf("Yarıçap:%f%n", c.getRadius());
		System.out.printf("Alan:%f%n", c.getArea());
		System.out.printf("Çevre:%f%n", c.getCircumference());
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Circle sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.geometry.Circle;

class App {
	public static void main(String [] args)
	{
		Circle c = new Circle(-2.3);

		System.out.printf("Yarıçap:%f%n", c.getRadius());
		System.out.printf("Alan:%f%n", c.getArea());
		System.out.printf("Çevre:%f%n", c.getCircumference());

		c.setPI(3);

		System.out.println("///////////////////////");
		System.out.printf("Yarıçap:%f%n", c.getRadius());
		System.out.printf("Alan:%f%n", c.getArea());
		System.out.printf("Çevre:%f%n", c.getCircumference());
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Circle sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math.geometry;

public class Circle {
    private double m_r;
    private double m_area;
    private double m_circumference;
    private double m_pi;

    private void calculateArea()
    {
        m_area = m_pi * m_r * m_r;
    }

    private void calculateCircumference()
    {
        m_circumference = 2 * m_pi * m_r;
    }

    private void calculate()
    {
        calculateArea();
        calculateCircumference();
    }

    public Circle()
    {
    }

    public Circle(double r)
    {
        setRadius(r);
    }

    public Circle(double r, double pi)
    {
        setRadius(r, pi);
    }

    public double getRadius()
    {
        return m_r;
    }

    public void setRadius(double r)
    {
        setRadius(r, Math.PI);
    }

    public void setRadius(double r, double pi)
    {
        m_r = Math.abs(r);
        setPI(pi);
    }

    public double getArea()
    {
        return m_area;
    }

    public double getCircumference()
    {
        return m_circumference;
    }

    public void setPI(double pi)
    {
        m_pi = Math.abs(pi); //Kolaylık için mutlak değer aldık
        calculate();
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Circle sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.geometry.Circle;

class App {
	public static void main(String [] args)
	{
		Circle c = new Circle(-2.3);

		System.out.printf("Yarıçap:%f%n", c.getRadius());
		System.out.printf("Alan:%f%n", c.getArea());
		System.out.printf("Çevre:%f%n", c.getCircumference());

		c.setPI(3);

		System.out.println("///////////////////////");
		System.out.printf("Yarıçap:%f%n", c.getRadius());
		System.out.printf("Alan:%f%n", c.getArea());
		System.out.printf("Çevre:%f%n", c.getCircumference());
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Circle sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math.geometry;

public class Circle {
    private double m_radius;
    private double m_pi;

    public Circle()
    {
    }

    public Circle(double radius)
    {
        setRadius(radius);
    }

    public Circle(double radius, double pi)
    {
        setRadius(radius, pi);
    }

    public double getRadius()
    {
        return m_radius;
    }

    public void setRadius(double radius)
    {
        setRadius(radius, Math.PI);
    }

    public void setRadius(double radius, double pi)
    {
        m_radius = Math.abs(radius);
        setPI(pi);
    }

    public double getArea()
    {
        return m_pi * m_radius * m_radius;
    }

    public double getCircumference()
    {
        return 2 * m_pi * m_radius;
    }

    public void setPI(double pi)
    {
        m_pi = Math.abs(pi); //Kolaylık için mutlak değer aldık
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Complex sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math;

public class Complex {
	private static Complex add(double re1, double im1, double re2, double im2)
	{
		Complex z = new Complex();

		z.re = re1 + re2;
		z.im = im1 + im2;

		return z;
	}

	private static Complex subtract(double re1, double im1, double re2, double im2)
	{
		return add(re1, im1, -re2, -im2);
	}

	public double re;
	public double im;

	public Complex()
	{

	}

	public Complex(int a)
	{
		re = a;
	}

	public Complex(int a, int b)
	{
		re = a;
		im = b;
	}

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

	public String toString()
	{
		return String.format("|%.2f + %.2f * i| = %f", re, im, getNorm());
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte dizinin elemanlarının değiştirilmesi ebgellenmemiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.math.geometry.Circle;
import org.csystem.util.ArrayUtil;

class App {
	public static void main(String [] args)
	{
		Sample s = new Sample(10, 1, 100);

		ArrayUtil.display(s.getA());
		s.getA()[0] = 106;
		ArrayUtil.display(s.getA());
	}
}

class Sample {
	private int [] m_a;

	public Sample(int n, int min, int max)
	{
		m_a = ArrayUtil.getRandomArray(n, min, max);
	}

	public int[] getA()
	{
		return m_a;
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki problem aşağıdaki gibi çözülebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

class App {
	public static void main(String [] args)
	{
		Sample s = new Sample(10, 1, 100);

		int length = s.length();

		for (int i = 0; i < length; ++i)
			System.out.printf("%d ", s.get(i));

		System.out.println();
	}
}

class Sample {
	private int [] m_a;

	public Sample(int n, int min, int max)
	{
		m_a = ArrayUtil.getRandomArray(n, min, max);
	}

	public int length()
	{
		return m_a.length;
	}

	public int get(int i)
	{
		return m_a[i];
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Tüm elemanları static olarak bildirilmiş sınıflar türünden nesnelerin anlamı olmayacağından public ctor bu tarz
	sınıflara yazılmaz. Bu durum Java'nın standart sınıfları için de vardır.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

class App {
	public static void main(String [] args)
	{
		ArrayUtil arrayUtil = new ArrayUtil(); //error
		Math math = new Math(); //error

		//...
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	ArrayUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Random;

public class ArrayUtil {
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
        if (isNotMatrix(a) || isNotMatrix(b) || a.length != b.length || a[0].length != b[0].length) {
            System.out.println("Invalid matrices for add operation");
            System.exit(-1); //exception işlemlerine kadar sabredin
        }

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
```java
/*----------------------------------------------------------------------------------------------------------------------
	NumberUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import static java.lang.Math.*;

public class NumberUtil {
	private static String [] ms_onesTR = {"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
	private static String [] ms_tensTR = {"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};

	private static int[] getDigits(long val, int n)
	{
		long value = Math.abs(val);
		int count = value == 0 ? 1 : (int)Math.log10(value) / n + 1;
		int [] digits = new int[count];
		int powerOfTen = (int)Math.pow(10, n);

		for (int i = count - 1; i >= 0; digits[i] = (int)(value % powerOfTen), value /= powerOfTen, --i)
			;

		return digits;
	}

	private static String numberToText3DigitsTR(int val)
	{
		if(val == 0)
			return "sıfır";

		String text = val < 0 ? "eksi" : "";
		int value = Math.abs(val);
		int a = value / 100;
		int b = value / 10 % 10;
		int c = value % 10;

		if (a != 0) {
			if (a != 1)
				text += ms_onesTR[a];
			text += "yüz";
		}

		if (b != 0)
			text += ms_tensTR[b];

		if (c != 0)
			text += ms_onesTR[c];

		return text;
	}

	private NumberUtil()
	{
	}

	public static int factorial(int n)
	{
		if (n < 0)
			return -1;

		int result = 1;

		for (int i = 2; i <= n; ++i)
			result *= i;

		return result;
	}

	public static int[] getDigits(int val)
	{
		return getDigits((long)val);
	}

	public static int[] getDigits(long val)
	{
		return getDigits(val, 1);
	}

	public static int[] getDigitsInTwos(long val)
	{
		return getDigits(val, 2);
	}

	public static int[] getDigitsInThrees(long val)
	{
		return getDigits(val, 3);
	}

	public static int getDigitsCount(long val)
	{
		return val == 0 ? 1 : (int)log10(abs(val)) + 1;
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

	public static int getDigitsSum(int val)
	{
		val = abs(val);
		int sum = 0;

		while (val != 0) {
			sum += val % 10;
			val /= 10;
		}

		return sum;
	}

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

	public static int getReverse(int val)
	{
		int reverse = 0;

		while (val != 0) {
			reverse = reverse * 10 + val % 10;
			val /= 10;
		}

		return reverse;
	}

	public static boolean isArmstrong(int val)
	{
		if (val < 0)
			return false;

		return getDigitsPowSum(val) == val;
	}

	public static boolean isEven(int val)
	{
		return val % 2 == 0;
	}


	public static boolean isOdd(int val)
	{
		return !isEven(val);
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

		int sqrtVal = (int)sqrt(val);

		for (int i = 11; i <= sqrtVal; i += 2)
			if (val % i == 0)
				return false;

		return true;
	}

	public static boolean isNotPrime(int val)
	{
		return !isPrime(val);
	}

	public static int max(int a, int b, int c)
	{
		return Math.max(Math.max(a, b), c);
	}

	public static int min(int a, int b, int c)
	{
		return Math.min(Math.min(a, b), c);
	}


	public static String numberToTextTR(long val)
	{
		String text;

		//TODO: Homework-012-3. soru
		text = numberToText3DigitsTR((int)val);

		return text;
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
```java
/*----------------------------------------------------------------------------------------------------------------------
	StringUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Random;

import static java.lang.Character.*;

public class StringUtil {

	private StringUtil()
	{
	}

    public static String capitalize(String s)
    {
		if (s.isEmpty())
			return s;

		return toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

    public static int countString(String s1, String s2)
    {
		int count = 0;

		for (int i = -1; (i = s1.indexOf(s2, i + 1)) != -1; ++count)
			;

		return count;
    }

    public static String getLetters(String s)
    {
		String str = "";
		int length = s.length();

		for (int i = 0; i < length; ++i) {
		    char ch = s.charAt(i);

		    if (isLetter(ch))
		    	str += ch;
		}

		return str;
    }

    public static String getLongestPalindrome(String s)
    {
		String text = "";

		int endIndex = s.length();

		while (endIndex != 0) {
		    int beginIndex = 0;

		    while (beginIndex != endIndex) {
				String str = s.substring(beginIndex++, endIndex);

				if (str.length() > 1 && StringUtil.isPalindrome(str) && str.length() > text.length())
				    text = str;
		    }

		    --endIndex;
		}

		return text;
    }

    public static String getRandomText(Random r, int n, String mainText)
    {
		char [] c = new char[n];

		for (int i = 0; i < n; ++i) {
		    char ch = mainText.charAt(r.nextInt(mainText.length()));

		    if (r.nextBoolean())
				ch = toUpperCase(ch);

		    c[i] = ch;
		}

		return String.valueOf(c);
    }

    public static String getRandomTextEN(int n)
    {
    	return getRandomTextEN(new Random(), n);
    }

    public static String getRandomTextEN(Random r, int n)
    {
    	return getRandomText(r, n, "abcdefghijklmnopqrstuwxvyz");
    }

    public static String getRandomTextTR(int n)
    {
    	return getRandomTextTR(new Random(), n);
    }

    public static String getRandomTextTR(Random r, int n)
    {
    	return getRandomText(r, n, "abcçdefgğhıijklmnoöprsştuüvyz");
    }

    public static boolean isPalindrome(String s)
	{
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			char chLeft = toLowerCase(s.charAt(left));

			if (!isLetter(chLeft)) {
				++left;
				continue;
			}

			char chRight = toLowerCase(s.charAt(right));

			if (!isLetter(chRight)) {
				--right;
				continue;
			}

			if (chLeft != chRight)
				return false;

			++left;
			--right;
		}

		return true;
	}

    public static boolean isPangram(String text, String alphabet)
    {
		int length = alphabet.length();

		for (int i = 0; i < length; ++i)
		    if (!text.contains(alphabet.charAt(i) + ""))
		    	return false;

		return true;
    }

    public static boolean isPangramEN(String text)
    {
    	return isPangram(text.toLowerCase(), "abcdefghijklmnopqrstuwxvyz");
    }

    public static boolean isPangramTR(String text)
    {
    	return isPangram(text.toLowerCase(), "abcçdefgğhıijklmnoöprsştuüvyz");
    }

    public static String padLeft(String s, int length)
    {
    	return padLeft(s, length, ' ');
    }

    public static String padLeft(String s, int length, char ch)
    {
		length -= s.length();

		if (length <= 0)
		    return s;

		return repeat(length, ch) + s;
    }

    public static String padRight(String s, int length)
    {
    	return padRight(s, length, ' ');
    }

    public static String padRight(String s, int length, char ch)
    {
		length -= s.length();

		if (length <= 0)
		    return s;

		return s + repeat(length, ch);
    }

    public static String removeWhitespaces(String s)
    {
		int length = s.length();
		String str = "";

		for (int i = 0; i < length; ++i) {
		    char ch = s.charAt(i);

		    if (!isWhitespace(ch))
				str += ch;
		}

		return str;
    }

    public static String repeat(int n, char ch)
    {
		char [] c = new char[n];

		while (n-- > 0)
		    c[n] = ch;

		return String.valueOf(c);
    }

    public static String reverse(String str)
    {
		char [] c = str.toCharArray();

		ArrayUtil.reverse(c);

		return String.valueOf(c);
    }

    public static String trimLeft(String s)
    {
		int i;
		int len = s.length();

		for (i = 0; i < len && isWhitespace(s.charAt(i)); ++i)
		    ;

		return s.substring(i);
    }

    public static String trimRight(String s)
    {
		int i;

		for (i = s.length() - 1; i >= 0 && isWhitespace(s.charAt(i)); --i)
		    ;

		return s.substring(0, i + 1);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Anahtar Notlar: Programlamada o bölge için hiç bir yer ayrılmayan bir adres numarası vardır. Bu adres Java' da null isimli
    bir anahtar sözcük ile temsil edilir. Buna null adres/referans de denir. Bir referansın default değer null değeridir.
    null referans detayları ileride ele alınacaktır.
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Singleton kalıbı: Öyle bir sınıf olsun ki bu sınıf türünden program boyunca yalnızca bir tane nesne yaratılabilsin
	ve her isteyen aynı nesneyi kullanabilsin. Singleton kalıbının bir çok implementasyonu yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Singleton kalıbının bir implementasyonu (lazy implementation)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();

		System.out.println(s1 == s2);

		s1.setA(10);

		System.out.println(s2.getA());
	}
}

class Singleton {
	private static Singleton ms_instance;
	private int m_a;

	private Singleton()
	{}

	public static Singleton getInstance()
	{
		if (ms_instance == null)
			ms_instance = new Singleton();

		return ms_instance;
	}

	public int getA()
	{
		return m_a;
	}

	public void setA(int a)
	{
		//...
		m_a = a;
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Singleton kalıbının bir implementasyonu (lazy implementation)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Singleton s1 = Singleton.getInstance(10);
		Singleton s2 = Singleton.getInstance(20);

		System.out.println(s1 == s2);

		System.out.println(s1.getA());
		System.out.println(s2.getA());
	}
}

class Singleton {
	private static Singleton ms_instance;
	private int m_a;

	private Singleton()
	{
	}

	public static Singleton getInstance()
	{
		return getInstance(0);
	}

	public static Singleton getInstance(int a)
	{
		if (ms_instance == null)
			ms_instance = new Singleton();

		ms_instance.m_a = a;
		return ms_instance;
	}

	public int getA()
	{
		return m_a;
	}

	public void setA(int a)
	{
		//...
		m_a = a;
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	final değişkenler:
	Bir değişkenin final olarak bildirilmesi o değişkenin bir kez değer alabileceği anlamına gelir. Yani final bir
	değişene bir kez atama yapılır. İkinci bir atama error oluşturur. final değişkenler sabit ifadesi olarak ele alınır.
	final yerel değişkenler ve parametre değişkenlerinin Java 8'den itibaren kullanımının anlamı kalmamıştır. Java 8
	öncesindeki kodlarda kullanılması zorunlu olan durumlar vardı. Ancak bu durumlar Java 8 ile birlikte değişti.

	final veri elemanları için genel olarak şu kuraldan bahsedilebilir: Veri elemanının final yapılması algoritmik olarak
	geçerliyse kesinklikle yapılmalıdır.
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	final yerel değişkenlere faaliyet alanı boyunca bir kez atama yapılabilir. Genel olarak ilkdeğer verilse de
	faaliyet boyunca tek atama olması koşuluyla istenildiği yerde atama yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		final int a = 10;
		final double b;

		b = 3.4;

		//...
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir metodun parametre değişkeni final olarak bildirilebilir. Bu durumda metodun final olan parametre değişkenine
	metot içerisinde atama yapılamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

class Sample {
	public static void foo(final int a, int b)
	{
		++a; //error
		b--;
	}

}
/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/
```
