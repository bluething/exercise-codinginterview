package io.github.bluething.leetcode.marchleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SetMismatchTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertArrayEquals(new int[]{2, 3}, findErrorNums(new int[]{1,2,2,4}));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertArrayEquals(new int[]{1, 2}, findErrorNums(new int[]{1, 1}));
    }

    private int[] findErrorNums(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        int duplicate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!uniqueNums.add(Integer.valueOf(nums[i]))) {
                duplicate = nums[i];
            }
        }

        int missing = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (uniqueNums.add(i)) {
                missing = i;
                break;
            }
        }

        return new int[]{duplicate, missing};
    }
}
