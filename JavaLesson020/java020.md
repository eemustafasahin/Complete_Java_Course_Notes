```java
/*----------------------------------------------------------------------------------------------------------------------
	26.09.2020
	Sarmalayan sınıfların ctor'ları Java 9 ile birlikte deprecated olmuştur. Yani kutulama işlemi için ctor'lar
	kullanılmamalıdır. Zaten ileride anlatılacak sebeplerden dolayı Java 5'den itibaren zaten ctor kullanımı
	tavsiye edilmemektedir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Integer iVal = new Integer(10);
		Double dVal = new Double(20.2);

		//...
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Kutulama için sarmalayan sınıfların valueOf metotları ctor yerine kullanılmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Integer iVal = Integer.valueOf(10);
		Double dVal = Double.valueOf(20.2);
		Boolean bVal = Boolean.valueOf(true);

		//...
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Integer sınıfının (aslında tamsayı türlerine ilişkin tüm sarmalayan sınıfların) valueOf metotları [-128, 127]
	aralığındaki değerleri bir önbellekte (cache) tutar. Böylelikle daha efektif bir çalışma sağlanır.
	Not: IntValue sınıfının kodlarını tekrar inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Integer iVal1 = Integer.valueOf(100);
		Integer iVal2 = Integer.valueOf(100);

		System.out.println(iVal1 == iVal2);
		//...
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	[-128, 127] aralığı dışında kalan değerler için önbellek kullanılacağı garanti değildir. Bu JDK yazanlara
	bırakılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Integer iVal1 = Integer.valueOf(100);
		Integer iVal2 = Integer.valueOf(100);

		System.out.println(iVal1 == iVal2);
		//...
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Character sınıfı [0, 127] (standart ASCII karkaterleri) aralığındaki karakterlere ilişkin sıra numarasını
	önbellekte tutar. Diğer karakterlere ilişkin sıra numaralarının önbellekte tutulacağının bir garantisi yoktur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Character c1 = Character.valueOf('C');
		Character c2 = Character.valueOf('C');
		Character c3 = Character.valueOf('Ş');
		Character c4 = Character.valueOf('Ş');

		System.out.println(c1 == c2);
		System.out.println(c3 == c4);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Number sınıfının xxxValue metotları nümerik sarmalayan sınıflar için ilişkin olduğu temel türe göre tür dönüştürme
	kurallarına uygun olarak çalışır. Yani örneğin, bir int değerin short türüne explicit olarak atanması durumunda elde
	edilen değer Integer sınıfı ile sarmalanmış bir değere ilişkin nesnenin shortValue metodunun döndürdüğü değer ile
	aynıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int val = 200000;
		Integer iVal = Integer.valueOf(val);
		short a = (short)val;
		short b = iVal.shortValue();

		System.out.printf("a=%d%n", a);
		System.out.printf("b=%d%n", b);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Kutulama işlemi ile kutulanmış bir değere ilişkin nesnenin referansı da Object referansı ile tutulabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Object object = Integer.valueOf(10);

		System.out.println(object.getClass().getName());

		int val = ((Integer)object).intValue();

		System.out.printf("val=%d%n", val);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	RandomObjectArrayGeneratorApp uygulaması
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.randomgenerator.RandomObjectArrayGeneratorApp;

class App {
	public static void main(String [] args)
	{
		RandomObjectArrayGeneratorApp.run();
	}
}

package org.csystem.app.samples.randomgenerator;

import org.csystem.util.ArrayUtil;
import org.csystem.util.datetime.Date;
import org.csystem.util.datetime.Time;

public class RandomObjectArrayGeneratorApp {
    private RandomObjectArrayGeneratorApp()
    {}

    public static void run()
    {
        RandomObjectArrayGenerator randomObjectArrayGenerator = new RandomObjectArrayGenerator(5);

        randomObjectArrayGenerator.run();

        for (Object object : randomObjectArrayGenerator.getObjects()) {
            System.out.printf("Dinamik tür ismi:%s%n", object.getClass().getName());

            if (object instanceof String) {
                String s = (String)object;

                System.out.printf("Yazı:%s%n", s);
                System.out.printf("Yazı:%s%n", s.toUpperCase());
            }
            else if (object instanceof Integer) {
                Integer iVal = (Integer) object;
                int val = iVal.intValue();

                System.out.printf("%d * %d = %d%n", val, val, val * val);
            }
            else if (object instanceof Double) {
                double dVal = ((Double)object).doubleValue();

                System.out.printf("dVal=%f%n", dVal);
            }
            else if (object instanceof Date) {
                Date date = (Date)object;

                System.out.println(date.toLongDateStringTR());
            }
            else if (object instanceof Time) {
                Time time = (Time)object;

                System.out.println(time.toLongTimeString());
            }
            else if (object instanceof int []) {
                int [] a = (int[])object;

                ArrayUtil.display(3, a);
            }
        }
    }
}


package org.csystem.app.samples.randomgenerator;

import org.csystem.util.ArrayUtil;
import org.csystem.util.StringUtil;
import org.csystem.util.datetime.Date;
import org.csystem.util.datetime.Time;

import java.util.Random;

public class RandomObjectArrayGenerator {
    private final Random m_random;
    private final Object [] m_objects;

    private Object getRandomObject()
    {
        int val = m_random.nextInt(6);

        Object object;

        switch (val) {
            case 0:
                object = StringUtil.getRandomTextTR(m_random.nextInt(15) + 1);
                break;
            case 1:
                object = Integer.valueOf(m_random.nextInt(255) - 128);
                break;
            case 2:
                object = Date.randomDate(m_random);
                break;
            case 3:
                object = Time.randomTime(m_random);
                break;
            case 4:
                object = Double.valueOf(m_random.nextDouble());
                break;
            default:
                object = ArrayUtil.getRandomArray(m_random, 10, 0, 256);
        }

        return object;
    }

    public RandomObjectArrayGenerator(int n)
    {
        m_random = new Random();
        m_objects = new Object[n];
    }

    public Object [] getObjects()
    {
        return m_objects;
    }

    public void run()
    {
        for (int i = 0; i < m_objects.length; ++i)
            m_objects[i] = getRandomObject();
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java 5 ile birlikte temel türlere ilişkin sarmalayan sınıf referanslarına ilgili türden bir değer doğrudan
	atanabilmektedir. Bu işlem aslında derleyici tarafından aşağıdaki gibi bir kod üretilmesini sağlar. Yani programcı
	bu atamayı yaptığında derleyici uygun kodu üretir. Bu işleme "auto-boxing (otomatik kutulama)".
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Integer iVal1 = 10; //auto-boxing: Integer.valueOf(10);
		Integer iVal2 = 10; //auto-boxing: Integer.valueOf(10);

		System.out.println(iVal1 == iVal2);

		Double dVal = 3.4; //auto-boxing: Double.valueOf(3.4);
	}
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Otomatik kutulama Object türü için de geçerlidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Object o = 10;

		System.out.println(o.getClass().getName());
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki metot çağrılarında otomatik kutulama yapılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Random;

class App {
	public static void main(String [] args)
	{
		Sample.foo(10); //auto-boxing
		Sample.foo('c'); //auto-boxing
		Sample.foo("ankara"); //upcasting
		Sample.foo(new Random()); //upcasting
	}
}


class Sample {
	public static void foo(Object o)
	{
		System.out.println(o.getClass().getName());
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Temel türden bir değer o türe ilişkin sarmalayan sınıf referansına doğrudan atanabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Double d = 10; //error: Integer.valueOf(10);

		//...
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java 5 ile birlikte sarmalayan sınıf referansı ilişkin olduğu türe doğrudan atanabilir. Bu durumda yine derleyici
	aşağıdaki gibi kod üretir. Bu işleme "auto unboxing (otomatik kutu açma)" denir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Integer iVal = 10; //auto boxing
		int a = iVal; //auto unboxing: iVal.intValue();

		System.out.printf("a=%d%n", a);

		Double dVal = 2.3;//auto boxing
		double b = dVal; //auto unboxing: dVal.doubleValue();

		System.out.printf("b=%f%n", b);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki durumda error oluşmaz çünkü Derleyicinin ürettiği kodda çağrılan intValue metodunun geri dönüş
	değeri int türdendir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Integer iVal = 10; //auto boxing
		double a = iVal; //auto unboxing: iVal.intValue();

		System.out.printf("a=%f%n", a);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki durumda error oluşur. Çünkü int türünün short türüne atanması geçersizdir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Integer iVal = 10; //auto boxing
		short a = iVal; //error: iVal.intValue();

		//...
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Otomatik kutu açma tür dönüştürme operatörü ile aşağıdaki gibi Object türü ile de kullanılabilir. Yine derleyici
	aşağıda belirtilen kodları üretir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int a = 10;

		Object object = a; //auto boxing: Integer.valueOf(a);

		int val = (int)object; //auto unboxing: ((Integer)object).intValue();

		System.out.printf("val=%d%n", val);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Otomatik kutu açma uygun türe yapılmalıdır. Aşağıdaki örnekte exception oluşur. Yani haksız dönüşüm vardır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int a = 10;

		Object object = a; //auto boxing: Integer.valueOf(a);

		double val = (double)object; //auto unboxing: ((Double)object).doubleValue();

		System.out.printf("val=%f%n", val);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki problem aşağıdaki gibi çözülebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int a = 10;

		Object object = a; //auto boxing: Integer.valueOf(a);

		double val = (int)object; //auto unboxing: ((Integer)object).intValue();

		System.out.printf("val=%f%n", val);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte önce int türüne otomatik kutu açılmış, elde edilen değer short türüne dönüştürülmüştür.
	Tür dönüştürme operatörünün sağdan sola öncelikli (right asscociative) olduğunu anımsayınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int a = 100000;

		Object object = a; //auto boxing: Integer.valueOf(a);

		short val = (short)(int)object; //auto unboxing: (double)((Integer)object).intValue();

		System.out.printf("val=%d%n", val);
	}
}

package org.csystem.app.samples.randomgenerator;

import org.csystem.util.ArrayUtil;
import org.csystem.util.datetime.Date;
import org.csystem.util.datetime.Time;

public class RandomObjectArrayGeneratorApp {
    private RandomObjectArrayGeneratorApp()
    {}

    public static void run()
    {
        RandomObjectArrayGenerator randomObjectArrayGenerator = new RandomObjectArrayGenerator(5);

        randomObjectArrayGenerator.run();

        for (Object object : randomObjectArrayGenerator.getObjects()) {
            System.out.printf("Dinamik tür ismi:%s%n", object.getClass().getName());

            if (object instanceof String) {
                String s = (String)object;

                System.out.printf("Yazı:%s%n", s);
                System.out.printf("Yazı:%s%n", s.toUpperCase());
            }
            else if (object instanceof Integer) {
                int val = (int)object;

                System.out.printf("%d * %d = %d%n", val, val, val * val);
            }
            else if (object instanceof Double) {
                double dVal = (double)object;

                System.out.printf("dVal=%f%n", dVal);
            }
            else if (object instanceof Boolean) {
                boolean flag = (boolean)object;

                System.out.printf("flag=%b%n", flag);
            }
            else if (object instanceof Date) {
                Date date = (Date)object;

                System.out.println(date.toLongDateStringTR());
            }
            else if (object instanceof Time) {
                Time time = (Time)object;

                System.out.println(time.toLongTimeString());
            }
            else if (object instanceof int []) {
                int [] a = (int[])object;

                ArrayUtil.display(3, a);
            }
        }
    }
}

package org.csystem.app.samples.randomgenerator;

import org.csystem.util.ArrayUtil;
import org.csystem.util.StringUtil;
import org.csystem.util.datetime.Date;
import org.csystem.util.datetime.Time;

import java.util.Random;

public class RandomObjectArrayGenerator {
    private final Random m_random;
    private final Object [] m_objects;

    private Object getRandomObject()
    {
        int val = m_random.nextInt(7);

        Object object;

        switch (val) {
            case 0:
                object = StringUtil.getRandomTextTR(m_random.nextInt(15) + 1);
                break;
            case 1:
                object = m_random.nextInt(255) - 128;
                break;
            case 2:
                object = Date.randomDate(m_random);
                break;
            case 3:
                object = Time.randomTime(m_random);
                break;
            case 4:
                object = m_random.nextDouble();
                break;
            case 5:
                object = m_random.nextBoolean();
                break;
            default:
                object = ArrayUtil.getRandomArray(m_random, 10, 0, 256);
        }

        return object;
    }

    public RandomObjectArrayGenerator(int n)
    {
        m_random = new Random();
        m_objects = new Object[n];
    }

    public Object [] getObjects()
    {
        return m_objects;
    }

    public void run()
    {
        for (int i = 0; i < m_objects.length; ++i)
            m_objects[i] = getRandomObject();
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sarmalayan sınıflar ilişkin olduğu türler gibi davranabilmektedir. Aslında bu işlemler otomatik kutulama ve
	otomatik kutu açma işlemleri ile yapılabilmektedir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		for (Integer i = 0; i < 10; ++i)
			System.out.printf("%d ", i);

		System.out.println();
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sarmalayan sınıflar immutable olduğundan aşağıdaki örnekte ++ operatörü aslında yeni nesne yaratılıp eski
	nesnenin kopartılması biçiminde yapılmaktadır. Şüphesiz bu işlem de otomatik kutulama ve otomatik kutu açma
	ile kolayca yapılabilmektedir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Integer i = 10;

		++i; // i = i.intValue() + 1

		int a = i;

		System.out.println(i);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	++ operatörü ile nesnenin içeriğinin değiştirilmediğinin ispatı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Integer i = 10;
		Integer temp = i;

		++i;

		System.out.println(i == temp);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	final anahtar sözcüğü ile bildirilen bir sınıftan türetme yapılamaz. Yani bu sınıf türetmeye kapatılmış olur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

class A extends Sample { //error
	//...
}

final class Sample {
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	final sınıflar başka bir sınıftan türetilmiş olabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}

class C extends B { //error
	//...
}

final class B extends A {
	//...
}

class A {

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	final sınıf olmasaysı türetmeye kapatmak için aşağıdaki işlemlerin yapılması gerekirdi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		A x = A.getInstance();

		//...
	}
}

class B extends A { //error

}

class A {
	private A()
	{}

	public static A getInstance()
	{
		return new A();
	}
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    ctor'u private olarak bildirilmiş bir sınıftan zaten türetme yapılamayacağından bu tarz sınıfların final
    olarak bildirilmesi iyi bir tekniktir. Örneğin Math sınıfı final olarak bildirilmiştir
----------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------
	StringUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Random;

import static java.lang.Character.*;

public final class StringUtil {
	private static final String ALPHABET_TR = "abcçdefgğhıijklmnoöprsştuüvyz";
	private static final String ALPHABET_EN = "abcdefghijklmnopqrstuwxvyz";

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
    	return getRandomText(r, n, ALPHABET_EN);
    }

    public static String getRandomTextTR(int n)
    {
    	return getRandomTextTR(new Random(), n);
    }

    public static String getRandomTextTR(Random r, int n)
    {
    	return getRandomText(r, n, ALPHABET_TR);
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
    	return isPangram(text.toLowerCase(), ALPHABET_EN);
    }

    public static boolean isPangramTR(String text)
    {
    	return isPangram(text.toLowerCase(), ALPHABET_TR);
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

	public static String [] split(String str, String delimiters)
	{
		return split(str, delimiters, StringSplitOptions.NONE);
	}

    public static String [] split(String str, String delimiters, StringSplitOptions stringSplitOptions) // Bazı az kulanılan detaylar gözmezden gelindi
	{
		String pattern = "[";
		int length = delimiters.length();

		for (int i = 0; i < length; ++i) {
			char delim = delimiters.charAt(i);

			pattern += delim == '[' || delim == ']' ? "\\" + delim : delim;
		}

		pattern += stringSplitOptions == StringSplitOptions.REMOVE_EMPTY_ENTRIES ? "]+" : "]";

		return  str.split(pattern);
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
	NumberUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import static java.lang.Math.*;

public final class NumberUtil {
	private static final String [] ONES_TR = {"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
	private static final String [] TENS_TR = {"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};

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
				text += ONES_TR[a];
			text += "yüz";
		}

		if (b != 0)
			text += TENS_TR[b];

		if (c != 0)
			text += ONES_TR[c];

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
	ArrayUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

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
    immutable sınıflardan genel olarak (tabii ki her zaman değil) türetme taban sınıf bölümü değiştirilemediğinden
    anlamsız olduğundan bu tarz sınıflar final yapılır. Ancak bu durum sadece genellenebilir. Konuya göre sınıfın
    final olmaması anlamlı olabilir. Örneğin String sınıfı ve sarmalayan sınıflar final olarak bildirilmiştir.
----------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------
    IntValue sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

public final class IntValue {
    private static final IntValue[] CACHE = new IntValue[256];
    private final int m_val;

    private IntValue(int val)
    {
        m_val = val;
    }

    public static final IntValue ZERO = of(0);
    public static final IntValue ONE = of(1);

    public static IntValue of(int val)
    {
        if (val < -128 || val > 127)
            return new IntValue(val);

        if (CACHE[val + 128] == null)
            CACHE[val + 128] = new IntValue(val);

        return CACHE[val + 128];
    }

    public int getVal()
    {
        return m_val;
    }

    public int compareTo(IntValue other)
    {
        return m_val - other.m_val;
    }

    public IntValue add(int val)
    {
        return of(m_val + val);
    }

    public IntValue add(IntValue intValue)
    {
        return add(intValue.m_val);
    }

    public IntValue subtract(int val)
    {
        return add(-val);
    }

    public IntValue subtract(IntValue intValue)
    {
        return subtract(intValue.m_val);
    }


    public IntValue multiply(int val)
    {
        return of(m_val * val);
    }

    public IntValue mul(IntValue intValue)
    {
        return multiply(intValue.m_val);
    }

    public IntValue increment()
    {
        return add(1);
    }

    public IntValue decrement()
    {
        return subtract(1);
    }

    public String toString()
    {
        return m_val + "";
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Heap'de tahsis edilen nesnelere dinamik olarak tahsis edilen (dinamik ömürlü) nesneler denir. Bu nesnelerin
	yok edilmesi çöp toplayıcı (garbage collector) denilen ve arka planda çalışan bir program tarafından yapılır.
	Çöp toplayıcı artık kullanılmayan (garbage collected, eligible) yani çöp olan nesneleri yok eder. Burada 3(üç)
	tane temel soru sorulabilir:
	1. Programcı bir nesneyi yok edebilir mi? (HAYIR)
	2. Çöp olan (garbage collected) bir nesne çöp olur olmaz yok edilir mi, yani çöp toplayıcı program hemen devreye
	girer mi? (GİRMEYEBİLİR)
	3. Çöp toplayıcı yok edilmesi gereken bir nesneyi nasıl anlar?

	Java' da programcı bir nesneyi yok edemez. Yani tahsis edilmiş bir alanın geri bırakamaz (free, delete). Programcı
	kod akışı içerisinde bir nesneyi yok edilebilir (garbage collected) duruma getirebilir.

	Çöp toplayıcı programın ne zaman devreye gireceği standartlarda belirtilmemiştir. Bu çöp toplayıcı programla
	beraber JVM ve JRE yazanlara bırakılmıştır (implementation dependent.) Hemen devreye gireceği garanti değildir.
	Programcı bu bilinçle ve etkinliğine güvenerek kod yazar.

	Bir nesnenin yok edilebilir yani çöp durumuna gelmesi o nesneyi gösteren hiçbir referansın kalmaması kalmaması
	demektir. Yani nesnenin adresinin hiçbir referans tarafından tutulmuyor duruma gelmesidir. Bir nesnenin adresinin
	hangi referanslar tarafından tutulduğu ve özellikle kaç referans tarafından tutulduğunın takibi çeşitli algoritmalar
	kullanılarak yapılmaktadır. Bu algoritmanın ne olacağı da standtartlarda belirtilmemiştir (implementation dependent.)
	Biz burada referans sayma (reference counting) algoritması kullanılıyor varsayımıyla açıklama yapacağız. Referans
	sayacı yönteminde her yaratılan nesne için bir sayaç tutulur (bu sayaç genelde nesne içerisinde tutulur.). Bu yöntemde
	nesnenin adresi yeni bir referansa atandığından o nesne için sayaç 1(bir) artırılır. Nesne bir referanstan
	kopartıldığında sayaç 1(bir) azaltılır. Sayacı sıfır olam yani hiç bi referans tarafından gösterilmeyen bir nesne
	çöp durumuna gelmiş olur. Şüphesiz bir program sonlandığında tüm nesneler yok edilir.
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte referans sayacı yönteminin çalışması gösterilmiştir
	rc: reference counter
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Sample s;

		s = new Sample(); //rc1:1

		{
			Sample k;

			k = s; //rc1:2
			Mample.foo(k);//rc1:3 -> rc1:4
			//rc1:2
		} //rc1:1

		s = new Sample(); //rc1:0 (garbage collected), rc2:1

		//...
	}
}

class Mample {
	public static void foo(Sample s)
	{
		Sample k;

		//...

		k = s;

		//...
	}
}
class Sample {
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Programcı isterse çöp toplayıcı programın devreye girmesini sağlayabilir. Bunun için System sınıfının gc isimli metodu
	veya Runtime sınıfının gc isimli metodu çağrılabilir. Ancak bu çoğunlukla yapılmaması gereken bir durumdur. Programcı
	çöp toplayıcı programın devre girmesi konusundaki etkin çalışmaya güvenmelidir. Çünkü çöp toplayıcı programın
	gereksi yere arka planda çalışması da uygulamayı göreceli yavaşlatabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Sample s;

		s = new Sample(); //rc1:1

		{
			Sample k;

			k = s; //rc1:2
			Mample.foo(k);//rc1:3 -> rc1:4
			//rc1:2
		} //rc1:1

		s = new Sample(); //rc1:0 (garbage collected), rc2:1

		System.gc(); // ~ Runtime.getRuntime().gc();
		//...
	}
}

class Mample {
	public static void foo(Sample s)
	{
		Sample k;

		//...

		k = s;

		//...
	}
}
class Sample {
	//...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    27.09.2020
    Arakod düzeyinde non-static metot kavramı yoktur. Aslında aşağı seviyede böyle bir kavram yoktur. Bundan dolayı
    derleyici non-static metotları adeta static metotlar biçiminde arakoda yazar. Bunu non-static metoda ait olduğu
    sınıf türünden ekstra bir referans parametresi ekleyerek yapar. Bu parametrenin ilk parametre ya da son parametre
    ya da arada bir parametre olup olmadığının önemi yoktur. non-static bir metodun çağrısı da o metot çağrılırken kullanılan
    referansın arakoddaki karşılığı olan static metoda argüman olarak geçilmesiyle yapılır. Aşağıdaki örnekte
    non-static bir metodun bildirimi ve çağrılmasının arakoddaki temsili karşılıkları gösterilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Sample s = new Sample();

		s.setVal(10);

		//Arakoddaki karşılığımım temsili
		Sample.setVal(s, 10);

		s.display();

		//Arakoddaki karşılığımım temsili
		Sample.display(s);
	}
}

class Sample {
	private int m_val;

	public void setVal(int val)
	{
		m_val = val;
	}

	//Arakoddaki karşılığının temsili
	public static void setVal(Sample s, int val)
	{
		s.m_val = val;
	}

	public void display()
	{
		System.out.printf("m_val=%d%n", m_val);
	}

	//Arakoddaki karşılığının temsili
	public static void display(Sample s)
	{
		System.out.printf("m_val=%d%n", s.m_val);
	}
}

```
```java

/*----------------------------------------------------------------------------------------------------------------------
    non-static metotlara gizlice geçirilen adrese metot bildiriminde this referansı ile erişilebilir. non-static bir
    metot içerisinde this referansı o metodu çağıran referans yani arakoddaki static metoda geçilen argümana
    karşılık gelir. this referansının türü hangi sınıf içerisinde kullanılmışsa o türdendir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Sample s = new Sample();

		s.setVal(10);
		s.display();

		Sample k = new Sample();

		k.setVal(23);
		k.display();
	}
}

class Sample {
	private int m_val;

	public void setVal(int val)
	{
		this.m_val = val;
	}

	public void display()
	{
		System.out.printf("m_val=%d%n", this.m_val);
	}
}

```
```java

/*----------------------------------------------------------------------------------------------------------------------
    this referansı sabit kabul edilir. Yani this referansına atama yapılamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        Sample s = new Sample();

        s.foo(10);

        Sample k = new Sample();

        k.foo(20);
    }
}

class Sample {
    private int m_val;

    public void foo(int val)
    {
        this = new Sample(); //error
        this.m_val = val;
        System.out.printf("m_val=%d%n", this.m_val);
        this.bar();
    }

    public void bar()
    {
        System.out.println("bar");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    static metotlara this geçirilmez. Yani static metotlar içerisinde this referansı kullanılamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {

    }
}

class Sample {
    private static int ms_val;

    public static void foo(int val)
    {
        this.ms_val = val; //error
    }


}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Biz programcı olarak veri elemanları için this referansını gerekmedikçe kullanmayacağız. Ancak metot çağrılarında
    okunabilirlik açısından (ifadeyi karmaşık hale getirmesi durumları hariç) kullanmayı tercih edeceğiz. Çünkü
    non-static bir metodu this ile çağırmak static metotların okunabiliğini artırır. Bu kurala uyarak yazılmış bir
    kod içerisinde this ile çağrılmamış bir metodun static olduğu kolayca anlaşılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String[] args)
	{
		Sample s = new Sample();

		s.foo(10);
	}
}

class Sample {
	private int m_val;

	public static void tar()
	{
		System.out.println("tar");
	}

	public void foo(int val)
	{
		m_val = val;
		this.bar();
		tar();
	}

	public void bar()
	{
		System.out.println("bar");
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bazı programcılar sınıfların veri elemanlarının isimlendirmesinde önek ya da sonek kullanmazlar. Bilindiği gibi
    biz sınıfın private veri elemanlarını m_, static ise ms_ önekleri ile isimlendiriyoruz. Ancak sınıfın veri elemanları
    public ise biz de bir önek kullanmıyoruz. Böylesi bir durumda bir metodun parametresi ile veri elemanı aynı isimde
    yapıldığında artık veri elemanına doğrudan erişilemez. Bu şekilde tasarımda this referansı ile bu işlem
    yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Point sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math.geometry;

import static java.lang.Math.sqrt;

public class Point {
	public int x;
	public int y;

	Point(Point point)
	{
		x = point.x;
		y = point.y;
	}

	public Point()
	{
	}

	public Point(int x)
	{
		this.x = x;
	}

	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public double distance(Point p)
	{
		return this.distance(p.x, p.y);
	}

	public double distance(int a, int b)
	{
		return sqrt((x - a) * (x - a) + (y - b) * (y - b));
	}

	public void offset(int dxy)
	{
		this.offset(dxy, dxy);
	}

	public void offset(int dx, int dy)
	{
		x += dx;
		y += dy;
	}

	public String toString()
	{
		return String.format("{x: %d, y: %d}", x, y);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	PointF sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math.geometry;

import static java.lang.Math.sqrt;

public class PointF {
	public float x;
	public float y;

	public PointF()
	{
	}

	public PointF(float x)
	{
		this.x = x;
	}

	public PointF(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	public double distance(Point p)
	{
		return this.distance(p.x, p.y);
	}

	public double distance(float a, float b)
	{
		return sqrt((x - a) * (x - a) + (y - b) * (y - b));
	}

	public void offset(float dxy)
	{
		this.offset(dxy, dxy);
	}

	public void offset(float dx, float dy)
	{
		x += dx;
		y += dy;
	}

	public String toString()
	{
		return String.format("{x: %f, y: %f}", x, y);
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
		return new Complex(re1 + re2, im1 + im2);
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

	public Complex(double re)
	{
		this.re = re;
	}

	public Complex(double re, double im)
	{
		this.re = re;
		this.im = im;
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
		this.offset(dxy, dxy);
	}

	public void offset(double dx, double dy)
	{
		re += dx;
		im += dy;
	}

	public String toString()
	{
		return String.format("|%.2f + %.2f * i| = %f", re, im, this.getNorm());
	}
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki durumun benzeri static veri elemanları için de oluşabilir. Bu durumda niteliklendirmek için
    sınıf ismi kullanılmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String[] args)
	{
		Sample.setX(10);

		System.out.printf("Sample.x=%d%n", Sample.x);
	}
}

class Sample {
	public static int x;

	public static void setX(int x)
	{
		Sample.x = x;
	}
}

```
```java

/*----------------------------------------------------------------------------------------------------------------------
    Bir sınıfın metotlarının aynı nesnenin referansı üzerinden zincir biçiminde aşağıdaki gibi çağrılabilmesi
    için sınıfın tasarımında this referansı kullanılmalıdır (fluent pattern)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String[] args)
	{
		Sample s = new Sample();

		s.foo(19).bar(45).tar(3).zar(6).foo(7);

		System.out.println(s.getVal());
	}
}

class Sample {
	private int m_val;

	public int getVal()
	{
		return m_val;
	}

	public Sample foo(int val)
	{
		m_val += val;

		return this;
	}

	public Sample bar(int val)
	{
		m_val *= val;

		return this;
	}

	public Sample tar(int val)
	{
		m_val /= val;

		return this;
	}

	public Sample zar(int val)
	{
		foo(-val);

		return this;
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte MutableIntValue sınıfı zincir çağırmaya uygun olarak yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.MutableIntValue;

class App {
	public static void main(String[] args)
	{
		MutableIntValue mutableIntValue = new MutableIntValue();

		mutableIntValue.setVal(10).add(20).multiply(4).increment();

		System.out.println(mutableIntValue.getVal());
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    MutableIntValue sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

public final class MutableIntValue {
    private int m_val;

    public MutableIntValue()
    {}
    public MutableIntValue(int val)
    {
        m_val = val;
    }

    public int getVal()
    {
        return m_val;
    }

    public MutableIntValue setVal(int val)
    {
        m_val = val;

        return this;
    }

    public int compareTo(MutableIntValue other)
    {
        return m_val - other.m_val;
    }

    public MutableIntValue add(int val)
    {
        m_val += val;

        return this;
    }

    public MutableIntValue add(MutableIntValue intValue)
    {
        return this.add(intValue.m_val);
    }

    public MutableIntValue subtract(int val)
    {
        return this.add(-val);
    }

    public MutableIntValue subtract(MutableIntValue intValue)
    {
        return this.subtract(intValue.m_val);
    }


    public MutableIntValue multiply(int val)
    {
        m_val *= val;

        return this;
    }

    public MutableIntValue mul(MutableIntValue intValue)
    {
        return this.multiply(intValue.m_val);
    }

    public MutableIntValue increment()
    {
        return this.add(1);
    }

    public MutableIntValue decrement()
    {
        return this.subtract(1);
    }

    public String toString()
    {
        return m_val + "";
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
        this.setRadius(radius);
    }

    public Circle(double radius, double pi)
    {
        this.setRadius(radius, pi);
    }

    public double getRadius()
    {
        return m_radius;
    }

    public void setRadius(double radius)
    {
        this.setRadius(radius, Math.PI);
    }

    public void setRadius(double radius, double pi)
    {
        m_radius = Math.abs(radius);
        this.setPI(pi);
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
	Circle sınıfı
	-- AnalyticalCircle is Circle, has a Point
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math.geometry;

public class AnalyticalCircle extends Circle {
    private final Point m_center;

    public AnalyticalCircle()
    {
        this(0);
    }

    public AnalyticalCircle(double radius)
    {
        this(radius, 0, 0);
    }

    public AnalyticalCircle(int x, int y)
    {
        this(0, x, y);
    }

    public AnalyticalCircle(Point center)
    {
        this(0, center);
    }

    public AnalyticalCircle(double radius, Point center)
    {
        this(radius, center.x, center.y);
    }

    public AnalyticalCircle(double radius, int x, int y) //primary (core) ctor
    {
        super(radius);
        m_center = new Point(x, y);
    }

    public int getX()
    {
        return m_center.x;
    }

    public void setCenter(Point center)
    {
        this.setCenter(center.x, center.y);
    }

    public void setCenter(int x, int y)
    {
        this.setX(x);
        this.setY(y);
    }

    public void setX(int x)
    {
        m_center.x = x;
    }

    public void setY(int y)
    {
        m_center.y = y;
    }

    public int getY()
    {
        return m_center.y;
    }

    public Point getCenter()
    {
        return new Point(m_center); // m_center doğrudan verilseydi. Composition delinmiş olurdu
    }

    public void offset(int dxy) //delegate method
    {
        this.offset(dxy, dxy);
    }

    public void offset(int dx, int dy) //delegate method
    {
        m_center.offset(dx, dy);
    }

    public double radiusDistance(AnalyticalCircle analyticalCircle)
    {
        return m_center.distance(analyticalCircle.m_center);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Java'da kullanılmayan bir bytle'lık gözeneğin adresini temsil eden (null address) null isimli bir anahtar
    sözcük bulunur. null bir referansa atanabilir. Bir referansa null atandığında o referansın içerisnde bir adres
    vardır. Ancak bu adres kullanılmadığı için bir nesnenin adresi değildir.

    Anahtar Notlar: Modern sistemlerde null adres olarak sıfır numaralı gözeneğin adresi alınır. Yani bu sistemlerde
    sıfır numaralı adres herhangi bir bölge olarak kullanılmaz. Java programcısı için kullanılmayan adresin hangisi
    olduğu önemsizdir. null sabitinin varlık sebebi zaten bu adresi temsil etmektir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Random;

class App {
	public static void main(String[] args)
	{
		String s = null;
		Sample sample = null;
		Random r = null;
		int val = null; //error
	}
}

class Sample {
	//..
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir referansın default değeri null'dır. Hatırlanacağı gibi Singleton kalıbının bir implementasyonunda null'ın
    default değer olup olmamasına göre kod yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        Singleton s = Singleton.getInstance();
        Singleton k = Singleton.getInstance();

        System.out.println(s == k);
    }
}

class Singleton {
    //...
    private static Singleton ms_instance;

    private Singleton()
    {}

    public static Singleton getInstance()
    {
        if (ms_instance == null)
            ms_instance = new Singleton();

        return ms_instance;
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir referansın null olması durumunda o referansın ilişkin olduğu türün elemanlarına erişim durumunda
    exception oluşur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String[] args)
	{
		Sample s = null;

		s.foo();
	}
}

class Sample {
	public void foo()
	{

	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    null referans bir referansı nesneden kopartmak için de kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String[] args)
	{
		Sample s = new Sample();

		//...

		Sample k = s;


		s = null;
		//...
	}
}

class Sample {
	public void foo()
	{

	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir referansa null atanması o referansın gösterdiği nesnenin garbage collected olacağı anlamına gelmez
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String[] args)
	{
		Sample s = new Sample();

		//...

		Sample k = s;


		s = null;

		k.foo(10);

		System.out.printf("val:%d%n", k.val);
	}
}

class Sample {
	public int val;

	public void foo(int val)
	{
		this.val = val;
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    null referans bir metodun geri dönüş değerinin referans olması durumunda kontrol amaçlı kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Random;

class App {
	public static void main(String[] args)
	{
		Random r = new Random();

		for (int i = 0; i < 30; ++i) {
			int n = r.nextInt(30);
			int[] a = ArrayUtil.getRandomArray(r, n, 1, 100);

			ArrayUtil.display(2, a);
			Integer result = Util.max(a);

			if (result != null)
				System.out.printf("En büyük eleman:%d%n", result);
			else
				System.out.println("Boş dizi geçildi");
			System.out.println("//////////////////////////");

		}
	}
}

class Util {
	public static Integer max(int [] a)
	{
		if (a.length == 0)
			return null;

		int result = a[0];

		for (int i = 1; i < a.length; ++i)
			if (result < a[i])
				result  = a[i];

		return result;
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Bir metodun referans parametresi için null kontrolü yapılabilir. Bazı durumlarda metodun referans parametresine
    null geçilmesi metodun ilgili referansa ilişkin nesneyi kendisi yaratacağı anlamına geleblir. Aşağıdaki
    örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

class App {
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);

		for (int i = 0; i < 5; ++i) {
			System.out.print("min değerini giriniz:");
			int min = Integer.parseInt(kb.nextLine());

			System.out.print("max değerini giriniz:");
			int max = Integer.parseInt(kb.nextLine());

			System.out.print("Dizinin eleman sayısını giriniz:");
			int n = Integer.parseInt(kb.nextLine());

			int[] a = Util.getRandomArray(null, n, min, max);

			if (a == null) {
				System.out.println("min ve max değerleri geçersiz değerlerdir");
				continue;
			}

			ArrayUtil.display(2, a);

			System.out.println("//////////////////////////");
		}
	}
}

class Util {
	public static int [] getRandomArray(Random r, int n, int min, int max)
	{
		if (n <= 0 || min >= max)
			return null;

		if (r == null)
			r = new Random();

		int [] a = new int[n];

		for (int i = 0; i < n; ++i)
			a[i] = r.nextInt(max - min) + min;

		return a;
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    null referans aşağıdaki örnekte olduğu gibi derleyicinin "değer atanmamış bir değişkeni kullanıyor olabilirsin"
    error'unu vermemesi için kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int a = Integer.parseInt(kb.nextLine());

		if (a < 1 || a > 3) {
			System.out.println("Geçersiz değer");
			System.exit(-1);
		}

		Unit unit = null;

		switch (a) {
			case 1:
				unit = new Unit(23);
				break;
			case 2:
				unit = new Unit(78);
				break;
			case 3:
				unit = new Unit(90);
				break;
		}

		System.out.println(unit.getVal());
	}
}

class Unit {
	private final int m_val;

	public Unit(int val)
	{
		m_val = val;
	}

	public int getVal()
	{
		return m_val;
	}
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
    Algoritma bir problemin çözümüne ulaştıran doğru adımlara denir.
    Algoritmaların anlatımında belli bir formal yöntem yoktur. Genel olarak sahte kodlar (pseudo codes) kullanılarak
    algoritmalar açıklanır. Algoritmalar genel olarak dilden bağımsızdır. Ancak ince noktalara gelindiğinde
    algorimalar da dile bağımlı hale gelebilir. Örneğin, bir dilde belli bir işi daha kolay yapan deyimler olabilir.
    Bu durumda algoritma o deyimlerle gerçekleştirilebilir.

    Bir algoritmanın işleyişinin masaya yatırılıp incelenmesine "algoritma" analizi denir. Bu analiz genel olarak
    matematiksel yöntemlerle yapılır. İki algoritmanın karşılaştırılabilmesi için kullanılan ölçüye algoritmanın
    karmaşıklığı denir. Algoritmanın karmaşıklığı için iki temel ölçüt vardır: Hız (speed), kaynak kullanımı (resource usage)
    Burada baskın ölçüt hızdır. Yani daha çok algoritmalar hızlarına göre karşılaştırılır. Ancak bazı durumlar da (bu durumlar
    hıza göre az olsa da kritik durumlardır) kaynak kullanımı da gözönüne alınabilir. Şüphesiz iki ölçütün de en iyi olduğu
    durum her zaman mümkün olmaz.
    Örneğin aşağıdaki gibi yazılmış en büyük sayıyı bulma algoritması için:
    int [] a = {...};
    int max;
    int n;

    n = a.length;
    max = a[0];
    for (int i = 1; i < n; ++i)
        if (max < a[i])
            max = a[i];

    Burada toplam işlemin sayısı max = a[i] işlemine bağlıdır. Bu algoritmada dizinin elemanları bilinmeden bu anlaşılamaz.
    İşte algoritma analizinde işlemlerin sayısını hesaplarken üç durum dikkate alınabilmektedir:

    1. Ortalama durum (average case condition)
    2. En kötü durum (worst case condition)
    3. En iyi durum (best case condition)

    En kötü durum olabileceklerin en kötüsüdür. Yukarıdaki örnekte en kötü durumda max = a[i] işlemi "n - 1" kez yapılır.
    Ortalama durum tüm olasılıkların ortalamasını temsil eder. Yukarıdaki örnekte ortalama max = a[i] işlemi "(n - 1) / 2"
    kez yapılmaktadır. En iyi durum olabileceklerin en iyisini temsil eder. Yani max = a[i] işlemi hiç yapılmaz.
    Algoritma analizinde en iyi durumun çok yararı yoktur. Çünkü aşırı iyimserlik programlamada çok değerli değildir.
    En kötü durum senaryosu önemlidir. Çünkü bazı durumlarda en kötü duruma hazırlıklı olmak gerekebilir. En önemli durum
    ortalama durumdur. Ortalama durum algoritmanın karakterini en iyi belirten durumdur. Genellikle algoritma ele alınırken
    hem ortalama durum hem de en kütü durum analizi yapılır.

    Algoritmalarda işlem sayısına ilişkin analizler çok kolay değildir. Özellikle ortalama durumu hesaplamak bazen çok karmaşık
    olabilmektedir. Algoritmaları pratik bakımdan kıyaslamak için asimtotik notasyonlardan yararlanılmaktadır. Bu notasyonların
    en yaygın kullanılanı "Big O" notasyondur. Bu notasyonda belli karakterdeki algoritmalar aynı kategoride kabul edilir.
    Eğer algoritma birden fazla kategoriye sahipse en kötü duruma ilişkin kategori gerçek kategorisini belirtir.

    Algoritmanın karmaşıklığının Big O notasyonu ile iyiden kötüye doğru ketegorileri şunlardır:
    - Polinomsal (polynomial) karmaşıklıklar
    O(1)        -> sabit karmaşıklık: döngü yok. Örneğin:üçgenin alanının bulunması, dizinin bir elemanına erişim
    O(logn)     -> logaritmik karmaşıklık (2 tabanında): Tek bir döngü var. Her adımda dönme sayısı yarı yarıya azalıyor. Örnek: binary search
    O(n)        -> doğrusal karmaşıklık: Tek döngü. Örneğin: Bir dizinin elemanları toplamının bulunması, en büyük elemanın bulunması
    O(n * logn) -> nlogn karmaşıklı: İçiçe iki döngü var, birisinde her adımda dönme sayısı yarı yarıya azalıyor. Örneğin: quick sort algoritması
    O(n ^ 2)    -> karesel karmaşıklık: İçiçe iki döngü var. Örneğin: Bir matrisin elemanları toplamının bulunması
    O(n ^ 3)    -> küpsel karmaşıklık: İçiçe üç döngü var. Örneğin: Bir kübün üzerindeki noktaların toplamının bulunması, matrislerin çarpımı
    ...
    O(n ^ k)    -> k-sal karmaşıklık (k sabit): İçiçe k tane döngü var

    - Polinomsal olmayan (non-polynomial) karmaşıklıklar
    O(k ^ n)    -> Üstel karmaşıklık (k sabit): Örneğin: N elemanlı bir kümenin alt kümelerinin sayısının bulunması
    O(n!)       -> Faktöriyel karmaşıklık. Örneğin: gezgin satıcı problemi

    Bir algoritma çoğu zaman herhangi bir karmaşıklıktayken bazı zamamnlar (bu az olmalıdır) üst bir karmaşıklıkta
    çalışır. Bu tarz karmaşıklıklara amortize edilmiş (amortized) karmaşıklıklar denir. Örneğin, bir algoritma
    çogu zaman O(1) karmaşıklıkta iken bazı zamanlar O(n) karmaşıklıkta çalışıyor ise amortize edilmiş sabit zamanlı
    (amortized constant time) karmaşıklık denir
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte a dizisinin elemanlarını da içeren 10 elemanlı bir dizi elde edilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

class App {
	public static void main(String[] args)
	{
		int [] a = {1, 2, 3, 4, 5};
		int [] b;

		b = ArrayUtil.enlarge(a, 10);

		ArrayUtil.display(a);
		ArrayUtil.display(b);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte a dizisi eski diziden koparılıp yeni bir diziyi görmesi sağlandığından mantıksal olarak
	büyütülmüştür
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

class App {
	public static void main(String[] args)
	{
		int [] a = {1, 2, 3, 4, 5};

		a = ArrayUtil.enlarge(a, 10);

		ArrayUtil.display(a);
	}
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Dinamik büyüyen dizi veri yapıları diziyi eklenen eleman sayısı kadar büyütmez. Dizinin büyütülmesi
    gerektiği durumda büyütme işlemini biraz fazlaca yapar. İşte bu tarz veri yapılarında dizinin uzunluğuna
    capacity değeri denir Ancak dizide mantıksal tutulan elaman sayısına size denir. size hiç bir zaman capacity
    değerinden büyük olamaz. Capacity değeri size değerinden büyük veya size değerine eşit olabilir.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
	public static void main(String[] args)
	{
		DeviceApp app = new DeviceApp(2);

		app.run();
	}
}

class DeviceApp {
	private Device [] m_devices;
	private int m_index;

	private void enlargeDevices(int newLength)
	{
		Device [] temp = new Device[newLength];

		for (int i = 0; i < m_index; ++i)
			temp[i] = m_devices[i];

		m_devices = temp;
	}

	public DeviceApp(int n)
	{
		m_devices = new Device[n];
	}
	public void run()
	{
		Scanner kb = new Scanner(System.in);

		for (;;) {
			System.out.print("İsim giriniz:");
			String name = kb.nextLine();

			if (name.equals("quit"))
				break;

			System.out.print("Host giriniz:");
			String host = kb.nextLine();

			System.out.print("Port giriniz:");
			int port = Integer.parseInt(kb.nextLine());

			if (m_index == m_devices.length)
				this.enlargeDevices(m_devices.length * 2);

			m_devices[m_index++] = new Device(name, host, port);

			System.out.printf("Capacity:%d%n", m_devices.length);
			System.out.printf("Size:%d%n", m_index);
		}
		System.out.println("Final:");
		System.out.printf("Capacity:%d%n", m_devices.length);
		System.out.printf("Size:%d%n", m_index);

		//...
	}
}


class Device {
	private String m_name;
	private String m_host;
	private int m_port;

	public Device(String name, String host, int port)
	{
		m_name = name;
		m_host = host;
		m_port = port;
	}

	public String getName()
	{
		return m_name;
	}

	public void setName(String name)
	{
		m_name = name;
	}

	public String getHost()
	{
		return m_host;
	}

	public void setHost(String host)
	{
		m_host = host;
	}

	public int getPort()
	{
		return m_port;
	}

	public void setPort(int port)
	{
		m_port = port;
	}

	public String toString()
	{
		return String.format("[%s]%s:%d", m_name, m_host, m_port);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    ArrayList sınıfında capacity kullanılır ancak nasıl büyütüleceği söylenmez. Bu sebeple ArrayList sınıfının
    capacity değerini veren bir metodu yoktur. Dolayısıyla capacity bilgisi gereken kodlarda Vector sınıfı ile örnekler
    yazılacaktır. Vector sınıfı burada anlatılmayan farklılıkları ve capacity bilgisini elde edebilmemiz dışında
    ArrayList ile aynı düşünülebilir
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    ArrayList/Vector sınıfının default ctor elemanı capacity değerini 10(on) alarak nesnenin yartılmasını sağlar. Vector
    sınıfının capacity metodu capacity değerini döndürür (ArrayList sınıfının capacity metodu yoktur).
    ArrayList/Vector sınıfının size metodu tutulan eleman sayısı bilgisini döndürür
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Vector;

class App {
	public static void main(String [] args)
	{
		Vector numbers = new Vector();

		System.out.printf("Capacity:%d%n", numbers.capacity());
		System.out.printf("Size:%d%n", numbers.size());
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    ArrayList/Vector sınıfının capacity parametreli ctor elemanı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Vector;

class App {
    public static void main(String [] args)
    {
        Vector numbers = new Vector(23);

        System.out.printf("Capacity:%d%n", numbers.capacity());
        System.out.printf("Size:%d%n", numbers.size());
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    ArrayList/Vector sınıfının add metodu sona eklemek için kullanılır. Şüphesiz bu metot gerektiğinde capacity
    değerini de uygun şekilde (amortized constant time) büyütür. Vector sınıfının default capacity büyütmesi
    var olan capacity değerinin iki katı olacak şekildedir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Vector;

class App {
	public static void main(String [] args)
	{
		Vector numbers = new Vector(6);

		System.out.printf("Capacity:%d%n", numbers.capacity());
		System.out.printf("Size:%d%n", numbers.size());

		for (int i = 0; i < 12; ++i)
			numbers.add(i * 10);

		System.out.printf("Capacity:%d%n", numbers.capacity());
		System.out.printf("Size:%d%n", numbers.size());

		numbers.add(67);

		System.out.printf("Capacity:%d%n", numbers.capacity());
		System.out.printf("Size:%d%n", numbers.size());
	}
}

```
```java

/*----------------------------------------------------------------------------------------------------------------------
    ArrayList/Vector sınıfının index parametreli add metodu araya ekleme yapmak için kullanılabilir. Bu metot
    O(n) karmaşıklıktadır. Şüphesiz bu metot gerektiğinde capacity değerini uygun şekilde büyütür
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Vector;

class App {
    public static void main(String [] args)
    {
        Vector numbers = new Vector(6);

        System.out.printf("Capacity:%d%n", numbers.capacity());
        System.out.printf("Size:%d%n", numbers.size());

        for (int i = 0; i < 12; ++i)
            numbers.add(0, i * 10);

        System.out.printf("Capacity:%d%n", numbers.capacity());
        System.out.printf("Size:%d%n", numbers.size());

        numbers.add(2, 67);

        System.out.printf("Capacity:%d%n", numbers.capacity());
        System.out.printf("Size:%d%n", numbers.size());
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    ArrayList sınıfının get metodu ile bir indeksteki eleman elde edilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList numbers = new ArrayList(6);

        for (int i = 0; i < 12; ++i)
            numbers.add(i * 10);

        int size = numbers.size();

        for (int i = 0; i < size; ++i) {
            int val = (int)numbers.get(i);

            System.out.printf("%d ", val);
        }

        System.out.println();
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    ArrayList sınıfının get metoduna pozitif ya da negatif bakımdan sınırlar dışında bir indeks numarası
    verildiğinde exception oluşur. Burada sınır size olarak düşünülmelidir. Capacity değeri yani dizinin
    asıl uzunluğu içsel olarak kullanılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList numbers = new ArrayList(10);

        for (int i = 0; i < 12; ++i)
            numbers.add(i * 10);

        int size = numbers.size();

        int val = (int)numbers.get(13);

        System.out.println(val);
    }
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
    ArrayList sınıfı for-each döngü deyimi ile dolaşılabilir (iterable) bir sınıftır. for-each döngü deyiminin
    her adımında içeride tutulan eleman sırasıyla elde edilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList numbers = new ArrayList(6);

        for (int i = 0; i < 10; ++i)
            numbers.add(i * 10);

        for (Object obj : numbers) {
            int val = (int)obj;

            System.out.printf("%d ", val);
        }

        System.out.println();
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte quit girilene kadar alınan isimler bir listeye atılmıştır. Bu işlemden sonra liste for-each
    döngü deyimi ile dolaşılarak elemanlar elde edilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.ArrayList;
import java.util.Scanner;

class App {
    public static void main(String [] args)
    {
        ArrayList names = new ArrayList();
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print("İsim giriniz:");
            String name = kb.nextLine();

            if (name.equals("quit"))
                break;

            names.add(name);
        }

        for (Object object : names) {
            String name = (String)object;

            System.out.println(name.toUpperCase());
        }
    }
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
    ArrayList sınıfının isEmpty metodu ile ArrayList'in boş olup olmadığı test edilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.ArrayList;
import java.util.Scanner;

class App {
    public static void main(String [] args)
    {
        ArrayList names = new ArrayList();
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print("İsim giriniz:");
            String name = kb.nextLine();

            if (name.equals("quit"))
                break;

            names.add(name);
        }

        if (!names.isEmpty()) {
            for (Object object : names) {
                String name = (String) object;

                System.out.println(name.toUpperCase());
            }
        }
        else
            System.out.println("Hiç isim girilmedi");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    ArrayList sınıfının set metodu, birinci parametresi ile aldığı index numarasındaki elemanı ikinci parametresi ile
    aldığı elaman ile değiştirir. Metot eski elemana ilişkin referansı döndürür.
    Metoda pozitif ya da negatif bakımdan sınırlar dışında index numarası gönderildiğinde exception fırlatır.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList numbers = new ArrayList();

        for (int i = 0; i < 20; ++i)
            numbers.add(i * 10);

        System.out.println("Elements:");
        for (Object o : numbers) {
            int val = (int)o;

            System.out.printf("%d ", val);
        }

        System.out.println();

        int oldValue = (int)numbers.set(2, 67);

        System.out.println("Elements:");
        for (Object o : numbers) {
            int val = (int)o;

            System.out.printf("%d ", val);
        }

        System.out.println();
        System.out.printf("Old Value:%d%n", oldValue);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    ArrayList/Vector sınıfının toString metodu ile ArrayList'in elemanları [] içerisinde virgülle ayrılacak
    şekilde bir String elde edilebilir. Bu String'in oluşturulma detayları ileride ele alınacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Vector;

class App {
    public static void main(String [] args)
    {
        Vector numbers = new Vector();

        System.out.printf("Capacity:%d%n", numbers.capacity());
        System.out.printf("Size:%d%n", numbers.size());

        for (int i = 0; i < 15; ++i)
            numbers.add(i * 10);

        System.out.printf("Capacity:%d%n", numbers.capacity());
        System.out.printf("Size:%d%n", numbers.size());

        System.out.println(numbers.toString());
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    ArrayList/Vector sınıfının clear metodu tüm elemanları siler. Bu sınıflarda silme yapan metotlar yani size değerini
    azaltan metotlar capacity değerini değiştirmezler
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Vector;

class App {
    public static void main(String [] args)
    {
        Vector numbers = new Vector();

        System.out.printf("Capacity:%d%n", numbers.capacity());
        System.out.printf("Size:%d%n", numbers.size());

        for (int i = 0; i < 15; ++i)
            numbers.add(i * 10);

        System.out.println(numbers.toString());
        System.out.printf("Capacity:%d%n", numbers.capacity());
        System.out.printf("Size:%d%n", numbers.size());

        numbers.clear();

        System.out.println(numbers.toString());
        System.out.printf("Capacity:%d%n", numbers.capacity());
        System.out.printf("Size:%d%n", numbers.size());
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    ArrayList/Vector sınıfının remove metodu parametresi ile aldığı index numarasına ilişkin elemanı siler. Metot
    sildiği elemana ilişkin referansı döndürür. Metoda pozitif ya da negatif bakımdan sınırlar dışında index numarası
    gönderildiğinde exception fırlatır. Dizide eleman silmek O(n) karmaşıklıktadır.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Vector;

class App {
    public static void main(String [] args)
    {
        Vector numbers = new Vector();

        System.out.printf("Capacity:%d%n", numbers.capacity());
        System.out.printf("Size:%d%n", numbers.size());

        for (int i = 0; i < 15; ++i)
            numbers.add(i * 10);

        System.out.println(numbers.toString());

        System.out.printf("Capacity:%d%n", numbers.capacity());
        System.out.printf("Size:%d%n", numbers.size());

        int oldVal = (int)numbers.remove(2);

        System.out.println(numbers.toString());

        System.out.printf("Old value:%d%n", oldVal);
        System.out.printf("Capacity:%d%n", numbers.capacity());
        System.out.printf("Size:%d%n", numbers.size());
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    ArrayList/Vector sınıfının trimToSize metodu capacity değerini size değerine getirir. Bu metodun sürekli
    çağrılmaması gerekir. Çünkü bu metot da O(n) karmaşıklıktadır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.StringUtil;
import java.util.Random;
import java.util.Vector;

class App {
    public static void main(String [] args)
    {
        Vector passwords = new Vector();
        Random r = new Random();

        for (int i = 0; i < 15; ++i)
            passwords.add(StringUtil.getRandomTextTR(r, 10));

        System.out.println(passwords.toString());

        System.out.printf("Size:%d%n", passwords.size());
        System.out.printf("Capacity:%d%n", passwords.capacity());

        passwords.trimToSize();

        System.out.printf("Size:%d%n", passwords.size());
        System.out.printf("Capacity:%d%n", passwords.capacity());
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Vector sınıfının trimToSize metodu size sıfır ise capacity değerini de sıfır yapar
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.StringUtil;
import java.util.Random;
import java.util.Vector;

class App {
    public static void main(String [] args)
    {
        Vector passwords = new Vector();
        Random r = new Random();

        for (int i = 0; i < 15; ++i)
            passwords.add(StringUtil.getRandomTextTR(r, 10));

        System.out.printf("Size:%d%n", passwords.size());
        System.out.printf("Capacity:%d%n", passwords.capacity());

        passwords.clear();

        System.out.printf("Size:%d%n", passwords.size());
        System.out.printf("Capacity:%d%n", passwords.capacity());

        passwords.trimToSize();

        System.out.printf("Size:%d%n", passwords.size());
        System.out.printf("Capacity:%d%n", passwords.capacity());
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Aşağıaki örnekte Vector sınıfının capacity değeri sıfır iken değeri nasıl artırdığı gösterilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.StringUtil;
import java.util.Random;
import java.util.Vector;

class App {
    public static void main(String [] args)
    {
        Vector passwords = new Vector();
        Random r = new Random();

        System.out.printf("Size:%d%n", passwords.size());
        System.out.printf("Capacity:%d%n", passwords.capacity());

        passwords.trimToSize();

        System.out.printf("Size:%d%n", passwords.size());
        System.out.printf("Capacity:%d%n", passwords.capacity());

        passwords.add(StringUtil.getRandomTextTR(r, 10));

        System.out.printf("Size:%d%n", passwords.size());
        System.out.printf("Capacity:%d%n", passwords.capacity());

        passwords.add(StringUtil.getRandomTextTR(r, 10));

        System.out.printf("Size:%d%n", passwords.size());
        System.out.printf("Capacity:%d%n", passwords.capacity());
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    ArrayList/Vector sınıfının ensureCapcity metodu capacity değerini aşağıdaki şekilde değiştirmekte (veya değiştirememekte)
    kullanılabilir:
    - Yeni capacity değeri var olan capacity değerinden küçük veya eşitse değişiklik yopmaz
    - Yeni capacity değeri var olan capacity değerinin artması gereken değerinden küçük veya eşitse
    artması gereken değere çeker
    - Yeni capacity değeri var olan capacity değerinin artması gereken değerinden büyükse yeni capacity değerine çeker
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.StringUtil;

import java.util.Random;
import java.util.Vector;

class App {
    public static void main(String [] args)
    {
        Vector passwords = new Vector();
        Random r = new Random();

        for (int i = 0; i < 15; ++i)
            passwords.add(StringUtil.getRandomTextTR(r, 10));

        System.out.printf("Size:%d%n", passwords.size());
        System.out.printf("Capacity:%d%n", passwords.capacity());

        passwords.ensureCapacity(17);

        System.out.printf("Size:%d%n", passwords.size());
        System.out.printf("Capacity:%d%n", passwords.capacity());

        passwords.ensureCapacity(30);

        System.out.printf("Size:%d%n", passwords.size());
        System.out.printf("Capacity:%d%n", passwords.capacity());

        passwords.ensureCapacity(87);

        System.out.printf("Size:%d%n", passwords.size());
        System.out.printf("Capacity:%d%n", passwords.capacity());
    }
}

/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/
```
