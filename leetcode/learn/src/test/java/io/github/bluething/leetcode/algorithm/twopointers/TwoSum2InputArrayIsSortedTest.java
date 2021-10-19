package io.github.bluething.leetcode.algorithm.twopointers;

import org.junit.Assert;
import org.junit.Test;

public class TwoSum2InputArrayIsSortedTest {
    @Test
    public void case01() {
        Assert.assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{2,7,11,15}, 9));
    }

    @Test
    public void case02() {
        Assert.assertArrayEquals(new int[]{1, 3}, twoSum(new int[]{2,3,4}, 6));
    }

    @Test
    public void case03() {
        Assert.assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{-1, 0}, -1));
    }

    private int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        int sum = 0;
        while (i <= j) {
            sum = numbers[i] + numbers[j];
            if (sum == target) {
                i++;
                j++;
                break;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return new int[]{i, j};
    }
}
