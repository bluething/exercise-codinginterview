package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

// The problem https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
public class HowManyNumbersAreSmallerThantheCurrentNumberTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertArrayEquals(new int[]{4,0,1,1,3}, smallerNumbersThanCurrent(new int[]{8,1,2,2,3}));
    }
    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertArrayEquals(new int[]{2,1,0,3}, smallerNumbersThanCurrent(new int[]{6,5,4,8}));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertArrayEquals(new int[]{0,0,0,0}, smallerNumbersThanCurrent(new int[]{7,7,7,7}));
    }

    private int[] smallerNumbersThanCurrent(int[] nums) {
        int[] counter = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((i != j) && (nums[i] > nums[j])) {
                    counter[i]++;
                }
            }
        }

        return counter;
    }

}
