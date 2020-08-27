package io.github.bluething.hackerrank.interviewpreparationkit.warmup;

import org.junit.Assert;
import org.junit.Test;

/*
* The problem https://www.hackerrank.com/challenges/counting-valleys/problem
* */
public class CountingValleysTest {

    // The idea is detect when we enter the valley, then check if we already up
    private int countingValleys(int n, String s) {
        char up = 'U';
        char down = 'D';
        boolean enterTheValley = false;
        char[] sChar = s.toCharArray();
        int seaLevel = 0;
        int valley = 0;
        for (int i = 0; i < n; i++) {
            if(sChar[i] == up) {
                seaLevel++;
            } else {
                seaLevel--;
            }
            if(enterTheValley && seaLevel == 0) {
                valley++;
            }
            if(seaLevel < 0) {
                enterTheValley = true;
            } else {
                enterTheValley = false;
            }
        }
        return valley;
    }

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(1, countingValleys(8, "UDDDUDUU"));
    }

}
