package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequenceTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(5, findLHS(new int[]{1,3,2,2,5,2,3,7}));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals(2, findLHS(new int[]{1,2,3,4}));
    }

    @Test
    public void successWhenInputIsRightTwoThree() {
        Assert.assertEquals(0, findLHS(new int[]{1,1,1,1}));
    }

    private int findLHS(int[] nums) {
        int counter = 0;
        int tempCount = 0;
        boolean isFound = false;
        for (int i = 0; i < nums.length; i++) {
            tempCount = 0;
            isFound = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    tempCount++;
                } else if (nums[j] + 1 == nums[i]) {
                    tempCount++;
                    isFound = true;
                }
            }
            if (isFound) {
                counter = Integer.max(tempCount, counter);
            }
        }

        return counter;
    }

    // Using nested loop
    // The idea is find all element value which is same or > 1
    // If the value > 1 mark as found then find the max between counter and tempcount
    // We don't care about the sequence (except we need to print the sequence)
    // Time complexity O(n ^ 2)
    // Space complexity O(1)
}
