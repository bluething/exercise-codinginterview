package io.github.bluething.leetcode.marchleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

public class MissingNumberTes {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(2, missingNumber(new int[]{3,0,1}));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals(2, missingNumber(new int[]{0,1}));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertEquals(8, missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }

    @Test
    public void successWhenInputIsRightFour() {
        Assert.assertEquals(1, missingNumber(new int[]{0}));
    }

    private int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }

        return sum;
    }

    // All the numbers of nums are unique
    // Mean we can calculate the sum with n * (n + 1) / 2
    // We can find missing number by way of subtract sum with sum of nums elements
}
