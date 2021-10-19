package io.github.bluething.leetcode.algorithm.twopointers;

import org.junit.Assert;
import org.junit.Test;

public class SquaresofaSortedArrayTest {
    @Test
    public void case01() {
        Assert.assertArrayEquals(new int[]{0,1,9,16,100}, sortedSquares(new int[]{-4,-1,0,3,10}));
    }

    @Test
    public void case02() {
        Assert.assertArrayEquals(new int[]{4,9,9,49,121}, sortedSquares(new int[]{-7,-3,2,3,11}));
    }

    private int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int[] result = new int[nums.length];
        int resultIdx = nums.length - 1;
        while (i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                result[resultIdx] = nums[i] * nums[i];
                i++;
            } else {
                result[resultIdx] = nums[j] * nums[j];
                j--;
            }

            resultIdx--;
        }

        return result;
    }
}
