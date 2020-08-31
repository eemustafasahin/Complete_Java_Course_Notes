/*----------------------------------------------------------------------------------------------------------------------
	Time sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.datetime.Time;

import java.util.Random;

class App {
	public static void main(String [] args)
	{
		Random r = new Random();

		for (int i = 0; i < 10; ++i) {
			Time time = Time.randomTime(r);

			System.out.println(time.toLongTimeString());
		}
	}
}

