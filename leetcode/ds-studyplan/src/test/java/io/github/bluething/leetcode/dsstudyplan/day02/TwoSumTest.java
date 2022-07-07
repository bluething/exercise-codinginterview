package io.github.bluething.leetcode.dsstudyplan.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
public class TwoSumTest {
    @Test
    public void case01() {
        Assertions.assertArrayEquals(new int[]{0,1}, twoSum(new int[]{2,7,11,15}, 9));
    }

    @Test
    public void case02() {
        Assertions.assertArrayEquals(new int[]{1,2}, twoSum(new int[]{3,2,4}, 6));
    }

    @Test
    public void case03() {
        Assertions.assertArrayEquals(new int[]{0,1}, twoSum(new int[]{3,3}, 6));
    }

    private int[] twoSum(int[] nums, int target) {
        int[] pair = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    pair[0] = i;
                    pair[1] = j;
                    return pair;
                }
            }
        }
        return pair;
    }
}
