# All_The_Course_And_Homework_Codes_Here_...
-------------------

```java
package csd;


/*
	
 */
class App {
	public static void main(String [] args) 
	{
	   
	   //...System.out.println("Hello World!");
	    	 BingoGame bingo = new BingoGame();
		 bingo.run();
		 bingo.displayGameResult();
		 bingo.displayWinnerStatus();
		 BingoGamePossiblity.run();
	    
	}
}

class BingoGamePossiblity {
    public static double p;
    
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.printf("Oyun kaç defa oynanasın ?");
	int ival = Integer.parseInt(kb.nextLine());
	BingoGame bingo = new BingoGame();
	
	do{
	    p = getP(bingo,ival);
	    displayPossibility();	
	    System.out.printf("Oyun kaç defa oynanasın ?");
	}while((ival = Integer.parseInt(kb.nextLine())) != 0);
	
	
    }
        
    public static double getP(BingoGame bingo,int n)
    {
	int counterWinner = 0;	
	for (int i = 0; i < n; i++){
	    
	    bingo = new BingoGame();
	    bingo.run();
	    
	    if (bingo.getWinner())
		counterWinner++;	    
	}
	return (double)counterWinner / n;
	
    }
    
    public static void displayPossibility()
    {
	System.out.printf("Possibility is %.15f%n",p);
    }
}

class BingoGame {
    public int number1;
    public int number2;
    public int number3;
    
    public BingoGame()
    {
	number1 = getNewNumber();
	number2 = getNewNumber(number1);
	number3 = getNewNumber(number1,number2);
    }
    
    public static int getNewNumber()
    {
	java.util.Random r = new java.util.Random();
	
	return RandomUtil.nextInt(r, 1, 99);
	
    }
    
    public static int getNewNumber(int exeption)
    {
	java.util.Random r = new java.util.Random();
	
	int randomVal = RandomUtil.nextInt(r, 1, 99);
	
	return randomVal == exeption ? getNewNumber(exeption) : randomVal;
    }
    
    public static int getNewNumber(int exeption1,int exeption2)
    {
	java.util.Random r = new java.util.Random();
	
	int randomVal = RandomUtil.nextInt(r, 1, 99);
	
	return randomVal == exeption1 || randomVal == exeption1 ? 
		getNewNumber(exeption1,exeption2) : randomVal;
    }
    
    public int getSumOfTree()
    {
	return number1 + number2 + number3;
    }
    
    public boolean islessThan150()
    {
	return getSumOfTree() < 150;
    }
    
    public boolean isAllPrime()
    {
	return  NumberUtil.isPrime(number1) ? 
		NumberUtil.isPrime(number2) ? 
		NumberUtil.isPrime(number3) : false : false;
    }
    
    public  boolean isdiffMinAndMaxGreaterThanMid()
    {		
	int mid = NumberUtil.getMid(number1, number2, number3);
	
	return getDiffMidMax() > mid;
    }
    
    public int getDiffMidMax()
    {
	int min = Math.min(number1,Math.min(number2, number3));
	int max = Math.max(number1,Math.max(number2, number3));
	return max - min;
    }
    
    public boolean getWinner()
    {
	boolean winner = islessThan150() || isAllPrime() || isdiffMinAndMaxGreaterThanMid();
	return winner;
    }
    
    public void displayWinnerStatus()
    {
	if(getWinner())
	    System.out.println("Oyunu kazandınız...");
	else
	    System.out.println("Oyunu kaybettiniz...");
    }
    
    public void displayGameResult()
    {
	System.out.printf("number1: %3d %s%nnumber2: %3d %s%nnumber3: %3d %s%n",
	number1,NumberUtil.isPrime(number1) ? "asal" : "asal degil",
	number2,NumberUtil.isPrime(number2) ? "asal" : "asal degil",
	number3,NumberUtil.isPrime(number3) ? "asal" : "asal degil");
	System.out.printf("is All Prime Numbers		 %s%n",isAllPrime()?"yes":"no");
	System.out.println();
	System.out.printf("sum of tree numbers =  %d%n",getSumOfTree());
	System.out.printf("is sumOfTree less than 150 	 %s%n",islessThan150()?"yes":"no");
	System.out.println();
	System.out.printf("diff Max-Min = %d %c mid = %d%n",getDiffMidMax(),isdiffMinAndMaxGreaterThanMid()? '>' : '<'
							   ,NumberUtil.getMid(number1, number2, number3));
	System.out.printf("isdiffMinAndMaxGreaterThanMin	 %s%n",isdiffMinAndMaxGreaterThanMid()?"yes":"no");
	System.out.println();

    }
    
    public void run()
    {
	islessThan150();
	isAllPrime();
	isdiffMinAndMaxGreaterThanMid();	
    }
   
}

class CrapsGameApp {
    public double p;
    
    public void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.println("kaç defa oynamak istiyorsunuz...");
	int ival = Integer.parseInt(kb.nextLine());
	calculateP(ival);
	display();
    }
    
    public void calculateP(int n)
    {	
	CrapsGameSimulation newGame = new CrapsGameSimulation();
	
	int sumOfWinner = 0;
	for (int i = 0; i < n; i++){
	    
	 
	    
	    if(newGame.playGame()){
		System.out.println("Oyunu kazandınız...");
		sumOfWinner++;
	    }
	    else
		System.out.println("Oyunu kaybettiniz...");
	   
	    
	}
	 p = (double)sumOfWinner / n;
	
    }
    
    public void display()
    {
	System.out.printf("P = %.20f",p);
    }
    
}

class CrapsGameSimulation {
    public boolean winner;
    public int dice1;
    public int dice2;
    public int sumOfDice;
    
    public static int getDice()
    {
	java.util.Random r = new java.util.Random();
	return  r.nextInt(6) + 1;
    }
    
    public int getDiceSum(int dice1,int dice2)
    {
	return dice1 + dice2;
    }
    
    public void setNewDice()
    {
	dice1 = getDice();
	dice2 = getDice();
    }
    
    public void setSumOfDice()
    {
	sumOfDice = getDiceSum(dice1,dice2);
    }
    
     public void displayDices()
     {
	 System.out.printf("(%d + %d = %d)%n",dice1,dice2,getDiceSum(dice1,dice2));
     }

    public boolean playGame()
    {
	setNewDice();
	displayDices();
	int diceSum = getDiceSum(dice1,dice2);	
	
	switch(diceSum){
		case  7:
		case 11: {winner = true; break;}
		case  2:
		case  3:
		case  5: {winner = false; break;}
		default:  winner = newGame(diceSum);		
	}
	return winner;
    }
    
    public boolean newGame(int diceSum)
    {   
	do{
	    setNewDice();
	    setSumOfDice();
	    displayDices();
	    
	    if(sumOfDice == 7)	
		return false; 

	}while(sumOfDice != diceSum);
	
	return true;	
    }
    
    public void run()
    {
	if(playGame())
	    System.out.println("Oyunu kazandınız...");
	else
	    System.out.println("Oyunu kaybettiniz...");
    }
     
}



class DiceSimulationApp {
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.println("kaç zar atılacak...");
	int ival = Integer.parseInt(kb.nextLine());
	DiceSimulation mydice = new DiceSimulation(ival);
	//mydice.run();
	System.out.printf("Possibility is %.15f",mydice.possibility);
    }
}

class CoinSimulationApp {
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.println("kaç kere zar atılacak?");
	int ival = Integer.parseInt(kb.nextLine());
	CoinSimulation newcoin = new CoinSimulation(ival);
	newcoin.run();
	System.out.printf("yazı tura olasılığı = %.15f%n",newcoin.p);
    }
}

class ComplexTest {
    public static void run()
    {
	Complex z = new Complex();
	z.re = 3;
	z.im = 5;
	Complex z1 = new Complex();
	z1 = z;
	z.display();
	z1 = z.add(z);
	z1.display();
	
	z1 = z1.subtract(z);
	z1.display();	
     }
    
}

class Complex {
    
    public static Complex add(double re1, double im1, double re2, double im2)
    {
	Complex z = new Complex();
	
	z.re = re1 + re2;
	z.im = im1 + im2;
	
	return z;
    }
    
    public static Complex subtract(double re1, double im1, double re2, double im2)
    {
	return add(re1,im1,-re2,-im2);
    }
    
    //------------------
    
    public double re;
    public double im;
    
    public Complex getConjugate()
    {
	Complex z = new Complex();
	z.re =  re;
	z.im = -im;
	
	return z;
    }
    
    public void display()
    {
	System.out.printf("|%.2f + %.2fi|%n",re,im);
    }
    
    public double getNorm()
    {
	return Math.sqrt(re * re + im * im);
    }
    
    public Complex add(Complex z)
    {
	return add(z.re,z.im,re,im);
    }
    
    public Complex add(double a)
    {
	return add(a,0,re,im);
    }
    
    public Complex add(double a, Complex z)
    {
	return add(a,0,z.re,z.im);
    }
    
    public Complex subtract(Complex z)
    {
	return subtract(re,im,z.re,z.im);
    }
    
    public Complex subtract(double a)
    {
	return subtract(re,im,a,0);
    }
    
    public static Complex subtract(double a, Complex z)
    {
	return subtract(a, 0, z.re, z.im);				
    }
    
    public void offset(int dx,int dy)
    {
	re += dx;
	im += dy;
    }
    
    public void offset(int dxy)
    {
	 offset(dxy,dxy);
    }
}


class CoinSimulation {
    public double p;
    public int coinCount;
    public CoinSimulation (int n)
    {
	coinCount = n;
    }
    
    public static boolean isTail(java.util.Random r)
    {
	return r.nextBoolean();
    }
    public void run()
    {
	java.util.Random r = new java.util.Random();
	int sumOfTails = 0;
	
	for (int i = 0; i < coinCount; i++){
	    if (isTail(r))
		sumOfTails++;
	}
	p = (double)sumOfTails / coinCount;
	
    }
    
}



class DiceSimulation {
    double possibility;
    public int diceNumber;
    
    public DiceSimulation(int num)
    {
	diceNumber =  num;
	run();
    }
    
    
    public static boolean areSame(java.util.Random r)
    {
	return r.nextInt(6) + 1 == r.nextInt(6) + 1;
    }
    
    public void run(){
	java.util.Random r = new java.util.Random();
	
	int sameDiceCount = 0;
	
	for(int i = 0; i < diceNumber; i++){
	    if(areSame(r))
		sameDiceCount++;
	}
	
	possibility = (double)sameDiceCount / diceNumber;
    }
}

class RandomUtil {
    public static int nextInt(java.util.Random r, int min, int max)
    {
	return r.nextInt(max - min) + min;
    }
    public static double nextDouble(java.util.Random r, double min, double max)
    {
	return r.nextDouble()*(max - min) + min;
    }
    public static long nextLong(java.util.Random r, long min, long max)
    {
	return Math.abs(r.nextLong()) % (max - min) + min;
    }
    
   
}

class BallGameApp {
    public static void run()
    {
	BallGame.run();
    }
}

class BallGame {
    
    public static void run()
    {
	playGame(5,100);
    }
    
    public static void playGame(int width, int height)
    {
	int starPos = 0;
	boolean starPosFlag = true;
	for (int i = 1; i <= height ; i++){   
	    
	    System.out.print('!');
	    fillWithSpace(0,starPos);
	    System.out.print('*');
	    fillWithSpace(starPos+1,width);
	    System.out.println('!');
	    starPosFlag = getFlag(starPos, width,starPosFlag);
	    starPos = getStarPosition(starPos, width,starPosFlag);
	    
	}
    }
    
    public static int getStarPosition(int starPos,int width,boolean starPosFlag){
	if (width == 1)
	    return starPos;
	
	if (starPosFlag)
	    return ++starPos;
	
	return --starPos;
    }
    public static boolean getFlag(int starPos, int width, boolean starPosFlag)
    {
	if (starPos == width -1)
	    return false;
	if (starPos == 0)
	    return true;
	
	return starPosFlag;
    }
    
    public static void fillWithSpace(int start,int end)
    {
	
	for (int i = start; i < end; i++){
	    System.out.print(' ');
	}
    }
    
}



class Point {
    
    public Point()
    {
	
    }
    
    public Point(int a)
    {
	x =  a;
	
    }
    
    public Point(int a, int b)
    {
	x =  a;
	y =  b;
    }
    
    public int x;
    public int y;
    
    public void offset(){
	x += 10;
	y += 10;
    }
    
    public void offset(int dx,int dy)
    {
	x += dx;
	y += dy;
    }
    
    public void offset(int dxy)
    {
	offset(dxy,dxy);
    }
    
    public void displayPoints(int x, int y)
    {
	System.out.printf("x:%d y:%d%n",x,y);
    }
    
    public static void displayDistance(double distance)
    {
	System.out.printf("distance %f%n",distance);
    }
    
    public double getDistance(Point p)
    {
	return getDistance(p.x,p.y);
    }
    
    public double getDistance(int a, int b)
    {
	return  Math.sqrt((x-a)*(x-a) + (y-b)*(y-b));
    }
    
}


class Homework4 {
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.printf("Bir tamsayı giriniz:");
	int ival = Integer.parseInt(kb.nextLine());
	int sum = ival, 
	    min = ival, 
	    max = ival;
	int sumCounter = 1;
	for (;;){
	    System.out.printf("Yeni bir deger girmek istiyor musunuz?%n"
	    	+ "[Evet için 1(bir) Hayır için 0(sıfır)%n"
	    	+ "değerlerinden birini giriniz]:");
	    ival = Integer.parseInt(kb.nextLine());
	    if (ival == 0)
		break;
	    System.out.printf("Yeni bir değer giriniz:");
	    ival = Integer.parseInt(kb.nextLine());
	    if (ival > 100 || ival < 0){
		System.out.printf("Geçersiz bir değer girdiniz%n"
			+ "Girilen değer [0-100] aralığında olmalıdır...");
		continue;
	    }
	    min = Math.min(ival, min);
	    max = Math.max(ival, max);
	    sum += ival;
	    sumCounter++;
	    
	}
	System.out.println("Çıkış yaptınız...");
	System.out.printf("Toplam %d değer girildi%n",sumCounter);
	System.out.printf("Max =  %d%n",max);
	System.out.printf("Min =  %d%n",min);
	System.out.printf("Ortalama =  %f%n",NumberUtil.getAverage(sum,sumCounter));
	
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

class IsLeapYearTest {
	public static void run()
	{
		for (int year = 1999; year <= 2105; ++year)
			if (DateUtil.isLeapYear(year))
				System.out.printf("%d ", year);
		
		System.out.println();
	}	
}

class IsValidDateTest {
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
			
			if (DateUtil.isValidDate(day, month, year))
				System.out.printf("%02d/%02d/%04d tarihi geçerlidir%n", day, month, year);
			else
				System.out.println("Geçersiz tarih");	
			
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}	
}

class GetDayOfYearTest {
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	
	for(;;){
	    
	    System.out.println("Gün bilgisi giriniz:");
	    int day = Integer.parseInt(kb.nextLine());
	    	if (day == 0)
	    	    break;
	    System.out.println("Ay bilgisi giriniz:");
	    int mon = Integer.parseInt(kb.nextLine());
	    
	    System.out.print("Yıl bilgisini giriniz:");
	    int year = Integer.parseInt(kb.nextLine());
	    
	    int dayOfYear = DateUtil.getDayOfYear(day, mon, year);
	    
	    if(dayOfYear != -1)
		System.out.printf("%02d/%02d/%04d tarihi yılın %d. günüdür%n",day,mon,year,DateUtil.getDayOfYear(day, mon, dayOfYear));
	    else
		System.out.printf("Geçersiz bir tarih girdiniz. Lütfen tekrar deneyiniz...");
		
	}
	
	System.out.println("Çıkış yaptınız. Program sonlandırılıyor...");
    }
    
    
}

class GetDayOfWeekTest {
	public static void displayTR(int day, int month, int year)
	{
		int dayOfWeek = DateUtil.getDayOfWeek(day, month, year);
		
		if (dayOfWeek == -1) {
			System.out.println("Geçersiz tarih");
			return;
		}
		
		switch (dayOfWeek) {
		case 0:
			System.out.printf("%02d/%02d/%04d Pazar%n", day, month, year);
			break;
		case 1:
			System.out.printf("%02d/%02d/%04d Pazartesi%n", day, month, year);
			break;
		case 2:
			System.out.printf("%02d/%02d/%04d Salı%n", day, month, year);
			break;
		case 3:
			System.out.printf("%02d/%02d/%04d Çarşamba%n", day, month, year);
			break;
		case 4:
			System.out.printf("%02d/%02d/%04d Perşembe%n", day, month, year);
			break;
		case 5:
			System.out.printf("%02d/%02d/%04d Cuma%n", day, month, year);
			break;
		case 6:
			System.out.printf("%02d/%02d/%04d Cumartesi%n", day, month, year);
			break;			
		}
		
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

class DateUtil {
    public static boolean isValidDate(int day, int mon, int year)
    {
	if (day < 1 || day > 31 || mon < 1 || mon > 12)
	    return false;
	int days = 31;
	switch(mon){
	case 4:
	case 6:
	case 9:
	case 11:
	    days = 30;
	    break;
	case 2: 
	    days = 28;
	    if (isLeapYear(year))
	    days++;
	}
	return day <= days;
	
    }
    public static boolean isLeapYear(int year)
    {
	return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
    
    public static int getDayOfYear(int day, int mon, int year)
    {
	if (!isValidDate(day,mon,year))
	    return -1;
	int dayOfYear = day;
	
	switch(mon-1){
	case 11:dayOfYear += 30;
	case 10:dayOfYear += 31;
	case  9:dayOfYear += 30;
	case  8:dayOfYear += 31;
	case  7:dayOfYear += 31;
	case  6:dayOfYear += 30;
	case  5:dayOfYear += 31;
	case  4:dayOfYear += 30;
	case  3:dayOfYear += 31;
	case  2:dayOfYear += 28;
	    if (isLeapYear(year))
		dayOfYear++;
	case 1: dayOfYear += 31;
	    
	}
	return dayOfYear;
    }
    
    public static int getDayOfWeek(int day, int month, int year)
	{
		int dayOfYear;
		
		dayOfYear = getDayOfYear(day, month, year);
		
		if (dayOfYear == -1 || year < 1900)
			return -1;
		
		for (int y = 1900; y < year; ++y) {
			dayOfYear += 365;
			if (isLeapYear(y))
				++dayOfYear;
		}
		
		return dayOfYear % 7;
	}
    
    
}




class GoldBatchNumbersTest {
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.printf("İkiden büyük çift bir tamsayı giriniz:");
	int ival;
	while ((ival = Integer.parseInt(kb.nextLine())) != 0)
	{
	    System.out.println("İşte altın Batch Sayıları:");
	    GoldBatchNumbers.displayGoldBatchNumbers(ival);
	    System.out.println("Çıkmak için '0' giriniz:");
	    System.out.println("Devam etmek için 2'den büyük bir çift sayı giriniz:");
	}
    }
}

class GoldBatchNumbers {
    public static void displayGoldBatchNumbers(int ival)
    {
	
	for(int i = 2; i < ival; i++ )
	    if (NumberUtil.isPrime(i) && NumberUtil.isPrime(ival-i))
		System.out.printf("(%2d) + (%2d) = (%3d)%n",i,ival-i,ival);

    }
}


class PatternTest {
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.println("Merdiven Çizimi: ?");
	
	
		    
	    
	   System.out.println("Yükseklik:");
	   int  height = Integer.parseInt(kb.nextLine());
	   System.out.println("Genişlik:");
	   int width = Integer.parseInt(kb.nextLine());
	   Pattern.createPattern(height, width);
	   
	   
	
    }
}

class Pattern{
    public static void createPattern (int height,int width)
    {
	
	boolean starFlag = true;
	int starPos = 1;
	for(int i = 0; i < height; i++){
	    {
		System.out.print("<");
		    if (starPos <= width && starFlag){
			    displayStarLeftToRight(starPos,width);		    
			    starPos++;
			    if (starPos > width){
				starPos -= 2;
				starFlag = false;
			    }
			}
		    else if (starPos <= width && !starFlag) {
			displayStarRightToLeft(starPos, width);
			starPos--;
			 if (starPos < 1){
			     starPos += 2;
			     starFlag = true;
			 }
			
		    }
		System.out.println(">");
		
	    }
	    
	}
    }
    public static void displayStarLeftToRight(int starPos,int width)
    {
	for (int i = 1; i <= width; i++){
	    if ((i == starPos))
		System.out.print("*");
	    else
		System.out.print("_");
	}
    }
    public static void displayStarRightToLeft(int starPos,int width)
    {
	
	for (int i = 1; i <= width; i++){
	    if ((i == starPos))
		System.out.print("*");
	    else
		System.out.print("_");
	}
    }
}

class GetPrimeFactorTest{
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.println("Bir tamsayı giriniz:");
	int ival;
	while( (ival = Integer.parseInt(kb.nextLine())) > 0 ){
	    System.out.println("Asal Çarpanlar gösteriliyor:");
	    GetPrimeFactor.displayPrimeFactor(ival);
	    System.out.println("Yeni bir tamsayı giriniz:");
	    System.out.println("Çıkmak için 0'a basınız:");
	    
	}
    }
}
class GetPrimeFactor {
   
    
    public static void displayPrimeFactor(int ival)
    {
	int i = 2;
	if (ival < i){
	    System.out.printf("%d sayısının asal çarpanları yok",ival);
	    return;	    
	}
	while (i <= ival){
	    if ((NumberUtil.isPrime(i) && ival % i == 0)){
		System.out.printf("%d ",i);
		ival /= i;
		continue;
	    }
		i++;	
	}
	   
	   
	
    }
}


class DisplayDurationAppTest{
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.println("Tamsayı türden bir saniye değeri giriniz:");
	long second = Long.parseLong(kb.nextLine());
	for(;;){
	    int n = 1000000000;
	    while (n-- > 0)
		;
	    DisplayDurationApp.displayDuration(second--);
	    System.out.printf("%n");
	    if(second == 0)
		break;
	}
    }
}

class DisplayDurationApp {
    public static void displayDuration(long second)
    {

	if (second / 3600 > 0)
	    System.out.printf("%d hour ",second / 3600);
	if ((second % 3600) / 60 > 0)
	    System.out.printf("%d minute ", (second % 3600) / 60);
	if (second % 60 > 0)
	    System.out.printf("%d second ", second %= 60);
    }
    
}

class DiamondShapeAppTest{
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.printf("Baklava çizimi için bir tamsayı giriniz:");
	int ival = Integer.parseInt(kb.nextLine());
	System.out.println("İşte Nefis Baklava:");
	DiamondShapeApp.CreateDiamondShape(ival);
    }
}

class DiamondShapeApp {
    public static void CreateDiamondShape(int n)
    {
	int maxStarNumber = 2*n - 1;
	for (int i = 0, j = 1; i < n; i++, j += 2){  
		displayStar(j, maxStarNumber);
		if (j == maxStarNumber){
		    j -=2;
		    for (int k = 1; k < n; k++,j -= 2){  
			displayStar(j, maxStarNumber);
		    }
		}
	}
    }
    
    public static void displayStar(int currentStarNumber,int maxStarNumber)
    {	
	int spaceNumber = maxStarNumber - currentStarNumber;
	for (int i = 0;i < maxStarNumber; i++){
	    if (i == spaceNumber / 2){
		while(currentStarNumber-- > 0){
		    System.out.printf("*");
		    i++;
		}
	    }
	    System.out.printf(" "); 
	}
	System.out.printf("%n");
    }
	
}


class SigNumTest {
    public static void run()
    {
	java.util.Scanner kb = new java.util.Scanner(System.in);
	System.out.println("Bir tamsayı sayı giriniz:");
	int ival = Integer.parseInt(kb.nextLine());
	
	Homework1.displaySigNum(ival);

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
	
	Homework1.cmpTreeNum(ival1, ival2, ival3);
	
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
	
	System.out.printf("mid sayısı %d%n",Homework1.getMid(ival1, ival2, ival3));
    }
}

class Homework1 {
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

class GetFibonacciNumberTest {
	public static void run()
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.printf("Kaçıncı Fibonaççi sayısı?");
			int n = Integer.parseInt(kb.nextLine());
			
			if (n <= 0)
			    return;
			
			int val = NumberUtil.getFibonacciNumber(n);
			
			System.out.printf("%d. fibonacci sayısı:%d%n", n, val);
		}
	}
}

class GetNextFibonacciNextTest {
	public static void run()
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.printf("Bir sayı giriniz?");
			int n = Integer.parseInt(kb.nextLine());
			
			if (n <= -999)
				return;
			
			int val = NumberUtil.getNextFibonacciNumber(n);
			
			System.out.printf("%d. sayısından sonraki ilk fibonacci sayısı:%d%n", n, val);
		}
	}
}

class GetPrimeTest {
	public static void run()
	{		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.printf("Kaçıncı asal sayıyı istiyorsun?");
			int n = Integer.parseInt(kb.nextLine());
			
			if (n <= 0)
				return;
			
			int val = NumberUtil.getPrime(n);
			
			System.out.printf("%d. asal sayı:%d%n", n, val);
		}
	}
}

class NumberUtil {
    
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
    		if (ival % i == 0)
    		    return false;
    	
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
