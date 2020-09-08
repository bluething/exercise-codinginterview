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
        if(digits == null || digits.length == 0) {
            return new int[] {1};
        }
        int carry = 1;
        int digit = 0;
        for (int i = digits.length-1; i>= 0; i--) {
            if(digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += carry;
                break;
            }
        }
        if(digits[0] == 0) {
            int[] arrResult = new int[digits.length+1];
            arrResult[0] = 1;
            for (int i = 1; i < arrResult.length; i++) {
                arrResult[i] = digits[i-1];
            }
            return arrResult;
        } else {
            return digits;
        }
    }

}
