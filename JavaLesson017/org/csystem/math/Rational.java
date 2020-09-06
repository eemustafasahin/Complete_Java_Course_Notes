/*----------------------------------------------------------------------------------------------------------------------
	Rational sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math;

public class Rational {
    private int m_a;
    private int m_b;

    private static Rational add(int a1, int b1, int a2, int b2)
    {
        return new Rational(a1 * b2 + a2 * b1, b1 * b2);
    }

    private static Rational subtract(int a1, int b1, int a2, int b2)
    {
        return add(a1, b1, -a2, b2);
    }

    private static Rational multiply(int a1, int b1, int a2, int b2)
    {
        return new Rational(a1 * a2, b1 * b2);
    }

    private static Rational divide(int a1, int b1, int a2, int b2)
    {
        return multiply(a1, b1, b2, a2);
    }

    private static void check(int a, int b)
    {
        if (b == 0) {
            if (a == 0)
                System.out.println("Belirsiz");
            else
                System.out.println("Tanımsız");

            System.exit(-1); //Exception işlemlerine kadar sabredin
        }
    }

    private void simplify()
    {
        int min = Math.min(Math.abs(m_a), m_b);

        for (int i = min; i >= 2; --i)
            if (m_a % i == 0 && m_b % i == 0) {
                m_a /= i;
                m_b /= i;
                break;
            }
    }

    private void configureSign()
    {
        if (m_b < 0) {
            m_a = -m_a;
            m_b = -m_b;
        }
    }

    private void set(int a, int b)
    {
        if (a == 0) {
            m_a = 0;
            m_b = 1;
            return;
        }
        m_a = a;
        m_b = b;
        configureSign();
        simplify();
    }

    public Rational()
    {
        m_b = 1;
    }

    public Rational(int a)
    {
        m_a = a;
        m_b = 1;
    }

    public Rational(int a, int b)
    {
        check(a, b);
        set(a, b);
    }

    public int getNumerator()
    {
        return m_a;
    }

    public void setNumerator(int val)
    {
        if (val == m_a)
            return;

        set(val, m_b);
    }

    public void setDenominator(int val)
    {
        if (val == m_b)
            return;

        check(m_a, val);
        set(m_a, val);
    }

    public int getDenominator()
    {
        return m_b;
    }

    public double getRealValue()
    {
        return  (double) m_a / m_b;
    }

    //add
    public Rational add(Rational r)
    {
        return add(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational add(int val)
    {
        return add(m_a, m_b, val, 1);
    }

    public static Rational add(int val, Rational r)
    {
        return add(val, 1, r.m_a, r.m_b);
    }

    //subtract
    public Rational subtract(Rational r)
    {
        return subtract(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational subtract(int val)
    {
        return subtract(m_a, m_b, val, 1);
    }

    public static Rational subtract(int val, Rational r)
    {
        return subtract(val, 1, r.m_a, r.m_b);
    }

    //multiply
    public Rational multiply(Rational r)
    {
        return multiply(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational multiply(int val)
    {
        return multiply(m_a, m_b, val, 1);
    }

    public static Rational multiply(int val, Rational r)
    {
        return multiply(val, 1, r.m_a, r.m_b);
    }

    //divide
    public Rational divide(Rational r)
    {
        return divide(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational divide(int val)
    {
        return divide(m_a, m_b, val, 1);
    }

    public static Rational divide(int val, Rational r)
    {
        return divide(val, 1, r.m_a, r.m_b);
    }

    //increment
    public void increment(int val)
    {
        m_a += m_b * val;
    }

    public void increment()
    {
        increment(1);
    }

    //decrement
    public void decrement(int val)
    {
        increment(-val);
    }

    public void decrement()
    {
        decrement(1);
    }

    public String toString()
    {
        return String.format("%d / %d = %f", m_a, m_b, getRealValue());
    }
}
