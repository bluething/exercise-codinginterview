package io.github.bluething.leetcode.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Given an integer array nums and two integers k and t, return true if there are two distinct indices i and j in the array such that
// 1. abs(nums[i] - nums[j]) <= t, and
// 2. abs(i - j) <= k
public class ContainsDuplicateIIITest {

    @Test
    public void case01() {
        Assert.assertTrue(containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));
    }

    @Test
    public void case02() {
        Assert.assertTrue(containsNearbyAlmostDuplicate(new int[]{1,0,1,1}, 1, 2));
    }

    @Test
    public void case03() {
        Assert.assertFalse(containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
    }

    @Test
    public void case04() {
        Assert.assertTrue(containsNearbyAlmostDuplicate(new int[]{1,2,2,3,4,5}, 3, 0));
    }

    @Test
    public void case05() {
        Assert.assertFalse(containsNearbyAlmostDuplicate(new int[]{0}, 0, 0));
    }

    @Test
    public void case06() {
        Assert.assertTrue(containsNearbyAlmostDuplicate(new int[]{8,7,15,1,6,1,9,15}, 1, 3));
    }

    @Test
    public void case07() {
        Assert.assertFalse(containsNearbyAlmostDuplicate(new int[]{2147483647,-1,2147483647}, 1, 2147483647));
    }

    @Test
    public void case08() {
        Assert.assertFalse(containsNearbyAlmostDuplicate(new int[]{1, 2}, 0, 1));
    }

    // The idea is using a map as bucket (sliding windows)
    // We map a range of values to a bucket
    // In each loop we look at the bucket to see if we already have the value
    // If we found it means we have separated values with distance <= t
    // If not, we need to check in the adjacent bucket (-1 and +1) from current bucket
    // because upper and lower numbers of bucket can be t apart from items in the adjacent buckets
    private boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, Long> bucket = new HashMap<>();
        // 1 bucket will hold t+1 values
        // use long because the value can be Integer.MAX_VALUE
        long width = t + 1;
        long bucketId = 0;
        boolean isNearbyAlmostDuplicate = false;
        for (int i = 0; i < nums.length; i++) {
            // Example t = 3 (Divide by t + 1 = 4)
            // buckets[0] will contain 0, 1, 2, 3
            // buckets[1] will contain 4, 5, 6, 7
            // buckets[2] will contain 8, 9, 10, 11
            bucketId = Math.floorDiv(nums[i], width);
            if (bucket.containsKey(bucketId) ||
                    (bucket.containsKey(bucketId + 1) && Math.abs(nums[i] - bucket.get(bucketId + 1)) <= t) ||
                    (bucket.containsKey(bucketId - 1) && Math.abs(nums[i] - bucket.get(bucketId - 1)) <= t)) {
                isNearbyAlmostDuplicate = true;
                break;
            }

            bucket.put(bucketId, Long.valueOf(nums[i]));

            // to maintain sliding window of size k
            // we delete the 1st bucket
            if (i >= k) {
                bucket.remove(Math.floorDiv(nums[i - k] , width));
            }
        }

        return isNearbyAlmostDuplicate;
    }

    @Test
    public void case09() {
        Assert.assertTrue(containsNearbyAlmostDuplicate2(new int[]{1,2,3,1}, 3, 0));
    }

    @Test
    public void case10() {
        Assert.assertTrue(containsNearbyAlmostDuplicate2(new int[]{1,0,1,1}, 1, 2));
    }

    @Test
    public void case11() {
        Assert.assertFalse(containsNearbyAlmostDuplicate2(new int[]{1,5,9,1,5,9}, 2, 3));
    }

    @Test
    public void case12() {
        Assert.assertTrue(containsNearbyAlmostDuplicate2(new int[]{1,2,2,3,4,5}, 3, 0));
    }

    @Test
    public void case13() {
        Assert.assertFalse(containsNearbyAlmostDuplicate2(new int[]{0}, 0, 0));
    }

    @Test
    public void case14() {
        Assert.assertTrue(containsNearbyAlmostDuplicate2(new int[]{8,7,15,1,6,1,9,15}, 1, 3));
    }

    @Test
    public void case15() {
        Assert.assertFalse(containsNearbyAlmostDuplicate2(new int[]{2147483647,-1,2147483647}, 1, 2147483647));
    }

    @Test
    public void case16() {
        Assert.assertFalse(containsNearbyAlmostDuplicate2(new int[]{1, 2}, 0, 1));
    }

    // need to tune for large nums
    private boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        boolean isNearbyAlmostDuplicate = false;
        int i = 0;
        while (!isNearbyAlmostDuplicate && i < nums.length) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j
                        && (Math.abs((long)nums[i] - (long)nums[j]) <= t)
                        && (Math.abs(i - j) <= k)) {
                    isNearbyAlmostDuplicate = true;
                    break;
                } else {
                    continue;
                }
            }
            i++;
        }

        return isNearbyAlmostDuplicate;
    }
}
