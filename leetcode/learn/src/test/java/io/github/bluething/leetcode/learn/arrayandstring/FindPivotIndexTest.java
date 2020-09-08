package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

/*
 * The problem https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/
 * */
public class FindPivotIndexTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(3, pivotIndex(new int[]{1,7,3,6,5,6}));
        Assert.assertEquals(0, pivotIndex(new int[]{-1,-1,-1,0,1,1}));
    }

    private int pivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        for (int x : nums) {
            sum += x;
        }
        for (int i = 0; i < nums.length; i++) {
            if(leftSum == (sum - leftSum - nums[i])) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

}