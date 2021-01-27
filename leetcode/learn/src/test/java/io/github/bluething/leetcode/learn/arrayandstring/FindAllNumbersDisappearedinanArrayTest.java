package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// The problem https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class FindAllNumbersDisappearedinanArrayTest {

    @Test
    public void successWhenInputIsRight() {
        List<Integer> accepted = new ArrayList<>(Arrays.asList(new Integer[]{5, 6}));
        Assert.assertEquals(accepted, findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

    private List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();

        int visitingIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            visitingIndex = Math.abs(nums[i]) - 1;
            if (nums[visitingIndex] > 0) {
                nums[visitingIndex] = 0 - nums[visitingIndex];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missingNumbers.add(Integer.valueOf(i + 1));
            }
        }

        return missingNumbers;
    }

    // do it without extra space and in O(n) runtime
}
