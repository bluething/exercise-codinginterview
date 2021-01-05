package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicatesfromSortedArrayTest {

    @Test
    public void successWhenInputIsRightCaseOne() {
        Assert.assertEquals(2, removeDuplicates(new int[]{1,1,2}));
    }

    @Test
    public void successWhenInputIsRightCaseTwo() {
        Assert.assertEquals(5, removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public int removeDuplicates(int[] nums) {
        int k = 0;

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                k++;
                nums[k] = nums[i];
            }
        }

        return k+1;
    }

    // clue
    // Do not allocate extra space for another array
    // modifying the input array in-place
    // It doesn't matter what you leave beyond the returned length.
}
