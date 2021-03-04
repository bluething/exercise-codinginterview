package io.github.bluething.leetcode.marchleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

public class SetMismatchTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertArrayEquals(new int[]{2, 3}, findErrorNums(new int[]{1,2,2,4}));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertArrayEquals(new int[]{1, 2}, findErrorNums(new int[]{1, 1}));
    }

    private int[] findErrorNums(int[] nums) {
        int duplicate = 0;
        for (int i = 0; i < nums.length; i++) {
            duplicate = Math.abs(nums[i]);
            if (nums[duplicate - 1] < 0) {
                break;
            }
            nums[duplicate - 1] *= -1;
        }

        int sumArray = 0;
        for (int i = 0; i < nums.length; i++) {
            sumArray += Math.abs(nums[i]);
        }

        int n = nums.length;
        int missing = (n * (n + 1) / 2) - sumArray + duplicate;

        return new int[]{duplicate, missing};
    }

    // In math, sum 1..N is (N * (N + 1) / 2)
    // The missing number can be find with (N * (N + 1) / 2) - sumArray + duplicate number
    // Because the value start from 1 to N, we can see this value as an index (minus 1)
    // Loop the array, get the value as index, visit the index
    // If the value positive make negative
    // If the value already negative it's mean we get the duplicate
    // O(n) time complexity
    // O(1) space complexity
}
