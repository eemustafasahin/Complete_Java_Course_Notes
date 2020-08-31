/*----------------------------------------------------------------------------------------------------------------------	
	Sınıf çalışması: Parametresi ile aldığı int türden gün, ay ve yıl bilgilerine ilişkin tarihin aşağıdaki 
	açıklamalara göre haftanın hangi gününe geldiğini döndüren getDayOfWeek metodunu yazınız.
	Açıklamalar: 
		- Metot geçersiz bir tarih için -1 değerini döndürecektir.
		- Haftanın günü 1.1.1900 ile verilen tarih arasındaki gün sayısının 7 değerine modu alınarak bulunabilir
		- 7 değerine mod alındıktan sonra sıfır Pazar, 1 pazartesi, .., 6 cumartesi günü için
		elde edilecek değerdir
		- 1.1.1900' den önceki tarihler geçersiz kabul edilecektir 
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.samples.dateapp;

public class DateUtilApp {
	public static String [] daysOfWeek = {"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};
	public static String [] monthsTR = {"", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran",
			"Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};

	public static String [] monthsEN = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

	public static void displayTR(int day, int month, int year)
	{
		int dayOfWeek = DateUtil.getDayOfWeek(day, month, year);
		
		if (dayOfWeek == -1) {
			System.out.println("Geçersiz tarih");
			return;
		}

		System.out.printf("%02d %s %04d %s%n", day, monthsTR[month], year, daysOfWeek[dayOfWeek]);
		
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

