package io.github.bluething.leetcode.algorithm.twopointers;

import org.junit.Test;

public class SortArrayByParityTest {

    @Test
    public void case01() {
        int[] actual = sortArrayByParity(new int[]{3,1,2,4});
    }

    @Test
    public void case02() {
        int[] actual = sortArrayByParity2(new int[]{3,1,2,4});
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

    private int[] sortArrayByParity2(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int tmp = 0;
        while (i < j) {
            // nums[i] must even when i < j
            if (nums[i] % 2 > nums[j] % 2) {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }

            // found even, move to the right
            if (nums[i] % 2 == 0) {
                i++;
            }
            // found odd, move to the left
            if (nums[j] % 2 == 1) {
                j--;
            }
        }

        return nums;
    }
}
