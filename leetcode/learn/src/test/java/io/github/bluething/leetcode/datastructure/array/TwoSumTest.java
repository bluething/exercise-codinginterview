package io.github.bluething.leetcode.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumTest {
    @Test
    public void case01() {
        int[] nums = twoSum(new int[]{2,7,11,15}, 9);
        Arrays.sort(nums);
        Assert.assertArrayEquals(new int[]{0, 1}, nums);
    }

    @Test
    public void case02() {
        int[] nums = twoSum(new int[]{3,2,4}, 6);
        Arrays.sort(nums);
        Assert.assertArrayEquals(new int[]{1, 2}, nums);
    }

    @Test
    public void case03() {
        int[] nums = twoSum(new int[]{3,3}, 6);
        Arrays.sort(nums);
        Assert.assertArrayEquals(new int[]{0, 1}, nums);
    }

    private int[] twoSum(int[] nums, int target) {
        int[] idxs = new int[2];
        Map<Integer, Integer> remainderIdx = new HashMap<>();
        remainderIdx.put(nums[0], 0);
        int remainder = 0;
        for (int i = 1; i < nums.length; i++) {
            remainder = target - nums[i];
            if (remainderIdx.containsKey(remainder)) {
                idxs[0] = remainderIdx.get(remainder);
                idxs[1] = i;
                break;
            } else {
                remainderIdx.put(nums[i], i);
            }
        }

        return idxs;
    }
}
