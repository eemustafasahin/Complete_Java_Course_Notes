/*----------------------------------------------------------------------------------------------------------------------
	Sınıf çalışması: Parametresi ile aldığı en fazla üç basamaklı bir sayının Türkçe olarak okunuşunu döndüren
	numberToText3Digits metodunu yazınız ve test ediniz. Metot 3 basamaktan daha büyü sayılar için kontrol
	yapmayacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.NumberUtil;

import java.util.Random;
import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		NumberToText3DigitsTest.run();
	}
}

class NumberToText3DigitsTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		Random r = new Random();

		for (;;) {
			System.out.print("Bir sayı giriniz:");
			int n = Integer.parseInt(kb.nextLine());

			if (n <= 0)
				break;

			for (int i = 0; i < n; ++i) {
				int val = r.nextInt(1000 + 999) - 999;
				System.out.printf("%d:%s%n", val, NumberUtil.numberToText3DigitsTR(val));
			}
			System.out.println("*********************************");
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}

