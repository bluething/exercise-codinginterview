package io.github.bluething.leetcode.algorithm.binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void case01() {
        Assert.assertEquals(4, search(new int[]{-1,0,3,5,9,12}, 9));
    }

    public void case02() {
        Assert.assertEquals(-1, search(new int[]{-1,0,3,5,9,12}, 2));
    }

    private int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        int idx = -1;
        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                idx = mid;
                break;
            }
        }

        return idx;
    }
}