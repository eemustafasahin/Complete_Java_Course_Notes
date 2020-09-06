package org.csystem.app.samples.lottary;

import java.util.Random;

public class Lottary {
    private final Random m_random;

    private boolean [] getFlags()
    {
        boolean [] flags = new boolean[50];
        int val;

        for (int i = 0; i < 6; ++i) {
            for (;;) {
                val = m_random.nextInt(49) + 1;
                if (!flags[val])
                    break;
            }
            flags[val] = true;
        }

        return flags;
    }

    private int [] getNumbers(boolean [] flags)
    {
        int [] a = new int[6];

        int index = 0;

        for (int i = 1; i < 50; ++i)
            if (flags[i])
                a[index++] = i;

        return a;
    }

    public Lottary()
    {
        m_random = new Random();
    }

    public int [] getNumbers()
    {
        return getNumbers(getFlags());
    }

    public int [][] getNumbers(int n)
    {
        int [][] numbers = new int[n][];

        for (int i = 0; i < n; ++i)
            numbers[i] = getNumbers();

        return numbers;
    }
}
