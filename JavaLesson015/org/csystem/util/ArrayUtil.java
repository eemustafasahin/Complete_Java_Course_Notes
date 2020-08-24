/*----------------------------------------------------------------------------------------------------------------------
	ArrayUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Random;

public class ArrayUtil {
    private static void bubbleSortAscending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k + 1] < a[k])
                    swap(a, k, k + 1);
    }

    private static void bubbleSortDescending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k + 1] > a[k])
                    swap(a, k, k + 1);
    }

    private static void selectionSortAscending(int [] a)
    {
        int min, minIndex;

        for (int i = 0; i < a.length - 1; ++i) {
            min = a[i];
            minIndex = i;

            for (int k = i + 1; k < a.length; ++k) {
                if (a[k] < min) {
                    min = a[k];
                    minIndex = k;
                }
            }
            a[minIndex] = a[i];
            a[i] = min;
        }
    }

    private static void selectionSortDescending(int [] a)
    {
        int max, maxIndex;

        for (int i = 0; i < a.length - 1; ++i) {
            max = a[i];
            maxIndex = i;

            for (int k = i + 1; k < a.length; ++k) {
                if (a[k] > max) {
                    max = a[k];
                    maxIndex = k;
                }
            }
            a[maxIndex] = a[i];
            a[i] = max;
        }
    }

    private ArrayUtil()
    {
    }

    public static int [][] addMatrices(int [][] a, int [][] b)
    {
        if (isNotMatrix(a) || isNotMatrix(b) || a.length != b.length || a[0].length != b[0].length) {
            System.out.println("Invalid matrices for add operation");
            System.exit(-1); //exception işlemlerine kadar sabredin
        }

        int [][] total = new int[a.length][a[0].length];

        for (int i = 0; i < total.length; ++i)
            for (int j = 0; j < total[i].length; ++j)
                total[i][j] = a[i][j] + b[i][j];

        return total;
    }


    public static void bubbleSort(int [] a, boolean descending)
    {
        if (descending)
            bubbleSortDescending(a);
        else
            bubbleSortAscending(a);
    }

    public static void bubbleSort(int [] a)
    {
        bubbleSort(a, false);
    }

    public static void display(int [] a)
    {
        display(1, a);
    }

    public static void display(int k, int [] a)
    {
        display(k, a.length, a);
    }

    public static void display(int k, int count, int [] a)
    {
        String fmt = String.format("%%0%dd ", k); //"%02d " -> k = 2

        for (int i = 0; i < count; ++i)
            System.out.printf(fmt, a[i]);

        System.out.println();
    }

    public static void display(String [] strings)
    {
        for (String string : strings)
            System.out.println(string);
    }

    public static void display(int [][] a)
    {
        display(1, a);
    }

    public static void display(int k, int [][] a)
    {
        for (int [] array : a)
            display(k, array);
    }

    public static void drawHistogram(int [] data, int n, char ch)
    {
        int maxVal = max(data);

        for (int val : data) {
            int count  = (int)Math.floor(val * n / (double)maxVal);

            while (count-- > 0)
                System.out.print(ch);

            System.out.println();
        }
    }

    public static void fillRandomArray(int [] a, int min, int max)
    {
        fillRandomArray(new Random(), a, min, max);
    }

    public static void fillRandomArray(Random r, int [] a, int min, int max)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] = r.nextInt(max - min) + min;
    }

    public static int[] getHistogramData(int [] a, int n) //[0, n]
    {
        int [] histData = new int[n + 1];

        for (int val : a)
            ++histData[val];

        return histData;
    }

    public static int [] getRandomArray(int n, int min, int max) //[min, max)
    {
        return getRandomArray(new Random(), n, min, max);
    }

    public static int [] getRandomArray(Random r, int n, int min, int max) //[min, max)
    {
        int [] a = new int[n];

        fillRandomArray(r, a, min, max);

        return a;
    }

    public static int[][] getRandomMatrix(int m, int n, int min, int max) //[min, max)
    {
        return getRandomMatrix(new Random(), m, n, min, max);
    }

    public static int[][] getRandomMatrix(Random r, int m, int n, int min, int max) //[min, max)
    {
        int [][] a = new int[m][];

        for (int i = 0; i < m; ++i)
            a[i] = getRandomArray(r, n, min, max);

        return a;
    }

    public static int [][] getRandomSquareMatrix(int n, int min, int max)
    {
        return getRandomSquareMatrix(new Random(), n, min, max);
    }

    public static int [][] getRandomSquareMatrix(Random r, int n, int min, int max)
    {
        return getRandomMatrix(r, n, n, min, max);
    }

    public static boolean isMatrix(int [][] a)
    {
        int count = a[0].length;

        for (int i = 1; i < a.length; ++i)
            if (a[i].length != count)
                return false;

        return true;
    }

    public static boolean isNotMatrix(int [][]a)
    {
        return !isMatrix(a);
    }

    public static boolean isSquareMatrix(int [][] a)
    {
        return isMatrix(a) && a[0].length == a.length;
    }

    public static boolean isNotSquareMatrix(int [][] a)
    {
        return !isSquareMatrix(a);
    }

    public static String join(String [] strings, char delimiter)
    {
        return join(strings, delimiter + "");
    }

    public static String join(String [] strings, String delimiter)
    {
        String str = "";

        for (String s : strings)
            str += s + delimiter;

        return str.substring(0, str.length() - delimiter.length());
    }

    public static int max(int [] a)
    {
        int maxVal = a[0];

        for (int i = 1; i < a.length; ++i)
            if (a[i] > maxVal)
                maxVal = a[i];

        return maxVal;
    }

    public static int min(int [] a)
    {
        int minVal = a[0];

        for (int i = 1; i < a.length; ++i)
            if (a[i] < minVal)
                minVal = a[i];

        return minVal;
    }

    public static int partition(int [] a, int threshold)
    {
        int partitionIndex = 0;

        while (partitionIndex != a.length && a[partitionIndex] < threshold)
            ++partitionIndex;

        if (partitionIndex == a.length)
            return partitionIndex;

        for (int i = partitionIndex + 1; i < a.length; ++i)
            if (a[i] < threshold)
                swap(a, i, partitionIndex++);

        return partitionIndex;
    }

    public static void reverse(int [] a)
    {
        int halfLen = a.length / 2;

        for (int i = 0; i < halfLen; ++i)
            swap(a, i, a.length - 1 - i);
    }

    public static void reverse(char [] a)
    {
        int halfLen = a.length / 2;

        for (int i = 0; i < halfLen; ++i)
            swap(a, i, a.length - 1 - i);
    }

    public static void selectionSort(int [] a)
    {
        selectionSort(a, false);
    }

    public static void selectionSort(int [] a, boolean descending)
    {
        if (descending)
            selectionSortDescending(a);
        else
            selectionSortAscending(a);
    }

    public static int sum(int [] a)
    {
        int total = 0;

        for (int val : a)
            total += val;

        return total;
    }

    public static int sum(int [][] a)
    {
        int total = 0;

        for (int i = 0; i < a.length; ++i)
            for (int k = 0; k < a[i].length; ++k)
                total += a[i][k];

        return total;
    }

    public static int sumDiagonal(int [][] a)
    {
        int total = 0;

        for (int i = 0; i < a.length; ++i)
            total += a[i][i];

        return total;
    }

    public static void swap(int [] a, int i, int k)
    {
        int temp;

        temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }

    public static void swap(char [] a, int i, int k)
    {
        char temp;

        temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }

    public static int [][] transpose(int [][] a)
    {
        int [][] t = new int[a[0].length][a.length];

        for (int i = 0; i < t.length; ++i)
            for (int j = 0; j < t[i].length; ++j)
                t[i][j] = a[j][i];

        return t;
    }
}

