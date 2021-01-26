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

    private List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<Integer> uniqueNums = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                uniqueNums.add(Integer.valueOf(nums[i]));
                nums[i + 1] = -1;
            }
        }

        return uniqueNums;
    }

    // without extra space and in O(n) runtime?
    // Use hashmap to save nums and counter, extra space
    // Use 2 loop, 2nd loop to find duplicate, O(n^2)
    // I wondering if Arrays.sort(nums) will add space consumption
    // I can't find explanation from Javadocs
    // From https://stackoverflow.com/questions/22571586/will-arrays-sort-increase-time-complexity-and-space-time-complexity I can assume it don't add extra space
}
