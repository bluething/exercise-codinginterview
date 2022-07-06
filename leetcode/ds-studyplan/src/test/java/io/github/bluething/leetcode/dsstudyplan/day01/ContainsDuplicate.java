package io.github.bluething.leetcode.dsstudyplan.day01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    @Test
    public void case01ReturnTrue() {
        Assertions.assertTrue(containsDuplicate(new int[]{1,2,3,1}));
    }

    @Test
    public void case02ReturnFalse() {
        Assertions.assertFalse(containsDuplicate(new int[]{1,2,3,4}));
    }

    @Test
    public void case03ReturnTrue() {
        Assertions.assertTrue(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    private boolean containsDuplicate(int[] nums) {
        boolean isDuplicate = false;
        Set<Integer> uniqueValues = new HashSet<>();
        for (int i : nums) {
            if (!uniqueValues.add(i)) {
                isDuplicate = true;
                break;
            }
        }
        return isDuplicate;
    }
}
