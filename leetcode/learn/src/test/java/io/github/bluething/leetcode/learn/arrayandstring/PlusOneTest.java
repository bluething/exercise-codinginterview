package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

/*
* The problem https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1148/
* */
public class PlusOneTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertArrayEquals(new int[]{1,2,4}, plusOne(new int[]{1,2,3}));
        Assert.assertArrayEquals(new int[]{4,3,2,2}, plusOne(new int[]{4,3,2,1}));
    }

    public int[] plusOne(int[] digits) {
        int[] arrResult = new int[digits.length];
        int i=0;
        for (i=0; i < digits.length-1; i++) {
            arrResult[i] = digits[i];
        }
        arrResult[i] = digits[i] + 1;
        return arrResult;
    }

}
