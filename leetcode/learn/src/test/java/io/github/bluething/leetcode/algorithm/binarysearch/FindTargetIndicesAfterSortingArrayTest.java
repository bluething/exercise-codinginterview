package io.github.bluething.leetcode.algorithm.binarysearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* I think this solution can't be solved with binary search without sacrifice time complexity
* With binary search we need to check both lower and higher side
* */
public class FindTargetIndicesAfterSortingArrayTest {

    @Test
    public void case01() {
        List<Integer> expected = Arrays.asList(1, 2);
        Assert.assertEquals(expected, targetIndices(new int[]{1,2,5,2,3}, 2));
    }

    @Test
    public void case02() {
        List<Integer> expected = Arrays.asList(3);
        Assert.assertEquals(expected, targetIndices(new int[]{1,2,5,2,3}, 3));
    }

    @Test
    public void case03() {
        List<Integer> expected = new ArrayList<>();
        Assert.assertEquals(expected, targetIndices(new int[]{1,2,5,2,3}, 4));
    }

    private List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);

        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                idx.add(i);
            }
        }

        return idx;
    }
}
