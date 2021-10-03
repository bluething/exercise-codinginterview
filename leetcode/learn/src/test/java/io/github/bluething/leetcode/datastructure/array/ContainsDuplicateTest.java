package io.github.bluething.leetcode.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateTest {

    @Test
    public void case01() {
        Assert.assertTrue(containsDuplicate(new int[]{1,2,3,1}));
    }

    @Test
    public void case02() {
        Assert.assertFalse(containsDuplicate(new int[]{1,2,3,4}));
    }

    @Test
    public void case03() {
        Assert.assertTrue(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    private boolean containsDuplicate(int[] nums) {
        boolean isDuplicate = false;
        Set<Integer> uniqueNums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!uniqueNums.add(nums[i])) {
                isDuplicate = true;
                break;
            }
        }

        return isDuplicate;
    }
}
