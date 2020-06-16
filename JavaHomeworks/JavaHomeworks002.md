```java
package csd;

class App {
	public static void main(String [] args) 
	{
	   
	    //...
	   
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

```
