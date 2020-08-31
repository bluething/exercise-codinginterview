package io.github.bluething.hackerrank.interviewpreparationkit.warmup;

import org.junit.Assert;
import org.junit.Test;

public class JumpingOnTheCloudsTest {

    private int jumpingOnClouds(int[] c) {
        int numSteps = 0;
        int lengthStep = 0;
        for(int i = 1; i < c.length; i++) {
            if(c[i] == 1) {
                lengthStep = -1;
                continue;
            }
            numSteps++;
            lengthStep++;
            if(lengthStep == 2) {
                numSteps--;
                lengthStep = 0;
            }
        }
        return numSteps;
    }

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(4, jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0}));
        Assert.assertEquals(3, jumpingOnClouds(new int[]{0, 0, 0, 1, 0, 0}));
        Assert.assertEquals(3, jumpingOnClouds(new int[]{0, 0, 0, 0, 1, 0}));
    }

}
