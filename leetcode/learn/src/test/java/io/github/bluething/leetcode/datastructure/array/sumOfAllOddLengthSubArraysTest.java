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

    // https://leetcode.com/problems/sum-of-all-odd-length-subarrays/discuss/980310/Dew-It-or-O(n)-1-pass-or-(Almost)-No-math
    // How many times does a particular element a[i] contribute to the final sum? The count of all odd-sized sized sub arrays that include this element a[i].
    // How do you compute a[i]? A subarray is odd-sized if both its start and end indices are even OR both are odd.
    // For any element a[i], we keep separate count of odd and even numbered indices to the left and right of it - the ones to the left would be starts of the sub arrays and the ones to the right would be the ends.
    //
    //
    private int sumOddLengthSubArraysWithCountingElementOccurrence(int[] arr) {

    }
}
