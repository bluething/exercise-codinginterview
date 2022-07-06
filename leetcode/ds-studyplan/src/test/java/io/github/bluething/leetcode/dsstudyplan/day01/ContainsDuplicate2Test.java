package io.github.bluething.leetcode.dsstudyplan.day01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
public class ContainsDuplicate2Test {
    @Test
    public void case01ReturnTrue() {
        Assertions.assertTrue(containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
    }

    @Test
    public void case02ReturnFalse() {
        Assertions.assertTrue(containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
    }

    @Test
    public void case03ReturnTrue() {
        Assertions.assertFalse(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }

    private boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean isDuplicate = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <= i+k && j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    isDuplicate = true;
                    break;
                }
            }
        }

        return isDuplicate;
    }
}
