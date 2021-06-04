package io.github.bluething.leetcode.juneleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCuts {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(6, maxArea(5, 4, new int[]{3, 1}, new int[]{1}));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals(9, maxArea(5, 4, new int[]{3}, new int[]{1}));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertEquals(4, maxArea(5, 4, new int[]{1, 2, 4}, new int[]{1, 3}));
    }

    private int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int maxH = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        int maxW = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);

        for (int i = 1; i < horizontalCuts.length; i++) {
            maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        for (int i = 1; i < verticalCuts.length; i++) {
            maxW = Math.max(maxW, verticalCuts[i] - verticalCuts[i - 1]);
        }

        int area = (int)((long)maxH * maxW % 1000000007);

        return area;
    }
    // Horizontal cut and vertical cut will always intersect
    // We need to find largest area of each
    // 1st find largest area for each horizontal and vertical cut
    // Sort the array. We only care about 1st and last element
    // Compare the value of 1st element and difference between h or w value with the last element
    // This is the two end cuts
    // Let's find the other slice
    // Loop for each horizontalCuts and verticalCuts
    // We search again for the maximum h or w, compare with area between two sequential cuts
    // Careful with the statement "return this modulo 10^9 + 7"
    // We need to cast to long then back to int

}
