package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

public class RemoveElement {

    @Test
    public void successWhenInputIsRightCaseOne() {
        Assert.assertEquals(5, removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }

    @Test
    public void successWhenInputIsRightCaseOTwo() {
        Assert.assertEquals(2, removeElement(new int[]{3,2,2,3}, 3));
    }


    public int removeElement(int[] nums, int val) {
        int k = 0;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[j++] = nums[i];
                k++;
            }
        }

        return k;
    }

    // clue
    // Do not allocate extra space for another array
    // modifying the input array in-place
    // It doesn't matter what you leave beyond the returned length
}
