/*----------------------------------------------------------------------------------------------------------------------
	PointF sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math.geometry;

import static java.lang.Math.sqrt;

public class PointF {
	public float x;
	public float y;
	
	public PointF()
	{		
	}
	
	public PointF(float a)
	{
		x = a;
	}
	
	public PointF(float a, float b)
	{
		x = a;
		y = b;
	}
	
	public double distance(Point p)
	{
		return distance(p.x, p.y);				
	}
	
	public double distance(float a, float b)
	{
		return sqrt((x - a) * (x - a) + (y - b) * (y - b));								
	}
	
	public void offset(float dxy)
	{
		offset(dxy, dxy);
	}
	
	public void offset(float dx, float dy)
	{
		x += dx;
		y += dy;
	}
	
	public String toString()
	{
		return String.format("{x: %f, y: %f}", x, y);
	}	
}
