package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {

    @Test
    public void successWhenInputIsRightCaseOne() {
        Assert.assertArrayEquals(new int[]{0, 1}, twoSum(new int[]{2,7,11,15}, 9));
    }

    @Test
    public void successWhenInputIsRightCaseTwo() {
        Assert.assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{3,2,4}, 6));
    }

    public int[] twoSum(int[] nums, int target) {

        int[] indicies = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indicies[0] = i;
                    indicies[1] = j;
                    i = nums.length;
                    j = nums.length;
                }
            }
        }

        return indicies;

    }
}
