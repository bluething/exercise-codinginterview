package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarrayTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(5, findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals(0, findUnsortedSubarray(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertEquals(0, findUnsortedSubarray(new int[]{1}));
    }

    private int findUnsortedSubarray(int[] nums) {
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        int leftIdx = 0;
        int rightIdx = nums.length - 1;
        while (leftIdx <= rightIdx && nums[leftIdx] == sortedNums[leftIdx]) {
            leftIdx++;
        }
        while (leftIdx <= rightIdx && nums[rightIdx] == sortedNums[rightIdx]) {
            rightIdx--;
        }

        int numOfShortedElement = rightIdx - leftIdx + 1;

        return numOfShortedElement;
    }

    // The key is 'continous' and 'sorted'
    // What I do is create clone of nums (O(n) space complexity), this clone sorted in ascending order (default), sortedNums
    // nums and sortedNums will only be different at some index, this is the answer
    // The way we find it with two loop
    // 1st loop will go from left -> right until the value from nums and sortedNums was different
    // 2nd loop will go from right -> left (last left from 1st loop) until the value from nums and sortedNums was different
    // Remaining element from left index and right index is the value that we need to sort
    // O(n log(n)) time complexity (sort the array)
}
