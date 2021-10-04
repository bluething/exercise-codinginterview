package io.github.bluething.leetcode.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortedArrayTest {
    @Test
    public void case01() {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int[] result = new int[]{1,2,2,3,5,6};
        merge(nums1, 3, nums2, 3);
        Assert.assertArrayEquals(result, nums1);
    }

    @Test
    public void case02() {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{};
        int[] result = new int[]{1};
        merge(nums1, 1, nums2, 0);
        Assert.assertArrayEquals(result, nums1);
    }

    @Test
    public void case03() {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        int[] result = new int[]{1};
        merge(nums1, 0, nums2, 1);
        Assert.assertArrayEquals(result, nums1);
    }

    @Test
    public void case04() {
        int[] nums1 = new int[]{4,0,0,0,0,0};
        int[] nums2 = new int[]{1,2,3,5,6};
        int[] result = new int[]{1,2,3,4,5,6};
        merge(nums1, 1, nums2, 5);
        Assert.assertArrayEquals(result, nums1);
    }

    private void merge(int[] nums1, int m, int[] nums2, int n) {
        int counter = m + n - 1;

        // this is an index
        m--;
        n--;

        while (m >= 0 && n >= 0) {
            if (nums1[m] >= nums2[n]) {
                nums1[counter--] = nums1[m--];
            } else if (nums1[m] < nums2[n]) {
                nums1[counter--] = nums2[n--];
            }
        }

        while (n >= 0) {
            nums1[counter--] = nums2[n--];
        }
    }

    // the key is both array already sort in asc order
    // start from the right, find the bigger number, put in the rightmost nums1
    // there are probability remainder in nums2 (nums1 always bigger than nums2)
    // so we fill the rest nums1 with nums2 (after all the bigger values move to rightmost)
}
