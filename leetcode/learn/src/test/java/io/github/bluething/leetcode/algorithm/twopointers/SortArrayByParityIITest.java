package io.github.bluething.leetcode.algorithm.twopointers;

import org.junit.Assert;
import org.junit.Test;

// Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
//Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
//Return any answer array that satisfies this condition.
public class SortArrayByParityIITest {

    @Test
    public void case01() {
        sortArrayByParityII(new int[]{4,2,5,7});
    }

    @Test
    public void case02() {
        Assert.assertArrayEquals(new int[]{2,3}, sortArrayByParityII(new int[]{2,3}));
    }

    // create pointer for even and odd index
    // loop until one of them exceed the length
    // if in evenIdx the mod value greater than mod value in oddIdx, swap
    // after swap:
    // if in evenIdx mod value is 0 (even), increment by 2 (to the next element)
    // if in oddIdx mod value is 1 (odd), increment by 2 (to the next element)
    private int[] sortArrayByParityII(int[] nums) {
        int evenIdx = 0;
        int oddIdx = 1;
        int tmp = 0;
        while (evenIdx < nums.length && oddIdx < nums.length) {
            if (nums[evenIdx] % 2 > nums[oddIdx] % 2) {
                tmp = nums[evenIdx];
                nums[evenIdx] = nums[oddIdx];
                nums[oddIdx] = tmp;
            }
            if (nums[evenIdx] % 2 == 0) {
                evenIdx += 2;
            }
            if (nums[oddIdx] % 2 == 1) {
                oddIdx += 2;
            }
        }

        return nums;
    }
}
