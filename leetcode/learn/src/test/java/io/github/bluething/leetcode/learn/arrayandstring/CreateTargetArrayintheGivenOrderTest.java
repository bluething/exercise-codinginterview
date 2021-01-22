package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

// The problem https://leetcode.com/problems/create-target-array-in-the-given-order/
public class CreateTargetArrayintheGivenOrderTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertArrayEquals(new int[]{0,4,1,3,2}, createTargetArray(new int[]{0,1,2,3,4}, new int[]{0,1,2,2,1}));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertArrayEquals(new int[]{0,1,2,3,4}, createTargetArray(new int[]{1,2,3,4,0}, new int[]{0,1,2,3,0}));
    }

    private int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> targetList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            targetList.add(index[i], nums[i]);
        }
        int[] targetArray = new int[index.length];

        for (int i = 0; i < targetList.size(); i++) {
            targetArray[i] = targetList.get(i);
        }

        return targetArray;
    }
}
