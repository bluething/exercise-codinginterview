package io.github.bluething.leetcode.dsstudyplan.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//
//Merge nums1 and nums2 into a single array sorted in non-decreasing order.
public class MergeSortedArrayTest {

    @Test
    public void case01() {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2, 3);
        Assertions.assertArrayEquals(new int[]{1,2,2,3,5,6}, nums1);
    }

    @Test
    public void case02() {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{};
        merge(nums1, 1, nums2, 0);
        Assertions.assertArrayEquals(new int[]{1}, nums1);
    }

    @Test
    public void case03() {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        merge(nums1, 0, nums2, 1);
        Assertions.assertArrayEquals(new int[]{1}, nums1);
    }

    private void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n - 1;
        m--;
        n--;
        // move the biggest number to the right nums1
        while (m >= 0 && n>= 0) {
            if (nums1[m] >= nums2[n]) {
                nums1[idx--] = nums1[m--];
            } else if (nums1[m] < nums2[n]){
                nums1[idx--] = nums2[n--];
            }
        }

        // move the rest of nums2
        while (n >= 0) {
            nums1[idx--] = nums2[n--];
        }
    }
}
