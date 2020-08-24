/*----------------------------------------------------------------------------------------------------------------------
	Circle sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math.geometry;

public class Circle {
    private double m_radius;
    private double m_pi;

    public Circle()
    {
    }

    public Circle(double radius)
    {
        setRadius(radius);
    }

    public Circle(double radius, double pi)
    {
        setRadius(radius, pi);
    }

    public double getRadius()
    {
        return m_radius;
    }

    public void setRadius(double radius)
    {
        setRadius(radius, Math.PI);
    }

    public void setRadius(double radius, double pi)
    {
        m_radius = Math.abs(radius);
        setPI(pi);
    }

    public double getArea()
    {
        return m_pi * m_radius * m_radius;
    }

    public double getCircumference()
    {
        return 2 * m_pi * m_radius;
    }

    public void setPI(double pi)
    {
        m_pi = Math.abs(pi); //Kolaylık için mutlak değer aldık
    }
}
