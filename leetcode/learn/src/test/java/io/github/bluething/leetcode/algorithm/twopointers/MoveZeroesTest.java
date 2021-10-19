package io.github.bluething.leetcode.algorithm.twopointers;

import org.junit.Assert;
import org.junit.Test;

public class MoveZeroesTest {

    @Test
    public void case01() {
        int[] input = new int[]{0,1,0,3,12};
        moveZeroes(input);
        int[] output = new int[]{1,3,12,0,0};
        Assert.assertArrayEquals(output, input);
    }

    public void case02() {
        int[] input = new int[]{0};
        moveZeroes(input);
        int[] output = new int[]{0};
        Assert.assertArrayEquals(output, input);
    }

    // the idea is switch zero behind the non zero
    // insertIdx is the pointer for zero value
    // i is the pointer for non zero value
    private void moveZeroes(int[] nums) {
        int insertIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (insertIdx != i) {
                    nums[insertIdx] = nums[i];
                    nums[i] = 0;
                }
                insertIdx++;
            }
        }
    }
}
