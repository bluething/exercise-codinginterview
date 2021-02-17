package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

public class ContainerWithMostWaterTest {

    @Test
    public void successWhenInputIsRightCaseOne() {
        Assert.assertEquals(1, maxArea(new int[]{1, 1}));
    }

    @Test
    public void successWhenInputIsRightCaseTwo() {
        Assert.assertEquals(16, maxArea(new int[]{4,3,2,1,4}));
    }

    @Test
    public void successWhenInputIsRightCaseThree() {
        Assert.assertEquals(2, maxArea(new int[]{1, 2, 1}));
    }

    @Test
    public void successWhenInputIsRightCaseFour() {
        Assert.assertEquals(49, maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    private int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            if (height[i] < height[j]) {
                max = Math.max(max, (height[i] * (j - i)));
                i++;
            } else {
                max = Math.max(max, (height[j] * (j - i)));
                j--;
            }
        }

        return max;
    }
}
