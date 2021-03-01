package io.github.bluething.leetcode.marchleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandiesTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(3, distributeCandies(new int[]{1,1,2,2,3,3}));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals(2, distributeCandies(new int[]{1,1,2,3}));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertEquals(1, distributeCandies(new int[]{6,6,6,6}));
    }

    private int distributeCandies(int[] candyType) {
        int maxCandies = candyType.length / 2;
        Set<Integer> distinctType = new HashSet<>();
        int i = 0;
        int j = 1;
        while (i < candyType.length && j <= maxCandies) {
            if (distinctType.add(Integer.valueOf(candyType[i]))) {
                j++;
            }
            i++;
        }

        int numOfDistinctType = distinctType.size();

        return numOfDistinctType;
    }
}
