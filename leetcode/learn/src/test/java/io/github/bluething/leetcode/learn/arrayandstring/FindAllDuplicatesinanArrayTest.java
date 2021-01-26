package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

// The problem https://leetcode.com/problems/find-all-duplicates-in-an-array/
public class FindAllDuplicatesinanArrayTest {

    @Test
    public void successWhenInputIsRight() {
        List<Integer> expected = new ArrayList<>(Arrays.asList(new Integer[]{2, 3}));
        Assert.assertEquals(expected, findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        List<Integer> expected = new ArrayList<>(Arrays.asList(new Integer[]{1}));
        Assert.assertEquals(expected, findDuplicates(new int[]{1, 1}));
    }

    private List<Integer> findDuplicates(int[] nums) {
        List<Integer> uniqueNums = new ArrayList<>();
        int visitingIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            visitingIndex = Math.abs(nums[i]) - 1;
            if (nums[visitingIndex] < 0) {
                uniqueNums.add(Integer.valueOf(Math.abs(nums[i])));
            }
            nums[visitingIndex] = 0 - nums[visitingIndex];
        }

        return uniqueNums;
    }

    // without extra space and in O(n) runtime?
    // Use hashmap to save nums and counter, extra space
    // Use 2 loop, 2nd loop to find duplicate, O(n^2)
    // I wondering if Arrays.sort(nums) will add space consumption
    // I can't find explanation from Javadocs
    // From https://stackoverflow.com/questions/22571586/will-arrays-sort-increase-time-complexity-and-space-time-complexity I can assume it don't add extra space
    // After read the discussion I learn a new approach
    // The clue is: 1 ≤ a[i] ≤ n (n = size of array). We can see the value start from 1, not 0. And the value is positive.
    // That's mean the value of array (can be) represent an index
    // So if we find the value twice, it's mean we will visit same index twice.
    // The idea is we make all value negative, then when we visit the index again check if the value negative or not
    // 1st get visiting index, this is current value - 1 (remember the value start from 1 not 0), check if we already change to negative
    // If yes (we already visit before) add to uniqueNums
}
