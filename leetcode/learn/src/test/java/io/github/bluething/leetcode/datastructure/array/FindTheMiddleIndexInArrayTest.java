package io.github.bluething.leetcode.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

// Given a 0-indexed integer array nums, find the leftmost middleIndex (i.e., the smallest amongst all the possible ones).
//
//A middleIndex is an index where nums[0] + nums[1] + ... + nums[middleIndex-1] == nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1].
//
//If middleIndex == 0, the left side sum is considered to be 0. Similarly, if middleIndex == nums.length - 1, the right side sum is considered to be 0.
//
//Return the leftmost middleIndex that satisfies the condition, or -1 if there is no such index.
public class FindTheMiddleIndexInArrayTest {

    @Test
    public void case01() {
        int[] input = new int[]{2,3,-1,8,4};
        int expected = 3;
        Assert.assertEquals(expected, findMiddleIndex(input));
    }

    @Test
    public void case02() {
        int[] input = new int[]{1,-1,4};
        int expected = 2;
        Assert.assertEquals(expected, findMiddleIndex(input));
    }

    @Test
    public void case03() {
        int[] input = new int[]{2,5};
        int expected = -1;
        Assert.assertEquals(expected, findMiddleIndex(input));
    }

    private int findMiddleIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int pivotIdx = -1;
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum = sum - leftSum - nums[i];
            if (leftSum == rightSum) {
                pivotIdx = i;
                break;
            }

            leftSum += nums[i];
        }

        return pivotIdx;
    }
}
