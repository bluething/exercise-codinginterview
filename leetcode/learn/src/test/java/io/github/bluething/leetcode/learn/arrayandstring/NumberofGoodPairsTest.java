package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

// The problem https://leetcode.com/problems/number-of-good-pairs/
public class NumberofGoodPairsTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(4, numIdenticalPairs(new int[]{1,2,3,1,1,3}));
    }

    @Test
    public void successWhenInputIsRightCaseTwo() {
        Assert.assertEquals(6, numIdenticalPairs(new int[]{1,1,1,1}));
    }

    @Test
    public void successWhenInputIsRightCaseThree() {
        Assert.assertEquals(0, numIdenticalPairs(new int[]{1,2,3}));
    }

    private int numIdenticalPairs(int[] nums) {
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    counter++;
                }
            }
        }

        return counter;
    }
}
