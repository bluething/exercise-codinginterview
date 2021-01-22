package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

// The problem https://leetcode.com/problems/count-number-of-teams/
public class CountNumberofTeamsTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(3, numTeams(new int[]{2,5,3,4,1}));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals(0, numTeams(new int[]{2, 1, 3}));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertEquals(4, numTeams(new int[]{1, 2, 3, 4}));
    }

    private int numTeams(int[] rating) {
        int counter = 0;

        for (int i = 0; i < rating.length; i++) {
            for (int j = i + 1; j < rating.length; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    if (rating[i] > rating[j] && rating[j] > rating[k]) {
                        counter++;
                    } else if (rating[i] < rating[j] && rating[j] < rating[k]) {
                        counter++;
                    }
                }
            }
        }

        return counter;
    }
}
