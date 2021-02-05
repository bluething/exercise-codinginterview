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

        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            frequency.put(Integer.valueOf(nums[i]), frequency.getOrDefault(Integer.valueOf(nums[i]), 0) + 1);
        }

        for (Integer num : frequency.keySet()) {
            if (frequency.get(num + 1) != null) {
                counter = Integer.max(frequency.get(num) + frequency.get(num + 1), counter);
            }
        }

        return counter;
    }
}
