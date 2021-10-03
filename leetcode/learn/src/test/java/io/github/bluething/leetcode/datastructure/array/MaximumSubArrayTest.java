package io.github.bluething.leetcode.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

public class MaximumSubArrayTest {

    @Test
    public void case01() {
        Assert.assertEquals(6, maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    @Test
    public void case02() {
        Assert.assertEquals(1, maxSubArray(new int[]{1}));
    }

    @Test
    public void case03() {
        Assert.assertEquals(23, maxSubArray(new int[]{5,4,-1,7,8}));
    }

    private int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int localMax = 0;
        for (int i = 0; i < nums.length; i++) {
            localMax = Math.max(nums[i], nums[i] + localMax);
            max = Math.max(max, localMax);
        }

        return max;
    }
}
