package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

public class RunningSumof1dArrayTest {

    @Test
    public void successWhenInputIsRightCaseOne() {
        Assert.assertArrayEquals(new int[]{1,3,6,10}, runningSum(new int[]{1,2,3,4}));
    }

    @Test
    public void successWhenInputIsRightCaseTwo() {
        Assert.assertArrayEquals(new int[]{1,2,3,4,5}, runningSum(new int[]{1,1,1,1,1}));
    }

    @Test
    public void successWhenInputIsRightCaseThree() {
        Assert.assertArrayEquals(new int[]{3,4,6,16,17}, runningSum(new int[]{3,1,2,10,1}));
    }

    public int[] runningSum(int[] nums) {
        int[] sumArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                sumArray[i] += nums[j];
            }
        }

        return sumArray;
    }

}
