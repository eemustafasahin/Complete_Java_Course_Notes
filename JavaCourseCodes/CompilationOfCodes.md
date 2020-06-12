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





class IsEvenTest{
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	int ival;
	while ((ival =  Integer.parseInt(kb.nextLine())) !=0 ) {
	if (NumberUtil.isEven(ival))
	    System.out.printf("evet çift%n");
	else
	    System.out.printf("hayir çift değil%n");
	}
	System.out.printf("%d sayisi çift bir sayidir",ival);
    }
}

class IsOddTest{
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	int ival;
	while ((ival =  Integer.parseInt(kb.nextLine())) !=0 ) {
	if (NumberUtil.isOdd(ival))
	    System.out.printf("evet tek%n");
	else
	    System.out.printf("hayir tek değil%n");
	}
	System.out.printf("%d sayisi tek bir sayi değildir",ival);
    }
}

class IsPrimeTest{
    public static void run()
    {
    java.util.Scanner kb = new java.util.Scanner(System.in);
    
    System.out.printf("Pozitif bir sayi giriniz:");
    
    int ival = Integer.parseInt(kb.nextLine()); 
    
    System.out.printf("%d sayisina kadar asal sayılar:%n",ival);
    int j = 0;
    for(int i = 0; i < ival; i++){
	if(NumberUtil.isPrime(i))
	    System.out.printf("%d. asal sayi = %d%n",++j,i);
    }
    if(j == 0)
	System.out.printf("Asal sayi bulunamadı");
    }
    
}

class FactorialTest{
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	int ival = Integer.parseInt(kb.nextLine());
	for(int i = 0; i <= ival; i++){
	    System.out.printf("%d! = %d%n",i,NumberUtil.factorial(i));
	}
	
    }
}

class IsArmStrongTest{
    public static void run(){
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.printf("Bir tam sayi giriniz:");
	int ival = Integer.parseInt(kb.nextLine());
	System.out.printf("%d sayısına kadar olan Armstrong sayilari:%n",ival);
	int j = 0;
	for(int i = 0; i < ival; i++){
	    if(NumberUtil.isArmStrong(i))
		System.out.printf("%d.Armstrong sayisi %d %n",++j,i);
	}
	if(j == 0)
	    System.out.printf("Armstrong sayısı bulunamadı...");
    }
}

class GetDigitsCountTest{
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.printf("Bir tam sayi giriniz:");
	int ival;
	while ((ival = Integer.parseInt(kb.nextLine())) != 0){
	    
	    System.out.printf("%d sayisinin basamak sayisi %d %n",ival,
	    NumberUtil.getDigitsCount(ival));
	}
	System.out.printf("%d sayısının basamak sayısı %d",ival,ival,
		    NumberUtil.getDigitsCount(ival));
	
	
    }
}

class GetDigitsSumTest{
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.printf("Bir tam sayi giriniz:");
	int ival;
	while((ival = Integer.parseInt(kb.nextLine())) != 0){
	    
	    System.out.printf("%d sayısının basamakları toplamı = %d%n",ival,
		    NumberUtil.getDigitsSum(ival));
	    
	}
	    System.out.printf("%d sayısının basamakları toplamı = %d%n",ival,
		    NumberUtil.getDigitsSum(ival));
	
    }
}

class GetReverseTest{
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.printf("Bir tam sayı giriniz:");
	int ival;
	while ((ival = Integer.parseInt(kb.nextLine())) != 0){
	    System.out.printf("Girilen sayinin tersi = %d%n",NumberUtil.getReverse(ival));
	}
	
	
    }
}


class FindPosNegSumApp{
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.printf("Bir tamsayı giriniz:");
	int ival, posSum = 0,negSum = 0;
	while((ival = Integer.parseInt(kb.nextLine())) != 0){
	    if (ival < 0)
		negSum += ival;
	    else
		posSum += ival;
	}
	
	displayResult(posSum,negSum);
	
    }
    
    public static void displayResult(int posSum,int negSum){
	if(posSum > 0)
	System.out.printf("pozitif sayılar top: %d%n",posSum);
	else
	    System.out.printf("Hiç bir pozitif sayı girmediniz.");
	if(negSum < 0)
	System.out.printf("negatif sayılar top: %d%n",negSum);
	else
	    System.out.printf("Hiç bir negatif sayı girmediniz.");
    }
}

class EquationSolverApp {
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.printf("a:");
	double a = Double.parseDouble(kb.nextLine());
	System.out.printf("b:");
	double b = Double.parseDouble(kb.nextLine());
	System.out.printf("c:");
	double c = Double.parseDouble(kb.nextLine());
	findRoots(a,b,c);
	
    }
    
    public static void findRoots(double a,double b,double c)
    {
	double delta = b*b - 4*a*c;
	if (delta >= 0){
	    double x1 = (-b + Math.sqrt(delta)) / 2*a;
	    double x2 = (-b - Math.sqrt(delta)) / 2*a;
	    System.out.printf("x1 = %f ve x2 =%f :",x1,x2);
	}
	else {
	    
	    System.out.printf("Sistemin gerçek kökleri yoktur.");
	    }
	
    }
    
}



class NumberUtil {
    
    	
    
    	public static boolean isEven(int ival)
    	{
    	    return ival % 2 == 0;
    	}
    	
    	public static boolean isOdd (int ival)
    	{
    	    return !isEven(ival);
    	}
    
    	public static  boolean isPrimeSlow(int ival)
    	{
    	    	if(ival <= 1)
    	    	    return false;
    	    	int halfVal = ival/2;
    	    	for(int i = 2; i <= halfVal; i++){
    	    	    if (ival % i == 0)
    	    		return false;
  	    	
    	    	}
    	    	return true;
    	}
    	
    	public static boolean isPrime(int ival)
    	{
    	    if(ival <= 1)
    		return false;
    	    if (ival % 2 == 0)
    		return ival == 2;
    	    if (ival % 3 == 0)
    		return ival == 3;
    	    if(ival % 5 == 0)
    		return ival == 5;
    	    if (ival % 7 == 0)
    		return ival == 7;
    	    
    	    for(int i = 11; i*i < ival; i+=2)
    		return !(ival % i == 0);
    	
    	    return true;
    	}
    	
    	
    	public static int factorial(int ival)
    	{
    	    if(ival < 0)
    		return -1;
    	    int result = 1;
    	    
    	    for(int i = 2; i <= ival; i++){
    		result *= i;
    	    }
    	    return result;
    	    
    	    
    	}
    	
    	public static boolean isArmStrong(int ival)
    	{
    	    if(ival < 0)
    		return false;
    	    
    	    return getDigitsPowSum(ival)==ival;
    	    
    	    
    	}
    	public static int getDigitsPowSum(int ival)
    	{
    	    int n = getDigitsCount(ival);
    	    int sum = 0;
    	    while(ival != 0){
    		sum += getPow(ival % 10,n);
    		ival /= 10;
    	    }
    	    return sum;
    	}
    	
    	public static int getDigitsCount(int ival)
    	{
    	    if(ival == 0)
    		return 1;
    	    int count = 0;
    	    while(ival != 0){
    		count ++;
    		ival /= 10;
    	    }
    	    return count;
    	}
    	
    	public static int getDigitsSum(int ival)
    	{
    	    int sum = 0;
    	    while(ival != 0){
    		sum += ival % 10;
    		ival /= 10;
    	    }
    	    return sum;
    	}
    	
    	public static int getPow(int base,int exp)
    	{
    	    if(exp <= 0)
    		return 1;
    	    int result = 1;
    	    for(int i = 0; i < exp; i++){
    		result*=base;
    	    }
    	    return result;
    	}
    	
    	public static int getReverse(int ival)
    	{
    	    int reverse = 0;
    	    
    	    while(ival != 0){
    		
    		reverse = reverse*10 + ival % 10;
    		ival /= 10;
    	    }
    	    return reverse;
    	    
    	    
    	}
    	
}
```
