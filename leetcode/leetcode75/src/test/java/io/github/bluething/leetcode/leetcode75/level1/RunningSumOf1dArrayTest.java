package io.github.bluething.leetcode.leetcode75.level1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
* Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
* Return the running sum of nums.
* */
public class RunningSumOf1dArrayTest {
    @Test
    public void case01() {
        int[] input = new int[]{1,2,3,4};
        int[] expected = new int[]{1,3,6,10};
        Assertions.assertArrayEquals(expected, runningSum(input));
    }

    @Test
    public void case02() {
        int[] input = new int[]{1,1,1,1,1};
        int[] expected = new int[]{1,2,3,4,5};
        Assertions.assertArrayEquals(expected, runningSum(input));
    }

    @Test
    public void case03() {
        int[] input = new int[]{3,1,2,10,1};
        int[] expected = new int[]{3,4,6,16,17};
        Assertions.assertArrayEquals(expected, runningSum(input));
    }

    @Test
    public void case04() {
        int[] input = new int[]{1,2,3,4};
        int[] expected = new int[]{1,3,6,10};
        Assertions.assertArrayEquals(expected, runningSum2(input));
    }

    @Test
    public void case05() {
        int[] input = new int[]{1,1,1,1,1};
        int[] expected = new int[]{1,2,3,4,5};
        Assertions.assertArrayEquals(expected, runningSum2(input));
    }

    @Test
    public void case06() {
        int[] input = new int[]{3,1,2,10,1};
        int[] expected = new int[]{3,4,6,16,17};
        Assertions.assertArrayEquals(expected, runningSum2(input));
    }

    private int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result[i] = sum;
        }

        return result;
    }

    // without additional temp variable
    private int[] runningSum2(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] + nums[i];
        }

        return result;
    }
}
