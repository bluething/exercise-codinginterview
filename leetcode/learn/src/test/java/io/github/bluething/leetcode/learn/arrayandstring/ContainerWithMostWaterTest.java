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
        int area = 0;
        int max = 0;
        int currHeight = 0;
        for (int i = 0; i < height.length; i++) {
            currHeight = height[height.length - 1];
            for (int j = height.length - 1; j > i; j--) {
                if (currHeight <= height[j]) {
                    currHeight = height[j];

                    area = Math.min(height[j], height[i]) * (j - i);
                    if (max < area) {
                        max = area;
                    }
                }
            }
        }

        return max;
    }
}
