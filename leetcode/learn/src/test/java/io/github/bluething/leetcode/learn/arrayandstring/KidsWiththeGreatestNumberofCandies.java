package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWiththeGreatestNumberofCandies {

    @Test
    public void successWhenInputIsRightCaseOne() {
        List<Boolean> answers = Arrays.asList(true,true,true,false,true);
        Assert.assertEquals(answers, kidsWithCandies(new int[]{2,3,5,1,3}, 3));
    }

    @Test
    public void successWhenInputIsRightCaseTwo() {
        List<Boolean> answers = Arrays.asList(true,false,true);
        Assert.assertEquals(answers, kidsWithCandies(new int[]{12,1,12}, 10));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> answers = new ArrayList<>();

        int maxCandies = 0;
        for (int i = 0; i < candies.length; i++) {
            if (maxCandies <= candies[i]) {
                maxCandies = candies[i];
            }
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxCandies) {
                answers.add(Boolean.TRUE);
            } else {
                answers.add(Boolean.FALSE);
            }
        }

        return answers;
    }

}
