/*----------------------------------------------------------------------------------------------------------------------
	Complex sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math;

public class Complex {
	public static Complex add(double re1, double im1, double re2, double im2) //İleride gizlenecek
	{
		Complex z = new Complex();
		
		z.re = re1 + re2;
		z.im = im1 + im2;
		
		return z;
	}
	
	public static Complex subtract(double re1, double im1, double re2, double im2) //İleride gizlenecek
	{
		return add(re1, im1, -re2, -im2);
	}
	
	public double re;
	public double im;
	
	public Complex()
	{
		
	}
	
	public Complex(int a)
	{
		re = a;
	}
	
	public Complex(int a, int b)
	{
		re = a;
		im = b;
	}
	
	public Complex getConjugate()
	{
		Complex z = new Complex();
		
		z.re = re;
		z.im = -im;
		
		return z;
	}
	
	public double getNorm()
	{
		return Math.sqrt(re * re + im * im);
	}
	
	//add
	public static Complex add(double a, Complex z)
	{
		return add(a, 0, z.re, z.im);				
	}
	
	public Complex add(Complex z)
	{
		return add(re, im, z.re, z.im);
	}
	
	public Complex add(double a)
	{
		return add(re, im, a, 0);		
	}
	
	//subtract
	public static Complex subtract(double a, Complex z)
	{
		return subtract(a, 0, z.re, z.im);				
	}
	
	public Complex subtract(Complex z)
	{
		return subtract(re, im, z.re, z.im);
	}
	
	public Complex subtract(double a)
	{
		return subtract(re, im, a, 0);		
	}
	
	public void offset(double dxy)
	{
		offset(dxy, dxy);
	}	
	
	public void offset(double dx, double dy)
	{
		re += dx;
		im += dy;
	}
	
	public String toString()
	{
		return String.format("|%.2f + %.2f * i| = %f", re, im, getNorm());
	}
}

