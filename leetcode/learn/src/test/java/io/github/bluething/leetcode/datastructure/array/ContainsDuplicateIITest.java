package io.github.bluething.leetcode.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Given an integer array nums and an integer k,
// return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
public class ContainsDuplicateIITest {

    @Test
    public void case01() {
        Assert.assertTrue(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }

    @Test
    public void case02() {
        Assert.assertTrue(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
    }

    @Test
    public void case03() {
        Assert.assertFalse(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    @Test
    public void case04() {
        Assert.assertTrue(containsNearbyDuplicate2(new int[]{1, 2, 3, 1}, 3));
    }

    @Test
    public void case05() {
        Assert.assertTrue(containsNearbyDuplicate2(new int[]{1, 0, 1, 1}, 1));
    }

    @Test
    public void case06() {
        Assert.assertFalse(containsNearbyDuplicate2(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    private boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean isNearbyValuesDuplicate = false;
        Map<Integer, Integer> values = new HashMap<>();
        values.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (values.containsKey(nums[i]) && Math.abs(values.get(nums[i]) - i) <= k) {
                isNearbyValuesDuplicate = true;
                break;
            }
            values.put(nums[i], i);
        }

        return isNearbyValuesDuplicate;
    }

    private boolean containsNearbyDuplicate2(int[] nums, int k) {
        boolean isNearbyValuesDuplicate = false;
        Set<Integer> filters = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // this is crucial part
            // for every i > k, remove the 1st element on the left
            // this is to maintain sliding window, with size k
            if (i > k) {
                filters.remove(nums[i - k - 1]);
            }
            if (!filters.add(nums[i])) {
                isNearbyValuesDuplicate = true;
                break;
            }
        }

        return isNearbyValuesDuplicate;
    }
}
