```java
package csd;
/*
	Programın diğer bileşenlerine README dosyasından ulaşabilirsiniz...
 */
class App {
	public static void main(String [] args) 
	{
	   
	   //...

	    
	}
}

class IsPerfectTest{
    public static void run()
    {
	System.out.printf("Dört basamağa perfect sayıları gösteriliyor...%n");
	for (int i = 1; i < 9999;i++){
	    if (NumberUtil.isPerfect(i))
		System.out.printf("Perfect number: = %4d  Çarpanları toplamı: %4d%n",i,NumberUtil.sumFactors(i));
	}
    }
}
class IsFriendNumTest{
    public static void run()
    {
	System.out.printf("Dört basamaklı arkadaş sayılar gösteriliyor.%n");
	for(int i = 1000; i < 9999; i++)
	    for (int j = i + 1; j < 9999; j++)
		 if (NumberUtil.isFriendNum(i, j) && !NumberUtil.isPrime(i) && !NumberUtil.isPrime(j)){
		     System.out.printf("%d %d	",i,j);
		     System.out.printf("Çarpanları toplamı: %d ve %d%n",NumberUtil.sumFactors(i),NumberUtil.sumFactors(j));
		     int k = 2000000000;
		     while (k-- > 0)
			 ;
		 }
    }
}
class SumFactorsTest{
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.printf("Bir tamsayı giriniz:");
	int ival = Integer.parseInt(kb.nextLine());
	for(;;){
	    if (ival < 0){
		System.out.println("Negatif bir sayı girdiniz. Program sonlandırıldı.");
		break;
	    }
	    System.out.printf("%d sayısının çarpanları toplamı = %d%n",ival,NumberUtil.sumFactors(ival));
	    System.out.printf("%d sayısının çarpanları:",ival);
	    NumberUtil.displayFactors(ival);
	    System.out.printf("Yeni bir değer giriniz:");
	    ival = Integer.parseInt(kb.nextLine());
	    
	}
    }
}


class NumberUtil {
    
    public static double getAverage(int ival,int counter)
    {
	return (double)ival / counter ;
    }
    public static void displayE()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.println("Bir tamsayı giriniz:");
	int ival = Integer.parseInt(kb.nextLine());
	
	System.out.printf("e sayısı = %.15f",getE(ival));
    }
    public static double getE(int n)
    {
	double sum = 0;
	while (n > -1){
	    sum += 1. / getFactorial(n); 
	    n--;
	}
	return sum;
    }
    public static long getFactorial(int n)
    {
	long result = 1;
	if (n == 0 || n == 1)
	    return 1;
	for (int i = 2; i <= n; i++){
	    result *= i;
	}
	return result;
    }
    public static int sumFactors(int ival)
    {
	int sum = 0;
	if (ival < 0 || ival == 1)
	    return ival < 0 ? -1: 1;
	
	for(int i = 1; i < ival; i++){
	    if (ival % i == 0)
	    sum += i;
	}
	return sum;
    }
    public static void displayFactors(int ival)
    {
	if (ival == 1)
	    System.out.print(1);
	for (int i = 1; i < ival ; i++){
	    if(ival % i == 0)
		System.out.printf("%d ",i);
	}
	System.out.printf("%n");
    }
    public static boolean isFriendNum(int ival1,int ival2)
    {
	return sumFactors(ival1) == sumFactors(ival2) ? true : false;
	    
    }
    public static boolean isPerfect(int ival)
    {
	return ival == sumFactors(ival);
    }
 }


```
