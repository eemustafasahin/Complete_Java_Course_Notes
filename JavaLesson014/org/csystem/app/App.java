/*----------------------------------------------------------------------------------------------------------------------
	for-each döngü deyiminin dizi ile kullanımında döngü değişkenine döngünün her adımında o anki elemanın değeri
	atanır. Bu işlem dizinin başından sonuna kadar tekrarlanır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		int [] a = {1, 2, 3, 4, 5};

		for (int val : a)
			System.out.printf("%d ", val);

		System.out.println();
	}
}

