package io.github.bluething.leetcode.dsstudyplan.day01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
    public void case03ReturnFalse() {
        Assertions.assertFalse(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }

    @Test
    public void case01Solution2ReturnTrue() {
        Assertions.assertTrue(containsNearbyDuplicate2(new int[]{1,2,3,1}, 3));
    }

    @Test
    public void case02Solution2ReturnFalse() {
        Assertions.assertTrue(containsNearbyDuplicate2(new int[]{1,0,1,1}, 1));
    }

    @Test
    public void case03Solution2ReturnFalse() {
        Assertions.assertFalse(containsNearbyDuplicate2(new int[]{1,2,3,1,2,3}, 2));
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

    private boolean containsNearbyDuplicate2(int[] nums, int k) {
        boolean isDuplicate = false;
        Map<Integer, Integer> uniqueValues = new HashMap<>();
        uniqueValues.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (uniqueValues.containsKey(nums[i])
                    && Math.abs(uniqueValues.get(nums[i]) - i) <= k) {
                isDuplicate = true;
                break;
            }

            uniqueValues.put(nums[i], i);
        }

        return isDuplicate;
    }
}
