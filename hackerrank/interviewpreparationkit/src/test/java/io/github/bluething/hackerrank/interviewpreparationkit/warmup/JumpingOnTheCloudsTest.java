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

    // The clue is "She can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus 1 or 2."
    // So at least we jump one time. (increment in loop).
    // If current index is 0, we increase index by 1, move forward the index by 2 (1 from loop, 1 from if).
    // Each loop we increment the step.
    // We want to terminate the loop as soon as possible, because we can jump twice (stop at index n-1).
    private int jumpingOnCloudsTwo(int[] c) {
        int numSteps = 0;
        for(int i = 0; i < c.length-1; i++) {
            if(c[i] == 0) {
                i++;
            }
            numSteps++;
        }
        return numSteps;
    }

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(4, jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0}));
        Assert.assertEquals(3, jumpingOnClouds(new int[]{0, 0, 0, 1, 0, 0}));
        Assert.assertEquals(3, jumpingOnClouds(new int[]{0, 0, 0, 0, 1, 0}));
    }

    @Test
    public void successWhenInputIsRightUsingSecondSolution() {
        Assert.assertEquals(4, jumpingOnCloudsTwo(new int[]{0, 0, 1, 0, 0, 1, 0}));
        Assert.assertEquals(3, jumpingOnCloudsTwo(new int[]{0, 0, 0, 1, 0, 0}));
        Assert.assertEquals(3, jumpingOnCloudsTwo(new int[]{0, 0, 0, 0, 1, 0}));
    }

}
