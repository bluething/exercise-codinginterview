package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

// The problem https://leetcode.com/problems/shuffle-the-array/
public class ShuffletheArrayTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertArrayEquals(new int[]{2,3,5,4,1,7}, shuffle(new int[]{2,5,1,3,4,7}, 3));
    }

    @Test
    public void successWhenInputIsRightCaseTwo() {
        Assert.assertArrayEquals(new int[]{1,4,2,3,3,2,4,1}, shuffle(new int[]{1,2,3,4,4,3,2,1}, 4));
    }

    @Test
    public void successWhenInputIsRightCaseThree() {
        Assert.assertArrayEquals(new int[]{1,2,1,2}, shuffle(new int[]{1,1,2,2}, 2));
    }

    private int[] shuffle(int[] nums, int n) {
        int[] shuffledArray = new int[nums.length];

        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                shuffledArray[i] = nums[j];
                j++;
            } else {
                shuffledArray[i] = nums[n];
                n++;
            }
        }

        return shuffledArray;
    }
}
