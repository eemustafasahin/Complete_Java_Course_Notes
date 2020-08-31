### final değişkenler
```java
/*----------------------------------------------------------------------------------------------------------------------
	29.08.2020
	final değişkenler:
	Bir değişkenin final olarak bildirilmesi o değişkenin bir kez değer alabileceği anlamına gelir. Yani final bir
	değişene bir kez atama yapılır. İkinci bir atama error oluşturur. final değişkenler sabit ifadesi olarak ele alınır.
	final yerel değişkenler ve parametre değişkenlerinin Java 8'den itibaren kullanımının anlamı kalmamıştır. Java 8
	öncesindeki kodlarda kullanılması zorunlu olan durumlar vardı. Ancak bu durumlar Java 8 ile birlikte değişti.final
	veri elemanları aynı durum geçerli değildir. final veri elemanlarının kullanılması gereken durumlar vardır.

	final veri elemanları için genel olarak şu kuraldan bahsedilebilir: Veri elemanının final yapılması algoritmik olarak
	geçerliyse kesinklikle yapılmalıdır.
----------------------------------------------------------------------------------------------------------------------*/
```
### final yerel değişkenlere faaliyet alanı boyunca bir kez atama yapılabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	final yerel değişkenlere faaliyet alanı boyunca bir kez atama yapılabilir. Genel olarak ilkdeğer verilse de
	faaliyet alanı boyunca tek atama olması koşuluyla istenildiği yerde atama yapılabilir
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
### Bir metodun parametre değişkeni final olarak bildirilebilir. 
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
```
### final ve non-static olarak bildirilen veri elemanlarına default değer atanmaz!
```java
/*----------------------------------------------------------------------------------------------------------------------
	final ve non-static olarak bildirilen veri elemanlarına default değer atanmaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}


class Sample {
	public final int a; //error
}
```
### non-static final veri elemanlarına bildirim sırasında değer atanabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	non-static final veri elemanlarına bildirim sırasında değer atanabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Sample s = new Sample();

		System.out.println(s.a);
	}
}


class Sample {
	public final int a = 10;
}
```
### Bildirim sırasında atanan değerin sabit ifadesi olması gerekmez
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bildirim sırasında atanan değerin sabit ifadesi olması gerekmez
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Random;

class App {
	public static void main(String [] args)
	{
		Sample s = new Sample();
		Sample k = new Sample();

		System.out.println(s.a);
		System.out.println(k.a);
	}
}


class Sample {
	private int getRandomValue()
	{
		return new Random().nextInt(100);
	}

	public final int a = getRandomValue();

}
```
### non-static final elemanlara ctor içerisinde değer atanabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	non-static final elemanlara ctor içerisinde değer atanabilir. Şüphesiz bu veri elemanına bildirim
	sırasında değer atanmamış olması gerekir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Sample s = new Sample(12);
		Sample k = new Sample(23);

		System.out.println(s.a);
		System.out.println(k.a);
	}
}


class Sample {
	public final int a;

	public Sample(int x)
	{
		a = x;
	}

}
```
### non-static final elemanlara değer ctor dışında atanmamışsa tüm ctor'larda atama yapılmalıdır!
```java
/*----------------------------------------------------------------------------------------------------------------------
	non-static final elemanlara değer ctor dışında atanmamışsa tüm ctor'larda atama yapılmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Sample s = new Sample(12);
		Sample k = new Sample();

		System.out.println(s.a);
		System.out.println(k.a);
	}
}


class Sample {
	public final int a;

	public Sample()
	{
		a = 0;
	}

	public Sample(int x)
	{
		a = x;
	}
}
```
### Sınıfın static ve final olarak bildirilmiş veri elemanlarına da default değer atanmaz.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıfın static ve final olarak bildirilmiş veri elemanlarına da default değer atanmaz.
	Anahtar Notlar: Sınıfın static ve özellikle public veri elemanlarının isimlendirmesinde tamamen büyük harfler
	ile kelime ayracı olarak alttire karakteri kullanımı çok yaygındır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{

	}
}


class Sample {
	public static final int A;

}
```
### Sınıfın final static veri elemanına bildirim sırasında ve sınıfın static bloğu içinde değer atanabilir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıfın final static veri elemanına bildirim sırasında değer atanabilir. Sınıfın final static veri elemanlarına
	sınıfın static bloğu içerisinde de değer atanbilir. Sınıfın static bloğu ileride ele alınacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		System.out.println(Sample.A);
	}
}

class Sample {
	public static final int A = 10;
}
```
### Sınıfın final static elemanlarının bir kullanımı
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıfın final static elemanlarının bir kullanımı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		System.out.printf("%f%n", ChemistryUtil.AVOGADRO_NUMBER);
	}
}

class ChemistryUtil {
	public static final double AVOGADRO_NUMBER = 6.02E22;
	//...
}
```
### CommanPrompt uygulaması
```java
/*----------------------------------------------------------------------------------------------------------------------
	CommanPrompt uygulaması
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.commandpromptapp.CommandPromptApp;

class App {
	public static void main(String [] args)
	{
		CommandPromptApp.run();
	}
}

//---
package org.csystem.app.samples.commandpromptapp;

public class CommandPromptApp {
    private CommandPromptApp()
    {
    }

    public static void run()
    {
        CommandPrompt commandPrompt = new CommandPrompt("CSD");

        commandPrompt.run();
    }
}
//---
package org.csystem.app.samples.commandpromptapp;

import org.csystem.util.StringUtil;

import java.util.Scanner;

public class CommandPrompt {
    private static final String [] COMMAND_STRINGS = {"length", "reverse", "upper", "lower", "change", "clear"};
    private String m_prompt;
    private final Scanner m_kb;

    private static String getCommandByText(String text)
    {
        if (text.length() < 3)
            return "";

        for (String s : COMMAND_STRINGS)
            if (s.startsWith(text))
                return s;

        return "";
    }

    private void lengthProc(String [] commandsStr)
    {
        if (commandsStr.length != 2) {
            System.out.println("length bir tane argüman almalıdır");
            return;
        }

        System.out.println(commandsStr[1].length());
    }

    private void reverseProc(String [] commandsStr)
    {
        if (commandsStr.length != 2) {
            System.out.println("revere bir tane argüman almalıdır");
            return;
        }

        System.out.println(StringUtil.reverse(commandsStr[1]));
    }

    private void upperProc(String [] commandsStr)
    {
        if (commandsStr.length != 2) {
            System.out.println("upper bir tane argüman almalıdır");
            return;
        }
        System.out.println(commandsStr[1].toUpperCase());
    }

    private void lowerProc(String [] commandsStr)
    {
        if (commandsStr.length != 2) {
            System.out.println("lower bir tane argüman almalıdır");
            return;
        }
        System.out.println(commandsStr[1].toLowerCase());
    }

    private void changeProc(String [] commandsStr)
    {
        if (commandsStr.length != 2) {
            System.out.println("change bir tane argüman almalıdır");
            return;
        }
        m_prompt = commandsStr[1];
    }

    private void clearProc(String [] commandsStr)
    {
        for (int i = 0; i < 30; ++i)
            System.out.println();
    }

    private void doWorkForCommand(String [] commandInfoStr)
    {
        switch (commandInfoStr[0]) {
            case "length":
                lengthProc(commandInfoStr);
                break;
            case "reverse":
                reverseProc(commandInfoStr);
                break;
            case "upper":
                upperProc(commandInfoStr);
                break;
            case "lower":
                lowerProc(commandInfoStr);
                break;
            case "change":
                changeProc(commandInfoStr);
                break;
            case "clear":
                clearProc(commandInfoStr);
                break;
        }
    }

    private void parseCommand(String [] commandInfoStr)
    {
        String cmd = getCommandByText(commandInfoStr[0]);

        if (!cmd.isEmpty()) {
            commandInfoStr[0] = cmd;
            doWorkForCommand(commandInfoStr);
        }
        else
            System.out.println("Geçersiz komut");
    }

    public CommandPrompt(String p)
    {
        m_prompt = p;
        m_kb = new Scanner(System.in);
    }

    public void run()
    {
        System.out.println("C ve Sistem Programcıları Derneği");
        System.out.println("Homework-013 sorusuna ilişkin bir iskelet");

        for (;;) {
            System.out.print(m_prompt + ">");
            String cmd = m_kb.nextLine().trim();

            if (cmd.equals("quit"))
                break;

            parseCommand(cmd.split("[ \t]+"));
        }

        System.out.println("C ve Sistem Programcıları Derneği");
        System.out.println("Tekrar yapıyor musunuz?");
    }
}

```
### ExamSimulation uygulaması
```java
/*----------------------------------------------------------------------------------------------------------------------
	ExamSimulation uygulaması
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.examsimulationapp.ExamSimulationApp;

class App {
	public static void main(String [] args)
	{
		ExamSimulationApp.run();
	}
}
//---
package org.csystem.app.samples.examsimulationapp;

public class ExamSimulationApp {
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
//---
package org.csystem.app.samples.examsimulationapp;

import org.csystem.util.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

public class ExamSimulation {
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
        Scanner kb = new Scanner(System.in);
        System.out.print("Şube sayısını giriniz:");
        m_grades = new int[Integer.parseInt(kb.nextLine())][];
        m_averages = new double[m_grades.length];

        for (int i = 0; i < m_grades.length; ++i) {
            System.out.printf("%d. şube öğrenci sayısını giriniz:", i + 1);
            int count = Integer.parseInt(kb.nextLine());

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
### Lottary uygulaması
```java
/*----------------------------------------------------------------------------------------------------------------------
	Lottary uygulaması
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
    private LottaryApp()
    {
    }

    public static void run()
    {
        Lottary lottary = new Lottary();
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print("Kaç kupon oynamak istersiniz?");
            int n = Integer.parseInt(kb.nextLine());

            if (n <= 0)
                break;

            ArrayUtil.display(2, lottary.getNumbers(n));
            System.out.println("///////////////////");
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}

//---
package org.csystem.app.samples.lottary;

import java.util.Random;

public class Lottary {
    private final Random m_random;

    private boolean [] getFlags()
    {
        boolean [] flags = new boolean[50];
        int val;

        for (int i = 0; i < 6; ++i) {
            for (;;) {
                val = m_random.nextInt(49) + 1;
                if (!flags[val])
                    break;
            }
            flags[val] = true;
        }

        return flags;
    }

    private int [] getNumbers(boolean [] flags)
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
        m_random = new Random();
    }

    public int [] getNumbers()
    {
        return getNumbers(getFlags());
    }

    public int [][] getNumbers(int n)
    {
        int [][] numbers = new int[n][];

        for (int i = 0; i < n; ++i)
            numbers[i] = getNumbers();

        return numbers;
    }
}
```
### NumberUtil sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
	NumberUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import static java.lang.Math.*;

public class NumberUtil {
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
### StringUtil sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
	StringUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Random;

import static java.lang.Character.*;

public class StringUtil {
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
### Singleton kalıbının bir implementasyonu (eager implementation)
```java
/*----------------------------------------------------------------------------------------------------------------------
	Singleton kalıbının bir implementasyonu (eager implementation)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		Singleton s1 = Singleton.INSTANCE;
		Singleton s2 = Singleton.INSTANCE;

		System.out.println(s1 == s2);

		s1.setA(10);

		System.out.println(s2.getA());
	}
}

class Singleton {
	public static final Singleton INSTANCE = new Singleton();
	private int m_a;

	private Singleton()
	{}

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
### Bir referansın final olması o referansa atama yapılamayacağı anlamına gelir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir referansın final olması o referansa atama yapılamayacağı anlamına gelir. Referansın gösterdiği nesnenin
	veri elemanlarının değiştirilip değiştirilemeyecği sınıfın yazımına bağlıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		final Sample s = new Sample();

		s.a = 10;

		s = new Sample(); //error
	}
}

class Sample {
	public int a;
}
```
### Aşağıdaki kurallara göre immutable bir sınıf yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
	Problem: Öyle bir sınıf yazın ki, sınıf içerisinde int türden bir değer tutulabilsin. Sınıf immutable olarak
	yazılsın. Bu sınıf için [-128, 127] aralığındaki değerlere ilişkin nesne ilk kez istendiğinde yaratılsın. Daha
	sonraki isteklerde hep aynı nesnenin referansı verilsin (flyweight).
	Yukarıda anlatılan kavrama ön bellek (cache) denir.
	IntValue sınıfı ve test kodları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.IntValue;

class App {
	public static void main(String [] args)
	{
		int val = 10;

		IntValue intValue1 = IntValue.of(10);
		IntValue intValue2 = IntValue.of(val);

		System.out.println(intValue1 == intValue2);
	}
}
//---
package org.csystem.app;

import org.csystem.util.IntValue;

class App {
	public static void main(String [] args)
	{
		int val = 1000;

		IntValue intValue1 = IntValue.of(1000);
		IntValue intValue2 = IntValue.of(val);

		System.out.println(intValue1 == intValue2);
	}
}
//---
package org.csystem.app;

import org.csystem.util.IntValue;

class App {
	public static void main(String [] args)
	{
		System.out.println(IntValue.ONE);
		System.out.println(IntValue.ZERO);
	}
}
//---
package org.csystem.app;

import org.csystem.util.IntValue;

class App {
	public static void main(String [] args)
	{
		IntValue intValue = IntValue.ONE.add(10);

		System.out.println(intValue);
		System.out.println(intValue == IntValue.of(11));
	}
}
//---
package org.csystem.app;

import org.csystem.util.IntValue;

class App {
	public static void main(String [] args)
	{
		for (IntValue i = IntValue.ONE; i.getVal() < 10; i = i.add(1))
			System.out.printf("%d ", i.getVal());

		System.out.println();
	}
}
//---
package org.csystem.app;

import org.csystem.util.IntValue;

class App {
	public static void main(String [] args)
	{
		for (IntValue i = IntValue.of(10); i.getVal() >= 0; i = i.subtract(1))
			System.out.printf("%d ", i.getVal());

		System.out.println();
	}
}
//---
package org.csystem.app;

import org.csystem.util.IntValue;

class App {
	public static void main(String [] args)
	{
		for (IntValue i = IntValue.of(10); i.getVal() >= 0; i = i.decrement())
			System.out.printf("%d ", i.getVal());

		System.out.println();
	}
}
//---
package org.csystem.app;

import org.csystem.util.IntValue;

class App {
	public static void main(String [] args)
	{
		for (IntValue i = IntValue.of(10); i.compareTo(IntValue.ZERO) >= 0; i = i.decrement())
			System.out.printf("%d ", i.getVal());

		System.out.println();
	}
}
//---
package org.csystem.app;

import org.csystem.util.IntValue;

class App {
	public static void main(String [] args)
	{
		IntValue ten = IntValue.of(10);

		for (IntValue i = IntValue.ZERO; i.compareTo(ten) < 0; i = i.increment())
			System.out.printf("%d ", i.getVal());

		System.out.println();
	}
}
//---
package org.csystem.app;

import org.csystem.util.IntValue;

class App {
	public static void main(String [] args)
	{
		IntValue intValue = IntValue.of(10).multiply(2).subtract(3);

		System.out.println(intValue.getVal());
	}
}
```
###  IntValue sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
    IntValue sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

public class IntValue {
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
### Time sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Time sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.datetime.Time;

class App {
	public static void main(String [] args)
	{
		Time time = new Time(15, 7, 4, 35);

		System.out.println(time.toLongTimeString());
	}
}
```
### Time sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Time sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.datetime.Time;

class App {
	public static void main(String [] args)
	{
		Time time = new Time(15, 70, 4, 35);

		System.out.println(time.toLongTimeString());
	}
}
```
### Time sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Time sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.datetime.Time;

class App {
	public static void main(String [] args)
	{
		Time time = new Time(16, 0, 4, 35);

		System.out.println(time.toLongTimeString());

		time.setMillisecond(1200);

		System.out.println(time.toLongTimeString());
	}
}
```
### Time sınıfı ile basit bir dijital saat uygulaması
```java
/*----------------------------------------------------------------------------------------------------------------------
	Time sınıfı ile basit bir dijital saat uygulaması
	Not: Efektif yazılmamıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.datetime.Time;

class App {
	public static void main(String [] args)
	{
		while (true) {
			Time now = new Time();

			System.out.printf("%s\r", now.toLongTimeString());
		}
	}
}
```
### Time sınıfı ile basit bir dijital saat uygulaması
```java
/*----------------------------------------------------------------------------------------------------------------------
	Time sınıfı ile basit bir dijital saat uygulaması
	Not: Efektif yazılmamıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.datetime.Time;

class App {
	public static void main(String [] args)
	{
		while (true) {
			Time now = new Time();

			System.out.printf("%s\r", now.toString());
		}
	}
}
```
### Time sınıfı ve test kodu
```java
/*----------------------------------------------------------------------------------------------------------------------
	Time sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.datetime.Time;

import java.util.Random;

class App {
	public static void main(String [] args)
	{
		Random r = new Random();

		for (int i = 0; i < 10; ++i) {
			Time time = Time.randomTime(r);

			System.out.println(time.toLongTimeString());
		}
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

    private static void doWorkForException(String msg)
    {
        System.out.println(msg);
        System.exit(-1); // exception işlemlerine kadar sabredin
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

    //...

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

/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/
```
