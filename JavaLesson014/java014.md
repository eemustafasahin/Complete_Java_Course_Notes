### Sınıf çalışması: getDigitsInThrees metodunu NumberUtil sınıfı içerisinde yazınız yazınız ve test ediniz.
```java
/*----------------------------------------------------------------------------------------------------------------------
    15.08.2020
	Sınıf çalışması: Parametresi ile aldığı long türden bir sayının en fazla 3 basamaklı ayrılmış sayılarından oluşan
	diziyi döndüren getDigitsInThrees metodunu NumberUtil sınıfı içerisinde yazınız yazınız ve test ediniz.
	Örnek: 1234567 -> 1 234 567
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;
import org.csystem.util.NumberUtil;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		GetDigitsInThreesTest.run();
	}
}

class GetDigitsInThreesTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);

		for (;;) {
			System.out.print("Bir sayı giriniz:");
			long val = Long.parseLong(kb.nextLine());

			int [] a = NumberUtil.getDigitsInThrees(val);

			ArrayUtil.display(a);

			if (val == 0)
				break;
		}
	}
}
```
### String sınıfının split metodu ve çeşitli örnekler
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte split metodu space karakterini ayraç kabul ederek yazıyı ayrıştırmıştır. Ancak split
	metodu regex kullanıldığında bu şekildeki kullanım her karakter için mümkün değildir. Ayraç tek bir karakterden
	oluşsa bile bu kullanım tavsiye edilmez
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		String text = "Bugün,hava çok güzel";
		String [] strings = text.split(" ");

		for (int i = 0; i < strings.length; ++i)
			System.out.println(strings[i]);
	}
}
```
### split metodu ile kullanılacak ayraç(lar) [] arasında yazılmalıdır
```java
/*----------------------------------------------------------------------------------------------------------------------
	split metodu ile kullanılacak ayraç(lar) [] arasında yazılmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		String text = "Bugün hava çok güzel";
		String [] strings = text.split("[ ]");

		for (int i = 0; i < strings.length; ++i)
			System.out.println(strings[i]);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	split metodu ile kullanılacak ayraç(lar) [] arasında yazılmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		String text = "Bugün hava çok,güzel";
		String [] strings = text.split("[ ,]");

		for (int i = 0; i < strings.length; ++i)
			System.out.println(strings[i]);
	}
}
```
### split'in aşağıdaki biçimde kullanımında iki ayraç arasındaki boş string'ler de geri döndürülen diziye dahil edilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	split'in aşağıdaki biçimde kullanımında iki ayraç arasındaki boş string'ler de geri döndürülen diziye dahil edilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		String text = "Bugün hava  çok, güzel";
		String [] strings = text.split("[ ,]");

		for (int i = 0; i < strings.length; ++i)
			System.out.println(strings[i]);
	}
}
```
### Boş string'in diziye dahil edilmemesi için ] sonuna + konmalıdır
```java
/*----------------------------------------------------------------------------------------------------------------------
	Boş string'in diziye dahil edilmemesi için ] sonuna + konmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		String text = "Bugün hava  çok,                 güzel";
		String [] strings = text.split("[ ,]+");

		for (int i = 0; i < strings.length; ++i)
			System.out.println(strings[i]);
	}
}
```
### [ ve ] karakterlerinin ayraç olarak verilebilmesi için ters bölü ile yazılması gerekir. 
```java
/*----------------------------------------------------------------------------------------------------------------------
	[ ve ] karakterlerinin ayraç olarak verilebilmesi için ters bölü ile yazılması gerekir. Hatırlanacağı gibi
	bir stirn sabiti içerisinde ters bölü yazıda olacaksa iki tane ters bölü konmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		String text = "Bugün [hava] çok, güzel";
		String [] strings = text.split("[ ,\\[\\]]+");

		for (int i = 0; i < strings.length; ++i)
			System.out.println(strings[i]);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki kalıplar dışında başka kalıplar da gerekebilir. Bu durum ileride ele alınacaktır
----------------------------------------------------------------------------------------------------------------------*/
```
### Sınıf çalışması: Klavyeden aşağıdaki formatta girilen bilgiyi ayrıştırarak ekrana yazdıran programı yazınız.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf çalışması: Klavyeden aşağıdaki formatta girilen bilgiyi ayrıştırarak ekrana yazdıran programı yazınız.
	Not: Geçerlilik kontrolü yapılmayacaktır.

	<isim>:<gg/aa/yyyy>:<ders adı>:<vize>:<final>
	Oğuz karan:10/09/1976:Matematik:90:100

	Bu formatta kişinin vize final notlarına vize * %40 + final * %60 formulüne göre geçme notunu hesaplayan ve doğum
	tarihinin hangi güne geldiğini yazdıran programı yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.studentinfoparserapp.StudentInfoParserApp;

class App {
	public static void main(String [] args)
	{
		StudentInfoParserApp.run();
	}
}
```
```java
package org.csystem.app.samples.studentinfoparserapp;

public class StudentInfo {
    public String name;
    public String birthDate;
    public String lectureName;
    public int midtermGrade;
    public int finalGrade;

    public double getGrade()
    {
        return midtermGrade * 0.4 + finalGrade * 0.6;
    }

    public String getBirthDateDayOfWeekTR()
    {
        String [] birthDateInfo = birthDate.split("[/]");

        return DateUtil.getDayOfWeekTR(Integer.parseInt(birthDateInfo[0]), Integer.parseInt(birthDateInfo[1]), Integer.parseInt(birthDateInfo[2]));
    }

    public String toString()
    {
        double grade = getGrade();

        return String.format("{name:'%s', birthDate:'%s %s', lectureName:%s, midTermGrade:%d, finalGrade: %d, grade:%f, status:'%s'}",
                name, birthDate, getBirthDateDayOfWeekTR(), lectureName, midtermGrade, finalGrade, grade,  grade >= 50 ? "Geçti" : "Kaldı");
    }
}
```
```java
package org.csystem.app.samples.studentinfoparserapp;

public class DateUtil {
    public static int [] daysOfMonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static String [] daysOfWeekTR = {"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};

    public static String getDayOfWeekTR(int day, int month, int year)
    {
        return daysOfWeekTR[getDayOfWeek(day, month, year)];
    }

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
```java
package org.csystem.app.samples.studentinfoparserapp;

public class StudentInfoParser {
    public StudentInfo studentInfo;

    public StudentInfoParser(String str)
    {
        String [] studentInfoStr = str.split("[:]+");
        //...

        studentInfo = new StudentInfo();
        studentInfo.name = studentInfoStr[0];
        studentInfo.birthDate = studentInfoStr[1];
        studentInfo.lectureName = studentInfoStr[2];
        studentInfo.midtermGrade = Integer.parseInt(studentInfoStr[3]);
        studentInfo.finalGrade = Integer.parseInt(studentInfoStr[4]);
    }
}
```
```java
package org.csystem.app.samples.studentinfoparserapp;

import java.util.Scanner;

public class StudentInfoParserApp {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print("Formatlı yazıyı giriniz:");
            String str = kb.nextLine();

            if (str.equals("quit"))
                break;

            StudentInfoParser studentInfoParser = new StudentInfoParser(str);

            System.out.println(studentInfoParser.studentInfo.toString());
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}
```
### Homework-013 sorusuna ilişkin bir iskelet. Bunu kullanarak geliştirmeniz tavsiye edilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Homework-013 sorusuna ilişkin bir iskelet. Bunu kullanarak geliştirmeniz tavsiye edilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.commandpromptapp.CommandPromptApp;

class App {
	public static void main(String [] args)
	{
		CommandPromptApp.run();
	}
}
```
```java
package org.csystem.app.samples.commandpromptapp;

public class CommandPromptApp {
    public static void run()
    {
        CommandPrompt commandPrompt = new CommandPrompt("CSD");

        commandPrompt.run();
    }
}
```
```java
package org.csystem.app.samples.commandpromptapp;

import org.csystem.util.StringUtil;

import java.util.Scanner;

public class CommandPrompt {
    public static String [] commandsStr = {"length", "reverse", "upper", "lower", "change", "clear"};
    public String prompt;
    public Scanner kb;

    public static String getCommandByText(String text)
    {
        if (text.length() < 3)
            return "";

        for (int i = 0; i < commandsStr.length; ++i)
            if (commandsStr[i].startsWith(text))
                return commandsStr[i];

        return "";
    }

    public void lengthProc(String [] commandsStr)
    {
        if (commandsStr.length != 2) {
            System.out.println("length bir tane argüman almalıdır");
            return;
        }

        System.out.println(commandsStr[1].length());
    }

    public void reverseProc(String [] commandsStr)
    {
        if (commandsStr.length != 2) {
            System.out.println("revere bir tane argüman almalıdır");
            return;
        }

        System.out.println(StringUtil.reverse(commandsStr[1]));
    }

    public void upperProc(String [] commandsStr)
    {
        if (commandsStr.length != 2) {
            System.out.println("upper bir tane argüman almalıdır");
            return;
        }
        System.out.println(commandsStr[1].toUpperCase());
    }

    public void lowerProc(String [] commandsStr)
    {
        if (commandsStr.length != 2) {
            System.out.println("lower bir tane argüman almalıdır");
            return;
        }
        System.out.println(commandsStr[1].toLowerCase());
    }

    public void changeProc(String [] commandsStr)
    {
        if (commandsStr.length != 2) {
            System.out.println("change bir tane argüman almalıdır");
            return;
        }
        prompt = commandsStr[1];
    }

    public void clearProc(String [] commandsStr)
    {
        for (int i = 0; i < 30; ++i)
            System.out.println();
    }

    public void doWorkForCommand(String [] commandInfoStr)
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

    public void parseCommand(String [] commandInfoStr)
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
        prompt = p;
        kb = new Scanner(System.in);
    }

    public void run()
    {
        System.out.println("C ve Sistem Programcıları Derneği");
        System.out.println("Homework-013 sorusuna ilişkin bir iskelet");

        for (;;) {
            System.out.print(prompt + ">");
            String cmd = kb.nextLine().trim();

            if (cmd.equals("quit"))
                break;

            parseCommand(cmd.split("[ \t]+"));
        }

        System.out.println("C ve Sistem Programcıları Derneği");
        System.out.println("Tekrar yapıyor musunuz?");
    }
}
```
## Dizi Dizileri
```java
/*----------------------------------------------------------------------------------------------------------------------
	16.08.2020
	T [] a ifadesinde T dizinin herbir elemanının tür bilgisi olduğuna göre örneğin:
	int [][] a
	ifadesi "her bir elemanı bir dizi referansı olan bir dizi referansı bildirimidir". Yani, a'nın türü int[][] dir.
	a referansı herbir elemanı bir dizi referansı olan bir dizinin adresini tutar
----------------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------------
	Dizi dizisi bildiriminde new işlemi sırasında tür isminde sonra referans bildiriminde kullanılan [] kadar
	[] olmalıdır. Bu [] 'lerin ilki dizinin uzunluğunu temsil ettiği için boş bırakılamaz. Diğer []'ler boş bırakılabilir.
	int [][] türünden bir dizinin her bir elemanı olan dizi referanslarının gösterdiği dizilerin uzunlukları aynı ise
	buna mantıksal olarak matris denir. Çünkü bir matrisi temsil eder. Eğer en az bir dizinin uzunluğu diğerlerinden
	faklı ise bu aryık matris belitrmez. Java' da bazı programlama dillerinde olduğu gibi çok boyutlu dizi kavramı
	yoktur. Örneğin iki boyutlu bişr dizi matris belirtir cümlesi Java için yanlış bir cümledir. Yani aslında
	matrisler de Java' da dizi dizileridir.
----------------------------------------------------------------------------------------------------------------------*/
```
### Aşağıdaki m * n'lik bir matris yaratılmış ve elemanlarına rasgele değerler atanmıştır
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki m * n'lik bir matris yaratılmış ve elemanlarına rasgele değerler atanmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Random;
import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Random r = new Random();
		Scanner kb = new Scanner(System.in);
		System.out.print("Satır sayısını giriniz:");
		int m = Integer.parseInt(kb.nextLine());

		System.out.print("Sütun sayısını giriniz:");
		int n = Integer.parseInt(kb.nextLine());

		int [][] a;

		a = new int[m][];

		for (int i = 0; i < a.length; ++i)
			a[i] = new int[n];

		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				a[i][j] = r.nextInt(100);

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j)
				System.out.printf("%02d ", a[i][j]);

			System.out.println();
		}
	}
}
```
### Java 5 ile birlikte aşağıdaki gibi ikinci [] içerisinde yazılan uzunluk matrisin satır sayısı anlamına gelir.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java 5 ile birlikte aşağıdaki gibi ikinci [] içerisinde yazılan uzunluk matrisin satır sayısı anlamına gelir. Yani
	dizinin gösterdiği diziler otomatik olarak aynı uzunlukta yarılmış olur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Random;
import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Random r = new Random();
		Scanner kb = new Scanner(System.in);
		System.out.print("Satır sayısını giriniz:");
		int m = Integer.parseInt(kb.nextLine());

		System.out.print("Sütun sayısını giriniz:");
		int n = Integer.parseInt(kb.nextLine());

		int [][] a;

		a = new int[m][n];

		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				a[i][j] = r.nextInt(100);

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j)
				System.out.printf("%02d ", a[i][j]);

			System.out.println();
		}
	}
}
```
### Dizi dizileri de metotlara geçirilebilir, dizi dizisi (referansı) döndüren metotlar da yazılabilir
```java
/*----------------------------------------------------------------------------------------------------------------------
	Dizi dizileri de metotlara geçirilebilir, dizi dizisi (referansı) döndüren metotlar da yazılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Random r = new Random();
		Scanner kb = new Scanner(System.in);
		System.out.print("Satır sayısını giriniz:");
		int m = Integer.parseInt(kb.nextLine());

		System.out.print("Sütun sayısını giriniz:");
		int n = Integer.parseInt(kb.nextLine());

		int [][] a;

		a = ArrayUtil.getRandomMatrix(r, m, n, 0, 100);

		ArrayUtil.display(2, a);
	}
}
```
### Dizi dizilerine ilk değer verilmesi
```java
/*----------------------------------------------------------------------------------------------------------------------
	Dizi dizilerine ilk değer verilmesi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

class App {
	public static void main(String [] args)
	{
		int [][] a = {{1, 2, 3,}, {4, 5, 6}, {7, 8, 9}};

		ArrayUtil.display(a);
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Dizi dizilerine ilk değer verilmesi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

class App {
	public static void main(String [] args)
	{
		int [][] a;

		a = new int[][]{{1, 2, 3,}, {4, 5, 6}, {7, 8, 9}};

		ArrayUtil.display(a);
	}
}
```
### Sınıf Çalışması: Parametresi ile aldığı int türden bir dizi dizisinin elemanlarının toplamını döndüren sum isimli metodu ArrayUtil sınıfı içerisinde yazınız ve test ediniz
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden bir dizi dizisinin elemanlarının toplamını döndüren
	sum isimli metodu ArrayUtil sınıfı içerisinde yazınız ve test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		SumTest.run();
	}
}


class SumTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		Random r = new Random();

		for (;;) {
			System.out.print("Satır sayısını giriniz:");
			int m = Integer.parseInt(kb.nextLine());

			if (m <= 0)
				break;

			System.out.print("Sütun sayısını giriniz:");
			int n = Integer.parseInt(kb.nextLine());

			int [][] a = ArrayUtil.getRandomMatrix(r, m, n, 0, 100);

			ArrayUtil.display(2, a);
			System.out.printf("Toplam:%d%n", ArrayUtil.sum(a));
		}

	}
}
```
### Sınıf Çalışması: Parametresi ile aldığı bir matrisin devriğini (transpose) döndüren transpose isimli metodu yazınız.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı bir matrisin devriğini (transpose) döndüren transpose isimli
	metodu yazınız. Metot şüphesiz yeni bir dizi dizisi referansı döndürecektir.
	Not: Matris kontrolü yapılmayacaktır
	1 2 3
	4 5 6

	1 4
	2 5
	3 6
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		TransposeTest.run();
	}
}


class TransposeTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		Random r = new Random();

		for (;;) {
			System.out.print("Satır sayısını giriniz:");
			int m = Integer.parseInt(kb.nextLine());

			if (m <= 0)
				break;

			System.out.print("Sütun sayısını giriniz:");
			int n = Integer.parseInt(kb.nextLine());

			int [][] a = ArrayUtil.getRandomMatrix(r, m, n, 0, 100);

			ArrayUtil.display(2, a);
			System.out.println("///////////////////////");
			ArrayUtil.display(2, ArrayUtil.transpose(a));
		}

	}
}
```
### Sınıf Çalışması: isMatrix ve isSquareMatrix metodlarını yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden dizi dizisinin matris olup olmadığını test eden isMatrix metodu
	ile kare matris olup olmadığını test eden isSquareMatrix metodunu yazınız ve test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

class App {
	public static void main(String [] args)
	{
		int [][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

		System.out.println(ArrayUtil.isMatrix(a) ? "Matris" : "Matris değil");
		System.out.println(ArrayUtil.isSquareMatrix(a) ? "Kare matris" : "Kare matris değil");
	}
}
```
### Sınıf Çalışması: Parametresi ile aldığı int türden bir kare matrisin esas köşegeni üzerindeki elemanlarının toplamını bulan programı yazınız.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden bir kare matrisin esas köşegeni üzerindeki elemanlarının
	toplamını bulan programı yazınız.
	Açıklamalar:
	1. Metot matris veya kare matris kontrolü yapmayacaktır
	2. Metodun testini elemanları rasgele üretilmiş matrisler ile yapınız
	3. Esas köşegen elemanları örneğin:
		1 2 3
		4 5 6
		7 8 9
	matrisi için 1, 5 ve 9 sayılarıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		SumDiagonalTest.run();
	}
}

class SumDiagonalTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		Random r = new Random();

		for (;;) {
			System.out.print("Bir sayı giriniz:");
			int n = Integer.parseInt(kb.nextLine());

			if (n <= 0)
				break;

			int [][] a = ArrayUtil.getRandomSquareMatrix(r, n, 0, 100);

			ArrayUtil.display(2, a);
			System.out.printf("Esas kşegen elemanlar toplamı:%d%n", ArrayUtil.sumDiagonal(a));
		}
	}
}
```
### Sınıf Çalışması: addMtrices isimli metodu ArrayUtil sınıfı içerisinde yazınız ve test ediniz.
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı elemanları int türden olan iki matrisin toplamından oluşan matrisi döndüren
	addMtrices isimli metodu ArrayUtil sınıfı içerisinde yazınız ve test ediniz.
	Açıklamalar:
	1. Metot iki matrisin toplanamaması durumunda ekrana bir mesaj yazdıracak ve programı sonlandıracaktır
	2. Programı sonlandırmak için System.exit(-1) çağrısı yapılabilir
	3. İki matrisin toplanabilmesi için satır sayılarının ve sütun sayıların aynı olması gerekir.
	4. Toplama işlemi için karşılıklı elemanların toplamından yine aynı satır ve sütün sayısına sahip matris elde edilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		AddMatricesTest.run();
	}
}

class AddMatricesTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		Random r = new Random();

		for (;;) {
			System.out.print("Satır sayısını giriniz:");
			int m = Integer.parseInt(kb.nextLine());

			if (m <= 0)
				break;

			System.out.print("Sütün sayısını giriniz:");
			int n = Integer.parseInt(kb.nextLine());

			int [][] a = ArrayUtil.getRandomMatrix(r, m, n, 0, 100);
			int [][] b = ArrayUtil.getRandomMatrix(r, m, n, 0, 100);
			int [][] total = ArrayUtil.addMatrices(a, b);

			ArrayUtil.display(2, a);
			System.out.println("+");
			ArrayUtil.display(2, b);
			System.out.println("=");
			ArrayUtil.display(3, total);
		}
	}
}
```
### Dizi dizilerine yönelik karmaşık bildirimler
```java
/*----------------------------------------------------------------------------------------------------------------------
	Dizi dizilerine yönelik karmaşık bildirimler
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int [][][] a;

		a = new int[3][4][5];

		for (int i = 0; i < a.length; ++i)
			for (int j = 0; j < a[i].length; ++j)
				for (int k = 0; k < a[i][j].length; ++k)
					a[i][j][k] = i + j + k;

		//...
	}
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Dizi dizilerine yönelik karmaşık bildirimler
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int [][][] a = {{{1, 2, 3}, {4, 5, 6}}, {{1, 2,3}, {4, 5, 6}}};

		//...


	}
}
```
### Sayısal loto kupon oluşturan program
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sayısal loto kupon oluşturan program
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

            ArrayUtil.display(2, lottary.getNumbers(n));
            System.out.println("///////////////////");
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}
```
```java
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

    public int [][] getNumbers(int n)
    {
        int [][] numbers = new int[n][];

        for (int i = 0; i < n; ++i)
            numbers[i] = getNumbers();

        return numbers;
    }
}
```
### Sınıf Çalışması: Şubelere göre matematik sınav sonuçlarını bulup yazdıran programı yazınız
```java
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Bir okulda Matematik sınavı ortak olarak yapılıyor olsun. Kaç şube olduğu ve her bir şubenin
	öğrenci sayısı klavyeden girilmek üzere şubelerin notları programda rasgele belirlenecektir. Bu işlemlerden sonra
	Matematik sınavı için her bir şubenin ayrı ayrı not ortalamaları ile okulun not ortalamasını bulan programı
	yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.examsimulationapp.ExamSimulationApp;

class App {
	public static void main(String [] args)
	{
		ExamSimulationApp.run();
	}
}
```
```java
package org.csystem.app.samples.examsimulationapp;

public class ExamSimulationApp {
    public static void run()
    {
        ExamSimulation examSimulation = new ExamSimulation("Matematik");

        examSimulation.run();
        examSimulation.displayGrades();
        examSimulation.displayStatus();
    }
}
```
```java
package org.csystem.app.samples.examsimulationapp;

import org.csystem.util.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

public class ExamSimulation {
    public String lectureName;
    public int [][] grades;
    public double [] averages;
    public double average;

    public void findAverages()
    {
        int totalNumberOfStudents = 0;
        int totalGrades = 0;

        for (int i = 0; i < grades.length; ++i) {
            int total = ArrayUtil.sum(grades[i]);

            averages[i] = (double)total / grades[i].length;
            totalGrades += total;
            totalNumberOfStudents += grades[i].length;
        }

        average = (double)totalGrades / totalNumberOfStudents;
    }

    public void fillGrades()
    {
        Random r = new Random();
        Scanner kb = new Scanner(System.in);
        System.out.print("Şube sayısını giriniz:");
        grades = new int[Integer.parseInt(kb.nextLine())][];
        averages = new double[grades.length];

        for (int i = 0; i < grades.length; ++i) {
            System.out.printf("%d. şube öğrenci sayısını giriniz:", i + 1);
            int count = Integer.parseInt(kb.nextLine());
            grades[i] = ArrayUtil.getRandomArray(r, count, 0, 101);
        }
    }

    public ExamSimulation(String name)
    {
        lectureName = name;
    }

    public void run()
    {
        fillGrades();
        findAverages();
    }

    public void displayGrades()
    {
        System.out.printf("%s dersi sınav notları:%n", lectureName);
        System.out.println("*************************************************************");
        for (int i = 0; i < grades.length; ++i) {
            System.out.printf("%d. şube notları:", i + 1);
            ArrayUtil.display(3, grades[i]);
        }
        System.out.println("*************************************************************");
    }

    public void displayStatus()
    {
        displayGrades();

        System.out.printf("%s dersi için ortalamalar%n", lectureName);
        System.out.println("*************************************************************");
        for (int i = 0; i < averages.length; ++i)
            System.out.printf("%d.şube not ortalaması:%f%n", i + 1, averages[i]);

        System.out.printf("Okul ortalaması:%f%n", average);
        System.out.println("*************************************************************");
    }
}
```
### ArrayUtil sınıfı
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
        for (int i = 0; i < strings.length; ++i)
            System.out.println(strings[i]);
    }

    public static void display(int [][] a)
    {
        display(1, a);
    }

    public static void display(int k, int [][] a)
    {
        for (int i = 0; i < a.length; ++i)
            display(k, a[i]);
    }

    public static void drawHistogram(int [] data, int n, char ch)
    {
        int maxVal = max(data);

        for (int i = 0; i < data.length; ++i) {
            int count  = (int)Math.floor(data[i] * n / (double)maxVal);

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

        for (int i = 0; i < a.length; ++i)
            ++histData[a[i]];

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

        for (int i = 0; i < strings.length; ++i)
            str += strings[i] + delimiter;

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

        for (int i = 0; i < a.length; ++i)
            total += a[i];

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
### NumberUtil sınıfı
```java
/*----------------------------------------------------------------------------------------------------------------------
	NumberUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import static java.lang.Math.*;

public class NumberUtil {
	public static String [] onesTR = {"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
	public static String [] tensTR = {"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};

	public static int[] getDigits(long val, int n)
	{
		long value = Math.abs(val);
		int count = value == 0 ? 1 : (int)Math.log10(value) / n + 1;
		int [] digits = new int[count];
		int powerOfTen = (int)Math.pow(10, n);

		for (int i = count - 1; i >= 0; digits[i] = (int)(value % powerOfTen), value /= powerOfTen, --i)
			;

		return digits;
	}

	public static String numberToText3DigitsTR(int val)
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
				text += onesTR[a];
			text += "yüz";
		}

		if (b != 0)
			text += tensTR[b];

		if (c != 0)
			text += onesTR[c];

		return text;
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

    public static String getRandomText(Random r, int n, String alphabet)
    {
		char [] c = new char[n];

		for (int i = 0; i < n; ++i) {
		    char ch = alphabet.charAt(r.nextInt(alphabet.length()));

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
### for-each döngü deyiminin genel biçimi
```java
/*----------------------------------------------------------------------------------------------------------------------
	for-each döngü deyiminin genel biçimi:
	for (<tür> <değişken> : <dolaşaılabilir (iterable) bir türe ilişkin referans>)
		<deyim>

	Burada dolaşılabilir kavramı uygulama kursunda ele alınacaktır. Diziler dolaşılabilir türler olduğundan
	for-each döngü deyimi ile kullanılabilir.
----------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------
	for-each döngü deyiminin dizi ile kullanımında döngü değişkenine döngünün her adımında o anki elemanın değeri
	atanır. Bu işlem dizinin başından sonuna kadar tekrarlanır
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

/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/
```

