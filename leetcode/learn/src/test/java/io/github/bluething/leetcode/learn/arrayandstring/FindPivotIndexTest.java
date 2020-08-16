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
        int arrLength = nums.length;
        if(arrLength == 0 || arrLength == 1 || arrLength == 2)
            return -1;
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < arrLength; i++) {
            sumLeft=0;
            sumRight=0;
            for(int j = 0; j<i; j++) {
                sumLeft += nums[j];
            }
            for (int k = i+1; k < arrLength; k++) {
                sumRight += nums[k];
            }
            if(sumLeft == sumRight) {
                return i;
            }

        }
        return -1;
    }

}
