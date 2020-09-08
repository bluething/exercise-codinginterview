package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

/*
 * The problem https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1147/
 * */
public class LargestNumberAtLeastTwiceofOthersTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(1, dominantIndex(new int[]{3, 6, 1, 0}));
    }

    private int dominantIndex(int[] nums) {
        int maxIndex = 0;
        for (int i=0; i < nums.length; i++) {
            if(nums[i] >= nums[maxIndex]) {
                maxIndex = i;
            }
        }
        for (int i=0; i < nums.length; i++) {
            if(i != maxIndex && nums[maxIndex] < 2 * nums[i]) {
                return -1;
            }
        }
        return maxIndex;
    }

}
