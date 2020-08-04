/*----------------------------------------------------------------------------------------------------------------------
	Diziye ilkdeğer olarak verilen elemanlar sabit ifadesi olmak zorunda değildir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.dateapp.DateUtilApp;

import java.util.Scanner;

import static org.csystem.app.samples.dateapp.DateUtilApp.*;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		DateUtilApp.run();
	}
}


	



