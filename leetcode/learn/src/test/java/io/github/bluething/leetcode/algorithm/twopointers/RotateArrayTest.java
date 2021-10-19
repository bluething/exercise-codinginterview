package io.github.bluething.leetcode.algorithm.twopointers;

import org.junit.Assert;
import org.junit.Test;

public class RotateArrayTest {
    @Test
    public void case01() {
        int[] input = new int[]{1,2,3,4,5,6,7};
        rotate(input, 3);
        int[] output = new int[]{5,6,7,1,2,3,4};

        Assert.assertArrayEquals(output, input);
    }

    @Test
    public void case02() {
        int[] input = new int[]{-1,-100,3,99};
        rotate(input, 2);
        int[] output = new int[]{3,99,-1,-100};

        Assert.assertArrayEquals(output, input);
    }

    private void rotate(int[] nums, int k) {
        k %= nums.length;

        //reverse the last n-k elements
        reverse(nums, nums.length - k, nums.length - 1);

        //reverse the first n-k elements
        reverse(nums, 0, nums.length - k - 1);

        //reverse the complete array
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        int temp = 0;
        while (i < j) {
            temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }
    }
}
