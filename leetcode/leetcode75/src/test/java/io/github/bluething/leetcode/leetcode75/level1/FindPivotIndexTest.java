package io.github.bluething.leetcode.leetcode75.level1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
* Given an array of integers nums, calculate the pivot index of this array.
* The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
* If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
* Return the leftmost pivot index. If no such index exists, return -1.
* */
public class FindPivotIndexTest {
    @Test
    public void case01() {
        int[] input = new int[]{1,7,3,6,5,6};
        int expected = 3;
        Assertions.assertEquals(expected, pivotIndex(input));
    }

    @Test
    public void case02() {
        int[] input = new int[]{1,2,3};
        int expected = -1;
        Assertions.assertEquals(expected, pivotIndex(input));
    }

    // edge case
    // Left sum = 0 (no elements to the left of index 0)
    @Test
    public void case03() {
        int[] input = new int[]{2,1,-1};
        int expected = 0;
        Assertions.assertEquals(expected, pivotIndex(input));
    }

    // From the hint:
    // precompute prefix sums P[i] = nums[0] + nums[1] + ... + nums[i-1]
    // Then for each index, the left sum is P[i], and the right sum is P[P.length - 1] - P[i] - nums[i].
    private int pivotIndex(int[] nums) {
        int pivotIdx = -1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                pivotIdx = i;
                break;
            }

            leftSum += nums[i];
        }

        return pivotIdx;
    }
}
