package io.github.bluething.leetcode.algorithm.twopointers;

import org.junit.Test;

public class SortArrayByParityTest {

    @Test
    public void case01() {
        int[] actual = sortArrayByParity(new int[]{3,1,2,4});
    }

    private int[] sortArrayByParity(int[] nums) {
        int insertIdx = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                if (i != insertIdx) {
                    tmp = nums[insertIdx];
                    nums[insertIdx] = nums[i];
                    nums[i] = tmp;
                }
                insertIdx++;
            }
        }

        return nums;
    }
}
