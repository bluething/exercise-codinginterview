package io.github.bluething.leetcode.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

// Given an array of positive integers arr, return the sum of all possible odd-length subarrays of arr.
//
//A subarray is a contiguous subsequence of the array.
public class sumOfAllOddLengthSubArraysTest {

    @Test
    public void case01() {
        int[] input = new int[]{1,4,2,5,3};
        int expected = 58;
        Assert.assertEquals(expected, sumOddLengthSubArrays(input));
    }

    @Test
    public void case02() {
        int[] input = new int[]{1, 2};
        int expected = 3;
        Assert.assertEquals(expected, sumOddLengthSubArrays(input));
    }

    @Test
    public void case03() {
        int[] input = new int[]{10,11,12};
        int expected = 66;
        Assert.assertEquals(expected, sumOddLengthSubArrays(input));
    }

    private int sumOddLengthSubArrays(int[] arr) {
        int sum = 0;
        // i and j is the range of sub array
        for (int i = 0; i < arr.length; i++) {
            // make sure we sum odd length
            for (int j = i + 1; j <= arr.length; j += 2) {
                for (int k = i; k < j; k++) {
                    sum += arr[k];
                }
            }
        }

        return sum;
    }
}
