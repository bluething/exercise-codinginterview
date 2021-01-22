package io.github.bluething.hackerrank.practice;

import org.junit.Assert;
import org.junit.Test;

// The problem https://www.hackerrank.com/challenges/arrays-ds/problem
public class ArraysDS {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertArrayEquals(new int[]{2, 3, 4, 1}, reverseArray(new int[]{1, 4, 3, 2}));
    }

    private int[] reverseArray(int[] a) {
        int i = 0;
        int j = a.length - 1;

        int temp = 0;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }

        return a;
    }
}
