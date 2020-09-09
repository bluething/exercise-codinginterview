package io.github.bluething.hackerrank.interviewpreparationkit.warmup;

import org.junit.Assert;
import org.junit.Test;

/*
* The problem https://www.hackerrank.com/challenges/2d-array/problem
* */
public class TwoDArrayTest {
    private int hourglassSum(int[][] arr) {
        // if hourglass all -9, then maxSum will be -9 * 7
        int maxSum = -63;
        int sum = 0;
        // we already know how big hourglass array
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sum = 0;
                // actually we only need iterate 3 times (num of lines of hourglass)
                // each line, except 2nd line, we add all the value
                for(int k = 0; k < 3; k++) {
                    if(k == 1) {
                        sum += arr[i+k][j+k];
                        continue;
                    }
                    sum += arr[i+k][j+0] + arr[i+k][j+1] + arr[i+k][j+2];
                }
                // if sum bigger than maxSum, put sum to maxSum
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    @Test
    public void successWhenInputIsRight() {
        int[][] arrays = new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        Assert.assertEquals(19, hourglassSum(arrays));
    }
}
