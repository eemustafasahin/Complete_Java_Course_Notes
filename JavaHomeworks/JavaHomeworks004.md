```java
package csd;
/*
  Bütün Code bileşenlerine ve iyileştirmelerine README dosyasından ulaşabilirsiniz...
 */
class App {
	public static void main(String [] args) 
	{
	   
	    Homework4.run();

	    
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
```
