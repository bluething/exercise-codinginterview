package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

// The problem https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWaterTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(49, maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals(1, maxArea(new int[]{1, 1}));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertEquals(16, maxArea(new int[]{4,3,2,1,4}));
    }

    @Test
    public void successWhenInputIsRightFour() {
        Assert.assertEquals(2, maxArea(new int[]{1,2,1}));
    }

    private int maxArea(int[] height) {

        int max = 0;
        int i = 0;
        int j = height.length - 1;

        while (j > i) {

            max = Math.max(max, Math.min(height[i], height[j]) * (j-i));

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return max;
    }
}
