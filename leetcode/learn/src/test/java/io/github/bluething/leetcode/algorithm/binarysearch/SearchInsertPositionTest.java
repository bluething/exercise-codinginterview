package io.github.bluething.leetcode.algorithm.binarysearch;

import org.junit.Assert;
import org.junit.Test;

import javax.imageio.plugins.tiff.TIFFDirectory;

public class SearchInsertPositionTest {

    @Test
    public void case01() {
        Assert.assertEquals(2, searchInsert(new int[]{1,3,5,6}, 5));
    }

    @Test
    public void case02() {
        Assert.assertEquals(1, searchInsert(new int[]{1,3,5,6}, 2));
    }

    @Test
    public void case03() {
        Assert.assertEquals(4, searchInsert(new int[]{1,3,5,6}, 7));
    }

    @Test
    public void case04() {
        Assert.assertEquals(0, searchInsert(new int[]{1,3,5,6}, 0));
    }

    @Test
    public void case05() {
        Assert.assertEquals(0, searchInsert(new int[]{1}, 0));
    }

    // same with finding target in nums
    // but now we need to return expected idx when target not found in nums
    // if the target found, return the idx
    // otherwise return left idx (the order is ascending)
    private int searchInsert(int[] nums, int target) {
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

            idx = low;
        }

        return idx;
    }
}
