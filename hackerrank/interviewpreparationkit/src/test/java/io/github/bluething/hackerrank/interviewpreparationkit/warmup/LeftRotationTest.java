package io.github.bluething.hackerrank.interviewpreparationkit.warmup;

import org.junit.Assert;
import org.junit.Test;

/*
* The problem https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
* */
public class LeftRotationTest {

    // The idea is move value to the left start from index 1 until length -1
    // Then value at length -1 fill with temp
    private int[] rotLeft(int[] a, int d) {
        int temp = 0;
        for (int i = 1; i <= d; i++) {
            temp = a[0];
            for (int j = 1; j < a.length; j++) {
                a[j-1] = a[j];
            }
            a[a.length-1] = temp;
        }
        return a;
    }

    @Test
    public void successWhenInputIsRight() {
        Assert.assertArrayEquals(new int[]{5, 1, 2, 3, 4}, rotLeft(new int[]{1, 2, 3, 4, 5}, 4));
    }
}
