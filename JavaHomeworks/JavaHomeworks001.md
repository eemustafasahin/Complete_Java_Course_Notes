1. Klavyeden alınan int türden üç sayı arasındaki büyüklük küçüklük ilişkisini küçükten büyüğe doğru < ve = sembolleriyle gösteriniz:

Açıklama : Program üç tane int türden sayı isteyecek, aralarındaki ilişkiyi ekranda gösterecek. İşte birkaç örnek :

- [x] Giriş: 10 20 30

- [ ] Yanıt: 10 < 20 < 30

- [x] Giriş: 30 10 20

- [ ] Yanıt: 10 < 20 < 30

- [x] Giriş: 10 10 15

- [ ] Yanıt: 10 = 10 < 15

- [x] Giriş: 40 50 50

- [ ] Yanıt: 40 < 50 = 50

2. Parametresi ile ald ığı int türden 3 sayıdan ortancasına geri dönen mid isimli metodu yazınız ve test ediniz.
3. Parametresi ile aldığı int türden bir sayının negatif mi, 0(sıfır) mı, pozitif mi olduğunu test eden s ignum isimli metodu yazınız ve test ediniz. Metot pozitif iç in 1(bir), negatif için 1(eksi bir) ve sıfır için 0(sıfır) döndürecektir.

```java
package csd;

class App {
	public static void main(String [] args) 
	{
	    CmpTreeNumTest.run();
	    SigNumTest.run();
	    GetMidTest.run();
	  
	}
}

class SigNumTest {
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.println("Bir tamsayı sayı giriniz:");
	int ival = Integer.parseInt(kb.nextLine());
	
	Homework.displaySigNum(ival);

    }
}

class CmpTreeNumTest{
    public static void  run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.println("Üç tamsayı sayı giriniz:");
	int ival1 = Integer.parseInt(kb.nextLine());

	int ival2 = Integer.parseInt(kb.nextLine());

	int ival3 = Integer.parseInt(kb.nextLine());
	
	Homework.cmpTreeNum(ival1, ival2, ival3);
	
    }
}

class GetMidTest {
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.println("Üç tamsayı sayı giriniz:");
	int ival1 = Integer.parseInt(kb.nextLine());

	int ival2 = Integer.parseInt(kb.nextLine());

	int ival3 = Integer.parseInt(kb.nextLine());
	
	System.out.printf("mid sayısı %d%n",Homework.getMid(ival1, ival2, ival3));
    }
}

class Homework {
    public static void displaySigNum(int val)
    {	
	System.out.printf("signum: %d%n",sigNum(val));
    }
    
    public static void displayComparedNum(int min,int mid,int max)
    {
	
	char sigMinMid = '=';
	char sigMidMax = '=';
	if (min != mid)
	    sigMinMid = '<';
	if(mid != max)
	    sigMidMax = '<';
	System.out.printf("[%d] %c [%d] %c [%d]%n",min,sigMinMid,mid,sigMidMax,max);
	
    }
    
    public static void cmpTreeNum(int ival1,int ival2,int ival3)
    {
	int min = Math.min(Math.min(ival1, ival2),ival3);
	int max = Math.max(Math.max(ival1,ival2),ival3);
	int mid = getMid(ival1,ival2,ival3);
	displayComparedNum(min,mid,max);
    }
    
    public static int getMid(int ival1,int ival2,int ival3)
    {
	int mid = -1;
	if (ival1 <= ival2 && ival2 <= ival3 || ival3 <= ival2 && ival2 <= ival1)
	    mid = ival2;
	else if (ival2 <= ival1 && ival1 <= ival3 || ival3 <= ival1 && ival1 <= ival2)
	    mid = ival1;
	else if (ival1 <= ival3 && ival3 <= ival2 || ival2 <= ival3 && ival3 <= ival1)
	     mid = ival3;
	    
	return mid;
    }
    
    public static int sigNum(int ival)
    {
	if(ival != 0)
	if (ival > 0)
	    ival /=ival;
	else 
	    ival /=-ival;
	
	return ival;
    }
}

```
