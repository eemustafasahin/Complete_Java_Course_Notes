```java
package csd;

class App {
	public static void main(String [] args) 
	{
	   
	    //...
	   
	}
}

class TripletPrimeNumTest{
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.println("üç basamaklı TripletPrimeNumbers:");
	for(int i = 100; i < 1000; i++) {
	    if(TripletPrimeNum.isTripletPrime(i)){
		System.out.printf("%d -- %d%n",i,NumberUtil.getReverse(i));
	    	
	    }
		
	}
    }
}

class TripletPrimeNum{
    public static boolean isTripletPrime(int ival)
    {
	int reverseVal = NumberUtil.getReverse(ival);
	if (reverseVal > ival)
	    if (NumberUtil.isPrime(ival) && NumberUtil.isPrime(reverseVal))
		    if (NumberUtil.isPrime(ival % 100) && NumberUtil.isPrime(reverseVal % 100))
			    if (NumberUtil.isPrime(ival / 10) && NumberUtil.isPrime(reverseVal / 10))
				     return true;
	    return false;
    }
}

class XPrimalityTest{
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	int ival;
	for(;;){
	    System.out.printf("Bir tam sayı giriniz:");
	    ival = Integer.parseInt(kb.nextLine());
	    if(xPrimality.xPrime(ival))
	    System.out.printf("(%d) sayısı Xprime%n",ival);
	    else
		System.out.printf("(%d) sayısı Xprime değildir%n",ival);
	    System.out.println("Çıkış için negatif bir sayı giriniz");
	    if(ival < 0)
		break;
	    
	}
	System.out.println("Çıkış yaptınız....");
    }
}

class xPrimality {
    public static boolean xPrime(int ival)
    {
	
	while ( NumberUtil.getDigitsCount(ival) > 2){
	    if (!NumberUtil.isPrime(ival))
		return false;
	    ival = NumberUtil.getDigitsSum(ival);
	}
	
	return NumberUtil.isPrime(ival);
    }
}
```
