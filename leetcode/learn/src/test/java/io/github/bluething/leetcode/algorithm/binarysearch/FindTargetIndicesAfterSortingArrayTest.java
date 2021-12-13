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

    @Test
    public void case04() {
        List<Integer> expected = Arrays.asList(1, 2);
        Assert.assertEquals(expected, targetIndices2(new int[]{1,2,5,2,3}, 2));
    }

    @Test
    public void case05() {
        List<Integer> expected = Arrays.asList(3);
        Assert.assertEquals(expected, targetIndices2(new int[]{1,2,5,2,3}, 3));
    }

    @Test
    public void case06() {
        List<Integer> expected = new ArrayList<>();
        Assert.assertEquals(expected, targetIndices2(new int[]{1,2,5,2,3}, 4));
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

    // more optimize solution
    // We count how many element less than target (lowerIdx) and how many element equal to target (targetIdx)
    // Loop as much targetIdx, in each iteration we increment lowerIdx
    private List<Integer> targetIndices2(int[] nums, int target) {
        int lowerIdx = 0;
        int targetIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                lowerIdx++;
            }
            if (nums[i] == target) {
                targetIdx++;
            }
        }

        Arrays.sort(nums);

        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < targetIdx; i++) {
            idx.add(lowerIdx++);
        }

        return idx;
    }
}
